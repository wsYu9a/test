package com.vivo.mobilead.lottie.c.a;

import android.graphics.PointF;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public class e implements m<PointF, PointF> {

    /* renamed from: a */
    private final List<com.vivo.mobilead.lottie.g.a<PointF>> f29173a;

    public e() {
        this.f29173a = Collections.singletonList(new com.vivo.mobilead.lottie.g.a(new PointF(0.0f, 0.0f)));
    }

    public e(List<com.vivo.mobilead.lottie.g.a<PointF>> list) {
        this.f29173a = list;
    }

    @Override // com.vivo.mobilead.lottie.c.a.m
    public com.vivo.mobilead.lottie.a.b.a<PointF, PointF> a() {
        return this.f29173a.get(0).e() ? new com.vivo.mobilead.lottie.a.b.j(this.f29173a) : new com.vivo.mobilead.lottie.a.b.i(this.f29173a);
    }

    @Override // com.vivo.mobilead.lottie.c.a.m
    public boolean b() {
        return this.f29173a.size() == 1 && this.f29173a.get(0).e();
    }

    @Override // com.vivo.mobilead.lottie.c.a.m
    public List<com.vivo.mobilead.lottie.g.a<PointF>> c() {
        return this.f29173a;
    }
}
