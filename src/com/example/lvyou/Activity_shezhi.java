package com.example.lvyou;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Activity_shezhi extends Activity{
	RelativeLayout re_tongzhi,re_tongyongshezhi,re_fankui,re_beibeike;
	ImageView image_fanhui;
	TextView text_tuichudenglu;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_shezhi);
		getData();
	}
	public void getData(){
		re_tongzhi=(RelativeLayout) findViewById(R.id.relativelayout_tongzhi);
		re_tongyongshezhi=(RelativeLayout) findViewById(R.id.relativelayout_tongyongshezhi);
		re_fankui=(RelativeLayout) findViewById(R.id.relativelayout_yonghufankui);
		re_beibeike=(RelativeLayout) findViewById(R.id.relativelayout_guanyubeibaoke);
		re_tongzhi.setOnClickListener(clickListener);
		re_tongyongshezhi.setOnClickListener(clickListener);
		re_fankui.setOnClickListener(clickListener);
		re_beibeike.setOnClickListener(clickListener);
				
	}
	public void tianzhuan_tongzhi(){
		Intent intent=new Intent(this,Activity_tongzhi.class);
		startActivity(intent);
	}
	public void tianzhuan_tongyongshezhi(){
		Intent intent=new Intent(this,Activity_tongyongshezhi.class);
		startActivity(intent);
	}
	public void tianzhuan_re_fankui(){
		Intent intent=new Intent(this,Activity_yonghufankui.class);
		startActivity(intent);
	}
	public void tiaozhuan_guanyubeibaoke(){
		Intent intent=new Intent(this,Activity_guan_yu_bei_bao_ke.class);
		startActivity(intent);
	}
	OnClickListener clickListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.relativelayout_tongzhi:
				tianzhuan_tongzhi();
				break;
			case R.id.relativelayout_tongyongshezhi:
				tianzhuan_tongyongshezhi();
				break;
			case R.id.relativelayout_yonghufankui:
				tianzhuan_re_fankui();
				break;
			case R.id.relativelayout_guanyubeibaoke:
				tiaozhuan_guanyubeibaoke();
				break;

			default:
				break;
			}
		}
	};
}
