package com.martian.libfeedback.request;

import com.martian.libcomm.http.requests.d.a;

/* loaded from: classes2.dex */
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

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "push/history";
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
