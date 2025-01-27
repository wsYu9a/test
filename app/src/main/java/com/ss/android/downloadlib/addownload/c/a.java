package com.ss.android.downloadlib.addownload.c;

import com.ss.android.downloadlib.g.k;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceCallback;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;

/* loaded from: classes4.dex */
public class a implements IDownloadDiskSpaceHandler {

    /* renamed from: a */
    private int f21244a;

    private long b(DownloadSetting downloadSetting) {
        long optLong = downloadSetting.optLong("clear_space_sleep_time", 0L);
        if (optLong <= 0) {
            return 0L;
        }
        if (optLong > 5000) {
            optLong = 5000;
        }
        k.b("AppDownloadDiskSpaceHandler", "waiting for space clear, sleepTime = " + optLong, null);
        try {
            Thread.sleep(optLong);
        } catch (InterruptedException e10) {
            e10.printStackTrace();
        }
        k.b("AppDownloadDiskSpaceHandler", "waiting end!", null);
        return optLong;
    }

    public void a(int i10) {
        this.f21244a = i10;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler
    public boolean cleanUpDisk(long j10, long j11, IDownloadDiskSpaceCallback iDownloadDiskSpaceCallback) {
        long j12;
        DownloadSetting obtain = DownloadSetting.obtain(this.f21244a);
        if (!a(obtain)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        d.a().c();
        long b10 = m.b(0L);
        a();
        long b11 = m.b(0L);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (b11 < j11) {
            long b12 = b(obtain);
            if (b12 > 0) {
                b11 = m.b(0L);
            }
            j12 = b12;
        } else {
            j12 = 0;
        }
        k.b("AppDownloadDiskSpaceHandler", "cleanUpDisk, byteRequired = " + j11 + ", byteAvailableAfter = " + b11 + ", cleaned = " + (b11 - b10), null);
        long j13 = b11;
        a(b10, b11, j11, currentTimeMillis2, j12);
        if (j13 < j11) {
            return false;
        }
        if (iDownloadDiskSpaceCallback == null) {
            return true;
        }
        iDownloadDiskSpaceCallback.onDiskCleaned();
        return true;
    }

    private boolean a(DownloadSetting downloadSetting) {
        if (downloadSetting.optInt("clear_space_use_disk_handler", 0) != 1) {
            return false;
        }
        return System.currentTimeMillis() - d.a().b() >= downloadSetting.optLong("clear_space_min_time_interval", 600000L);
    }

    private void a() {
        com.ss.android.download.api.config.e q10 = com.ss.android.downloadlib.addownload.k.q();
        if (q10 != null) {
            q10.a();
        }
        c.a();
        c.b();
    }

    private void a(long j10, long j11, long j12, long j13, long j14) {
        DownloadInfo downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.k.a()).getDownloadInfo(this.f21244a);
        if (downloadInfo == null) {
            return;
        }
        try {
            com.ss.android.downloadlib.a.a().a(downloadInfo, j10, j11, j12, j13, j14, j11 > j12);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
