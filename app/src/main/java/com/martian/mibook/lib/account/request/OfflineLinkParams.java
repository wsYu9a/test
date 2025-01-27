package com.martian.mibook.lib.account.request;

import com.martian.libcomm.http.requests.d.a;

/* loaded from: classes3.dex */
public class OfflineLinkParams extends TYBookHttpGetParams {

    @a
    private final int hideNaviBar = 1;

    @a
    private int notchHeight = 0;

    @a
    private int ctype = 0;

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "offline_notification";
    }

    public void setCtype(int ctype) {
        this.ctype = ctype;
    }

    public void setNotchHeight(int notchHeight) {
        this.notchHeight = notchHeight;
    }
}
