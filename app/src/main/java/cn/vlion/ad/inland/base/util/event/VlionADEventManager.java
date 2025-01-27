package cn.vlion.ad.inland.base.util.event;

import android.text.TextUtils;
import cn.vlion.ad.inland.base.adapter.VlionBidderSource;
import cn.vlion.ad.inland.base.adapter.VlionLossReason;
import cn.vlion.ad.inland.base.c6;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.javabean.VlionADNetBodyParameter;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.javabean.VlionDAClkBodyParameter;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse;
import cn.vlion.ad.inland.base.l1;
import cn.vlion.ad.inland.base.n0;
import cn.vlion.ad.inland.base.network.VlionHttpCallBack;
import cn.vlion.ad.inland.base.network.ok.HttpRequestUtil;
import cn.vlion.ad.inland.base.p;
import cn.vlion.ad.inland.base.util.VlionAESUtils;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.device.VlionDeviceInfo;
import cn.vlion.ad.inland.base.util.init.VlionPrivateController;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.base.util.sp.VlionSharedPreferences;
import cn.vlion.ad.inland.base.util.timer.VlionTimer;
import cn.vlion.ad.inland.base.y;
import cn.vlion.ad.inland.base.y0;
import h3.e;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class VlionADEventManager {

    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ boolean f3413a;

        /* renamed from: cn.vlion.ad.inland.base.util.event.VlionADEventManager$a$a */
        public class C0028a implements VlionHttpCallBack {
            @Override // cn.vlion.ad.inland.base.network.VlionHttpCallBack
            public final void onFail(VlionAdBaseError vlionAdBaseError) {
                if (vlionAdBaseError != null) {
                    StringBuilder a10 = l1.a("VlionADEventManager sendReportSdkEvent: onFail getErrorCode=");
                    a10.append(vlionAdBaseError.getErrorCode());
                    a10.append(" getErrorMessage=");
                    a10.append(vlionAdBaseError.getErrorMessage());
                    LogVlion.e(a10.toString());
                }
            }

            @Override // cn.vlion.ad.inland.base.network.VlionHttpCallBack
            public final void onSuccess(String str) {
                LogVlion.e("VlionADEventManager sendReportSdkEvent: onSuccess");
                VlionSharedPreferences.getInstance().setAppListEventEventDate();
            }
        }

        public a(boolean z10) {
            this.f3413a = z10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                boolean isAppListEventTodayHas = VlionSharedPreferences.getInstance().isAppListEventTodayHas();
                VlionPrivateController privateController = VlionSDkManager.getInstance().getPrivateController();
                boolean isCanReadAppList = privateController != null ? privateController.isCanReadAppList() : true;
                LogVlion.e("VlionADEventManager sendReportSdkEvent: collectInstalledPackage=" + this.f3413a + "isCanReadAppList=" + isCanReadAppList + " isAppListEventTodayHas=" + isAppListEventTodayHas);
                if (!this.f3413a || !isCanReadAppList || isAppListEventTodayHas || TextUtils.isEmpty(VlionServiceConfigParse.getInstance().getReportUrl())) {
                    return;
                }
                List<String> installedPackages = VlionDeviceInfo.getInstance().getInstalledPackages(VlionSDkManager.getInstance().getApplication());
                if (installedPackages != null) {
                    LogVlion.e("VlionADEventManager sendReportSdkEvent: appList.size=" + installedPackages.size());
                }
                String a10 = y0.a(installedPackages);
                if (TextUtils.isEmpty(a10)) {
                    LogVlion.e("VlionADEventManager sendReportSdkEvent adJson isEmpty");
                    return;
                }
                String sendJsonAESData = VlionADEventManager.getSendJsonAESData(a10);
                LogVlion.e("VlionADEventManager 准备发送数据，加密数据 sendData:" + sendJsonAESData);
                HttpRequestUtil.uploadReport(VlionServiceConfigParse.getInstance().getReportUrl(), sendJsonAESData, new C0028a());
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public static n0 getAdEvent(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return new n0(str, str2);
    }

    public static n0 getNetEvent(VlionADNetBodyParameter vlionADNetBodyParameter) {
        if (vlionADNetBodyParameter == null) {
            return null;
        }
        String str = "";
        try {
            try {
                str = y0.a(vlionADNetBodyParameter);
            } catch (Exception e10) {
                LogVlion.e("VlionBaseParameter ====getParameterAdVlion 请求参数=====Exception=" + e10);
            }
            LogVlion.e("VlionBaseParameter ====getParameterAdVlion 请求参数=====" + str);
            if (!TextUtils.isEmpty(str)) {
                return getAdEvent("99", str);
            }
            LogVlion.e("VlionADEventManager getParameterAdVlion adJson isEmpty");
            return null;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return null;
        }
    }

    public static void getParameterDeepLinkCheck(VlionAdapterADConfig vlionAdapterADConfig, String str, String str2, int i10) {
        if (vlionAdapterADConfig == null) {
            return;
        }
        try {
            String adDpcheck = VlionServiceConfigParse.getInstance().getEventsBean().getAdDpcheck();
            LogVlion.e("VlionADEventManager getParameterDeepLinkCheck：" + adDpcheck);
            String a10 = y0.a(adDpcheck, vlionAdapterADConfig, str, str2, i10);
            if (TextUtils.isEmpty(a10)) {
                LogVlion.e("VlionADEventManager getParameterDeepLinkCheck adJson isEmpty");
            } else {
                c6.a().a(getAdEvent("100", a10));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void getParameterEnter(VlionAdapterADConfig vlionAdapterADConfig) {
        if (vlionAdapterADConfig == null) {
            return;
        }
        try {
            String adEnter = VlionServiceConfigParse.getInstance().getEventsBean().getAdEnter();
            LogVlion.e("VlionADEventManager getParameterSkip：" + adEnter);
            String a10 = y0.a(adEnter, vlionAdapterADConfig);
            if (TextUtils.isEmpty(a10)) {
                LogVlion.e("VlionADEventManager getParameterSkip adJson isEmpty");
            } else {
                c6.a().a(getAdEvent("100", a10));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void getParameterShow(VlionAdapterADConfig vlionAdapterADConfig, String str) {
        if (vlionAdapterADConfig == null) {
            return;
        }
        try {
            String adShow = VlionServiceConfigParse.getInstance().getEventsBean().getAdShow();
            LogVlion.e("VlionADEventManager getParameterShow：" + adShow);
            String a10 = y0.a(adShow, vlionAdapterADConfig, str);
            if (TextUtils.isEmpty(a10)) {
                LogVlion.e("VlionADEventManager getParameterShow adJson isEmpty");
            } else {
                c6.a().a(getAdEvent("100", a10));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void getParameterSkip(VlionAdapterADConfig vlionAdapterADConfig, int i10) {
        if (vlionAdapterADConfig == null) {
            return;
        }
        try {
            String adSkip = VlionServiceConfigParse.getInstance().getEventsBean().getAdSkip();
            LogVlion.e("VlionADEventManager getParameterSkip：" + adSkip);
            String b10 = y0.b(vlionAdapterADConfig, adSkip, i10);
            if (TextUtils.isEmpty(b10)) {
                LogVlion.e("VlionADEventManager getParameterSkip adJson isEmpty");
            } else {
                c6.a().a(getAdEvent("100", b10));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static String getSendJsonAESData(String str) {
        String str2;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(e.f26408m, VlionAESUtils.encrypt(str, HttpRequestUtil.KEY, HttpRequestUtil.IV));
            str2 = jSONObject.toString();
        } catch (Throwable th2) {
            p.a(th2, "VlionADEventManager SendJsonAESData == 请求参数=====Exception=", th2);
            str2 = "";
        }
        y.a("VlionADEventManager SendJsonAESData === 请求参数=====", str2);
        return str2;
    }

    public static void sendFrontBackSdkEvent() {
        try {
            LogVlion.e("VlionADEventManager sendFrontBackSdkEvent: ");
            String a10 = y0.a();
            if (TextUtils.isEmpty(a10)) {
                LogVlion.e("VlionADEventManager sendFrontBackSdkEvent adJson isEmpty");
            } else {
                c6.a().a(getAdEvent("99", a10));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void sendReportSdkEvent(boolean z10) {
        try {
            LogVlion.e("VlionADEventManager sendReportSdkEvent: ");
            VlionTimer.getInstance().startTimer(0L, new a(z10));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void sendStartSdkEvent() {
        try {
            LogVlion.e("VlionADEventManager sendStartSdkEvent: ");
            String b10 = y0.b();
            if (TextUtils.isEmpty(b10)) {
                LogVlion.e("VlionADEventManager sendStartSdkEvent adJson isEmpty");
            } else {
                c6.a().a(getAdEvent("100", b10));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void submitBidFail(VlionAdapterADConfig vlionAdapterADConfig, double d10, double d11, VlionBidderSource vlionBidderSource, VlionLossReason vlionLossReason) {
        if (vlionAdapterADConfig == null) {
            return;
        }
        try {
            String adBid = VlionServiceConfigParse.getInstance().getEventsBean().getAdBid();
            LogVlion.e("VlionADEventManager submitFillFail：" + adBid);
            String a10 = y0.a(adBid, vlionAdapterADConfig, d10, d11, vlionBidderSource, vlionLossReason);
            if (TextUtils.isEmpty(a10)) {
                LogVlion.e("VlionADEventManager submitFillFail adJson isEmpty");
            } else {
                c6.a().a(getAdEvent("100", a10));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void submitBidSuccess(VlionAdapterADConfig vlionAdapterADConfig, double d10, double d11, double d12, VlionBidderSource vlionBidderSource) {
        if (vlionAdapterADConfig == null) {
            return;
        }
        try {
            String adBid = VlionServiceConfigParse.getInstance().getEventsBean().getAdBid();
            LogVlion.e("VlionADEventManager submitBidSuccess：" + adBid);
            String a10 = y0.a(adBid, vlionAdapterADConfig, d10, d11, d12, vlionBidderSource);
            if (TextUtils.isEmpty(a10)) {
                LogVlion.e("VlionADEventManager submitBidSuccess adJson isEmpty");
            } else {
                c6.a().a(getAdEvent("100", a10));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void submitClick(VlionAdapterADConfig vlionAdapterADConfig, VlionADClickType vlionADClickType) {
        if (vlionAdapterADConfig == null) {
            return;
        }
        try {
            String adClk = VlionServiceConfigParse.getInstance().getEventsBean().getAdClk();
            LogVlion.e("VlionADEventManager submitClick：" + adClk);
            String a10 = y0.a(adClk, vlionAdapterADConfig, vlionADClickType);
            if (TextUtils.isEmpty(a10)) {
                LogVlion.e("VlionADEventManager submitClick adJson isEmpty");
            } else {
                c6.a().a(getAdEvent("100", a10));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void submitClose(VlionAdapterADConfig vlionAdapterADConfig) {
        if (vlionAdapterADConfig == null) {
            return;
        }
        try {
            String adClose = VlionServiceConfigParse.getInstance().getEventsBean().getAdClose();
            LogVlion.e("VlionADEventManager submitClose：" + adClose);
            String a10 = y0.a(vlionAdapterADConfig, adClose, vlionAdapterADConfig.getDuration());
            if (TextUtils.isEmpty(a10)) {
                LogVlion.e("VlionADEventManager submitClose adJson isEmpty");
            } else {
                c6.a().a(getAdEvent("100", a10));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void submitDa(String str, String str2, String str3) {
        try {
            String a10 = y0.a(str, str2, str3);
            if (TextUtils.isEmpty(a10)) {
                LogVlion.e("Down 策略 :  VlionADEventManager submitDa adJson isEmpty");
                return;
            }
            LogVlion.e("Down 策略 :  submitDa 打点数据adJson =" + a10);
            c6.a().a(getAdEvent("100", a10));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void submitDaclk(boolean z10, int i10, String str, VlionDAClkBodyParameter vlionDAClkBodyParameter, long j10) {
        try {
            String a10 = y0.a(z10 ? VlionServiceConfigParse.getInstance().getEventsBean().getDaShow() : VlionServiceConfigParse.getInstance().getEventsBean().getDaClickCb(), z10, i10, str, vlionDAClkBodyParameter, j10);
            if (TextUtils.isEmpty(a10)) {
                LogVlion.e("Down 策略 :  VlionADEventManager submitDa adJson isEmpty");
                return;
            }
            LogVlion.e("Down 策略 :  adJson ==" + a10);
            c6.a().a(getAdEvent("100", a10));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void submitDeeplink(int i10, String str, long j10, VlionDAClkBodyParameter vlionDAClkBodyParameter) {
        try {
            String a10 = y0.a(VlionServiceConfigParse.getInstance().getEventsBean().getDaDeeplink(), i10, str, j10, vlionDAClkBodyParameter);
            if (TextUtils.isEmpty(a10)) {
                LogVlion.e("Down 策略 :  VlionADEventManager submitDa adJson isEmpty");
                return;
            }
            LogVlion.e("Down 策略 :  adJson ==" + a10);
            c6.a().a(getAdEvent("100", a10));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void submitDownComplete(VlionAdapterADConfig vlionAdapterADConfig, VlionADEventDownParam vlionADEventDownParam) {
        if (vlionAdapterADConfig == null) {
            return;
        }
        try {
            String dwComplete = VlionServiceConfigParse.getInstance().getEventsBean().getDwComplete();
            LogVlion.e("VlionADEventManager submitDownComplete：" + dwComplete);
            String a10 = y0.a(dwComplete, vlionAdapterADConfig, vlionADEventDownParam);
            if (TextUtils.isEmpty(a10)) {
                LogVlion.e("VlionADEventManager submitDownComplete adJson isEmpty");
            } else {
                c6.a().a(getAdEvent("100", a10));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void submitDownInstall(VlionAdapterADConfig vlionAdapterADConfig, VlionADEventDownParam vlionADEventDownParam, boolean z10) {
        if (vlionAdapterADConfig == null) {
            return;
        }
        try {
            String dwInstall = VlionServiceConfigParse.getInstance().getEventsBean().getDwInstall();
            LogVlion.e("VlionADEventManager submitDownInstall：" + dwInstall);
            String a10 = y0.a(dwInstall, vlionAdapterADConfig, vlionADEventDownParam, z10);
            if (TextUtils.isEmpty(a10)) {
                LogVlion.e("VlionADEventManager submitDownInstall adJson isEmpty");
            } else {
                c6.a().a(getAdEvent("100", a10));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void submitDownInstalled(VlionAdapterADConfig vlionAdapterADConfig, VlionADEventDownParam vlionADEventDownParam) {
        if (vlionAdapterADConfig == null) {
            return;
        }
        try {
            String dwInstalled = VlionServiceConfigParse.getInstance().getEventsBean().getDwInstalled();
            LogVlion.e("VlionADEventManager submitDownInstalled：" + dwInstalled);
            String b10 = y0.b(dwInstalled, vlionAdapterADConfig, vlionADEventDownParam);
            if (TextUtils.isEmpty(b10)) {
                LogVlion.e("VlionADEventManager submitDownInstalled adJson isEmpty");
            } else {
                c6.a().a(getAdEvent("100", b10));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void submitDownPause(VlionAdapterADConfig vlionAdapterADConfig, VlionADEventDownParam vlionADEventDownParam, int i10) {
        if (vlionAdapterADConfig == null) {
            return;
        }
        try {
            String dwPause = VlionServiceConfigParse.getInstance().getEventsBean().getDwPause();
            LogVlion.e("VlionADEventManager submitDownPause：" + dwPause);
            String a10 = y0.a(dwPause, vlionAdapterADConfig, vlionADEventDownParam, i10);
            if (TextUtils.isEmpty(a10)) {
                LogVlion.e("VlionADEventManager submitDownPause adJson isEmpty");
            } else {
                c6.a().a(getAdEvent("100", a10));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void submitDownProgress(VlionAdapterADConfig vlionAdapterADConfig, VlionADEventDownParam vlionADEventDownParam, int i10) {
        if (vlionAdapterADConfig == null) {
            return;
        }
        try {
            String dwProgress = VlionServiceConfigParse.getInstance().getEventsBean().getDwProgress();
            LogVlion.e("VlionADEventManager submitDownProgress：" + dwProgress);
            String b10 = y0.b(dwProgress, vlionAdapterADConfig, vlionADEventDownParam, i10);
            if (TextUtils.isEmpty(b10)) {
                LogVlion.e("VlionADEventManager submitDownProgress adJson isEmpty");
            } else {
                c6.a().a(getAdEvent("100", b10));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void submitDownStart(VlionAdapterADConfig vlionAdapterADConfig, VlionADEventDownParam vlionADEventDownParam) {
        if (vlionAdapterADConfig == null) {
            return;
        }
        try {
            String dwStart = VlionServiceConfigParse.getInstance().getEventsBean().getDwStart();
            LogVlion.e("VlionADEventManager submitDownStart：" + dwStart);
            String c10 = y0.c(dwStart, vlionAdapterADConfig, vlionADEventDownParam);
            if (TextUtils.isEmpty(c10)) {
                LogVlion.e("VlionADEventManager submitDownStart adJson isEmpty");
            } else {
                c6.a().a(getAdEvent("100", c10));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void submitDownStorage(VlionAdapterADConfig vlionAdapterADConfig, VlionADEventDownParam vlionADEventDownParam, int i10, int i11, long j10) {
        if (vlionAdapterADConfig == null) {
            return;
        }
        try {
            String dwStorage = VlionServiceConfigParse.getInstance().getEventsBean().getDwStorage();
            LogVlion.e("VlionADEventManager submitDownStorage：" + dwStorage);
            String a10 = y0.a(dwStorage, vlionAdapterADConfig, vlionADEventDownParam, i10, (double) i11, j10);
            if (TextUtils.isEmpty(a10)) {
                LogVlion.e("VlionADEventManager submitDownStorage adJson isEmpty");
            } else {
                c6.a().a(getAdEvent("100", a10));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void submitFillFail(VlionAdapterADConfig vlionAdapterADConfig, String str) {
        if (vlionAdapterADConfig == null) {
            return;
        }
        try {
            String adFill = VlionServiceConfigParse.getInstance().getEventsBean().getAdFill();
            LogVlion.e("VlionADEventManager submitFillFail：" + adFill);
            String a10 = y0.a(adFill, vlionAdapterADConfig, -1.0d, str);
            if (TextUtils.isEmpty(a10)) {
                LogVlion.e("VlionADEventManager submitFillFail adJson isEmpty");
            } else {
                c6.a().a(getAdEvent("100", a10));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void submitFillSuccess(VlionAdapterADConfig vlionAdapterADConfig, double d10) {
        if (vlionAdapterADConfig == null) {
            return;
        }
        try {
            String adFill = VlionServiceConfigParse.getInstance().getEventsBean().getAdFill();
            LogVlion.e("VlionADEventManager submitFill：" + adFill);
            String a10 = y0.a(adFill, vlionAdapterADConfig, d10, "-1");
            if (TextUtils.isEmpty(a10)) {
                LogVlion.e("VlionADEventManager submitFill adJson isEmpty");
            } else {
                c6.a().a(getAdEvent("100", a10));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void submitImp(VlionAdapterADConfig vlionAdapterADConfig, double d10, double d11) {
        if (vlionAdapterADConfig == null) {
            return;
        }
        try {
            String adImp = VlionServiceConfigParse.getInstance().getEventsBean().getAdImp();
            LogVlion.e("VlionADEventManager submitImp：" + adImp);
            String a10 = y0.a(adImp, vlionAdapterADConfig, d10, d11);
            if (TextUtils.isEmpty(a10)) {
                LogVlion.e("VlionADEventManager submitImp adJson isEmpty");
            } else {
                c6.a().a(getAdEvent("100", a10));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0070 A[Catch: all -> 0x0076, TryCatch #0 {all -> 0x0076, blocks: (B:5:0x0003, B:10:0x006a, B:12:0x0070, B:14:0x0078, B:17:0x0056, B:20:0x003b, B:7:0x0029, B:16:0x0030), top: B:4:0x0003, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0078 A[Catch: all -> 0x0076, TRY_LEAVE, TryCatch #0 {all -> 0x0076, blocks: (B:5:0x0003, B:10:0x006a, B:12:0x0070, B:14:0x0078, B:17:0x0056, B:20:0x003b, B:7:0x0029, B:16:0x0030), top: B:4:0x0003, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void submitRenderFail(cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig r4) {
        /*
            if (r4 != 0) goto L3
            return
        L3:
            cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse r0 = cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse.getInstance()     // Catch: java.lang.Throwable -> L76
            cn.vlion.ad.inland.base.javabean.VlionServiceConfig$DataBean$EventsBean r0 = r0.getEventsBean()     // Catch: java.lang.Throwable -> L76
            java.lang.String r0 = r0.getAdRender()     // Catch: java.lang.Throwable -> L76
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L76
            r1.<init>()     // Catch: java.lang.Throwable -> L76
            java.lang.String r2 = "VlionADEventManager submitRenderFail："
            r1.append(r2)     // Catch: java.lang.Throwable -> L76
            r1.append(r0)     // Catch: java.lang.Throwable -> L76
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L76
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r1)     // Catch: java.lang.Throwable -> L76
            java.lang.String r1 = "0"
            java.lang.String r2 = "ad_render"
            java.lang.String r3 = ""
            org.json.JSONObject r4 = cn.vlion.ad.inland.base.y0.a(r0, r2, r4)     // Catch: java.lang.Throwable -> L3a
            if (r4 != 0) goto L30
            goto L6a
        L30:
            java.lang.String r0 = "result"
            r4.put(r0, r1)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> L3a
            goto L56
        L3a:
            r4 = move-exception
            cn.vlion.ad.inland.base.util.init.VlionSDkManager r0 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()     // Catch: java.lang.Throwable -> L76
            r0.upLoadCatchException(r4)     // Catch: java.lang.Throwable -> L76
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L76
            r0.<init>()     // Catch: java.lang.Throwable -> L76
            java.lang.String r1 = "VlionBaseParameter ====getParameterAdVlionRender 请求参数=====Exception="
            r0.append(r1)     // Catch: java.lang.Throwable -> L76
            r0.append(r4)     // Catch: java.lang.Throwable -> L76
            java.lang.String r4 = r0.toString()     // Catch: java.lang.Throwable -> L76
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r4)     // Catch: java.lang.Throwable -> L76
        L56:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L76
            r4.<init>()     // Catch: java.lang.Throwable -> L76
            java.lang.String r0 = "VlionBaseParameter ====getParameterAdVlionRender 请求参数====="
            r4.append(r0)     // Catch: java.lang.Throwable -> L76
            r4.append(r3)     // Catch: java.lang.Throwable -> L76
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L76
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r4)     // Catch: java.lang.Throwable -> L76
        L6a:
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L76
            if (r4 == 0) goto L78
            java.lang.String r4 = "VlionADEventManager submitRenderFail adJson isEmpty"
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r4)     // Catch: java.lang.Throwable -> L76
            return
        L76:
            r4 = move-exception
            goto L86
        L78:
            java.lang.String r4 = "100"
            cn.vlion.ad.inland.base.n0 r4 = getAdEvent(r4, r3)     // Catch: java.lang.Throwable -> L76
            cn.vlion.ad.inland.base.c6 r0 = cn.vlion.ad.inland.base.c6.a()     // Catch: java.lang.Throwable -> L76
            r0.a(r4)     // Catch: java.lang.Throwable -> L76
            goto L8d
        L86:
            cn.vlion.ad.inland.base.util.init.VlionSDkManager r0 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()
            r0.upLoadCatchException(r4)
        L8d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.base.util.event.VlionADEventManager.submitRenderFail(cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0070 A[Catch: all -> 0x0076, TryCatch #0 {all -> 0x0076, blocks: (B:5:0x0003, B:10:0x006a, B:12:0x0070, B:14:0x0078, B:17:0x0056, B:20:0x003b, B:7:0x0029, B:16:0x0030), top: B:4:0x0003, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0078 A[Catch: all -> 0x0076, TRY_LEAVE, TryCatch #0 {all -> 0x0076, blocks: (B:5:0x0003, B:10:0x006a, B:12:0x0070, B:14:0x0078, B:17:0x0056, B:20:0x003b, B:7:0x0029, B:16:0x0030), top: B:4:0x0003, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void submitRenderSuccess(cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig r4) {
        /*
            if (r4 != 0) goto L3
            return
        L3:
            cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse r0 = cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse.getInstance()     // Catch: java.lang.Throwable -> L76
            cn.vlion.ad.inland.base.javabean.VlionServiceConfig$DataBean$EventsBean r0 = r0.getEventsBean()     // Catch: java.lang.Throwable -> L76
            java.lang.String r0 = r0.getAdRender()     // Catch: java.lang.Throwable -> L76
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L76
            r1.<init>()     // Catch: java.lang.Throwable -> L76
            java.lang.String r2 = "VlionADEventManager submitRenderSuccess："
            r1.append(r2)     // Catch: java.lang.Throwable -> L76
            r1.append(r0)     // Catch: java.lang.Throwable -> L76
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L76
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r1)     // Catch: java.lang.Throwable -> L76
            java.lang.String r1 = "1"
            java.lang.String r2 = "ad_render"
            java.lang.String r3 = ""
            org.json.JSONObject r4 = cn.vlion.ad.inland.base.y0.a(r0, r2, r4)     // Catch: java.lang.Throwable -> L3a
            if (r4 != 0) goto L30
            goto L6a
        L30:
            java.lang.String r0 = "result"
            r4.put(r0, r1)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> L3a
            goto L56
        L3a:
            r4 = move-exception
            cn.vlion.ad.inland.base.util.init.VlionSDkManager r0 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()     // Catch: java.lang.Throwable -> L76
            r0.upLoadCatchException(r4)     // Catch: java.lang.Throwable -> L76
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L76
            r0.<init>()     // Catch: java.lang.Throwable -> L76
            java.lang.String r1 = "VlionBaseParameter ====getParameterAdVlionRender 请求参数=====Exception="
            r0.append(r1)     // Catch: java.lang.Throwable -> L76
            r0.append(r4)     // Catch: java.lang.Throwable -> L76
            java.lang.String r4 = r0.toString()     // Catch: java.lang.Throwable -> L76
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r4)     // Catch: java.lang.Throwable -> L76
        L56:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L76
            r4.<init>()     // Catch: java.lang.Throwable -> L76
            java.lang.String r0 = "VlionBaseParameter ====getParameterAdVlionRender 请求参数====="
            r4.append(r0)     // Catch: java.lang.Throwable -> L76
            r4.append(r3)     // Catch: java.lang.Throwable -> L76
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L76
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r4)     // Catch: java.lang.Throwable -> L76
        L6a:
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L76
            if (r4 == 0) goto L78
            java.lang.String r4 = "VlionADEventManager submitRenderSuccess adJson isEmpty"
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r4)     // Catch: java.lang.Throwable -> L76
            return
        L76:
            r4 = move-exception
            goto L86
        L78:
            java.lang.String r4 = "100"
            cn.vlion.ad.inland.base.n0 r4 = getAdEvent(r4, r3)     // Catch: java.lang.Throwable -> L76
            cn.vlion.ad.inland.base.c6 r0 = cn.vlion.ad.inland.base.c6.a()     // Catch: java.lang.Throwable -> L76
            r0.a(r4)     // Catch: java.lang.Throwable -> L76
            goto L8d
        L86:
            cn.vlion.ad.inland.base.util.init.VlionSDkManager r0 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()
            r0.upLoadCatchException(r4)
        L8d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.base.util.event.VlionADEventManager.submitRenderSuccess(cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig):void");
    }

    public static void submitReq(VlionAdapterADConfig vlionAdapterADConfig) {
        if (vlionAdapterADConfig == null) {
            return;
        }
        try {
            String adReq = VlionServiceConfigParse.getInstance().getEventsBean().getAdReq();
            LogVlion.e("VlionADEventManager submitReq：" + adReq);
            String a10 = y0.a(adReq, vlionAdapterADConfig, (double) vlionAdapterADConfig.getBidfloor());
            if (TextUtils.isEmpty(a10)) {
                LogVlion.e("VlionADEventManager submitReq adJson isEmpty");
            } else {
                c6.a().a(getAdEvent("100", a10));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void submitTrigger(VlionAdapterADConfig vlionAdapterADConfig) {
        if (vlionAdapterADConfig == null) {
            return;
        }
        try {
            String adTrigger = VlionServiceConfigParse.getInstance().getEventsBean().getAdTrigger();
            LogVlion.e("VlionADEventManager submitTrigger：" + adTrigger);
            String b10 = y0.b(adTrigger, vlionAdapterADConfig);
            if (TextUtils.isEmpty(b10)) {
                LogVlion.e("VlionADEventManager submitTrigger adJson isEmpty");
            } else {
                c6.a().a(getAdEvent("100", b10));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void uploadNetEvent(VlionADNetBodyParameter vlionADNetBodyParameter) {
        try {
            n0 netEvent = getNetEvent(vlionADNetBodyParameter);
            if (netEvent == null) {
                LogVlion.e("VlionADEventManager getParameterAdVlion vlionAdEvent null");
            } else {
                c6.a().a(netEvent);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
