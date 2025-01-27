package com.google.zxing.common.reedsolomon;

import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    public static final a f8344a = new a(4201, 4096, 1);

    /* renamed from: b */
    public static final a f8345b = new a(DownloadErrorCode.ERROR_CHUNK_NOT_EQUALS_CACHE, 1024, 1);

    /* renamed from: c */
    public static final a f8346c;

    /* renamed from: d */
    public static final a f8347d;

    /* renamed from: e */
    public static final a f8348e;

    /* renamed from: f */
    public static final a f8349f;

    /* renamed from: g */
    public static final a f8350g;

    /* renamed from: h */
    public static final a f8351h;

    /* renamed from: i */
    private final int[] f8352i;

    /* renamed from: j */
    private final int[] f8353j;
    private final b k;
    private final b l;
    private final int m;
    private final int n;
    private final int o;

    static {
        a aVar = new a(67, 64, 1);
        f8346c = aVar;
        f8347d = new a(19, 16, 1);
        f8348e = new a(285, 256, 0);
        a aVar2 = new a(301, 256, 1);
        f8349f = aVar2;
        f8350g = aVar2;
        f8351h = aVar;
    }

    public a(int i2, int i3, int i4) {
        this.n = i2;
        this.m = i3;
        this.o = i4;
        this.f8352i = new int[i3];
        this.f8353j = new int[i3];
        int i5 = 1;
        for (int i6 = 0; i6 < i3; i6++) {
            this.f8352i[i6] = i5;
            i5 <<= 1;
            if (i5 >= i3) {
                i5 = (i5 ^ i2) & (i3 - 1);
            }
        }
        for (int i7 = 0; i7 < i3 - 1; i7++) {
            this.f8353j[this.f8352i[i7]] = i7;
        }
        this.k = new b(this, new int[]{0});
        this.l = new b(this, new int[]{1});
    }

    static int a(int i2, int i3) {
        return i2 ^ i3;
    }

    b b(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (i3 == 0) {
            return this.k;
        }
        int[] iArr = new int[i2 + 1];
        iArr[0] = i3;
        return new b(this, iArr);
    }

    int c(int i2) {
        return this.f8352i[i2];
    }

    public int d() {
        return this.o;
    }

    b e() {
        return this.l;
    }

    public int f() {
        return this.m;
    }

    b g() {
        return this.k;
    }

    int h(int i2) {
        if (i2 != 0) {
            return this.f8352i[(this.m - this.f8353j[i2]) - 1];
        }
        throw new ArithmeticException();
    }

    int i(int i2) {
        if (i2 != 0) {
            return this.f8353j[i2];
        }
        throw new IllegalArgumentException();
    }

    int j(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = this.f8352i;
        int[] iArr2 = this.f8353j;
        return iArr[(iArr2[i2] + iArr2[i3]) % (this.m - 1)];
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.n) + ',' + this.m + ')';
    }
}
