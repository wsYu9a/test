package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class DialogTagBinding implements ViewBinding {

    @NonNull
    public final ThemeLinearLayout bookrackCategory;

    @NonNull
    public final View bookrackCategoryTop;

    @NonNull
    private final RelativeLayout rootView;

    @NonNull
    public final View storeCategoryView;

    @NonNull
    public final ListView tagCategoryList;

    @NonNull
    public final ThemeTextView tagCategoryNews;

    @NonNull
    public final ThemeTextView tagTitle;

    private DialogTagBinding(@NonNull RelativeLayout relativeLayout, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull View view, @NonNull View view2, @NonNull ListView listView, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2) {
        this.rootView = relativeLayout;
        this.bookrackCategory = themeLinearLayout;
        this.bookrackCategoryTop = view;
        this.storeCategoryView = view2;
        this.tagCategoryList = listView;
        this.tagCategoryNews = themeTextView;
        this.tagTitle = themeTextView2;
    }

    @NonNull
    public static DialogTagBinding bind(@NonNull View view) {
        View findChildViewById;
        View findChildViewById2;
        int i10 = R.id.bookrack_category;
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
        if (themeLinearLayout != null && (findChildViewById = ViewBindings.findChildViewById(view, (i10 = R.id.bookrack_category_top))) != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i10 = R.id.store_category_view))) != null) {
            i10 = R.id.tag_category_list;
            ListView listView = (ListView) ViewBindings.findChildViewById(view, i10);
            if (listView != null) {
                i10 = R.id.tag_category_news;
                ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView != null) {
                    i10 = R.id.tag_title;
                    ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (themeTextView2 != null) {
                        return new DialogTagBinding((RelativeLayout) view, themeLinearLayout, findChildViewById, findChildViewById2, listView, themeTextView, themeTextView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static DialogTagBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogTagBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.dialog_tag, viewGroup, false);
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
