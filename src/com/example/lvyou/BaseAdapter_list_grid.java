package com.example.lvyou;

import java.util.List;

import com.example.traves.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class BaseAdapter_list_grid extends BaseAdapter{
	Context context;
	int str;
	
	public BaseAdapter_list_grid(Context context, 
			int itemId, List<Shopinfor> list) {
		super();
		this.context = context;
		this.inflater = LayoutInflater.from(context);
		ItemId = itemId;
		this.list = list;
	}

	LayoutInflater inflater;
	int ItemId;
	List<Shopinfor> list;
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

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView==null){
			convertView=inflater.inflate(ItemId, null);
		}
		TextView text_riqi=(TextView) convertView.findViewById(R.id.text_wd_zuji_xiangqing_gridview);
		GridView gridview=(GridView) convertView.findViewById(R.id.gridview_wode_zuji_xiangqing);
		Shopinfor shop=list.get(position);
		text_riqi.setText(shop.getText_riqi());
		//ArrayAdapter<String> adapter=new ArrayAdapter<String>(context, R.layout.layout_list_grid_image, shop.getLists());
		MyAdapter_gridview_wodeguanzhu_xiangqing adapter_gridview_wodeguanzhu_xiangqing=new MyAdapter_gridview_wodeguanzhu_xiangqing(context, R.layout.layout_list_grid_image, shop.getLists());
		gridview.setAdapter(adapter_gridview_wodeguanzhu_xiangqing);
		return convertView;
	}

}
