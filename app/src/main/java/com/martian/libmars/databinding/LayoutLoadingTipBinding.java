package com.martian.libmars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;

/* loaded from: classes3.dex */
public final class LayoutLoadingTipBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ThemeLinearLayout f12232a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f12233b;

    /* renamed from: c */
    @NonNull
    public final ImageView f12234c;

    /* renamed from: d */
    @NonNull
    public final ThemeLinearLayout f12235d;

    /* renamed from: e */
    @NonNull
    public final LinearLayout f12236e;

    /* renamed from: f */
    @NonNull
    public final ImageView f12237f;

    /* renamed from: g */
    @NonNull
    public final ThemeTextView f12238g;

    /* renamed from: h */
    @NonNull
    public final ThemeTextView f12239h;

    /* renamed from: i */
    @NonNull
    public final ThemeTextView f12240i;

    public LayoutLoadingTipBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeTextView themeTextView, @NonNull ImageView imageView, @NonNull ThemeLinearLayout themeLinearLayout2, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView2, @NonNull ThemeTextView themeTextView2, @NonNull ThemeTextView themeTextView3, @NonNull ThemeTextView themeTextView4) {
        this.f12232a = themeLinearLayout;
        this.f12233b = themeTextView;
        this.f12234c = imageView;
        this.f12235d = themeLinearLayout2;
        this.f12236e = linearLayout;
        this.f12237f = imageView2;
        this.f12238g = themeTextView2;
        this.f12239h = themeTextView3;
        this.f12240i = themeTextView4;
    }

    @NonNull
    public static LayoutLoadingTipBinding a(@NonNull View view) {
        int i10 = R.id.bt_operate;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = R.id.img_tip_logo;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView != null) {
                ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) view;
                i10 = R.id.tv_loading;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                if (linearLayout != null) {
                    i10 = R.id.tv_loading_icon;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                    if (imageView2 != null) {
                        i10 = R.id.tv_loading_text;
                        ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView2 != null) {
                            i10 = R.id.tv_tips;
                            ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                            if (themeTextView3 != null) {
                                i10 = R.id.tv_tips_retry_hint;
                                ThemeTextView themeTextView4 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                if (themeTextView4 != null) {
                                    return new LayoutLoadingTipBinding(themeLinearLayout, themeTextView, imageView, themeLinearLayout, linearLayout, imageView2, themeTextView2, themeTextView3, themeTextView4);
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
    public static LayoutLoadingTipBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static LayoutLoadingTipBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.layout_loading_tip, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f12232a;
    }
}
