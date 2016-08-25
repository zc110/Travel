package com.example.lvyou;

import java.util.List;

import com.example.traves.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter_wd_zu_ji extends BaseAdapter{
	Context context;
	LayoutInflater inflater;
	int ItemId;
	List<Shopinfor> list;
		public MyAdapter_wd_zu_ji(Context context,
			int itemId, List<Shopinfor> list) {
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

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView==null){
			convertView=inflater.inflate(ItemId, null);
		}
		ImageView image=(ImageView) convertView.findViewById(R.id.wodezuji_gridview_image);
		TextView text1=(TextView) convertView.findViewById(R.id.wodezuji_gridview_text1);
		TextView text2=(TextView) convertView.findViewById(R.id.wodezuji_gridview_text2);
		Shopinfor shopinfor=list.get(position);
		//image.setImageDrawable(context.getResources().getDrawable(shopinfor.getImage_wodezuji()));
	    Bitmap bm = BitmapFactory.decodeFile(shopinfor.getImage_shezhitupian());
	    image.setImageBitmap(bm);
		text1.setText(shopinfor.getText_wdzuji1());
		text2.setText(shopinfor.getText_wdzuji2());
		return convertView;
	}

}
