package com.opos.mobad.b.a;

/* loaded from: classes4.dex */
public enum ad implements com.heytap.nearx.a.a.i {
    UNKNOWN(0),
    SPLASH(1),
    HOT_SPLASH(2);


    /* renamed from: d */
    public static final com.heytap.nearx.a.a.e<ad> f19553d = com.heytap.nearx.a.a.e.a(ad.class);

    /* renamed from: e */
    private final int f19555e;

    ad(int i2) {
        this.f19555e = i2;
    }

    public static ad fromValue(int i2) {
        if (i2 == 0) {
            return UNKNOWN;
        }
        if (i2 == 1) {
            return SPLASH;
        }
        if (i2 != 2) {
            return null;
        }
        return HOT_SPLASH;
    }

    @Override // com.heytap.nearx.a.a.i
    public int a() {
        return this.f19555e;
    }
}
