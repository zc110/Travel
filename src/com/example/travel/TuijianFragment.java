package com.example.travel;

import java.util.ArrayList;
import java.util.List;
import classify.Scene;
import adapter.MyTuijianAdapter;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.ViewFlipper;

public class TuijianFragment extends Fragment{
	ListView listview;
	Spinner spinner;
	ArrayAdapter<String> adapter;
	String[] str={"重庆","上海","广东","浙江","云南","北京","四川","天津","江苏","深圳"};
	LinearLayout layout1,layout2,layout3;
	ViewFlipper flipper;
	GestureDetector mGestureDetector;
	@SuppressLint("InflateParams")
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {	
		View v=inflater.inflate(R.layout.fragment_tuijian,null);
		listview=(ListView)v.findViewById(R.id.listview_tuijian);
		getData();
		
		spinner=(Spinner)v.findViewById(R.id.spinner_tuijian);
		adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_spinner_item, str);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		return v;
	}

	@SuppressLint("InflateParams")
	private void getData() {
		LayoutInflater in=getLayoutInflater(getArguments());
		View headview=in.inflate(R.layout.fragment_tuijian_head,null);
		listview.addHeaderView(headview);
		
		List<Scene> list = new ArrayList<Scene>();
		Scene en=new Scene();
		en.setPhoto(R.drawable.flipper2);
		en.setContent("人间三月，带你看春暖花开\n金佛山带你领略不一样的浪漫樱花季");
		list.add(en);
		
		Scene en1=new Scene();
		en1.setPhoto(R.drawable.flipper3);
		en1.setContent("百万株春花竞开，多彩活动亮园博\n告别多天，去花舞人间看百花相争");
		list.add(en1);
		
		Scene en2=new Scene();
		en2.setPhoto(R.drawable.flipper4);
		en2.setContent("一个令世人追逐的“世外桃源”\n世界上有两个桃花源，一个在您心里，一个在酉阳");
		list.add(en2);
		
		Scene en3=new Scene();
		en3.setPhoto(R.drawable.flipper1);
		en3.setContent("人间三月，带你看春暖花开\n带你走进四面山，回归大自然");
		list.add(en3);
		MyTuijianAdapter myAdapter = new MyTuijianAdapter(
				R.layout.fragment_tuijian_neirong, list, getActivity());
		listview.setAdapter(myAdapter);
		
		layout1=(LinearLayout)headview.findViewById(R.id.layout1);
		layout1.setOnClickListener(l);
		layout2=(LinearLayout)headview.findViewById(R.id.layout2);
		layout2.setOnClickListener(l);
		layout3=(LinearLayout)headview.findViewById(R.id.layout3);
		layout3.setOnClickListener(l);
		flipper=(ViewFlipper)headview.findViewById(R.id.flipper);
		flipper.startFlipping();
	}
	OnClickListener l=new OnClickListener(){
		public void onClick(View v) {
			Intent intent; 
			switch(v.getId()){
				 case R.id.layout1:
					 intent=new Intent(getActivity(),JingdianActivity.class);
					 startActivity(intent);
					 break;
				 case R.id.layout2:
					 intent=new Intent(getActivity(),HuwaiActivity.class); 
					 startActivity(intent);
					 break;
				 case R.id.layout3:
					 intent=new Intent(getActivity(),ZhouBianActivity.class);
					 startActivity(intent);
					 break;
				 default:
					 break;
			}
		}
	};
}
