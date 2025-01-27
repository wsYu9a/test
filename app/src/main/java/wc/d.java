package wc;

import java.util.Date;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import xi.k;

/* loaded from: classes3.dex */
public final class d implements Interceptor {

    /* renamed from: a */
    public long f31691a = Long.MAX_VALUE;

    public final void a(long j10, String str) {
        Date a10;
        if (str == null || j10 >= this.f31691a || (a10 = defpackage.a.a(str)) == null) {
            return;
        }
        xc.a.f31995a.b(a10.getTime());
        this.f31691a = j10;
    }

    @Override // okhttp3.Interceptor
    @k
    public Response intercept(@k Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        long nanoTime = System.nanoTime();
        Response proceed = chain.proceed(request);
        a(System.nanoTime() - nanoTime, proceed.headers().get(m5.c.f28298d));
        return proceed;
    }
}
