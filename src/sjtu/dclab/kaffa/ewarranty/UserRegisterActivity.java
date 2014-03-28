package sjtu.dclab.kaffa.ewarranty;

import org.apache.http.protocol.HTTP;

import sjtu.dclab.kaffa.ewarranty.domain.CustomerCard;
import sjtu.dclab.kaffa.ewarranty.webserv.CustomerRegServ;
import kaffa.test.myalipay.R;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;

public class UserRegisterActivity extends Activity {
	private EditText usernameEditText;
	private EditText psswdEditText;
	private EditText emailEditText;
	private EditText telEditText;
	private EditText addrEditText;
	
	class CusRegTask extends AsyncTask<CustomerCard, Void, Integer>{
		
		public CusRegTask() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		protected Integer doInBackground(CustomerCard... customer) {
			// TODO Auto-generated method stub
			CustomerRegServ customerRegServ = new CustomerRegServ();
			int stat = customerRegServ.customerReg(customer[0]);
			return stat;
		}

		@Override
		protected void onPostExecute(Integer stat) {
			// TODO Auto-generated method stub
			if (stat == 200) {	//OK in getStatusCode
				Toast.makeText(getApplicationContext(), "×¢²á³É¹¦", Toast.LENGTH_SHORT).show();
			}else {
				Toast.makeText(getApplicationContext(), "×¢²áÊ§°Ü", Toast.LENGTH_SHORT).show();
			}
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_user_register);

		usernameEditText = (EditText) findViewById(R.id.usr_reg_name);
		psswdEditText = (EditText) findViewById(R.id.usr_reg_psswd);
		emailEditText = (EditText) findViewById(R.id.usr_reg_email);
		telEditText = (EditText) findViewById(R.id.usr_reg_tel);
		addrEditText = (EditText) findViewById(R.id.usr_reg_addr);
	}
	
	public void userReg(View view) {
		CustomerCard customer = new CustomerCard();
		customer.setName(usernameEditText.getText().toString());
		customer.setPasswd(psswdEditText.getText().toString());
		customer.setEmail(emailEditText.getText().toString());
		customer.setTel(telEditText.getText().toString());
		customer.setAddress(addrEditText.getText().toString());
		
		new CusRegTask().execute(customer);
	}
}
