package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.mibook.R;
import com.martian.mibook.mvvm.read.widget.ReaderBookLastPageLayout;

/* loaded from: classes3.dex */
public final class ReaderSlideBookLastPageLayoutBinding implements ViewBinding {

    @NonNull
    private final ReaderBookLastPageLayout rootView;

    private ReaderSlideBookLastPageLayoutBinding(@NonNull ReaderBookLastPageLayout readerBookLastPageLayout) {
        this.rootView = readerBookLastPageLayout;
    }

    @NonNull
    public static ReaderSlideBookLastPageLayoutBinding bind(@NonNull View view) {
        if (view != null) {
            return new ReaderSlideBookLastPageLayoutBinding((ReaderBookLastPageLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static ReaderSlideBookLastPageLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReaderSlideBookLastPageLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reader_slide_book_last_page_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ReaderBookLastPageLayout getRoot() {
        return this.rootView;
    }
}
