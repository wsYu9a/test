package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeProgressBar;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class ReadingBottomStatusBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout batteryView;

    @NonNull
    public final LinearLayout llBottomStatusContent;

    @NonNull
    public final ReaderThemeImageView rbsIvBattery;

    @NonNull
    public final ReaderThemeProgressBar rbsTvBattery;

    @NonNull
    public final ReaderThemeTextView rbsTvHint;

    @NonNull
    public final ReaderThemeTextView rbsTvRightContent;

    @NonNull
    public final ReaderThemeTextView rbsTvTime;

    @NonNull
    public final ReaderThemeImageView rivCharging;

    @NonNull
    private final LinearLayout rootView;

    private ReadingBottomStatusBinding(@NonNull LinearLayout linearLayout, @NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout2, @NonNull ReaderThemeImageView readerThemeImageView, @NonNull ReaderThemeProgressBar readerThemeProgressBar, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull ReaderThemeTextView readerThemeTextView3, @NonNull ReaderThemeImageView readerThemeImageView2) {
        this.rootView = linearLayout;
        this.batteryView = relativeLayout;
        this.llBottomStatusContent = linearLayout2;
        this.rbsIvBattery = readerThemeImageView;
        this.rbsTvBattery = readerThemeProgressBar;
        this.rbsTvHint = readerThemeTextView;
        this.rbsTvRightContent = readerThemeTextView2;
        this.rbsTvTime = readerThemeTextView3;
        this.rivCharging = readerThemeImageView2;
    }

    @NonNull
    public static ReadingBottomStatusBinding bind(@NonNull View view) {
        int i10 = R.id.battery_view;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
        if (relativeLayout != null) {
            i10 = R.id.ll_bottom_status_content;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
            if (linearLayout != null) {
                i10 = R.id.rbs_iv_battery;
                ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                if (readerThemeImageView != null) {
                    i10 = R.id.rbs_tv_battery;
                    ReaderThemeProgressBar readerThemeProgressBar = (ReaderThemeProgressBar) ViewBindings.findChildViewById(view, i10);
                    if (readerThemeProgressBar != null) {
                        i10 = R.id.rbs_tv_hint;
                        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (readerThemeTextView != null) {
                            i10 = R.id.rbs_tv_right_content;
                            ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                            if (readerThemeTextView2 != null) {
                                i10 = R.id.rbs_tv_time;
                                ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                if (readerThemeTextView3 != null) {
                                    i10 = R.id.riv_charging;
                                    ReaderThemeImageView readerThemeImageView2 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                                    if (readerThemeImageView2 != null) {
                                        return new ReadingBottomStatusBinding((LinearLayout) view, relativeLayout, linearLayout, readerThemeImageView, readerThemeProgressBar, readerThemeTextView, readerThemeTextView2, readerThemeTextView3, readerThemeImageView2);
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
    public static ReadingBottomStatusBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReadingBottomStatusBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reading_bottom_status, viewGroup, false);
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
