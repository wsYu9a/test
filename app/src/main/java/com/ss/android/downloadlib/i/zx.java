package com.ss.android.downloadlib.i;

import android.content.pm.PackageInfo;
import com.ss.android.downloadlib.addownload.pa;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: classes4.dex */
public class zx implements IDownloadCompleteHandler {
    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
    public void handle(DownloadInfo downloadInfo) throws BaseException {
        PackageInfo j2 = com.ss.android.socialbase.appdownloader.i.j(pa.getContext(), downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
        if (j2 != null) {
            downloadInfo.setAppVersionCode(j2.versionCode);
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
    public boolean needHandle(DownloadInfo downloadInfo) {
        return downloadInfo != null && com.ss.android.downloadlib.lg.q.zx() && downloadInfo.getPackageInfo() == null;
    }
}
