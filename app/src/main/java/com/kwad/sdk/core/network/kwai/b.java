package com.kwad.sdk.core.network.kwai;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.internal.am;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.q;
import com.kwad.sdk.core.network.s;
import com.kwad.sdk.crash.utils.h;
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
import java.util.Map;
import org.apache.http.HttpHeaders;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b {
    private static com.kwad.sdk.core.network.c a(String str, Map<String, String> map, String str2, boolean z) {
        OutputStream outputStream;
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        HttpURLConnection httpURLConnection = null;
        r1 = null;
        r1 = null;
        OutputStream outputStream2 = null;
        httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                s.wrapHttpURLConnection(httpURLConnection2);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setRequestProperty("Content-Type", z ? am.f5520d : "application/x-www-form-urlencoded");
                q.b(httpURLConnection2);
                a(httpURLConnection2, map);
                httpURLConnection2.setConnectTimeout(5000);
                httpURLConnection2.setReadTimeout(5000);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.connect();
                if (!TextUtils.isEmpty(str2)) {
                    outputStream2 = httpURLConnection2.getOutputStream();
                    outputStream2.write(str2.getBytes());
                    outputStream2.flush();
                }
                int responseCode = httpURLConnection2.getResponseCode();
                cVar.code = responseCode;
                cVar.agd = responseCode;
                if (responseCode == 200) {
                    cVar.agf = a(httpURLConnection2.getInputStream());
                }
                com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream2);
            } catch (Exception e2) {
                e = e2;
                OutputStream outputStream3 = outputStream2;
                httpURLConnection = httpURLConnection2;
                outputStream = outputStream3;
                try {
                    a(cVar, e);
                    com.kwad.sdk.crash.utils.b.a(httpURLConnection);
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                    return cVar;
                } catch (Throwable th) {
                    th = th;
                    com.kwad.sdk.crash.utils.b.a(httpURLConnection);
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                OutputStream outputStream4 = outputStream2;
                httpURLConnection = httpURLConnection2;
                outputStream = outputStream4;
                com.kwad.sdk.crash.utils.b.a(httpURLConnection);
                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            outputStream = null;
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
        }
        return cVar;
    }

    public static com.kwad.sdk.core.network.c a(String str, Map<String, String> map, boolean z) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        HttpURLConnection httpURLConnection2 = null;
        r1 = null;
        r1 = null;
        InputStream inputStream2 = null;
        httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (Exception e2) {
            e = e2;
            inputStream = null;
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            s.wrapHttpURLConnection(httpURLConnection);
            a(httpURLConnection, map);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT, am.f5520d);
            q.b(httpURLConnection);
            int responseCode = httpURLConnection.getResponseCode();
            cVar.code = responseCode;
            cVar.agd = responseCode;
            StringBuilder sb = new StringBuilder();
            if (z) {
                inputStream2 = httpURLConnection.getInputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    sb.append(new String(bArr, 0, read));
                }
            }
            cVar.agf = sb.toString();
            com.kwad.sdk.crash.utils.b.a(httpURLConnection);
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
        } catch (Exception e3) {
            e = e3;
            InputStream inputStream3 = inputStream2;
            httpURLConnection2 = httpURLConnection;
            inputStream = inputStream3;
            try {
                a(cVar, e);
                com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                return cVar;
            } catch (Throwable th2) {
                th = th2;
                com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            InputStream inputStream4 = inputStream2;
            httpURLConnection2 = httpURLConnection;
            inputStream = inputStream4;
            com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            throw th;
        }
        return cVar;
    }

    private static String a(InputStream inputStream) {
        try {
            try {
                return h.c(inputStream);
            } catch (IOException e2) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                return null;
            }
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
        }
    }

    private static void a(@NonNull com.kwad.sdk.core.network.c cVar, Exception exc) {
        int i2 = cVar.code;
        if (i2 == 0) {
            i2 = -1;
        }
        cVar.agd = i2;
        cVar.age = exc;
        if (exc instanceof SocketTimeoutException) {
            f fVar = f.agi;
            cVar.code = fVar.errorCode;
            cVar.agf = fVar.msg;
        } else {
            cVar.code = f.agj.errorCode;
            try {
                cVar.agf = f.agj.msg + "/n" + Log.getStackTraceString(exc);
            } catch (Exception unused) {
            }
        }
        if (com.kwad.b.kwai.a.bI.booleanValue()) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(exc);
        }
    }

    private static void a(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map == null || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    public static com.kwad.sdk.core.network.c doGet(String str, Map<String, String> map) {
        return a(str, map, true);
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, Map<String, String> map2) {
        String str2;
        if (map2 != null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                String encode = encode(entry.getValue());
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(encode);
                sb.append("&");
            }
            str2 = sb.substring(0, sb.length() - 1);
        } else {
            str2 = null;
        }
        return a(str, map, str2, false);
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, JSONObject jSONObject) {
        return a(str, map, jSONObject != null ? jSONObject.toString() : null, true);
    }

    public static boolean downloadUrlToStream(String str, OutputStream outputStream, int i2) {
        HttpURLConnection httpURLConnection;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                s.wrapHttpURLConnection(httpURLConnection);
                httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_LANGUAGE, "zh-CN");
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(120000);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestProperty("Connection", "keep-alive");
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                q.b(httpURLConnection);
                bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    byte[] bArr = new byte[1024];
                    long j2 = 0;
                    if (i2 > 0) {
                        do {
                            int read = bufferedInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            j2 += read;
                        } while (j2 <= i2);
                    } else if (i2 < 0) {
                        BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(outputStream);
                        while (true) {
                            try {
                                int read2 = bufferedInputStream.read(bArr);
                                if (read2 == -1) {
                                    break;
                                }
                                bufferedOutputStream2.write(bArr, 0, read2);
                            } catch (Throwable th) {
                                th = th;
                                bufferedOutputStream = bufferedOutputStream2;
                                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedOutputStream);
                                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                throw th;
                            }
                        }
                        bufferedOutputStream2.flush();
                        bufferedOutputStream = bufferedOutputStream2;
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedOutputStream);
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                    httpURLConnection.disconnect();
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            bufferedInputStream = null;
        }
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
}
