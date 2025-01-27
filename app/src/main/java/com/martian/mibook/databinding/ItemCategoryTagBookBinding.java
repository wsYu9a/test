package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.BookCoverImageView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ItemCategoryTagBookBinding implements ViewBinding {

    @NonNull
    public final BookCoverImageView ivBookCover;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final ThemeTextView tvBookCategory;

    @NonNull
    public final ThemeTextView tvBookName;

    @NonNull
    public final TextView tvBookScore;

    private ItemCategoryTagBookBinding(@NonNull ConstraintLayout constraintLayout, @NonNull BookCoverImageView bookCoverImageView, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull TextView textView) {
        this.rootView = constraintLayout;
        this.ivBookCover = bookCoverImageView;
        this.tvBookCategory = themeTextView;
        this.tvBookName = themeTextView2;
        this.tvBookScore = textView;
    }

    @NonNull
    public static ItemCategoryTagBookBinding bind(@NonNull View view) {
        int i10 = R.id.iv_book_cover;
        BookCoverImageView bookCoverImageView = (BookCoverImageView) ViewBindings.findChildViewById(view, i10);
        if (bookCoverImageView != null) {
            i10 = R.id.tv_book_category;
            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView != null) {
                i10 = R.id.tv_book_name;
                ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView2 != null) {
                    i10 = R.id.tv_book_score;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                    if (textView != null) {
                        return new ItemCategoryTagBookBinding((ConstraintLayout) view, bookCoverImageView, themeTextView, themeTextView2, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ItemCategoryTagBookBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemCategoryTagBookBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_category_tag_book, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
