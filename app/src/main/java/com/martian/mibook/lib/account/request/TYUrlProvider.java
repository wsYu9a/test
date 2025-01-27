package com.martian.mibook.lib.account.request;

import com.martian.libmars.c.d;
import com.martian.libmars.d.h;

/* loaded from: classes3.dex */
public class TYUrlProvider extends d {
    @Override // com.martian.libcomm.http.requests.c
    public String getBaseUrl() {
        return h.F().Q0() ? "http://testtfbook.taoyuewenhua.net/" : h.F().G0() ? "http://betatfbook.taoyuewenhua.net/" : "http://tfbook.taoyuewenhua.net/";
    }
}
