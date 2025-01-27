package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeIRecyclerView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class FragmentDiscountBookstoresBinding implements ViewBinding {

    @NonNull
    public final LinearLayout bsChannels;

    @NonNull
    public final ThemeIRecyclerView originalIrc;

    @NonNull
    public final LinearLayout originalTitle;

    @NonNull
    private final NestedScrollView rootView;

    @NonNull
    public final NestedScrollView svContainer;

    private FragmentDiscountBookstoresBinding(@NonNull NestedScrollView nestedScrollView, @NonNull LinearLayout linearLayout, @NonNull ThemeIRecyclerView themeIRecyclerView, @NonNull LinearLayout linearLayout2, @NonNull NestedScrollView nestedScrollView2) {
        this.rootView = nestedScrollView;
        this.bsChannels = linearLayout;
        this.originalIrc = themeIRecyclerView;
        this.originalTitle = linearLayout2;
        this.svContainer = nestedScrollView2;
    }

    @NonNull
    public static FragmentDiscountBookstoresBinding bind(@NonNull View view) {
        int i10 = R.id.bs_channels;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
        if (linearLayout != null) {
            i10 = R.id.original_irc;
            ThemeIRecyclerView themeIRecyclerView = (ThemeIRecyclerView) ViewBindings.findChildViewById(view, i10);
            if (themeIRecyclerView != null) {
                i10 = R.id.original_title;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                if (linearLayout2 != null) {
                    NestedScrollView nestedScrollView = (NestedScrollView) view;
                    return new FragmentDiscountBookstoresBinding(nestedScrollView, linearLayout, themeIRecyclerView, linearLayout2, nestedScrollView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static FragmentDiscountBookstoresBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentDiscountBookstoresBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.fragment_discount_bookstores, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public NestedScrollView getRoot() {
        return this.rootView;
    }
}
