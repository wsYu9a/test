package com.ss.android.downloadlib;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.alipay.mobilesecuritysdk.constant.a;
import com.kwai.sodler.lib.ext.PluginError;
import com.martian.mibook.application.MiConfigSingleton;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.pa;
import com.ss.android.downloadlib.addownload.zx.g;
import com.ss.android.downloadlib.addownload.zx.k;
import com.ss.android.downloadlib.lg.nt;
import com.ss.android.socialbase.appdownloader.zx;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.depend.IOpenInstallerListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.NetTrafficManager;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class j implements com.ss.android.downloadad.api.j, zx.i, AppStatusManager.AppStatusChangeListener, IOpenInstallerListener {

    /* renamed from: g */
    private static volatile j f24287g = null;

    /* renamed from: j */
    private static String f24288j = "j";

    /* renamed from: i */
    private zx f24289i;
    private long zx;

    /* renamed from: com.ss.android.downloadlib.j$1 */
    class AnonymousClass1 implements com.ss.android.downloadlib.zx.lg {

        /* renamed from: j */
        final /* synthetic */ com.ss.android.downloadad.api.j.zx f24291j;
        final /* synthetic */ String zx;

        AnonymousClass1(com.ss.android.downloadad.api.j.zx zxVar, String str) {
            j2 = zxVar;
            str = str;
        }

        @Override // com.ss.android.downloadlib.zx.lg
        public void j(boolean z) {
            Logger.d(j.f24288j, "appBackForeground->" + z);
            if (!z) {
                if (com.ss.android.downloadlib.zx.j.j(str, j2) || j2.hk() != 4) {
                    return;
                }
                com.ss.android.downloadlib.addownload.j.j.j().j(j2);
                return;
            }
            if (!(com.ss.android.downloadlib.zx.gv.i(j2) ? com.ss.android.downloadlib.zx.j.j(str, j2) : false) && com.ss.android.downloadlib.zx.gv.g(j2) && j2.hk() == 4) {
                com.ss.android.downloadlib.addownload.j.j.j().j(j2);
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.j$2 */
    class AnonymousClass2 implements Runnable {

        /* renamed from: j */
        final /* synthetic */ long f24292j;

        AnonymousClass2(long j2) {
            j2 = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.j().j(j2);
        }
    }

    /* renamed from: com.ss.android.downloadlib.j$3 */
    class AnonymousClass3 implements Runnable {

        /* renamed from: j */
        final /* synthetic */ String f24294j;
        final /* synthetic */ com.ss.android.downloadad.api.j.zx zx;

        AnonymousClass3(String str, com.ss.android.downloadad.api.j.zx zxVar) {
            targetFilePath = str;
            zxVar = zxVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String j2 = com.ss.android.downloadlib.lg.j.j(targetFilePath);
            if (TextUtils.isEmpty(j2)) {
                return;
            }
            pa.getContext().getSharedPreferences("sp_ttdownloader_md5", 0).edit().putString(String.valueOf(zxVar.zx()), j2).apply();
        }
    }

    /* renamed from: com.ss.android.downloadlib.j$4 */
    class AnonymousClass4 implements com.ss.android.downloadlib.zx.g {

        /* renamed from: j */
        final /* synthetic */ DownloadInfo f24296j;
        final /* synthetic */ JSONObject zx;

        AnonymousClass4(DownloadInfo downloadInfo, JSONObject jSONObject) {
            downloadInfo = downloadInfo;
            jSONObject = jSONObject;
        }

        @Override // com.ss.android.downloadlib.zx.g
        public void j(boolean z) {
            if (!z) {
                Intent intent = (Intent) downloadInfo.getTempCacheData().get("intent");
                if (intent != null) {
                    downloadInfo.getTempCacheData().remove("intent");
                    com.ss.android.socialbase.appdownloader.i.j(pa.getContext(), intent);
                    nt.j(jSONObject, MiConfigSingleton.v0, (Object) 1);
                } else {
                    nt.j(jSONObject, MiConfigSingleton.v0, (Object) 2);
                }
            }
            com.ss.android.downloadad.api.j.zx j2 = com.ss.android.downloadlib.addownload.zx.gv.j().j(downloadInfo);
            if (j2 != null) {
                com.ss.android.downloadlib.g.j.j().j(z ? "installer_delay_success" : "installer_delay_failed", jSONObject, j2);
            } else {
                com.ss.android.downloadlib.q.i.j().zx("ah nativeModel=null");
            }
            if (z) {
                pa.gm().j(pa.getContext(), null, null, null, null, 1);
            }
        }
    }

    private class i implements Runnable {
        private final com.ss.android.downloadad.api.j.zx zx;

        public i(com.ss.android.downloadad.api.j.zx zxVar) {
            this.zx = zxVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    this.zx.pa(true);
                    j.this.i(this.zx);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } finally {
                this.zx.pa(false);
            }
        }
    }

    @WorkerThread
    /* renamed from: com.ss.android.downloadlib.j$j */
    private class RunnableC0497j implements Runnable {
        private final int zx;

        public RunnableC0497j(int i2) {
            this.zx = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.ss.android.downloadlib.addownload.zx.gv.j().zx();
                ConcurrentHashMap<Long, com.ss.android.downloadad.api.j.zx> i2 = com.ss.android.downloadlib.addownload.zx.gv.j().i();
                if (i2 == null || i2.isEmpty()) {
                    return;
                }
                j.this.j(i2, this.zx);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private static class zx implements Runnable {

        /* renamed from: g */
        private int f24300g;

        /* renamed from: i */
        private long f24301i;

        /* renamed from: j */
        private long f24302j;
        private long q;
        private int zx;

        /* synthetic */ zx(long j2, int i2, long j3, int i3, AnonymousClass1 anonymousClass1) {
            this(j2, i2, j3, i3);
        }

        public void zx() {
            this.q = System.currentTimeMillis();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (j()) {
                    j.j().j(this.f24302j, this.zx);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        private zx(long j2, int i2, long j3, int i3) {
            this.f24302j = j2;
            this.zx = i2;
            this.f24301i = j3;
            this.f24300g = i3;
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x006a, code lost:
        
            if (r9 < r1) goto L80;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean j() {
            /*
                Method dump skipped, instructions count: 272
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.j.zx.j():boolean");
        }

        private int j(boolean z, com.ss.android.downloadad.api.j.zx zxVar, DownloadInfo downloadInfo, boolean z2, JSONObject jSONObject) {
            DownloadSetting obtain = DownloadSetting.obtain(downloadInfo.getId());
            int i2 = 1;
            if (obtain.optInt("install_failed_check_ttmd5", 1) == 1) {
                int checkMd5Status = downloadInfo.checkMd5Status();
                try {
                    jSONObject.put("ttmd5_status", checkMd5Status);
                } catch (Throwable unused) {
                }
                if (!DownloadUtils.isMd5Valid(checkMd5Status)) {
                    return PluginError.ERROR_UPD_CAPACITY;
                }
            }
            int i3 = this.f24300g;
            if (i3 != 2000) {
                return i3;
            }
            if (obtain.optInt("install_failed_check_signature", 1) == 1 && nt.g(pa.getContext(), zxVar.q())) {
                if (!nt.j(nt.y(pa.getContext(), downloadInfo.getTargetFilePath()), nt.lg(pa.getContext(), zxVar.q()))) {
                    return PluginError.ERROR_UPD_REQUEST;
                }
            }
            if (!z) {
                return 2002;
            }
            long j2 = this.q;
            long j3 = this.f24301i;
            if (j2 <= j3) {
                return 2000;
            }
            try {
                jSONObject.put("install_time", j2 - j3);
                if (zxVar.qo() <= this.f24301i) {
                    i2 = 0;
                }
                jSONObject.put("install_again", i2);
            } catch (Throwable unused2) {
            }
            if (z2) {
                return PluginError.ERROR_UPD_EXTRACT;
            }
            return 2003;
        }
    }

    private j() {
        com.ss.android.socialbase.appdownloader.zx.j(this);
        AppStatusManager.getInstance().registerAppSwitchListener(this);
    }

    private int g(com.ss.android.downloadad.api.j.zx zxVar) {
        int realStatus;
        double optDouble = DownloadSetting.obtain(zxVar.v()).optDouble("download_failed_finally_hours", 48.0d);
        if (optDouble <= 0.0d) {
            return -1;
        }
        if (System.currentTimeMillis() - zxVar.me() < optDouble * 60.0d * 60.0d * 1000.0d) {
            return 1;
        }
        if (zxVar.f24093g.get()) {
            return 0;
        }
        DownloadInfo downloadInfo = Downloader.getInstance(pa.getContext()).getDownloadInfo(zxVar.v());
        if (downloadInfo == null || (realStatus = downloadInfo.getRealStatus()) == -3 || realStatus == -4) {
            return -1;
        }
        if (!DownloadStatus.isDownloading(realStatus) && zxVar.f24093g.compareAndSet(false, true)) {
            try {
                JSONObject jSONObject = new JSONObject();
                j(jSONObject, downloadInfo);
                jSONObject.putOpt(MonitorConstants.EXTRA_DOWNLOAD_STATUS, Integer.valueOf(realStatus));
                jSONObject.putOpt("fail_status", Integer.valueOf(zxVar.l()));
                jSONObject.putOpt("fail_msg", zxVar.vs());
                jSONObject.put("download_failed_times", zxVar.mx());
                if (downloadInfo.getTotalBytes() > 0) {
                    double curBytes = downloadInfo.getCurBytes();
                    double totalBytes = downloadInfo.getTotalBytes();
                    Double.isNaN(curBytes);
                    Double.isNaN(totalBytes);
                    jSONObject.put("download_percent", curBytes / totalBytes);
                }
                jSONObject.put("is_update_download", zxVar.ty() ? 1 : 2);
                com.ss.android.downloadlib.g.j.j().j(zxVar.pa(), "download_failed_finally", jSONObject, zxVar);
                k.j().j(zxVar);
                return 0;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return 1;
    }

    public static JSONObject zx(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject == null || downloadInfo == null || DownloadSetting.obtain(downloadInfo.getId()).optInt("download_event_opt", 1) == 0) {
            return jSONObject;
        }
        try {
            long j2 = nt.j(0L);
            double d2 = j2;
            Double.isNaN(d2);
            jSONObject.put("available_space", d2 / 1048576.0d);
            long totalBytes = downloadInfo.getTotalBytes();
            double d3 = totalBytes;
            Double.isNaN(d3);
            jSONObject.put("apk_size", d3 / 1048576.0d);
            if (j2 > 0 && totalBytes > 0) {
                Double.isNaN(d2);
                Double.isNaN(d3);
                jSONObject.put("available_space_ratio", d2 / d3);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppBackground() {
        Logger.d(f24288j, "onAppBackground()");
        j(6);
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppForeground() {
        Logger.d(f24288j, "onAppForeground()");
        zx();
        j(5);
    }

    @Override // com.ss.android.socialbase.downloader.depend.IOpenInstallerListener
    public void onOpenInstaller(@Nullable DownloadInfo downloadInfo, @Nullable String str) {
        if (downloadInfo == null) {
            com.ss.android.downloadlib.q.i.j().j("info is null");
        } else if ((DownloadSetting.obtain(downloadInfo).optInt("check_applink_mode") & 2) != 0) {
            com.ss.android.downloadlib.zx.q.j().zx(new com.ss.android.downloadlib.zx.g() { // from class: com.ss.android.downloadlib.j.4

                /* renamed from: j */
                final /* synthetic */ DownloadInfo f24296j;
                final /* synthetic */ JSONObject zx;

                AnonymousClass4(DownloadInfo downloadInfo2, JSONObject jSONObject) {
                    downloadInfo = downloadInfo2;
                    jSONObject = jSONObject;
                }

                @Override // com.ss.android.downloadlib.zx.g
                public void j(boolean z) {
                    if (!z) {
                        Intent intent = (Intent) downloadInfo.getTempCacheData().get("intent");
                        if (intent != null) {
                            downloadInfo.getTempCacheData().remove("intent");
                            com.ss.android.socialbase.appdownloader.i.j(pa.getContext(), intent);
                            nt.j(jSONObject, MiConfigSingleton.v0, (Object) 1);
                        } else {
                            nt.j(jSONObject, MiConfigSingleton.v0, (Object) 2);
                        }
                    }
                    com.ss.android.downloadad.api.j.zx j2 = com.ss.android.downloadlib.addownload.zx.gv.j().j(downloadInfo);
                    if (j2 != null) {
                        com.ss.android.downloadlib.g.j.j().j(z ? "installer_delay_success" : "installer_delay_failed", jSONObject, j2);
                    } else {
                        com.ss.android.downloadlib.q.i.j().zx("ah nativeModel=null");
                    }
                    if (z) {
                        pa.gm().j(pa.getContext(), null, null, null, null, 1);
                    }
                }
            });
        }
    }

    @WorkerThread
    public void i(com.ss.android.downloadad.api.j.zx zxVar) {
        SystemClock.sleep(20000L);
        int i2 = 15;
        while (i2 > 0) {
            if (nt.zx(zxVar)) {
                j(zxVar.q());
                return;
            }
            i2--;
            if (i2 == 0) {
                return;
            } else {
                SystemClock.sleep(20000L);
            }
        }
    }

    public static j j() {
        if (f24287g == null) {
            synchronized (j.class) {
                if (f24287g == null) {
                    f24287g = new j();
                }
            }
        }
        return f24287g;
    }

    public static String i(@NonNull DownloadInfo downloadInfo, @NonNull com.ss.android.downloadad.api.j.zx zxVar) {
        File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        String str = null;
        if (file.exists()) {
            try {
                PackageInfo packageArchiveInfo = pa.getContext().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), com.ss.android.socialbase.appdownloader.i.j());
                if (packageArchiveInfo != null) {
                    str = packageArchiveInfo.packageName;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(str) && !str.equals(downloadInfo.getPackageName())) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("real_package_name", str);
                jSONObject.put("input_package_name", downloadInfo.getPackageName());
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            com.ss.android.downloadlib.g.j.j().j("embeded_ad", "package_name_error", jSONObject, zxVar);
            return str;
        }
        return downloadInfo.getPackageName();
    }

    @WorkerThread
    public static synchronized void j(DownloadInfo downloadInfo, com.ss.android.downloadad.api.j.zx zxVar) {
        synchronized (j.class) {
            if (downloadInfo == null) {
                com.ss.android.downloadlib.q.i.j().j("onDownloadFinish info null");
                return;
            }
            if (zxVar == null) {
                com.ss.android.downloadlib.q.i.j().j("onDownloadFinish nativeModel null");
                return;
            }
            if (zxVar.up() != 1) {
                return;
            }
            com.ss.android.downloadlib.i.y.j().g(zxVar);
            String i2 = i(downloadInfo, zxVar);
            com.ss.android.downloadlib.addownload.zx.gv.j().zx(downloadInfo.getUrl(), i2);
            Map<Long, com.ss.android.downloadad.api.j.zx> j2 = com.ss.android.downloadlib.addownload.zx.gv.j().j(downloadInfo.getUrl(), i2);
            zxVar.gv(System.currentTimeMillis());
            zxVar.q(2);
            zxVar.zx(i2);
            j2.put(Long.valueOf(zxVar.zx()), zxVar);
            k.j().j(j2.values());
            zx(zxVar);
            lg.j().j(downloadInfo, i2);
            if (AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType())) {
                j().j(zxVar);
                j().zx(downloadInfo, zxVar);
                if (zxVar.qt()) {
                    com.ss.android.downloadlib.addownload.j.j.j().j(downloadInfo.getId(), zxVar.zx(), zxVar.nt(), i2, downloadInfo.getTitle(), zxVar.g(), downloadInfo.getTargetFilePath());
                }
                com.ss.android.downloadlib.addownload.q.j.j(downloadInfo, zxVar.zx(), zxVar.g(), i2);
            }
        }
    }

    public void zx(DownloadInfo downloadInfo, com.ss.android.downloadad.api.j.zx zxVar) {
        if (downloadInfo == null || zxVar == null || DownloadSetting.obtain(downloadInfo.getId()).optInt("install_finish_check_ttmd5", 1) == 0) {
            return;
        }
        String targetFilePath = downloadInfo.getTargetFilePath();
        if (TextUtils.isEmpty(targetFilePath)) {
            return;
        }
        g.j().zx(new Runnable() { // from class: com.ss.android.downloadlib.j.3

            /* renamed from: j */
            final /* synthetic */ String f24294j;
            final /* synthetic */ com.ss.android.downloadad.api.j.zx zx;

            AnonymousClass3(String targetFilePath2, com.ss.android.downloadad.api.j.zx zxVar2) {
                targetFilePath = targetFilePath2;
                zxVar = zxVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String j2 = com.ss.android.downloadlib.lg.j.j(targetFilePath);
                if (TextUtils.isEmpty(j2)) {
                    return;
                }
                pa.getContext().getSharedPreferences("sp_ttdownloader_md5", 0).edit().putString(String.valueOf(zxVar.zx()), j2).apply();
            }
        });
    }

    private static void zx(com.ss.android.downloadad.api.j.zx zxVar) {
        if (zxVar == null) {
            return;
        }
        String ts = TextUtils.isEmpty(zxVar.ts()) ? "" : zxVar.ts();
        DownloadInfo downloadInfo = Downloader.getInstance(pa.getContext()).getDownloadInfo(zxVar.v());
        zxVar.nt("");
        k.j().j(zxVar);
        JSONObject j2 = j(new JSONObject(), downloadInfo);
        int i2 = 1;
        try {
            j2.putOpt("finish_reason", ts);
            j2.putOpt("finish_from_reserve_wifi", Integer.valueOf(downloadInfo.isDownloadFromReserveWifi() ? 1 : 0));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadad.api.j.zx j3 = com.ss.android.downloadlib.addownload.zx.gv.j().j(downloadInfo);
        com.ss.android.downloadlib.lg.gv.j(j2, downloadInfo.getId());
        try {
            j2.put("download_failed_times", j3.mx());
            j2.put("can_show_notification", com.ss.android.socialbase.appdownloader.q.g.j() ? 1 : 2);
            if (downloadInfo.getExpectFileLength() > 0 && downloadInfo.getTotalBytes() > 0) {
                j2.put("file_length_gap", downloadInfo.getExpectFileLength() - downloadInfo.getTotalBytes());
            }
            j2.put("ttmd5_status", downloadInfo.getTTMd5CheckStatus());
            j2.put("has_send_download_failed_finally", j3.f24093g.get() ? 1 : 2);
            if (!j3.ty()) {
                i2 = 2;
            }
            j2.put("is_update_download", i2);
            com.ss.android.downloadlib.lg.gv.j(j3, j2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        com.ss.android.downloadlib.g.j.j().zx("download_finish", j2, zxVar);
    }

    synchronized void zx() {
        zx zxVar = this.f24289i;
        if (zxVar != null) {
            zxVar.zx();
            this.f24289i = null;
        }
    }

    @WorkerThread
    public synchronized void j(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!nt.j()) {
            com.ss.android.downloadad.api.j.zx j2 = com.ss.android.downloadlib.addownload.zx.gv.j().j(str);
            if (j2 == null) {
                com.ss.android.downloadlib.addownload.zx.g.j().j(str);
                return;
            }
            com.ss.android.downloadlib.addownload.q j3 = lg.j().j(j2.j());
            if (j3 != null) {
                j3.gv();
            }
            if (j2.f24094i.get()) {
                return;
            }
            if (DownloadSetting.obtain(j2.v()).optInt("notification_opt_2") == 1) {
                DownloadNotificationManager.getInstance().cancelNotification(j2.v());
            }
            new com.ss.android.downloadlib.zx.zx().j(j2, new com.ss.android.downloadlib.zx.lg() { // from class: com.ss.android.downloadlib.j.1

                /* renamed from: j */
                final /* synthetic */ com.ss.android.downloadad.api.j.zx f24291j;
                final /* synthetic */ String zx;

                AnonymousClass1(com.ss.android.downloadad.api.j.zx j22, String str2) {
                    j2 = j22;
                    str = str2;
                }

                @Override // com.ss.android.downloadlib.zx.lg
                public void j(boolean z) {
                    Logger.d(j.f24288j, "appBackForeground->" + z);
                    if (!z) {
                        if (com.ss.android.downloadlib.zx.j.j(str, j2) || j2.hk() != 4) {
                            return;
                        }
                        com.ss.android.downloadlib.addownload.j.j.j().j(j2);
                        return;
                    }
                    if (!(com.ss.android.downloadlib.zx.gv.i(j2) ? com.ss.android.downloadlib.zx.j.j(str, j2) : false) && com.ss.android.downloadlib.zx.gv.g(j2) && j2.hk() == 4) {
                        com.ss.android.downloadlib.addownload.j.j.j().j(j2);
                    }
                }
            }, com.ss.android.downloadlib.lg.q.j(j22).optInt("try_applink_delay_after_installed", 0));
            com.ss.android.downloadlib.i.y.j().gv(j22);
            j(str2, j22);
            com.ss.android.downloadlib.addownload.j.j.j().zx(str2);
            DownloadInfo j4 = j((List<DownloadInfo>) Downloader.getInstance(pa.getContext()).getSuccessedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK), str2);
            if (j4 != null) {
                if (DownloadSetting.obtain(j4.getId()).optInt(DownloadSettingKeys.NO_HIDE_NOTIFICATION) != 1) {
                    DownloadNotificationManager.getInstance().hideNotification(j4.getId());
                }
                lg.j().zx(j4, str2);
                com.ss.android.downloadlib.addownload.i.g.j(j4);
            } else {
                lg.j().zx(null, str2);
            }
            return;
        }
        throw new RuntimeException("handleAppInstalled in main thread.");
    }

    private JSONObject zx(@NonNull DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.j jVar) {
        com.ss.android.downloadad.api.j.zx j2 = com.ss.android.downloadlib.addownload.zx.gv.j().j(downloadInfo);
        if (j2 == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jVar.j(jSONObject);
        try {
            jSONObject.put("download_id", downloadInfo.getId());
            jSONObject.put("name", downloadInfo.getName());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        com.ss.android.downloadlib.lg.gv.j(jSONObject, downloadInfo.getId());
        com.ss.android.downloadlib.g.j.j().j("embeded_ad", "ah_result", jSONObject, j2);
        return jSONObject;
    }

    void j(DownloadInfo downloadInfo, com.ss.android.downloadad.api.j.zx zxVar, int i2) {
        long max;
        if (downloadInfo == null || zxVar == null) {
            return;
        }
        zx();
        long currentTimeMillis = System.currentTimeMillis();
        zxVar.zx(currentTimeMillis);
        zxVar.lg(nt.j(Environment.getDataDirectory(), -1L));
        if (i2 != 2000) {
            max = 2000;
        } else {
            long optLong = DownloadSetting.obtain(downloadInfo.getId()).optLong("check_install_failed_delay_time", 120000L);
            if (optLong < 0) {
                return;
            } else {
                max = Math.max(optLong, 30000L);
            }
        }
        long j2 = max;
        zx zxVar2 = new zx(zxVar.zx(), downloadInfo.getId(), currentTimeMillis, i2);
        g.j().j(zxVar2, j2);
        this.f24289i = zxVar2;
        k.j().j(zxVar);
    }

    public void j(long j2, int i2) {
        long optLong = DownloadSetting.obtain(i2).optLong("check_install_finish_hijack_delay_time", 900000L);
        if (optLong < 0) {
            return;
        }
        g.j().j(new Runnable() { // from class: com.ss.android.downloadlib.j.2

            /* renamed from: j */
            final /* synthetic */ long f24292j;

            AnonymousClass2(long j22) {
                j2 = j22;
            }

            @Override // java.lang.Runnable
            public void run() {
                j.j().j(j2);
            }
        }, Math.max(optLong, a.k));
    }

    public void j(long j2) {
        g.j j3;
        int i2;
        try {
            com.ss.android.downloadad.api.j.zx g2 = com.ss.android.downloadlib.addownload.zx.gv.j().g(j2);
            if (g2 != null && !nt.zx(g2) && !g2.f24094i.get()) {
                Pair<g.j, Integer> zx2 = com.ss.android.downloadlib.addownload.zx.g.j().zx(g2);
                if (zx2 != null) {
                    j3 = (g.j) zx2.first;
                    i2 = ((Integer) zx2.second).intValue();
                } else {
                    j3 = com.ss.android.downloadlib.addownload.zx.g.j().j(g2);
                    i2 = -1;
                }
                if (j3 == null) {
                    return;
                }
                com.ss.android.downloadlib.addownload.zx.g.j().zx(j3.f24221j);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("installed_app_name", j3.f24219g);
                jSONObject.put("installed_pkg_name", j3.f24221j);
                if (i2 != -1) {
                    jSONObject.put("error_code", i2);
                    com.ss.android.downloadlib.lg.gv.j(jSONObject, g2.v());
                    com.ss.android.downloadlib.g.j.j().zx("install_finish_hijack", jSONObject, g2);
                    return;
                }
                com.ss.android.downloadlib.g.j.j().zx("install_finish_may_hijack", jSONObject, g2);
            }
        } catch (Throwable th) {
            com.ss.android.downloadlib.q.i.j().j(th, "trySendInstallFinishHijack");
        }
    }

    public void j(String str, com.ss.android.downloadad.api.j.zx zxVar) {
        if (zxVar != null && nt.zx(zxVar) && zxVar.f24094i.compareAndSet(false, true)) {
            com.ss.android.downloadlib.g.j.j().j(zxVar.pa(), "install_finish", j(zxVar, str, zxVar.hk() != 4 ? 3 : 4), zxVar);
            k.j().j(zxVar);
        }
    }

    private static DownloadInfo j(List<DownloadInfo> list, String str) {
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null) {
                    if (str.equals(downloadInfo.getPackageName())) {
                        return downloadInfo;
                    }
                    if (nt.j(pa.getContext(), downloadInfo.getTargetFilePath(), str)) {
                        return downloadInfo;
                    }
                }
            }
        }
        return null;
    }

    public static JSONObject j(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject != null && downloadInfo != null) {
            int i2 = 1;
            if (DownloadSetting.obtain(downloadInfo.getId()).optInt("download_event_opt", 1) == 0) {
                return jSONObject;
            }
            try {
                jSONObject.put("download_id", downloadInfo.getId());
                jSONObject.put("name", downloadInfo.getName());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_CUR_BYTES, downloadInfo.getCurBytes());
                jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_NETWORK_QUALITY, downloadInfo.getNetworkQuality());
                jSONObject.put(MonitorConstants.EXTRA_CUR_NETWORK_QUALITY, NetTrafficManager.getInstance().getCurrentNetworkQuality().name());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_ONLY_WIFI, downloadInfo.isOnlyWifi() ? 1 : 0);
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_NEED_HTTPS_DEGRADE, downloadInfo.isNeedHttpsToHttpRetry() ? 1 : 0);
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_HTTPS_DEGRADE_RETRY_USED, downloadInfo.isHttpsToHttpRetryUsed() ? 1 : 0);
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_CHUNK_COUNT, downloadInfo.getChunkCount());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_RETRY_COUNT, downloadInfo.getRetryCount());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_CUR_RETRY_TIME, downloadInfo.getCurRetryTime());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_NEED_RETRY_DELAY, downloadInfo.isNeedRetryDelay() ? 1 : 0);
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_BACKUP_URL_USED, downloadInfo.isBackUpUrlUsed() ? 1 : 0);
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_HEAD_CONNECTION_ERROR_MSG, downloadInfo.getHeadConnectionException() != null ? downloadInfo.getHeadConnectionException() : "");
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_NEED_INDEPENDENT_PROCESS, downloadInfo.isNeedIndependentProcess() ? 1 : 0);
                jSONObject.put(MonitorConstants.EXTRA_TOTAL_RETRY_COUNT, downloadInfo.getTotalRetryCount());
                jSONObject.put(MonitorConstants.EXTRA_CUR_RETRY_TIME_IN_TOTAL, downloadInfo.getCurRetryTimeInTotal());
                jSONObject.put(MonitorConstants.EXTRA_REAL_DOWNLOAD_TIME, downloadInfo.getRealDownloadTime());
                jSONObject.put("first_speed_time", downloadInfo.getFirstSpeedTime());
                jSONObject.put("all_connect_time", downloadInfo.getAllConnectTime());
                jSONObject.put("download_prepare_time", downloadInfo.getDownloadPrepareTime());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_TIME, downloadInfo.getRealDownloadTime() + downloadInfo.getAllConnectTime() + downloadInfo.getDownloadPrepareTime());
                jSONObject.put(MonitorConstants.EXTRA_CHUNK_DOWNGRADE_UESD, downloadInfo.isChunkDowngradeRetryUsed() ? 1 : 0);
                jSONObject.put(MonitorConstants.EXTRA_NEED_CHUNK_DOWNGRADE_RETRY, downloadInfo.isNeedChunkDowngradeRetry() ? 1 : 0);
                jSONObject.put("failed_resume_count", downloadInfo.getFailedResumeCount());
                jSONObject.put(MonitorConstants.EXTRA_PRECONNECT_LEVEL, downloadInfo.getPreconnectLevel());
                jSONObject.put("md5", downloadInfo.getMd5());
                jSONObject.put("expect_file_length", downloadInfo.getExpectFileLength());
                jSONObject.put("retry_schedule_count", downloadInfo.getRetryScheduleCount());
                jSONObject.put("rw_concurrent", downloadInfo.isRwConcurrent() ? 1 : 0);
                double curBytes = downloadInfo.getCurBytes();
                Double.isNaN(curBytes);
                double d2 = curBytes / 1048576.0d;
                double realDownloadTime = downloadInfo.getRealDownloadTime();
                Double.isNaN(realDownloadTime);
                double d3 = realDownloadTime / 1000.0d;
                if (d2 > 0.0d && d3 > 0.0d) {
                    double d4 = d2 / d3;
                    try {
                        jSONObject.put(MonitorConstants.DOWNLOAD_SPEED, d4);
                    } catch (Exception unused) {
                    }
                    Logger.d(f24288j, "download speed : " + d4 + "MB/s");
                }
                try {
                    jSONObject.put("is_download_service_foreground", Downloader.getInstance(pa.getContext()).isDownloadServiceForeground(downloadInfo.getId()) ? 1 : 0);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (downloadInfo.getBackUpUrls() != null) {
                    jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_BACKUP_URL_COUNT, downloadInfo.getBackUpUrls().size());
                    jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_CUR_BACKUP_URL_INDEX, downloadInfo.getCurBackUpUrlIndex());
                }
                jSONObject.put("clear_space_restart_times", com.ss.android.downloadlib.addownload.i.g.j().zx(downloadInfo.getUrl()));
                jSONObject.put("mime_type", downloadInfo.getMimeType());
                if (!DownloadUtils.isNetworkConnected(pa.getContext())) {
                    i2 = 2;
                }
                jSONObject.put("network_available", i2);
                jSONObject.put(MonitorConstants.STATUS_CODE, downloadInfo.getHttpStatusCode());
                zx(jSONObject, downloadInfo);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return jSONObject;
    }

    private int j(com.ss.android.downloadad.api.j.zx zxVar, DownloadInfo downloadInfo, String str, JSONObject jSONObject) {
        int zx2 = com.ss.android.socialbase.appdownloader.i.zx(pa.getContext(), downloadInfo);
        int zx3 = nt.zx(pa.getContext(), str);
        if (zx2 > 0 && zx3 > 0 && zx2 != zx3) {
            return zx3 > zx2 ? 3011 : 3010;
        }
        if (DownloadSetting.obtain(zxVar.v()).optInt("install_finish_check_ttmd5", 1) != 1) {
            return 3001;
        }
        String string = pa.getContext().getSharedPreferences("sp_ttdownloader_md5", 0).getString(String.valueOf(zxVar.zx()), null);
        if (TextUtils.isEmpty(string) && downloadInfo != null) {
            string = com.ss.android.downloadlib.lg.j.j(downloadInfo.getTargetFilePath());
        }
        int j2 = com.ss.android.downloadlib.lg.j.j(string, com.ss.android.downloadlib.lg.j.zx(str));
        try {
            jSONObject.put("ttmd5_status", j2);
        } catch (Throwable unused) {
        }
        if (j2 == 0) {
            return 3000;
        }
        return j2 == 1 ? 3002 : 3001;
    }

    @Override // com.ss.android.downloadad.api.j
    public void j(int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.zx < 120000) {
            return;
        }
        g.j().j(new RunnableC0497j(i2), this.zx > 0 ? 2000L : 8000L);
        this.zx = currentTimeMillis;
    }

    @WorkerThread
    public void j(@NonNull ConcurrentHashMap<Long, com.ss.android.downloadad.api.j.zx> concurrentHashMap, int i2) {
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        for (com.ss.android.downloadad.api.j.zx zxVar : concurrentHashMap.values()) {
            if (zxVar.f24094i.get()) {
                if (currentTimeMillis - zxVar.me() >= DownloadSetting.obtain(zxVar.v()).optInt("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(zxVar.zx()));
                }
            } else if (zxVar.up() == 1) {
                if (g(zxVar) <= 0 && currentTimeMillis - zxVar.me() >= DownloadSetting.obtain(zxVar.v()).optInt("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(zxVar.zx()));
                }
            } else if (zxVar.up() == 2) {
                if (!zxVar.lv()) {
                    if (nt.zx(zxVar)) {
                        if (zxVar.hk() == 4) {
                            i2 = zxVar.hk();
                        }
                        com.ss.android.downloadlib.g.j.j().j(j(zxVar, zxVar.q(), i2), zxVar);
                        arrayList.add(Long.valueOf(zxVar.zx()));
                        com.ss.android.downloadlib.addownload.i.g.j(zxVar);
                    } else if (currentTimeMillis - zxVar.me() >= DownloadSetting.obtain(zxVar.v()).optInt("finish_event_expire_hours", 168) * 60 * 60 * 1000) {
                        arrayList.add(Long.valueOf(zxVar.zx()));
                    } else if (TextUtils.isEmpty(zxVar.q())) {
                        arrayList.add(Long.valueOf(zxVar.zx()));
                    }
                }
            } else {
                arrayList.add(Long.valueOf(zxVar.zx()));
            }
        }
        com.ss.android.downloadlib.addownload.zx.gv.j().j(arrayList);
    }

    @Override // com.ss.android.socialbase.appdownloader.zx.i
    public void j(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.j jVar) {
        JSONObject zx2;
        if (downloadInfo == null || jVar == null) {
            return;
        }
        JSONArray optJSONArray = DownloadSetting.obtain(downloadInfo.getId()).optJSONArray("ah_report_config");
        if (jVar.zx != 0) {
            downloadInfo.getTempCacheData().remove("intent");
        }
        if (optJSONArray == null || (zx2 = zx(downloadInfo, jVar)) == null) {
            return;
        }
        downloadInfo.getTempCacheData().put("ah_ext_json", zx2);
    }

    public void j(com.ss.android.downloadad.api.j.zx zxVar) {
        g.j().j(new i(zxVar));
    }

    private JSONObject j(com.ss.android.downloadad.api.j.zx zxVar, String str, int i2) {
        com.ss.android.socialbase.appdownloader.j j2;
        JSONObject jSONObject = new JSONObject();
        try {
            DownloadInfo downloadInfo = Downloader.getInstance(pa.getContext()).getDownloadInfo(zxVar.v());
            jSONObject.putOpt("scene", Integer.valueOf(i2));
            com.ss.android.downloadlib.lg.gv.j(jSONObject, zxVar.v());
            com.ss.android.downloadlib.lg.gv.j(zxVar, jSONObject);
            jSONObject.put("is_update_download", zxVar.ty() ? 1 : 2);
            jSONObject.put("install_after_back_app", zxVar.xl() ? 1 : 2);
            jSONObject.putOpt("clean_space_install_params", zxVar.db() ? "1" : "2");
            if (downloadInfo != null) {
                j(jSONObject, downloadInfo);
                try {
                    jSONObject.put("uninstall_resume_count", downloadInfo.getUninstallResumeCount());
                    if (zxVar.qo() > 0) {
                        jSONObject.put("install_time", System.currentTimeMillis() - zxVar.qo());
                    }
                } catch (Throwable unused) {
                }
                String string = DownloadUtils.getString(downloadInfo.getTempCacheData().get("ah_attempt"), null);
                if (!TextUtils.isEmpty(string) && (j2 = com.ss.android.socialbase.appdownloader.j.j(string)) != null) {
                    j2.j(jSONObject);
                }
            }
            int j3 = j(zxVar, downloadInfo, str, jSONObject);
            jSONObject.put("fail_status", j3);
            if (j3 == 3000) {
                jSONObject.put("hijack", 2);
            } else if (j3 == 3001) {
                jSONObject.put("hijack", 0);
            } else {
                jSONObject.put("hijack", 1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public void j(DownloadInfo downloadInfo, long j2, long j3, long j4, long j5, long j6, boolean z) {
        com.ss.android.downloadad.api.j.zx j7 = com.ss.android.downloadlib.addownload.zx.gv.j().j(downloadInfo);
        if (j7 == null) {
            com.ss.android.downloadlib.q.i.j().j("trySendClearSpaceEvent nativeModel null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            double d2 = j2;
            Double.isNaN(d2);
            jSONObject.putOpt("space_before", Double.valueOf(d2 / 1048576.0d));
            double d3 = j3 - j2;
            Double.isNaN(d3);
            jSONObject.putOpt("space_cleaned", Double.valueOf(d3 / 1048576.0d));
            jSONObject.putOpt("clean_up_time_cost", Long.valueOf(j5));
            jSONObject.putOpt("is_download_restarted", Integer.valueOf(z ? 1 : 0));
            jSONObject.putOpt("byte_required", Long.valueOf(j4));
            double d4 = j4 - j3;
            Double.isNaN(d4);
            jSONObject.putOpt("byte_required_after", Double.valueOf(d4 / 1048576.0d));
            jSONObject.putOpt("clear_sleep_time", Long.valueOf(j6));
            com.ss.android.downloadlib.lg.gv.i(downloadInfo, jSONObject);
            com.ss.android.downloadlib.g.j.j().j("cleanup", jSONObject, j7);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
