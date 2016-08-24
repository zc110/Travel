package com.example.travel;

import java.util.ArrayList;
import java.util.List;
import classify.Trend;
import adapter.MyDongtaiAdapter;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class DongtaiFragment extends Fragment{
	ListView listview;
	@SuppressLint("InflateParams")
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState){
		View v=inflater.inflate(R.layout.fragment_dongtai,null);
		listview=(ListView)v.findViewById(R.id.listview_dongtai);
		getData();
		return v;
	}
	@SuppressLint("InflateParams")
	private void getData() {
		LayoutInflater in=getLayoutInflater(getArguments());
		View headview=in.inflate(R.layout.fragment_dongtai_head,null);
		listview.addHeaderView(headview);
		
		List<Trend> list = new ArrayList<Trend>();
		Trend tr=new Trend();
		tr.setTouxiang(R.drawable.touxiang_dongtai);
		tr.setName("Dfdfdr");
		tr.setZan(R.drawable.zan);
		tr.setNemu("59");
		tr.setXian(R.drawable.feigexian);
		tr.setTimu("情系滇东北-穿越乌蒙山之旅");
		tr.setTupian(R.drawable.dongtu1);
		tr.setPhoto(R.drawable.dongtu2);
		tr.setRiqi("2016.3.8");
		list.add(tr);
		
		Trend tr1=new Trend();
		tr1.setTouxiang(R.drawable.touxiang2);
		tr1.setName("王法开");
		tr1.setZan(R.drawable.zan);
		tr1.setNemu("95");
		tr1.setXian(R.drawable.feigexian);
		tr1.setTimu("寻找最美的海滩青苔-汕尾摄影之旅");
		tr1.setTupian(R.drawable.dongtu3);
		tr1.setPhoto(R.drawable.dongtu4);
		tr1.setRiqi("2016.3.10");
		list.add(tr1);
		
		Trend tr2=new Trend();
		tr2.setTouxiang(R.drawable.touxiang3);
		tr2.setName("李小果");
		tr2.setZan(R.drawable.zan);
		tr2.setNemu("80");
		tr2.setXian(R.drawable.feigexian);
		tr2.setTimu("希腊爱琴海经典风光摄影之旅");
		tr2.setTupian(R.drawable.dongtu6);
		tr2.setPhoto(R.drawable.dongtu7);
		tr2.setRiqi("2016.3.11");
		list.add(tr2);
		
		Trend tr3=new Trend();
		tr3.setTouxiang(R.drawable.touxiang4);
		tr3.setName("程存存");
		tr3.setZan(R.drawable.zan);
		tr3.setNemu("95");
		tr3.setXian(R.drawable.feigexian);
		tr3.setTimu("寻找最美的海滩青苔-汕尾摄影之旅");
		tr3.setTupian(R.drawable.dongtu4);
		tr3.setPhoto(R.drawable.dongtu5);
		tr3.setRiqi("2016.3.10");
		list.add(tr3);
		MyDongtaiAdapter dongtai=new   MyDongtaiAdapter(
				R.layout.fragment_dongtai_neirong, list, getActivity());
		listview.setAdapter(dongtai);
	}
}
