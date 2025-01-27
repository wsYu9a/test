package com.jd.ad.sdk.jad_re;

import com.jd.ad.sdk.bl.initsdk.JADYunSdkConfig;
import com.jd.ad.sdk.jad_fq.jad_cp;
import com.jd.ad.sdk.jad_qd.jad_jt;
import com.jd.ad.sdk.jad_uh.jad_an;
import com.jd.ad.sdk.jad_uh.jad_bo;
import com.jd.ad.sdk.jad_uh.jad_dq;
import com.jd.ad.sdk.jad_xk.jad_fs;
import h3.e;
import java.util.Map;

/* loaded from: classes2.dex */
public class jad_bo implements Runnable {
    public final /* synthetic */ JADYunSdkConfig jad_an;

    public jad_bo(JADYunSdkConfig jADYunSdkConfig) {
        this.jad_an = jADYunSdkConfig;
    }

    @Override // java.lang.Runnable
    public void run() {
        jad_an.jad_bo.jad_an.getClass();
        com.jd.ad.sdk.jad_uh.jad_bo jad_boVar = jad_bo.jad_an.jad_an;
        jad_boVar.getClass();
        if (jad_jt.jad_dq(jad_cp.jad_an())) {
            jad_boVar.jad_cp = jad_dq.jad_an("jadyunsdk");
            jad_boVar.jad_bo.readLock().lock();
            try {
                Map<String, ?> all = jad_boVar.jad_cp.jad_an.getAll();
                if (all != null && !all.isEmpty()) {
                    jad_boVar.jad_an.putAll(all);
                }
            } catch (Exception e10) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_LOAD_DISC_TO_MEMORY_ERROR;
                jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e10.getMessage()));
            } finally {
                jad_boVar.jad_bo.readLock().unlock();
            }
        }
        jad_an.jad_bo.jad_an.jad_an(e.f26403h, this.jad_an.getAppId());
    }
}
