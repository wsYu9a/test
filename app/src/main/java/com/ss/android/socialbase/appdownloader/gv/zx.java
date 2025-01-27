package com.ss.android.socialbase.appdownloader.gv;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.io.File;

/* loaded from: classes4.dex */
public class zx {

    /* renamed from: com.ss.android.socialbase.appdownloader.gv.zx$1 */
    static class AnonymousClass1 implements Runnable {

        /* renamed from: i */
        final /* synthetic */ int f24461i;

        /* renamed from: j */
        final /* synthetic */ Context f24462j;
        final /* synthetic */ DownloadInfo zx;

        AnonymousClass1(Context context, DownloadInfo downloadInfo, int i2) {
            appContext = context;
            downloadInfo = downloadInfo;
            j2 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.appdownloader.i.g zx = com.ss.android.socialbase.appdownloader.g.pa().zx();
            IDownloadNotificationEventListener downloadNotificationEventListener = Downloader.getInstance(appContext).getDownloadNotificationEventListener(downloadInfo.getId());
            if (zx == null && downloadNotificationEventListener == null) {
                return;
            }
            File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            if (file.exists()) {
                try {
                    PackageInfo j2 = com.ss.android.socialbase.appdownloader.i.j(downloadInfo, file);
                    if (j2 != null) {
                        String packageName = (j2 == 1 || TextUtils.isEmpty(downloadInfo.getPackageName())) ? j2.packageName : downloadInfo.getPackageName();
                        if (zx != null) {
                            zx.j(downloadInfo.getId(), 1, packageName, -3, downloadInfo.getDownloadTime());
                        }
                        if (downloadNotificationEventListener != null) {
                            downloadNotificationEventListener.onNotificationEvent(1, downloadInfo, packageName, "");
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void j(DownloadInfo downloadInfo) {
        zx(downloadInfo);
    }

    private static void zx(DownloadInfo downloadInfo) {
        Context appContext = DownloadComponentManager.getAppContext();
        boolean z = true;
        if (((downloadInfo.isAutoResumed() && !downloadInfo.isShowNotificationForNetworkResumed()) || com.ss.android.socialbase.appdownloader.i.zx(downloadInfo.getExtra()) || TextUtils.isEmpty(downloadInfo.getMimeType()) || !downloadInfo.getMimeType().equals(AdBaseConstants.MIME_APK)) && DownloadSetting.obtain(downloadInfo.getId()).optInt("auto_install_when_resume", 0) != 1) {
            z = false;
        }
        DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.gv.zx.1

            /* renamed from: i */
            final /* synthetic */ int f24461i;

            /* renamed from: j */
            final /* synthetic */ Context f24462j;
            final /* synthetic */ DownloadInfo zx;

            AnonymousClass1(Context appContext2, DownloadInfo downloadInfo2, int i2) {
                appContext = appContext2;
                downloadInfo = downloadInfo2;
                j2 = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.i.g zx = com.ss.android.socialbase.appdownloader.g.pa().zx();
                IDownloadNotificationEventListener downloadNotificationEventListener = Downloader.getInstance(appContext).getDownloadNotificationEventListener(downloadInfo.getId());
                if (zx == null && downloadNotificationEventListener == null) {
                    return;
                }
                File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                if (file.exists()) {
                    try {
                        PackageInfo j2 = com.ss.android.socialbase.appdownloader.i.j(downloadInfo, file);
                        if (j2 != null) {
                            String packageName = (j2 == 1 || TextUtils.isEmpty(downloadInfo.getPackageName())) ? j2.packageName : downloadInfo.getPackageName();
                            if (zx != null) {
                                zx.j(downloadInfo.getId(), 1, packageName, -3, downloadInfo.getDownloadTime());
                            }
                            if (downloadNotificationEventListener != null) {
                                downloadNotificationEventListener.onNotificationEvent(1, downloadInfo, packageName, "");
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });
    }
}
