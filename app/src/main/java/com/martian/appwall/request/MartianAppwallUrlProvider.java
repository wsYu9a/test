package com.martian.appwall.request;

import com.martian.libmars.c.d;
import com.martian.libmars.d.h;

/* loaded from: classes2.dex */
public class MartianAppwallUrlProvider extends d {
    @Override // com.martian.libcomm.http.requests.c
    public String getBaseUrl() {
        return h.F().Q0() ? "http://testappwall.taoyuewenhua.net/" : h.F().G0() ? "http://betaappwall.taoyuewenhua.net/" : "https://appwall.taoyuewenhua.net/";
    }
}
