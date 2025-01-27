package cn.vlion.ad.inland.ad.utils.apkdownload;

import android.content.Context;
import android.text.TextUtils;
import cn.vlion.ad.inland.ad.javabean.VlionCustomAdData;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.base.c5;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.javabean.VlionNetRespType;
import cn.vlion.ad.inland.base.network.ok.HttpRequestUtil;
import cn.vlion.ad.inland.base.t0;
import cn.vlion.ad.inland.base.util.VlionHandlerUtils;
import cn.vlion.ad.inland.base.util.device.VlionDeviceInfo;
import cn.vlion.ad.inland.base.util.event.VlionADEventDownParam;
import cn.vlion.ad.inland.base.util.event.VlionADEventManager;
import cn.vlion.ad.inland.base.util.handle.VlionBaseParameterReplace;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.base.y4;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class DownloadApkData implements Serializable {
    private VlionBaseParameterReplace apkDownloadParameterReplace;
    private String downloadApkName;
    private String filename;
    private String packageName;
    private ScheduledThreadPoolExecutor scheduledFuture;
    private String urlHeader;
    private String urlactiveHeader;
    private String urldownloadStartHeader;
    private VlionADEventDownParam vlionADEventDownParam;
    private VlionAdapterADConfig vlionAdapterADConfig;
    private y4 vlionDownloadProgressListener;
    private ArrayList<String> downloadStartUrl = new ArrayList<>();
    private ArrayList<String> downloadCompleteUrl = new ArrayList<>();
    private ArrayList<String> installStartUrl = new ArrayList<>();
    private ArrayList<String> installCompleteUrl = new ArrayList<>();
    private ArrayList<String> activeCompleteUrl = new ArrayList<>();
    private long downloadId = 0;
    private boolean isDownComplete = false;
    private boolean isInstallDownComplete = false;
    private int percentProgress = -1;
    private boolean isAdClosed = false;

    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Context f2380a;

        /* renamed from: b */
        public final /* synthetic */ y4 f2381b;

        /* renamed from: cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData$a$a */
        public class C0022a implements y4 {
            public C0022a() {
            }

            @Override // cn.vlion.ad.inland.base.y4
            public final void a() {
                y4 y4Var = a.this.f2381b;
                if (y4Var != null) {
                    y4Var.a();
                }
            }

            @Override // cn.vlion.ad.inland.base.y4
            public final void b() {
                y4 y4Var = a.this.f2381b;
                if (y4Var != null) {
                    y4Var.b();
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0091 A[Catch: all -> 0x0046, TRY_LEAVE, TryCatch #0 {all -> 0x0046, blocks: (B:2:0x0000, B:4:0x002e, B:6:0x0039, B:7:0x0043, B:8:0x0084, B:9:0x008b, B:11:0x0091, B:18:0x004c, B:21:0x005b, B:24:0x006a, B:27:0x0079), top: B:1:0x0000 }] */
            /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
            @Override // cn.vlion.ad.inland.base.y4
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void onDownloadApkProgress(int r3) {
                /*
                    r2 = this;
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L46
                    r0.<init>()     // Catch: java.lang.Throwable -> L46
                    java.lang.String r1 = "DownloadApkData  onDownloadApkProgress percentProgress="
                    r0.append(r1)     // Catch: java.lang.Throwable -> L46
                    cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData$a r1 = cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData.a.this     // Catch: java.lang.Throwable -> L46
                    cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData r1 = cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData.this     // Catch: java.lang.Throwable -> L46
                    int r1 = cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData.access$100(r1)     // Catch: java.lang.Throwable -> L46
                    r0.append(r1)     // Catch: java.lang.Throwable -> L46
                    java.lang.String r1 = " percent"
                    r0.append(r1)     // Catch: java.lang.Throwable -> L46
                    r0.append(r3)     // Catch: java.lang.Throwable -> L46
                    java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L46
                    cn.vlion.ad.inland.base.util.log.LogVlion.e(r0)     // Catch: java.lang.Throwable -> L46
                    cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData$a r0 = cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData.a.this     // Catch: java.lang.Throwable -> L46
                    cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData r0 = cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData.this     // Catch: java.lang.Throwable -> L46
                    int r0 = cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData.access$100(r0)     // Catch: java.lang.Throwable -> L46
                    if (r0 >= r3) goto L9c
                    cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData$a r0 = cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData.a.this     // Catch: java.lang.Throwable -> L46
                    cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData r0 = cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData.this     // Catch: java.lang.Throwable -> L46
                    cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData.access$102(r0, r3)     // Catch: java.lang.Throwable -> L46
                    r0 = 100
                    if (r3 < r0) goto L48
                    cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData$a r0 = cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData.a.this     // Catch: java.lang.Throwable -> L46
                    cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData r0 = cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData.this     // Catch: java.lang.Throwable -> L46
                    cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig r0 = cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData.access$200(r0)     // Catch: java.lang.Throwable -> L46
                    cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData$a r1 = cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData.a.this     // Catch: java.lang.Throwable -> L46
                L43:
                    cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData r1 = cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData.this     // Catch: java.lang.Throwable -> L46
                    goto L84
                L46:
                    r3 = move-exception
                    goto L95
                L48:
                    r0 = 80
                    if (r3 < r0) goto L57
                    cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData$a r0 = cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData.a.this     // Catch: java.lang.Throwable -> L46
                    cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData r0 = cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData.this     // Catch: java.lang.Throwable -> L46
                    cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig r0 = cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData.access$200(r0)     // Catch: java.lang.Throwable -> L46
                    cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData$a r1 = cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData.a.this     // Catch: java.lang.Throwable -> L46
                    goto L43
                L57:
                    r0 = 60
                    if (r3 < r0) goto L66
                    cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData$a r0 = cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData.a.this     // Catch: java.lang.Throwable -> L46
                    cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData r0 = cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData.this     // Catch: java.lang.Throwable -> L46
                    cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig r0 = cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData.access$200(r0)     // Catch: java.lang.Throwable -> L46
                    cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData$a r1 = cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData.a.this     // Catch: java.lang.Throwable -> L46
                    goto L43
                L66:
                    r0 = 40
                    if (r3 < r0) goto L75
                    cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData$a r0 = cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData.a.this     // Catch: java.lang.Throwable -> L46
                    cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData r0 = cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData.this     // Catch: java.lang.Throwable -> L46
                    cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig r0 = cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData.access$200(r0)     // Catch: java.lang.Throwable -> L46
                    cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData$a r1 = cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData.a.this     // Catch: java.lang.Throwable -> L46
                    goto L43
                L75:
                    r0 = 20
                    if (r3 < r0) goto L8b
                    cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData$a r0 = cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData.a.this     // Catch: java.lang.Throwable -> L46
                    cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData r0 = cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData.this     // Catch: java.lang.Throwable -> L46
                    cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig r0 = cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData.access$200(r0)     // Catch: java.lang.Throwable -> L46
                    cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData$a r1 = cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData.a.this     // Catch: java.lang.Throwable -> L46
                    goto L43
                L84:
                    cn.vlion.ad.inland.base.util.event.VlionADEventDownParam r1 = cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData.access$300(r1)     // Catch: java.lang.Throwable -> L46
                    cn.vlion.ad.inland.base.util.event.VlionADEventManager.submitDownProgress(r0, r1, r3)     // Catch: java.lang.Throwable -> L46
                L8b:
                    cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData$a r0 = cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData.a.this     // Catch: java.lang.Throwable -> L46
                    cn.vlion.ad.inland.base.y4 r0 = r0.f2381b     // Catch: java.lang.Throwable -> L46
                    if (r0 == 0) goto L9c
                    r0.onDownloadApkProgress(r3)     // Catch: java.lang.Throwable -> L46
                    goto L9c
                L95:
                    cn.vlion.ad.inland.base.util.init.VlionSDkManager r0 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()
                    r0.upLoadCatchException(r3)
                L9c:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData.a.C0022a.onDownloadApkProgress(int):void");
            }

            @Override // cn.vlion.ad.inland.base.y4
            public final void onDownloadFailed() {
                y4 y4Var = a.this.f2381b;
                if (y4Var != null) {
                    y4Var.onDownloadFailed();
                }
            }

            @Override // cn.vlion.ad.inland.base.y4
            public final void onDownloadPaused() {
                y4 y4Var = a.this.f2381b;
                if (y4Var != null) {
                    y4Var.onDownloadPaused();
                }
            }

            @Override // cn.vlion.ad.inland.base.y4
            public final void onDownloadSuccess(String str) {
                y4 y4Var = a.this.f2381b;
                if (y4Var != null) {
                    y4Var.onDownloadSuccess(str);
                }
            }

            @Override // cn.vlion.ad.inland.base.y4
            public final void onInstallComplete() {
                y4 y4Var = a.this.f2381b;
                if (y4Var != null) {
                    y4Var.onInstallComplete();
                }
            }

            @Override // cn.vlion.ad.inland.base.y4
            public final void a(int i10) {
                y4 y4Var = a.this.f2381b;
                if (y4Var != null) {
                    y4Var.a(i10);
                }
            }
        }

        public a(Context context, y4 y4Var) {
            this.f2380a = context;
            this.f2381b = y4Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                LogVlion.e("DownloadApkData  定时到检测");
                t0.a(this.f2380a, DownloadApkData.this.downloadId, new C0022a());
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f2384a;

        public b(String str) {
            this.f2384a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (DownloadApkData.this.vlionDownloadProgressListener != null) {
                DownloadApkData.this.vlionDownloadProgressListener.onDownloadSuccess(this.f2384a);
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (DownloadApkData.this.vlionDownloadProgressListener != null) {
                DownloadApkData.this.vlionDownloadProgressListener.onInstallComplete();
            }
        }
    }

    public DownloadApkData(VlionCustomParseAdData vlionCustomParseAdData, VlionAdapterADConfig vlionAdapterADConfig) {
        ArrayList<String> arrayList;
        this.urlHeader = "";
        this.urldownloadStartHeader = "";
        this.urlactiveHeader = "";
        this.packageName = "";
        if (vlionCustomParseAdData == null) {
            return;
        }
        try {
            this.vlionAdapterADConfig = vlionAdapterADConfig;
            VlionCustomAdData.SeatbidBean.BidBean.AppInfoBean appInfoBean = vlionCustomParseAdData.getAppInfoBean();
            if (appInfoBean != null) {
                this.downloadApkName = appInfoBean.getApp_name();
                this.packageName = appInfoBean.getPkgname();
            }
            List<VlionCustomAdData.SeatbidBean.BidBean.ConvTrackingBean> conv_tracking = vlionCustomParseAdData.getBidBean().getConv_tracking();
            if (conv_tracking != null && conv_tracking.size() > 0) {
                for (int i10 = 0; i10 < conv_tracking.size(); i10++) {
                    VlionCustomAdData.SeatbidBean.BidBean.ConvTrackingBean convTrackingBean = conv_tracking.get(i10);
                    if (convTrackingBean != null) {
                        String url = convTrackingBean.getUrl();
                        if (!TextUtils.isEmpty(url)) {
                            switch (convTrackingBean.getTrack_type()) {
                                case 5:
                                    arrayList = this.downloadStartUrl;
                                    break;
                                case 6:
                                    arrayList = this.installStartUrl;
                                    break;
                                case 7:
                                    arrayList = this.downloadCompleteUrl;
                                    break;
                                case 8:
                                    arrayList = this.installCompleteUrl;
                                    break;
                                case 9:
                                    arrayList = this.activeCompleteUrl;
                                    break;
                                default:
                                    continue;
                            }
                            arrayList.add(url);
                        }
                    }
                }
            }
            this.urlHeader = c5.a(vlionCustomParseAdData, VlionNetRespType.adx_download_complete);
            this.urldownloadStartHeader = c5.a(vlionCustomParseAdData, VlionNetRespType.adx_download_start);
            this.urlactiveHeader = c5.a(vlionCustomParseAdData, VlionNetRespType.adx_active_complete);
            LogVlion.e("DownloadApkData  downloadStartUrl=" + this.downloadStartUrl.size());
            LogVlion.e("DownloadApkData  downloadCompleteUrl=" + this.downloadCompleteUrl.size());
            LogVlion.e("DownloadApkData  installStartUrl=" + this.installStartUrl.size());
            LogVlion.e("DownloadApkData  installCompleteUrl=" + this.installCompleteUrl.size());
            LogVlion.e("DownloadApkData  activeCompleteUrl=" + this.activeCompleteUrl.size());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void cancelMission() {
        try {
            VlionADEventManager.submitDownPause(this.vlionAdapterADConfig, this.vlionADEventDownParam, this.percentProgress);
            if (this.isDownComplete) {
                return;
            }
            this.downloadId = 0L;
            cancelSchedule();
            this.isDownComplete = false;
            this.isInstallDownComplete = false;
            this.percentProgress = -1;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void cancelSchedule() {
        try {
            LogVlion.e("DownloadApkData  cancelSchedule=");
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.scheduledFuture;
            if (scheduledThreadPoolExecutor != null) {
                scheduledThreadPoolExecutor.shutdown();
                this.scheduledFuture = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public String getDownloadApkName() {
        return this.downloadApkName;
    }

    public long getDownloadId() {
        return this.downloadId;
    }

    public String getFilename() {
        return this.filename;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getPercentProgress() {
        return this.percentProgress;
    }

    public boolean haveDownMission() {
        return this.downloadId > 0;
    }

    public boolean isAdClosed() {
        return this.isAdClosed;
    }

    public boolean isDownComplete() {
        return this.isDownComplete;
    }

    public boolean isInstallComplete() {
        return this.isInstallDownComplete;
    }

    public void onDownloadFailed() {
        this.downloadId = 0L;
        cancelSchedule();
    }

    public void setAdClosed(boolean z10) {
        this.isAdClosed = z10;
    }

    public void setDownloadId(long j10) {
        this.downloadId = j10;
    }

    public void startSchedule(Context context, y4 y4Var) {
        try {
            cancelSchedule();
            this.vlionDownloadProgressListener = y4Var;
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
            this.scheduledFuture = scheduledThreadPoolExecutor;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(new a(context, y4Var), 0L, 500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void submitActiveComplete() {
        ArrayList<String> arrayList = this.activeCompleteUrl;
        String str = this.urlactiveHeader;
        if (arrayList != null) {
            try {
                if (arrayList.size() == 0) {
                    return;
                }
                LogVlion.e("VlionEventAction submitActiveComplete");
                HttpRequestUtil.submitBehavior(arrayList, VlionNetRespType.adx_active_complete, str);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public void submitDownloadComplete(String str) {
        try {
            this.filename = str;
            cancelSchedule();
            if (this.isDownComplete) {
                return;
            }
            this.isDownComplete = true;
            VlionBaseParameterReplace vlionBaseParameterReplace = this.apkDownloadParameterReplace;
            if (vlionBaseParameterReplace != null) {
                vlionBaseParameterReplace.handleApkDownloadParameter(2);
            }
            c5.a(this.downloadCompleteUrl, this.urlHeader, this.apkDownloadParameterReplace);
            VlionADEventManager.submitDownComplete(this.vlionAdapterADConfig, this.vlionADEventDownParam);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void submitDownloadStart(Context context, VlionADEventDownParam vlionADEventDownParam, int i10, VlionBaseParameterReplace vlionBaseParameterReplace) {
        try {
            this.vlionADEventDownParam = vlionADEventDownParam;
            this.apkDownloadParameterReplace = vlionBaseParameterReplace;
            if (vlionBaseParameterReplace != null) {
                vlionBaseParameterReplace.handleApkDownloadParameter(1);
            }
            c5.b(this.downloadStartUrl, this.urldownloadStartHeader, vlionBaseParameterReplace);
            VlionADEventManager.submitDownStart(this.vlionAdapterADConfig, vlionADEventDownParam);
            VlionADEventManager.submitDownStorage(this.vlionAdapterADConfig, vlionADEventDownParam, t0.a(context), i10, VlionDeviceInfo.getInstance().getAvailableStorageSpace());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void submitInstallComplete() {
        try {
            LogVlion.e("DownloadApkData  submitInstallComplete");
            VlionBaseParameterReplace vlionBaseParameterReplace = this.apkDownloadParameterReplace;
            if (vlionBaseParameterReplace != null) {
                vlionBaseParameterReplace.handleApkDownloadParameter(4);
            }
            VlionADEventManager.submitDownInstalled(this.vlionAdapterADConfig, this.vlionADEventDownParam);
            VlionHandlerUtils.instant().post(new c());
            if (this.isInstallDownComplete) {
                return;
            }
            this.isInstallDownComplete = true;
            c5.c(this.installCompleteUrl, this.urlHeader, this.apkDownloadParameterReplace);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void submitInstallStart(String str, boolean z10) {
        try {
            LogVlion.e("DownloadApkData  submitInstallStart");
            this.filename = str;
            VlionBaseParameterReplace vlionBaseParameterReplace = this.apkDownloadParameterReplace;
            if (vlionBaseParameterReplace != null) {
                vlionBaseParameterReplace.handleApkDownloadParameter(3);
            }
            c5.d(this.installStartUrl, this.urlHeader, this.apkDownloadParameterReplace);
            VlionADEventManager.submitDownInstall(this.vlionAdapterADConfig, this.vlionADEventDownParam, z10);
            VlionHandlerUtils.instant().post(new b(str));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
