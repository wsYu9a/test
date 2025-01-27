package com.martian.libmars.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.R;
import com.martian.libmars.widget.recyclerview.LoadingTip;

/* loaded from: classes2.dex */
public final class b0 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final SwipeRefreshLayout f9913a;

    /* renamed from: b */
    @NonNull
    public final ViewStub f9914b;

    /* renamed from: c */
    @NonNull
    public final SwipeRefreshLayout f9915c;

    /* renamed from: d */
    @NonNull
    public final LoadingTip f9916d;

    private b0(@NonNull SwipeRefreshLayout rootView, @NonNull ViewStub libmarsStrContainer, @NonNull SwipeRefreshLayout libmarsStrRefreshLayout, @NonNull LoadingTip loadedTip) {
        this.f9913a = rootView;
        this.f9914b = libmarsStrContainer;
        this.f9915c = libmarsStrRefreshLayout;
        this.f9916d = loadedTip;
    }

    @NonNull
    public static b0 a(@NonNull View rootView) {
        int i2 = R.id.libmars_str_container;
        ViewStub viewStub = (ViewStub) rootView.findViewById(i2);
        if (viewStub != null) {
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) rootView;
            int i3 = R.id.loadedTip;
            LoadingTip loadingTip = (LoadingTip) rootView.findViewById(i3);
            if (loadingTip != null) {
                return new b0(swipeRefreshLayout, viewStub, swipeRefreshLayout, loadingTip);
            }
            i2 = i3;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static b0 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static b0 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.libmars_strfragment, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public SwipeRefreshLayout getRoot() {
        return this.f9913a;
    }
}
