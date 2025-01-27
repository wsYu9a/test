package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class ReaderVipThemeLayoutBinding implements ViewBinding {

    @NonNull
    public final ReaderThemeImageView ivClose;

    @NonNull
    public final ImageView ivCustomUsed;

    @NonNull
    public final NestedScrollView nestedScrollview;

    @NonNull
    private final RoundedLayout rootView;

    @NonNull
    public final RecyclerView rvTheme;

    @NonNull
    public final ReaderThemeTextView tvCustom;

    @NonNull
    public final ReaderThemeTextView tvTitle;

    private ReaderVipThemeLayoutBinding(@NonNull RoundedLayout roundedLayout, @NonNull ReaderThemeImageView readerThemeImageView, @NonNull ImageView imageView, @NonNull NestedScrollView nestedScrollView, @NonNull RecyclerView recyclerView, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeTextView readerThemeTextView2) {
        this.rootView = roundedLayout;
        this.ivClose = readerThemeImageView;
        this.ivCustomUsed = imageView;
        this.nestedScrollview = nestedScrollView;
        this.rvTheme = recyclerView;
        this.tvCustom = readerThemeTextView;
        this.tvTitle = readerThemeTextView2;
    }

    @NonNull
    public static ReaderVipThemeLayoutBinding bind(@NonNull View view) {
        int i10 = R.id.iv_close;
        ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (readerThemeImageView != null) {
            i10 = R.id.iv_custom_used;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView != null) {
                i10 = R.id.nested_scrollview;
                NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, i10);
                if (nestedScrollView != null) {
                    i10 = R.id.rv_theme;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i10);
                    if (recyclerView != null) {
                        i10 = R.id.tv_custom;
                        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (readerThemeTextView != null) {
                            i10 = R.id.tv_title;
                            ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                            if (readerThemeTextView2 != null) {
                                return new ReaderVipThemeLayoutBinding((RoundedLayout) view, readerThemeImageView, imageView, nestedScrollView, recyclerView, readerThemeTextView, readerThemeTextView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ReaderVipThemeLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReaderVipThemeLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reader_vip_theme_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public RoundedLayout getRoot() {
        return this.rootView;
    }
}
