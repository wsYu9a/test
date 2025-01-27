package m6;

import com.google.zxing.FormatException;

/* loaded from: classes2.dex */
public final class o extends p {

    /* renamed from: d */
    public static final int f28515d = 10;

    /* renamed from: b */
    public final int f28516b;

    /* renamed from: c */
    public final int f28517c;

    public o(int i10, int i11, int i12) throws FormatException {
        super(i10);
        if (i11 < 0 || i11 > 10 || i12 < 0 || i12 > 10) {
            throw FormatException.getFormatInstance();
        }
        this.f28516b = i11;
        this.f28517c = i12;
    }

    public int b() {
        return this.f28516b;
    }

    public int c() {
        return this.f28517c;
    }

    public int d() {
        return (this.f28516b * 10) + this.f28517c;
    }

    public boolean e() {
        return this.f28516b == 10 || this.f28517c == 10;
    }

    public boolean f() {
        return this.f28516b == 10;
    }

    public boolean g() {
        return this.f28517c == 10;
    }
}
