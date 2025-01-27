package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeIRecyclerView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class FragmentBookRankBinding implements ViewBinding {

    @NonNull
    public final ThemeTextView bookStatus;

    @NonNull
    public final ThemeLinearLayout bookStatusView;

    @NonNull
    public final LoadingTip categoryLoadingTip;

    @NonNull
    public final ThemeIRecyclerView rankIrc;

    @NonNull
    private final ThemeLinearLayout rootView;

    private FragmentBookRankBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeTextView themeTextView, @NonNull ThemeLinearLayout themeLinearLayout2, @NonNull LoadingTip loadingTip, @NonNull ThemeIRecyclerView themeIRecyclerView) {
        this.rootView = themeLinearLayout;
        this.bookStatus = themeTextView;
        this.bookStatusView = themeLinearLayout2;
        this.categoryLoadingTip = loadingTip;
        this.rankIrc = themeIRecyclerView;
    }

    @NonNull
    public static FragmentBookRankBinding bind(@NonNull View view) {
        int i10 = R.id.book_status;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = R.id.book_status_view;
            ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
            if (themeLinearLayout != null) {
                i10 = R.id.category_loading_tip;
                LoadingTip loadingTip = (LoadingTip) ViewBindings.findChildViewById(view, i10);
                if (loadingTip != null) {
                    i10 = R.id.rank_irc;
                    ThemeIRecyclerView themeIRecyclerView = (ThemeIRecyclerView) ViewBindings.findChildViewById(view, i10);
                    if (themeIRecyclerView != null) {
                        return new FragmentBookRankBinding((ThemeLinearLayout) view, themeTextView, themeLinearLayout, loadingTip, themeIRecyclerView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static FragmentBookRankBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentBookRankBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.fragment_book_rank, viewGroup, false);
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
