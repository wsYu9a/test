package com.martian.libfeedback.request.url;

import com.martian.libcomm.http.requests.d.a;

/* loaded from: classes2.dex */
public class MessageUrlParams extends FeedbacklUrlHttpGetParams {

    @a
    private Integer lastNid;

    public Integer getLastNid() {
        Integer num = this.lastNid;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "#/messages";
    }

    public void setLastNid(Integer lastNid) {
        this.lastNid = lastNid;
    }
}
