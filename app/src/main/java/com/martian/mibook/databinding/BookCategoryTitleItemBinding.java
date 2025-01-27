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
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class BookCategoryTitleItemBinding implements ViewBinding {

    @NonNull
    public final TextView categoryTitle;

    @NonNull
    public final LinearLayout categoryTitleView;

    @NonNull
    private final LinearLayout rootView;

    private BookCategoryTitleItemBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.categoryTitle = textView;
        this.categoryTitleView = linearLayout2;
    }

    @NonNull
    public static BookCategoryTitleItemBinding bind(@NonNull View view) {
        int i10 = R.id.category_title;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
        if (textView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
        }
        LinearLayout linearLayout = (LinearLayout) view;
        return new BookCategoryTitleItemBinding(linearLayout, textView, linearLayout);
    }

    @NonNull
    public static BookCategoryTitleItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static BookCategoryTitleItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.book_category_title_item, viewGroup, false);
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
