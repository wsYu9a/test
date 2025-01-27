package cn.vlion.ad.inland.base.util;

import android.content.Context;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public class DensityUtil {
    public static int dip2px(Context context, float f10) {
        if (context == null) {
            return 0;
        }
        try {
            return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return 0;
        }
    }

    public static int px2dip(Context context, float f10) {
        if (context == null) {
            return 0;
        }
        try {
            return (int) ((f10 / context.getResources().getDisplayMetrics().density) + 0.5f);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return 0;
        }
    }
}
