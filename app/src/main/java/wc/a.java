package wc;

import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import xi.k;
import xi.l;

/* loaded from: classes3.dex */
public final class a implements Interceptor {

    /* renamed from: a */
    @k
    public String f31689a;

    /* renamed from: b */
    @l
    public String f31690b;

    public a(@k String originalBaseUrl) {
        Intrinsics.checkNotNullParameter(originalBaseUrl, "originalBaseUrl");
        this.f31689a = originalBaseUrl;
    }

    @Override // okhttp3.Interceptor
    @k
    public Response intercept(@k Interceptor.Chain chain) {
        HttpUrl parse;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        HttpUrl.Companion companion = HttpUrl.INSTANCE;
        if (!Intrinsics.areEqual(companion.get(this.f31689a).host(), request.url().host())) {
            return chain.proceed(request);
        }
        String str = this.f31690b;
        String host = (str == null || (parse = companion.parse(str)) == null) ? null : parse.host();
        if (host != null) {
            return chain.proceed(request.newBuilder().url(request.url().newBuilder().host(host).build()).build());
        }
        Response proceed = chain.proceed(request);
        if (proceed.code() != 200 && proceed.code() != 302 && proceed.code() != 304) {
            this.f31690b = "http://tfbook.itaoxiaoshuo.com/";
        }
        return proceed;
    }
}
