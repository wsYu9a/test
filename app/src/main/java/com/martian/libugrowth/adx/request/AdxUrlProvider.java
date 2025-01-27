package com.martian.libugrowth.adx.request;

import com.martian.libmars.c.d;
import com.martian.libmars.d.h;

/* loaded from: classes3.dex */
public class AdxUrlProvider extends d {
    @Override // com.martian.libcomm.http.requests.c
    public String getBaseUrl() {
        return h.F().Q0() ? "http://testadx.taoyuewenhua.net/" : h.F().G0() ? "http://betaadx.taoyuewenhua.net/" : "https://adx.taoyuewenhua.net/";
    }
}
