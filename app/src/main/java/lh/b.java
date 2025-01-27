package lh;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;

/* loaded from: classes4.dex */
public final class b {
    public static Drawable a(int[] iArr, float f10) {
        if (iArr == null || iArr.length == 0) {
            return null;
        }
        return new ShapeDrawable(new a(f10, iArr));
    }
}
