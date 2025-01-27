package com.sigmob.sdk.base.common;

import android.net.Uri;
import android.os.AsyncTask;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.network.ResponseHeader;
import com.czhj.sdk.logger.SigmobLog;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/* loaded from: classes4.dex */
public class l0 extends AsyncTask<String, Void, String> {

    /* renamed from: b */
    public static final int f17957b = 10;

    /* renamed from: a */
    public final a f17958a;

    public interface a {
        void a(String str);

        void a(String str, Throwable th2);
    }

    public l0(a aVar) {
        this.f17958a = aVar;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        Throwable th2;
        String str;
        String str2 = null;
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        try {
            String str3 = strArr[0];
            while (true) {
                String str4 = str2;
                str2 = str3;
                str = str4;
                if (str2 == null) {
                    break;
                }
                try {
                    if (!j0.f17912h.a(Uri.parse(str2), 0)) {
                        return str2;
                    }
                    str3 = a(str2);
                } catch (Throwable th3) {
                    th2 = th3;
                    SigmobLog.w(th2.getMessage());
                    return str;
                }
            }
        } catch (Throwable th4) {
            String str5 = str2;
            th2 = th4;
            str = str5;
        }
        return str;
    }

    @Override // android.os.AsyncTask
    /* renamed from: b */
    public void onPostExecute(String str) {
        super.onPostExecute(str);
        if (isCancelled() || str == null) {
            onCancelled();
        } else {
            this.f17958a.a(str);
        }
    }

    @Override // android.os.AsyncTask
    public void onCancelled() {
        super.onCancelled();
        this.f17958a.a("Task for resolving url was cancelled", null);
    }

    public final String a(String str) throws IOException, URISyntaxException {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.addRequestProperty(ResponseHeader.USER_AGENT.getKey(), Networking.getUserAgent());
            String a10 = a(str, httpURLConnection);
            InputStream inputStream = httpURLConnection.getInputStream();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable unused) {
                    SigmobLog.d("IOException when closing httpUrlConnection. Ignoring.");
                }
            }
            httpURLConnection.disconnect();
            return a10;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection2 = httpURLConnection;
            if (httpURLConnection2 != null) {
                InputStream inputStream2 = httpURLConnection2.getInputStream();
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Throwable unused2) {
                        SigmobLog.d("IOException when closing httpUrlConnection. Ignoring.");
                    }
                }
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }

    public static void a(String str, a aVar) {
        try {
            new l0(aVar).executeOnExecutor(ThreadPoolFactory.BackgroundThreadPool.getInstance().getExecutorService(), str);
        } catch (Throwable th2) {
            aVar.a("Failed to resolve url", th2);
        }
    }

    public static String a(String str, HttpURLConnection httpURLConnection) throws IOException, URISyntaxException {
        URI uri = new URI(str);
        int responseCode = httpURLConnection.getResponseCode();
        String headerField = httpURLConnection.getHeaderField(m5.c.f28347t0);
        if (responseCode < 300 || responseCode >= 400) {
            return null;
        }
        try {
            return uri.resolve(headerField).toString();
        } catch (IllegalArgumentException unused) {
            SigmobLog.e("Invalid URL redirection. baseUrl=" + str + "\n redirectUrl=" + headerField);
            throw new URISyntaxException(headerField, "Unable to parse invalid URL");
        } catch (Throwable th2) {
            SigmobLog.e("Invalid URL redirection. baseUrl=" + str + "\n redirectUrl=" + headerField);
            throw th2;
        }
    }
}
