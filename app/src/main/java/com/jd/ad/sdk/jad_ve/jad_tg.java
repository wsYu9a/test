package com.jd.ad.sdk.jad_ve;

import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.SparseArrayCompat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.jd.ad.sdk.jad_wf.jad_cp;
import com.kwad.sdk.m.e;
import com.umeng.analytics.pro.bt;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class jad_tg {
    public static SparseArrayCompat<WeakReference<Interpolator>> jad_bo;
    public static final Interpolator jad_an = new LinearInterpolator();
    public static jad_cp.jad_an jad_cp = jad_cp.jad_an.jad_an(bt.aO, "s", e.TAG, "o", "i", "h", TypedValues.TransitionType.S_TO, "ti");
    public static jad_cp.jad_an jad_dq = jad_cp.jad_an.jad_an("x", "y");

    public static Interpolator jad_an(PointF pointF, PointF pointF2) {
        WeakReference<Interpolator> weakReference;
        Interpolator create;
        float f10 = pointF.x;
        PointF pointF3 = com.jd.ad.sdk.jad_xg.jad_jt.jad_an;
        pointF.x = Math.max(-1.0f, Math.min(1.0f, f10));
        pointF.y = Math.max(-100.0f, Math.min(100.0f, pointF.y));
        pointF2.x = Math.max(-1.0f, Math.min(1.0f, pointF2.x));
        float max = Math.max(-100.0f, Math.min(100.0f, pointF2.y));
        pointF2.y = max;
        float f11 = pointF.x;
        float f12 = pointF.y;
        float f13 = pointF2.x;
        ThreadLocal<PathMeasure> threadLocal = com.jd.ad.sdk.jad_xg.jad_hu.jad_an;
        int i10 = f11 != 0.0f ? (int) (527 * f11) : 17;
        if (f12 != 0.0f) {
            i10 = (int) (i10 * 31 * f12);
        }
        if (f13 != 0.0f) {
            i10 = (int) (i10 * 31 * f13);
        }
        if (max != 0.0f) {
            i10 = (int) (i10 * 31 * max);
        }
        synchronized (jad_tg.class) {
            try {
                if (jad_bo == null) {
                    jad_bo = new SparseArrayCompat<>();
                }
                weakReference = jad_bo.get(i10);
            } finally {
            }
        }
        Interpolator interpolator = weakReference != null ? weakReference.get() : null;
        if (weakReference == null || interpolator == null) {
            try {
                create = PathInterpolatorCompat.create(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e10) {
                create = "The Path cannot loop back on itself.".equals(e10.getMessage()) ? PathInterpolatorCompat.create(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y) : new LinearInterpolator();
            }
            interpolator = create;
            try {
                WeakReference<Interpolator> weakReference2 = new WeakReference<>(interpolator);
                synchronized (jad_tg.class) {
                    jad_bo.put(i10, weakReference2);
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
        }
        return interpolator;
    }

    public static <T> com.jd.ad.sdk.jad_yh.jad_an<T> jad_an(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar, com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar, float f10, jad_mx<T> jad_mxVar, boolean z10, boolean z11) {
        Interpolator jad_an2;
        T t10;
        Interpolator interpolator;
        Interpolator jad_an3;
        Interpolator jad_an4;
        T t11;
        PointF pointF;
        T t12;
        float f11;
        float f12;
        if (!z10 || !z11) {
            if (z10) {
                jad_cpVar.jad_cp();
                PointF pointF2 = null;
                PointF pointF3 = null;
                PointF pointF4 = null;
                boolean z12 = false;
                T t13 = null;
                float f13 = 0.0f;
                PointF pointF5 = null;
                T t14 = null;
                while (jad_cpVar.jad_jt()) {
                    switch (jad_cpVar.jad_an(jad_cp)) {
                        case 0:
                            f13 = (float) jad_cpVar.jad_iv();
                            break;
                        case 1:
                            t13 = jad_mxVar.jad_an(jad_cpVar, f10);
                            break;
                        case 2:
                            t14 = jad_mxVar.jad_an(jad_cpVar, f10);
                            break;
                        case 3:
                            pointF2 = jad_sf.jad_an(jad_cpVar, 1.0f);
                            break;
                        case 4:
                            pointF3 = jad_sf.jad_an(jad_cpVar, 1.0f);
                            break;
                        case 5:
                            if (jad_cpVar.jad_jw() != 1) {
                                z12 = false;
                                break;
                            } else {
                                z12 = true;
                                break;
                            }
                        case 6:
                            pointF4 = jad_sf.jad_an(jad_cpVar, f10);
                            break;
                        case 7:
                            pointF5 = jad_sf.jad_an(jad_cpVar, f10);
                            break;
                        default:
                            jad_cpVar.jad_ob();
                            break;
                    }
                }
                jad_cpVar.jad_er();
                if (z12) {
                    jad_an2 = jad_an;
                    t10 = t13;
                } else {
                    jad_an2 = (pointF2 == null || pointF3 == null) ? jad_an : jad_an(pointF2, pointF3);
                    t10 = t14;
                }
                com.jd.ad.sdk.jad_yh.jad_an<T> jad_anVar = new com.jd.ad.sdk.jad_yh.jad_an<>(jad_jtVar, t13, t10, jad_an2, f13, null);
                jad_anVar.jad_ob = pointF4;
                jad_anVar.jad_pc = pointF5;
                return jad_anVar;
            }
            return new com.jd.ad.sdk.jad_yh.jad_an<>(jad_mxVar.jad_an(jad_cpVar, f10));
        }
        jad_cpVar.jad_cp();
        PointF pointF6 = null;
        PointF pointF7 = null;
        boolean z13 = false;
        PointF pointF8 = null;
        PointF pointF9 = null;
        PointF pointF10 = null;
        T t15 = null;
        PointF pointF11 = null;
        PointF pointF12 = null;
        PointF pointF13 = null;
        float f14 = 0.0f;
        T t16 = null;
        while (jad_cpVar.jad_jt()) {
            switch (jad_cpVar.jad_an(jad_cp)) {
                case 0:
                    pointF = pointF6;
                    f14 = (float) jad_cpVar.jad_iv();
                    break;
                case 1:
                    t15 = jad_mxVar.jad_an(jad_cpVar, f10);
                    continue;
                case 2:
                    t16 = jad_mxVar.jad_an(jad_cpVar, f10);
                    continue;
                case 3:
                    pointF = pointF6;
                    PointF pointF14 = pointF7;
                    if (jad_cpVar.jad_mz() == 3) {
                        jad_cpVar.jad_cp();
                        float f15 = 0.0f;
                        float f16 = 0.0f;
                        float f17 = 0.0f;
                        float f18 = 0.0f;
                        while (jad_cpVar.jad_jt()) {
                            int jad_an5 = jad_cpVar.jad_an(jad_dq);
                            if (jad_an5 == 0) {
                                t12 = t15;
                                if (jad_cpVar.jad_mz() == 7) {
                                    f17 = (float) jad_cpVar.jad_iv();
                                    t15 = t12;
                                    f15 = f17;
                                } else {
                                    jad_cpVar.jad_bo();
                                    f15 = (float) jad_cpVar.jad_iv();
                                    f17 = jad_cpVar.jad_mz() == 7 ? (float) jad_cpVar.jad_iv() : f15;
                                    jad_cpVar.jad_dq();
                                    t15 = t12;
                                }
                            } else if (jad_an5 != 1) {
                                jad_cpVar.jad_ob();
                            } else {
                                t12 = t15;
                                if (jad_cpVar.jad_mz() == 7) {
                                    f18 = (float) jad_cpVar.jad_iv();
                                    t15 = t12;
                                    f16 = f18;
                                } else {
                                    jad_cpVar.jad_bo();
                                    f16 = (float) jad_cpVar.jad_iv();
                                    f18 = jad_cpVar.jad_mz() == 7 ? (float) jad_cpVar.jad_iv() : f16;
                                    jad_cpVar.jad_dq();
                                    t15 = t12;
                                }
                            }
                        }
                        pointF10 = new PointF(f15, f16);
                        pointF11 = new PointF(f17, f18);
                        jad_cpVar.jad_er();
                    } else {
                        pointF8 = jad_sf.jad_an(jad_cpVar, f10);
                    }
                    pointF7 = pointF14;
                    break;
                case 4:
                    if (jad_cpVar.jad_mz() != 3) {
                        pointF9 = jad_sf.jad_an(jad_cpVar, f10);
                        break;
                    } else {
                        jad_cpVar.jad_cp();
                        float f19 = 0.0f;
                        float f20 = 0.0f;
                        float f21 = 0.0f;
                        float f22 = 0.0f;
                        while (jad_cpVar.jad_jt()) {
                            PointF pointF15 = pointF7;
                            int jad_an6 = jad_cpVar.jad_an(jad_dq);
                            PointF pointF16 = pointF6;
                            if (jad_an6 != 0) {
                                if (jad_an6 != 1) {
                                    jad_cpVar.jad_ob();
                                } else if (jad_cpVar.jad_mz() == 7) {
                                    f22 = (float) jad_cpVar.jad_iv();
                                    f20 = f22;
                                } else {
                                    jad_cpVar.jad_bo();
                                    float jad_iv = (float) jad_cpVar.jad_iv();
                                    if (jad_cpVar.jad_mz() == 7) {
                                        f12 = jad_iv;
                                        f22 = (float) jad_cpVar.jad_iv();
                                    } else {
                                        f12 = jad_iv;
                                        f22 = f12;
                                    }
                                    jad_cpVar.jad_dq();
                                    f20 = f12;
                                }
                            } else if (jad_cpVar.jad_mz() == 7) {
                                f21 = (float) jad_cpVar.jad_iv();
                                f19 = f21;
                            } else {
                                jad_cpVar.jad_bo();
                                float jad_iv2 = (float) jad_cpVar.jad_iv();
                                if (jad_cpVar.jad_mz() == 7) {
                                    f11 = jad_iv2;
                                    f21 = (float) jad_cpVar.jad_iv();
                                } else {
                                    f11 = jad_iv2;
                                    f21 = f11;
                                }
                                jad_cpVar.jad_dq();
                                f19 = f11;
                            }
                            pointF7 = pointF15;
                            pointF6 = pointF16;
                        }
                        pointF = pointF6;
                        PointF pointF17 = new PointF(f19, f20);
                        PointF pointF18 = new PointF(f21, f22);
                        jad_cpVar.jad_er();
                        pointF12 = pointF17;
                        pointF13 = pointF18;
                        break;
                    }
                case 5:
                    if (jad_cpVar.jad_jw() == 1) {
                        z13 = true;
                        break;
                    } else {
                        z13 = false;
                        continue;
                    }
                case 6:
                    pointF6 = jad_sf.jad_an(jad_cpVar, f10);
                    continue;
                case 7:
                    pointF7 = jad_sf.jad_an(jad_cpVar, f10);
                    continue;
                default:
                    jad_cpVar.jad_ob();
                    continue;
            }
            pointF6 = pointF;
        }
        PointF pointF19 = pointF6;
        PointF pointF20 = pointF7;
        T t17 = t15;
        jad_cpVar.jad_er();
        if (z13) {
            interpolator = jad_an;
            t11 = t17;
        } else {
            if (pointF8 != null && pointF9 != null) {
                interpolator = jad_an(pointF8, pointF9);
            } else {
                if (pointF10 != null && pointF11 != null && pointF12 != null && pointF13 != null) {
                    jad_an3 = jad_an(pointF10, pointF12);
                    jad_an4 = jad_an(pointF11, pointF13);
                    t11 = t16;
                    interpolator = null;
                    com.jd.ad.sdk.jad_yh.jad_an<T> jad_anVar2 = (jad_an3 != null || jad_an4 == null) ? new com.jd.ad.sdk.jad_yh.jad_an<>(jad_jtVar, t17, t11, interpolator, f14, null) : new com.jd.ad.sdk.jad_yh.jad_an<>(jad_jtVar, t17, t11, jad_an3, jad_an4, f14, null);
                    jad_anVar2.jad_ob = pointF19;
                    jad_anVar2.jad_pc = pointF20;
                    return jad_anVar2;
                }
                interpolator = jad_an;
            }
            t11 = t16;
        }
        jad_an3 = null;
        jad_an4 = null;
        if (jad_an3 != null) {
        }
        jad_anVar2.jad_ob = pointF19;
        jad_anVar2.jad_pc = pointF20;
        return jad_anVar2;
    }
}
