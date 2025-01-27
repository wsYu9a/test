package com.ss.android.downloadlib.addownload.i;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.ss.android.downloadlib.addownload.pa;
import com.ss.android.downloadlib.lg.nt;
import com.ss.android.downloadlib.lg.t;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceCallback;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;

/* loaded from: classes4.dex */
public class j implements IDownloadDiskSpaceHandler {

    /* renamed from: j */
    private int f24166j;

    private long zx(DownloadSetting downloadSetting) {
        long optLong = downloadSetting.optLong("clear_space_sleep_time", 0L);
        if (optLong <= 0) {
            return 0L;
        }
        if (optLong > 5000) {
            optLong = 5000;
        }
        t.zx("AppDownloadDiskSpaceHandler", "waiting for space clear, sleepTime = " + optLong, null);
        try {
            Thread.sleep(optLong);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        t.zx("AppDownloadDiskSpaceHandler", "waiting end!", null);
        return optLong;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler
    public boolean cleanUpDisk(long j2, long j3, IDownloadDiskSpaceCallback iDownloadDiskSpaceCallback) {
        long j4;
        DownloadSetting obtain = DownloadSetting.obtain(this.f24166j);
        if (!j(obtain)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        g.j().i();
        long j5 = nt.j(0L);
        j();
        long j6 = nt.j(0L);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (j6 < j3) {
            long zx = zx(obtain);
            if (zx > 0) {
                j6 = nt.j(0L);
            }
            j4 = zx;
        } else {
            j4 = 0;
        }
        t.zx("AppDownloadDiskSpaceHandler", "cleanUpDisk, byteRequired = " + j3 + ", byteAvailableAfter = " + j6 + ", cleaned = " + (j6 - j5), null);
        long j7 = j6;
        j(j5, j6, j3, currentTimeMillis2, j4);
        if (j7 < j3) {
            return false;
        }
        if (iDownloadDiskSpaceCallback == null) {
            return true;
        }
        iDownloadDiskSpaceCallback.onDiskCleaned();
        return true;
    }

    public void j(int i2) {
        this.f24166j = i2;
    }

    private boolean j(DownloadSetting downloadSetting) {
        if (downloadSetting.optInt("clear_space_use_disk_handler", 0) != 1) {
            return false;
        }
        return System.currentTimeMillis() - g.j().zx() >= downloadSetting.optLong("clear_space_min_time_interval", TTAdConstant.AD_MAX_EVENT_TIME);
    }

    private void j() {
        com.ss.android.download.api.config.q w = pa.w();
        if (w != null) {
            w.j();
        }
        i.j();
        i.zx();
    }

    private void j(long j2, long j3, long j4, long j5, long j6) {
        DownloadInfo downloadInfo = Downloader.getInstance(pa.getContext()).getDownloadInfo(this.f24166j);
        if (downloadInfo == null) {
            return;
        }
        try {
            com.ss.android.downloadlib.j.j().j(downloadInfo, j2, j3, j4, j5, j6, j3 > j4);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
