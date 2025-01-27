package w5;

import kotlin.text.Typography;

/* loaded from: classes2.dex */
public final class e extends g {

    /* renamed from: c */
    public final short f31592c;

    /* renamed from: d */
    public final short f31593d;

    public e(g gVar, int i10, int i11) {
        super(gVar);
        this.f31592c = (short) i10;
        this.f31593d = (short) i11;
    }

    @Override // w5.g
    public void c(z5.a aVar, byte[] bArr) {
        aVar.c(this.f31592c, this.f31593d);
    }

    public String toString() {
        short s10 = this.f31592c;
        short s11 = this.f31593d;
        return "<" + Integer.toBinaryString((s10 & ((1 << s11) - 1)) | (1 << s11) | (1 << this.f31593d)).substring(1) + Typography.greater;
    }
}
