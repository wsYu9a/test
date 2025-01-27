package com.jd.ad.sdk.jad_lo;

/* loaded from: classes2.dex */
public class jad_er {
    public static jad_er jad_an;

    public static jad_er jad_an() {
        if (jad_an == null) {
            synchronized (jad_er.class) {
                try {
                    if (jad_an == null) {
                        jad_an = new jad_er();
                    }
                } finally {
                }
            }
        }
        return jad_an;
    }
}
