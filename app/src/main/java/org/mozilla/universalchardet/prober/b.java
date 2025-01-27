package org.mozilla.universalchardet.prober;

import java.util.Arrays;
import org.mozilla.universalchardet.prober.CharsetProber;

/* loaded from: classes5.dex */
public class b extends CharsetProber {

    /* renamed from: i */
    private static final org.mozilla.universalchardet.prober.q.m f35426i = new org.mozilla.universalchardet.prober.q.c();
    private CharsetProber.ProbingState k;

    /* renamed from: j */
    private org.mozilla.universalchardet.prober.q.b f35427j = new org.mozilla.universalchardet.prober.q.b(f35426i);
    private org.mozilla.universalchardet.prober.n.a l = new org.mozilla.universalchardet.prober.n.a();
    private org.mozilla.universalchardet.prober.o.c m = new org.mozilla.universalchardet.prober.o.c();
    private byte[] n = new byte[2];

    public b() {
        i();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public String c() {
        return org.mozilla.universalchardet.b.f35414i;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float d() {
        return Math.max(this.l.a(), this.m.a());
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
            int c2 = this.f35427j.c(bArr[i5]);
            if (c2 == 1) {
                this.k = CharsetProber.ProbingState.NOT_ME;
                break;
            }
            if (c2 == 2) {
                this.k = CharsetProber.ProbingState.FOUND_IT;
                break;
            }
            if (c2 == 0) {
                int b2 = this.f35427j.b();
                if (i5 == i2) {
                    byte[] bArr2 = this.n;
                    bArr2[1] = bArr[i2];
                    this.l.f(bArr2, 0, b2);
                    this.m.e(this.n, 0, b2);
                } else {
                    int i6 = i5 - 1;
                    this.l.f(bArr, i6, b2);
                    this.m.e(bArr, i6, b2);
                }
            }
            i5++;
        }
        this.n[0] = bArr[i4 - 1];
        if (this.k == CharsetProber.ProbingState.DETECTING && this.l.d() && d() > 0.95f) {
            this.k = CharsetProber.ProbingState.FOUND_IT;
        }
        return this.k;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void i() {
        this.f35427j.d();
        this.k = CharsetProber.ProbingState.DETECTING;
        this.l.g();
        this.m.f();
        Arrays.fill(this.n, (byte) 0);
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void j() {
    }
}
