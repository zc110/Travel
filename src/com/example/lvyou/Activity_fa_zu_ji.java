package com.example.lvyou;


import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.format.DateFormat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Activity_fa_zu_ji extends Activity{
	TextView text_quxiao,text_fabiao,text_dingwei;
	RelativeLayout layout_tianjiatupian;
	EditText edit_shuru;
	AlertDialog alertDialog;
	Builder builder;
	  private static final int IMAGE = 1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_fa_zu_ji);
		getData();
	}
	public void getData(){
		text_quxiao=(TextView) findViewById(R.id.fazuji_text_quxiao);
		text_quxiao.setOnClickListener(clickListener);
		text_fabiao=(TextView) findViewById(R.id.fazuji_text_fabiao);
		text_fabiao.setOnClickListener(clickListener);
		text_dingwei=(TextView) findViewById(R.id.fazuji_text_dingwei);
		text_dingwei.setOnClickListener(clickListener);
		layout_tianjiatupian=(RelativeLayout) findViewById(R.id.fazuji_relativelayout_tianjiatupian);
		layout_tianjiatupian.setOnClickListener(clickListener);
		edit_shuru=(EditText) findViewById(R.id.fazuji_edittext);
	}
	public void fabiaochenggong(){
		Intent intent =new Intent(this, Activity_wo_de_zu_ji.class);
			intent.putExtra("fabiao", edit_shuru.getText().toString());
			//intent.putExtra("tupian", value);
				 setResult(RESULT_OK, intent);
				 finish();
	}
	/*public void cunshuju(){
		final ContentValues cv = new ContentValues();
		mySQliteOpenHelper = new MySQliteOpenHelper(FatieActivity.this, "User",
				null, 1);
		//quchu();
		sqLiteDatabase = mySQliteOpenHelper.getWritableDatabase();
		String biaoti = edit_shuru.getText().toString();
		//String neirong = editTextneirong.getText().toString();
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(date);
		cv.put("id", biaoti + time + namel);
		cv.put("biaoti", biaoti);
		cv.put("neirong", neirong);
		cv.put("time", time);
		cv.put("name", namel);
		sqLiteDatabase.insert("fatie", null, cv);// 插入数据

	}*/
	OnClickListener clickListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.fazuji_text_quxiao:
				Intent intent =new Intent(Activity_fa_zu_ji.this, com.example.lvyou.Activity_wo_de_zu_ji.class);
				startActivity(intent);
				break;
			case R.id.fazuji_text_fabiao:
				fabiaochenggong();
					
				break;
			case R.id.fazuji_text_dingwei:
	
				break;
			case R.id.fazuji_relativelayout_tianjiatupian:
				if(alertDialog==null){
				createDialog();
			} 
				alertDialog.show();
				
				break;
			case R.id.text_fayueban_xuanzhe:
				diaoyongxiangce();
				alertDialog.dismiss();    
				break;
			case R.id.text_fayueban_quxiao:
				alertDialog.dismiss();   
			default:
				break;
			}
		}
	};
	public void diaoyongxiangce(){//调用相册方法
		  Intent intent = new Intent(Intent.ACTION_PICK,
	                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
	        startActivityForResult(intent, IMAGE);
	}
	 @Override
	    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	        super.onActivityResult(requestCode, resultCode, data);
	        //获取图片路径
	        if (requestCode == IMAGE && resultCode == Activity.RESULT_OK && data != null) {
	            Uri selectedImage = data.getData();
	            String[] filePathColumns = {MediaStore.Images.Media.DATA};
	            Cursor c = getContentResolver().query(selectedImage, filePathColumns, null, null, null);
	            c.moveToFirst();
	            int columnIndex = c.getColumnIndex(filePathColumns[0]);
	            String imagePath = c.getString(columnIndex);
	            showImage(imagePath);
	            c.close();
	        }
	    }

	    //加载图片
	    private void showImage(String imaePath){
	        Bitmap bm = BitmapFactory.decodeFile(imaePath);
	        ((ImageView)findViewById(R.id.image_tianjiatupian1)).setImageBitmap(bm);
	    }
	    public void createDialog(){
	    	LayoutInflater inflater=LayoutInflater.from(this);
	    	View v=inflater.inflate(R.layout.layout_fayueban_dialog, null);
	    	builder=new AlertDialog.Builder(this);// 创建builder的对象
	    	builder.setView(v);
	    	alertDialog=builder.create();//通过builder类创建alertdilog的对象
	    	 Window window=alertDialog.getWindow(); //获得当前Dialog的对象
			  WindowManager.LayoutParams layoutParams=window.getAttributes();
			  window.setGravity(Gravity.BOTTOM);//设置内容置顶 layoutParams.x=50;
			  layoutParams.y=50; layoutParams.width=50; layoutParams.alpha=1f;
			  alertDialog.onWindowAttributesChanged(layoutParams);
			 // alertDialog.show();
			//  alertDialog.setContentView(v);
			  TextView text_xuanze=(TextView) v.findViewById(R.id.text_fayueban_xuanzhe);
			  TextView text_paizhao=(TextView) v.findViewById(R.id.text_fayueban_paizhao);
			  TextView text_quxiao=(TextView) v.findViewById(R.id.text_fayueban_quxiao);
			  text_xuanze.setOnClickListener(clickListener);
			  text_paizhao.setOnClickListener(clickListener);
			  text_quxiao.setOnClickListener(clickListener);
	    }
	  
		

}
