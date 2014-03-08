package kaffa.test.ewarranty;

import kaffa.test.myalipay.R;
import android.os.Bundle;
import android.view.Window;
import android.app.Activity;

public class ApplyRepairActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_apply_repair);
	}

}
