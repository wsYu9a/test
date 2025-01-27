package com.jd.ad.sdk.jad_en;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public final class jad_bo implements jad_fs, jad_dq {
    public final Object jad_an;

    @Nullable
    public final jad_fs jad_bo;
    public volatile jad_dq jad_cp;
    public volatile jad_dq jad_dq;

    @GuardedBy("requestLock")
    public int jad_er = 3;

    @GuardedBy("requestLock")
    public int jad_fs = 3;

    public jad_bo(Object obj, @Nullable jad_fs jad_fsVar) {
        this.jad_an = obj;
        this.jad_bo = jad_fsVar;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public void clear() {
        synchronized (this.jad_an) {
            try {
                this.jad_er = 3;
                this.jad_cp.clear();
                if (this.jad_fs != 3) {
                    this.jad_fs = 3;
                    this.jad_dq.clear();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public boolean isRunning() {
        boolean z10;
        synchronized (this.jad_an) {
            try {
                z10 = true;
                if (this.jad_er != 1 && this.jad_fs != 1) {
                    z10 = false;
                }
            } finally {
            }
        }
        return z10;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_fs, com.jd.ad.sdk.jad_en.jad_dq
    public boolean jad_an() {
        boolean z10;
        synchronized (this.jad_an) {
            try {
                z10 = this.jad_cp.jad_an() || this.jad_dq.jad_an();
            } finally {
            }
        }
        return z10;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_fs
    public jad_fs jad_bo() {
        jad_fs jad_bo;
        synchronized (this.jad_an) {
            try {
                jad_fs jad_fsVar = this.jad_bo;
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
        synchronized (this.jad_an) {
            try {
                z10 = this.jad_er == 4 || this.jad_fs == 4;
            } finally {
            }
        }
        return z10;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public void jad_dq() {
        synchronized (this.jad_an) {
            try {
                if (this.jad_er == 1) {
                    this.jad_er = 2;
                    this.jad_cp.jad_dq();
                }
                if (this.jad_fs == 1) {
                    this.jad_fs = 2;
                    this.jad_dq.jad_dq();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public boolean jad_er() {
        boolean z10;
        synchronized (this.jad_an) {
            try {
                z10 = this.jad_er == 3 && this.jad_fs == 3;
            } finally {
            }
        }
        return z10;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public void jad_fs() {
        synchronized (this.jad_an) {
            try {
                if (this.jad_er != 1) {
                    this.jad_er = 1;
                    this.jad_cp.jad_fs();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @GuardedBy("requestLock")
    public final boolean jad_jt(jad_dq jad_dqVar) {
        return jad_dqVar.equals(this.jad_cp) || (this.jad_er == 5 && jad_dqVar.equals(this.jad_dq));
    }

    @Override // com.jd.ad.sdk.jad_en.jad_fs
    public boolean jad_an(jad_dq jad_dqVar) {
        boolean z10;
        synchronized (this.jad_an) {
            try {
                jad_fs jad_fsVar = this.jad_bo;
                if (jad_fsVar != null) {
                    if (jad_fsVar.jad_an(this)) {
                    }
                }
                z10 = jad_jt(jad_dqVar);
            } finally {
            }
        }
        return z10;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_fs
    public boolean jad_bo(jad_dq jad_dqVar) {
        boolean z10;
        synchronized (this.jad_an) {
            try {
                jad_fs jad_fsVar = this.jad_bo;
                if (jad_fsVar != null) {
                    if (jad_fsVar.jad_bo(this)) {
                    }
                }
                z10 = jad_jt(jad_dqVar);
            } finally {
            }
        }
        return z10;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_fs
    public boolean jad_cp(jad_dq jad_dqVar) {
        boolean z10;
        synchronized (this.jad_an) {
            try {
                jad_fs jad_fsVar = this.jad_bo;
                if (jad_fsVar != null) {
                    if (jad_fsVar.jad_cp(this)) {
                    }
                }
                z10 = jad_jt(jad_dqVar);
            } finally {
            }
        }
        return z10;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_fs
    public void jad_dq(jad_dq jad_dqVar) {
        synchronized (this.jad_an) {
            try {
                if (jad_dqVar.equals(this.jad_cp)) {
                    this.jad_er = 4;
                } else if (jad_dqVar.equals(this.jad_dq)) {
                    this.jad_fs = 4;
                }
                jad_fs jad_fsVar = this.jad_bo;
                if (jad_fsVar != null) {
                    jad_fsVar.jad_dq(this);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public boolean jad_er(jad_dq jad_dqVar) {
        if (!(jad_dqVar instanceof jad_bo)) {
            return false;
        }
        jad_bo jad_boVar = (jad_bo) jad_dqVar;
        return this.jad_cp.jad_er(jad_boVar.jad_cp) && this.jad_dq.jad_er(jad_boVar.jad_dq);
    }

    @Override // com.jd.ad.sdk.jad_en.jad_fs
    public void jad_fs(jad_dq jad_dqVar) {
        synchronized (this.jad_an) {
            try {
                if (jad_dqVar.equals(this.jad_dq)) {
                    this.jad_fs = 5;
                    jad_fs jad_fsVar = this.jad_bo;
                    if (jad_fsVar != null) {
                        jad_fsVar.jad_fs(this);
                    }
                    return;
                }
                this.jad_er = 5;
                if (this.jad_fs != 1) {
                    this.jad_fs = 1;
                    this.jad_dq.jad_fs();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
