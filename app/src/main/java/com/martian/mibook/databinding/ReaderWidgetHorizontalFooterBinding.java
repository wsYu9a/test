package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderBrokenLineView;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class ReaderWidgetHorizontalFooterBinding implements ViewBinding {

    @NonNull
    public final ReaderBrokenLineView brokenLine;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final ReaderThemeTextView tvTips;

    private ReaderWidgetHorizontalFooterBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ReaderBrokenLineView readerBrokenLineView, @NonNull ReaderThemeTextView readerThemeTextView) {
        this.rootView = constraintLayout;
        this.brokenLine = readerBrokenLineView;
        this.tvTips = readerThemeTextView;
    }

    @NonNull
    public static ReaderWidgetHorizontalFooterBinding bind(@NonNull View view) {
        int i10 = R.id.broken_line;
        ReaderBrokenLineView readerBrokenLineView = (ReaderBrokenLineView) ViewBindings.findChildViewById(view, i10);
        if (readerBrokenLineView != null) {
            i10 = R.id.tv_tips;
            ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (readerThemeTextView != null) {
                return new ReaderWidgetHorizontalFooterBinding((ConstraintLayout) view, readerBrokenLineView, readerThemeTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ReaderWidgetHorizontalFooterBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReaderWidgetHorizontalFooterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reader_widget_horizontal_footer, viewGroup, false);
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
