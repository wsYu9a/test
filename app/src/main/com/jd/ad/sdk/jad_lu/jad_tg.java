package com.jd.ad.sdk.jad_lu;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class jad_tg implements Runnable {
    public final /* synthetic */ jad_uh jad_an;

    public jad_tg(jad_uh jad_uhVar) {
        this.jad_an = jad_uhVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public void run() {
        if (this.jad_an.jad_dq == null) {
            return;
        }
        jad_sf<T> jad_sfVar = this.jad_an.jad_dq;
        V v10 = jad_sfVar.jad_an;
        if (v10 != 0) {
            jad_uh jad_uhVar = this.jad_an;
            synchronized (jad_uhVar) {
                Iterator it = new ArrayList(jad_uhVar.jad_an).iterator();
                while (it.hasNext()) {
                    ((jad_ob) it.next()).jad_an(v10);
                }
            }
            return;
        }
        jad_uh jad_uhVar2 = this.jad_an;
        Throwable th2 = jad_sfVar.jad_bo;
        synchronized (jad_uhVar2) {
            ArrayList arrayList = new ArrayList(jad_uhVar2.jad_bo);
            if (arrayList.isEmpty()) {
                com.jd.ad.sdk.jad_xg.jad_dq.jad_an("Lottie encountered an error but no failure listener was added:", th2);
            } else {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((jad_ob) it2.next()).jad_an(th2);
                }
            }
        }
    }
}
