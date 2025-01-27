package com.jd.ad.sdk.fdt.imageloader;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public interface OnImageLoadListener {
    void onLoadFailed(int i10, String str, @Nullable Drawable drawable);

    void onLoadSuccess(@NonNull Drawable drawable);
}
