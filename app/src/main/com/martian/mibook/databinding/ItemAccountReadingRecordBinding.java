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
public final class ItemAccountReadingRecordBinding implements ViewBinding {

    @NonNull
    public final BookCoverImageView ivBookCover;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final TextView tvAddBookShelf;

    @NonNull
    public final ThemeTextView tvBookName;

    @NonNull
    public final TextView tvTxtName;

    private ItemAccountReadingRecordBinding(@NonNull ConstraintLayout constraintLayout, @NonNull BookCoverImageView bookCoverImageView, @NonNull TextView textView, @NonNull ThemeTextView themeTextView, @NonNull TextView textView2) {
        this.rootView = constraintLayout;
        this.ivBookCover = bookCoverImageView;
        this.tvAddBookShelf = textView;
        this.tvBookName = themeTextView;
        this.tvTxtName = textView2;
    }

    @NonNull
    public static ItemAccountReadingRecordBinding bind(@NonNull View view) {
        int i10 = R.id.iv_book_cover;
        BookCoverImageView bookCoverImageView = (BookCoverImageView) ViewBindings.findChildViewById(view, i10);
        if (bookCoverImageView != null) {
            i10 = R.id.tv_add_book_shelf;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
            if (textView != null) {
                i10 = R.id.tv_book_name;
                ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView != null) {
                    i10 = R.id.tv_txt_name;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                    if (textView2 != null) {
                        return new ItemAccountReadingRecordBinding((ConstraintLayout) view, bookCoverImageView, textView, themeTextView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ItemAccountReadingRecordBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemAccountReadingRecordBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_account_reading_record, viewGroup, false);
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
