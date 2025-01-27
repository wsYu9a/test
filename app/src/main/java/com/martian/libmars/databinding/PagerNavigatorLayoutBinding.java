package com.martian.libmars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.R;

/* loaded from: classes3.dex */
public final class PagerNavigatorLayoutBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final HorizontalScrollView f12327a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f12328b;

    /* renamed from: c */
    @NonNull
    public final HorizontalScrollView f12329c;

    /* renamed from: d */
    @NonNull
    public final LinearLayout f12330d;

    public PagerNavigatorLayoutBinding(@NonNull HorizontalScrollView horizontalScrollView, @NonNull LinearLayout linearLayout, @NonNull HorizontalScrollView horizontalScrollView2, @NonNull LinearLayout linearLayout2) {
        this.f12327a = horizontalScrollView;
        this.f12328b = linearLayout;
        this.f12329c = horizontalScrollView2;
        this.f12330d = linearLayout2;
    }

    @NonNull
    public static PagerNavigatorLayoutBinding a(@NonNull View view) {
        int i10 = R.id.indicator_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
        if (linearLayout != null) {
            HorizontalScrollView horizontalScrollView = (HorizontalScrollView) view;
            int i11 = R.id.title_container;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i11);
            if (linearLayout2 != null) {
                return new PagerNavigatorLayoutBinding(horizontalScrollView, linearLayout, horizontalScrollView, linearLayout2);
            }
            i10 = i11;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static PagerNavigatorLayoutBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static PagerNavigatorLayoutBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.pager_navigator_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public HorizontalScrollView getRoot() {
        return this.f12327a;
    }
}
