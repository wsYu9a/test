package t5;

/* loaded from: classes2.dex */
public final class h extends e {

    /* renamed from: h */
    public static final int f30709h = 2;

    /* renamed from: c */
    public final byte[] f30710c;

    /* renamed from: d */
    public final int f30711d;

    /* renamed from: e */
    public final int f30712e;

    /* renamed from: f */
    public final int f30713f;

    /* renamed from: g */
    public final int f30714g;

    public h(byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15, boolean z10) {
        super(i14, i15);
        if (i12 + i14 > i10 || i13 + i15 > i11) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f30710c = bArr;
        this.f30711d = i10;
        this.f30712e = i11;
        this.f30713f = i12;
        this.f30714g = i13;
        if (z10) {
            n(i14, i15);
        }
    }

    @Override // t5.e
    public e a(int i10, int i11, int i12, int i13) {
        return new h(this.f30710c, this.f30711d, this.f30712e, this.f30713f + i10, this.f30714g + i11, i12, i13, false);
    }

    @Override // t5.e
    public byte[] c() {
        int e10 = e();
        int b10 = b();
        int i10 = this.f30711d;
        if (e10 == i10 && b10 == this.f30712e) {
            return this.f30710c;
        }
        int i11 = e10 * b10;
        byte[] bArr = new byte[i11];
        int i12 = (this.f30714g * i10) + this.f30713f;
        if (e10 == i10) {
            System.arraycopy(this.f30710c, i12, bArr, 0, i11);
            return bArr;
        }
        for (int i13 = 0; i13 < b10; i13++) {
            System.arraycopy(this.f30710c, i12, bArr, i13 * e10, e10);
            i12 += this.f30711d;
        }
        return bArr;
    }

    @Override // t5.e
    public byte[] d(int i10, byte[] bArr) {
        if (i10 < 0 || i10 >= b()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i10);
        }
        int e10 = e();
        if (bArr == null || bArr.length < e10) {
            bArr = new byte[e10];
        }
        System.arraycopy(this.f30710c, ((i10 + this.f30714g) * this.f30711d) + this.f30713f, bArr, 0, e10);
        return bArr;
    }

    @Override // t5.e
    public boolean g() {
        return true;
    }

    public int k() {
        return b() / 2;
    }

    public int l() {
        return e() / 2;
    }

    public int[] m() {
        int e10 = e() / 2;
        int b10 = b() / 2;
        int[] iArr = new int[e10 * b10];
        byte[] bArr = this.f30710c;
        int i10 = (this.f30714g * this.f30711d) + this.f30713f;
        for (int i11 = 0; i11 < b10; i11++) {
            int i12 = i11 * e10;
            for (int i13 = 0; i13 < e10; i13++) {
                iArr[i12 + i13] = ((bArr[(i13 << 1) + i10] & 255) * 65793) | (-16777216);
            }
            i10 += this.f30711d << 1;
        }
        return iArr;
    }

    public final void n(int i10, int i11) {
        byte[] bArr = this.f30710c;
        int i12 = (this.f30714g * this.f30711d) + this.f30713f;
        int i13 = 0;
        while (i13 < i11) {
            int i14 = (i10 / 2) + i12;
            int i15 = (i12 + i10) - 1;
            int i16 = i12;
            while (i16 < i14) {
                byte b10 = bArr[i16];
                bArr[i16] = bArr[i15];
                bArr[i15] = b10;
                i16++;
                i15--;
            }
            i13++;
            i12 += this.f30711d;
        }
    }
}
