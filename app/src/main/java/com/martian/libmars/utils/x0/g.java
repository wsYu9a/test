package com.martian.libmars.utils.x0;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.cdo.oaps.ad.wrapper.BaseWrapper;

/* loaded from: classes2.dex */
class g implements c {

    /* renamed from: a */
    private static final String f10295a = "ghStatusBarView";

    g() {
    }

    private static int b(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", BaseWrapper.BASE_PKG_SYSTEM);
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    @Override // com.martian.libmars.utils.x0.c
    @TargetApi(19)
    public void a(Window window, int color) {
        window.addFlags(67108864);
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        View findViewWithTag = viewGroup.findViewWithTag(f10295a);
        if (findViewWithTag == null) {
            findViewWithTag = new View(window.getContext());
            findViewWithTag.setTag(f10295a);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, b(window.getContext()));
            layoutParams.gravity = 48;
            findViewWithTag.setLayoutParams(layoutParams);
            viewGroup.addView(findViewWithTag);
        }
        findViewWithTag.setBackgroundColor(color);
        e.d(window, true);
    }
}
