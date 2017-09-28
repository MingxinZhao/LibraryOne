package helloworld.hello.com.libraryone.Utils;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;

/**
 */

public class VersionUtils {
    public static int getCurrentVersionCode(Context context){
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }
    public static String getCurrentVersionName(Context context){
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return "δ??????汾????";
        }
    }
}
