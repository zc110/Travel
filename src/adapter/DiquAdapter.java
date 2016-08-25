package adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import classify.Diqu;

import com.example.travel.R;

public class DiquAdapter extends BaseAdapter{
	int ItemId;
	LayoutInflater inflater;
	List<Diqu> list;
	Context context;
	public DiquAdapter(int itemId,List<Diqu> list,Context context){
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
		TextView text=(TextView)convertView.findViewById(R.id.list_text);
		Diqu di=list.get(position);
		text.setText(di.getDi());
		return convertView;
	}

}
