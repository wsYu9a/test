package com.czhj.volley;

/* loaded from: classes2.dex */
public class NetworkError extends VolleyError {
    public NetworkError() {
    }

    public NetworkError(NetworkResponse networkResponse) {
        super(networkResponse);
    }

    public NetworkError(Throwable th2) {
        super(th2);
    }
}
