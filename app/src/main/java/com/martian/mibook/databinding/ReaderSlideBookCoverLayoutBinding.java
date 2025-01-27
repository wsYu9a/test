package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.mibook.R;
import com.martian.mibook.mvvm.read.widget.ReaderBookCoverLayout;

/* loaded from: classes3.dex */
public final class ReaderSlideBookCoverLayoutBinding implements ViewBinding {

    @NonNull
    private final ReaderBookCoverLayout rootView;

    private ReaderSlideBookCoverLayoutBinding(@NonNull ReaderBookCoverLayout readerBookCoverLayout) {
        this.rootView = readerBookCoverLayout;
    }

    @NonNull
    public static ReaderSlideBookCoverLayoutBinding bind(@NonNull View view) {
        if (view != null) {
            return new ReaderSlideBookCoverLayoutBinding((ReaderBookCoverLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static ReaderSlideBookCoverLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReaderSlideBookCoverLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reader_slide_book_cover_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ReaderBookCoverLayout getRoot() {
        return this.rootView;
    }
}
