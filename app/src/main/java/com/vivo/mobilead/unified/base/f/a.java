package com.vivo.mobilead.unified.base.f;

import android.text.TextUtils;
import android.util.SparseArray;
import com.martian.rpauth.MartianRPUserManager;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private static SparseArray<String> f29753a = new SparseArray<>();

    public static int a(int i2) {
        try {
            return Integer.parseInt("60" + i2);
        } catch (Exception unused) {
            return i2;
        }
    }

    public static int b(int i2) {
        try {
            return Integer.parseInt("70" + i2);
        } catch (Exception unused) {
            return i2;
        }
    }

    public static int c(int i2) {
        try {
            return Integer.parseInt("50" + i2);
        } catch (Exception unused) {
            return i2;
        }
    }

    public static int d(int i2) {
        try {
            return Integer.parseInt("401" + i2);
        } catch (Exception unused) {
            return i2;
        }
    }

    public static String e(int i2) {
        if (f29753a.size() == 0) {
            a();
        }
        String str = f29753a.get(i2);
        return TextUtils.isEmpty(str) ? "没有广告数据，建议稍后重试" : str;
    }

    public static int f(int i2) {
        try {
            return Integer.parseInt("4022" + i2);
        } catch (Exception unused) {
            return i2;
        }
    }

    public static String a(int i2, String str) {
        if (f29753a.size() == 0) {
            a();
        }
        String str2 = f29753a.get(i2);
        return TextUtils.isEmpty(str2) ? str : str2;
    }

    private static void a() {
        f29753a.put(2, "请检查下广告位id是否存在");
        f29753a.put(4, "广告请求成功，但可能无广告填充，建议多刷几次");
        f29753a.put(5, "广告请求出现异常，建议重试几遍");
        f29753a.put(MartianRPUserManager.f14923j, "媒体id无效");
        f29753a.put(20002, "媒体包名和注册包名不一致");
        f29753a.put(20003, "广告位id和广告类型不匹配");
        f29753a.put(20005, "设备厂商不支持，请检查手机厂商");
        f29753a.put(20006, "请求过多，请限制每天的请求量");
        f29753a.put(20007, "请检查是否有获取imei权限，没有此权限，无法获取广告");
    }
}
