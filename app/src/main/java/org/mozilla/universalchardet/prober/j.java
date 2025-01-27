package org.mozilla.universalchardet.prober;

import java.nio.ByteBuffer;
import org.mozilla.universalchardet.prober.CharsetProber;
import org.mozilla.universalchardet.prober.p.n;
import org.mozilla.universalchardet.prober.p.o;

/* loaded from: classes5.dex */
public class j extends CharsetProber {

    /* renamed from: i */
    private static final org.mozilla.universalchardet.prober.p.l f35442i = new n();

    /* renamed from: j */
    private static final org.mozilla.universalchardet.prober.p.l f35443j = new org.mozilla.universalchardet.prober.p.g();
    private static final org.mozilla.universalchardet.prober.p.l k = new org.mozilla.universalchardet.prober.p.i();
    private static final org.mozilla.universalchardet.prober.p.l l = new org.mozilla.universalchardet.prober.p.k();
    private static final org.mozilla.universalchardet.prober.p.l m = new org.mozilla.universalchardet.prober.p.f();
    private static final org.mozilla.universalchardet.prober.p.l n = new org.mozilla.universalchardet.prober.p.e();
    private static final org.mozilla.universalchardet.prober.p.l o = new org.mozilla.universalchardet.prober.p.j();
    private static final org.mozilla.universalchardet.prober.p.l p = new o();
    private static final org.mozilla.universalchardet.prober.p.l q = new org.mozilla.universalchardet.prober.p.h();
    private static final org.mozilla.universalchardet.prober.p.l r = new org.mozilla.universalchardet.prober.p.m();
    private static final org.mozilla.universalchardet.prober.p.l s = new org.mozilla.universalchardet.prober.p.d();
    private CharsetProber.ProbingState t;
    private CharsetProber[] u;
    private boolean[] v = new boolean[13];
    private int w;
    private int x;

    public j() {
        CharsetProber[] charsetProberArr = new CharsetProber[13];
        this.u = charsetProberArr;
        charsetProberArr[0] = new l(f35442i);
        this.u[1] = new l(f35443j);
        this.u[2] = new l(k);
        this.u[3] = new l(l);
        this.u[4] = new l(m);
        this.u[5] = new l(n);
        this.u[6] = new l(o);
        this.u[7] = new l(p);
        this.u[8] = new l(q);
        this.u[9] = new l(r);
        g gVar = new g();
        CharsetProber[] charsetProberArr2 = this.u;
        charsetProberArr2[10] = gVar;
        org.mozilla.universalchardet.prober.p.l lVar = s;
        charsetProberArr2[11] = new l(lVar, false, gVar);
        this.u[12] = new l(lVar, true, gVar);
        CharsetProber[] charsetProberArr3 = this.u;
        gVar.m(charsetProberArr3[11], charsetProberArr3[12]);
        i();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public String c() {
        if (this.w == -1) {
            d();
            if (this.w == -1) {
                this.w = 0;
            }
        }
        return this.u[this.w].c();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float d() {
        CharsetProber.ProbingState probingState = this.t;
        if (probingState == CharsetProber.ProbingState.FOUND_IT) {
            return 0.99f;
        }
        if (probingState == CharsetProber.ProbingState.NOT_ME) {
            return 0.01f;
        }
        int i2 = 0;
        float f2 = 0.0f;
        while (true) {
            CharsetProber[] charsetProberArr = this.u;
            if (i2 >= charsetProberArr.length) {
                return f2;
            }
            if (this.v[i2]) {
                float d2 = charsetProberArr[i2].d();
                if (f2 < d2) {
                    this.w = i2;
                    f2 = d2;
                }
            }
            i2++;
        }
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState e() {
        return this.t;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState f(byte[] bArr, int i2, int i3) {
        ByteBuffer b2 = b(bArr, i2, i3);
        if (b2.position() != 0) {
            int i4 = 0;
            while (true) {
                CharsetProber[] charsetProberArr = this.u;
                if (i4 >= charsetProberArr.length) {
                    break;
                }
                if (this.v[i4]) {
                    CharsetProber.ProbingState f2 = charsetProberArr[i4].f(b2.array(), 0, b2.position());
                    CharsetProber.ProbingState probingState = CharsetProber.ProbingState.FOUND_IT;
                    if (f2 == probingState) {
                        this.w = i4;
                        this.t = probingState;
                        break;
                    }
                    CharsetProber.ProbingState probingState2 = CharsetProber.ProbingState.NOT_ME;
                    if (f2 == probingState2) {
                        this.v[i4] = false;
                        int i5 = this.x - 1;
                        this.x = i5;
                        if (i5 <= 0) {
                            this.t = probingState2;
                            break;
                        }
                    } else {
                        continue;
                    }
                }
                i4++;
            }
        }
        return this.t;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void i() {
        int i2 = 0;
        this.x = 0;
        while (true) {
            CharsetProber[] charsetProberArr = this.u;
            if (i2 >= charsetProberArr.length) {
                this.w = -1;
                this.t = CharsetProber.ProbingState.DETECTING;
                return;
            } else {
                charsetProberArr[i2].i();
                this.v[i2] = true;
                this.x++;
                i2++;
            }
        }
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void j() {
    }
}
