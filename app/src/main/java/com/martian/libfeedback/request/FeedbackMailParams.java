package com.martian.libfeedback.request;

import com.martian.libcomm.http.requests.d.c;

/* loaded from: classes2.dex */
public class FeedbackMailParams extends FeedbacklTaskHttpPostParams {

    @c
    private String mail;

    public String getMail() {
        return this.mail;
    }

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "auth/feedback/apply_user_info";
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
