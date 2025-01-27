package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class f7 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f11972a;

    /* renamed from: b */
    @NonNull
    public final ThemeImageView f11973b;

    /* renamed from: c */
    @NonNull
    public final ImageView f11974c;

    /* renamed from: d */
    @NonNull
    public final ThemeImageView f11975d;

    private f7(@NonNull RelativeLayout rootView, @NonNull ThemeImageView ttsFloatClose, @NonNull ImageView ttsFloatCover, @NonNull ThemeImageView ttsFloatOperation) {
        this.f11972a = rootView;
        this.f11973b = ttsFloatClose;
        this.f11974c = ttsFloatCover;
        this.f11975d = ttsFloatOperation;
    }

    @NonNull
    public static f7 a(@NonNull View rootView) {
        int i2 = R.id.tts_float_close;
        ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.tts_float_close);
        if (themeImageView != null) {
            i2 = R.id.tts_float_cover;
            ImageView imageView = (ImageView) rootView.findViewById(R.id.tts_float_cover);
            if (imageView != null) {
                i2 = R.id.tts_float_operation;
                ThemeImageView themeImageView2 = (ThemeImageView) rootView.findViewById(R.id.tts_float_operation);
                if (themeImageView2 != null) {
                    return new f7((RelativeLayout) rootView, themeImageView, imageView, themeImageView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static f7 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static f7 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.tts_float_view, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f11972a;
    }
}
