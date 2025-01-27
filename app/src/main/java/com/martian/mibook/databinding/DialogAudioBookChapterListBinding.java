package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.BookCoverImageView;
import com.martian.libmars.widget.DownLoadButton;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.libmars.widget.scroller.FastScrollRecyclerView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class DialogAudioBookChapterListBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout clChapterList;

    @NonNull
    public final ThemeTextView dirCategory;

    @NonNull
    public final ThemeImageView dirCategoryIconLeft;

    @NonNull
    public final LinearLayout dirCategoryView;

    @NonNull
    public final ThemeTextView dirNumbers;

    @NonNull
    public final DownLoadButton downloadBtn;

    @NonNull
    public final FloatingActionButton floatingAction;

    @NonNull
    public final BookCoverImageView ivBookCover;

    @NonNull
    public final ThemeImageView ivRight;

    @NonNull
    public final LoadingTip loadedTip;

    @NonNull
    public final RelativeLayout rlDownload;

    @NonNull
    private final ThemeLinearLayout rootView;

    @NonNull
    public final FastScrollRecyclerView rvChapterList;

    @NonNull
    public final ThemeTextView tvBookDes;

    @NonNull
    public final ThemeTextView tvBookName;

    private DialogAudioBookChapterListBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull ConstraintLayout constraintLayout, @NonNull ThemeTextView themeTextView, @NonNull ThemeImageView themeImageView, @NonNull LinearLayout linearLayout, @NonNull ThemeTextView themeTextView2, @NonNull DownLoadButton downLoadButton, @NonNull FloatingActionButton floatingActionButton, @NonNull BookCoverImageView bookCoverImageView, @NonNull ThemeImageView themeImageView2, @NonNull LoadingTip loadingTip, @NonNull RelativeLayout relativeLayout, @NonNull FastScrollRecyclerView fastScrollRecyclerView, @NonNull ThemeTextView themeTextView3, @NonNull ThemeTextView themeTextView4) {
        this.rootView = themeLinearLayout;
        this.clChapterList = constraintLayout;
        this.dirCategory = themeTextView;
        this.dirCategoryIconLeft = themeImageView;
        this.dirCategoryView = linearLayout;
        this.dirNumbers = themeTextView2;
        this.downloadBtn = downLoadButton;
        this.floatingAction = floatingActionButton;
        this.ivBookCover = bookCoverImageView;
        this.ivRight = themeImageView2;
        this.loadedTip = loadingTip;
        this.rlDownload = relativeLayout;
        this.rvChapterList = fastScrollRecyclerView;
        this.tvBookDes = themeTextView3;
        this.tvBookName = themeTextView4;
    }

    @NonNull
    public static DialogAudioBookChapterListBinding bind(@NonNull View view) {
        int i10 = R.id.cl_chapter_list;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i10);
        if (constraintLayout != null) {
            i10 = R.id.dir_category;
            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView != null) {
                i10 = R.id.dir_category_icon_left;
                ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                if (themeImageView != null) {
                    i10 = R.id.dir_category_view;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                    if (linearLayout != null) {
                        i10 = R.id.dir_numbers;
                        ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView2 != null) {
                            i10 = R.id.download_btn;
                            DownLoadButton downLoadButton = (DownLoadButton) ViewBindings.findChildViewById(view, i10);
                            if (downLoadButton != null) {
                                i10 = R.id.floating_action;
                                FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(view, i10);
                                if (floatingActionButton != null) {
                                    i10 = R.id.iv_book_cover;
                                    BookCoverImageView bookCoverImageView = (BookCoverImageView) ViewBindings.findChildViewById(view, i10);
                                    if (bookCoverImageView != null) {
                                        i10 = R.id.iv_right;
                                        ThemeImageView themeImageView2 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                        if (themeImageView2 != null) {
                                            i10 = R.id.loadedTip;
                                            LoadingTip loadingTip = (LoadingTip) ViewBindings.findChildViewById(view, i10);
                                            if (loadingTip != null) {
                                                i10 = R.id.rl_download;
                                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                                                if (relativeLayout != null) {
                                                    i10 = R.id.rv_chapter_list;
                                                    FastScrollRecyclerView fastScrollRecyclerView = (FastScrollRecyclerView) ViewBindings.findChildViewById(view, i10);
                                                    if (fastScrollRecyclerView != null) {
                                                        i10 = R.id.tv_book_des;
                                                        ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                        if (themeTextView3 != null) {
                                                            i10 = R.id.tv_book_name;
                                                            ThemeTextView themeTextView4 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                            if (themeTextView4 != null) {
                                                                return new DialogAudioBookChapterListBinding((ThemeLinearLayout) view, constraintLayout, themeTextView, themeImageView, linearLayout, themeTextView2, downLoadButton, floatingActionButton, bookCoverImageView, themeImageView2, loadingTip, relativeLayout, fastScrollRecyclerView, themeTextView3, themeTextView4);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static DialogAudioBookChapterListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogAudioBookChapterListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.dialog_audio_book_chapter_list, viewGroup, false);
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
