package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.mibook.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: classes3.dex */
public final class FragmentBookShelfBinding implements ViewBinding {

    @NonNull
    public final ViewStub bookShelfCategories;

    @NonNull
    public final ViewStub bookShelfSearch;

    @NonNull
    public final SmartRefreshLayout refreshLayout;

    @NonNull
    private final ThemeLinearLayout rootView;

    @NonNull
    public final RecyclerView rvBookShelf;

    private FragmentBookShelfBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull ViewStub viewStub, @NonNull ViewStub viewStub2, @NonNull SmartRefreshLayout smartRefreshLayout, @NonNull RecyclerView recyclerView) {
        this.rootView = themeLinearLayout;
        this.bookShelfCategories = viewStub;
        this.bookShelfSearch = viewStub2;
        this.refreshLayout = smartRefreshLayout;
        this.rvBookShelf = recyclerView;
    }

    @NonNull
    public static FragmentBookShelfBinding bind(@NonNull View view) {
        int i10 = R.id.book_shelf_categories;
        ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, i10);
        if (viewStub != null) {
            i10 = R.id.book_shelf_search;
            ViewStub viewStub2 = (ViewStub) ViewBindings.findChildViewById(view, i10);
            if (viewStub2 != null) {
                i10 = R.id.refreshLayout;
                SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) ViewBindings.findChildViewById(view, i10);
                if (smartRefreshLayout != null) {
                    i10 = R.id.rv_book_shelf;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i10);
                    if (recyclerView != null) {
                        return new FragmentBookShelfBinding((ThemeLinearLayout) view, viewStub, viewStub2, smartRefreshLayout, recyclerView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static FragmentBookShelfBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentBookShelfBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.fragment_book_shelf, viewGroup, false);
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
