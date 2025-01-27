package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.widget.ScrollTabWidget;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeSeekBar;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class f6 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final CoordinatorLayout f11962a;

    /* renamed from: b */
    @NonNull
    public final ReaderThemeImageView f11963b;

    /* renamed from: c */
    @NonNull
    public final ReaderThemeLinearLayout f11964c;

    /* renamed from: d */
    @NonNull
    public final ReaderThemeLinearLayout f11965d;

    /* renamed from: e */
    @NonNull
    public final ReaderThemeTextView f11966e;

    /* renamed from: f */
    @NonNull
    public final ReaderThemeLinearLayout f11967f;

    /* renamed from: g */
    @NonNull
    public final ScrollTabWidget f11968g;

    /* renamed from: h */
    @NonNull
    public final ReaderThemeSeekBar f11969h;

    /* renamed from: i */
    @NonNull
    public final ReaderThemeImageView f11970i;

    /* renamed from: j */
    @NonNull
    public final ReaderThemeImageView f11971j;

    @NonNull
    public final ReaderThemeTextView k;

    private f6(@NonNull CoordinatorLayout rootView, @NonNull ReaderThemeImageView cbAutoBrightness, @NonNull ReaderThemeLinearLayout cbAutoBrightnessView, @NonNull ReaderThemeLinearLayout cbManualBrightnessView, @NonNull ReaderThemeTextView ivTypeface, @NonNull ReaderThemeLinearLayout ivTypefaceView, @NonNull ScrollTabWidget mtbReadingTheme, @NonNull ReaderThemeSeekBar sbBrightness, @NonNull ReaderThemeImageView sbBrightnessIncrease, @NonNull ReaderThemeImageView sbBrightnessReduce, @NonNull ReaderThemeTextView tvTextSize) {
        this.f11962a = rootView;
        this.f11963b = cbAutoBrightness;
        this.f11964c = cbAutoBrightnessView;
        this.f11965d = cbManualBrightnessView;
        this.f11966e = ivTypeface;
        this.f11967f = ivTypefaceView;
        this.f11968g = mtbReadingTheme;
        this.f11969h = sbBrightness;
        this.f11970i = sbBrightnessIncrease;
        this.f11971j = sbBrightnessReduce;
        this.k = tvTextSize;
    }

    @NonNull
    public static f6 a(@NonNull View rootView) {
        int i2 = R.id.cb_auto_brightness;
        ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) rootView.findViewById(R.id.cb_auto_brightness);
        if (readerThemeImageView != null) {
            i2 = R.id.cb_auto_brightness_view;
            ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) rootView.findViewById(R.id.cb_auto_brightness_view);
            if (readerThemeLinearLayout != null) {
                i2 = R.id.cb_manual_brightness_view;
                ReaderThemeLinearLayout readerThemeLinearLayout2 = (ReaderThemeLinearLayout) rootView.findViewById(R.id.cb_manual_brightness_view);
                if (readerThemeLinearLayout2 != null) {
                    i2 = R.id.iv_typeface;
                    ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.iv_typeface);
                    if (readerThemeTextView != null) {
                        i2 = R.id.iv_typeface_view;
                        ReaderThemeLinearLayout readerThemeLinearLayout3 = (ReaderThemeLinearLayout) rootView.findViewById(R.id.iv_typeface_view);
                        if (readerThemeLinearLayout3 != null) {
                            i2 = R.id.mtb_reading_theme;
                            ScrollTabWidget scrollTabWidget = (ScrollTabWidget) rootView.findViewById(R.id.mtb_reading_theme);
                            if (scrollTabWidget != null) {
                                i2 = R.id.sb_brightness;
                                ReaderThemeSeekBar readerThemeSeekBar = (ReaderThemeSeekBar) rootView.findViewById(R.id.sb_brightness);
                                if (readerThemeSeekBar != null) {
                                    i2 = R.id.sb_brightness_increase;
                                    ReaderThemeImageView readerThemeImageView2 = (ReaderThemeImageView) rootView.findViewById(R.id.sb_brightness_increase);
                                    if (readerThemeImageView2 != null) {
                                        i2 = R.id.sb_brightness_reduce;
                                        ReaderThemeImageView readerThemeImageView3 = (ReaderThemeImageView) rootView.findViewById(R.id.sb_brightness_reduce);
                                        if (readerThemeImageView3 != null) {
                                            i2 = R.id.tv_text_size;
                                            ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) rootView.findViewById(R.id.tv_text_size);
                                            if (readerThemeTextView2 != null) {
                                                return new f6((CoordinatorLayout) rootView, readerThemeImageView, readerThemeLinearLayout, readerThemeLinearLayout2, readerThemeTextView, readerThemeLinearLayout3, scrollTabWidget, readerThemeSeekBar, readerThemeImageView2, readerThemeImageView3, readerThemeTextView2);
                                            }
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
    public static f6 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static f6 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_page_setting, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public CoordinatorLayout getRoot() {
        return this.f11962a;
    }
}
