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
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class TtsSettingItemBinding implements ViewBinding {

    @NonNull
    private final RelativeLayout rootView;

    @NonNull
    public final ThemeTextView ttsSettingDesc;

    @NonNull
    public final ThemeTextView ttsSettingStatus;

    @NonNull
    public final ThemeImageView ttsSettingStatusMore;

    @NonNull
    public final ThemeTextView ttsSettingTitle;

    @NonNull
    public final ThemeLinearLayout ttsSettingView;

    private TtsSettingItemBinding(@NonNull RelativeLayout relativeLayout, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeImageView themeImageView, @NonNull ThemeTextView themeTextView3, @NonNull ThemeLinearLayout themeLinearLayout) {
        this.rootView = relativeLayout;
        this.ttsSettingDesc = themeTextView;
        this.ttsSettingStatus = themeTextView2;
        this.ttsSettingStatusMore = themeImageView;
        this.ttsSettingTitle = themeTextView3;
        this.ttsSettingView = themeLinearLayout;
    }

    @NonNull
    public static TtsSettingItemBinding bind(@NonNull View view) {
        int i10 = R.id.tts_setting_desc;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = R.id.tts_setting_status;
            ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView2 != null) {
                i10 = R.id.tts_setting_status_more;
                ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                if (themeImageView != null) {
                    i10 = R.id.tts_setting_title;
                    ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (themeTextView3 != null) {
                        i10 = R.id.tts_setting_view;
                        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                        if (themeLinearLayout != null) {
                            return new TtsSettingItemBinding((RelativeLayout) view, themeTextView, themeTextView2, themeImageView, themeTextView3, themeLinearLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static TtsSettingItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static TtsSettingItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.tts_setting_item, viewGroup, false);
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
