package com.martian.libfeedback.request.url;

import v8.a;

/* loaded from: classes3.dex */
public class MessageUrlParams extends FeedbacklUrlHttpGetParams {

    @a
    private Integer lastNid;

    public Integer getLastNid() {
        Integer num = this.lastNid;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    @Override // u8.b
    public String getRequestMethod() {
        return "#/messages";
    }

    public void setLastNid(Integer num) {
        this.lastNid = num;
    }
}
