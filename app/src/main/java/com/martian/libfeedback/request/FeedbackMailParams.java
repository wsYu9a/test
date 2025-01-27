package com.martian.libfeedback.request;

import v8.c;

/* loaded from: classes3.dex */
public class FeedbackMailParams extends FeedbacklTaskHttpPostParams {

    @c
    private String mail;

    public String getMail() {
        return this.mail;
    }

    @Override // u8.b
    public String getRequestMethod() {
        return "auth/feedback/apply_user_info";
    }

    public void setMail(String str) {
        this.mail = str;
    }
}
