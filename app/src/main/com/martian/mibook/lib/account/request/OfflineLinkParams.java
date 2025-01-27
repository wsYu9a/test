package com.martian.mibook.lib.account.request;

import v8.a;

/* loaded from: classes3.dex */
public class OfflineLinkParams extends TYBookHttpGetParams {

    @a
    private final int hideNaviBar = 1;

    @a
    private int notchHeight = 0;

    @a
    private int ctype = 0;

    @Override // u8.b
    public String getRequestMethod() {
        return "offline_notification";
    }

    public void setCtype(int i10) {
        this.ctype = i10;
    }

    public void setNotchHeight(int i10) {
        this.notchHeight = i10;
    }
}
