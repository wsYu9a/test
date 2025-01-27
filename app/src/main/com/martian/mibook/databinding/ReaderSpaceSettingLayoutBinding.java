package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.utils.tablayout.MagicIndicator;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class ReaderSpaceSettingLayoutBinding implements ViewBinding {

    @NonNull
    public final ReaderThemeImageView ivClose;

    @NonNull
    public final MagicIndicator magicIndicatorRowSpace;

    @NonNull
    private final RoundedLayout rootView;

    @NonNull
    public final ReaderThemeTextView tvExit;

    @NonNull
    public final ReaderThemeTextView tvRowSpace;

    @NonNull
    public final ReaderThemeTextView tvTitle;

    private ReaderSpaceSettingLayoutBinding(@NonNull RoundedLayout roundedLayout, @NonNull ReaderThemeImageView readerThemeImageView, @NonNull MagicIndicator magicIndicator, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull ReaderThemeTextView readerThemeTextView3) {
        this.rootView = roundedLayout;
        this.ivClose = readerThemeImageView;
        this.magicIndicatorRowSpace = magicIndicator;
        this.tvExit = readerThemeTextView;
        this.tvRowSpace = readerThemeTextView2;
        this.tvTitle = readerThemeTextView3;
    }

    @NonNull
    public static ReaderSpaceSettingLayoutBinding bind(@NonNull View view) {
        int i10 = R.id.iv_close;
        ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (readerThemeImageView != null) {
            i10 = R.id.magic_indicator_row_space;
            MagicIndicator magicIndicator = (MagicIndicator) ViewBindings.findChildViewById(view, i10);
            if (magicIndicator != null) {
                i10 = R.id.tv_exit;
                ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (readerThemeTextView != null) {
                    i10 = R.id.tv_row_space;
                    ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (readerThemeTextView2 != null) {
                        i10 = R.id.tv_title;
                        ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (readerThemeTextView3 != null) {
                            return new ReaderSpaceSettingLayoutBinding((RoundedLayout) view, readerThemeImageView, magicIndicator, readerThemeTextView, readerThemeTextView2, readerThemeTextView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ReaderSpaceSettingLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReaderSpaceSettingLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reader_space_setting_layout, viewGroup, false);
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
