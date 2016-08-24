package com.example.zhaoliusentravel;

import java.util.List;

import com.example.travel.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyDongtaiAdapter extends BaseAdapter{
	int ItemId;
	LayoutInflater inflater;
	List<Trend> list;
	Context context;
	
	public MyDongtaiAdapter(int itemId, List<Trend> list, Context context) {
		super();
		this.ItemId = itemId;
		inflater = LayoutInflater.from(context);
		this.list = list;
		this.context = context;
	}
	public int getCount() {
		return list.size();
	}
	public Object getItem(int position) {		
		return list.get(position);
	}

	public long getItemId(int position) {	
		return position;
	}
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView==null){
			convertView = inflater.inflate(ItemId, null);
		}
		ImageView touxiang=(ImageView)convertView.findViewById(R.id.image_tou);
		TextView name=(TextView)convertView.findViewById(R.id.text_name);
		ImageView zan=(ImageView)convertView.findViewById(R.id.image_zan);
		TextView nemu=(TextView)convertView.findViewById(R.id.text_nemu);
		ImageView xian=(ImageView)convertView.findViewById(R.id.image_xian);
		TextView timu=(TextView)convertView.findViewById(R.id.text_timu);
		ImageView tupian=(ImageView)convertView.findViewById(R.id.image_tupian);
		ImageView photo=(ImageView)convertView.findViewById(R.id.image_photo);
		TextView riqi=(TextView)convertView.findViewById(R.id.text_riqi);
		
		Trend end=list.get(position);
		touxiang.setImageDrawable(context.getResources().getDrawable(end.getTouxiang()));
		name.setText(end.getName());
		zan.setImageDrawable(context.getResources().getDrawable(end.getZan()));
		nemu.setText(end.getNemu());
		xian.setImageDrawable(context.getResources().getDrawable(end.getXian()));
		timu.setText(end.getTimu());
		tupian.setImageDrawable(context.getResources().getDrawable(end.getTupian()));
		photo.setImageDrawable(context.getResources().getDrawable(end.getPhoto()));
		riqi.setText(end.getRiqi());
		return convertView;
	}

}
