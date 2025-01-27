package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.BookCoverImageView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ItemBookShelfListBinding implements ViewBinding {

    @NonNull
    public final BookCoverImageView bookListCover;

    @NonNull
    public final LinearLayout bookListItemContainer;

    @NonNull
    public final ImageView bpItemSelect;

    @NonNull
    public final TextView ivUpdateSign;

    @NonNull
    private final LinearLayout rootView;

    @NonNull
    public final ThemeTextView tvReadingRecord;

    @NonNull
    public final TextView tvTitleName;

    @NonNull
    public final ThemeTextView tvUrl;

    @NonNull
    public final ThemeTextView tvUrlName;

    private ItemBookShelfListBinding(@NonNull LinearLayout linearLayout, @NonNull BookCoverImageView bookCoverImageView, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull ThemeTextView themeTextView, @NonNull TextView textView2, @NonNull ThemeTextView themeTextView2, @NonNull ThemeTextView themeTextView3) {
        this.rootView = linearLayout;
        this.bookListCover = bookCoverImageView;
        this.bookListItemContainer = linearLayout2;
        this.bpItemSelect = imageView;
        this.ivUpdateSign = textView;
        this.tvReadingRecord = themeTextView;
        this.tvTitleName = textView2;
        this.tvUrl = themeTextView2;
        this.tvUrlName = themeTextView3;
    }

    @NonNull
    public static ItemBookShelfListBinding bind(@NonNull View view) {
        int i10 = R.id.book_list_cover;
        BookCoverImageView bookCoverImageView = (BookCoverImageView) ViewBindings.findChildViewById(view, i10);
        if (bookCoverImageView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i10 = R.id.bp_item_select;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView != null) {
                i10 = R.id.iv_update_sign;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                if (textView != null) {
                    i10 = R.id.tv_reading_record;
                    ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (themeTextView != null) {
                        i10 = R.id.tv_title_name;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                        if (textView2 != null) {
                            i10 = R.id.tv_url;
                            ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                            if (themeTextView2 != null) {
                                i10 = R.id.tv_url_name;
                                ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                if (themeTextView3 != null) {
                                    return new ItemBookShelfListBinding(linearLayout, bookCoverImageView, linearLayout, imageView, textView, themeTextView, textView2, themeTextView2, themeTextView3);
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
    public static ItemBookShelfListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemBookShelfListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_book_shelf_list, viewGroup, false);
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
