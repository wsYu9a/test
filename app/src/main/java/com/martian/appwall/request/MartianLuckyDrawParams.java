package com.martian.appwall.request;

import com.martian.libcomm.http.requests.d.a;

/* loaded from: classes2.dex */
public class MartianLuckyDrawParams extends MartianApBaseParams {

    @a
    private final int hideNaviBar = 1;

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "lucky_draw";
    }
}
