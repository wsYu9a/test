package com.martian.libmars.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.R;

/* loaded from: classes2.dex */
public final class x implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final FrameLayout f10066a;

    /* renamed from: b */
    @NonNull
    public final FrameLayout f10067b;

    /* renamed from: c */
    @NonNull
    public final ProgressBar f10068c;

    private x(@NonNull FrameLayout rootView, @NonNull FrameLayout libmarsLoadingWrapper, @NonNull ProgressBar libmarsPbLoading) {
        this.f10066a = rootView;
        this.f10067b = libmarsLoadingWrapper;
        this.f10068c = libmarsPbLoading;
    }

    @NonNull
    public static x a(@NonNull View rootView) {
        FrameLayout frameLayout = (FrameLayout) rootView;
        int i2 = R.id.libmars_pb_loading;
        ProgressBar progressBar = (ProgressBar) rootView.findViewById(i2);
        if (progressBar != null) {
            return new x((FrameLayout) rootView, frameLayout, progressBar);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static x c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static x d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.libmars_loading_activity, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public FrameLayout getRoot() {
        return this.f10066a;
    }
}
