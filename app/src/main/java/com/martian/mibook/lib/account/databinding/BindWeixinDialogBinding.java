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
import com.martian.mibook.lib.account.R;

/* loaded from: classes3.dex */
public final class BindWeixinDialogBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RelativeLayout f13931a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f13932b;

    /* renamed from: c */
    @NonNull
    public final TextView f13933c;

    /* renamed from: d */
    @NonNull
    public final ImageView f13934d;

    /* renamed from: e */
    @NonNull
    public final LinearLayout f13935e;

    /* renamed from: f */
    @NonNull
    public final ImageView f13936f;

    /* renamed from: g */
    @NonNull
    public final TextView f13937g;

    /* renamed from: h */
    @NonNull
    public final TextView f13938h;

    /* renamed from: i */
    @NonNull
    public final ProgressBar f13939i;

    public BindWeixinDialogBinding(@NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView2, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull ProgressBar progressBar) {
        this.f13931a = relativeLayout;
        this.f13932b = linearLayout;
        this.f13933c = textView;
        this.f13934d = imageView;
        this.f13935e = linearLayout2;
        this.f13936f = imageView2;
        this.f13937g = textView2;
        this.f13938h = textView3;
        this.f13939i = progressBar;
    }

    @NonNull
    public static BindWeixinDialogBinding a(@NonNull View view) {
        int i10 = R.id.account_bind_wx;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
        if (linearLayout != null) {
            i10 = R.id.bind_weixin_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
            if (textView != null) {
                i10 = R.id.bind_wx_close;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                if (imageView != null) {
                    i10 = R.id.bind_wx_intimate;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                    if (linearLayout2 != null) {
                        i10 = R.id.bind_wx_intimate_icon;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                        if (imageView2 != null) {
                            i10 = R.id.bind_wx_privacy_link;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                            if (textView2 != null) {
                                i10 = R.id.bind_wx_user_privacy;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i10);
                                if (textView3 != null) {
                                    i10 = R.id.login_progressbar;
                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i10);
                                    if (progressBar != null) {
                                        return new BindWeixinDialogBinding((RelativeLayout) view, linearLayout, textView, imageView, linearLayout2, imageView2, textView2, textView3, progressBar);
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
    public static BindWeixinDialogBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static BindWeixinDialogBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.bind_weixin_dialog, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f13931a;
    }
}
