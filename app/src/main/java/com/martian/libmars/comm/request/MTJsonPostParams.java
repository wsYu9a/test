package com.martian.libmars.comm.request;

import com.martian.libcomm.http.requests.c;
import okhttp3.RequestBody;

/* loaded from: classes2.dex */
public class MTJsonPostParams extends MTHttpPostParams {
    private MTRequest request;

    public MTJsonPostParams() {
        super(null);
    }

    @Override // com.martian.libcomm.http.requests.b
    public c getProvider() {
        return this.request.getProvider();
    }

    public MTRequest getRequest() {
        return this.request;
    }

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return this.request.getRequestMethod();
    }

    public void setRequest(MTRequest request) {
        this.request = request;
    }

    @Override // com.martian.libcomm.http.requests.b
    public RequestBody toPostContent(String charset) {
        return this.request.toPostContent(charset);
    }
}
