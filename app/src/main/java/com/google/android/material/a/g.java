package com.google.android.material.a;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class g implements TypeEvaluator<Matrix> {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f6617a = new float[9];

    /* renamed from: b, reason: collision with root package name */
    private final float[] f6618b = new float[9];

    /* renamed from: c, reason: collision with root package name */
    private final Matrix f6619c = new Matrix();

    @Override // android.animation.TypeEvaluator
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Matrix evaluate(float f2, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
        matrix.getValues(this.f6617a);
        matrix2.getValues(this.f6618b);
        for (int i2 = 0; i2 < 9; i2++) {
            float[] fArr = this.f6618b;
            float f3 = fArr[i2];
            float[] fArr2 = this.f6617a;
            fArr[i2] = fArr2[i2] + ((f3 - fArr2[i2]) * f2);
        }
        this.f6619c.setValues(this.f6618b);
        return this.f6619c;
    }
}
