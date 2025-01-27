package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class BookInfoMenuBinding implements ViewBinding {

    @NonNull
    public final ThemeImageView menuIconBookImport;

    @NonNull
    public final ThemeLinearLayout menuReport;

    @NonNull
    private final LinearLayout rootView;

    private BookInfoMenuBinding(@NonNull LinearLayout linearLayout, @NonNull ThemeImageView themeImageView, @NonNull ThemeLinearLayout themeLinearLayout) {
        this.rootView = linearLayout;
        this.menuIconBookImport = themeImageView;
        this.menuReport = themeLinearLayout;
    }

    @NonNull
    public static BookInfoMenuBinding bind(@NonNull View view) {
        int i10 = R.id.menu_icon_book_import;
        ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (themeImageView != null) {
            i10 = R.id.menu_report;
            ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
            if (themeLinearLayout != null) {
                return new BookInfoMenuBinding((LinearLayout) view, themeImageView, themeLinearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static BookInfoMenuBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static BookInfoMenuBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.book_info_menu, viewGroup, false);
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
