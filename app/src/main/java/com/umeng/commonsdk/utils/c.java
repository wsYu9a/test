package com.umeng.commonsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.bd;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: b */
    private static final String f24823b = "lastReqTime";

    /* renamed from: c */
    private static final int f24824c = 48;

    /* renamed from: d */
    private static final int f24825d = 1;

    /* renamed from: e */
    private static final int f24826e = 720;

    /* renamed from: f */
    private static final String f24827f = "iss";

    /* renamed from: g */
    private static final String f24828g = "sinr";

    /* renamed from: h */
    private static final String f24829h = "clean";

    /* renamed from: i */
    private static boolean f24830i;

    /* renamed from: j */
    private static int f24831j;

    /* renamed from: a */
    private static final String f24822a = bd.b().b(bd.f23546z);

    /* renamed from: k */
    private static Object f24832k = new Object();

    static {
        f24830i = false;
        f24831j = f24826e;
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(appContext, f24827f, "");
            if (TextUtils.isEmpty(imprintProperty) || !"1".equals(imprintProperty)) {
                return;
            }
            synchronized (f24832k) {
                f24830i = true;
            }
            String imprintProperty2 = UMEnvelopeBuild.imprintProperty(appContext, f24828g, "");
            if (TextUtils.isEmpty(imprintProperty)) {
                f24831j = 48;
                return;
            }
            try {
                f24831j = a(Integer.parseInt(imprintProperty2));
            } catch (Throwable unused) {
                f24831j = 48;
            }
        }
    }

    private static int a(int i10) {
        if (i10 > f24826e) {
            return f24826e;
        }
        if (i10 < 1) {
            return 1;
        }
        return i10;
    }

    public static long b(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f24822a, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getLong(f24823b, 0L);
        }
        return 0L;
    }

    public static void c(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f24822a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(f24829h, true).commit();
        }
    }

    public static void d(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f24822a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(f24829h, false).commit();
        }
    }

    public static boolean e(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f24822a, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(f24829h, false);
        }
        return false;
    }

    public static boolean a() {
        boolean z10;
        synchronized (f24832k) {
            z10 = f24830i;
        }
        return z10;
    }

    public static int a(Context context) {
        int i10;
        synchronized (f24832k) {
            i10 = f24831j;
        }
        return i10;
    }

    public static boolean a(long j10, long j11, int i10) {
        Date date = new Date(j11);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j10));
        calendar.add(10, i10);
        return date.after(calendar.getTime());
    }

    public static void a(Context context, long j10) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f24822a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(f24823b, j10).commit();
        }
    }
}
