package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class BookCoverReadingGridItemBinding implements ViewBinding {

    @NonNull
    public final ThemeImageView bookCover;

    @NonNull
    public final ThemeLinearLayout gridItemView;

    @NonNull
    public final RelativeLayout gridViewCover;

    @NonNull
    public final ThemeTextView rdBookAuthorName;

    @NonNull
    public final ThemeTextView rdBookName;

    @NonNull
    public final TextView rdBookScore;

    @NonNull
    private final RelativeLayout rootView;

    private BookCoverReadingGridItemBinding(@NonNull RelativeLayout relativeLayout, @NonNull ThemeImageView themeImageView, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull RelativeLayout relativeLayout2, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull TextView textView) {
        this.rootView = relativeLayout;
        this.bookCover = themeImageView;
        this.gridItemView = themeLinearLayout;
        this.gridViewCover = relativeLayout2;
        this.rdBookAuthorName = themeTextView;
        this.rdBookName = themeTextView2;
        this.rdBookScore = textView;
    }

    @NonNull
    public static BookCoverReadingGridItemBinding bind(@NonNull View view) {
        int i10 = R.id.book_cover;
        ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (themeImageView != null) {
            i10 = R.id.grid_item_view;
            ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
            if (themeLinearLayout != null) {
                i10 = R.id.grid_view_cover;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                if (relativeLayout != null) {
                    i10 = R.id.rd_book_author_name;
                    ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (themeTextView != null) {
                        i10 = R.id.rd_book_name;
                        ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView2 != null) {
                            i10 = R.id.rd_book_score;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                            if (textView != null) {
                                return new BookCoverReadingGridItemBinding((RelativeLayout) view, themeImageView, themeLinearLayout, relativeLayout, themeTextView, themeTextView2, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static BookCoverReadingGridItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static BookCoverReadingGridItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.book_cover_reading_grid_item, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
