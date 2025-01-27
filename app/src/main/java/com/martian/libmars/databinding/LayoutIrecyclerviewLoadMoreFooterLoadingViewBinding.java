package com.martian.libmars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.ThemeTextView;

/* loaded from: classes3.dex */
public final class LayoutIrecyclerviewLoadMoreFooterLoadingViewBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f12211a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f12212b;

    public LayoutIrecyclerviewLoadMoreFooterLoadingViewBinding(@NonNull LinearLayout linearLayout, @NonNull ThemeTextView themeTextView) {
        this.f12211a = linearLayout;
        this.f12212b = themeTextView;
    }

    @NonNull
    public static LayoutIrecyclerviewLoadMoreFooterLoadingViewBinding a(@NonNull View view) {
        int i10 = R.id.tvLoading;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            return new LayoutIrecyclerviewLoadMoreFooterLoadingViewBinding((LinearLayout) view, themeTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static LayoutIrecyclerviewLoadMoreFooterLoadingViewBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static LayoutIrecyclerviewLoadMoreFooterLoadingViewBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.layout_irecyclerview_load_more_footer_loading_view, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12211a;
    }
}
