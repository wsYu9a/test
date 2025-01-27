package fr.castorflex.android.smoothprogressbar;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;

/* loaded from: classes5.dex */
public final class b {
    private b() {
    }

    public static Drawable a(int[] iArr, float f2) {
        if (iArr == null || iArr.length == 0) {
            return null;
        }
        return new ShapeDrawable(new a(f2, iArr));
    }
}
