package com.example.travel;

import java.util.ArrayList;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyFragmentAdapter extends FragmentPagerAdapter{
	ArrayList<Fragment> fragmentlist;
	public MyFragmentAdapter(FragmentManager fm) {
		super(fm);
	}
	public MyFragmentAdapter(FragmentManager fm,ArrayList<Fragment> fragmentlist) {
		super(fm);
		this.fragmentlist=fragmentlist;
	}
	public int getCount() {
		return fragmentlist.size();
	}
	public Fragment getItem(int position) {
		return fragmentlist.get(position);
	}
}
