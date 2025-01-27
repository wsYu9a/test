package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class ReaderSlideModeSettingLayoutBinding implements ViewBinding {

    @NonNull
    public final ReaderThemeImageView ivClose;

    @NonNull
    private final RoundedLayout rootView;

    @NonNull
    public final RecyclerView rvClickRules;

    @NonNull
    public final RecyclerView rvSlideMode;

    @NonNull
    public final ReaderThemeTextView tvExit;

    @NonNull
    public final ReaderThemeTextView tvTitle;

    private ReaderSlideModeSettingLayoutBinding(@NonNull RoundedLayout roundedLayout, @NonNull ReaderThemeImageView readerThemeImageView, @NonNull RecyclerView recyclerView, @NonNull RecyclerView recyclerView2, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeTextView readerThemeTextView2) {
        this.rootView = roundedLayout;
        this.ivClose = readerThemeImageView;
        this.rvClickRules = recyclerView;
        this.rvSlideMode = recyclerView2;
        this.tvExit = readerThemeTextView;
        this.tvTitle = readerThemeTextView2;
    }

    @NonNull
    public static ReaderSlideModeSettingLayoutBinding bind(@NonNull View view) {
        int i10 = R.id.iv_close;
        ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (readerThemeImageView != null) {
            i10 = R.id.rv_click_rules;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i10);
            if (recyclerView != null) {
                i10 = R.id.rv_slide_mode;
                RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i10);
                if (recyclerView2 != null) {
                    i10 = R.id.tv_exit;
                    ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (readerThemeTextView != null) {
                        i10 = R.id.tv_title;
                        ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (readerThemeTextView2 != null) {
                            return new ReaderSlideModeSettingLayoutBinding((RoundedLayout) view, readerThemeImageView, recyclerView, recyclerView2, readerThemeTextView, readerThemeTextView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ReaderSlideModeSettingLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReaderSlideModeSettingLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reader_slide_mode_setting_layout, viewGroup, false);
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
