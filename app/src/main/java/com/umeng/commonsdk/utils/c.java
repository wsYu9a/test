package com.umeng.commonsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private static final String f26483a = "um_slmode_sp";

    /* renamed from: b */
    private static final String f26484b = "lastReqTime";

    /* renamed from: c */
    private static final int f26485c = 48;

    /* renamed from: d */
    private static final int f26486d = 1;

    /* renamed from: e */
    private static final int f26487e = 720;

    /* renamed from: f */
    private static final String f26488f = "iss";

    /* renamed from: g */
    private static final String f26489g = "sinr";

    /* renamed from: h */
    private static final String f26490h = "clean";

    /* renamed from: i */
    private static boolean f26491i = false;

    /* renamed from: j */
    private static int f26492j = 720;
    private static Object k = new Object();

    static {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(appContext, f26488f, "");
            if (TextUtils.isEmpty(imprintProperty) || !"1".equals(imprintProperty)) {
                return;
            }
            synchronized (k) {
                f26491i = true;
            }
            String imprintProperty2 = UMEnvelopeBuild.imprintProperty(appContext, f26489g, "");
            if (TextUtils.isEmpty(imprintProperty)) {
                f26492j = 48;
                return;
            }
            try {
                f26492j = a(Integer.parseInt(imprintProperty2));
            } catch (Throwable unused) {
                f26492j = 48;
            }
        }
    }

    private static int a(int i2) {
        if (i2 > f26487e) {
            return f26487e;
        }
        if (i2 < 1) {
            return 1;
        }
        return i2;
    }

    public static boolean a() {
        boolean z;
        synchronized (k) {
            z = f26491i;
        }
        return z;
    }

    public static long b(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f26483a, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getLong(f26484b, 0L);
        }
        return 0L;
    }

    public static void c(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f26483a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(f26490h, true).commit();
        }
    }

    public static void d(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f26483a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(f26490h, false).commit();
        }
    }

    public static boolean e(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f26483a, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(f26490h, false);
        }
        return false;
    }

    public static int a(Context context) {
        int i2;
        synchronized (k) {
            i2 = f26492j;
        }
        return i2;
    }

    public static boolean a(long j2, long j3, int i2) {
        Date date = new Date(j3);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j2));
        calendar.add(10, i2);
        return date.after(calendar.getTime());
    }

    public static void a(Context context, long j2) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f26483a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(f26484b, j2).commit();
        }
    }
}
