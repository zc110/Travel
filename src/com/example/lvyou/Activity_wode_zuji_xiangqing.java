package com.example.lvyou;

import java.util.ArrayList;
import java.util.List;

import com.example.traves.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class Activity_wode_zuji_xiangqing extends Activity{
	ListView  listview;
	List<Shopinfor> list=new ArrayList<Shopinfor>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_wode_zuji_xiangqing);
		listview=(ListView) findViewById(R.id.listview_wode_zuji_xiangqing);
		getData();
		BaseAdapter_list_grid adapter_list_grid=new BaseAdapter_list_grid(this, R.layout.layout_wode_zuji_xiangqing_gridview, list);
		listview.setAdapter(adapter_list_grid);
	}
	public void getData(){
		for(int i=0;i<8;i++){
			Shopinfor shop=new Shopinfor();
			List<Integer> list1=new ArrayList<Integer>();
			shop.setText_riqi("2010年3月12日");
			//shop.lists.add(Integer.toString(R.drawable.dajiaotang));
			//shop.lists.add(Integer.toString(R.drawable.jinzita));
			list1.add(R.drawable.dajiaotang);
			list1.add(R.drawable.meiguozhixing);
			list1.add(R.drawable.jinianbei);
			list1.add(R.drawable.jinianbei);
			list1.add(R.drawable.jinianbei);
			list1.add(R.drawable.dajiaotang);
			list1.add(R.drawable.meiguozhixing);
			list1.add(R.drawable.jinianbei);
			list1.add(R.drawable.jinianbei);
			list1.add(R.drawable.jinianbei);
			shop.setLists(list1);
			list.add(shop);
		}
	}
}
