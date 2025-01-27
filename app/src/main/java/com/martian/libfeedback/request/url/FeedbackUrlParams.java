package com.martian.libfeedback.request.url;

import v8.a;

/* loaded from: classes3.dex */
public class FeedbackUrlParams extends FeedbacklUrlHttpGetParams {

    @a
    private boolean enableNotification;

    @Override // u8.b
    public String getRequestMethod() {
        return "#/feedback/categories";
    }

    public boolean isEnableNotification() {
        return this.enableNotification;
    }

    public void setEnableNotification(boolean z10) {
        this.enableNotification = z10;
    }
}
