package org.mozilla.universalchardet.prober;

import java.nio.ByteBuffer;
import org.mozilla.universalchardet.prober.CharsetProber;

/* loaded from: classes5.dex */
public class h extends CharsetProber {

    /* renamed from: i */
    public static final byte f35438i = 0;

    /* renamed from: j */
    public static final byte f35439j = 1;
    public static final byte k = 2;
    public static final byte l = 3;
    public static final byte m = 4;
    public static final byte n = 5;
    public static final byte o = 6;
    public static final byte p = 7;
    public static final int q = 8;
    public static final int r = 4;
    private static final byte[] s = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 0, 1, 7, 1, 1, 1, 1, 1, 1, 5, 1, 5, 0, 5, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 7, 1, 7, 0, 7, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 4, 4, 4, 5, 5, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 4, 4, 4, 4, 4, 1, 4, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6, 7, 7, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 6, 6, 6, 6, 6, 1, 6, 6, 6, 6, 6, 7, 7, 7};
    private static final byte[] t = {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3, 3, 0, 3, 3, 3, 3, 3, 3, 3, 0, 3, 3, 3, 1, 1, 3, 3, 0, 3, 3, 3, 1, 2, 1, 2, 0, 3, 3, 3, 3, 3, 3, 3, 0, 3, 1, 3, 1, 1, 1, 3, 0, 3, 1, 3, 1, 1, 3, 3};
    private CharsetProber.ProbingState u;
    private byte v;
    private int[] w = new int[4];

    public h() {
        i();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public String c() {
        return org.mozilla.universalchardet.b.r;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float d() {
        int[] iArr;
        float f2;
        if (this.u == CharsetProber.ProbingState.NOT_ME) {
            return 0.01f;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            iArr = this.w;
            if (i2 >= iArr.length) {
                break;
            }
            i3 += iArr[i2];
            i2++;
        }
        if (i3 <= 0) {
            f2 = 0.0f;
        } else {
            float f3 = i3;
            f2 = ((iArr[3] * 1.0f) / f3) - ((iArr[1] * 20.0f) / f3);
        }
        return (f2 >= 0.0f ? f2 : 0.0f) * 0.5f;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState e() {
        return this.u;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState f(byte[] bArr, int i2, int i3) {
        ByteBuffer a2 = a(bArr, i2, i3);
        byte[] array = a2.array();
        int position = a2.position();
        int i4 = 0;
        while (true) {
            if (i4 >= position) {
                break;
            }
            byte b2 = s[array[i4] & 255];
            byte b3 = t[(this.v * 8) + b2];
            if (b3 == 0) {
                this.u = CharsetProber.ProbingState.NOT_ME;
                break;
            }
            int[] iArr = this.w;
            iArr[b3] = iArr[b3] + 1;
            this.v = b2;
            i4++;
        }
        return this.u;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void i() {
        this.u = CharsetProber.ProbingState.DETECTING;
        this.v = (byte) 1;
        int i2 = 0;
        while (true) {
            int[] iArr = this.w;
            if (i2 >= iArr.length) {
                return;
            }
            iArr[i2] = 0;
            i2++;
        }
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void j() {
    }
}
