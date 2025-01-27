package com.alimm.tanx.core.utils;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/* loaded from: classes.dex */
public class ViewSize implements NotConfused {
    public static void setViewSize(View view, int i10, int i11) {
        if (view.getParent() instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.width = i10;
            layoutParams.height = i11;
            view.setLayoutParams(layoutParams);
            view.requestLayout();
            return;
        }
        if (view.getParent() instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams2.width = i10;
            layoutParams2.height = i11;
            view.setLayoutParams(layoutParams2);
            view.requestLayout();
            return;
        }
        if (view.getParent() instanceof LinearLayout) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams3.width = i10;
            layoutParams3.height = i11;
            view.setLayoutParams(layoutParams3);
            view.requestLayout();
        }
    }
}
