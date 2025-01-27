package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.apptask.widget.CountdownNumberTextView;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.ui.reader.ReaderThemeItemTextView;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class s2 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final View f12660a;

    /* renamed from: b */
    @NonNull
    public final ReaderThemeItemTextView f12661b;

    /* renamed from: c */
    @NonNull
    public final ReaderThemeItemTextView f12662c;

    /* renamed from: d */
    @Nullable
    public final CountdownNumberTextView f12663d;

    /* renamed from: e */
    @NonNull
    public final ReaderThemeTextView f12664e;

    /* renamed from: f */
    @NonNull
    public final ReaderThemeTextView f12665f;

    /* renamed from: g */
    @NonNull
    public final ReaderThemeTextView f12666g;

    /* renamed from: h */
    @Nullable
    public final RoundedLayout f12667h;

    /* renamed from: i */
    @NonNull
    public final ReaderThemeTextView f12668i;

    private s2(@NonNull View rootView, @NonNull ReaderThemeItemTextView btOperate, @NonNull ReaderThemeItemTextView videoAdsClose, @Nullable CountdownNumberTextView videoAdsCountdown, @NonNull ReaderThemeTextView videoAdsDesc, @NonNull ReaderThemeTextView videoAdsGrab, @NonNull ReaderThemeTextView videoAdsHint, @Nullable RoundedLayout videoAdsLayout, @NonNull ReaderThemeTextView videoAdsMinutes) {
        this.f12660a = rootView;
        this.f12661b = btOperate;
        this.f12662c = videoAdsClose;
        this.f12663d = videoAdsCountdown;
        this.f12664e = videoAdsDesc;
        this.f12665f = videoAdsGrab;
        this.f12666g = videoAdsHint;
        this.f12667h = videoAdsLayout;
        this.f12668i = videoAdsMinutes;
    }

    @NonNull
    public static s2 a(@NonNull View rootView) {
        int i2 = R.id.bt_operate;
        ReaderThemeItemTextView readerThemeItemTextView = (ReaderThemeItemTextView) rootView.findViewById(R.id.bt_operate);
        if (readerThemeItemTextView != null) {
            i2 = R.id.video_ads_close;
            ReaderThemeItemTextView readerThemeItemTextView2 = (ReaderThemeItemTextView) rootView.findViewById(R.id.video_ads_close);
            if (readerThemeItemTextView2 != null) {
                CountdownNumberTextView countdownNumberTextView = (CountdownNumberTextView) rootView.findViewById(R.id.video_ads_countdown);
                i2 = R.id.video_ads_desc;
                ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.video_ads_desc);
                if (readerThemeTextView != null) {
                    i2 = R.id.video_ads_grab;
                    ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) rootView.findViewById(R.id.video_ads_grab);
                    if (readerThemeTextView2 != null) {
                        i2 = R.id.video_ads_hint;
                        ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) rootView.findViewById(R.id.video_ads_hint);
                        if (readerThemeTextView3 != null) {
                            RoundedLayout roundedLayout = (RoundedLayout) rootView.findViewById(R.id.video_ads_layout);
                            i2 = R.id.video_ads_minutes;
                            ReaderThemeTextView readerThemeTextView4 = (ReaderThemeTextView) rootView.findViewById(R.id.video_ads_minutes);
                            if (readerThemeTextView4 != null) {
                                return new s2(rootView, readerThemeItemTextView, readerThemeItemTextView2, countdownNumberTextView, readerThemeTextView, readerThemeTextView2, readerThemeTextView3, roundedLayout, readerThemeTextView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static s2 b(@NonNull LayoutInflater inflater) {
        return c(inflater, null, false);
    }

    @NonNull
    public static s2 c(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.dialog_video_bonus, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f12660a;
    }
}
