package com.ss.android.downloadlib;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.ei;
import com.ss.android.download.api.config.hm;
import com.ss.android.download.api.config.nt;
import com.ss.android.downloadlib.addownload.pa;
import com.ss.android.downloadlib.lg.k;
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
class q implements com.ss.android.download.api.j {

    /* renamed from: com.ss.android.downloadlib.q$1 */
    class AnonymousClass1 implements AppStatusManager.InnerAppStatusChangeCaller {

        /* renamed from: j */
        final /* synthetic */ com.ss.android.download.api.config.zx f24348j;

        AnonymousClass1(com.ss.android.download.api.config.zx zxVar) {
            zxVar = zxVar;
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.InnerAppStatusChangeCaller
        public boolean isAppInBackground() {
            return zxVar.j();
        }
    }

    /* renamed from: com.ss.android.downloadlib.q$2 */
    class AnonymousClass2 implements INotificationClickCallback {
        AnonymousClass2() {
        }

        private boolean j(DownloadInfo downloadInfo) {
            hm e2 = pa.e();
            if (e2 == null) {
                return false;
            }
            com.ss.android.downloadad.api.j.zx j2 = com.ss.android.downloadlib.addownload.zx.gv.j().j(downloadInfo);
            String j3 = (j2 == null || !j2.i()) ? com.ss.android.downloadlib.addownload.y.j(downloadInfo) : DownloadSetting.obtain(downloadInfo.getId()).optString("ad_notification_jump_url", null);
            if (TextUtils.isEmpty(j3)) {
                return false;
            }
            return e2.j(pa.getContext(), j3);
        }

        @Override // com.ss.android.socialbase.downloader.depend.INotificationClickCallback
        public boolean onClickWhenInstalled(DownloadInfo downloadInfo) {
            if (downloadInfo == null) {
                return false;
            }
            com.ss.android.downloadad.api.j.zx j2 = com.ss.android.downloadlib.addownload.zx.gv.j().j(downloadInfo);
            if (j2 != null) {
                com.ss.android.downloadlib.zx.j.j(j2);
            } else {
                k.zx(pa.getContext(), downloadInfo.getPackageName());
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
                boolean j2 = j(downloadInfo);
                if (obtain.optInt("disable_delete_dialog", 0) == 1) {
                    return true;
                }
                return j2;
            }
            if (downloadInfo.getStatus() == -2) {
                DownloadHandlerService.j(pa.getContext(), downloadInfo, com.ss.android.socialbase.appdownloader.g.pa().zx(), Downloader.getInstance(pa.getContext()).getDownloadNotificationEventListener(downloadInfo.getId()));
            }
            return true;
        }
    }

