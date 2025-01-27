package com.alimm.tanx.core.net.okhttp.tanxc_if;

import java.io.IOException;
import m5.c;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;

/* loaded from: classes.dex */
public class tanxc_do implements Interceptor {

    /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_if.tanxc_do$1 */
    public class AnonymousClass1 extends RequestBody {
        final /* synthetic */ RequestBody tanxc_do;

        public AnonymousClass1(RequestBody requestBody) {
            requestBody = requestBody;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() {
            return -1L;
        }

        @Override // okhttp3.RequestBody
        /* renamed from: contentType */
        public MediaType getContentType() {
            return requestBody.getContentType();
        }

        @Override // okhttp3.RequestBody
        public void writeTo(BufferedSink bufferedSink) throws IOException {
            BufferedSink buffer = Okio.buffer(new GzipSink(bufferedSink));
            requestBody.writeTo(buffer);
            buffer.close();
        }
    }

    private RequestBody tanxc_do(RequestBody requestBody) {
        return new RequestBody() { // from class: com.alimm.tanx.core.net.okhttp.tanxc_if.tanxc_do.1
            final /* synthetic */ RequestBody tanxc_do;

            public AnonymousClass1(RequestBody requestBody2) {
                requestBody = requestBody2;
            }

            @Override // okhttp3.RequestBody
            public long contentLength() {
                return -1L;
            }

            @Override // okhttp3.RequestBody
            /* renamed from: contentType */
            public MediaType getContentType() {
                return requestBody.getContentType();
            }

            @Override // okhttp3.RequestBody
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                BufferedSink buffer = Okio.buffer(new GzipSink(bufferedSink));
                requestBody.writeTo(buffer);
                buffer.close();
            }
        };
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        return (request.body() == null || request.header(c.f28293b0) != null) ? chain.proceed(request) : chain.proceed(request.newBuilder().method(request.method(), tanxc_do(request.body())).build());
    }
}
