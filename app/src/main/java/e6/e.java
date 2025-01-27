package e6;

import java.util.Arrays;

/* loaded from: classes2.dex */
public class e {

    /* renamed from: a */
    public final CharSequence f25709a;

    /* renamed from: b */
    public final int f25710b;

    /* renamed from: c */
    public final int f25711c;

    /* renamed from: d */
    public final byte[] f25712d;

    public e(CharSequence charSequence, int i10, int i11) {
        this.f25709a = charSequence;
        this.f25711c = i10;
        this.f25710b = i11;
        byte[] bArr = new byte[i10 * i11];
        this.f25712d = bArr;
        Arrays.fill(bArr, (byte) -1);
    }

    public final void a(int i10) {
        j(this.f25710b - 1, 0, i10, 1);
        j(this.f25710b - 1, 1, i10, 2);
        j(this.f25710b - 1, 2, i10, 3);
        j(0, this.f25711c - 2, i10, 4);
        j(0, this.f25711c - 1, i10, 5);
        j(1, this.f25711c - 1, i10, 6);
        j(2, this.f25711c - 1, i10, 7);
        j(3, this.f25711c - 1, i10, 8);
    }

    public final void b(int i10) {
        j(this.f25710b - 3, 0, i10, 1);
        j(this.f25710b - 2, 0, i10, 2);
        j(this.f25710b - 1, 0, i10, 3);
        j(0, this.f25711c - 4, i10, 4);
        j(0, this.f25711c - 3, i10, 5);
        j(0, this.f25711c - 2, i10, 6);
        j(0, this.f25711c - 1, i10, 7);
        j(1, this.f25711c - 1, i10, 8);
    }

    public final void c(int i10) {
        j(this.f25710b - 3, 0, i10, 1);
        j(this.f25710b - 2, 0, i10, 2);
        j(this.f25710b - 1, 0, i10, 3);
        j(0, this.f25711c - 2, i10, 4);
        j(0, this.f25711c - 1, i10, 5);
        j(1, this.f25711c - 1, i10, 6);
        j(2, this.f25711c - 1, i10, 7);
        j(3, this.f25711c - 1, i10, 8);
    }

    public final void d(int i10) {
        j(this.f25710b - 1, 0, i10, 1);
        j(this.f25710b - 1, this.f25711c - 1, i10, 2);
        j(0, this.f25711c - 3, i10, 3);
        j(0, this.f25711c - 2, i10, 4);
        j(0, this.f25711c - 1, i10, 5);
        j(1, this.f25711c - 3, i10, 6);
        j(1, this.f25711c - 2, i10, 7);
        j(1, this.f25711c - 1, i10, 8);
    }

    public final boolean e(int i10, int i11) {
        return this.f25712d[(i11 * this.f25711c) + i10] == 1;
    }

    public final byte[] f() {
        return this.f25712d;
    }

    public final int g() {
        return this.f25711c;
    }

    public final int h() {
        return this.f25710b;
    }

    public final boolean i(int i10, int i11) {
        return this.f25712d[(i11 * this.f25711c) + i10] >= 0;
    }

    public final void j(int i10, int i11, int i12, int i13) {
        if (i10 < 0) {
            int i14 = this.f25710b;
            i10 += i14;
            i11 += 4 - ((i14 + 4) % 8);
        }
        if (i11 < 0) {
            int i15 = this.f25711c;
            i11 += i15;
            i10 += 4 - ((i15 + 4) % 8);
        }
        l(i11, i10, (this.f25709a.charAt(i12) & (1 << (8 - i13))) != 0);
    }

    public final void k() {
        int i10;
        int i11;
        int i12 = 0;
        int i13 = 0;
        int i14 = 4;
        while (true) {
            if (i14 == this.f25710b && i12 == 0) {
                a(i13);
                i13++;
            }
            if (i14 == this.f25710b - 2 && i12 == 0 && this.f25711c % 4 != 0) {
                b(i13);
                i13++;
            }
            if (i14 == this.f25710b - 2 && i12 == 0 && this.f25711c % 8 == 4) {
                c(i13);
                i13++;
            }
            if (i14 == this.f25710b + 4 && i12 == 2 && this.f25711c % 8 == 0) {
                d(i13);
                i13++;
            }
            while (true) {
                if (i14 < this.f25710b && i12 >= 0 && !i(i12, i14)) {
                    m(i14, i12, i13);
                    i13++;
                }
                int i15 = i14 - 2;
                int i16 = i12 + 2;
                if (i15 < 0 || i16 >= this.f25711c) {
                    break;
                }
                i14 = i15;
                i12 = i16;
            }
            int i17 = i14 - 1;
            int i18 = i12 + 5;
            while (true) {
                if (i17 >= 0 && i18 < this.f25711c && !i(i18, i17)) {
                    m(i17, i18, i13);
                    i13++;
                }
                int i19 = i17 + 2;
                int i20 = i18 - 2;
                i10 = this.f25710b;
                if (i19 >= i10 || i20 < 0) {
                    break;
                }
                i17 = i19;
                i18 = i20;
            }
            i14 = i17 + 5;
            i12 = i18 - 1;
            if (i14 >= i10 && i12 >= (i11 = this.f25711c)) {
                break;
            }
        }
        if (i(i11 - 1, i10 - 1)) {
            return;
        }
        l(this.f25711c - 1, this.f25710b - 1, true);
        l(this.f25711c - 2, this.f25710b - 2, true);
    }

    public final void l(int i10, int i11, boolean z10) {
        this.f25712d[(i11 * this.f25711c) + i10] = z10 ? (byte) 1 : (byte) 0;
    }

    public final void m(int i10, int i11, int i12) {
        int i13 = i10 - 2;
        int i14 = i11 - 2;
        j(i13, i14, i12, 1);
        int i15 = i11 - 1;
        j(i13, i15, i12, 2);
        int i16 = i10 - 1;
        j(i16, i14, i12, 3);
        j(i16, i15, i12, 4);
        j(i16, i11, i12, 5);
        j(i10, i14, i12, 6);
        j(i10, i15, i12, 7);
        j(i10, i11, i12, 8);
    }
}
