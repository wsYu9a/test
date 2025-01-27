package com.opos.mobad.n.a;

import android.animation.FloatEvaluator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;

/* loaded from: classes4.dex */
public class j implements TypeEvaluator<Float> {

    /* renamed from: a */
    private TimeInterpolator f21823a;

    /* renamed from: b */
    private FloatEvaluator f21824b = new FloatEvaluator();

    /* renamed from: c */
    private float f21825c;

    /* renamed from: d */
    private float f21826d;

    public j(TimeInterpolator timeInterpolator, float f2, float f3) {
        this.f21823a = timeInterpolator;
        this.f21825c = f2;
        this.f21826d = f3;
    }

    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public Float evaluate(float f2, Float f3, Float f4) {
        return this.f21824b.evaluate(this.f21823a.getInterpolation(f2), (Number) Float.valueOf(this.f21825c), (Number) Float.valueOf(this.f21826d));
    }
}
