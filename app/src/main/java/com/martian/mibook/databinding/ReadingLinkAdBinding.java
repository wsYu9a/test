package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class ReadingLinkAdBinding implements ViewBinding {

    @NonNull
    public final ReaderThemeImageView readingAdsCloseIcon;

    @NonNull
    public final ReaderThemeImageView readingAdsCloseMore;

    @NonNull
    public final ReaderThemeTextView readingAdsCloseTitle;

    @NonNull
    public final ThemeLinearLayout readingLinkAdView;

    @NonNull
    private final ThemeLinearLayout rootView;

    private ReadingLinkAdBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull ReaderThemeImageView readerThemeImageView, @NonNull ReaderThemeImageView readerThemeImageView2, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ThemeLinearLayout themeLinearLayout2) {
        this.rootView = themeLinearLayout;
        this.readingAdsCloseIcon = readerThemeImageView;
        this.readingAdsCloseMore = readerThemeImageView2;
        this.readingAdsCloseTitle = readerThemeTextView;
        this.readingLinkAdView = themeLinearLayout2;
    }

    @NonNull
    public static ReadingLinkAdBinding bind(@NonNull View view) {
        int i10 = R.id.reading_ads_close_icon;
        ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (readerThemeImageView != null) {
            i10 = R.id.reading_ads_close_more;
            ReaderThemeImageView readerThemeImageView2 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
            if (readerThemeImageView2 != null) {
                i10 = R.id.reading_ads_close_title;
                ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (readerThemeTextView != null) {
                    ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) view;
                    return new ReadingLinkAdBinding(themeLinearLayout, readerThemeImageView, readerThemeImageView2, readerThemeTextView, themeLinearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ReadingLinkAdBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReadingLinkAdBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reading_link_ad, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ThemeLinearLayout getRoot() {
        return this.rootView;
    }
}
