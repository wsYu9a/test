package com.kwai.filedownloader;

import android.os.SystemClock;
import com.kwai.filedownloader.s;

/* loaded from: classes2.dex */
public final class b implements s.a, s.b {
    private long aEP;
    private long aEQ;
    private long aER;
    private int aES;
    private int aET = 1000;
    private long mStartTime;

    @Override // com.kwai.filedownloader.s.b
    public final void aj(long j2) {
        if (this.aET <= 0) {
            return;
        }
        boolean z = true;
        if (this.aEP != 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.aEP;
            if (uptimeMillis >= this.aET || (this.aES == 0 && uptimeMillis > 0)) {
                int i2 = (int) ((j2 - this.aEQ) / uptimeMillis);
                this.aES = i2;
                this.aES = Math.max(0, i2);
            } else {
                z = false;
            }
        }
        if (z) {
            this.aEQ = j2;
            this.aEP = SystemClock.uptimeMillis();
        }
    }

    @Override // com.kwai.filedownloader.s.b
    public final void end(long j2) {
        if (this.mStartTime <= 0) {
            return;
        }
        long j3 = j2 - this.aER;
        this.aEP = 0L;
        long uptimeMillis = SystemClock.uptimeMillis() - this.mStartTime;
        if (uptimeMillis > 0) {
            j3 /= uptimeMillis;
        }
        this.aES = (int) j3;
    }

    @Override // com.kwai.filedownloader.s.a
    public final int getSpeed() {
        return this.aES;
    }

    @Override // com.kwai.filedownloader.s.b
    public final void reset() {
        this.aES = 0;
        this.aEP = 0L;
    }

    @Override // com.kwai.filedownloader.s.b
    public final void start(long j2) {
        this.mStartTime = SystemClock.uptimeMillis();
        this.aER = j2;
    }
}
