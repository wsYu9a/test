package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.utils.tablayout.MagicIndicator;
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class ReadingLeftDrawerBinding implements ViewBinding {

    @NonNull
    public final MagicIndicator magicIndicator;

    @NonNull
    public final ViewPager mainPager;

    @NonNull
    private final ReaderThemeLinearLayout rootView;

    @NonNull
    public final ReaderThemeTextView slBookCategories;

    @NonNull
    public final ImageView slBookCover;

    @NonNull
    public final ReaderThemeLinearLayout slBookCoverView;

    @NonNull
    public final ReaderThemeTextView slBookName;

    @NonNull
    public final ThemeImageView slCacheDivider;

    @NonNull
    public final ReaderThemeLinearLayout slCacheView;

    private ReadingLeftDrawerBinding(@NonNull ReaderThemeLinearLayout readerThemeLinearLayout, @NonNull MagicIndicator magicIndicator, @NonNull ViewPager viewPager, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ImageView imageView, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout2, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull ThemeImageView themeImageView, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout3) {
        this.rootView = readerThemeLinearLayout;
        this.magicIndicator = magicIndicator;
        this.mainPager = viewPager;
        this.slBookCategories = readerThemeTextView;
        this.slBookCover = imageView;
        this.slBookCoverView = readerThemeLinearLayout2;
        this.slBookName = readerThemeTextView2;
        this.slCacheDivider = themeImageView;
        this.slCacheView = readerThemeLinearLayout3;
    }

    @NonNull
    public static ReadingLeftDrawerBinding bind(@NonNull View view) {
        int i10 = R.id.magic_indicator;
        MagicIndicator magicIndicator = (MagicIndicator) ViewBindings.findChildViewById(view, i10);
        if (magicIndicator != null) {
            i10 = R.id.main_pager;
            ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(view, i10);
            if (viewPager != null) {
                i10 = R.id.sl_book_categories;
                ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (readerThemeTextView != null) {
                    i10 = R.id.sl_book_cover;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                    if (imageView != null) {
                        ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) view;
                        i10 = R.id.sl_book_name;
                        ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (readerThemeTextView2 != null) {
                            i10 = R.id.sl_cache_divider;
                            ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                            if (themeImageView != null) {
                                i10 = R.id.sl_cache_view;
                                ReaderThemeLinearLayout readerThemeLinearLayout2 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                if (readerThemeLinearLayout2 != null) {
                                    return new ReadingLeftDrawerBinding(readerThemeLinearLayout, magicIndicator, viewPager, readerThemeTextView, imageView, readerThemeLinearLayout, readerThemeTextView2, themeImageView, readerThemeLinearLayout2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ReadingLeftDrawerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReadingLeftDrawerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reading_left_drawer, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ReaderThemeLinearLayout getRoot() {
        return this.rootView;
    }
}
