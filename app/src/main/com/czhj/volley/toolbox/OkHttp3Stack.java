package com.czhj.volley.toolbox;

import android.text.TextUtils;
import com.czhj.volley.AuthFailureError;
import com.czhj.volley.Header;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.ConnectionPool;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes2.dex */
public class OkHttp3Stack extends BaseHttpStack {
    public static final String NETWORK_TIMEOUT = "NETWORK_TIMEOUT";

    /* renamed from: a */
    public final SSLSocketFactory f8828a;

    /* renamed from: b */
    public final OkHttpClient.Builder f8829b;

    /* renamed from: c */
    public final OkHttpClient f8830c;

    /* renamed from: d */
    public Interceptor f8831d = new Interceptor() { // from class: com.czhj.volley.toolbox.OkHttp3Stack.1
        public AnonymousClass1() {
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            try {
                Request request = chain.request();
                int connectTimeoutMillis = chain.getConnectTimeoutMillis();
                int readTimeoutMillis = chain.readTimeoutMillis();
                int writeTimeoutMillis = chain.writeTimeoutMillis();
                String header = request.header(OkHttp3Stack.NETWORK_TIMEOUT);
                if (!TextUtils.isEmpty(header)) {
                    connectTimeoutMillis = Integer.valueOf(header).intValue();
                }
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                return chain.withConnectTimeout(connectTimeoutMillis, timeUnit).withReadTimeout(readTimeoutMillis, timeUnit).withWriteTimeout(writeTimeoutMillis, timeUnit).proceed(request);
            } catch (Throwable unused) {
                return chain.proceed(chain.request());
            }
        }
    };

    /* renamed from: com.czhj.volley.toolbox.OkHttp3Stack$1 */
    public class AnonymousClass1 implements Interceptor {
        public AnonymousClass1() {
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            try {
                Request request = chain.request();
                int connectTimeoutMillis = chain.getConnectTimeoutMillis();
                int readTimeoutMillis = chain.readTimeoutMillis();
                int writeTimeoutMillis = chain.writeTimeoutMillis();
                String header = request.header(OkHttp3Stack.NETWORK_TIMEOUT);
                if (!TextUtils.isEmpty(header)) {
                    connectTimeoutMillis = Integer.valueOf(header).intValue();
                }
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                return chain.withConnectTimeout(connectTimeoutMillis, timeUnit).withReadTimeout(readTimeoutMillis, timeUnit).withWriteTimeout(writeTimeoutMillis, timeUnit).proceed(request);
            } catch (Throwable unused) {
                return chain.proceed(chain.request());
            }
        }
    }

    public OkHttp3Stack() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        this.f8829b = builder;
        builder.connectionPool(new ConnectionPool());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builder.connectTimeout(5000L, timeUnit);
        builder.readTimeout(5000L, timeUnit);
        builder.writeTimeout(5000L, timeUnit);
        builder.addInterceptor(this.f8831d);
        this.f8828a = null;
        this.f8830c = builder.build();
    }

    public static RequestBody a(com.czhj.volley.Request request) throws AuthFailureError {
        byte[] body = request.getBody();
        if (body == null) {
            return null;
        }
        return RequestBody.create(MediaType.parse(request.getBodyContentType()), body);
    }

    @Override // com.czhj.volley.toolbox.BaseHttpStack
    public HttpResponse executeRequest(com.czhj.volley.Request<?> request, Map<String, String> map) throws IOException, AuthFailureError {
        Request.Builder builder = new Request.Builder();
        builder.url(request.getUrl());
        Map<String, String> headers = request.getHeaders();
        builder.addHeader(NETWORK_TIMEOUT, request.getRetryPolicy().getCurrentTimeout() + "");
        for (String str : headers.keySet()) {
            String str2 = headers.get(str);
            if (TextUtils.isEmpty(str2)) {
                builder.removeHeader(str);
            } else {
                builder.addHeader(str, str2);
            }
        }
        for (String str3 : map.keySet()) {
            String str4 = map.get(str3);
            if (TextUtils.isEmpty(str4)) {
                builder.removeHeader(str3);
            } else {
                builder.addHeader(str3, str4);
            }
        }
        a(builder, request);
        Response execute = this.f8830c.newCall(builder.build()).execute();
        int code = execute.code();
        ResponseBody body = execute.body();
        return new HttpResponse(code, a(execute.headers()), body == null ? 0 : (int) body.getContentLength(), body == null ? null : body.byteStream());
    }

    public OkHttp3Stack(SSLSocketFactory sSLSocketFactory) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        this.f8829b = builder;
        builder.connectionPool(new ConnectionPool());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builder.connectTimeout(5000L, timeUnit);
        builder.readTimeout(5000L, timeUnit);
        builder.writeTimeout(5000L, timeUnit);
        builder.addInterceptor(this.f8831d);
        this.f8828a = sSLSocketFactory;
        this.f8830c = builder.build();
    }

    public final List<Header> a(Headers headers) {
        ArrayList arrayList = new ArrayList();
        int size = headers.size();
        for (int i10 = 0; i10 < size; i10++) {
            String name = headers.name(i10);
            String value = headers.value(i10);
            if (name != null) {
                arrayList.add(new Header(name, value));
            }
        }
        return arrayList;
    }

    public static void a(Request.Builder builder, com.czhj.volley.Request<?> request) throws AuthFailureError {
        RequestBody create;
        String str;
        switch (request.getMethod()) {
            case -1:
                byte[] body = request.getBody();
                if (body != null) {
                    create = RequestBody.create(MediaType.parse(request.getBodyContentType()), body);
                    builder.post(create);
                    return;
                }
                return;
            case 0:
                builder.get();
                return;
            case 1:
                create = a(request);
                builder.post(create);
                return;
            case 2:
                builder.put(a(request));
                return;
            case 3:
                builder.delete(a(request));
                return;
            case 4:
                builder.head();
                return;
            case 5:
                str = "OPTIONS";
                builder.method(str, null);
                return;
            case 6:
                str = "TRACE";
                builder.method(str, null);
                return;
            case 7:
                builder.patch(a(request));
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }
}
