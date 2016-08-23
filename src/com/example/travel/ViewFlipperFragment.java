package com.example.travel;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;

public class ViewFlipperFragment extends Fragment{
	ViewFlipper flipper;
	GestureDetector mGestureDetector;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v=inflater.inflate(R.layout.fragment_tuijian_head,null);
		flipper=(ViewFlipper)v.findViewById(R.id.flipper);
		flipper.startFlipping();
		return v;
	}
	public boolean onTouchEvent(MotionEvent event) {
		return mGestureDetector.onTouchEvent(event);
	}

	OnGestureListener gestureDetector = new OnGestureListener() {
		public boolean onDown(MotionEvent e) {

			return false;
		}

		public void onShowPress(MotionEvent e) {

		}

		public boolean onSingleTapUp(MotionEvent e) {

			return false;
		}

		public boolean onScroll(MotionEvent e1, MotionEvent e2,
				float distanceX, float distanceY) {

			return false;
		}

		public void onLongPress(MotionEvent e) {

		}

		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			if (flipper.isFlipping() == true) {
				if (velocityX < 0) {
					flipper.showNext();
				} else {
					flipper.showPrevious();
				}
			}
			return false;
		}
	};
}
