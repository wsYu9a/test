package org.mozilla.universalchardet.prober;

import org.mozilla.universalchardet.prober.CharsetProber;

/* loaded from: classes4.dex */
public class l extends CharsetProber {

    /* renamed from: s */
    public static final int f29335s = 64;

    /* renamed from: t */
    public static final int f29336t = 1024;

    /* renamed from: u */
    public static final float f29337u = 0.95f;

    /* renamed from: v */
    public static final float f29338v = 0.05f;

    /* renamed from: w */
    public static final int f29339w = 250;

    /* renamed from: x */
    public static final int f29340x = 4;

    /* renamed from: y */
    public static final int f29341y = 3;

    /* renamed from: z */
    public static final int f29342z = 0;

    /* renamed from: j */
    public CharsetProber.ProbingState f29343j;

    /* renamed from: k */
    public bj.l f29344k;

    /* renamed from: l */
    public boolean f29345l;

    /* renamed from: m */
    public short f29346m;

    /* renamed from: n */
    public int f29347n;

    /* renamed from: o */
    public int[] f29348o;

    /* renamed from: p */
    public int f29349p;

    /* renamed from: q */
    public int f29350q;

    /* renamed from: r */
    public CharsetProber f29351r;

    public l(bj.l lVar) {
        this.f29344k = lVar;
        this.f29345l = false;
        this.f29351r = null;
        this.f29348o = new int[4];
        j();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public String c() {
        CharsetProber charsetProber = this.f29351r;
        return charsetProber == null ? this.f29344k.a() : charsetProber.c();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float d() {
        int i10 = this.f29347n;
        if (i10 <= 0) {
            return 0.01f;
        }
        float e10 = ((((this.f29348o[3] * 1.0f) / i10) / this.f29344k.e()) * this.f29350q) / this.f29349p;
        if (e10 >= 1.0f) {
            return 0.99f;
        }
        return e10;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState e() {
        return this.f29343j;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState f(byte[] bArr, int i10, int i11) {
        int i12 = i11 + i10;
        while (i10 < i12) {
            short c10 = this.f29344k.c(bArr[i10]);
            if (c10 < 250) {
                this.f29349p++;
            }
            if (c10 < 64) {
                this.f29350q++;
                short s10 = this.f29346m;
                if (s10 < 64) {
                    this.f29347n++;
                    if (this.f29345l) {
                        int[] iArr = this.f29348o;
                        byte d10 = this.f29344k.d((c10 * 64) + s10);
                        iArr[d10] = iArr[d10] + 1;
                    } else {
                        int[] iArr2 = this.f29348o;
                        byte d11 = this.f29344k.d((s10 * 64) + c10);
                        iArr2[d11] = iArr2[d11] + 1;
                    }
                }
            }
            this.f29346m = c10;
            i10++;
        }
        if (this.f29343j == CharsetProber.ProbingState.DETECTING && this.f29347n > 1024) {
            float d12 = d();
            if (d12 > 0.95f) {
                this.f29343j = CharsetProber.ProbingState.FOUND_IT;
            } else if (d12 < 0.05f) {
                this.f29343j = CharsetProber.ProbingState.NOT_ME;
            }
        }
        return this.f29343j;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public final void j() {
        this.f29343j = CharsetProber.ProbingState.DETECTING;
        this.f29346m = (short) 255;
        for (int i10 = 0; i10 < 4; i10++) {
            this.f29348o[i10] = 0;
        }
        this.f29347n = 0;
        this.f29349p = 0;
        this.f29350q = 0;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void l() {
    }

    public boolean m() {
        return this.f29344k.b();
    }

    public l(bj.l lVar, boolean z10, CharsetProber charsetProber) {
        this.f29344k = lVar;
        this.f29345l = z10;
        this.f29351r = charsetProber;
        this.f29348o = new int[4];
        j();
    }
}
