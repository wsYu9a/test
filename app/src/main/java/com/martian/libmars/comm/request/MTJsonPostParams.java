package com.martian.libmars.comm.request;

import okhttp3.RequestBody;
import u8.c;

/* loaded from: classes3.dex */
public class MTJsonPostParams extends MTHttpPostParams {
    private MTRequest request;

    public MTJsonPostParams() {
        super(null);
    }

    @Override // u8.b
    public c getProvider() {
        return this.request.getProvider();
    }

    public MTRequest getRequest() {
        return this.request;
    }

    @Override // u8.b
    public String getRequestMethod() {
        return this.request.getRequestMethod();
    }

    public void setRequest(MTRequest mTRequest) {
        this.request = mTRequest;
    }

    @Override // u8.b
    public RequestBody toPostContent(String str) {
        return this.request.toPostContent(str);
    }
}
