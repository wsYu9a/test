package com.jd.ad.sdk.jad_qd;

import android.annotation.SuppressLint;
import android.content.Context;
import com.jd.ad.sdk.dl.baseinfo.JADLocation;
import com.jd.ad.sdk.jad_fq.jad_hu;
import com.jd.ad.sdk.jad_qd.jad_cp;
import com.jd.ad.sdk.jad_qd.jad_dq;

/* loaded from: classes2.dex */
public class jad_fs {
    @SuppressLint({"MissingPermission"})
    public static int jad_an(Context context) {
        try {
            if (jad_cp.jad_an.jad_an.jad_an("connectionType")) {
                return jad_hu.jad_an(context);
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static double[] jad_bo(Context context) {
        double[] dArr = jad_bo.jad_bo;
        try {
            jad_cp jad_cpVar = jad_cp.jad_an.jad_an;
            if (jad_cpVar.jad_fs) {
                return !jad_cpVar.jad_an("geo") ? dArr : jad_dq.jad_an.jad_an.jad_an(context);
            }
            JADLocation jADLocation = jad_cpVar.jad_dq;
            return jADLocation != null ? jADLocation.toDoubleArray() : dArr;
        } catch (Exception unused) {
            return dArr;
        }
    }
}
