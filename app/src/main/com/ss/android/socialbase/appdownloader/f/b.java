package com.ss.android.socialbase.appdownloader.f;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: com.ss.android.socialbase.appdownloader.f.b$1 */
    public static class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f21909a;

        /* renamed from: b */
        final /* synthetic */ DownloadInfo f21910b;

        /* renamed from: c */
        final /* synthetic */ int f21911c;

        public AnonymousClass1(Context context, DownloadInfo downloadInfo, int i10) {
            appContext = context;
            downloadInfo = downloadInfo;
            a10 = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.appdownloader.c.d b10 = com.ss.android.socialbase.appdownloader.d.j().b();
            IDownloadNotificationEventListener downloadNotificationEventListener = Downloader.getInstance(appContext).getDownloadNotificationEventListener(downloadInfo.getId());
            if (b10 == null && downloadNotificationEventListener == null) {
                return;
            }
            File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            if (file.exists()) {
                try {
                    PackageInfo a10 = com.ss.android.socialbase.appdownloader.c.a(downloadInfo, file);
                    if (a10 != null) {
                        String packageName = (a10 == 1 || TextUtils.isEmpty(downloadInfo.getPackageName())) ? a10.packageName : downloadInfo.getPackageName();
                        if (b10 != null) {
                            b10.a(downloadInfo.getId(), 1, packageName, -3, downloadInfo.getDownloadTime());
                        }
                        if (downloadNotificationEventListener != null) {
                            downloadNotificationEventListener.onNotificationEvent(1, downloadInfo, packageName, "");
                        }
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }
    }

    public static void a(DownloadInfo downloadInfo) {
        b(downloadInfo);
    }

    private static void b(DownloadInfo downloadInfo) {
        Context appContext = DownloadComponentManager.getAppContext();
        DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.f.b.1

            /* renamed from: a */
            final /* synthetic */ Context f21909a;

            /* renamed from: b */
            final /* synthetic */ DownloadInfo f21910b;

            /* renamed from: c */
            final /* synthetic */ int f21911c;

            public AnonymousClass1(Context appContext2, DownloadInfo downloadInfo2, int i10) {
                appContext = appContext2;
                downloadInfo = downloadInfo2;
                a10 = i10;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.c.d b10 = com.ss.android.socialbase.appdownloader.d.j().b();
                IDownloadNotificationEventListener downloadNotificationEventListener = Downloader.getInstance(appContext).getDownloadNotificationEventListener(downloadInfo.getId());
                if (b10 == null && downloadNotificationEventListener == null) {
                    return;
                }
                File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                if (file.exists()) {
                    try {
                        PackageInfo a10 = com.ss.android.socialbase.appdownloader.c.a(downloadInfo, file);
                        if (a10 != null) {
                            String packageName = (a10 == 1 || TextUtils.isEmpty(downloadInfo.getPackageName())) ? a10.packageName : downloadInfo.getPackageName();
                            if (b10 != null) {
                                b10.a(downloadInfo.getId(), 1, packageName, -3, downloadInfo.getDownloadTime());
                            }
                            if (downloadNotificationEventListener != null) {
                                downloadNotificationEventListener.onNotificationEvent(1, downloadInfo, packageName, "");
                            }
                        }
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            }
        });
    }
}
