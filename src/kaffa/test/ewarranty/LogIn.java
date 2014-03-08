package kaffa.test.ewarranty;

import kaffa.test.myalipay.R;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

public class LogIn extends Activity {

	private EditText mUser;
	private EditText mPasswd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// ȥ��������
		setContentView(R.layout.activity_log_in);

		mUser = (EditText) this.findViewById(R.id.login_user_edit);
		mPasswd = (EditText) this.findViewById(R.id.login_passwd_edit);
	}

	public void login(View view) {
		if ("test".equals(mUser.getText().toString())
				&& "test".equals(mPasswd.getText().toString())) {
			Intent intent = new Intent(LogIn.this, MainPage.class);
			startActivity(intent);
			this.finish();
		} else if ("".equals(mUser.getText().toString())
				&& "".equals(mPasswd.getText().toString())) {
			new AlertDialog.Builder(LogIn.this).setIcon(null).setTitle("Wrong")
					.setMessage("�˺Ż����벻��Ϊ�գ�\n����������").create().show();
		} else {
			new AlertDialog.Builder(LogIn.this).setIcon(null).setTitle("Wrong")
			.setMessage("�˺Ż����벻��ȷ��\n����������").create().show();
		}
	}
	
	public void login_back(View view) {
		this.finish();
	}
	
	public void login_pw(View view) {
		this.finish();
	}
}
