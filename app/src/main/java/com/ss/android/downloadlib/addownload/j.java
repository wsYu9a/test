package com.ss.android.downloadlib.addownload;

import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;

/* loaded from: classes4.dex */
public class j {
    public static int a(int i10, int i11) {
        return (i11 <= 0 || i11 >= 100 || !a(i10)) ? i11 : (int) (Math.sqrt(i11) * 10.0d);
    }

    public static long a(int i10, long j10, long j11) {
        if (!a(i10)) {
            return j10;
        }
        if (j10 <= 0) {
            return 0L;
        }
        return j11 <= 0 ? j10 : (j11 * a(i10, (int) ((j10 * 100) / j11))) / 100;
    }

    public static DownloadShortInfo a(DownloadShortInfo downloadShortInfo) {
        if (downloadShortInfo != null && a((int) downloadShortInfo.f20978id)) {
            downloadShortInfo.currentBytes = a((int) downloadShortInfo.f20978id, downloadShortInfo.currentBytes, downloadShortInfo.totalBytes);
        }
        return downloadShortInfo;
    }

    private static boolean a(int i10) {
        return DownloadSetting.obtain(i10).optInt("pause_optimise_pretend_download_percent_switch", 0) == 1 && DownloadSetting.obtain(i10).optInt("pause_optimise_switch", 0) == 1;
    }
}
