package com.jd.ad.sdk.jad_ny;

import com.jd.ad.sdk.jad_ny.jad_mz;
import java.util.Queue;

/* loaded from: classes2.dex */
public abstract class jad_dq<T extends jad_mz> {
    public final Queue<T> jad_an = com.jd.ad.sdk.jad_ir.jad_ly.jad_an(20);

    public abstract T jad_an();

    public T jad_bo() {
        T poll = this.jad_an.poll();
        return poll == null ? jad_an() : poll;
    }
}
