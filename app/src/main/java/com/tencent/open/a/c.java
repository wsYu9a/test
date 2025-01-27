package com.tencent.open.a;

import com.baidu.mobads.sdk.internal.bm;
import java.io.File;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    public static int f23146a = 62;

    /* renamed from: b */
    public static int f23147b = 60;

    /* renamed from: c */
    public static String f23148c = "OpenSDK.Client.File.Tracer";

    /* renamed from: d */
    public static String f23149d;

    /* renamed from: e */
    public static String f23150e;

    /* renamed from: f */
    public static long f23151f;

    /* renamed from: g */
    public static int f23152g;

    /* renamed from: h */
    public static int f23153h;

    /* renamed from: i */
    public static int f23154i;

    /* renamed from: j */
    public static String f23155j;

    /* renamed from: k */
    public static String f23156k;

    /* renamed from: l */
    public static String f23157l;

    /* renamed from: m */
    public static int f23158m;

    /* renamed from: n */
    public static long f23159n;

    static {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Tencent");
        String str = File.separator;
        sb2.append(str);
        sb2.append("msflogs");
        sb2.append(str);
        sb2.append("com");
        sb2.append(str);
        sb2.append("tencent");
        sb2.append(str);
        sb2.append("mobileqq");
        sb2.append(str);
        f23149d = sb2.toString();
        f23150e = ".log";
        f23151f = 8388608L;
        f23152g = 262144;
        f23153h = 1024;
        f23154i = 10000;
        f23155j = "debug.file.blockcount";
        f23156k = "debug.file.keepperiod";
        f23157l = "debug.file.tracelevel";
        f23158m = 24;
        f23159n = bm.f6899d;
    }
}
