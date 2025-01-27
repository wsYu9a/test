package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.widget.MTWebView;
import com.martian.mibook.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: classes3.dex */
public final class FragmentWebviewBinding implements ViewBinding {

    @NonNull
    public final SmartRefreshLayout refreshLayout;

    @NonNull
    private final CoordinatorLayout rootView;

    @NonNull
    public final MTWebView webview;

    private FragmentWebviewBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull SmartRefreshLayout smartRefreshLayout, @NonNull MTWebView mTWebView) {
        this.rootView = coordinatorLayout;
        this.refreshLayout = smartRefreshLayout;
        this.webview = mTWebView;
    }

    @NonNull
    public static FragmentWebviewBinding bind(@NonNull View view) {
        int i10 = R.id.refreshLayout;
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) ViewBindings.findChildViewById(view, i10);
        if (smartRefreshLayout != null) {
            i10 = R.id.webview;
            MTWebView mTWebView = (MTWebView) ViewBindings.findChildViewById(view, i10);
            if (mTWebView != null) {
                return new FragmentWebviewBinding((CoordinatorLayout) view, smartRefreshLayout, mTWebView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static FragmentWebviewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentWebviewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.fragment_webview, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }
}
