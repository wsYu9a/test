package okhttp3.internal.http;

import kotlin.Metadata;
import okhttp3.Interceptor;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lokhttp3/internal/http/CallServerInterceptor;", "Lokhttp3/Interceptor;", "forWebSocket", "", "(Z)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "shouldIgnoreAndWaitForRealResponse", "code", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CallServerInterceptor implements Interceptor {
    private final boolean forWebSocket;

    public CallServerInterceptor(boolean z10) {
        this.forWebSocket = z10;
    }

    private final boolean shouldIgnoreAndWaitForRealResponse(int code) {
        if (code == 100) {
            return true;
        }
        return 102 <= code && code < 200;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e4 A[Catch: IOException -> 0x00b7, TryCatch #2 {IOException -> 0x00b7, blocks: (B:65:0x00a9, B:67:0x00b2, B:22:0x00ba, B:24:0x00e4, B:26:0x00ed, B:27:0x00f0, B:28:0x0114, B:32:0x011f, B:33:0x013e, B:35:0x014c, B:43:0x0162, B:48:0x0175, B:51:0x0198, B:52:0x01a2, B:60:0x0190, B:61:0x016b, B:62:0x0157, B:63:0x012e), top: B:64:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0175 A[Catch: IOException -> 0x00b7, TryCatch #2 {IOException -> 0x00b7, blocks: (B:65:0x00a9, B:67:0x00b2, B:22:0x00ba, B:24:0x00e4, B:26:0x00ed, B:27:0x00f0, B:28:0x0114, B:32:0x011f, B:33:0x013e, B:35:0x014c, B:43:0x0162, B:48:0x0175, B:51:0x0198, B:52:0x01a2, B:60:0x0190, B:61:0x016b, B:62:0x0157, B:63:0x012e), top: B:64:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x016b A[Catch: IOException -> 0x00b7, TryCatch #2 {IOException -> 0x00b7, blocks: (B:65:0x00a9, B:67:0x00b2, B:22:0x00ba, B:24:0x00e4, B:26:0x00ed, B:27:0x00f0, B:28:0x0114, B:32:0x011f, B:33:0x013e, B:35:0x014c, B:43:0x0162, B:48:0x0175, B:51:0x0198, B:52:0x01a2, B:60:0x0190, B:61:0x016b, B:62:0x0157, B:63:0x012e), top: B:64:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01ac  */
    /* JADX WARN: Type inference failed for: r9v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v27 */
    @Override // okhttp3.Interceptor
    @xi.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public okhttp3.Response intercept(@xi.k okhttp3.Interceptor.Chain r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 429
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.CallServerInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
