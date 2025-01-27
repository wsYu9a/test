package com.martian.libmars.ui.theme;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.widget.recyclerview.IRecyclerView;
import k9.a;
import l9.u0;

/* loaded from: classes3.dex */
public class ThemeIRecyclerView extends IRecyclerView implements a {
    public int I;

    public ThemeIRecyclerView(Context context) {
        super(context);
    }

    private void J(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ThemeIRecyclerView);
        this.I = obtainStyledAttributes.getColor(R.styleable.ThemeIRecyclerView_recyclerBackgroundType, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        p();
        ConfigSingleton.D().h(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ConfigSingleton.D().X0(this);
    }

    @Override // k9.a
    public void p() {
        int i10;
        if (isInEditMode()) {
            return;
        }
        if (ConfigSingleton.D().A0()) {
            i10 = this.I == 1 ? R.color.night_background_secondary : R.color.night_background;
        } else {
            int i11 = this.I;
            i10 = i11 == 1 ? R.color.light_grey : i11 == 2 ? R.color.light_grey_bg : R.color.white;
        }
        int color = ContextCompat.getColor(getContext(), i10);
        setBackgroundColor(color);
        setLoadMoreBackgroundColor(color);
        if (getAdapter() != null) {
            getAdapter().notifyDataSetChanged();
        }
        if (getHeaderContainer() != null) {
            u0.b(getHeaderContainer());
        }
        if (getLoadMoreFooterView() != null) {
            u0.b(getLoadMoreFooterView());
        }
    }

    public ThemeIRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        J(context, attributeSet);
    }

    public ThemeIRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        J(context, attributeSet);
    }
}
