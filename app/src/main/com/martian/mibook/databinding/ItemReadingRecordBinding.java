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
public final class ItemReadingRecordBinding implements ViewBinding {

    @NonNull
    public final BookCoverImageView bookHistoryCover;

    @NonNull
    public final ImageView bpItemSelect;

    @NonNull
    public final ThemeTextView recordAddBookrack;

    @NonNull
    private final ThemeLinearLayout rootView;

    @NonNull
    public final ThemeTextView tvBookName;

    @NonNull
    public final ThemeTextView tvChapterTitle;

    @NonNull
    public final ThemeTextView tvLastReadingTime;

    @NonNull
    public final ThemeTextView tvRecordAuthor;

    @NonNull
    public final TextView tvTitleName;

    private ItemReadingRecordBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull BookCoverImageView bookCoverImageView, @NonNull ImageView imageView, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeTextView themeTextView3, @NonNull ThemeTextView themeTextView4, @NonNull ThemeTextView themeTextView5, @NonNull TextView textView) {
        this.rootView = themeLinearLayout;
        this.bookHistoryCover = bookCoverImageView;
        this.bpItemSelect = imageView;
        this.recordAddBookrack = themeTextView;
        this.tvBookName = themeTextView2;
        this.tvChapterTitle = themeTextView3;
        this.tvLastReadingTime = themeTextView4;
        this.tvRecordAuthor = themeTextView5;
        this.tvTitleName = textView;
    }

    @NonNull
    public static ItemReadingRecordBinding bind(@NonNull View view) {
        int i10 = R.id.book_history_cover;
        BookCoverImageView bookCoverImageView = (BookCoverImageView) ViewBindings.findChildViewById(view, i10);
        if (bookCoverImageView != null) {
            i10 = R.id.bp_item_select;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView != null) {
                i10 = R.id.record_add_bookrack;
                ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView != null) {
                    i10 = R.id.tv_book_name;
                    ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (themeTextView2 != null) {
                        i10 = R.id.tv_chapter_title;
                        ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView3 != null) {
                            i10 = R.id.tv_last_reading_time;
                            ThemeTextView themeTextView4 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                            if (themeTextView4 != null) {
                                i10 = R.id.tv_record_author;
                                ThemeTextView themeTextView5 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                if (themeTextView5 != null) {
                                    i10 = R.id.tv_title_name;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                                    if (textView != null) {
                                        return new ItemReadingRecordBinding((ThemeLinearLayout) view, bookCoverImageView, imageView, themeTextView, themeTextView2, themeTextView3, themeTextView4, themeTextView5, textView);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ItemReadingRecordBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemReadingRecordBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_reading_record, viewGroup, false);
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
