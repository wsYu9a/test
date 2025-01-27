package com.martian.mibook.lib.yuewen.request;

import com.martian.libcomm.http.requests.d.a;
import com.martian.mibook.lib.account.request.TYHttpGetParams;

/* loaded from: classes4.dex */
public class YWChapterListParams extends TYHttpGetParams {

    @a
    private Long cbid;

    @a
    private String token;

    public Long getCbid() {
        return this.cbid;
    }

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "/authopt/yw/chapter_list";
    }

    @Override // com.martian.libmars.comm.request.MTHttpGetParams
    public String getToken() {
        return this.token;
    }

    public void setCbid(Long cbid) {
        this.cbid = cbid;
    }

    @Override // com.martian.libmars.comm.request.MTHttpGetParams
    public void setToken(String token) {
        this.token = token;
    }
}
