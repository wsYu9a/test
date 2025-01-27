package org.mozilla.universalchardet.prober;

import org.mozilla.universalchardet.prober.CharsetProber;
import org.mozilla.universalchardet.prober.q.o;

/* loaded from: classes5.dex */
public class m extends CharsetProber {

    /* renamed from: i */
    public static final float f35448i = 0.5f;

    /* renamed from: j */
    private static final org.mozilla.universalchardet.prober.q.m f35449j = new o();
    private CharsetProber.ProbingState l;
    private int m = 0;
    private org.mozilla.universalchardet.prober.q.b k = new org.mozilla.universalchardet.prober.q.b(f35449j);

    public m() {
        i();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public String c() {
        return org.mozilla.universalchardet.b.u;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float d() {
        float f2 = 0.99f;
        if (this.m >= 6) {
            return 0.99f;
        }
        for (int i2 = 0; i2 < this.m; i2++) {
            f2 *= 0.5f;
        }
        return 1.0f - f2;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState e() {
        return this.l;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState f(byte[] bArr, int i2, int i3) {
        int i4 = i3 + i2;
        while (true) {
            if (i2 >= i4) {
                break;
            }
            int c2 = this.k.c(bArr[i2]);
            if (c2 == 1) {
                this.l = CharsetProber.ProbingState.NOT_ME;
                break;
            }
            if (c2 == 2) {
                this.l = CharsetProber.ProbingState.FOUND_IT;
                break;
            }
            if (c2 == 0 && this.k.b() >= 2) {
                this.m++;
            }
            i2++;
        }
        if (this.l == CharsetProber.ProbingState.DETECTING && d() > 0.95f) {
            this.l = CharsetProber.ProbingState.FOUND_IT;
        }
        return this.l;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void i() {
        this.k.d();
        this.m = 0;
        this.l = CharsetProber.ProbingState.DETECTING;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void j() {
    }
}
