package com.ss.android.downloadlib.i;

import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.pa;
import com.ss.android.downloadlib.lg.nt;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class y {

    /* renamed from: com.ss.android.downloadlib.i.y$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: j */
        final /* synthetic */ int f24281j;
        final /* synthetic */ com.ss.android.downloadad.api.j.zx zx;

        AnonymousClass1(int i2, com.ss.android.downloadad.api.j.zx zxVar) {
            v = i2;
            zxVar = zxVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            DownloadInfo downloadInfo = Downloader.getInstance(pa.getContext()).getDownloadInfo(v);
            JSONObject jSONObject = new JSONObject();
            nt.j(jSONObject, "ttdownloader_type", (Object) 1);
            com.ss.android.downloadlib.lg.gv.i(downloadInfo, jSONObject);
            if (downloadInfo == null || -2 != downloadInfo.getRealStatus() || downloadInfo.isPauseReserveOnWifi()) {
                nt.j(jSONObject, "error_code", (Object) 1001);
            } else {
                y.this.j(v, zxVar, jSONObject);
            }
            com.ss.android.downloadlib.g.j.j().zx("download_notification_try_show", jSONObject, zxVar);
        }
    }

    /* renamed from: com.ss.android.downloadlib.i.y$2 */
    class AnonymousClass2 implements Runnable {

        /* renamed from: j */
        final /* synthetic */ int f24283j;
        final /* synthetic */ com.ss.android.downloadad.api.j.zx zx;

        AnonymousClass2(int i2, com.ss.android.downloadad.api.j.zx zxVar) {
            v = i2;
            zxVar = zxVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            DownloadInfo downloadInfo = Downloader.getInstance(pa.getContext()).getDownloadInfo(v);
            JSONObject jSONObject = new JSONObject();
            nt.j(jSONObject, "ttdownloader_type", (Object) 2);
            com.ss.android.downloadlib.lg.gv.i(downloadInfo, jSONObject);
            if (nt.zx(zxVar)) {
                nt.j(jSONObject, "error_code", (Object) 1002);
            } else {
                y.this.j(v, zxVar, jSONObject);
            }
            com.ss.android.downloadlib.g.j.j().zx("download_notification_try_show", jSONObject, zxVar);
        }
    }

    /* renamed from: com.ss.android.downloadlib.i.y$3 */
    class AnonymousClass3 implements Runnable {

        /* renamed from: j */
        final /* synthetic */ int f24285j;
        final /* synthetic */ com.ss.android.downloadad.api.j.zx zx;

        AnonymousClass3(int i2, com.ss.android.downloadad.api.j.zx zxVar) {
            v = i2;
            zxVar = zxVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            DownloadInfo downloadInfo = Downloader.getInstance(pa.getContext()).getDownloadInfo(v);
            JSONObject jSONObject = new JSONObject();
            nt.j(jSONObject, "ttdownloader_type", (Object) 3);
            com.ss.android.downloadlib.lg.gv.i(downloadInfo, jSONObject);
            if (nt.i(zxVar.q())) {
                nt.j(jSONObject, "error_code", (Object) 1003);
            } else {
                y.this.j(v, zxVar, jSONObject);
            }
            com.ss.android.downloadlib.g.j.j().zx("download_notification_try_show", jSONObject, zxVar);
        }
    }

    private static class j {

        /* renamed from: j */
        private static y f24286j = new y();
    }

    /* synthetic */ y(AnonymousClass1 anonymousClass1) {
        this();
    }

    public void g(@NonNull com.ss.android.downloadad.api.j.zx zxVar) {
        i(zxVar, DownloadSetting.obtain(zxVar.v()).optInt("noti_install_delay_secs", 5));
    }

    public void gv(@NonNull com.ss.android.downloadad.api.j.zx zxVar) {
        j(zxVar, DownloadSetting.obtain(zxVar.v()).optInt("noti_open_delay_secs", 5));
    }

    public void i(@NonNull com.ss.android.downloadad.api.j.zx zxVar) {
        i(zxVar, 5L);
    }

    public void q(@NonNull com.ss.android.downloadad.api.j.zx zxVar) {
        j(zxVar, 5L);
    }

    public void zx(com.ss.android.downloadad.api.j.zx zxVar) {
        if (zxVar == null) {
            return;
        }
        zx(zxVar, DownloadSetting.obtain(zxVar.v()).optInt("noti_continue_delay_secs", 5));
    }

    private y() {
    }

    private void i(@NonNull com.ss.android.downloadad.api.j.zx zxVar, long j2) {
        int v = zxVar.v();
        if (DownloadSetting.obtain(v).optInt("notification_opt_2") != 1) {
            return;
        }
        j(v);
        com.ss.android.downloadlib.g.j().j(new Runnable() { // from class: com.ss.android.downloadlib.i.y.2

            /* renamed from: j */
            final /* synthetic */ int f24283j;
            final /* synthetic */ com.ss.android.downloadad.api.j.zx zx;

            AnonymousClass2(int v2, com.ss.android.downloadad.api.j.zx zxVar2) {
                v = v2;
                zxVar = zxVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(pa.getContext()).getDownloadInfo(v);
                JSONObject jSONObject = new JSONObject();
                nt.j(jSONObject, "ttdownloader_type", (Object) 2);
                com.ss.android.downloadlib.lg.gv.i(downloadInfo, jSONObject);
                if (nt.zx(zxVar)) {
                    nt.j(jSONObject, "error_code", (Object) 1002);
                } else {
                    y.this.j(v, zxVar, jSONObject);
                }
                com.ss.android.downloadlib.g.j.j().zx("download_notification_try_show", jSONObject, zxVar);
            }
        }, j2 * 1000);
    }

    public static y j() {
        return j.f24286j;
    }

    private void zx(@NonNull com.ss.android.downloadad.api.j.zx zxVar, long j2) {
        int v = zxVar.v();
        if (DownloadSetting.obtain(v).optInt("notification_opt_2") != 1) {
            return;
        }
        j(v);
        com.ss.android.downloadlib.g.j().j(new Runnable() { // from class: com.ss.android.downloadlib.i.y.1

            /* renamed from: j */
            final /* synthetic */ int f24281j;
            final /* synthetic */ com.ss.android.downloadad.api.j.zx zx;

            AnonymousClass1(int v2, com.ss.android.downloadad.api.j.zx zxVar2) {
                v = v2;
                zxVar = zxVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(pa.getContext()).getDownloadInfo(v);
                JSONObject jSONObject = new JSONObject();
                nt.j(jSONObject, "ttdownloader_type", (Object) 1);
                com.ss.android.downloadlib.lg.gv.i(downloadInfo, jSONObject);
                if (downloadInfo == null || -2 != downloadInfo.getRealStatus() || downloadInfo.isPauseReserveOnWifi()) {
                    nt.j(jSONObject, "error_code", (Object) 1001);
                } else {
                    y.this.j(v, zxVar, jSONObject);
                }
                com.ss.android.downloadlib.g.j.j().zx("download_notification_try_show", jSONObject, zxVar);
            }
        }, j2 * 1000);
    }

    public void j(com.ss.android.downloadad.api.j.zx zxVar) {
        zx(zxVar, 5L);
    }

    public void j(@NonNull com.ss.android.downloadad.api.j.zx zxVar, long j2) {
        int v = zxVar.v();
        if (DownloadSetting.obtain(v).optInt("notification_opt_2") != 1) {
            return;
        }
        j(v);
        com.ss.android.downloadlib.g.j().j(new Runnable() { // from class: com.ss.android.downloadlib.i.y.3

            /* renamed from: j */
            final /* synthetic */ int f24285j;
            final /* synthetic */ com.ss.android.downloadad.api.j.zx zx;

            AnonymousClass3(int v2, com.ss.android.downloadad.api.j.zx zxVar2) {
                v = v2;
                zxVar = zxVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(pa.getContext()).getDownloadInfo(v);
                JSONObject jSONObject = new JSONObject();
                nt.j(jSONObject, "ttdownloader_type", (Object) 3);
                com.ss.android.downloadlib.lg.gv.i(downloadInfo, jSONObject);
                if (nt.i(zxVar.q())) {
                    nt.j(jSONObject, "error_code", (Object) 1003);
                } else {
                    y.this.j(v, zxVar, jSONObject);
                }
                com.ss.android.downloadlib.g.j.j().zx("download_notification_try_show", jSONObject, zxVar);
            }
        }, j2 * 1000);
    }

    public void j(int i2, com.ss.android.downloadad.api.j.zx zxVar, JSONObject jSONObject) {
        if (!com.ss.android.socialbase.appdownloader.q.g.j()) {
            nt.j(jSONObject, "error_code", (Object) 1004);
            return;
        }
        DownloadInfo downloadInfo = Downloader.getInstance(pa.getContext()).getDownloadInfo(i2);
        if (downloadInfo == null) {
            nt.j(jSONObject, "error_code", (Object) 1005);
            return;
        }
        if (DownloadNotificationManager.getInstance().getNotificationItem(i2) != null) {
            DownloadNotificationManager.getInstance().cancelNotification(i2);
        }
        com.ss.android.socialbase.appdownloader.q.j jVar = new com.ss.android.socialbase.appdownloader.q.j(pa.getContext(), i2, downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
        jVar.setCurBytes(downloadInfo.getCurBytes());
        jVar.setTotalBytes(downloadInfo.getTotalBytes());
        jVar.refreshStatus(downloadInfo.getStatus(), null, false, false);
        DownloadNotificationManager.getInstance().addNotification(jVar);
        jVar.updateNotification(null, false);
        com.ss.android.downloadlib.g.j.j().zx("download_notification_show", jSONObject, zxVar);
    }

    public void j(int i2) {
        DownloadInfo downloadInfo;
        if (com.ss.android.socialbase.appdownloader.q.i.j().j(i2) != null || (downloadInfo = Downloader.getInstance(pa.getContext()).getDownloadInfo(i2)) == null) {
            return;
        }
        com.ss.android.socialbase.appdownloader.q.i.j().j(i2, downloadInfo.getIconUrl());
    }
}
