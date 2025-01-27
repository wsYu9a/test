package com.jd.ad.sdk.fdt.utils;

import android.text.TextUtils;
import android.util.Log;
import com.jd.ad.sdk.logger.Logger;
import p3.f;

/* loaded from: classes2.dex */
public class ANEProxy {
    public static synchronized String ja(String str) {
        String jad_cp;
        synchronized (ANEProxy.class) {
            jad_cp = ANE.jad_cp(str);
        }
        return jad_cp;
    }

    public static synchronized String jb(String str) {
        String jad_an;
        synchronized (ANEProxy.class) {
            jad_an = ANE.jad_an(str);
        }
        return jad_an;
    }

    public static synchronized String jc(String str) {
        String trim;
        synchronized (ANEProxy.class) {
            synchronized (ANE.class) {
                try {
                    int i10 = ANE.jad_an;
                    if (!TextUtils.isEmpty(str)) {
                        trim = str.trim();
                        if (!trim.startsWith("{") || !trim.endsWith(f.f29748d)) {
                            try {
                                trim = ANE.jad_an(trim);
                            } catch (Throwable th2) {
                                Logger.d(Log.getStackTraceString(th2));
                                trim = "";
                            }
                            if (trim.startsWith("{")) {
                                if (trim.endsWith(f.f29748d)) {
                                }
                            }
                        }
                    }
                    trim = "";
                } finally {
                }
            }
        }
        return trim;
    }

    public static synchronized String jd(String str) {
        String jad_dq;
        synchronized (ANEProxy.class) {
            jad_dq = ANE.jad_dq(str);
        }
        return jad_dq;
    }

    public static synchronized String je(String str) {
        String jad_bo;
        synchronized (ANEProxy.class) {
            jad_bo = ANE.jad_bo(str);
        }
        return jad_bo;
    }
}
