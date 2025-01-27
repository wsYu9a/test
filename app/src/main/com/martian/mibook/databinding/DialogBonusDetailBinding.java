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
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.CountUpTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class DialogBonusDetailBinding implements ViewBinding {

    @NonNull
    public final LinearLayout dialogAdsContainers;

    @NonNull
    public final ThemeLinearLayout dialogAdsParentView;

    @NonNull
    public final View dialogAdsPlaceholder;

    @NonNull
    public final ThemeTextView dialogBonusAward;

    @NonNull
    public final ThemeTextView dialogBonusContinue;

    @NonNull
    public final CountUpTextView dialogBonusMoney;

    @NonNull
    public final TextView dialogBonusMoneyUnit;

    @NonNull
    public final ImageView dialogIconBox;

    @NonNull
    public final ThemeImageView dialogIconClose;

    @NonNull
    private final RelativeLayout rootView;

    private DialogBonusDetailBinding(@NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull View view, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull CountUpTextView countUpTextView, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull ThemeImageView themeImageView) {
        this.rootView = relativeLayout;
        this.dialogAdsContainers = linearLayout;
        this.dialogAdsParentView = themeLinearLayout;
        this.dialogAdsPlaceholder = view;
        this.dialogBonusAward = themeTextView;
        this.dialogBonusContinue = themeTextView2;
        this.dialogBonusMoney = countUpTextView;
        this.dialogBonusMoneyUnit = textView;
        this.dialogIconBox = imageView;
        this.dialogIconClose = themeImageView;
    }

    @NonNull
    public static DialogBonusDetailBinding bind(@NonNull View view) {
        View findChildViewById;
        int i10 = R.id.dialog_ads_containers;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
        if (linearLayout != null) {
            i10 = R.id.dialog_ads_parent_view;
            ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
            if (themeLinearLayout != null && (findChildViewById = ViewBindings.findChildViewById(view, (i10 = R.id.dialog_ads_placeholder))) != null) {
                i10 = R.id.dialog_bonus_award;
                ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView != null) {
                    i10 = R.id.dialog_bonus_continue;
                    ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (themeTextView2 != null) {
                        i10 = R.id.dialog_bonus_money;
                        CountUpTextView countUpTextView = (CountUpTextView) ViewBindings.findChildViewById(view, i10);
                        if (countUpTextView != null) {
                            i10 = R.id.dialog_bonus_money_unit;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                            if (textView != null) {
                                i10 = R.id.dialog_icon_box;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                                if (imageView != null) {
                                    i10 = R.id.dialog_icon_close;
                                    ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                    if (themeImageView != null) {
                                        return new DialogBonusDetailBinding((RelativeLayout) view, linearLayout, themeLinearLayout, findChildViewById, themeTextView, themeTextView2, countUpTextView, textView, imageView, themeImageView);
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
    public static DialogBonusDetailBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogBonusDetailBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.dialog_bonus_detail, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
