package com.martian.libmars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;

/* loaded from: classes3.dex */
public final class DialogConfirmViewBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RelativeLayout f12141a;

    /* renamed from: b */
    @NonNull
    public final CheckBox f12142b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f12143c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f12144d;

    /* renamed from: e */
    @NonNull
    public final ThemeTextView f12145e;

    /* renamed from: f */
    @NonNull
    public final View f12146f;

    /* renamed from: g */
    @NonNull
    public final ThemeTextView f12147g;

    /* renamed from: h */
    @NonNull
    public final ThemeLinearLayout f12148h;

    /* renamed from: i */
    @NonNull
    public final View f12149i;

    /* renamed from: j */
    @NonNull
    public final View f12150j;

    public DialogConfirmViewBinding(@NonNull RelativeLayout relativeLayout, @NonNull CheckBox checkBox, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeTextView themeTextView3, @NonNull View view, @NonNull ThemeTextView themeTextView4, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull View view2, @NonNull View view3) {
        this.f12141a = relativeLayout;
        this.f12142b = checkBox;
        this.f12143c = themeTextView;
        this.f12144d = themeTextView2;
        this.f12145e = themeTextView3;
        this.f12146f = view;
        this.f12147g = themeTextView4;
        this.f12148h = themeLinearLayout;
        this.f12149i = view2;
        this.f12150j = view3;
    }

    @NonNull
    public static DialogConfirmViewBinding a(@NonNull View view) {
        View findChildViewById;
        View findChildViewById2;
        View findChildViewById3;
        int i10 = R.id.dialog_check;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, i10);
        if (checkBox != null) {
            i10 = R.id.dialog_close;
            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView != null) {
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
                                return new DialogConfirmViewBinding((RelativeLayout) view, checkBox, themeTextView, themeTextView2, themeTextView3, findChildViewById, themeTextView4, themeLinearLayout, findChildViewById2, findChildViewById3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static DialogConfirmViewBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static DialogConfirmViewBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.dialog_confirm_view, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12141a;
    }
}
