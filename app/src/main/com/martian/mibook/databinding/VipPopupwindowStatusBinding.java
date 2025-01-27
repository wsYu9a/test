package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class VipPopupwindowStatusBinding implements ViewBinding {

    @NonNull
    private final RelativeLayout rootView;

    @NonNull
    public final AppCompatTextView vipStatusBenefitLeft;

    @NonNull
    public final AppCompatTextView vipStatusBenefitMiddle;

    @NonNull
    public final AppCompatTextView vipStatusBenefitRight;

    @NonNull
    public final ImageView vipStatusBg;

    @NonNull
    public final TextView vipStatusButton;

    @NonNull
    public final ImageView vipStatusCover;

    @NonNull
    public final TextView vipStatusDesc;

    @NonNull
    public final TextView vipStatusHead;

    @NonNull
    public final TextView vipStatusNickname;

    @NonNull
    public final TextView vipStatusTitle;

    @NonNull
    public final ImageView vipStatusclose;

    private VipPopupwindowStatusBinding(@NonNull RelativeLayout relativeLayout, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull ImageView imageView2, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull ImageView imageView3) {
        this.rootView = relativeLayout;
        this.vipStatusBenefitLeft = appCompatTextView;
        this.vipStatusBenefitMiddle = appCompatTextView2;
        this.vipStatusBenefitRight = appCompatTextView3;
        this.vipStatusBg = imageView;
        this.vipStatusButton = textView;
        this.vipStatusCover = imageView2;
        this.vipStatusDesc = textView2;
        this.vipStatusHead = textView3;
        this.vipStatusNickname = textView4;
        this.vipStatusTitle = textView5;
        this.vipStatusclose = imageView3;
    }

    @NonNull
    public static VipPopupwindowStatusBinding bind(@NonNull View view) {
        int i10 = R.id.vipStatusBenefitLeft;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i10);
        if (appCompatTextView != null) {
            i10 = R.id.vipStatusBenefitMiddle;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(view, i10);
            if (appCompatTextView2 != null) {
                i10 = R.id.vipStatusBenefitRight;
                AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.findChildViewById(view, i10);
                if (appCompatTextView3 != null) {
                    i10 = R.id.vipStatusBg;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                    if (imageView != null) {
                        i10 = R.id.vipStatusButton;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                        if (textView != null) {
                            i10 = R.id.vipStatusCover;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                            if (imageView2 != null) {
                                i10 = R.id.vipStatusDesc;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                                if (textView2 != null) {
                                    i10 = R.id.vipStatusHead;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i10);
                                    if (textView3 != null) {
                                        i10 = R.id.vipStatusNickname;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i10);
                                        if (textView4 != null) {
                                            i10 = R.id.vipStatusTitle;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i10);
                                            if (textView5 != null) {
                                                i10 = R.id.vipStatusclose;
                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                                if (imageView3 != null) {
                                                    return new VipPopupwindowStatusBinding((RelativeLayout) view, appCompatTextView, appCompatTextView2, appCompatTextView3, imageView, textView, imageView2, textView2, textView3, textView4, textView5, imageView3);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static VipPopupwindowStatusBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static VipPopupwindowStatusBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.vip_popupwindow_status, viewGroup, false);
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
