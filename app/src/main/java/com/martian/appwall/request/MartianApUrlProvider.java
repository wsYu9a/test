package com.martian.appwall.request;

import com.martian.libmars.c.d;
import com.martian.libmars.d.h;

/* loaded from: classes2.dex */
public class MartianApUrlProvider extends d {
    @Override // com.martian.libcomm.http.requests.c
    public String getBaseUrl() {
        return h.F().Q0() ? "http://testap.taoyuewenhua.com/" : h.F().G0() ? "http://betaap.taoyuewenhua.com/" : "https://ap.taoyuewenhua.com/";
    }
}
