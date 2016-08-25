package com.example.lvyou;

import java.util.ArrayList;

import com.example.traves.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;


public class MainActivity extends FragmentActivity {
	ArrayList<Fragment> list;
	MyAdapter_fragment myadapter;
	ViewPager viewpager;
	TextView text_haoyou,text_jingqu;
	View view1,view2; 
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_wdguanzhu);
		getData();
		viewpager=(ViewPager) findViewById(R.id.viewpager_wodeguanzhu);
		myadapter = new MyAdapter_fragment(getSupportFragmentManager(),list);
		viewpager.setAdapter(myadapter);
		text_haoyou=(TextView) findViewById(R.id.text_haoyou);
		text_jingqu=(TextView) findViewById(R.id.text_jingqu);
		text_haoyou.setOnClickListener(clickListener);
		text_jingqu.setOnClickListener(clickListener);
		view1=findViewById(R.id.wodeguanzhu_view1);
		view2=findViewById(R.id.wodeguanzhu_view2);
		viewpager.setOnPageChangeListener(changeListener);
		
		
	}
	public void getData(){
		list=new ArrayList<Fragment>();
		Fragment_haoyou haoyou=new Fragment_haoyou();
		list.add(haoyou);
		Fragment_jingqu jingqu=new Fragment_jingqu();
		list.add(jingqu);
	}
	
	OnClickListener clickListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.text_haoyou:
				viewpager.setCurrentItem(0);
				text_haoyou.setTextColor(getResources().getColor(R.color.lvse));
				text_jingqu.setTextColor(getResources().getColor(R.color.heise));
				view1.setBackgroundColor(getResources().getColor(R.color.lvse));
				view2.setBackgroundColor(getResources().getColor(R.color.huise));
				
				break;
			case R.id.text_jingqu:
				viewpager.setCurrentItem(1);
				text_haoyou.setTextColor(getResources().getColor(R.color.heise));
				text_jingqu.setTextColor(getResources().getColor(R.color.lvse));
				view1.setBackgroundColor(getResources().getColor(R.color.huise));
				view2.setBackgroundColor(getResources().getColor(R.color.lvse));
				break;

			default:
				break;
			}
		}
	};
	OnPageChangeListener changeListener=new OnPageChangeListener() {
		
		@Override
		public void onPageSelected(int arg0) {
			// TODO Auto-generated method stub
			switch (arg0) {
			case 0:
				text_haoyou.setTextColor(getResources().getColor(R.color.lvse));
				text_jingqu.setTextColor(getResources().getColor(R.color.heise));
				view1.setBackgroundColor(getResources().getColor(R.color.lvse));
				view2.setBackgroundColor(getResources().getColor(R.color.huise));
				break;
			case 1:
				viewpager.setCurrentItem(1);
				text_haoyou.setTextColor(getResources().getColor(R.color.heise));
				text_jingqu.setTextColor(getResources().getColor(R.color.lvse));
				view1.setBackgroundColor(getResources().getColor(R.color.huise));
				view2.setBackgroundColor(getResources().getColor(R.color.lvse));
				break;
			default:
				break;
			}
		}
		
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
			
		}
	};
}
