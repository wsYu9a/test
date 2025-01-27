package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeProgressBar;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class DialogDownloadTtsEngineBinding implements ViewBinding {

    @NonNull
    public final ImageView ivInstall;

    @NonNull
    public final ImageView ivVip;

    @NonNull
    public final ThemeProgressBar rbsProgressBar;

    @NonNull
    public final RelativeLayout rlDownload;

    @NonNull
    private final RoundedLayout rootView;

    @NonNull
    public final TextView tvDescription;

    @NonNull
    public final ThemeTextView tvDownload;

    @NonNull
    public final TextView tvTitle;

    private DialogDownloadTtsEngineBinding(@NonNull RoundedLayout roundedLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ThemeProgressBar themeProgressBar, @NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull ThemeTextView themeTextView, @NonNull TextView textView2) {
        this.rootView = roundedLayout;
        this.ivInstall = imageView;
        this.ivVip = imageView2;
        this.rbsProgressBar = themeProgressBar;
        this.rlDownload = relativeLayout;
        this.tvDescription = textView;
        this.tvDownload = themeTextView;
        this.tvTitle = textView2;
    }

    @NonNull
    public static DialogDownloadTtsEngineBinding bind(@NonNull View view) {
        int i10 = R.id.iv_install;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
        if (imageView != null) {
            i10 = R.id.iv_vip;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView2 != null) {
                i10 = R.id.rbs_progress_bar;
                ThemeProgressBar themeProgressBar = (ThemeProgressBar) ViewBindings.findChildViewById(view, i10);
                if (themeProgressBar != null) {
                    i10 = R.id.rl_download;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                    if (relativeLayout != null) {
                        i10 = R.id.tv_description;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                        if (textView != null) {
                            i10 = R.id.tv_download;
                            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                            if (themeTextView != null) {
                                i10 = R.id.tv_title;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                                if (textView2 != null) {
                                    return new DialogDownloadTtsEngineBinding((RoundedLayout) view, imageView, imageView2, themeProgressBar, relativeLayout, textView, themeTextView, textView2);
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
    public static DialogDownloadTtsEngineBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogDownloadTtsEngineBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.dialog_download_tts_engine, viewGroup, false);
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
