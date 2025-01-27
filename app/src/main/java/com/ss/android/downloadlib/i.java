package com.ss.android.downloadlib;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadlib.addownload.pa;
import com.ss.android.downloadlib.lg.nt;
import com.ss.android.downloadlib.lg.t;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class i implements com.ss.android.socialbase.appdownloader.i.y {

    /* renamed from: j */
    private static String f24264j = "i";
    private Handler zx = new Handler(Looper.getMainLooper());

    /* renamed from: com.ss.android.downloadlib.i$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            pa.i().j(5, pa.getContext(), null, "无网络，请检查网络设置", null, 0);
        }
    }

    /* renamed from: com.ss.android.downloadlib.i$2 */
    class AnonymousClass2 implements Runnable {

        /* renamed from: j */
        final /* synthetic */ DownloadSetting f24267j;
        final /* synthetic */ DownloadModel zx;

        AnonymousClass2(DownloadSetting downloadSetting, DownloadModel downloadModel) {
            obtain = downloadSetting;
            j2 = downloadModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            pa.i().j(2, pa.getContext(), j2, obtain.optString("no_enough_space_toast_text", "您的存储空间不足，请清理后再试"), null, 0);
        }
    }

    /* renamed from: com.ss.android.downloadlib.i$3 */
    class AnonymousClass3 implements AppStatusManager.AppStatusChangeListener {

        /* renamed from: g */
        final /* synthetic */ double f24268g;

        /* renamed from: i */
        final /* synthetic */ long f24269i;

        /* renamed from: j */
        final /* synthetic */ com.ss.android.downloadad.api.j.zx f24270j;
        final /* synthetic */ DownloadInfo q;
        final /* synthetic */ long zx;

        AnonymousClass3(com.ss.android.downloadad.api.j.zx zxVar, long j2, long j3, double d2, DownloadInfo downloadInfo) {
            zxVar = zxVar;
            j2 = j2;
            totalBytes = j3;
            d4 = d2;
            downloadInfo = downloadInfo;
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppBackground() {
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppForeground() {
            if (nt.zx(zxVar)) {
                AppStatusManager.getInstance().unregisterAppSwitchListener(this);
                return;
            }
            long j2 = j2;
            if (j2 <= -1 || totalBytes <= -1 || j2 >= d4) {
                return;
            }
            com.ss.android.downloadlib.g.j.j().j("clean_space_install", com.ss.android.downloadlib.addownload.g.j("install_no_enough_space"), zxVar);
            if (com.ss.android.downloadlib.addownload.g.j(downloadInfo, ((long) d4) - j2)) {
                AppStatusManager.getInstance().unregisterAppSwitchListener(this);
                zxVar.lg(true);
            }
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.i.y
    public void j(DownloadInfo downloadInfo, BaseException baseException, int i2) {
        DownloadModel j2;
        if (downloadInfo == null) {
            return;
        }
        if (i2 == -1 && baseException != null) {
            JSONObject jSONObject = new JSONObject();
            com.ss.android.downloadlib.lg.gv.i(downloadInfo, jSONObject);
            j.j(jSONObject, downloadInfo);
            t.j("download_failed", jSONObject.toString());
        }
        com.ss.android.downloadad.api.j.zx j3 = com.ss.android.downloadlib.addownload.zx.gv.j().j(downloadInfo);
        if (j3 == null) {
            return;
        }
        try {
            if (i2 != -1) {
                if (i2 == -3) {
                    j.j(downloadInfo, j3);
                    return;
                }
                if (i2 == 2001) {
                    j.j().j(downloadInfo, j3, 2001);
                    return;
                } else {
                    if (i2 == 11) {
                        j.j().j(downloadInfo, j3, 2000);
                        if (j3.cg()) {
                            return;
                        }
                        j(downloadInfo, j3);
                        return;
                    }
                    return;
                }
            }
            BaseException baseException2 = null;
            if (baseException != null) {
                if (DownloadSetting.obtain(downloadInfo.getId()).optInt("toast_without_network", 0) == 1 && baseException.getErrorCode() == 1049) {
                    this.zx.post(new Runnable() { // from class: com.ss.android.downloadlib.i.1
                        AnonymousClass1() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            pa.i().j(5, pa.getContext(), null, "无网络，请检查网络设置", null, 0);
                        }
                    });
                }
                if (DownloadUtils.isInsufficientSpaceError(baseException)) {
                    if (pa.nt() != null) {
                        pa.nt().j(j3.zx());
                    }
                    com.ss.android.downloadlib.g.j.j().j("download_failed_for_space", j3);
                    if (!j3.tc()) {
                        com.ss.android.downloadlib.g.j.j().j("download_can_restart", j3);
                        j(downloadInfo);
                    }
                    if ((pa.nt() == null || !pa.nt().g()) && (j2 = com.ss.android.downloadlib.addownload.zx.gv.j().j(j3.zx())) != null && j2.isShowToast()) {
                        DownloadSetting obtain = DownloadSetting.obtain(downloadInfo.getId());
                        if (obtain.optInt("show_no_enough_space_toast", 0) == 1) {
                            this.zx.post(new Runnable() { // from class: com.ss.android.downloadlib.i.2

                                /* renamed from: j */
                                final /* synthetic */ DownloadSetting f24267j;
                                final /* synthetic */ DownloadModel zx;

                                AnonymousClass2(DownloadSetting obtain2, DownloadModel j22) {
                                    obtain = obtain2;
                                    j2 = j22;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    pa.i().j(2, pa.getContext(), j2, obtain.optString("no_enough_space_toast_text", "您的存储空间不足，请清理后再试"), null, 0);
                                }
                            });
                        }
                    }
                }
                baseException2 = new BaseException(baseException.getErrorCode(), nt.j(baseException.getMessage(), pa.k().optInt(DownloadSettingKeys.KEY_EXCEPTION_MSG_LENGTH, 500)));
            }
            com.ss.android.downloadlib.g.j.j().zx(downloadInfo, baseException2);
            lg.j().j(downloadInfo, baseException, "");
        } catch (Exception e2) {
            pa.v().j(e2, "onAppDownloadMonitorSend");
        }
    }

    private void j(DownloadInfo downloadInfo, com.ss.android.downloadad.api.j.zx zxVar) {
        long j2 = nt.j(Environment.getDataDirectory(), -1L);
        long min = Math.min(524288000L, nt.j(Environment.getDataDirectory()) / 10);
        long totalBytes = downloadInfo.getTotalBytes();
        double d2 = min;
        double d3 = totalBytes;
        Double.isNaN(d3);
        Double.isNaN(d2);
        double d4 = (d3 * 2.5d) + d2;
        if (j2 > -1 && totalBytes > -1) {
            double d5 = j2;
            if (d5 < d4) {
                Double.isNaN(d5);
                if (d4 - d5 > com.ss.android.downloadlib.addownload.g.zx()) {
                    com.ss.android.downloadlib.addownload.g.j(downloadInfo.getId());
                }
            }
        }
        AppStatusManager.getInstance().registerAppSwitchListener(new AppStatusManager.AppStatusChangeListener() { // from class: com.ss.android.downloadlib.i.3

            /* renamed from: g */
            final /* synthetic */ double f24268g;

            /* renamed from: i */
            final /* synthetic */ long f24269i;

            /* renamed from: j */
            final /* synthetic */ com.ss.android.downloadad.api.j.zx f24270j;
            final /* synthetic */ DownloadInfo q;
            final /* synthetic */ long zx;

            AnonymousClass3(com.ss.android.downloadad.api.j.zx zxVar2, long j22, long totalBytes2, double d42, DownloadInfo downloadInfo2) {
                zxVar = zxVar2;
                j2 = j22;
                totalBytes = totalBytes2;
                d4 = d42;
                downloadInfo = downloadInfo2;
            }

            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppBackground() {
            }

            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppForeground() {
                if (nt.zx(zxVar)) {
                    AppStatusManager.getInstance().unregisterAppSwitchListener(this);
                    return;
                }
                long j22 = j2;
                if (j22 <= -1 || totalBytes <= -1 || j22 >= d4) {
                    return;
                }
                com.ss.android.downloadlib.g.j.j().j("clean_space_install", com.ss.android.downloadlib.addownload.g.j("install_no_enough_space"), zxVar);
                if (com.ss.android.downloadlib.addownload.g.j(downloadInfo, ((long) d4) - j2)) {
                    AppStatusManager.getInstance().unregisterAppSwitchListener(this);
                    zxVar.lg(true);
                }
            }
        });
    }

    private void j(@NonNull DownloadInfo downloadInfo) {
        if (com.ss.android.downloadlib.lg.q.gv(downloadInfo.getId())) {
            g.j().zx(new com.ss.android.downloadlib.addownload.i.zx(downloadInfo));
        }
    }
}
