package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.BookCoverImageView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class LayoutReadingRecordBinding implements ViewBinding {

    @NonNull
    public final BookCoverImageView audioBookCover;

    @NonNull
    public final ThemeImageView readBookCover;

    @NonNull
    public final ThemeTextView recordBookname;

    @NonNull
    public final ThemeImageView recordIconClose;

    @NonNull
    public final ThemeTextView recordReading;

    @NonNull
    public final ThemeTextView recordStatus;

    @NonNull
    public final RelativeLayout recordView;

    @NonNull
    public final RelativeLayout rlAudioBook;

    @NonNull
    public final RelativeLayout rlReadBook;

    @NonNull
    private final RelativeLayout rootView;

    private LayoutReadingRecordBinding(@NonNull RelativeLayout relativeLayout, @NonNull BookCoverImageView bookCoverImageView, @NonNull ThemeImageView themeImageView, @NonNull ThemeTextView themeTextView, @NonNull ThemeImageView themeImageView2, @NonNull ThemeTextView themeTextView2, @NonNull ThemeTextView themeTextView3, @NonNull RelativeLayout relativeLayout2, @NonNull RelativeLayout relativeLayout3, @NonNull RelativeLayout relativeLayout4) {
        this.rootView = relativeLayout;
        this.audioBookCover = bookCoverImageView;
        this.readBookCover = themeImageView;
        this.recordBookname = themeTextView;
        this.recordIconClose = themeImageView2;
        this.recordReading = themeTextView2;
        this.recordStatus = themeTextView3;
        this.recordView = relativeLayout2;
        this.rlAudioBook = relativeLayout3;
        this.rlReadBook = relativeLayout4;
    }

    @NonNull
    public static LayoutReadingRecordBinding bind(@NonNull View view) {
        int i10 = R.id.audio_book_cover;
        BookCoverImageView bookCoverImageView = (BookCoverImageView) ViewBindings.findChildViewById(view, i10);
        if (bookCoverImageView != null) {
            i10 = R.id.read_book_cover;
            ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
            if (themeImageView != null) {
                i10 = R.id.record_bookname;
                ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView != null) {
                    i10 = R.id.record_icon_close;
                    ThemeImageView themeImageView2 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                    if (themeImageView2 != null) {
                        i10 = R.id.record_reading;
                        ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView2 != null) {
                            i10 = R.id.record_status;
                            ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                            if (themeTextView3 != null) {
                                RelativeLayout relativeLayout = (RelativeLayout) view;
                                i10 = R.id.rl_audio_book;
                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                                if (relativeLayout2 != null) {
                                    i10 = R.id.rl_read_book;
                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                                    if (relativeLayout3 != null) {
                                        return new LayoutReadingRecordBinding(relativeLayout, bookCoverImageView, themeImageView, themeTextView, themeImageView2, themeTextView2, themeTextView3, relativeLayout, relativeLayout2, relativeLayout3);
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
    public static LayoutReadingRecordBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static LayoutReadingRecordBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.layout_reading_record, viewGroup, false);
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
