package b6;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: h */
    public static final a f1284h = new a(TTAdConstant.INIT_FAILED_CREATE_INITIALIZER_FAILED, 4096, 1);

    /* renamed from: i */
    public static final a f1285i = new a(DownloadErrorCode.ERROR_CHUNK_NOT_EQUALS_CACHE, 1024, 1);

    /* renamed from: j */
    public static final a f1286j;

    /* renamed from: k */
    public static final a f1287k;

    /* renamed from: l */
    public static final a f1288l;

    /* renamed from: m */
    public static final a f1289m;

    /* renamed from: n */
    public static final a f1290n;

    /* renamed from: o */
    public static final a f1291o;

    /* renamed from: a */
    public final int[] f1292a;

    /* renamed from: b */
    public final int[] f1293b;

    /* renamed from: c */
    public final b f1294c;

    /* renamed from: d */
    public final b f1295d;

    /* renamed from: e */
    public final int f1296e;

    /* renamed from: f */
    public final int f1297f;

    /* renamed from: g */
    public final int f1298g;

    static {
        a aVar = new a(67, 64, 1);
        f1286j = aVar;
        f1287k = new a(19, 16, 1);
        f1288l = new a(285, 256, 0);
        a aVar2 = new a(301, 256, 1);
        f1289m = aVar2;
        f1290n = aVar2;
        f1291o = aVar;
    }

    public a(int i10, int i11, int i12) {
        this.f1297f = i10;
        this.f1296e = i11;
        this.f1298g = i12;
        this.f1292a = new int[i11];
        this.f1293b = new int[i11];
        int i13 = 1;
        for (int i14 = 0; i14 < i11; i14++) {
            this.f1292a[i14] = i13;
            i13 <<= 1;
            if (i13 >= i11) {
                i13 = (i13 ^ i10) & (i11 - 1);
            }
        }
        for (int i15 = 0; i15 < i11 - 1; i15++) {
            this.f1293b[this.f1292a[i15]] = i15;
        }
        this.f1294c = new b(this, new int[]{0});
        this.f1295d = new b(this, new int[]{1});
    }

    public static int a(int i10, int i11) {
        return i10 ^ i11;
    }

    public b b(int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException();
        }
        if (i11 == 0) {
            return this.f1294c;
        }
        int[] iArr = new int[i10 + 1];
        iArr[0] = i11;
        return new b(this, iArr);
    }

    public int c(int i10) {
        return this.f1292a[i10];
    }

    public int d() {
        return this.f1298g;
    }

    public b e() {
        return this.f1295d;
    }

    public int f() {
        return this.f1296e;
    }

    public b g() {
        return this.f1294c;
    }

    public int h(int i10) {
        if (i10 != 0) {
            return this.f1292a[(this.f1296e - this.f1293b[i10]) - 1];
        }
        throw new ArithmeticException();
    }

    public int i(int i10) {
        if (i10 != 0) {
            return this.f1293b[i10];
        }
        throw new IllegalArgumentException();
    }

    public int j(int i10, int i11) {
        if (i10 == 0 || i11 == 0) {
            return 0;
        }
        int[] iArr = this.f1292a;
        int[] iArr2 = this.f1293b;
        return iArr[(iArr2[i10] + iArr2[i11]) % (this.f1296e - 1)];
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f1297f) + ',' + this.f1296e + ')';
    }
}
