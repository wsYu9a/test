package com.vivo.push.util;

import android.content.Context;
import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: c */
    private static volatile a f31072c;

    /* renamed from: a */
    private byte[] f31073a;

    /* renamed from: b */
    private byte[] f31074b;

    private a(Context context) {
        w.b().a(ContextDelegate.getContext(context));
        w b2 = w.b();
        this.f31073a = b2.c();
        this.f31074b = b2.d();
    }

    public static a a(Context context) {
        if (f31072c == null) {
            synchronized (a.class) {
                if (f31072c == null) {
                    f31072c = new a(context.getApplicationContext());
                }
            }
        }
        return f31072c;
    }

    public final String b(String str) throws Exception {
        return new String(f.a(f.a(a()), f.a(b()), Base64.decode(str, 2)), "utf-8");
    }

    private byte[] b() {
        byte[] bArr = this.f31074b;
        return (bArr == null || bArr.length <= 0) ? w.b().d() : bArr;
    }

    public final String a(String str) throws Exception {
        String a2 = f.a(a());
        String a3 = f.a(b());
        byte[] bytes = str.getBytes("utf-8");
        SecretKeySpec secretKeySpec = new SecretKeySpec(a3.getBytes("utf-8"), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(a2.getBytes("utf-8")));
        return Base64.encodeToString(cipher.doFinal(bytes), 2);
    }

    private byte[] a() {
        byte[] bArr = this.f31073a;
        return (bArr == null || bArr.length <= 0) ? w.b().c() : bArr;
    }
}
