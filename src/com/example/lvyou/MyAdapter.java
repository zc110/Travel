package com.example.lvyou;

import java.util.List;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter{
	Context context;
	LayoutInflater inflater;
	int ItemId;
	List<Shopinfor> list;
	public MyAdapter(Context context,  int itemId,
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
		RelativeLayout relative=(RelativeLayout) convertView.findViewById(R.id.relativelayout_wodeguanzhu);
		TextView text_xian= (TextView) convertView.findViewById(R.id.text_wodeguanzhu_xian);
		TextView text_jieshao= (TextView) convertView.findViewById(R.id.text_wodeguanzhu_jieshao);
		Shopinfor shopinfor=list.get(position);
		relative.setBackground(context.getResources().getDrawable(shopinfor.getBackId()));
		//image_erhu.setImageDrawable(context.getResources().getDrawable(shopinfor.getImageId()));
				text_xian.setText(shopinfor.getText_xian());
				text_jieshao.setText(shopinfor.getText_jieshao());
		return convertView;
	}

}
