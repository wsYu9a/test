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
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class ReadingAdsItemBookLargeBinding implements ViewBinding {

    @NonNull
    public final TextView bookAdAddBookrack;

    @NonNull
    public final ReaderThemeTextView bookAdAuthor;

    @NonNull
    public final ImageView bookAdCover;

    @NonNull
    public final ReaderThemeTextView bookAdInfo;

    @NonNull
    public final ReaderThemeTextView bookAdName;

    @NonNull
    public final TextView bookAdRank;

    @NonNull
    public final TextView bookAdRecommend;

    @NonNull
    public final TextView bookAdScore;

    @NonNull
    public final LinearLayout bookAdScoreView;

    @NonNull
    private final RelativeLayout rootView;

    private ReadingAdsItemBookLargeBinding(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ImageView imageView, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull ReaderThemeTextView readerThemeTextView3, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull LinearLayout linearLayout) {
        this.rootView = relativeLayout;
        this.bookAdAddBookrack = textView;
        this.bookAdAuthor = readerThemeTextView;
        this.bookAdCover = imageView;
        this.bookAdInfo = readerThemeTextView2;
        this.bookAdName = readerThemeTextView3;
        this.bookAdRank = textView2;
        this.bookAdRecommend = textView3;
        this.bookAdScore = textView4;
        this.bookAdScoreView = linearLayout;
    }

    @NonNull
    public static ReadingAdsItemBookLargeBinding bind(@NonNull View view) {
        int i10 = R.id.book_ad_add_bookrack;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
        if (textView != null) {
            i10 = R.id.book_ad_author;
            ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (readerThemeTextView != null) {
                i10 = R.id.book_ad_cover;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                if (imageView != null) {
                    i10 = R.id.book_ad_info;
                    ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (readerThemeTextView2 != null) {
                        i10 = R.id.book_ad_name;
                        ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (readerThemeTextView3 != null) {
                            i10 = R.id.book_ad_rank;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                            if (textView2 != null) {
                                i10 = R.id.book_ad_recommend;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i10);
                                if (textView3 != null) {
                                    i10 = R.id.book_ad_score;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i10);
                                    if (textView4 != null) {
                                        i10 = R.id.book_ad_score_view;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                        if (linearLayout != null) {
                                            return new ReadingAdsItemBookLargeBinding((RelativeLayout) view, textView, readerThemeTextView, imageView, readerThemeTextView2, readerThemeTextView3, textView2, textView3, textView4, linearLayout);
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
    public static ReadingAdsItemBookLargeBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReadingAdsItemBookLargeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reading_ads_item_book_large, viewGroup, false);
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
