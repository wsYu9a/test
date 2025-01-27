package com.jd.ad.sdk.jad_qd;

import android.os.Build;
import com.jd.ad.sdk.jad_qd.jad_cp;
import com.jd.ad.sdk.jad_uh.jad_an;
import com.jd.ad.sdk.multi.BuildConfig;
import com.umeng.analytics.pro.bd;

/* loaded from: classes2.dex */
public class jad_er {
    public static String jad_an() {
        String str = "";
        if (!jad_cp.jad_an.jad_an.jad_an("osVersion")) {
            return "";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("osVersion", true)) {
            return jad_anVar.jad_dq("osVersion");
        }
        str = Build.VERSION.RELEASE;
        jad_anVar.jad_bo("osVersion", str);
        return str;
    }

    public static String jad_bo() {
        if (!jad_cp.jad_an.jad_an.jad_an("osApiVersion")) {
            return "";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("osApiVersion", true)) {
            return jad_anVar.jad_dq("osApiVersion");
        }
        StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("");
        jad_an.append(Build.VERSION.SDK_INT);
        String sb2 = jad_an.toString();
        jad_anVar.jad_bo("osApiVersion", sb2);
        return sb2;
    }

    public static String jad_cp() {
        String str = "";
        if (!jad_cp.jad_an.jad_an.jad_an(bd.f23524d)) {
            return "";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an(bd.f23524d, true)) {
            return jad_anVar.jad_dq(bd.f23524d);
        }
        str = System.getProperty("http.agent") + " JADYunSDK/" + BuildConfig.VERSION_NAME;
        jad_anVar.jad_bo(bd.f23524d, str);
        return str;
    }

    public static synchronized int jad_dq() {
        int i10;
        synchronized (jad_er.class) {
            try {
                if (!jad_cp.jad_an.jad_an.jad_an("jdAppInstalled")) {
                    return -1;
                }
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar = jad_an.jad_bo.jad_an;
                if (jad_anVar.jad_an("jdAppInstalled", true)) {
                    i10 = jad_anVar.jad_cp("jdAppInstalled");
                } else {
                    boolean jad_an = com.jd.ad.sdk.jad_fq.jad_bo.jad_an("com.jingdong.app.mall");
                    jad_anVar.jad_bo("jdAppInstalled", Integer.valueOf(jad_an ? 1 : 0));
                    i10 = jad_an ? 1 : 0;
                }
                return i10;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
