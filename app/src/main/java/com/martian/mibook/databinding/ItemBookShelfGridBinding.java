package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
public final class ItemBookShelfGridBinding implements ViewBinding {

    @NonNull
    public final BookCoverImageView bookGridCover;

    @NonNull
    public final ThemeTextView bookShelfGridBookName;

    @NonNull
    public final TextView bookShelfGridSign;

    @NonNull
    public final TextView bookrackGridTitleName;

    @NonNull
    public final ImageView bpItemSelect;

    @NonNull
    private final ThemeLinearLayout rootView;

    @NonNull
    public final ThemeTextView tvReadingRecord;

    private ItemBookShelfGridBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull BookCoverImageView bookCoverImageView, @NonNull ThemeTextView themeTextView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView, @NonNull ThemeTextView themeTextView2) {
        this.rootView = themeLinearLayout;
        this.bookGridCover = bookCoverImageView;
        this.bookShelfGridBookName = themeTextView;
        this.bookShelfGridSign = textView;
        this.bookrackGridTitleName = textView2;
        this.bpItemSelect = imageView;
        this.tvReadingRecord = themeTextView2;
    }

    @NonNull
    public static ItemBookShelfGridBinding bind(@NonNull View view) {
        int i10 = R.id.book_grid_cover;
        BookCoverImageView bookCoverImageView = (BookCoverImageView) ViewBindings.findChildViewById(view, i10);
        if (bookCoverImageView != null) {
            i10 = R.id.book_shelf_grid_book_name;
            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView != null) {
                i10 = R.id.book_shelf_grid_sign;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                if (textView != null) {
                    i10 = R.id.bookrack_grid_title_name;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                    if (textView2 != null) {
                        i10 = R.id.bp_item_select;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                        if (imageView != null) {
                            i10 = R.id.tv_reading_record;
                            ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                            if (themeTextView2 != null) {
                                return new ItemBookShelfGridBinding((ThemeLinearLayout) view, bookCoverImageView, themeTextView, textView, textView2, imageView, themeTextView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ItemBookShelfGridBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemBookShelfGridBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_book_shelf_grid, viewGroup, false);
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
