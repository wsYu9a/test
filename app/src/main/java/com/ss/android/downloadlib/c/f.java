package com.ss.android.downloadlib.c;

import android.content.Context;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class f implements com.ss.android.socialbase.appdownloader.c.d {

    /* renamed from: a */
    private Context f21567a;

    public f(Context context) {
        this.f21567a = context.getApplicationContext();
    }

    @Override // com.ss.android.socialbase.appdownloader.c.d
    public void a(Context context, String str) {
        com.ss.android.downloadlib.a.a().a(str);
    }

    @Override // com.ss.android.socialbase.appdownloader.c.d
    public void a(int i10, int i11, String str, int i12, long j10) {
        DownloadInfo downloadInfo;
        com.ss.android.downloadad.api.a.b a10;
        Context context = this.f21567a;
        if (context == null || (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i10)) == null || downloadInfo.getStatus() == 0 || (a10 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo)) == null) {
            return;
        }
        if (i11 == 1) {
            com.ss.android.downloadlib.a.a(downloadInfo, a10);
            if ("application/vnd.android.package-archive".equals(downloadInfo.getMimeType())) {
                com.ss.android.downloadlib.addownload.a.a().a(downloadInfo, a10.b(), a10.l(), a10.e(), downloadInfo.getTitle(), a10.d(), downloadInfo.getTargetFilePath());
                return;
            }
            return;
        }
        if (i11 == 3) {
            com.ss.android.downloadlib.d.a.a().a("download_notification", "download_notification_install", com.ss.android.downloadlib.a.b(new JSONObject(), downloadInfo), a10);
            return;
        }
        if (i11 == 5) {
            com.ss.android.downloadlib.d.a.a().a("download_notification", "download_notification_pause", a10);
        } else if (i11 == 6) {
            com.ss.android.downloadlib.d.a.a().a("download_notification", "download_notification_continue", a10);
        } else {
            if (i11 != 7) {
                return;
            }
            com.ss.android.downloadlib.d.a.a().a("download_notification", "download_notification_click", a10);
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.c.d
    public boolean a(int i10, boolean z10) {
        if (k.p() != null) {
            return k.p().a(z10);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.d
    public void a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        com.ss.android.downloadlib.g.a().a(downloadInfo);
        if (DownloadSetting.obtain(downloadInfo.getId()).optInt("report_download_cancel", 1) == 1) {
            com.ss.android.downloadlib.d.a.a().a(downloadInfo, new BaseException(1012, ""));
        } else {
            com.ss.android.downloadlib.d.a.a().b(downloadInfo, new BaseException(1012, ""));
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.c.d
    public void a(int i10, int i11, String str, String str2, String str3) {
        DownloadInfo downloadInfo;
        Context context = this.f21567a;
        if (context == null || (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i10)) == null || downloadInfo.getStatus() != -3) {
            return;
        }
        downloadInfo.setPackageName(str2);
        com.ss.android.downloadlib.addownload.b.a().a(this.f21567a, downloadInfo);
    }

    @Override // com.ss.android.socialbase.appdownloader.c.d
    public boolean a() {
        return com.ss.android.downloadlib.addownload.b.a().b();
    }
}
