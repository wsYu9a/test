package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
public final class BookCoverReadingListItemBinding implements ViewBinding {

    @NonNull
    public final BookCoverImageView bookCover;

    @NonNull
    public final FrameLayout flBookShadow;

    @NonNull
    public final ThemeLinearLayout llAddBookshelf;

    @NonNull
    public final ThemeTextView rdBookAuthorName;

    @NonNull
    public final ThemeTextView rdBookName;

    @NonNull
    public final TextView rdBookScore;

    @NonNull
    public final ThemeTextView rdBookShortContent;

    @NonNull
    private final ThemeLinearLayout rootView;

    @NonNull
    public final ThemeTextView tvAddShelf;

    private BookCoverReadingListItemBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull BookCoverImageView bookCoverImageView, @NonNull FrameLayout frameLayout, @NonNull ThemeLinearLayout themeLinearLayout2, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull TextView textView, @NonNull ThemeTextView themeTextView3, @NonNull ThemeTextView themeTextView4) {
        this.rootView = themeLinearLayout;
        this.bookCover = bookCoverImageView;
        this.flBookShadow = frameLayout;
        this.llAddBookshelf = themeLinearLayout2;
        this.rdBookAuthorName = themeTextView;
        this.rdBookName = themeTextView2;
        this.rdBookScore = textView;
        this.rdBookShortContent = themeTextView3;
        this.tvAddShelf = themeTextView4;
    }

    @NonNull
    public static BookCoverReadingListItemBinding bind(@NonNull View view) {
        int i10 = R.id.book_cover;
        BookCoverImageView bookCoverImageView = (BookCoverImageView) ViewBindings.findChildViewById(view, i10);
        if (bookCoverImageView != null) {
            i10 = R.id.fl_book_shadow;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i10);
            if (frameLayout != null) {
                i10 = R.id.ll_add_bookshelf;
                ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                if (themeLinearLayout != null) {
                    i10 = R.id.rd_book_author_name;
                    ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (themeTextView != null) {
                        i10 = R.id.rd_book_name;
                        ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView2 != null) {
                            i10 = R.id.rd_book_score;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                            if (textView != null) {
                                i10 = R.id.rd_book_short_content;
                                ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                if (themeTextView3 != null) {
                                    i10 = R.id.tv_add_shelf;
                                    ThemeTextView themeTextView4 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                    if (themeTextView4 != null) {
                                        return new BookCoverReadingListItemBinding((ThemeLinearLayout) view, bookCoverImageView, frameLayout, themeLinearLayout, themeTextView, themeTextView2, textView, themeTextView3, themeTextView4);
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
    public static BookCoverReadingListItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static BookCoverReadingListItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.book_cover_reading_list_item, viewGroup, false);
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
