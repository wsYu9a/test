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
import com.martian.mibook.ui.reader.ReaderThemeItemTextView;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class LoadingBookActiveBinding implements ViewBinding {

    @NonNull
    private final LinearLayout rootView;

    @NonNull
    public final ReaderThemeTextView tvActiveReadingBookName;

    @NonNull
    public final ReaderThemeTextView tvActiveReadingContent;

    @NonNull
    public final ReaderThemeItemTextView tvActiveReadingPurchaseVideo;

    @NonNull
    public final ReaderThemeTextView tvActiveReadingTitle;

    @NonNull
    public final LinearLayout tvActiveReadingTitleView;

    @NonNull
    public final ReaderThemeItemTextView tvActiveReadingVip;

    private LoadingBookActiveBinding(@NonNull LinearLayout linearLayout, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull ReaderThemeItemTextView readerThemeItemTextView, @NonNull ReaderThemeTextView readerThemeTextView3, @NonNull LinearLayout linearLayout2, @NonNull ReaderThemeItemTextView readerThemeItemTextView2) {
        this.rootView = linearLayout;
        this.tvActiveReadingBookName = readerThemeTextView;
        this.tvActiveReadingContent = readerThemeTextView2;
        this.tvActiveReadingPurchaseVideo = readerThemeItemTextView;
        this.tvActiveReadingTitle = readerThemeTextView3;
        this.tvActiveReadingTitleView = linearLayout2;
        this.tvActiveReadingVip = readerThemeItemTextView2;
    }

    @NonNull
    public static LoadingBookActiveBinding bind(@NonNull View view) {
        int i10 = R.id.tv_active_reading_book_name;
        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (readerThemeTextView != null) {
            i10 = R.id.tv_active_reading_content;
            ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (readerThemeTextView2 != null) {
                i10 = R.id.tv_active_reading_purchase_video;
                ReaderThemeItemTextView readerThemeItemTextView = (ReaderThemeItemTextView) ViewBindings.findChildViewById(view, i10);
                if (readerThemeItemTextView != null) {
                    i10 = R.id.tv_active_reading_title;
                    ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (readerThemeTextView3 != null) {
                        i10 = R.id.tv_active_reading_title_view;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                        if (linearLayout != null) {
                            i10 = R.id.tv_active_reading_vip;
                            ReaderThemeItemTextView readerThemeItemTextView2 = (ReaderThemeItemTextView) ViewBindings.findChildViewById(view, i10);
                            if (readerThemeItemTextView2 != null) {
                                return new LoadingBookActiveBinding((LinearLayout) view, readerThemeTextView, readerThemeTextView2, readerThemeItemTextView, readerThemeTextView3, linearLayout, readerThemeItemTextView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static LoadingBookActiveBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static LoadingBookActiveBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.loading_book_active, viewGroup, false);
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
