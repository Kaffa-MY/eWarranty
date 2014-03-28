package sjtu.dclab.kaffa.ewarranty;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import kaffa.test.myalipay.R;
import sjtu.dclab.kaffa.ewarranty.domain.EWarrantyCard;
import sjtu.dclab.kaffa.ewarranty.util.ClassParse;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EWarrantyRegActivity extends Activity {
	private TextView serialNumTextView;
	private Button regButton;

	private Intent intent;
	private String resString; // received json string

	private final String urlString = "http://192.168.1.117:8088/eWarrantyServ/testServlet";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_ewarranty_reg);

		serialNumTextView = (TextView) findViewById(R.id.SerialNumText);
		regButton = (Button) findViewById(R.id.EWRegBut);

		intent = this.getIntent();
		EWarrantyCard ewcard = new EWarrantyCard();
		ewcard.setCustomer(0);
		ewcard.setId(0);
		ewcard.setModel("airconditionary");
		ewcard.setPointOfSells(0);
		ewcard.setRemark("null");
		ewcard.setSeller(0);
		ewcard.setSerialNum(intent.getStringExtra("serialNum"));

		ClassParse parse = new ClassParse();
		resString = parse.card2String(ewcard);
		serialNumTextView.setText(resString);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ewarranty_reg, menu);
		return true;
	}

	public void eWarrantyReg(View view) {
		// app cannot perform a networking operation on its main thread.
		
		class RegTask extends AsyncTask<String, Void, String>{

			@Override
			protected String doInBackground(String... v) {
				try {
					URL url = new URL(urlString);
					HttpURLConnection urlConn = (HttpURLConnection) url
							.openConnection();
					urlConn.setDoInput(true);
					urlConn.setDoOutput(true);
					urlConn.setRequestMethod("POST");
					urlConn.setUseCaches(false);
					urlConn.setRequestProperty("Charset", "utf-8");

					urlConn.connect(); // connect to server

					DataOutputStream dop = new DataOutputStream(
							urlConn.getOutputStream());
					dop.writeBytes("param=" + URLEncoder.encode(resString, "utf-8"));
					dop.flush();
					dop.close();

					Toast.makeText(getApplicationContext(), "reg successfully!",
							Toast.LENGTH_SHORT).show();
					return "ok";

				} catch (Exception e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
					System.out.println(e);
					Toast.makeText(getApplicationContext(), "wrong!",
							Toast.LENGTH_SHORT).show();
					return "fatal";
				}
				// TODO Auto-generated method stub			
			}
			
		}

		new RegTask().execute();

	}
}
