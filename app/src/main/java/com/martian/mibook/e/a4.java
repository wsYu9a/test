package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class a4 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f11690a;

    /* renamed from: b */
    @NonNull
    public final ViewPager f11691b;

    private a4(@NonNull ThemeLinearLayout rootView, @NonNull ViewPager lbContent) {
        this.f11690a = rootView;
        this.f11691b = lbContent;
    }

    @NonNull
    public static a4 a(@NonNull View rootView) {
        ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.lb_content);
        if (viewPager != null) {
            return new a4((ThemeLinearLayout) rootView, viewPager);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.lb_content)));
    }

    @NonNull
    public static a4 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static a4 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.martian_activity_yw_book_rank_list, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f11690a;
    }
}
