package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;
import com.martian.mibook.mvvm.widget.DotSeekBar;

/* loaded from: classes3.dex */
public final class FragmentAudioBookSpeedLayoutBinding implements ViewBinding {

    @NonNull
    private final RelativeLayout rootView;

    @NonNull
    public final DotSeekBar seekBar;

    @NonNull
    public final ThemeImageView timingWindowClose;

    @NonNull
    public final ThemeTextView tv05;

    @NonNull
    public final ThemeTextView tv10;

    @NonNull
    public final ThemeTextView tv15;

    @NonNull
    public final ThemeTextView tv20;

    @NonNull
    public final ThemeTextView tv25;

    @NonNull
    public final ThemeTextView tv30;

    @NonNull
    public final ThemeTextView tv35;

    @NonNull
    public final ThemeTextView tvClose;

    @NonNull
    public final ThemeTextView tvReset;

    @NonNull
    public final ThemeTextView tvSpeedTitle;

    private FragmentAudioBookSpeedLayoutBinding(@NonNull RelativeLayout relativeLayout, @NonNull DotSeekBar dotSeekBar, @NonNull ThemeImageView themeImageView, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeTextView themeTextView3, @NonNull ThemeTextView themeTextView4, @NonNull ThemeTextView themeTextView5, @NonNull ThemeTextView themeTextView6, @NonNull ThemeTextView themeTextView7, @NonNull ThemeTextView themeTextView8, @NonNull ThemeTextView themeTextView9, @NonNull ThemeTextView themeTextView10) {
        this.rootView = relativeLayout;
        this.seekBar = dotSeekBar;
        this.timingWindowClose = themeImageView;
        this.tv05 = themeTextView;
        this.tv10 = themeTextView2;
        this.tv15 = themeTextView3;
        this.tv20 = themeTextView4;
        this.tv25 = themeTextView5;
        this.tv30 = themeTextView6;
        this.tv35 = themeTextView7;
        this.tvClose = themeTextView8;
        this.tvReset = themeTextView9;
        this.tvSpeedTitle = themeTextView10;
    }

    @NonNull
    public static FragmentAudioBookSpeedLayoutBinding bind(@NonNull View view) {
        int i10 = R.id.seekBar;
        DotSeekBar dotSeekBar = (DotSeekBar) ViewBindings.findChildViewById(view, i10);
        if (dotSeekBar != null) {
            i10 = R.id.timing_window_close;
            ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
            if (themeImageView != null) {
                i10 = R.id.tv_05;
                ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView != null) {
                    i10 = R.id.tv_10;
                    ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (themeTextView2 != null) {
                        i10 = R.id.tv_15;
                        ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView3 != null) {
                            i10 = R.id.tv_20;
                            ThemeTextView themeTextView4 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                            if (themeTextView4 != null) {
                                i10 = R.id.tv_25;
                                ThemeTextView themeTextView5 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                if (themeTextView5 != null) {
                                    i10 = R.id.tv_30;
                                    ThemeTextView themeTextView6 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                    if (themeTextView6 != null) {
                                        i10 = R.id.tv_35;
                                        ThemeTextView themeTextView7 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                        if (themeTextView7 != null) {
                                            i10 = R.id.tv_close;
                                            ThemeTextView themeTextView8 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                            if (themeTextView8 != null) {
                                                i10 = R.id.tv_reset;
                                                ThemeTextView themeTextView9 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                if (themeTextView9 != null) {
                                                    i10 = R.id.tv_speed_title;
                                                    ThemeTextView themeTextView10 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                    if (themeTextView10 != null) {
                                                        return new FragmentAudioBookSpeedLayoutBinding((RelativeLayout) view, dotSeekBar, themeImageView, themeTextView, themeTextView2, themeTextView3, themeTextView4, themeTextView5, themeTextView6, themeTextView7, themeTextView8, themeTextView9, themeTextView10);
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
    public static FragmentAudioBookSpeedLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentAudioBookSpeedLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.fragment_audio_book_speed_layout, viewGroup, false);
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
