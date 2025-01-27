package cn.vlion.ad.inland.base;

import android.text.TextUtils;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class m1 {
    public static i1 a(VlionAdapterADConfig vlionAdapterADConfig) {
        if (vlionAdapterADConfig != null) {
            try {
                String appId = vlionAdapterADConfig.getAppId();
                String slotID = vlionAdapterADConfig.getSlotID();
                if (TextUtils.isEmpty(appId)) {
                    return i1.f2916f;
                }
                if (TextUtils.isEmpty(slotID)) {
                    return i1.f2917g;
                }
                return null;
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
        return null;
    }
}
