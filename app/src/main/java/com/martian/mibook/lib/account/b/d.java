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
import com.martian.mibook.lib.account.R;

/* loaded from: classes3.dex */
public final class d implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f13834a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f13835b;

    /* renamed from: c */
    @NonNull
    public final TextView f13836c;

    /* renamed from: d */
    @NonNull
    public final ImageView f13837d;

    /* renamed from: e */
    @NonNull
    public final LinearLayout f13838e;

    /* renamed from: f */
    @NonNull
    public final ImageView f13839f;

    /* renamed from: g */
    @NonNull
    public final TextView f13840g;

    /* renamed from: h */
    @NonNull
    public final TextView f13841h;

    /* renamed from: i */
    @NonNull
    public final ProgressBar f13842i;

    private d(@NonNull RelativeLayout rootView, @NonNull LinearLayout accountBindWx, @NonNull TextView bindWeixinTitle, @NonNull ImageView bindWxClose, @NonNull LinearLayout bindWxIntimate, @NonNull ImageView bindWxIntimateIcon, @NonNull TextView bindWxPrivacyLink, @NonNull TextView bindWxUserPrivacy, @NonNull ProgressBar loginProgressbar) {
        this.f13834a = rootView;
        this.f13835b = accountBindWx;
        this.f13836c = bindWeixinTitle;
        this.f13837d = bindWxClose;
        this.f13838e = bindWxIntimate;
        this.f13839f = bindWxIntimateIcon;
        this.f13840g = bindWxPrivacyLink;
        this.f13841h = bindWxUserPrivacy;
        this.f13842i = loginProgressbar;
    }

    @NonNull
    public static d a(@NonNull View rootView) {
        int i2 = R.id.account_bind_wx;
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(i2);
        if (linearLayout != null) {
            i2 = R.id.bind_weixin_title;
            TextView textView = (TextView) rootView.findViewById(i2);
            if (textView != null) {
                i2 = R.id.bind_wx_close;
                ImageView imageView = (ImageView) rootView.findViewById(i2);
                if (imageView != null) {
                    i2 = R.id.bind_wx_intimate;
                    LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(i2);
                    if (linearLayout2 != null) {
                        i2 = R.id.bind_wx_intimate_icon;
                        ImageView imageView2 = (ImageView) rootView.findViewById(i2);
                        if (imageView2 != null) {
                            i2 = R.id.bind_wx_privacy_link;
                            TextView textView2 = (TextView) rootView.findViewById(i2);
                            if (textView2 != null) {
                                i2 = R.id.bind_wx_user_privacy;
                                TextView textView3 = (TextView) rootView.findViewById(i2);
                                if (textView3 != null) {
                                    i2 = R.id.login_progressbar;
                                    ProgressBar progressBar = (ProgressBar) rootView.findViewById(i2);
                                    if (progressBar != null) {
                                        return new d((RelativeLayout) rootView, linearLayout, textView, imageView, linearLayout2, imageView2, textView2, textView3, progressBar);
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
    public static d c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static d d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.bind_weixin_dialog, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f13834a;
    }
}
