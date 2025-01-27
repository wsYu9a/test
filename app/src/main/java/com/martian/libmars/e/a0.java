package com.martian.libmars.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.VerticalSwipeRefreshLayout;
import com.martian.libmars.widget.recyclerview.LoadingTip;

/* loaded from: classes2.dex */
public final class a0 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f9902a;

    /* renamed from: b */
    @NonNull
    public final u f9903b;

    /* renamed from: c */
    @NonNull
    public final ViewStub f9904c;

    /* renamed from: d */
    @NonNull
    public final LinearLayout f9905d;

    /* renamed from: e */
    @NonNull
    public final VerticalSwipeRefreshLayout f9906e;

    /* renamed from: f */
    @NonNull
    public final RelativeLayout f9907f;

    /* renamed from: g */
    @NonNull
    public final LoadingTip f9908g;

    private a0(@NonNull RelativeLayout rootView, @NonNull u libmarsActionBar, @NonNull ViewStub libmarsContainerView, @NonNull LinearLayout libmarsContainerViewLayout, @NonNull VerticalSwipeRefreshLayout libmarsStrRefreshLayout, @NonNull RelativeLayout libmarsStrRootView, @NonNull LoadingTip loadedTip) {
        this.f9902a = rootView;
        this.f9903b = libmarsActionBar;
        this.f9904c = libmarsContainerView;
        this.f9905d = libmarsContainerViewLayout;
        this.f9906e = libmarsStrRefreshLayout;
        this.f9907f = libmarsStrRootView;
        this.f9908g = loadedTip;
    }

    @NonNull
    public static a0 a(@NonNull View rootView) {
        int i2 = R.id.libmars_action_bar;
        View findViewById = rootView.findViewById(i2);
        if (findViewById != null) {
            u a2 = u.a(findViewById);
            i2 = R.id.libmars_container_view;
            ViewStub viewStub = (ViewStub) rootView.findViewById(i2);
            if (viewStub != null) {
                i2 = R.id.libmars_container_view_layout;
                LinearLayout linearLayout = (LinearLayout) rootView.findViewById(i2);
                if (linearLayout != null) {
                    i2 = R.id.libmars_str_refresh_layout;
                    VerticalSwipeRefreshLayout verticalSwipeRefreshLayout = (VerticalSwipeRefreshLayout) rootView.findViewById(i2);
                    if (verticalSwipeRefreshLayout != null) {
                        RelativeLayout relativeLayout = (RelativeLayout) rootView;
                        i2 = R.id.loadedTip;
                        LoadingTip loadingTip = (LoadingTip) rootView.findViewById(i2);
                        if (loadingTip != null) {
                            return new a0(relativeLayout, a2, viewStub, linearLayout, verticalSwipeRefreshLayout, relativeLayout, loadingTip);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static a0 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static a0 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.libmars_retry_loading_activity, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f9902a;
    }
}
