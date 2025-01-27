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
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class DialogReadingBookIntroductionBinding implements ViewBinding {

    @NonNull
    public final ThemeImageView ivBottomLine;

    @NonNull
    public final ReaderThemeImageView ivClose;

    @NonNull
    public final ThemeImageView ivTopLine;

    @NonNull
    public final ReaderThemeLinearLayout rlContent;

    @NonNull
    public final RelativeLayout rlTopView;

    @NonNull
    private final RelativeLayout rootView;

    @NonNull
    public final ReaderThemeTextView tvExit;

    @NonNull
    public final ReaderThemeTextView tvIntroduction;

    @NonNull
    public final ReaderThemeTextView tvTitle;

    private DialogReadingBookIntroductionBinding(@NonNull RelativeLayout relativeLayout, @NonNull ThemeImageView themeImageView, @NonNull ReaderThemeImageView readerThemeImageView, @NonNull ThemeImageView themeImageView2, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout, @NonNull RelativeLayout relativeLayout2, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull ReaderThemeTextView readerThemeTextView3) {
        this.rootView = relativeLayout;
        this.ivBottomLine = themeImageView;
        this.ivClose = readerThemeImageView;
        this.ivTopLine = themeImageView2;
        this.rlContent = readerThemeLinearLayout;
        this.rlTopView = relativeLayout2;
        this.tvExit = readerThemeTextView;
        this.tvIntroduction = readerThemeTextView2;
        this.tvTitle = readerThemeTextView3;
    }

    @NonNull
    public static DialogReadingBookIntroductionBinding bind(@NonNull View view) {
        int i10 = R.id.iv_bottom_line;
        ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (themeImageView != null) {
            i10 = R.id.iv_close;
            ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
            if (readerThemeImageView != null) {
                i10 = R.id.iv_top_line;
                ThemeImageView themeImageView2 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                if (themeImageView2 != null) {
                    i10 = R.id.rl_content;
                    ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                    if (readerThemeLinearLayout != null) {
                        i10 = R.id.rl_top_view;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                        if (relativeLayout != null) {
                            i10 = R.id.tv_exit;
                            ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                            if (readerThemeTextView != null) {
                                i10 = R.id.tv_introduction;
                                ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                if (readerThemeTextView2 != null) {
                                    i10 = R.id.tv_title;
                                    ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                    if (readerThemeTextView3 != null) {
                                        return new DialogReadingBookIntroductionBinding((RelativeLayout) view, themeImageView, readerThemeImageView, themeImageView2, readerThemeLinearLayout, relativeLayout, readerThemeTextView, readerThemeTextView2, readerThemeTextView3);
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
    public static DialogReadingBookIntroductionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogReadingBookIntroductionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.dialog_reading_book_introduction, viewGroup, false);
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
