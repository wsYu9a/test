package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeEditText;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class BookrackSearchBinding implements ViewBinding {

    @NonNull
    public final ThemeLinearLayout brSearch;

    @NonNull
    public final ThemeImageView btnClearSearchText;

    @NonNull
    public final ThemeEditText etSearch;

    @NonNull
    private final ThemeLinearLayout rootView;

    private BookrackSearchBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeLinearLayout themeLinearLayout2, @NonNull ThemeImageView themeImageView, @NonNull ThemeEditText themeEditText) {
        this.rootView = themeLinearLayout;
        this.brSearch = themeLinearLayout2;
        this.btnClearSearchText = themeImageView;
        this.etSearch = themeEditText;
    }

    @NonNull
    public static BookrackSearchBinding bind(@NonNull View view) {
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) view;
        int i10 = R.id.btn_clear_search_text;
        ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (themeImageView != null) {
            i10 = R.id.et_search;
            ThemeEditText themeEditText = (ThemeEditText) ViewBindings.findChildViewById(view, i10);
            if (themeEditText != null) {
                return new BookrackSearchBinding(themeLinearLayout, themeLinearLayout, themeImageView, themeEditText);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static BookrackSearchBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static BookrackSearchBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.bookrack_search, viewGroup, false);
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
