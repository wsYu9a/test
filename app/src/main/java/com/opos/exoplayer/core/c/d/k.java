package com.opos.exoplayer.core.c.d;

import com.opos.exoplayer.core.i.u;

/* loaded from: classes4.dex */
final class k {

    /* renamed from: a */
    private static final int[] f17975a = {u.f("isom"), u.f("iso2"), u.f("iso3"), u.f("iso4"), u.f("iso5"), u.f("iso6"), u.f("avc1"), u.f("hvc1"), u.f("hev1"), u.f("mp41"), u.f("mp42"), u.f("3g2a"), u.f("3g2b"), u.f("3gr6"), u.f("3gs6"), u.f("3ge6"), u.f("3gg6"), u.f("M4V "), u.f("M4A "), u.f("f4v "), u.f("kddi"), u.f("M4VP"), u.f("qt  "), u.f("MSNV")};

    private static boolean a(int i2) {
        if ((i2 >>> 8) != u.f("3gp")) {
            for (int i3 : f17975a) {
                if (i3 != i2) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean a(com.opos.exoplayer.core.c.f fVar) {
        return a(fVar, true);
    }

    private static boolean a(com.opos.exoplayer.core.c.f fVar, boolean z) {
        boolean z2;
        long d2 = fVar.d();
        long j2 = -1;
        if (d2 == -1 || d2 > 4096) {
            d2 = 4096;
        }
        int i2 = (int) d2;
        com.opos.exoplayer.core.i.m mVar = new com.opos.exoplayer.core.i.m(64);
        boolean z3 = false;
        int i3 = 0;
        boolean z4 = false;
        while (i3 < i2) {
            mVar.a(8);
            fVar.c(mVar.f19048a, z3 ? 1 : 0, 8);
            long m = mVar.m();
            int o = mVar.o();
            int i4 = 16;
            if (m == 1) {
                fVar.c(mVar.f19048a, 8, 8);
                mVar.b(16);
                m = mVar.w();
            } else {
                if (m == 0) {
                    long d3 = fVar.d();
                    if (d3 != j2) {
                        m = 8 + (d3 - fVar.c());
                    }
                }
                i4 = 8;
            }
            long j3 = i4;
            if (m >= j3) {
                i3 += i4;
                if (o != g.B) {
                    if (o != g.K && o != g.M) {
                        if ((i3 + m) - j3 >= i2) {
                            break;
                        }
                        int i5 = (int) (m - j3);
                        if (o == g.f17919a) {
                            if (i5 >= 8) {
                                mVar.a(i5);
                                fVar.c(mVar.f19048a, 0, i5);
                                int i6 = i5 / 4;
                                int i7 = 0;
                                while (true) {
                                    if (i7 >= i6) {
                                        break;
                                    }
                                    if (i7 == 1) {
                                        mVar.d(4);
                                    } else if (a(mVar.o())) {
                                        z4 = true;
                                        break;
                                    }
                                    i7++;
                                }
                                if (!z4) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else if (i5 != 0) {
                            fVar.c(i5);
                        }
                        i3 += i5;
                        z3 = false;
                        j2 = -1;
                    } else {
                        z2 = true;
                        break;
                    }
                }
            } else {
                return z3;
            }
        }
        z2 = false;
        return z4 && z == z2;
    }

    public static boolean b(com.opos.exoplayer.core.c.f fVar) {
        return a(fVar, false);
    }
}
