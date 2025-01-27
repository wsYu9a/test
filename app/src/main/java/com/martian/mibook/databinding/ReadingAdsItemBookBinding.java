package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.mibook.R;
import com.martian.mibook.ui.AutoScrollView;
import com.martian.mibook.ui.FlowAdView;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class ReadingAdsItemBookBinding implements ViewBinding {

    @NonNull
    public final ReaderThemeTextView bookAdAddBookrack;

    @NonNull
    public final ReaderThemeTextView bookAdAuthor;

    @NonNull
    public final ReaderThemeTextView bookAdContent;

    @NonNull
    public final AutoScrollView bookAdContentView;

    @NonNull
    public final ImageView bookAdCover;

    @NonNull
    public final ReaderThemeTextView bookAdInfo;

    @NonNull
    public final ReaderThemeTextView bookAdName;

    @NonNull
    public final ReaderThemeTextView bookAdRank;

    @NonNull
    public final ReaderThemeTextView bookAdRecommend;

    @NonNull
    public final ReaderThemeTextView bookAdScore;

    @NonNull
    public final LinearLayout bookAdScoreView;

    @NonNull
    public final FlowAdView misClickView;

    @NonNull
    private final LinearLayout rootView;

    private ReadingAdsItemBookBinding(@NonNull LinearLayout linearLayout, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull ReaderThemeTextView readerThemeTextView3, @NonNull AutoScrollView autoScrollView, @NonNull ImageView imageView, @NonNull ReaderThemeTextView readerThemeTextView4, @NonNull ReaderThemeTextView readerThemeTextView5, @NonNull ReaderThemeTextView readerThemeTextView6, @NonNull ReaderThemeTextView readerThemeTextView7, @NonNull ReaderThemeTextView readerThemeTextView8, @NonNull LinearLayout linearLayout2, @NonNull FlowAdView flowAdView) {
        this.rootView = linearLayout;
        this.bookAdAddBookrack = readerThemeTextView;
        this.bookAdAuthor = readerThemeTextView2;
        this.bookAdContent = readerThemeTextView3;
        this.bookAdContentView = autoScrollView;
        this.bookAdCover = imageView;
        this.bookAdInfo = readerThemeTextView4;
        this.bookAdName = readerThemeTextView5;
        this.bookAdRank = readerThemeTextView6;
        this.bookAdRecommend = readerThemeTextView7;
        this.bookAdScore = readerThemeTextView8;
        this.bookAdScoreView = linearLayout2;
        this.misClickView = flowAdView;
    }

    @NonNull
    public static ReadingAdsItemBookBinding bind(@NonNull View view) {
        int i10 = R.id.book_ad_add_bookrack;
        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (readerThemeTextView != null) {
            i10 = R.id.book_ad_author;
            ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (readerThemeTextView2 != null) {
                i10 = R.id.book_ad_content;
                ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (readerThemeTextView3 != null) {
                    i10 = R.id.book_ad_content_view;
                    AutoScrollView autoScrollView = (AutoScrollView) ViewBindings.findChildViewById(view, i10);
                    if (autoScrollView != null) {
                        i10 = R.id.book_ad_cover;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                        if (imageView != null) {
                            i10 = R.id.book_ad_info;
                            ReaderThemeTextView readerThemeTextView4 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                            if (readerThemeTextView4 != null) {
                                i10 = R.id.book_ad_name;
                                ReaderThemeTextView readerThemeTextView5 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                if (readerThemeTextView5 != null) {
                                    i10 = R.id.book_ad_rank;
                                    ReaderThemeTextView readerThemeTextView6 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                    if (readerThemeTextView6 != null) {
                                        i10 = R.id.book_ad_recommend;
                                        ReaderThemeTextView readerThemeTextView7 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                        if (readerThemeTextView7 != null) {
                                            i10 = R.id.book_ad_score;
                                            ReaderThemeTextView readerThemeTextView8 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                            if (readerThemeTextView8 != null) {
                                                i10 = R.id.book_ad_score_view;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                if (linearLayout != null) {
                                                    i10 = R.id.mis_click_view;
                                                    FlowAdView flowAdView = (FlowAdView) ViewBindings.findChildViewById(view, i10);
                                                    if (flowAdView != null) {
                                                        return new ReadingAdsItemBookBinding((LinearLayout) view, readerThemeTextView, readerThemeTextView2, readerThemeTextView3, autoScrollView, imageView, readerThemeTextView4, readerThemeTextView5, readerThemeTextView6, readerThemeTextView7, readerThemeTextView8, linearLayout, flowAdView);
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
    public static ReadingAdsItemBookBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReadingAdsItemBookBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reading_ads_item_book, viewGroup, false);
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
