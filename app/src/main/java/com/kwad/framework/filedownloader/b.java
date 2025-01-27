package com.kwad.framework.filedownloader;

import android.os.SystemClock;
import com.kwad.framework.filedownloader.s;

/* loaded from: classes3.dex */
public final class b implements s.a, s.b {
    private long agS;
    private long agT;
    private long agU;
    private int agV;
    private int agW = 1000;
    private long mStartTime;

    @Override // com.kwad.framework.filedownloader.s.b
    public final void O(long j10) {
        if (this.agW <= 0) {
            return;
        }
        if (this.agS != 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.agS;
            if (uptimeMillis < this.agW && (this.agV != 0 || uptimeMillis <= 0)) {
                return;
            }
            int i10 = (int) ((j10 - this.agT) / uptimeMillis);
            this.agV = i10;
            this.agV = Math.max(0, i10);
        }
        this.agT = j10;
        this.agS = SystemClock.uptimeMillis();
    }

    @Override // com.kwad.framework.filedownloader.s.b
    public final void end(long j10) {
        if (this.mStartTime <= 0) {
            return;
        }
        long j11 = j10 - this.agU;
        this.agS = 0L;
        long uptimeMillis = SystemClock.uptimeMillis() - this.mStartTime;
        if (uptimeMillis <= 0) {
            this.agV = (int) j11;
        } else {
            this.agV = (int) (j11 / uptimeMillis);
        }
    }

    @Override // com.kwad.framework.filedownloader.s.a
    public final int getSpeed() {
        return this.agV;
    }

    @Override // com.kwad.framework.filedownloader.s.b
    public final void reset() {
        this.agV = 0;
        this.agS = 0L;
    }

    @Override // com.kwad.framework.filedownloader.s.b
    public final void start(long j10) {
        this.mStartTime = SystemClock.uptimeMillis();
        this.agU = j10;
    }
}
