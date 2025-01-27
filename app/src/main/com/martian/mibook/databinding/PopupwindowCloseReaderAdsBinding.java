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
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeItemTextView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class PopupwindowCloseReaderAdsBinding implements ViewBinding {

    @NonNull
    public final ReaderThemeImageView closeAdsCancel;

    @NonNull
    public final ReaderThemeTextView closeAdsTitle;

    @NonNull
    public final ReaderThemeItemTextView closeAdsVideo;

    @NonNull
    public final ReaderThemeLinearLayout closeAdsView;

    @NonNull
    public final ReaderThemeItemTextView openVipMember;

    @NonNull
    private final RelativeLayout rootView;

    private PopupwindowCloseReaderAdsBinding(@NonNull RelativeLayout relativeLayout, @NonNull ReaderThemeImageView readerThemeImageView, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeItemTextView readerThemeItemTextView, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout, @NonNull ReaderThemeItemTextView readerThemeItemTextView2) {
        this.rootView = relativeLayout;
        this.closeAdsCancel = readerThemeImageView;
        this.closeAdsTitle = readerThemeTextView;
        this.closeAdsVideo = readerThemeItemTextView;
        this.closeAdsView = readerThemeLinearLayout;
        this.openVipMember = readerThemeItemTextView2;
    }

    @NonNull
    public static PopupwindowCloseReaderAdsBinding bind(@NonNull View view) {
        int i10 = R.id.close_ads_cancel;
        ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (readerThemeImageView != null) {
            i10 = R.id.close_ads_title;
            ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (readerThemeTextView != null) {
                i10 = R.id.close_ads_video;
                ReaderThemeItemTextView readerThemeItemTextView = (ReaderThemeItemTextView) ViewBindings.findChildViewById(view, i10);
                if (readerThemeItemTextView != null) {
                    i10 = R.id.close_ads_view;
                    ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                    if (readerThemeLinearLayout != null) {
                        i10 = R.id.open_vip_member;
                        ReaderThemeItemTextView readerThemeItemTextView2 = (ReaderThemeItemTextView) ViewBindings.findChildViewById(view, i10);
                        if (readerThemeItemTextView2 != null) {
                            return new PopupwindowCloseReaderAdsBinding((RelativeLayout) view, readerThemeImageView, readerThemeTextView, readerThemeItemTextView, readerThemeLinearLayout, readerThemeItemTextView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static PopupwindowCloseReaderAdsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static PopupwindowCloseReaderAdsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.popupwindow_close_reader_ads, viewGroup, false);
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
