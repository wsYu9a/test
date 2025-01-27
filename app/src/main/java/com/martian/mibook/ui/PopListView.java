package com.martian.mibook.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

/* loaded from: classes3.dex */
public class PopListView extends ListView {
    public PopListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PopListView(Context context) {
        super(context);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter == null || listAdapter.getCount() <= 0) {
            return;
        }
        View view = listAdapter.getView(0, null, this);
        view.measure(0, 0);
        if (listAdapter.getCount() > 6) {
            getLayoutParams().height = (int) (view.getMeasuredHeight() * 6.6d);
        } else {
            getLayoutParams().height = view.getMeasuredHeight() * listAdapter.getCount();
        }
    }

    public PopListView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
