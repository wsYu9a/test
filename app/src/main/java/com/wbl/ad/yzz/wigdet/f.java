package com.wbl.ad.yzz.wigdet;

import android.graphics.Camera;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;

/* loaded from: classes5.dex */
public class f extends Animation {

    /* renamed from: a */
    public float f34420a;

    /* renamed from: b */
    public float f34421b;

    /* renamed from: c */
    public final boolean f34422c;

    /* renamed from: d */
    public final boolean f34423d;

    /* renamed from: e */
    public Camera f34424e;

    /* renamed from: f */
    public View f34425f;

    public f(boolean z, boolean z2, View view) {
        this.f34422c = z;
        this.f34423d = z2;
        this.f34425f = view;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f2, Transformation transformation) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8470, this, Float.valueOf(f2), transformation);
    }

    @Override // android.view.animation.Animation
    public void initialize(int i2, int i3, int i4, int i5) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8469, this, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }
}
