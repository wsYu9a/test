package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class g7 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12023a;

    /* renamed from: b */
    @NonNull
    public final ReaderThemeImageView f12024b;

    private g7(@NonNull RelativeLayout rootView, @NonNull ReaderThemeImageView ttsPositionBack) {
        this.f12023a = rootView;
        this.f12024b = ttsPositionBack;
    }

    @NonNull
    public static g7 a(@NonNull View rootView) {
        ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) rootView.findViewById(R.id.tts_position_back);
        if (readerThemeImageView != null) {
            return new g7((RelativeLayout) rootView, readerThemeImageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.tts_position_back)));
    }

    @NonNull
    public static g7 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static g7 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.tts_position_control_view, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12023a;
    }
}
