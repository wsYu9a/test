package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeProgressBar;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class u5 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12791a;

    /* renamed from: b */
    @NonNull
    public final RelativeLayout f12792b;

    /* renamed from: c */
    @NonNull
    public final ReaderThemeImageView f12793c;

    /* renamed from: d */
    @NonNull
    public final ReaderThemeProgressBar f12794d;

    /* renamed from: e */
    @NonNull
    public final ReaderThemeTextView f12795e;

    /* renamed from: f */
    @NonNull
    public final ReaderThemeTextView f12796f;

    /* renamed from: g */
    @NonNull
    public final ReaderThemeTextView f12797g;

    private u5(@NonNull LinearLayout rootView, @NonNull RelativeLayout batteryView, @NonNull ReaderThemeImageView rbsIvBattery, @NonNull ReaderThemeProgressBar rbsTvBattery, @NonNull ReaderThemeTextView rbsTvHint, @NonNull ReaderThemeTextView rbsTvLeftContent, @NonNull ReaderThemeTextView rbsTvTime) {
        this.f12791a = rootView;
        this.f12792b = batteryView;
        this.f12793c = rbsIvBattery;
        this.f12794d = rbsTvBattery;
        this.f12795e = rbsTvHint;
        this.f12796f = rbsTvLeftContent;
        this.f12797g = rbsTvTime;
    }

    @NonNull
    public static u5 a(@NonNull View rootView) {
        int i2 = R.id.battery_view;
        RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.battery_view);
        if (relativeLayout != null) {
            i2 = R.id.rbs_iv_battery;
            ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) rootView.findViewById(R.id.rbs_iv_battery);
            if (readerThemeImageView != null) {
                i2 = R.id.rbs_tv_battery;
                ReaderThemeProgressBar readerThemeProgressBar = (ReaderThemeProgressBar) rootView.findViewById(R.id.rbs_tv_battery);
                if (readerThemeProgressBar != null) {
                    i2 = R.id.rbs_tv_hint;
                    ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.rbs_tv_hint);
                    if (readerThemeTextView != null) {
                        i2 = R.id.rbs_tv_left_content;
                        ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) rootView.findViewById(R.id.rbs_tv_left_content);
                        if (readerThemeTextView2 != null) {
                            i2 = R.id.rbs_tv_time;
                            ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) rootView.findViewById(R.id.rbs_tv_time);
                            if (readerThemeTextView3 != null) {
                                return new u5((LinearLayout) rootView, relativeLayout, readerThemeImageView, readerThemeProgressBar, readerThemeTextView, readerThemeTextView2, readerThemeTextView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static u5 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static u5 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_bottom_status, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12791a;
    }
}
