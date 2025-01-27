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
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class DialogTtsSoundSettingBinding implements ViewBinding {

    @NonNull
    public final ThemeImageView ivClose;

    @NonNull
    public final ImageView ivGoSetting;

    @NonNull
    public final ImageView ivIcon;

    @NonNull
    public final ImageView ivVip;

    @NonNull
    public final ThemeLinearLayout modifyVoiceSetting;

    @NonNull
    public final ThemeLinearLayout replaceVoicePlugin;

    @NonNull
    private final RoundedLayout rootView;

    @NonNull
    public final TextView tvContent;

    @NonNull
    public final TextView tvDownload;

    @NonNull
    public final TextView tvSetting;

    @NonNull
    public final ImageView tvSettingMore;

    @NonNull
    public final TextView tvTitle;

    private DialogTtsSoundSettingBinding(@NonNull RoundedLayout roundedLayout, @NonNull ThemeImageView themeImageView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeLinearLayout themeLinearLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull ImageView imageView4, @NonNull TextView textView4) {
        this.rootView = roundedLayout;
        this.ivClose = themeImageView;
        this.ivGoSetting = imageView;
        this.ivIcon = imageView2;
        this.ivVip = imageView3;
        this.modifyVoiceSetting = themeLinearLayout;
        this.replaceVoicePlugin = themeLinearLayout2;
        this.tvContent = textView;
        this.tvDownload = textView2;
        this.tvSetting = textView3;
        this.tvSettingMore = imageView4;
        this.tvTitle = textView4;
    }

    @NonNull
    public static DialogTtsSoundSettingBinding bind(@NonNull View view) {
        int i10 = R.id.iv_close;
        ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (themeImageView != null) {
            i10 = R.id.iv_go_setting;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView != null) {
                i10 = R.id.iv_icon;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                if (imageView2 != null) {
                    i10 = R.id.iv_vip;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i10);
                    if (imageView3 != null) {
                        i10 = R.id.modify_voice_setting;
                        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                        if (themeLinearLayout != null) {
                            i10 = R.id.replace_voice_plugin;
                            ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                            if (themeLinearLayout2 != null) {
                                i10 = R.id.tv_content;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                                if (textView != null) {
                                    i10 = R.id.tv_download;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                                    if (textView2 != null) {
                                        i10 = R.id.tv_setting;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i10);
                                        if (textView3 != null) {
                                            i10 = R.id.tv_setting_more;
                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                            if (imageView4 != null) {
                                                i10 = R.id.tv_title;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i10);
                                                if (textView4 != null) {
                                                    return new DialogTtsSoundSettingBinding((RoundedLayout) view, themeImageView, imageView, imageView2, imageView3, themeLinearLayout, themeLinearLayout2, textView, textView2, textView3, imageView4, textView4);
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
    public static DialogTtsSoundSettingBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogTtsSoundSettingBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.dialog_tts_sound_setting, viewGroup, false);
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
