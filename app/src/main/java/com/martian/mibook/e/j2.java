package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.CountUpTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class j2 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12167a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f12168b;

    /* renamed from: c */
    @NonNull
    public final ThemeLinearLayout f12169c;

    /* renamed from: d */
    @NonNull
    public final View f12170d;

    /* renamed from: e */
    @NonNull
    public final ThemeTextView f12171e;

    /* renamed from: f */
    @NonNull
    public final ThemeTextView f12172f;

    /* renamed from: g */
    @NonNull
    public final CountUpTextView f12173g;

    /* renamed from: h */
    @NonNull
    public final TextView f12174h;

    /* renamed from: i */
    @NonNull
    public final ImageView f12175i;

    /* renamed from: j */
    @NonNull
    public final ThemeImageView f12176j;

    private j2(@NonNull RelativeLayout rootView, @NonNull LinearLayout dialogAdsContainers, @NonNull ThemeLinearLayout dialogAdsParentView, @NonNull View dialogAdsPlaceholder, @NonNull ThemeTextView dialogBonusAward, @NonNull ThemeTextView dialogBonusContinue, @NonNull CountUpTextView dialogBonusMoney, @NonNull TextView dialogBonusMoneyUnit, @NonNull ImageView dialogIconBox, @NonNull ThemeImageView dialogIconClose) {
        this.f12167a = rootView;
        this.f12168b = dialogAdsContainers;
        this.f12169c = dialogAdsParentView;
        this.f12170d = dialogAdsPlaceholder;
        this.f12171e = dialogBonusAward;
        this.f12172f = dialogBonusContinue;
        this.f12173g = dialogBonusMoney;
        this.f12174h = dialogBonusMoneyUnit;
        this.f12175i = dialogIconBox;
        this.f12176j = dialogIconClose;
    }

    @NonNull
    public static j2 a(@NonNull View rootView) {
        int i2 = R.id.dialog_ads_containers;
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.dialog_ads_containers);
        if (linearLayout != null) {
            i2 = R.id.dialog_ads_parent_view;
            ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.dialog_ads_parent_view);
            if (themeLinearLayout != null) {
                i2 = R.id.dialog_ads_placeholder;
                View findViewById = rootView.findViewById(R.id.dialog_ads_placeholder);
                if (findViewById != null) {
                    i2 = R.id.dialog_bonus_award;
                    ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.dialog_bonus_award);
                    if (themeTextView != null) {
                        i2 = R.id.dialog_bonus_continue;
                        ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.dialog_bonus_continue);
                        if (themeTextView2 != null) {
                            i2 = R.id.dialog_bonus_money;
                            CountUpTextView countUpTextView = (CountUpTextView) rootView.findViewById(R.id.dialog_bonus_money);
                            if (countUpTextView != null) {
                                i2 = R.id.dialog_bonus_money_unit;
                                TextView textView = (TextView) rootView.findViewById(R.id.dialog_bonus_money_unit);
                                if (textView != null) {
                                    i2 = R.id.dialog_icon_box;
                                    ImageView imageView = (ImageView) rootView.findViewById(R.id.dialog_icon_box);
                                    if (imageView != null) {
                                        i2 = R.id.dialog_icon_close;
                                        ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.dialog_icon_close);
                                        if (themeImageView != null) {
                                            return new j2((RelativeLayout) rootView, linearLayout, themeLinearLayout, findViewById, themeTextView, themeTextView2, countUpTextView, textView, imageView, themeImageView);
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
    public static j2 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static j2 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.dialog_bonus_detail, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12167a;
    }
}
