package com.martian.mibook.lib.yuewen.request;

import com.martian.mibook.lib.account.request.TYHttpGetParams;
import v8.a;

/* loaded from: classes3.dex */
public class YWBookParams extends TYHttpGetParams {

    @a
    private Long cbid;

    public Long getCbid() {
        return this.cbid;
    }

    @Override // u8.b
    public String getRequestMethod() {
        return "yw/book";
    }

    public void setCbid(Long l10) {
        this.cbid = l10;
    }
}
