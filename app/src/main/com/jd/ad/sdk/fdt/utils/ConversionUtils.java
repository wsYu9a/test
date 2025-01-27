package com.jd.ad.sdk.fdt.utils;

import l5.c;

/* loaded from: classes2.dex */
public class ConversionUtils {
    public static double floatToDouble(float f10) {
        try {
            return Double.valueOf(String.valueOf(f10)).doubleValue();
        } catch (Exception unused) {
            return c.f27899e;
        }
    }
}
