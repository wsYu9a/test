package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeItemTextView;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class LoadingPurchaseBinding implements ViewBinding {

    @NonNull
    public final LinearLayout accountView;

    @NonNull
    public final ThemeLinearLayout llBuyVip;

    @NonNull
    public final LinearLayout llUnlockView;

    @NonNull
    public final LinearLayout llVipView;

    @NonNull
    public final LinearLayout priceView;

    @NonNull
    private final LinearLayout rootView;

    @NonNull
    public final ReaderThemeTextView tvBuyAccountBookCoins;

    @NonNull
    public final ReaderThemeImageView tvBuyAuto;

    @NonNull
    public final LinearLayout tvBuyAutoView;

    @NonNull
    public final ReaderThemeTextView tvBuyReadingBookName;

    @NonNull
    public final ReaderThemeTextView tvBuyReadingContent;

    @NonNull
    public final ReaderThemeTextView tvBuyReadingHint;

    @NonNull
    public final ReaderThemeTextView tvBuyReadingPrice;

    @NonNull
    public final ReaderThemeItemTextView tvBuyReadingPurchase;

    @NonNull
    public final ReaderThemeItemTextView tvBuyReadingPurchaseVideo;

    @NonNull
    public final ReaderThemeTextView tvBuyReadingTitle;

    @NonNull
    public final LinearLayout tvBuyReadingTitleView;

    @NonNull
    public final ReaderThemeTextView tvBuyVipDes;

    @NonNull
    public final ReaderThemeItemTextView tvBuyVipPurchaseVideo;

    @NonNull
    public final LinearLayout tvBuyWithAd;

    @NonNull
    public final LinearLayout tvFreeReadWithAd;

    private LoadingPurchaseBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull LinearLayout linearLayout5, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeImageView readerThemeImageView, @NonNull LinearLayout linearLayout6, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull ReaderThemeTextView readerThemeTextView3, @NonNull ReaderThemeTextView readerThemeTextView4, @NonNull ReaderThemeTextView readerThemeTextView5, @NonNull ReaderThemeItemTextView readerThemeItemTextView, @NonNull ReaderThemeItemTextView readerThemeItemTextView2, @NonNull ReaderThemeTextView readerThemeTextView6, @NonNull LinearLayout linearLayout7, @NonNull ReaderThemeTextView readerThemeTextView7, @NonNull ReaderThemeItemTextView readerThemeItemTextView3, @NonNull LinearLayout linearLayout8, @NonNull LinearLayout linearLayout9) {
        this.rootView = linearLayout;
        this.accountView = linearLayout2;
        this.llBuyVip = themeLinearLayout;
        this.llUnlockView = linearLayout3;
        this.llVipView = linearLayout4;
        this.priceView = linearLayout5;
        this.tvBuyAccountBookCoins = readerThemeTextView;
        this.tvBuyAuto = readerThemeImageView;
        this.tvBuyAutoView = linearLayout6;
        this.tvBuyReadingBookName = readerThemeTextView2;
        this.tvBuyReadingContent = readerThemeTextView3;
        this.tvBuyReadingHint = readerThemeTextView4;
        this.tvBuyReadingPrice = readerThemeTextView5;
        this.tvBuyReadingPurchase = readerThemeItemTextView;
        this.tvBuyReadingPurchaseVideo = readerThemeItemTextView2;
        this.tvBuyReadingTitle = readerThemeTextView6;
        this.tvBuyReadingTitleView = linearLayout7;
        this.tvBuyVipDes = readerThemeTextView7;
        this.tvBuyVipPurchaseVideo = readerThemeItemTextView3;
        this.tvBuyWithAd = linearLayout8;
        this.tvFreeReadWithAd = linearLayout9;
    }

    @NonNull
    public static LoadingPurchaseBinding bind(@NonNull View view) {
        int i10 = R.id.account_view;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
        if (linearLayout != null) {
            i10 = R.id.ll_buy_vip;
            ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
            if (themeLinearLayout != null) {
                i10 = R.id.ll_unlock_view;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                if (linearLayout2 != null) {
                    i10 = R.id.ll_vip_view;
                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                    if (linearLayout3 != null) {
                        i10 = R.id.price_view;
                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                        if (linearLayout4 != null) {
                            i10 = R.id.tv_buy_account_book_coins;
                            ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                            if (readerThemeTextView != null) {
                                i10 = R.id.tv_buy_auto;
                                ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                                if (readerThemeImageView != null) {
                                    i10 = R.id.tv_buy_auto_view;
                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                    if (linearLayout5 != null) {
                                        i10 = R.id.tv_buy_reading_book_name;
                                        ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                        if (readerThemeTextView2 != null) {
                                            i10 = R.id.tv_buy_reading_content;
                                            ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                            if (readerThemeTextView3 != null) {
                                                i10 = R.id.tv_buy_reading_hint;
                                                ReaderThemeTextView readerThemeTextView4 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                if (readerThemeTextView4 != null) {
                                                    i10 = R.id.tv_buy_reading_price;
                                                    ReaderThemeTextView readerThemeTextView5 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                    if (readerThemeTextView5 != null) {
                                                        i10 = R.id.tv_buy_reading_purchase;
                                                        ReaderThemeItemTextView readerThemeItemTextView = (ReaderThemeItemTextView) ViewBindings.findChildViewById(view, i10);
                                                        if (readerThemeItemTextView != null) {
                                                            i10 = R.id.tv_buy_reading_purchase_video;
                                                            ReaderThemeItemTextView readerThemeItemTextView2 = (ReaderThemeItemTextView) ViewBindings.findChildViewById(view, i10);
                                                            if (readerThemeItemTextView2 != null) {
                                                                i10 = R.id.tv_buy_reading_title;
                                                                ReaderThemeTextView readerThemeTextView6 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                if (readerThemeTextView6 != null) {
                                                                    i10 = R.id.tv_buy_reading_title_view;
                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                    if (linearLayout6 != null) {
                                                                        i10 = R.id.tv_buy_vip_des;
                                                                        ReaderThemeTextView readerThemeTextView7 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                        if (readerThemeTextView7 != null) {
                                                                            i10 = R.id.tv_buy_vip_purchase_video;
                                                                            ReaderThemeItemTextView readerThemeItemTextView3 = (ReaderThemeItemTextView) ViewBindings.findChildViewById(view, i10);
                                                                            if (readerThemeItemTextView3 != null) {
                                                                                i10 = R.id.tv_buy_with_ad;
                                                                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                if (linearLayout7 != null) {
                                                                                    i10 = R.id.tv_free_read_with_ad;
                                                                                    LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                    if (linearLayout8 != null) {
                                                                                        return new LoadingPurchaseBinding((LinearLayout) view, linearLayout, themeLinearLayout, linearLayout2, linearLayout3, linearLayout4, readerThemeTextView, readerThemeImageView, linearLayout5, readerThemeTextView2, readerThemeTextView3, readerThemeTextView4, readerThemeTextView5, readerThemeItemTextView, readerThemeItemTextView2, readerThemeTextView6, linearLayout6, readerThemeTextView7, readerThemeItemTextView3, linearLayout7, linearLayout8);
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
    public static LoadingPurchaseBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static LoadingPurchaseBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.loading_purchase, viewGroup, false);
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
