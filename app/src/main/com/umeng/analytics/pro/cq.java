package com.umeng.analytics.pro;

import com.umeng.analytics.pro.da;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* loaded from: classes4.dex */
public class cq {

    /* renamed from: a */
    private final ByteArrayOutputStream f23753a;

    /* renamed from: b */
    private final ds f23754b;

    /* renamed from: c */
    private dg f23755c;

    public cq() {
        this(new da.a());
    }

    public byte[] a(ch chVar) throws cn {
        this.f23753a.reset();
        chVar.write(this.f23755c);
        return this.f23753a.toByteArray();
    }

    public String b(ch chVar) throws cn {
        return new String(a(chVar));
    }

    public cq(di diVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f23753a = byteArrayOutputStream;
        ds dsVar = new ds(byteArrayOutputStream);
        this.f23754b = dsVar;
        this.f23755c = diVar.a(dsVar);
    }

    public String a(ch chVar, String str) throws cn {
        try {
            return new String(a(chVar), str);
        } catch (UnsupportedEncodingException unused) {
            throw new cn("JVM DOES NOT SUPPORT ENCODING: " + str);
        }
    }
}
