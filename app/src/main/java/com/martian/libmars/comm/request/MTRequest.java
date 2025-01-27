package com.martian.libmars.comm.request;

import com.martian.libcomm.utils.GsonUtils;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import u8.c;

/* loaded from: classes3.dex */
public abstract class MTRequest {
    private c provider;

    public MTRequest(c cVar) {
        this.provider = cVar;
    }

    public c getProvider() {
        return this.provider;
    }

    public abstract String getRequestMethod();

    public void setProvider(c cVar) {
        this.provider = cVar;
    }

    public RequestBody toPostContent(String str) {
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), GsonUtils.c().toJson(this));
    }
}
