package e6;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;

/* loaded from: classes2.dex */
public class k {

    /* renamed from: i */
    public static final k[] f25747i;

    /* renamed from: j */
    public static k[] f25748j;

    /* renamed from: a */
    public final boolean f25749a;

    /* renamed from: b */
    public final int f25750b;

    /* renamed from: c */
    public final int f25751c;

    /* renamed from: d */
    public final int f25752d;

    /* renamed from: e */
    public final int f25753e;

    /* renamed from: f */
    public final int f25754f;

    /* renamed from: g */
    public final int f25755g;

    /* renamed from: h */
    public final int f25756h;

    static {
        k[] kVarArr = {new k(false, 3, 5, 8, 8, 1), new k(false, 5, 7, 10, 10, 1), new k(true, 5, 7, 16, 6, 1), new k(false, 8, 10, 12, 12, 1), new k(true, 10, 11, 14, 6, 2), new k(false, 12, 12, 14, 14, 1), new k(true, 16, 14, 24, 10, 1), new k(false, 18, 14, 16, 16, 1), new k(false, 22, 18, 18, 18, 1), new k(true, 22, 18, 16, 10, 2), new k(false, 30, 20, 20, 20, 1), new k(true, 32, 24, 16, 14, 2), new k(false, 36, 24, 22, 22, 1), new k(false, 44, 28, 24, 24, 1), new k(true, 49, 28, 22, 14, 2), new k(false, 62, 36, 14, 14, 4), new k(false, 86, 42, 16, 16, 4), new k(false, 114, 48, 18, 18, 4), new k(false, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_HEADERS, 56, 20, 20, 4), new k(false, 174, 68, 22, 22, 4), new k(false, 204, 84, 24, 24, 4, 102, 42), new k(false, 280, 112, 14, 14, 16, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL, 56), new k(false, 368, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_HEADERS, 16, 16, 16, 92, 36), new k(false, 456, 192, 18, 18, 16, 114, 48), new k(false, 576, 224, 20, 20, 16, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_HEADERS, 56), new k(false, 696, 272, 22, 22, 16, 174, 68), new k(false, 816, 336, 24, 24, 16, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME, 56), new k(false, DownloadErrorCode.ERROR_NO_SDCARD_PERMISSION, TTAdConstant.INTERACTION_TYPE_CODE, 18, 18, 36, 175, 68), new k(false, 1304, 496, 20, 20, 36, 163, 62), new d()};
        f25747i = kVarArr;
        f25748j = kVarArr;
    }

    public k(boolean z10, int i10, int i11, int i12, int i13, int i14) {
        this(z10, i10, i11, i12, i13, i14, i10, i11);
    }

    public static k m(int i10) {
        return p(i10, SymbolShapeHint.FORCE_NONE, true);
    }

    public static k n(int i10, SymbolShapeHint symbolShapeHint) {
        return p(i10, symbolShapeHint, true);
    }

    public static k o(int i10, SymbolShapeHint symbolShapeHint, t5.c cVar, t5.c cVar2, boolean z10) {
        for (k kVar : f25748j) {
            if (!(symbolShapeHint == SymbolShapeHint.FORCE_SQUARE && kVar.f25749a) && ((symbolShapeHint != SymbolShapeHint.FORCE_RECTANGLE || kVar.f25749a) && ((cVar == null || (kVar.k() >= cVar.b() && kVar.j() >= cVar.a())) && ((cVar2 == null || (kVar.k() <= cVar2.b() && kVar.j() <= cVar2.a())) && i10 <= kVar.f25750b)))) {
                return kVar;
            }
        }
        if (!z10) {
            return null;
        }
        throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: " + i10);
    }

    public static k p(int i10, SymbolShapeHint symbolShapeHint, boolean z10) {
        return o(i10, symbolShapeHint, null, null, z10);
    }

    public static k q(int i10, boolean z10, boolean z11) {
        return p(i10, z10 ? SymbolShapeHint.FORCE_NONE : SymbolShapeHint.FORCE_SQUARE, z11);
    }

    public static void r(k[] kVarArr) {
        f25748j = kVarArr;
    }

    public int a() {
        return this.f25750b + this.f25751c;
    }

    public final int b() {
        return this.f25750b;
    }

    public int c(int i10) {
        return this.f25755g;
    }

    public final int d() {
        return this.f25751c;
    }

    public final int e(int i10) {
        return this.f25756h;
    }

    public final int f() {
        int i10 = this.f25754f;
        int i11 = 1;
        if (i10 != 1) {
            i11 = 2;
            if (i10 != 2 && i10 != 4) {
                if (i10 == 16) {
                    return 4;
                }
                if (i10 == 36) {
                    return 6;
                }
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
        }
        return i11;
    }

    public int g() {
        return this.f25750b / this.f25755g;
    }

    public final int h() {
        return l() * this.f25753e;
    }

    public final int i() {
        return f() * this.f25752d;
    }

    public final int j() {
        return h() + (l() << 1);
    }

    public final int k() {
        return i() + (f() << 1);
    }

    public final int l() {
        int i10 = this.f25754f;
        if (i10 == 1 || i10 == 2) {
            return 1;
        }
        if (i10 == 4) {
            return 2;
        }
        if (i10 == 16) {
            return 4;
        }
        if (i10 == 36) {
            return 6;
        }
        throw new IllegalStateException("Cannot handle this number of data regions");
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f25749a ? "Rectangular Symbol:" : "Square Symbol:");
        sb2.append(" data region ");
        sb2.append(this.f25752d);
        sb2.append('x');
        sb2.append(this.f25753e);
        sb2.append(", symbol size ");
        sb2.append(k());
        sb2.append('x');
        sb2.append(j());
        sb2.append(", symbol data size ");
        sb2.append(i());
        sb2.append('x');
        sb2.append(h());
        sb2.append(", codewords ");
        sb2.append(this.f25750b);
        sb2.append('+');
        sb2.append(this.f25751c);
        return sb2.toString();
    }

    public k(boolean z10, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        this.f25749a = z10;
        this.f25750b = i10;
        this.f25751c = i11;
        this.f25752d = i12;
        this.f25753e = i13;
        this.f25754f = i14;
        this.f25755g = i15;
        this.f25756h = i16;
    }
}
