package com.bytedance.sdk.openadsdk.api.plugin.b;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.Arrays;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import m5.h;

/* loaded from: classes2.dex */
public class c {

    public static final class a {

        /* renamed from: a */
        private static final c f8052a = new c();
    }

    public /* synthetic */ c(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static c a() {
        return a.f8052a;
    }

    private X509TrustManager b() throws IOException {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1) {
                TrustManager trustManager = trustManagers[0];
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e10) {
            throw new IOException("No System TLS", e10);
        }
    }

    private c() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0088, code lost:
    
        if (r5 == null) goto L132;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(boolean r4, java.lang.String r5, byte[] r6) {
        /*
            r3 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            javax.net.ssl.X509TrustManager r5 = r3.b()     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            javax.net.ssl.SSLSocketFactory r5 = r3.a(r5)     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(r5)     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            java.net.URLConnection r5 = r1.openConnection()     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            javax.net.ssl.HttpsURLConnection r5 = (javax.net.ssl.HttpsURLConnection) r5     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            r1 = 5000(0x1388, float:7.006E-42)
            r5.setConnectTimeout(r1)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            com.bytedance.sdk.openadsdk.api.plugin.b.a r1 = com.bytedance.sdk.openadsdk.api.plugin.b.a.f8043a     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            r5.setHostnameVerifier(r1)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            if (r4 == 0) goto L4d
            if (r6 == 0) goto L4d
            int r4 = r6.length     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            if (r4 == 0) goto L4d
            r4 = 1
            r5.setDoOutput(r4)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            int r4 = r6.length     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            r5.setFixedLengthStreamingMode(r4)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            java.io.OutputStream r1 = r5.getOutputStream()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            r4.write(r6)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            r4.flush()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            r4.close()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            java.lang.String r4 = "POST"
            r5.setRequestMethod(r4)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            goto L52
        L48:
            r4 = move-exception
            r0 = r5
            goto L8c
        L4b:
            r4 = move-exception
            goto L85
        L4d:
            java.lang.String r4 = "GET"
            r5.setRequestMethod(r4)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
        L52:
            int r4 = r5.getResponseCode()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            r6 = 200(0xc8, float:2.8E-43)
            if (r4 < r6) goto L7d
            r6 = 300(0x12c, float:4.2E-43)
            if (r4 >= r6) goto L7d
            java.lang.String r4 = "Content-Type"
            java.lang.String r4 = r5.getHeaderField(r4)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            java.lang.String r6 = "utf-8"
            java.lang.String r4 = a(r4, r6)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            java.lang.String r6 = new java.lang.String     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            java.io.InputStream r1 = r5.getInputStream()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r1 = a(r1, r2)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            r6.<init>(r1, r4)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            r5.disconnect()     // Catch: java.lang.Exception -> L7c
        L7c:
            return r6
        L7d:
            r5.disconnect()     // Catch: java.lang.Exception -> L8b
            goto L8b
        L81:
            r4 = move-exception
            goto L8c
        L83:
            r4 = move-exception
            r5 = r0
        L85:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L48
            if (r5 == 0) goto L8b
            goto L7d
        L8b:
            return r0
        L8c:
            if (r0 == 0) goto L91
            r0.disconnect()     // Catch: java.lang.Exception -> L91
        L91:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.api.plugin.b.c.a(boolean, java.lang.String, byte[]):java.lang.String");
    }

    private static byte[] a(InputStream inputStream, int i10) throws IOException {
        if (inputStream == null) {
            return null;
        }
        if (i10 < 1) {
            i10 = 1;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[i10];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.close();
                inputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    private static String a(String str, String str2) {
        if (str != null) {
            String[] split = str.split(";", 0);
            for (int i10 = 1; i10 < split.length; i10++) {
                String[] split2 = split[i10].trim().split("=", 0);
                if (split2.length == 2 && split2[0].equals(h.f28414g)) {
                    return split2[1];
                }
            }
        }
        return str2;
    }

    private SSLSocketFactory a(X509TrustManager x509TrustManager) throws IOException {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e10) {
            throw new IOException("No System TLS", e10);
        }
    }
}
