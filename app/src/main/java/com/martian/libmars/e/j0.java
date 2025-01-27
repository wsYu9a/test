package com.martian.libmars.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.R;

/* loaded from: classes2.dex */
public final class j0 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final FrameLayout f10011a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f10012b;

    /* renamed from: c */
    @NonNull
    public final LinearLayout f10013c;

    private j0(@NonNull FrameLayout rootView, @NonNull LinearLayout indicatorContainer, @NonNull LinearLayout titleContainer) {
        this.f10011a = rootView;
        this.f10012b = indicatorContainer;
        this.f10013c = titleContainer;
    }

    @NonNull
    public static j0 a(@NonNull View rootView) {
        int i2 = R.id.indicator_container;
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(i2);
        if (linearLayout != null) {
            i2 = R.id.title_container;
            LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(i2);
            if (linearLayout2 != null) {
                return new j0((FrameLayout) rootView, linearLayout, linearLayout2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static j0 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static j0 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.pager_navigator_layout_no_scroll, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public FrameLayout getRoot() {
        return this.f10011a;
    }
}
