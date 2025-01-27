package org.mozilla.universalchardet.prober;

import cj.o;
import org.mozilla.universalchardet.prober.CharsetProber;

/* loaded from: classes4.dex */
public class m extends CharsetProber {

    /* renamed from: m */
    public static final float f29352m = 0.5f;

    /* renamed from: n */
    public static final cj.m f29353n = new o();

    /* renamed from: k */
    public CharsetProber.ProbingState f29355k;

    /* renamed from: l */
    public int f29356l = 0;

    /* renamed from: j */
    public cj.b f29354j = new cj.b(f29353n);

    public m() {
        j();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public String c() {
        return yi.b.f33524u;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float d() {
        float f10 = 0.99f;
        if (this.f29356l >= 6) {
            return 0.99f;
        }
        for (int i10 = 0; i10 < this.f29356l; i10++) {
            f10 *= 0.5f;
        }
        return 1.0f - f10;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState e() {
        return this.f29355k;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState f(byte[] bArr, int i10, int i11) {
        int i12 = i11 + i10;
        while (true) {
            if (i10 >= i12) {
                break;
            }
            int c10 = this.f29354j.c(bArr[i10]);
            if (c10 == 1) {
                this.f29355k = CharsetProber.ProbingState.NOT_ME;
                break;
            }
            if (c10 == 2) {
                this.f29355k = CharsetProber.ProbingState.FOUND_IT;
                break;
            }
            if (c10 == 0 && this.f29354j.b() >= 2) {
                this.f29356l++;
            }
            i10++;
        }
        if (this.f29355k == CharsetProber.ProbingState.DETECTING && d() > 0.95f) {
            this.f29355k = CharsetProber.ProbingState.FOUND_IT;
        }
        return this.f29355k;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public final void j() {
        this.f29354j.d();
        this.f29356l = 0;
        this.f29355k = CharsetProber.ProbingState.DETECTING;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void l() {
    }
}
