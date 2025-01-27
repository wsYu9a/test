package com.ss.android.downloadlib.i;

import android.content.Context;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.pa;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class gv implements com.ss.android.socialbase.appdownloader.i.g {

    /* renamed from: j */
    private Context f24272j;

    public gv(Context context) {
        this.f24272j = context.getApplicationContext();
    }

    @Override // com.ss.android.socialbase.appdownloader.i.g
    public void j(Context context, String str) {
        com.ss.android.downloadlib.j.j().j(str);
    }

    @Override // com.ss.android.socialbase.appdownloader.i.g
    public void j(int i2, int i3, String str, int i4, long j2) {
        DownloadInfo downloadInfo;
        com.ss.android.downloadad.api.j.zx j3;
        Context context = this.f24272j;
        if (context == null || (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i2)) == null || downloadInfo.getStatus() == 0 || (j3 = com.ss.android.downloadlib.addownload.zx.gv.j().j(downloadInfo)) == null) {
            return;
        }
        if (i3 == 1) {
            com.ss.android.downloadlib.j.j(downloadInfo, j3);
            if (AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType())) {
                com.ss.android.downloadlib.addownload.j.j().j(downloadInfo, j3.zx(), j3.nt(), j3.q(), downloadInfo.getTitle(), j3.g(), downloadInfo.getTargetFilePath());
                return;
            }
            return;
        }
        if (i3 == 3) {
            com.ss.android.downloadlib.g.j.j().j("download_notification", "download_notification_install", com.ss.android.downloadlib.j.zx(new JSONObject(), downloadInfo), j3);
            return;
        }
        if (i3 == 5) {
            com.ss.android.downloadlib.g.j.j().j("download_notification", "download_notification_pause", j3);
        } else if (i3 == 6) {
            com.ss.android.downloadlib.g.j.j().j("download_notification", "download_notification_continue", j3);
        } else {
            if (i3 != 7) {
                return;
            }
            com.ss.android.downloadlib.g.j.j().j("download_notification", "download_notification_click", j3);
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.i.g
    public boolean j(int i2, boolean z) {
        if (pa.r() != null) {
            return pa.r().j(z);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.appdownloader.i.g
    public void j(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        com.ss.android.downloadlib.lg.j().j(downloadInfo);
        if (DownloadSetting.obtain(downloadInfo.getId()).optInt("report_download_cancel", 1) == 1) {
            com.ss.android.downloadlib.g.j.j().j(downloadInfo, new BaseException(1012, ""));
        } else {
            com.ss.android.downloadlib.g.j.j().zx(downloadInfo, new BaseException(1012, ""));
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.i.g
    public void j(int i2, int i3, String str, String str2, String str3) {
        DownloadInfo downloadInfo;
        Context context = this.f24272j;
        if (context == null || (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i2)) == null || downloadInfo.getStatus() != -3) {
            return;
        }
        downloadInfo.setPackageName(str2);
        com.ss.android.downloadlib.addownload.zx.j().j(this.f24272j, downloadInfo);
    }

    @Override // com.ss.android.socialbase.appdownloader.i.g
    public boolean j() {
        return com.ss.android.downloadlib.addownload.zx.j().zx();
    }
}
