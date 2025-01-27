package com.ss.android.downloadlib.c;

import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class h {

    /* renamed from: com.ss.android.downloadlib.c.h$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f21577a;

        /* renamed from: b */
        final /* synthetic */ com.ss.android.downloadad.api.a.b f21578b;

        public AnonymousClass1(int i10, com.ss.android.downloadad.api.a.b bVar) {
            s10 = i10;
            bVar = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            DownloadInfo downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(s10);
            JSONObject jSONObject = new JSONObject();
            m.a(jSONObject, "ttdownloader_type", (Object) 1);
            com.ss.android.downloadlib.g.f.c(downloadInfo, jSONObject);
            if (downloadInfo == null || -2 != downloadInfo.getRealStatus() || downloadInfo.isPauseReserveOnWifi()) {
                m.a(jSONObject, "error_code", (Object) 1001);
            } else {
                h.this.a(s10, bVar, jSONObject);
            }
            com.ss.android.downloadlib.d.a.a().b("download_notification_try_show", jSONObject, bVar);
        }
    }

    /* renamed from: com.ss.android.downloadlib.c.h$2 */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f21580a;

        /* renamed from: b */
        final /* synthetic */ com.ss.android.downloadad.api.a.b f21581b;

        public AnonymousClass2(int i10, com.ss.android.downloadad.api.a.b bVar) {
            s10 = i10;
            bVar = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            DownloadInfo downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(s10);
            JSONObject jSONObject = new JSONObject();
            m.a(jSONObject, "ttdownloader_type", (Object) 2);
            com.ss.android.downloadlib.g.f.c(downloadInfo, jSONObject);
            if (m.b(bVar)) {
                m.a(jSONObject, "error_code", (Object) 1002);
            } else {
                h.this.a(s10, bVar, jSONObject);
            }
            com.ss.android.downloadlib.d.a.a().b("download_notification_try_show", jSONObject, bVar);
        }
    }

    /* renamed from: com.ss.android.downloadlib.c.h$3 */
    public class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f21583a;

        /* renamed from: b */
        final /* synthetic */ com.ss.android.downloadad.api.a.b f21584b;

        public AnonymousClass3(int i10, com.ss.android.downloadad.api.a.b bVar) {
            s10 = i10;
            bVar = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            DownloadInfo downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(s10);
            JSONObject jSONObject = new JSONObject();
            m.a(jSONObject, "ttdownloader_type", (Object) 3);
            com.ss.android.downloadlib.g.f.c(downloadInfo, jSONObject);
            if (m.c(bVar.e())) {
                m.a(jSONObject, "error_code", (Object) 1003);
            } else {
                h.this.a(s10, bVar, jSONObject);
            }
            com.ss.android.downloadlib.d.a.a().b("download_notification_try_show", jSONObject, bVar);
        }
    }

    public static class a {

        /* renamed from: a */
        private static h f21586a = new h();
    }

    public /* synthetic */ h(AnonymousClass1 anonymousClass1) {
        this();
    }

    public void b(com.ss.android.downloadad.api.a.b bVar) {
        if (bVar == null) {
            return;
        }
        b(bVar, DownloadSetting.obtain(bVar.s()).optInt("noti_continue_delay_secs", 5));
    }

    public void c(@NonNull com.ss.android.downloadad.api.a.b bVar) {
        c(bVar, 5L);
    }

    public void d(@NonNull com.ss.android.downloadad.api.a.b bVar) {
        c(bVar, DownloadSetting.obtain(bVar.s()).optInt("noti_install_delay_secs", 5));
    }

    public void e(@NonNull com.ss.android.downloadad.api.a.b bVar) {
        a(bVar, 5L);
    }

    public void f(@NonNull com.ss.android.downloadad.api.a.b bVar) {
        a(bVar, DownloadSetting.obtain(bVar.s()).optInt("noti_open_delay_secs", 5));
    }

    private h() {
    }

    public static h a() {
        return a.f21586a;
    }

    private void b(@NonNull com.ss.android.downloadad.api.a.b bVar, long j10) {
        int s10 = bVar.s();
        if (DownloadSetting.obtain(s10).optInt("notification_opt_2") != 1) {
            return;
        }
        a(s10);
        com.ss.android.downloadlib.d.a().a(new Runnable() { // from class: com.ss.android.downloadlib.c.h.1

            /* renamed from: a */
            final /* synthetic */ int f21577a;

            /* renamed from: b */
            final /* synthetic */ com.ss.android.downloadad.api.a.b f21578b;

            public AnonymousClass1(int s102, com.ss.android.downloadad.api.a.b bVar2) {
                s10 = s102;
                bVar = bVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(s10);
                JSONObject jSONObject = new JSONObject();
                m.a(jSONObject, "ttdownloader_type", (Object) 1);
                com.ss.android.downloadlib.g.f.c(downloadInfo, jSONObject);
                if (downloadInfo == null || -2 != downloadInfo.getRealStatus() || downloadInfo.isPauseReserveOnWifi()) {
                    m.a(jSONObject, "error_code", (Object) 1001);
                } else {
                    h.this.a(s10, bVar, jSONObject);
                }
                com.ss.android.downloadlib.d.a.a().b("download_notification_try_show", jSONObject, bVar);
            }
        }, j10 * 1000);
    }

    private void c(@NonNull com.ss.android.downloadad.api.a.b bVar, long j10) {
        int s10 = bVar.s();
        if (DownloadSetting.obtain(s10).optInt("notification_opt_2") != 1) {
            return;
        }
        a(s10);
        com.ss.android.downloadlib.d.a().a(new Runnable() { // from class: com.ss.android.downloadlib.c.h.2

            /* renamed from: a */
            final /* synthetic */ int f21580a;

            /* renamed from: b */
            final /* synthetic */ com.ss.android.downloadad.api.a.b f21581b;

            public AnonymousClass2(int s102, com.ss.android.downloadad.api.a.b bVar2) {
                s10 = s102;
                bVar = bVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(s10);
                JSONObject jSONObject = new JSONObject();
                m.a(jSONObject, "ttdownloader_type", (Object) 2);
                com.ss.android.downloadlib.g.f.c(downloadInfo, jSONObject);
                if (m.b(bVar)) {
                    m.a(jSONObject, "error_code", (Object) 1002);
                } else {
                    h.this.a(s10, bVar, jSONObject);
                }
                com.ss.android.downloadlib.d.a.a().b("download_notification_try_show", jSONObject, bVar);
            }
        }, j10 * 1000);
    }

    public void a(com.ss.android.downloadad.api.a.b bVar) {
        b(bVar, 5L);
    }

    public void a(@NonNull com.ss.android.downloadad.api.a.b bVar, long j10) {
        int s10 = bVar.s();
        if (DownloadSetting.obtain(s10).optInt("notification_opt_2") != 1) {
            return;
        }
        a(s10);
        com.ss.android.downloadlib.d.a().a(new Runnable() { // from class: com.ss.android.downloadlib.c.h.3

            /* renamed from: a */
            final /* synthetic */ int f21583a;

            /* renamed from: b */
            final /* synthetic */ com.ss.android.downloadad.api.a.b f21584b;

            public AnonymousClass3(int s102, com.ss.android.downloadad.api.a.b bVar2) {
                s10 = s102;
                bVar = bVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(s10);
                JSONObject jSONObject = new JSONObject();
                m.a(jSONObject, "ttdownloader_type", (Object) 3);
                com.ss.android.downloadlib.g.f.c(downloadInfo, jSONObject);
                if (m.c(bVar.e())) {
                    m.a(jSONObject, "error_code", (Object) 1003);
                } else {
                    h.this.a(s10, bVar, jSONObject);
                }
                com.ss.android.downloadlib.d.a.a().b("download_notification_try_show", jSONObject, bVar);
            }
        }, j10 * 1000);
    }

    public void a(int i10, com.ss.android.downloadad.api.a.b bVar, JSONObject jSONObject) {
        if (!com.ss.android.socialbase.appdownloader.e.d.a()) {
            m.a(jSONObject, "error_code", (Object) 1004);
            return;
        }
        DownloadInfo downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(i10);
        if (downloadInfo == null) {
            m.a(jSONObject, "error_code", (Object) 1005);
            return;
        }
        if (DownloadNotificationManager.getInstance().getNotificationItem(i10) != null) {
            DownloadNotificationManager.getInstance().cancelNotification(i10);
        }
        com.ss.android.socialbase.appdownloader.e.a aVar = new com.ss.android.socialbase.appdownloader.e.a(k.a(), i10, downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
        aVar.setCurBytes(downloadInfo.getCurBytes());
        aVar.setTotalBytes(downloadInfo.getTotalBytes());
        aVar.refreshStatus(downloadInfo.getStatus(), null, false, false);
        DownloadNotificationManager.getInstance().addNotification(aVar);
        aVar.updateNotification(null, false);
        com.ss.android.downloadlib.d.a.a().b("download_notification_show", jSONObject, bVar);
    }

    public void a(int i10) {
        DownloadInfo downloadInfo;
        if (com.ss.android.socialbase.appdownloader.e.c.a().a(i10) != null || (downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(i10)) == null) {
            return;
        }
        com.ss.android.socialbase.appdownloader.e.c.a().a(i10, downloadInfo.getIconUrl());
    }
}
