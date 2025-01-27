package com.vivo.mobilead.util;

import com.vivo.secboxsdk.SecBoxCipher;
import com.vivo.secboxsdk.SecBoxCipherException;
import java.util.Map;

/* loaded from: classes4.dex */
public class z0 {

    /* renamed from: a */
    private SecBoxCipher f30814a;

    public static class b {

        /* renamed from: a */
        static final z0 f30815a = new z0();
    }

    /* synthetic */ z0(a aVar) {
        this();
    }

    public static z0 d() {
        return b.f30815a;
    }

    public byte[] a() throws SecBoxCipherException {
        return this.f30814a.a();
    }

    public int b() {
        return SecBoxCipher.d();
    }

    public String c() {
        return SecBoxCipher.c();
    }

    private z0() {
        this.f30814a = null;
        this.f30814a = SecBoxCipher.b();
    }

    public String a(String str, byte[] bArr) throws SecBoxCipherException {
        return this.f30814a.a(str, bArr);
    }

    public Map<String, String> a(Map<String, String> map, byte[] bArr) throws SecBoxCipherException {
        return this.f30814a.a(map, bArr);
    }
}
