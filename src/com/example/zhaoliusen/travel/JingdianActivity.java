package com.example.zhaoliusen.travel;

import java.util.ArrayList;
import java.util.List;

import com.example.travel.R;
import com.example.travel.R.drawable;
import com.example.travel.R.id;
import com.example.travel.R.layout;

import adapter.DiquAdapter;
import adapter.JingquAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import classify.Diqu;
import classify.Jingqu;

public class JingdianActivity extends Activity {
	ImageView image_fanhui;
	ListView listview;
	GridView gridview;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gedijingdian);
		image_fanhui = (ImageView) findViewById(R.id.jingdian_fanhui);
		image_fanhui.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});
		listview = (ListView) findViewById(R.id.listview_jing);
		getData();
		gridview = (GridView) findViewById(R.id.gridview_jing);
		getZhao();
	}

	private void getData() {
			List<Diqu> lists = new ArrayList<Diqu>();
			Diqu di = new Diqu();
			di.setDi("重庆");
			lists.add(di);
			
			Diqu di1 = new Diqu();
			di1.setDi("上海");
			lists.add(di1);
			
			Diqu di2 = new Diqu();
			di2.setDi("广东");
			lists.add(di2);
			
			Diqu di3= new Diqu();
			di3.setDi("浙江");
			lists.add(di3);
			
			Diqu di4 = new Diqu();
			di4.setDi("云南");
			lists.add(di4);
			
			Diqu di5 = new Diqu();
			di5.setDi("北京");
			lists.add(di5);
			
			Diqu di6= new Diqu();
			di6.setDi("四川");
			lists.add(di6);
			
			Diqu di7 = new Diqu();
			di7.setDi("天津");
			lists.add(di7);
			
			Diqu di8 = new Diqu();
			di8.setDi("江苏");
			lists.add(di8);
			
			Diqu di9 = new Diqu();
			di9.setDi("深圳");
			lists.add(di9);
			
			Diqu di10 = new Diqu();
			di10.setDi("杭州");
			lists.add(di10);
			
			Diqu di11= new Diqu();
			di11.setDi("贵州");
			lists.add(di11);
			
			Diqu di12 = new Diqu();
			di12.setDi("湖南");
			lists.add(di12);
			
			Diqu di13= new Diqu();
			di13.setDi("安徽");
			lists.add(di13);
			DiquAdapter dAdapter = new DiquAdapter(
					R.layout.activity_jing_listview, lists, this);
			listview.setAdapter(dAdapter);
	}

	private void getZhao() {
		List<Jingqu> li=new ArrayList<Jingqu>();
		Jingqu jing=new Jingqu();
		jing.setJing_photo(R.drawable.jing_sanya);
		jing.setJing_name("海南三亚");
		li.add(jing);
		
		Jingqu jing1=new Jingqu();
		jing1.setJing_photo(R.drawable.jing_guilin);
		jing1.setJing_name("桂林山水");
		li.add(jing1);
		
		Jingqu jing2=new Jingqu();
		jing2.setJing_photo(R.drawable.jing_hangzou);
		jing2.setJing_name("杭州西湖");
		li.add(jing2);
		
		Jingqu jing3=new Jingqu();
		jing3.setJing_photo(R.drawable.jing_lijiang);
		jing3.setJing_name("丽江古城");
		li.add(jing3);
		
		Jingqu jing4=new Jingqu();
		jing4.setJing_photo(R.drawable.jing_xueshan);
		jing4.setJing_name("玉龙雪山");
		li.add(jing4);
		
		Jingqu jing5=new Jingqu();
		jing5.setJing_photo(R.drawable.jing_jiuzaigou);
		jing5.setJing_name("九寨沟");
		li.add(jing5);
		
		Jingqu jing6=new Jingqu();
		jing6.setJing_photo(R.drawable.jing_budalagong);
		jing6.setJing_name("布达拉宫");
		li.add(jing6);
		
		Jingqu jing7=new Jingqu();
		jing7.setJing_photo(R.drawable.jing_yongdingtitian);
		jing7.setJing_name("永定梯田");
		li.add(jing7);
		
		Jingqu jing8=new Jingqu();
		jing8.setJing_photo(R.drawable.jing_wuzheng);
		jing8.setJing_name("杭州乌镇");
		li.add(jing8);
		
		Jingqu jing9=new Jingqu();
		jing9.setJing_photo(R.drawable.jing_hukoupubu);
		jing9.setJing_name("壶口瀑布");
		li.add(jing9);
		JingquAdapter jingAdapter=new JingquAdapter(
				R.layout.activity_jing_gridview,li,this);
		gridview.setAdapter(jingAdapter);
	}
}
