package com.example.servicedemo;

import java.util.Calendar;

import android.R.integer;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.text.format.Time;
import android.util.Log;

public class MyService extends Service{

	private static final String TAG = "MyService";

	private IBinder mBinder = new MyBinder();

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub

		Log.e(TAG, "start IBinder~~~");
		return mBinder;
	}

	@Override
	public void onCreate(){
		Log.e(TAG,"start onCreate~~~");
		super.onCreate();
	}

	@Override
	public void onStart(Intent intent, int startId){
		Log.e(TAG,"start onStart~~~");
		super.onStart(intent, startId);
	}

	@Override  
	public void onDestroy() {  
		Log.e(TAG, "start onDestroy~~~");  
		super.onDestroy();  
	}  


	@Override  
	public boolean onUnbind(Intent intent) {  
		Log.e(TAG, "start onUnbind~~~");  
		return super.onUnbind(intent);  
	}  

	//这里我写了一个获取当前时间的函数，不过没有格式化就先这么着吧  
	public String getSystemTime(){  
		long time = System.currentTimeMillis();
		final Calendar mCalendar = Calendar.getInstance();
		mCalendar.setTimeInMillis(time);
		int hour = mCalendar.get(Calendar.HOUR);
		int minuts = mCalendar.get(Calendar.MINUTE);
		int second = mCalendar.get(Calendar.SECOND);
		int millisec = mCalendar.get(Calendar.MILLISECOND);  

		String accValue;
		accValue = String.valueOf(hour)+":"+String.valueOf(minuts)+":"+String.valueOf(second)
				+"."+String.valueOf(millisec);

		return accValue;  
	}  

	public class MyBinder extends Binder{  
		MyService getService()  
		{  
			return MyService.this;  
		}  
	}  


}
