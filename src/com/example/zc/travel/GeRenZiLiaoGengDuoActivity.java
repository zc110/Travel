package com.example.zc.travel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.travel.R;

public class GeRenZiLiaoGengDuoActivity extends Activity {
	ImageView image;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_geng_duo_zi_liao);
		image=(ImageView)findViewById(R.id.gengduozhiliao);
		image.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});
		
	}
	OnClickListener clickListener=new OnClickListener(){
		public void onClick(View v) {
			switch(v.getId()){
			}
		}
	};
}
