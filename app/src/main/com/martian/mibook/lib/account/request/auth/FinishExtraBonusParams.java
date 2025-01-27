package com.martian.mibook.lib.account.request.auth;

import v8.a;

/* loaded from: classes3.dex */
public class FinishExtraBonusParams extends TYAuthParams {

    @a
    private Long extraId;

    @Override // com.martian.mibook.lib.account.request.auth.TYAuthParams
    public String getAuthMethod() {
        return "finish_extra_task.do";
    }

    public long getExtraId() {
        Long l10 = this.extraId;
        if (l10 == null) {
            return 0L;
        }
        return l10.longValue();
    }

    public void setExtraId(Long l10) {
        this.extraId = l10;
    }
}
