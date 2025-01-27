package b.d.c.a;

import com.martian.libcomm.http.requests.HttpGetParams;
import com.martian.libcomm.http.requests.HttpPostParams;
import com.martian.libcomm.utils.d;
import com.martian.libsupport.l;
import com.vivo.google.android.exoplayer3.DefaultLoadControl;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a */
    public static final String f4421a = "b";

    /* renamed from: b */
    private static final a f4422b = a.c();

    /* renamed from: c */
    private static OkHttpClient f4423c = new OkHttpClient.Builder().connectionPool(new ConnectionPool(5, 4, TimeUnit.SECONDS)).dns(new com.martian.libcomm.utils.a()).build();

    /* JADX WARN: Removed duplicated region for block: B:45:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.lang.String r5) {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L52
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L52
            b.d.c.a.a r5 = b.d.c.a.b.f4422b     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L52
            boolean r2 = r5.d(r1)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L52
            if (r2 == 0) goto Lf
            return
        Lf:
            java.net.URLConnection r1 = r1.openConnection()     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L52
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L52
            r2 = 8000(0x1f40, float:1.121E-41)
            r1.setConnectTimeout(r2)     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L65
            r1.setReadTimeout(r2)     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L65
            r5.j(r1)     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L65
            java.io.InputStream r0 = r1.getInputStream()     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L65
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L65
            r5.<init>()     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L65
            r2 = 8064(0x1f80, float:1.13E-41)
            byte[] r2 = new byte[r2]     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L65
        L2d:
            int r3 = r0.read(r2)     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L65
            r4 = -1
            if (r3 != r4) goto L48
            r5.flush()     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L65
            b.d.c.a.a r5 = b.d.c.a.b.f4422b     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L65
            r5.k(r1)     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L65
            r0.close()     // Catch: java.io.IOException -> L40
            goto L44
        L40:
            r5 = move-exception
            r5.printStackTrace()
        L44:
            r1.disconnect()     // Catch: java.lang.Exception -> L64
            goto L64
        L48:
            r4 = 0
            r5.write(r2, r4, r3)     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L65
            goto L2d
        L4d:
            r5 = move-exception
            goto L54
        L4f:
            r5 = move-exception
            r1 = r0
            goto L66
        L52:
            r5 = move-exception
            r1 = r0
        L54:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L65
            if (r0 == 0) goto L61
            r0.close()     // Catch: java.io.IOException -> L5d
            goto L61
        L5d:
            r5 = move-exception
            r5.printStackTrace()
        L61:
            if (r1 == 0) goto L64
            goto L44
        L64:
            return
        L65:
            r5 = move-exception
        L66:
            if (r0 == 0) goto L70
            r0.close()     // Catch: java.io.IOException -> L6c
            goto L70
        L6c:
            r0 = move-exception
            r0.printStackTrace()
        L70:
            if (r1 == 0) goto L75
            r1.disconnect()     // Catch: java.lang.Exception -> L75
        L75:
            goto L77
        L76:
            throw r5
        L77:
            goto L76
        */
        throw new UnsupportedOperationException("Method not decompiled: b.d.c.a.b.a(java.lang.String):void");
    }

    public static b.d.c.a.c.a b(String urlstr, Hashtable<String, String> properties, int timeout) {
        Response execute;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient build = f4423c.newBuilder().connectTimeout(timeout / 2, timeUnit).readTimeout(timeout, timeUnit).build();
        Request.Builder url = new Request.Builder().url(urlstr);
        if (properties != null) {
            for (Map.Entry<String, String> entry : properties.entrySet()) {
                url.addHeader(entry.getKey(), entry.getValue());
            }
        }
        Call newCall = build.newCall(url.build());
        b.d.c.a.c.a aVar = new b.d.c.a.c.a();
        try {
            execute = newCall.execute();
        } catch (Exception e2) {
            e2.printStackTrace();
            aVar.h("网络异常");
            aVar.j(g(e2));
        }
        if (execute.body() == null) {
            throw new IOException("empty body " + aVar);
        }
        String string = execute.body().string();
        if (l.K()) {
            string = d.b(string);
        }
        aVar.g(execute.code());
        aVar.h(string);
        execute.close();
        return aVar;
    }

    public static b.d.c.a.c.a c(HttpGetParams params, Hashtable<String, String> properties, String charset, int timeout) {
        return b(params.toHttpUrl(charset), properties, timeout / 1000);
    }

    public static b.d.c.a.c.a d(HttpPostParams params, Hashtable<String, String> properties, String charset, int timeout) {
        Response execute;
        OkHttpClient.Builder newBuilder = f4423c.newBuilder();
        long j2 = timeout / 2;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient build = newBuilder.connectTimeout(j2, timeUnit).readTimeout(j2, timeUnit).build();
        Request.Builder post = new Request.Builder().url(params.toHttpUrl(charset)).post(params.toPostContent(charset));
        if (properties != null) {
            for (Map.Entry<String, String> entry : properties.entrySet()) {
                post.addHeader(entry.getKey(), entry.getValue());
            }
        }
        Call newCall = build.newCall(post.build());
        b.d.c.a.c.a aVar = new b.d.c.a.c.a();
        try {
            execute = newCall.execute();
        } catch (Exception e2) {
            e2.printStackTrace();
            aVar.h("网络异常");
        }
        if (execute.body() == null) {
            throw new IOException("empty body " + aVar);
        }
        String string = execute.body().string();
        aVar.g(execute.code());
        aVar.h(string);
        execute.close();
        return aVar;
    }

    public static b.d.c.a.c.a e(com.martian.libcomm.http.requests.b params, Hashtable<String, String> properties, String charset) {
        return f(params, properties, charset, DefaultLoadControl.DEFAULT_MAX_BUFFER_MS);
    }

    public static b.d.c.a.c.a f(com.martian.libcomm.http.requests.b params, Hashtable<String, String> properties, String charset, int timeout) {
        if (params instanceof HttpGetParams) {
            return c((HttpGetParams) params, properties, charset, timeout);
        }
        if (params instanceof HttpPostParams) {
            return d((HttpPostParams) params, properties, charset, timeout);
        }
        b.d.c.a.c.a aVar = new b.d.c.a.c.a();
        aVar.h("Invalid HttpRequestParams class.");
        return aVar;
    }

    public static String g(Throwable throwable) {
        if (throwable == null) {
            return "";
        }
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            if (throwable.getCause() != null) {
                throwable.getCause().printStackTrace(printWriter);
            } else {
                throwable.printStackTrace(printWriter);
            }
            printWriter.flush();
            stringWriter.flush();
            String obj = stringWriter.toString();
            printWriter.close();
            stringWriter.close();
            return obj;
        } catch (IOException e2) {
            e2.printStackTrace();
            return "";
        } catch (Exception e3) {
            e3.printStackTrace();
            return "";
        }
    }

    public static boolean h(String url) {
        try {
            return f4422b.d(new URL(url));
        } catch (MalformedURLException unused) {
            return false;
        }
    }
}
