package com.example.zhaoliusentravel;

import java.util.ArrayList;
import java.util.List;
import classify.Run;
import adapter.MyYuebanAdapter;
import android.annotation.SuppressLint;
import com.example.travel.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class YuebanFragment extends Fragment{
	ListView listview;
	@SuppressLint("InflateParams")
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v=inflater.inflate(R.layout.fragment_yueban,null);
		listview=(ListView)v.findViewById(R.id.listview_yueban);
		getData();
		return v;
	}
	@SuppressLint("InflateParams")
	private void getData() {
		LayoutInflater in=getLayoutInflater(getArguments());
		View headview=in.inflate(R.layout.fragment_yueban_head,null);
		listview.addHeaderView(headview);
		
		List<Run> list=new ArrayList<Run>();
		Run run=new Run();
		run.setTouxiang(R.drawable.touxiang6);
		run.setName("离殇\n03月04日19:37");
		run.setGuanzhu("关注");
		run.setNeirong("成熟不是人的心变老，是泪在打转还能微笑。走得最急\n的，都是最美的风景，伤得最深的，也总是那些最真的情");
		run.setTu1(R.drawable.yueban1);
		run.setTu2(R.drawable.yueban2);
		run.setTu3(R.drawable.yueban3);
		run.setZan(R.drawable.zan);
		run.setPing(R.drawable.yueban_ping);
		list.add(run);
		
		Run run1=new Run();
		run1.setTouxiang(R.drawable.touxiang5);
		run1.setName("100%低调\n03月04日19:00");
		run1.setGuanzhu("关注");
		run1.setNeirong("一个人，一条路，人在途中，心随景动，从起点\n到尽头，也许快乐，或有时孤独");
		run1.setTu1(R.drawable.yueban5);
		run1.setTu2(R.drawable.yueban6);
		run1.setTu3(R.drawable.yueban4);
		run1.setZan(R.drawable.zan);
		run1.setPing(R.drawable.yueban_ping);
		list.add(run1);
		
		Run run2=new Run();
		run2.setTouxiang(R.drawable.touxiang2);
		run2.setName("王法开\n03月04日19:37");
		run2.setGuanzhu("关注");
		run2.setNeirong("成熟不是人的心变老，是泪在打转还能微笑。走得最急\n的，都是最美的风景，伤得最深的，也总是那些最真的情");
		run2.setTu1(R.drawable.yueban1);
		run2.setTu2(R.drawable.yueban2);
		run2.setTu3(R.drawable.yueban3);
		run2.setZan(R.drawable.zan);
		run2.setPing(R.drawable.yueban_ping);
		list.add(run2);
		MyYuebanAdapter yueban=new   MyYuebanAdapter(
				R.layout.fragment_yueban_neirong, list, getActivity());
		listview.setAdapter(yueban);
	}
}
