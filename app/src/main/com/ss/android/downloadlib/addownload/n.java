package com.ss.android.downloadlib.addownload;

import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.impls.RetryScheduler;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class n {

    /* renamed from: a */
    private static com.ss.android.downloadlib.addownload.a.d f21493a;

    /* renamed from: b */
    private static com.ss.android.downloadlib.addownload.a.c f21494b;

    /* renamed from: com.ss.android.downloadlib.addownload.n$1 */
    public static class AnonymousClass1 implements com.ss.android.downloadlib.addownload.a.d {

        /* renamed from: a */
        final /* synthetic */ int f21495a;

        /* renamed from: b */
        final /* synthetic */ boolean f21496b;

        /* renamed from: c */
        final /* synthetic */ com.ss.android.downloadad.api.a.b f21497c;

        /* renamed from: d */
        final /* synthetic */ com.ss.android.downloadlib.addownload.d.h f21498d;

        public AnonymousClass1(int i10, boolean z10, com.ss.android.downloadad.api.a.b bVar, com.ss.android.downloadlib.addownload.d.h hVar) {
            id2 = i10;
            z10 = z10;
            bVar = bVar;
            hVar = hVar;
        }

        @Override // com.ss.android.downloadlib.addownload.a.d
        public void a() {
            n.a((com.ss.android.downloadlib.addownload.a.d) null);
            DownloadInfo downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(id2);
            if (downloadInfo != null) {
                downloadInfo.startPauseReserveOnWifi();
                RetryScheduler.getInstance().tryStartScheduleRetry(downloadInfo);
                if (z10) {
                    com.ss.android.downloadlib.d.a.a().a("cancel_pause_reserve_wifi_confirm", bVar);
                } else {
                    com.ss.android.downloadlib.d.a.a().b("pause_reserve_wifi_confirm", bVar);
                }
            }
            hVar.a(bVar);
        }

        @Override // com.ss.android.downloadlib.addownload.a.d
        public void b() {
            n.a((com.ss.android.downloadlib.addownload.a.d) null);
            DownloadInfo downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(id2);
            if (downloadInfo != null) {
                downloadInfo.stopPauseReserveOnWifi();
            }
            if (z10) {
                com.ss.android.downloadlib.d.a.a().a("cancel_pause_reserve_wifi_cancel", bVar);
            } else {
                com.ss.android.downloadlib.d.a.a().b("pause_reserve_wifi_cancel", bVar);
            }
            hVar.a(bVar);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.n$2 */
    public static class AnonymousClass2 implements com.ss.android.downloadlib.addownload.a.c {

        /* renamed from: b */
        final /* synthetic */ com.ss.android.downloadlib.addownload.a.c f21500b;

        public AnonymousClass2(com.ss.android.downloadlib.addownload.a.c cVar) {
            cVar = cVar;
        }

        @Override // com.ss.android.downloadlib.addownload.a.c
        public void a() {
            com.ss.android.downloadlib.d.a.a().a("cancel_pause_reserve_wifi_delete", com.ss.android.downloadad.api.a.b.this);
            cVar.a();
        }
    }

    public static boolean a(int i10) {
        return i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5 || i10 == 7 || i10 == 8;
    }

    public static com.ss.android.downloadlib.addownload.a.c b() {
        return f21494b;
    }

    public static com.ss.android.downloadlib.addownload.a.d a() {
        return f21493a;
    }

    public static void a(com.ss.android.downloadlib.addownload.a.d dVar) {
        f21493a = dVar;
    }

    public static void a(com.ss.android.downloadlib.addownload.a.c cVar) {
        f21494b = cVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public static boolean a(com.ss.android.downloadad.api.a.b bVar, DownloadInfo downloadInfo, int i10, com.ss.android.downloadlib.addownload.d.h hVar, boolean z10, com.ss.android.downloadlib.addownload.a.c cVar) {
        ?? r22;
        if (bVar == null) {
            com.ss.android.downloadlib.e.c.a().a("tryReverseWifi nativeModel null");
            return false;
        }
        if (downloadInfo == null) {
            com.ss.android.downloadlib.e.c.a().a("tryReverseWifi info null");
            return false;
        }
        int id2 = downloadInfo.getId();
        if (z10) {
            r22 = com.ss.android.downloadlib.g.e.c((com.ss.android.downloadad.api.a.a) bVar);
        } else {
            r22 = com.ss.android.downloadlib.g.e.b((com.ss.android.downloadad.api.a.a) bVar);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("switch_status", Integer.valueOf((int) r22));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (z10) {
            com.ss.android.downloadlib.d.a.a().a("cancel_pause_reserve_wifi_switch_status", jSONObject, bVar);
        } else {
            com.ss.android.downloadlib.d.a.a().a("pause_reserve_wifi_switch_status", jSONObject, bVar);
        }
        if (r22 == 0 || !a(i10) || DownloadUtils.isWifi(k.a())) {
            return false;
        }
        if (!z10 && downloadInfo.hasPauseReservedOnWifi()) {
            return false;
        }
        a(new com.ss.android.downloadlib.addownload.a.d() { // from class: com.ss.android.downloadlib.addownload.n.1

            /* renamed from: a */
            final /* synthetic */ int f21495a;

            /* renamed from: b */
            final /* synthetic */ boolean f21496b;

            /* renamed from: c */
            final /* synthetic */ com.ss.android.downloadad.api.a.b f21497c;

            /* renamed from: d */
            final /* synthetic */ com.ss.android.downloadlib.addownload.d.h f21498d;

            public AnonymousClass1(int id22, boolean z102, com.ss.android.downloadad.api.a.b bVar2, com.ss.android.downloadlib.addownload.d.h hVar2) {
                id2 = id22;
                z10 = z102;
                bVar = bVar2;
                hVar = hVar2;
            }

            @Override // com.ss.android.downloadlib.addownload.a.d
            public void a() {
                n.a((com.ss.android.downloadlib.addownload.a.d) null);
                DownloadInfo downloadInfo2 = Downloader.getInstance(k.a()).getDownloadInfo(id2);
                if (downloadInfo2 != null) {
                    downloadInfo2.startPauseReserveOnWifi();
                    RetryScheduler.getInstance().tryStartScheduleRetry(downloadInfo2);
                    if (z10) {
                        com.ss.android.downloadlib.d.a.a().a("cancel_pause_reserve_wifi_confirm", bVar);
                    } else {
                        com.ss.android.downloadlib.d.a.a().b("pause_reserve_wifi_confirm", bVar);
                    }
                }
                hVar.a(bVar);
            }

            @Override // com.ss.android.downloadlib.addownload.a.d
            public void b() {
                n.a((com.ss.android.downloadlib.addownload.a.d) null);
                DownloadInfo downloadInfo2 = Downloader.getInstance(k.a()).getDownloadInfo(id2);
                if (downloadInfo2 != null) {
                    downloadInfo2.stopPauseReserveOnWifi();
                }
                if (z10) {
                    com.ss.android.downloadlib.d.a.a().a("cancel_pause_reserve_wifi_cancel", bVar);
                } else {
                    com.ss.android.downloadlib.d.a.a().b("pause_reserve_wifi_cancel", bVar);
                }
                hVar.a(bVar);
            }
        });
        if (z102 && cVar != null) {
            a(new com.ss.android.downloadlib.addownload.a.c() { // from class: com.ss.android.downloadlib.addownload.n.2

                /* renamed from: b */
                final /* synthetic */ com.ss.android.downloadlib.addownload.a.c f21500b;

                public AnonymousClass2(com.ss.android.downloadlib.addownload.a.c cVar2) {
                    cVar = cVar2;
                }

                @Override // com.ss.android.downloadlib.addownload.a.c
                public void a() {
                    com.ss.android.downloadlib.d.a.a().a("cancel_pause_reserve_wifi_delete", com.ss.android.downloadad.api.a.b.this);
                    cVar.a();
                }
            });
        }
        if (z102) {
            TTDelegateActivity.a(bVar2, "删除");
        } else {
            TTDelegateActivity.b(bVar2);
        }
        return true;
    }
}
