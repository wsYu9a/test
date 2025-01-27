package com.martian.libmars.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.martian.libmars.R;

/* loaded from: classes2.dex */
public final class a implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f9900a;

    /* renamed from: b */
    @NonNull
    public final ViewPager f9901b;

    private a(@NonNull LinearLayout rootView, @NonNull ViewPager vpContent) {
        this.f9900a = rootView;
        this.f9901b = vpContent;
    }

    @NonNull
    public static a a(@NonNull View rootView) {
        int i2 = R.id.vp_content;
        ViewPager viewPager = (ViewPager) rootView.findViewById(i2);
        if (viewPager != null) {
            return new a((LinearLayout) rootView, viewPager);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static a c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static a d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_load_viewpager, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f9900a;
    }
}
