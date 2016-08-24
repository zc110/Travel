package adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import classify.Zhoubian;

import com.example.travel.R;

public class MyZhoubianAdapter extends BaseAdapter{
	int ItemId;
	LayoutInflater inflater;
	List<Zhoubian> list;
	Context context;
	
	public MyZhoubianAdapter(int itemId, List<Zhoubian> list, Context context) {
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
		ImageView zhou_photo=(ImageView)convertView.findViewById(R.id.zhou_image);
		TextView zhou_name=(TextView)convertView.findViewById(R.id.zhou_name);
		ImageView zhou_tu1=(ImageView)convertView.findViewById(R.id.zhou_image1);
		ImageView zhou_tu2=(ImageView)convertView.findViewById(R.id.zhou_image2);
		ImageView zhou_tu3=(ImageView)convertView.findViewById(R.id.zhou_image3);
		ImageView zhou_tu4=(ImageView)convertView.findViewById(R.id.zhou_image4);
		ImageView zhou_tu5=(ImageView)convertView.findViewById(R.id.zhou_image5);
		TextView zhou_mi=(TextView)convertView.findViewById(R.id.zhou_mi);
		Zhoubian zhou=list.get(position);
		zhou_photo.setImageDrawable(context.getResources().getDrawable(zhou.getZhou_photo()));
		zhou_name.setText(zhou.getZhou_name());
		zhou_tu1.setImageDrawable(context.getResources().getDrawable(zhou.getZhou_tu1()));
		zhou_tu2.setImageDrawable(context.getResources().getDrawable(zhou.getZhou_tu2()));
		zhou_tu3.setImageDrawable(context.getResources().getDrawable(zhou.getZhou_tu3()));
		zhou_tu4.setImageDrawable(context.getResources().getDrawable(zhou.getZhou_tu4()));
		zhou_tu5.setImageDrawable(context.getResources().getDrawable(zhou.getZhou_tu5()));
		zhou_mi.setText(zhou.getZhou_mi());
		return convertView;
	}
}
