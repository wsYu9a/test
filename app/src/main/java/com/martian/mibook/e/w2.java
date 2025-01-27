package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeIRecyclerView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class w2 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f12874a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f12875b;

    /* renamed from: c */
    @NonNull
    public final ThemeLinearLayout f12876c;

    /* renamed from: d */
    @NonNull
    public final LoadingTip f12877d;

    /* renamed from: e */
    @NonNull
    public final ThemeIRecyclerView f12878e;

    private w2(@NonNull ThemeLinearLayout rootView, @NonNull ThemeTextView bookStatus, @NonNull ThemeLinearLayout bookStatusView, @NonNull LoadingTip categoryLoadingTip, @NonNull ThemeIRecyclerView rankIrc) {
        this.f12874a = rootView;
        this.f12875b = bookStatus;
        this.f12876c = bookStatusView;
        this.f12877d = categoryLoadingTip;
        this.f12878e = rankIrc;
    }

    @NonNull
    public static w2 a(@NonNull View rootView) {
        int i2 = R.id.book_status;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.book_status);
        if (themeTextView != null) {
            i2 = R.id.book_status_view;
            ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.book_status_view);
            if (themeLinearLayout != null) {
                i2 = R.id.category_loading_tip;
                LoadingTip loadingTip = (LoadingTip) rootView.findViewById(R.id.category_loading_tip);
                if (loadingTip != null) {
                    i2 = R.id.rank_irc;
                    ThemeIRecyclerView themeIRecyclerView = (ThemeIRecyclerView) rootView.findViewById(R.id.rank_irc);
                    if (themeIRecyclerView != null) {
                        return new w2((ThemeLinearLayout) rootView, themeTextView, themeLinearLayout, loadingTip, themeIRecyclerView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static w2 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static w2 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fragment_book_rank, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f12874a;
    }
}
