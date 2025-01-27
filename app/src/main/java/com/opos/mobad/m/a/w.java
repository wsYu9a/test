package com.opos.mobad.m.a;

/* loaded from: classes4.dex */
public enum w implements com.heytap.nearx.a.a.i {
    UNKNOWN_STATUS(0),
    VIP(1),
    NORMAL(2);


    /* renamed from: d */
    public static final com.heytap.nearx.a.a.e<w> f21461d = com.heytap.nearx.a.a.e.a(w.class);

    /* renamed from: e */
    private final int f21463e;

    w(int i2) {
        this.f21463e = i2;
    }

    public static w fromValue(int i2) {
        if (i2 == 0) {
            return UNKNOWN_STATUS;
        }
        if (i2 == 1) {
            return VIP;
        }
        if (i2 != 2) {
            return null;
        }
        return NORMAL;
    }

    @Override // com.heytap.nearx.a.a.i
    public int a() {
        return this.f21463e;
    }
}
