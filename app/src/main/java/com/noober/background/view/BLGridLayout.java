package com.noober.background.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridLayout;
import com.noober.background.BackgroundFactory;

/* loaded from: classes3.dex */
public class BLGridLayout extends GridLayout {
    public BLGridLayout(Context context) {
        super(context);
    }

    private void init(Context context, AttributeSet attributeSet) {
        BackgroundFactory.setViewBackground(context, attributeSet, this);
    }

    public BLGridLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public BLGridLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        init(context, attributeSet);
    }
}
