package cn.vlion.ad.inland.base;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import cn.vlion.ad.inland.ad.config.VlionCustomAdActiveType$VlionCustomTarget;
import cn.vlion.ad.inland.ad.javabean.VlionCustomAdData;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse;
import cn.vlion.ad.inland.base.r6;
import cn.vlion.ad.inland.base.t0;
import cn.vlion.ad.inland.base.util.StrategysIdUtils;
import cn.vlion.ad.inland.base.util.VlionHandlerUtils;
import cn.vlion.ad.inland.base.util.event.VlionADEventDownParam;
import cn.vlion.ad.inland.base.util.event.VlionADEventManager;
import cn.vlion.ad.inland.base.util.handle.VlionBaseParameterReplace;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class q0 {

    /* renamed from: a */
    public DownloadApkData f3297a;

    /* renamed from: b */
    public r6 f3298b = new r6();

    /* renamed from: c */
    public y4 f3299c;

    /* renamed from: d */
    public VlionBaseParameterReplace f3300d;

    public class a implements r6.a {

        /* renamed from: a */
        public final /* synthetic */ VlionCustomParseAdData f3301a;

        /* renamed from: b */
        public final /* synthetic */ VlionAdapterADConfig f3302b;

        /* renamed from: c */
        public final /* synthetic */ String f3303c;

        public a(VlionCustomParseAdData vlionCustomParseAdData, VlionAdapterADConfig vlionAdapterADConfig, String str) {
            this.f3301a = vlionCustomParseAdData;
            this.f3302b = vlionAdapterADConfig;
            this.f3303c = str;
        }

        public final void a(int i10) {
            try {
                LogVlion.e("VlionApkDownStatueUtils schedule  time=" + i10);
                VlionCustomParseAdData vlionCustomParseAdData = this.f3301a;
                VlionADEventManager.getParameterDeepLinkCheck(this.f3302b, this.f3303c, vlionCustomParseAdData != null ? vlionCustomParseAdData.getBidBean().getPkgname() : "", i10);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            y4 y4Var = q0.this.f3299c;
            if (y4Var != null) {
                y4Var.b();
            }
        }
    }

    public interface c {
        void a();

        void b();

        void c();
    }

    public final VlionCustomAdActiveType$VlionCustomTarget a(Context context, VlionAdapterADConfig vlionAdapterADConfig, VlionCustomParseAdData vlionCustomParseAdData, y4 y4Var) {
        VlionCustomAdActiveType$VlionCustomTarget a10;
        boolean z10;
        VlionCustomAdActiveType$VlionCustomTarget vlionCustomAdActiveType$VlionCustomTarget = VlionCustomAdActiveType$VlionCustomTarget.exception;
        try {
            this.f3299c = y4Var;
            if (context != null && vlionCustomParseAdData != null && vlionAdapterADConfig != null) {
                String dp = vlionCustomParseAdData.getDp();
                String mdp = vlionCustomParseAdData.getMdp();
                boolean isEmpty = TextUtils.isEmpty(dp);
                String ldp = vlionCustomParseAdData.getBidBean().getLdp();
                boolean isIs_download = vlionCustomParseAdData.isIs_download();
                VlionCustomAdData.SeatbidBean.BidBean.AppInfoBean appInfoBean = vlionCustomParseAdData.getAppInfoBean();
                boolean a11 = q.a(context, dp);
                String wake_id = vlionCustomParseAdData.getWake_id();
                String wake_path = vlionCustomParseAdData.getWake_path();
                int wake_type = vlionCustomParseAdData.getWake_type();
                LogVlion.e("WXApiUtil.getIsWxSdk() " + VlionServiceConfigParse.getInstance().getIsWxSdk() + ",isWXAppInstalled " + h7.f2858a + ",wake_id " + wake_id + ",wake_type " + wake_type + ",wake_path " + wake_path);
                try {
                    if (h7.f2858a) {
                        if (VlionServiceConfigParse.getInstance().getIsWxSdk() == 1) {
                            if (wake_type == 1 && h7.a(context, VlionServiceConfigParse.getInstance().getWxAppId(), wake_path, wake_id).booleanValue()) {
                                return VlionCustomAdActiveType$VlionCustomTarget.WXMiniProgram;
                            }
                        } else if (VlionServiceConfigParse.getInstance().getIsWxSdk() == 0 && h7.b(context, VlionServiceConfigParse.getInstance().getWxAppId(), wake_path, wake_id)) {
                            return VlionCustomAdActiveType$VlionCustomTarget.WXMiniProgram;
                        }
                    }
                } catch (Throwable th2) {
                    LogVlion.e("VlionApkDownStatueUtils open WXMiniProgram e " + th2.getMessage());
                }
                if (a11) {
                    boolean a12 = q.a(context, dp, vlionCustomParseAdData.getSlotID(), vlionCustomParseAdData.getDspid());
                    LogVlion.e("VlionApkDownStatueUtils isOPen " + a12);
                    if (a12) {
                        vlionCustomAdActiveType$VlionCustomTarget = VlionCustomAdActiveType$VlionCustomTarget.deeplink;
                        DownloadApkData downloadApkData = this.f3297a;
                        if (downloadApkData != null && downloadApkData.isInstallComplete()) {
                            LogVlion.e("VlionApkDownStatueUtils submitActiveComplete ");
                            this.f3297a.submitActiveComplete();
                        }
                        StrategysIdUtils.getInstance().regroupStrategysIdList(vlionCustomParseAdData.getBidBean().getPkgname());
                        r6 r6Var = this.f3298b;
                        int deeplinkTimes = VlionServiceConfigParse.getInstance().getDeeplinkTimes();
                        a aVar = new a(vlionCustomParseAdData, vlionAdapterADConfig, dp);
                        r6Var.getClass();
                        try {
                            q6 q6Var = r6Var.f3358a;
                            if (q6Var != null) {
                                q6Var.cancel();
                                r6Var.f3358a = null;
                            }
                            if (deeplinkTimes <= 0) {
                                return vlionCustomAdActiveType$VlionCustomTarget;
                            }
                            LogVlion.e("VlionTimerUtils CountDownTimer");
                            q6 q6Var2 = new q6(r6Var, deeplinkTimes * 1000, aVar, deeplinkTimes);
                            r6Var.f3358a = q6Var2;
                            q6Var2.start();
                            return vlionCustomAdActiveType$VlionCustomTarget;
                        } catch (Throwable th3) {
                            VlionSDkManager.getInstance().upLoadCatchException(th3);
                            return vlionCustomAdActiveType$VlionCustomTarget;
                        }
                    }
                    if (q.a(context, mdp)) {
                        if (q.a(context, dp, vlionCustomParseAdData.getSlotID(), vlionCustomParseAdData.getDspid())) {
                            VlionCustomAdActiveType$VlionCustomTarget vlionCustomAdActiveType$VlionCustomTarget2 = VlionCustomAdActiveType$VlionCustomTarget.marketurl;
                        } else {
                            z10 = isIs_download;
                            a(context, isEmpty, isIs_download, appInfoBean, ldp, y4Var, vlionAdapterADConfig, vlionCustomParseAdData);
                            a10 = a(context, isEmpty, z10, appInfoBean, ldp, y4Var, vlionAdapterADConfig, vlionCustomParseAdData);
                        }
                    }
                    z10 = isIs_download;
                    a10 = a(context, isEmpty, z10, appInfoBean, ldp, y4Var, vlionAdapterADConfig, vlionCustomParseAdData);
                } else {
                    if (q.a(context, mdp)) {
                        VlionCustomAdActiveType$VlionCustomTarget a13 = q.a(context, dp, vlionCustomParseAdData.getSlotID(), vlionCustomParseAdData.getDspid()) ? VlionCustomAdActiveType$VlionCustomTarget.marketurl : a(context, isEmpty, isIs_download, appInfoBean, ldp, y4Var, vlionAdapterADConfig, vlionCustomParseAdData);
                    }
                    LogVlion.e("VlionApkDownStatueUtils isDownLoad " + isIs_download + " 无  dp  无  Marketurl");
                    a10 = a(context, isEmpty, isIs_download, appInfoBean, ldp, y4Var, vlionAdapterADConfig, vlionCustomParseAdData);
                }
                return a10;
            }
            return vlionCustomAdActiveType$VlionCustomTarget;
        } catch (Throwable th4) {
            VlionSDkManager.getInstance().upLoadCatchException(th4);
            return vlionCustomAdActiveType$VlionCustomTarget;
        }
    }

    public final VlionCustomAdActiveType$VlionCustomTarget a(Context context, boolean z10, boolean z11, VlionCustomAdData.SeatbidBean.BidBean.AppInfoBean appInfoBean, String str, y4 y4Var, VlionAdapterADConfig vlionAdapterADConfig, VlionCustomParseAdData vlionCustomParseAdData) {
        List<VlionCustomAdData.SeatbidBean.BidBean.HeadInfoBean.Headerbean> list;
        String str2;
        String str3;
        StringBuilder sb2;
        String vlionCustomAdActiveType$VlionCustomTarget;
        VlionADEventDownParam vlionADEventDownParam;
        VlionCustomAdActiveType$VlionCustomTarget vlionCustomAdActiveType$VlionCustomTarget2 = VlionCustomAdActiveType$VlionCustomTarget.exception;
        try {
            LogVlion.e("VlionApkDownStatueUtils  11111 target exception = =" + vlionCustomAdActiveType$VlionCustomTarget2.toString());
            list = null;
            vlionADEventDownParam = null;
            list = null;
            list = null;
            list = null;
            str2 = "";
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        if (z11) {
            if (!TextUtils.isEmpty(str) && str.startsWith("hwpps://landingpage")) {
                Intent intent = new Intent();
                intent.setData(Uri.parse(str));
                intent.addFlags(268435456);
                try {
                    LogVlion.e("landingpage-  hwpps://landingpage: = " + str);
                    context.startActivity(intent);
                } catch (Throwable th3) {
                    VlionSDkManager.getInstance().upLoadCatchException(th3);
                    LogVlion.e("landingpage- e " + th3);
                }
                return VlionCustomAdActiveType$VlionCustomTarget.hmsinstall;
            }
            DownloadApkData downloadApkData = this.f3297a;
            if (downloadApkData != null) {
                if (downloadApkData.isInstallComplete()) {
                    LogVlion.e("VlionApkDownStatueUtils isInstallDownComplete true isDeeplinkEmpty=" + z10);
                    if (z10) {
                        DownloadApkData downloadApkData2 = this.f3297a;
                        downloadApkData2.submitInstallStart(downloadApkData2.getFilename(), false);
                        i5.a(context, this.f3297a.getFilename());
                    }
                    return VlionCustomAdActiveType$VlionCustomTarget.installApp;
                }
                if (this.f3297a.isDownComplete()) {
                    LogVlion.e("VlionApkDownStatueUtils isDownComplete true ");
                    DownloadApkData downloadApkData3 = this.f3297a;
                    downloadApkData3.submitInstallStart(downloadApkData3.getFilename(), false);
                    i5.a(context, this.f3297a.getFilename());
                    return VlionCustomAdActiveType$VlionCustomTarget.installApp;
                }
            }
            DownloadApkData downloadApkData4 = this.f3297a;
            long downloadId = downloadApkData4 != null ? downloadApkData4.getDownloadId() : 0L;
            LogVlion.e("VlionApkDownStatueUtils downId=" + downloadId);
            if (downloadId > 0 && t0.c(context, downloadId)) {
                LogVlion.e("VlionApkDownStatueUtils onDownloadLoading");
                DownloadApkData downloadApkData5 = this.f3297a;
                y4Var.a(downloadApkData5 != null ? downloadApkData5.getPercentProgress() : 0);
                vlionCustomAdActiveType$VlionCustomTarget2 = VlionCustomAdActiveType$VlionCustomTarget.downloading;
                sb2 = new StringBuilder();
                sb2.append("VlionApkDownStatueUtils  333333 target downloading = =");
                sb2.append(vlionCustomAdActiveType$VlionCustomTarget2.toString());
                LogVlion.e(sb2.toString());
                LogVlion.e("VlionApkDownStatueUtils  55555 target  = =" + vlionCustomAdActiveType$VlionCustomTarget2.toString());
                return vlionCustomAdActiveType$VlionCustomTarget2;
            }
            String str4 = "" + SystemClock.currentThreadTimeMillis();
            if (appInfoBean != null && !TextUtils.isEmpty(appInfoBean.getPkgname())) {
                str4 = appInfoBean.getPkgname();
            }
            t0.a a10 = t0.a(context, str, str4);
            long j10 = a10.f3369a;
            String str5 = a10.f3370b;
            LogVlion.e("VlionApkDownStatueUtils downloadId=" + j10);
            if (this.f3297a != null) {
                if (appInfoBean != null) {
                    r14 = appInfoBean.getSize();
                    vlionADEventDownParam = new VlionADEventDownParam(str5, appInfoBean.getPkgname(), appInfoBean.getSize());
                }
                this.f3297a.setDownloadId(j10);
                if (vlionCustomParseAdData != null) {
                    this.f3300d = new VlionBaseParameterReplace(vlionCustomParseAdData);
                }
                this.f3297a.submitDownloadStart(context, vlionADEventDownParam, r14, this.f3300d);
                DownloadApkData downloadApkData6 = this.f3297a;
                ConcurrentHashMap<Long, DownloadApkData> concurrentHashMap = s0.f3359a;
                try {
                    LogVlion.e("VlionApkDownUtils saveAppInfo=" + downloadApkData6.getPackageName());
                    s0.f3359a.put(Long.valueOf(j10), downloadApkData6);
                } catch (Throwable th4) {
                    VlionSDkManager.getInstance().upLoadCatchException(th4);
                }
                LogVlion.e("VlionApkDownStatueUtils downloadApkData.getDownloadId()=" + this.f3297a.getDownloadId());
                try {
                    LogVlion.e("VlionApkDownStatueUtils 查询");
                    this.f3297a.startSchedule(context, new r0(this, y4Var));
                } catch (Throwable th5) {
                    VlionSDkManager.getInstance().upLoadCatchException(th5);
                }
                vlionCustomAdActiveType$VlionCustomTarget2 = VlionCustomAdActiveType$VlionCustomTarget.download;
                sb2 = new StringBuilder();
                sb2.append("VlionApkDownStatueUtils  22222 target download = =");
                vlionCustomAdActiveType$VlionCustomTarget = vlionCustomAdActiveType$VlionCustomTarget2.toString();
            }
            LogVlion.e("VlionApkDownStatueUtils  55555 target  = =" + vlionCustomAdActiveType$VlionCustomTarget2.toString());
            return vlionCustomAdActiveType$VlionCustomTarget2;
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return vlionCustomAdActiveType$VlionCustomTarget2;
        }
        if (vlionAdapterADConfig != null) {
            str2 = vlionAdapterADConfig.getSlotID();
            str3 = vlionAdapterADConfig.getDspid();
        } else {
            str3 = "";
        }
        if (vlionCustomParseAdData != null && vlionCustomParseAdData.getBidBean() != null && vlionCustomParseAdData.getBidBean().getHead_info() != null && vlionCustomParseAdData.getBidBean().getHead_info().getLdp() != null) {
            list = vlionCustomParseAdData.getBidBean().getHead_info().getLdp();
        }
        vlionCustomAdActiveType$VlionCustomTarget2 = q.a(context, str, str2, str3, list);
        sb2 = new StringBuilder();
        sb2.append("VlionApkDownStatueUtils  444444 target openEndPage = =");
        vlionCustomAdActiveType$VlionCustomTarget = vlionCustomAdActiveType$VlionCustomTarget2.toString();
        sb2.append(vlionCustomAdActiveType$VlionCustomTarget);
        LogVlion.e(sb2.toString());
        LogVlion.e("VlionApkDownStatueUtils  55555 target  = =" + vlionCustomAdActiveType$VlionCustomTarget2.toString());
        return vlionCustomAdActiveType$VlionCustomTarget2;
    }

    public static String a(Context context, VlionCustomParseAdData vlionCustomParseAdData) {
        if (context == null || vlionCustomParseAdData == null) {
            return "";
        }
        try {
            String dp = vlionCustomParseAdData.getDp();
            return !TextUtils.isEmpty(dp) ? q.a(context, dp) ? "1" : "0" : "";
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return "";
        }
    }

    public final void a() {
        try {
            DownloadApkData downloadApkData = this.f3297a;
            if (downloadApkData != null) {
                downloadApkData.cancelSchedule();
            }
            r6 r6Var = this.f3298b;
            if (r6Var != null) {
                try {
                    q6 q6Var = r6Var.f3358a;
                    if (q6Var != null) {
                        q6Var.cancel();
                        r6Var.f3358a = null;
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
                this.f3298b = null;
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    public final void a(Context context) {
        try {
            LogVlion.e("VlionApkDownStatueUtils cancelMission");
            DownloadApkData downloadApkData = this.f3297a;
            long downloadId = downloadApkData != null ? downloadApkData.getDownloadId() : 0L;
            boolean b10 = t0.b(context, downloadId);
            LogVlion.e("VlionApkDownStatueUtils cancelMission isDownSuccess=" + b10);
            if (b10) {
                return;
            }
            t0.a(context, downloadId);
            this.f3297a.cancelMission();
            VlionHandlerUtils.instant().post(new b());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a(Context context, String str, boolean z10, c cVar) {
        try {
            if (context == null) {
                cVar.a();
                return;
            }
            boolean a10 = q.a(context, str);
            LogVlion.e("VlionApkDownStatueUtils isShowDownConfirm CanOpenDeeplink=" + a10);
            if (!a10) {
                LogVlion.e("VlionApkDownStatueUtils isShowDownConfirm isDownLoad=" + z10);
                if (z10) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("VlionApkDownStatueUtils isShowDownConfirm null == downloadApkData ");
                    sb2.append(this.f3297a == null);
                    sb2.append(" !downloadApkData.haveDownMission()=");
                    sb2.append(!this.f3297a.haveDownMission());
                    LogVlion.e(sb2.toString());
                    DownloadApkData downloadApkData = this.f3297a;
                    if (downloadApkData != null && downloadApkData.haveDownMission()) {
                        LogVlion.e("VlionApkDownStatueUtils isShowDownConfirm isDownComplete=" + this.f3297a.isDownComplete() + " isInstallComplete" + this.f3297a.isInstallComplete());
                        cVar.c();
                        return;
                    }
                    cVar.b();
                    return;
                }
            }
            cVar.a();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
