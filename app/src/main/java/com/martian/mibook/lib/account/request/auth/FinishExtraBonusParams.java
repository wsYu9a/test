package com.martian.mibook.lib.account.request.auth;

import com.martian.libcomm.http.requests.d.a;

/* loaded from: classes3.dex */
public class FinishExtraBonusParams extends TYAuthParams {

    @a
    private Long extraId;

    @Override // com.martian.mibook.lib.account.request.auth.TYAuthParams
    public String getAuthMethod() {
        return "finish_extra_task.do";
    }

    public long getExtraId() {
        Long l = this.extraId;
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public void setExtraId(Long extraId) {
        this.extraId = extraId;
    }
}
