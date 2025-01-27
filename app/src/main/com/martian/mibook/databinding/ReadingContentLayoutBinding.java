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
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.mibook.ui.reader.page.ReaderPageView;

/* loaded from: classes3.dex */
public final class ReadingContentLayoutBinding implements ViewBinding {

    @NonNull
    public final ReaderThemeImageView ivReadingBack;

    @NonNull
    public final LinearLayout llReadingContent;

    @NonNull
    private final LinearLayout rootView;

    @NonNull
    public final ReaderPageView rtvPage;

    @NonNull
    public final ReaderThemeTextView tvReadingTitle;

    @NonNull
    public final LinearLayout tvReadingTitleView;

    private ReadingContentLayoutBinding(@NonNull LinearLayout linearLayout, @NonNull ReaderThemeImageView readerThemeImageView, @NonNull LinearLayout linearLayout2, @NonNull ReaderPageView readerPageView, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull LinearLayout linearLayout3) {
        this.rootView = linearLayout;
        this.ivReadingBack = readerThemeImageView;
        this.llReadingContent = linearLayout2;
        this.rtvPage = readerPageView;
        this.tvReadingTitle = readerThemeTextView;
        this.tvReadingTitleView = linearLayout3;
    }

    @NonNull
    public static ReadingContentLayoutBinding bind(@NonNull View view) {
        int i10 = R.id.iv_reading_back;
        ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (readerThemeImageView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i10 = R.id.rtv_page;
            ReaderPageView readerPageView = (ReaderPageView) ViewBindings.findChildViewById(view, i10);
            if (readerPageView != null) {
                i10 = R.id.tv_reading_title;
                ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (readerThemeTextView != null) {
                    i10 = R.id.tv_reading_title_view;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                    if (linearLayout2 != null) {
                        return new ReadingContentLayoutBinding(linearLayout, readerThemeImageView, linearLayout, readerPageView, readerThemeTextView, linearLayout2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ReadingContentLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReadingContentLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reading_content_layout, viewGroup, false);
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
