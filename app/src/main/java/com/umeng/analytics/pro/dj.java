package com.umeng.analytics.pro;

import com.umeng.analytics.pro.da;

/* loaded from: classes4.dex */
public class dj {

    /* renamed from: a */
    private static int f23851a = Integer.MAX_VALUE;

    public static void a(int i10) {
        f23851a = i10;
    }

    public static void a(dg dgVar, byte b10) throws cn {
        a(dgVar, b10, f23851a);
    }

    public static void a(dg dgVar, byte b10, int i10) throws cn {
        if (i10 > 0) {
            int i11 = 0;
            switch (b10) {
                case 2:
                    dgVar.t();
                    return;
                case 3:
                    dgVar.u();
                    return;
                case 4:
                    dgVar.y();
                    return;
                case 5:
                case 7:
                case 9:
                default:
                    return;
                case 6:
                    dgVar.v();
                    return;
                case 8:
                    dgVar.w();
                    return;
                case 10:
                    dgVar.x();
                    return;
                case 11:
                    dgVar.A();
                    return;
                case 12:
                    dgVar.j();
                    while (true) {
                        byte b11 = dgVar.l().f23828b;
                        if (b11 == 0) {
                            dgVar.k();
                            return;
                        } else {
                            a(dgVar, b11, i10 - 1);
                            dgVar.m();
                        }
                    }
                case 13:
                    dd n10 = dgVar.n();
                    while (i11 < n10.f23834c) {
                        int i12 = i10 - 1;
                        a(dgVar, n10.f23832a, i12);
                        a(dgVar, n10.f23833b, i12);
                        i11++;
                    }
                    dgVar.o();
                    return;
                case 14:
                    dk r10 = dgVar.r();
                    while (i11 < r10.f23853b) {
                        a(dgVar, r10.f23852a, i10 - 1);
                        i11++;
                    }
                    dgVar.s();
                    return;
                case 15:
                    dc p10 = dgVar.p();
                    while (i11 < p10.f23831b) {
                        a(dgVar, p10.f23830a, i10 - 1);
                        i11++;
                    }
                    dgVar.q();
                    return;
            }
        } else {
            throw new cn("Maximum skip depth exceeded");
        }
    }

    public static di a(byte[] bArr, di diVar) {
        if (bArr[0] > 16) {
            return new da.a();
        }
        return (bArr.length <= 1 || (bArr[1] & 128) == 0) ? diVar : new da.a();
    }
}
