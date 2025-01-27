package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class DialogVipBonusBinding implements ViewBinding {

    @NonNull
    public final ThemeImageView ivClose;

    @NonNull
    public final ImageView llBg;

    @NonNull
    public final ThemeLinearLayout llContent;

    @NonNull
    private final LinearLayout rootView;

    @NonNull
    public final TextView tvShowAd;

    @NonNull
    public final ThemeTextView tvTips;

    @NonNull
    public final TextView tvVipDialogBonus;

    @NonNull
    public final ThemeTextView tvVipDialogTitle;

    @NonNull
    public final TextView tvVipDialogUnit;

    private DialogVipBonusBinding(@NonNull LinearLayout linearLayout, @NonNull ThemeImageView themeImageView, @NonNull ImageView imageView, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull TextView textView, @NonNull ThemeTextView themeTextView, @NonNull TextView textView2, @NonNull ThemeTextView themeTextView2, @NonNull TextView textView3) {
        this.rootView = linearLayout;
        this.ivClose = themeImageView;
        this.llBg = imageView;
        this.llContent = themeLinearLayout;
        this.tvShowAd = textView;
        this.tvTips = themeTextView;
        this.tvVipDialogBonus = textView2;
        this.tvVipDialogTitle = themeTextView2;
        this.tvVipDialogUnit = textView3;
    }

    @NonNull
    public static DialogVipBonusBinding bind(@NonNull View view) {
        int i10 = R.id.iv_close;
        ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (themeImageView != null) {
            i10 = R.id.ll_bg;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView != null) {
                i10 = R.id.ll_content;
                ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                if (themeLinearLayout != null) {
                    i10 = R.id.tv_show_ad;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                    if (textView != null) {
                        i10 = R.id.tv_tips;
                        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView != null) {
                            i10 = R.id.tv_vip_dialog_bonus;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                            if (textView2 != null) {
                                i10 = R.id.tv_vip_dialog_title;
                                ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                if (themeTextView2 != null) {
                                    i10 = R.id.tv_vip_dialog_unit;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i10);
                                    if (textView3 != null) {
                                        return new DialogVipBonusBinding((LinearLayout) view, themeImageView, imageView, themeLinearLayout, textView, themeTextView, textView2, themeTextView2, textView3);
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
    public static DialogVipBonusBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogVipBonusBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.dialog_vip_bonus, viewGroup, false);
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
