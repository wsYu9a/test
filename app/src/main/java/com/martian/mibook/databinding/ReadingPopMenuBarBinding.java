package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class ReadingPopMenuBarBinding implements ViewBinding {

    @NonNull
    public final ThemeImageView bookCommentViewDivider;

    @NonNull
    public final ReaderThemeLinearLayout llAddBookmark;

    @NonNull
    public final ReaderThemeLinearLayout llBookComment;

    @NonNull
    public final ReaderThemeLinearLayout llBookDetail;

    @NonNull
    public final ThemeImageView llBookDetailDivider;

    @NonNull
    public final ReaderThemeLinearLayout llBookReport;

    @NonNull
    public final LinearLayout menuTopView;

    @NonNull
    private final RelativeLayout rootView;

    @NonNull
    public final ReaderThemeTextView rtvBookMark;

    private ReadingPopMenuBarBinding(@NonNull RelativeLayout relativeLayout, @NonNull ThemeImageView themeImageView, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout2, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout3, @NonNull ThemeImageView themeImageView2, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout4, @NonNull LinearLayout linearLayout, @NonNull ReaderThemeTextView readerThemeTextView) {
        this.rootView = relativeLayout;
        this.bookCommentViewDivider = themeImageView;
        this.llAddBookmark = readerThemeLinearLayout;
        this.llBookComment = readerThemeLinearLayout2;
        this.llBookDetail = readerThemeLinearLayout3;
        this.llBookDetailDivider = themeImageView2;
        this.llBookReport = readerThemeLinearLayout4;
        this.menuTopView = linearLayout;
        this.rtvBookMark = readerThemeTextView;
    }

    @NonNull
    public static ReadingPopMenuBarBinding bind(@NonNull View view) {
        int i10 = R.id.book_comment_view_divider;
        ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (themeImageView != null) {
            i10 = R.id.ll_add_bookmark;
            ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
            if (readerThemeLinearLayout != null) {
                i10 = R.id.ll_book_comment;
                ReaderThemeLinearLayout readerThemeLinearLayout2 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                if (readerThemeLinearLayout2 != null) {
                    i10 = R.id.ll_book_detail;
                    ReaderThemeLinearLayout readerThemeLinearLayout3 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                    if (readerThemeLinearLayout3 != null) {
                        i10 = R.id.ll_book_detail_divider;
                        ThemeImageView themeImageView2 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                        if (themeImageView2 != null) {
                            i10 = R.id.ll_book_report;
                            ReaderThemeLinearLayout readerThemeLinearLayout4 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                            if (readerThemeLinearLayout4 != null) {
                                i10 = R.id.menu_top_view;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                if (linearLayout != null) {
                                    i10 = R.id.rtv_book_mark;
                                    ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                    if (readerThemeTextView != null) {
                                        return new ReadingPopMenuBarBinding((RelativeLayout) view, themeImageView, readerThemeLinearLayout, readerThemeLinearLayout2, readerThemeLinearLayout3, themeImageView2, readerThemeLinearLayout4, linearLayout, readerThemeTextView);
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
    public static ReadingPopMenuBarBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReadingPopMenuBarBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reading_pop_menu_bar, viewGroup, false);
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
