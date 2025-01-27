package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderThemeItemTextView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class ReadingAdsBookBinding implements ViewBinding {

    @NonNull
    public final ImageView ivBookCover;

    @NonNull
    public final ImageView ivBookCoverBg;

    @NonNull
    public final ReaderThemeItemTextView ivBookCreative;

    @NonNull
    public final ReaderThemeTextView ivBookDesc;

    @NonNull
    public final ReaderThemeTextView ivBookTitle;

    @NonNull
    private final ReaderThemeLinearLayout rootView;

    private ReadingAdsBookBinding(@NonNull ReaderThemeLinearLayout readerThemeLinearLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ReaderThemeItemTextView readerThemeItemTextView, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeTextView readerThemeTextView2) {
        this.rootView = readerThemeLinearLayout;
        this.ivBookCover = imageView;
        this.ivBookCoverBg = imageView2;
        this.ivBookCreative = readerThemeItemTextView;
        this.ivBookDesc = readerThemeTextView;
        this.ivBookTitle = readerThemeTextView2;
    }

    @NonNull
    public static ReadingAdsBookBinding bind(@NonNull View view) {
        int i10 = R.id.iv_book_cover;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
        if (imageView != null) {
            i10 = R.id.iv_book_cover_bg;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView2 != null) {
                i10 = R.id.iv_book_creative;
                ReaderThemeItemTextView readerThemeItemTextView = (ReaderThemeItemTextView) ViewBindings.findChildViewById(view, i10);
                if (readerThemeItemTextView != null) {
                    i10 = R.id.iv_book__desc;
                    ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (readerThemeTextView != null) {
                        i10 = R.id.iv_book__title;
                        ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (readerThemeTextView2 != null) {
                            return new ReadingAdsBookBinding((ReaderThemeLinearLayout) view, imageView, imageView2, readerThemeItemTextView, readerThemeTextView, readerThemeTextView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ReadingAdsBookBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReadingAdsBookBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reading_ads_book, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ReaderThemeLinearLayout getRoot() {
        return this.rootView;
    }
}
