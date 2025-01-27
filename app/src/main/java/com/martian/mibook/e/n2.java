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
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class n2 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12412a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f12413b;

    /* renamed from: c */
    @NonNull
    public final RelativeLayout f12414c;

    /* renamed from: d */
    @NonNull
    public final TextView f12415d;

    /* renamed from: e */
    @NonNull
    public final LinearLayout f12416e;

    /* renamed from: f */
    @NonNull
    public final TextView f12417f;

    /* renamed from: g */
    @NonNull
    public final TextView f12418g;

    /* renamed from: h */
    @NonNull
    public final TextView f12419h;

    /* renamed from: i */
    @NonNull
    public final RelativeLayout f12420i;

    /* renamed from: j */
    @NonNull
    public final ImageView f12421j;

    private n2(@NonNull RelativeLayout rootView, @NonNull LinearLayout bonusAdsContainer, @NonNull RelativeLayout bonusDialogView, @NonNull TextView frBonusHint, @NonNull LinearLayout frBonusNum, @NonNull TextView frBonusOperate, @NonNull TextView frBonusTitle, @NonNull TextView frBonusUnit, @NonNull RelativeLayout frBonusView, @NonNull ImageView frClose) {
        this.f12412a = rootView;
        this.f12413b = bonusAdsContainer;
        this.f12414c = bonusDialogView;
        this.f12415d = frBonusHint;
        this.f12416e = frBonusNum;
        this.f12417f = frBonusOperate;
        this.f12418g = frBonusTitle;
        this.f12419h = frBonusUnit;
        this.f12420i = frBonusView;
        this.f12421j = frClose;
    }

    @NonNull
    public static n2 a(@NonNull View rootView) {
        int i2 = R.id.bonus_ads_container;
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.bonus_ads_container);
        if (linearLayout != null) {
            RelativeLayout relativeLayout = (RelativeLayout) rootView;
            i2 = R.id.fr_bonus_hint;
            TextView textView = (TextView) rootView.findViewById(R.id.fr_bonus_hint);
            if (textView != null) {
                i2 = R.id.fr_bonus_num;
                LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.fr_bonus_num);
                if (linearLayout2 != null) {
                    i2 = R.id.fr_bonus_operate;
                    TextView textView2 = (TextView) rootView.findViewById(R.id.fr_bonus_operate);
                    if (textView2 != null) {
                        i2 = R.id.fr_bonus_title;
                        TextView textView3 = (TextView) rootView.findViewById(R.id.fr_bonus_title);
                        if (textView3 != null) {
                            i2 = R.id.fr_bonus_unit;
                            TextView textView4 = (TextView) rootView.findViewById(R.id.fr_bonus_unit);
                            if (textView4 != null) {
                                i2 = R.id.fr_bonus_view;
                                RelativeLayout relativeLayout2 = (RelativeLayout) rootView.findViewById(R.id.fr_bonus_view);
                                if (relativeLayout2 != null) {
                                    i2 = R.id.fr_close;
                                    ImageView imageView = (ImageView) rootView.findViewById(R.id.fr_close);
                                    if (imageView != null) {
                                        return new n2(relativeLayout, linearLayout, relativeLayout, textView, linearLayout2, textView2, textView3, textView4, relativeLayout2, imageView);
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
    public static n2 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static n2 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.dialog_reading_bonus, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12412a;
    }
}
