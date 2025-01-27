package com.kwad.sdk.core.network.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.internal.am;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.core.network.r;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.export.proxy.AdHttpResponseHelper;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.utils.bt;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class b {
    public static com.kwad.sdk.core.network.c a(String str, Map<String, String> map, boolean z10) {
        InputStream inputStream;
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        HttpURLConnection httpURLConnection = null;
        r1 = null;
        r1 = null;
        InputStream inputStream2 = null;
        httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                r.wrapHttpURLConnection(httpURLConnection2);
                a(httpURLConnection2, map);
                httpURLConnection2.setRequestMethod("GET");
                httpURLConnection2.setRequestProperty(m5.c.f28310h, am.f6738d);
                p.b(httpURLConnection2);
                int responseCode = httpURLConnection2.getResponseCode();
                cVar.code = responseCode;
                cVar.azs = responseCode;
                StringBuilder sb2 = new StringBuilder();
                if (z10) {
                    inputStream2 = httpURLConnection2.getInputStream();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        sb2.append(new String(bArr, 0, read));
                    }
                }
                cVar.azu = sb2.toString();
                com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
            } catch (Exception e10) {
                e = e10;
                InputStream inputStream3 = inputStream2;
                httpURLConnection = httpURLConnection2;
                inputStream = inputStream3;
                try {
                    a(cVar, e);
                    com.kwad.sdk.crash.utils.b.a(httpURLConnection);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                    return cVar;
                } catch (Throwable th2) {
                    th = th2;
                    com.kwad.sdk.crash.utils.b.a(httpURLConnection);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                InputStream inputStream4 = inputStream2;
                httpURLConnection = httpURLConnection2;
                inputStream = inputStream4;
                com.kwad.sdk.crash.utils.b.a(httpURLConnection);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            inputStream = null;
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
        }
        return cVar;
    }

    private static long c(HttpURLConnection httpURLConnection) {
        for (Map.Entry<String, List<String>> entry : httpURLConnection.getHeaderFields().entrySet()) {
            String key = entry.getKey();
            if (key != null && "content-length".equals(key.toLowerCase())) {
                try {
                    return Long.parseLong(entry.getValue().get(0));
                } catch (Throwable unused) {
                }
            }
        }
        return -1L;
    }

    public static com.kwad.sdk.core.network.c doGet(String str, Map<String, String> map) {
        return a(str, map, true);
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, Map<String, String> map2) {
        String str2;
        if (map2 != null) {
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                String encode = encode(entry.getValue());
                sb2.append(entry.getKey());
                sb2.append("=");
                sb2.append(encode);
                sb2.append("&");
            }
            str2 = sb2.substring(0, sb2.length() - 1);
        } else {
            str2 = null;
        }
        return a(str, map, str2, false);
    }

    public static boolean downloadUrlToStream(String str, OutputStream outputStream, long j10, AdHttpResponseListener adHttpResponseListener) {
        HttpURLConnection httpURLConnection;
        BufferedInputStream bufferedInputStream;
        long c10;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                r.wrapHttpURLConnection(httpURLConnection);
                AdHttpResponseHelper.notifyResponseStart(adHttpResponseListener);
                httpURLConnection.setRequestProperty(m5.c.f28319k, "zh-CN");
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(120000);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestProperty(m5.c.f28331o, "keep-alive");
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                p.b(httpURLConnection);
                c10 = c(httpURLConnection);
                bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            bufferedInputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            long j11 = 0;
            if (j10 > 0) {
                do {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    j11 += read;
                    AdHttpResponseHelper.notifyResponseProgress(adHttpResponseListener, j11, c10);
                } while (j11 <= j10);
            } else if (j10 < 0) {
                r2 = outputStream != null ? new BufferedOutputStream(outputStream) : null;
                do {
                    int read2 = bufferedInputStream.read(bArr);
                    if (read2 == -1) {
                        break;
                    }
                    if (r2 != null) {
                        r2.write(bArr, 0, read2);
                    }
                    j11 += read2;
                } while (!AdHttpResponseHelper.notifyResponseProgress(adHttpResponseListener, j11, c10));
                if (r2 != null) {
                    r2.flush();
                }
            }
            AdHttpResponseHelper.notifyResponseEnd(adHttpResponseListener);
            com.kwad.sdk.crash.utils.b.closeQuietly(r2);
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
            httpURLConnection.disconnect();
            return true;
        } catch (Throwable th4) {
            th = th4;
            com.kwad.sdk.crash.utils.b.closeQuietly(r2);
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    private static String encode(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
            return "";
        }
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, JSONObject jSONObject) {
        return a(str, map, jSONObject != null ? jSONObject.toString() : null, true);
    }

    private static void a(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map == null || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private static com.kwad.sdk.core.network.c a(String str, Map<String, String> map, String str2, boolean z10) {
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        HttpURLConnection httpURLConnection2 = null;
        r1 = null;
        r1 = null;
        OutputStream outputStream2 = null;
        httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (Exception e10) {
            e = e10;
            outputStream = null;
        } catch (Throwable th2) {
            th = th2;
            outputStream = null;
        }
        try {
            r.wrapHttpURLConnection(httpURLConnection);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            if (z10) {
                httpURLConnection.setRequestProperty("Content-Type", am.f6738d);
            } else {
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            }
            p.b(httpURLConnection);
            a(httpURLConnection, map);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.connect();
            if (!TextUtils.isEmpty(str2)) {
                outputStream2 = httpURLConnection.getOutputStream();
                outputStream2.write(str2.getBytes());
                outputStream2.flush();
            }
            int responseCode = httpURLConnection.getResponseCode();
            cVar.code = responseCode;
            cVar.azs = responseCode;
            if (responseCode == 200) {
                cVar.azu = a(httpURLConnection.getInputStream());
            }
            com.kwad.sdk.crash.utils.b.a(httpURLConnection);
            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream2);
        } catch (Exception e11) {
            e = e11;
            OutputStream outputStream3 = outputStream2;
            httpURLConnection2 = httpURLConnection;
            outputStream = outputStream3;
            try {
                a(cVar, e);
                com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                return cVar;
            } catch (Throwable th3) {
                th = th3;
                com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            OutputStream outputStream4 = outputStream2;
            httpURLConnection2 = httpURLConnection;
            outputStream = outputStream4;
            com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
            throw th;
        }
        return cVar;
    }

    private static void a(@NonNull com.kwad.sdk.core.network.c cVar, Exception exc) {
        int i10 = cVar.code;
        if (i10 == 0) {
            i10 = -1;
        }
        cVar.azs = i10;
        cVar.azt = exc;
        if (exc instanceof SocketTimeoutException) {
            e eVar = e.azv;
            cVar.code = eVar.errorCode;
            cVar.azu = eVar.msg;
        } else {
            cVar.code = e.azw.errorCode;
            cVar.azu = e.azw.msg + "/" + bt.t(exc);
        }
        if (com.kwad.framework.a.a.ns.booleanValue()) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(exc);
        }
    }

    private static String a(InputStream inputStream) {
        try {
            try {
                return h.c(inputStream);
            } catch (IOException e10) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                return null;
            }
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
        }
    }
}
