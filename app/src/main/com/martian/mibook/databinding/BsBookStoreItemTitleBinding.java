package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.utils.tablayout.MagicIndicator;
import com.martian.mibook.R;
import com.martian.mibook.ui.IntervalCountdownTextView;

/* loaded from: classes3.dex */
public final class BsBookStoreItemTitleBinding implements ViewBinding {

    @NonNull
    public final ThemeTextView authorBookMore;

    @NonNull
    public final ThemeImageView authorBookMoreView;

    @NonNull
    public final ProgressBar bookMoreProgressbar;

    @NonNull
    public final ThemeLinearLayout contentMore;

    @NonNull
    public final ThemeTextView contentTitle;

    @NonNull
    public final RelativeLayout contentTitleView;

    @NonNull
    private final RelativeLayout rootView;

    @NonNull
    public final MagicIndicator titleMagicIndicator;

    @NonNull
    public final ImageView tvBg;

    @NonNull
    public final ThemeImageView tvClose;

    @NonNull
    public final IntervalCountdownTextView tvTime;

    private BsBookStoreItemTitleBinding(@NonNull RelativeLayout relativeLayout, @NonNull ThemeTextView themeTextView, @NonNull ThemeImageView themeImageView, @NonNull ProgressBar progressBar, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeTextView themeTextView2, @NonNull RelativeLayout relativeLayout2, @NonNull MagicIndicator magicIndicator, @NonNull ImageView imageView, @NonNull ThemeImageView themeImageView2, @NonNull IntervalCountdownTextView intervalCountdownTextView) {
        this.rootView = relativeLayout;
        this.authorBookMore = themeTextView;
        this.authorBookMoreView = themeImageView;
        this.bookMoreProgressbar = progressBar;
        this.contentMore = themeLinearLayout;
        this.contentTitle = themeTextView2;
        this.contentTitleView = relativeLayout2;
        this.titleMagicIndicator = magicIndicator;
        this.tvBg = imageView;
        this.tvClose = themeImageView2;
        this.tvTime = intervalCountdownTextView;
    }

    @NonNull
    public static BsBookStoreItemTitleBinding bind(@NonNull View view) {
        int i10 = R.id.author_book_more;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = R.id.author_book_more_view;
            ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
            if (themeImageView != null) {
                i10 = R.id.book_more_progressbar;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i10);
                if (progressBar != null) {
                    i10 = R.id.content_more;
                    ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                    if (themeLinearLayout != null) {
                        i10 = R.id.content_title;
                        ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView2 != null) {
                            RelativeLayout relativeLayout = (RelativeLayout) view;
                            i10 = R.id.title_magic_indicator;
                            MagicIndicator magicIndicator = (MagicIndicator) ViewBindings.findChildViewById(view, i10);
                            if (magicIndicator != null) {
                                i10 = R.id.tv_bg;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                                if (imageView != null) {
                                    i10 = R.id.tv_close;
                                    ThemeImageView themeImageView2 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                    if (themeImageView2 != null) {
                                        i10 = R.id.tv_time;
                                        IntervalCountdownTextView intervalCountdownTextView = (IntervalCountdownTextView) ViewBindings.findChildViewById(view, i10);
                                        if (intervalCountdownTextView != null) {
                                            return new BsBookStoreItemTitleBinding(relativeLayout, themeTextView, themeImageView, progressBar, themeLinearLayout, themeTextView2, relativeLayout, magicIndicator, imageView, themeImageView2, intervalCountdownTextView);
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
    public static BsBookStoreItemTitleBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static BsBookStoreItemTitleBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.bs_book_store_item_title, viewGroup, false);
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
