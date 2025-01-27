package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.util.Util;

/* loaded from: classes4.dex */
public final class o1 {

    /* renamed from: a */
    public final int f27884a;

    /* renamed from: b */
    public final long[] f27885b;

    /* renamed from: c */
    public final int[] f27886c;

    /* renamed from: d */
    public final int f27887d;

    /* renamed from: e */
    public final long[] f27888e;

    /* renamed from: f */
    public final int[] f27889f;

    public o1(long[] jArr, int[] iArr, int i2, long[] jArr2, int[] iArr2) {
        g1.a(iArr.length == jArr2.length);
        g1.a(jArr.length == jArr2.length);
        g1.a(iArr2.length == jArr2.length);
        this.f27885b = jArr;
        this.f27886c = iArr;
        this.f27887d = i2;
        this.f27888e = jArr2;
        this.f27889f = iArr2;
        this.f27884a = jArr.length;
    }

    public int a(long j2) {
        for (int binarySearchFloor = Util.binarySearchFloor(this.f27888e, j2, true, false); binarySearchFloor >= 0; binarySearchFloor--) {
            if ((this.f27889f[binarySearchFloor] & 1) != 0) {
                return binarySearchFloor;
            }
        }
        return -1;
    }

    public int b(long j2) {
        for (int binarySearchCeil = Util.binarySearchCeil(this.f27888e, j2, true, false); binarySearchCeil < this.f27888e.length; binarySearchCeil++) {
            if ((this.f27889f[binarySearchCeil] & 1) != 0) {
                return binarySearchCeil;
            }
        }
        return -1;
    }
}
