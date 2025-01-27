package com.google.android.material.slider;

import androidx.annotation.NonNull;
import java.util.Locale;

/* loaded from: classes.dex */
public final class c implements d {

    /* renamed from: d */
    private static final long f7728d = 1000000000000L;

    /* renamed from: e */
    private static final int f7729e = 1000000000;

    /* renamed from: f */
    private static final int f7730f = 1000000;

    /* renamed from: g */
    private static final int f7731g = 1000;

    @Override // com.google.android.material.slider.d
    @NonNull
    public String a(float f2) {
        return f2 >= 1.0E12f ? String.format(Locale.US, "%.1fT", Float.valueOf(f2 / 1.0E12f)) : f2 >= 1.0E9f ? String.format(Locale.US, "%.1fB", Float.valueOf(f2 / 1.0E9f)) : f2 >= 1000000.0f ? String.format(Locale.US, "%.1fM", Float.valueOf(f2 / 1000000.0f)) : f2 >= 1000.0f ? String.format(Locale.US, "%.1fK", Float.valueOf(f2 / 1000.0f)) : String.format(Locale.US, "%.0f", Float.valueOf(f2));
    }
}
