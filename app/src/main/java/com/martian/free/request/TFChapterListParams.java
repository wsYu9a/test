package com.martian.free.request;

import com.martian.libcomm.http.requests.d.a;
import com.martian.mibook.lib.account.request.TYHttpGetParams;

/* loaded from: classes2.dex */
public class TFChapterListParams extends TYHttpGetParams {

    @a
    private String bid;

    public String getBid() {
        return this.bid;
    }

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "tf/chapter_list";
    }

    public void setBid(String bid) {
        this.bid = bid;
    }
}
