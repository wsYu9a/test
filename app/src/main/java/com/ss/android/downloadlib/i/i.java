package com.ss.android.downloadlib.i;

import com.ss.android.download.api.config.p;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.pa;
import com.ss.android.downloadlib.lg.nt;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.io.File;

/* loaded from: classes4.dex */
public class i implements IDownloadCompleteHandler {
    private File j(String str, String str2) {
        File file = new File(str2);
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf > 0) {
            str = name.substring(0, lastIndexOf);
        }
        return new File(file.getParent(), str + ".apk");
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
    public void handle(DownloadInfo downloadInfo) throws BaseException {
        p pa = pa.pa();
        if (downloadInfo == null || pa == null) {
            return;
        }
        String packageName = downloadInfo.getPackageName();
        String targetFilePath = downloadInfo.getTargetFilePath();
        File j2 = j(packageName, targetFilePath);
        com.ss.android.downloadad.api.j.zx j3 = com.ss.android.downloadlib.addownload.zx.gv.j().j(downloadInfo);
        pa.j(packageName, targetFilePath, j2, j3 != null ? nt.j(j3.lg()) : null);
        downloadInfo.setMimeType(AdBaseConstants.MIME_APK);
        downloadInfo.setName(j2.getName());
        downloadInfo.setMd5(null);
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
    public boolean needHandle(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            return com.ss.android.download.api.i.zx.j(DownloadSetting.obtain(downloadInfo.getId()), downloadInfo.getMimeType());
        }
        return false;
    }
}
