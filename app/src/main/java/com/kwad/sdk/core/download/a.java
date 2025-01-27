package com.kwad.sdk.core.download;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.core.network.r;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.z;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/* loaded from: classes3.dex */
public final class a {

    @SuppressLint({"StaticFieldLeak"})
    private static Context mContext;
    private static volatile boolean mHasInit;

    /* renamed from: com.kwad.sdk.core.download.a$a */
    public interface InterfaceC0490a {
    }

    @Nullable
    public static String H(AdInfo adInfo) {
        return dG(DownloadParams.transform(adInfo).mFileUrl);
    }

    public static void I(@NonNull AdInfo adInfo) {
        a(adInfo, false);
    }

    private static void a(@NonNull AdInfo adInfo, boolean z10) {
        try {
            Context context = mContext;
            if (context == null) {
                return;
            }
            if (!al.isNetworkConnected(context)) {
                Context context2 = mContext;
                z.P(context2, ab.co(context2));
                return;
            }
            DownloadParams transform = DownloadParams.transform(adInfo);
            transform.requestInstallPermission = false;
            String str = transform.mFileUrl;
            if (!TextUtils.isEmpty(str) && URLUtil.isNetworkUrl(str)) {
                DownloadTask.DownloadRequest downloadRequest = new DownloadTask.DownloadRequest(transform.mFileUrl);
                downloadRequest.setDestinationFileName(dH(str));
                downloadRequest.setTag(transform);
                downloadRequest.setDownloadEnablePause(transform.downloadEnablePause);
                if (ServiceProvider.MB().showNotification && bn(mContext)) {
                    downloadRequest.setNotificationVisibility(3);
                } else {
                    downloadRequest.setNotificationVisibility(0);
                }
                com.kwad.sdk.d.a.a(mContext, transform.mDownloadid, downloadRequest);
            }
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static synchronized void bm(Context context) {
        synchronized (a.class) {
            if (context != null) {
                if (!mHasInit) {
                    mContext = context;
                    com.kwad.sdk.c.yU().init(context);
                    b.EI().init(context);
                    mHasInit = true;
                }
            }
        }
    }

    private static boolean bn(Context context) {
        try {
            new NotificationCompat.Builder(context, "");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean d(String str, File file) {
        try {
            return a(str, file, null, false);
        } catch (IOException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    private static String dG(String str) {
        if (mContext == null) {
            return "";
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return bb.de(mContext) + File.separator + dH(str);
    }

    private static String dH(String str) {
        return ai.by(str) + ".apk";
    }

    public static void dI(String str) {
        if (mContext == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.kwad.sdk.d.a.D(mContext, str);
    }

    public static void dJ(String str) {
        if (mContext == null) {
            return;
        }
        String dG = dG(str);
        com.kwad.sdk.d.a.e(mContext, ai.by(str), dG);
    }

    private static URLConnection dK(String str) {
        URLConnection openConnection = new URL(str).openConnection();
        r.wrapHttpURLConnection(openConnection);
        openConnection.setRequestProperty(m5.c.f28319k, "zh-CN");
        openConnection.setConnectTimeout(10000);
        openConnection.setReadTimeout(120000);
        openConnection.setUseCaches(false);
        openConnection.setDoInput(true);
        openConnection.setRequestProperty(m5.c.f28331o, "keep-alive");
        openConnection.setRequestProperty("Charset", "UTF-8");
        return openConnection;
    }

    public static void a(String str, File file, boolean z10) {
        a(str, file, null, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0116 A[Catch: all -> 0x0119, TryCatch #7 {all -> 0x0119, blocks: (B:15:0x0112, B:17:0x0116, B:21:0x0141, B:20:0x011b), top: B:14:0x0112 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x011b A[Catch: all -> 0x0119, TryCatch #7 {all -> 0x0119, blocks: (B:15:0x0112, B:17:0x0116, B:21:0x0141, B:20:0x011b), top: B:14:0x0112 }] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8, types: [java.io.Closeable, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r12v9, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(java.lang.String r9, java.io.File r10, com.kwad.sdk.core.download.a.InterfaceC0490a r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.download.a.a(java.lang.String, java.io.File, com.kwad.sdk.core.download.a$a, boolean):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0008, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.io.InputStream a(java.util.Map<java.lang.String, java.util.List<java.lang.String>> r3, java.io.InputStream r4) {
        /*
            java.util.Set r3 = r3.entrySet()
            java.util.Iterator r3 = r3.iterator()
        L8:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L51
            java.lang.Object r0 = r3.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "Content-Encoding"
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 == 0) goto L8
            java.lang.Object r0 = r0.getValue()
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L8
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L8
            java.util.Iterator r0 = r0.iterator()
        L34:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L8
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "gzip"
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 == 0) goto L34
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch: java.io.IOException -> L4f
            r0.<init>(r4)     // Catch: java.io.IOException -> L4f
            r4 = r0
            goto L51
        L4f:
            goto L8
        L51:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.download.a.a(java.util.Map, java.io.InputStream):java.io.InputStream");
    }
}
