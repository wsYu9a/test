package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;
import com.martian.mibook.ui.recybanner.BannerLayout;

/* loaded from: classes3.dex */
public final class SimilarityBookHeaderBinding implements ViewBinding {

    @NonNull
    public final BannerLayout recyclerViewBanner;

    @NonNull
    private final RelativeLayout rootView;

    @NonNull
    public final ThemeTextView similarityBookName;

    private SimilarityBookHeaderBinding(@NonNull RelativeLayout relativeLayout, @NonNull BannerLayout bannerLayout, @NonNull ThemeTextView themeTextView) {
        this.rootView = relativeLayout;
        this.recyclerViewBanner = bannerLayout;
        this.similarityBookName = themeTextView;
    }

    @NonNull
    public static SimilarityBookHeaderBinding bind(@NonNull View view) {
        int i10 = R.id.recycler_view_banner;
        BannerLayout bannerLayout = (BannerLayout) ViewBindings.findChildViewById(view, i10);
        if (bannerLayout != null) {
            i10 = R.id.similarity_book_name;
            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView != null) {
                return new SimilarityBookHeaderBinding((RelativeLayout) view, bannerLayout, themeTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static SimilarityBookHeaderBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static SimilarityBookHeaderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.similarity_book_header, viewGroup, false);
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
