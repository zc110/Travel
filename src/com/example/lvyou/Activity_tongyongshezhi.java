package com.example.lvyou;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;

public class Activity_tongyongshezhi extends Activity{
	CheckBox chebox1,chebox2;
	ImageView image_fanhui;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layou_tongyongshezhi);
		chebox1=(CheckBox) findViewById(R.id.tongyongshezhi_checkbox1);
		chebox2=(CheckBox) findViewById(R.id.tongyongshezhi_checkbox2);
		image_fanhui=(ImageView) findViewById(R.id.image_tongyongshezhi_fanhui);
		image_fanhui.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
}	
