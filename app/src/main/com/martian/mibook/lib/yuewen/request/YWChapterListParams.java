package com.martian.mibook.lib.yuewen.request;

import com.martian.mibook.lib.account.request.TYHttpGetParams;
import v8.a;

/* loaded from: classes3.dex */
public class YWChapterListParams extends TYHttpGetParams {

    @a
    private Long cbid;

    @a
    private Integer retry;

    @a
    private String token;

    public Long getCbid() {
        return this.cbid;
    }

    @Override // u8.b
    public String getRequestMethod() {
        return "/authopt/yw/chapter_list";
    }

    public Integer getRetry() {
        return this.retry;
    }

    @Override // com.martian.libmars.comm.request.MTHttpGetParams
    public String getToken() {
        return this.token;
    }

    public void setCbid(Long l10) {
        this.cbid = l10;
    }

    public void setRetry(Integer num) {
        this.retry = num;
    }

    @Override // com.martian.libmars.comm.request.MTHttpGetParams
    public void setToken(String str) {
        this.token = str;
    }
}
