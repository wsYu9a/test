package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class e0 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeRelativeLayout f11873a;

    /* renamed from: b */
    @NonNull
    public final ThemeLinearLayout f11874b;

    /* renamed from: c */
    @NonNull
    public final TextView f11875c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f11876d;

    /* renamed from: e */
    @NonNull
    public final FrameLayout f11877e;

    /* renamed from: f */
    @NonNull
    public final ThemeTextView f11878f;

    /* renamed from: g */
    @NonNull
    public final ThemeTextView f11879g;

    private e0(@NonNull ThemeRelativeLayout rootView, @NonNull ThemeLinearLayout wdAdsContainer, @NonNull TextView wdButton, @NonNull ThemeTextView wdDetailButton, @NonNull FrameLayout wdFloatAdsView, @NonNull ThemeTextView wdHint1, @NonNull ThemeTextView wdMoney) {
        this.f11873a = rootView;
        this.f11874b = wdAdsContainer;
        this.f11875c = wdButton;
        this.f11876d = wdDetailButton;
        this.f11877e = wdFloatAdsView;
        this.f11878f = wdHint1;
        this.f11879g = wdMoney;
    }

    @NonNull
    public static e0 a(@NonNull View rootView) {
        int i2 = R.id.wd_ads_container;
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.wd_ads_container);
        if (themeLinearLayout != null) {
            i2 = R.id.wd_button;
            TextView textView = (TextView) rootView.findViewById(R.id.wd_button);
            if (textView != null) {
                i2 = R.id.wd_detail_button;
                ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.wd_detail_button);
                if (themeTextView != null) {
                    i2 = R.id.wd_float_ads_view;
                    FrameLayout frameLayout = (FrameLayout) rootView.findViewById(R.id.wd_float_ads_view);
                    if (frameLayout != null) {
                        i2 = R.id.wd_hint_1;
                        ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.wd_hint_1);
                        if (themeTextView2 != null) {
                            i2 = R.id.wd_money;
                            ThemeTextView themeTextView3 = (ThemeTextView) rootView.findViewById(R.id.wd_money);
                            if (themeTextView3 != null) {
                                return new e0((ThemeRelativeLayout) rootView, themeLinearLayout, textView, themeTextView, frameLayout, themeTextView2, themeTextView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static e0 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static e0 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_withdraw_success, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeRelativeLayout getRoot() {
        return this.f11873a;
    }
}
