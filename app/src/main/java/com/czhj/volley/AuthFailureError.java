package com.czhj.volley;

import android.content.Intent;

/* loaded from: classes2.dex */
public class AuthFailureError extends VolleyError {

    /* renamed from: b */
    public Intent f8700b;

    public AuthFailureError() {
    }

    @Override // com.czhj.volley.VolleyError, java.lang.Throwable
    public String getMessage() {
        return this.f8700b != null ? "User needs to (re)enter credentials." : super.getMessage();
    }

    public Intent getResolutionIntent() {
        return this.f8700b;
    }

    public AuthFailureError(Intent intent) {
        this.f8700b = intent;
    }

    public AuthFailureError(NetworkResponse networkResponse) {
        super(networkResponse);
    }

    public AuthFailureError(String str) {
        super(str);
    }

    public AuthFailureError(String str, Exception exc) {
        super(str, exc);
    }
}
