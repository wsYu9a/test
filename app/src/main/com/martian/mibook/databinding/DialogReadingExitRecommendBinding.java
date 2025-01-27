package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class DialogReadingExitRecommendBinding implements ViewBinding {

    @NonNull
    public final ThemeImageView ivClose;

    @NonNull
    public final ThemeLinearLayout llExitReading;

    @NonNull
    private final RoundedLayout rootView;

    @NonNull
    public final RecyclerView rvBooks;

    @NonNull
    public final ThemeTextView tvReadContinue;

    @NonNull
    public final ThemeTextView tvSwitchMoreBook;

    @NonNull
    public final ThemeTextView tvTitle;

    private DialogReadingExitRecommendBinding(@NonNull RoundedLayout roundedLayout, @NonNull ThemeImageView themeImageView, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull RecyclerView recyclerView, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeTextView themeTextView3) {
        this.rootView = roundedLayout;
        this.ivClose = themeImageView;
        this.llExitReading = themeLinearLayout;
        this.rvBooks = recyclerView;
        this.tvReadContinue = themeTextView;
        this.tvSwitchMoreBook = themeTextView2;
        this.tvTitle = themeTextView3;
    }

    @NonNull
    public static DialogReadingExitRecommendBinding bind(@NonNull View view) {
        int i10 = R.id.iv_close;
        ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (themeImageView != null) {
            i10 = R.id.ll_exit_reading;
            ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
            if (themeLinearLayout != null) {
                i10 = R.id.rv_books;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i10);
                if (recyclerView != null) {
                    i10 = R.id.tv_read_continue;
                    ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (themeTextView != null) {
                        i10 = R.id.tv_switch_more_book;
                        ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView2 != null) {
                            i10 = R.id.tv_title;
                            ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                            if (themeTextView3 != null) {
                                return new DialogReadingExitRecommendBinding((RoundedLayout) view, themeImageView, themeLinearLayout, recyclerView, themeTextView, themeTextView2, themeTextView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static DialogReadingExitRecommendBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogReadingExitRecommendBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.dialog_reading_exit_recommend, viewGroup, false);
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
