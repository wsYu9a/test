package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.network.HttpCallBack;
import cn.vlion.ad.inland.base.network.ok.HttpRequestUtil;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class f4 {
    public static void a(int i10, VlionAdapterADConfig vlionAdapterADConfig, HttpCallBack httpCallBack) {
        try {
            LogVlion.e("VlionCustomNetWorkProxy getVlionAdData");
            if (vlionAdapterADConfig == null) {
                LogVlion.e("VlionCustomNetWorkProxy getVlionAdData: vlionAdapterADConfig is null");
                return;
            }
            String a10 = z.a(vlionAdapterADConfig, i10);
            StringBuilder sb2 = new StringBuilder();
            VlionSDkManager.getInstance().isSdkDebug();
            sb2.append("https://bid-adx2.vlion.cn/main?");
            sb2.append("media=");
            sb2.append(vlionAdapterADConfig.getAppId());
            String sb3 = sb2.toString();
            HttpRequestUtil.getVlionAdData(a10, sb3, new e4(sb3, httpCallBack));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
