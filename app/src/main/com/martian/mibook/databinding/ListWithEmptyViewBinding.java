package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeListView;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ListWithEmptyViewBinding implements ViewBinding {

    @NonNull
    public final ThemeTextView emptyText;

    @NonNull
    public final ThemeListView list;

    @NonNull
    private final ThemeRelativeLayout rootView;

    private ListWithEmptyViewBinding(@NonNull ThemeRelativeLayout themeRelativeLayout, @NonNull ThemeTextView themeTextView, @NonNull ThemeListView themeListView) {
        this.rootView = themeRelativeLayout;
        this.emptyText = themeTextView;
        this.list = themeListView;
    }

    @NonNull
    public static ListWithEmptyViewBinding bind(@NonNull View view) {
        int i10 = R.id.empty_text;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = android.R.id.list;
            ThemeListView themeListView = (ThemeListView) ViewBindings.findChildViewById(view, android.R.id.list);
            if (themeListView != null) {
                return new ListWithEmptyViewBinding((ThemeRelativeLayout) view, themeTextView, themeListView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ListWithEmptyViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ListWithEmptyViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.list_with_empty_view, viewGroup, false);
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
