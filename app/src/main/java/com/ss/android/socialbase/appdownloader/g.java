package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.appdownloader.i.p;
import com.ss.android.socialbase.appdownloader.i.pa;
import com.ss.android.socialbase.appdownloader.i.r;
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

/* loaded from: classes4.dex */
public class g {
    private static boolean gv = false;

    /* renamed from: j */
    private static final String f24417j = "g";
    private static boolean lg = false;
    private static volatile g zx;
    private IOpenInstallerListener ei;

    /* renamed from: g */
    private String f24418g;

    /* renamed from: i */
    private String f24419i;
    private com.ss.android.socialbase.appdownloader.i.i k;
    private com.ss.android.socialbase.appdownloader.i.lg nt;
    private p p;
    private com.ss.android.socialbase.appdownloader.i.g pa;
    private DownloadReceiver q;
    private com.ss.android.socialbase.appdownloader.i.gv r;
    private IInstallAppHandler s;
    private com.ss.android.socialbase.appdownloader.i.y t;
    private pa w;
    private boolean y = false;

    /* renamed from: com.ss.android.socialbase.appdownloader.g$1 */
    class AnonymousClass1 implements RetryScheduler.RetryScheduleHandler {
        AnonymousClass1() {
        }

        @Override // com.ss.android.socialbase.downloader.impls.RetryScheduler.RetryScheduleHandler
        public void cancelRetry(int i2) {
            RetryJobSchedulerService.j(i2);
        }

