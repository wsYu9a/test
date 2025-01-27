package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.mibook.ui.IntervalCountdownTextView;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeItemTextView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeSeekBar;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class p6 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12533a;

    /* renamed from: b */
    @NonNull
    public final ReaderThemeTextView f12534b;

    /* renamed from: c */
    @NonNull
    public final ReaderThemeItemTextView f12535c;

    /* renamed from: d */
    @NonNull
    public final ReaderThemeLinearLayout f12536d;

    /* renamed from: e */
    @NonNull
    public final ReaderThemeSeekBar f12537e;

    /* renamed from: f */
    @NonNull
    public final ReaderThemeImageView f12538f;

    /* renamed from: g */
    @NonNull
    public final ReaderThemeImageView f12539g;

    /* renamed from: h */
    @NonNull
    public final ReaderThemeImageView f12540h;

    /* renamed from: i */
    @NonNull
    public final IntervalCountdownTextView f12541i;

    /* renamed from: j */
    @NonNull
    public final ReaderThemeImageView f12542j;

    private p6(@NonNull LinearLayout rootView, @NonNull ReaderThemeTextView closeAdsTitle, @NonNull ReaderThemeItemTextView sbTtsNotification, @NonNull ReaderThemeLinearLayout sbTtsNotificationView, @NonNull ReaderThemeSeekBar sbTtsSpeakRate, @NonNull ReaderThemeImageView ttsPlayIcon, @NonNull ReaderThemeImageView ttsPlayNext, @NonNull ReaderThemeImageView ttsPlayPre, @NonNull IntervalCountdownTextView ttsTimerCountdown, @NonNull ReaderThemeImageView windowClose) {
        this.f12533a = rootView;
        this.f12534b = closeAdsTitle;
        this.f12535c = sbTtsNotification;
        this.f12536d = sbTtsNotificationView;
        this.f12537e = sbTtsSpeakRate;
        this.f12538f = ttsPlayIcon;
        this.f12539g = ttsPlayNext;
        this.f12540h = ttsPlayPre;
        this.f12541i = ttsTimerCountdown;
        this.f12542j = windowClose;
    }

    @NonNull
    public static p6 a(@NonNull View rootView) {
        int i2 = R.id.close_ads_title;
        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.close_ads_title);
        if (readerThemeTextView != null) {
            i2 = R.id.sb_tts_notification;
            ReaderThemeItemTextView readerThemeItemTextView = (ReaderThemeItemTextView) rootView.findViewById(R.id.sb_tts_notification);
            if (readerThemeItemTextView != null) {
                i2 = R.id.sb_tts_notification_view;
                ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) rootView.findViewById(R.id.sb_tts_notification_view);
                if (readerThemeLinearLayout != null) {
                    i2 = R.id.sb_tts_speak_rate;
                    ReaderThemeSeekBar readerThemeSeekBar = (ReaderThemeSeekBar) rootView.findViewById(R.id.sb_tts_speak_rate);
                    if (readerThemeSeekBar != null) {
                        i2 = R.id.tts_play_icon;
                        ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) rootView.findViewById(R.id.tts_play_icon);
                        if (readerThemeImageView != null) {
                            i2 = R.id.tts_play_next;
                            ReaderThemeImageView readerThemeImageView2 = (ReaderThemeImageView) rootView.findViewById(R.id.tts_play_next);
                            if (readerThemeImageView2 != null) {
                                i2 = R.id.tts_play_pre;
                                ReaderThemeImageView readerThemeImageView3 = (ReaderThemeImageView) rootView.findViewById(R.id.tts_play_pre);
                                if (readerThemeImageView3 != null) {
                                    i2 = R.id.tts_timer_countdown;
                                    IntervalCountdownTextView intervalCountdownTextView = (IntervalCountdownTextView) rootView.findViewById(R.id.tts_timer_countdown);
                                    if (intervalCountdownTextView != null) {
                                        i2 = R.id.window_close;
                                        ReaderThemeImageView readerThemeImageView4 = (ReaderThemeImageView) rootView.findViewById(R.id.window_close);
                                        if (readerThemeImageView4 != null) {
                                            return new p6((LinearLayout) rootView, readerThemeTextView, readerThemeItemTextView, readerThemeLinearLayout, readerThemeSeekBar, readerThemeImageView, readerThemeImageView2, readerThemeImageView3, intervalCountdownTextView, readerThemeImageView4);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static p6 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static p6 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_tts_setting, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12533a;
    }
}
