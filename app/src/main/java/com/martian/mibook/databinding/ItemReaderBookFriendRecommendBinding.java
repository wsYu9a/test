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
import com.martian.libmars.widget.BookCoverImageView;
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class ItemReaderBookFriendRecommendBinding implements ViewBinding {

    @NonNull
    public final BookCoverImageView ivBookCover;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final TextView tvAddBookShelf;

    @NonNull
    public final ReaderThemeTextView tvBookName;

    @NonNull
    public final TextView tvReadTime;

    private ItemReaderBookFriendRecommendBinding(@NonNull ConstraintLayout constraintLayout, @NonNull BookCoverImageView bookCoverImageView, @NonNull TextView textView, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull TextView textView2) {
        this.rootView = constraintLayout;
        this.ivBookCover = bookCoverImageView;
        this.tvAddBookShelf = textView;
        this.tvBookName = readerThemeTextView;
        this.tvReadTime = textView2;
    }

    @NonNull
    public static ItemReaderBookFriendRecommendBinding bind(@NonNull View view) {
        int i10 = R.id.iv_book_cover;
        BookCoverImageView bookCoverImageView = (BookCoverImageView) ViewBindings.findChildViewById(view, i10);
        if (bookCoverImageView != null) {
            i10 = R.id.tv_add_book_shelf;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
            if (textView != null) {
                i10 = R.id.tv_book_name;
                ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (readerThemeTextView != null) {
                    i10 = R.id.tv_read_time;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                    if (textView2 != null) {
                        return new ItemReaderBookFriendRecommendBinding((ConstraintLayout) view, bookCoverImageView, textView, readerThemeTextView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ItemReaderBookFriendRecommendBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemReaderBookFriendRecommendBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_reader_book_friend_recommend, viewGroup, false);
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
