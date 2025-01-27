package org.mozilla.universalchardet.prober;

import java.util.Arrays;
import org.mozilla.universalchardet.prober.CharsetProber;

/* loaded from: classes4.dex */
public class b extends CharsetProber {

    /* renamed from: o */
    public static final cj.m f29260o = new cj.c();

    /* renamed from: k */
    public CharsetProber.ProbingState f29262k;

    /* renamed from: j */
    public cj.b f29261j = new cj.b(f29260o);

    /* renamed from: l */
    public zi.a f29263l = new zi.a();

    /* renamed from: m */
    public aj.c f29264m = new aj.c();

    /* renamed from: n */
    public byte[] f29265n = new byte[2];

    public b() {
        j();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public String c() {
        return yi.b.f33512i;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float d() {
        return Math.max(this.f29263l.a(), this.f29264m.a());
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState e() {
        return this.f29262k;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState f(byte[] bArr, int i10, int i11) {
        int i12 = i11 + i10;
        int i13 = i10;
        while (true) {
            if (i13 >= i12) {
                break;
            }
            int c10 = this.f29261j.c(bArr[i13]);
            if (c10 == 1) {
                this.f29262k = CharsetProber.ProbingState.NOT_ME;
                break;
            }
            if (c10 == 2) {
                this.f29262k = CharsetProber.ProbingState.FOUND_IT;
                break;
            }
            if (c10 == 0) {
                int b10 = this.f29261j.b();
                if (i13 == i10) {
                    byte[] bArr2 = this.f29265n;
                    bArr2[1] = bArr[i10];
                    this.f29263l.f(bArr2, 0, b10);
                    this.f29264m.e(this.f29265n, 0, b10);
                } else {
                    int i14 = i13 - 1;
                    this.f29263l.f(bArr, i14, b10);
                    this.f29264m.e(bArr, i14, b10);
                }
            }
            i13++;
        }
        this.f29265n[0] = bArr[i12 - 1];
        if (this.f29262k == CharsetProber.ProbingState.DETECTING && this.f29263l.d() && d() > 0.95f) {
            this.f29262k = CharsetProber.ProbingState.FOUND_IT;
        }
        return this.f29262k;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public final void j() {
        this.f29261j.d();
        this.f29262k = CharsetProber.ProbingState.DETECTING;
        this.f29263l.g();
        this.f29264m.f();
        Arrays.fill(this.f29265n, (byte) 0);
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void l() {
    }
}
