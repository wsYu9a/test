package com.czhj.volley;

/* loaded from: classes2.dex */
public class DefaultRetryPolicy implements RetryPolicy {
    public static final float DEFAULT_BACKOFF_MULT = 0.0f;
    public static final int DEFAULT_CONNECT_TIMEOUT_MS = 5000;
    public static final int DEFAULT_MAX_RETRIES = 2;
    public static final int DEFAULT_TIMEOUT_MS = 5000;

    /* renamed from: a */
    public final int f8713a;

    /* renamed from: b */
    public final float f8714b;

    /* renamed from: c */
    public final int f8715c;

    /* renamed from: d */
    public int f8716d;

    /* renamed from: e */
    public int f8717e;

    public DefaultRetryPolicy() {
        this(5000, 2, 0.0f);
    }

    public float getBackoffMultiplier() {
        return this.f8714b;
    }

    @Override // com.czhj.volley.RetryPolicy
    public int getCurrentConnectTimeoutMs() {
        return this.f8715c;
    }

    @Override // com.czhj.volley.RetryPolicy
    public int getCurrentRetryCount() {
        return this.f8717e;
    }

    @Override // com.czhj.volley.RetryPolicy
    public int getCurrentTimeout() {
        return this.f8716d;
    }

    public boolean hasAttemptRemaining() {
        return this.f8717e <= this.f8713a;
    }

    @Override // com.czhj.volley.RetryPolicy
    public void retry(VolleyError volleyError) throws VolleyError {
        this.f8717e++;
        int i10 = this.f8716d;
        this.f8716d = i10 + ((int) (i10 * this.f8714b));
        if (!hasAttemptRemaining()) {
            throw volleyError;
        }
    }

    public DefaultRetryPolicy(int i10, int i11, float f10) {
        this.f8715c = i10;
        this.f8716d = i10;
        this.f8713a = i11;
        this.f8714b = f10;
    }

    public DefaultRetryPolicy(int i10, int i11, int i12, float f10) {
        this.f8715c = i10;
        this.f8716d = i11;
        this.f8713a = i12;
        this.f8714b = f10;
    }
}
