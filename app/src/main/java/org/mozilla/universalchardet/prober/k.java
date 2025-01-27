package org.mozilla.universalchardet.prober;

import java.util.Arrays;
import org.mozilla.universalchardet.prober.CharsetProber;

/* loaded from: classes4.dex */
public class k extends CharsetProber {

    /* renamed from: o */
    public static final cj.m f29329o = new cj.l();

    /* renamed from: k */
    public CharsetProber.ProbingState f29331k;

    /* renamed from: j */
    public cj.b f29330j = new cj.b(f29329o);

    /* renamed from: l */
    public zi.c f29332l = new zi.c();

    /* renamed from: m */
    public aj.h f29333m = new aj.h();

    /* renamed from: n */
    public byte[] f29334n = new byte[2];

    public k() {
        j();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public String c() {
        return yi.b.f33515l;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float d() {
        return Math.max(this.f29332l.a(), this.f29333m.a());
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState e() {
        return this.f29331k;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState f(byte[] bArr, int i10, int i11) {
        int i12 = i11 + i10;
        int i13 = i10;
        while (true) {
            if (i13 >= i12) {
                break;
            }
            int c10 = this.f29330j.c(bArr[i13]);
            if (c10 == 1) {
                this.f29331k = CharsetProber.ProbingState.NOT_ME;
                break;
            }
            if (c10 == 2) {
                this.f29331k = CharsetProber.ProbingState.FOUND_IT;
                break;
            }
            if (c10 == 0) {
                int b10 = this.f29330j.b();
                if (i13 == i10) {
                    byte[] bArr2 = this.f29334n;
                    bArr2[1] = bArr[i10];
                    this.f29332l.f(bArr2, 2 - b10, b10);
                    this.f29333m.e(this.f29334n, 0, b10);
                } else {
                    this.f29332l.f(bArr, (i13 + 1) - b10, b10);
                    this.f29333m.e(bArr, i13 - 1, b10);
                }
            }
            i13++;
        }
        this.f29334n[0] = bArr[i12 - 1];
        if (this.f29331k == CharsetProber.ProbingState.DETECTING && this.f29332l.d() && d() > 0.95f) {
            this.f29331k = CharsetProber.ProbingState.FOUND_IT;
        }
        return this.f29331k;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public final void j() {
        this.f29330j.d();
        this.f29331k = CharsetProber.ProbingState.DETECTING;
        this.f29332l.g();
        this.f29333m.f();
        Arrays.fill(this.f29334n, (byte) 0);
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void l() {
    }
}