    /* renamed from: com.ss.android.downloadlib.q$3 */
    class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.appdownloader.gv.q.j("");
            if (com.ss.android.socialbase.appdownloader.gv.q.r()) {
                DownloadComponentManager.setNotAutoRebootService(true);
            }
            if (DownloadSetting.obtainGlobal().optInt("disable_security_init", 1) == 1) {
                com.ss.android.socialbase.appdownloader.gv.gv.j(pa.getContext());
            }
        }
    }

    q() {
    }

    @Override // com.ss.android.download.api.j
    public com.ss.android.download.api.j j(@NonNull com.ss.android.download.api.config.k kVar) {
        pa.j(kVar);
        return this;
    }

    @Override // com.ss.android.download.api.j
    public com.ss.android.download.api.j j(@NonNull com.ss.android.download.api.config.lg lgVar) {
        pa.j(lgVar);
        return this;
    }

    @Override // com.ss.android.download.api.j
    public com.ss.android.download.api.j j(@NonNull nt ntVar) {
        pa.j(ntVar);
        return this;
    }

    @Override // com.ss.android.download.api.j
    public com.ss.android.download.api.j j(@NonNull com.ss.android.download.api.config.y yVar) {
        pa.j(yVar);
        return this;
    }

    @Override // com.ss.android.download.api.j
    public com.ss.android.download.api.j j(@NonNull com.ss.android.download.api.config.pa paVar) {
        pa.j(paVar);
        return this;
    }

    @Override // com.ss.android.download.api.j
    public com.ss.android.download.api.j j(@NonNull com.ss.android.download.api.model.j jVar) {
        pa.j(jVar);
        return this;
    }

    @Override // com.ss.android.download.api.j
    public com.ss.android.download.api.j j(String str) {
        pa.j(str);
        return this;
    }

    @Override // com.ss.android.download.api.j
    public com.ss.android.download.api.j j(@NonNull com.ss.android.download.api.config.zx zxVar) {
        pa.j(zxVar);
        AppStatusManager.getInstance().setInnerAppStatusChangeCaller(new AppStatusManager.InnerAppStatusChangeCaller() { // from class: com.ss.android.downloadlib.q.1

            /* renamed from: j */
            final /* synthetic */ com.ss.android.download.api.config.zx f24348j;

            AnonymousClass1(com.ss.android.download.api.config.zx zxVar2) {
                zxVar = zxVar2;
            }

            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.InnerAppStatusChangeCaller
            public boolean isAppInBackground() {
                return zxVar.j();
            }
        });
        return this;
    }

    @Override // com.ss.android.download.api.j
    public com.ss.android.download.api.j j(DownloaderBuilder downloaderBuilder) {
        if (downloaderBuilder.getNotificationClickCallback() == null) {
            downloaderBuilder.notificationClickCallback(new INotificationClickCallback() { // from class: com.ss.android.downloadlib.q.2
                AnonymousClass2() {
                }

                private boolean j(DownloadInfo downloadInfo) {
                    hm e2 = pa.e();
                    if (e2 == null) {
                        return false;
                    }
                    com.ss.android.downloadad.api.j.zx j2 = com.ss.android.downloadlib.addownload.zx.gv.j().j(downloadInfo);
                    String j3 = (j2 == null || !j2.i()) ? com.ss.android.downloadlib.addownload.y.j(downloadInfo) : DownloadSetting.obtain(downloadInfo.getId()).optString("ad_notification_jump_url", null);
                    if (TextUtils.isEmpty(j3)) {
                        return false;
                    }
                    return e2.j(pa.getContext(), j3);
                }

                @Override // com.ss.android.socialbase.downloader.depend.INotificationClickCallback
                public boolean onClickWhenInstalled(DownloadInfo downloadInfo) {
                    if (downloadInfo == null) {
                        return false;
                    }
                    com.ss.android.downloadad.api.j.zx j2 = com.ss.android.downloadlib.addownload.zx.gv.j().j(downloadInfo);
                    if (j2 != null) {
                        com.ss.android.downloadlib.zx.j.j(j2);
                    } else {
                        k.zx(pa.getContext(), downloadInfo.getPackageName());
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
                        boolean j2 = j(downloadInfo);
                        if (obtain.optInt("disable_delete_dialog", 0) == 1) {
                            return true;
                        }
                        return j2;
                    }
                    if (downloadInfo.getStatus() == -2) {
                        DownloadHandlerService.j(pa.getContext(), downloadInfo, com.ss.android.socialbase.appdownloader.g.pa().zx(), Downloader.getInstance(pa.getContext()).getDownloadNotificationEventListener(downloadInfo.getId()));
                    }
                    return true;
                }
            });
        }
        downloaderBuilder.addDownloadCompleteHandler(new com.ss.android.downloadlib.i.i());
        Downloader.initOrCover(downloaderBuilder, true);
        return this;
    }

    @Override // com.ss.android.download.api.j
    public com.ss.android.download.api.j j(ei eiVar) {
        pa.j(eiVar);
        return this;
    }

    @Override // com.ss.android.download.api.j
    public void j() {
        if (!pa.f()) {
            com.ss.android.downloadlib.q.i.j().j("ttdownloader init error");
        }
        pa.j(com.ss.android.downloadlib.q.i.j());
        try {
            com.ss.android.socialbase.appdownloader.g.pa().zx(pa.hm());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.socialbase.appdownloader.g.pa().j(j.j());
        g.j().zx(new Runnable() { // from class: com.ss.android.downloadlib.q.3
            AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.gv.q.j("");
                if (com.ss.android.socialbase.appdownloader.gv.q.r()) {
                    DownloadComponentManager.setNotAutoRebootService(true);
                }
                if (DownloadSetting.obtainGlobal().optInt("disable_security_init", 1) == 1) {
                    com.ss.android.socialbase.appdownloader.gv.gv.j(pa.getContext());
                }
            }
        });
    }
}
