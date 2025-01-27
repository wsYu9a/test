package com.jd.ad.sdk.jad_uh;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;

@SuppressLint({"ApplySharedPref"})
/* loaded from: classes2.dex */
public final class jad_dq {
    public static final Map<String, jad_dq> jad_bo = new HashMap();
    public final SharedPreferences jad_an;

    public jad_dq(String str, int i10) {
        this.jad_an = com.jd.ad.sdk.jad_fq.jad_cp.jad_an().getSharedPreferences(str, i10);
    }

    public static jad_dq jad_an(String str) {
        int length = str.length();
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                str = "spUtils";
                break;
            }
            if (!Character.isWhitespace(str.charAt(i10))) {
                break;
            }
            i10++;
        }
        Map<String, jad_dq> map = jad_bo;
        jad_dq jad_dqVar = (jad_dq) ((HashMap) map).get(str);
        if (jad_dqVar == null) {
            synchronized (jad_dq.class) {
                try {
                    jad_dqVar = (jad_dq) ((HashMap) map).get(str);
                    if (jad_dqVar == null) {
                        jad_dqVar = new jad_dq(str, 0);
                        ((HashMap) map).put(str, jad_dqVar);
                    }
                } finally {
                }
            }
        }
        return jad_dqVar;
    }
}
