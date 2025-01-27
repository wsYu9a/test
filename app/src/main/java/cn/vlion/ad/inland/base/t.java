package cn.vlion.ad.inland.base;

import android.content.Context;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.io.File;

/* loaded from: classes.dex */
public final class t {
    public static String a(Context context) {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(context.getExternalFilesDir(null));
            String str = File.separator;
            sb2.append(str);
            sb2.append("vlioncustom");
            sb2.append(str);
            sb2.append("apk");
            sb2.append(str);
            String sb3 = sb2.toString();
            File file = new File(sb3);
            if (!file.exists()) {
                LogVlion.e("getDownApkPath mkdirs is" + file.mkdirs());
            }
            return sb3;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return "";
        }
    }

    public static String b(Context context) {
        String str = "";
        try {
            str = d(context) + "natives" + File.separator;
            File file = new File(str);
            LogVlion.e("getDownNativesVideoPath folderDir.exists() is" + file.exists());
            if (!file.exists()) {
                LogVlion.e("getDownNativesVideoPath mkdirs is" + file.mkdirs());
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        return str;
    }

    public static String c(Context context) {
        String str = "";
        try {
            str = d(context) + "video" + File.separator;
            File file = new File(str);
            LogVlion.e("getDownVideoPath folderDir.exists() is" + file.exists());
            if (!file.exists()) {
                LogVlion.e("getDownVideoPath mkdirs is" + file.mkdirs());
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        return str;
    }

    public static String d(Context context) {
        if (context != null) {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(context.getCacheDir());
                String str = File.separator;
                sb2.append(str);
                sb2.append("vlioncustom");
                sb2.append(str);
                String sb3 = sb2.toString();
                File file = new File(sb3);
                if (!file.exists()) {
                    LogVlion.e("getPath mkdirs is" + file.mkdirs());
                }
                return sb3;
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
        return "";
    }

    public static void a(String str) {
        String[] list;
        File file;
        try {
            LogVlion.e("deleteAllDirectory=" + str);
            File file2 = new File(str);
            if (file2.exists() && file2.isDirectory() && (list = file2.list()) != null) {
                LogVlion.e("tempList=" + list.length);
                for (int i10 = 0; i10 < list.length; i10++) {
                    String str2 = File.separator;
                    if (str.endsWith(str2)) {
                        LogVlion.e("path + tempList[i]=" + str + list[i10]);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append(list[i10]);
                        file = new File(sb2.toString());
                    } else {
                        LogVlion.e("path + tempList[i]=" + str + str2 + list[i10]);
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str);
                        sb3.append(str2);
                        sb3.append(list[i10]);
                        file = new File(sb3.toString());
                    }
                    if (file.isFile() && file.exists()) {
                        LogVlion.e("isDelete=" + file.delete());
                    }
                    if (file.isDirectory()) {
                        a(str + "/" + list[i10]);
                        String str3 = str + "/" + list[i10];
                        try {
                            a(str3);
                            new File(str3).delete();
                        } catch (Throwable th2) {
                            VlionSDkManager.getInstance().upLoadCatchException(th2);
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }
}
