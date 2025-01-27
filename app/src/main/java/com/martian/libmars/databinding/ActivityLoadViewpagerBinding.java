package com.martian.libmars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.martian.libmars.R;

/* loaded from: classes3.dex */
public final class ActivityLoadViewpagerBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f12123a;

    /* renamed from: b */
    @NonNull
    public final ViewPager f12124b;

    public ActivityLoadViewpagerBinding(@NonNull LinearLayout linearLayout, @NonNull ViewPager viewPager) {
        this.f12123a = linearLayout;
        this.f12124b = viewPager;
    }

    @NonNull
    public static ActivityLoadViewpagerBinding a(@NonNull View view) {
        int i10 = R.id.vp_content;
        ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(view, i10);
        if (viewPager != null) {
            return new ActivityLoadViewpagerBinding((LinearLayout) view, viewPager);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ActivityLoadViewpagerBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityLoadViewpagerBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_load_viewpager, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12123a;
    }
}
