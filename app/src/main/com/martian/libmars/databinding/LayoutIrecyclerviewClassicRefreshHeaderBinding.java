package com.martian.libmars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.R;
import com.martian.libmars.widget.ClassicRefreshHeaderView;

/* loaded from: classes3.dex */
public final class LayoutIrecyclerviewClassicRefreshHeaderBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ClassicRefreshHeaderView f12202a;

    public LayoutIrecyclerviewClassicRefreshHeaderBinding(@NonNull ClassicRefreshHeaderView classicRefreshHeaderView) {
        this.f12202a = classicRefreshHeaderView;
    }

    @NonNull
    public static LayoutIrecyclerviewClassicRefreshHeaderBinding a(@NonNull View view) {
        if (view != null) {
            return new LayoutIrecyclerviewClassicRefreshHeaderBinding((ClassicRefreshHeaderView) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static LayoutIrecyclerviewClassicRefreshHeaderBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static LayoutIrecyclerviewClassicRefreshHeaderBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.layout_irecyclerview_classic_refresh_header, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ClassicRefreshHeaderView getRoot() {
        return this.f12202a;
    }
}
