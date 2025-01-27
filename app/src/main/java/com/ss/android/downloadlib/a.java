package com.ss.android.downloadlib;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.martian.mibook.application.MiConfigSingleton;
import com.sigmob.sdk.base.common.y;
import com.ss.android.downloadlib.addownload.b.d;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.addownload.l;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.appdownloader.b;
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
public class a implements com.ss.android.downloadad.api.a, b.c, AppStatusManager.AppStatusChangeListener, IOpenInstallerListener {

    /* renamed from: a */
    private static String f21082a = "a";

    /* renamed from: d */
    private static volatile a f21083d;

    /* renamed from: b */
    private long f21084b;

    /* renamed from: c */
    private b f21085c;

    /* renamed from: com.ss.android.downloadlib.a$1 */
    public class AnonymousClass1 implements com.ss.android.downloadlib.b.g {

        /* renamed from: a */
        final /* synthetic */ com.ss.android.downloadad.api.a.b f21086a;

        /* renamed from: b */
        final /* synthetic */ String f21087b;

        public AnonymousClass1(com.ss.android.downloadad.api.a.b bVar, String str) {
            a10 = bVar;
            str = str;
        }

        @Override // com.ss.android.downloadlib.b.g
        public void a(boolean z10) {
            Logger.d(a.f21082a, "appBackForeground->" + z10);
            if (!z10) {
                if (com.ss.android.downloadlib.b.a.a(str, a10) || a10.K() != 4) {
                    return;
                }
                com.ss.android.downloadlib.addownload.a.a.a().a(a10);
                return;
            }
            if (!(com.ss.android.downloadlib.b.f.c(a10) ? com.ss.android.downloadlib.b.a.a(str, a10) : false) && com.ss.android.downloadlib.b.f.d(a10) && a10.K() == 4) {
                com.ss.android.downloadlib.addownload.a.a.a().a(a10);
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.a$2 */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ long f21089a;

        public AnonymousClass2(long j10) {
            j10 = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a().a(j10);
        }
    }

    /* renamed from: com.ss.android.downloadlib.a$3 */
    public class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f21091a;

        /* renamed from: b */
        final /* synthetic */ com.ss.android.downloadad.api.a.b f21092b;

        public AnonymousClass3(String str, com.ss.android.downloadad.api.a.b bVar) {
            targetFilePath = str;
            bVar = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String a10 = com.ss.android.downloadlib.g.a.a(targetFilePath);
            if (TextUtils.isEmpty(a10)) {
                return;
            }
            k.a().getSharedPreferences("sp_ttdownloader_md5", 0).edit().putString(String.valueOf(bVar.b()), a10).apply();
        }
    }

    /* renamed from: com.ss.android.downloadlib.a$4 */
    public class AnonymousClass4 implements com.ss.android.downloadlib.b.d {

        /* renamed from: a */
        final /* synthetic */ DownloadInfo f21094a;

        /* renamed from: b */
        final /* synthetic */ JSONObject f21095b;

        public AnonymousClass4(DownloadInfo downloadInfo, JSONObject jSONObject) {
            downloadInfo = downloadInfo;
            jSONObject = jSONObject;
        }

        @Override // com.ss.android.downloadlib.b.d
        public void a(boolean z10) {
            if (!z10) {
                Intent intent = (Intent) downloadInfo.getTempCacheData().get("intent");
                if (intent != null) {
                    downloadInfo.getTempCacheData().remove("intent");
                    com.ss.android.socialbase.appdownloader.c.a(k.a(), intent);
                    m.a(jSONObject, MiConfigSingleton.Q0, (Object) 1);
                } else {
                    m.a(jSONObject, MiConfigSingleton.Q0, (Object) 2);
                }
            }
            com.ss.android.downloadad.api.a.b a10 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
            if (a10 != null) {
                com.ss.android.downloadlib.d.a.a().a(z10 ? "installer_delay_success" : "installer_delay_failed", jSONObject, a10);
            } else {
                com.ss.android.downloadlib.e.c.a().b("ah nativeModel=null");
            }
            if (z10) {
                k.v().a(k.a(), null, null, null, null, 1);
            }
        }
    }

    @WorkerThread
    /* renamed from: com.ss.android.downloadlib.a$a */
    public class RunnableC0632a implements Runnable {

        /* renamed from: b */
        private final int f21098b;

