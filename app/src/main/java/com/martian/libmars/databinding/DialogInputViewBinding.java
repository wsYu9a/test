package com.martian.libmars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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
public final class DialogInputViewBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RelativeLayout f12153a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f12154b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f12155c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f12156d;

    /* renamed from: e */
    @NonNull
    public final EditText f12157e;

    /* renamed from: f */
    @NonNull
    public final ThemeTextView f12158f;

    /* renamed from: g */
    @NonNull
    public final ThemeImageView f12159g;

    /* renamed from: h */
    @NonNull
    public final View f12160h;

    /* renamed from: i */
    @NonNull
    public final ThemeLinearLayout f12161i;

    /* renamed from: j */
    @NonNull
    public final View f12162j;

    /* renamed from: k */
    @NonNull
    public final View f12163k;

    /* renamed from: l */
    @NonNull
    public final ThemeLinearLayout f12164l;

    public DialogInputViewBinding(@NonNull RelativeLayout relativeLayout, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeTextView themeTextView3, @NonNull EditText editText, @NonNull ThemeTextView themeTextView4, @NonNull ThemeImageView themeImageView, @NonNull View view, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull View view2, @NonNull View view3, @NonNull ThemeLinearLayout themeLinearLayout2) {
        this.f12153a = relativeLayout;
        this.f12154b = themeTextView;
        this.f12155c = themeTextView2;
        this.f12156d = themeTextView3;
        this.f12157e = editText;
        this.f12158f = themeTextView4;
        this.f12159g = themeImageView;
        this.f12160h = view;
        this.f12161i = themeLinearLayout;
        this.f12162j = view2;
        this.f12163k = view3;
        this.f12164l = themeLinearLayout2;
    }

    @NonNull
    public static DialogInputViewBinding a(@NonNull View view) {
        View findChildViewById;
        View findChildViewById2;
        View findChildViewById3;
        int i10 = R.id.dialog_close;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = R.id.dialog_create_desc;
            ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView2 != null) {
                i10 = R.id.dialog_create_title;
                ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView3 != null) {
                    i10 = R.id.dialog_edit;
                    EditText editText = (EditText) ViewBindings.findChildViewById(view, i10);
                    if (editText != null) {
                        i10 = R.id.dialog_notarize;
                        ThemeTextView themeTextView4 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView4 != null) {
                            i10 = R.id.dialog_search_close;
                            ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                            if (themeImageView != null && (findChildViewById = ViewBindings.findChildViewById(view, (i10 = R.id.dialog_shade_view))) != null) {
                                i10 = R.id.dialog_view;
                                ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                if (themeLinearLayout != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i10 = R.id.dialog_view_bottom))) != null && (findChildViewById3 = ViewBindings.findChildViewById(view, (i10 = R.id.dialog_view_top))) != null) {
                                    i10 = R.id.search_view;
                                    ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                    if (themeLinearLayout2 != null) {
                                        return new DialogInputViewBinding((RelativeLayout) view, themeTextView, themeTextView2, themeTextView3, editText, themeTextView4, themeImageView, findChildViewById, themeLinearLayout, findChildViewById2, findChildViewById3, themeLinearLayout2);
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
    public static DialogInputViewBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static DialogInputViewBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.dialog_input_view, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12153a;
    }
}
