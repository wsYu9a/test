package com.umeng.analytics.pro;

/* loaded from: classes4.dex */
public class bp {

    /* renamed from: a */
    public final String f25779a;

    /* renamed from: b */
    public final byte f25780b;

    /* renamed from: c */
    public final short f25781c;

    public bp() {
        this("", (byte) 0, (short) 0);
    }

    public boolean a(bp bpVar) {
        return this.f25780b == bpVar.f25780b && this.f25781c == bpVar.f25781c;
    }

    public String toString() {
        return "<TField name:'" + this.f25779a + "' type:" + ((int) this.f25780b) + " field-id:" + ((int) this.f25781c) + ">";
    }

    public bp(String str, byte b2, short s) {
        this.f25779a = str;
        this.f25780b = b2;
        this.f25781c = s;
    }
}
