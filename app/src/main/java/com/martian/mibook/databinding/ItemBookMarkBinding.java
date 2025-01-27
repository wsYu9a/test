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
import com.martian.mibook.mvvm.widget.UnderLineTextView;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class ItemBookMarkBinding implements ViewBinding {

    @NonNull
    public final ReaderThemeImageView ivMarkType;

    @NonNull
    private final LinearLayout rootView;

    @NonNull
    public final ReaderThemeTextView tvChapterTitle;

    @NonNull
    public final UnderLineTextView tvSummary;

    private ItemBookMarkBinding(@NonNull LinearLayout linearLayout, @NonNull ReaderThemeImageView readerThemeImageView, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull UnderLineTextView underLineTextView) {
        this.rootView = linearLayout;
        this.ivMarkType = readerThemeImageView;
        this.tvChapterTitle = readerThemeTextView;
        this.tvSummary = underLineTextView;
    }

    @NonNull
    public static ItemBookMarkBinding bind(@NonNull View view) {
        int i10 = R.id.iv_mark_type;
        ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (readerThemeImageView != null) {
            i10 = R.id.tv_chapter_title;
            ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (readerThemeTextView != null) {
                i10 = R.id.tv_summary;
                UnderLineTextView underLineTextView = (UnderLineTextView) ViewBindings.findChildViewById(view, i10);
                if (underLineTextView != null) {
                    return new ItemBookMarkBinding((LinearLayout) view, readerThemeImageView, readerThemeTextView, underLineTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ItemBookMarkBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemBookMarkBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_book_mark, viewGroup, false);
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
