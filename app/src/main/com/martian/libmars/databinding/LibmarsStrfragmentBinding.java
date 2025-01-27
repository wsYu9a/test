package com.martian.libmars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.R;
import com.martian.libmars.widget.recyclerview.LoadingTip;

/* loaded from: classes3.dex */
public final class LibmarsStrfragmentBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final SwipeRefreshLayout f12299a;

    /* renamed from: b */
    @NonNull
    public final ViewStub f12300b;

    /* renamed from: c */
    @NonNull
    public final FrameLayout f12301c;

    /* renamed from: d */
    @NonNull
    public final SwipeRefreshLayout f12302d;

    /* renamed from: e */
    @NonNull
    public final LoadingTip f12303e;

    public LibmarsStrfragmentBinding(@NonNull SwipeRefreshLayout swipeRefreshLayout, @NonNull ViewStub viewStub, @NonNull FrameLayout frameLayout, @NonNull SwipeRefreshLayout swipeRefreshLayout2, @NonNull LoadingTip loadingTip) {
        this.f12299a = swipeRefreshLayout;
        this.f12300b = viewStub;
        this.f12301c = frameLayout;
        this.f12302d = swipeRefreshLayout2;
        this.f12303e = loadingTip;
    }

    @NonNull
    public static LibmarsStrfragmentBinding a(@NonNull View view) {
        int i10 = R.id.libmars_str_container;
        ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, i10);
        if (viewStub != null) {
            i10 = R.id.libmars_str_frame_container;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i10);
            if (frameLayout != null) {
                SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view;
                i10 = R.id.loadedTip;
                LoadingTip loadingTip = (LoadingTip) ViewBindings.findChildViewById(view, i10);
                if (loadingTip != null) {
                    return new LibmarsStrfragmentBinding(swipeRefreshLayout, viewStub, frameLayout, swipeRefreshLayout, loadingTip);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static LibmarsStrfragmentBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static LibmarsStrfragmentBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.libmars_strfragment, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public SwipeRefreshLayout getRoot() {
        return this.f12299a;
    }
}
