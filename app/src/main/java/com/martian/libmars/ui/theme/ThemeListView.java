package com.martian.libmars.ui.theme;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.BaseAdapter;
import android.widget.ListView;
import androidx.core.content.ContextCompat;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import k9.a;

/* loaded from: classes3.dex */
public class ThemeListView extends ListView implements a {
    public ThemeListView(Context context) {
        super(context);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        p();
        ConfigSingleton.D().h(this);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ConfigSingleton.D().X0(this);
    }

    @Override // k9.a
    public void p() {
        if (isInEditMode()) {
            return;
        }
        setBackgroundColor(ContextCompat.getColor(getContext(), ConfigSingleton.D().A0() ? R.color.night_background : R.color.white));
        if (getAdapter() instanceof BaseAdapter) {
            ((BaseAdapter) getAdapter()).notifyDataSetChanged();
        }
    }

    public ThemeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public ThemeListView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
