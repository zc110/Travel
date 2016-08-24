package com.example.yjj.travel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;














import com.example.travel.R;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.utils.SMSLog;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.ParseException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ZhuceActivity extends Activity{
	TextView textView_tiaozhuandenglu;
	EditText zhuce_username;
	EditText zhuce_firstmima;
	EditText zhuce_secondmima;
	Button zhuce_huoquyanzhengma;
	Button zhuce_zhuce;
	String phString;
	EditText zhuce_yanzhengma;
	int i = 30; 
	//private static String APPKEY="1623b6aa80840";
	//private static String APPSECRET="4ae449ebbc30bdd8bfe3f770ac52387d";
	private static String APPKEY="1623846047e00";
	private static String APPSECRET="358d9c4c209c0a7dec3a70adaeb64c05";
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
setContentView(R.layout.activity_zhuce);
getId();

}
Handler mHandler = new Handler() {
public void handleMessage(Message msg) {

	// TODO Auto-generated method stub
	super.handleMessage(msg);
	int event = msg.arg1;
	int result = msg.arg2;
	Object data = msg.obj;
	Log.e("event", "event=" + event);
	// System.out.println("--------result---0"+event+"--------*"+result+"--------"+data);

	if (result == SMSSDK.RESULT_COMPLETE) {
		if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
			Toast.makeText(getApplicationContext(), "发送验证码成功",
					Toast.LENGTH_SHORT).show();
		}
		else if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {// 提交验证码成功	
			Toast.makeText(getApplicationContext(), "注册成功",
					Toast.LENGTH_SHORT).show();
			//zhuce();

		} /*else if(event != SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE){
			Toast.makeText(getApplicationContext(), "验证码错误",
					Toast.LENGTH_SHORT).show();
		}*/
	} else {
		int status = 0;
		try {
			((Throwable) data).printStackTrace();
			Throwable throwable = (Throwable) data;

			JSONObject object = new JSONObject(throwable.getMessage());
			String des = object.optString("detail");
			status = object.optInt("status");
			if (!TextUtils.isEmpty(des)) {
				Toast.makeText(ZhuceActivity.this, des,
						Toast.LENGTH_SHORT).show();
				return;
			}
		} catch (Exception e) {
			SMSLog.getInstance().w(e);
		}
	}
};
};
protected void onDestroy() {
	super.onDestroy();
	SMSSDK.unregisterAllEventHandler();
};
OnClickListener onClickListener=new OnClickListener(){

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String phoneNums=zhuce_username.getText().toString();
		switch (v.getId()) {
		case R.id.zhuce_tiaozhuandenglu:
			tiaozhuandaozhuce();
			break;
		case R.id.zhuce_huoquyanzhengma:
			if (!judgePhoneNums(phoneNums)) {  
		        return;  
		      } // 2. 通过sdk发送短信验证  
		      SMSSDK.getVerificationCode("86", phoneNums);
		      zhuce_huoquyanzhengma.setClickable(false);  
		      zhuce_huoquyanzhengma.setText("重新发送(" + i + ")");  
		      new Thread(new Runnable() {  
		        @Override 
		        public void run() {  
		          for (; i > 0; i--) {  
		            handler.sendEmptyMessage(-9);  
		            if (i <= 0) {  
		              break;  
		            }  
		            try {  
		              Thread.sleep(1000);  
		            } catch (InterruptedException e) {  
		              e.printStackTrace();  
		            }  
		          }  
		          handler.sendEmptyMessage(-8);  
		        }  
		      }).start(); 
			break;
		case R.id.zhuce_zhuce:
			zhuce();
			
			break;
		default:
			break;
		}
	}
	
};
Handler handler = new Handler() {  
    public void handleMessage(Message msg) {  
      if (msg.what == -9) {  
        zhuce_huoquyanzhengma.setText("重新发送(" + i + ")");  
      } else if (msg.what == -8) {  
    	  zhuce_huoquyanzhengma.setText("获取验证码");  
    	  zhuce_huoquyanzhengma.setClickable(true);  
        i = 30;  
      } else {  
        int event = msg.arg1;  
        int result = msg.arg2;  
        Object data = msg.obj;  
        Log.e("event", "event=" + event);  
        if (result == SMSSDK.RESULT_COMPLETE) {  
          // 短信注册成功后，返回MainActivity,然后提示  
          if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {// 提交验证码成功  
            Toast.makeText(getApplicationContext(), "提交验证码成功",  
                Toast.LENGTH_SHORT).show();  
     
          } else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {  
            Toast.makeText(getApplicationContext(), "正在获取验证码",  
                Toast.LENGTH_SHORT).show();  
          } else {  
            ((Throwable) data).printStackTrace();  
          }  
        }  
      }  
    }  
  };  
