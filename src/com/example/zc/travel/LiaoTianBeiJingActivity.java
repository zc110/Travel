package com.example.zc.travel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




import com.example.travel.R;
import com.example.travel.R.drawable;
import com.example.travel.R.id;
import com.example.travel.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;

public class LiaoTianBeiJingActivity extends Activity {
	private GridView gridView;

	private int res[] = new int[] { R.drawable.chat_settings_background01,
			R.drawable.chat_settings_background02,
			R.drawable.chat_settings_background03,
			R.drawable.chat_settings_background04,
			R.drawable.chat_settings_background05,
			R.drawable.chat_settings_background06,
			R.drawable.chat_settings_background07,
			R.drawable.chat_settings_background08,
			R.drawable.chat_settings_background09};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bei_jing);

		gridView = (GridView) findViewById(R.id.gridView1);

		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

		for (int i = 0; i < res.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("imageView", res[i]);

			data.add(map);
		}

		SimpleAdapter simpleAdapter = new SimpleAdapter(this, data,
				R.layout.activity_xuan_liao_tian_bei_jing, new String[] { "imageView" },
				new int[] { R.id.imageView1 });

		gridView.setAdapter(simpleAdapter);

	}

}
