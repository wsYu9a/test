package com.ss.android.socialbase.downloader.network;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.thread.DownloadWatchDog;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class DeviceBandwidthSampler {
    private static final String TAG = "DeviceBandwidthSampler";
    private static volatile DeviceBandwidthSampler instance = null;
    public static volatile boolean isWifi = false;
    private static long sPreviousBytes = -1;
    private long mLastTimeReading;
    private final NetTrafficManager mNetTrafficManager = NetTrafficManager.getInstance();
    private final AtomicInteger mSamplingCounter = new AtomicInteger();
    private final SamplingHandler mHandler = new SamplingHandler(DownloadWatchDog.getThreadLooper());

    public class SamplingHandler extends Handler {
        private static final int MSG_START = 1;
        static final long SAMPLE_TIME = 1000;

        public SamplingHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            DeviceBandwidthSampler.this.addSample();
            sendEmptyMessageDelayed(1, 1000L);
        }

        public void startSamplingThread() {
            sendEmptyMessage(1);
        }

        public void stopSamplingThread() {
            removeMessages(1);
        }
    }

    private DeviceBandwidthSampler() {
    }

    public static long getAllRxBytesWifi() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    public static DeviceBandwidthSampler getInstance() {
        if (instance == null) {
            synchronized (DeviceBandwidthSampler.class) {
                try {
                    if (instance == null) {
                        instance = new DeviceBandwidthSampler();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    public static void updateWifiStatus() {
        isWifi = DownloadUtils.isWifi(DownloadComponentManager.getAppContext());
    }

    public void addFinalSample() {
        addSample();
        sPreviousBytes = -1L;
    }

    public void addSample() {
        try {
            updateWifiStatus();
            long allRxBytesWifi = isWifi ? getAllRxBytesWifi() : TrafficStats.getMobileRxBytes();
            long j10 = sPreviousBytes;
            long j11 = allRxBytesWifi - j10;
            if (j10 >= 0) {
                synchronized (this) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    this.mNetTrafficManager.addBandwidth(j11, uptimeMillis - this.mLastTimeReading);
                    this.mLastTimeReading = uptimeMillis;
                }
            }
            sPreviousBytes = allRxBytesWifi;
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public boolean isSampling() {
        return this.mSamplingCounter.get() != 0;
    }

    public void startSampling() {
        try {
            Logger.i(TAG, "startSampling: mSamplingCounter = " + this.mSamplingCounter);
            if (this.mSamplingCounter.getAndIncrement() == 0) {
                this.mHandler.startSamplingThread();
                this.mLastTimeReading = SystemClock.uptimeMillis();
            }
        } catch (Throwable unused) {
        }
    }

    public void stopSampling() {
        try {
            Logger.i(TAG, "stopSampling: mSamplingCounter = " + this.mSamplingCounter);
            if (this.mSamplingCounter.decrementAndGet() == 0) {
                this.mHandler.stopSamplingThread();
                addFinalSample();
            }
        } catch (Throwable unused) {
        }
    }
}
