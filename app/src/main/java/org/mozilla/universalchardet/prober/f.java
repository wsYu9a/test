package org.mozilla.universalchardet.prober;

import java.util.Arrays;
import org.mozilla.universalchardet.prober.CharsetProber;

/* loaded from: classes4.dex */
public class f extends CharsetProber {

    /* renamed from: n */
    public static final cj.m f29284n = new cj.f();

    /* renamed from: k */
    public CharsetProber.ProbingState f29286k;

    /* renamed from: j */
    public cj.b f29285j = new cj.b(f29284n);

    /* renamed from: l */
    public aj.f f29287l = new aj.f();

    /* renamed from: m */
    public byte[] f29288m = new byte[2];

    public f() {
        j();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public String c() {
        return yi.b.f33511h;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float d() {
        return this.f29287l.a();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState e() {
        return this.f29286k;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState f(byte[] bArr, int i10, int i11) {
        int i12 = i11 + i10;
        int i13 = i10;
        while (true) {
            if (i13 >= i12) {
                break;
            }
            int c10 = this.f29285j.c(bArr[i13]);
            if (c10 == 1) {
                this.f29286k = CharsetProber.ProbingState.NOT_ME;
                break;
            }
            if (c10 == 2) {
                this.f29286k = CharsetProber.ProbingState.FOUND_IT;
                break;
            }
            if (c10 == 0) {
                int b10 = this.f29285j.b();
                if (i13 == i10) {
                    byte[] bArr2 = this.f29288m;
                    bArr2[1] = bArr[i10];
                    this.f29287l.e(bArr2, 0, b10);
                } else {
                    this.f29287l.e(bArr, i13 - 1, b10);
                }
            }
            i13++;
        }
        this.f29288m[0] = bArr[i12 - 1];
        if (this.f29286k == CharsetProber.ProbingState.DETECTING && this.f29287l.c() && d() > 0.95f) {
            this.f29286k = CharsetProber.ProbingState.FOUND_IT;
        }
        return this.f29286k;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public final void j() {
        this.f29285j.d();
        this.f29286k = CharsetProber.ProbingState.DETECTING;
        this.f29287l.f();
        Arrays.fill(this.f29288m, (byte) 0);
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void l() {
    }
}
