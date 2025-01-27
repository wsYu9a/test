package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;
import com.martian.mibook.ui.AutoScrollView;
import com.martian.mibook.ui.FlowAdView;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class ReadingAdsItemBookPosterBinding implements ViewBinding {

    @NonNull
    public final ImageView bookAdBg;

    @NonNull
    public final ThemeTextView bookAdCardAddBookrack;

    @NonNull
    public final ReaderThemeTextView bookAdCardAuthor;

    @NonNull
    public final ImageView bookAdCardCover;

    @NonNull
    public final ReaderThemeTextView bookAdCardInfo;

    @NonNull
    public final ThemeTextView bookAdCardRead;

    @NonNull
    public final RelativeLayout bookAdCardView;

    @NonNull
    public final ReaderThemeTextView bookAdTextContent;

    @NonNull
    public final ReaderThemeTextView bookAdTextTitle;

    @NonNull
    public final AutoScrollView bookAdTextView;

    @NonNull
    public final FlowAdView misClickView;

    @NonNull
    private final LinearLayout rootView;

    private ReadingAdsItemBookPosterBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ThemeTextView themeTextView, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ImageView imageView2, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull ThemeTextView themeTextView2, @NonNull RelativeLayout relativeLayout, @NonNull ReaderThemeTextView readerThemeTextView3, @NonNull ReaderThemeTextView readerThemeTextView4, @NonNull AutoScrollView autoScrollView, @NonNull FlowAdView flowAdView) {
        this.rootView = linearLayout;
        this.bookAdBg = imageView;
        this.bookAdCardAddBookrack = themeTextView;
        this.bookAdCardAuthor = readerThemeTextView;
        this.bookAdCardCover = imageView2;
        this.bookAdCardInfo = readerThemeTextView2;
        this.bookAdCardRead = themeTextView2;
        this.bookAdCardView = relativeLayout;
        this.bookAdTextContent = readerThemeTextView3;
        this.bookAdTextTitle = readerThemeTextView4;
        this.bookAdTextView = autoScrollView;
        this.misClickView = flowAdView;
    }

    @NonNull
    public static ReadingAdsItemBookPosterBinding bind(@NonNull View view) {
        int i10 = R.id.book_ad_bg;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
        if (imageView != null) {
            i10 = R.id.book_ad_card_add_bookrack;
            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView != null) {
                i10 = R.id.book_ad_card_author;
                ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (readerThemeTextView != null) {
                    i10 = R.id.book_ad_card_cover;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                    if (imageView2 != null) {
                        i10 = R.id.book_ad_card_info;
                        ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (readerThemeTextView2 != null) {
                            i10 = R.id.book_ad_card_read;
                            ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                            if (themeTextView2 != null) {
                                i10 = R.id.book_ad_card_view;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                                if (relativeLayout != null) {
                                    i10 = R.id.book_ad_text_content;
                                    ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                    if (readerThemeTextView3 != null) {
                                        i10 = R.id.book_ad_text_title;
                                        ReaderThemeTextView readerThemeTextView4 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                        if (readerThemeTextView4 != null) {
                                            i10 = R.id.book_ad_text_view;
                                            AutoScrollView autoScrollView = (AutoScrollView) ViewBindings.findChildViewById(view, i10);
                                            if (autoScrollView != null) {
                                                i10 = R.id.mis_click_view;
                                                FlowAdView flowAdView = (FlowAdView) ViewBindings.findChildViewById(view, i10);
                                                if (flowAdView != null) {
                                                    return new ReadingAdsItemBookPosterBinding((LinearLayout) view, imageView, themeTextView, readerThemeTextView, imageView2, readerThemeTextView2, themeTextView2, relativeLayout, readerThemeTextView3, readerThemeTextView4, autoScrollView, flowAdView);
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
    public static ReadingAdsItemBookPosterBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReadingAdsItemBookPosterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reading_ads_item_book_poster, viewGroup, false);
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
