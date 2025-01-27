package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ItemBookMallTypeTabBinding implements ViewBinding {

    @NonNull
    public final ImageView ivTabBookComplete;

    @NonNull
    public final ImageView ivTabCategory;

    @NonNull
    public final ImageView ivTabList;

    @NonNull
    public final ImageView ivTabNewBook;

    @NonNull
    public final ThemeLinearLayout rlTabBookComplete;

    @NonNull
    public final ThemeLinearLayout rlTabCategory;

    @NonNull
    public final ThemeLinearLayout rlTabList;

    @NonNull
    public final ThemeLinearLayout rlTabNewBook;

    @NonNull
    private final LinearLayout rootView;

    @NonNull
    public final ThemeTextView tvTabBookComplete;

    @NonNull
    public final ThemeTextView tvTabCategory;

    @NonNull
    public final ThemeTextView tvTabList;

    @NonNull
    public final ThemeTextView tvTabNewBook;

    private ItemBookMallTypeTabBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeLinearLayout themeLinearLayout2, @NonNull ThemeLinearLayout themeLinearLayout3, @NonNull ThemeLinearLayout themeLinearLayout4, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeTextView themeTextView3, @NonNull ThemeTextView themeTextView4) {
        this.rootView = linearLayout;
        this.ivTabBookComplete = imageView;
        this.ivTabCategory = imageView2;
        this.ivTabList = imageView3;
        this.ivTabNewBook = imageView4;
        this.rlTabBookComplete = themeLinearLayout;
        this.rlTabCategory = themeLinearLayout2;
        this.rlTabList = themeLinearLayout3;
        this.rlTabNewBook = themeLinearLayout4;
        this.tvTabBookComplete = themeTextView;
        this.tvTabCategory = themeTextView2;
        this.tvTabList = themeTextView3;
        this.tvTabNewBook = themeTextView4;
    }

    @NonNull
    public static ItemBookMallTypeTabBinding bind(@NonNull View view) {
        int i10 = R.id.iv_tab_book_complete;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
        if (imageView != null) {
            i10 = R.id.iv_tab_category;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView2 != null) {
                i10 = R.id.iv_tab_list;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i10);
                if (imageView3 != null) {
                    i10 = R.id.iv_tab_new_book;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i10);
                    if (imageView4 != null) {
                        i10 = R.id.rl_tab_book_complete;
                        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                        if (themeLinearLayout != null) {
                            i10 = R.id.rl_tab_category;
                            ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                            if (themeLinearLayout2 != null) {
                                i10 = R.id.rl_tab_list;
                                ThemeLinearLayout themeLinearLayout3 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                if (themeLinearLayout3 != null) {
                                    i10 = R.id.rl_tab_new_book;
                                    ThemeLinearLayout themeLinearLayout4 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                    if (themeLinearLayout4 != null) {
                                        i10 = R.id.tv_tab_book_complete;
                                        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                        if (themeTextView != null) {
                                            i10 = R.id.tv_tab_category;
                                            ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                            if (themeTextView2 != null) {
                                                i10 = R.id.tv_tab_list;
                                                ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                if (themeTextView3 != null) {
                                                    i10 = R.id.tv_tab_new_book;
                                                    ThemeTextView themeTextView4 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                    if (themeTextView4 != null) {
                                                        return new ItemBookMallTypeTabBinding((LinearLayout) view, imageView, imageView2, imageView3, imageView4, themeLinearLayout, themeLinearLayout2, themeLinearLayout3, themeLinearLayout4, themeTextView, themeTextView2, themeTextView3, themeTextView4);
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
    public static ItemBookMallTypeTabBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemBookMallTypeTabBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_book_mall_type_tab, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
