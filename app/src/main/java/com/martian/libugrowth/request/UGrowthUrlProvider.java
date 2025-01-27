package com.martian.libugrowth.request;

import com.martian.libmars.c.d;
import com.martian.libmars.d.h;

/* loaded from: classes3.dex */
public class UGrowthUrlProvider extends d {
    @Override // com.martian.libcomm.http.requests.c
    public String getBaseUrl() {
        return h.F().Q0() ? "http://testugrowth.taoyuewenhua.net/" : h.F().G0() ? "http://betaugrowth.taoyuewenhua.net/" : "https://ugrowth.taoyuewenhua.net/";
    }
}
