package com.jd.ad.sdk.jad_xg;

import com.jd.ad.sdk.jad_lu.jad_pc;
import java.util.HashSet;

/* loaded from: classes2.dex */
public class jad_dq {
    public static jad_pc jad_an = new jad_cp();

    public static void jad_an(String str) {
        ((jad_cp) jad_an).getClass();
        HashSet hashSet = (HashSet) jad_cp.jad_an;
        if (hashSet.contains(str)) {
            return;
        }
        hashSet.add(str);
    }

    public static void jad_an(String str, Throwable th2) {
        ((jad_cp) jad_an).getClass();
        HashSet hashSet = (HashSet) jad_cp.jad_an;
        if (hashSet.contains(str)) {
            return;
        }
        hashSet.add(str);
    }
}
