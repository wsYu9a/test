package com.alimm.tanx.core.net.okhttp;

import android.os.Handler;
import android.os.Looper;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_int;
import com.alimm.tanx.core.net.okhttp.tanxc_if.tanxc_for;
import com.alimm.tanx.core.net.okhttp.tanxc_if.tanxc_if;
import com.alimm.tanx.core.utils.FileUtils;
import com.alimm.tanx.core.utils.LogUtils;
import com.sigmob.sdk.downloader.core.download.g;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;

/* loaded from: classes.dex */
public class tanxc_do {
    private static tanxc_do tanxc_do;
    private static tanxc_do tanxc_if;
    private OkHttpClient tanxc_for;
    private OkHttpClient tanxc_int;
    private final ArrayList<String> tanxc_try = new ArrayList<>();
    private final Handler tanxc_new = new Handler(Looper.getMainLooper());

    /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do$1 */
    public class AnonymousClass1 implements HostnameVerifier {
        public AnonymousClass1() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do$2 */
    public class AnonymousClass2 implements HostnameVerifier {
        public AnonymousClass2() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    private tanxc_do(boolean z10) {
        Cache cache = new Cache(new File(FileUtils.getExternalDir(TanxCoreSdk.getApplication(), 0).getPath() + "/okhttp_cache/"), g.f19256f);
        if (z10) {
            OkHttpClient.Builder hostnameVerifier = new OkHttpClient.Builder().cache(cache).hostnameVerifier(new HostnameVerifier() { // from class: com.alimm.tanx.core.net.okhttp.tanxc_do.1
                public AnonymousClass1() {
                }

                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    return true;
                }
            });
            TimeUnit timeUnit = TimeUnit.SECONDS;
            this.tanxc_int = hostnameVerifier.connectTimeout(10L, timeUnit).readTimeout(10L, timeUnit).writeTimeout(10L, timeUnit).addInterceptor(tanxc_for.tanxc_do()).addNetworkInterceptor(tanxc_if.tanxc_do()).addInterceptor(new com.alimm.tanx.core.net.okhttp.tanxc_if.tanxc_do()).build();
        } else {
            OkHttpClient.Builder hostnameVerifier2 = new OkHttpClient.Builder().cache(cache).hostnameVerifier(new HostnameVerifier() { // from class: com.alimm.tanx.core.net.okhttp.tanxc_do.2
                public AnonymousClass2() {
                }

                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    return true;
                }
            });
            TimeUnit timeUnit2 = TimeUnit.SECONDS;
            this.tanxc_for = hostnameVerifier2.connectTimeout(10L, timeUnit2).readTimeout(10L, timeUnit2).writeTimeout(10L, timeUnit2).addInterceptor(tanxc_for.tanxc_do()).addNetworkInterceptor(tanxc_if.tanxc_do()).build();
        }
    }

    public static com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do tanxc_byte() {
        return new com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do();
    }

    public static tanxc_do tanxc_do() {
        long currentTimeMillis = System.currentTimeMillis();
        if (tanxc_do == null) {
            synchronized (tanxc_do.class) {
                try {
                    if (tanxc_do == null) {
                        tanxc_do = new tanxc_do(false);
                        LogUtils.d("splashTimeConsuming", "new OkHttpUtil ->" + (System.currentTimeMillis() - currentTimeMillis));
                    }
                } finally {
                }
            }
        }
        return tanxc_do;
    }

    public static tanxc_do tanxc_if() {
        if (tanxc_if == null) {
            synchronized (tanxc_do.class) {
                try {
                    if (tanxc_if == null) {
                        tanxc_if = new tanxc_do(true);
                    }
                } finally {
                }
            }
        }
        return tanxc_if;
    }

    public static com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if tanxc_new() {
        return new com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if();
    }

    public static tanxc_int tanxc_try() {
        return new tanxc_int();
    }

    public Handler tanxc_for() {
        return this.tanxc_new;
    }

    public ArrayList<String> tanxc_int() {
        return this.tanxc_try;
    }

    public static com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for tanxc_if(boolean z10) {
        return new com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for(z10);
    }

    public OkHttpClient tanxc_do(boolean z10) {
        if (z10) {
            return this.tanxc_int;
        }
        return this.tanxc_for;
    }

    public void tanxc_do(String str) {
        Dispatcher dispatcher = this.tanxc_for.dispatcher();
        synchronized (dispatcher) {
            try {
                for (Call call : dispatcher.queuedCalls()) {
                    if (str.equals(call.request().tag())) {
                        call.cancel();
                    }
                }
                for (Call call2 : dispatcher.runningCalls()) {
                    if (str.equals(call2.request().tag())) {
                        call2.cancel();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
