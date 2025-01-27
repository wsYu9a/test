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
public final class ItemListBookMallBinding implements ViewBinding {

    @NonNull
    public final BookCoverImageView bookCover;

    @NonNull
    public final FrameLayout flBookShadow;

    @NonNull
    private final ThemeLinearLayout rootView;

    @NonNull
    public final ThemeTextView tvBookAuthorName;

    @NonNull
    public final ThemeTextView tvBookName;

    @NonNull
    public final TextView tvBookScore;

    @NonNull
    public final ThemeTextView tvBookShortContent;

    private ItemListBookMallBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull BookCoverImageView bookCoverImageView, @NonNull FrameLayout frameLayout, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull TextView textView, @NonNull ThemeTextView themeTextView3) {
        this.rootView = themeLinearLayout;
        this.bookCover = bookCoverImageView;
        this.flBookShadow = frameLayout;
        this.tvBookAuthorName = themeTextView;
        this.tvBookName = themeTextView2;
        this.tvBookScore = textView;
        this.tvBookShortContent = themeTextView3;
    }

    @NonNull
    public static ItemListBookMallBinding bind(@NonNull View view) {
        int i10 = R.id.book_cover;
        BookCoverImageView bookCoverImageView = (BookCoverImageView) ViewBindings.findChildViewById(view, i10);
        if (bookCoverImageView != null) {
            i10 = R.id.fl_book_shadow;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i10);
            if (frameLayout != null) {
                i10 = R.id.tv_book_author_name;
                ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView != null) {
                    i10 = R.id.tv_book_name;
                    ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (themeTextView2 != null) {
                        i10 = R.id.tv_book_score;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                        if (textView != null) {
                            i10 = R.id.tv_book_short_content;
                            ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                            if (themeTextView3 != null) {
                                return new ItemListBookMallBinding((ThemeLinearLayout) view, bookCoverImageView, frameLayout, themeTextView, themeTextView2, textView, themeTextView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ItemListBookMallBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemListBookMallBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_list_book_mall, viewGroup, false);
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
