package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.BookCoverImageView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ItemReadingAddShelfRecommendBookListBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout cslBook;

    @NonNull
    public final FrameLayout flBookShadow;

    @NonNull
    public final BookCoverImageView ivBookCover;

    @NonNull
    private final ThemeLinearLayout rootView;

    @NonNull
    public final ThemeTextView tvBookName;

    @NonNull
    public final ThemeTextView tvBookTag;

    private ItemReadingAddShelfRecommendBookListBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout, @NonNull BookCoverImageView bookCoverImageView, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2) {
        this.rootView = themeLinearLayout;
        this.cslBook = constraintLayout;
        this.flBookShadow = frameLayout;
        this.ivBookCover = bookCoverImageView;
        this.tvBookName = themeTextView;
        this.tvBookTag = themeTextView2;
    }

    @NonNull
    public static ItemReadingAddShelfRecommendBookListBinding bind(@NonNull View view) {
        int i10 = R.id.csl_book;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i10);
        if (constraintLayout != null) {
            i10 = R.id.fl_book_shadow;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i10);
            if (frameLayout != null) {
                i10 = R.id.iv_book_cover;
                BookCoverImageView bookCoverImageView = (BookCoverImageView) ViewBindings.findChildViewById(view, i10);
                if (bookCoverImageView != null) {
                    i10 = R.id.tv_book_name;
                    ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (themeTextView != null) {
                        i10 = R.id.tv_book_tag;
                        ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView2 != null) {
                            return new ItemReadingAddShelfRecommendBookListBinding((ThemeLinearLayout) view, constraintLayout, frameLayout, bookCoverImageView, themeTextView, themeTextView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ItemReadingAddShelfRecommendBookListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemReadingAddShelfRecommendBookListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_reading_add_shelf_recommend_book_list, viewGroup, false);
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
