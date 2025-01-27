package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeIRecyclerView;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class b3 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeRelativeLayout f11737a;

    /* renamed from: b */
    @NonNull
    public final LoadingTip f11738b;

    /* renamed from: c */
    @NonNull
    public final ThemeIRecyclerView f11739c;

    /* renamed from: d */
    @NonNull
    public final ThemeRelativeLayout f11740d;

    private b3(@NonNull ThemeRelativeLayout rootView, @NonNull LoadingTip categoryLoadingTip, @NonNull ThemeIRecyclerView categoryRecyclerview, @NonNull ThemeRelativeLayout svContainer) {
        this.f11737a = rootView;
        this.f11738b = categoryLoadingTip;
        this.f11739c = categoryRecyclerview;
        this.f11740d = svContainer;
    }

    @NonNull
    public static b3 a(@NonNull View rootView) {
        int i2 = R.id.category_loading_tip;
        LoadingTip loadingTip = (LoadingTip) rootView.findViewById(R.id.category_loading_tip);
        if (loadingTip != null) {
            i2 = R.id.category_recyclerview;
            ThemeIRecyclerView themeIRecyclerView = (ThemeIRecyclerView) rootView.findViewById(R.id.category_recyclerview);
            if (themeIRecyclerView != null) {
                ThemeRelativeLayout themeRelativeLayout = (ThemeRelativeLayout) rootView;
                return new b3(themeRelativeLayout, loadingTip, themeIRecyclerView, themeRelativeLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static b3 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static b3 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fragment_category, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeRelativeLayout getRoot() {
        return this.f11737a;
    }
}
