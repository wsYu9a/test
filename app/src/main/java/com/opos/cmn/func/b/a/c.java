package com.opos.cmn.func.b.a;

import android.content.Context;
import android.text.TextUtils;
import com.heytap.baselib.cloudctrl.database.AreaCode;
import com.heytap.common.iinterface.IAccountCallback;
import com.heytap.httpdns.env.ApiEnv;
import com.heytap.httpdns.env.HttpDnsConfig;
import com.heytap.nearx.taphttp.statitics.StatisticCallback;
import com.heytap.okhttp.extension.HeyConfig;
import com.heytap.okhttp.extension.api.IPv6Config;
import com.heytap.trace.AppTraceConfig;
import com.opos.cmn.func.b.b.a.b;
import com.opos.cmn.func.b.b.a.g;
import com.opos.cmn.func.b.b.e;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* loaded from: classes4.dex */
public class c implements f {

    /* renamed from: a */
    private static OkHttpClient f17079a;

    /* renamed from: b */
    private OkHttpClient f17080b;

    /* renamed from: c */
    private HashMap<Long, Call> f17081c = new HashMap<>();

    /* renamed from: d */
    private Object f17082d = new Object();

    /* renamed from: e */
    private Object f17083e = new Object();

    /* renamed from: com.opos.cmn.func.b.a.c$1 */
    class AnonymousClass1 implements Callback {
    }

    /* renamed from: com.opos.cmn.func.b.a.c$2 */
    static final class AnonymousClass2 implements StatisticCallback {
        AnonymousClass2() {
        }
    }

    /* renamed from: com.opos.cmn.func.b.a.c$3 */
    static final class AnonymousClass3 implements IAccountCallback {
        AnonymousClass3() {
        }
    }

    /* renamed from: com.opos.cmn.func.b.a.c$4 */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a */
        static final /* synthetic */ int[] f17086a;

