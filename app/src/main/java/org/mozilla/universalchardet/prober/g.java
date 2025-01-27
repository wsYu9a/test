package org.mozilla.universalchardet.prober;

import org.mozilla.universalchardet.prober.CharsetProber;

/* loaded from: classes4.dex */
public class g extends CharsetProber {
    public static final int A = 5;
    public static final float B = 0.01f;

    /* renamed from: p */
    public static final int f29289p = 234;

    /* renamed from: q */
    public static final int f29290q = 235;

    /* renamed from: r */
    public static final int f29291r = 237;

    /* renamed from: s */
    public static final int f29292s = 238;

    /* renamed from: t */
    public static final int f29293t = 239;

    /* renamed from: u */
    public static final int f29294u = 240;

    /* renamed from: v */
    public static final int f29295v = 243;

    /* renamed from: w */
    public static final int f29296w = 244;

    /* renamed from: x */
    public static final int f29297x = 245;

    /* renamed from: y */
    public static final int f29298y = 246;

    /* renamed from: z */
    public static final byte f29299z = 32;

    /* renamed from: j */
    public int f29300j;

    /* renamed from: k */
    public int f29301k;

    /* renamed from: l */
    public byte f29302l;

    /* renamed from: m */
    public byte f29303m;

    /* renamed from: n */
    public CharsetProber f29304n = null;

    /* renamed from: o */
    public CharsetProber f29305o = null;

    public g() {
        j();
    }

    public static boolean m(byte b10) {
        int i10 = b10 & 255;
        return i10 == 234 || i10 == 237 || i10 == 239 || i10 == 243 || i10 == 245;
    }

    public static boolean n(byte b10) {
        int i10 = b10 & 255;
        return i10 == 235 || i10 == 238 || i10 == 240 || i10 == 244;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public String c() {
        int i10 = this.f29300j - this.f29301k;
        if (i10 >= 5) {
            return yi.b.f33523t;
        }
        if (i10 <= -5) {
            return yi.b.f33509f;
        }
        float d10 = this.f29304n.d() - this.f29305o.d();
        return d10 > 0.01f ? yi.b.f33523t : d10 < -0.01f ? yi.b.f33509f : i10 < 0 ? yi.b.f33509f : yi.b.f33523t;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float d() {
        return 0.0f;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState e() {
        CharsetProber.ProbingState e10 = this.f29304n.e();
        CharsetProber.ProbingState probingState = CharsetProber.ProbingState.NOT_ME;
        return (e10 == probingState && this.f29305o.e() == probingState) ? probingState : CharsetProber.ProbingState.DETECTING;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState f(byte[] bArr, int i10, int i11) {
        CharsetProber.ProbingState e10 = e();
        CharsetProber.ProbingState probingState = CharsetProber.ProbingState.NOT_ME;
        if (e10 == probingState) {
            return probingState;
        }
        int i12 = i11 + i10;
        while (i10 < i12) {
            byte b10 = bArr[i10];
            if (b10 == 32) {
                if (this.f29303m != 32) {
                    if (m(this.f29302l)) {
                        this.f29300j++;
                    } else if (n(this.f29302l)) {
                        this.f29301k++;
                    }
                }
            } else if (this.f29303m == 32 && m(this.f29302l) && b10 != 32) {
                this.f29301k++;
            }
            this.f29303m = this.f29302l;
            this.f29302l = b10;
            i10++;
        }
        return CharsetProber.ProbingState.DETECTING;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public final void j() {
        this.f29300j = 0;
        this.f29301k = 0;
        this.f29302l = (byte) 32;
        this.f29303m = (byte) 32;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void l() {
    }

    public void o(CharsetProber charsetProber, CharsetProber charsetProber2) {
        this.f29304n = charsetProber;
        this.f29305o = charsetProber2;
    }
}
