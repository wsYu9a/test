package t5;

/* loaded from: classes2.dex */
public abstract class e {

    /* renamed from: a */
    public final int f30704a;

    /* renamed from: b */
    public final int f30705b;

    public e(int i10, int i11) {
        this.f30704a = i10;
        this.f30705b = i11;
    }

    public e a(int i10, int i11, int i12, int i13) {
        throw new UnsupportedOperationException("This luminance source does not support cropping.");
    }

    public final int b() {
        return this.f30705b;
    }

    public abstract byte[] c();

    public abstract byte[] d(int i10, byte[] bArr);

    public final int e() {
        return this.f30704a;
    }

    public e f() {
        return new d(this);
    }

    public boolean g() {
        return false;
    }

    public boolean h() {
        return false;
    }

    public e i() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public e j() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 45 degrees.");
    }

    public final String toString() {
        int i10 = this.f30704a;
        byte[] bArr = new byte[i10];
        StringBuilder sb2 = new StringBuilder(this.f30705b * (i10 + 1));
        for (int i11 = 0; i11 < this.f30705b; i11++) {
            bArr = d(i11, bArr);
            for (int i12 = 0; i12 < this.f30704a; i12++) {
                int i13 = bArr[i12] & 255;
                sb2.append(i13 < 64 ? '#' : i13 < 128 ? '+' : i13 < 192 ? '.' : b5.a.O);
            }
            sb2.append('\n');
        }
        return sb2.toString();
    }
}
