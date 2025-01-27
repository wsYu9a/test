package org.mozilla.universalchardet.prober;

import kotlin.jvm.internal.ByteCompanionObject;
import org.mozilla.universalchardet.prober.CharsetProber;

/* loaded from: classes5.dex */
public class i extends CharsetProber {

    /* renamed from: i */
    private CharsetProber.ProbingState f35440i;

    /* renamed from: j */
    private CharsetProber[] f35441j;
    private boolean[] k = new boolean[7];
    private int l;
    private int m;

    public i() {
        CharsetProber[] charsetProberArr = new CharsetProber[7];
        this.f35441j = charsetProberArr;
        charsetProberArr[0] = new m();
        this.f35441j[1] = new k();
        this.f35441j[2] = new b();
        this.f35441j[3] = new f();
        this.f35441j[4] = new c();
        this.f35441j[5] = new a();
        this.f35441j[6] = new d();
        i();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public String c() {
        if (this.l == -1) {
            d();
            if (this.l == -1) {
                this.l = 0;
            }
        }
        return this.f35441j[this.l].c();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float d() {
        CharsetProber.ProbingState probingState = this.f35440i;
        if (probingState == CharsetProber.ProbingState.FOUND_IT) {
            return 0.99f;
        }
        if (probingState == CharsetProber.ProbingState.NOT_ME) {
            return 0.01f;
        }
        int i2 = 0;
        float f2 = 0.0f;
        while (true) {
            CharsetProber[] charsetProberArr = this.f35441j;
            if (i2 >= charsetProberArr.length) {
                return f2;
            }
            if (this.k[i2]) {
                float d2 = charsetProberArr[i2].d();
                if (f2 < d2) {
                    this.l = i2;
                    f2 = d2;
                }
            }
            i2++;
        }
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState e() {
        return this.f35440i;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState f(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[i3];
        int i4 = i3 + i2;
        boolean z = true;
        int i5 = 0;
        while (i2 < i4) {
            if ((bArr[i2] & ByteCompanionObject.MIN_VALUE) != 0) {
                bArr2[i5] = bArr[i2];
                i5++;
                z = true;
            } else if (z) {
                bArr2[i5] = bArr[i2];
                i5++;
                z = false;
            }
            i2++;
        }
        int i6 = 0;
        while (true) {
            CharsetProber[] charsetProberArr = this.f35441j;
            if (i6 >= charsetProberArr.length) {
                break;
            }
            if (this.k[i6]) {
                CharsetProber.ProbingState f2 = charsetProberArr[i6].f(bArr2, 0, i5);
                CharsetProber.ProbingState probingState = CharsetProber.ProbingState.FOUND_IT;
                if (f2 == probingState) {
                    this.l = i6;
                    this.f35440i = probingState;
                    break;
                }
                CharsetProber.ProbingState probingState2 = CharsetProber.ProbingState.NOT_ME;
                if (f2 == probingState2) {
                    this.k[i6] = false;
                    int i7 = this.m - 1;
                    this.m = i7;
                    if (i7 <= 0) {
                        this.f35440i = probingState2;
                        break;
                    }
                } else {
                    continue;
                }
            }
            i6++;
        }
        return this.f35440i;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void i() {
        int i2 = 0;
        this.m = 0;
        while (true) {
            CharsetProber[] charsetProberArr = this.f35441j;
            if (i2 >= charsetProberArr.length) {
                this.l = -1;
                this.f35440i = CharsetProber.ProbingState.DETECTING;
                return;
            } else {
                charsetProberArr[i2].i();
                this.k[i2] = true;
                this.m++;
                i2++;
            }
        }
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void j() {
    }
}
