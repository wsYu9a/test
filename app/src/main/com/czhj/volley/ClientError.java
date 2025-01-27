package com.czhj.volley;

/* loaded from: classes2.dex */
public class ClientError extends ServerError {

    /* renamed from: b */
    public String f8712b;

    public ClientError() {
    }

    public String getRequest_id() {
        return this.f8712b;
    }

    public ClientError(NetworkResponse networkResponse) {
        super(networkResponse);
    }

    public ClientError(String str, String str2) {
        super(str);
        this.f8712b = str2;
    }
}
