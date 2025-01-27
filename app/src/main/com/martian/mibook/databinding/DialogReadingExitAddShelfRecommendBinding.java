package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.BookCoverImageView;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.R;
import com.martian.mibook.ui.MyGridView;

/* loaded from: classes3.dex */
public final class DialogReadingExitAddShelfRecommendBinding implements ViewBinding {

    @NonNull
    public final MyGridView exitDialogBooks;

    @NonNull
    public final BookCoverImageView ivBookCover;

    @NonNull
    public final ThemeLinearLayout llExitReading;

    @NonNull
    public final RelativeLayout rlSwitchMore;

    @NonNull
    private final RoundedLayout rootView;

    @NonNull
    public final ThemeTextView tvAddShelf;

    @NonNull
    public final ThemeTextView tvBookName;

    @NonNull
    public final ThemeTextView tvSwitchMore;

    @NonNull
    public final ThemeImageView tvSwitchMoreLoan;

    @NonNull
    public final ProgressBar tvSwitchMoreProgressbar;

    @NonNull
    public final ThemeTextView tvTitle;

    private DialogReadingExitAddShelfRecommendBinding(@NonNull RoundedLayout roundedLayout, @NonNull MyGridView myGridView, @NonNull BookCoverImageView bookCoverImageView, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull RelativeLayout relativeLayout, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeTextView themeTextView3, @NonNull ThemeImageView themeImageView, @NonNull ProgressBar progressBar, @NonNull ThemeTextView themeTextView4) {
        this.rootView = roundedLayout;
        this.exitDialogBooks = myGridView;
        this.ivBookCover = bookCoverImageView;
        this.llExitReading = themeLinearLayout;
        this.rlSwitchMore = relativeLayout;
        this.tvAddShelf = themeTextView;
        this.tvBookName = themeTextView2;
        this.tvSwitchMore = themeTextView3;
        this.tvSwitchMoreLoan = themeImageView;
        this.tvSwitchMoreProgressbar = progressBar;
        this.tvTitle = themeTextView4;
    }

    @NonNull
    public static DialogReadingExitAddShelfRecommendBinding bind(@NonNull View view) {
        int i10 = R.id.exit_dialog_books;
        MyGridView myGridView = (MyGridView) ViewBindings.findChildViewById(view, i10);
        if (myGridView != null) {
            i10 = R.id.iv_book_cover;
            BookCoverImageView bookCoverImageView = (BookCoverImageView) ViewBindings.findChildViewById(view, i10);
            if (bookCoverImageView != null) {
                i10 = R.id.ll_exit_reading;
                ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                if (themeLinearLayout != null) {
                    i10 = R.id.rl_switch_more;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                    if (relativeLayout != null) {
                        i10 = R.id.tv_add_shelf;
                        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView != null) {
                            i10 = R.id.tv_book_name;
                            ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                            if (themeTextView2 != null) {
                                i10 = R.id.tv_switch_more;
                                ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                if (themeTextView3 != null) {
                                    i10 = R.id.tv_switch_more_loan;
                                    ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                    if (themeImageView != null) {
                                        i10 = R.id.tv_switch_more_progressbar;
                                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i10);
                                        if (progressBar != null) {
                                            i10 = R.id.tv_title;
                                            ThemeTextView themeTextView4 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                            if (themeTextView4 != null) {
                                                return new DialogReadingExitAddShelfRecommendBinding((RoundedLayout) view, myGridView, bookCoverImageView, themeLinearLayout, relativeLayout, themeTextView, themeTextView2, themeTextView3, themeImageView, progressBar, themeTextView4);
                                            }
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
    public static DialogReadingExitAddShelfRecommendBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogReadingExitAddShelfRecommendBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.dialog_reading_exit_add_shelf_recommend, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public RoundedLayout getRoot() {
        return this.rootView;
    }
}
