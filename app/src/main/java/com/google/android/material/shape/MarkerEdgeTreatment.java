package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public final class MarkerEdgeTreatment extends EdgeTreatment {
    private final float radius;

    public MarkerEdgeTreatment(float f10) {
        this.radius = f10 - 0.001f;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public boolean forceIntersection() {
        return true;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f10, float f11, float f12, @NonNull ShapePath shapePath) {
        float sqrt = (float) ((this.radius * Math.sqrt(2.0d)) / 2.0d);
        float sqrt2 = (float) Math.sqrt(Math.pow(this.radius, 2.0d) - Math.pow(sqrt, 2.0d));
        shapePath.reset(f11 - sqrt, ((float) (-((this.radius * Math.sqrt(2.0d)) - this.radius))) + sqrt2);
        shapePath.lineTo(f11, (float) (-((this.radius * Math.sqrt(2.0d)) - this.radius)));
        shapePath.lineTo(f11 + sqrt, ((float) (-((this.radius * Math.sqrt(2.0d)) - this.radius))) + sqrt2);
    }
}
