package com.vivo.mobilead.unified.base.view.s;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.vivo.mobilead.unified.base.AdParams;

/* loaded from: classes4.dex */
public class c {
    public static int[] a(int i2) {
        int[] iArr = {org.mozilla.universalchardet.prober.g.n, 210};
        switch (i2) {
            case 1:
                return new int[]{org.mozilla.universalchardet.prober.g.n, 173};
            case 2:
                return new int[]{org.mozilla.universalchardet.prober.g.n, 125};
            case 3:
                return new int[]{org.mozilla.universalchardet.prober.g.n, 100};
            case 4:
                return new int[]{org.mozilla.universalchardet.prober.g.n, 100};
            case 5:
                return new int[]{org.mozilla.universalchardet.prober.g.n, 210};
            case 6:
                return new int[]{org.mozilla.universalchardet.prober.g.n, 210};
            case 7:
                return new int[]{TTAdConstant.IMAGE_MODE_SPLASH, 292};
            default:
                return iArr;
        }
    }

    public static float a(AdParams adParams, Context context, int i2) {
        int c2;
        if (adParams == null || context == null || (c2 = com.vivo.mobilead.util.m.c(context, com.vivo.mobilead.util.n.b(context))) == 0) {
            return 1.0f;
        }
        int[] a2 = a(i2);
        int nativeExpressWidth = adParams.getNativeExpressWidth() == -1 ? 360 : adParams.getNativeExpressWidth();
        if (nativeExpressWidth > c2) {
            nativeExpressWidth = c2;
        } else if (nativeExpressWidth < a2[0]) {
            nativeExpressWidth = a2[0];
        }
        return nativeExpressWidth / c2;
    }
}
