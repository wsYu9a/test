package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeIRecyclerView;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class FragmentCommentsBinding implements ViewBinding {

    @NonNull
    public final ThemeIRecyclerView commentsIrc;

    @NonNull
    private final ThemeRelativeLayout rootView;

    @NonNull
    public final ThemeRelativeLayout svContainer;

    private FragmentCommentsBinding(@NonNull ThemeRelativeLayout themeRelativeLayout, @NonNull ThemeIRecyclerView themeIRecyclerView, @NonNull ThemeRelativeLayout themeRelativeLayout2) {
        this.rootView = themeRelativeLayout;
        this.commentsIrc = themeIRecyclerView;
        this.svContainer = themeRelativeLayout2;
    }

    @NonNull
    public static FragmentCommentsBinding bind(@NonNull View view) {
        int i10 = R.id.comments_irc;
        ThemeIRecyclerView themeIRecyclerView = (ThemeIRecyclerView) ViewBindings.findChildViewById(view, i10);
        if (themeIRecyclerView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
        }
        ThemeRelativeLayout themeRelativeLayout = (ThemeRelativeLayout) view;
        return new FragmentCommentsBinding(themeRelativeLayout, themeIRecyclerView, themeRelativeLayout);
    }

    @NonNull
    public static FragmentCommentsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentCommentsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.fragment_comments, viewGroup, false);
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
