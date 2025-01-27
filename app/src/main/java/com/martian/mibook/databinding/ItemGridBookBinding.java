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
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.BookCoverImageView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ItemGridBookBinding implements ViewBinding {

    @NonNull
    public final BookCoverImageView bookCover;

    @NonNull
    public final TextView bsBookScore;

    @NonNull
    public final ThemeTextView bsGridBookCategory;

    @NonNull
    public final ThemeTextView bsGridBookName;

    @NonNull
    public final FrameLayout flBookShadow;

    @NonNull
    private final LinearLayout rootView;

    private ItemGridBookBinding(@NonNull LinearLayout linearLayout, @NonNull BookCoverImageView bookCoverImageView, @NonNull TextView textView, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull FrameLayout frameLayout) {
        this.rootView = linearLayout;
        this.bookCover = bookCoverImageView;
        this.bsBookScore = textView;
        this.bsGridBookCategory = themeTextView;
        this.bsGridBookName = themeTextView2;
        this.flBookShadow = frameLayout;
    }

    @NonNull
    public static ItemGridBookBinding bind(@NonNull View view) {
        int i10 = R.id.book_cover;
        BookCoverImageView bookCoverImageView = (BookCoverImageView) ViewBindings.findChildViewById(view, i10);
        if (bookCoverImageView != null) {
            i10 = R.id.bs_book_score;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
            if (textView != null) {
                i10 = R.id.bs_grid_book_category;
                ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView != null) {
                    i10 = R.id.bs_grid_book_name;
                    ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (themeTextView2 != null) {
                        i10 = R.id.fl_book_shadow;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i10);
                        if (frameLayout != null) {
                            return new ItemGridBookBinding((LinearLayout) view, bookCoverImageView, textView, themeTextView, themeTextView2, frameLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ItemGridBookBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemGridBookBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_grid_book, viewGroup, false);
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
