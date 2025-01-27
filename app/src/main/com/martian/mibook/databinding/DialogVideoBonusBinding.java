package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.apptask.widget.CountdownNumberTextView;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderThemeItemTextView;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class DialogVideoBonusBinding implements ViewBinding {

    @NonNull
    public final ReaderThemeItemTextView btOperate;

    @NonNull
    private final View rootView;

    @NonNull
    public final ReaderThemeItemTextView videoAdsClose;

    @Nullable
    public final CountdownNumberTextView videoAdsCountdown;

    @NonNull
    public final ReaderThemeTextView videoAdsDesc;

    @NonNull
    public final ReaderThemeTextView videoAdsGrab;

    @NonNull
    public final ReaderThemeTextView videoAdsHint;

    @Nullable
    public final RoundedLayout videoAdsLayout;

    @NonNull
    public final ReaderThemeTextView videoAdsMinutes;

    private DialogVideoBonusBinding(@NonNull View view, @NonNull ReaderThemeItemTextView readerThemeItemTextView, @NonNull ReaderThemeItemTextView readerThemeItemTextView2, @Nullable CountdownNumberTextView countdownNumberTextView, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull ReaderThemeTextView readerThemeTextView3, @Nullable RoundedLayout roundedLayout, @NonNull ReaderThemeTextView readerThemeTextView4) {
        this.rootView = view;
        this.btOperate = readerThemeItemTextView;
        this.videoAdsClose = readerThemeItemTextView2;
        this.videoAdsCountdown = countdownNumberTextView;
        this.videoAdsDesc = readerThemeTextView;
        this.videoAdsGrab = readerThemeTextView2;
        this.videoAdsHint = readerThemeTextView3;
        this.videoAdsLayout = roundedLayout;
        this.videoAdsMinutes = readerThemeTextView4;
    }

    @NonNull
    public static DialogVideoBonusBinding bind(@NonNull View view) {
        int i10 = R.id.bt_operate;
        ReaderThemeItemTextView readerThemeItemTextView = (ReaderThemeItemTextView) ViewBindings.findChildViewById(view, i10);
        if (readerThemeItemTextView != null) {
            i10 = R.id.video_ads_close;
            ReaderThemeItemTextView readerThemeItemTextView2 = (ReaderThemeItemTextView) ViewBindings.findChildViewById(view, i10);
            if (readerThemeItemTextView2 != null) {
                CountdownNumberTextView countdownNumberTextView = (CountdownNumberTextView) ViewBindings.findChildViewById(view, R.id.video_ads_countdown);
                i10 = R.id.video_ads_desc;
                ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (readerThemeTextView != null) {
                    i10 = R.id.video_ads_grab;
                    ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (readerThemeTextView2 != null) {
                        i10 = R.id.video_ads_hint;
                        ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (readerThemeTextView3 != null) {
                            RoundedLayout roundedLayout = (RoundedLayout) ViewBindings.findChildViewById(view, R.id.video_ads_layout);
                            i10 = R.id.video_ads_minutes;
                            ReaderThemeTextView readerThemeTextView4 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                            if (readerThemeTextView4 != null) {
                                return new DialogVideoBonusBinding(view, readerThemeItemTextView, readerThemeItemTextView2, countdownNumberTextView, readerThemeTextView, readerThemeTextView2, readerThemeTextView3, roundedLayout, readerThemeTextView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static DialogVideoBonusBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.rootView;
    }

    @NonNull
    public static DialogVideoBonusBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.dialog_video_bonus, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }
}
