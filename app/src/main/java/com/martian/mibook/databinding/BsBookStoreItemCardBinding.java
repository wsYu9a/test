package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class BsBookStoreItemCardBinding implements ViewBinding {

    @NonNull
    public final LinearLayout bookItemRoot;

    @NonNull
    public final ThemeTextView bsListAuthorName;

    @NonNull
    public final ThemeTextView bsListBookName;

    @NonNull
    public final ThemeImageView bsListCover;

    @NonNull
    public final TextView bsListScore;

    @NonNull
    public final ThemeTextView bsListShortContent;

    @NonNull
    private final LinearLayout rootView;

    private BsBookStoreItemCardBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeImageView themeImageView, @NonNull TextView textView, @NonNull ThemeTextView themeTextView3) {
        this.rootView = linearLayout;
        this.bookItemRoot = linearLayout2;
        this.bsListAuthorName = themeTextView;
        this.bsListBookName = themeTextView2;
        this.bsListCover = themeImageView;
        this.bsListScore = textView;
        this.bsListShortContent = themeTextView3;
    }

    @NonNull
    public static BsBookStoreItemCardBinding bind(@NonNull View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i10 = R.id.bs_list_author_name;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = R.id.bs_list_book_name;
            ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView2 != null) {
                i10 = R.id.bs_list_cover;
                ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                if (themeImageView != null) {
                    i10 = R.id.bs_list_score;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                    if (textView != null) {
                        i10 = R.id.bs_list_short_content;
                        ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView3 != null) {
                            return new BsBookStoreItemCardBinding(linearLayout, linearLayout, themeTextView, themeTextView2, themeImageView, textView, themeTextView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static BsBookStoreItemCardBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static BsBookStoreItemCardBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.bs_book_store_item_card, viewGroup, false);
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
