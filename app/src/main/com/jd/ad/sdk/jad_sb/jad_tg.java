package com.jd.ad.sdk.jad_sb;

import android.graphics.Paint;
import com.jd.ad.sdk.jad_sb.jad_re;

/* loaded from: classes2.dex */
public final /* synthetic */ class jad_tg {
    public static Paint.Join jad_an(int i10) {
        int[] iArr = jad_re.jad_an.jad_bo;
        if (i10 == 0) {
            throw null;
        }
        int i11 = iArr[i10 - 1];
        if (i11 == 1) {
            return Paint.Join.BEVEL;
        }
        if (i11 == 2) {
            return Paint.Join.MITER;
        }
        if (i11 != 3) {
            return null;
        }
        return Paint.Join.ROUND;
    }
}
