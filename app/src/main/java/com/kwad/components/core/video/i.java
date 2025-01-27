package com.kwad.components.core.video;

import android.os.SystemClock;
import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public final class i {
    private volatile boolean XD;
    private long XE;
    private a XF = new a();

    public static class a {
        private long XG = 0;
        private int XH = 0;

        public final void accumulate(long j10) {
            this.XG += j10;
            this.XH++;
        }

        public final void reset() {
            this.XG = 0L;
            this.XH = 0;
        }

        public final int sY() {
            return this.XH;
        }

        public final long sZ() {
            return this.XG;
        }
    }

    public final void reset() {
        this.XD = false;
        this.XE = 0L;
        this.XF.reset();
    }

    public final void sT() {
        if (this.XD) {
            return;
        }
        this.XD = true;
        this.XE = SystemClock.elapsedRealtime();
        com.kwad.sdk.core.video.a.a.a.eH("videoStartBlock");
    }

    public final void sU() {
        if (this.XD) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.XE;
            this.XF.accumulate(elapsedRealtime);
            this.XD = false;
            com.kwad.sdk.core.video.a.a.a.eH("videoEndBlock");
            com.kwad.sdk.core.video.a.a.a.eH("videoBlockTime_" + elapsedRealtime);
        }
    }

    public final boolean sV() {
        return this.XD;
    }

    @NonNull
    public final a sW() {
        if (this.XD) {
            this.XF.accumulate(SystemClock.elapsedRealtime() - this.XE);
            this.XD = false;
        }
        return this.XF;
    }

    public final long sX() {
        return this.XE;
    }
}
