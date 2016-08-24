package com.example.travel;

import java.util.ArrayList;
import java.util.List;

import adapter.MyZhoubianAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import classify.Zhoubian;

public class ZhouBianActivity extends Activity{
	ListView listview;
	ImageView image_fanhui;
	Spinner spinner;
	ArrayAdapter<String> adapter;
	String[] str={"排序方式","默认排序","路线最近","热门评论"};
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zhoubianjingdian);
		listview=(ListView)findViewById(R.id.listview_zhou);
		getData();
		image_fanhui=(ImageView)findViewById(R.id.zhoubian_fanhui);
		image_fanhui.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});
		spinner=(Spinner)findViewById(R.id.zhou_spinner);
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, str);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
	}
	private void getData() {
		List<Zhoubian> list =new ArrayList<Zhoubian>();
		Zhoubian zb=new Zhoubian();
		zb.setZhou_photo(R.drawable.jinfoshan);
		zb.setZhou_name("金佛山（南川区）");
		zb.setZhou_tu1(R.drawable.xing_liang);
		zb.setZhou_tu2(R.drawable.xing_liang);
		zb.setZhou_tu3(R.drawable.xing_liang);
		zb.setZhou_tu4(R.drawable.xing_liang);
		zb.setZhou_tu5(R.drawable.xing_liang);
		zb.setZhou_mi("82km");
		list.add(zb);
		
		Zhoubian zb1=new Zhoubian();
		zb1.setZhou_photo(R.drawable.xiannvshan);
		zb1.setZhou_name("仙女山（武隆县）");
		zb1.setZhou_tu1(R.drawable.xing_liang);
		zb1.setZhou_tu2(R.drawable.xing_liang);
		zb1.setZhou_tu3(R.drawable.xing_liang);
		zb1.setZhou_tu4(R.drawable.xing_liang);
		zb1.setZhou_tu5(R.drawable.xing_liang);
		zb1.setZhou_mi("120km");
		list.add(zb1);
		
		Zhoubian zb2=new Zhoubian();
		zb2.setZhou_photo(R.drawable.longgang);
		zb2.setZhou_name("云阳龙缸（云阳县）");
		zb2.setZhou_tu1(R.drawable.xing_liang);
		zb2.setZhou_tu2(R.drawable.xing_liang);
		zb2.setZhou_tu3(R.drawable.xing_liang);
		zb2.setZhou_tu4(R.drawable.xing_liang);
		zb2.setZhou_tu5(R.drawable.xing);
		zb2.setZhou_mi("265km");
		list.add(zb2);
		
		Zhoubian zb3=new Zhoubian();
		zb3.setZhou_photo(R.drawable.simianshan);
		zb3.setZhou_name("四面山（江津区）");
		zb3.setZhou_tu1(R.drawable.xing_liang);
		zb3.setZhou_tu2(R.drawable.xing_liang);
		zb3.setZhou_tu3(R.drawable.xing_liang);
		zb3.setZhou_tu4(R.drawable.xing_liang);
		zb3.setZhou_tu5(R.drawable.xing);
		zb3.setZhou_mi("102km");
		list.add(zb3);
		
		Zhoubian zb4=new Zhoubian();
		zb4.setZhou_photo(R.drawable.nanshan);
		zb4.setZhou_name("南山植物园（南岸区）");
		zb4.setZhou_tu1(R.drawable.xing_liang);
		zb4.setZhou_tu2(R.drawable.xing_liang);
		zb4.setZhou_tu3(R.drawable.xing_liang);
		zb4.setZhou_tu4(R.drawable.xing);
		zb4.setZhou_tu5(R.drawable.xing);
		zb4.setZhou_mi("56km");
		list.add(zb4);
		MyZhoubianAdapter zhouAdapter=new MyZhoubianAdapter(R.layout.activity_zhou_two,list,this);
		listview.setAdapter(zhouAdapter);
	}
}