public void huoquyanzhengma(){
	if (!panduanEdit()) {				
		return;
	}
	if(!TextUtils.isEmpty(zhuce_username.getText().toString())){
		SMSSDK.getVerificationCode("86",zhuce_username.getText().toString());   
		//SMSSDK.getVoiceVerifyCode("86",phonEditText.getText().toString());	
		phString=zhuce_username.getText().toString();
	}
}
private boolean panduanEdit() {
	String username = zhuce_username.getText().toString().trim();
	String frist = zhuce_firstmima.getText().toString().trim();
	String second = zhuce_secondmima.getText().toString().trim();
	String yanzhengma=zhuce_yanzhengma.getText().toString().trim();
	if (username.equals("")) {
		Toast.makeText(ZhuceActivity.this, "用户名不能为空", Toast.LENGTH_SHORT)
				.show();
	}else if(username.length()!=11){
		Toast.makeText(ZhuceActivity.this, "请输入正确的手机号码", Toast.LENGTH_SHORT)
		.show();
	} 
	else if (frist.equals("")) {
		Toast.makeText(ZhuceActivity.this, "密码不能为空", Toast.LENGTH_SHORT)
				.show();
	} else if(frist.length() < 6){
		Toast.makeText(ZhuceActivity.this, "密码不能少于6位",
				Toast.LENGTH_SHORT).show();
	} else if (second.equals("")) {
		Toast.makeText(ZhuceActivity.this, "确认密码不能为空",
				Toast.LENGTH_SHORT).show();
	} else if(!frist.equals(second)){
		Toast.makeText(ZhuceActivity.this,
				"两次密码输入不一样,请重新输入", Toast.LENGTH_SHORT).show();
	}
	else {
		return true;
	}
	return false;
}
public void zhuce(){
	if (!checkEdit()) {				
		return;
	}
	panduan(zhuce_username.getText().toString(), zhuce_firstmima.getText().toString());
}
public void getId(){
	textView_tiaozhuandenglu=(TextView)findViewById(R.id.zhuce_tiaozhuandenglu);
	textView_tiaozhuandenglu.setOnClickListener(onClickListener);
	zhuce_username=(EditText)findViewById(R.id.zhuce_username);
	zhuce_firstmima=(EditText)findViewById(R.id.zhuce_firstpassword);
	zhuce_secondmima=(EditText)findViewById(R.id.zhuce_secondpassword);
	zhuce_zhuce=(Button)findViewById(R.id.zhuce_zhuce);
	zhuce_zhuce.setOnClickListener(onClickListener);
	zhuce_huoquyanzhengma=(Button)findViewById(R.id.zhuce_huoquyanzhengma);
	zhuce_huoquyanzhengma.setOnClickListener(onClickListener);
	zhuce_yanzhengma=(EditText)findViewById(R.id.zhuce_yanzhengma);
	SMSSDK.initSDK(this, APPKEY, APPSECRET, false);
	EventHandler eh = new EventHandler() {

		@Override
		public void afterEvent(int event, int result, Object data) {
			Message msg = new Message();
			msg.arg1 = event;
			msg.arg2 = result;
			msg.obj = data;
			mHandler.sendMessage(msg);
		}

	};
	SMSSDK.registerEventHandler(eh);
}
@SuppressWarnings("unused")
private boolean judgePhoneNums(String phoneNums) {  
    if (isMatchLength(phoneNums, 11)  
        && isMobileNO(phoneNums)) {  
      return true;  
    }  
    Toast.makeText(this, "手机号码输入有误！",Toast.LENGTH_SHORT).show();  
    return false;  
  }  
public static boolean isMobileNO(String mobileNums) {  
    /* 
     * 移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188 
     * 联通：130、131、132、152、155、156、185、186 电信：133、153、180、189、（1349卫通） 
     * 总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9 
     */  
    String telRegex = "[1][358]\\d{9}";// "[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。  
    if (TextUtils.isEmpty(mobileNums))  
      return false;  
    else  
      return mobileNums.matches(telRegex);  
  }  
@SuppressLint("NewApi")
public static boolean isMatchLength(String str, int length) {  
    if (str.isEmpty()) {  
      return false;  
    } else {  
      return str.length() == length ? true : false;  
    }  
  } 
public void tiaozhuandaozhuce(){
	Intent intent=new Intent(ZhuceActivity.this,DengluActivity.class);
	startActivity(intent);
}

