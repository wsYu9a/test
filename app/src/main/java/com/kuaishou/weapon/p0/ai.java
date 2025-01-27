package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ai {

    /* renamed from: b */
    private static final String[] f9060b = {"/data/local/", "/data/local/bin/", "/data/local/xbin/", "/sbin/", "/su/bin/", "/system/bin/", "/system/bin/.ext/", "/system/bin/failsafe/", "/system/sd/xbin/", "/system/usr/we-need-root/", "/system/xbin/", "/cache/", "/data/", "/dev/"};

    /* renamed from: a */
    private Context f9061a;

    public ai(Context context) {
        this.f9061a = context;
    }

    private String[] a(String[] strArr) {
        String str;
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        try {
            str = System.getenv("PATH");
        } catch (Exception unused) {
        }
        if (str != null && !"".equals(str)) {
            String[] split = str.split(":");
            int length = split.length;
            for (int i2 = 0; i2 < length; i2++) {
                String str2 = split[i2];
                if (!str2.endsWith("/")) {
                    str2 = str2 + '/';
                }
                if (!arrayList.contains(str2)) {
                    arrayList.add(str2);
                }
            }
            return (String[]) arrayList.toArray(new String[0]);
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static boolean b() {
        String a2;
        try {
            a2 = bg.a("ro.build.display.id");
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        if (a2.contains("flyme")) {
            return true;
        }
        return a2.toLowerCase().contains("flyme");
    }

    public int a() {
        boolean z;
        try {
            String[] a2 = a(bh.z);
            int length = a2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = false;
                    break;
                }
                if (new File(a2[i2], bh.y).exists()) {
                    z = true;
                    break;
                }
                i2++;
            }
        } catch (Exception unused) {
        }
        return z ? 1 : 0;
    }

    public String a(String str) {
        try {
            return aa.a().b(str).replace("\n", "");
        } catch (Exception unused) {
            return "";
        }
    }

    public String c() {
        try {
            if (Build.VERSION.SDK_INT > 29) {
                return null;
            }
            return aa.a().b("su -v").replace("\n", "");
        } catch (Exception unused) {
            return null;
        }
    }

    public int d() {
        String a2 = aa.a().a("ro.secure");
        return (a2 == null || !"0".equals(a2)) ? 1 : 0;
    }

    public int e() {
        String a2 = aa.a().a("ro.debuggable");
        return (a2 == null || !"0".equals(a2)) ? 1 : 0;
    }

    public int f() {
        String a2 = aa.a().a("ro.adb.secure");
        return (a2 == null || !"0".equals(a2)) ? 1 : 0;
    }

    public JSONObject g() {
        try {
            JSONObject jSONObject = new JSONObject();
            String a2 = a(" which su ");
            if (TextUtils.isEmpty(a2) || a2.length() <= 2) {
                jSONObject.put("0", 0);
            } else {
                jSONObject.put("0", 1);
                jSONObject.put("0-p", a2);
            }
            String a3 = a(" id ");
            if (!TextUtils.isEmpty(a3)) {
                if (a3.toLowerCase().contains("uid=0")) {
                    jSONObject.put("1", 1);
                } else {
                    jSONObject.put("1", 0);
                }
            }
            String a4 = a(" busybox df ");
            if (!TextUtils.isEmpty(a4) && !a4.contains("not found")) {
                if (a4.length() > 30) {
                    jSONObject.put("2", 1);
                } else {
                    jSONObject.put("2", 0);
                }
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public int h() {
        return new File("/system/app/Superuser.apk").exists() ? 1 : 0;
    }

    public String i() {
        for (String str : f9060b) {
            if (new File(str, "magisk").exists()) {
                return str + "magisk";
            }
        }
        return "";
    }

    public String j() {
        for (String str : f9060b) {
            if (new File(str, bh.y).exists()) {
                return str + bh.y;
            }
        }
        return "";
    }

    public String k() {
        try {
            throw new Exception("");
        } catch (Exception e2) {
            for (StackTraceElement stackTraceElement : e2.getStackTrace()) {
                if (stackTraceElement.getClassName().equals("com.android.internal.os.ZygoteInit") || stackTraceElement.getMethodName().equals("invoked") || stackTraceElement.getMethodName().equals("main") || stackTraceElement.getMethodName().equals("handleHookedMethod")) {
                    return stackTraceElement.getClassName();
                }
            }
            return "";
        }
    }
}
