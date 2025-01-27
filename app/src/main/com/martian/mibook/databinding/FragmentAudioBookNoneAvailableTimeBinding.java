package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class FragmentAudioBookNoneAvailableTimeBinding implements ViewBinding {

    @NonNull
    public final ThemeImageView ivClose;

    @NonNull
    public final ThemeLinearLayout llContent;

    @NonNull
    public final RelativeLayout rlShowAd;

    @NonNull
    private final RelativeLayout rootView;

    @NonNull
    public final TextView tvActivateVip;

    @NonNull
    public final ThemeTextView tvDes;

    @NonNull
    public final ThemeTextView tvShowAd;

    @NonNull
    public final ThemeTextView tvTitle;

    private FragmentAudioBookNoneAvailableTimeBinding(@NonNull RelativeLayout relativeLayout, @NonNull ThemeImageView themeImageView, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull RelativeLayout relativeLayout2, @NonNull TextView textView, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeTextView themeTextView3) {
        this.rootView = relativeLayout;
        this.ivClose = themeImageView;
        this.llContent = themeLinearLayout;
        this.rlShowAd = relativeLayout2;
        this.tvActivateVip = textView;
        this.tvDes = themeTextView;
        this.tvShowAd = themeTextView2;
        this.tvTitle = themeTextView3;
    }

    @NonNull
    public static FragmentAudioBookNoneAvailableTimeBinding bind(@NonNull View view) {
        int i10 = R.id.iv_close;
        ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (themeImageView != null) {
            i10 = R.id.ll_content;
            ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
            if (themeLinearLayout != null) {
                i10 = R.id.rl_show_ad;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                if (relativeLayout != null) {
                    i10 = R.id.tv_activate_vip;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                    if (textView != null) {
                        i10 = R.id.tv_des;
                        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView != null) {
                            i10 = R.id.tv_show_ad;
                            ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                            if (themeTextView2 != null) {
                                i10 = R.id.tv_title;
                                ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                if (themeTextView3 != null) {
                                    return new FragmentAudioBookNoneAvailableTimeBinding((RelativeLayout) view, themeImageView, themeLinearLayout, relativeLayout, textView, themeTextView, themeTextView2, themeTextView3);
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
    public static FragmentAudioBookNoneAvailableTimeBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentAudioBookNoneAvailableTimeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.fragment_audio_book_none_available_time, viewGroup, false);
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
