package com.umeng.analytics.pro;

import com.umeng.analytics.pro.bo;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* loaded from: classes4.dex */
public class be {

    /* renamed from: a */
    private final ByteArrayOutputStream f25727a;

    /* renamed from: b */
    private final cg f25728b;

    /* renamed from: c */
    private bu f25729c;

    public be() {
        this(new bo.a());
    }

    public byte[] a(av avVar) throws bb {
        this.f25727a.reset();
        avVar.write(this.f25729c);
        return this.f25727a.toByteArray();
    }

    public String b(av avVar) throws bb {
        return new String(a(avVar));
    }

    public be(bw bwVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f25727a = byteArrayOutputStream;
        cg cgVar = new cg(byteArrayOutputStream);
        this.f25728b = cgVar;
        this.f25729c = bwVar.a(cgVar);
    }

    public String a(av avVar, String str) throws bb {
        try {
            return new String(a(avVar), str);
        } catch (UnsupportedEncodingException unused) {
            throw new bb("JVM DOES NOT SUPPORT ENCODING: " + str);
        }
    }
}
