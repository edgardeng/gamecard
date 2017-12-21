package com.lordcard.ui;

import com.edgardeng.gamecard.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;

public class CGChargeActivity extends Activity{
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.w("CGChargeActivity","onCreate");

		if(isYd(this)) // 移动计费
		{
			Log.w("CGChargeActivity","移动计费");
//			Intent intent = new Intent();
//			intent.setClass(CGChargeActivity.this, cn.cmgame.billing.api.GameOpenActivity.class);
//			intent.setClassName(this,"cn.cmgame.billing.ui.GameOpenActivit");
//			startActivity(intent);
//			finish();
		}else
		{
			Log.w("CGChargeActivity","非移动计费");
			Intent intent2=new Intent();
			try {
				int id = getId(this, "string", "g_class_name");
				String name = getString(id);
				Log.w("CGChargeActivity",name);
				intent2.setClass(CGChargeActivity.this, Class.forName(name));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} 
			startActivity(intent2);
			finish();
		}
	}
	private int getId(Context context,String className,String name){
		Resources res=context.getResources();
		return res.getIdentifier(name,className,context.getPackageName());
	}
	/**
	 * 是否是移动计费
	 * @param context
	 * @return
	 */
	public static boolean isYd(Context context)
	{
		String yd = context.getString(R.string.sms_type_yd);
		String sms_type = context.getString(R.string.sms_type);
		return yd != null && sms_type != null && yd.equals(sms_type);
	}
}
