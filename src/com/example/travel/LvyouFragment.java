package com.example.travel;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ImageView;

public class LvyouFragment extends Fragment {
	ImageView image_menu;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_lvyou, container, false);
		image_menu = (ImageView) v.findViewById(R.id.imageview_menu);
		registerForContextMenu(image_menu);
		return v;
	}
	
	public void onCreateContextMenu(ContextMenu menu, View v,ContextMenuInfo menuInfo) {
		MenuInflater in=new MenuInflater(getActivity());
		in.inflate(R.menu.main, menu);
		super.onCreateContextMenu(menu, v, menuInfo);
	}	
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		
		}
		return super.onOptionsItemSelected(item);
	}
}