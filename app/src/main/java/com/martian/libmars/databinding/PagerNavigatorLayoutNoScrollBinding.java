package com.martian.libmars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.R;

/* loaded from: classes3.dex */
public final class PagerNavigatorLayoutNoScrollBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final FrameLayout f12331a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f12332b;

    /* renamed from: c */
    @NonNull
    public final LinearLayout f12333c;

    public PagerNavigatorLayoutNoScrollBinding(@NonNull FrameLayout frameLayout, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2) {
        this.f12331a = frameLayout;
        this.f12332b = linearLayout;
        this.f12333c = linearLayout2;
    }

    @NonNull
    public static PagerNavigatorLayoutNoScrollBinding a(@NonNull View view) {
        int i10 = R.id.indicator_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
        if (linearLayout != null) {
            i10 = R.id.title_container;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
            if (linearLayout2 != null) {
                return new PagerNavigatorLayoutNoScrollBinding((FrameLayout) view, linearLayout, linearLayout2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static PagerNavigatorLayoutNoScrollBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static PagerNavigatorLayoutNoScrollBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.pager_navigator_layout_no_scroll, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public FrameLayout getRoot() {
        return this.f12331a;
    }
}
