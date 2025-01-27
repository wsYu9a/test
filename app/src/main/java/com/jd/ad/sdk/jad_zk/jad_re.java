package com.jd.ad.sdk.jad_zk;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;
import p3.f;

/* loaded from: classes2.dex */
public class jad_re {
    public final Set<com.jd.ad.sdk.jad_en.jad_dq> jad_an = Collections.newSetFromMap(new WeakHashMap());
    public final Set<com.jd.ad.sdk.jad_en.jad_dq> jad_bo = new HashSet();
    public boolean jad_cp;

    public boolean jad_an(@Nullable com.jd.ad.sdk.jad_en.jad_dq jad_dqVar) {
        boolean z10 = true;
        if (jad_dqVar == null) {
            return true;
        }
        boolean remove = this.jad_an.remove(jad_dqVar);
        if (!this.jad_bo.remove(jad_dqVar) && !remove) {
            z10 = false;
        }
        if (z10) {
            jad_dqVar.clear();
        }
        return z10;
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.jad_an.size() + ", isPaused=" + this.jad_cp + f.f29748d;
    }
}
