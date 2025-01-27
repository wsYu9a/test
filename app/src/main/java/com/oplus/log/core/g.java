package com.oplus.log.core;

/* loaded from: classes4.dex */
public interface g {
    void logan_debug(boolean z);

    void logan_flush();

    void logan_init(String str, String str2, int i2, String str3, String str4);

    void logan_open(String str);

    void logan_write(int i2, String str, long j2, String str2, long j3);

    void setOnLoganProtocolStatus(i iVar);
}
