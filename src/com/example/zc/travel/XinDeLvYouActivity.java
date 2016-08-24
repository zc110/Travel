package com.example.zc.travel;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.example.travel.R;

public class XinDeLvYouActivity extends Activity {
	ImageView image_fanhui;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_lv_you);
		image_fanhui=(ImageView)findViewById(R.id.image_newlvyou);
		image_fanhui.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});
	}
}
