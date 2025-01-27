package com.jd.ad.sdk.jad_nw;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_ox.jad_an;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class jad_jt implements jad_er, jad_an.InterfaceC0340jad_an, jad_kx {
    public final Path jad_an;
    public final Paint jad_bo;
    public final com.jd.ad.sdk.jad_tc.jad_an jad_cp;
    public final String jad_dq;
    public final boolean jad_er;
    public final List<jad_mz> jad_fs;
    public final com.jd.ad.sdk.jad_ox.jad_an<Integer, Integer> jad_hu;

    @Nullable
    public com.jd.ad.sdk.jad_ox.jad_an<ColorFilter, ColorFilter> jad_iv;
    public final com.jd.ad.sdk.jad_ox.jad_an<Integer, Integer> jad_jt;
    public final com.jd.ad.sdk.jad_lu.jad_mz jad_jw;

    @Nullable
    public com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_kx;
    public float jad_ly;

    @Nullable
    public com.jd.ad.sdk.jad_ox.jad_cp jad_mz;

    public jad_jt(com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar, com.jd.ad.sdk.jad_tc.jad_an jad_anVar, com.jd.ad.sdk.jad_sb.jad_ob jad_obVar) {
        Path path = new Path();
        this.jad_an = path;
        this.jad_bo = new com.jd.ad.sdk.jad_mv.jad_an(1);
        this.jad_fs = new ArrayList();
        this.jad_cp = jad_anVar;
        this.jad_dq = jad_obVar.jad_cp();
        this.jad_er = jad_obVar.jad_er();
        this.jad_jw = jad_mzVar;
        if (jad_anVar.jad_er() != null) {
            com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_an = jad_anVar.jad_er().jad_an().jad_an();
            this.jad_kx = jad_an;
            jad_an.jad_an(this);
            jad_anVar.jad_an(this.jad_kx);
        }
        if (jad_anVar.jad_fs() != null) {
            this.jad_mz = new com.jd.ad.sdk.jad_ox.jad_cp(this, jad_anVar, jad_anVar.jad_fs());
        }
        if (jad_obVar.jad_an() == null || jad_obVar.jad_dq() == null) {
            this.jad_jt = null;
            this.jad_hu = null;
            return;
        }
        path.setFillType(jad_obVar.jad_bo());
        com.jd.ad.sdk.jad_ox.jad_an<Integer, Integer> jad_an2 = jad_obVar.jad_an().jad_an();
        this.jad_jt = jad_an2;
        jad_an2.jad_an(this);
        jad_anVar.jad_an(jad_an2);
        com.jd.ad.sdk.jad_ox.jad_an<Integer, Integer> jad_an3 = jad_obVar.jad_dq().jad_an();
        this.jad_hu = jad_an3;
        jad_an3.jad_an(this);
        jad_anVar.jad_an(jad_an3);
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0340jad_an
    public void jad_an() {
        this.jad_jw.invalidateSelf();
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_cp
    public String jad_cp() {
        return this.jad_dq;
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_er
    public void jad_an(RectF rectF, Matrix matrix, boolean z10) {
        this.jad_an.reset();
        for (int i10 = 0; i10 < this.jad_fs.size(); i10++) {
            this.jad_an.addPath(this.jad_fs.get(i10).jad_bo(), matrix);
        }
        this.jad_an.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.jd.ad.sdk.jad_qz.jad_fs
    public void jad_an(com.jd.ad.sdk.jad_qz.jad_er jad_erVar, int i10, List<com.jd.ad.sdk.jad_qz.jad_er> list, com.jd.ad.sdk.jad_qz.jad_er jad_erVar2) {
        com.jd.ad.sdk.jad_xg.jad_jt.jad_an(jad_erVar, i10, list, jad_erVar2, this);
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_cp
    public void jad_an(List<jad_cp> list, List<jad_cp> list2) {
        for (int i10 = 0; i10 < list2.size(); i10++) {
            jad_cp jad_cpVar = list2.get(i10);
            if (jad_cpVar instanceof jad_mz) {
                this.jad_fs.add((jad_mz) jad_cpVar);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jd.ad.sdk.jad_qz.jad_fs
    public <T> void jad_an(T t10, @Nullable com.jd.ad.sdk.jad_yh.jad_cp<T> jad_cpVar) {
        com.jd.ad.sdk.jad_ox.jad_cp jad_cpVar2;
        com.jd.ad.sdk.jad_ox.jad_cp jad_cpVar3;
        com.jd.ad.sdk.jad_ox.jad_cp jad_cpVar4;
        com.jd.ad.sdk.jad_ox.jad_cp jad_cpVar5;
        com.jd.ad.sdk.jad_ox.jad_cp jad_cpVar6;
        com.jd.ad.sdk.jad_ox.jad_an<Integer, Integer> jad_anVar;
        if (t10 == com.jd.ad.sdk.jad_lu.jad_re.jad_an) {
            jad_anVar = this.jad_jt;
        } else {
            if (t10 != com.jd.ad.sdk.jad_lu.jad_re.jad_dq) {
                if (t10 == com.jd.ad.sdk.jad_lu.jad_re.jad_mx) {
                    com.jd.ad.sdk.jad_ox.jad_an<ColorFilter, ColorFilter> jad_anVar2 = this.jad_iv;
                    if (jad_anVar2 != null) {
                        this.jad_cp.jad_uh.remove(jad_anVar2);
                    }
                    if (jad_cpVar == 0) {
                        this.jad_iv = null;
                        return;
                    }
                    com.jd.ad.sdk.jad_ox.jad_qd jad_qdVar = new com.jd.ad.sdk.jad_ox.jad_qd(jad_cpVar, null);
                    this.jad_iv = jad_qdVar;
                    jad_qdVar.jad_an.add(this);
                    this.jad_cp.jad_an(this.jad_iv);
                    return;
                }
                if (t10 == com.jd.ad.sdk.jad_lu.jad_re.jad_jw) {
                    com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_anVar3 = this.jad_kx;
                    if (jad_anVar3 != null) {
                        jad_anVar3.jad_er = jad_cpVar;
                        return;
                    }
                    com.jd.ad.sdk.jad_ox.jad_qd jad_qdVar2 = new com.jd.ad.sdk.jad_ox.jad_qd(jad_cpVar, null);
                    this.jad_kx = jad_qdVar2;
                    jad_qdVar2.jad_an.add(this);
                    this.jad_cp.jad_an(this.jad_kx);
                    return;
                }
                if (t10 == com.jd.ad.sdk.jad_lu.jad_re.jad_er && (jad_cpVar6 = this.jad_mz) != null) {
                    jad_cpVar6.jad_bo.jad_er = jad_cpVar;
                    return;
                }
                if (t10 == com.jd.ad.sdk.jad_lu.jad_re.jad_it && (jad_cpVar5 = this.jad_mz) != null) {
                    jad_cpVar5.jad_an((com.jd.ad.sdk.jad_yh.jad_cp<Float>) jad_cpVar);
                    return;
                }
                if (t10 == com.jd.ad.sdk.jad_lu.jad_re.jad_ju && (jad_cpVar4 = this.jad_mz) != null) {
                    jad_cpVar4.jad_dq.jad_er = jad_cpVar;
                    return;
                }
                if (t10 == com.jd.ad.sdk.jad_lu.jad_re.jad_kv && (jad_cpVar3 = this.jad_mz) != null) {
                    jad_cpVar3.jad_er.jad_er = jad_cpVar;
                    return;
                } else {
                    if (t10 != com.jd.ad.sdk.jad_lu.jad_re.jad_lw || (jad_cpVar2 = this.jad_mz) == null) {
                        return;
                    }
                    jad_cpVar2.jad_fs.jad_er = jad_cpVar;
                    return;
                }
            }
            jad_anVar = this.jad_hu;
        }
        jad_anVar.jad_er = jad_cpVar;
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_er
    public void jad_an(Canvas canvas, Matrix matrix, int i10) {
        if (this.jad_er) {
            return;
        }
        Paint paint = this.jad_bo;
        com.jd.ad.sdk.jad_ox.jad_bo jad_boVar = (com.jd.ad.sdk.jad_ox.jad_bo) this.jad_jt;
        paint.setColor(jad_boVar.jad_bo(jad_boVar.jad_an(), jad_boVar.jad_cp()));
        Paint paint2 = this.jad_bo;
        PointF pointF = com.jd.ad.sdk.jad_xg.jad_jt.jad_an;
        paint2.setAlpha(Math.max(0, Math.min(255, (int) ((((i10 / 255.0f) * this.jad_hu.jad_fs().intValue()) / 100.0f) * 255.0f))));
        com.jd.ad.sdk.jad_ox.jad_an<ColorFilter, ColorFilter> jad_anVar = this.jad_iv;
        if (jad_anVar != null) {
            this.jad_bo.setColorFilter(jad_anVar.jad_fs());
        }
        com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_anVar2 = this.jad_kx;
        if (jad_anVar2 != null) {
            float floatValue = jad_anVar2.jad_fs().floatValue();
            if (floatValue == 0.0f) {
                this.jad_bo.setMaskFilter(null);
            } else if (floatValue != this.jad_ly) {
                this.jad_bo.setMaskFilter(this.jad_cp.jad_an(floatValue));
            }
            this.jad_ly = floatValue;
        }
        com.jd.ad.sdk.jad_ox.jad_cp jad_cpVar = this.jad_mz;
        if (jad_cpVar != null) {
            jad_cpVar.jad_an(this.jad_bo);
        }
        this.jad_an.reset();
        for (int i11 = 0; i11 < this.jad_fs.size(); i11++) {
            this.jad_an.addPath(this.jad_fs.get(i11).jad_bo(), matrix);
        }
        canvas.drawPath(this.jad_an, this.jad_bo);
        com.jd.ad.sdk.jad_lu.jad_dq.jad_an("FillContent#draw");
    }
}
