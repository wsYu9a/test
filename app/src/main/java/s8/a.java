package s8;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import xi.k;

/* loaded from: classes3.dex */
public final class a implements Interceptor {
    public final void a(Response response) {
        if (response == null || response.code() == 200 || response.code() == 302 || response.code() == 304 || response.code() == 500) {
            return;
        }
        b.f30606b = true;
    }

    public final boolean b(String str) {
        return StringsKt.contains$default((CharSequence) str, (CharSequence) "book.taoyuewenhua.net", false, 2, (Object) null);
    }

    @Override // okhttp3.Interceptor
    @k
    public Response intercept(@k Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        if (!b(request.url().host())) {
            return chain.proceed(request);
        }
        Response proceed = chain.proceed(request);
        a(proceed);
        return proceed;
    }
}
