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
public final class ItemBookFirendShelfBookBinding implements ViewBinding {

    @NonNull
    public final BookCoverImageView bookCover;

    @NonNull
    public final FrameLayout flBookShadow;

    @NonNull
    public final ThemeLinearLayout llAddBookshelf;

    @NonNull
    private final ThemeLinearLayout rootView;

    @NonNull
    public final ThemeTextView tvAddShelf;

    @NonNull
    public final ThemeTextView tvBookCategory;

    @NonNull
    public final TextView tvBookMark;

    @NonNull
    public final ThemeTextView tvBookName;

    @NonNull
    public final ThemeTextView tvBookShortContent;

    @NonNull
    public final TextView tvReadTime;

    private ItemBookFirendShelfBookBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull BookCoverImageView bookCoverImageView, @NonNull FrameLayout frameLayout, @NonNull ThemeLinearLayout themeLinearLayout2, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull TextView textView, @NonNull ThemeTextView themeTextView3, @NonNull ThemeTextView themeTextView4, @NonNull TextView textView2) {
        this.rootView = themeLinearLayout;
        this.bookCover = bookCoverImageView;
        this.flBookShadow = frameLayout;
        this.llAddBookshelf = themeLinearLayout2;
        this.tvAddShelf = themeTextView;
        this.tvBookCategory = themeTextView2;
        this.tvBookMark = textView;
        this.tvBookName = themeTextView3;
        this.tvBookShortContent = themeTextView4;
        this.tvReadTime = textView2;
    }

    @NonNull
    public static ItemBookFirendShelfBookBinding bind(@NonNull View view) {
        int i10 = R.id.book_cover;
        BookCoverImageView bookCoverImageView = (BookCoverImageView) ViewBindings.findChildViewById(view, i10);
        if (bookCoverImageView != null) {
            i10 = R.id.fl_book_shadow;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i10);
            if (frameLayout != null) {
                i10 = R.id.ll_add_bookshelf;
                ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                if (themeLinearLayout != null) {
                    i10 = R.id.tv_add_shelf;
                    ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (themeTextView != null) {
                        i10 = R.id.tv_book_category;
                        ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView2 != null) {
                            i10 = R.id.tv_book_mark;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                            if (textView != null) {
                                i10 = R.id.tv_book_name;
                                ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                if (themeTextView3 != null) {
                                    i10 = R.id.tv_book_short_content;
                                    ThemeTextView themeTextView4 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                    if (themeTextView4 != null) {
                                        i10 = R.id.tv_read_time;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                                        if (textView2 != null) {
                                            return new ItemBookFirendShelfBookBinding((ThemeLinearLayout) view, bookCoverImageView, frameLayout, themeLinearLayout, themeTextView, themeTextView2, textView, themeTextView3, themeTextView4, textView2);
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
    public static ItemBookFirendShelfBookBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemBookFirendShelfBookBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_book_firend_shelf_book, viewGroup, false);
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
