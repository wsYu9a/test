package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;

/* loaded from: classes3.dex */
public class MultiProcessFlag {

    /* renamed from: a */
    private static boolean f16396a;

    /* renamed from: b */
    private static boolean f16397b;

    public static boolean isMultiProcess() {
        return f16396a;
    }

    public static void setMultiProcess(boolean z10) {
        if (f16397b) {
            GDTLogger.w("MultiProcessFlag已经设置过，再次设置无效");
        } else {
            f16397b = true;
            f16396a = z10;
        }
    }
}
