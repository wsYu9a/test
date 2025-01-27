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
public final class ReaderLoadingTipBinding implements ViewBinding {

    @NonNull
    public final ReaderThemeItemTextView btOperate;

    @NonNull
    public final LinearLayout llLoading;

    @NonNull
    private final LinearLayout rootView;

    @NonNull
    public final ReaderThemeTextView tvLoadingText;

    @NonNull
    public final ReaderThemeTextView tvTips;

    @NonNull
    public final ReaderThemeTextView tvTipsRetryHint;

    private ReaderLoadingTipBinding(@NonNull LinearLayout linearLayout, @NonNull ReaderThemeItemTextView readerThemeItemTextView, @NonNull LinearLayout linearLayout2, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull ReaderThemeTextView readerThemeTextView3) {
        this.rootView = linearLayout;
        this.btOperate = readerThemeItemTextView;
        this.llLoading = linearLayout2;
        this.tvLoadingText = readerThemeTextView;
        this.tvTips = readerThemeTextView2;
        this.tvTipsRetryHint = readerThemeTextView3;
    }

    @NonNull
    public static ReaderLoadingTipBinding bind(@NonNull View view) {
        int i10 = R.id.bt_operate;
        ReaderThemeItemTextView readerThemeItemTextView = (ReaderThemeItemTextView) ViewBindings.findChildViewById(view, i10);
        if (readerThemeItemTextView != null) {
            i10 = R.id.ll_loading;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
            if (linearLayout != null) {
                i10 = R.id.tv_loading_text;
                ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (readerThemeTextView != null) {
                    i10 = R.id.tv_tips;
                    ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (readerThemeTextView2 != null) {
                        i10 = R.id.tv_tips_retry_hint;
                        ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (readerThemeTextView3 != null) {
                            return new ReaderLoadingTipBinding((LinearLayout) view, readerThemeItemTextView, linearLayout, readerThemeTextView, readerThemeTextView2, readerThemeTextView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ReaderLoadingTipBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReaderLoadingTipBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reader_loading_tip, viewGroup, false);
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
