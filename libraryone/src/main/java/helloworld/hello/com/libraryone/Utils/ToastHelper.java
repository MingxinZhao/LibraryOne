package helloworld.hello.com.libraryone.Utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Toast工具类
 * @author oceangray
 *
 */
public class ToastHelper {
	public static  void longShow(Context context, String content){
		Toast.makeText(context, content, Toast.LENGTH_LONG).show();;
	}
	public static void shortShow(Context context, String content){
		Toast.makeText(context, content, Toast.LENGTH_SHORT).show();;
	}
	public static void shortShow(Context context, int resId){
		Toast.makeText(context, context.getResources().getString(resId), Toast.LENGTH_SHORT).show();
	}
	public static void shortShow(Context context, String content, boolean isShow){
		if(isShow){
			Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
		}
	}
	static Toast toast;
	public static void showToast(Context context, String msg){
		if(toast == null){
			toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
		}
		toast.setText(msg);
		toast.show();
	}


}
