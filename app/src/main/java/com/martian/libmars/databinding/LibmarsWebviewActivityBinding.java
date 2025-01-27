package com.martian.libmars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.VerticalSwipeRefreshLayout;
import com.martian.libmars.widget.MTWebView;

/* loaded from: classes3.dex */
public final class LibmarsWebviewActivityBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RelativeLayout f12309a;

    /* renamed from: b */
    @NonNull
    public final FrameLayout f12310b;

    /* renamed from: c */
    @NonNull
    public final MTWebView f12311c;

    /* renamed from: d */
    @NonNull
    public final ImageView f12312d;

    /* renamed from: e */
    @NonNull
    public final VerticalSwipeRefreshLayout f12313e;

    public LibmarsWebviewActivityBinding(@NonNull RelativeLayout relativeLayout, @NonNull FrameLayout frameLayout, @NonNull MTWebView mTWebView, @NonNull ImageView imageView, @NonNull VerticalSwipeRefreshLayout verticalSwipeRefreshLayout) {
        this.f12309a = relativeLayout;
        this.f12310b = frameLayout;
        this.f12311c = mTWebView;
        this.f12312d = imageView;
        this.f12313e = verticalSwipeRefreshLayout;
    }

    @NonNull
    public static LibmarsWebviewActivityBinding a(@NonNull View view) {
        int i10 = R.id.banner_ads;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i10);
        if (frameLayout != null) {
            i10 = R.id.libmars_webview;
            MTWebView mTWebView = (MTWebView) ViewBindings.findChildViewById(view, i10);
            if (mTWebView != null) {
                i10 = R.id.share;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                if (imageView != null) {
                    i10 = R.id.swipe_container;
                    VerticalSwipeRefreshLayout verticalSwipeRefreshLayout = (VerticalSwipeRefreshLayout) ViewBindings.findChildViewById(view, i10);
                    if (verticalSwipeRefreshLayout != null) {
                        return new LibmarsWebviewActivityBinding((RelativeLayout) view, frameLayout, mTWebView, imageView, verticalSwipeRefreshLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static LibmarsWebviewActivityBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static LibmarsWebviewActivityBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.libmars_webview_activity, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12309a;
    }
}
