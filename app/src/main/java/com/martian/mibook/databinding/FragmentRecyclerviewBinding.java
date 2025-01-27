package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeIRecyclerView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class FragmentRecyclerviewBinding implements ViewBinding {

    @NonNull
    public final ThemeIRecyclerView normalRecyclerview;

    @NonNull
    private final ThemeIRecyclerView rootView;

    private FragmentRecyclerviewBinding(@NonNull ThemeIRecyclerView themeIRecyclerView, @NonNull ThemeIRecyclerView themeIRecyclerView2) {
        this.rootView = themeIRecyclerView;
        this.normalRecyclerview = themeIRecyclerView2;
    }

    @NonNull
    public static FragmentRecyclerviewBinding bind(@NonNull View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        ThemeIRecyclerView themeIRecyclerView = (ThemeIRecyclerView) view;
        return new FragmentRecyclerviewBinding(themeIRecyclerView, themeIRecyclerView);
    }

    @NonNull
    public static FragmentRecyclerviewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentRecyclerviewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.fragment_recyclerview, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ThemeIRecyclerView getRoot() {
        return this.rootView;
    }
}
