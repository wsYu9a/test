package com.opos.mobad.b.a;

/* loaded from: classes4.dex */
public enum ac implements com.heytap.nearx.a.a.i {
    MODE_ONE(1),
    MODE_TWO(2);


    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<ac> f19547c = com.heytap.nearx.a.a.e.a(ac.class);

    /* renamed from: d */
    private final int f19549d;

    ac(int i2) {
        this.f19549d = i2;
    }

    public static ac fromValue(int i2) {
        if (i2 == 1) {
            return MODE_ONE;
        }
        if (i2 != 2) {
            return null;
        }
        return MODE_TWO;
    }

    @Override // com.heytap.nearx.a.a.i
    public int a() {
        return this.f19549d;
    }
}
