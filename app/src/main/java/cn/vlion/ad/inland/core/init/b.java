package cn.vlion.ad.inland.core.init;

import android.text.TextUtils;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfig;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse;
import cn.vlion.ad.inland.base.util.StrategysIdUtils;
import cn.vlion.ad.inland.base.util.VlionAdStrategyUtils;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.device.VlionDeviceInfo;
import cn.vlion.ad.inland.base.util.init.VlionPrivateInfo;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.base.util.sp.VlionConfigSharedPreferences;
import cn.vlion.ad.inland.base.util.sp.VlionSharedPreferences;
import cn.vlion.ad.inland.base.util.timer.VlionTimer;
import cn.vlion.ad.inland.core.d0;
import cn.vlion.ad.inland.core.p;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a */
    public static WeakReference<List<String>> f3636a;

    public class a implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            LogVlion.e("VlionSDkConfig checkLocalAppList  run");
            b.a();
        }
    }

    /* renamed from: cn.vlion.ad.inland.core.init.b$b */
    public interface InterfaceC0029b {
    }

    public static void a(d0.a aVar) {
        String str;
        try {
            LogVlion.e("VlionSDkConfig getConfig  isHaveData=" + VlionServiceConfigParse.getInstance().isHaveData());
            if (aVar != null) {
                if (VlionServiceConfigParse.getInstance().isHaveData()) {
                    LogVlion.e("VlionSDkConfig local have  isExpire=" + VlionServiceConfigParse.getInstance().isExpire());
                    if (!VlionServiceConfigParse.getInstance().isExpire()) {
                        aVar.a();
                        return;
                    } else if (VlionSharedPreferences.getInstance().getStrategysIdRreshdate()) {
                        aVar.a();
                        str = "VlionSDkConfig getConfigNetWork  同一天不过期 异步调用 刷新 ";
                    } else {
                        f3636a = null;
                        LogVlion.e("VlionSDkConfig getConfigNetWork  过期 同步调用 刷新 ");
                    }
                } else {
                    f3636a = null;
                }
                b(aVar);
                return;
            }
            LogVlion.e("VlionSDkConfig getConfig  local data");
            VlionServiceConfig configData = VlionConfigSharedPreferences.getInstance().getConfigData();
            f3636a = null;
            if (configData != null) {
                LogVlion.e("VlionSDkConfig getConfig  have local data");
                VlionServiceConfigParse.getInstance().Parse("", configData);
                b(null);
            }
            str = "VlionSDkConfig getConfig  have no local data";
            LogVlion.e(str);
            b(null);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void b() {
        try {
            VlionTimer.getInstance().startTimer(0L, new a());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void a() {
        List<String> list;
        try {
            if (VlionPrivateInfo.isCanReadAppList()) {
                WeakReference<List<String>> weakReference = f3636a;
                if (weakReference == null || weakReference.get() == null) {
                    list = VlionDeviceInfo.getInstance().getInstalledPackages(VlionSDkManager.getInstance().getApplication());
                    f3636a = new WeakReference<>(list);
                } else {
                    list = f3636a.get();
                }
            } else {
                list = null;
            }
            List<VlionServiceConfig.DataBean.ActiveStrategyBean> activeStrategy = VlionServiceConfigParse.getInstance().getActiveStrategy();
            StrategysIdUtils.getInstance().InitVlionSDKConfig(list, activeStrategy);
            LogVlion.e("VlionSDkConfig checkLocalInStallList  serviceActiveStrategyList.size()=" + activeStrategy.size());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void b(d0.a aVar) {
        try {
            if (TextUtils.isEmpty(VlionSDkManager.getInstance().getAppId())) {
                LogVlion.e("VlionSDkConfig getConfigNetWork  AppId is empty");
                if (aVar != null) {
                    aVar.a(VlionAdBaseError.AD_APP_ID_IS_EMPTY);
                    return;
                }
                return;
            }
            if (!TextUtils.isEmpty(VlionSDkManager.getInstance().getAppKey())) {
                LogVlion.e("VlionSDkConfig getConfigNetWork ");
                VlionAdStrategyUtils.getInstance().regroupAdStrategysIdList(VlionSDkManager.getInstance().getApplication());
                p.a(VlionSDkManager.getInstance().getAppId(), VlionSDkManager.getInstance().getAppKey(), new cn.vlion.ad.inland.core.init.a(aVar));
            } else {
                LogVlion.e("VlionSDkConfig getConfigNetWork  appKey is empty");
                if (aVar != null) {
                    aVar.a(VlionAdBaseError.AD_APP_KEY_IS_EMPTY);
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
