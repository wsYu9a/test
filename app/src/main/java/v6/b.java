package v6;

import java.lang.reflect.Array;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a */
    public final byte[][] f31234a;

    /* renamed from: b */
    public final int f31235b;

    /* renamed from: c */
    public final int f31236c;

    public b(int i10, int i11) {
        this.f31234a = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i11, i10);
        this.f31235b = i10;
        this.f31236c = i11;
    }

    public void a(byte b10) {
        for (int i10 = 0; i10 < this.f31236c; i10++) {
            for (int i11 = 0; i11 < this.f31235b; i11++) {
                this.f31234a[i10][i11] = b10;
            }
        }
    }

    public byte b(int i10, int i11) {
        return this.f31234a[i11][i10];
    }

    public byte[][] c() {
        return this.f31234a;
    }

    public int d() {
        return this.f31236c;
    }

    public int e() {
        return this.f31235b;
    }

    public void f(int i10, int i11, byte b10) {
        this.f31234a[i11][i10] = b10;
    }

    public void g(int i10, int i11, int i12) {
        this.f31234a[i11][i10] = (byte) i12;
    }

    public void h(int i10, int i11, boolean z10) {
        this.f31234a[i11][i10] = z10 ? (byte) 1 : (byte) 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder((this.f31235b * 2 * this.f31236c) + 2);
        for (int i10 = 0; i10 < this.f31236c; i10++) {
            for (int i11 = 0; i11 < this.f31235b; i11++) {
                byte b10 = this.f31234a[i10][i11];
                if (b10 == 0) {
                    sb2.append(" 0");
                } else if (b10 != 1) {
                    sb2.append("  ");
                } else {
                    sb2.append(" 1");
                }
            }
            sb2.append('\n');
        }
        return sb2.toString();
    }
}
