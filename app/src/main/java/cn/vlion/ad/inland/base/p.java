package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final /* synthetic */ class p {
    public static void a(Throwable th2, String str, Throwable th3) {
        VlionSDkManager.getInstance().upLoadCatchException(th2);
        LogVlion.e(str + th3);
    }
}
