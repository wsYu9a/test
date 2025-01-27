package com.martian.free.request;

import com.martian.mibook.lib.account.request.TYHttpGetParams;
import v8.a;

/* loaded from: classes3.dex */
public class TFChapterContentParams extends TYHttpGetParams {

    @a
    private String bid;

    @a
    private String cid;

    public String getBid() {
        return this.bid;
    }

    public String getCid() {
        return this.cid;
    }

    @Override // u8.b
    public String getRequestMethod() {
        return "tf/chapter_content";
    }

    public void setBid(String str) {
        this.bid = str;
    }

    public void setCid(String str) {
        this.cid = str;
    }
}
