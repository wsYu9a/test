package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeBottomNavigationBar;
import com.martian.mibook.ui.MyViewPager;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class l implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12270a;

    /* renamed from: b */
    @NonNull
    public final ThemeBottomNavigationBar f12271b;

    /* renamed from: c */
    @NonNull
    public final RelativeLayout f12272c;

    /* renamed from: d */
    @NonNull
    public final MyViewPager f12273d;

    /* renamed from: e */
    @NonNull
    public final ViewStub f12274e;

    private l(@NonNull RelativeLayout rootView, @NonNull ThemeBottomNavigationBar bottomNavigationBar, @NonNull RelativeLayout homepage, @NonNull MyViewPager mainPager, @NonNull ViewStub ttsFloatView) {
        this.f12270a = rootView;
        this.f12271b = bottomNavigationBar;
        this.f12272c = homepage;
        this.f12273d = mainPager;
        this.f12274e = ttsFloatView;
    }

    @NonNull
    public static l a(@NonNull View rootView) {
        int i2 = R.id.bottom_navigation_bar;
        ThemeBottomNavigationBar themeBottomNavigationBar = (ThemeBottomNavigationBar) rootView.findViewById(R.id.bottom_navigation_bar);
        if (themeBottomNavigationBar != null) {
            RelativeLayout relativeLayout = (RelativeLayout) rootView;
            i2 = R.id.main_pager;
            MyViewPager myViewPager = (MyViewPager) rootView.findViewById(R.id.main_pager);
            if (myViewPager != null) {
                i2 = R.id.tts_float_view;
                ViewStub viewStub = (ViewStub) rootView.findViewById(R.id.tts_float_view);
                if (viewStub != null) {
                    return new l(relativeLayout, themeBottomNavigationBar, relativeLayout, myViewPager, viewStub);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static l c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static l d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_homepage, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12270a;
    }
}
