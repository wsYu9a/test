package com.shu.priory.d;

import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.am;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* loaded from: classes3.dex */
class e extends Thread {

    /* renamed from: a */
    private URL f16912a;

    /* renamed from: c */
    private int f16914c;

    /* renamed from: b */
    private int f16913b = 0;

    /* renamed from: d */
    private final ArrayList<byte[]> f16915d = new ArrayList<>();

    /* renamed from: e */
    private f f16916e = null;

    /* renamed from: com.shu.priory.d.e$1 */
    public class AnonymousClass1 implements HostnameVerifier {
        public AnonymousClass1() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
        }
    }

    private URL a(String str, String str2) throws MalformedURLException {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!str.endsWith("?")) {
                str = str + "?";
            }
            str = str + str2;
        }
        if (str.contains(" ")) {
            str = str.replaceAll(" ", "%20");
        }
        return new URL(str);
    }

    private void b() {
        HttpURLConnection httpURLConnection;
        OutputStream outputStream;
        InputStream inputStream = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) this.f16912a.openConnection();
                try {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setRequestMethod("POST");
                    a(httpURLConnection);
                    httpURLConnection.setConnectTimeout(this.f16914c);
                    httpURLConnection.setReadTimeout(this.f16914c);
                    httpURLConnection.setRequestProperty("Charset", "utf-8");
                    httpURLConnection.setRequestProperty("Content-Type", am.f6738d);
                    outputStream = httpURLConnection.getOutputStream();
                    try {
                        Iterator<byte[]> it = this.f16915d.iterator();
                        while (it.hasNext()) {
                            outputStream.write(it.next());
                        }
                        outputStream.flush();
                        outputStream.close();
                        if (200 == httpURLConnection.getResponseCode()) {
                            inputStream = httpURLConnection.getInputStream();
                            b(a(inputStream));
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        outputStream.close();
                    } catch (Throwable unused) {
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (httpURLConnection == null) {
                            return;
                        }
                        httpURLConnection.disconnect();
                    }
                } catch (Throwable unused2) {
                    outputStream = null;
                }
            } catch (Throwable unused3) {
                httpURLConnection = null;
                outputStream = null;
            }
            httpURLConnection.disconnect();
        } catch (Throwable unused4) {
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            if (this.f16913b == 1) {
                b();
            } else {
                a();
            }
        } catch (Exception e10) {
            f fVar = this.f16916e;
            if (fVar != null) {
                fVar.a(e10);
            }
        }
    }

    private void a() {
        HttpURLConnection httpURLConnection;
        InputStream inputStream = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) this.f16912a.openConnection();
                try {
                    httpURLConnection.setRequestMethod("GET");
                    a(httpURLConnection);
                    httpURLConnection.setConnectTimeout(this.f16914c);
                    httpURLConnection.setReadTimeout(this.f16914c);
                    int responseCode = httpURLConnection.getResponseCode();
                    if (200 == responseCode) {
                        inputStream = httpURLConnection.getInputStream();
                        b(a(inputStream));
                    } else {
                        a(new Exception("request error, response code " + responseCode));
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Throwable unused) {
                    if (0 != 0) {
                        inputStream.close();
                    }
                    if (httpURLConnection == null) {
                        return;
                    }
                    httpURLConnection.disconnect();
                }
            } catch (Throwable unused2) {
                httpURLConnection = null;
            }
            httpURLConnection.disconnect();
        } catch (Throwable unused3) {
        }
    }

    private void b(byte[] bArr) {
        f fVar = this.f16916e;
        if (fVar != null) {
            fVar.a(bArr);
        }
    }

    public void a(int i10) {
        this.f16913b = i10;
    }

    public void a(f fVar) {
        this.f16916e = fVar;
        start();
    }

    private void a(Exception exc) {
        f fVar = this.f16916e;
        if (fVar != null) {
            fVar.a(exc);
        }
    }

    public void a(String str, String str2, byte[] bArr) {
        this.f16915d.clear();
        a(bArr);
        try {
            this.f16912a = a(str, str2);
        } catch (MalformedURLException unused) {
        }
    }

    private void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection instanceof HttpsURLConnection) {
            ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new HostnameVerifier() { // from class: com.shu.priory.d.e.1
                public AnonymousClass1() {
                }

                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
                }
            });
        }
    }

    private void a(byte[] bArr) {
        if (bArr != null) {
            this.f16915d.add(bArr);
        }
    }

    private byte[] a(InputStream inputStream) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = bufferedInputStream.read(bArr, 0, 1024);
            if (read == -1) {
                bufferedInputStream.close();
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }
}
