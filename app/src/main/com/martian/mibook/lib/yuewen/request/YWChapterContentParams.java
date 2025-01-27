package com.martian.mibook.lib.yuewen.request;

import com.martian.mibook.lib.account.request.TYHttpGetParams;
import v8.a;

/* loaded from: classes3.dex */
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

    @Override // u8.b
    public String getRequestMethod() {
        return "authopt/yw/chapter_content";
    }

    public void setAutoBuy(Boolean bool) {
        this.autoBuy = bool;
    }

    public void setCbid(String str) {
        this.cbid = str;
    }

    public void setCcid(Long l10) {
        this.ccid = l10;
    }
}
