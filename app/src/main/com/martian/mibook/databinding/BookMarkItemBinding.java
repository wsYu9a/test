package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class BookMarkItemBinding implements ViewBinding {

    @NonNull
    private final LinearLayout rootView;

    @NonNull
    public final ReaderThemeTextView tvChapterTitle;

    @NonNull
    public final ReaderThemeTextView tvDimiPercent;

    @NonNull
    public final ReaderThemeTextView tvMarkTime;

    @NonNull
    public final ReaderThemeTextView tvSummary;

    private BookMarkItemBinding(@NonNull LinearLayout linearLayout, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull ReaderThemeTextView readerThemeTextView3, @NonNull ReaderThemeTextView readerThemeTextView4) {
        this.rootView = linearLayout;
        this.tvChapterTitle = readerThemeTextView;
        this.tvDimiPercent = readerThemeTextView2;
        this.tvMarkTime = readerThemeTextView3;
        this.tvSummary = readerThemeTextView4;
    }

    @NonNull
    public static BookMarkItemBinding bind(@NonNull View view) {
        int i10 = R.id.tv_chapter_title;
        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (readerThemeTextView != null) {
            i10 = R.id.tv_dimi_percent;
            ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (readerThemeTextView2 != null) {
                i10 = R.id.tv_mark_time;
                ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (readerThemeTextView3 != null) {
                    i10 = R.id.tv_summary;
                    ReaderThemeTextView readerThemeTextView4 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (readerThemeTextView4 != null) {
                        return new BookMarkItemBinding((LinearLayout) view, readerThemeTextView, readerThemeTextView2, readerThemeTextView3, readerThemeTextView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static BookMarkItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static BookMarkItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.book_mark_item, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
