package adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import classify.Jingqu;

import com.example.travel.R;

public class JingquAdapter extends BaseAdapter{
	int ItemId;
	LayoutInflater inflater;
	List<Jingqu> list;
	Context context;
	public JingquAdapter(int itemId,List<Jingqu> list,Context context){
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
			convertView=inflater.inflate(ItemId, null);
		}
		ImageView image=(ImageView)convertView.findViewById(R.id.grid_image);
		TextView text=(TextView)convertView.findViewById(R.id.grid_text);
		Jingqu jing=list.get(position);
		image.setImageDrawable(context.getResources().getDrawable(jing.getJing_photo()));
		text.setText(jing.getJing_name());
		return convertView;
	}

}
