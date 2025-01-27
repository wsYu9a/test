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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.martian.libmars.widget.scroller.FastScrollRecyclerView;
import com.martian.mibook.R;
import com.martian.mibook.mvvm.read.widget.ReaderLoadingTip;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class FragmentReadingBookChapterListBinding implements ViewBinding {

    @NonNull
    public final ReaderThemeTextView dirCategory;

    @NonNull
    public final ReaderThemeImageView dirCategoryIconLeft;

    @NonNull
    public final LinearLayout dirCategoryView;

    @NonNull
    public final ReaderThemeTextView dirNumbers;

    @NonNull
    public final FloatingActionButton floatingAction;

    @NonNull
    public final LinearLayout llChapterList;

    @NonNull
    public final ReaderLoadingTip loadedTip;

    @NonNull
    private final RelativeLayout rootView;

    @NonNull
    public final FastScrollRecyclerView rvChapterList;

    private FragmentReadingBookChapterListBinding(@NonNull RelativeLayout relativeLayout, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeImageView readerThemeImageView, @NonNull LinearLayout linearLayout, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull FloatingActionButton floatingActionButton, @NonNull LinearLayout linearLayout2, @NonNull ReaderLoadingTip readerLoadingTip, @NonNull FastScrollRecyclerView fastScrollRecyclerView) {
        this.rootView = relativeLayout;
        this.dirCategory = readerThemeTextView;
        this.dirCategoryIconLeft = readerThemeImageView;
        this.dirCategoryView = linearLayout;
        this.dirNumbers = readerThemeTextView2;
        this.floatingAction = floatingActionButton;
        this.llChapterList = linearLayout2;
        this.loadedTip = readerLoadingTip;
        this.rvChapterList = fastScrollRecyclerView;
    }

    @NonNull
    public static FragmentReadingBookChapterListBinding bind(@NonNull View view) {
        int i10 = R.id.dir_category;
        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (readerThemeTextView != null) {
            i10 = R.id.dir_category_icon_left;
            ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
            if (readerThemeImageView != null) {
                i10 = R.id.dir_category_view;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                if (linearLayout != null) {
                    i10 = R.id.dir_numbers;
                    ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (readerThemeTextView2 != null) {
                        i10 = R.id.floating_action;
                        FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(view, i10);
                        if (floatingActionButton != null) {
                            i10 = R.id.ll_chapter_list;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                            if (linearLayout2 != null) {
                                i10 = R.id.loadedTip;
                                ReaderLoadingTip readerLoadingTip = (ReaderLoadingTip) ViewBindings.findChildViewById(view, i10);
                                if (readerLoadingTip != null) {
                                    i10 = R.id.rv_chapter_list;
                                    FastScrollRecyclerView fastScrollRecyclerView = (FastScrollRecyclerView) ViewBindings.findChildViewById(view, i10);
                                    if (fastScrollRecyclerView != null) {
                                        return new FragmentReadingBookChapterListBinding((RelativeLayout) view, readerThemeTextView, readerThemeImageView, linearLayout, readerThemeTextView2, floatingActionButton, linearLayout2, readerLoadingTip, fastScrollRecyclerView);
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
    public static FragmentReadingBookChapterListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentReadingBookChapterListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.fragment_reading_book_chapter_list, viewGroup, false);
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
