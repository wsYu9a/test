package com.kwad.sdk.core.download;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.ksad.download.DownloadTask;
import com.kwad.sdk.core.network.s;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.v;
import com.kwad.sdk.utils.w;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpHeaders;

/* loaded from: classes2.dex */
public final class a {

    @SuppressLint({"StaticFieldLeak"})
    private static Context mContext;
    private static volatile boolean mHasInit;

    /* renamed from: com.kwad.sdk.core.download.a$a */
    public static class C0212a implements c {
        final OutputStream aeV;

        public C0212a(File file, boolean z) {
            this.aeV = new FileOutputStream(file, z);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            this.aeV.close();
        }

        @Override // com.kwad.sdk.core.download.a.c
        public final void write(byte[] bArr, int i2, int i3) {
            this.aeV.write(bArr, 0, i3);
        }
    }

    public interface b {
    }

    public interface c extends Closeable {
        void write(byte[] bArr, int i2, int i3);
    }

    @Nullable
    public static String A(AdInfo adInfo) {
        if (mContext == null) {
            return "";
        }
        DownloadParams transform = DownloadParams.transform(adInfo);
        if (TextUtils.isEmpty(transform.mFileUrl)) {
            return null;
        }
        return av.cB(mContext) + File.separator + bL(transform.mFileUrl);
    }

    public static void B(@NonNull AdInfo adInfo) {
        a(adInfo, false);
    }

