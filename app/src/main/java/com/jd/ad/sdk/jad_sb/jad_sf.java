package com.jd.ad.sdk.jad_sb;

import android.graphics.Paint;
import com.jd.ad.sdk.jad_sb.jad_re;

/* loaded from: classes2.dex */
public final /* synthetic */ class jad_sf {
    public static Paint.Cap jad_an(int i10) {
        int[] iArr = jad_re.jad_an.jad_an;
        if (i10 == 0) {
            throw null;
        }
        int i11 = iArr[i10 - 1];
        return i11 != 1 ? i11 != 2 ? Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
    }
}
