package com.google.zxing.datamatrix.encoder;

import java.util.Arrays;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final CharSequence f8389a;

    /* renamed from: b, reason: collision with root package name */
    private final int f8390b;

    /* renamed from: c, reason: collision with root package name */
    private final int f8391c;

    /* renamed from: d, reason: collision with root package name */
    private final byte[] f8392d;

    public e(CharSequence charSequence, int i2, int i3) {
        this.f8389a = charSequence;
        this.f8391c = i2;
        this.f8390b = i3;
        byte[] bArr = new byte[i2 * i3];
        this.f8392d = bArr;
        Arrays.fill(bArr, (byte) -1);
    }

    private void a(int i2) {
        j(this.f8390b - 1, 0, i2, 1);
        j(this.f8390b - 1, 1, i2, 2);
        j(this.f8390b - 1, 2, i2, 3);
        j(0, this.f8391c - 2, i2, 4);
        j(0, this.f8391c - 1, i2, 5);
        j(1, this.f8391c - 1, i2, 6);
        j(2, this.f8391c - 1, i2, 7);
        j(3, this.f8391c - 1, i2, 8);
    }

    private void b(int i2) {
        j(this.f8390b - 3, 0, i2, 1);
        j(this.f8390b - 2, 0, i2, 2);
        j(this.f8390b - 1, 0, i2, 3);
        j(0, this.f8391c - 4, i2, 4);
        j(0, this.f8391c - 3, i2, 5);
        j(0, this.f8391c - 2, i2, 6);
        j(0, this.f8391c - 1, i2, 7);
        j(1, this.f8391c - 1, i2, 8);
    }

    private void c(int i2) {
        j(this.f8390b - 3, 0, i2, 1);
        j(this.f8390b - 2, 0, i2, 2);
        j(this.f8390b - 1, 0, i2, 3);
        j(0, this.f8391c - 2, i2, 4);
        j(0, this.f8391c - 1, i2, 5);
        j(1, this.f8391c - 1, i2, 6);
        j(2, this.f8391c - 1, i2, 7);
        j(3, this.f8391c - 1, i2, 8);
    }

    private void d(int i2) {
        j(this.f8390b - 1, 0, i2, 1);
        j(this.f8390b - 1, this.f8391c - 1, i2, 2);
        j(0, this.f8391c - 3, i2, 3);
        j(0, this.f8391c - 2, i2, 4);
        j(0, this.f8391c - 1, i2, 5);
        j(1, this.f8391c - 3, i2, 6);
        j(1, this.f8391c - 2, i2, 7);
        j(1, this.f8391c - 1, i2, 8);
    }

    private boolean i(int i2, int i3) {
        return this.f8392d[(i3 * this.f8391c) + i2] >= 0;
    }

    private void j(int i2, int i3, int i4, int i5) {
        if (i2 < 0) {
            int i6 = this.f8390b;
            i2 += i6;
            i3 += 4 - ((i6 + 4) % 8);
        }
        if (i3 < 0) {
            int i7 = this.f8391c;
            i3 += i7;
            i2 += 4 - ((i7 + 4) % 8);
        }
        l(i3, i2, (this.f8389a.charAt(i4) & (1 << (8 - i5))) != 0);
    }

    private void l(int i2, int i3, boolean z) {
        this.f8392d[(i3 * this.f8391c) + i2] = z ? (byte) 1 : (byte) 0;
    }

    private void m(int i2, int i3, int i4) {
        int i5 = i2 - 2;
        int i6 = i3 - 2;
        j(i5, i6, i4, 1);
        int i7 = i3 - 1;
        j(i5, i7, i4, 2);
        int i8 = i2 - 1;
        j(i8, i6, i4, 3);
        j(i8, i7, i4, 4);
        j(i8, i3, i4, 5);
        j(i2, i6, i4, 6);
        j(i2, i7, i4, 7);
        j(i2, i3, i4, 8);
    }

    public final boolean e(int i2, int i3) {
        return this.f8392d[(i3 * this.f8391c) + i2] == 1;
    }

    final byte[] f() {
        return this.f8392d;
    }

    final int g() {
        return this.f8391c;
    }

    final int h() {
        return this.f8390b;
    }

    public final void k() {
        int i2;
        int i3;
        int i4 = 0;
        int i5 = 0;
        int i6 = 4;
        while (true) {
            if (i6 == this.f8390b && i4 == 0) {
                a(i5);
                i5++;
            }
            if (i6 == this.f8390b - 2 && i4 == 0 && this.f8391c % 4 != 0) {
                b(i5);
                i5++;
            }
            if (i6 == this.f8390b - 2 && i4 == 0 && this.f8391c % 8 == 4) {
                c(i5);
                i5++;
            }
            if (i6 == this.f8390b + 4 && i4 == 2 && this.f8391c % 8 == 0) {
                d(i5);
                i5++;
            }
            do {
                if (i6 < this.f8390b && i4 >= 0 && !i(i4, i6)) {
                    m(i6, i4, i5);
                    i5++;
                }
                i6 -= 2;
                i4 += 2;
                if (i6 < 0) {
                    break;
                }
            } while (i4 < this.f8391c);
            int i7 = i6 + 1;
            int i8 = i4 + 3;
            do {
                if (i7 >= 0 && i8 < this.f8391c && !i(i8, i7)) {
                    m(i7, i8, i5);
                    i5++;
                }
                i7 += 2;
                i8 -= 2;
                i2 = this.f8390b;
                if (i7 >= i2) {
                    break;
                }
            } while (i8 >= 0);
            i6 = i7 + 3;
            i4 = i8 + 1;
            if (i6 >= i2 && i4 >= (i3 = this.f8391c)) {
                break;
            }
        }
        if (i(i3 - 1, i2 - 1)) {
            return;
        }
        l(this.f8391c - 1, this.f8390b - 1, true);
        l(this.f8391c - 2, this.f8390b - 2, true);
    }
}
