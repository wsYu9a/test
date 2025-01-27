package com.google.android.material.m;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.transition.PathMotion;

/* loaded from: classes.dex */
public final class k extends PathMotion {
    private static PointF a(float f2, float f3, float f4, float f5) {
        return f3 > f5 ? new PointF(f4, f3) : new PointF(f2, f5);
    }

    @Override // androidx.transition.PathMotion
    @NonNull
    public Path getPath(float f2, float f3, float f4, float f5) {
        Path path = new Path();
        path.moveTo(f2, f3);
        PointF a2 = a(f2, f3, f4, f5);
        path.quadTo(a2.x, a2.y, f4, f5);
        return path;
    }
}
