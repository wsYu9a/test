package r6;

import java.lang.reflect.Array;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a */
    public final b[] f30314a;

    /* renamed from: b */
    public int f30315b;

    /* renamed from: c */
    public final int f30316c;

    /* renamed from: d */
    public final int f30317d;

    public a(int i10, int i11) {
        b[] bVarArr = new b[i10];
        this.f30314a = bVarArr;
        int length = bVarArr.length;
        for (int i12 = 0; i12 < length; i12++) {
            this.f30314a[i12] = new b(((i11 + 4) * 17) + 1);
        }
        this.f30317d = i11 * 17;
        this.f30316c = i10;
        this.f30315b = -1;
    }

    public b a() {
        return this.f30314a[this.f30315b];
    }

    public byte[][] b() {
        return c(1, 1);
    }

    public byte[][] c(int i10, int i11) {
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, this.f30316c * i11, this.f30317d * i10);
        int i12 = this.f30316c * i11;
        for (int i13 = 0; i13 < i12; i13++) {
            bArr[(i12 - i13) - 1] = this.f30314a[i13 / i11].b(i10);
        }
        return bArr;
    }

    public void d(int i10, int i11, byte b10) {
        this.f30314a[i11].c(i10, b10);
    }

    public void e() {
        this.f30315b++;
    }
}
