package com.example.travel;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class SouActivity extends Activity{
	ImageView image;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_soushou);
		image=(ImageView)findViewById(R.id.sous_fanhui);
		image.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();	
			}
		});
	}
}