        public RunnableC0632a(int i10) {
            this.f21098b = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.ss.android.downloadlib.addownload.b.f.a().b();
                ConcurrentHashMap<Long, com.ss.android.downloadad.api.a.b> c10 = com.ss.android.downloadlib.addownload.b.f.a().c();
                if (c10 == null || c10.isEmpty()) {
                    return;
                }
                a.this.a(c10, this.f21098b);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public static class b implements Runnable {

        /* renamed from: a */
        private long f21124a;

        /* renamed from: b */
        private int f21125b;

        /* renamed from: c */
        private long f21126c;

        /* renamed from: d */
        private int f21127d;

        /* renamed from: e */
        private long f21128e;

        public /* synthetic */ b(long j10, int i10, long j11, int i11, AnonymousClass1 anonymousClass1) {
            this(j10, i10, j11, i11);
        }

        public void b() {
            this.f21128e = System.currentTimeMillis();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (a()) {
                    a.a().a(this.f21124a, this.f21125b);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }

        private b(long j10, int i10, long j11, int i11) {
            this.f21124a = j10;
            this.f21125b = i10;
            this.f21126c = j11;
            this.f21127d = i11;
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0064, code lost:
        
            if (r9 < r1) goto L133;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a() {
            /*
                Method dump skipped, instructions count: 258
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.a.b.a():boolean");
        }

        private int a(boolean z10, com.ss.android.downloadad.api.a.b bVar, DownloadInfo downloadInfo, boolean z11, JSONObject jSONObject) {
            DownloadSetting obtain = DownloadSetting.obtain(downloadInfo.getId());
            int i10 = 1;
            if (obtain.optInt("install_failed_check_ttmd5", 1) == 1) {
                int checkMd5Status = downloadInfo.checkMd5Status();
                try {
                    jSONObject.put("ttmd5_status", checkMd5Status);
                } catch (Throwable unused) {
                }
                if (!DownloadUtils.isMd5Valid(checkMd5Status)) {
                    return 2005;
                }
            }
            int i11 = this.f21127d;
            if (i11 != 2000) {
                return i11;
            }
            if (obtain.optInt("install_failed_check_signature", 1) == 1 && m.e(k.a(), bVar.e())) {
                if (!m.a(m.i(k.a(), downloadInfo.getTargetFilePath()), m.h(k.a(), bVar.e()))) {
                    return 2006;
                }
            }
            if (!z10) {
                return 2002;
            }
            long j10 = this.f21128e;
            long j11 = this.f21126c;
            if (j10 <= j11) {
                return 2000;
            }
            try {
                jSONObject.put("install_time", j10 - j11);
                if (bVar.C() <= this.f21126c) {
                    i10 = 0;
                }
                jSONObject.put("install_again", i10);
            } catch (Throwable unused2) {
            }
            return !z11 ? 2003 : 2004;
        }
    }

    private a() {
        com.ss.android.socialbase.appdownloader.b.a(this);
        AppStatusManager.getInstance().registerAppSwitchListener(this);
    }

    public static JSONObject b(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject == null || downloadInfo == null || DownloadSetting.obtain(downloadInfo.getId()).optInt("download_event_opt", 1) == 0) {
            return jSONObject;
        }
        try {
            long b10 = m.b(0L);
            double d10 = b10;
            jSONObject.put("available_space", d10 / 1048576.0d);
            long totalBytes = downloadInfo.getTotalBytes();
            double d11 = totalBytes;
            jSONObject.put("apk_size", d11 / 1048576.0d);
            if (b10 > 0 && totalBytes > 0) {
                jSONObject.put("available_space_ratio", d10 / d11);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppBackground() {
        Logger.d(f21082a, "onAppBackground()");
        a(6);
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppForeground() {
        Logger.d(f21082a, "onAppForeground()");
        b();
        a(5);
    }

    @Override // com.ss.android.socialbase.downloader.depend.IOpenInstallerListener
    public void onOpenInstaller(@Nullable DownloadInfo downloadInfo, @Nullable String str) {
        if (downloadInfo == null) {
            com.ss.android.downloadlib.e.c.a().a("info is null");
        } else if ((DownloadSetting.obtain(downloadInfo).optInt("check_applink_mode") & 2) != 0) {
            com.ss.android.downloadlib.b.e.a().b(new com.ss.android.downloadlib.b.d() { // from class: com.ss.android.downloadlib.a.4

                /* renamed from: a */
                final /* synthetic */ DownloadInfo f21094a;

                /* renamed from: b */
                final /* synthetic */ JSONObject f21095b;

                public AnonymousClass4(DownloadInfo downloadInfo2, JSONObject jSONObject) {
                    downloadInfo = downloadInfo2;
                    jSONObject = jSONObject;
                }

                @Override // com.ss.android.downloadlib.b.d
                public void a(boolean z10) {
                    if (!z10) {
                        Intent intent = (Intent) downloadInfo.getTempCacheData().get("intent");
                        if (intent != null) {
                            downloadInfo.getTempCacheData().remove("intent");
                            com.ss.android.socialbase.appdownloader.c.a(k.a(), intent);
                            m.a(jSONObject, MiConfigSingleton.Q0, (Object) 1);
                        } else {
                            m.a(jSONObject, MiConfigSingleton.Q0, (Object) 2);
                        }
                    }
                    com.ss.android.downloadad.api.a.b a10 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
                    if (a10 != null) {
                        com.ss.android.downloadlib.d.a.a().a(z10 ? "installer_delay_success" : "installer_delay_failed", jSONObject, a10);
                    } else {
                        com.ss.android.downloadlib.e.c.a().b("ah nativeModel=null");
                    }
                    if (z10) {
                        k.v().a(k.a(), null, null, null, null, 1);
                    }
                }
            });
        }
    }

    public static a a() {
        if (f21083d == null) {
            synchronized (a.class) {
                try {
                    if (f21083d == null) {
                        f21083d = new a();
                    }
                } finally {
                }
            }
        }
        return f21083d;
    }

    public static String c(@NonNull DownloadInfo downloadInfo, @NonNull com.ss.android.downloadad.api.a.b bVar) {
        File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        String str = null;
        if (file.exists()) {
            try {
                PackageInfo packageArchiveInfo = k.a().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), com.ss.android.socialbase.appdownloader.c.a());
                if (packageArchiveInfo != null) {
                    str = packageArchiveInfo.packageName;
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(str) || str.equals(downloadInfo.getPackageName())) {
            return downloadInfo.getPackageName();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("real_package_name", str);
            jSONObject.put("input_package_name", downloadInfo.getPackageName());
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("embeded_ad", "package_name_error", jSONObject, bVar);
        return str;
    }

    @WorkerThread
    public static synchronized void a(DownloadInfo downloadInfo, com.ss.android.downloadad.api.a.b bVar) {
        synchronized (a.class) {
            if (downloadInfo == null) {
                com.ss.android.downloadlib.e.c.a().a("onDownloadFinish info null");
                return;
            }
            if (bVar == null) {
                com.ss.android.downloadlib.e.c.a().a("onDownloadFinish nativeModel null");
                return;
            }
            if (bVar.G() != 1) {
                return;
            }
            com.ss.android.downloadlib.c.h.a().d(bVar);
            String c10 = c(downloadInfo, bVar);
            com.ss.android.downloadlib.addownload.b.f.a().b(downloadInfo.getUrl(), c10);
            Map<Long, com.ss.android.downloadad.api.a.b> a10 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo.getUrl(), c10);
            bVar.f(System.currentTimeMillis());
            bVar.e(2);
            bVar.b(c10);
            a10.put(Long.valueOf(bVar.b()), bVar);
            com.ss.android.downloadlib.addownload.b.i.a().a(a10.values());
            a(bVar);
            g.a().a(downloadInfo, c10);
            if ("application/vnd.android.package-archive".equals(downloadInfo.getMimeType())) {
                if (com.ss.android.downloadlib.g.e.a((com.ss.android.downloadad.api.a.a) bVar).optInt("enable_app_install_receiver", 1) != 1 && k.j().optInt("enable_app_install_receiver", 1) != 1) {
                    l.a().a(bVar);
                }
                a().b(downloadInfo, bVar);
                if (bVar.L()) {
                    com.ss.android.downloadlib.addownload.a.a.a().a(downloadInfo.getId(), bVar.b(), bVar.l(), c10, downloadInfo.getTitle(), bVar.d(), downloadInfo.getTargetFilePath());
                }
                com.ss.android.downloadlib.addownload.e.a.a(downloadInfo, bVar.b(), bVar.d(), c10);
            }
        }
    }

    public void b(DownloadInfo downloadInfo, com.ss.android.downloadad.api.a.b bVar) {
        if (downloadInfo == null || bVar == null || DownloadSetting.obtain(downloadInfo.getId()).optInt("install_finish_check_ttmd5", 1) == 0) {
            return;
        }
        String targetFilePath = downloadInfo.getTargetFilePath();
        if (TextUtils.isEmpty(targetFilePath)) {
            return;
        }
        d.a().b(new Runnable() { // from class: com.ss.android.downloadlib.a.3

            /* renamed from: a */
            final /* synthetic */ String f21091a;

            /* renamed from: b */
            final /* synthetic */ com.ss.android.downloadad.api.a.b f21092b;

            public AnonymousClass3(String targetFilePath2, com.ss.android.downloadad.api.a.b bVar2) {
                targetFilePath = targetFilePath2;
                bVar = bVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String a10 = com.ss.android.downloadlib.g.a.a(targetFilePath);
                if (TextUtils.isEmpty(a10)) {
                    return;
                }
                k.a().getSharedPreferences("sp_ttdownloader_md5", 0).edit().putString(String.valueOf(bVar.b()), a10).apply();
            }
        });
    }

    public synchronized void b() {
        b bVar = this.f21085c;
        if (bVar != null) {
            bVar.b();
            this.f21085c = null;
        }
    }

    private int b(com.ss.android.downloadad.api.a.b bVar) {
        int realStatus;
        double optDouble = DownloadSetting.obtain(bVar.s()).optDouble("download_failed_finally_hours", 48.0d);
        if (optDouble <= l5.c.f27899e) {
            return -1;
        }
        if (System.currentTimeMillis() - bVar.H() < optDouble * 60.0d * 60.0d * 1000.0d) {
            return 1;
        }
        if (bVar.f21059d.get()) {
            return 0;
        }
        DownloadInfo downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(bVar.s());
        if (downloadInfo == null || (realStatus = downloadInfo.getRealStatus()) == -3 || realStatus == -4) {
            return -1;
        }
        if (!DownloadStatus.isDownloading(realStatus) && bVar.f21059d.compareAndSet(false, true)) {
            try {
                JSONObject jSONObject = new JSONObject();
                a(jSONObject, downloadInfo);
                jSONObject.putOpt(MonitorConstants.EXTRA_DOWNLOAD_STATUS, Integer.valueOf(realStatus));
                jSONObject.putOpt("fail_status", Integer.valueOf(bVar.E()));
                jSONObject.putOpt("fail_msg", bVar.F());
                jSONObject.put("download_failed_times", bVar.x());
                if (downloadInfo.getTotalBytes() > 0) {
                    jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
                }
                jSONObject.put("is_update_download", bVar.V() ? 1 : 2);
                com.ss.android.downloadlib.d.a.a().a(bVar.j(), "download_failed_finally", jSONObject, bVar);
                com.ss.android.downloadlib.addownload.b.i.a().a(bVar);
                return 0;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return 1;
    }

    @WorkerThread
    public synchronized void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!m.b()) {
            com.ss.android.downloadad.api.a.b a10 = com.ss.android.downloadlib.addownload.b.f.a().a(str);
            if (a10 == null) {
                com.ss.android.downloadlib.addownload.b.d.a().a(str);
                return;
            }
            com.ss.android.downloadlib.addownload.e a11 = g.a().a(a10.a());
            if (a11 != null) {
                a11.f();
            }
            if (a10.f21058c.get()) {
                return;
            }
            if (DownloadSetting.obtain(a10.s()).optInt("notification_opt_2") == 1) {
                DownloadNotificationManager.getInstance().cancelNotification(a10.s());
            }
            new com.ss.android.downloadlib.b.b().a(a10, new com.ss.android.downloadlib.b.g() { // from class: com.ss.android.downloadlib.a.1

                /* renamed from: a */
                final /* synthetic */ com.ss.android.downloadad.api.a.b f21086a;

                /* renamed from: b */
                final /* synthetic */ String f21087b;

                public AnonymousClass1(com.ss.android.downloadad.api.a.b a102, String str2) {
                    a10 = a102;
                    str = str2;
                }

                @Override // com.ss.android.downloadlib.b.g
                public void a(boolean z10) {
                    Logger.d(a.f21082a, "appBackForeground->" + z10);
                    if (!z10) {
                        if (com.ss.android.downloadlib.b.a.a(str, a10) || a10.K() != 4) {
                            return;
                        }
                        com.ss.android.downloadlib.addownload.a.a.a().a(a10);
                        return;
                    }
                    if (!(com.ss.android.downloadlib.b.f.c(a10) ? com.ss.android.downloadlib.b.a.a(str, a10) : false) && com.ss.android.downloadlib.b.f.d(a10) && a10.K() == 4) {
                        com.ss.android.downloadlib.addownload.a.a.a().a(a10);
                    }
                }
            }, com.ss.android.downloadlib.g.e.a((com.ss.android.downloadad.api.a.a) a102).optInt("try_applink_delay_after_installed", 0));
            com.ss.android.downloadlib.c.h.a().f(a102);
            a(str2, a102);
            com.ss.android.downloadlib.addownload.a.a.a().b(str2);
            DownloadInfo a12 = a((List<DownloadInfo>) Downloader.getInstance(k.a()).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive"), str2);
            if (a12 != null) {
                if (DownloadSetting.obtain(a12.getId()).optInt(DownloadSettingKeys.NO_HIDE_NOTIFICATION) != 1) {
                    DownloadNotificationManager.getInstance().hideNotification(a12.getId());
                }
                g.a().b(a12, str2);
                com.ss.android.downloadlib.addownload.c.d.a(a12);
            } else {
                g.a().b(null, str2);
            }
            return;
        }
        throw new RuntimeException("handleAppInstalled in main thread.");
    }

    private JSONObject b(@NonNull DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.a aVar) {
        com.ss.android.downloadad.api.a.b a10 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
        if (a10 == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        aVar.a(jSONObject);
        try {
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_ID, downloadInfo.getId());
            jSONObject.put("name", downloadInfo.getName());
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        com.ss.android.downloadlib.g.f.a(jSONObject, downloadInfo.getId());
        com.ss.android.downloadlib.d.a.a().a("embeded_ad", "ah_result", jSONObject, a10);
        return jSONObject;
    }

    public void a(DownloadInfo downloadInfo, com.ss.android.downloadad.api.a.b bVar, int i10) {
        long max;
        if (downloadInfo == null || bVar == null) {
            return;
        }
        b();
        long currentTimeMillis = System.currentTimeMillis();
        bVar.b(currentTimeMillis);
        bVar.g(m.a(Environment.getDataDirectory(), -1L));
        if (i10 != 2000) {
            max = y.f.f18076n;
        } else {
            long optLong = DownloadSetting.obtain(downloadInfo.getId()).optLong("check_install_failed_delay_time", 120000L);
            if (optLong < 0) {
                return;
            } else {
                max = Math.max(optLong, 30000L);
            }
        }
        long j10 = max;
        b bVar2 = new b(bVar.b(), downloadInfo.getId(), currentTimeMillis, i10);
        d.a().a(bVar2, j10);
        this.f21085c = bVar2;
        com.ss.android.downloadlib.addownload.b.i.a().a(bVar);
    }

    public void a(long j10, int i10) {
        long optLong = DownloadSetting.obtain(i10).optLong("check_install_finish_hijack_delay_time", 900000L);
        if (optLong < 0) {
            return;
        }
        d.a().a(new Runnable() { // from class: com.ss.android.downloadlib.a.2

            /* renamed from: a */
            final /* synthetic */ long f21089a;

            public AnonymousClass2(long j102) {
                j10 = j102;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.a().a(j10);
            }
        }, Math.max(optLong, 300000L));
    }

    public void a(long j10) {
        d.a a10;
        int i10;
        try {
            com.ss.android.downloadad.api.a.b d10 = com.ss.android.downloadlib.addownload.b.f.a().d(j10);
            if (d10 != null && !m.b(d10) && !d10.f21058c.get()) {
                Pair<d.a, Integer> b10 = com.ss.android.downloadlib.addownload.b.d.a().b(d10);
                if (b10 != null) {
                    a10 = (d.a) b10.first;
                    i10 = ((Integer) b10.second).intValue();
                } else {
                    a10 = com.ss.android.downloadlib.addownload.b.d.a().a(d10);
                    i10 = -1;
                }
                if (a10 == null) {
                    return;
                }
                com.ss.android.downloadlib.addownload.b.d.a().b(a10.f21211a);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("installed_app_name", a10.f21214d);
                jSONObject.put("installed_pkg_name", a10.f21211a);
                if (i10 != -1) {
                    jSONObject.put("error_code", i10);
                    com.ss.android.downloadlib.g.f.a(jSONObject, d10.s());
                    com.ss.android.downloadlib.d.a.a().b("install_finish_hijack", jSONObject, d10);
                    return;
                }
                com.ss.android.downloadlib.d.a.a().b("install_finish_may_hijack", jSONObject, d10);
            }
        } catch (Throwable th2) {
            com.ss.android.downloadlib.e.c.a().a(th2, "trySendInstallFinishHijack");
        }
    }

    public void a(String str, com.ss.android.downloadad.api.a.b bVar) {
        if (bVar != null && m.b(bVar) && bVar.f21058c.compareAndSet(false, true)) {
            com.ss.android.downloadlib.d.a.a().a(bVar.j(), com.sigmob.sdk.base.common.a.J, a(bVar, str, bVar.K() != 4 ? 3 : 4), bVar);
            com.ss.android.downloadlib.addownload.b.i.a().a(bVar);
        }
    }

    private static DownloadInfo a(List<DownloadInfo> list, String str) {
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null) {
                    if (str.equals(downloadInfo.getPackageName())) {
                        return downloadInfo;
                    }
                    if (m.a(k.a(), downloadInfo.getTargetFilePath(), str)) {
                        return downloadInfo;
                    }
                }
            }
        }
        return null;
    }

