package com.umeng.analytics.pro;

/* loaded from: classes4.dex */
public final class bs {

    /* renamed from: a */
    public final String f25787a;

    /* renamed from: b */
    public final byte f25788b;

    /* renamed from: c */
    public final int f25789c;

    public bs() {
        this("", (byte) 0, 0);
    }

    public boolean a(bs bsVar) {
        return this.f25787a.equals(bsVar.f25787a) && this.f25788b == bsVar.f25788b && this.f25789c == bsVar.f25789c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof bs) {
            return a((bs) obj);
        }
        return false;
    }

    public String toString() {
        return "<TMessage name:'" + this.f25787a + "' type: " + ((int) this.f25788b) + " seqid:" + this.f25789c + ">";
    }

    public bs(String str, byte b2, int i2) {
        this.f25787a = str;
        this.f25788b = b2;
        this.f25789c = i2;
    }
}
