package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.mibook.R;
import com.martian.mibook.mvvm.payment.ui.ThemeVipImageView;
import com.martian.mibook.mvvm.payment.ui.ThemeVipProgressBar;
import com.martian.mibook.mvvm.payment.ui.ThemeVipRelativeLayout;
import com.martian.mibook.mvvm.payment.ui.ThemeVipTextView;
import de.hdodenhof.circleimageview.CircleImageView;

/* loaded from: classes3.dex */
public final class FragmentVipPayDialogBinding implements ViewBinding {

    @NonNull
    public final ThemeLinearLayout accountLinkAccountView;

    @NonNull
    public final ThemeTextView accountVipDesc;

    @NonNull
    public final LinearLayout accountVipStatusView;

    @NonNull
    public final ImageView accountVipTag;

    @NonNull
    public final ThemeTextView accountVipTitle;

    @NonNull
    public final ThemeImageView actionbarBack;

    @NonNull
    public final ThemeTextView actionbarTitle;

    @NonNull
    public final RelativeLayout actionbarView;

    @NonNull
    public final LinearLayout rootView;

    @NonNull
    private final ThemeRelativeLayout rootView_;

    @NonNull
    public final RecyclerView vipBenefitRecyclerView;

    @NonNull
    public final ThemeTextView vipBenefitView;

    @NonNull
    public final ThemeVipImageView vipBgView;

    @NonNull
    public final LoadingTip vipComboLoadingTip;

    @NonNull
    public final RecyclerView vipComboRecyclerView;

    @NonNull
    public final ThemeTextView vipContactCustomerService;

    @NonNull
    public final ThemeTextView vipCustomerHint;

    @NonNull
    public final CircleImageView vipHeader;

    @NonNull
    public final ThemeVipTextView vipOpenText;

    @NonNull
    public final ThemeVipRelativeLayout vipOpenTextButton;

    @NonNull
    public final ThemeVipProgressBar vipOpenTextProgressbar;

    @NonNull
    public final ThemeLinearLayout vipOpenTextView;

    @NonNull
    public final ThemeTextView vipOrderProgress;

    @NonNull
    public final ProgressBar vipOrderProgressbar;

    @NonNull
    public final ThemeTextView vipOrderRefresh;

    @NonNull
    public final ThemeLinearLayout vipOrderResult;

    @NonNull
    public final RecyclerView vipPaymentMethodRecyclerView;

    @NonNull
    public final LinearLayout vipPrivacyCheck;

    @NonNull
    public final ThemeVipImageView vipPrivacyCheckIcon;

    @NonNull
    public final ThemeTextView vipPrivacyCheckText;

    @NonNull
    public final ThemeTextView vipSubscribeDesc;

    private FragmentVipPayDialogBinding(@NonNull ThemeRelativeLayout themeRelativeLayout, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeTextView themeTextView, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeImageView themeImageView, @NonNull ThemeTextView themeTextView3, @NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout2, @NonNull RecyclerView recyclerView, @NonNull ThemeTextView themeTextView4, @NonNull ThemeVipImageView themeVipImageView, @NonNull LoadingTip loadingTip, @NonNull RecyclerView recyclerView2, @NonNull ThemeTextView themeTextView5, @NonNull ThemeTextView themeTextView6, @NonNull CircleImageView circleImageView, @NonNull ThemeVipTextView themeVipTextView, @NonNull ThemeVipRelativeLayout themeVipRelativeLayout, @NonNull ThemeVipProgressBar themeVipProgressBar, @NonNull ThemeLinearLayout themeLinearLayout2, @NonNull ThemeTextView themeTextView7, @NonNull ProgressBar progressBar, @NonNull ThemeTextView themeTextView8, @NonNull ThemeLinearLayout themeLinearLayout3, @NonNull RecyclerView recyclerView3, @NonNull LinearLayout linearLayout3, @NonNull ThemeVipImageView themeVipImageView2, @NonNull ThemeTextView themeTextView9, @NonNull ThemeTextView themeTextView10) {
        this.rootView_ = themeRelativeLayout;
        this.accountLinkAccountView = themeLinearLayout;
        this.accountVipDesc = themeTextView;
        this.accountVipStatusView = linearLayout;
        this.accountVipTag = imageView;
        this.accountVipTitle = themeTextView2;
        this.actionbarBack = themeImageView;
        this.actionbarTitle = themeTextView3;
        this.actionbarView = relativeLayout;
        this.rootView = linearLayout2;
        this.vipBenefitRecyclerView = recyclerView;
        this.vipBenefitView = themeTextView4;
        this.vipBgView = themeVipImageView;
        this.vipComboLoadingTip = loadingTip;
        this.vipComboRecyclerView = recyclerView2;
        this.vipContactCustomerService = themeTextView5;
        this.vipCustomerHint = themeTextView6;
        this.vipHeader = circleImageView;
        this.vipOpenText = themeVipTextView;
        this.vipOpenTextButton = themeVipRelativeLayout;
        this.vipOpenTextProgressbar = themeVipProgressBar;
        this.vipOpenTextView = themeLinearLayout2;
        this.vipOrderProgress = themeTextView7;
        this.vipOrderProgressbar = progressBar;
        this.vipOrderRefresh = themeTextView8;
        this.vipOrderResult = themeLinearLayout3;
        this.vipPaymentMethodRecyclerView = recyclerView3;
        this.vipPrivacyCheck = linearLayout3;
        this.vipPrivacyCheckIcon = themeVipImageView2;
        this.vipPrivacyCheckText = themeTextView9;
        this.vipSubscribeDesc = themeTextView10;
    }

