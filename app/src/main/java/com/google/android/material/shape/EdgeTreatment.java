package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public class EdgeTreatment {
    public boolean forceIntersection() {
        return false;
    }

    @Deprecated
    public void getEdgePath(float f10, float f11, @NonNull ShapePath shapePath) {
        getEdgePath(f10, f10 / 2.0f, f11, shapePath);
    }

    public void getEdgePath(float f10, float f11, float f12, @NonNull ShapePath shapePath) {
        shapePath.lineTo(f10, 0.0f);
    }
}
