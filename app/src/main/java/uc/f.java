package uc;

import android.util.Log;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.application.MiConfigSingleton;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* loaded from: classes3.dex */
public class f {

    /* renamed from: f */
    public static volatile f f30982f = null;

    /* renamed from: g */
    public static final String f30983g = "f";

    /* renamed from: h */
    public static final long f30984h = 5000;

    /* renamed from: i */
    public static final long f30985i = 30000;

    /* renamed from: j */
    public static final long f30986j = 30000;

    /* renamed from: k */
    public static final long f30987k = 35000;

    /* renamed from: a */
    public Retrofit f30988a;

    /* renamed from: b */
    public Retrofit f30989b;

    /* renamed from: d */
    public s8.a f30991d;

    /* renamed from: c */
    public long f30990c = 0;

    /* renamed from: e */
    public boolean f30992e = s8.b.f30606b;

    public static f f() {
        if (f30982f == null) {
            synchronized (f.class) {
                try {
                    if (f30982f == null) {
                        f30982f = new f();
                    }
                } finally {
                }
            }
        }
        return f30982f;
    }

    public static /* synthetic */ void l(String str) {
        Log.d(f30983g, str);
    }

    public final synchronized void b() {
        try {
            if (this.f30988a != null) {
                this.f30988a = null;
            }
            if (this.f30989b != null) {
                this.f30989b = null;
            }
            this.f30988a = new Retrofit.Builder().addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).baseUrl(c()).client(g()).build();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final String c() {
        return ConfigSingleton.D().J0() ? "http://testtfbook.taoyuewenhua.net/" : ConfigSingleton.D().z0() ? "http://betatfbook.taoyuewenhua.net/" : s8.b.f30606b ? s8.b.f30614j : s8.b.f30613i;
    }

    public s8.a d() {
        if (this.f30991d == null) {
            this.f30991d = new s8.a();
        }
        return this.f30991d;
    }

    public final Interceptor e() {
        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() { // from class: uc.e
            @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
            public final void log(String str) {
                f.l(str);
            }
        }).setLevel(MiConfigSingleton.b2().B0() ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
    }

    public final OkHttpClient g() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builder.connectTimeout(5000L, timeUnit).readTimeout(30000L, timeUnit).writeTimeout(30000L, timeUnit).callTimeout(f30987k, timeUnit).dns(new z8.a());
        builder.interceptors().add(d());
        builder.interceptors().add(new wc.c());
        builder.interceptors().add(new wc.b());
        builder.interceptors().add(new wc.d());
        builder.interceptors().add(e());
        return builder.build();
    }

    public <T> T h(Class<T> cls) {
        if (s8.b.f30606b != this.f30992e) {
            synchronized (this) {
                try {
                    if (s8.b.f30606b != this.f30992e) {
                        b();
                        this.f30992e = !this.f30992e;
                    }
                } finally {
                }
            }
        }
        return (T) this.f30988a.create(cls);
    }

    public final String i() {
        return ConfigSingleton.D().J0() ? s8.b.f30627w : ConfigSingleton.D().z0() ? s8.b.f30628x : s8.b.f30629y;
    }

    public <T> T j(Class<T> cls) {
        if (this.f30989b == null) {
            this.f30989b = new Retrofit.Builder().addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).baseUrl(i()).client(g()).build();
        }
        return (T) this.f30989b.create(cls);
    }

    public void k() {
        b();
    }
}
