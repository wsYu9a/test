package com.martian.mibook.lib.account.request.auth;

import com.martian.libcomm.http.requests.d.a;

/* loaded from: classes3.dex */
public class StartExtraBonusParams extends TYAuthParams {

    @a
    private Long extraId;

    @Override // com.martian.mibook.lib.account.request.auth.TYAuthParams
    public String getAuthMethod() {
        return "start_extra_task.do";
    }

    public Long getExtraId() {
        return this.extraId;
    }

    public void setExtraId(Long extraId) {
        this.extraId = extraId;
    }
}
