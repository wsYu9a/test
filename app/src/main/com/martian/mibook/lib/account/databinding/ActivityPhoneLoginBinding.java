package com.martian.mibook.lib.account.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeEditText;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.lib.account.R;

/* loaded from: classes3.dex */
public final class ActivityPhoneLoginBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ThemeRelativeLayout f13911a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f13912b;

    /* renamed from: c */
    @NonNull
    public final TextView f13913c;

    /* renamed from: d */
    @NonNull
    public final LinearLayout f13914d;

    /* renamed from: e */
    @NonNull
    public final ThemeEditText f13915e;

    /* renamed from: f */
    @NonNull
    public final ThemeEditText f13916f;

    /* renamed from: g */
    @NonNull
    public final ThemeRelativeLayout f13917g;

    /* renamed from: h */
    @NonNull
    public final ThemeTextView f13918h;

    /* renamed from: i */
    @Nullable
    public final LinearLayout f13919i;

    /* renamed from: j */
    @NonNull
    public final ThemeTextView f13920j;

    public ActivityPhoneLoginBinding(@NonNull ThemeRelativeLayout themeRelativeLayout, @NonNull ThemeTextView themeTextView, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull ThemeEditText themeEditText, @NonNull ThemeEditText themeEditText2, @NonNull ThemeRelativeLayout themeRelativeLayout2, @NonNull ThemeTextView themeTextView2, @Nullable LinearLayout linearLayout2, @NonNull ThemeTextView themeTextView3) {
        this.f13911a = themeRelativeLayout;
        this.f13912b = themeTextView;
        this.f13913c = textView;
        this.f13914d = linearLayout;
        this.f13915e = themeEditText;
        this.f13916f = themeEditText2;
        this.f13917g = themeRelativeLayout2;
        this.f13918h = themeTextView2;
        this.f13919i = linearLayout2;
        this.f13920j = themeTextView3;
    }

    @NonNull
    public static ActivityPhoneLoginBinding a(@NonNull View view) {
        int i10 = R.id.bind_hint;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = R.id.loading_hint;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
            if (textView != null) {
                i10 = R.id.login_loading;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                if (linearLayout != null) {
                    i10 = R.id.login_password_edit;
                    ThemeEditText themeEditText = (ThemeEditText) ViewBindings.findChildViewById(view, i10);
                    if (themeEditText != null) {
                        i10 = R.id.login_phone_edit;
                        ThemeEditText themeEditText2 = (ThemeEditText) ViewBindings.findChildViewById(view, i10);
                        if (themeEditText2 != null) {
                            ThemeRelativeLayout themeRelativeLayout = (ThemeRelativeLayout) view;
                            i10 = R.id.phone_title;
                            ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                            if (themeTextView2 != null) {
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.qq_login_view);
                                i10 = R.id.request_phone_code_text;
                                ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                if (themeTextView3 != null) {
                                    return new ActivityPhoneLoginBinding(themeRelativeLayout, themeTextView, textView, linearLayout, themeEditText, themeEditText2, themeRelativeLayout, themeTextView2, linearLayout2, themeTextView3);
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
    public static ActivityPhoneLoginBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityPhoneLoginBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_phone_login, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeRelativeLayout getRoot() {
        return this.f13911a;
    }
}
