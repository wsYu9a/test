package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class TtsFloatViewBinding implements ViewBinding {

    @NonNull
    private final RelativeLayout rootView;

    @NonNull
    public final ThemeImageView ttsFloatClose;

    @NonNull
    public final ImageView ttsFloatCover;

    @NonNull
    public final ThemeImageView ttsFloatOperation;

    private TtsFloatViewBinding(@NonNull RelativeLayout relativeLayout, @NonNull ThemeImageView themeImageView, @NonNull ImageView imageView, @NonNull ThemeImageView themeImageView2) {
        this.rootView = relativeLayout;
        this.ttsFloatClose = themeImageView;
        this.ttsFloatCover = imageView;
        this.ttsFloatOperation = themeImageView2;
    }

    @NonNull
    public static TtsFloatViewBinding bind(@NonNull View view) {
        int i10 = R.id.tts_float_close;
        ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (themeImageView != null) {
            i10 = R.id.tts_float_cover;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView != null) {
                i10 = R.id.tts_float_operation;
                ThemeImageView themeImageView2 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                if (themeImageView2 != null) {
                    return new TtsFloatViewBinding((RelativeLayout) view, themeImageView, imageView, themeImageView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static TtsFloatViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static TtsFloatViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.tts_float_view, viewGroup, false);
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
