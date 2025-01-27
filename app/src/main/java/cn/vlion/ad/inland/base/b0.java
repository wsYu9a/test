package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class b0 {
    public static String a(i0 i0Var) {
        if (i0Var == null) {
            return "";
        }
        try {
            return i0Var.b();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return "";
        }
    }
}
