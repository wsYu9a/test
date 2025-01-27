package z5;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a */
    public final byte[] f33653a;

    /* renamed from: b */
    public int f33654b;

    /* renamed from: c */
    public int f33655c;

    public c(byte[] bArr) {
        this.f33653a = bArr;
    }

    public int a() {
        return ((this.f33653a.length - this.f33654b) * 8) - this.f33655c;
    }

    public int b() {
        return this.f33655c;
    }

    public int c() {
        return this.f33654b;
    }

    public int d(int i10) {
        if (i10 <= 0 || i10 > 32 || i10 > a()) {
            throw new IllegalArgumentException(String.valueOf(i10));
        }
        int i11 = this.f33655c;
        int i12 = 0;
        if (i11 > 0) {
            int i13 = 8 - i11;
            int i14 = i10 < i13 ? i10 : i13;
            int i15 = i13 - i14;
            byte[] bArr = this.f33653a;
            int i16 = this.f33654b;
            int i17 = (((255 >> (8 - i14)) << i15) & bArr[i16]) >> i15;
            i10 -= i14;
            int i18 = i11 + i14;
            this.f33655c = i18;
            if (i18 == 8) {
                this.f33655c = 0;
                this.f33654b = i16 + 1;
            }
            i12 = i17;
        }
        if (i10 <= 0) {
            return i12;
        }
        while (i10 >= 8) {
            int i19 = i12 << 8;
            byte[] bArr2 = this.f33653a;
            int i20 = this.f33654b;
            i12 = (bArr2[i20] & 255) | i19;
            this.f33654b = i20 + 1;
            i10 -= 8;
        }
        if (i10 <= 0) {
            return i12;
        }
        int i21 = 8 - i10;
        int i22 = (i12 << i10) | ((((255 >> i21) << i21) & this.f33653a[this.f33654b]) >> i21);
        this.f33655c += i10;
        return i22;
    }
}
