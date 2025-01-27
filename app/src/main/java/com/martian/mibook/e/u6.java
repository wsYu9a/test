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
public final class u6 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12798a;

    /* renamed from: b */
    @NonNull
    public final RelativeLayout f12799b;

    private u6(@NonNull RelativeLayout rootView, @NonNull RelativeLayout guideView) {
        this.f12798a = rootView;
        this.f12799b = guideView;
    }

    @NonNull
    public static u6 a(@NonNull View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        RelativeLayout relativeLayout = (RelativeLayout) rootView;
        return new u6(relativeLayout, relativeLayout);
    }

    @NonNull
    public static u6 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static u6 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.scroll_reading_first_guide, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12798a;
    }
}
