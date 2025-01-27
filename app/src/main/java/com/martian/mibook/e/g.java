package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.CountUpTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class g implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeRelativeLayout f11976a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f11977b;

    /* renamed from: c */
    @NonNull
    public final RelativeLayout f11978c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f11979d;

    /* renamed from: e */
    @NonNull
    public final CountUpTextView f11980e;

    /* renamed from: f */
    @NonNull
    public final TextView f11981f;

    /* renamed from: g */
    @NonNull
    public final TextView f11982g;

    /* renamed from: h */
    @NonNull
    public final NestedScrollView f11983h;

    /* renamed from: i */
    @NonNull
    public final ThemeTextView f11984i;

    /* renamed from: j */
    @NonNull
    public final TextView f11985j;

    @NonNull
    public final LinearLayout k;

    private g(@NonNull ThemeRelativeLayout rootView, @NonNull LinearLayout bonusAdsContainer, @NonNull RelativeLayout bonusDetailView, @NonNull ThemeTextView bonusDraw, @NonNull CountUpTextView bonusMoney, @NonNull TextView bonusMoneyUnit, @NonNull TextView bonusTitle, @NonNull NestedScrollView bonusView, @NonNull ThemeTextView urlMissionGrab, @NonNull TextView urlMissionTitle, @NonNull LinearLayout urlMissionView) {
        this.f11976a = rootView;
        this.f11977b = bonusAdsContainer;
        this.f11978c = bonusDetailView;
        this.f11979d = bonusDraw;
        this.f11980e = bonusMoney;
        this.f11981f = bonusMoneyUnit;
        this.f11982g = bonusTitle;
        this.f11983h = bonusView;
        this.f11984i = urlMissionGrab;
        this.f11985j = urlMissionTitle;
        this.k = urlMissionView;
    }

    @NonNull
    public static g a(@NonNull View rootView) {
        int i2 = R.id.bonus_ads_container;
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.bonus_ads_container);
        if (linearLayout != null) {
            i2 = R.id.bonus_detail_view;
            RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.bonus_detail_view);
            if (relativeLayout != null) {
                i2 = R.id.bonus_draw;
                ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.bonus_draw);
                if (themeTextView != null) {
                    i2 = R.id.bonus_money;
                    CountUpTextView countUpTextView = (CountUpTextView) rootView.findViewById(R.id.bonus_money);
                    if (countUpTextView != null) {
                        i2 = R.id.bonus_money_unit;
                        TextView textView = (TextView) rootView.findViewById(R.id.bonus_money_unit);
                        if (textView != null) {
                            i2 = R.id.bonus_title;
                            TextView textView2 = (TextView) rootView.findViewById(R.id.bonus_title);
                            if (textView2 != null) {
                                i2 = R.id.bonus_view;
                                NestedScrollView nestedScrollView = (NestedScrollView) rootView.findViewById(R.id.bonus_view);
                                if (nestedScrollView != null) {
                                    i2 = R.id.url_mission_grab;
                                    ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.url_mission_grab);
                                    if (themeTextView2 != null) {
                                        i2 = R.id.url_mission_title;
                                        TextView textView3 = (TextView) rootView.findViewById(R.id.url_mission_title);
                                        if (textView3 != null) {
                                            i2 = R.id.url_mission_view;
                                            LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.url_mission_view);
                                            if (linearLayout2 != null) {
                                                return new g((ThemeRelativeLayout) rootView, linearLayout, relativeLayout, themeTextView, countUpTextView, textView, textView2, nestedScrollView, themeTextView2, textView3, linearLayout2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static g c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static g d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_bonus_detail, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeRelativeLayout getRoot() {
        return this.f11976a;
    }
}
