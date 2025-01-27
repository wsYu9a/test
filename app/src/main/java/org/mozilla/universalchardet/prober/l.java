package org.mozilla.universalchardet.prober;

import org.mozilla.universalchardet.prober.CharsetProber;

/* loaded from: classes5.dex */
public class l extends CharsetProber {

    /* renamed from: i */
    public static final int f35446i = 64;

    /* renamed from: j */
    public static final int f35447j = 1024;
    public static final float k = 0.95f;
    public static final float l = 0.05f;
    public static final int m = 250;
    public static final int n = 4;
    public static final int o = 3;
    public static final int p = 0;
    private CharsetProber.ProbingState q;
    private org.mozilla.universalchardet.prober.p.l r;
    private boolean s;
    private short t;
    private int u;
    private int[] v;
    private int w;
    private int x;
    private CharsetProber y;

    public l(org.mozilla.universalchardet.prober.p.l lVar) {
        this.r = lVar;
        this.s = false;
        this.y = null;
        this.v = new int[4];
        i();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public String c() {
        CharsetProber charsetProber = this.y;
        return charsetProber == null ? this.r.a() : charsetProber.c();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float d() {
        int i2 = this.u;
        if (i2 <= 0) {
            return 0.01f;
        }
        float e2 = ((((this.v[3] * 1.0f) / i2) / this.r.e()) * this.x) / this.w;
        if (e2 >= 1.0f) {
            return 0.99f;
        }
        return e2;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState e() {
        return this.q;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState f(byte[] bArr, int i2, int i3) {
        int i4 = i3 + i2;
        while (i2 < i4) {
            short c2 = this.r.c(bArr[i2]);
            if (c2 < 250) {
                this.w++;
            }
            if (c2 < 64) {
                this.x++;
                short s = this.t;
                if (s < 64) {
                    this.u++;
                    if (this.s) {
                        int[] iArr = this.v;
                        byte d2 = this.r.d((c2 * 64) + s);
                        iArr[d2] = iArr[d2] + 1;
                    } else {
                        int[] iArr2 = this.v;
                        byte d3 = this.r.d((s * 64) + c2);
                        iArr2[d3] = iArr2[d3] + 1;
                    }
                }
            }
            this.t = c2;
            i2++;
        }
        if (this.q == CharsetProber.ProbingState.DETECTING && this.u > 1024) {
            float d4 = d();
            if (d4 > 0.95f) {
                this.q = CharsetProber.ProbingState.FOUND_IT;
            } else if (d4 < 0.05f) {
                this.q = CharsetProber.ProbingState.NOT_ME;
            }
        }
        return this.q;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void i() {
        this.q = CharsetProber.ProbingState.DETECTING;
        this.t = (short) 255;
        for (int i2 = 0; i2 < 4; i2++) {
            this.v[i2] = 0;
        }
        this.u = 0;
        this.w = 0;
        this.x = 0;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void j() {
    }

    boolean k() {
        return this.r.b();
    }

    public l(org.mozilla.universalchardet.prober.p.l lVar, boolean z, CharsetProber charsetProber) {
        this.r = lVar;
        this.s = z;
        this.y = charsetProber;
        this.v = new int[4];
        i();
    }
}
