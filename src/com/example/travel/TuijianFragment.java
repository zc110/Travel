package com.example.travel;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class TuijianFragment extends Fragment{
	ListView listview;
	Spinner spinner;
	ArrayAdapter<String> adapter;
	String[] str={"重庆","北京","上海","四川","杭州"};
	
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
		MyAdapter myAdapter = new MyAdapter(
				R.layout.fragment_tuijian_neirong, list, getActivity());
		listview.setAdapter(myAdapter);
	}
}
