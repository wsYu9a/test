package com.jd.ad.sdk.jad_ir;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;

/* loaded from: classes2.dex */
public final class jad_kx {
    @NonNull
    public static <T> T jad_an(@Nullable T t10, @NonNull String str) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(str);
    }

    @NonNull
    public static String jad_an(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        return str;
    }

    @NonNull
    public static <T extends Collection<Y>, Y> T jad_an(@NonNull T t10) {
        if (t10.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        return t10;
    }

    public static void jad_an(boolean z10, @NonNull String str) {
        if (!z10) {
            throw new IllegalArgumentException(str);
        }
    }

    @NonNull
    public static <T> T jad_an(@Nullable T t10) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException("Argument must not be null");
    }
}
