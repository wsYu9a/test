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
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class BookStoreListBookMoreItemBinding implements ViewBinding {

    @NonNull
    public final ThemeLinearLayout bookAdderListContainer;

    @NonNull
    public final RelativeLayout ivBookListMoreView;

    @NonNull
    private final ThemeLinearLayout rootView;

    @NonNull
    public final ThemeTextView tvReadingRecord;

    private BookStoreListBookMoreItemBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeLinearLayout themeLinearLayout2, @NonNull RelativeLayout relativeLayout, @NonNull ThemeTextView themeTextView) {
        this.rootView = themeLinearLayout;
        this.bookAdderListContainer = themeLinearLayout2;
        this.ivBookListMoreView = relativeLayout;
        this.tvReadingRecord = themeTextView;
    }

    @NonNull
    public static BookStoreListBookMoreItemBinding bind(@NonNull View view) {
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) view;
        int i10 = R.id.iv_book_list_more_view;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
        if (relativeLayout != null) {
            i10 = R.id.tv_reading_record;
            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView != null) {
                return new BookStoreListBookMoreItemBinding(themeLinearLayout, themeLinearLayout, relativeLayout, themeTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static BookStoreListBookMoreItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static BookStoreListBookMoreItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.book_store_list_book_more_item, viewGroup, false);
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
