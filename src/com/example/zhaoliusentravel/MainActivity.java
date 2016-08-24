package com.example.zhaoliusentravel;

import java.util.ArrayList;

import com.example.travel.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {
	ViewPager viewpager;
	MyFragmentAdapter mAdapter;
	ArrayList<Fragment> fragmentList;
	LinearLayout layout_tuijian,layout_lvyou,layout_yueban,layout_dongtai,layout_wode;
	ImageView image_tuijian,image_lvyou,image_yueban,image_dongtai,image_wode;
	TextView text_tuijian,text_lvyou,text_yueban,text_dongtai,text_wode;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragement_main);
		getData();
		mAdapter=new MyFragmentAdapter(getSupportFragmentManager(),fragmentList);
		viewpager=(ViewPager)findViewById(R.id.viewpager);
		viewpager.setAdapter(mAdapter);
		
		layout_tuijian=(LinearLayout)findViewById(R.id.tuijian);
		image_tuijian=(ImageView)findViewById(R.id.imageview_tuijian);
		text_tuijian=(TextView)findViewById(R.id.textview_tuijian);
		layout_tuijian.setOnClickListener(l);
		
		layout_lvyou=(LinearLayout)findViewById(R.id.lvyou);
		image_lvyou=(ImageView)findViewById(R.id.imageview_lvyou);
		text_lvyou=(TextView)findViewById(R.id.textview_lvyou);
		layout_lvyou.setOnClickListener(l);
		
		layout_yueban=(LinearLayout)findViewById(R.id.yueban);
		image_yueban=(ImageView)findViewById(R.id.imageview_yueban);
		text_yueban=(TextView)findViewById(R.id.textview_yueban);
		layout_yueban.setOnClickListener(l);
		
		layout_dongtai=(LinearLayout)findViewById(R.id.dongtai);
		image_dongtai=(ImageView)findViewById(R.id.imageview_dongtai);
		text_dongtai=(TextView)findViewById(R.id.textview_dongtai);
		layout_dongtai.setOnClickListener(l);
		
		layout_wode=(LinearLayout)findViewById(R.id.wode);
		image_wode=(ImageView)findViewById(R.id.imageview_wode);
		text_wode=(TextView)findViewById(R.id.textview_wode);
		layout_wode.setOnClickListener(l);
	}

	private void getData() {
		fragmentList=new ArrayList<Fragment>();
		TuijianFragment tuijian=new TuijianFragment();
		fragmentList.add(tuijian);
		
		LvyouFragment lvyou=new LvyouFragment();
		fragmentList.add(lvyou);
		
		YuebanFragment yueban=new YuebanFragment();
		fragmentList.add(yueban);
		
		DongtaiFragment dongtai=new DongtaiFragment();
		fragmentList.add(dongtai);
		
		WodeFragment wode=new WodeFragment();
		fragmentList.add(wode);
	}
	OnClickListener l=new OnClickListener(){
		public void onClick(View v) {
			switch(v.getId()){
				case R.id.tuijian:
					viewpager.setCurrentItem(0);	
					image_tuijian.setImageResource(R.drawable.shouye_liang);
					text_tuijian.setTextColor(getResources().getColor(R.color.baolan));
					
					image_lvyou.setImageResource(R.drawable.lvyou);
					text_lvyou.setTextColor(getResources().getColor(R.color.heise));
					
					image_yueban.setImageResource(R.drawable.yueban);
					text_yueban.setTextColor(getResources().getColor(R.color.heise));
					
					image_dongtai.setImageResource(R.drawable.dongtai);
					text_dongtai.setTextColor(getResources().getColor(R.color.heise));
					
					image_wode.setImageResource(R.drawable.wode);
					text_wode.setTextColor(getResources().getColor(R.color.heise));
					break;
				case R.id.lvyou:
					viewpager.setCurrentItem(1);
					image_lvyou.setImageResource(R.drawable.lvyou_liang);
					text_lvyou.setTextColor(getResources().getColor(R.color.baolan));
					
					image_tuijian.setImageResource(R.drawable.shouye);
					text_tuijian.setTextColor(getResources().getColor(R.color.heise));
	
					image_yueban.setImageResource(R.drawable.yueban);
					text_yueban.setTextColor(getResources().getColor(R.color.heise));
					
					image_dongtai.setImageResource(R.drawable.dongtai);
					text_dongtai.setTextColor(getResources().getColor(R.color.heise));
					
					image_wode.setImageResource(R.drawable.wode);
					text_wode.setTextColor(getResources().getColor(R.color.heise));
					break;
				case R.id.yueban:
					viewpager.setCurrentItem(2);
					image_yueban.setImageResource(R.drawable.yueban_liang);
					text_yueban.setTextColor(getResources().getColor(R.color.baolan));
					
					image_tuijian.setImageResource(R.drawable.shouye);
					text_tuijian.setTextColor(getResources().getColor(R.color.heise));
					
					image_lvyou.setImageResource(R.drawable.lvyou);
					text_lvyou.setTextColor(getResources().getColor(R.color.heise));
					
					image_dongtai.setImageResource(R.drawable.dongtai);
					text_dongtai.setTextColor(getResources().getColor(R.color.heise));
					
					image_wode.setImageResource(R.drawable.wode);
					text_wode.setTextColor(getResources().getColor(R.color.heise));
					break;
				case R.id.dongtai:
					viewpager.setCurrentItem(3);
					image_dongtai.setImageResource(R.drawable.dongtai_liang);
					text_dongtai.setTextColor(getResources().getColor(R.color.baolan));
					
					image_tuijian.setImageResource(R.drawable.shouye);
					text_tuijian.setTextColor(getResources().getColor(R.color.heise));
					
					image_lvyou.setImageResource(R.drawable.lvyou);
					text_lvyou.setTextColor(getResources().getColor(R.color.heise));
					
					image_yueban.setImageResource(R.drawable.yueban);
					text_yueban.setTextColor(getResources().getColor(R.color.heise));
	
					image_wode.setImageResource(R.drawable.wode);
					text_wode.setTextColor(getResources().getColor(R.color.heise));
					break;
				case R.id.wode:
					viewpager.setCurrentItem(4);
					image_wode.setImageResource(R.drawable.wode_liang);
					text_wode.setTextColor(getResources().getColor(R.color.baolan));
					
					image_tuijian.setImageResource(R.drawable.shouye);
					text_tuijian.setTextColor(getResources().getColor(R.color.heise));
					
					image_lvyou.setImageResource(R.drawable.lvyou);
					text_lvyou.setTextColor(getResources().getColor(R.color.heise));
					
					image_yueban.setImageResource(R.drawable.yueban);
					text_yueban.setTextColor(getResources().getColor(R.color.heise));
					
					image_dongtai.setImageResource(R.drawable.dongtai);
					text_dongtai.setTextColor(getResources().getColor(R.color.heise));
					break;
				default:
					break;
			}
		}
	};
}
