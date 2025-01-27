package com.martian.mibook.lib.yuewen.request;

import com.martian.libcomm.http.requests.d.a;
import com.martian.mibook.lib.account.request.TYHttpGetParams;

/* loaded from: classes4.dex */
public class YWBookParams extends TYHttpGetParams {

    @a
    private Long cbid;

    public Long getCbid() {
        return this.cbid;
    }

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "yw/book";
    }

    public void setCbid(Long cbid) {
        this.cbid = cbid;
    }
}
