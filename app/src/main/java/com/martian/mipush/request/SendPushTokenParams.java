package com.martian.mipush.request;

import com.martian.libcomm.http.requests.d.c;
import com.martian.libmars.comm.request.MTHttpPostParams;

/* loaded from: classes4.dex */
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

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "regIds";
    }

    public void setPushChannel(String pushChannel) {
        this.pushChannel = pushChannel;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }
}
