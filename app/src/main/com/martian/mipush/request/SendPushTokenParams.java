package com.martian.mipush.request;

import com.martian.libmars.comm.request.MTHttpPostParams;
import v8.c;

/* loaded from: classes3.dex */
public class SendPushTokenParams extends MTHttpPostParams {

    @c
    private String pushChannel;

    @c
    private String regId;

    public SendPushTokenParams() {
        super(new PushUrlProvider());
    }

    public String getPushChannel() {
        return this.pushChannel;
    }

    public String getRegId() {
        return this.regId;
    }

    @Override // u8.b
    public String getRequestMethod() {
        return "regIds";
    }

    public void setPushChannel(String str) {
        this.pushChannel = str;
    }

    public void setRegId(String str) {
        this.regId = str;
    }
}
