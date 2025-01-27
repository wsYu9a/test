package cn.vlion.ad.inland.core;

import cn.vlion.ad.inland.base.network.ok.HttpRequestUtil;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class p {
    public static void a(String str, String str2, cn.vlion.ad.inland.core.init.a aVar) {
        try {
            LogVlion.e("VlionCoreNetWorkProxy getAdData: ");
            String str3 = VlionSDkManager.getInstance().isSdkDebug() ? "http://api-gray-v3.mentamob.com:8000/api/v1/config" : "https://api-v3.mentamob.com/api/v1/config";
            String a10 = c.a(str, str2);
            HttpRequestUtil.getData(str3, a10, new o(aVar, a10));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
