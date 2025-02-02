package com.alibaba.android.arouter.facade.template;

/* loaded from: classes.dex */
public interface ILogger {
    public static final String defaultTag = "ARouter::";
    public static final boolean isShowLog = false;
    public static final boolean isShowStackTrace = false;

    void debug(String str, String str2);

    void error(String str, String str2);

    void error(String str, String str2, Throwable th2);

    String getDefaultTag();

    void info(String str, String str2);

    boolean isMonitorMode();

    void monitor(String str);

    void showLog(boolean z10);

    void showStackTrace(boolean z10);

    void warning(String str, String str2);
}
