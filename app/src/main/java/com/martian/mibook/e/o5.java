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
public final class o5 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12489a;

    /* renamed from: b */
    @NonNull
    public final AdxWebView f12490b;

    private o5(@NonNull LinearLayout rootView, @NonNull AdxWebView adxWebview) {
        this.f12489a = rootView;
        this.f12490b = adxWebview;
    }

    @NonNull
    public static o5 a(@NonNull View rootView) {
        AdxWebView adxWebView = (AdxWebView) rootView.findViewById(R.id.adx_webview);
        if (adxWebView != null) {
            return new o5((LinearLayout) rootView, adxWebView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.adx_webview)));
    }

    @NonNull
    public static o5 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static o5 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_adx_webview, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12489a;
    }
}
