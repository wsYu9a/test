package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class z0 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final FrameLayout f13005a;

    /* renamed from: b */
    @NonNull
    public final FrameLayout f13006b;

    private z0(@NonNull FrameLayout rootView, @NonNull FrameLayout adContainer) {
        this.f13005a = rootView;
        this.f13006b = adContainer;
    }

    @NonNull
    public static z0 a(@NonNull View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        FrameLayout frameLayout = (FrameLayout) rootView;
        return new z0(frameLayout, frameLayout);
    }

    @NonNull
    public static z0 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static z0 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.book_store_ads_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public FrameLayout getRoot() {
        return this.f13005a;
    }
}
