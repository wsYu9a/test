package com.martian.libfeedback.request;

import v8.a;

/* loaded from: classes3.dex */
public class MessagesParams extends FeedbacklTaskHttpGetParams {

    @a
    private Integer page;

    @a
    private Integer pageSize = 5;

    public Integer getPage() {
        Integer num = this.page;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer getPageSize() {
        Integer num = this.pageSize;
        return Integer.valueOf(num == null ? 5 : num.intValue());
    }

    @Override // u8.b
    public String getRequestMethod() {
        return "push/history";
    }

    public void setPage(Integer num) {
        this.page = num;
    }

    public void setPageSize(Integer num) {
        this.pageSize = num;
    }
}
