package com.martian.mibook.lib.account.request.auth;

import com.martian.libcomm.http.requests.d.a;

/* loaded from: classes3.dex */
public class UrlMissionParams extends TYAuthParams {

    @a
    private Integer position;

    @a
    private Boolean random = Boolean.FALSE;

    @Override // com.martian.mibook.lib.account.request.auth.TYAuthParams
    public String getAuthMethod() {
        return "url_mission.do";
    }

    public Integer getPosition() {
        Integer num = this.position;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Boolean getRandom() {
        return this.random;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public void setRandom(Boolean random) {
        this.random = random;
    }
}