        static {
            int[] iArr = new int[b.a.values().length];
            f17086a = iArr;
            try {
                iArr[b.a.CN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17086a[b.a.EU.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17086a[b.a.SA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17086a[b.a.SEA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private static class a<K, V> extends HashMap<K, V> {

        /* renamed from: a */
        private Headers f17087a;

        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        public void a(Headers headers) {
            this.f17087a = headers;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [V, java.lang.String] */
        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            if (obj == null) {
                return null;
            }
            String str = (String) obj;
            Headers headers = this.f17087a;
            if (headers == null) {
                return (V) super.get(obj);
            }
            ?? r5 = (V) headers.get(str);
            com.opos.cmn.an.f.a.b("HttpTapInsideHttpImpl", "HeaderMap name:" + str + " value:" + ((String) r5));
            if (r5 != 0) {
                return r5;
            }
            return null;
        }
    }

    private static class b implements com.opos.cmn.func.b.b.a {

        /* renamed from: a */
        private Headers f17088a;

        /* renamed from: b */
        private Map<String, String> f17089b;

        public b(Headers headers) {
            this.f17089b = null;
            this.f17088a = headers;
            if (headers != null) {
                try {
                    this.f17089b = new HashMap();
                    for (String str : this.f17088a.names()) {
                        if (str != null) {
                            this.f17089b.put(str, this.f17088a.get(str));
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }

        @Override // com.opos.cmn.func.b.b.a
        public String a(String str) {
            Headers headers = this.f17088a;
            if (headers == null || str == null) {
                return null;
            }
            return headers.get(str);
        }
    }

    private static AreaCode a(b.a aVar, Context context) {
        if (aVar == null) {
            aVar = com.opos.cmn.func.b.a.a.b.d(context);
        }
        int i2 = AnonymousClass4.f17086a[aVar.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return AreaCode.EU;
            }
            if (i2 == 3) {
                return AreaCode.SA;
            }
            if (i2 == 4) {
                return AreaCode.SEA;
            }
        }
        return AreaCode.CN;
    }

    private static HttpDnsConfig a(com.opos.cmn.func.b.b.a.c cVar, Context context) {
        if (cVar == null) {
            return null;
        }
        String str = cVar.f17106b;
        String str2 = cVar.f17107c;
        if (TextUtils.isEmpty(str)) {
            str = com.opos.cmn.func.b.a.a.b.c(context);
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = com.opos.cmn.func.b.a.a.b.b(context);
        }
        HttpDnsConfig httpDnsConfig = new HttpDnsConfig(cVar.f17105a, str, str2, cVar.f17108d);
        List<String> list = cVar.f17109e;
        if (list != null && !list.isEmpty()) {
            httpDnsConfig.setInnerWhiteList(cVar.f17109e);
        }
        if (cVar.f17110f != null) {
            httpDnsConfig.setSsoCallback(new IAccountCallback() { // from class: com.opos.cmn.func.b.a.c.3
                AnonymousClass3() {
                }
            });
        }
        return httpDnsConfig;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:0|(1:2)|3|(2:5|(1:7))|8|(1:10)(1:38)|11|(1:15)|16|(3:18|(1:20)|21)|23|(2:25|(1:27))|28|(2:30|(1:32))|33|34|21) */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x012b, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x012c, code lost:
    
        com.opos.cmn.an.f.a.b("HttpTapInsideHttpImpl", "", r7);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.heytap.okhttp.extension.HeyConfig.Builder a(com.opos.cmn.func.b.b.a.d r7, android.content.Context r8) {
        /*
            Method dump skipped, instructions count: 306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.func.b.a.c.a(com.opos.cmn.func.b.b.a.d, android.content.Context):com.heytap.okhttp.extension.HeyConfig$Builder");
    }

    private static IPv6Config a(com.opos.cmn.func.b.b.a.f fVar) {
        if (fVar == null) {
            return null;
        }
        return new IPv6Config(fVar.f17131a, fVar.f17132b, fVar.f17133c, fVar.f17134d);
    }

    private static AppTraceConfig a(com.opos.cmn.func.b.b.a.a aVar) {
        if (aVar == null) {
            return null;
        }
        return new AppTraceConfig(aVar.f17090a, aVar.f17091b);
    }

    private com.opos.cmn.func.b.b.e a(Response response) {
        if (response == null) {
            return null;
        }
        int code = response.code();
        com.opos.cmn.an.f.a.b("HttpTapInsideHttpImpl", "code=" + code);
        String message = response.message();
        StringBuilder sb = new StringBuilder();
        sb.append("msg=");
        sb.append(message != null ? message : "null");
        com.opos.cmn.an.f.a.b("HttpTapInsideHttpImpl", sb.toString());
        InputStream byteStream = response.body() != null ? response.body().byteStream() : null;
        Headers build = response.headers().newBuilder().build();
        long j2 = -1;
        if (build != null) {
            String str = build.get("Content-Length");
            if (!TextUtils.isEmpty(str)) {
                try {
                    j2 = Long.parseLong(str);
                } catch (Exception unused) {
                }
            }
        }
        return new e.a().a(code).a(message).a(j2).a(a(build)).a(new b(build)).a(byteStream).a();
    }

    private Map<String, String> a(Headers headers) {
        if (headers == null) {
            return null;
        }
        try {
            a aVar = new a(null);
            aVar.a(headers);
            for (String str : headers.names()) {
                if (str != null) {
                    aVar.put(str, headers.get(str));
                }
            }
            return aVar;
        } catch (Exception unused) {
            return null;
        }
    }

    private Call a(long j2) {
        try {
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("HttpTapInsideHttpImpl", "removeRequestFromMap fail", e2);
        }
        synchronized (this.f17082d) {
            Call call = this.f17081c.get(Long.valueOf(j2));
            if (call == null) {
                return null;
            }
            this.f17081c.remove(Long.valueOf(j2));
            return call;
        }
    }

    private static OkHttpClient.Builder a() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builder.readTimeout(30000L, timeUnit);
        builder.connectTimeout(30000L, timeUnit);
        return builder;
    }

    private static OkHttpClient.Builder a(Context context, OkHttpClient.Builder builder, g gVar) {
        if (gVar != null) {
            if (gVar.f17141c != null) {
                com.opos.cmn.an.f.a.b("HttpTapInsideHttpImpl", "config set sslSocketFactory");
                X509TrustManager x509TrustManager = gVar.f17143e;
                if (x509TrustManager != null) {
                    builder.sslSocketFactory(gVar.f17141c, x509TrustManager);
                } else {
                    builder.sslSocketFactory(gVar.f17141c);
                }
            }
            if (gVar.f17142d != null) {
                com.opos.cmn.an.f.a.b("HttpTapInsideHttpImpl", "config set hostnameVerifier");
                builder.hostnameVerifier(gVar.f17142d);
            }
            long j2 = gVar.f17140b;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            builder.readTimeout(j2, timeUnit).connectTimeout(gVar.f17139a, timeUnit);
            com.opos.cmn.an.f.a.b("HttpTapInsideHttpImpl", "config set readTimeout=" + gVar.f17140b);
            com.opos.cmn.an.f.a.b("HttpTapInsideHttpImpl", "config set connectTimeout=" + gVar.f17139a);
            HeyConfig.Builder a2 = a(gVar.f17144f, context);
            if (a2 != null) {
                builder.config(a2.build(context));
            }
        }
        return builder;
    }

    private void a(long j2, Call call) {
        com.opos.cmn.an.f.a.b("HttpTapInsideHttpImpl", "putCall requestId=" + j2);
        if (call != null) {
            synchronized (this.f17082d) {
                this.f17081c.put(Long.valueOf(j2), call);
                com.opos.cmn.an.f.a.b("HttpTapInsideHttpImpl", "putCall mCallsMap.size()=" + this.f17081c.size());
            }
        }
    }

    private void a(Context context, g gVar) {
        if (this.f17080b == null) {
            synchronized (this.f17083e) {
                if (this.f17080b == null) {
                    Context applicationContext = context.getApplicationContext();
                    long currentTimeMillis = System.currentTimeMillis();
                    this.f17080b = b(applicationContext, gVar);
                    com.opos.cmn.an.f.a.b("HttpTapInsideHttpImpl", "getOkHttpClient cost time:" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    private static ApiEnv b() {
        return com.opos.cmn.func.b.a.f17057a.booleanValue() ? ApiEnv.RELEASE : ApiEnv.DEV;
    }

    private static OkHttpClient b(Context context) {
        OkHttpClient okHttpClient = f17079a;
        if (okHttpClient == null) {
            synchronized (c.class) {
                if (f17079a == null) {
                    try {
                        g a2 = com.opos.cmn.func.b.a.a.b.a(context);
                        OkHttpClient.Builder a3 = a();
                        a(context, a3, a2);
                        f17079a = a3.build();
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.b("HttpTapInsideHttpImpl", "init fail", e2);
                    }
                }
                okHttpClient = f17079a;
            }
        }
        return okHttpClient;
    }

    private static OkHttpClient b(Context context, g gVar) {
        OkHttpClient b2;
        try {
            b2 = b(context);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("HttpTapInsideHttpImpl", "getOkHttpClient", e2);
        }
        if (gVar == null) {
            return b2;
        }
        if (b2 != null) {
            OkHttpClient.Builder newBuilder = b2.newBuilder();
            a(context, newBuilder, gVar);
            return newBuilder.build();
        }
        return null;
    }

    private Request b(Context context, com.opos.cmn.func.b.b.d dVar) {
        Request.Builder url;
        if (dVar == null) {
            return null;
        }
        com.opos.cmn.func.b.b.d a2 = com.opos.cmn.func.b.a.a.b.a(context, dVar);
        Request.Builder builder = new Request.Builder();
        Map<String, String> map = a2.f17155c;
        if (map != null) {
            for (String str : map.keySet()) {
                builder.addHeader(str, a2.f17155c.get(str));
            }
        }
        String str2 = a2.f17153a;
        if (str2 == "GET") {
            url = builder.url(a2.f17154b).get();
        } else {
            if (str2 == "POST") {
                byte[] bArr = a2.f17156d;
                builder.post(bArr != null ? RequestBody.create((MediaType) null, bArr) : RequestBody.create((MediaType) null, new byte[0]));
            }
            url = builder.url(a2.f17154b);
        }
        return url.build();
    }

    @Override // com.opos.cmn.func.b.a.e
    public com.opos.cmn.func.b.b.e a(Context context, com.opos.cmn.func.b.b.d dVar) {
        Request b2;
        com.opos.cmn.an.f.a.b("HttpTapInsideHttpImpl", "execSync");
        if (dVar == null) {
            return null;
        }
        try {
            if (context == null) {
                return null;
            }
            try {
                Context applicationContext = context.getApplicationContext();
                a(applicationContext, (g) null);
                if (this.f17080b != null && (b2 = b(applicationContext, dVar)) != null) {
                    com.opos.cmn.an.f.a.b("HttpTapInsideHttpImpl", b2.toString());
                    Call newCall = this.f17080b.newCall(b2);
                    a(dVar.f17157e, newCall);
                    com.opos.cmn.func.b.b.e a2 = a(newCall.execute());
                    StringBuilder sb = new StringBuilder();
                    sb.append("onResponse,");
                    sb.append(a2 == null ? "null" : a2.toString());
                    com.opos.cmn.an.f.a.b("HttpTapInsideHttpImpl", sb.toString());
                    return a2;
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b("HttpTapInsideHttpImpl", "execSync fail", e2);
            }
            return null;
        } finally {
            a(dVar.f17157e);
        }
    }

    @Override // com.opos.cmn.func.b.a.d
    public void a(Context context) {
        a(context, (g) null);
    }
}
