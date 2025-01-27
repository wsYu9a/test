package com.jd.ad.sdk.jad_ob;

import android.text.TextUtils;
import com.jd.ad.sdk.bl.initsdk.JADYunSdk;
import com.jd.ad.sdk.jad_uh.jad_an;

/* loaded from: classes2.dex */
public class jad_an {
    public static long jad_an() {
        Object jad_an;
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        Class cls = Long.TYPE;
        jad_anVar.getClass();
        if (TextUtils.isEmpty("cat")) {
            jad_an = null;
        } else {
            StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("cat");
            jad_an2.append(JADYunSdk.getAppId());
            jad_an = jad_anVar.jad_an(jad_an2.toString(), (Class<Object>) cls);
        }
        long longValue = (jad_an == null || !(jad_an instanceof Long)) ? 0L : ((Long) jad_an).longValue();
        if (com.jd.ad.sdk.jad_re.jad_an.jad_bo()) {
            return longValue;
        }
        return 0L;
    }
}
