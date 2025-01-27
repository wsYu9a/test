package com.martian.libmars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;

/* loaded from: classes3.dex */
public final class DialogConfirmHintBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RelativeLayout f12131a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f12132b;

    /* renamed from: c */
    @NonNull
    public final ThemeImageView f12133c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f12134d;

    /* renamed from: e */
    @NonNull
    public final ThemeTextView f12135e;

    /* renamed from: f */
    @NonNull
    public final View f12136f;

    /* renamed from: g */
    @NonNull
    public final ThemeTextView f12137g;

    /* renamed from: h */
    @NonNull
    public final ThemeLinearLayout f12138h;

    /* renamed from: i */
    @NonNull
    public final View f12139i;

    /* renamed from: j */
    @NonNull
    public final View f12140j;

    public DialogConfirmHintBinding(@NonNull RelativeLayout relativeLayout, @NonNull ThemeTextView themeTextView, @NonNull ThemeImageView themeImageView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeTextView themeTextView3, @NonNull View view, @NonNull ThemeTextView themeTextView4, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull View view2, @NonNull View view3) {
        this.f12131a = relativeLayout;
        this.f12132b = themeTextView;
        this.f12133c = themeImageView;
        this.f12134d = themeTextView2;
        this.f12135e = themeTextView3;
        this.f12136f = view;
        this.f12137g = themeTextView4;
        this.f12138h = themeLinearLayout;
        this.f12139i = view2;
        this.f12140j = view3;
    }

    @NonNull
    public static DialogConfirmHintBinding a(@NonNull View view) {
        View findChildViewById;
        View findChildViewById2;
        View findChildViewById3;
        int i10 = R.id.dialog_close;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = R.id.dialog_close_image;
            ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
            if (themeImageView != null) {
                i10 = R.id.dialog_desc;
                ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView2 != null) {
                    i10 = R.id.dialog_notarize;
                    ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (themeTextView3 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i10 = R.id.dialog_shade_view))) != null) {
                        i10 = R.id.dialog_title;
                        ThemeTextView themeTextView4 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView4 != null) {
                            i10 = R.id.dialog_view;
                            ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                            if (themeLinearLayout != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i10 = R.id.dialog_view_bottom))) != null && (findChildViewById3 = ViewBindings.findChildViewById(view, (i10 = R.id.dialog_view_top))) != null) {
                                return new DialogConfirmHintBinding((RelativeLayout) view, themeTextView, themeImageView, themeTextView2, themeTextView3, findChildViewById, themeTextView4, themeLinearLayout, findChildViewById2, findChildViewById3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static DialogConfirmHintBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static DialogConfirmHintBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.dialog_confirm_hint, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12131a;
    }
}
