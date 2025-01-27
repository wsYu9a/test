package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeSeekBar;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class p5 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12527a;

    /* renamed from: b */
    @NonNull
    public final ReaderThemeImageView f12528b;

    /* renamed from: c */
    @NonNull
    public final ReaderThemeSeekBar f12529c;

    /* renamed from: d */
    @NonNull
    public final ReaderThemeImageView f12530d;

    /* renamed from: e */
    @NonNull
    public final ReaderThemeTextView f12531e;

    /* renamed from: f */
    @NonNull
    public final ReaderThemeImageView f12532f;

    private p5(@NonNull LinearLayout rootView, @NonNull ReaderThemeImageView autoSlidingDown, @NonNull ReaderThemeSeekBar autoSlidingRate, @NonNull ReaderThemeImageView autoSlidingUp, @NonNull ReaderThemeTextView closeAdsTitle, @NonNull ReaderThemeImageView windowClose) {
        this.f12527a = rootView;
        this.f12528b = autoSlidingDown;
        this.f12529c = autoSlidingRate;
        this.f12530d = autoSlidingUp;
        this.f12531e = closeAdsTitle;
        this.f12532f = windowClose;
    }

    @NonNull
    public static p5 a(@NonNull View rootView) {
        int i2 = R.id.auto_sliding_down;
        ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) rootView.findViewById(R.id.auto_sliding_down);
        if (readerThemeImageView != null) {
            i2 = R.id.auto_sliding_rate;
            ReaderThemeSeekBar readerThemeSeekBar = (ReaderThemeSeekBar) rootView.findViewById(R.id.auto_sliding_rate);
            if (readerThemeSeekBar != null) {
                i2 = R.id.auto_sliding_up;
                ReaderThemeImageView readerThemeImageView2 = (ReaderThemeImageView) rootView.findViewById(R.id.auto_sliding_up);
                if (readerThemeImageView2 != null) {
                    i2 = R.id.close_ads_title;
                    ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.close_ads_title);
                    if (readerThemeTextView != null) {
                        i2 = R.id.window_close;
                        ReaderThemeImageView readerThemeImageView3 = (ReaderThemeImageView) rootView.findViewById(R.id.window_close);
                        if (readerThemeImageView3 != null) {
                            return new p5((LinearLayout) rootView, readerThemeImageView, readerThemeSeekBar, readerThemeImageView2, readerThemeTextView, readerThemeImageView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static p5 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static p5 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_auto_sliding, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12527a;
    }
}
