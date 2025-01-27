package com.martian.mibook.lib.account.request;

import com.martian.libcomm.http.requests.c;
import com.martian.libmars.d.h;

/* loaded from: classes3.dex */
public class TYBookUrlProvider extends c {
    @Override // com.martian.libcomm.http.requests.c
    public String getBaseUrl() {
        return h.F().Q0() ? "http://testm.taoyuewenhua.com/" : h.F().G0() ? "http://betam.taoyuewenhua.com/" : "http://m.taoyuewenhua.com/";
    }
}
