package com.shu.priory.download.b.a;

import android.os.Process;
import android.text.TextUtils;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.utils.h;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import m5.c;

/* loaded from: classes3.dex */
public class b implements Runnable {

    /* renamed from: a */
    private com.shu.priory.download.b.a f16935a;

    /* renamed from: b */
    private com.shu.priory.download.d.a f16936b;

    /* renamed from: c */
    private a f16937c;

    /* renamed from: d */
    private final int f16938d = 10000;

    /* renamed from: e */
    private final int f16939e = 10000;

    public interface a {
        void a(long j10, boolean z10);

        void b();
    }

    public b(com.shu.priory.download.b.a aVar, com.shu.priory.download.d.a aVar2, a aVar3) {
        this.f16935a = aVar;
        this.f16936b = aVar2;
        this.f16937c = aVar3;
    }

    private synchronized String a(String str) throws Exception {
        h.a(SDKConstants.TAG, "get file preUrl-->" + str);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setConnectTimeout(5000);
        if (httpURLConnection.getResponseCode() != 200 && httpURLConnection.getResponseCode() != 206) {
            if (httpURLConnection.getResponseCode() != 302) {
                return str;
            }
            String headerField = httpURLConnection.getHeaderField(c.f28347t0);
            h.a(SDKConstants.TAG, "get file tempUrl-->" + headerField);
            return a(headerField);
        }
        h.a(SDKConstants.TAG, "get file downUrl-->" + str);
        return str;
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        try {
            a();
        } catch (com.shu.priory.download.e.a e10) {
            this.f16937c.b();
            this.f16936b.a(e10);
            this.f16936b.a(5);
            this.f16935a.a(this.f16936b);
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0039: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:36:0x0039 */
    private void a() throws com.shu.priory.download.e.a {
        Exception e10;
        IOException e11;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        try {
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            try {
                HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(a(this.f16936b.b())).openConnection();
                try {
                    httpURLConnection3.setConnectTimeout(10000);
                    httpURLConnection3.setReadTimeout(10000);
                    httpURLConnection3.setRequestMethod("GET");
                    httpURLConnection3.setRequestProperty("Range", "bytes=0-");
                    int responseCode = httpURLConnection3.getResponseCode();
                    if (responseCode == 200) {
                        a(httpURLConnection3, false);
                    } else {
                        if (responseCode != 206) {
                            throw new com.shu.priory.download.e.a(3, "UnSupported response code:" + responseCode);
                        }
                        a(httpURLConnection3, true);
                    }
                    httpURLConnection3.disconnect();
                } catch (MalformedURLException e12) {
                    e = e12;
                    throw new com.shu.priory.download.e.a(2, "Bad url.", e);
                } catch (ProtocolException e13) {
                    e = e13;
                    throw new com.shu.priory.download.e.a(4, "Protocol error", e);
                } catch (IOException e14) {
                    e11 = e14;
                    throw new com.shu.priory.download.e.a(5, "IO error", e11);
                } catch (Exception e15) {
                    e10 = e15;
                    throw new com.shu.priory.download.e.a(5, "Unknown error", e10);
                }
            } catch (MalformedURLException e16) {
                e = e16;
            } catch (ProtocolException e17) {
                e = e17;
            } catch (IOException e18) {
                e11 = e18;
            } catch (Exception e19) {
                e10 = e19;
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection2 = httpURLConnection;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }

    private void a(HttpURLConnection httpURLConnection, boolean z10) throws com.shu.priory.download.e.a {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        long contentLength = (TextUtils.isEmpty(headerField) || headerField.equals("0") || headerField.equals("-1")) ? httpURLConnection.getContentLength() : Long.parseLong(headerField);
        if (contentLength <= 0) {
            throw new com.shu.priory.download.e.a(6, "length <= 0");
        }
        if (this.f16936b.k()) {
            throw new com.shu.priory.download.e.a(7);
        }
        this.f16937c.a(contentLength, z10);
    }
}
