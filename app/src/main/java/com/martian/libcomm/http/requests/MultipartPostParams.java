package com.martian.libcomm.http.requests;

import org.apache.http.entity.mime.MultipartEntity;

/* loaded from: classes2.dex */
public abstract class MultipartPostParams extends HttpPostParams {

    /* renamed from: a */
    private String f9720a;

    public MultipartPostParams(c provider) {
        super(provider);
        this.f9720a = "application/octet-stream";
    }

    public MultipartEntity a(String charset) {
        return a.h(this, this.f9720a, charset);
    }

    public void b(String fileContentType) {
        this.f9720a = fileContentType;
    }
}
