package com.vivo.push.util;

import android.content.Context;
import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: c */
    private static volatile a f25108c;

    /* renamed from: a */
    private byte[] f25109a;

    /* renamed from: b */
    private byte[] f25110b;

    private a(Context context) {
        w.b().a(ContextDelegate.getContext(context));
        w b10 = w.b();
        this.f25109a = b10.c();
        this.f25110b = b10.d();
    }

    public static a a(Context context) {
        if (f25108c == null) {
            synchronized (a.class) {
                try {
                    if (f25108c == null) {
                        f25108c = new a(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return f25108c;
    }

    public final String b(String str) throws Exception {
        return new String(f.a(f.a(a()), f.a(b()), Base64.decode(str, 2)), "utf-8");
    }

    private byte[] b() {
        byte[] bArr = this.f25110b;
        return (bArr == null || bArr.length <= 0) ? w.b().d() : bArr;
    }

    public final String a(String str) throws Exception {
        String a10 = f.a(a());
        String a11 = f.a(b());
        byte[] bytes = str.getBytes("utf-8");
        SecretKeySpec secretKeySpec = new SecretKeySpec(a11.getBytes("utf-8"), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(a10.getBytes("utf-8")));
        return Base64.encodeToString(cipher.doFinal(bytes), 2);
    }

    private byte[] a() {
        byte[] bArr = this.f25109a;
        return (bArr == null || bArr.length <= 0) ? w.b().c() : bArr;
    }
}
