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
public final class t2 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12720a;

    /* renamed from: b */
    @NonNull
    public final RelativeLayout f12721b;

    /* renamed from: c */
    @NonNull
    public final TextView f12722c;

    /* renamed from: d */
    @NonNull
    public final LinearLayout f12723d;

    /* renamed from: e */
    @NonNull
    public final TextView f12724e;

    /* renamed from: f */
    @NonNull
    public final TextView f12725f;

    /* renamed from: g */
    @NonNull
    public final TextView f12726g;

    /* renamed from: h */
    @NonNull
    public final RelativeLayout f12727h;

    /* renamed from: i */
    @NonNull
    public final ImageView f12728i;

    private t2(@NonNull RelativeLayout rootView, @NonNull RelativeLayout bonusDialogVipView, @NonNull TextView frBonusHint, @NonNull LinearLayout frBonusNum, @NonNull TextView frBonusOperate, @NonNull TextView frBonusTitle, @NonNull TextView frBonusUnit, @NonNull RelativeLayout frBonusView, @NonNull ImageView frClose) {
        this.f12720a = rootView;
        this.f12721b = bonusDialogVipView;
        this.f12722c = frBonusHint;
        this.f12723d = frBonusNum;
        this.f12724e = frBonusOperate;
        this.f12725f = frBonusTitle;
        this.f12726g = frBonusUnit;
        this.f12727h = frBonusView;
        this.f12728i = frClose;
    }

    @NonNull
    public static t2 a(@NonNull View rootView) {
        RelativeLayout relativeLayout = (RelativeLayout) rootView;
        int i2 = R.id.fr_bonus_hint;
        TextView textView = (TextView) rootView.findViewById(R.id.fr_bonus_hint);
        if (textView != null) {
            i2 = R.id.fr_bonus_num;
            LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.fr_bonus_num);
            if (linearLayout != null) {
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
                                    return new t2((RelativeLayout) rootView, relativeLayout, textView, linearLayout, textView2, textView3, textView4, relativeLayout2, imageView);
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
    public static t2 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static t2 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.dialog_vip_bonus, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12720a;
    }
}
