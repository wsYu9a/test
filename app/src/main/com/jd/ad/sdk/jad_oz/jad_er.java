package com.jd.ad.sdk.jad_oz;

import android.util.Log;
import com.jd.ad.sdk.jad_hs.jad_an;
import com.jd.ad.sdk.jad_oz.jad_an;
import com.jd.ad.sdk.jad_oz.jad_cp;
import com.jd.ad.sdk.logger.Logger;
import java.io.File;
import java.io.IOException;
import ve.a;

/* loaded from: classes2.dex */
public class jad_er implements jad_an {
    public final File jad_bo;
    public final long jad_cp;
    public com.jd.ad.sdk.jad_hs.jad_an jad_er;
    public final jad_cp jad_dq = new jad_cp();
    public final jad_jw jad_an = new jad_jw();

    @Deprecated
    public jad_er(File file, long j10) {
        this.jad_bo = file;
        this.jad_cp = j10;
    }

    @Override // com.jd.ad.sdk.jad_oz.jad_an
    public File jad_an(com.jd.ad.sdk.jad_ju.jad_hu jad_huVar) {
        String jad_an = this.jad_an.jad_an(jad_huVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Logger.v("DiskLruCacheWrapper", "Get: Obtained: " + jad_an + " for for Key: " + jad_huVar);
        }
        try {
            jad_an.jad_er jad_bo = jad_an().jad_bo(jad_an);
            if (jad_bo != null) {
                return jad_bo.jad_an(0);
            }
        } catch (IOException e10) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Logger.w("DiskLruCacheWrapper", "Unable to get from disk cache", e10);
            }
        }
        return null;
    }

    public final synchronized com.jd.ad.sdk.jad_hs.jad_an jad_an() {
        try {
            if (this.jad_er == null) {
                File file = this.jad_bo;
                long j10 = this.jad_cp;
                if (j10 <= 0) {
                    throw new IllegalArgumentException("maxSize <= 0");
                }
                File file2 = new File(file, a.f31466t);
                if (file2.exists()) {
                    File file3 = new File(file, a.f31464r);
                    if (file3.exists()) {
                        file2.delete();
                    } else {
                        com.jd.ad.sdk.jad_hs.jad_an.jad_an(file2, file3, false);
                    }
                }
                com.jd.ad.sdk.jad_hs.jad_an jad_anVar = new com.jd.ad.sdk.jad_hs.jad_an(file, 1, 1, j10);
                if (jad_anVar.jad_bo.exists()) {
                    try {
                        jad_anVar.jad_er();
                        jad_anVar.jad_dq();
                    } catch (IOException e10) {
                        System.out.println("DiskLruCache " + file + " is corrupt: " + e10.getMessage() + ", removing");
                        jad_anVar.close();
                        com.jd.ad.sdk.jad_hs.jad_cp.jad_an(jad_anVar.jad_an);
                    }
                    this.jad_er = jad_anVar;
                }
                file.mkdirs();
                jad_anVar = new com.jd.ad.sdk.jad_hs.jad_an(file, 1, 1, j10);
                jad_anVar.jad_fs();
                this.jad_er = jad_anVar;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.jad_er;
    }

    @Override // com.jd.ad.sdk.jad_oz.jad_an
    public void jad_an(com.jd.ad.sdk.jad_ju.jad_hu jad_huVar, jad_an.jad_bo jad_boVar) {
        jad_cp.jad_an jad_anVar;
        com.jd.ad.sdk.jad_hs.jad_an jad_an;
        boolean z10;
        String jad_an2 = this.jad_an.jad_an(jad_huVar);
        jad_cp jad_cpVar = this.jad_dq;
        synchronized (jad_cpVar) {
            try {
                jad_anVar = jad_cpVar.jad_an.get(jad_an2);
                if (jad_anVar == null) {
                    jad_cp.jad_bo jad_boVar2 = jad_cpVar.jad_bo;
                    synchronized (jad_boVar2.jad_an) {
                        jad_anVar = jad_boVar2.jad_an.poll();
                    }
                    if (jad_anVar == null) {
                        jad_anVar = new jad_cp.jad_an();
                    }
                    jad_cpVar.jad_an.put(jad_an2, jad_anVar);
                }
                jad_anVar.jad_bo++;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        jad_anVar.jad_an.lock();
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Logger.v("DiskLruCacheWrapper", "Put: Obtained: " + jad_an2 + " for for Key: " + jad_huVar);
            }
            try {
                jad_an = jad_an();
            } catch (IOException e10) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Logger.w("DiskLruCacheWrapper", "Unable to put to disk cache", e10);
                }
            }
            if (jad_an.jad_bo(jad_an2) != null) {
                return;
            }
            jad_an.jad_cp jad_an3 = jad_an.jad_an(jad_an2);
            if (jad_an3 == null) {
                throw new IllegalStateException("Had two simultaneous puts for: " + jad_an2);
            }
            try {
                com.jd.ad.sdk.jad_mx.jad_er jad_erVar = (com.jd.ad.sdk.jad_mx.jad_er) jad_boVar;
                if (jad_erVar.jad_an.jad_an(jad_erVar.jad_bo, jad_an3.jad_an(0), jad_erVar.jad_cp)) {
                    com.jd.ad.sdk.jad_hs.jad_an.jad_an(com.jd.ad.sdk.jad_hs.jad_an.this, jad_an3, true);
                    jad_an3.jad_cp = true;
                }
                if (!z10) {
                    try {
                        jad_an3.jad_an();
                    } catch (IOException unused) {
                    }
                }
            } finally {
                if (!jad_an3.jad_cp) {
                    try {
                        jad_an3.jad_an();
                    } catch (IOException unused2) {
                    }
                }
            }
        } finally {
            this.jad_dq.jad_an(jad_an2);
        }
    }
}