    @NonNull
    public static FragmentVipPayDialogBinding bind(@NonNull View view) {
        int i10 = R.id.accountLinkAccountView;
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
        if (themeLinearLayout != null) {
            i10 = R.id.accountVipDesc;
            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView != null) {
                i10 = R.id.accountVipStatusView;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                if (linearLayout != null) {
                    i10 = R.id.accountVipTag;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                    if (imageView != null) {
                        i10 = R.id.accountVipTitle;
                        ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView2 != null) {
                            i10 = R.id.actionbar_back;
                            ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                            if (themeImageView != null) {
                                i10 = R.id.actionbar_title;
                                ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                if (themeTextView3 != null) {
                                    i10 = R.id.actionbarView;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                                    if (relativeLayout != null) {
                                        i10 = R.id.rootView;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                        if (linearLayout2 != null) {
                                            i10 = R.id.vipBenefitRecyclerView;
                                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i10);
                                            if (recyclerView != null) {
                                                i10 = R.id.vipBenefitView;
                                                ThemeTextView themeTextView4 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                if (themeTextView4 != null) {
                                                    i10 = R.id.vipBgView;
                                                    ThemeVipImageView themeVipImageView = (ThemeVipImageView) ViewBindings.findChildViewById(view, i10);
                                                    if (themeVipImageView != null) {
                                                        i10 = R.id.vipComboLoadingTip;
                                                        LoadingTip loadingTip = (LoadingTip) ViewBindings.findChildViewById(view, i10);
                                                        if (loadingTip != null) {
                                                            i10 = R.id.vipComboRecyclerView;
                                                            RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i10);
                                                            if (recyclerView2 != null) {
                                                                i10 = R.id.vipContactCustomerService;
                                                                ThemeTextView themeTextView5 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                if (themeTextView5 != null) {
                                                                    i10 = R.id.vipCustomerHint;
                                                                    ThemeTextView themeTextView6 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                    if (themeTextView6 != null) {
                                                                        i10 = R.id.vipHeader;
                                                                        CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(view, i10);
                                                                        if (circleImageView != null) {
                                                                            i10 = R.id.vipOpenText;
                                                                            ThemeVipTextView themeVipTextView = (ThemeVipTextView) ViewBindings.findChildViewById(view, i10);
                                                                            if (themeVipTextView != null) {
                                                                                i10 = R.id.vipOpenTextButton;
                                                                                ThemeVipRelativeLayout themeVipRelativeLayout = (ThemeVipRelativeLayout) ViewBindings.findChildViewById(view, i10);
                                                                                if (themeVipRelativeLayout != null) {
                                                                                    i10 = R.id.vipOpenTextProgressbar;
                                                                                    ThemeVipProgressBar themeVipProgressBar = (ThemeVipProgressBar) ViewBindings.findChildViewById(view, i10);
                                                                                    if (themeVipProgressBar != null) {
                                                                                        i10 = R.id.vipOpenTextView;
                                                                                        ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                        if (themeLinearLayout2 != null) {
                                                                                            i10 = R.id.vipOrderProgress;
                                                                                            ThemeTextView themeTextView7 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                            if (themeTextView7 != null) {
                                                                                                i10 = R.id.vipOrderProgressbar;
                                                                                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i10);
                                                                                                if (progressBar != null) {
                                                                                                    i10 = R.id.vipOrderRefresh;
                                                                                                    ThemeTextView themeTextView8 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                    if (themeTextView8 != null) {
                                                                                                        i10 = R.id.vipOrderResult;
                                                                                                        ThemeLinearLayout themeLinearLayout3 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                        if (themeLinearLayout3 != null) {
                                                                                                            i10 = R.id.vipPaymentMethodRecyclerView;
                                                                                                            RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(view, i10);
                                                                                                            if (recyclerView3 != null) {
                                                                                                                i10 = R.id.vipPrivacyCheck;
                                                                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                if (linearLayout3 != null) {
                                                                                                                    i10 = R.id.vipPrivacyCheckIcon;
                                                                                                                    ThemeVipImageView themeVipImageView2 = (ThemeVipImageView) ViewBindings.findChildViewById(view, i10);
                                                                                                                    if (themeVipImageView2 != null) {
                                                                                                                        i10 = R.id.vipPrivacyCheckText;
                                                                                                                        ThemeTextView themeTextView9 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                        if (themeTextView9 != null) {
                                                                                                                            i10 = R.id.vipSubscribeDesc;
                                                                                                                            ThemeTextView themeTextView10 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                            if (themeTextView10 != null) {
                                                                                                                                return new FragmentVipPayDialogBinding((ThemeRelativeLayout) view, themeLinearLayout, themeTextView, linearLayout, imageView, themeTextView2, themeImageView, themeTextView3, relativeLayout, linearLayout2, recyclerView, themeTextView4, themeVipImageView, loadingTip, recyclerView2, themeTextView5, themeTextView6, circleImageView, themeVipTextView, themeVipRelativeLayout, themeVipProgressBar, themeLinearLayout2, themeTextView7, progressBar, themeTextView8, themeLinearLayout3, recyclerView3, linearLayout3, themeVipImageView2, themeTextView9, themeTextView10);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static FragmentVipPayDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentVipPayDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.fragment_vip_pay_dialog, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ThemeRelativeLayout getRoot() {
        return this.rootView_;
    }
}
