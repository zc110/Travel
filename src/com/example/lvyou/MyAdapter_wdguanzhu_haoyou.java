package com.example.lvyou;

import java.util.List;

import com.example.traves.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter_wdguanzhu_haoyou extends BaseAdapter{

	Context context;
	LayoutInflater inflater;
	int ItemId;
	List<Shopinfor> list;
	public MyAdapter_wdguanzhu_haoyou(Context context,  int itemId,
			List<Shopinfor> list) {
		super();
		this.context = context;
		this.inflater = LayoutInflater.from(context);
		ItemId = itemId;
		this.list = list;
	}

	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@SuppressLint("NewApi")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView==null){
			convertView=inflater.inflate(ItemId, null);
		}
		ImageView imageview=(ImageView) convertView.findViewById(R.id.image_wodeguanzhu_haoyou);
		TextView text_xingming= (TextView) convertView.findViewById(R.id.text_wodeguanzhu_xingming);
		TextView text_dongtai= (TextView) convertView.findViewById(R.id.text_wodeguanzhu_dongtai);
		Shopinfor shopinfor=list.get(position);
		imageview.setImageDrawable(context.getResources().getDrawable(shopinfor.getImageid()));
		text_xingming.setText(shopinfor.getText_haoyou());
		text_dongtai.setText(shopinfor.getText_jingqu());
		return convertView;
	}

}