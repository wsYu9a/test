package com.czhj.volley;

/* loaded from: classes2.dex */
public class ParseError extends VolleyError {
    public ParseError() {
    }

    public ParseError(NetworkResponse networkResponse) {
        super(networkResponse);
    }

    public ParseError(Throwable th2) {
        super(th2);
    }
}
