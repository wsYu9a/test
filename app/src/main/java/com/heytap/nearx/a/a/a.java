package com.heytap.nearx.a.a;

/* loaded from: classes.dex */
public enum a {
    VARINT(0),
    FIXED64(1),
    LENGTH_DELIMITED(2),
    FIXED32(5);


    /* renamed from: e */
    final int f9011e;

    /* renamed from: com.heytap.nearx.a.a.a$1 */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f9012a;

        static {
            int[] iArr = new int[a.values().length];
            f9012a = iArr;
            try {
                iArr[a.VARINT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9012a[a.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9012a[a.FIXED64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9012a[a.LENGTH_DELIMITED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    a(int i2) {
        this.f9011e = i2;
    }

    public e<?> a() {
        int i2 = AnonymousClass1.f9012a[ordinal()];
        if (i2 == 1) {
            return e.f9031j;
        }
        if (i2 == 2) {
            return e.f9028g;
        }
        if (i2 == 3) {
            return e.l;
        }
        if (i2 == 4) {
            return e.q;
        }
        throw new AssertionError();
    }
}
