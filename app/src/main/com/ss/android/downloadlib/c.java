package com.ss.android.downloadlib;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.sigmob.sdk.base.mta.PointCategory;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class c implements com.ss.android.socialbase.appdownloader.c.h {

    /* renamed from: a */
    private static String f21552a = "c";

    /* renamed from: b */
    private Handler f21553b = new Handler(Looper.getMainLooper());

    /* renamed from: com.ss.android.downloadlib.c$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k.d().a(5, k.a(), null, "无网络，请检查网络设置", null, 0);
        }
    }

    /* renamed from: com.ss.android.downloadlib.c$2 */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ DownloadSetting f21555a;

        /* renamed from: b */
        final /* synthetic */ DownloadModel f21556b;

        public AnonymousClass2(DownloadSetting downloadSetting, DownloadModel downloadModel) {
            obtain = downloadSetting;
            a10 = downloadModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.d().a(2, k.a(), a10, obtain.optString("no_enough_space_toast_text", "您的存储空间不足，请清理后再试"), null, 0);
        }
    }

    /* renamed from: com.ss.android.downloadlib.c$3 */
    public class AnonymousClass3 implements AppStatusManager.AppStatusChangeListener {

        /* renamed from: a */
        final /* synthetic */ com.ss.android.downloadad.api.a.b f21558a;

        /* renamed from: b */
        final /* synthetic */ long f21559b;

        /* renamed from: c */
        final /* synthetic */ long f21560c;

        /* renamed from: d */
        final /* synthetic */ double f21561d;

        /* renamed from: e */
        final /* synthetic */ DownloadInfo f21562e;

        public AnonymousClass3(com.ss.android.downloadad.api.a.b bVar, long j10, long j11, double d10, DownloadInfo downloadInfo) {
            bVar = bVar;
            a10 = j10;
            totalBytes = j11;
            d10 = d10;
            downloadInfo = downloadInfo;
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppBackground() {
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppForeground() {
            if (m.b(bVar)) {
                AppStatusManager.getInstance().unregisterAppSwitchListener(this);
                return;
            }
            long j10 = a10;
            if (j10 <= -1 || totalBytes <= -1 || j10 >= d10) {
                return;
            }
            com.ss.android.downloadlib.d.a.a().a("clean_space_install", com.ss.android.downloadlib.addownload.d.a("install_no_enough_space"), bVar);
            if (com.ss.android.downloadlib.addownload.d.a(downloadInfo, ((long) d10) - a10)) {
                AppStatusManager.getInstance().unregisterAppSwitchListener(this);
                bVar.g(true);
            }
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.c.h
    public void a(DownloadInfo downloadInfo, BaseException baseException, int i10) {
        BaseException baseException2;
        DownloadModel a10;
        if (downloadInfo == null) {
            return;
        }
        if (i10 == -1 && baseException != null) {
            JSONObject jSONObject = new JSONObject();
            com.ss.android.downloadlib.g.f.c(downloadInfo, jSONObject);
            a.a(jSONObject, downloadInfo);
            com.ss.android.downloadlib.g.k.a(PointCategory.DOWNLOAD_FAILED, jSONObject.toString());
        }
        com.ss.android.downloadad.api.a.b a11 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
        if (a11 == null) {
            return;
        }
        try {
            if (i10 != -1) {
                if (i10 == -3) {
                    a.a(downloadInfo, a11);
                    return;
                }
                if (i10 == 2001) {
                    a.a().a(downloadInfo, a11, 2001);
                    return;
                } else {
                    if (i10 == 11) {
                        a.a().a(downloadInfo, a11, 2000);
                        if (a11.S()) {
                            return;
                        }
                        a(downloadInfo, a11);
                        return;
                    }
                    return;
                }
            }
            if (baseException != null) {
                if (DownloadSetting.obtain(downloadInfo.getId()).optInt("toast_without_network", 0) == 1 && baseException.getErrorCode() == 1049) {
                    this.f21553b.post(new Runnable() { // from class: com.ss.android.downloadlib.c.1
                        public AnonymousClass1() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            k.d().a(5, k.a(), null, "无网络，请检查网络设置", null, 0);
                        }
                    });
                }
                if (DownloadUtils.isInsufficientSpaceError(baseException)) {
                    if (k.n() != null) {
                        k.n().a(a11.b());
                    }
                    com.ss.android.downloadlib.d.a.a().a("download_failed_for_space", a11);
                    if (!a11.Q()) {
                        com.ss.android.downloadlib.d.a.a().a("download_can_restart", a11);
                        a(downloadInfo);
                    }
                    if ((k.n() == null || !k.n().d()) && (a10 = com.ss.android.downloadlib.addownload.b.f.a().a(a11.b())) != null && a10.isShowToast()) {
                        DownloadSetting obtain = DownloadSetting.obtain(downloadInfo.getId());
                        if (obtain.optInt("show_no_enough_space_toast", 0) == 1) {
                            this.f21553b.post(new Runnable() { // from class: com.ss.android.downloadlib.c.2

                                /* renamed from: a */
                                final /* synthetic */ DownloadSetting f21555a;

                                /* renamed from: b */
                                final /* synthetic */ DownloadModel f21556b;

                                public AnonymousClass2(DownloadSetting obtain2, DownloadModel a102) {
                                    obtain = obtain2;
                                    a10 = a102;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    k.d().a(2, k.a(), a10, obtain.optString("no_enough_space_toast_text", "您的存储空间不足，请清理后再试"), null, 0);
                                }
                            });
                        }
                    }
                }
                baseException2 = new BaseException(baseException.getErrorCode(), m.a(baseException.getMessage(), k.j().optInt(DownloadSettingKeys.KEY_EXCEPTION_MSG_LENGTH, 500)));
            } else {
                baseException2 = null;
            }
            com.ss.android.downloadlib.d.a.a().b(downloadInfo, baseException2);
            g.a().a(downloadInfo, baseException, "");
        } catch (Exception e10) {
            k.u().a(e10, "onAppDownloadMonitorSend");
        }
    }

    private void a(DownloadInfo downloadInfo, com.ss.android.downloadad.api.a.b bVar) {
        long a10 = m.a(Environment.getDataDirectory(), -1L);
        long min = Math.min(524288000L, m.a(Environment.getDataDirectory()) / 10);
        long totalBytes = downloadInfo.getTotalBytes();
        double d10 = (totalBytes * 2.5d) + min;
        if (a10 > -1 && totalBytes > -1) {
            double d11 = a10;
            if (d11 < d10 && d10 - d11 > com.ss.android.downloadlib.addownload.d.b()) {
                com.ss.android.downloadlib.addownload.d.a(downloadInfo.getId());
            }
        }
        AppStatusManager.getInstance().registerAppSwitchListener(new AppStatusManager.AppStatusChangeListener() { // from class: com.ss.android.downloadlib.c.3

            /* renamed from: a */
            final /* synthetic */ com.ss.android.downloadad.api.a.b f21558a;

            /* renamed from: b */
            final /* synthetic */ long f21559b;

            /* renamed from: c */
            final /* synthetic */ long f21560c;

            /* renamed from: d */
            final /* synthetic */ double f21561d;

            /* renamed from: e */
            final /* synthetic */ DownloadInfo f21562e;

            public AnonymousClass3(com.ss.android.downloadad.api.a.b bVar2, long a102, long totalBytes2, double d102, DownloadInfo downloadInfo2) {
                bVar = bVar2;
                a10 = a102;
                totalBytes = totalBytes2;
                d10 = d102;
                downloadInfo = downloadInfo2;
            }

            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppBackground() {
            }

            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppForeground() {
                if (m.b(bVar)) {
                    AppStatusManager.getInstance().unregisterAppSwitchListener(this);
                    return;
                }
                long j10 = a10;
                if (j10 <= -1 || totalBytes <= -1 || j10 >= d10) {
                    return;
                }
                com.ss.android.downloadlib.d.a.a().a("clean_space_install", com.ss.android.downloadlib.addownload.d.a("install_no_enough_space"), bVar);
                if (com.ss.android.downloadlib.addownload.d.a(downloadInfo, ((long) d10) - a10)) {
                    AppStatusManager.getInstance().unregisterAppSwitchListener(this);
                    bVar.g(true);
                }
            }
        });
    }

    private void a(@NonNull DownloadInfo downloadInfo) {
        if (com.ss.android.downloadlib.g.e.f(downloadInfo.getId())) {
            d.a().b(new com.ss.android.downloadlib.addownload.c.b(downloadInfo));
        }
    }
}
