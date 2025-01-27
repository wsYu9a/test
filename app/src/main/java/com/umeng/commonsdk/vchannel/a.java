package com.umeng.commonsdk.vchannel;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    public static String f24870a = "https://pslog.umeng.com";

    /* renamed from: b */
    public static String f24871b = "https://pslog.umeng.com/";

    /* renamed from: c */
    public static String f24872c = "explog";

    /* renamed from: d */
    public static final String f24873d = "analytics";

    /* renamed from: e */
    public static final String f24874e = "ekv";

    /* renamed from: f */
    public static final String f24875f = "id";

    /* renamed from: g */
    public static final String f24876g = "ts";

    /* renamed from: h */
    public static final String f24877h = "ds";

    /* renamed from: i */
    public static final String f24878i = "pn";

    /* renamed from: j */
    public static String f24879j = "";

    static {
        String str = "SUB" + System.currentTimeMillis();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(String.format("%0" + (32 - str.length()) + "d", 0));
        f24879j = sb2.toString();
    }
}
