package adapter;

import java.util.List;
import classify.Run;
import com.example.travel.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyYuebanAdapter extends BaseAdapter {
	int ItemId;
	LayoutInflater inflater;
	List<Run> list;
	Context context;

	public MyYuebanAdapter(int itemId, List<Run> list, Context context) {
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
		if (convertView == null) {
			convertView = inflater.inflate(ItemId, null);
		}
		ImageView touxiang=(ImageView)convertView.findViewById(R.id.yueban_touxiang);
		TextView name=(TextView)convertView.findViewById(R.id.yueban_name);
		TextView guan=(TextView)convertView.findViewById(R.id.yueban_guanzhu);
		TextView neirong=(TextView)convertView.findViewById(R.id.yueban_neirong);
		ImageView tu1=(ImageView)convertView.findViewById(R.id.image_tu1);
		ImageView tu2=(ImageView)convertView.findViewById(R.id.image_tu2);
		ImageView tu3=(ImageView)convertView.findViewById(R.id.image_tu3);
		ImageView tu4=(ImageView)convertView.findViewById(R.id.image_tu4);
		ImageView tu5=(ImageView)convertView.findViewById(R.id.image_tu5);
		Run run=list.get(position);
		touxiang.setImageDrawable(context.getResources().getDrawable(run.getTouxiang()));
		name.setText(run.getName());
		guan.setText(run.getGuanzhu());
		neirong.setText(run.getNeirong());
		tu1.setImageDrawable(context.getResources().getDrawable(run.getTu1()));
		tu2.setImageDrawable(context.getResources().getDrawable(run.getTu2()));
		tu3.setImageDrawable(context.getResources().getDrawable(run.getTu3()));
		tu4.setImageDrawable(context.getResources().getDrawable(run.getZan()));
		tu5.setImageDrawable(context.getResources().getDrawable(run.getPing()));
		return convertView;
	}
}
