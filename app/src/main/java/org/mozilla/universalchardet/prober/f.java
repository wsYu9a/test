package org.mozilla.universalchardet.prober;

import java.util.Arrays;
import org.mozilla.universalchardet.prober.CharsetProber;

/* loaded from: classes5.dex */
public class f extends CharsetProber {

    /* renamed from: i */
    private static final org.mozilla.universalchardet.prober.q.m f35434i = new org.mozilla.universalchardet.prober.q.f();
    private CharsetProber.ProbingState k;

    /* renamed from: j */
    private org.mozilla.universalchardet.prober.q.b f35435j = new org.mozilla.universalchardet.prober.q.b(f35434i);
    private org.mozilla.universalchardet.prober.o.f l = new org.mozilla.universalchardet.prober.o.f();
    private byte[] m = new byte[2];

    public f() {
        i();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public String c() {
        return org.mozilla.universalchardet.b.f35413h;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float d() {
        return this.l.a();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState e() {
        return this.k;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState f(byte[] bArr, int i2, int i3) {
        int i4 = i3 + i2;
        int i5 = i2;
        while (true) {
            if (i5 >= i4) {
                break;
            }
            int c2 = this.f35435j.c(bArr[i5]);
            if (c2 == 1) {
                this.k = CharsetProber.ProbingState.NOT_ME;
                break;
            }
            if (c2 == 2) {
                this.k = CharsetProber.ProbingState.FOUND_IT;
                break;
            }
            if (c2 == 0) {
                int b2 = this.f35435j.b();
                if (i5 == i2) {
                    byte[] bArr2 = this.m;
                    bArr2[1] = bArr[i2];
                    this.l.e(bArr2, 0, b2);
                } else {
                    this.l.e(bArr, i5 - 1, b2);
                }
            }
            i5++;
        }
        this.m[0] = bArr[i4 - 1];
        if (this.k == CharsetProber.ProbingState.DETECTING && this.l.c() && d() > 0.95f) {
            this.k = CharsetProber.ProbingState.FOUND_IT;
        }
        return this.k;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void i() {
        this.f35435j.d();
        this.k = CharsetProber.ProbingState.DETECTING;
        this.l.f();
        Arrays.fill(this.m, (byte) 0);
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void j() {
    }
}
