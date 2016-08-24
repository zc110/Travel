package com.example.zhaoliusen.travel;

import java.util.ArrayList;
import java.util.List;

import com.example.travel.R;
import com.example.travel.R.drawable;
import com.example.travel.R.id;
import com.example.travel.R.layout;

import classify.Huwai;
import adapter.MyHuAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.ImageView;

public class HuwaiActivity extends Activity{
	GridView gridview;
	ImageView image_fanhui,image_soushou;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_huwaihongdong);
		gridview=(GridView)findViewById(R.id.huwai_gridview);
		getData();
		image_fanhui=(ImageView)findViewById(R.id.huwai_fanhui);
		image_fanhui.setOnClickListener(l);
		image_soushou=(ImageView)findViewById(R.id.huwai_sou);
		image_soushou.setOnClickListener(l);
		
	}
	private void getData() {
		List<Huwai> list=new ArrayList<Huwai>();
		Huwai wai=new Huwai();
		wai.setHu_photo(R.drawable.huwai1);
		wai.setHu_name("川藏行必备物品");
		wai.setHu_tou(R.drawable.touxiang7);
		wai.setHu_zs("户外小知识");
		wai.setHu_shi(R.drawable.shijian);
		wai.setHu_tian("1天前");
		list.add(wai);
		
		Huwai wai2=new Huwai();
		wai2.setHu_photo(R.drawable.huwai2);
		wai2.setHu_name("野外生存小技巧");
		wai2.setHu_tou(R.drawable.touxiang2);
		wai2.setHu_zs("户外小知识");
		wai2.setHu_shi(R.drawable.shijian);
		wai2.setHu_tian("1天前");
		list.add(wai2);
		
		Huwai wai3=new Huwai();
		wai3.setHu_photo(R.drawable.huwai3);
		wai3.setHu_name("如何选择露营地点");
		wai3.setHu_tou(R.drawable.touxiang3);
		wai3.setHu_zs("户外小知识");
		wai3.setHu_shi(R.drawable.shijian);
		wai3.setHu_tian("2天前");
		list.add(wai3);
		
		Huwai wai4=new Huwai();
		wai4.setHu_photo(R.drawable.huwai5);
		wai4.setHu_name("如何快速搭建帐篷");
		wai4.setHu_tou(R.drawable.touxiang4);
		wai4.setHu_zs("户外小知识");
		wai4.setHu_shi(R.drawable.shijian);
		wai4.setHu_tian("2天前");
		list.add(wai4);
		
		Huwai wai5=new Huwai();
		wai5.setHu_photo(R.drawable.huwai5);
		wai5.setHu_name("户外野餐注意事项");
		wai5.setHu_tou(R.drawable.touxiang3);
		wai5.setHu_zs("户外小知识");
		wai5.setHu_shi(R.drawable.shijian);
		wai5.setHu_tian("3天前");
		list.add(wai5);
		
		Huwai wai6=new Huwai();
		wai6.setHu_photo(R.drawable.huwai6);
		wai6.setHu_name("如何正确选择装备");
		wai6.setHu_tou(R.drawable.touxiang4);
		wai6.setHu_zs("户外小知识");
		wai6.setHu_shi(R.drawable.shijian);
		wai6.setHu_tian("3天前");
		list.add(wai6);
		MyHuAdapter huAdapter=new MyHuAdapter(R.layout.activity_huwai_content,list,this);
		gridview.setAdapter(huAdapter);
	}
	OnClickListener l=new OnClickListener(){
		public void onClick(View v) {
			switch(v.getId()){
				case R.id.huwai_fanhui:
					finish();
					break;
				case R.id.huwai_sou:
					Intent intent=new Intent(HuwaiActivity.this,SouActivity.class);
					startActivity(intent);
					break;
				default:
					break;
			}
			
		}
	};
}
