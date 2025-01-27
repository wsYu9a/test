package com.kwad.components.offline.api.core.api;

/* loaded from: classes3.dex */
public interface ILogcat {
    void d(String str, String str2);

    void e(String str, String str2);

    void e(String str, String str2, Throwable th2);

    void i(String str, String str2);

    void printStackTrace(Throwable th2);

    void printStackTraceOnly(Throwable th2);

    void v(String str, String str2);

    void v(String str, String str2, boolean z10);

    void w(String str, String str2);

    void w(String str, String str2, boolean z10);
}
