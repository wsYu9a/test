package cn.vlion.ad.inland.base;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.martian.libmars.activity.BaseActivity;

/* loaded from: classes.dex */
public final class u0 {
    public static String a(Context context) {
        String str = "";
        if (context != null) {
            try {
                str = !TextUtils.isEmpty(context.getPackageName()) ? context.getPackageName() : context.getApplicationInfo().packageName;
            } catch (Throwable th2) {
                LogVlion.e("getAppNameError: app name Throwable：" + th2);
                VlionSDkManager.getInstance().upLoadCatchException(th2);
                return str;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", null).invoke(cls, null);
            return ((Context) invoke.getClass().getMethod("getApplication", null).invoke(invoke, null)).getPackageName();
        } catch (ClassNotFoundException | NoSuchMethodException e10) {
            VlionSDkManager.getInstance().upLoadCatchException(e10);
            return str;
        }
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Throwable th2) {
            LogVlion.e("isApkInDebug:Throwable：" + th2);
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return false;
        }
    }

    public static void a(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            activity.getWindow().getDecorView().setSystemUiVisibility(BaseActivity.f12020n);
        } catch (Throwable th2) {
            LogVlion.e("hideNavigationBar:Throwable：" + th2);
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
