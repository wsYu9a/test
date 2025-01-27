package com.jd.ad.sdk.jad_ox;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* loaded from: classes2.dex */
public class jad_jw extends jad_jt<PointF> {
    public final PointF jad_iv;
    public final float[] jad_jw;
    public final PathMeasure jad_kx;
    public jad_iv jad_ly;

    public jad_jw(List<? extends com.jd.ad.sdk.jad_yh.jad_an<PointF>> list) {
        super(list);
        this.jad_iv = new PointF();
        this.jad_jw = new float[2];
        this.jad_kx = new PathMeasure();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jd.ad.sdk.jad_ox.jad_an
    public Object jad_an(com.jd.ad.sdk.jad_yh.jad_an jad_anVar, float f10) {
        PointF pointF;
        jad_iv jad_ivVar = (jad_iv) jad_anVar;
        Path path = jad_ivVar.jad_qd;
        if (path == null) {
            return (PointF) jad_anVar.jad_bo;
        }
        com.jd.ad.sdk.jad_yh.jad_cp<A> jad_cpVar = this.jad_er;
        if (jad_cpVar != 0 && (pointF = (PointF) jad_cpVar.jad_an(jad_ivVar.jad_jt, jad_ivVar.jad_hu.floatValue(), (PointF) jad_ivVar.jad_bo, (PointF) jad_ivVar.jad_cp, jad_dq(), f10, this.jad_dq)) != null) {
            return pointF;
        }
        if (this.jad_ly != jad_ivVar) {
            this.jad_kx.setPath(path, false);
            this.jad_ly = jad_ivVar;
        }
        PathMeasure pathMeasure = this.jad_kx;
        pathMeasure.getPosTan(pathMeasure.getLength() * f10, this.jad_jw, null);
        PointF pointF2 = this.jad_iv;
        float[] fArr = this.jad_jw;
        pointF2.set(fArr[0], fArr[1]);
        return this.jad_iv;
    }
}
