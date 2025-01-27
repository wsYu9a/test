package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeIRecyclerView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class FragmentCategoryListBinding implements ViewBinding {

    @NonNull
    public final ThemeTextView bookOrder;

    @NonNull
    public final ThemeLinearLayout bookOrderView;

    @NonNull
    public final ThemeIRecyclerView categoryIrc;

    @NonNull
    private final RelativeLayout rootView;

    private FragmentCategoryListBinding(@NonNull RelativeLayout relativeLayout, @NonNull ThemeTextView themeTextView, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeIRecyclerView themeIRecyclerView) {
        this.rootView = relativeLayout;
        this.bookOrder = themeTextView;
        this.bookOrderView = themeLinearLayout;
        this.categoryIrc = themeIRecyclerView;
    }

    @NonNull
    public static FragmentCategoryListBinding bind(@NonNull View view) {
        int i10 = R.id.book_order;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = R.id.book_order_view;
            ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
            if (themeLinearLayout != null) {
                i10 = R.id.category_irc;
                ThemeIRecyclerView themeIRecyclerView = (ThemeIRecyclerView) ViewBindings.findChildViewById(view, i10);
                if (themeIRecyclerView != null) {
                    return new FragmentCategoryListBinding((RelativeLayout) view, themeTextView, themeLinearLayout, themeIRecyclerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static FragmentCategoryListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentCategoryListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.fragment_category_list, viewGroup, false);
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
