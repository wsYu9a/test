package com.umeng.analytics.pro;

/* loaded from: classes4.dex */
public class db {

    /* renamed from: a */
    public final String f23827a;

    /* renamed from: b */
    public final byte f23828b;

    /* renamed from: c */
    public final short f23829c;

    public db() {
        this("", (byte) 0, (short) 0);
    }

    public boolean a(db dbVar) {
        return this.f23828b == dbVar.f23828b && this.f23829c == dbVar.f23829c;
    }

    public String toString() {
        return "<TField name:'" + this.f23827a + "' type:" + ((int) this.f23828b) + " field-id:" + ((int) this.f23829c) + ">";
    }

    public db(String str, byte b10, short s10) {
        this.f23827a = str;
        this.f23828b = b10;
        this.f23829c = s10;
    }
}
