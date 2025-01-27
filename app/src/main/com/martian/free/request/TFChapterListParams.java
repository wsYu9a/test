package com.martian.free.request;

import com.martian.mibook.lib.account.request.TYHttpGetParams;
import v8.a;

/* loaded from: classes3.dex */
public class TFChapterListParams extends TYHttpGetParams {

    @a
    private String bid;

    @a
    private Integer retry;

    public String getBid() {
        return this.bid;
    }

    @Override // u8.b
    public String getRequestMethod() {
        return "tf/chapter_list";
    }

    public Integer getRetry() {
        return this.retry;
    }

    public void setBid(String str) {
        this.bid = str;
    }

    public void setRetry(Integer num) {
        this.retry = num;
    }
}
