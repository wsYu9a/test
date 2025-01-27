package com.ss.android.downloadlib.addownload;

import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;

/* loaded from: classes4.dex */
public class k {
    public static int j(int i2, int i3) {
        return (i3 <= 0 || i3 >= 100 || !j(i2)) ? i3 : (int) (Math.sqrt(i3) * 10.0d);
    }

    public static long j(int i2, long j2, long j3) {
        if (!j(i2)) {
            return j2;
        }
        if (j2 <= 0) {
            return 0L;
        }
        return j3 <= 0 ? j2 : (j3 * j(i2, (int) ((j2 * 100) / j3))) / 100;
    }

    public static DownloadShortInfo j(DownloadShortInfo downloadShortInfo) {
        if (downloadShortInfo != null && j((int) downloadShortInfo.id)) {
            downloadShortInfo.currentBytes = j((int) downloadShortInfo.id, downloadShortInfo.currentBytes, downloadShortInfo.totalBytes);
        }
        return downloadShortInfo;
    }

    private static boolean j(int i2) {
        return DownloadSetting.obtain(i2).optInt("pause_optimise_pretend_download_percent_switch", 0) == 1 && DownloadSetting.obtain(i2).optInt("pause_optimise_switch", 0) == 1;
    }
}
