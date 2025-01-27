package com.wbl.ad.yzz.ms.data.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;

/* loaded from: classes5.dex */
public class ListViewForScrollView extends ListView {
    public ListViewForScrollView(Context context) {
        super(context);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12000, this, Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public ListViewForScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ListViewForScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
