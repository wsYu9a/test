package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.BookCoverImageView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ItemBookShelfListAdBinding implements ViewBinding {

    @NonNull
    public final FrameLayout adsContainer;

    @NonNull
    public final LinearLayout brCloseAdsIcon;

    @NonNull
    public final ImageView ivAdsLogo;

    @NonNull
    public final BookCoverImageView ivAppIcon;

    @NonNull
    public final RelativeLayout ivAppIconView;

    @NonNull
    public final FrameLayout ivVideoView;

    @NonNull
    public final View listAdsShade;

    @NonNull
    public final RelativeLayout listAdsView;

    @NonNull
    public final ThemeLinearLayout llAdContainer;

    @NonNull
    public final ThemeLinearLayout llAdView;

    @NonNull
    private final FrameLayout rootView;

    @NonNull
    public final TextView tvAdsLogoDesc;

    @NonNull
    public final ThemeTextView tvAppDesc;

    @NonNull
    public final ThemeTextView tvAppTitle;

    private ItemBookShelfListAdBinding(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull BookCoverImageView bookCoverImageView, @NonNull RelativeLayout relativeLayout, @NonNull FrameLayout frameLayout3, @NonNull View view, @NonNull RelativeLayout relativeLayout2, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeLinearLayout themeLinearLayout2, @NonNull TextView textView, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2) {
        this.rootView = frameLayout;
        this.adsContainer = frameLayout2;
        this.brCloseAdsIcon = linearLayout;
        this.ivAdsLogo = imageView;
        this.ivAppIcon = bookCoverImageView;
        this.ivAppIconView = relativeLayout;
        this.ivVideoView = frameLayout3;
        this.listAdsShade = view;
        this.listAdsView = relativeLayout2;
        this.llAdContainer = themeLinearLayout;
        this.llAdView = themeLinearLayout2;
        this.tvAdsLogoDesc = textView;
        this.tvAppDesc = themeTextView;
        this.tvAppTitle = themeTextView2;
    }

    @NonNull
    public static ItemBookShelfListAdBinding bind(@NonNull View view) {
        View findChildViewById;
        FrameLayout frameLayout = (FrameLayout) view;
        int i10 = R.id.br_close_ads_icon;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
        if (linearLayout != null) {
            i10 = R.id.iv_ads_logo;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView != null) {
                i10 = R.id.iv_app_icon;
                BookCoverImageView bookCoverImageView = (BookCoverImageView) ViewBindings.findChildViewById(view, i10);
                if (bookCoverImageView != null) {
                    i10 = R.id.iv_app_icon_view;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                    if (relativeLayout != null) {
                        i10 = R.id.iv_video_view;
                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i10);
                        if (frameLayout2 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i10 = R.id.list_ads_shade))) != null) {
                            i10 = R.id.list_ads_view;
                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                            if (relativeLayout2 != null) {
                                i10 = R.id.ll_ad_container;
                                ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                if (themeLinearLayout != null) {
                                    i10 = R.id.ll_ad_view;
                                    ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                    if (themeLinearLayout2 != null) {
                                        i10 = R.id.tv_ads_logo_desc;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                                        if (textView != null) {
                                            i10 = R.id.tv_app_desc;
                                            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                            if (themeTextView != null) {
                                                i10 = R.id.tv_app_title;
                                                ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                if (themeTextView2 != null) {
                                                    return new ItemBookShelfListAdBinding(frameLayout, frameLayout, linearLayout, imageView, bookCoverImageView, relativeLayout, frameLayout2, findChildViewById, relativeLayout2, themeLinearLayout, themeLinearLayout2, textView, themeTextView, themeTextView2);
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
    public static ItemBookShelfListAdBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemBookShelfListAdBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_book_shelf_list_ad, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
