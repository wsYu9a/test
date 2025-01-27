package com.shu.priory.c;

import android.graphics.Bitmap;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class c extends Thread {

    /* renamed from: a, reason: collision with root package name */
    private String f16889a;

    /* renamed from: b, reason: collision with root package name */
    private b f16890b;

    public static class a extends FilterInputStream {
        public a(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j10) throws IOException {
            long j11 = 0;
            while (j11 < j10) {
                long skip = ((FilterInputStream) this).in.skip(j10 - j11);
                if (skip == 0) {
                    if (read() < 0) {
                        break;
                    }
                    skip = 1;
                }
                j11 += skip;
            }
            return j11;
        }
    }

    public interface b {
        void a(Bitmap bitmap);

        void a(Exception exc);
    }

    public c(String str, b bVar) {
        this.f16889a = str;
        this.f16890b = bVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0091, code lost:
    
        if (r1 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0070, code lost:
    
        if (r1 == null) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b() {
        /*
            r5 = this;
            java.lang.String r0 = "network error!"
            java.lang.String r1 = r5.f16889a
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto Lb
            return
        Lb:
            r1 = 0
            java.net.URL r2 = new java.net.URL     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66 java.lang.IllegalStateException -> L76 java.io.IOException -> L85
            java.lang.String r3 = r5.f16889a     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66 java.lang.IllegalStateException -> L76 java.io.IOException -> L85
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66 java.lang.IllegalStateException -> L76 java.io.IOException -> L85
            java.net.URLConnection r2 = r2.openConnection()     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66 java.lang.IllegalStateException -> L76 java.io.IOException -> L85
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66 java.lang.IllegalStateException -> L76 java.io.IOException -> L85
            java.lang.String r1 = "GET"
            r2.setRequestMethod(r1)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f java.lang.IllegalStateException -> L41 java.io.IOException -> L43
            r1 = 15000(0x3a98, float:2.102E-41)
            r2.setConnectTimeout(r1)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f java.lang.IllegalStateException -> L41 java.io.IOException -> L43
            r2.setReadTimeout(r1)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f java.lang.IllegalStateException -> L41 java.io.IOException -> L43
            int r1 = r2.getResponseCode()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f java.lang.IllegalStateException -> L41 java.io.IOException -> L43
            r3 = 200(0xc8, float:2.8E-43)
            if (r3 == r1) goto L45
            com.shu.priory.c.c$b r1 = r5.f16890b     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f java.lang.IllegalStateException -> L41 java.io.IOException -> L43
            java.lang.Exception r3 = new java.lang.Exception     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f java.lang.IllegalStateException -> L41 java.io.IOException -> L43
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f java.lang.IllegalStateException -> L41 java.io.IOException -> L43
            r1.a(r3)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f java.lang.IllegalStateException -> L41 java.io.IOException -> L43
            r2.disconnect()
            return
        L3c:
            r0 = move-exception
            r1 = r2
            goto L95
        L3f:
            r1 = r2
            goto L66
        L41:
            r1 = r2
            goto L76
        L43:
            r1 = r2
            goto L85
        L45:
            java.io.InputStream r1 = r2.getInputStream()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f java.lang.IllegalStateException -> L41 java.io.IOException -> L43
            com.shu.priory.c.c$a r3 = new com.shu.priory.c.c$a     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f java.lang.IllegalStateException -> L41 java.io.IOException -> L43
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f java.lang.IllegalStateException -> L41 java.io.IOException -> L43
            android.os.Looper.prepare()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f java.lang.IllegalStateException -> L41 java.io.IOException -> L43
            android.os.Looper.getMainLooper()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f java.lang.IllegalStateException -> L41 java.io.IOException -> L43
            com.shu.priory.c.c$b r4 = r5.f16890b     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f java.lang.IllegalStateException -> L41 java.io.IOException -> L43
            android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeStream(r3)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f java.lang.IllegalStateException -> L41 java.io.IOException -> L43
            r4.a(r3)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f java.lang.IllegalStateException -> L41 java.io.IOException -> L43
            r1.close()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f java.lang.IllegalStateException -> L41 java.io.IOException -> L43
            r2.disconnect()
            goto L94
        L64:
            r0 = move-exception
            goto L95
        L66:
            com.shu.priory.c.c$b r2 = r5.f16890b     // Catch: java.lang.Throwable -> L64
            java.lang.Exception r3 = new java.lang.Exception     // Catch: java.lang.Throwable -> L64
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L64
            r2.a(r3)     // Catch: java.lang.Throwable -> L64
            if (r1 == 0) goto L94
        L72:
            r1.disconnect()
            goto L94
        L76:
            com.shu.priory.c.c$b r0 = r5.f16890b     // Catch: java.lang.Throwable -> L64
            java.lang.Exception r2 = new java.lang.Exception     // Catch: java.lang.Throwable -> L64
            java.lang.String r3 = "Incorrect URL!"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L64
            r0.a(r2)     // Catch: java.lang.Throwable -> L64
            if (r1 == 0) goto L94
            goto L72
        L85:
            com.shu.priory.c.c$b r0 = r5.f16890b     // Catch: java.lang.Throwable -> L64
            java.lang.Exception r2 = new java.lang.Exception     // Catch: java.lang.Throwable -> L64
            java.lang.String r3 = "I/O error!"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L64
            r0.a(r2)     // Catch: java.lang.Throwable -> L64
            if (r1 == 0) goto L94
            goto L72
        L94:
            return
        L95:
            if (r1 == 0) goto L9a
            r1.disconnect()
        L9a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shu.priory.c.c.b():void");
    }

    public void a() {
        start();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        b();
    }
}
