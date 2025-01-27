package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Environment;
import android.text.TextUtils;
import com.sigmob.sdk.base.k;
import com.ss.android.socialbase.appdownloader.c.j;
import com.ss.android.socialbase.appdownloader.c.m;
import com.ss.android.socialbase.appdownloader.c.n;
import com.ss.android.socialbase.appdownloader.c.o;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.IInstallAppHandler;
import com.ss.android.socialbase.downloader.depend.IOpenInstallerListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.RetryScheduler;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    private static final String f21781a = "d";

    /* renamed from: b */
    private static volatile d f21782b = null;

    /* renamed from: f */
    private static boolean f21783f = false;

    /* renamed from: g */
    private static boolean f21784g = false;

    /* renamed from: h */
    private static boolean f21785h = false;

    /* renamed from: c */
    private String f21786c;

    /* renamed from: d */
    private String f21787d;

    /* renamed from: i */
    private Future f21789i;

    /* renamed from: j */
    private int f21790j;

    /* renamed from: m */
    private com.ss.android.socialbase.appdownloader.c.c f21793m;

    /* renamed from: n */
    private com.ss.android.socialbase.appdownloader.c.d f21794n;

    /* renamed from: o */
    private com.ss.android.socialbase.appdownloader.c.h f21795o;

    /* renamed from: p */
    private com.ss.android.socialbase.appdownloader.c.g f21796p;

    /* renamed from: q */
    private m f21797q;

    /* renamed from: r */
    private com.ss.android.socialbase.appdownloader.c.f f21798r;

    /* renamed from: s */
    private j f21799s;

    /* renamed from: t */
    private IInstallAppHandler f21800t;

    /* renamed from: u */
    private IOpenInstallerListener f21801u;

    /* renamed from: v */
    private o f21802v;

    /* renamed from: e */
    private DownloadReceiver f21788e = new DownloadReceiver();

    /* renamed from: k */
    private boolean f21791k = false;

    /* renamed from: l */
    private boolean f21792l = false;

    /* renamed from: com.ss.android.socialbase.appdownloader.d$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.s();
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.d$2 */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger.d(d.f21781a, "registerDownloadReceiver tryUnRegisterTempAppInstallDownloadReceiver run inner");
            d.this.l();
            d.this.s();
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.d$3 */
    public class AnonymousClass3 implements RetryScheduler.RetryScheduleHandler {
        public AnonymousClass3() {
        }

        @Override // com.ss.android.socialbase.downloader.impls.RetryScheduler.RetryScheduleHandler
        public void cancelRetry(int i10) {
            RetryJobSchedulerService.a(i10);
        }

        @Override // com.ss.android.socialbase.downloader.impls.RetryScheduler.RetryScheduleHandler
        public void scheduleRetry(DownloadInfo downloadInfo, long j10, boolean z10, int i10) {
            RetryJobSchedulerService.a(downloadInfo, j10, z10, i10);
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.d$4 */
    public class AnonymousClass4 implements IDownloadDepend {
        public AnonymousClass4() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadDepend
        public void monitorLogSend(DownloadInfo downloadInfo, BaseException baseException, int i10) {
            if (d.this.f21795o != null) {
                d.this.f21795o.a(downloadInfo, baseException, i10);
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.d$5 */
    public class AnonymousClass5 implements n {

        /* renamed from: a */
        final /* synthetic */ String f21807a;

        /* renamed from: b */
        final /* synthetic */ DownloadTask f21808b;

        /* renamed from: c */
        final /* synthetic */ int f21809c;

        /* renamed from: d */
        final /* synthetic */ boolean f21810d;

        public AnonymousClass5(String str, DownloadTask downloadTask, int i10, boolean z10) {
            r2 = str;
            r3 = downloadTask;
            r4 = i10;
            r5 = z10;
        }

        @Override // com.ss.android.socialbase.appdownloader.c.n
        public void a() {
            Logger.d(d.f21781a, "notification permission granted, start download :" + r2);
            d.this.a(r3, r4, r5);
        }

        @Override // com.ss.android.socialbase.appdownloader.c.n
        public void b() {
            Logger.d(d.f21781a, "notification permission denied, start download :" + r2);
            d.this.a(r3, r4, r5);
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.d$6 */
    public class AnonymousClass6 implements IDownloadNotificationEventListener {

        /* renamed from: a */
        final /* synthetic */ com.ss.android.socialbase.appdownloader.c.e f21812a;

        public AnonymousClass6(com.ss.android.socialbase.appdownloader.c.e eVar) {
            eVar = eVar;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener
        public String getNotifyProcessName() {
            return eVar.a();
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener
        public boolean interceptAfterNotificationSuccess(boolean z10) {
            return eVar.a(z10);
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener
        public void onNotificationEvent(int i10, DownloadInfo downloadInfo, String str, String str2) {
            if (i10 != 1 && i10 != 3) {
                switch (i10) {
                    case 8:
                        eVar.a(i10, downloadInfo.getPackageName(), str, str2);
                        break;
                    case 9:
                        eVar.a(DownloadComponentManager.getAppContext(), str);
                        break;
                    case 10:
                        eVar.a(downloadInfo);
                        break;
                }
            }
            eVar.a(i10, str, downloadInfo.getStatus(), downloadInfo.getDownloadTime());
        }
    }

    private d() {
    }

    public static d j() {
        if (f21782b == null) {
            synchronized (d.class) {
                try {
                    if (f21782b == null) {
                        f21782b = new d();
                    }
                } finally {
                }
            }
        }
        return f21782b;
    }

    public void s() {
        synchronized (this.f21788e) {
            if (f21784g) {
                return;
            }
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                intentFilter.addAction("android.ss.intent.action.DOWNLOAD_COMPLETE");
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.MEDIA_MOUNTED");
                intentFilter2.addDataScheme(k.f18193y);
                DownloadComponentManager.getAppContext().registerReceiver(this.f21788e, intentFilter);
                DownloadComponentManager.getAppContext().registerReceiver(this.f21788e, intentFilter2);
                f21784g = true;
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            Logger.d(f21781a, "registerDownloadReceiver mIsRegistered:" + f21784g);
        }
    }

    private void t() {
        RetryScheduler.setRetryScheduleHandler(new RetryScheduler.RetryScheduleHandler() { // from class: com.ss.android.socialbase.appdownloader.d.3
            public AnonymousClass3() {
            }

            @Override // com.ss.android.socialbase.downloader.impls.RetryScheduler.RetryScheduleHandler
            public void cancelRetry(int i10) {
                RetryJobSchedulerService.a(i10);
            }

            @Override // com.ss.android.socialbase.downloader.impls.RetryScheduler.RetryScheduleHandler
            public void scheduleRetry(DownloadInfo downloadInfo, long j10, boolean z10, int i10) {
                RetryJobSchedulerService.a(downloadInfo, j10, z10, i10);
            }
        });
    }

    public com.ss.android.socialbase.appdownloader.c.h c() {
        return this.f21795o;
    }

    public String d() {
        return this.f21787d;
    }

    public com.ss.android.socialbase.appdownloader.c.f e() {
        return this.f21798r;
    }

    public boolean f() {
        return DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.PACKAGE_FLAG_CONFIG, 1) == 1;
    }

    public j g() {
        return this.f21799s;
    }

    public File h() {
        return Downloader.getInstance(DownloadComponentManager.getAppContext()).getGlobalSaveDir();
    }

    public String i() {
        return this.f21786c;
    }

    public void k() {
        if (DownloadSetting.obtainGlobal().optInt("enable_app_install_receiver", 1) <= 0) {
            Logger.d(f21781a, "disable app install receiver");
            return;
        }
        synchronized (this.f21788e) {
            try {
                if (f21785h) {
                    return;
                }
                try {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                    intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
                    intentFilter.addDataScheme("package");
                    DownloadComponentManager.getAppContext().registerReceiver(this.f21788e, intentFilter);
                    f21785h = true;
                    o oVar = this.f21802v;
                    if (oVar != null) {
                        oVar.a();
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                Logger.d(f21781a, "tryRegisterTempAppInstallDownloadReceiver mIsAppInstallRegistered:" + f21784g);
            } finally {
                b(0);
            }
        }
    }

    public void l() {
        o oVar;
        synchronized (this.f21788e) {
            try {
                if (f21784g) {
                    DownloadComponentManager.getAppContext().unregisterReceiver(this.f21788e);
                    if (f21785h && (oVar = this.f21802v) != null) {
                        oVar.b();
                    }
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            f21784g = false;
            f21785h = false;
        }
        Logger.d(f21781a, "registerDownloadReceiver unRegisterDownloadReceiver");
    }

    public m m() {
        return this.f21797q;
    }

    public com.ss.android.socialbase.appdownloader.c.g n() {
        return this.f21796p;
    }

    public IReserveWifiStatusListener o() {
        return Downloader.getInstance(DownloadComponentManager.getAppContext()).getReserveWifiStatusListener();
    }

    public IInstallAppHandler p() {
        return this.f21800t;
    }

    public IOpenInstallerListener q() {
        return this.f21801u;
    }

    private void c(Context context) {
        if (context == null || f21783f) {
            return;
        }
        DownloadConstants.setMimeApk("application/vnd.android.package-archive");
        DownloadComponentManager.setAppContext(context);
        DownloadComponentManager.setDownloadLaunchHandler(new com.ss.android.socialbase.appdownloader.d.b());
        if (this.f21792l) {
            DownloadComponentManager.submitScheduleTask(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.d.1
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    d.this.s();
                }
            }, 5L, TimeUnit.SECONDS);
        } else {
            s();
        }
        t();
        f21783f = true;
    }

    public com.ss.android.socialbase.appdownloader.c.d b() {
        return this.f21794n;
    }

    public com.ss.android.socialbase.appdownloader.c.c a() {
        return this.f21793m;
    }

    public void b(String str) {
        Downloader.getInstance(DownloadComponentManager.getAppContext()).setDefaultSavePath(str);
    }

    private void b(int i10) {
        this.f21790j = DownloadSetting.obtainGlobal().optInt("app_install_keep_receiver_time_s", 60);
        Logger.d(f21781a, "tryUnRegisterTempAppInstallDownloadReceiver mAppInstallReceiverKeepTime:" + this.f21790j);
        if (this.f21790j <= 0) {
            return;
        }
        if (i10 > 0) {
            this.f21790j = i10;
        }
        Future future = this.f21789i;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        this.f21789i = DownloadComponentManager.submitScheduleTask(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.d.2
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Logger.d(d.f21781a, "registerDownloadReceiver tryUnRegisterTempAppInstallDownloadReceiver run inner");
                d.this.l();
                d.this.s();
            }
        }, this.f21790j, TimeUnit.SECONDS);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f21787d = str;
    }

    public void a(j jVar) {
        this.f21799s = jVar;
    }

    @Deprecated
    public void a(Context context, String str, com.ss.android.socialbase.appdownloader.c.c cVar, com.ss.android.socialbase.appdownloader.c.d dVar, com.ss.android.socialbase.appdownloader.c.h hVar) {
        if (cVar != null) {
            this.f21793m = cVar;
        }
        if (dVar != null) {
            this.f21794n = dVar;
        }
        if (hVar != null) {
            this.f21795o = hVar;
        }
        c(context);
    }

    public static boolean a(Context context, int i10) {
        return c.a(context, i10, true) == 1;
    }

    private DownloadInfo b(Context context, String str) {
        List<DownloadInfo> downloadInfoList = Downloader.getInstance(context).getDownloadInfoList(str);
        if (downloadInfoList == null) {
            return null;
        }
        for (DownloadInfo downloadInfo : downloadInfoList) {
            if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                return downloadInfo;
            }
        }
        return null;
    }

    public void a(Context context, int i10, int i11) {
        try {
            switch (i11) {
                case -4:
                case -1:
                    Downloader.getInstance(context).restart(i10);
                    break;
                case -3:
                    c.a(context, i10, true);
                    break;
                case -2:
                    Downloader.getInstance(context).resume(i10);
                    break;
                case 0:
                case 6:
                default:
                    return;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                    Downloader.getInstance(context).pause(i10);
                    break;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public List<DownloadInfo> b(Context context) {
        return Downloader.getInstance(context).getDownloadingDownloadInfosWithMimeType("application/vnd.android.package-archive");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(27:34|(1:36)|37|(2:41|42)|45|(1:113)(1:52)|53|(2:59|(1:61)(19:62|63|(1:65)|66|(3:68|(2:71|69)|72)|73|74|75|(1:77)(1:110)|78|79|(6:84|(1:107)(1:88)|89|(1:93)|(1:(1:105)(1:104))|106)|108|(1:86)|107|89|(2:91|93)|(0)|106))|112|63|(0)|66|(0)|73|74|75|(0)(0)|78|79|(8:81|84|(0)|107|89|(0)|(0)|106)|108|(0)|107|89|(0)|(0)|106) */
    /* JADX WARN: Removed duplicated region for block: B:110:0x017c A[Catch: all -> 0x0197, TryCatch #2 {all -> 0x0197, blocks: (B:75:0x0170, B:77:0x0176, B:78:0x0181, B:110:0x017c), top: B:74:0x0170 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0149 A[Catch: all -> 0x0044, TryCatch #1 {all -> 0x0044, blocks: (B:6:0x0011, B:10:0x0024, B:13:0x002d, B:15:0x003b, B:16:0x0047, B:18:0x004f, B:19:0x0058, B:22:0x005f, B:24:0x006b, B:27:0x0077, B:29:0x0085, B:30:0x0089, B:32:0x0090, B:34:0x0099, B:37:0x00a4, B:39:0x00b8, B:45:0x00d2, B:48:0x00eb, B:50:0x00f1, B:53:0x0102, B:55:0x0108, B:57:0x010e, B:59:0x0114, B:61:0x011a, B:62:0x0129, B:63:0x0143, B:65:0x0149, B:66:0x014e, B:68:0x0158, B:69:0x015c, B:71:0x0162, B:73:0x016c, B:79:0x0197, B:81:0x019d, B:86:0x01a9, B:88:0x01b6, B:89:0x01c6, B:91:0x0342, B:93:0x034c, B:96:0x0357, B:98:0x035d, B:100:0x0363, B:102:0x036d, B:104:0x0373, B:105:0x0383), top: B:5:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0158 A[Catch: all -> 0x0044, TryCatch #1 {all -> 0x0044, blocks: (B:6:0x0011, B:10:0x0024, B:13:0x002d, B:15:0x003b, B:16:0x0047, B:18:0x004f, B:19:0x0058, B:22:0x005f, B:24:0x006b, B:27:0x0077, B:29:0x0085, B:30:0x0089, B:32:0x0090, B:34:0x0099, B:37:0x00a4, B:39:0x00b8, B:45:0x00d2, B:48:0x00eb, B:50:0x00f1, B:53:0x0102, B:55:0x0108, B:57:0x010e, B:59:0x0114, B:61:0x011a, B:62:0x0129, B:63:0x0143, B:65:0x0149, B:66:0x014e, B:68:0x0158, B:69:0x015c, B:71:0x0162, B:73:0x016c, B:79:0x0197, B:81:0x019d, B:86:0x01a9, B:88:0x01b6, B:89:0x01c6, B:91:0x0342, B:93:0x034c, B:96:0x0357, B:98:0x035d, B:100:0x0363, B:102:0x036d, B:104:0x0373, B:105:0x0383), top: B:5:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0176 A[Catch: all -> 0x0197, TryCatch #2 {all -> 0x0197, blocks: (B:75:0x0170, B:77:0x0176, B:78:0x0181, B:110:0x017c), top: B:74:0x0170 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01a9 A[Catch: all -> 0x0044, TryCatch #1 {all -> 0x0044, blocks: (B:6:0x0011, B:10:0x0024, B:13:0x002d, B:15:0x003b, B:16:0x0047, B:18:0x004f, B:19:0x0058, B:22:0x005f, B:24:0x006b, B:27:0x0077, B:29:0x0085, B:30:0x0089, B:32:0x0090, B:34:0x0099, B:37:0x00a4, B:39:0x00b8, B:45:0x00d2, B:48:0x00eb, B:50:0x00f1, B:53:0x0102, B:55:0x0108, B:57:0x010e, B:59:0x0114, B:61:0x011a, B:62:0x0129, B:63:0x0143, B:65:0x0149, B:66:0x014e, B:68:0x0158, B:69:0x015c, B:71:0x0162, B:73:0x016c, B:79:0x0197, B:81:0x019d, B:86:0x01a9, B:88:0x01b6, B:89:0x01c6, B:91:0x0342, B:93:0x034c, B:96:0x0357, B:98:0x035d, B:100:0x0363, B:102:0x036d, B:104:0x0373, B:105:0x0383), top: B:5:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0342 A[Catch: all -> 0x0044, TryCatch #1 {all -> 0x0044, blocks: (B:6:0x0011, B:10:0x0024, B:13:0x002d, B:15:0x003b, B:16:0x0047, B:18:0x004f, B:19:0x0058, B:22:0x005f, B:24:0x006b, B:27:0x0077, B:29:0x0085, B:30:0x0089, B:32:0x0090, B:34:0x0099, B:37:0x00a4, B:39:0x00b8, B:45:0x00d2, B:48:0x00eb, B:50:0x00f1, B:53:0x0102, B:55:0x0108, B:57:0x010e, B:59:0x0114, B:61:0x011a, B:62:0x0129, B:63:0x0143, B:65:0x0149, B:66:0x014e, B:68:0x0158, B:69:0x015c, B:71:0x0162, B:73:0x016c, B:79:0x0197, B:81:0x019d, B:86:0x01a9, B:88:0x01b6, B:89:0x01c6, B:91:0x0342, B:93:0x034c, B:96:0x0357, B:98:0x035d, B:100:0x0363, B:102:0x036d, B:104:0x0373, B:105:0x0383), top: B:5:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0355  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int a(com.ss.android.socialbase.appdownloader.f r22) {
        /*
            Method dump skipped, instructions count: 968
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.d.a(com.ss.android.socialbase.appdownloader.f):int");
    }

    public void a(DownloadTask downloadTask, int i10, boolean z10) {
        if (downloadTask == null) {
            return;
        }
        downloadTask.download();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            downloadInfo.setAntiHijackErrorCode(i10);
        }
        if (downloadInfo == null || !z10) {
            return;
        }
        downloadInfo.setSavePathRedirected(z10);
    }

    private List<HttpHeader> a(List<HttpHeader> list) {
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        if (list != null && list.size() > 0) {
            for (HttpHeader httpHeader : list) {
                if (httpHeader != null && !TextUtils.isEmpty(httpHeader.getName()) && !TextUtils.isEmpty(httpHeader.getValue())) {
                    if (httpHeader.getName().equals("User-Agent")) {
                        z10 = true;
                    }
                    arrayList.add(new HttpHeader(httpHeader.getName(), httpHeader.getValue()));
                }
            }
        }
        if (!z10) {
            arrayList.add(new HttpHeader("User-Agent", com.ss.android.socialbase.appdownloader.b.a.f21757a));
        }
        return arrayList;
    }

    public String a(String str, String str2) {
        return (TextUtils.isEmpty(str) || !str.endsWith(".apk") || c.c(str2)) ? str2 : "application/vnd.android.package-archive";
    }

    private IDownloadNotificationEventListener a(com.ss.android.socialbase.appdownloader.c.e eVar) {
        if (eVar == null) {
            return null;
        }
        return new IDownloadNotificationEventListener() { // from class: com.ss.android.socialbase.appdownloader.d.6

            /* renamed from: a */
            final /* synthetic */ com.ss.android.socialbase.appdownloader.c.e f21812a;

            public AnonymousClass6(com.ss.android.socialbase.appdownloader.c.e eVar2) {
                eVar = eVar2;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener
            public String getNotifyProcessName() {
                return eVar.a();
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener
            public boolean interceptAfterNotificationSuccess(boolean z10) {
                return eVar.a(z10);
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener
            public void onNotificationEvent(int i10, DownloadInfo downloadInfo, String str, String str2) {
                if (i10 != 1 && i10 != 3) {
                    switch (i10) {
                        case 8:
                            eVar.a(i10, downloadInfo.getPackageName(), str, str2);
                            break;
                        case 9:
                            eVar.a(DownloadComponentManager.getAppContext(), str);
                            break;
                        case 10:
                            eVar.a(downloadInfo);
                            break;
                    }
                }
                eVar.a(i10, str, downloadInfo.getStatus(), downloadInfo.getDownloadTime());
            }
        };
    }

    public DownloadInfo a(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                DownloadInfo a10 = a(context, str, h());
                if (a10 == null) {
                    a10 = a(context, str, context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS));
                }
                if (a10 == null) {
                    a10 = a(context, str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
                }
                if (a10 == null) {
                    a10 = a(context, str, context.getFilesDir());
                }
                return (a10 == null && DownloadSetting.obtainGlobal().optBugFix(DownloadSettingKeys.BugFix.BUGFIX_GET_DOWNLOAD_INFO_BY_LIST)) ? b(context, str) : a10;
            } catch (Throwable th2) {
                Logger.d(f21781a, String.format("getAppDownloadInfo error:%s", th2.getMessage()));
            }
        }
        return null;
    }

    private DownloadInfo a(Context context, String str, File file) {
        if (context == null || TextUtils.isEmpty(str) || file == null) {
            return null;
        }
        return Downloader.getInstance(context).getDownloadInfo(str, file.getAbsolutePath());
    }

    public List<DownloadInfo> a(Context context) {
        return Downloader.getInstance(context).getUnCompletedDownloadInfosWithMimeType("application/vnd.android.package-archive");
    }

    public void a(com.ss.android.socialbase.appdownloader.c.g gVar) {
        this.f21796p = gVar;
    }

    public void a(IReserveWifiStatusListener iReserveWifiStatusListener) {
        Downloader.getInstance(DownloadComponentManager.getAppContext()).setReserveWifiStatusListener(iReserveWifiStatusListener);
    }

    public void a(IInstallAppHandler iInstallAppHandler) {
        this.f21800t = iInstallAppHandler;
    }

    public void a(IOpenInstallerListener iOpenInstallerListener) {
        this.f21801u = iOpenInstallerListener;
    }

    public void a(int i10) {
        if (DownloadSetting.obtainGlobal().optInt("enable_app_install_receiver", 1) <= 0) {
            return;
        }
        k();
        b(i10);
    }

    public void a(o oVar) {
        this.f21802v = oVar;
    }

    public void a(boolean z10) {
        this.f21792l = z10;
    }
}
