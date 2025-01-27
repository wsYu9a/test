package com.ss.android.downloadlib;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.j;
import com.ss.android.download.api.config.l;
import com.ss.android.download.api.config.q;
import com.ss.android.download.api.config.u;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;

/* loaded from: classes4.dex */
class e implements com.ss.android.download.api.a {

    /* renamed from: com.ss.android.downloadlib.e$1 */
    public class AnonymousClass1 implements AppStatusManager.InnerAppStatusChangeCaller {

        /* renamed from: a */
        final /* synthetic */ com.ss.android.download.api.config.b f21597a;

        public AnonymousClass1(com.ss.android.download.api.config.b bVar) {
            bVar = bVar;
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.InnerAppStatusChangeCaller
        public boolean isAppInBackground() {
            return bVar.a();
        }
    }

    /* renamed from: com.ss.android.downloadlib.e$2 */
    public class AnonymousClass2 implements INotificationClickCallback {
        public AnonymousClass2() {
        }

        private boolean a(DownloadInfo downloadInfo) {
            u t10 = k.t();
            if (t10 == null) {
                return false;
            }
            com.ss.android.downloadad.api.a.b a10 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
            String a11 = (a10 == null || !a10.c()) ? com.ss.android.downloadlib.addownload.i.a(downloadInfo) : DownloadSetting.obtain(downloadInfo.getId()).optString("ad_notification_jump_url", null);
            if (TextUtils.isEmpty(a11)) {
                return false;
            }
            return t10.a(k.a(), a11);
        }

        @Override // com.ss.android.socialbase.downloader.depend.INotificationClickCallback
        public boolean onClickWhenInstalled(DownloadInfo downloadInfo) {
            if (downloadInfo == null) {
                return false;
            }
            com.ss.android.downloadad.api.a.b a10 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
            if (a10 != null) {
                com.ss.android.downloadlib.b.a.a(a10);
            } else {
                com.ss.android.downloadlib.g.i.b(k.a(), downloadInfo.getPackageName());
            }
            DownloadNotificationManager.getInstance().cancelNotification(downloadInfo.getId());
            return true;
        }

        @Override // com.ss.android.socialbase.downloader.depend.INotificationClickCallback
        public boolean onClickWhenSuccess(DownloadInfo downloadInfo) {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.depend.INotificationClickCallback
        public boolean onClickWhenUnSuccess(DownloadInfo downloadInfo) {
            DownloadSetting obtain = DownloadSetting.obtain(downloadInfo.getId());
            if (obtain.optInt("notification_opt_2") != 1) {
                boolean a10 = a(downloadInfo);
                if (obtain.optInt("disable_delete_dialog", 0) == 1) {
                    return true;
                }
                return a10;
            }
            if (downloadInfo.getStatus() == -2) {
                DownloadHandlerService.a(k.a(), downloadInfo, com.ss.android.socialbase.appdownloader.d.j().b(), Downloader.getInstance(k.a()).getDownloadNotificationEventListener(downloadInfo.getId()));
            }
            return true;
        }
    }

