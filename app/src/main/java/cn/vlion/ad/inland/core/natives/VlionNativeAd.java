package cn.vlion.ad.inland.core.natives;

import android.content.Context;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.core.config.VlionSlotConfig;
import cn.vlion.ad.inland.core.d;
import cn.vlion.ad.inland.core.g0;

/* loaded from: classes.dex */
public class VlionNativeAd {
    public static void fetchFeedsAd(Context context, VlionSlotConfig vlionSlotConfig, VlionNativeADListener vlionNativeADListener) {
        try {
            new g0(context).a(d.a(vlionSlotConfig, 2), vlionNativeADListener);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
