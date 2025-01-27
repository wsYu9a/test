package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.widget.BookCoverImageView;
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class ReaderItemGridBookBinding implements ViewBinding {

    @NonNull
    public final BookCoverImageView bookCover;

    @NonNull
    public final TextView bsBookScore;

    @NonNull
    public final ReaderThemeTextView bsGridBookCategory;

    @NonNull
    public final ReaderThemeTextView bsGridBookName;

    @NonNull
    public final FrameLayout flBookShadow;

    @NonNull
    private final LinearLayout rootView;

    private ReaderItemGridBookBinding(@NonNull LinearLayout linearLayout, @NonNull BookCoverImageView bookCoverImageView, @NonNull TextView textView, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull FrameLayout frameLayout) {
        this.rootView = linearLayout;
        this.bookCover = bookCoverImageView;
        this.bsBookScore = textView;
        this.bsGridBookCategory = readerThemeTextView;
        this.bsGridBookName = readerThemeTextView2;
        this.flBookShadow = frameLayout;
    }

    @NonNull
    public static ReaderItemGridBookBinding bind(@NonNull View view) {
        int i10 = R.id.book_cover;
        BookCoverImageView bookCoverImageView = (BookCoverImageView) ViewBindings.findChildViewById(view, i10);
        if (bookCoverImageView != null) {
            i10 = R.id.bs_book_score;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
            if (textView != null) {
                i10 = R.id.bs_grid_book_category;
                ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (readerThemeTextView != null) {
                    i10 = R.id.bs_grid_book_name;
                    ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (readerThemeTextView2 != null) {
                        i10 = R.id.fl_book_shadow;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i10);
                        if (frameLayout != null) {
                            return new ReaderItemGridBookBinding((LinearLayout) view, bookCoverImageView, textView, readerThemeTextView, readerThemeTextView2, frameLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ReaderItemGridBookBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReaderItemGridBookBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reader_item_grid_book, viewGroup, false);
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
