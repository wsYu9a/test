package com.ss.android.socialbase.appdownloader.f.a;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
class a implements i {

    /* renamed from: b */
    private d f21883b;

    /* renamed from: d */
    private f f21885d;

    /* renamed from: e */
    private int[] f21886e;

    /* renamed from: g */
    private boolean f21888g;

    /* renamed from: h */
    private int f21889h;

    /* renamed from: i */
    private int f21890i;

    /* renamed from: j */
    private int f21891j;

    /* renamed from: k */
    private int f21892k;

    /* renamed from: l */
    private int[] f21893l;

    /* renamed from: m */
    private int f21894m;

    /* renamed from: n */
    private int f21895n;

    /* renamed from: o */
    private int f21896o;

    /* renamed from: c */
    private boolean f21884c = false;

    /* renamed from: f */
    private C0648a f21887f = new C0648a();

    public a() {
        g();
    }

    private final void g() {
        this.f21889h = -1;
        this.f21890i = -1;
        this.f21891j = -1;
        this.f21892k = -1;
        this.f21893l = null;
        this.f21894m = -1;
        this.f21895n = -1;
        this.f21896o = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x018c, code lost:
    
        throw new java.io.IOException("Invalid chunk type (" + r5 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void h() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 398
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.f.a.a.h():void");
    }

    public void a(InputStream inputStream) {
        a();
        if (inputStream != null) {
            this.f21883b = new d(inputStream, false);
        }
    }

    public int b() throws h, IOException {
        if (this.f21883b == null) {
            throw new h("Parser is not opened.", this, null);
        }
        try {
            h();
            return this.f21889h;
        } catch (IOException e10) {
            a();
            throw e10;
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.f.a.g
    public int c() {
        return this.f21890i;
    }

    @Override // com.ss.android.socialbase.appdownloader.f.a.g
    public String d() {
        return "XML line #" + c();
    }

    public int e() {
        if (this.f21889h != 2) {
            return -1;
        }
        return this.f21893l.length / 5;
    }

    @Override // com.ss.android.socialbase.appdownloader.f.a.g
    public int f() {
        return -1;
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.f.a.a$a */
    public static final class C0648a {

        /* renamed from: a */
        private int[] f21897a = new int[32];

        /* renamed from: b */
        private int f21898b;

        /* renamed from: c */
        private int f21899c;

        public final void a() {
            this.f21898b = 0;
            this.f21899c = 0;
        }

        public final int b() {
            int i10 = this.f21898b;
            if (i10 == 0) {
                return 0;
            }
            return this.f21897a[i10 - 1];
        }

        public final boolean c() {
            int[] iArr;
            int i10;
            int i11 = this.f21898b;
            if (i11 == 0 || (i10 = (iArr = this.f21897a)[i11 - 1]) == 0) {
                return false;
            }
            int i12 = i10 - 1;
            int i13 = i11 - 3;
            iArr[i13] = i12;
            iArr[i13 - ((i12 * 2) + 1)] = i12;
            this.f21898b = i11 - 2;
            return true;
        }

        public final int d() {
            return this.f21899c;
        }

        public final void e() {
            a(2);
            int i10 = this.f21898b;
            int[] iArr = this.f21897a;
            iArr[i10] = 0;
            iArr[i10 + 1] = 0;
            this.f21898b = i10 + 2;
            this.f21899c++;
        }

        public final void f() {
            int i10 = this.f21898b;
            if (i10 != 0) {
                int i11 = this.f21897a[i10 - 1] * 2;
                if ((i10 - 2) - i11 != 0) {
                    this.f21898b = i10 - (i11 + 2);
                    this.f21899c--;
                }
            }
        }

        public final void a(int i10, int i11) {
            if (this.f21899c == 0) {
                e();
            }
            a(2);
            int i12 = this.f21898b;
            int i13 = i12 - 1;
            int[] iArr = this.f21897a;
            int i14 = iArr[i13];
            int i15 = (i12 - 2) - (i14 * 2);
            int i16 = i14 + 1;
            iArr[i15] = i16;
            iArr[i13] = i10;
            iArr[i12] = i11;
            iArr[i12 + 1] = i16;
            this.f21898b = i12 + 2;
        }

        private void a(int i10) {
            int[] iArr = this.f21897a;
            int length = iArr.length;
            int i11 = this.f21898b;
            int i12 = length - i11;
            if (i12 <= i10) {
                int[] iArr2 = new int[(iArr.length + i12) * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i11);
                this.f21897a = iArr2;
            }
        }
    }

    private final int e(int i10) {
        if (this.f21889h != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i11 = i10 * 5;
        if (i11 < this.f21893l.length) {
            return i11;
        }
        throw new IndexOutOfBoundsException("Invalid attribute index (" + i10 + ").");
    }

    public int c(int i10) {
        return this.f21893l[e(i10) + 4];
    }

    public String d(int i10) {
        int e10 = e(i10);
        int[] iArr = this.f21893l;
        if (iArr[e10 + 3] == 3) {
            return this.f21885d.a(iArr[e10 + 2]);
        }
        int i11 = iArr[e10 + 4];
        return "";
    }

    public void a() {
        if (this.f21884c) {
            this.f21884c = false;
            this.f21883b.a();
            this.f21883b = null;
            this.f21885d = null;
            this.f21886e = null;
            this.f21887f.a();
            g();
        }
    }

    public int b(int i10) {
        return this.f21893l[e(i10) + 3];
    }

    public String a(int i10) {
        int i11 = this.f21893l[e(i10) + 1];
        return i11 == -1 ? "" : this.f21885d.a(i11);
    }
}
