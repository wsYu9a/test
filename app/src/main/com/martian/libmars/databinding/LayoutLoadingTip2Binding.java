package com.martian.libmars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;

/* loaded from: classes3.dex */
public final class LayoutLoadingTip2Binding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ThemeLinearLayout f12222a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f12223b;

    /* renamed from: c */
    @NonNull
    public final ThemeLinearLayout f12224c;

    /* renamed from: d */
    @NonNull
    public final LinearLayout f12225d;

    /* renamed from: e */
    @NonNull
    public final RelativeLayout f12226e;

    /* renamed from: f */
    @NonNull
    public final LinearLayout f12227f;

    /* renamed from: g */
    @NonNull
    public final ImageView f12228g;

    /* renamed from: h */
    @NonNull
    public final ThemeTextView f12229h;

    /* renamed from: i */
    @NonNull
    public final ThemeTextView f12230i;

    /* renamed from: j */
    @NonNull
    public final ThemeTextView f12231j;

    public LayoutLoadingTip2Binding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeTextView themeTextView, @NonNull ThemeLinearLayout themeLinearLayout2, @NonNull LinearLayout linearLayout, @NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeTextView themeTextView3, @NonNull ThemeTextView themeTextView4) {
        this.f12222a = themeLinearLayout;
        this.f12223b = themeTextView;
        this.f12224c = themeLinearLayout2;
        this.f12225d = linearLayout;
        this.f12226e = relativeLayout;
        this.f12227f = linearLayout2;
        this.f12228g = imageView;
        this.f12229h = themeTextView2;
        this.f12230i = themeTextView3;
        this.f12231j = themeTextView4;
    }

    @NonNull
    public static LayoutLoadingTip2Binding a(@NonNull View view) {
        int i10 = R.id.bt_operate;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) view;
            i10 = R.id.ll_retry;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
            if (linearLayout != null) {
                i10 = R.id.rl_loading;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                if (relativeLayout != null) {
                    i10 = R.id.tv_loading;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                    if (linearLayout2 != null) {
                        i10 = R.id.tv_loading_icon;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                        if (imageView != null) {
                            i10 = R.id.tv_tips;
                            ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                            if (themeTextView2 != null) {
                                i10 = R.id.tv_tips_hint;
                                ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                if (themeTextView3 != null) {
                                    i10 = R.id.tv_tips_retry_hint;
                                    ThemeTextView themeTextView4 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                    if (themeTextView4 != null) {
                                        return new LayoutLoadingTip2Binding(themeLinearLayout, themeTextView, themeLinearLayout, linearLayout, relativeLayout, linearLayout2, imageView, themeTextView2, themeTextView3, themeTextView4);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static LayoutLoadingTip2Binding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static LayoutLoadingTip2Binding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.layout_loading_tip_2, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f12222a;
    }
}
