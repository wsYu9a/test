package com.martian.mibook.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

/* loaded from: classes3.dex */
public class MyListView extends ListView {
    public MyListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
