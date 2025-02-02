package com.bytedance.pangle.log;

import androidx.annotation.Keep;

@Keep
/* loaded from: classes2.dex */
public interface IZeusLogger {
    void e(String str, String str2, Throwable th2);

    void i(String str, String str2);

    void v(String str, String str2);

    void w(String str, String str2);

    void w(String str, String str2, Throwable th2);
}
