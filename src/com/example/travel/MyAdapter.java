package com.example.travel;

import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter{
	int ItemId;
	LayoutInflater inflater;
	List<Scene> list;
	Context context;
	public MyAdapter(int itemId, List<Scene> list, Context context) {
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
		ImageView image_tu=(ImageView)convertView.findViewById(R.id.neirong1);
		TextView name=(TextView)convertView.findViewById(R.id.neirong2);
		
		Scene sc=list.get(position);
		image_tu.setImageDrawable(context.getResources().getDrawable(sc.getPhoto()));
		name.setText(sc.getContent());
		return convertView;
	}

}
