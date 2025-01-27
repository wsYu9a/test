package com.jd.ad.sdk.jad_en;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public class jad_kx implements jad_fs, jad_dq {

    @Nullable
    public final jad_fs jad_an;
    public final Object jad_bo;
    public volatile jad_dq jad_cp;
    public volatile jad_dq jad_dq;

    @GuardedBy("requestLock")
    public int jad_er = 3;

    @GuardedBy("requestLock")
    public int jad_fs = 3;

    @GuardedBy("requestLock")
    public boolean jad_jt;

    public jad_kx(Object obj, @Nullable jad_fs jad_fsVar) {
        this.jad_bo = obj;
        this.jad_an = jad_fsVar;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public void clear() {
        synchronized (this.jad_bo) {
            this.jad_jt = false;
            this.jad_er = 3;
            this.jad_fs = 3;
            this.jad_dq.clear();
            this.jad_cp.clear();
        }
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public boolean isRunning() {
        boolean z10;
        synchronized (this.jad_bo) {
            z10 = true;
            if (this.jad_er != 1) {
                z10 = false;
            }
        }
        return z10;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_fs, com.jd.ad.sdk.jad_en.jad_dq
    public boolean jad_an() {
        boolean z10;
        synchronized (this.jad_bo) {
            try {
                z10 = this.jad_dq.jad_an() || this.jad_cp.jad_an();
            } finally {
            }
        }
        return z10;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_fs
    public jad_fs jad_bo() {
        jad_fs jad_bo;
        synchronized (this.jad_bo) {
            try {
                jad_fs jad_fsVar = this.jad_an;
                jad_bo = jad_fsVar != null ? jad_fsVar.jad_bo() : this;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return jad_bo;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public boolean jad_cp() {
        boolean z10;
        synchronized (this.jad_bo) {
            z10 = this.jad_er == 4;
        }
        return z10;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_fs
    public void jad_dq(jad_dq jad_dqVar) {
        synchronized (this.jad_bo) {
            try {
                if (jad_dqVar.equals(this.jad_dq)) {
                    this.jad_fs = 4;
                    return;
                }
                this.jad_er = 4;
                jad_fs jad_fsVar = this.jad_an;
                if (jad_fsVar != null) {
                    jad_fsVar.jad_dq(this);
                }
                if (!jad_er.jad_an(this.jad_fs)) {
                    this.jad_dq.clear();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public boolean jad_er() {
        boolean z10;
        synchronized (this.jad_bo) {
            z10 = this.jad_er == 3;
        }
        return z10;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public void jad_fs() {
        synchronized (this.jad_bo) {
            try {
                this.jad_jt = true;
                try {
                    if (this.jad_er != 4 && this.jad_fs != 1) {
                        this.jad_fs = 1;
                        this.jad_dq.jad_fs();
                    }
                    if (this.jad_jt && this.jad_er != 1) {
                        this.jad_er = 1;
                        this.jad_cp.jad_fs();
                    }
                    this.jad_jt = false;
                } catch (Throwable th2) {
                    this.jad_jt = false;
                    throw th2;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_en.jad_fs
    public boolean jad_an(jad_dq jad_dqVar) {
        boolean z10;
        synchronized (this.jad_bo) {
            try {
                jad_fs jad_fsVar = this.jad_an;
                if (jad_fsVar != null) {
                    if (jad_fsVar.jad_an(this)) {
                    }
                    z10 = false;
                }
                if (!jad_dqVar.equals(this.jad_cp)) {
                    if (this.jad_er != 4) {
                    }
                    z10 = false;
                }
                z10 = true;
            } finally {
            }
        }
        return z10;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_fs
    public boolean jad_bo(jad_dq jad_dqVar) {
        boolean z10;
        synchronized (this.jad_bo) {
            try {
                jad_fs jad_fsVar = this.jad_an;
                if (jad_fsVar != null) {
                    if (jad_fsVar.jad_bo(this)) {
                    }
                }
                z10 = jad_dqVar.equals(this.jad_cp) && !jad_an();
            } finally {
            }
        }
        return z10;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_fs
    public boolean jad_cp(jad_dq jad_dqVar) {
        boolean z10;
        synchronized (this.jad_bo) {
            try {
                jad_fs jad_fsVar = this.jad_an;
                if (jad_fsVar != null) {
                    if (jad_fsVar.jad_cp(this)) {
                    }
                }
                z10 = jad_dqVar.equals(this.jad_cp) && this.jad_er != 2;
            } finally {
            }
        }
        return z10;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public boolean jad_er(jad_dq jad_dqVar) {
        if (!(jad_dqVar instanceof jad_kx)) {
            return false;
        }
        jad_kx jad_kxVar = (jad_kx) jad_dqVar;
        if (this.jad_cp == null) {
            if (jad_kxVar.jad_cp != null) {
                return false;
            }
        } else if (!this.jad_cp.jad_er(jad_kxVar.jad_cp)) {
            return false;
        }
        if (this.jad_dq == null) {
            if (jad_kxVar.jad_dq != null) {
                return false;
            }
        } else if (!this.jad_dq.jad_er(jad_kxVar.jad_dq)) {
            return false;
        }
        return true;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_fs
    public void jad_fs(jad_dq jad_dqVar) {
        synchronized (this.jad_bo) {
            try {
                if (!jad_dqVar.equals(this.jad_cp)) {
                    this.jad_fs = 5;
                    return;
                }
                this.jad_er = 5;
                jad_fs jad_fsVar = this.jad_an;
                if (jad_fsVar != null) {
                    jad_fsVar.jad_fs(this);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public void jad_dq() {
        synchronized (this.jad_bo) {
            try {
                if (!jad_er.jad_an(this.jad_fs)) {
                    this.jad_fs = 2;
                    this.jad_dq.jad_dq();
                }
                if (!jad_er.jad_an(this.jad_er)) {
                    this.jad_er = 2;
                    this.jad_cp.jad_dq();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
