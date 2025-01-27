package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class AudioBookDownloadGoogleTtsEngineBinding implements ViewBinding {

    @NonNull
    private final RelativeLayout rootView;

    @NonNull
    public final ThemeTextView tvDownload;

    private AudioBookDownloadGoogleTtsEngineBinding(@NonNull RelativeLayout relativeLayout, @NonNull ThemeTextView themeTextView) {
        this.rootView = relativeLayout;
        this.tvDownload = themeTextView;
    }

    @NonNull
    public static AudioBookDownloadGoogleTtsEngineBinding bind(@NonNull View view) {
        int i10 = R.id.tv_download;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            return new AudioBookDownloadGoogleTtsEngineBinding((RelativeLayout) view, themeTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static AudioBookDownloadGoogleTtsEngineBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static AudioBookDownloadGoogleTtsEngineBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.audio_book_download_google_tts_engine, viewGroup, false);
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