    /* renamed from: com.ss.android.downloadlib.e$3 */
    public class AnonymousClass3 implements Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.appdownloader.f.e.a("");
            if (com.ss.android.socialbase.appdownloader.f.e.o()) {
                DownloadComponentManager.setNotAutoRebootService(true);
            }
            if (DownloadSetting.obtainGlobal().optInt("disable_security_init", 1) == 1) {
                com.ss.android.socialbase.appdownloader.f.f.a(k.a());
            }
        }
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(@NonNull com.ss.android.download.api.config.i iVar) {
        k.a(iVar);
        return this;
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(@NonNull com.ss.android.download.api.config.g gVar) {
        k.a(gVar);
        return this;
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(@NonNull l lVar) {
        k.a(lVar);
        return this;
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(@NonNull com.ss.android.download.api.config.h hVar) {
        k.a(hVar);
        return this;
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(@NonNull j jVar) {
        k.a(jVar);
        return this;
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(@NonNull com.ss.android.download.api.model.a aVar) {
        k.a(aVar);
        return this;
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(String str) {
        k.a(str);
        return this;
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(@NonNull com.ss.android.download.api.config.b bVar) {
        k.a(bVar);
        AppStatusManager.getInstance().setInnerAppStatusChangeCaller(new AppStatusManager.InnerAppStatusChangeCaller() { // from class: com.ss.android.downloadlib.e.1

            /* renamed from: a */
            final /* synthetic */ com.ss.android.download.api.config.b f21597a;

            public AnonymousClass1(com.ss.android.download.api.config.b bVar2) {
                bVar = bVar2;
            }

            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.InnerAppStatusChangeCaller
            public boolean isAppInBackground() {
                return bVar.a();
            }
        });
        return this;
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(DownloaderBuilder downloaderBuilder) {
        if (downloaderBuilder.getNotificationClickCallback() == null) {
            downloaderBuilder.notificationClickCallback(new INotificationClickCallback() { // from class: com.ss.android.downloadlib.e.2
                public AnonymousClass2() {
                }

                private boolean a(DownloadInfo downloadInfo) {
                    u t10 = k.t();
                    if (t10 == null) {
                        return false;
                    }
                    com.ss.android.downloadad.api.a.b a10 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
                    String a11 = (a10 == null || !a10.c()) ? com.ss.android.downloadlib.addownload.i.a(downloadInfo) : DownloadSetting.obtain(downloadInfo.getId()).optString("ad_notification_jump_url", null);
                    if (TextUtils.isEmpty(a11)) {
                        return false;
                    }
                    return t10.a(k.a(), a11);
                }

                @Override // com.ss.android.socialbase.downloader.depend.INotificationClickCallback
                public boolean onClickWhenInstalled(DownloadInfo downloadInfo) {
                    if (downloadInfo == null) {
                        return false;
                    }
                    com.ss.android.downloadad.api.a.b a10 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
                    if (a10 != null) {
                        com.ss.android.downloadlib.b.a.a(a10);
                    } else {
                        com.ss.android.downloadlib.g.i.b(k.a(), downloadInfo.getPackageName());
                    }
                    DownloadNotificationManager.getInstance().cancelNotification(downloadInfo.getId());
                    return true;
                }

                @Override // com.ss.android.socialbase.downloader.depend.INotificationClickCallback
                public boolean onClickWhenSuccess(DownloadInfo downloadInfo) {
                    return false;
                }

                @Override // com.ss.android.socialbase.downloader.depend.INotificationClickCallback
                public boolean onClickWhenUnSuccess(DownloadInfo downloadInfo) {
                    DownloadSetting obtain = DownloadSetting.obtain(downloadInfo.getId());
                    if (obtain.optInt("notification_opt_2") != 1) {
                        boolean a10 = a(downloadInfo);
                        if (obtain.optInt("disable_delete_dialog", 0) == 1) {
                            return true;
                        }
                        return a10;
                    }
                    if (downloadInfo.getStatus() == -2) {
                        DownloadHandlerService.a(k.a(), downloadInfo, com.ss.android.socialbase.appdownloader.d.j().b(), Downloader.getInstance(k.a()).getDownloadNotificationEventListener(downloadInfo.getId()));
                    }
                    return true;
                }
            });
        }
        downloaderBuilder.addDownloadCompleteHandler(new com.ss.android.downloadlib.c.c());
        Downloader.initOrCover(downloaderBuilder, true);
        return this;
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(q qVar) {
        k.a(qVar);
        return this;
    }

    @Override // com.ss.android.download.api.a
    public void a() {
        if (!k.x()) {
            com.ss.android.downloadlib.e.c.a().a("ttdownloader init error");
        }
        k.a(com.ss.android.downloadlib.e.c.a());
        try {
            com.ss.android.socialbase.appdownloader.d.j().b(k.w());
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        com.ss.android.socialbase.appdownloader.d.j().a(a.a());
        d.a().b(new Runnable() { // from class: com.ss.android.downloadlib.e.3
            public AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.f.e.a("");
                if (com.ss.android.socialbase.appdownloader.f.e.o()) {
                    DownloadComponentManager.setNotAutoRebootService(true);
                }
                if (DownloadSetting.obtainGlobal().optInt("disable_security_init", 1) == 1) {
                    com.ss.android.socialbase.appdownloader.f.f.a(k.a());
                }
            }
        });
    }
}
