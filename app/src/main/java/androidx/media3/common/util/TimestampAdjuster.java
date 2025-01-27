package androidx.media3.common.util;

import androidx.annotation.GuardedBy;
import androidx.media3.common.C;
import java.util.concurrent.TimeoutException;

@UnstableApi
/* loaded from: classes.dex */
public final class TimestampAdjuster {
    private static final long MAX_PTS_PLUS_ONE = 8589934592L;
    public static final long MODE_NO_OFFSET = Long.MAX_VALUE;
    public static final long MODE_SHARED = 9223372036854775806L;

    @GuardedBy("this")
    private long firstSampleTimestampUs;

    @GuardedBy("this")
    private long lastUnadjustedTimestampUs;
    private final ThreadLocal<Long> nextSampleTimestampUs = new ThreadLocal<>();

    @GuardedBy("this")
    private long timestampOffsetUs;

    public TimestampAdjuster(long j10) {
        reset(j10);
    }

    public static long ptsToUs(long j10) {
        return (j10 * C.MICROS_PER_SECOND) / 90000;
    }

    public static long usToNonWrappedPts(long j10) {
        return (j10 * 90000) / C.MICROS_PER_SECOND;
    }

    public static long usToWrappedPts(long j10) {
        return usToNonWrappedPts(j10) % MAX_PTS_PLUS_ONE;
    }

    public synchronized long adjustSampleTimestamp(long j10) {
        if (j10 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        try {
            if (!isInitialized()) {
                long j11 = this.firstSampleTimestampUs;
                if (j11 == MODE_SHARED) {
                    j11 = ((Long) Assertions.checkNotNull(this.nextSampleTimestampUs.get())).longValue();
                }
                this.timestampOffsetUs = j11 - j10;
                notifyAll();
            }
            this.lastUnadjustedTimestampUs = j10;
            return j10 + this.timestampOffsetUs;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized long adjustTsTimestamp(long j10) {
        if (j10 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        try {
            long j11 = this.lastUnadjustedTimestampUs;
            if (j11 != C.TIME_UNSET) {
                long usToNonWrappedPts = usToNonWrappedPts(j11);
                long j12 = (4294967296L + usToNonWrappedPts) / MAX_PTS_PLUS_ONE;
                long j13 = ((j12 - 1) * MAX_PTS_PLUS_ONE) + j10;
                j10 += j12 * MAX_PTS_PLUS_ONE;
                if (Math.abs(j13 - usToNonWrappedPts) < Math.abs(j10 - usToNonWrappedPts)) {
                    j10 = j13;
                }
            }
            return adjustSampleTimestamp(ptsToUs(j10));
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized long getFirstSampleTimestampUs() {
        long j10;
        j10 = this.firstSampleTimestampUs;
        if (j10 == Long.MAX_VALUE || j10 == MODE_SHARED) {
            j10 = C.TIME_UNSET;
        }
        return j10;
    }

    public synchronized long getLastAdjustedTimestampUs() {
        long j10;
        try {
            j10 = this.lastUnadjustedTimestampUs;
        } catch (Throwable th2) {
            throw th2;
        }
        return j10 != C.TIME_UNSET ? j10 + this.timestampOffsetUs : getFirstSampleTimestampUs();
    }

    public synchronized long getTimestampOffsetUs() {
        return this.timestampOffsetUs;
    }

    public synchronized boolean isInitialized() {
        return this.timestampOffsetUs != C.TIME_UNSET;
    }

    public synchronized void reset(long j10) {
        this.firstSampleTimestampUs = j10;
        this.timestampOffsetUs = j10 == Long.MAX_VALUE ? 0L : -9223372036854775807L;
        this.lastUnadjustedTimestampUs = C.TIME_UNSET;
    }

    public synchronized void sharedInitializeOrWait(boolean z10, long j10, long j11) throws InterruptedException, TimeoutException {
        try {
            Assertions.checkState(this.firstSampleTimestampUs == MODE_SHARED);
            if (isInitialized()) {
                return;
            }
            if (z10) {
                this.nextSampleTimestampUs.set(Long.valueOf(j10));
            } else {
                long j12 = 0;
                long j13 = j11;
                while (!isInitialized()) {
                    if (j11 == 0) {
                        wait();
                    } else {
                        Assertions.checkState(j13 > 0);
                        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
                        wait(j13);
                        j12 += android.os.SystemClock.elapsedRealtime() - elapsedRealtime;
                        if (j12 >= j11 && !isInitialized()) {
                            throw new TimeoutException("TimestampAdjuster failed to initialize in " + j11 + " milliseconds");
                        }
                        j13 = j11 - j12;
                    }
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
