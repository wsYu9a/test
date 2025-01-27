package r2;

/* loaded from: classes.dex */
public class a extends p2.a {

    /* renamed from: d */
    public static final /* synthetic */ boolean f30219d = true;

    public a(byte[] bArr) {
        super(bArr);
    }

    public static a c(String str, long j10, b bVar, short s10, e eVar) throws Exception {
        byte[] c10 = p2.c.c((byte) 1);
        boolean z10 = f30219d;
        if (!z10 && c10.length != 1) {
            throw new AssertionError();
        }
        byte[] e10 = p2.c.e(str.charAt(0), str.charAt(1));
        if (!z10 && e10.length != 2) {
            throw new AssertionError();
        }
        byte[] g10 = p2.c.g(j10);
        if (!z10 && g10.length != 8) {
            throw new AssertionError();
        }
        byte[] k10 = p2.c.k();
        if (!z10 && k10.length != 2) {
            throw new AssertionError();
        }
        bVar.a();
        byte[] c11 = p2.c.c(bVar.f30222a);
        if (!z10 && c11.length != 1) {
            throw new AssertionError();
        }
        byte[] c12 = p2.c.c(bVar.f30223b);
        if (!z10 && c12.length != 1) {
            throw new AssertionError();
        }
        byte[] bArr = (byte[]) bVar.f30224c.clone();
        if (!z10 && bArr.length != (bVar.f30223b & 255)) {
            throw new AssertionError();
        }
        byte[] h10 = p2.c.h(s10);
        if (!z10 && h10.length != 2) {
            throw new AssertionError();
        }
        byte[] k11 = p2.c.k();
        if (!z10 && k11.length != 2) {
            throw new AssertionError();
        }
        eVar.a();
        byte[] c13 = p2.c.c(eVar.f30226a);
        if (!z10 && c13.length != 1) {
            throw new AssertionError();
        }
        byte[] bArr2 = (byte[]) eVar.f30227b.clone();
        if (!z10 && bArr2.length != (eVar.f30226a & 255)) {
            throw new AssertionError();
        }
        byte[] l10 = p2.c.l();
        if (z10 || l10.length == 4) {
            return new a(p2.c.i(c10, e10, g10, k10, c11, c12, bArr, h10, k11, c13, bArr2, l10));
        }
        throw new AssertionError();
    }

    public static a d() {
        try {
            return c(p2.a.f29710c, 0L, new c(""), (short) 0, new f());
        } catch (Exception unused) {
            return null;
        }
    }
}
