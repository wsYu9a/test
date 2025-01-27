package com.martian.mibook.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

/* loaded from: classes4.dex */
public class PopListView extends ListView {
    public PopListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PopListView(Context context) {
        super(context);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter adapter) {
        super.setAdapter(adapter);
        if (adapter == null || adapter.getCount() <= 0) {
            return;
        }
        View view = adapter.getView(0, null, this);
        view.measure(0, 0);
        if (adapter.getCount() <= 6) {
            getLayoutParams().height = view.getMeasuredHeight() * adapter.getCount();
        } else {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            double measuredHeight = view.getMeasuredHeight();
            Double.isNaN(measuredHeight);
            layoutParams.height = (int) (measuredHeight * 6.6d);
        }
    }

    public PopListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
