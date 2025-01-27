package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.BookCoverImageView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ItemReadingAddShelfRecommendBookGridBinding implements ViewBinding {

    @NonNull
    public final FrameLayout flBookShadow;

    @NonNull
    public final BookCoverImageView ivBookCover;

    @NonNull
    private final ThemeRelativeLayout rootView;

    @NonNull
    public final ThemeTextView tvBookName;

    @NonNull
    public final ThemeTextView tvBookTag;

    private ItemReadingAddShelfRecommendBookGridBinding(@NonNull ThemeRelativeLayout themeRelativeLayout, @NonNull FrameLayout frameLayout, @NonNull BookCoverImageView bookCoverImageView, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2) {
        this.rootView = themeRelativeLayout;
        this.flBookShadow = frameLayout;
        this.ivBookCover = bookCoverImageView;
        this.tvBookName = themeTextView;
        this.tvBookTag = themeTextView2;
    }

    @NonNull
    public static ItemReadingAddShelfRecommendBookGridBinding bind(@NonNull View view) {
        int i10 = R.id.fl_book_shadow;
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
                        return new ItemReadingAddShelfRecommendBookGridBinding((ThemeRelativeLayout) view, frameLayout, bookCoverImageView, themeTextView, themeTextView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ItemReadingAddShelfRecommendBookGridBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemReadingAddShelfRecommendBookGridBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_reading_add_shelf_recommend_book_grid, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ThemeRelativeLayout getRoot() {
        return this.rootView;
    }
}
