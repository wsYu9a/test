package b.h.a.e;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.view.View;
import java.io.File;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public final class c {
    public static long a(File file) {
        if (file == null) {
            return -1L;
        }
        return file.getUsableSpace();
    }

    public static Bitmap b(Activity activity) {
        Bitmap bitmap;
        View rootView = activity.getWindow().getDecorView().getRootView();
        try {
            Method declaredMethod = View.class.getDeclaredMethod("createSnapshot", Bitmap.Config.class, Integer.TYPE, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            bitmap = (Bitmap) declaredMethod.invoke(rootView, Bitmap.Config.RGB_565, -1, Boolean.FALSE);
        } catch (Throwable th) {
            if (b.h.a.c.j()) {
                th.printStackTrace();
            }
            bitmap = null;
        }
        if (bitmap != null) {
            return bitmap;
        }
        try {
            rootView.setDrawingCacheEnabled(true);
            rootView.buildDrawingCache(true);
            bitmap = Bitmap.createBitmap(rootView.getDrawingCache());
            rootView.setDrawingCacheEnabled(false);
            return bitmap;
        } catch (Throwable th2) {
            if (!b.h.a.c.j()) {
                return bitmap;
            }
            th2.printStackTrace();
            return bitmap;
        }
    }

    public static String c() {
        return d(b.a());
    }

    private static String d(Context context) {
        NetworkInfo activeNetworkInfo;
        String str;
        StringBuilder sb = new StringBuilder();
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable th) {
            if (b.h.a.c.j()) {
                th.printStackTrace();
            }
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == 1) {
                sb.append(com.alipay.mobilesecuritysdk.constant.a.I);
                return sb.toString();
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            sb.append(telephonyManager.getNetworkOperatorName());
            sb.append("_");
            int networkType = telephonyManager.getNetworkType();
            switch (networkType) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    str = "2G";
                    sb.append(str);
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    str = "3G";
                    sb.append(str);
                    break;
                case 13:
                    str = "4G";
                    sb.append(str);
                    break;
                default:
                    sb.append("unknown:");
                    sb.append(networkType);
                    break;
            }
            return sb.toString();
        }
        sb.append("disconnected");
        return sb.toString();
    }

    public static boolean e() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) b.a().getSystemService("connectivity");
            if (connectivityManager != null) {
                if (NetworkInfo.State.CONNECTED == connectivityManager.getNetworkInfo(1).getState()) {
                    return true;
                }
            }
        } catch (Throwable th) {
            if (b.h.a.c.j()) {
                th.printStackTrace();
            }
        }
        return false;
    }
}
