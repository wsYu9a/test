package com.vivo.mobilead.lottie.a.b;

import android.graphics.PointF;
import java.util.Collections;

/* loaded from: classes4.dex */
public class m extends a<PointF, PointF> {

    /* renamed from: c */
    private final PointF f29097c;

    /* renamed from: d */
    private final a<Float, Float> f29098d;

    /* renamed from: e */
    private final a<Float, Float> f29099e;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.f29097c = new PointF();
        this.f29098d = aVar;
        this.f29099e = aVar2;
        a(h());
    }

    @Override // com.vivo.mobilead.lottie.a.b.a
    public void a(float f2) {
        this.f29098d.a(f2);
        this.f29099e.a(f2);
        this.f29097c.set(this.f29098d.g().floatValue(), this.f29099e.g().floatValue());
        for (int i2 = 0; i2 < this.f29073a.size(); i2++) {
            this.f29073a.get(i2).a();
        }
    }

    @Override // com.vivo.mobilead.lottie.a.b.a
    /* renamed from: b */
    public PointF a(com.vivo.mobilead.lottie.g.a<PointF> aVar, float f2) {
        return this.f29097c;
    }

    @Override // com.vivo.mobilead.lottie.a.b.a
    /* renamed from: i */
    public PointF g() {
        return a(null, 0.0f);
    }
}
