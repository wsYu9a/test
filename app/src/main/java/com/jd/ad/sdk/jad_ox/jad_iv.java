package com.jd.ad.sdk.jad_ox;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public class jad_iv extends com.jd.ad.sdk.jad_yh.jad_an<PointF> {

    @Nullable
    public Path jad_qd;
    public final com.jd.ad.sdk.jad_yh.jad_an<PointF> jad_re;

    public jad_iv(com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar, com.jd.ad.sdk.jad_yh.jad_an<PointF> jad_anVar) {
        super(jad_jtVar, jad_anVar.jad_bo, jad_anVar.jad_cp, jad_anVar.jad_dq, jad_anVar.jad_er, jad_anVar.jad_fs, jad_anVar.jad_jt, jad_anVar.jad_hu);
        this.jad_re = jad_anVar;
        jad_dq();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void jad_dq() {
        boolean z10;
        T t10;
        T t11;
        T t12;
        T t13 = this.jad_cp;
        if (t13 != 0 && (t12 = this.jad_bo) != 0) {
            PointF pointF = (PointF) t13;
            if (((PointF) t12).equals(pointF.x, pointF.y)) {
                z10 = true;
                t10 = this.jad_bo;
                if (t10 != 0 || (t11 = this.jad_cp) == 0 || z10) {
                    return;
                }
                PointF pointF2 = (PointF) t10;
                PointF pointF3 = (PointF) t11;
                com.jd.ad.sdk.jad_yh.jad_an<PointF> jad_anVar = this.jad_re;
                PointF pointF4 = jad_anVar.jad_ob;
                PointF pointF5 = jad_anVar.jad_pc;
                ThreadLocal<PathMeasure> threadLocal = com.jd.ad.sdk.jad_xg.jad_hu.jad_an;
                Path path = new Path();
                path.moveTo(pointF2.x, pointF2.y);
                if (pointF4 == null || pointF5 == null || (pointF4.length() == 0.0f && pointF5.length() == 0.0f)) {
                    path.lineTo(pointF3.x, pointF3.y);
                } else {
                    float f10 = pointF4.x + pointF2.x;
                    float f11 = pointF2.y + pointF4.y;
                    float f12 = pointF3.x;
                    float f13 = f12 + pointF5.x;
                    float f14 = pointF3.y;
                    path.cubicTo(f10, f11, f13, f14 + pointF5.y, f12, f14);
                }
                this.jad_qd = path;
                return;
            }
        }
        z10 = false;
        t10 = this.jad_bo;
        if (t10 != 0) {
        }
    }
}
