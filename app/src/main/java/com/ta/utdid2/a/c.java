package com.ta.utdid2.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import b.i.a.a.a.d;
import b.i.a.a.a.h;
import b.i.a.a.a.i;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private static final String f24545a = "com.ta.utdid2.a.c";

    /* renamed from: b */
    private static Map<String, String> f24546b = new ConcurrentHashMap();

    /* renamed from: c */
    private static Map<String, Long> f24547c = new ConcurrentHashMap();

    public static long a(Context context, String str, String str2) {
        if (context == null) {
            Log.e(f24545a, "no context!");
            return 0L;
        }
        String d2 = d(str, str2);
        Long valueOf = Long.valueOf(f24547c.containsKey(d2) ? f24547c.get(d2).longValue() : 0L);
        if (d.f5072a) {
            Log.d(f24545a, "cache AIDGenTime:" + valueOf);
        }
        if (valueOf.longValue() == 0) {
            valueOf = Long.valueOf(context.getSharedPreferences("OfJbkLdFbPOMbGyP", 0).getLong("rKrMJgyAEbVtSQGi".concat(d2), 0L));
            f24547c.put(d2, valueOf);
        }
        return valueOf.longValue();
    }

    public static String b(Context context, String str, String str2) {
        if (context == null) {
            Log.e(f24545a, "no context!");
            return "";
        }
        String d2 = d(str, str2);
        String str3 = f24546b.get(d2);
        if (d.f5072a) {
            Log.d(f24545a, "cache AID:" + str3);
        }
        if (!i.b(str3)) {
            return str3;
        }
        String string = context.getSharedPreferences("OfJbkLdFbPOMbGyP", 0).getString("EvQwnbilKezpOJey".concat(d2), "");
        f24546b.put(d2, string);
        return string;
    }

    public static void c(Context context, String str, String str2, String str3) {
        if (context == null) {
            Log.e(f24545a, "no context!");
            return;
        }
        String d2 = d(str, str3);
        long currentTimeMillis = System.currentTimeMillis();
        f24546b.put(d2, str2);
        f24547c.put(d2, Long.valueOf(currentTimeMillis));
        SharedPreferences sharedPreferences = context.getSharedPreferences("OfJbkLdFbPOMbGyP", 0);
        if (Build.VERSION.SDK_INT >= 9) {
            h.a(sharedPreferences.edit().putString("EvQwnbilKezpOJey".concat(d2), str2));
            h.a(sharedPreferences.edit().putLong("rKrMJgyAEbVtSQGi".concat(d2), currentTimeMillis));
        } else {
            sharedPreferences.edit().putString("EvQwnbilKezpOJey".concat(d2), str2).commit();
            sharedPreferences.edit().putLong("rKrMJgyAEbVtSQGi".concat(d2), currentTimeMillis).commit();
        }
    }

    private static String d(String str, String str2) {
        String a2 = Build.VERSION.SDK_INT >= 8 ? b.i.a.a.a.c.a(str.concat(str2).getBytes(), 2) : b.i.a.a.a.b.f(str.concat(str2).getBytes(), 2);
        if (d.f5072a) {
            Log.d(f24545a, "encodedName:" + a2);
        }
        return a2;
    }
}
