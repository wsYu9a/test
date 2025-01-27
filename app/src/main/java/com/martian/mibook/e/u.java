package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeIRecyclerView;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class u implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12755a;

    /* renamed from: b */
    @NonNull
    public final RelativeLayout f12756b;

    /* renamed from: c */
    @NonNull
    public final ThemeIRecyclerView f12757c;

    /* renamed from: d */
    @NonNull
    public final LoadingTip f12758d;

    private u(@NonNull RelativeLayout rootView, @NonNull RelativeLayout similarityBookContainer, @NonNull ThemeIRecyclerView similarityBookRecyclerView, @NonNull LoadingTip similarityLoadingTip) {
        this.f12755a = rootView;
        this.f12756b = similarityBookContainer;
        this.f12757c = similarityBookRecyclerView;
        this.f12758d = similarityLoadingTip;
    }

    @NonNull
    public static u a(@NonNull View rootView) {
        RelativeLayout relativeLayout = (RelativeLayout) rootView;
        int i2 = R.id.similarity_book_recycler_view;
        ThemeIRecyclerView themeIRecyclerView = (ThemeIRecyclerView) rootView.findViewById(R.id.similarity_book_recycler_view);
        if (themeIRecyclerView != null) {
            i2 = R.id.similarity_loading_tip;
            LoadingTip loadingTip = (LoadingTip) rootView.findViewById(R.id.similarity_loading_tip);
            if (loadingTip != null) {
                return new u((RelativeLayout) rootView, relativeLayout, themeIRecyclerView, loadingTip);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static u c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static u d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_similarity_book, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12755a;
    }
}
