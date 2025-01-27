package org.mozilla.universalchardet.prober;

import org.mozilla.universalchardet.prober.CharsetProber;

/* loaded from: classes4.dex */
public class e extends CharsetProber {

    /* renamed from: n */
    public static final cj.g f29276n = new cj.g();

    /* renamed from: o */
    public static final cj.h f29277o = new cj.h();

    /* renamed from: p */
    public static final cj.i f29278p = new cj.i();

    /* renamed from: q */
    public static final cj.j f29279q = new cj.j();

    /* renamed from: j */
    public cj.b[] f29280j;

    /* renamed from: k */
    public int f29281k;

    /* renamed from: l */
    public CharsetProber.ProbingState f29282l;

    /* renamed from: m */
    public String f29283m;

    public e() {
        cj.b[] bVarArr = new cj.b[4];
        this.f29280j = bVarArr;
        bVarArr[0] = new cj.b(f29276n);
        this.f29280j[1] = new cj.b(f29277o);
        this.f29280j[2] = new cj.b(f29278p);
        this.f29280j[3] = new cj.b(f29279q);
        j();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public String c() {
        return this.f29283m;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float d() {
        return 0.99f;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState e() {
        return this.f29282l;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState f(byte[] bArr, int i10, int i11) {
        int i12 = i11 + i10;
        while (i10 < i12 && this.f29282l == CharsetProber.ProbingState.DETECTING) {
            for (int i13 = this.f29281k - 1; i13 >= 0; i13--) {
                int c10 = this.f29280j[i13].c(bArr[i10]);
                if (c10 == 1) {
                    int i14 = this.f29281k - 1;
                    this.f29281k = i14;
                    if (i14 <= 0) {
                        CharsetProber.ProbingState probingState = CharsetProber.ProbingState.NOT_ME;
                        this.f29282l = probingState;
                        return probingState;
                    }
                    if (i13 != i14) {
                        cj.b[] bVarArr = this.f29280j;
                        cj.b bVar = bVarArr[i14];
                        bVarArr[i14] = bVarArr[i13];
                        bVarArr[i13] = bVar;
                    }
                } else if (c10 == 2) {
                    this.f29282l = CharsetProber.ProbingState.FOUND_IT;
                    this.f29283m = this.f29280j[i13].a();
                    return this.f29282l;
                }
            }
            i10++;
        }
        return this.f29282l;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public final void j() {
        this.f29282l = CharsetProber.ProbingState.DETECTING;
        int i10 = 0;
        while (true) {
            cj.b[] bVarArr = this.f29280j;
            if (i10 >= bVarArr.length) {
                this.f29281k = bVarArr.length;
                this.f29283m = null;
                return;
            } else {
                bVarArr[i10].d();
                i10++;
            }
        }
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void l() {
    }
}
