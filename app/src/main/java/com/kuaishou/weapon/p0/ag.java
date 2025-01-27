package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Proxy;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ag {

    /* renamed from: a */
    private static final String f9055a = "YW5kcm9pZC5hcHAuQWN0aXZpdHlUaHJlYWQ=";

    /* renamed from: b */
    private final String f9056b = "YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2Vy";

    /* renamed from: c */
    private final String f9057c = "YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2VyTmF0aXZl";

    /* renamed from: d */
    private final String f9058d = "YW5kcm9pZC5hcHAuQWN0aXZpdHlUYXNrTWFuYWdlcg==";

    /* renamed from: e */
    private final String f9059e = "SUFjdGl2aXR5VGFza01hbmFnZXJTaW5nbGV0b24=";

    private void a(JSONObject jSONObject, int i2) {
        Object a2;
        try {
            Object a3 = Build.VERSION.SDK_INT >= 26 ? dg.a(new String(c.a("YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2Vy".getBytes(), 2)), "IActivityManagerSingleton") : dg.a(new String(c.a("YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2VyTmF0aXZl".getBytes(), 2)), "gDefault");
            if (a3 == null || (a2 = dg.a("android.util.Singleton", a3, MonitorConstants.CONNECT_TYPE_GET, new Object[0])) == null) {
                return;
            }
            a(a2, jSONObject, i2);
        } catch (Exception unused) {
        }
    }

    private boolean a(Object obj, JSONObject jSONObject, int i2) {
        StringBuilder sb;
        if (jSONObject != null) {
            try {
                boolean isProxyClass = Proxy.isProxyClass(obj.getClass());
                String name = obj.getClass().getName();
                int i3 = 1;
                if (!isProxyClass) {
                    if (i2 == 3 && !name.contains("Instrumentation")) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(i2);
                        String sb3 = sb2.toString();
                        if (!isProxyClass) {
                            i3 = 0;
                        }
                        jSONObject.put(sb3, i3);
                        sb = new StringBuilder();
                        sb.append(i2);
                        sb.append("-c");
                    }
                    return isProxyClass;
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append(i2);
                String sb5 = sb4.toString();
                if (!isProxyClass) {
                    i3 = 0;
                }
                jSONObject.put(sb5, i3);
                sb = new StringBuilder();
                sb.append(i2);
                sb.append("-c");
                jSONObject.put(sb.toString(), name);
                return isProxyClass;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private void b(JSONObject jSONObject, int i2) {
        try {
            Object a2 = dg.a(new String(c.a(f9055a.getBytes(), 2)), (Object) null, "getPackageManager", new Object[0]);
            if (a2 != null) {
                a(a2, jSONObject, i2);
            }
        } catch (Exception unused) {
        }
    }

    private void c(JSONObject jSONObject, int i2) {
        Object a2;
        Object a3;
        try {
            if (Build.VERSION.SDK_INT < 29 || (a2 = dg.a(new String(c.a("YW5kcm9pZC5hcHAuQWN0aXZpdHlUYXNrTWFuYWdlcg==".getBytes(), 2)), new String(c.a("SUFjdGl2aXR5VGFza01hbmFnZXJTaW5nbGV0b24=".getBytes(), 2)))) == null || (a3 = dg.a("android.util.Singleton", a2, MonitorConstants.CONNECT_TYPE_GET, new Object[0])) == null) {
                return;
            }
            a(a3, jSONObject, i2);
        } catch (Exception unused) {
        }
    }

    private void d(JSONObject jSONObject, int i2) {
        Object a2;
        try {
            Object a3 = dg.a(new String(c.a(f9055a.getBytes(), 2)), (Object) null, "currentActivityThread", new Object[0]);
            if (a3 == null || (a2 = dg.a(a3.getClass(), a3, "mInstrumentation")) == null) {
                return;
            }
            a(a2, jSONObject, i2);
        } catch (Exception unused) {
        }
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            b(jSONObject, 0);
            a(jSONObject, 1);
            c(jSONObject, 2);
            d(jSONObject, 3);
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            PackageManager packageManager = context.getPackageManager();
            Object a2 = dg.a(packageManager.getClass(), packageManager, "mPM");
            if (a2 == null) {
                return null;
            }
            if (a(a2, jSONObject, 0)) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
