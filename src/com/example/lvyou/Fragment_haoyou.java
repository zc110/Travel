package com.example.lvyou;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class Fragment_haoyou extends Fragment{
	ListView listview_haoyou;
	List<Shopinfor> list=new ArrayList<Shopinfor>();
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			View v=inflater.inflate(R.layout.layout_listview_wodeguanzhu_haoyou, container,false);
			listview_haoyou=(ListView)v.findViewById(R.id.listview_wodeguanzhu_haoyou);
			 getData_haoyou();
			return v;
		}
		public void getData_haoyou(){
			
			Shopinfor shopinfor3=new Shopinfor();
			shopinfor3.setImageid(R.drawable.chengcuncun);
			shopinfor3.setText_haoyou("程存存");
			shopinfor3.setText_jingqu("上海著名地标，走在259米高的全透明观光");
			list.add(shopinfor3);
			
			Shopinfor shopinfor4=new Shopinfor();
			shopinfor4.setImageid(R.drawable.lixiaoguo);
			shopinfor4.setText_haoyou("李小果");
			shopinfor4.setText_jingqu("白天看浦江两岸万国建筑和摩天楼群，入夜");
			list.add(shopinfor4);
			
			Shopinfor shopinfor0=new Shopinfor();
			shopinfor0.setImageid(R.drawable.chenmoumou);
			shopinfor0.setText_haoyou("陈某某");
			shopinfor0.setText_jingqu("杭州一人间天堂");
			list.add(shopinfor0);
			
			Shopinfor shopinfor5=new Shopinfor();
			shopinfor5.setImageid(R.drawable.wangfakai);
			shopinfor5.setText_haoyou("王发开");
			shopinfor5.setText_jingqu("北京故宫博物馆-世界五大宫之一");
			list.add(shopinfor5);
			MyAdapter_wdguanzhu_haoyou aadapter=new MyAdapter_wdguanzhu_haoyou(getActivity(), R.layout.layou_wdguanzhu_haoyou, list);
			listview_haoyou.setAdapter(aadapter);
		}
}
