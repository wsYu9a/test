package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.mibook.R;
import com.martian.mibook.mvvm.read.widget.ReaderLoadingTip;
import com.martian.mibook.ui.reader.ReaderThemeImageView;

/* loaded from: classes3.dex */
public final class ReadingErrorViewBinding implements ViewBinding {

    @NonNull
    public final ReaderLoadingTip readerLoadingTip;

    @NonNull
    public final ReaderThemeImageView readingErrorBack;

    @NonNull
    private final RelativeLayout rootView;

    private ReadingErrorViewBinding(@NonNull RelativeLayout relativeLayout, @NonNull ReaderLoadingTip readerLoadingTip, @NonNull ReaderThemeImageView readerThemeImageView) {
        this.rootView = relativeLayout;
        this.readerLoadingTip = readerLoadingTip;
        this.readingErrorBack = readerThemeImageView;
    }

    @NonNull
    public static ReadingErrorViewBinding bind(@NonNull View view) {
        int i10 = R.id.reader_loading_tip;
        ReaderLoadingTip readerLoadingTip = (ReaderLoadingTip) ViewBindings.findChildViewById(view, i10);
        if (readerLoadingTip != null) {
            i10 = R.id.reading_error_back;
            ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
            if (readerThemeImageView != null) {
                return new ReadingErrorViewBinding((RelativeLayout) view, readerLoadingTip, readerThemeImageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ReadingErrorViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReadingErrorViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reading_error_view, viewGroup, false);
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
