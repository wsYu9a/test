package org.mozilla.universalchardet.prober;

import java.nio.ByteBuffer;
import org.mozilla.universalchardet.prober.CharsetProber;

/* loaded from: classes4.dex */
public class h extends CharsetProber {

    /* renamed from: m */
    public static final byte f29306m = 0;

    /* renamed from: n */
    public static final byte f29307n = 1;

    /* renamed from: o */
    public static final byte f29308o = 2;

    /* renamed from: p */
    public static final byte f29309p = 3;

    /* renamed from: q */
    public static final byte f29310q = 4;

    /* renamed from: r */
    public static final byte f29311r = 5;

    /* renamed from: s */
    public static final byte f29312s = 6;

    /* renamed from: t */
    public static final byte f29313t = 7;

    /* renamed from: u */
    public static final int f29314u = 8;

    /* renamed from: v */
    public static final int f29315v = 4;

    /* renamed from: w */
    public static final byte[] f29316w = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 0, 1, 7, 1, 1, 1, 1, 1, 1, 5, 1, 5, 0, 5, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 7, 1, 7, 0, 7, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 4, 4, 4, 5, 5, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 4, 4, 4, 4, 4, 1, 4, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6, 7, 7, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 6, 6, 6, 6, 6, 1, 6, 6, 6, 6, 6, 7, 7, 7};

    /* renamed from: x */
    public static final byte[] f29317x = {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3, 3, 0, 3, 3, 3, 3, 3, 3, 3, 0, 3, 3, 3, 1, 1, 3, 3, 0, 3, 3, 3, 1, 2, 1, 2, 0, 3, 3, 3, 3, 3, 3, 3, 0, 3, 1, 3, 1, 1, 1, 3, 0, 3, 1, 3, 1, 1, 3, 3};

    /* renamed from: j */
    public CharsetProber.ProbingState f29318j;

    /* renamed from: k */
    public byte f29319k;

    /* renamed from: l */
    public int[] f29320l = new int[4];

    public h() {
        j();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public String c() {
        return yi.b.f33521r;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float d() {
        int[] iArr;
        float f10;
        if (this.f29318j == CharsetProber.ProbingState.NOT_ME) {
            return 0.01f;
        }
        int i10 = 0;
        int i11 = 0;
        while (true) {
            iArr = this.f29320l;
            if (i10 >= iArr.length) {
                break;
            }
            i11 += iArr[i10];
            i10++;
        }
        if (i11 <= 0) {
            f10 = 0.0f;
        } else {
            float f11 = i11;
            f10 = ((iArr[3] * 1.0f) / f11) - ((iArr[1] * 20.0f) / f11);
        }
        return (f10 >= 0.0f ? f10 : 0.0f) * 0.5f;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState e() {
        return this.f29318j;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState f(byte[] bArr, int i10, int i11) {
        ByteBuffer a10 = a(bArr, i10, i11);
        byte[] array = a10.array();
        int position = a10.position();
        int i12 = 0;
        while (true) {
            if (i12 >= position) {
                break;
            }
            byte b10 = f29316w[array[i12] & 255];
            byte b11 = f29317x[(this.f29319k * 8) + b10];
            if (b11 == 0) {
                this.f29318j = CharsetProber.ProbingState.NOT_ME;
                break;
            }
            int[] iArr = this.f29320l;
            iArr[b11] = iArr[b11] + 1;
            this.f29319k = b10;
            i12++;
        }
        return this.f29318j;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public final void j() {
        this.f29318j = CharsetProber.ProbingState.DETECTING;
        this.f29319k = (byte) 1;
        int i10 = 0;
        while (true) {
            int[] iArr = this.f29320l;
            if (i10 >= iArr.length) {
                return;
            }
            iArr[i10] = 0;
            i10++;
        }
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void l() {
    }
}
