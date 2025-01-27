package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.R;
import com.martian.mibook.mvvm.widget.DotSeekBar;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class ReaderAutoSlideLayoutBinding implements ViewBinding {

    @NonNull
    public final ReaderThemeImageView ivClose;

    @NonNull
    public final ReaderThemeLinearLayout llStopAutoSlide;

    @NonNull
    private final RoundedLayout rootView;

    @NonNull
    public final DotSeekBar seekBar;

    @NonNull
    public final ReaderThemeTextView tvFast;

    @NonNull
    public final ReaderThemeTextView tvReset;

    @NonNull
    public final ReaderThemeTextView tvSlow;

    @NonNull
    public final ReaderThemeTextView tvTitle;

    private ReaderAutoSlideLayoutBinding(@NonNull RoundedLayout roundedLayout, @NonNull ReaderThemeImageView readerThemeImageView, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout, @NonNull DotSeekBar dotSeekBar, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull ReaderThemeTextView readerThemeTextView3, @NonNull ReaderThemeTextView readerThemeTextView4) {
        this.rootView = roundedLayout;
        this.ivClose = readerThemeImageView;
        this.llStopAutoSlide = readerThemeLinearLayout;
        this.seekBar = dotSeekBar;
        this.tvFast = readerThemeTextView;
        this.tvReset = readerThemeTextView2;
        this.tvSlow = readerThemeTextView3;
        this.tvTitle = readerThemeTextView4;
    }

    @NonNull
    public static ReaderAutoSlideLayoutBinding bind(@NonNull View view) {
        int i10 = R.id.iv_close;
        ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (readerThemeImageView != null) {
            i10 = R.id.ll_stop_auto_slide;
            ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
            if (readerThemeLinearLayout != null) {
                i10 = R.id.seekBar;
                DotSeekBar dotSeekBar = (DotSeekBar) ViewBindings.findChildViewById(view, i10);
                if (dotSeekBar != null) {
                    i10 = R.id.tv_fast;
                    ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (readerThemeTextView != null) {
                        i10 = R.id.tv_reset;
                        ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (readerThemeTextView2 != null) {
                            i10 = R.id.tv_slow;
                            ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                            if (readerThemeTextView3 != null) {
                                i10 = R.id.tv_title;
                                ReaderThemeTextView readerThemeTextView4 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                if (readerThemeTextView4 != null) {
                                    return new ReaderAutoSlideLayoutBinding((RoundedLayout) view, readerThemeImageView, readerThemeLinearLayout, dotSeekBar, readerThemeTextView, readerThemeTextView2, readerThemeTextView3, readerThemeTextView4);
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
    public static ReaderAutoSlideLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReaderAutoSlideLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reader_auto_slide_layout, viewGroup, false);
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
