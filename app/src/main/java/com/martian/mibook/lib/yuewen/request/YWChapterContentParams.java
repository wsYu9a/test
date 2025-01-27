package com.martian.mibook.lib.yuewen.request;

import com.martian.libcomm.http.requests.d.a;
import com.martian.mibook.lib.account.request.TYHttpGetParams;

/* loaded from: classes4.dex */
public class YWChapterContentParams extends TYHttpGetParams {

    @a
    private Boolean autoBuy;

    @a
    private String cbid;

    @a
    private Long ccid;

    public Boolean getAutoBuy() {
        return this.autoBuy;
    }

    public String getCbid() {
        return this.cbid;
    }

    public Long getCcid() {
        return this.ccid;
    }

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "authopt/yw/chapter_content";
    }

    public void setAutoBuy(Boolean autoBuy) {
        this.autoBuy = autoBuy;
    }

    public void setCbid(String cbid) {
        this.cbid = cbid;
    }

    public void setCcid(Long ccid) {
        this.ccid = ccid;
    }
}
