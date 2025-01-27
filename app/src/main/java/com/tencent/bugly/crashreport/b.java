package com.tencent.bugly.crashreport;

/* loaded from: classes4.dex */
public interface b {
    boolean appendLogToNative(String str, String str2, String str3);

    String getLogFromNative();

    boolean setNativeIsAppForeground(boolean z);
}
