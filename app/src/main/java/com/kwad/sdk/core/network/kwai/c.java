package com.kwad.sdk.core.network.kwai;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.q;
import com.kwad.sdk.export.proxy.AdHttpBodyBuilder;
import com.kwad.sdk.export.proxy.AdHttpFormDataBuilder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import okhttp3.ConnectionSpec;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.http.HttpHeaders;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class c {
    private static final Pattern ahg = Pattern.compile("Unexpected response code for CONNECT: ([0-9]+)", 2);
    public static String ahh = "UTF-8";
    private static OkHttpClient ahi = null;
    public static OkHttpClient ahj = wl();

    /* renamed from: com.kwad.sdk.core.network.kwai.c$1 */
    static class AnonymousClass1 implements AdHttpFormDataBuilder {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.export.proxy.AdHttpFormDataBuilder
        public final void addFormDataPart(String str, String str2) {
            MultipartBody.Builder.this.addFormDataPart(str, str2);
        }

        @Override // com.kwad.sdk.export.proxy.AdHttpFormDataBuilder
        public final void addFormDataPart(String str, String str2, String str3, byte[] bArr) {
            MultipartBody.Builder.this.addFormDataPart(str, str2, RequestBody.create(MediaType.parse(str3), bArr));
        }
    }

    public static com.kwad.sdk.core.network.c a(String str, @Nullable Map<String, String> map, boolean z) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            Request.Builder url = new Request.Builder().url(str);
            a(url);
            a(url, map);
            Response execute = wk().newCall(url.build()).execute();
            int code = execute.code();
            cVar.code = code;
            cVar.agd = code;
            cVar.agf = z ? a(execute) : "";
        } catch (Exception e2) {
            a(cVar, e2);
        }
        return cVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.Closeable, java.io.InputStreamReader, java.io.Reader] */
    private static String a(Response response) {
        InputStream inputStream;
        InputStream inputStream2;
        ?? r4;
        InputStream inputStream3;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            inputStream = response.body().byteStream();
            try {
                List<String> headers = response.headers("Content-Encoding");
                boolean z = false;
                if (headers != null) {
                    Iterator<String> it = headers.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if ("gzip".equalsIgnoreCase(it.next())) {
                            z = true;
                            break;
                        }
                    }
                }
                if (z) {
                    inputStream3 = new GZIPInputStream(inputStream);
                    inputStream2 = inputStream3;
                } else {
                    inputStream2 = null;
                    inputStream3 = inputStream;
                }
                try {
                    r4 = new InputStreamReader(inputStream3, ahh);
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(r4, 8);
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                                    com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r4);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                                    return sb.toString();
                                }
                                sb.append(readLine);
                            } catch (Throwable th) {
                                bufferedReader = bufferedReader2;
                                th = th;
                                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r4);
                                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
                                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    r4 = 0;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream2 = null;
                r4 = inputStream2;
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r4);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
            inputStream2 = null;
        }
    }

    private static void a(@NonNull com.kwad.sdk.core.network.c cVar, Exception exc) {
        String message;
        cVar.age = exc;
        if (cVar.agd == -1 && (exc instanceof IOException) && (message = exc.getMessage()) != null) {
            Matcher matcher = ahg.matcher(message);
            if (matcher.find()) {
                try {
                    cVar.agd = Integer.parseInt(matcher.group(1));
                } catch (Exception unused) {
                }
            }
        }
        if (exc instanceof SocketTimeoutException) {
            f fVar = f.agi;
            cVar.code = fVar.errorCode;
            cVar.agf = fVar.msg;
        } else {
            cVar.code = f.agj.errorCode;
            try {
                cVar.agf = f.agj.msg + "/n" + Log.getStackTraceString(exc);
            } catch (Exception unused2) {
            }
        }
        if (com.kwad.b.kwai.a.bI.booleanValue()) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(exc);
        }
    }

    private static void a(Request.Builder builder) {
        builder.addHeader("User-Agent", q.getUserAgent());
        builder.addHeader("BrowserUa", q.wh());
        builder.addHeader("SystemUa", q.wg());
    }

    private static void a(Request.Builder builder, @Nullable Map<String, String> map) {
        if (builder == null || map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                try {
                    builder.removeHeader(entry.getKey());
                    builder.addHeader(entry.getKey(), entry.getValue());
                } catch (Exception unused) {
                }
            }
        }
    }

    private static void a(Request.Builder builder, JSONObject jSONObject) {
        builder.post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jSONObject.toString()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v6 */
    private static boolean a(Response response, OutputStream outputStream, int i2) {
        Closeable closeable;
        InputStream inputStream;
        InputStream inputStream2;
        boolean z;
        InputStream inputStream3;
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream = null;
        try {
            inputStream = response.body().byteStream();
            try {
                List<String> headers = response.headers("Content-Encoding");
                if (headers != null) {
                    Iterator<String> it = headers.iterator();
                    while (it.hasNext()) {
                        if ("gzip".equalsIgnoreCase(it.next())) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (z) {
                    inputStream3 = new GZIPInputStream(inputStream);
                    inputStream2 = inputStream3;
                } else {
                    inputStream2 = null;
                    inputStream3 = inputStream;
                }
                try {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inputStream3);
                    try {
                        byte[] bArr = new byte[1024];
                        long j2 = 0;
                        if (i2 > 0) {
                            do {
                                int read = bufferedInputStream2.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                j2 += read;
                            } while (j2 <= i2);
                        } else if (i2 < 0) {
                            bufferedOutputStream = new BufferedOutputStream(outputStream);
                            while (true) {
                                try {
                                    int read2 = bufferedInputStream2.read(bArr);
                                    if (read2 == -1) {
                                        break;
                                    }
                                    bufferedOutputStream.write(bArr, 0, read2);
                                } catch (Throwable th) {
                                    th = th;
                                    bufferedInputStream = bufferedInputStream2;
                                    closeable = bufferedOutputStream;
                                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                                    throw th;
                                }
                            }
                            bufferedOutputStream.flush();
                            bufferedInputStream = bufferedOutputStream;
                        }
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                        return true;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedOutputStream = 0;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    closeable = null;
                }
            } catch (Throwable th4) {
                th = th4;
                closeable = null;
                inputStream2 = null;
            }
        } catch (Throwable th5) {
            th = th5;
            closeable = null;
            inputStream = null;
            inputStream2 = null;
        }
    }

    private static void b(Request.Builder builder, Map<String, String> map) {
        FormBody formBody;
        if (map == null || map.isEmpty()) {
            formBody = null;
        } else {
            FormBody.Builder builder2 = new FormBody.Builder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null) {
                    try {
                        builder2.addEncoded(entry.getKey(), encode(entry.getValue()));
                    } catch (Exception unused) {
                    }
                }
            }
            formBody = builder2.build();
        }
        if (builder == null || formBody == null) {
            return;
        }
        builder.post(formBody);
    }

    public static com.kwad.sdk.core.network.c doGet(String str, @Nullable Map<String, String> map) {
        return a(str, map, true);
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, AdHttpBodyBuilder adHttpBodyBuilder) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
            if (adHttpBodyBuilder != null) {
                adHttpBodyBuilder.buildFormData(new AdHttpFormDataBuilder() { // from class: com.kwad.sdk.core.network.kwai.c.1
                    AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.export.proxy.AdHttpFormDataBuilder
                    public final void addFormDataPart(String str2, String str22) {
                        MultipartBody.Builder.this.addFormDataPart(str2, str22);
                    }

                    @Override // com.kwad.sdk.export.proxy.AdHttpFormDataBuilder
                    public final void addFormDataPart(String str2, String str22, String str3, byte[] bArr) {
                        MultipartBody.Builder.this.addFormDataPart(str2, str22, RequestBody.create(MediaType.parse(str3), bArr));
                    }
                });
            }
            Request.Builder post = new Request.Builder().url(str).post(type.build());
            a(post, map);
            Response execute = wk().newCall(post.build()).execute();
            int code = execute.code();
            cVar.code = code;
            cVar.agd = code;
            cVar.agf = a(execute);
        } catch (Exception e2) {
            a(cVar, e2);
        }
        return cVar;
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, Map<String, String> map2) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            Request.Builder url = new Request.Builder().url(str);
            a(url);
            a(url, map);
            b(url, map2);
            Response execute = wk().newCall(url.build()).execute();
            int code = execute.code();
            cVar.code = code;
            cVar.agd = code;
            cVar.agf = a(execute);
        } catch (Exception e2) {
            a(cVar, e2);
        }
        return cVar;
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, JSONObject jSONObject) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            Request.Builder url = new Request.Builder().url(str);
            a(url);
            a(url, map);
            a(url, jSONObject);
            Response execute = wk().newCall(url.build()).execute();
            int code = execute.code();
            cVar.code = code;
            cVar.agd = code;
            cVar.agf = a(execute);
        } catch (Exception e2) {
            a(cVar, e2);
        }
        return cVar;
    }

    public static boolean downloadUrlToStream(String str, OutputStream outputStream, int i2) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        Request.Builder url = new Request.Builder().url(str);
        HashMap hashMap = new HashMap();
        hashMap.put(HttpHeaders.ACCEPT_LANGUAGE, "zh-CN");
        hashMap.put("Connection", "keep-alive");
        hashMap.put("Charset", "UTF-8");
        a(url);
        a(url, hashMap);
        Response execute = wk().newCall(url.build()).execute();
        int code = execute.code();
        cVar.code = code;
        cVar.agd = code;
        a(execute, outputStream, i2);
        return true;
    }

    private static String encode(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            return "";
        }
    }

    public static OkHttpClient wk() {
        if (!com.kwad.b.kwai.a.bI.booleanValue()) {
            return ahj;
        }
        if (ahi == null) {
            ahi = ahj.newBuilder().build();
        }
        return ahi;
    }

    private static OkHttpClient wl() {
        if (ahj == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            OkHttpClient.Builder connectionSpecs = builder.connectTimeout(3000L, timeUnit).readTimeout(6000L, timeUnit).connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT));
            try {
                connectionSpecs.dns(new d());
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTrace(th);
            }
            ahj = connectionSpecs.build();
        }
        return ahj;
    }
}
