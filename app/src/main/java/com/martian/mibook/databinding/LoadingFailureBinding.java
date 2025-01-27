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
public final class LoadingFailureBinding implements ViewBinding {

    @NonNull
    private final LinearLayout rootView;

    @NonNull
    public final ReaderThemeItemTextView tvChapterFeedback;

    @NonNull
    public final ReaderThemeTextView tvErrorMsg;

    @NonNull
    public final ReaderThemeTextView tvFailBookName;

    @NonNull
    public final LinearLayout tvFailTitleView;

    @NonNull
    public final ReaderThemeTextView tvFailingReadingTitle;

    @NonNull
    public final ReaderThemeItemTextView tvFeedback;

    @NonNull
    public final ReaderThemeItemTextView tvRefresh;

    private LoadingFailureBinding(@NonNull LinearLayout linearLayout, @NonNull ReaderThemeItemTextView readerThemeItemTextView, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull LinearLayout linearLayout2, @NonNull ReaderThemeTextView readerThemeTextView3, @NonNull ReaderThemeItemTextView readerThemeItemTextView2, @NonNull ReaderThemeItemTextView readerThemeItemTextView3) {
        this.rootView = linearLayout;
        this.tvChapterFeedback = readerThemeItemTextView;
        this.tvErrorMsg = readerThemeTextView;
        this.tvFailBookName = readerThemeTextView2;
        this.tvFailTitleView = linearLayout2;
        this.tvFailingReadingTitle = readerThemeTextView3;
        this.tvFeedback = readerThemeItemTextView2;
        this.tvRefresh = readerThemeItemTextView3;
    }

    @NonNull
    public static LoadingFailureBinding bind(@NonNull View view) {
        int i10 = R.id.tv_chapter_feedback;
        ReaderThemeItemTextView readerThemeItemTextView = (ReaderThemeItemTextView) ViewBindings.findChildViewById(view, i10);
        if (readerThemeItemTextView != null) {
            i10 = R.id.tv_error_msg;
            ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (readerThemeTextView != null) {
                i10 = R.id.tv_fail_book_name;
                ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (readerThemeTextView2 != null) {
                    i10 = R.id.tv_fail_title_view;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                    if (linearLayout != null) {
                        i10 = R.id.tv_failing_reading_title;
                        ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (readerThemeTextView3 != null) {
                            i10 = R.id.tv_feedback;
                            ReaderThemeItemTextView readerThemeItemTextView2 = (ReaderThemeItemTextView) ViewBindings.findChildViewById(view, i10);
                            if (readerThemeItemTextView2 != null) {
                                i10 = R.id.tv_refresh;
                                ReaderThemeItemTextView readerThemeItemTextView3 = (ReaderThemeItemTextView) ViewBindings.findChildViewById(view, i10);
                                if (readerThemeItemTextView3 != null) {
                                    return new LoadingFailureBinding((LinearLayout) view, readerThemeItemTextView, readerThemeTextView, readerThemeTextView2, linearLayout, readerThemeTextView3, readerThemeItemTextView2, readerThemeItemTextView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static LoadingFailureBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static LoadingFailureBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.loading_failure, viewGroup, false);
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
