package com.bytedance.sdk.openadsdk.api;

/* loaded from: classes2.dex */
public interface TTILog {
    void d(String str, String str2);

    void e(String str, String str2);

    void e(String str, String str2, Throwable th2);

    void e(String str, Throwable th2);

    void flush();

    void forceLogSharding();

    void i(String str, String str2);

    void v(String str, String str2);

    void w(String str, String str2);

    void w(String str, String str2, Throwable th2);

    void w(String str, Throwable th2);
}
