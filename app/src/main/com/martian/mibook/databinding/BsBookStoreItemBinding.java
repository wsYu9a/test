package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class BsBookStoreItemBinding implements ViewBinding {

    @NonNull
    public final ThemeLinearLayout bookItemRoot;

    @NonNull
    public final ThemeTextView bsListAuthorName;

    @NonNull
    public final TextView bsListBookMark;

    @NonNull
    public final ThemeTextView bsListBookName;

    @NonNull
    public final ThemeImageView bsListCover;

    @NonNull
    public final TextView bsListScore;

    @NonNull
    public final ThemeTextView bsListShortContent;

    @NonNull
    private final ThemeLinearLayout rootView;

    private BsBookStoreItemBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeLinearLayout themeLinearLayout2, @NonNull ThemeTextView themeTextView, @NonNull TextView textView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeImageView themeImageView, @NonNull TextView textView2, @NonNull ThemeTextView themeTextView3) {
        this.rootView = themeLinearLayout;
        this.bookItemRoot = themeLinearLayout2;
        this.bsListAuthorName = themeTextView;
        this.bsListBookMark = textView;
        this.bsListBookName = themeTextView2;
        this.bsListCover = themeImageView;
        this.bsListScore = textView2;
        this.bsListShortContent = themeTextView3;
    }

    @NonNull
    public static BsBookStoreItemBinding bind(@NonNull View view) {
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) view;
        int i10 = R.id.bs_list_author_name;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = R.id.bs_list_book_mark;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
            if (textView != null) {
                i10 = R.id.bs_list_book_name;
                ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView2 != null) {
                    i10 = R.id.bs_list_cover;
                    ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                    if (themeImageView != null) {
                        i10 = R.id.bs_list_score;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                        if (textView2 != null) {
                            i10 = R.id.bs_list_short_content;
                            ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                            if (themeTextView3 != null) {
                                return new BsBookStoreItemBinding(themeLinearLayout, themeLinearLayout, themeTextView, textView, themeTextView2, themeImageView, textView2, themeTextView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static BsBookStoreItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static BsBookStoreItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.bs_book_store_item, viewGroup, false);
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
