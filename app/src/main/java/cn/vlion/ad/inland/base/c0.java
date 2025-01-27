package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse;
import cn.vlion.ad.inland.base.util.StrategysIdUtils;
import cn.vlion.ad.inland.base.util.device.VlionDeviceInfo;
import cn.vlion.ad.inland.base.util.init.VlionPrivateInfo;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class c0 implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        try {
            StrategysIdUtils.getInstance().InitVlionSDKConfig(VlionPrivateInfo.isCanReadAppList() ? VlionDeviceInfo.getInstance().getInstalledPackages(VlionSDkManager.getInstance().getApplication()) : null, VlionServiceConfigParse.getInstance().getActiveStrategy());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
