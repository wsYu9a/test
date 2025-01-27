package com.martian.mibook.lib.account.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.lib.account.R;

/* loaded from: classes3.dex */
public final class a implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f13812a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f13813b;

    /* renamed from: c */
    @NonNull
    public final TextView f13814c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f13815d;

    /* renamed from: e */
    @NonNull
    public final ImageView f13816e;

    /* renamed from: f */
    @NonNull
    public final RelativeLayout f13817f;

    /* renamed from: g */
    @NonNull
    public final ProgressBar f13818g;

    /* renamed from: h */
    @NonNull
    public final TextView f13819h;

    /* renamed from: i */
    @NonNull
    public final TextView f13820i;

    private a(@NonNull RelativeLayout rootView, @NonNull LinearLayout accountLoginIntimate, @NonNull TextView accountLoginPhone, @NonNull ThemeTextView accountLoginWx, @NonNull ImageView intimateIcon, @NonNull RelativeLayout loginDialogView, @NonNull ProgressBar loginProgressbar, @NonNull TextView privacyLink, @NonNull TextView userPrivacy) {
        this.f13812a = rootView;
        this.f13813b = accountLoginIntimate;
        this.f13814c = accountLoginPhone;
        this.f13815d = accountLoginWx;
        this.f13816e = intimateIcon;
        this.f13817f = loginDialogView;
        this.f13818g = loginProgressbar;
        this.f13819h = privacyLink;
        this.f13820i = userPrivacy;
    }

    @NonNull
    public static a a(@NonNull View rootView) {
        int i2 = R.id.account_login_intimate;
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(i2);
        if (linearLayout != null) {
            i2 = R.id.account_login_phone;
            TextView textView = (TextView) rootView.findViewById(i2);
            if (textView != null) {
                i2 = R.id.account_login_wx;
                ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(i2);
                if (themeTextView != null) {
                    i2 = R.id.intimate_icon;
                    ImageView imageView = (ImageView) rootView.findViewById(i2);
                    if (imageView != null) {
                        i2 = R.id.login_dialog_view;
                        RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(i2);
                        if (relativeLayout != null) {
                            i2 = R.id.login_progressbar;
                            ProgressBar progressBar = (ProgressBar) rootView.findViewById(i2);
                            if (progressBar != null) {
                                i2 = R.id.privacy_link;
                                TextView textView2 = (TextView) rootView.findViewById(i2);
                                if (textView2 != null) {
                                    i2 = R.id.user_privacy;
                                    TextView textView3 = (TextView) rootView.findViewById(i2);
                                    if (textView3 != null) {
                                        return new a((RelativeLayout) rootView, linearLayout, textView, themeTextView, imageView, relativeLayout, progressBar, textView2, textView3);
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
    public static a c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static a d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_login_window, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f13812a;
    }
}
