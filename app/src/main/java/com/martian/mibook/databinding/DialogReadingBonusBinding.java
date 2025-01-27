package com.martian.mibook.databinding;

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
import androidx.viewbinding.ViewBindings;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class DialogReadingBonusBinding implements ViewBinding {

    @NonNull
    public final LinearLayout bonusAdsContainer;

    @NonNull
    public final TextView frBonusHint;

    @NonNull
    public final LinearLayout frBonusNum;

    @NonNull
    public final TextView frBonusOperate;

    @NonNull
    public final TextView frBonusTitle;

    @NonNull
    public final TextView frBonusUnit;

    @NonNull
    public final RelativeLayout frBonusView;

    @NonNull
    public final ImageView frClose;

    @NonNull
    private final LinearLayout rootView;

    private DialogReadingBonusBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull LinearLayout linearLayout3, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView) {
        this.rootView = linearLayout;
        this.bonusAdsContainer = linearLayout2;
        this.frBonusHint = textView;
        this.frBonusNum = linearLayout3;
        this.frBonusOperate = textView2;
        this.frBonusTitle = textView3;
        this.frBonusUnit = textView4;
        this.frBonusView = relativeLayout;
        this.frClose = imageView;
    }

    @NonNull
    public static DialogReadingBonusBinding bind(@NonNull View view) {
        int i10 = R.id.bonus_ads_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
        if (linearLayout != null) {
            i10 = R.id.fr_bonus_hint;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
            if (textView != null) {
                i10 = R.id.fr_bonus_num;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                if (linearLayout2 != null) {
                    i10 = R.id.fr_bonus_operate;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                    if (textView2 != null) {
                        i10 = R.id.fr_bonus_title;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i10);
                        if (textView3 != null) {
                            i10 = R.id.fr_bonus_unit;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i10);
                            if (textView4 != null) {
                                i10 = R.id.fr_bonus_view;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                                if (relativeLayout != null) {
                                    i10 = R.id.fr_close;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                                    if (imageView != null) {
                                        return new DialogReadingBonusBinding((LinearLayout) view, linearLayout, textView, linearLayout2, textView2, textView3, textView4, relativeLayout, imageView);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static DialogReadingBonusBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogReadingBonusBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.dialog_reading_bonus, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
