package com.czhj.sdk.common.network;

import m5.c;

/* loaded from: classes2.dex */
public enum ResponseHeader {
    LOCATION(c.f28347t0),
    USER_AGENT("User-Agent"),
    ACCEPT_LANGUAGE(c.f28319k);

    private final String key;

    ResponseHeader(String str) {
        this.key = str;
    }

    public String getKey() {
        return this.key;
    }
}
