package com.example.lvyou;

import com.example.traves.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;

public class Activity_tongzhi extends Activity{
	ImageView image_fanhui;
	CheckBox checkbox1,image2,image3,image4,image5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_tongzhi);
		getData();
	}
	public void getData(){
		image_fanhui=(ImageView) findViewById(R.id.tongzhi_image_fanhui);
		checkbox1=(CheckBox) findViewById(R.id.tongzhi_image_kaiguan1);
		image2=(CheckBox) findViewById(R.id.tongzhi_image_kaiguan2);
		image3=(CheckBox) findViewById(R.id.tongzhi_image_kaiguan3);
		image4=(CheckBox) findViewById(R.id.tongzhi_image_kaiguan4);
		image5=(CheckBox) findViewById(R.id.tongzhi_image_kaiguan5);
		image_fanhui.setOnClickListener(clickListener);
		//image1.setOnClickListener(clickListener);
		checkbox1.setOnCheckedChangeListener(changeListener);
		
	}
	public void tiaozhuan(){
		Intent intent=new Intent(this,Activity_shezhi.class);
		startActivity(intent);
	}
	OnClickListener clickListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.tongzhi_image_fanhui:
				tiaozhuan();
				//finish();
				break;
			default:
				break;
			}
		}
	};
	OnCheckedChangeListener changeListener=new OnCheckedChangeListener() {//checkBox的监听
		
		@SuppressLint("NewApi")
		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			// TODO Auto-generated method stub
			if(checkbox1.isChecked()){
				checkbox1.setBackground(getResources().getDrawable(R.drawable.kai));
				
			}else{
				checkbox1.setBackground(getResources().getDrawable(R.drawable.guan));
				
			}
		}
	};

}
