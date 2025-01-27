package com.martian.libmars.utils;

import android.app.ActivityManager;
import android.content.Context;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/* loaded from: classes2.dex */
public class s0 {

    /* renamed from: a, reason: collision with root package name */
    private static final int f10193a = -32768;

    /* renamed from: b, reason: collision with root package name */
    private static long f10194b = -32768;

    public static long a(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static long b() {
        if (f10194b == -32768) {
            try {
                FileInputStream fileInputStream = new FileInputStream("/proc/meminfo");
                new Properties().load(fileInputStream);
                f10194b = Integer.parseInt(((String) r1.get("MemTotal")).replace("kB", "").trim()) * 1024;
            } catch (IOException unused) {
            }
        }
        return f10194b;
    }
}