        @Override // com.ss.android.socialbase.downloader.impls.RetryScheduler.RetryScheduleHandler
        public void scheduleRetry(DownloadInfo downloadInfo, long j2, boolean z, int i2) {
            RetryJobSchedulerService.j(downloadInfo, j2, z, i2);
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.g$2 */
    class AnonymousClass2 implements IDownloadDepend {
        AnonymousClass2() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadDepend
        public void monitorLogSend(DownloadInfo downloadInfo, BaseException baseException, int i2) {
            if (g.this.t != null) {
                g.this.t.j(downloadInfo, baseException, i2);
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.g$3 */
    class AnonymousClass3 implements r {

        /* renamed from: g */
        final /* synthetic */ boolean f24422g;

        /* renamed from: i */
        final /* synthetic */ int f24423i;

        /* renamed from: j */
        final /* synthetic */ String f24424j;
        final /* synthetic */ DownloadTask zx;

        AnonymousClass3(String str, DownloadTask downloadTask, int i2, boolean z) {
            r2 = str;
            r3 = downloadTask;
            r4 = i2;
            r5 = z;
        }

        @Override // com.ss.android.socialbase.appdownloader.i.r
        public void j() {
            Logger.d(g.f24417j, "notification permission granted, start download :" + r2);
            g.this.j(r3, r4, r5);
        }

        @Override // com.ss.android.socialbase.appdownloader.i.r
        public void zx() {
            Logger.d(g.f24417j, "notification permission denied, start download :" + r2);
            g.this.j(r3, r4, r5);
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.g$4 */
    class AnonymousClass4 implements IDownloadNotificationEventListener {

        /* renamed from: j */
        final /* synthetic */ com.ss.android.socialbase.appdownloader.i.q f24425j;

        AnonymousClass4(com.ss.android.socialbase.appdownloader.i.q qVar) {
            qVar = qVar;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener
        public String getNotifyProcessName() {
            return qVar.j();
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener
        public boolean interceptAfterNotificationSuccess(boolean z) {
            return qVar.j(z);
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener
        public void onNotificationEvent(int i2, DownloadInfo downloadInfo, String str, String str2) {
            if (i2 != 1 && i2 != 3) {
                switch (i2) {
                    case 8:
                        qVar.j(i2, downloadInfo.getPackageName(), str, str2);
                        break;
                    case 9:
                        qVar.j(DownloadComponentManager.getAppContext(), str);
                        break;
                    case 10:
                        qVar.j(downloadInfo);
                        break;
                }
            }
            qVar.j(i2, str, downloadInfo.getStatus(), downloadInfo.getDownloadTime());
        }
    }

    private g() {
    }

    private void e() {
        if (Build.VERSION.SDK_INT >= 21) {
            RetryScheduler.setRetryScheduleHandler(new RetryScheduler.RetryScheduleHandler() { // from class: com.ss.android.socialbase.appdownloader.g.1
                AnonymousClass1() {
                }

                @Override // com.ss.android.socialbase.downloader.impls.RetryScheduler.RetryScheduleHandler
                public void cancelRetry(int i2) {
                    RetryJobSchedulerService.j(i2);
                }

                @Override // com.ss.android.socialbase.downloader.impls.RetryScheduler.RetryScheduleHandler
                public void scheduleRetry(DownloadInfo downloadInfo, long j2, boolean z, int i2) {
                    RetryJobSchedulerService.j(downloadInfo, j2, z, i2);
                }
            });
        }
    }

    private void ei() {
        if (lg) {
            return;
        }
        if (this.q == null) {
            this.q = new DownloadReceiver();
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction("android.intent.action.BOOT_COMPLETED");
            intentFilter.addAction("android.ss.intent.action.DOWNLOAD_COMPLETE");
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter2.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter2.addDataScheme("package");
            IntentFilter intentFilter3 = new IntentFilter();
            intentFilter3.addAction("android.intent.action.MEDIA_MOUNTED");
            intentFilter3.addDataScheme("file");
            DownloadComponentManager.getAppContext().registerReceiver(this.q, intentFilter);
            DownloadComponentManager.getAppContext().registerReceiver(this.q, intentFilter2);
            DownloadComponentManager.getAppContext().registerReceiver(this.q, intentFilter3);
            lg = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static g pa() {
        if (zx == null) {
            synchronized (g.class) {
                if (zx == null) {
                    zx = new g();
                }
            }
        }
        return zx;
    }

    public String g() {
        return this.f24418g;
    }

    public boolean gv() {
        return DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.PACKAGE_FLAG_CONFIG, 1) == 1;
    }

    public com.ss.android.socialbase.appdownloader.i.y i() {
        return this.t;
    }

    public String k() {
        return this.f24419i;
    }

    public pa lg() {
        return this.w;
    }

    public com.ss.android.socialbase.appdownloader.i.lg nt() {
        return this.nt;
    }

    public IReserveWifiStatusListener p() {
        return Downloader.getInstance(DownloadComponentManager.getAppContext()).getReserveWifiStatusListener();
    }

    public com.ss.android.socialbase.appdownloader.i.gv q() {
        return this.r;
    }

    public IInstallAppHandler r() {
        return this.s;
    }

    public p t() {
        return this.p;
    }

    public IOpenInstallerListener w() {
        return this.ei;
    }

    public File y() {
        return Downloader.getInstance(DownloadComponentManager.getAppContext()).getGlobalSaveDir();
    }

    public com.ss.android.socialbase.appdownloader.i.g zx() {
        return this.pa;
    }

    private void i(Context context) {
        if (context == null || gv) {
            return;
        }
        DownloadConstants.setMimeApk(AdBaseConstants.MIME_APK);
        DownloadComponentManager.setAppContext(context);
        DownloadComponentManager.setDownloadLaunchHandler(new com.ss.android.socialbase.appdownloader.g.zx());
        ei();
        e();
        gv = true;
    }

    public void zx(String str) {
        Downloader.getInstance(DownloadComponentManager.getAppContext()).setDefaultSavePath(str);
    }

    private DownloadInfo zx(Context context, String str) {
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

    public com.ss.android.socialbase.appdownloader.i.i j() {
        return this.k;
    }

    public void j(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f24418g = str;
    }

    public void j(pa paVar) {
        this.w = paVar;
    }

    public List<DownloadInfo> zx(Context context) {
        return Downloader.getInstance(context).getDownloadingDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
    }

    @Deprecated
    public void j(Context context, String str, com.ss.android.socialbase.appdownloader.i.i iVar, com.ss.android.socialbase.appdownloader.i.g gVar, com.ss.android.socialbase.appdownloader.i.y yVar) {
        if (iVar != null) {
            this.k = iVar;
        }
        if (gVar != null) {
            this.pa = gVar;
        }
        if (yVar != null) {
            this.t = yVar;
        }
        i(context);
    }

    public static boolean j(Context context, int i2) {
        return i.j(context, i2, true) == 1;
    }

    public void j(Context context, int i2, int i3) {
        try {
            switch (i3) {
                case -4:
                case -1:
                    Downloader.getInstance(context).restart(i2);
                    break;
                case -3:
                    i.j(context, i2, true);
                    break;
                case -2:
                    Downloader.getInstance(context).resume(i2);
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
                    Downloader.getInstance(context).pause(i2);
                    break;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(25:37|(2:41|42)|45|(1:113)(1:52)|53|(2:59|(1:61)(19:62|63|(1:65)|66|(3:68|(2:71|69)|72)|73|74|75|(1:77)(1:110)|78|79|(6:84|(1:107)(1:88)|89|(1:93)|(1:(1:105)(1:104))|106)|108|(1:86)|107|89|(2:91|93)|(0)|106))|112|63|(0)|66|(0)|73|74|75|(0)(0)|78|79|(8:81|84|(0)|107|89|(0)|(0)|106)|108|(0)|107|89|(0)|(0)|106) */
    /* JADX WARN: Removed duplicated region for block: B:110:0x016a A[Catch: all -> 0x0185, TryCatch #1 {all -> 0x0185, blocks: (B:75:0x015e, B:77:0x0164, B:78:0x016f, B:110:0x016a), top: B:74:0x015e }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0137 A[Catch: all -> 0x0388, TryCatch #2 {all -> 0x0388, blocks: (B:7:0x0010, B:11:0x0023, B:14:0x002c, B:16:0x003a, B:17:0x0042, B:19:0x004a, B:20:0x0053, B:23:0x005a, B:25:0x0066, B:28:0x0072, B:30:0x0080, B:31:0x0084, B:33:0x008b, B:37:0x0093, B:39:0x00a7, B:45:0x00c1, B:48:0x00da, B:50:0x00e0, B:53:0x00f1, B:55:0x00f7, B:57:0x00fd, B:59:0x0103, B:61:0x0109, B:62:0x0117, B:63:0x0131, B:65:0x0137, B:66:0x013c, B:68:0x0146, B:69:0x014a, B:71:0x0150, B:73:0x015a, B:79:0x0185, B:81:0x018b, B:86:0x0197, B:88:0x01a4, B:89:0x01b4, B:91:0x0328, B:93:0x0332, B:96:0x033d, B:98:0x0343, B:100:0x0349, B:102:0x0353, B:104:0x0359, B:105:0x0369), top: B:6:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0146 A[Catch: all -> 0x0388, TryCatch #2 {all -> 0x0388, blocks: (B:7:0x0010, B:11:0x0023, B:14:0x002c, B:16:0x003a, B:17:0x0042, B:19:0x004a, B:20:0x0053, B:23:0x005a, B:25:0x0066, B:28:0x0072, B:30:0x0080, B:31:0x0084, B:33:0x008b, B:37:0x0093, B:39:0x00a7, B:45:0x00c1, B:48:0x00da, B:50:0x00e0, B:53:0x00f1, B:55:0x00f7, B:57:0x00fd, B:59:0x0103, B:61:0x0109, B:62:0x0117, B:63:0x0131, B:65:0x0137, B:66:0x013c, B:68:0x0146, B:69:0x014a, B:71:0x0150, B:73:0x015a, B:79:0x0185, B:81:0x018b, B:86:0x0197, B:88:0x01a4, B:89:0x01b4, B:91:0x0328, B:93:0x0332, B:96:0x033d, B:98:0x0343, B:100:0x0349, B:102:0x0353, B:104:0x0359, B:105:0x0369), top: B:6:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0164 A[Catch: all -> 0x0185, TryCatch #1 {all -> 0x0185, blocks: (B:75:0x015e, B:77:0x0164, B:78:0x016f, B:110:0x016a), top: B:74:0x015e }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0197 A[Catch: all -> 0x0388, TryCatch #2 {all -> 0x0388, blocks: (B:7:0x0010, B:11:0x0023, B:14:0x002c, B:16:0x003a, B:17:0x0042, B:19:0x004a, B:20:0x0053, B:23:0x005a, B:25:0x0066, B:28:0x0072, B:30:0x0080, B:31:0x0084, B:33:0x008b, B:37:0x0093, B:39:0x00a7, B:45:0x00c1, B:48:0x00da, B:50:0x00e0, B:53:0x00f1, B:55:0x00f7, B:57:0x00fd, B:59:0x0103, B:61:0x0109, B:62:0x0117, B:63:0x0131, B:65:0x0137, B:66:0x013c, B:68:0x0146, B:69:0x014a, B:71:0x0150, B:73:0x015a, B:79:0x0185, B:81:0x018b, B:86:0x0197, B:88:0x01a4, B:89:0x01b4, B:91:0x0328, B:93:0x0332, B:96:0x033d, B:98:0x0343, B:100:0x0349, B:102:0x0353, B:104:0x0359, B:105:0x0369), top: B:6:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0328 A[Catch: all -> 0x0388, TryCatch #2 {all -> 0x0388, blocks: (B:7:0x0010, B:11:0x0023, B:14:0x002c, B:16:0x003a, B:17:0x0042, B:19:0x004a, B:20:0x0053, B:23:0x005a, B:25:0x0066, B:28:0x0072, B:30:0x0080, B:31:0x0084, B:33:0x008b, B:37:0x0093, B:39:0x00a7, B:45:0x00c1, B:48:0x00da, B:50:0x00e0, B:53:0x00f1, B:55:0x00f7, B:57:0x00fd, B:59:0x0103, B:61:0x0109, B:62:0x0117, B:63:0x0131, B:65:0x0137, B:66:0x013c, B:68:0x0146, B:69:0x014a, B:71:0x0150, B:73:0x015a, B:79:0x0185, B:81:0x018b, B:86:0x0197, B:88:0x01a4, B:89:0x01b4, B:91:0x0328, B:93:0x0332, B:96:0x033d, B:98:0x0343, B:100:0x0349, B:102:0x0353, B:104:0x0359, B:105:0x0369), top: B:6:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x033b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int j(com.ss.android.socialbase.appdownloader.gv r23) {
        /*
            Method dump skipped, instructions count: 946
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.g.j(com.ss.android.socialbase.appdownloader.gv):int");
    }

    public void j(DownloadTask downloadTask, int i2, boolean z) {
        if (downloadTask == null) {
            return;
        }
        downloadTask.download();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            downloadInfo.setAntiHijackErrorCode(i2);
        }
        if (downloadInfo == null || !z) {
            return;
        }
        downloadInfo.setSavePathRedirected(z);
    }

    private List<HttpHeader> j(List<HttpHeader> list) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        if (list != null && list.size() > 0) {
            for (HttpHeader httpHeader : list) {
                if (httpHeader != null && !TextUtils.isEmpty(httpHeader.getName()) && !TextUtils.isEmpty(httpHeader.getValue())) {
                    if (httpHeader.getName().equals("User-Agent")) {
                        z = true;
                    }
                    arrayList.add(new HttpHeader(httpHeader.getName(), httpHeader.getValue()));
                }
            }
        }
        if (!z) {
            arrayList.add(new HttpHeader("User-Agent", com.ss.android.socialbase.appdownloader.zx.j.f24527j));
        }
        return arrayList;
    }

    public String j(String str, String str2) {
        return (TextUtils.isEmpty(str) || !str.endsWith(".apk") || i.i(str2)) ? str2 : AdBaseConstants.MIME_APK;
    }

    private IDownloadNotificationEventListener j(com.ss.android.socialbase.appdownloader.i.q qVar) {
        if (qVar == null) {
            return null;
        }
        return new IDownloadNotificationEventListener() { // from class: com.ss.android.socialbase.appdownloader.g.4

            /* renamed from: j */
            final /* synthetic */ com.ss.android.socialbase.appdownloader.i.q f24425j;

            AnonymousClass4(com.ss.android.socialbase.appdownloader.i.q qVar2) {
                qVar = qVar2;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener
            public String getNotifyProcessName() {
                return qVar.j();
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener
            public boolean interceptAfterNotificationSuccess(boolean z) {
                return qVar.j(z);
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener
            public void onNotificationEvent(int i2, DownloadInfo downloadInfo, String str, String str2) {
                if (i2 != 1 && i2 != 3) {
                    switch (i2) {
                        case 8:
                            qVar.j(i2, downloadInfo.getPackageName(), str, str2);
                            break;
                        case 9:
                            qVar.j(DownloadComponentManager.getAppContext(), str);
                            break;
                        case 10:
                            qVar.j(downloadInfo);
                            break;
                    }
                }
                qVar.j(i2, str, downloadInfo.getStatus(), downloadInfo.getDownloadTime());
            }
        };
    }

    public DownloadInfo j(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                DownloadInfo j2 = j(context, str, y());
                if (j2 == null) {
                    j2 = j(context, str, context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS));
                }
                if (j2 == null) {
                    j2 = j(context, str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
                }
                if (j2 == null) {
                    j2 = j(context, str, context.getFilesDir());
                }
                return (j2 == null && DownloadSetting.obtainGlobal().optBugFix(DownloadSettingKeys.BugFix.BUGFIX_GET_DOWNLOAD_INFO_BY_LIST)) ? zx(context, str) : j2;
            } catch (Throwable th) {
                Logger.d(f24417j, String.format("getAppDownloadInfo error:%s", th.getMessage()));
            }
        }
        return null;
    }

    private DownloadInfo j(Context context, String str, File file) {
        if (context == null || TextUtils.isEmpty(str) || file == null) {
            return null;
        }
        return Downloader.getInstance(context).getDownloadInfo(str, file.getAbsolutePath());
    }

    public List<DownloadInfo> j(Context context) {
        return Downloader.getInstance(context).getUnCompletedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
    }

    public void j(com.ss.android.socialbase.appdownloader.i.lg lgVar) {
        this.nt = lgVar;
    }

    public void j(IReserveWifiStatusListener iReserveWifiStatusListener) {
        Downloader.getInstance(DownloadComponentManager.getAppContext()).setReserveWifiStatusListener(iReserveWifiStatusListener);
    }

    public void j(IInstallAppHandler iInstallAppHandler) {
        this.s = iInstallAppHandler;
    }

    public void j(IOpenInstallerListener iOpenInstallerListener) {
        this.ei = iOpenInstallerListener;
    }
}
