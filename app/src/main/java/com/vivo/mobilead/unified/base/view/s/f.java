package com.vivo.mobilead.unified.base.view.s;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.vivo.mobilead.unified.nativead.VivoNativeExpressView;

/* loaded from: classes4.dex */
public class f extends VivoNativeExpressView {
    public f(Context context, View view) {
        super(context, null);
        if (view != null) {
            addView(view, new FrameLayout.LayoutParams(-2, -2));
        }
    }
}
