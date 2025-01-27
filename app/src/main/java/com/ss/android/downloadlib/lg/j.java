package com.ss.android.downloadlib.lg;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes4.dex */
public class j {

    /* renamed from: com.ss.android.downloadlib.lg.j$1 */
    static class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.appdownloader.gv.q.lg();
            j.i();
        }
    }

    /* renamed from: com.ss.android.downloadlib.lg.j$j */
    private static class C0501j implements InvocationHandler {

        /* renamed from: j */
        private Object f24331j;

        /* synthetic */ C0501j(Object obj, AnonymousClass1 anonymousClass1) {
            this(obj);
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                if ("startActivity".contains(method.getName())) {
                    j.j(objArr);
                }
            } catch (Throwable unused) {
            }
            return method.invoke(this.f24331j, objArr);
        }

        private C0501j(Object obj) {
            this.f24331j = obj;
        }
    }

    public static void i() {
        try {
            Field declaredField = Build.VERSION.SDK_INT < 26 ? Class.forName("android.app.ActivityManagerNative").getDeclaredField("gDefault") : Class.forName("android.app.ActivityManager").getDeclaredField("IActivityManagerSingleton");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Field declaredField2 = Class.forName("android.util.Singleton").getDeclaredField("mInstance");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            if (obj2 == null) {
                return;
            }
            declaredField2.set(obj, Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{Class.forName("android.app.IActivityManager")}, new C0501j(obj2)));
        } catch (Throwable unused) {
        }
    }

    public static String j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.ss.android.j.i.j(new File(str));
    }

    public static String zx(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = com.ss.android.downloadlib.addownload.pa.getContext().getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return applicationInfo.sourceDir;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static int j(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return 5;
        }
        return com.ss.android.j.i.j(str, new File(str2));
    }

    public static void j() {
        if (com.ss.android.downloadlib.addownload.pa.k().optInt("hook", 0) != 1) {
            return;
        }
        com.ss.android.downloadlib.g.j().j(new Runnable() { // from class: com.ss.android.downloadlib.lg.j.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.gv.q.lg();
                j.i();
            }
        }, 10000L);
    }

    public static void j(Object[] objArr) {
        if (com.ss.android.downloadlib.addownload.pa.k().optInt("hook", 0) == 1 && (objArr[1] instanceof String) && (objArr[2] instanceof Intent)) {
            Intent intent = (Intent) objArr[2];
            if ("android.intent.action.VIEW".equals(intent.getAction()) && DownloadConstants.MIME_APK.equals(intent.getType())) {
                if (com.ss.android.socialbase.appdownloader.gv.q.i()) {
                    String optString = com.ss.android.downloadlib.addownload.pa.k().optString("hook_vivo_arg", "com.android.settings");
                    if ("null".equals(optString)) {
                        return;
                    }
                    objArr[1] = optString;
                    return;
                }
                if (com.ss.android.socialbase.appdownloader.gv.q.g()) {
                    String optString2 = com.ss.android.downloadlib.addownload.pa.k().optString("hook_kllk_arg1", "com." + DownloadConstants.LOWER_OPPO + ".market");
                    if (!"null".equals(optString2)) {
                        objArr[1] = optString2;
                    }
                    String optString3 = com.ss.android.downloadlib.addownload.pa.k().optString("hook_kllk_arg2", "com.android.browser");
                    String optString4 = com.ss.android.downloadlib.addownload.pa.k().optString("hook_kllk_arg3", "m.store." + DownloadConstants.LOWER_OPPO + "mobile.com");
                    StringBuilder sb = new StringBuilder();
                    sb.append(DownloadConstants.LOWER_OPPO);
                    sb.append("_extra_pkg_name");
                    intent.putExtra(sb.toString(), optString3);
                    intent.putExtra("refererHost", optString4);
                    if (com.ss.android.downloadlib.addownload.pa.k().optInt("hook_kllk_arg4", 0) == 1) {
                        Intent intent2 = new Intent();
                        intent2.putExtra(DownloadConstants.LOWER_OPPO + "_extra_pkg_name", optString3);
                        intent2.putExtra("refererHost", optString4);
                        intent.putExtra("android.intent.extra.INTENT", intent2);
                        return;
                    }
                    return;
                }
                if (com.ss.android.socialbase.appdownloader.gv.q.j()) {
                    String optString5 = com.ss.android.downloadlib.addownload.pa.k().optString("hook_huawei_arg1", "com.huawei.appmarket");
                    if (!"null".equals(optString5)) {
                        objArr[1] = optString5;
                    }
                    intent.putExtra("caller_package", com.ss.android.downloadlib.addownload.pa.k().optString("hook_huawei_arg2", "com.huawei.appmarket"));
                }
            }
        }
    }
}
