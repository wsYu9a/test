package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libugrowth.adx.AdxWebView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class c implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f11773a;

    /* renamed from: b */
    @NonNull
    public final AdxWebView f11774b;

    private c(@NonNull LinearLayout rootView, @NonNull AdxWebView adxWebview) {
        this.f11773a = rootView;
        this.f11774b = adxWebview;
    }

    @NonNull
    public static c a(@NonNull View rootView) {
        AdxWebView adxWebView = (AdxWebView) rootView.findViewById(R.id.adx_webview);
        if (adxWebView != null) {
            return new c((LinearLayout) rootView, adxWebView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.adx_webview)));
    }

    @NonNull
    public static c c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static c d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_adx, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f11773a;
    }
}
