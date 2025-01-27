package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.CountUpTextView;
import com.martian.mibook.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* loaded from: classes3.dex */
public final class FragmentCommissionIncomeNewBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout clHorn;

    @NonNull
    public final CountUpTextView ctvMoney;

    @NonNull
    public final ImageView ivCloseHorn;

    @NonNull
    public final ImageView ivHorn;

    @NonNull
    public final LinearLayout martianTipsView;

    @NonNull
    public final LinearLayout missionItems;

    @NonNull
    public final CircleImageView rcHeaderOne;

    @NonNull
    public final CircleImageView rcHeaderThree;

    @NonNull
    public final CircleImageView rcHeaderTwo;

    @NonNull
    private final NestedScrollView rootView;

    @NonNull
    public final TextView tvHornContent;

    @NonNull
    public final ThemeTextView tvMoneyIncomeText;

    @NonNull
    public final ThemeImageView tvMore;

    @NonNull
    public final ThemeTextView tvWithdrawal;

    private FragmentCommissionIncomeNewBinding(@NonNull NestedScrollView nestedScrollView, @NonNull ConstraintLayout constraintLayout, @NonNull CountUpTextView countUpTextView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull CircleImageView circleImageView, @NonNull CircleImageView circleImageView2, @NonNull CircleImageView circleImageView3, @NonNull TextView textView, @NonNull ThemeTextView themeTextView, @NonNull ThemeImageView themeImageView, @NonNull ThemeTextView themeTextView2) {
        this.rootView = nestedScrollView;
        this.clHorn = constraintLayout;
        this.ctvMoney = countUpTextView;
        this.ivCloseHorn = imageView;
        this.ivHorn = imageView2;
        this.martianTipsView = linearLayout;
        this.missionItems = linearLayout2;
        this.rcHeaderOne = circleImageView;
        this.rcHeaderThree = circleImageView2;
        this.rcHeaderTwo = circleImageView3;
        this.tvHornContent = textView;
        this.tvMoneyIncomeText = themeTextView;
        this.tvMore = themeImageView;
        this.tvWithdrawal = themeTextView2;
    }

    @NonNull
    public static FragmentCommissionIncomeNewBinding bind(@NonNull View view) {
        int i10 = R.id.cl_horn;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i10);
        if (constraintLayout != null) {
            i10 = R.id.ctv_money;
            CountUpTextView countUpTextView = (CountUpTextView) ViewBindings.findChildViewById(view, i10);
            if (countUpTextView != null) {
                i10 = R.id.iv_close_horn;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                if (imageView != null) {
                    i10 = R.id.iv_horn;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                    if (imageView2 != null) {
                        i10 = R.id.martian_tips_view;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                        if (linearLayout != null) {
                            i10 = R.id.mission_items;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                            if (linearLayout2 != null) {
                                i10 = R.id.rc_header_one;
                                CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(view, i10);
                                if (circleImageView != null) {
                                    i10 = R.id.rc_header_three;
                                    CircleImageView circleImageView2 = (CircleImageView) ViewBindings.findChildViewById(view, i10);
                                    if (circleImageView2 != null) {
                                        i10 = R.id.rc_header_two;
                                        CircleImageView circleImageView3 = (CircleImageView) ViewBindings.findChildViewById(view, i10);
                                        if (circleImageView3 != null) {
                                            i10 = R.id.tv_horn_content;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                                            if (textView != null) {
                                                i10 = R.id.tv_money_income_text;
                                                ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                if (themeTextView != null) {
                                                    i10 = R.id.tv_more;
                                                    ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                    if (themeImageView != null) {
                                                        i10 = R.id.tv_withdrawal;
                                                        ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                        if (themeTextView2 != null) {
                                                            return new FragmentCommissionIncomeNewBinding((NestedScrollView) view, constraintLayout, countUpTextView, imageView, imageView2, linearLayout, linearLayout2, circleImageView, circleImageView2, circleImageView3, textView, themeTextView, themeImageView, themeTextView2);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static FragmentCommissionIncomeNewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentCommissionIncomeNewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.fragment_commission_income_new, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public NestedScrollView getRoot() {
        return this.rootView;
    }
}
