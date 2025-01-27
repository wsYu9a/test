package org.mozilla.universalchardet.prober;

import java.util.Arrays;
import org.mozilla.universalchardet.prober.CharsetProber;

/* loaded from: classes4.dex */
public class d extends CharsetProber {

    /* renamed from: n */
    public static final cj.m f29271n = new cj.e();

    /* renamed from: k */
    public CharsetProber.ProbingState f29273k;

    /* renamed from: j */
    public cj.b f29272j = new cj.b(f29271n);

    /* renamed from: l */
    public aj.e f29274l = new aj.e();

    /* renamed from: m */
    public byte[] f29275m = new byte[2];

    public d() {
        j();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public String c() {
        return yi.b.f33514k;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float d() {
        return this.f29274l.a();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState e() {
        return this.f29273k;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState f(byte[] bArr, int i10, int i11) {
        int i12 = i11 + i10;
        int i13 = i10;
        while (true) {
            if (i13 >= i12) {
                break;
            }
            int c10 = this.f29272j.c(bArr[i13]);
            if (c10 == 1) {
                this.f29273k = CharsetProber.ProbingState.NOT_ME;
                break;
            }
            if (c10 == 2) {
                this.f29273k = CharsetProber.ProbingState.FOUND_IT;
                break;
            }
            if (c10 == 0) {
                int b10 = this.f29272j.b();
                if (i13 == i10) {
                    byte[] bArr2 = this.f29275m;
                    bArr2[1] = bArr[i10];
                    this.f29274l.e(bArr2, 0, b10);
                } else {
                    this.f29274l.e(bArr, i13 - 1, b10);
                }
            }
            i13++;
        }
        this.f29275m[0] = bArr[i12 - 1];
        if (this.f29273k == CharsetProber.ProbingState.DETECTING && this.f29274l.c() && d() > 0.95f) {
            this.f29273k = CharsetProber.ProbingState.FOUND_IT;
        }
        return this.f29273k;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public final void j() {
        this.f29272j.d();
        this.f29273k = CharsetProber.ProbingState.DETECTING;
        this.f29274l.f();
        Arrays.fill(this.f29275m, (byte) 0);
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void l() {
    }
}
