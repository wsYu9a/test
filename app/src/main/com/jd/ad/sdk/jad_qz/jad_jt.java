package com.jd.ad.sdk.jad_qz;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes2.dex */
public class jad_jt {
    public static final jad_jt jad_bo = new jad_jt();
    public final LruCache<String, com.jd.ad.sdk.jad_lu.jad_jt> jad_an = new LruCache<>(20);

    @VisibleForTesting
    public jad_jt() {
    }

    public void jad_an(@Nullable String str, com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar) {
        if (str == null) {
            return;
        }
        this.jad_an.put(str, jad_jtVar);
    }
}
