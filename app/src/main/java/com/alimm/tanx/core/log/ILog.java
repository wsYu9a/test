package com.alimm.tanx.core.log;

import java.util.List;

/* loaded from: classes.dex */
public interface ILog {
    public static final String TAG = "ILog :";

    void uploadLog();

    void write(LogItemBean logItemBean);

    void write(String str, String str2, String str3);

    void write(List<LogItemBean> list);
}
