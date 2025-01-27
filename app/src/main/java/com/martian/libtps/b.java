package com.martian.libtps;

import android.content.Context;
import com.umeng.analytics.MobclickAgent;
import java.util.HashMap;

/* loaded from: classes.dex */
public class b {
    protected static String a(String versionName) {
        int indexOf = versionName.indexOf(".");
        if (indexOf == -1) {
            return versionName + "x";
        }
        return versionName.substring(0, indexOf) + "x";
    }

    protected static HashMap<String, String> b(String from, String value) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(from, value);
        return hashMap;
    }

    protected static HashMap<String, String> c(String versionName, String from) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(a(versionName), from);
        return hashMap;
    }

    public static void d(Context context, String key) {
        MobclickAgent.onEvent(context, key);
    }

    public static void e(Context context, String key, String value) {
        MobclickAgent.onEvent(context, key, value);
    }

    public static void f(Context context, String key, String from, String value) {
        MobclickAgent.onEvent(context, key, b(from, value));
    }

    public static void g(Context ctx, int versionCode) {
        MobclickAgent.onEvent(ctx.getApplicationContext(), "versionCode", "" + versionCode);
    }

    public static void h(Context context, String key, String versionName, String value) {
        MobclickAgent.onEvent(context, key, c(versionName, value));
    }

    public static void i(Context context, String key, String versionName, String value, int duration) {
        MobclickAgent.onEventValue(context, key, c(versionName, value), duration);
    }
}
