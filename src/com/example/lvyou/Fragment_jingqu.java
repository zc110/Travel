package com.example.lvyou;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class Fragment_jingqu extends Fragment{
	ListView listview;
	List<Shopinfor> list=new ArrayList<Shopinfor>();
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v=inflater.inflate(R.layout.layout_wdguanzhu_jingqu, container,false);
		listview=(ListView) v.findViewById(R.id.listview_wodeguanzhu_jingqu);
		getData();
		
		return v;
	}
	public void getData(){
		
		Shopinfor shopinfor=new Shopinfor();
		shopinfor.setBackId(R.drawable.xian);
		shopinfor.setText_xian("西安");
		shopinfor.setText_jieshao("西安自古帝王都，西安拥有着7000多年文明历史、3100多年建城史1000多年的历史...");
		list.add(shopinfor);
		
		Shopinfor shopinfor1=new Shopinfor();
		shopinfor1.setBackId(R.drawable.shanghai);
		shopinfor1.setText_xian("上海");
		shopinfor1.setText_jieshao("东方明珠塔是上海国际新闻中心所在地，它犹如一串从天而降的明珠，在上海浦东...");
		list.add(shopinfor1);
		
		Shopinfor shopinfor2=new Shopinfor();
		shopinfor2.setBackId(R.drawable.riben);
		shopinfor2.setText_xian("日本");
		shopinfor2.setText_jieshao("日本是一个高度发达的资本主义国家。其资源匮乏并极端依赖进口。高度发达的...");
		list.add(shopinfor2);
		MyAdapter adapter=new MyAdapter(getActivity(), R.layout.layout_listview_wodeguanzhu, list);
		listview.setAdapter(adapter);
}}
