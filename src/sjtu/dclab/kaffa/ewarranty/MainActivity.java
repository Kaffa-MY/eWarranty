package sjtu.dclab.kaffa.ewarranty;

import kaffa.test.myalipay.R;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.Window;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//ȥ��������
		setContentView(R.layout.activity_main);

		new Handler().postDelayed(new Runnable(){
			@Override
			public void run(){
				Intent intent = new Intent (MainActivity.this,LogIn.class);			
				startActivity(intent);			
				MainActivity.this.finish();
			}
		}, 2000);
   }
}
