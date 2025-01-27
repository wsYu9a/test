package com.martian.libmars.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.VerticalSwipeRefreshLayout;
import com.martian.libmars.widget.MTWebView;

/* loaded from: classes2.dex */
public final class e0 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f9955a;

    /* renamed from: b */
    @NonNull
    public final FrameLayout f9956b;

    /* renamed from: c */
    @NonNull
    public final MTWebView f9957c;

    /* renamed from: d */
    @NonNull
    public final ImageView f9958d;

    /* renamed from: e */
    @NonNull
    public final VerticalSwipeRefreshLayout f9959e;

    private e0(@NonNull RelativeLayout rootView, @NonNull FrameLayout bannerAds, @NonNull MTWebView libmarsWebview, @NonNull ImageView share, @NonNull VerticalSwipeRefreshLayout swipeContainer) {
        this.f9955a = rootView;
        this.f9956b = bannerAds;
        this.f9957c = libmarsWebview;
        this.f9958d = share;
        this.f9959e = swipeContainer;
    }

    @NonNull
    public static e0 a(@NonNull View rootView) {
        int i2 = R.id.banner_ads;
        FrameLayout frameLayout = (FrameLayout) rootView.findViewById(i2);
        if (frameLayout != null) {
            i2 = R.id.libmars_webview;
            MTWebView mTWebView = (MTWebView) rootView.findViewById(i2);
            if (mTWebView != null) {
                i2 = R.id.share;
                ImageView imageView = (ImageView) rootView.findViewById(i2);
                if (imageView != null) {
                    i2 = R.id.swipe_container;
                    VerticalSwipeRefreshLayout verticalSwipeRefreshLayout = (VerticalSwipeRefreshLayout) rootView.findViewById(i2);
                    if (verticalSwipeRefreshLayout != null) {
                        return new e0((RelativeLayout) rootView, frameLayout, mTWebView, imageView, verticalSwipeRefreshLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static e0 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static e0 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.libmars_webview_activity, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f9955a;
    }
}
