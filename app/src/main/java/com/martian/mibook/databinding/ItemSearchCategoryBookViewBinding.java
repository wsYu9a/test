package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ItemSearchCategoryBookViewBinding implements ViewBinding {

    @NonNull
    public final LinearLayout llMore;

    @NonNull
    private final ThemeLinearLayout rootView;

    @NonNull
    public final RecyclerView rvBooks;

    @NonNull
    public final ThemeTextView searchTagName;

    @NonNull
    public final TextView searchTagType;

    private ItemSearchCategoryBookViewBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView, @NonNull ThemeTextView themeTextView, @NonNull TextView textView) {
        this.rootView = themeLinearLayout;
        this.llMore = linearLayout;
        this.rvBooks = recyclerView;
        this.searchTagName = themeTextView;
        this.searchTagType = textView;
    }

    @NonNull
    public static ItemSearchCategoryBookViewBinding bind(@NonNull View view) {
        int i10 = R.id.ll_more;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
        if (linearLayout != null) {
            i10 = R.id.rv_books;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i10);
            if (recyclerView != null) {
                i10 = R.id.search_tag_name;
                ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView != null) {
                    i10 = R.id.search_tag_type;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                    if (textView != null) {
                        return new ItemSearchCategoryBookViewBinding((ThemeLinearLayout) view, linearLayout, recyclerView, themeTextView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ItemSearchCategoryBookViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemSearchCategoryBookViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_search_category_book_view, viewGroup, false);
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
