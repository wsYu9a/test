package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.utils.tablayout.MagicIndicator;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class b6 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ReaderThemeLinearLayout f11761a;

    /* renamed from: b */
    @NonNull
    public final MagicIndicator f11762b;

    /* renamed from: c */
    @NonNull
    public final ViewPager f11763c;

    /* renamed from: d */
    @NonNull
    public final ReaderThemeTextView f11764d;

    /* renamed from: e */
    @NonNull
    public final ImageView f11765e;

    /* renamed from: f */
    @NonNull
    public final ReaderThemeLinearLayout f11766f;

    /* renamed from: g */
    @NonNull
    public final ReaderThemeTextView f11767g;

    /* renamed from: h */
    @NonNull
    public final ThemeImageView f11768h;

    /* renamed from: i */
    @NonNull
    public final ReaderThemeLinearLayout f11769i;

    private b6(@NonNull ReaderThemeLinearLayout rootView, @NonNull MagicIndicator magicIndicator, @NonNull ViewPager mainPager, @NonNull ReaderThemeTextView slBookCategories, @NonNull ImageView slBookCover, @NonNull ReaderThemeLinearLayout slBookCoverView, @NonNull ReaderThemeTextView slBookName, @NonNull ThemeImageView slCacheDivider, @NonNull ReaderThemeLinearLayout slCacheView) {
        this.f11761a = rootView;
        this.f11762b = magicIndicator;
        this.f11763c = mainPager;
        this.f11764d = slBookCategories;
        this.f11765e = slBookCover;
        this.f11766f = slBookCoverView;
        this.f11767g = slBookName;
        this.f11768h = slCacheDivider;
        this.f11769i = slCacheView;
    }

    @NonNull
    public static b6 a(@NonNull View rootView) {
        int i2 = R.id.magic_indicator;
        MagicIndicator magicIndicator = (MagicIndicator) rootView.findViewById(R.id.magic_indicator);
        if (magicIndicator != null) {
            i2 = R.id.main_pager;
            ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.main_pager);
            if (viewPager != null) {
                i2 = R.id.sl_book_categories;
                ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.sl_book_categories);
                if (readerThemeTextView != null) {
                    i2 = R.id.sl_book_cover;
                    ImageView imageView = (ImageView) rootView.findViewById(R.id.sl_book_cover);
                    if (imageView != null) {
                        ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) rootView;
                        i2 = R.id.sl_book_name;
                        ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) rootView.findViewById(R.id.sl_book_name);
                        if (readerThemeTextView2 != null) {
                            i2 = R.id.sl_cache_divider;
                            ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.sl_cache_divider);
                            if (themeImageView != null) {
                                i2 = R.id.sl_cache_view;
                                ReaderThemeLinearLayout readerThemeLinearLayout2 = (ReaderThemeLinearLayout) rootView.findViewById(R.id.sl_cache_view);
                                if (readerThemeLinearLayout2 != null) {
                                    return new b6(readerThemeLinearLayout, magicIndicator, viewPager, readerThemeTextView, imageView, readerThemeLinearLayout, readerThemeTextView2, themeImageView, readerThemeLinearLayout2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static b6 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static b6 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_left_drawer, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ReaderThemeLinearLayout getRoot() {
        return this.f11761a;
    }
}
