package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.libmars.widget.scroller.FastScrollRecyclerView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class DialogBookChapterListBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout clChapterList;

    @NonNull
    public final FloatingActionButton floatingAction;

    @NonNull
    public final ThemeImageView ivClose;

    @NonNull
    public final ThemeImageView ivOrderIcon;

    @NonNull
    public final ThemeLinearLayout llOrderView;

    @NonNull
    public final LoadingTip loadedTip;

    @NonNull
    private final RoundedLayout rootView;

    @NonNull
    public final FastScrollRecyclerView rvChapterList;

    @NonNull
    public final ThemeTextView tvOrder;

    @NonNull
    public final ThemeTextView tvTitle;

    private DialogBookChapterListBinding(@NonNull RoundedLayout roundedLayout, @NonNull ConstraintLayout constraintLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull ThemeImageView themeImageView, @NonNull ThemeImageView themeImageView2, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull LoadingTip loadingTip, @NonNull FastScrollRecyclerView fastScrollRecyclerView, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2) {
        this.rootView = roundedLayout;
        this.clChapterList = constraintLayout;
        this.floatingAction = floatingActionButton;
        this.ivClose = themeImageView;
        this.ivOrderIcon = themeImageView2;
        this.llOrderView = themeLinearLayout;
        this.loadedTip = loadingTip;
        this.rvChapterList = fastScrollRecyclerView;
        this.tvOrder = themeTextView;
        this.tvTitle = themeTextView2;
    }

    @NonNull
    public static DialogBookChapterListBinding bind(@NonNull View view) {
        int i10 = R.id.cl_chapter_list;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i10);
        if (constraintLayout != null) {
            i10 = R.id.floating_action;
            FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(view, i10);
            if (floatingActionButton != null) {
                i10 = R.id.iv_close;
                ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                if (themeImageView != null) {
                    i10 = R.id.iv_order_icon;
                    ThemeImageView themeImageView2 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                    if (themeImageView2 != null) {
                        i10 = R.id.ll_order_view;
                        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                        if (themeLinearLayout != null) {
                            i10 = R.id.loadedTip;
                            LoadingTip loadingTip = (LoadingTip) ViewBindings.findChildViewById(view, i10);
                            if (loadingTip != null) {
                                i10 = R.id.rv_chapter_list;
                                FastScrollRecyclerView fastScrollRecyclerView = (FastScrollRecyclerView) ViewBindings.findChildViewById(view, i10);
                                if (fastScrollRecyclerView != null) {
                                    i10 = R.id.tv_order;
                                    ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                    if (themeTextView != null) {
                                        i10 = R.id.tv_title;
                                        ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                        if (themeTextView2 != null) {
                                            return new DialogBookChapterListBinding((RoundedLayout) view, constraintLayout, floatingActionButton, themeImageView, themeImageView2, themeLinearLayout, loadingTip, fastScrollRecyclerView, themeTextView, themeTextView2);
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
    public static DialogBookChapterListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogBookChapterListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.dialog_book_chapter_list, viewGroup, false);
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
