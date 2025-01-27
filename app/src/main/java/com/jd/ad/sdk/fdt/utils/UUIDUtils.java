package com.jd.ad.sdk.fdt.utils;

import java.util.UUID;

/* loaded from: classes2.dex */
public class UUIDUtils {
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
