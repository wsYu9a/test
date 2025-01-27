package fh;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: b */
    public static OkHttpClient f26045b;

    /* renamed from: a */
    public static final MediaType f26044a = MediaType.parse("application/json; charset=utf-8");

    /* renamed from: c */
    public static final Object f26046c = new Object();

    /* renamed from: d */
    public static ExecutorService f26047d = Executors.newCachedThreadPool(new c("pool_c"));

    static {
        Executors.newScheduledThreadPool(2, new c("pool_c_s"));
    }

    public static OkHttpClient a() {
        synchronized (f26046c) {
            try {
                OkHttpClient okHttpClient = f26045b;
                if (okHttpClient != null) {
                    return okHttpClient;
                }
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                OkHttpClient build = builder.connectTimeout(30L, timeUnit).readTimeout(30L, timeUnit).writeTimeout(30L, timeUnit).build();
                f26045b = build;
                return build;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
