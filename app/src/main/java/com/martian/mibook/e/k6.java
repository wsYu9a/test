package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class k6 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12265a;

    /* renamed from: b */
    @NonNull
    public final RelativeLayout f12266b;

    private k6(@NonNull RelativeLayout rootView, @NonNull RelativeLayout guideView) {
        this.f12265a = rootView;
        this.f12266b = guideView;
    }

    @NonNull
    public static k6 a(@NonNull View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        RelativeLayout relativeLayout = (RelativeLayout) rootView;
        return new k6(relativeLayout, relativeLayout);
    }

    @NonNull
    public static k6 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static k6 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_slide_guide, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12265a;
    }
}
