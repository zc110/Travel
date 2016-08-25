package com.example.lvyou;

import java.util.List;

import com.example.traves.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.ImageView;


public class MyAdapter_gridview_wodeguanzhu_xiangqing extends BaseAdapter{
	Context context;
	int str;
	
	public MyAdapter_gridview_wodeguanzhu_xiangqing(Context context, 
			int itemId, List<Integer> list) {
		super();
		this.context = context;
		this.inflater = LayoutInflater.from(context);
		ItemId = itemId;
		this.list = list;
	}

	LayoutInflater inflater;
	int ItemId;
	List<Integer> list;
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@SuppressWarnings("deprecation")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView==null){
			convertView=inflater.inflate(ItemId, null);
		}
		ImageView imageview=(ImageView) convertView.findViewById(R.id.image_list_gridview);
	//	Shopinfor shop=list.add(lists);
		imageview.setImageDrawable(context.getResources().getDrawable(list.get(position)));
		//imageview.setImageDrawable(context.getResources().getDrawable(shop.getImage_wodezuji()));
		
		return convertView;
	}
}
