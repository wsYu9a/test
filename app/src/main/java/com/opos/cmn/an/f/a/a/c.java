package com.opos.cmn.an.f.a.a;

import com.baidu.mobads.sdk.internal.am;
import com.usertrace.cdo.usertrace.domain.dto.UserTraceConfigDto;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class c implements b.h.a.j.a {
    private static SSLSocketFactory a() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, null, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    private void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection instanceof HttpsURLConnection) {
            try {
                SSLSocketFactory a2 = a();
                if (a2 != null) {
                    ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(a2);
                }
            } catch (Exception unused) {
            }
        }
    }

    private UserTraceConfigDto c(String str) {
        if (!com.opos.cmn.an.c.a.a(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                UserTraceConfigDto userTraceConfigDto = new UserTraceConfigDto();
                userTraceConfigDto.setTraceId(jSONObject.optLong("traceId", 0L));
                if (!jSONObject.isNull("imei")) {
                    userTraceConfigDto.setImei(jSONObject.optString("imei", ""));
                }
                userTraceConfigDto.setBeginTime(jSONObject.optLong("beginTime", 0L));
                userTraceConfigDto.setBeginTime(jSONObject.optLong("endTime", 0L));
                userTraceConfigDto.setForce(jSONObject.optInt("force", 0));
                if (!jSONObject.isNull("tracePkg")) {
                    userTraceConfigDto.setTracePkg(jSONObject.optString("tracePkg", ""));
                }
                if (jSONObject.isNull("openId")) {
                    return userTraceConfigDto;
                }
                userTraceConfigDto.setOpenId(jSONObject.optString("openId", ""));
                return userTraceConfigDto;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @Override // b.h.a.j.a
    public b.h.a.j.b a(String str) {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (com.opos.cmn.an.c.a.a(str)) {
                return null;
            }
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                a(httpURLConnection);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Connection", HTTP.CONN_KEEP_ALIVE);
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT, am.f5520d);
                httpURLConnection.connect();
                b.h.a.j.b bVar = new b.h.a.j.b(httpURLConnection.getResponseCode());
                try {
                    httpURLConnection.disconnect();
                } catch (Exception unused) {
                }
                return bVar;
            } catch (Exception unused2) {
                if (httpURLConnection == null) {
                    return null;
                }
                try {
                    httpURLConnection.disconnect();
                    return null;
                } catch (Exception unused3) {
                    return null;
                }
            } catch (Throwable th) {
                httpURLConnection2 = httpURLConnection;
                th = th;
                if (httpURLConnection2 != null) {
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Exception unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
            httpURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v12 */
    @Override // b.h.a.j.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public b.h.a.j.b a(java.lang.String r7, java.io.File r8) {
        /*
            r6 = this;
            r0 = 0
            boolean r1 = com.opos.cmn.an.c.a.a(r7)     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> La5
            if (r1 == 0) goto Lf
        L7:
            com.opos.cmn.an.f.c.b.a(r0)
            com.opos.cmn.an.f.c.b.a(r0)
            goto Lb3
        Lf:
            if (r8 == 0) goto L7
            boolean r1 = r8.exists()     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> La5
            if (r1 != 0) goto L18
            goto L7
        L18:
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> La5
            r1.<init>(r7)     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> La5
            java.net.URLConnection r7 = r1.openConnection()     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> La5
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> La5
            r6.a(r7)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L93
            r1 = 1
            r7.setDoInput(r1)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L93
            r7.setDoOutput(r1)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L93
            r1 = 0
            r7.setUseCaches(r1)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L93
            java.lang.String r2 = "POST"
            r7.setRequestMethod(r2)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L93
            java.lang.String r2 = "Connection"
            java.lang.String r3 = "Keep-Alive"
            r7.setRequestProperty(r2, r3)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L93
            java.lang.String r2 = "Charset"
            java.lang.String r3 = "UTF-8"
            r7.setRequestProperty(r2, r3)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L93
            java.lang.String r2 = "Content-Type"
            java.lang.String r3 = "application/octet-stream"
            r7.setRequestProperty(r2, r3)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L93
            java.lang.String r2 = "Accept"
            java.lang.String r3 = "application/json"
            r7.setRequestProperty(r2, r3)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L93
            java.io.DataOutputStream r2 = new java.io.DataOutputStream     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L93
            java.io.OutputStream r3 = r7.getOutputStream()     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L93
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L93
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8e
            r3.<init>(r8)     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8e
            r8 = 1024(0x400, float:1.435E-42)
            byte[] r8 = new byte[r8]     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L88
        L64:
            int r4 = r3.read(r8)     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L88
            r5 = -1
            if (r4 == r5) goto L6f
            r2.write(r8, r1, r4)     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L88
            goto L64
        L6f:
            r2.flush()     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L88
            b.h.a.j.b r8 = new b.h.a.j.b     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L88
            int r1 = r7.getResponseCode()     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L88
            r8.<init>(r1)     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L88
            com.opos.cmn.an.f.c.b.a(r2)
            com.opos.cmn.an.f.c.b.a(r3)
            r7.disconnect()     // Catch: java.lang.Exception -> L84
        L84:
            r0 = r8
            goto Lb3
        L86:
            r8 = move-exception
            goto L8c
        L88:
            goto La8
        L8a:
            r8 = move-exception
            r3 = r0
        L8c:
            r0 = r2
            goto L99
        L8e:
            r3 = r0
            goto La8
        L90:
            r8 = move-exception
            r3 = r0
            goto L99
        L93:
            r2 = r0
            goto La7
        L95:
            r7 = move-exception
            r8 = r7
            r7 = r0
            r3 = r7
        L99:
            com.opos.cmn.an.f.c.b.a(r0)
            com.opos.cmn.an.f.c.b.a(r3)
            if (r7 == 0) goto La4
            r7.disconnect()     // Catch: java.lang.Exception -> La4
        La4:
            throw r8
        La5:
            r7 = r0
            r2 = r7
        La7:
            r3 = r2
        La8:
            com.opos.cmn.an.f.c.b.a(r2)
            com.opos.cmn.an.f.c.b.a(r3)
            if (r7 == 0) goto Lb3
            r7.disconnect()     // Catch: java.lang.Exception -> Lb3
        Lb3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.f.a.a.c.a(java.lang.String, java.io.File):b.h.a.j.b");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x006b, code lost:
    
        if (r6 == null) goto L70;
     */
    @Override // b.h.a.j.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.usertrace.cdo.usertrace.domain.dto.UserTraceConfigDto b(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = ""
            r1 = 0
            boolean r2 = com.opos.cmn.an.c.a.a(r6)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L67
            if (r2 == 0) goto Ld
            com.opos.cmn.an.f.c.b.a(r1)
            goto L72
        Ld:
            java.net.URL r2 = new java.net.URL     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L67
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L67
            java.net.URLConnection r6 = r2.openConnection()     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L67
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L67
            r5.a(r6)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            java.lang.String r2 = "GET"
            r6.setRequestMethod(r2)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            r2 = 5000(0x1388, float:7.006E-42)
            r6.setConnectTimeout(r2)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            java.lang.String r2 = "Accept"
            java.lang.String r3 = "application/json"
            r6.setRequestProperty(r2, r3)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            r6.connect()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            java.io.InputStream r1 = r6.getInputStream()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            r2.<init>()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
        L42:
            java.lang.String r4 = r3.readLine()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            if (r4 == 0) goto L4c
            r2.append(r4)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            goto L42
        L4c:
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            com.opos.cmn.an.f.c.b.a(r1)
        L53:
            r6.disconnect()     // Catch: java.lang.Exception -> L6e
            goto L6e
        L57:
            r0 = move-exception
            goto L5e
        L59:
            goto L68
        L5b:
            r6 = move-exception
            r0 = r6
            r6 = r1
        L5e:
            com.opos.cmn.an.f.c.b.a(r1)
            if (r6 == 0) goto L66
            r6.disconnect()     // Catch: java.lang.Exception -> L66
        L66:
            throw r0
        L67:
            r6 = r1
        L68:
            com.opos.cmn.an.f.c.b.a(r1)
            if (r6 == 0) goto L6e
            goto L53
        L6e:
            com.usertrace.cdo.usertrace.domain.dto.UserTraceConfigDto r1 = r5.c(r0)
        L72:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.f.a.a.c.b(java.lang.String):com.usertrace.cdo.usertrace.domain.dto.UserTraceConfigDto");
    }
}
