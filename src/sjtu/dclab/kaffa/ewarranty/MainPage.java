package sjtu.dclab.kaffa.ewarranty;

import java.util.ArrayList;
import java.util.HashMap;

import kaffa.test.myalipay.R;

import com.zxing.activity.CaptureActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainPage extends Activity {

	public static MainPage mainPage = null;

	private ViewPager tabPager;
	private ImageView tabCur;
	private ImageView tabHome, tabExp, tabAbt, tabMore;

	private int offset = 0;
	private int curTabIndex = 0;

	// first page

	// second page
	private String labels[] = null;
	private int icons[] = null;
	private GridView serviceGridView = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main_page);

		tabPager = (ViewPager) findViewById(R.id.tabpager);
		tabPager.setOnPageChangeListener(new MyOnPageChangeListener());

		tabHome = (ImageView) findViewById(R.id.img_home);
		tabExp = (ImageView) findViewById(R.id.img_exp);
		tabAbt = (ImageView) findViewById(R.id.img_about);
		tabMore = (ImageView) findViewById(R.id.img_more);
		tabCur = (ImageView) findViewById(R.id.img_tab_now);

		tabHome.setOnClickListener(new MyOnClickListener(0));
		tabExp.setOnClickListener(new MyOnClickListener(1));
		tabAbt.setOnClickListener(new MyOnClickListener(2));
		tabMore.setOnClickListener(new MyOnClickListener(3));

		Display curDisplay = getWindowManager().getDefaultDisplay();
		offset = curDisplay.getWidth() / 4;

		LayoutInflater inflater = LayoutInflater.from(this);
		View view_home = inflater.inflate(R.layout.tab_home, null);
		View view_exp = inflater.inflate(R.layout.tab_exp, null);
		View view_about = inflater.inflate(R.layout.tab_about, null);
		View view_more = inflater.inflate(R.layout.tab_more, null);

		final ArrayList<View> views = new ArrayList<View>();
		views.add(view_home);
		views.add(view_exp);
		views.add(view_about);
		views.add(view_more);

		// adapter of the ViewPager tabPager
		PagerAdapter pagerAdapter = new PagerAdapter() {
			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				// TODO Auto-generated method stub
				((ViewPager) container).addView(views.get(position));
				return views.get(position);
			}

			@Override
			public void destroyItem(ViewGroup container, int position,
					Object object) {
				// TODO Auto-generated method stub
				((ViewPager) container).removeView(views.get(position));
			}

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				// TODO Auto-generated method stub
				return arg0 == arg1;
			}

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return views.size();
			}
		};
		tabPager.setAdapter(pagerAdapter);

		// second page
		icons = new int[] { R.drawable.item_icon_repair,
				R.drawable.item_icon_return, R.drawable.item_icon_change,
				R.drawable.item_icon_record, R.drawable.item_icon_comp };
		labels = new String[] { "…Í«ÎŒ¨–ﬁ", "…Í«ÎÕÀªı", "…Í«Îªªªı", "Œ¨–ﬁº«¬º", "Õ∂Àﬂ" };

		serviceGridView = (GridView) view_exp.findViewById(R.id.serviceItems);
		System.out.println(serviceGridView == null);
		ArrayList<HashMap<String, Object>> serviceItems = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < labels.length; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("itemIcon", icons[i]);
			map.put("itemLab", labels[i]);
			serviceItems.add(map);
		}
		SimpleAdapter itemsAdapter = new SimpleAdapter(this, serviceItems,
				R.layout.service_item, new String[] { "itemIcon", "itemLab" },
				new int[] { R.id.itemIcon, R.id.itemLab });
		serviceGridView.setAdapter(itemsAdapter);
		serviceGridView.setOnItemClickListener(new ServiceItemClickListener());
	}

	/**
	 * Õº±Íµ„ª˜º‡Ã˝
	 */
	public class MyOnClickListener implements View.OnClickListener {
		private int index = 0;

		public MyOnClickListener(int i) {
			// TODO Auto-generated constructor stub
			index = i;
		}

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			tabPager.setCurrentItem(index);
		}
	}

	/**
	 * “≥√Ê«–ªªº‡Ã˝
	 */
	public class MyOnPageChangeListener implements OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageSelected(int arg0) {
			// TODO Auto-generated method stub
			Animation animation = null;
			switch (arg0) {
			case 0:
				if (curTabIndex == 1) {
					animation = new TranslateAnimation(offset, 0, 0, 0);
				} else if (curTabIndex == 2) {
					animation = new TranslateAnimation(offset * 2, 0, 0, 0);
				} else if (curTabIndex == 3) {
					animation = new TranslateAnimation(offset * 3, 0, 0, 0);
				}
				break;

			case 1:
				if (curTabIndex == 0) {
					animation = new TranslateAnimation(0, offset, 0, 0);
				} else if (curTabIndex == 2) {
					animation = new TranslateAnimation(offset * 2, offset, 0, 0);
				} else if (curTabIndex == 3) {
					animation = new TranslateAnimation(offset * 3, offset, 0, 0);
				}
				break;

			case 2:
				if (curTabIndex == 0) {
					animation = new TranslateAnimation(0, offset * 2, 0, 0);
				} else if (curTabIndex == 1) {
					animation = new TranslateAnimation(offset, offset * 2, 0, 0);
				} else if (curTabIndex == 3) {
					animation = new TranslateAnimation(offset * 3, offset * 2,
							0, 0);
				}
				break;

			case 3:
				if (curTabIndex == 0) {
					animation = new TranslateAnimation(0, offset * 3, 0, 0);
				} else if (curTabIndex == 1) {
					animation = new TranslateAnimation(offset, offset * 3, 0, 0);
				} else if (curTabIndex == 2) {
					animation = new TranslateAnimation(offset * 2, offset * 3,
							0, 0);
				}
				break;
			}
			curTabIndex = arg0;
			animation.setFillAfter(true);
			animation.setDuration(150);
			tabCur.startAnimation(animation);
		}

	}

	class ServiceItemClickListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			switch (icons[arg2]) {
			case R.drawable.item_icon_repair:
				startActivity(new Intent(MainPage.this,
						ApplyRepairActivity.class));
				break;

			case R.drawable.item_icon_return:
				startActivity(new Intent(MainPage.this,
						ApplyReturnActivity.class));
				break;

			case R.drawable.item_icon_change:
				startActivity(new Intent(MainPage.this,
						ApplyChangeActivity.class));
				break;

			case R.drawable.item_icon_comp:
				startActivity(new Intent(MainPage.this,
						ApplyComplaintActivity.class));
				break;

			default:
				break;
			}
		}

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
			this.finish();
			return true;
		}
		return false;
	}

	public void barCode(View v) {
		//Toast.makeText(getApplicationContext(), "«Î…®√ËÃı¬Î", Toast.LENGTH_SHORT).show();
		Intent openCameraIntent = new Intent(MainPage.this,CaptureActivity.class);
		startActivityForResult(openCameraIntent, 0);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			Bundle bundle = data.getExtras();
			String scanRes = bundle.getString("result");
			Intent intent = new Intent(getApplicationContext(),EWarrantyRegActivity.class);
			intent.putExtra("serialNum", scanRes);
			//Toast.makeText(getApplicationContext(), scanRes, Toast.LENGTH_LONG).show();
			startActivity(intent);
		}
	}

	public void addEwarranty(View v) {
		Toast.makeText(getApplicationContext(), "ÃÌº”µÁ◊”±£µ•", Toast.LENGTH_SHORT)
				.show();
	}

	public void showWarrantyDetails(View v) {
		Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
		this.startActivity(intent);
	}
	
	public void editUserInfo(View view) {
		startActivity(new Intent(getApplicationContext(), UserInfoEditActivity.class));
	}
	
}