    public static JSONObject a(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject != null && downloadInfo != null) {
            int i10 = 1;
            if (DownloadSetting.obtain(downloadInfo.getId()).optInt("download_event_opt", 1) == 0) {
                return jSONObject;
            }
            try {
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_ID, downloadInfo.getId());
                jSONObject.put("name", downloadInfo.getName());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_CUR_BYTES, downloadInfo.getCurBytes());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_TOTAL_BYTES, downloadInfo.getTotalBytes());
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
                double curBytes = downloadInfo.getCurBytes() / 1048576.0d;
                double realDownloadTime = downloadInfo.getRealDownloadTime() / 1000.0d;
                if (curBytes > l5.c.f27899e && realDownloadTime > l5.c.f27899e) {
                    double d10 = curBytes / realDownloadTime;
                    try {
                        jSONObject.put(MonitorConstants.DOWNLOAD_SPEED, d10);
                    } catch (Exception unused) {
                    }
                    Logger.d(f21082a, "download speed : " + d10 + "MB/s");
                }
                try {
                    jSONObject.put("is_download_service_foreground", Downloader.getInstance(k.a()).isDownloadServiceForeground(downloadInfo.getId()) ? 1 : 0);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                if (downloadInfo.getBackUpUrls() != null) {
                    jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_BACKUP_URL_COUNT, downloadInfo.getBackUpUrls().size());
                    jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_CUR_BACKUP_URL_INDEX, downloadInfo.getCurBackUpUrlIndex());
                }
                jSONObject.put("clear_space_restart_times", com.ss.android.downloadlib.addownload.c.d.a().b(downloadInfo.getUrl()));
                jSONObject.put("mime_type", downloadInfo.getMimeType());
                if (!DownloadUtils.isNetworkConnected(k.a())) {
                    i10 = 2;
                }
                jSONObject.put("network_available", i10);
                jSONObject.put(MonitorConstants.STATUS_CODE, downloadInfo.getHttpStatusCode());
                b(jSONObject, downloadInfo);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return jSONObject;
    }

    private static void a(com.ss.android.downloadad.api.a.b bVar) {
        if (bVar == null) {
            return;
        }
        String P = TextUtils.isEmpty(bVar.P()) ? "" : bVar.P();
        DownloadInfo downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(bVar.s());
        bVar.l("");
        com.ss.android.downloadlib.addownload.b.i.a().a(bVar);
        JSONObject a10 = a(new JSONObject(), downloadInfo);
        int i10 = 1;
        try {
            a10.putOpt("finish_reason", P);
            a10.putOpt("finish_from_reserve_wifi", Integer.valueOf(downloadInfo.isDownloadFromReserveWifi() ? 1 : 0));
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        com.ss.android.downloadad.api.a.b a11 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
        com.ss.android.downloadlib.g.f.a(a10, downloadInfo.getId());
        try {
            a10.put("download_failed_times", a11.x());
            a10.put("can_show_notification", com.ss.android.socialbase.appdownloader.e.d.a() ? 1 : 2);
            if (downloadInfo.getExpectFileLength() > 0 && downloadInfo.getTotalBytes() > 0) {
                a10.put("file_length_gap", downloadInfo.getExpectFileLength() - downloadInfo.getTotalBytes());
            }
            a10.put("ttmd5_status", downloadInfo.getTTMd5CheckStatus());
            a10.put("has_send_download_failed_finally", a11.f21059d.get() ? 1 : 2);
            if (!a11.V()) {
                i10 = 2;
            }
            a10.put("is_update_download", i10);
            com.ss.android.downloadlib.g.f.a(a11, a10);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().b(com.sigmob.sdk.base.common.a.H, a10, bVar);
    }

    private int a(com.ss.android.downloadad.api.a.b bVar, DownloadInfo downloadInfo, String str, JSONObject jSONObject) {
        int b10 = com.ss.android.socialbase.appdownloader.c.b(k.a(), downloadInfo);
        int b11 = m.b(k.a(), str);
        if (b10 > 0 && b11 > 0 && b10 != b11) {
            return b11 > b10 ? 3011 : 3010;
        }
        if (DownloadSetting.obtain(bVar.s()).optInt("install_finish_check_ttmd5", 1) != 1) {
            return 3001;
        }
        String string = k.a().getSharedPreferences("sp_ttdownloader_md5", 0).getString(String.valueOf(bVar.b()), null);
        if (TextUtils.isEmpty(string) && downloadInfo != null) {
            string = com.ss.android.downloadlib.g.a.a(downloadInfo.getTargetFilePath());
        }
        int a10 = com.ss.android.downloadlib.g.a.a(string, com.ss.android.downloadlib.g.a.b(str));
        try {
            jSONObject.put("ttmd5_status", a10);
        } catch (Throwable unused) {
        }
        if (a10 == 0) {
            return 3000;
        }
        return a10 == 1 ? 3002 : 3001;
    }

    @Override // com.ss.android.downloadad.api.a
    public void a(int i10) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f21084b < 120000) {
            return;
        }
        d.a().a(new RunnableC0632a(i10), this.f21084b > 0 ? y.f.f18076n : 8000L);
        this.f21084b = currentTimeMillis;
    }

    @WorkerThread
    public void a(@NonNull ConcurrentHashMap<Long, com.ss.android.downloadad.api.a.b> concurrentHashMap, int i10) {
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        for (com.ss.android.downloadad.api.a.b bVar : concurrentHashMap.values()) {
            if (bVar.f21058c.get()) {
                if (currentTimeMillis - bVar.H() >= DownloadSetting.obtain(bVar.s()).optInt("start_event_expire_hours", 168) * 3600000) {
                    arrayList.add(Long.valueOf(bVar.b()));
                }
            } else if (bVar.G() == 1) {
                if (b(bVar) <= 0 && currentTimeMillis - bVar.H() >= DownloadSetting.obtain(bVar.s()).optInt("start_event_expire_hours", 168) * 3600000) {
                    arrayList.add(Long.valueOf(bVar.b()));
                }
            } else if (bVar.G() == 2) {
                if (!bVar.Y()) {
                    if (m.b(bVar)) {
                        if (bVar.K() == 4) {
                            i10 = bVar.K();
                        }
                        bVar.j(false);
                        com.ss.android.downloadlib.d.a.a().a(a(bVar, bVar.e(), i10), bVar);
                        arrayList.add(Long.valueOf(bVar.b()));
                        com.ss.android.downloadlib.addownload.c.d.a(bVar);
                    } else if (bVar.Y() && bVar.K() == 4 && i10 == 1 && !m.b(bVar)) {
                        com.ss.android.downloadlib.g.l.a().a(f21082a, "trySendAndRefreshAdEvent", "命中兜底逻辑,尝试对广播监听执行冷启兜底逻辑");
                        h.a().a(bVar);
                    } else if (currentTimeMillis - bVar.H() >= DownloadSetting.obtain(bVar.s()).optInt("finish_event_expire_hours", 168) * 3600000) {
                        arrayList.add(Long.valueOf(bVar.b()));
                    } else if (TextUtils.isEmpty(bVar.e())) {
                        arrayList.add(Long.valueOf(bVar.b()));
                    }
                }
            } else {
                arrayList.add(Long.valueOf(bVar.b()));
            }
        }
        com.ss.android.downloadlib.addownload.b.f.a().a(arrayList);
    }

    @Override // com.ss.android.socialbase.appdownloader.b.c
    public void a(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.a aVar) {
        JSONObject b10;
        if (downloadInfo == null || aVar == null) {
            return;
        }
        JSONArray optJSONArray = DownloadSetting.obtain(downloadInfo.getId()).optJSONArray("ah_report_config");
        if (aVar.f21741b != 0) {
            downloadInfo.getTempCacheData().remove("intent");
        }
        if (optJSONArray == null || (b10 = b(downloadInfo, aVar)) == null) {
            return;
        }
        downloadInfo.getTempCacheData().put("ah_ext_json", b10);
    }

    private JSONObject a(com.ss.android.downloadad.api.a.b bVar, String str, int i10) {
        com.ss.android.socialbase.appdownloader.a a10;
        JSONObject jSONObject = new JSONObject();
        try {
            DownloadInfo downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(bVar.s());
            jSONObject.putOpt(com.umeng.ccg.a.f24233j, Integer.valueOf(i10));
            com.ss.android.downloadlib.g.f.a(jSONObject, bVar.s());
            com.ss.android.downloadlib.g.f.a(bVar, jSONObject);
            jSONObject.put("is_update_download", bVar.V() ? 1 : 2);
            jSONObject.put("install_after_back_app", bVar.ab() ? 1 : 2);
            jSONObject.putOpt("clean_space_install_params", bVar.R() ? "1" : "2");
            if (downloadInfo != null) {
                a(jSONObject, downloadInfo);
                try {
                    jSONObject.put("uninstall_resume_count", downloadInfo.getUninstallResumeCount());
                    if (bVar.C() > 0) {
                        long currentTimeMillis = System.currentTimeMillis() - bVar.C();
                        jSONObject.put("install_time", currentTimeMillis);
                        if (currentTimeMillis > DownloadSetting.obtain(downloadInfo.getId()).optLong("check_install_finish_expired_duration", 86400000L)) {
                            jSONObject.put("install_expired", 1);
                        } else {
                            jSONObject.put("install_expired", 0);
                        }
                    }
                } catch (Throwable unused) {
                }
                String string = DownloadUtils.getString(downloadInfo.getTempCacheData().get("ah_attempt"), null);
                if (!TextUtils.isEmpty(string) && (a10 = com.ss.android.socialbase.appdownloader.a.a(string)) != null) {
                    a10.a(jSONObject);
                }
            }
            int a11 = a(bVar, downloadInfo, str, jSONObject);
            jSONObject.put("fail_status", a11);
            if (a11 == 3000) {
                jSONObject.put("hijack", 2);
            } else if (a11 == 3001) {
                jSONObject.put("hijack", 0);
            } else {
                jSONObject.put("hijack", 1);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return jSONObject;
    }

    public void a(DownloadInfo downloadInfo, long j10, long j11, long j12, long j13, long j14, boolean z10) {
        com.ss.android.downloadad.api.a.b a10 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
        if (a10 == null) {
            com.ss.android.downloadlib.e.c.a().a("trySendClearSpaceEvent nativeModel null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("space_before", Double.valueOf(j10 / 1048576.0d));
            jSONObject.putOpt("space_cleaned", Double.valueOf((j11 - j10) / 1048576.0d));
            jSONObject.putOpt("clean_up_time_cost", Long.valueOf(j13));
            jSONObject.putOpt("is_download_restarted", Integer.valueOf(z10 ? 1 : 0));
            jSONObject.putOpt("byte_required", Long.valueOf(j12));
            jSONObject.putOpt("byte_required_after", Double.valueOf((j12 - j11) / 1048576.0d));
            jSONObject.putOpt("clear_sleep_time", Long.valueOf(j14));
            com.ss.android.downloadlib.g.f.c(downloadInfo, jSONObject);
            com.ss.android.downloadlib.d.a.a().a("cleanup", jSONObject, a10);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
