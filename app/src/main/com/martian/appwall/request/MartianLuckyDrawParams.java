package com.martian.appwall.request;

import v8.a;

/* loaded from: classes3.dex */
public class MartianLuckyDrawParams extends MartianApBaseParams {

    @a
    private final int hideNaviBar = 1;

    @Override // u8.b
    public String getRequestMethod() {
        return "lucky_draw";
    }
}
