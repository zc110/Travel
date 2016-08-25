package adapter;

import java.util.List;
import classify.Huwai;
import com.example.travel.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyHuAdapter extends BaseAdapter{
	int ItemId;
	LayoutInflater inflater;
	List<Huwai> list;
	Context context;
	
	public MyHuAdapter(int itemId, List<Huwai> list, Context context) {
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
		ImageView hu_photo=(ImageView)convertView.findViewById(R.id.huwaitu);
		TextView hu_name=(TextView)convertView.findViewById(R.id.huwai_name);
		ImageView hu_tou=(ImageView)convertView.findViewById(R.id.huwai_touxiang);
		TextView hu_zs=(TextView)convertView.findViewById(R.id.huwai_zhishi);
		ImageView hu_sj=(ImageView)convertView.findViewById(R.id.huwau_shijian);
		TextView hu_tian=(TextView)convertView.findViewById(R.id.huwai_tian);
		Huwai hu=list.get(position);
		hu_photo.setImageDrawable(context.getResources().getDrawable(hu.getHu_photo()));
		hu_name.setText(hu.getHu_name());
		hu_tou.setImageDrawable(context.getResources().getDrawable(hu.getHu_tou()));
		hu_zs.setText(hu.getHu_zs());
		hu_sj.setImageDrawable(context.getResources().getDrawable(hu.getHu_shi()));
		hu_tian.setText(hu.getHu_tian());
		return convertView;
	}
}
