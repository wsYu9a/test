package org.mozilla.universalchardet.prober;

import java.util.Arrays;
import org.mozilla.universalchardet.prober.CharsetProber;

/* loaded from: classes4.dex */
public class a extends CharsetProber {

    /* renamed from: n */
    public static final cj.m f29255n = new cj.a();

    /* renamed from: k */
    public CharsetProber.ProbingState f29257k;

    /* renamed from: j */
    public cj.b f29256j = new cj.b(f29255n);

    /* renamed from: l */
    public aj.a f29258l = new aj.a();

    /* renamed from: m */
    public byte[] f29259m = new byte[2];

    public a() {
        j();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public String c() {
        return yi.b.f33510g;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float d() {
        return this.f29258l.a();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState e() {
        return this.f29257k;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState f(byte[] bArr, int i10, int i11) {
        int i12 = i11 + i10;
        int i13 = i10;
        while (true) {
            if (i13 >= i12) {
                break;
            }
            int c10 = this.f29256j.c(bArr[i13]);
            if (c10 == 1) {
                this.f29257k = CharsetProber.ProbingState.NOT_ME;
                break;
            }
            if (c10 == 2) {
                this.f29257k = CharsetProber.ProbingState.FOUND_IT;
                break;
            }
            if (c10 == 0) {
                int b10 = this.f29256j.b();
                if (i13 == i10) {
                    byte[] bArr2 = this.f29259m;
                    bArr2[1] = bArr[i10];
                    this.f29258l.e(bArr2, 0, b10);
                } else {
                    this.f29258l.e(bArr, i13 - 1, b10);
                }
            }
            i13++;
        }
        this.f29259m[0] = bArr[i12 - 1];
        if (this.f29257k == CharsetProber.ProbingState.DETECTING && this.f29258l.c() && d() > 0.95f) {
            this.f29257k = CharsetProber.ProbingState.FOUND_IT;
        }
        return this.f29257k;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public final void j() {
        this.f29256j.d();
        this.f29257k = CharsetProber.ProbingState.DETECTING;
        this.f29258l.f();
        Arrays.fill(this.f29259m, (byte) 0);
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void l() {
    }
}
