package cn.vlion.ad.inland.base.util.timer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class VlionTimer {
    private static volatile VlionTimer sInstance;
    private ScheduledExecutorService mScheduledService;

    public static VlionTimer getInstance() {
        if (sInstance == null) {
            synchronized (VlionTimer.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new VlionTimer();
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    private ScheduledExecutorService getScheduledService() {
        ScheduledExecutorService scheduledExecutorService = this.mScheduledService;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            this.mScheduledService = Executors.newScheduledThreadPool(10);
        }
        return this.mScheduledService;
    }

    public ScheduledFuture startInterval(long j10, long j11, Runnable runnable) {
        return getScheduledService().scheduleAtFixedRate(runnable, j10, j11, TimeUnit.SECONDS);
    }

    public ScheduledFuture startTimer(long j10, Runnable runnable) {
        return getScheduledService().schedule(runnable, j10, TimeUnit.SECONDS);
    }

    public ScheduledFuture startTimerMillisecond(long j10, Runnable runnable) {
        return getScheduledService().schedule(runnable, j10, TimeUnit.MILLISECONDS);
    }
}
