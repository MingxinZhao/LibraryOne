package helloworld.hello.com.libraryone.Utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class SaveImageUtils {
    /** 首先默认个文件保存路径 */
    private static final String SAVE_PIC_PATH= Environment.getExternalStorageState().equalsIgnoreCase(Environment.MEDIA_MOUNTED) ? Environment.getExternalStorageDirectory().getAbsolutePath() : "/mnt/sdcard";//保存到SD卡
    private static final String SAVE_REAL_PATH = SAVE_PIC_PATH+ "/doket/image";//保存的确切位置
    public static String path;
    public static void saveFile(Context context,Bitmap bm, String fileName) throws IOException {
        String subForder = SAVE_REAL_PATH;
        File foder = new File(subForder);
        if (!foder.exists()) {
            foder.mkdirs();
        }
        File myCaptureFile = new File(subForder, fileName);
//        if (!myCaptureFile.exists()) {
//            myCaptureFile.createNewFile();
//        }
        if(!myCaptureFile.createNewFile()) {
        }
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(myCaptureFile));
        bm.compress(Bitmap.CompressFormat.JPEG, 80, bos);
        bos.flush();
        bos.close();
        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        Uri uri = Uri.fromFile(myCaptureFile);
        path =uri.toString();
        intent.setData(uri);
        context.sendBroadcast(intent);//这个广播的目的就是更新图库，file:///storage/emulated/0/ruyuan/image/1474947600038.jpg   /storage/emulated/0/MagazineUnlock/Balance(magazine)-01-2.3.005-bigpicture_01_3.jpg
    }
}
