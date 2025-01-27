package com.vivo.mobilead.lottie.c.a;

import android.graphics.PointF;
import java.util.List;

/* loaded from: classes4.dex */
public class i implements m<PointF, PointF> {

    /* renamed from: a */
    private final b f29174a;

    /* renamed from: b */
    private final b f29175b;

    public i(b bVar, b bVar2) {
        this.f29174a = bVar;
        this.f29175b = bVar2;
    }

    @Override // com.vivo.mobilead.lottie.c.a.m
    public com.vivo.mobilead.lottie.a.b.a<PointF, PointF> a() {
        return new com.vivo.mobilead.lottie.a.b.m(this.f29174a.a(), this.f29175b.a());
    }

    @Override // com.vivo.mobilead.lottie.c.a.m
    public boolean b() {
        return this.f29174a.b() && this.f29175b.b();
    }

    @Override // com.vivo.mobilead.lottie.c.a.m
    public List<com.vivo.mobilead.lottie.g.a<PointF>> c() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }
}
