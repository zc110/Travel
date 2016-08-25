package com.example.lvyou;

import com.example.traves.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class Activity_guan_yu_bei_bao_ke extends Activity{
	ImageView image_fanhui;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_guanyubeibaoke);
		image_fanhui=(ImageView) findViewById(R.id.guanyubeibaoke_image_fanhui);
		image_fanhui.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
}
