package com.ss.android.downloadlib.addownload;

import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.impls.RetryScheduler;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class nt {

    /* renamed from: j */
    private static com.ss.android.downloadlib.addownload.j.i f24193j;

    /* renamed from: com.ss.android.downloadlib.addownload.nt$1 */
    static class AnonymousClass1 implements com.ss.android.downloadlib.addownload.j.i {

        /* renamed from: i */
        final /* synthetic */ com.ss.android.downloadlib.addownload.g.i f24194i;

        /* renamed from: j */
        final /* synthetic */ int f24195j;
        final /* synthetic */ com.ss.android.downloadad.api.j.zx zx;

        AnonymousClass1(int i2, com.ss.android.downloadad.api.j.zx zxVar, com.ss.android.downloadlib.addownload.g.i iVar) {
            id = i2;
            zxVar = zxVar;
            iVar = iVar;
        }

        @Override // com.ss.android.downloadlib.addownload.j.i
        public void j() {
            nt.j((com.ss.android.downloadlib.addownload.j.i) null);
            DownloadInfo downloadInfo = Downloader.getInstance(pa.getContext()).getDownloadInfo(id);
            if (downloadInfo != null) {
                downloadInfo.startPauseReserveOnWifi();
                RetryScheduler.getInstance().tryStartScheduleRetry(downloadInfo);
                com.ss.android.downloadlib.g.j.j().zx("pause_reserve_wifi_confirm", zxVar);
            }
            iVar.j(zxVar);
        }

        @Override // com.ss.android.downloadlib.addownload.j.i
        public void zx() {
            nt.j((com.ss.android.downloadlib.addownload.j.i) null);
            DownloadInfo downloadInfo = Downloader.getInstance(pa.getContext()).getDownloadInfo(id);
            if (downloadInfo != null) {
                downloadInfo.stopPauseReserveOnWifi();
            }
            com.ss.android.downloadlib.g.j.j().zx("pause_reserve_wifi_cancel", zxVar);
            iVar.j(zxVar);
        }
    }

    public static com.ss.android.downloadlib.addownload.j.i j() {
        return f24193j;
    }

    public static boolean j(int i2) {
        return i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 7 || i2 == 8;
    }

    public static void j(com.ss.android.downloadlib.addownload.j.i iVar) {
        f24193j = iVar;
    }

    public static boolean j(com.ss.android.downloadad.api.j.zx zxVar, DownloadInfo downloadInfo, int i2, com.ss.android.downloadlib.addownload.g.i iVar) {
        if (zxVar == null) {
            com.ss.android.downloadlib.q.i.j().j("tryReverseWifi nativeModel null");
            return false;
        }
        if (downloadInfo == null) {
            com.ss.android.downloadlib.q.i.j().j("tryReverseWifi info null");
            return false;
        }
        int id = downloadInfo.getId();
        boolean zx = com.ss.android.downloadlib.lg.q.zx(zxVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("switch_status", Integer.valueOf(zx ? 1 : 0));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.g.j.j().j("pause_reserve_wifi_switch_status", jSONObject, zxVar);
        if (!zx || !j(i2) || DownloadUtils.isWifi(pa.getContext()) || downloadInfo.hasPauseReservedOnWifi()) {
            return false;
        }
        j(new com.ss.android.downloadlib.addownload.j.i() { // from class: com.ss.android.downloadlib.addownload.nt.1

            /* renamed from: i */
            final /* synthetic */ com.ss.android.downloadlib.addownload.g.i f24194i;

            /* renamed from: j */
            final /* synthetic */ int f24195j;
            final /* synthetic */ com.ss.android.downloadad.api.j.zx zx;

            AnonymousClass1(int id2, com.ss.android.downloadad.api.j.zx zxVar2, com.ss.android.downloadlib.addownload.g.i iVar2) {
                id = id2;
                zxVar = zxVar2;
                iVar = iVar2;
            }

            @Override // com.ss.android.downloadlib.addownload.j.i
            public void j() {
                nt.j((com.ss.android.downloadlib.addownload.j.i) null);
                DownloadInfo downloadInfo2 = Downloader.getInstance(pa.getContext()).getDownloadInfo(id);
                if (downloadInfo2 != null) {
                    downloadInfo2.startPauseReserveOnWifi();
                    RetryScheduler.getInstance().tryStartScheduleRetry(downloadInfo2);
                    com.ss.android.downloadlib.g.j.j().zx("pause_reserve_wifi_confirm", zxVar);
                }
                iVar.j(zxVar);
            }

            @Override // com.ss.android.downloadlib.addownload.j.i
            public void zx() {
                nt.j((com.ss.android.downloadlib.addownload.j.i) null);
                DownloadInfo downloadInfo2 = Downloader.getInstance(pa.getContext()).getDownloadInfo(id);
                if (downloadInfo2 != null) {
                    downloadInfo2.stopPauseReserveOnWifi();
                }
                com.ss.android.downloadlib.g.j.j().zx("pause_reserve_wifi_cancel", zxVar);
                iVar.j(zxVar);
            }
        });
        TTDelegateActivity.zx(zxVar2);
        return true;
    }
}
