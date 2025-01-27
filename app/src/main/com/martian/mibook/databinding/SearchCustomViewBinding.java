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
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class SearchCustomViewBinding implements ViewBinding {

    @NonNull
    public final ThemeImageView btnClearSearchText;

    @NonNull
    private final ThemeRelativeLayout rootView;

    @NonNull
    public final ThemeEditText scEditText;

    @NonNull
    public final ThemeLinearLayout searchView;

    private SearchCustomViewBinding(@NonNull ThemeRelativeLayout themeRelativeLayout, @NonNull ThemeImageView themeImageView, @NonNull ThemeEditText themeEditText, @NonNull ThemeLinearLayout themeLinearLayout) {
        this.rootView = themeRelativeLayout;
        this.btnClearSearchText = themeImageView;
        this.scEditText = themeEditText;
        this.searchView = themeLinearLayout;
    }

    @NonNull
    public static SearchCustomViewBinding bind(@NonNull View view) {
        int i10 = R.id.btn_clear_search_text;
        ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (themeImageView != null) {
            i10 = R.id.sc_edit_text;
            ThemeEditText themeEditText = (ThemeEditText) ViewBindings.findChildViewById(view, i10);
            if (themeEditText != null) {
                i10 = R.id.search_view;
                ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                if (themeLinearLayout != null) {
                    return new SearchCustomViewBinding((ThemeRelativeLayout) view, themeImageView, themeEditText, themeLinearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static SearchCustomViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static SearchCustomViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.search_custom_view, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ThemeRelativeLayout getRoot() {
        return this.rootView;
    }
}
