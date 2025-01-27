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
public final class LayoutIrecyclerviewLoadMoreFooterTheEndViewBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f12213a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f12214b;

    public LayoutIrecyclerviewLoadMoreFooterTheEndViewBinding(@NonNull LinearLayout linearLayout, @NonNull ThemeTextView themeTextView) {
        this.f12213a = linearLayout;
        this.f12214b = themeTextView;
    }

    @NonNull
    public static LayoutIrecyclerviewLoadMoreFooterTheEndViewBinding a(@NonNull View view) {
        int i10 = R.id.tvTheEnd;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            return new LayoutIrecyclerviewLoadMoreFooterTheEndViewBinding((LinearLayout) view, themeTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static LayoutIrecyclerviewLoadMoreFooterTheEndViewBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static LayoutIrecyclerviewLoadMoreFooterTheEndViewBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.layout_irecyclerview_load_more_footer_the_end_view, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12213a;
    }
}
