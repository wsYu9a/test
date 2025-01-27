package com.martian.libmars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.VerticalSwipeRefreshLayout;
import com.martian.libmars.widget.recyclerview.LoadingTip;

/* loaded from: classes3.dex */
public final class LibmarsRetryLoadingActivityBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RelativeLayout f12292a;

    /* renamed from: b */
    @NonNull
    public final LibmarsActionBarBinding f12293b;

    /* renamed from: c */
    @NonNull
    public final ViewStub f12294c;

    /* renamed from: d */
    @NonNull
    public final LinearLayout f12295d;

    /* renamed from: e */
    @NonNull
    public final VerticalSwipeRefreshLayout f12296e;

    /* renamed from: f */
    @NonNull
    public final RelativeLayout f12297f;

    /* renamed from: g */
    @NonNull
    public final LoadingTip f12298g;

    public LibmarsRetryLoadingActivityBinding(@NonNull RelativeLayout relativeLayout, @NonNull LibmarsActionBarBinding libmarsActionBarBinding, @NonNull ViewStub viewStub, @NonNull LinearLayout linearLayout, @NonNull VerticalSwipeRefreshLayout verticalSwipeRefreshLayout, @NonNull RelativeLayout relativeLayout2, @NonNull LoadingTip loadingTip) {
        this.f12292a = relativeLayout;
        this.f12293b = libmarsActionBarBinding;
        this.f12294c = viewStub;
        this.f12295d = linearLayout;
        this.f12296e = verticalSwipeRefreshLayout;
        this.f12297f = relativeLayout2;
        this.f12298g = loadingTip;
    }

    @NonNull
    public static LibmarsRetryLoadingActivityBinding a(@NonNull View view) {
        int i10 = R.id.libmars_action_bar;
        View findChildViewById = ViewBindings.findChildViewById(view, i10);
        if (findChildViewById != null) {
            LibmarsActionBarBinding a10 = LibmarsActionBarBinding.a(findChildViewById);
            i10 = R.id.libmars_container_view;
            ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, i10);
            if (viewStub != null) {
                i10 = R.id.libmars_container_view_layout;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                if (linearLayout != null) {
                    i10 = R.id.libmars_str_refresh_layout;
                    VerticalSwipeRefreshLayout verticalSwipeRefreshLayout = (VerticalSwipeRefreshLayout) ViewBindings.findChildViewById(view, i10);
                    if (verticalSwipeRefreshLayout != null) {
                        RelativeLayout relativeLayout = (RelativeLayout) view;
                        i10 = R.id.loadedTip;
                        LoadingTip loadingTip = (LoadingTip) ViewBindings.findChildViewById(view, i10);
                        if (loadingTip != null) {
                            return new LibmarsRetryLoadingActivityBinding(relativeLayout, a10, viewStub, linearLayout, verticalSwipeRefreshLayout, relativeLayout, loadingTip);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static LibmarsRetryLoadingActivityBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static LibmarsRetryLoadingActivityBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.libmars_retry_loading_activity, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12292a;
    }
}
