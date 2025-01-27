package androidx.transition;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public abstract class PathMotion {
    public PathMotion() {
    }

    public abstract Path getPath(float f10, float f11, float f12, float f13);

    public PathMotion(Context context, AttributeSet attributeSet) {
    }
}
