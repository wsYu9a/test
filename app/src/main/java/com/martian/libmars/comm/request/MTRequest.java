package com.martian.libmars.comm.request;

import com.martian.libcomm.http.requests.c;
import com.martian.libcomm.utils.GsonUtils;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* loaded from: classes2.dex */
public abstract class MTRequest {
    private c provider;

    public MTRequest(c provider) {
        this.provider = provider;
    }

    public c getProvider() {
        return this.provider;
    }

    public abstract String getRequestMethod();

    public void setProvider(c provider) {
        this.provider = provider;
    }

    public RequestBody toPostContent(String charset) {
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), GsonUtils.c().toJson(this));
    }
}
