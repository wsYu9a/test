package com.martian.libfeedback.request.url;

import com.martian.libcomm.http.requests.d.a;

/* loaded from: classes2.dex */
public class FeedbackUrlParams extends FeedbacklUrlHttpGetParams {

    @a
    private boolean enableNotification;

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "#/feedback/categories";
    }

    public boolean isEnableNotification() {
        return this.enableNotification;
    }

    public void setEnableNotification(boolean enableNotification) {
        this.enableNotification = enableNotification;
    }
}
