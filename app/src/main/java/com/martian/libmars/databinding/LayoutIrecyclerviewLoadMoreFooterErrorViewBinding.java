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
public final class LayoutIrecyclerviewLoadMoreFooterErrorViewBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f12209a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f12210b;

    public LayoutIrecyclerviewLoadMoreFooterErrorViewBinding(@NonNull LinearLayout linearLayout, @NonNull ThemeTextView themeTextView) {
        this.f12209a = linearLayout;
        this.f12210b = themeTextView;
    }

    @NonNull
    public static LayoutIrecyclerviewLoadMoreFooterErrorViewBinding a(@NonNull View view) {
        int i10 = R.id.tvError;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            return new LayoutIrecyclerviewLoadMoreFooterErrorViewBinding((LinearLayout) view, themeTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static LayoutIrecyclerviewLoadMoreFooterErrorViewBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static LayoutIrecyclerviewLoadMoreFooterErrorViewBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.layout_irecyclerview_load_more_footer_error_view, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12209a;
    }
}
