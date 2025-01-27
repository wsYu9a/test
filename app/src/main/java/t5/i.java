package t5;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* loaded from: classes2.dex */
public final class i extends e {

    /* renamed from: c */
    public final byte[] f30715c;

    /* renamed from: d */
    public final int f30716d;

    /* renamed from: e */
    public final int f30717e;

    /* renamed from: f */
    public final int f30718f;

    /* renamed from: g */
    public final int f30719g;

    public i(int i10, int i11, int[] iArr) {
        super(i10, i11);
        this.f30716d = i10;
        this.f30717e = i11;
        this.f30718f = 0;
        this.f30719g = 0;
        int i12 = i10 * i11;
        this.f30715c = new byte[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = iArr[i13];
            this.f30715c[i13] = (byte) (((((i14 >> 16) & 255) + ((i14 >> 7) & TypedValues.PositionType.TYPE_POSITION_TYPE)) + (i14 & 255)) / 4);
        }
    }

    @Override // t5.e
    public e a(int i10, int i11, int i12, int i13) {
        return new i(this.f30715c, this.f30716d, this.f30717e, this.f30718f + i10, this.f30719g + i11, i12, i13);
    }

    @Override // t5.e
    public byte[] c() {
        int e10 = e();
        int b10 = b();
        int i10 = this.f30716d;
        if (e10 == i10 && b10 == this.f30717e) {
            return this.f30715c;
        }
        int i11 = e10 * b10;
        byte[] bArr = new byte[i11];
        int i12 = (this.f30719g * i10) + this.f30718f;
        if (e10 == i10) {
            System.arraycopy(this.f30715c, i12, bArr, 0, i11);
            return bArr;
        }
        for (int i13 = 0; i13 < b10; i13++) {
            System.arraycopy(this.f30715c, i12, bArr, i13 * e10, e10);
            i12 += this.f30716d;
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
        System.arraycopy(this.f30715c, ((i10 + this.f30719g) * this.f30716d) + this.f30718f, bArr, 0, e10);
        return bArr;
    }

    @Override // t5.e
    public boolean g() {
        return true;
    }

    public i(byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15) {
        super(i14, i15);
        if (i14 + i12 <= i10 && i15 + i13 <= i11) {
            this.f30715c = bArr;
            this.f30716d = i10;
            this.f30717e = i11;
            this.f30718f = i12;
            this.f30719g = i13;
            return;
        }
        throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
    }
}
