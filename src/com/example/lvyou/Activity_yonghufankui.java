package com.example.lvyou;

import com.example.traves.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_yonghufankui extends Activity{
	ImageView image_fanhui,image_xiangce;
	TextView text_fasong;
	AlertDialog alertDialog;
	Builder builder;
	  //调用系统相册-选择图片
    private static final int IMAGE = 1;
    private static final int CAMERA = 100;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_yonghufankui);
		image_fanhui=(ImageView) findViewById(R.id.yonghufankui_image_fanhui);
		image_xiangce=(ImageView) findViewById(R.id.yonghufankui_image_xiangce);
		text_fasong=(TextView) findViewById(R.id.yonghufankui_text_fasong);
		image_fanhui.setOnClickListener(clickListener);
		image_xiangce.setOnClickListener(clickListener);
	}
	OnClickListener clickListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.yonghufankui_image_fanhui:
				finish();
				break;
			case R.id.yonghufankui_image_xiangce:
			
				if(alertDialog==null){
				createDialog();
			} 
				alertDialog.show();
				
				break;
			case R.id.text_fayueban_xuanzhe:
				getPicture();
				alertDialog.dismiss();    
				break;
			case R.id.text_fayueban_quxiao:
				alertDialog.dismiss();   
			default:
				break;
			}
		}
	};
			public void diaoyongxiangji(){//调用相机
				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(intent, CAMERA);}
			public void getPicture(){//调用相册
				Intent intent = new Intent(Intent.ACTION_PICK,
		                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
		        startActivityForResult(intent, IMAGE);
		     //   onActivityResult(IMAGE,-1,intent);
		        
		        
		}
			/*protected void onActivityResult(int requestCode, int resultCode, Intent data) {
				  super.onActivityResult(requestCode, resultCode, data);
				  //相机的
				  if(requestCode == CAMERA && resultCode == Activity.RESULT_OK && null != data){
				      Bundle bundle = data.getExtras();
				      //获取相机返回的数据，并转换为图片格式
				      @SuppressWarnings("unused")
					Bitmap bitmap = (Bitmap)bundle.get("data");
				    }
				}*/
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
			        ((ImageView)findViewById(R.id.tianjiatupian_image)).setImageBitmap(bm);
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
					//  window.setLayout(50, 50);
					  layoutParams.y=50; 
					  layoutParams.width=50;
					  layoutParams.height=50;
					  layoutParams.alpha=1f;
					  alertDialog.onWindowAttributesChanged(layoutParams);
					  v.setLayoutParams(layoutParams);
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
