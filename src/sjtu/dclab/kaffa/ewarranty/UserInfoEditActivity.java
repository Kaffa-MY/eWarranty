package sjtu.dclab.kaffa.ewarranty;

import kaffa.test.myalipay.R;
import android.os.Bundle;
import android.view.Window;
import android.app.Activity;

public class UserInfoEditActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_user_info_edit);
	}
}
