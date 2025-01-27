package com.martian.mibook.lib.account.databinding;

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
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.lib.account.R;

/* loaded from: classes3.dex */
public final class ActivityLoginWindowBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RelativeLayout f13902a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f13903b;

    /* renamed from: c */
    @NonNull
    public final TextView f13904c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f13905d;

    /* renamed from: e */
    @NonNull
    public final ImageView f13906e;

    /* renamed from: f */
    @NonNull
    public final RelativeLayout f13907f;

    /* renamed from: g */
    @NonNull
    public final ProgressBar f13908g;

    /* renamed from: h */
    @NonNull
    public final TextView f13909h;

    /* renamed from: i */
    @NonNull
    public final TextView f13910i;

    public ActivityLoginWindowBinding(@NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ThemeTextView themeTextView, @NonNull ImageView imageView, @NonNull RelativeLayout relativeLayout2, @NonNull ProgressBar progressBar, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f13902a = relativeLayout;
        this.f13903b = linearLayout;
        this.f13904c = textView;
        this.f13905d = themeTextView;
        this.f13906e = imageView;
        this.f13907f = relativeLayout2;
        this.f13908g = progressBar;
        this.f13909h = textView2;
        this.f13910i = textView3;
    }

    @NonNull
    public static ActivityLoginWindowBinding a(@NonNull View view) {
        int i10 = R.id.account_login_intimate;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
        if (linearLayout != null) {
            i10 = R.id.account_login_phone;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
            if (textView != null) {
                i10 = R.id.account_login_wx;
                ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView != null) {
                    i10 = R.id.intimate_icon;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                    if (imageView != null) {
                        i10 = R.id.login_dialog_view;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                        if (relativeLayout != null) {
                            i10 = R.id.login_progressbar;
                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i10);
                            if (progressBar != null) {
                                i10 = R.id.privacy_link;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                                if (textView2 != null) {
                                    i10 = R.id.user_privacy;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i10);
                                    if (textView3 != null) {
                                        return new ActivityLoginWindowBinding((RelativeLayout) view, linearLayout, textView, themeTextView, imageView, relativeLayout, progressBar, textView2, textView3);
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
    public static ActivityLoginWindowBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityLoginWindowBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_login_window, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f13902a;
    }
}
