package com.google.zxing.datamatrix.encoder;

import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.vivo.ic.dm.Downloads;

/* loaded from: classes.dex */
public class k {

    /* renamed from: a */
    static final k[] f8417a;

    /* renamed from: b */
    private static k[] f8418b;

    /* renamed from: c */
    private final boolean f8419c;

    /* renamed from: d */
    private final int f8420d;

    /* renamed from: e */
    private final int f8421e;

    /* renamed from: f */
    public final int f8422f;

    /* renamed from: g */
    public final int f8423g;

    /* renamed from: h */
    private final int f8424h;

    /* renamed from: i */
    private final int f8425i;

    /* renamed from: j */
    private final int f8426j;

    static {
        k[] kVarArr = {new k(false, 3, 5, 8, 8, 1), new k(false, 5, 7, 10, 10, 1), new k(true, 5, 7, 16, 6, 1), new k(false, 8, 10, 12, 12, 1), new k(true, 10, 11, 14, 6, 2), new k(false, 12, 12, 14, 14, 1), new k(true, 16, 14, 24, 10, 1), new k(false, 18, 14, 16, 16, 1), new k(false, 22, 18, 18, 18, 1), new k(true, 22, 18, 16, 10, 2), new k(false, 30, 20, 20, 20, 1), new k(true, 32, 24, 16, 14, 2), new k(false, 36, 24, 22, 22, 1), new k(false, 44, 28, 24, 24, 1), new k(true, 49, 28, 22, 14, 2), new k(false, 62, 36, 14, 14, 4), new k(false, 86, 42, 16, 16, 4), new k(false, 114, 48, 18, 18, 4), new k(false, 144, 56, 20, 20, 4), new k(false, 174, 68, 22, 22, 4), new k(false, 204, 84, 24, 24, 4, 102, 42), new k(false, 280, 112, 14, 14, 16, 140, 56), new k(false, 368, 144, 16, 16, 16, 92, 36), new k(false, 456, Downloads.Impl.STATUS_RUNNING, 18, 18, 16, 114, 48), new k(false, 576, 224, 20, 20, 16, 144, 56), new k(false, 696, 272, 22, 22, 16, 174, 68), new k(false, 816, 336, 24, 24, 16, 136, 56), new k(false, DownloadErrorCode.ERROR_NO_SDCARD_PERMISSION, 408, 18, 18, 36, 175, 68), new k(false, 1304, Downloads.Impl.STATUS_HTTP_EXCEPTION, 20, 20, 36, 163, 62), new d()};
        f8417a = kVarArr;
        f8418b = kVarArr;
    }

    public k(boolean z, int i2, int i3, int i4, int i5, int i6) {
        this(z, i2, i3, i4, i5, i6, i2, i3);
    }

    private int f() {
        int i2 = this.f8424h;
        int i3 = 1;
        if (i2 != 1) {
            i3 = 2;
            if (i2 != 2 && i2 != 4) {
                if (i2 == 16) {
                    return 4;
                }
                if (i2 == 36) {
                    return 6;
                }
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
        }
        return i3;
    }

    private int l() {
        int i2 = this.f8424h;
        if (i2 == 1 || i2 == 2) {
            return 1;
        }
        if (i2 == 4) {
            return 2;
        }
        if (i2 == 16) {
            return 4;
        }
        if (i2 == 36) {
            return 6;
        }
        throw new IllegalStateException("Cannot handle this number of data regions");
    }

    public static k m(int i2) {
        return p(i2, SymbolShapeHint.FORCE_NONE, true);
    }

    public static k n(int i2, SymbolShapeHint symbolShapeHint) {
        return p(i2, symbolShapeHint, true);
    }

    public static k o(int i2, SymbolShapeHint symbolShapeHint, com.google.zxing.c cVar, com.google.zxing.c cVar2, boolean z) {
        for (k kVar : f8418b) {
            if (!(symbolShapeHint == SymbolShapeHint.FORCE_SQUARE && kVar.f8419c) && ((symbolShapeHint != SymbolShapeHint.FORCE_RECTANGLE || kVar.f8419c) && ((cVar == null || (kVar.k() >= cVar.b() && kVar.j() >= cVar.a())) && ((cVar2 == null || (kVar.k() <= cVar2.b() && kVar.j() <= cVar2.a())) && i2 <= kVar.f8420d)))) {
                return kVar;
            }
        }
        if (!z) {
            return null;
        }
        throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: " + i2);
    }

    private static k p(int i2, SymbolShapeHint symbolShapeHint, boolean z) {
        return o(i2, symbolShapeHint, null, null, z);
    }

    public static k q(int i2, boolean z, boolean z2) {
        return p(i2, z ? SymbolShapeHint.FORCE_NONE : SymbolShapeHint.FORCE_SQUARE, z2);
    }

    public static void r(k[] kVarArr) {
        f8418b = kVarArr;
    }

    public int a() {
        return this.f8420d + this.f8421e;
    }

    public final int b() {
        return this.f8420d;
    }

    public int c(int i2) {
        return this.f8425i;
    }

    public final int d() {
        return this.f8421e;
    }

    public final int e(int i2) {
        return this.f8426j;
    }

    public int g() {
        return this.f8420d / this.f8425i;
    }

    public final int h() {
        return l() * this.f8423g;
    }

    public final int i() {
        return f() * this.f8422f;
    }

    public final int j() {
        return h() + (l() << 1);
    }

    public final int k() {
        return i() + (f() << 1);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8419c ? "Rectangular Symbol:" : "Square Symbol:");
        sb.append(" data region ");
        sb.append(this.f8422f);
        sb.append('x');
        sb.append(this.f8423g);
        sb.append(", symbol size ");
        sb.append(k());
        sb.append('x');
        sb.append(j());
        sb.append(", symbol data size ");
        sb.append(i());
        sb.append('x');
        sb.append(h());
        sb.append(", codewords ");
        sb.append(this.f8420d);
        sb.append('+');
        sb.append(this.f8421e);
        return sb.toString();
    }

    k(boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f8419c = z;
        this.f8420d = i2;
        this.f8421e = i3;
        this.f8422f = i4;
        this.f8423g = i5;
        this.f8424h = i6;
        this.f8425i = i7;
        this.f8426j = i8;
    }
}
