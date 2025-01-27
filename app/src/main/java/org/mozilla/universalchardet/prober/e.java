package org.mozilla.universalchardet.prober;

import org.mozilla.universalchardet.prober.CharsetProber;

/* loaded from: classes5.dex */
public class e extends CharsetProber {

    /* renamed from: i */
    private static final org.mozilla.universalchardet.prober.q.g f35432i = new org.mozilla.universalchardet.prober.q.g();

    /* renamed from: j */
    private static final org.mozilla.universalchardet.prober.q.h f35433j = new org.mozilla.universalchardet.prober.q.h();
    private static final org.mozilla.universalchardet.prober.q.i k = new org.mozilla.universalchardet.prober.q.i();
    private static final org.mozilla.universalchardet.prober.q.j l = new org.mozilla.universalchardet.prober.q.j();
    private org.mozilla.universalchardet.prober.q.b[] m;
    private int n;
    private CharsetProber.ProbingState o;
    private String p;

    public e() {
        org.mozilla.universalchardet.prober.q.b[] bVarArr = new org.mozilla.universalchardet.prober.q.b[4];
        this.m = bVarArr;
        bVarArr[0] = new org.mozilla.universalchardet.prober.q.b(f35432i);
        this.m[1] = new org.mozilla.universalchardet.prober.q.b(f35433j);
        this.m[2] = new org.mozilla.universalchardet.prober.q.b(k);
        this.m[3] = new org.mozilla.universalchardet.prober.q.b(l);
        i();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public String c() {
        return this.p;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float d() {
        return 0.99f;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState e() {
        return this.o;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState f(byte[] bArr, int i2, int i3) {
        int i4 = i3 + i2;
        while (i2 < i4 && this.o == CharsetProber.ProbingState.DETECTING) {
            for (int i5 = this.n - 1; i5 >= 0; i5--) {
                int c2 = this.m[i5].c(bArr[i2]);
                if (c2 == 1) {
                    int i6 = this.n - 1;
                    this.n = i6;
                    if (i6 <= 0) {
                        CharsetProber.ProbingState probingState = CharsetProber.ProbingState.NOT_ME;
                        this.o = probingState;
                        return probingState;
                    }
                    if (i5 != i6) {
                        org.mozilla.universalchardet.prober.q.b[] bVarArr = this.m;
                        org.mozilla.universalchardet.prober.q.b bVar = bVarArr[i6];
                        bVarArr[i6] = bVarArr[i5];
                        bVarArr[i5] = bVar;
                    }
                } else if (c2 == 2) {
                    this.o = CharsetProber.ProbingState.FOUND_IT;
                    this.p = this.m[i5].a();
                    return this.o;
                }
            }
            i2++;
        }
        return this.o;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void i() {
        this.o = CharsetProber.ProbingState.DETECTING;
        int i2 = 0;
        while (true) {
            org.mozilla.universalchardet.prober.q.b[] bVarArr = this.m;
            if (i2 >= bVarArr.length) {
                this.n = bVarArr.length;
                this.p = null;
                return;
            } else {
                bVarArr[i2].d();
                i2++;
            }
        }
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void j() {
    }
}
