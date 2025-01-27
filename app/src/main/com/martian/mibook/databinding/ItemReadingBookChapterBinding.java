package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class ItemReadingBookChapterBinding implements ViewBinding {

    @NonNull
    public final ImageView ivChapterPosition;

    @NonNull
    private final LinearLayout rootView;

    @NonNull
    public final ReaderThemeTextView tvChapterStatus;

    @NonNull
    public final ReaderThemeTextView tvChapterTitle;

    @NonNull
    public final LinearLayout tvChapterView;

    private ItemReadingBookChapterBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.ivChapterPosition = imageView;
        this.tvChapterStatus = readerThemeTextView;
        this.tvChapterTitle = readerThemeTextView2;
        this.tvChapterView = linearLayout2;
    }

    @NonNull
    public static ItemReadingBookChapterBinding bind(@NonNull View view) {
        int i10 = R.id.iv_chapter_position;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
        if (imageView != null) {
            i10 = R.id.tv_chapter_status;
            ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (readerThemeTextView != null) {
                i10 = R.id.tv_chapter_title;
                ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (readerThemeTextView2 != null) {
                    LinearLayout linearLayout = (LinearLayout) view;
                    return new ItemReadingBookChapterBinding(linearLayout, imageView, readerThemeTextView, readerThemeTextView2, linearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ItemReadingBookChapterBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemReadingBookChapterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_reading_book_chapter, viewGroup, false);
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
