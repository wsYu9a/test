package com.opos.mobad.m.a;

/* loaded from: classes4.dex */
public enum j implements com.heytap.nearx.a.a.i {
    UNKNOWN_MODE(0),
    PERCENTAGE_MODE(1),
    RANKER_MODE(2),
    BIDDING_MODE(3);


    /* renamed from: e */
    public static final com.heytap.nearx.a.a.e<j> f21340e = com.heytap.nearx.a.a.e.a(j.class);

    /* renamed from: f */
    private final int f21342f;

    j(int i2) {
        this.f21342f = i2;
    }

    public static j fromValue(int i2) {
        if (i2 == 0) {
            return UNKNOWN_MODE;
        }
        if (i2 == 1) {
            return PERCENTAGE_MODE;
        }
        if (i2 == 2) {
            return RANKER_MODE;
        }
        if (i2 != 3) {
            return null;
        }
        return BIDDING_MODE;
    }

    @Override // com.heytap.nearx.a.a.i
    public int a() {
        return this.f21342f;
    }
}
