package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeEditText;
import com.martian.libmars.ui.theme.ThemeGridView;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ActivityCoverSwitchBinding implements ViewBinding {

    @NonNull
    public final ThemeImageView btnClearSearchText;

    @NonNull
    public final ThemeEditText etBookName;

    @NonNull
    public final ThemeGridView gvCoverList;

    @NonNull
    private final ThemeLinearLayout rootView;

    @NonNull
    public final ThemeLinearLayout searchView;

    private ActivityCoverSwitchBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeImageView themeImageView, @NonNull ThemeEditText themeEditText, @NonNull ThemeGridView themeGridView, @NonNull ThemeLinearLayout themeLinearLayout2) {
        this.rootView = themeLinearLayout;
        this.btnClearSearchText = themeImageView;
        this.etBookName = themeEditText;
        this.gvCoverList = themeGridView;
        this.searchView = themeLinearLayout2;
    }

    @NonNull
    public static ActivityCoverSwitchBinding bind(@NonNull View view) {
        int i10 = R.id.btn_clear_search_text;
        ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (themeImageView != null) {
            i10 = R.id.et_book_name;
            ThemeEditText themeEditText = (ThemeEditText) ViewBindings.findChildViewById(view, i10);
            if (themeEditText != null) {
                i10 = R.id.gv_cover_list;
                ThemeGridView themeGridView = (ThemeGridView) ViewBindings.findChildViewById(view, i10);
                if (themeGridView != null) {
                    i10 = R.id.search_view;
                    ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                    if (themeLinearLayout != null) {
                        return new ActivityCoverSwitchBinding((ThemeLinearLayout) view, themeImageView, themeEditText, themeGridView, themeLinearLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ActivityCoverSwitchBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityCoverSwitchBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_cover_switch, viewGroup, false);
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
