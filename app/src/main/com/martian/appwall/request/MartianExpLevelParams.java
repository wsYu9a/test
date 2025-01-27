package com.martian.appwall.request;

import v8.a;

/* loaded from: classes3.dex */
public class MartianExpLevelParams extends MartianApBaseParams {

    @a
    private final int hideNaviBar = 1;

    @a
    private Boolean night_mode;

    public Boolean getNight_mode() {
        return this.night_mode;
    }

    @Override // u8.b
    public String getRequestMethod() {
        return "level_rights.html";
    }

    public void setNight_mode(Boolean bool) {
        this.night_mode = bool;
    }
}
