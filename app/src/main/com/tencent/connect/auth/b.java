package com.tencent.connect.auth;

import com.tencent.tauth.IUiListener;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    public static b f22992a = null;

    /* renamed from: d */
    static final /* synthetic */ boolean f22993d = true;

    /* renamed from: e */
    private static int f22994e;

    /* renamed from: b */
    public HashMap<String, a> f22995b = new HashMap<>();

    /* renamed from: c */
    public final String f22996c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static class a {

        /* renamed from: a */
        public IUiListener f22997a;

        /* renamed from: b */
        public com.tencent.connect.auth.a f22998b;

        /* renamed from: c */
        public String f22999c;
    }

    public static b a() {
        if (f22992a == null) {
            f22992a = new b();
        }
        return f22992a;
    }

    public static int b() {
        int i10 = f22994e + 1;
        f22994e = i10;
        return i10;
    }

    public String c() {
        int ceil = (int) Math.ceil((Math.random() * 20.0d) + 3.0d);
        char[] charArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        int length = charArray.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < ceil; i10++) {
            stringBuffer.append(charArray[(int) (Math.random() * length)]);
        }
        return stringBuffer.toString();
    }

    public String a(a aVar) {
        int b10 = b();
        try {
            this.f22995b.put("" + b10, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return "" + b10;
    }
}
