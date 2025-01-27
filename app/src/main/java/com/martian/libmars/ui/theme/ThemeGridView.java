package com.martian.libmars.ui.theme;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.GridView;
import androidx.core.content.ContextCompat;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import k9.a;

/* loaded from: classes3.dex */
public class ThemeGridView extends GridView implements a {
    public ThemeGridView(Context context) {
        super(context);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        p();
        ConfigSingleton.D().h(this);
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ConfigSingleton.D().X0(this);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
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

    public ThemeGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThemeGridView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
