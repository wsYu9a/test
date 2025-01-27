package com.vivo.advv.vaf.virtualview.util;

import android.view.View;
import com.vivo.advv.vaf.virtualview.core.Layout;

/* loaded from: classes4.dex */
public final class ViewUtils {
    public static int scaleHeightMeasureSpec(int i2, float f2, Layout.Params params) {
        int i3;
        return (params == null || (i3 = params.mLayoutHeight) <= 0) ? i2 : View.MeasureSpec.makeMeasureSpec((int) (i3 * f2), View.MeasureSpec.getMode(i2));
    }

    public static int scaleWidthMeasureSpec(int i2, float f2, Layout.Params params) {
        int i3;
        return (params == null || (i3 = params.mLayoutWidth) <= 0) ? i2 : View.MeasureSpec.makeMeasureSpec((int) (i3 * f2), View.MeasureSpec.getMode(i2));
    }
}
