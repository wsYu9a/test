package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.ui.recybanner.BannerLayout;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class b7 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f11770a;

    /* renamed from: b */
    @NonNull
    public final BannerLayout f11771b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f11772c;

    private b7(@NonNull RelativeLayout rootView, @NonNull BannerLayout recyclerViewBanner, @NonNull ThemeTextView similarityBookName) {
        this.f11770a = rootView;
        this.f11771b = recyclerViewBanner;
        this.f11772c = similarityBookName;
    }

    @NonNull
    public static b7 a(@NonNull View rootView) {
        int i2 = R.id.recycler_view_banner;
        BannerLayout bannerLayout = (BannerLayout) rootView.findViewById(R.id.recycler_view_banner);
        if (bannerLayout != null) {
            i2 = R.id.similarity_book_name;
            ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.similarity_book_name);
            if (themeTextView != null) {
                return new b7((RelativeLayout) rootView, bannerLayout, themeTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static b7 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static b7 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.similarity_book_header, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f11770a;
    }
}
