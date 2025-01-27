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
public final class ItemBookMallTypeReadingRecordBinding implements ViewBinding {

    @NonNull
    public final BookCoverImageView ivAudioBookCover;

    @NonNull
    public final ImageView ivAudioPlay;

    @NonNull
    public final BookCoverImageView ivBookCover;

    @NonNull
    public final ThemeLinearLayout llReadingRecord;

    @NonNull
    public final ThemeTextView recordReading;

    @NonNull
    private final ThemeLinearLayout rootView;

    @NonNull
    public final ThemeTextView tvBookName;

    @NonNull
    public final ThemeTextView tvContent;

    @NonNull
    public final ThemeTextView tvReadingRecordTips;

    @NonNull
    public final TextView tvUpdateSign;

    private ItemBookMallTypeReadingRecordBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull BookCoverImageView bookCoverImageView, @NonNull ImageView imageView, @NonNull BookCoverImageView bookCoverImageView2, @NonNull ThemeLinearLayout themeLinearLayout2, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeTextView themeTextView3, @NonNull ThemeTextView themeTextView4, @NonNull TextView textView) {
        this.rootView = themeLinearLayout;
        this.ivAudioBookCover = bookCoverImageView;
        this.ivAudioPlay = imageView;
        this.ivBookCover = bookCoverImageView2;
        this.llReadingRecord = themeLinearLayout2;
        this.recordReading = themeTextView;
        this.tvBookName = themeTextView2;
        this.tvContent = themeTextView3;
        this.tvReadingRecordTips = themeTextView4;
        this.tvUpdateSign = textView;
    }

    @NonNull
    public static ItemBookMallTypeReadingRecordBinding bind(@NonNull View view) {
        int i10 = R.id.iv_audio_book_cover;
        BookCoverImageView bookCoverImageView = (BookCoverImageView) ViewBindings.findChildViewById(view, i10);
        if (bookCoverImageView != null) {
            i10 = R.id.iv_audio_play;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView != null) {
                i10 = R.id.iv_book_cover;
                BookCoverImageView bookCoverImageView2 = (BookCoverImageView) ViewBindings.findChildViewById(view, i10);
                if (bookCoverImageView2 != null) {
                    i10 = R.id.ll_reading_record;
                    ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                    if (themeLinearLayout != null) {
                        i10 = R.id.record_reading;
                        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView != null) {
                            i10 = R.id.tv_book_name;
                            ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                            if (themeTextView2 != null) {
                                i10 = R.id.tv_content;
                                ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                if (themeTextView3 != null) {
                                    i10 = R.id.tv_reading_record_tips;
                                    ThemeTextView themeTextView4 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                    if (themeTextView4 != null) {
                                        i10 = R.id.tv_update_sign;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                                        if (textView != null) {
                                            return new ItemBookMallTypeReadingRecordBinding((ThemeLinearLayout) view, bookCoverImageView, imageView, bookCoverImageView2, themeLinearLayout, themeTextView, themeTextView2, themeTextView3, themeTextView4, textView);
                                        }
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
    public static ItemBookMallTypeReadingRecordBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemBookMallTypeReadingRecordBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_book_mall_type_reading_record, viewGroup, false);
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
