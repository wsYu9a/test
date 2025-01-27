package com.czhj.volley;

import android.text.TextUtils;

/* loaded from: classes2.dex */
public class VolleyError extends Exception {

    /* renamed from: a */
    public long f8745a;
    protected String errorMsg;
    public final NetworkResponse networkResponse;

    public VolleyError() {
        this.networkResponse = null;
    }

    public void a(long j10) {
        this.f8745a = j10;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return !TextUtils.isEmpty(this.errorMsg) ? this.errorMsg : super.getMessage();
    }

    public long getNetworkTimeMs() {
        return this.f8745a;
    }

    public VolleyError(NetworkResponse networkResponse) {
        this.networkResponse = networkResponse;
        if (networkResponse != null) {
            this.errorMsg = String.format("http request error status code " + networkResponse.statusCode, new Object[0]);
        }
    }

    public VolleyError(String str) {
        super(str);
        this.networkResponse = null;
    }

    public VolleyError(String str, Throwable th2) {
        super(str, th2);
        this.networkResponse = null;
    }

    public VolleyError(Throwable th2) {
        super(th2);
        this.networkResponse = null;
    }
}
