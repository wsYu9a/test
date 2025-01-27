package com.martian.free.request;

import com.martian.libcomm.http.requests.d.a;
import com.martian.mibook.lib.account.request.TYHttpGetParams;

/* loaded from: classes2.dex */
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

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "tf/chapter_content";
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
}
