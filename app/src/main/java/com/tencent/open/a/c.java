package com.tencent.open.a;

import com.baidu.mobads.sdk.internal.bj;
import java.io.File;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    public static int f25417a = 62;

    /* renamed from: b */
    public static int f25418b = 60;

    /* renamed from: c */
    public static String f25419c = "OpenSDK.Client.File.Tracer";

    /* renamed from: d */
    public static String f25420d;

    /* renamed from: e */
    public static String f25421e;

    /* renamed from: f */
    public static long f25422f;

    /* renamed from: g */
    public static int f25423g;

    /* renamed from: h */
    public static int f25424h;

    /* renamed from: i */
    public static int f25425i;

    /* renamed from: j */
    public static String f25426j;
    public static String k;
    public static String l;
    public static int m;
    public static long n;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("Tencent");
        String str = File.separator;
        sb.append(str);
        sb.append("msflogs");
        sb.append(str);
        sb.append("com");
        sb.append(str);
        sb.append("tencent");
        sb.append(str);
        sb.append("mobileqq");
        sb.append(str);
        f25420d = sb.toString();
        f25421e = ".log";
        f25422f = 8388608L;
        f25423g = 262144;
        f25424h = 1024;
        f25425i = 10000;
        f25426j = "debug.file.blockcount";
        k = "debug.file.keepperiod";
        l = "debug.file.tracelevel";
        m = 24;
        n = bj.f5599d;
    }
}
