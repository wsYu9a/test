package okhttp3.internal.http;

import com.sigmob.sdk.downloader.core.c;
import h3.e;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import xi.k;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000b"}, d2 = {"Lokhttp3/internal/http/HttpMethod;", "", "()V", "invalidatesCache", "", e.f26414s, "", "permitsRequestBody", "redirectsToGet", "redirectsWithBody", "requiresRequestBody", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpMethod {

    @k
    public static final HttpMethod INSTANCE = new HttpMethod();

    private HttpMethod() {
    }

    @JvmStatic
    public static final boolean permitsRequestBody(@k String r12) {
        Intrinsics.checkNotNullParameter(r12, "method");
        return (Intrinsics.areEqual(r12, "GET") || Intrinsics.areEqual(r12, c.f19078a)) ? false : true;
    }

    @JvmStatic
    public static final boolean requiresRequestBody(@k String r12) {
        Intrinsics.checkNotNullParameter(r12, "method");
        return Intrinsics.areEqual(r12, "POST") || Intrinsics.areEqual(r12, "PUT") || Intrinsics.areEqual(r12, "PATCH") || Intrinsics.areEqual(r12, "PROPPATCH") || Intrinsics.areEqual(r12, "REPORT");
    }

    public final boolean invalidatesCache(@k String r22) {
        Intrinsics.checkNotNullParameter(r22, "method");
        return Intrinsics.areEqual(r22, "POST") || Intrinsics.areEqual(r22, "PATCH") || Intrinsics.areEqual(r22, "PUT") || Intrinsics.areEqual(r22, "DELETE") || Intrinsics.areEqual(r22, "MOVE");
    }

    public final boolean redirectsToGet(@k String r22) {
        Intrinsics.checkNotNullParameter(r22, "method");
        return !Intrinsics.areEqual(r22, "PROPFIND");
    }

    public final boolean redirectsWithBody(@k String r22) {
        Intrinsics.checkNotNullParameter(r22, "method");
        return Intrinsics.areEqual(r22, "PROPFIND");
    }
}
