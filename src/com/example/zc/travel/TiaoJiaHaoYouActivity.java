package com.example.zc.travel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.travel.R;

public class TiaoJiaHaoYouActivity extends Activity{
	ImageView image;
	TextView jia1;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tian_jia_lv_you);
		image=(ImageView)findViewById(R.id.view_jia);
		image.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});
		jia1=(TextView)findViewById(R.id.tianjia1);
		jia1.setOnClickListener(clickListener);
		
	}
	OnClickListener clickListener=new OnClickListener(){
		public void onClick(View v) {
			Intent intent;
			switch(v.getId()){
			case R.id.tianjia1:
				intent=new Intent(TiaoJiaHaoYouActivity.this,GeRenZiLiaoActivity.class);
				startActivity(intent);
				break;
			}
			
		}
	};
}