private boolean checkEdit() {
	String username = zhuce_username.getText().toString().trim();
	String frist = zhuce_firstmima.getText().toString().trim();
	String second = zhuce_secondmima.getText().toString().trim();
	String yanzhengma=zhuce_yanzhengma.getText().toString().trim();
	if (username.equals("")) {
		Toast.makeText(ZhuceActivity.this, "用户名不能为空", Toast.LENGTH_SHORT)
				.show();
	}else if(username.length()!=11){
		Toast.makeText(ZhuceActivity.this, "请输入正确的手机号码", Toast.LENGTH_SHORT)
		.show();
	} 
	else if (frist.equals("")) {
		Toast.makeText(ZhuceActivity.this, "密码不能为空", Toast.LENGTH_SHORT)
				.show();
	} else if(frist.length() < 6){
		Toast.makeText(ZhuceActivity.this, "密码不能少于6位",
				Toast.LENGTH_SHORT).show();
	} else if (second.equals("")) {
		Toast.makeText(ZhuceActivity.this, "确认密码不能为空",
				Toast.LENGTH_SHORT).show();
	} else if(!frist.equals(second)){
		Toast.makeText(ZhuceActivity.this,
				"两次密码输入不一样,请重新输入", Toast.LENGTH_SHORT).show();
	}/*else if(!yanzhengma.equals(SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE)){
		Toast.makeText(ZhuceActivity.this,
				"验证码错误", Toast.LENGTH_SHORT).show();
		//return false;
	}*/	
	
	else {
		return true;
	}
	return false;
}
protected void complete() {
	new Thread(new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			String httpUrl = "http://192.168.1.207/home/zhuce/register";
			@SuppressWarnings("deprecation")
			HttpPost httpRequest = new HttpPost(httpUrl);
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("username",
					zhuce_username.getText().toString().trim()));
			params.add(new BasicNameValuePair("password",
					zhuce_firstmima.getText().toString().trim()));
			HttpEntity httpentity = null;
			try {
				httpentity = new UrlEncodedFormEntity(params, "utf8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			httpRequest.setEntity(httpentity);
			HttpClient httpclient = new DefaultHttpClient();
			HttpResponse httpResponse = null;
			try {
				httpResponse = httpclient.execute(httpRequest);
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				String strResult = null;
				try {
					strResult = EntityUtils.toString(httpResponse
							.getEntity());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Looper.prepare();
				Toast.makeText(ZhuceActivity.this, strResult+"注册成功",
						Toast.LENGTH_SHORT).show();
				Looper.loop();
			} else {
				Looper.prepare();
				Toast.makeText(ZhuceActivity.this, "用户已经存在",
						Toast.LENGTH_SHORT).show();
				Looper.loop();
			}
		}
	}).start();	
}
String str;
public void panduan(final String username, final String password) {
	new Thread(new Runnable() {
		@Override
		public void run() {

			StringBuilder builder = new StringBuilder();
			try {
				String httpHost = "http://192.168.1.207/index.php/Home/zhuce/zhucepanduan";// php接口
				//String httpHost = "http://192.168.1.151/Home/zhuce/zhuce";// php接口
				String name = "username=" + username + "&password="
						+ password;
				String urlName = httpHost + "?" + name;
				URL url = new URL(urlName);
				HttpURLConnection connection = (HttpURLConnection) url
						.openConnection();
				connection.setConnectTimeout(5000);
				connection.setRequestProperty("accept", "*/*");// 设置客户端接受那些类型的信息，�?�配符代表接收所有类型的数据
				connection.setRequestProperty("connection", "Keep-Alive");// 保持长链�?
				connection
						.setRequestProperty("user-agent",
								"Mozilla/4.0(compatible;MSIE 6.0;Windows NT5.1;SV1)");// 设置浏览器代�?
				connection
						.setRequestProperty("accept-charset", "utf-8;GBK");// 客户端接受的字符�?
				connection.connect();// 建立连接
				InputStream inputStream = connection.getInputStream();
				Map<String, List<String>> headers = connection
						.getHeaderFields();
				for (String key : headers.keySet()) {
					System.out.println(key + "----" + headers.get(key));

				}
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(inputStream));
				String line = bufferedReader.readLine();
				while (line != null && line.length() > 0) {
					builder.append(line);
					line = bufferedReader.readLine();
				}
				bufferedReader.close();
				inputStream.close();
				str = builder.toString();
				myHandler.sendEmptyMessage(0);

			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}).start();
}

@SuppressLint("HandlerLeak")
Handler myHandler = new Handler() {
	public void handleMessage(Message msg) {
		try {
			JSONObject jsonObject = new JSONObject(str);
			int status = jsonObject.getInt("status");
			String message = jsonObject.getString("message");
			if (status == 2) {
				Toast.makeText(ZhuceActivity.this, message,
						Toast.LENGTH_SHORT).show();// 密码错误，提示用户名和密码错误?
			}else if(status == 3){
				Toast.makeText(ZhuceActivity.this, message,
						Toast.LENGTH_SHORT).show();
				complete();
			}

		} catch (JSONException e) {
			
			e.printStackTrace();
		}

	}
};
}

