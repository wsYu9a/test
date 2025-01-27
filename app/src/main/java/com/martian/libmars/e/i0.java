package com.martian.libmars.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.R;

/* loaded from: classes2.dex */
public final class i0 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final HorizontalScrollView f10004a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f10005b;

    /* renamed from: c */
    @NonNull
    public final HorizontalScrollView f10006c;

    /* renamed from: d */
    @NonNull
    public final LinearLayout f10007d;

    private i0(@NonNull HorizontalScrollView rootView, @NonNull LinearLayout indicatorContainer, @NonNull HorizontalScrollView scrollView, @NonNull LinearLayout titleContainer) {
        this.f10004a = rootView;
        this.f10005b = indicatorContainer;
        this.f10006c = scrollView;
        this.f10007d = titleContainer;
    }

    @NonNull
    public static i0 a(@NonNull View rootView) {
        int i2 = R.id.indicator_container;
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(i2);
        if (linearLayout != null) {
            HorizontalScrollView horizontalScrollView = (HorizontalScrollView) rootView;
            int i3 = R.id.title_container;
            LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(i3);
            if (linearLayout2 != null) {
                return new i0(horizontalScrollView, linearLayout, horizontalScrollView, linearLayout2);
            }
            i2 = i3;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static i0 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static i0 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.pager_navigator_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public HorizontalScrollView getRoot() {
        return this.f10004a;
    }
}
