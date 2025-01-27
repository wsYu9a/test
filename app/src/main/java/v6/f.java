package v6;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;

/* loaded from: classes2.dex */
public final class f {

    /* renamed from: f */
    public static final int f31251f = 8;

    /* renamed from: a */
    public Mode f31252a;

    /* renamed from: b */
    public ErrorCorrectionLevel f31253b;

    /* renamed from: c */
    public t6.f f31254c;

    /* renamed from: d */
    public int f31255d = -1;

    /* renamed from: e */
    public b f31256e;

    public static boolean f(int i10) {
        return i10 >= 0 && i10 < 8;
    }

    public ErrorCorrectionLevel a() {
        return this.f31253b;
    }

    public int b() {
        return this.f31255d;
    }

    public b c() {
        return this.f31256e;
    }

    public Mode d() {
        return this.f31252a;
    }

    public t6.f e() {
        return this.f31254c;
    }

    public void g(ErrorCorrectionLevel errorCorrectionLevel) {
        this.f31253b = errorCorrectionLevel;
    }

    public void h(int i10) {
        this.f31255d = i10;
    }

    public void i(b bVar) {
        this.f31256e = bVar;
    }

    public void j(Mode mode) {
        this.f31252a = mode;
    }

    public void k(t6.f fVar) {
        this.f31254c = fVar;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(200);
        sb2.append("<<\n");
        sb2.append(" mode: ");
        sb2.append(this.f31252a);
        sb2.append("\n ecLevel: ");
        sb2.append(this.f31253b);
        sb2.append("\n version: ");
        sb2.append(this.f31254c);
        sb2.append("\n maskPattern: ");
        sb2.append(this.f31255d);
        if (this.f31256e == null) {
            sb2.append("\n matrix: null\n");
        } else {
            sb2.append("\n matrix:\n");
            sb2.append(this.f31256e);
        }
        sb2.append(">>\n");
        return sb2.toString();
    }
}
