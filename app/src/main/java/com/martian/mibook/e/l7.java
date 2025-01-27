package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class l7 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12317a;

    /* renamed from: b */
    @NonNull
    public final ThemeLinearLayout f12318b;

    private l7(@NonNull LinearLayout rootView, @NonNull ThemeLinearLayout xianwanGameAdsView) {
        this.f12317a = rootView;
        this.f12318b = xianwanGameAdsView;
    }

    @NonNull
    public static l7 a(@NonNull View rootView) {
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.xianwan_game_ads_view);
        if (themeLinearLayout != null) {
            return new l7((LinearLayout) rootView, themeLinearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.xianwan_game_ads_view)));
    }

    @NonNull
    public static l7 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static l7 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.xianwan_game_ads, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12317a;
    }
}
