package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class ReaderWidgetBookMarkHeaderBinding implements ViewBinding {

    @NonNull
    public final ImageView ivArrow;

    @NonNull
    public final ImageView ivBookMark;

    @NonNull
    public final LinearLayout llMark;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final ReaderThemeTextView tvTips;

    private ReaderWidgetBookMarkHeaderBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull LinearLayout linearLayout, @NonNull ReaderThemeTextView readerThemeTextView) {
        this.rootView = constraintLayout;
        this.ivArrow = imageView;
        this.ivBookMark = imageView2;
        this.llMark = linearLayout;
        this.tvTips = readerThemeTextView;
    }

    @NonNull
    public static ReaderWidgetBookMarkHeaderBinding bind(@NonNull View view) {
        int i10 = R.id.iv_arrow;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
        if (imageView != null) {
            i10 = R.id.iv_book_mark;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView2 != null) {
                i10 = R.id.ll_mark;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                if (linearLayout != null) {
                    i10 = R.id.tv_tips;
                    ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (readerThemeTextView != null) {
                        return new ReaderWidgetBookMarkHeaderBinding((ConstraintLayout) view, imageView, imageView2, linearLayout, readerThemeTextView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ReaderWidgetBookMarkHeaderBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReaderWidgetBookMarkHeaderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reader_widget_book_mark_header, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
