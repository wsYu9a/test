package com.kwad.sdk.h;

import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.baidu.mobads.sdk.internal.am;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
class l {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static int aNV;

    public interface a {
        void onSuccess();
    }

    @WorkerThread
    public static void a(List<k> list, a aVar) {
        if (aNV > 10) {
            j.ak("LogReportUtil", "request error");
            return;
        }
        g KV = h.KR().KV();
        Map<String, String> requestHeader = KV.getRequestHeader();
        JSONObject KQ = KV.KQ();
        c.putValue(KQ, "actionList", list);
        c.putValue(KQ, o3.a.f29032k, System.currentTimeMillis());
        a(KV.KP(), requestHeader, a(requestHeader, KQ), aVar);
    }

    private static String c(Map<String, String> map, String str) {
        g KV = h.KR().KV();
        JSONObject jSONObject = new JSONObject();
        c.putValue(jSONObject, "version", KV.getSdkVersion());
        c.putValue(jSONObject, "appId", KV.getAppId());
        c.putValue(jSONObject, b7.d.f1362o, com.kwad.sdk.h.a.an(str));
        com.kwad.sdk.h.a.a(KV.KP(), map, jSONObject.toString());
        return jSONObject.toString();
    }

    private static String c(InputStream inputStream) {
        InputStreamReader inputStreamReader;
        Throwable th2;
        BufferedReader bufferedReader;
        try {
            inputStreamReader = new InputStreamReader(inputStream);
            try {
                bufferedReader = new BufferedReader(inputStreamReader, 1024);
            } catch (Throwable th3) {
                th2 = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            inputStreamReader = null;
            th2 = th4;
            bufferedReader = null;
        }
        try {
            String a10 = a(bufferedReader);
            j.closeQuietly(bufferedReader);
            j.closeQuietly(inputStreamReader);
            return a10;
        } catch (Throwable th5) {
            th2 = th5;
            j.closeQuietly(bufferedReader);
            j.closeQuietly(inputStreamReader);
            throw th2;
        }
    }

    private static String a(Map<String, String> map, JSONObject jSONObject) {
        if (h.KR().KV().KO()) {
            return jSONObject.toString();
        }
        return c(map, jSONObject.toString());
    }

    private static void a(String str, Map<String, String> map, String str2, a aVar) {
        Closeable closeable;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        OutputStream outputStream = null;
        httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (Exception unused) {
            closeable = null;
        } catch (Throwable th2) {
            th = th2;
            closeable = null;
        }
        try {
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", am.f6738d);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setUseCaches(false);
            a(httpURLConnection, map);
            httpURLConnection.connect();
            if (!TextUtils.isEmpty(str2)) {
                outputStream = httpURLConnection.getOutputStream();
                outputStream.write(str2.getBytes());
                outputStream.flush();
            }
            if (httpURLConnection.getResponseCode() == 200) {
                String a10 = a(httpURLConnection.getInputStream());
                j.Lc();
                if (!TextUtils.isEmpty(a10)) {
                    if (new JSONObject(a10).optInt(p3.i.f29758c) == 1) {
                        aNV = 0;
                        aVar.onSuccess();
                    } else {
                        aNV++;
                        j.Lc();
                    }
                } else {
                    aNV++;
                    j.Lc();
                }
            } else {
                aNV++;
                j.Lc();
            }
            j.a(httpURLConnection);
            j.closeQuietly(outputStream);
        } catch (Exception unused2) {
            httpURLConnection2 = httpURLConnection;
            closeable = null;
            try {
                aNV++;
                j.Lb();
                j.a(httpURLConnection2);
                j.closeQuietly(closeable);
            } catch (Throwable th3) {
                th = th3;
                j.a(httpURLConnection2);
                j.closeQuietly(closeable);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection2 = httpURLConnection;
            closeable = null;
            j.a(httpURLConnection2);
            j.closeQuietly(closeable);
            throw th;
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

    private static String a(Reader reader) {
        StringWriter stringWriter;
        Throwable th2;
        StringWriter stringWriter2 = new StringWriter();
        try {
            stringWriter = new StringWriter();
            try {
                char[] cArr = new char[1024];
                while (true) {
                    int read = reader.read(cArr);
                    if (read != -1) {
                        stringWriter.write(cArr, 0, read);
                    } else {
                        String stringWriter3 = stringWriter.toString();
                        j.closeQuietly(reader);
                        j.closeQuietly(stringWriter);
                        return stringWriter3;
                    }
                }
            } catch (Throwable th3) {
                th2 = th3;
                j.closeQuietly(reader);
                j.closeQuietly(stringWriter);
                throw th2;
            }
        } catch (Throwable th4) {
            stringWriter = stringWriter2;
            th2 = th4;
        }
    }

    private static String a(InputStream inputStream) {
        try {
            try {
                return c(inputStream);
            } catch (IOException unused) {
                j.Lb();
                j.closeQuietly(inputStream);
                return null;
            }
        } finally {
            j.closeQuietly(inputStream);
        }
    }
}
