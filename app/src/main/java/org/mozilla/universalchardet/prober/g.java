package org.mozilla.universalchardet.prober;

import org.mozilla.universalchardet.prober.CharsetProber;

/* loaded from: classes5.dex */
public class g extends CharsetProber {

    /* renamed from: i */
    public static final int f35436i = 234;

    /* renamed from: j */
    public static final int f35437j = 235;
    public static final int k = 237;
    public static final int l = 238;
    public static final int m = 239;
    public static final int n = 240;
    public static final int o = 243;
    public static final int p = 244;
    public static final int q = 245;
    public static final int r = 246;
    public static final byte s = 32;
    public static final int t = 5;
    public static final float u = 0.01f;
    private int v;
    private int w;
    private byte x;
    private byte y;
    private CharsetProber z = null;
    private CharsetProber A = null;

    public g() {
        i();
    }

    protected static boolean k(byte b2) {
        int i2 = b2 & 255;
        return i2 == 234 || i2 == 237 || i2 == 239 || i2 == 243 || i2 == 245;
    }

    protected static boolean l(byte b2) {
        int i2 = b2 & 255;
        return i2 == 235 || i2 == 238 || i2 == 240 || i2 == 244;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public String c() {
        int i2 = this.v - this.w;
        if (i2 >= 5) {
            return org.mozilla.universalchardet.b.t;
        }
        if (i2 <= -5) {
            return org.mozilla.universalchardet.b.f35411f;
        }
        float d2 = this.z.d() - this.A.d();
        return d2 > 0.01f ? org.mozilla.universalchardet.b.t : d2 < -0.01f ? org.mozilla.universalchardet.b.f35411f : i2 < 0 ? org.mozilla.universalchardet.b.f35411f : org.mozilla.universalchardet.b.t;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float d() {
        return 0.0f;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState e() {
        CharsetProber.ProbingState e2 = this.z.e();
        CharsetProber.ProbingState probingState = CharsetProber.ProbingState.NOT_ME;
        return (e2 == probingState && this.A.e() == probingState) ? probingState : CharsetProber.ProbingState.DETECTING;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState f(byte[] bArr, int i2, int i3) {
        CharsetProber.ProbingState e2 = e();
        CharsetProber.ProbingState probingState = CharsetProber.ProbingState.NOT_ME;
        if (e2 == probingState) {
            return probingState;
        }
        int i4 = i3 + i2;
        while (i2 < i4) {
            byte b2 = bArr[i2];
            if (b2 == 32) {
                if (this.y != 32) {
                    if (k(this.x)) {
                        this.v++;
                    } else if (l(this.x)) {
                        this.w++;
                    }
                }
            } else if (this.y == 32 && k(this.x) && b2 != 32) {
                this.w++;
            }
            this.y = this.x;
            this.x = b2;
            i2++;
        }
        return CharsetProber.ProbingState.DETECTING;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void i() {
        this.v = 0;
        this.w = 0;
        this.x = s;
        this.y = s;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void j() {
    }

    public void m(CharsetProber charsetProber, CharsetProber charsetProber2) {
        this.z = charsetProber;
        this.A = charsetProber2;
    }
}
