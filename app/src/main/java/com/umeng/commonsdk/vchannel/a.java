package com.umeng.commonsdk.vchannel;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    public static String f26504a = "https://pslog.umeng.com";

    /* renamed from: b */
    public static String f26505b = "https://pslog.umeng.com/";

    /* renamed from: c */
    public static String f26506c = "explog";

    /* renamed from: d */
    public static final String f26507d = "analytics";

    /* renamed from: e */
    public static final String f26508e = "ekv";

    /* renamed from: f */
    public static final String f26509f = "id";

    /* renamed from: g */
    public static final String f26510g = "ts";

    /* renamed from: h */
    public static final String f26511h = "ds";

    /* renamed from: i */
    public static final String f26512i = "pn";

    /* renamed from: j */
    public static String f26513j = "";

    static {
        String str = "SUB" + System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(String.format("%0" + (32 - str.length()) + "d", 0));
        f26513j = sb.toString();
    }
}
