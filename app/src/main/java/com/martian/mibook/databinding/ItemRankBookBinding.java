package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
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
public final class ItemRankBookBinding implements ViewBinding {

    @NonNull
    public final BookCoverImageView bookCover;

    @NonNull
    public final ThemeTextView bsRankBookCategory;

    @NonNull
    public final ThemeTextView bsRankBookName;

    @NonNull
    public final TextView bsRankIndex;

    @NonNull
    public final ConstraintLayout cslBook;

    @NonNull
    public final FrameLayout flBookShadow;

    @NonNull
    private final ThemeLinearLayout rootView;

    private ItemRankBookBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull BookCoverImageView bookCoverImageView, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull TextView textView, @NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout) {
        this.rootView = themeLinearLayout;
        this.bookCover = bookCoverImageView;
        this.bsRankBookCategory = themeTextView;
        this.bsRankBookName = themeTextView2;
        this.bsRankIndex = textView;
        this.cslBook = constraintLayout;
        this.flBookShadow = frameLayout;
    }

    @NonNull
    public static ItemRankBookBinding bind(@NonNull View view) {
        int i10 = R.id.book_cover;
        BookCoverImageView bookCoverImageView = (BookCoverImageView) ViewBindings.findChildViewById(view, i10);
        if (bookCoverImageView != null) {
            i10 = R.id.bs_rank_book_category;
            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView != null) {
                i10 = R.id.bs_rank_book_name;
                ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView2 != null) {
                    i10 = R.id.bs_rank_index;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                    if (textView != null) {
                        i10 = R.id.csl_book;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i10);
                        if (constraintLayout != null) {
                            i10 = R.id.fl_book_shadow;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i10);
                            if (frameLayout != null) {
                                return new ItemRankBookBinding((ThemeLinearLayout) view, bookCoverImageView, themeTextView, themeTextView2, textView, constraintLayout, frameLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ItemRankBookBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemRankBookBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_rank_book, viewGroup, false);
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
