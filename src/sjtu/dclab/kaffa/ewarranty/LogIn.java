package sjtu.dclab.kaffa.ewarranty;

import org.json.JSONException;
import org.json.JSONObject;

import sjtu.dclab.kaffa.ewarranty.domain.CustomerCard;
import sjtu.dclab.kaffa.ewarranty.webserv.LoginServ;
import kaffa.test.myalipay.R;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends Activity {

	private EditText mUser;
	private EditText mPasswd;

	class CustomerLoginTask extends AsyncTask<CustomerCard, Void, JSONObject> {

		@Override
		protected JSONObject doInBackground(CustomerCard... params) {
			// TODO Auto-generated method stub
			LoginServ loginServ = new LoginServ();
			JSONObject stat = loginServ.userLogin(params[0]);
			return stat;
		}

		@Override
		protected void onPostExecute(JSONObject stat) {
			// TODO Auto-generated method stub
			try {
				String rs = stat.getString("status");
				if (rs.equals("success")) {
					Toast.makeText(getApplicationContext(), "success",
							Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(LogIn.this, MainPage.class);
					startActivity(intent);
					finish();
				} else {
					Toast.makeText(getApplicationContext(), "error",
							Toast.LENGTH_SHORT).show();
				}
			} catch (JSONException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题栏
		setContentView(R.layout.activity_log_in);

		mUser = (EditText) this.findViewById(R.id.login_user_edit);
		mPasswd = (EditText) this.findViewById(R.id.login_passwd_edit);
	}

	public void login(View view) {
		// if ("test".equals(mUser.getText().toString())
		// && "test".equals(mPasswd.getText().toString())) {
		// Intent intent = new Intent(LogIn.this, MainPage.class);
		// startActivity(intent);
		// this.finish();
		// } else if ("".equals(mUser.getText().toString())
		// && "".equals(mPasswd.getText().toString())) {
		// new AlertDialog.Builder(LogIn.this).setIcon(null).setTitle("Wrong")
		// .setMessage("账号或密码不能为空，\n请重新输入").create().show();
		// } else {
		// new AlertDialog.Builder(LogIn.this).setIcon(null).setTitle("Wrong")
		// .setMessage("账号或密码不正确，\n请重新输入").create().show();
		// }
		CustomerCard card = new CustomerCard();
		card.setName(mUser.getText().toString());
		card.setPasswd(mPasswd.getText().toString());
		new CustomerLoginTask().execute(card);
	}

	public void login_back(View view) {
		this.finish();
	}

	public void login_reg(View view) {
		Intent intent = new Intent(getApplicationContext(),
				UserRegisterActivity.class);
		startActivity(intent);
	}
}
