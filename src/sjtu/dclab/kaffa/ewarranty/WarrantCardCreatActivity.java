package sjtu.dclab.kaffa.ewarranty;

import org.json.JSONException;
import org.json.JSONObject;

import sjtu.dclab.kaffa.ewarranty.domain.EWarrantyCard;
import sjtu.dclab.kaffa.ewarranty.webserv.WarrantyCardCreatServ;
import kaffa.test.myalipay.R;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

public class WarrantCardCreatActivity extends Activity {
	private EditText snEditText;
	private EditText modelEditText;
	private EditText customerEditText;
	private EditText creatorEditText;
	private EditText noteEditText;
	private EditText sellorEditText;
	private EditText shopEditText;

	private Intent intent = null;
	
	class WarCardCreatTask extends AsyncTask<EWarrantyCard, Void, JSONObject>{

		@Override
		protected JSONObject doInBackground(EWarrantyCard... params) {
			// TODO Auto-generated method stub
			WarrantyCardCreatServ warrantyCardCreatServ = new WarrantyCardCreatServ();
			JSONObject stat = warrantyCardCreatServ.warCardCreat(params[0]);
			return stat;
		}
		
		@Override
		protected void onPostExecute(JSONObject stat) {
			// TODO Auto-generated method stub
			try {
				String rs = stat.getString("status");
				if (rs.equals("success")) {	//OK in getStatusCode
					Toast.makeText(getApplicationContext(), "成功添加保修卡", Toast.LENGTH_LONG).show();
					startActivity(new Intent(getApplicationContext(), MainPage.class));
				}else {
					Toast.makeText(getApplicationContext(), "保修卡添加失败", Toast.LENGTH_SHORT).show();
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_warrant_card_creat);
		
		snEditText = (EditText)findViewById(R.id.snET);
		modelEditText = (EditText)findViewById(R.id.kyET);
		customerEditText = (EditText)findViewById(R.id.cusET);
		creatorEditText = (EditText)findViewById(R.id.creET);
		
		intent = getIntent();
		String json = intent.getStringExtra("JSonQRCode");
		try {
			JSONObject jsonObject = new JSONObject(json);
			snEditText.setText(jsonObject.getString("SN"));
			modelEditText.setText(jsonObject.getString("KY"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void warCardCreat(View view) {
		EWarrantyCard card = new EWarrantyCard();
		card.setSerialNum(snEditText.getText().toString());
		card.setModel(modelEditText.getText().toString());
		card.setCustomer(customerEditText.getText().toString());
		card.setCreator(creatorEditText.getText().toString());
		
		new WarCardCreatTask().execute(card);
	}
}
