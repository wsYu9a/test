package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.widget.BookCoverImageView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ItemSimilarityBookBannerBinding implements ViewBinding {

    @NonNull
    public final BookCoverImageView bookCover;

    @NonNull
    private final RelativeLayout rootView;

    @NonNull
    public final TextView tvBookName;

    private ItemSimilarityBookBannerBinding(@NonNull RelativeLayout relativeLayout, @NonNull BookCoverImageView bookCoverImageView, @NonNull TextView textView) {
        this.rootView = relativeLayout;
        this.bookCover = bookCoverImageView;
        this.tvBookName = textView;
    }

    @NonNull
    public static ItemSimilarityBookBannerBinding bind(@NonNull View view) {
        int i10 = R.id.book_cover;
        BookCoverImageView bookCoverImageView = (BookCoverImageView) ViewBindings.findChildViewById(view, i10);
        if (bookCoverImageView != null) {
            i10 = R.id.tv_book_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
            if (textView != null) {
                return new ItemSimilarityBookBannerBinding((RelativeLayout) view, bookCoverImageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ItemSimilarityBookBannerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemSimilarityBookBannerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_similarity_book_banner, viewGroup, false);
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
