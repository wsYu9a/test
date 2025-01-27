package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;

/* loaded from: classes4.dex */
public class MultiProcessFlag {

    /* renamed from: a */
    private static boolean f23885a;

    /* renamed from: b */
    private static boolean f23886b;

    public static boolean isMultiProcess() {
        return f23885a;
    }

    public static void setMultiProcess(boolean z) {
        if (f23886b) {
            GDTLogger.w("MultiProcessFlag已经设置过，再次设置无效");
        } else {
            f23886b = true;
            f23885a = z;
        }
    }
}
