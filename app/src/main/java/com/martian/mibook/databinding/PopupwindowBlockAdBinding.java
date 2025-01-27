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
public final class PopupwindowBlockAdBinding implements ViewBinding {

    @NonNull
    public final ReaderThemeImageView blockAdClose;

    @NonNull
    public final ReaderThemeTextView blockAdMinutes;

    @NonNull
    public final ReaderThemeTextView blockAdSeconds;

    @NonNull
    public final ReaderThemeTextView blockAdTitle;

    @NonNull
    public final ReaderThemeTextView blockAdVideo;

    @NonNull
    public final ReaderThemeLinearLayout blockAdVideoView;

    @NonNull
    public final ReaderThemeLinearLayout blockAdView;

    @NonNull
    public final RelativeLayout blockAdViewRoot;

    @NonNull
    public final ReaderThemeItemTextView blockAdVip;

    @NonNull
    private final RelativeLayout rootView;

    private PopupwindowBlockAdBinding(@NonNull RelativeLayout relativeLayout, @NonNull ReaderThemeImageView readerThemeImageView, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull ReaderThemeTextView readerThemeTextView3, @NonNull ReaderThemeTextView readerThemeTextView4, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout2, @NonNull RelativeLayout relativeLayout2, @NonNull ReaderThemeItemTextView readerThemeItemTextView) {
        this.rootView = relativeLayout;
        this.blockAdClose = readerThemeImageView;
        this.blockAdMinutes = readerThemeTextView;
        this.blockAdSeconds = readerThemeTextView2;
        this.blockAdTitle = readerThemeTextView3;
        this.blockAdVideo = readerThemeTextView4;
        this.blockAdVideoView = readerThemeLinearLayout;
        this.blockAdView = readerThemeLinearLayout2;
        this.blockAdViewRoot = relativeLayout2;
        this.blockAdVip = readerThemeItemTextView;
    }

    @NonNull
    public static PopupwindowBlockAdBinding bind(@NonNull View view) {
        int i10 = R.id.block_ad_close;
        ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (readerThemeImageView != null) {
            i10 = R.id.block_ad_minutes;
            ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (readerThemeTextView != null) {
                i10 = R.id.block_ad_seconds;
                ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (readerThemeTextView2 != null) {
                    i10 = R.id.block_ad_title;
                    ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (readerThemeTextView3 != null) {
                        i10 = R.id.block_ad_video;
                        ReaderThemeTextView readerThemeTextView4 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (readerThemeTextView4 != null) {
                            i10 = R.id.block_ad_video_view;
                            ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                            if (readerThemeLinearLayout != null) {
                                i10 = R.id.block_ad_view;
                                ReaderThemeLinearLayout readerThemeLinearLayout2 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                if (readerThemeLinearLayout2 != null) {
                                    RelativeLayout relativeLayout = (RelativeLayout) view;
                                    i10 = R.id.block_ad_vip;
                                    ReaderThemeItemTextView readerThemeItemTextView = (ReaderThemeItemTextView) ViewBindings.findChildViewById(view, i10);
                                    if (readerThemeItemTextView != null) {
                                        return new PopupwindowBlockAdBinding(relativeLayout, readerThemeImageView, readerThemeTextView, readerThemeTextView2, readerThemeTextView3, readerThemeTextView4, readerThemeLinearLayout, readerThemeLinearLayout2, relativeLayout, readerThemeItemTextView);
                                    }
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
    public static PopupwindowBlockAdBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static PopupwindowBlockAdBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.popupwindow_block_ad, viewGroup, false);
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
