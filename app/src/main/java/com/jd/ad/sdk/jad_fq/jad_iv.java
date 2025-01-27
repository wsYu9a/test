package com.jd.ad.sdk.jad_fq;

import java.text.DecimalFormat;

/* loaded from: classes2.dex */
public class jad_iv {
    public static String jad_an(double d10) {
        float log;
        double random = (float) Math.random();
        if (random <= 0.5d) {
            log = (float) (Math.log(1.0f - r0) * (-0.001f));
        } else {
            log = (float) (Math.log(random) * 0.001f);
        }
        try {
            return new DecimalFormat("0.000000").format(log + d10);
        } catch (Exception e10) {
            e10.printStackTrace();
            return "-1";
        }
    }
}
