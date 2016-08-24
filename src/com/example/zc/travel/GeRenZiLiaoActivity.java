package com.example.zc.travel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.travel.R;

public class GeRenZiLiaoActivity extends Activity {
	TextView text_gengduo,text_liao;;
	ImageView image_fanhui;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activitty_ge_ren_zi_liao);
		text_gengduo=(TextView)findViewById(R.id.text_gengduo);
		text_gengduo.setOnClickListener(clickListener);
		
		image_fanhui=(ImageView)findViewById(R.id.back_ju_bao);
		image_fanhui.setOnClickListener(clickListener);
		
		text_liao=(TextView)findViewById(R.id.jia_lv_you);
		text_liao.setOnClickListener(clickListener);
	}
	OnClickListener clickListener=new OnClickListener(){
		public void onClick(View v) {
			Intent intent;
			switch(v.getId()){
				case R.id.text_gengduo:
					intent=new Intent(GeRenZiLiaoActivity.this,GeRenZiLiaoGengDuoActivity.class);
					startActivity(intent);
					break;
				case R.id.back_ju_bao:
					finish();
					break;
				case R.id.jia_lv_you:
					intent=new Intent(GeRenZiLiaoActivity.this,LiaoTianActivity.class);
					startActivity(intent);
					break;
				default:
					break;
						
			}
	
		}
	};
}
