package com.example.yjj.travel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;



import com.example.travel.R;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.utils.SMSLog;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DengluActivity extends Activity{
	TextView denglu_kuasuzhuce;
	EditText denglu_username;
	EditText denglu_password;
	Button denglu_denglu;
	
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_denglu);
	SharedPreferences preferences = getSharedPreferences("count", MODE_WORLD_READABLE);
	int count = preferences.getInt("count", 0);
	Editor editor = preferences.edit();
	// 存入数据
	editor.putInt("count", ++count);
	// 提交修改
	editor.commit();
	getId();


}


OnClickListener onClickListener=new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.denglu_kuaisuzhuce:
			tiaozhuandaozhuce();
			break;
		case R.id.denglu_denglu:
			if (!checkEdit()) {
				return;
			}
			login();
			break;
		default:
			break;
		}
	}
};
public void getId(){
	denglu_kuasuzhuce=(TextView)findViewById(R.id.denglu_kuaisuzhuce);
	denglu_kuasuzhuce.setOnClickListener(onClickListener);
	denglu_username=(EditText)findViewById(R.id.denglu_username);
	denglu_password=(EditText)findViewById(R.id.denglu_password);
	denglu_denglu=(Button)findViewById(R.id.denglu_denglu);
	denglu_denglu.setOnClickListener(onClickListener);
}
public void tiaozhuandaozhuce(){
	Intent intent=new Intent(DengluActivity.this,ZhuceActivity.class);
startActivity(intent);
}
public boolean checkEdit() {
	if (denglu_username.getText().toString().trim().equals("")) {
		Toast.makeText(DengluActivity.this, "用户名不能为空", Toast.LENGTH_SHORT)
				.show();
	} else if (denglu_password.getText().toString().equals("")) {
		Toast.makeText(DengluActivity.this, "密码不能为空", Toast.LENGTH_SHORT)
				.show();
	} else {
		return true;
	}
	return false;
}
public void login(){
	denglu(denglu_username.getText().toString(),denglu_password.getText().toString());
	return;
}
String str;

public void denglu(final String username, final String password) {
	new Thread(new Runnable() {
		@Override
		public void run() {

			StringBuilder builder = new StringBuilder();
			try {
				String httpHost = "http://192.168.1.207/index.php/Home/Denglu/logina";// php接口
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
				Toast.makeText(DengluActivity.this, message,
						Toast.LENGTH_SHORT).show();// 密码错误，提示用户名和密码错误?
			} else if (status == 3) {
				Toast.makeText(DengluActivity.this, message,
						Toast.LENGTH_SHORT).show();// 当输入的用户名不存在时，提示用户不存在?
			}else if(status == 1){
				Toast.makeText(DengluActivity.this, message,
						Toast.LENGTH_SHORT).show();
			}

		} catch (JSONException e) {
			// TODO 自动生成�? catch �?
			e.printStackTrace();
		}

	}
};
}
