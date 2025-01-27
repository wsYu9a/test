package com.kwad.sdk.utils;

import android.os.SystemClock;

/* loaded from: classes3.dex */
public final class bs {
    private long aVE;
    private long aVF;
    private boolean aVG;

    public bs() {
        reset();
    }

    private void reset() {
        this.aVE = 0L;
        this.aVF = -1L;
    }

    public final void Pn() {
        if (this.aVG && this.aVF < 0) {
            this.aVF = SystemClock.elapsedRealtime();
        }
    }

    public final void Po() {
        if (this.aVG && this.aVF > 0) {
            this.aVE += SystemClock.elapsedRealtime() - this.aVF;
            this.aVF = -1L;
        }
    }

    public final long Pp() {
        if (!this.aVG) {
            return 0L;
        }
        this.aVG = false;
        if (this.aVF > 0) {
            this.aVE += SystemClock.elapsedRealtime() - this.aVF;
            this.aVF = -1L;
        }
        return this.aVE;
    }

    public final long getTime() {
        return this.aVF > 0 ? (this.aVE + SystemClock.elapsedRealtime()) - this.aVF : this.aVE;
    }

    public final void startTiming() {
        reset();
        this.aVG = true;
        this.aVF = SystemClock.elapsedRealtime();
    }
}
