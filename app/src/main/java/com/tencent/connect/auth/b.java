package com.tencent.connect.auth;

import com.tencent.tauth.IUiListener;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    public static b f25268a = null;

    /* renamed from: d */
    static final /* synthetic */ boolean f25269d = true;

    /* renamed from: e */
    private static int f25270e;

    /* renamed from: b */
    public HashMap<String, a> f25271b = new HashMap<>();

    /* renamed from: c */
    public final String f25272c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static class a {

        /* renamed from: a */
        public IUiListener f25273a;

        /* renamed from: b */
        public com.tencent.connect.auth.a f25274b;

        /* renamed from: c */
        public String f25275c;
    }

    public static b a() {
        if (f25268a == null) {
            f25268a = new b();
        }
        return f25268a;
    }

    public static int b() {
        int i2 = f25270e + 1;
        f25270e = i2;
        return i2;
    }

    public String c() {
        int ceil = (int) Math.ceil((Math.random() * 20.0d) + 3.0d);
        char[] charArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        int length = charArray.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < ceil; i2++) {
            double random = Math.random();
            double d2 = length;
            Double.isNaN(d2);
            stringBuffer.append(charArray[(int) (random * d2)]);
        }
        return stringBuffer.toString();
    }

    public String a(a aVar) {
        int b2 = b();
        try {
            this.f25271b.put("" + b2, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "" + b2;
    }
}
