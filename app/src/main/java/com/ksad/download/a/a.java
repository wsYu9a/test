package com.ksad.download.a;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

/* loaded from: classes.dex */
public final class a implements Interceptor {
    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) {
        try {
            return chain.proceed(chain.request());
        } catch (Exception e2) {
            if (e2 instanceof IOException) {
                throw e2;
            }
            throw new IOException(e2);
        }
    }
}
