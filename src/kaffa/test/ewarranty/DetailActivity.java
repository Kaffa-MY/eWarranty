package kaffa.test.ewarranty;

import kaffa.test.myalipay.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.Window;

public class DetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_detail);
	}
	
	public void ServiceInDetail(View view) {
		startActivity(new Intent(this, ServiceInDetailsActivity.class));
	}
}
