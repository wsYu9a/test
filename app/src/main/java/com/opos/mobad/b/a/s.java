package com.opos.mobad.b.a;

/* loaded from: classes4.dex */
public enum s implements com.heytap.nearx.a.a.i {
    TYPE_16_8(1),
    TYPE_16_9(2);


    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<s> f19869c = com.heytap.nearx.a.a.e.a(s.class);

    /* renamed from: d */
    private final int f19871d;

    s(int i2) {
        this.f19871d = i2;
    }

    public static s fromValue(int i2) {
        if (i2 == 1) {
            return TYPE_16_8;
        }
        if (i2 != 2) {
            return null;
        }
        return TYPE_16_9;
    }

    @Override // com.heytap.nearx.a.a.i
    public int a() {
        return this.f19871d;
    }
}
