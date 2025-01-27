package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class BookStoreGridBookMoreItemBinding implements ViewBinding {

    @NonNull
    public final ThemeLinearLayout bookAdderGridContainer;

    @NonNull
    public final RelativeLayout ivBookMoreView;

    @NonNull
    private final ThemeLinearLayout rootView;

    private BookStoreGridBookMoreItemBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeLinearLayout themeLinearLayout2, @NonNull RelativeLayout relativeLayout) {
        this.rootView = themeLinearLayout;
        this.bookAdderGridContainer = themeLinearLayout2;
        this.ivBookMoreView = relativeLayout;
    }

    @NonNull
    public static BookStoreGridBookMoreItemBinding bind(@NonNull View view) {
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) view;
        int i10 = R.id.iv_book_more_view;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
        if (relativeLayout != null) {
            return new BookStoreGridBookMoreItemBinding(themeLinearLayout, themeLinearLayout, relativeLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static BookStoreGridBookMoreItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static BookStoreGridBookMoreItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.book_store_grid_book_more_item, viewGroup, false);
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