    private static InputStream a(Map<String, List<String>> map, InputStream inputStream) {
        List<String> value;
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if ("Content-Encoding".equalsIgnoreCase(entry.getKey()) && (value = entry.getValue()) != null && !value.isEmpty()) {
                boolean z = false;
                Iterator<String> it = value.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if ("gzip".equalsIgnoreCase(it.next())) {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    try {
                        return new GZIPInputStream(inputStream);
                    } catch (IOException unused) {
                    }
                } else {
                    continue;
                }
            }
        }
        return inputStream;
    }

    private static URLConnection a(String str, int i2, int i3, boolean z) {
        try {
            URLConnection openConnection = new URL(str).openConnection();
            s.wrapHttpURLConnection(openConnection);
            openConnection.setRequestProperty(HttpHeaders.ACCEPT_LANGUAGE, "zh-CN");
            openConnection.setConnectTimeout(10000);
            if (i3 > 0) {
                openConnection.setReadTimeout(i3);
            }
            openConnection.setUseCaches(false);
            openConnection.setDoInput(true);
            openConnection.setRequestProperty("Connection", "keep-alive");
            openConnection.setRequestProperty("Charset", "UTF-8");
            return openConnection;
        } catch (MalformedURLException e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            return null;
        }
    }

    private static void a(@NonNull AdInfo adInfo, boolean z) {
        Context context = mContext;
        if (context == null) {
            return;
        }
        if (!ag.isNetworkConnected(context)) {
            Context context2 = mContext;
            v.H(context2, w.bN(context2));
            return;
        }
        DownloadParams transform = DownloadParams.transform(adInfo);
        int i2 = 0;
        transform.requestInstallPermission = false;
        String str = transform.mFileUrl;
        if (TextUtils.isEmpty(str) || !URLUtil.isNetworkUrl(str)) {
            return;
        }
        DownloadTask.DownloadRequest downloadRequest = new DownloadTask.DownloadRequest(transform.mFileUrl);
        downloadRequest.setDestinationFileName(bL(str));
        downloadRequest.setTag(transform);
        downloadRequest.setDownloadEnablePause(transform.downloadEnablePause);
        if (ServiceProvider.CB().showNotification && aL(mContext)) {
            i2 = 3;
        }
        downloadRequest.setNotificationVisibility(i2);
        com.ksad.download.kwai.a.a(mContext, transform.mDownloadid, downloadRequest);
    }

    private static boolean a(String str, File file, b bVar, int i2) {
        C0212a c0212a = null;
        try {
            C0212a c0212a2 = new C0212a(file, false);
            try {
                boolean a2 = a(str, (String) null, c0212a2, (b) null, 0);
                com.kwad.sdk.crash.utils.b.closeQuietly(c0212a2);
                return a2;
            } catch (Throwable th) {
                th = th;
                c0212a = c0212a2;
                com.kwad.sdk.crash.utils.b.closeQuietly(c0212a);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean a(String str, File file, b bVar, int i2, boolean z) {
        C0212a c0212a;
        C0212a c0212a2 = null;
        try {
            c0212a = new C0212a(file, true);
        } catch (Throwable th) {
            th = th;
        }
        try {
            boolean a2 = a(str, (String) null, (c) c0212a, (b) null, -1, file.length(), -1L, true);
            com.kwad.sdk.crash.utils.b.closeQuietly(c0212a);
            return a2;
        } catch (Throwable th2) {
            th = th2;
            c0212a2 = c0212a;
            com.kwad.sdk.crash.utils.b.closeQuietly(c0212a2);
            throw th;
        }
    }

    private static boolean a(String str, String str2, c cVar, b bVar, int i2) {
        return a(str, (String) null, cVar, bVar, i2, -1L, -1L, false);
    }

    private static boolean a(String str, String str2, c cVar, b bVar, int i2, long j2, long j3, boolean z) {
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) a(str, 10000, i2 > 0 ? i2 : 120000, false);
            try {
                if (httpURLConnection2 == null) {
                    throw new IOException("Fail to createUrlConnection");
                }
                boolean a2 = a(httpURLConnection2, str2, cVar, bVar, i2, j2, -1L, z);
                com.kwad.sdk.crash.utils.b.closeQuietly(cVar);
                httpURLConnection2.disconnect();
                return a2;
            } catch (Throwable th) {
                th = th;
                httpURLConnection = httpURLConnection2;
                com.kwad.sdk.crash.utils.b.closeQuietly(cVar);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0135 A[Catch: all -> 0x015f, TryCatch #6 {all -> 0x015f, blocks: (B:13:0x0131, B:15:0x0135, B:19:0x015e, B:18:0x0138), top: B:12:0x0131 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0138 A[Catch: all -> 0x015f, TryCatch #6 {all -> 0x015f, blocks: (B:13:0x0131, B:15:0x0135, B:19:0x015e, B:18:0x0138), top: B:12:0x0131 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(java.net.HttpURLConnection r14, java.lang.String r15, com.kwad.sdk.core.download.a.c r16, com.kwad.sdk.core.download.a.b r17, int r18, long r19, long r21, boolean r23) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.download.a.a(java.net.HttpURLConnection, java.lang.String, com.kwad.sdk.core.download.a$c, com.kwad.sdk.core.download.a$b, int, long, long, boolean):boolean");
    }

    public static synchronized void aK(Context context) {
        synchronized (a.class) {
            if (context != null) {
                if (!mHasInit) {
                    mContext = context;
                    com.ksad.download.c.M().init(context);
                    com.kwad.sdk.core.download.c.vu().init(context);
                    mHasInit = true;
                }
            }
        }
    }

    private static boolean aL(Context context) {
        try {
            new NotificationCompat.Builder(context, "");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static String bL(String str) {
        return ad.eC(str) + ".apk";
    }

    public static void bM(String str) {
        if (mContext == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.ksad.download.kwai.a.e(mContext, str);
    }

    public static void c(int i2, AdTemplate adTemplate) {
        com.kwad.sdk.core.download.b bVar = (com.kwad.sdk.core.download.b) ServiceProvider.get(com.kwad.sdk.core.download.b.class);
        if (bVar != null) {
            bVar.b(1, adTemplate);
        }
    }

    public static boolean c(String str, File file) {
        try {
            return a(str, file, (b) null, 0);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            return false;
        }
    }
}
