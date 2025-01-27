package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.text.Cue;
import com.vivo.google.android.exoplayer3.util.Util;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class o4 implements y3 {

    /* renamed from: a */
    public final Cue[] f27900a;

    /* renamed from: b */
    public final long[] f27901b;

    public o4(Cue[] cueArr, long[] jArr) {
        this.f27900a = cueArr;
        this.f27901b = jArr;
    }

    @Override // com.vivo.google.android.exoplayer3.y3
    public int a() {
        return this.f27901b.length;
    }

    @Override // com.vivo.google.android.exoplayer3.y3
    public int a(long j2) {
        int binarySearchCeil = Util.binarySearchCeil(this.f27901b, j2, false, false);
        if (binarySearchCeil < this.f27901b.length) {
            return binarySearchCeil;
        }
        return -1;
    }

    @Override // com.vivo.google.android.exoplayer3.y3
    public long a(int i2) {
        g1.a(i2 >= 0);
        g1.a(i2 < this.f27901b.length);
        return this.f27901b[i2];
    }

    @Override // com.vivo.google.android.exoplayer3.y3
    public List<Cue> b(long j2) {
        int binarySearchFloor = Util.binarySearchFloor(this.f27901b, j2, true, false);
        if (binarySearchFloor != -1) {
            Cue[] cueArr = this.f27900a;
            if (cueArr[binarySearchFloor] != null) {
                return Collections.singletonList(cueArr[binarySearchFloor]);
            }
        }
        return Collections.emptyList();
    }
}
