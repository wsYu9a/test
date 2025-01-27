package com.martian.mibook.lib.account.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.lib.account.R;

/* loaded from: classes3.dex */
public final class ActivityWechatLoginBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ThemeRelativeLayout f13921a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f13922b;

    /* renamed from: c */
    @NonNull
    public final ImageView f13923c;

    /* renamed from: d */
    @NonNull
    public final TextView f13924d;

    /* renamed from: e */
    @NonNull
    public final LinearLayout f13925e;

    /* renamed from: f */
    @NonNull
    public final ThemeTextView f13926f;

    /* renamed from: g */
    @NonNull
    public final ThemeTextView f13927g;

    /* renamed from: h */
    @NonNull
    public final ThemeImageView f13928h;

    /* renamed from: i */
    @NonNull
    public final ThemeTextView f13929i;

    /* renamed from: j */
    @NonNull
    public final ThemeRelativeLayout f13930j;

    public ActivityWechatLoginBinding(@NonNull ThemeRelativeLayout themeRelativeLayout, @NonNull ThemeTextView themeTextView, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull ThemeTextView themeTextView2, @NonNull ThemeTextView themeTextView3, @NonNull ThemeImageView themeImageView, @NonNull ThemeTextView themeTextView4, @NonNull ThemeRelativeLayout themeRelativeLayout2) {
        this.f13921a = themeRelativeLayout;
        this.f13922b = themeTextView;
        this.f13923c = imageView;
        this.f13924d = textView;
        this.f13925e = linearLayout;
        this.f13926f = themeTextView2;
        this.f13927g = themeTextView3;
        this.f13928h = themeImageView;
        this.f13929i = themeTextView4;
        this.f13930j = themeRelativeLayout2;
    }

    @NonNull
    public static ActivityWechatLoginBinding a(@NonNull View view) {
        int i10 = R.id.bind_hint;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = R.id.intimate_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView != null) {
                i10 = R.id.loading_hint;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                if (textView != null) {
                    i10 = R.id.login_loading;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                    if (linearLayout != null) {
                        i10 = R.id.privacy_link;
                        ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView2 != null) {
                            i10 = R.id.user_privacy;
                            ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                            if (themeTextView3 != null) {
                                i10 = R.id.wechat_login_phone;
                                ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                if (themeImageView != null) {
                                    i10 = R.id.wechat_login_slogon;
                                    ThemeTextView themeTextView4 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                    if (themeTextView4 != null) {
                                        ThemeRelativeLayout themeRelativeLayout = (ThemeRelativeLayout) view;
                                        return new ActivityWechatLoginBinding(themeRelativeLayout, themeTextView, imageView, textView, linearLayout, themeTextView2, themeTextView3, themeImageView, themeTextView4, themeRelativeLayout);
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
    public static ActivityWechatLoginBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityWechatLoginBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_wechat_login, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeRelativeLayout getRoot() {
        return this.f13921a;
    }
}
