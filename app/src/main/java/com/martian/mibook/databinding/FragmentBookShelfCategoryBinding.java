package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class FragmentBookShelfCategoryBinding implements ViewBinding {

    @NonNull
    public final ThemeImageView ivWindowClose;

    @NonNull
    private final RelativeLayout rootView;

    @NonNull
    public final RecyclerView rvBookShelfCategory;

    @NonNull
    public final ThemeTextView tvSpeedTitle;

    private FragmentBookShelfCategoryBinding(@NonNull RelativeLayout relativeLayout, @NonNull ThemeImageView themeImageView, @NonNull RecyclerView recyclerView, @NonNull ThemeTextView themeTextView) {
        this.rootView = relativeLayout;
        this.ivWindowClose = themeImageView;
        this.rvBookShelfCategory = recyclerView;
        this.tvSpeedTitle = themeTextView;
    }

    @NonNull
    public static FragmentBookShelfCategoryBinding bind(@NonNull View view) {
        int i10 = R.id.iv_window_close;
        ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (themeImageView != null) {
            i10 = R.id.rv_book_shelf_category;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i10);
            if (recyclerView != null) {
                i10 = R.id.tv_speed_title;
                ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView != null) {
                    return new FragmentBookShelfCategoryBinding((RelativeLayout) view, themeImageView, recyclerView, themeTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static FragmentBookShelfCategoryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentBookShelfCategoryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.fragment_book_shelf_category, viewGroup, false);
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
