package com.opos.mobad.m.a;

/* loaded from: classes4.dex */
public enum n implements com.heytap.nearx.a.a.i {
    HORIZONTAL(0),
    VERTICAL(1);


    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<n> f21366c = com.heytap.nearx.a.a.e.a(n.class);

    /* renamed from: d */
    private final int f21368d;

    n(int i2) {
        this.f21368d = i2;
    }

    public static n fromValue(int i2) {
        if (i2 == 0) {
            return HORIZONTAL;
        }
        if (i2 != 1) {
            return null;
        }
        return VERTICAL;
    }

    @Override // com.heytap.nearx.a.a.i
    public int a() {
        return this.f21368d;
    }
}
