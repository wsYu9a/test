package com.kwad.sdk.utils;

import android.os.SystemClock;

/* loaded from: classes2.dex */
public final class bh {
    private long aBu;
    private long aBv;
    private boolean aBw;

    public bh() {
        reset();
    }

    private void reset() {
        this.aBu = 0L;
        this.aBv = -1L;
    }

    public final void EX() {
        if (this.aBw && this.aBv < 0) {
            this.aBv = SystemClock.elapsedRealtime();
        }
    }

    public final void EY() {
        if (this.aBw && this.aBv > 0) {
            this.aBu += SystemClock.elapsedRealtime() - this.aBv;
            this.aBv = -1L;
        }
    }

    public final long EZ() {
        if (!this.aBw) {
            return 0L;
        }
        this.aBw = false;
        if (this.aBv > 0) {
            this.aBu += SystemClock.elapsedRealtime() - this.aBv;
            this.aBv = -1L;
        }
        return this.aBu;
    }

    public final long getTime() {
        long j2 = this.aBv;
        long j3 = this.aBu;
        return j2 > 0 ? (j3 + SystemClock.elapsedRealtime()) - this.aBv : j3;
    }

    public final void startTiming() {
        reset();
        this.aBw = true;
        this.aBv = SystemClock.elapsedRealtime();
    }
}
