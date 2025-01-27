package com.shu.priory.request;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.am;
import com.shu.priory.config.ErrorCode;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.utils.h;
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
public class b extends Thread {

    /* renamed from: a */
    private URL f17222a;

    /* renamed from: b */
    private Context f17223b;

    /* renamed from: d */
    private int f17225d;

    /* renamed from: e */
    private int f17226e;

    /* renamed from: f */
    private long f17227f;

    /* renamed from: j */
    private String f17231j;

    /* renamed from: c */
    private int f17224c = 0;

    /* renamed from: g */
    private boolean f17228g = true;

    /* renamed from: h */
    private final ArrayList<byte[]> f17229h = new ArrayList<>();

    /* renamed from: i */
    private c f17230i = null;

    /* renamed from: com.shu.priory.request.b$1 */
    public class AnonymousClass1 implements HostnameVerifier {
        public AnonymousClass1() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return !TextUtils.isEmpty(b.this.f17231j) ? HttpsURLConnection.getDefaultHostnameVerifier().verify(b.this.f17231j, sSLSession) : HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
        }
    }

    private void b() {
        HttpURLConnection httpURLConnection;
        Throwable th2;
        OutputStream outputStream;
        StringBuilder sb2;
        InputStream inputStream = null;
        try {
            httpURLConnection = (HttpURLConnection) this.f17222a.openConnection();
            try {
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                a(httpURLConnection);
                httpURLConnection.setConnectTimeout(this.f17226e);
                httpURLConnection.setReadTimeout(this.f17226e);
                httpURLConnection.setRequestProperty("Charset", "utf-8");
                httpURLConnection.setRequestProperty("Content-Type", am.f6738d);
                httpURLConnection.setRequestProperty("dpv", "2.0");
                if (!TextUtils.isEmpty(this.f17231j)) {
                    httpURLConnection.setRequestProperty(m5.c.f28355w, this.f17231j);
                }
                httpURLConnection.setRequestProperty("User-Agent", com.shu.priory.param.c.d(null));
                outputStream = httpURLConnection.getOutputStream();
                try {
                    Iterator<byte[]> it = this.f17229h.iterator();
                    while (it.hasNext()) {
                        outputStream.write(it.next());
                    }
                    outputStream.flush();
                    outputStream.close();
                    if (200 == httpURLConnection.getResponseCode()) {
                        inputStream = httpURLConnection.getInputStream();
                        b(a(inputStream));
                    } else {
                        d(ErrorCode.ERROR_SERVER);
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th3) {
                            th = th3;
                            sb2 = new StringBuilder();
                            sb2.append("post in close : ");
                            sb2.append(th.toString());
                            h.d(SDKConstants.TAG, sb2.toString());
                            return;
                        }
                    }
                    outputStream.close();
                    httpURLConnection.disconnect();
                } catch (Throwable th4) {
                    th2 = th4;
                    try {
                        h.d(SDKConstants.TAG, "runPost error : " + th2.toString());
                        d(ErrorCode.ERROR_SERVER);
                        if (0 != 0) {
                            try {
                                inputStream.close();
                            } catch (Throwable th5) {
                                th = th5;
                                sb2 = new StringBuilder();
                                sb2.append("post in close : ");
                                sb2.append(th.toString());
                                h.d(SDKConstants.TAG, sb2.toString());
                                return;
                            }
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    } catch (Throwable th6) {
                        if (0 != 0) {
                            try {
                                inputStream.close();
                            } catch (Throwable th7) {
                                h.d(SDKConstants.TAG, "post in close : " + th7.toString());
                                throw th6;
                            }
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th6;
                    }
                }
            } catch (Throwable th8) {
                th2 = th8;
                outputStream = null;
            }
        } catch (Throwable th9) {
            httpURLConnection = null;
            th2 = th9;
            outputStream = null;
        }
    }

    private void d(int i10) {
        Context context;
        String str;
        c cVar = this.f17230i;
        if (cVar != null) {
            cVar.a(i10);
        }
        if (this.f17228g) {
            long currentTimeMillis = System.currentTimeMillis() - this.f17227f;
            int i11 = this.f17225d;
            if (i11 == 0) {
                com.shu.priory.utils.e.a(this.f17223b, "reqDuration", currentTimeMillis);
                context = this.f17223b;
                str = "reqFailCnt";
            } else if (i11 == 1) {
                com.shu.priory.utils.e.a(this.f17223b, "impDuration", currentTimeMillis);
                context = this.f17223b;
                str = "impFailCnt";
            } else {
                if (i11 != 2) {
                    return;
                }
                com.shu.priory.utils.e.a(this.f17223b, "clkDuration", currentTimeMillis);
                context = this.f17223b;
                str = "clkFailCnt";
            }
            com.shu.priory.utils.e.a(this.f17223b, str, com.shu.priory.utils.e.b(context, str) + 1);
        }
    }

    public void c(int i10) {
        this.f17226e = i10;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.f17224c == 1) {
            b();
        } else {
            a();
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

    public void b(int i10) {
        this.f17224c = i10;
    }

    private void a() {
        InputStream inputStream;
        StringBuilder sb2;
        HttpURLConnection httpURLConnection = null;
        InputStream inputStream2 = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) this.f17222a.openConnection();
            try {
                httpURLConnection2.setRequestMethod("GET");
                a(httpURLConnection2);
                httpURLConnection2.setConnectTimeout(this.f17226e);
                httpURLConnection2.setReadTimeout(this.f17226e);
                httpURLConnection2.setRequestProperty("User-Agent", com.shu.priory.param.c.d(null));
                int responseCode = httpURLConnection2.getResponseCode();
                if (200 == responseCode) {
                    inputStream2 = httpURLConnection2.getInputStream();
                    b(a(inputStream2));
                } else {
                    d(responseCode);
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Throwable th2) {
                        th = th2;
                        sb2 = new StringBuilder();
                        sb2.append("get in close : ");
                        sb2.append(th.toString());
                        h.d(SDKConstants.TAG, sb2.toString());
                        return;
                    }
                }
                httpURLConnection2.disconnect();
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
                httpURLConnection = httpURLConnection2;
                try {
                    h.d(SDKConstants.TAG, "runGet error ; " + th.toString());
                    d(ErrorCode.ERROR_SERVER);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th4) {
                            th = th4;
                            sb2 = new StringBuilder();
                            sb2.append("get in close : ");
                            sb2.append(th.toString());
                            h.d(SDKConstants.TAG, sb2.toString());
                            return;
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } catch (Throwable th5) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th6) {
                            h.d(SDKConstants.TAG, "get in close : " + th6.toString());
                            throw th5;
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th5;
                }
            }
        } catch (Throwable th7) {
            th = th7;
            inputStream = null;
        }
    }

    private void b(byte[] bArr) {
        Context context;
        String str;
        c cVar = this.f17230i;
        if (cVar != null) {
            cVar.a(bArr);
        }
        if (this.f17228g) {
            long currentTimeMillis = System.currentTimeMillis() - this.f17227f;
            int i10 = this.f17225d;
            if (i10 == 0) {
                com.shu.priory.utils.e.a(this.f17223b, "reqDuration", currentTimeMillis);
                context = this.f17223b;
                str = "reqFailCnt";
            } else if (i10 == 1) {
                com.shu.priory.utils.e.a(this.f17223b, "impDuration", currentTimeMillis);
                context = this.f17223b;
                str = "impFailCnt";
            } else {
                if (i10 != 2) {
                    return;
                }
                com.shu.priory.utils.e.a(this.f17223b, "clkDuration", currentTimeMillis);
                context = this.f17223b;
                str = "clkFailCnt";
            }
            com.shu.priory.utils.e.a(context, str, 0L);
        }
    }

    public void a(int i10) {
        this.f17225d = i10;
    }

    public void a(Context context) {
        this.f17223b = context.getApplicationContext();
    }

    public void a(c cVar) {
        if (this.f17228g) {
            this.f17227f = System.currentTimeMillis();
        }
        this.f17230i = cVar;
        start();
    }

    public void a(String str) {
        this.f17231j = str;
    }

    public void a(String str, String str2, byte[] bArr) {
        this.f17229h.clear();
        a(bArr);
        try {
            this.f17222a = a(str, str2);
        } catch (MalformedURLException e10) {
            h.d(SDKConstants.TAG, "url error:" + e10.toString());
        }
    }

    private void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection instanceof HttpsURLConnection) {
            ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new HostnameVerifier() { // from class: com.shu.priory.request.b.1
                public AnonymousClass1() {
                }

                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    return !TextUtils.isEmpty(b.this.f17231j) ? HttpsURLConnection.getDefaultHostnameVerifier().verify(b.this.f17231j, sSLSession) : HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
                }
            });
        }
    }

    public void a(boolean z10) {
        this.f17228g = z10;
    }

    private void a(byte[] bArr) {
        if (bArr != null) {
            this.f17229h.add(bArr);
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
