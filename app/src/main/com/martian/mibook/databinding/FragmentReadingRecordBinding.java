package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class FragmentReadingRecordBinding implements ViewBinding {

    @NonNull
    private final ThemeRelativeLayout rootView;

    @NonNull
    public final LoadingTip rvLoadedTip;

    @NonNull
    public final RecyclerView rvRecord;

    private FragmentReadingRecordBinding(@NonNull ThemeRelativeLayout themeRelativeLayout, @NonNull LoadingTip loadingTip, @NonNull RecyclerView recyclerView) {
        this.rootView = themeRelativeLayout;
        this.rvLoadedTip = loadingTip;
        this.rvRecord = recyclerView;
    }

    @NonNull
    public static FragmentReadingRecordBinding bind(@NonNull View view) {
        int i10 = R.id.rv_loadedTip;
        LoadingTip loadingTip = (LoadingTip) ViewBindings.findChildViewById(view, i10);
        if (loadingTip != null) {
            i10 = R.id.rv_record;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i10);
            if (recyclerView != null) {
                return new FragmentReadingRecordBinding((ThemeRelativeLayout) view, loadingTip, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static FragmentReadingRecordBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentReadingRecordBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.fragment_reading_record, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ThemeRelativeLayout getRoot() {
        return this.rootView;
    }
}
