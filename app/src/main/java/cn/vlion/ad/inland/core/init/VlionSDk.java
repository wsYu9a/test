package cn.vlion.ad.inland.core.init;

import android.app.Application;
import cn.vlion.ad.inland.base.util.device.VlionDeviceInfo;
import cn.vlion.ad.inland.base.util.init.ConsumeLevel;
import cn.vlion.ad.inland.base.util.init.VlionPrivateController;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.init.VlionSdkConfig;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.core.f;
import cn.vlion.ad.inland.core.k0;
import cn.vlion.ad.inland.oaid.VlionOaidManager;

/* loaded from: classes.dex */
public class VlionSDk {
    private static String appKey;
    private static String mAppId;
    private static int oaidTimes;

    public class a implements VlionOaidManager.AppIdsListener {
        @Override // cn.vlion.ad.inland.oaid.VlionOaidManager.AppIdsListener
        public final void OnIds(String str) {
            LogVlion.e("VlionOaidManager.getIds OnIds=" + str);
            VlionDeviceInfo.getInstance().setOaid(str);
        }
    }

    public static int getSdkVersionCode() {
        return 601034;
    }

    public static String getSdkVersionName() {
        return "6.00.34";
    }

    public static void init(Application application, VlionSdkConfig vlionSdkConfig) {
        VlionPrivateController privateController;
        boolean z10;
        if (vlionSdkConfig != null) {
            try {
                mAppId = vlionSdkConfig.getAppId();
                appKey = vlionSdkConfig.getAppKey();
                boolean isEnableLog = vlionSdkConfig.isEnableLog();
                privateController = vlionSdkConfig.getPrivateController();
                z10 = isEnableLog;
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        } else {
            privateController = null;
            z10 = false;
        }
        k0.a();
        VlionSDkManager.getInstance().initAppInfo(mAppId, appKey);
        VlionSDkManager.getInstance().init(application, z10, privateController, k0.j(), getSdkVersionName());
        b.a(null);
        try {
            LogVlion.e("VlionOaidManager.getIds oaidTimes=" + oaidTimes);
            int i10 = oaidTimes;
            if (i10 < 1) {
                oaidTimes = i10 + 1;
                VlionOaidManager.getIds(application, new a());
            }
        } catch (Exception e10) {
            StringBuilder a10 = f.a("VlionOaidManager.getIds Exception:");
            a10.append(e10.getMessage());
            LogVlion.e(a10.toString());
        } catch (Throwable th3) {
            StringBuilder a11 = f.a("VlionOaidManager.getIds Throwable--------");
            a11.append(th3.getMessage());
            LogVlion.e(a11.toString());
        }
    }

    public static void isInitPlatformOnce(boolean z10) {
    }

    public static void setAge(int i10) {
        VlionSDkManager.getInstance().setAge(i10);
    }

    public static void setConsumeLevel(ConsumeLevel consumeLevel) {
        VlionSDkManager.getInstance().setConsumeLevel(consumeLevel);
    }

    public static void setPersonalizedAdState(boolean z10) {
        VlionSDkManager.getInstance().setPersonalizedAdState(z10);
    }

    public static void setUserId(String str) {
        VlionSDkManager.getInstance().setUserId(str);
    }

    public static void setWxSdkInt(int i10) {
        VlionSDkManager.getInstance().setWxSdkInt(i10);
    }

    public static void setWxSdkVersionName(String str) {
        VlionSDkManager.getInstance().setWxSdkVersionName(str);
    }
}
