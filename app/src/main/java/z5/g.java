package z5;

import com.google.zxing.NotFoundException;

/* loaded from: classes2.dex */
public class g extends t5.a {

    /* renamed from: d */
    public static final int f33668d = 5;

    /* renamed from: e */
    public static final int f33669e = 3;

    /* renamed from: f */
    public static final int f33670f = 32;

    /* renamed from: g */
    public static final byte[] f33671g = new byte[0];

    /* renamed from: b */
    public byte[] f33672b;

    /* renamed from: c */
    public final int[] f33673c;

    public g(t5.e eVar) {
        super(eVar);
        this.f33672b = f33671g;
        this.f33673c = new int[32];
    }

    public static int g(int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13++) {
            int i14 = iArr[i13];
            if (i14 > i10) {
                i12 = i13;
                i10 = i14;
            }
            if (i14 > i11) {
                i11 = i14;
            }
        }
        int i15 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < length; i17++) {
            int i18 = i17 - i12;
            int i19 = iArr[i17] * i18 * i18;
            if (i19 > i16) {
                i15 = i17;
                i16 = i19;
            }
        }
        if (i12 <= i15) {
            int i20 = i12;
            i12 = i15;
            i15 = i20;
        }
        if (i12 - i15 <= length / 16) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i21 = i12 - 1;
        int i22 = i21;
        int i23 = -1;
        while (i21 > i15) {
            int i24 = i21 - i15;
            int i25 = i24 * i24 * (i12 - i21) * (i11 - iArr[i21]);
            if (i25 > i23) {
                i22 = i21;
                i23 = i25;
            }
            i21--;
        }
        return i22 << 3;
    }

    @Override // t5.a
    public t5.a a(t5.e eVar) {
        return new g(eVar);
    }

    @Override // t5.a
    public b b() throws NotFoundException {
        t5.e e10 = e();
        int e11 = e10.e();
        int b10 = e10.b();
        b bVar = new b(e11, b10);
        h(e11);
        int[] iArr = this.f33673c;
        for (int i10 = 1; i10 < 5; i10++) {
            byte[] d10 = e10.d((b10 * i10) / 5, this.f33672b);
            int i11 = (e11 << 2) / 5;
            for (int i12 = e11 / 5; i12 < i11; i12++) {
                int i13 = (d10[i12] & 255) >> 3;
                iArr[i13] = iArr[i13] + 1;
            }
        }
        int g10 = g(iArr);
        byte[] c10 = e10.c();
        for (int i14 = 0; i14 < b10; i14++) {
            int i15 = i14 * e11;
            for (int i16 = 0; i16 < e11; i16++) {
                if ((c10[i15 + i16] & 255) < g10) {
                    bVar.o(i16, i14);
                }
            }
        }
        return bVar;
    }

    @Override // t5.a
    public a c(int i10, a aVar) throws NotFoundException {
        t5.e e10 = e();
        int e11 = e10.e();
        if (aVar == null || aVar.l() < e11) {
            aVar = new a(e11);
        } else {
            aVar.d();
        }
        h(e11);
        byte[] d10 = e10.d(i10, this.f33672b);
        int[] iArr = this.f33673c;
        for (int i11 = 0; i11 < e11; i11++) {
            int i12 = (d10[i11] & 255) >> 3;
            iArr[i12] = iArr[i12] + 1;
        }
        int g10 = g(iArr);
        if (e11 < 3) {
            for (int i13 = 0; i13 < e11; i13++) {
                if ((d10[i13] & 255) < g10) {
                    aVar.q(i13);
                }
            }
        } else {
            int i14 = 1;
            int i15 = d10[0] & 255;
            int i16 = d10[1] & 255;
            while (i14 < e11 - 1) {
                int i17 = i14 + 1;
                int i18 = d10[i17] & 255;
                if ((((i16 << 2) - i15) - i18) / 2 < g10) {
                    aVar.q(i14);
                }
                i15 = i16;
                i14 = i17;
                i16 = i18;
            }
        }
        return aVar;
    }

    public final void h(int i10) {
        if (this.f33672b.length < i10) {
            this.f33672b = new byte[i10];
        }
        for (int i11 = 0; i11 < 32; i11++) {
            this.f33673c[i11] = 0;
        }
    }
}
