package com.martian.mibook.lib.account.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeEditText;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.lib.account.R;

/* loaded from: classes3.dex */
public final class b implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeRelativeLayout f13821a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f13822b;

    /* renamed from: c */
    @NonNull
    public final TextView f13823c;

    /* renamed from: d */
    @NonNull
    public final LinearLayout f13824d;

    /* renamed from: e */
    @NonNull
    public final ThemeEditText f13825e;

    /* renamed from: f */
    @NonNull
    public final ThemeEditText f13826f;

    /* renamed from: g */
    @NonNull
    public final ThemeRelativeLayout f13827g;

    /* renamed from: h */
    @NonNull
    public final ThemeTextView f13828h;

    /* renamed from: i */
    @NonNull
    public final LinearLayout f13829i;

    /* renamed from: j */
    @NonNull
    public final ThemeTextView f13830j;

    private b(@NonNull ThemeRelativeLayout rootView, @NonNull ThemeTextView bindHint, @NonNull TextView loadingHint, @NonNull LinearLayout loginLoading, @NonNull ThemeEditText loginPasswordEdit, @NonNull ThemeEditText loginPhoneEdit, @NonNull ThemeRelativeLayout phoneLoginView, @NonNull ThemeTextView phoneTitle, @NonNull LinearLayout qqLoginView, @NonNull ThemeTextView requestPhoneCodeText) {
        this.f13821a = rootView;
        this.f13822b = bindHint;
        this.f13823c = loadingHint;
        this.f13824d = loginLoading;
        this.f13825e = loginPasswordEdit;
        this.f13826f = loginPhoneEdit;
        this.f13827g = phoneLoginView;
        this.f13828h = phoneTitle;
        this.f13829i = qqLoginView;
        this.f13830j = requestPhoneCodeText;
    }

    @NonNull
    public static b a(@NonNull View rootView) {
        int i2 = R.id.bind_hint;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(i2);
        if (themeTextView != null) {
            i2 = R.id.loading_hint;
            TextView textView = (TextView) rootView.findViewById(i2);
            if (textView != null) {
                i2 = R.id.login_loading;
                LinearLayout linearLayout = (LinearLayout) rootView.findViewById(i2);
                if (linearLayout != null) {
                    i2 = R.id.login_password_edit;
                    ThemeEditText themeEditText = (ThemeEditText) rootView.findViewById(i2);
                    if (themeEditText != null) {
                        i2 = R.id.login_phone_edit;
                        ThemeEditText themeEditText2 = (ThemeEditText) rootView.findViewById(i2);
                        if (themeEditText2 != null) {
                            ThemeRelativeLayout themeRelativeLayout = (ThemeRelativeLayout) rootView;
                            i2 = R.id.phone_title;
                            ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(i2);
                            if (themeTextView2 != null) {
                                i2 = R.id.qq_login_view;
                                LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(i2);
                                if (linearLayout2 != null) {
                                    i2 = R.id.request_phone_code_text;
                                    ThemeTextView themeTextView3 = (ThemeTextView) rootView.findViewById(i2);
                                    if (themeTextView3 != null) {
                                        return new b(themeRelativeLayout, themeTextView, textView, linearLayout, themeEditText, themeEditText2, themeRelativeLayout, themeTextView2, linearLayout2, themeTextView3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static b c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static b d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_phone_login, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeRelativeLayout getRoot() {
        return this.f13821a;
    }
}
