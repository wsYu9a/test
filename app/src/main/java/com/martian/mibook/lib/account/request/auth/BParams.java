package com.martian.mibook.lib.account.request.auth;

import com.martian.libcomm.http.requests.d.a;

/* loaded from: classes3.dex */
public class BParams extends TYAuthParams {

    @a
    private Integer bt;

    @a
    private String extra;

    @Override // com.martian.mibook.lib.account.request.auth.TYAuthParams
    public String getAuthMethod() {
        return "b.do";
    }

    public int getBT() {
        return this.bt.intValue();
    }

    public String getExtra() {
        return this.extra;
    }

    public void setBt(Integer bt) {
        this.bt = bt;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}
