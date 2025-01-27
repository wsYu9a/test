package com.opos.exoplayer.core.c.d;

import java.util.UUID;

/* loaded from: classes4.dex */
public final class d {

    private static class a {

        /* renamed from: a */
        private final UUID f17901a;

        /* renamed from: b */
        private final int f17902b;

        /* renamed from: c */
        private final byte[] f17903c;

        public a(UUID uuid, int i2, byte[] bArr) {
            this.f17901a = uuid;
            this.f17902b = i2;
            this.f17903c = bArr;
        }
    }

    public static UUID a(byte[] bArr) {
        a b2 = b(bArr);
        if (b2 == null) {
            return null;
        }
        return b2.f17901a;
    }

    private static a b(byte[] bArr) {
        com.opos.exoplayer.core.i.m mVar = new com.opos.exoplayer.core.i.m(bArr);
        if (mVar.c() >= 32) {
            mVar.c(0);
            if (mVar.o() == mVar.b() + 4 && mVar.o() == g.U) {
                int a2 = g.a(mVar.o());
                if (a2 > 1) {
                    com.opos.cmn.an.f.a.c("PsshAtomUtil", "Unsupported pssh version: " + a2);
                } else {
                    UUID uuid = new UUID(mVar.q(), mVar.q());
                    if (a2 == 1) {
                        mVar.d(mVar.u() * 16);
                    }
                    int u = mVar.u();
                    if (u == mVar.b()) {
                        byte[] bArr2 = new byte[u];
                        mVar.a(bArr2, 0, u);
                        return new a(uuid, a2, bArr2);
                    }
                }
            }
        }
        return null;
    }
}
