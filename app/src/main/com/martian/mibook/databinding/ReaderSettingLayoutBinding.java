package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.libmars.widget.ScrollTabWidget;
import com.martian.mibook.R;
import com.martian.mibook.mvvm.read.widget.ReaderCircularContainerView;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeSeekBar;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class ReaderSettingLayoutBinding implements ViewBinding {

    @NonNull
    public final ReaderThemeImageView cbAutoBrightness;

    @NonNull
    public final ReaderThemeLinearLayout cbAutoBrightnessView;

    @NonNull
    public final ReaderThemeImageView cbMinimalistMode;

    @NonNull
    public final ReaderCircularContainerView ccvVip;

    @NonNull
    public final ImageView ivAutoSlideVip;

    @NonNull
    public final ReaderThemeImageView ivStartAutoSliding;

    @NonNull
    public final ReaderThemeTextView ivTypeface;

    @NonNull
    public final ReaderThemeLinearLayout ivTypefaceView;

    @NonNull
    public final ReaderThemeTextView lineSpaceSetting;

    @NonNull
    public final ReaderThemeLinearLayout llFontDown;

    @NonNull
    public final ReaderThemeLinearLayout llFontUp;

    @NonNull
    public final ReaderThemeLinearLayout llMinimalistMode;

    @NonNull
    public final ReaderThemeLinearLayout llMore;

    @NonNull
    public final ReaderThemeLinearLayout llStartAutoSlide;

    @NonNull
    public final ScrollTabWidget mtbReadingTheme;

    @NonNull
    private final RoundedLayout rootView;

    @NonNull
    public final ReaderThemeSeekBar sbBrightness;

    @NonNull
    public final ReaderThemeTextView slideModeSetting;

    @NonNull
    public final ReaderThemeTextView tvStartAutoSliding;

    @NonNull
    public final ReaderThemeTextView tvTextSize;

    @NonNull
    public final TextView tvThemeViewText;

    private ReaderSettingLayoutBinding(@NonNull RoundedLayout roundedLayout, @NonNull ReaderThemeImageView readerThemeImageView, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout, @NonNull ReaderThemeImageView readerThemeImageView2, @NonNull ReaderCircularContainerView readerCircularContainerView, @NonNull ImageView imageView, @NonNull ReaderThemeImageView readerThemeImageView3, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout2, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout3, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout4, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout5, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout6, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout7, @NonNull ScrollTabWidget scrollTabWidget, @NonNull ReaderThemeSeekBar readerThemeSeekBar, @NonNull ReaderThemeTextView readerThemeTextView3, @NonNull ReaderThemeTextView readerThemeTextView4, @NonNull ReaderThemeTextView readerThemeTextView5, @NonNull TextView textView) {
        this.rootView = roundedLayout;
        this.cbAutoBrightness = readerThemeImageView;
        this.cbAutoBrightnessView = readerThemeLinearLayout;
        this.cbMinimalistMode = readerThemeImageView2;
        this.ccvVip = readerCircularContainerView;
        this.ivAutoSlideVip = imageView;
        this.ivStartAutoSliding = readerThemeImageView3;
        this.ivTypeface = readerThemeTextView;
        this.ivTypefaceView = readerThemeLinearLayout2;
        this.lineSpaceSetting = readerThemeTextView2;
        this.llFontDown = readerThemeLinearLayout3;
        this.llFontUp = readerThemeLinearLayout4;
        this.llMinimalistMode = readerThemeLinearLayout5;
        this.llMore = readerThemeLinearLayout6;
        this.llStartAutoSlide = readerThemeLinearLayout7;
        this.mtbReadingTheme = scrollTabWidget;
        this.sbBrightness = readerThemeSeekBar;
        this.slideModeSetting = readerThemeTextView3;
        this.tvStartAutoSliding = readerThemeTextView4;
        this.tvTextSize = readerThemeTextView5;
        this.tvThemeViewText = textView;
    }

    @NonNull
    public static ReaderSettingLayoutBinding bind(@NonNull View view) {
        int i10 = R.id.cb_auto_brightness;
        ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (readerThemeImageView != null) {
            i10 = R.id.cb_auto_brightness_view;
            ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
            if (readerThemeLinearLayout != null) {
                i10 = R.id.cb_minimalist_mode;
                ReaderThemeImageView readerThemeImageView2 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                if (readerThemeImageView2 != null) {
                    i10 = R.id.ccv_vip;
                    ReaderCircularContainerView readerCircularContainerView = (ReaderCircularContainerView) ViewBindings.findChildViewById(view, i10);
                    if (readerCircularContainerView != null) {
                        i10 = R.id.iv_auto_slide_vip;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                        if (imageView != null) {
                            i10 = R.id.iv_start_auto_sliding;
                            ReaderThemeImageView readerThemeImageView3 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                            if (readerThemeImageView3 != null) {
                                i10 = R.id.iv_typeface;
                                ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                if (readerThemeTextView != null) {
                                    i10 = R.id.iv_typeface_view;
                                    ReaderThemeLinearLayout readerThemeLinearLayout2 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                    if (readerThemeLinearLayout2 != null) {
                                        i10 = R.id.line_space_setting;
                                        ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                        if (readerThemeTextView2 != null) {
                                            i10 = R.id.ll_font_down;
                                            ReaderThemeLinearLayout readerThemeLinearLayout3 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                            if (readerThemeLinearLayout3 != null) {
                                                i10 = R.id.ll_font_up;
                                                ReaderThemeLinearLayout readerThemeLinearLayout4 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                if (readerThemeLinearLayout4 != null) {
                                                    i10 = R.id.ll_minimalist_mode;
                                                    ReaderThemeLinearLayout readerThemeLinearLayout5 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                    if (readerThemeLinearLayout5 != null) {
                                                        i10 = R.id.ll_more;
                                                        ReaderThemeLinearLayout readerThemeLinearLayout6 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                        if (readerThemeLinearLayout6 != null) {
                                                            i10 = R.id.ll_start_auto_slide;
                                                            ReaderThemeLinearLayout readerThemeLinearLayout7 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                            if (readerThemeLinearLayout7 != null) {
                                                                i10 = R.id.mtb_reading_theme;
                                                                ScrollTabWidget scrollTabWidget = (ScrollTabWidget) ViewBindings.findChildViewById(view, i10);
                                                                if (scrollTabWidget != null) {
                                                                    i10 = R.id.sb_brightness;
                                                                    ReaderThemeSeekBar readerThemeSeekBar = (ReaderThemeSeekBar) ViewBindings.findChildViewById(view, i10);
                                                                    if (readerThemeSeekBar != null) {
                                                                        i10 = R.id.slide_mode_setting;
                                                                        ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                        if (readerThemeTextView3 != null) {
                                                                            i10 = R.id.tv_start_auto_sliding;
                                                                            ReaderThemeTextView readerThemeTextView4 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                            if (readerThemeTextView4 != null) {
                                                                                i10 = R.id.tv_text_size;
                                                                                ReaderThemeTextView readerThemeTextView5 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                if (readerThemeTextView5 != null) {
                                                                                    i10 = R.id.tv_theme_view_text;
                                                                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                                                                                    if (textView != null) {
                                                                                        return new ReaderSettingLayoutBinding((RoundedLayout) view, readerThemeImageView, readerThemeLinearLayout, readerThemeImageView2, readerCircularContainerView, imageView, readerThemeImageView3, readerThemeTextView, readerThemeLinearLayout2, readerThemeTextView2, readerThemeLinearLayout3, readerThemeLinearLayout4, readerThemeLinearLayout5, readerThemeLinearLayout6, readerThemeLinearLayout7, scrollTabWidget, readerThemeSeekBar, readerThemeTextView3, readerThemeTextView4, readerThemeTextView5, textView);
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ReaderSettingLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReaderSettingLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reader_setting_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public RoundedLayout getRoot() {
        return this.rootView;
    }
}
