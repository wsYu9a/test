package com.google.android.material.b;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class a {
    private a() {
    }

    public static int a(@NonNull Canvas canvas, float f2, float f3, float f4, float f5, int i2) {
        return Build.VERSION.SDK_INT > 21 ? canvas.saveLayerAlpha(f2, f3, f4, f5, i2) : canvas.saveLayerAlpha(f2, f3, f4, f5, i2, 31);
    }

    public static int b(@NonNull Canvas canvas, @Nullable RectF rectF, int i2) {
        return Build.VERSION.SDK_INT > 21 ? canvas.saveLayerAlpha(rectF, i2) : canvas.saveLayerAlpha(rectF, i2, 31);
    }
}
