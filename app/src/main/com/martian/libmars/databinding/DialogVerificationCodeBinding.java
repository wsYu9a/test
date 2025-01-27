package com.martian.libmars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.ThemeEditText;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;

/* loaded from: classes3.dex */
public final class DialogVerificationCodeBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RelativeLayout f12184a;

    /* renamed from: b */
    @NonNull
    public final ImageView f12185b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f12186c;

    /* renamed from: d */
    @NonNull
    public final ThemeEditText f12187d;

    /* renamed from: e */
    @NonNull
    public final ThemeLinearLayout f12188e;

    /* renamed from: f */
    @NonNull
    public final ThemeLinearLayout f12189f;

    /* renamed from: g */
    @NonNull
    public final ThemeImageView f12190g;

    /* renamed from: h */
    @NonNull
    public final ThemeImageView f12191h;

    /* renamed from: i */
    @NonNull
    public final ThemeTextView f12192i;

    /* renamed from: j */
    @NonNull
    public final TextView f12193j;

    public DialogVerificationCodeBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull ThemeTextView themeTextView, @NonNull ThemeEditText themeEditText, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeLinearLayout themeLinearLayout2, @NonNull ThemeImageView themeImageView, @NonNull ThemeImageView themeImageView2, @NonNull ThemeTextView themeTextView2, @NonNull TextView textView) {
        this.f12184a = relativeLayout;
        this.f12185b = imageView;
        this.f12186c = themeTextView;
        this.f12187d = themeEditText;
        this.f12188e = themeLinearLayout;
        this.f12189f = themeLinearLayout2;
        this.f12190g = themeImageView;
        this.f12191h = themeImageView2;
        this.f12192i = themeTextView2;
        this.f12193j = textView;
    }

    @NonNull
    public static DialogVerificationCodeBinding a(@NonNull View view) {
        int i10 = R.id.code_bg;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
        if (imageView != null) {
            i10 = R.id.dialog_code_title;
            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView != null) {
                i10 = R.id.dialog_edit;
                ThemeEditText themeEditText = (ThemeEditText) ViewBindings.findChildViewById(view, i10);
                if (themeEditText != null) {
                    i10 = R.id.dialog_view;
                    ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                    if (themeLinearLayout != null) {
                        i10 = R.id.input_view;
                        ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                        if (themeLinearLayout2 != null) {
                            i10 = R.id.iv_close;
                            ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                            if (themeImageView != null) {
                                i10 = R.id.iv_refresh;
                                ThemeImageView themeImageView2 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                if (themeImageView2 != null) {
                                    i10 = R.id.tv_confirm;
                                    ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                    if (themeTextView2 != null) {
                                        i10 = R.id.tv_error_tips;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                                        if (textView != null) {
                                            return new DialogVerificationCodeBinding((RelativeLayout) view, imageView, themeTextView, themeEditText, themeLinearLayout, themeLinearLayout2, themeImageView, themeImageView2, themeTextView2, textView);
                                        }
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
    public static DialogVerificationCodeBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static DialogVerificationCodeBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.dialog_verification_code, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12184a;
    }
}
