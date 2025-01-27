package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class y implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f12950a;

    /* renamed from: b */
    @NonNull
    public final ThemeLinearLayout f12951b;

    private y(@NonNull ThemeLinearLayout rootView, @NonNull ThemeLinearLayout ttsOptimizeView) {
        this.f12950a = rootView;
        this.f12951b = ttsOptimizeView;
    }

    @NonNull
    public static y a(@NonNull View rootView) {
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.tts_optimize_view);
        if (themeLinearLayout != null) {
            return new y((ThemeLinearLayout) rootView, themeLinearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.tts_optimize_view)));
    }

    @NonNull
    public static y c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static y d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_tts_optimize, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f12950a;
    }
}
