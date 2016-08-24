package com.example.lvyou;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_wo_de_zu_ji extends Activity{
	public  static final int REQUEST_CODE = 1002;
	GridView gridview;
	List<Shopinfor> list=new ArrayList<Shopinfor>();
	ImageView image_tianjia;
	int [] strs={R.drawable.dongfangmingzhu,R.drawable.aifeier,R.drawable.dajiaotang,R.drawable.meiguozhixing,R.drawable.taqiao,R.drawable.madeli,R.drawable.jinzita};
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.layout_wd_zu_ji);
			image_tianjia=(ImageView) findViewById(R.id.image_wodezuji_fazuji);
			image_tianjia.setOnClickListener(clickListener);
			gridview=(GridView) findViewById(R.id.gridview_wodezuji);
			getData();
			MyAdapter_wd_zu_ji adapter_wd_zu_ji=new MyAdapter_wd_zu_ji(this, R.layout.layout_wodezuji_gridview_layout, list);
			gridview.setAdapter(adapter_wd_zu_ji);
			
		}
		public void getData(){
			for(int i=0;i<strs.length;i++){
			Shopinfor shopinfor=new Shopinfor();
			shopinfor.setImage_wodezuji(strs[i]);	
			shopinfor.setText_wdzuji1("123");
			shopinfor.setText_wdzuji2("456");
			list.add(shopinfor);
		}}
		protected void onActivityResult(int requestCode, int resultCode, Intent data) {
			Shopinfor shopinfor1=new Shopinfor();
			String str=data.getStringExtra("fabiao"); 
			shopinfor1.setImage_wodezuji(R.drawable.meiguozhixing);
			shopinfor1.setText_wdzuji1(str);
			shopinfor1.setText_wdzuji2("456");
			list.add(shopinfor1);
			MyAdapter_wd_zu_ji adapter_wd_zu_ji=new MyAdapter_wd_zu_ji(this, R.layout.layout_wodezuji_gridview_layout, list);
			gridview.setAdapter(adapter_wd_zu_ji);	
		};
		OnClickListener clickListener=new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()) {
				case R.id.image_wodezuji_fazuji:
					 tianzhuan_fazuji();
					break;

				default:
					break;
				}
			}
		};
		public void tianzhuan_fazuji(){
			Intent intent=new Intent(this,Activity_fa_zu_ji.class);
			//startActivity(intent);
			startActivityForResult(intent, REQUEST_CODE);
			onActivityResult(REQUEST_CODE, 0, intent);
		}
		OnItemClickListener clickListener2=new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
					
			}
		};
	
}
