package com.umeng.analytics.pro;

/* loaded from: classes4.dex */
public final class de {

    /* renamed from: a */
    public final String f23835a;

    /* renamed from: b */
    public final byte f23836b;

    /* renamed from: c */
    public final int f23837c;

    public de() {
        this("", (byte) 0, 0);
    }

    public boolean a(de deVar) {
        return this.f23835a.equals(deVar.f23835a) && this.f23836b == deVar.f23836b && this.f23837c == deVar.f23837c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof de) {
            return a((de) obj);
        }
        return false;
    }

    public String toString() {
        return "<TMessage name:'" + this.f23835a + "' type: " + ((int) this.f23836b) + " seqid:" + this.f23837c + ">";
    }

    public de(String str, byte b10, int i10) {
        this.f23835a = str;
        this.f23836b = b10;
        this.f23837c = i10;
    }
}
