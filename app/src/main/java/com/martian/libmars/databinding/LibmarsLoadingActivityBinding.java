package com.martian.libmars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.R;

/* loaded from: classes3.dex */
public final class LibmarsLoadingActivityBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final FrameLayout f12278a;

    /* renamed from: b */
    @NonNull
    public final FrameLayout f12279b;

    /* renamed from: c */
    @NonNull
    public final ProgressBar f12280c;

    public LibmarsLoadingActivityBinding(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull ProgressBar progressBar) {
        this.f12278a = frameLayout;
        this.f12279b = frameLayout2;
        this.f12280c = progressBar;
    }

    @NonNull
    public static LibmarsLoadingActivityBinding a(@NonNull View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i10 = R.id.libmars_pb_loading;
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i10);
        if (progressBar != null) {
            return new LibmarsLoadingActivityBinding(frameLayout, frameLayout, progressBar);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static LibmarsLoadingActivityBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static LibmarsLoadingActivityBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.libmars_loading_activity, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public FrameLayout getRoot() {
        return this.f12278a;
    }
}
