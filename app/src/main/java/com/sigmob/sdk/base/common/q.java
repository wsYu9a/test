package com.sigmob.sdk.base.common;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.network.ResponseHeader;
import com.czhj.sdk.logger.SigmobLog;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class q extends AsyncTask<String, Void, HashMap<String, String>> {

    /* renamed from: b */
    public static final int f18017b = 10;

    /* renamed from: a */
    public final a f18018a;

    public interface a {
        void a(String str, String str2);

        void a(String str, Throwable th2);
    }

    public q(a aVar) {
        this.f18018a = aVar;
    }

    public static String b(String str) {
        if (!str.toLowerCase().contains(".apk")) {
            return null;
        }
        String e10 = e(str);
        if (!TextUtils.isEmpty(e10)) {
            return e10;
        }
        String d10 = d(str);
        if (TextUtils.isEmpty(d10)) {
            return null;
        }
        return d10;
    }

    public static String d(String str) {
        try {
            Matcher matcher = Pattern.compile("[\\w\\.]+\\.apk", 2).matcher(str);
            if (matcher.find()) {
                return matcher.group(0);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String e(String str) {
        try {
            Matcher matcher = Pattern.compile("(fsname=)(.*?apk)", 2).matcher(str);
            if (matcher.find()) {
                return matcher.group(2);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String f(String str) throws IOException, URISyntaxException {
        HttpURLConnection httpURLConnection;
        String str2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
        }
        try {
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.addRequestProperty(ResponseHeader.USER_AGENT.getKey(), Networking.getUserAgent());
            int responseCode = httpURLConnection.getResponseCode();
            String headerField = httpURLConnection.getHeaderField(m5.c.f28347t0);
            if (responseCode >= 300 && responseCode < 400) {
                str2 = headerField;
            }
        } catch (Throwable th3) {
            th = th3;
            try {
                SigmobLog.e("resolveRedirectLocation fail", th);
            } finally {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }
        }
        return str2;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public HashMap<String, String> doInBackground(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            String str = strArr[0];
            try {
                str = c(str);
            } catch (Throwable th2) {
                SigmobLog.e(th2.getMessage());
            }
            hashMap.put("url", str);
            hashMap.put(TTDownloadField.TT_FILE_NAME, a(str));
        } catch (Throwable th3) {
            SigmobLog.e(th3.getMessage());
        }
        return hashMap;
    }

    public final String c(String str) throws IOException, URISyntaxException {
        String str2 = null;
        while (str != null) {
            try {
                str2 = str;
                str = f(str);
            } catch (Throwable th2) {
                SigmobLog.e(th2.getMessage());
                return str;
            }
        }
        return str2;
    }

    @Override // android.os.AsyncTask
    public void onCancelled() {
        super.onCancelled();
        this.f18018a.a("Task for resolving url was cancelled", (Throwable) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0094, code lost:
    
        if (r1 != null) goto L86;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String a(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 0
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> Lf
            if (r1 != 0) goto L13
            java.lang.String r8 = b(r8)     // Catch: java.lang.Throwable -> Lf
            r1 = r0
        Lc:
            r0 = r8
            goto L94
        Lf:
            r8 = move-exception
            r1 = r0
            goto L97
        L13:
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> Lf
            r1.<init>(r8)     // Catch: java.lang.Throwable -> Lf
            java.net.URLConnection r1 = r1.openConnection()     // Catch: java.lang.Throwable -> Lf
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch: java.lang.Throwable -> Lf
            r2 = 0
            r1.setInstanceFollowRedirects(r2)     // Catch: java.lang.Throwable -> L44
            com.czhj.sdk.common.network.ResponseHeader r2 = com.czhj.sdk.common.network.ResponseHeader.USER_AGENT     // Catch: java.lang.Throwable -> L44
            java.lang.String r2 = r2.getKey()     // Catch: java.lang.Throwable -> L44
            java.lang.String r3 = com.czhj.sdk.common.network.Networking.getUserAgent()     // Catch: java.lang.Throwable -> L44
            r1.addRequestProperty(r2, r3)     // Catch: java.lang.Throwable -> L44
            java.lang.String r2 = a(r8, r1)     // Catch: java.lang.Throwable -> L44
            java.lang.String r3 = ".apk"
            if (r2 == 0) goto L53
            java.lang.String r4 = "fsname="
            boolean r4 = r2.contains(r4)     // Catch: java.lang.Throwable -> L44
            if (r4 == 0) goto L46
            java.lang.String r8 = e(r8)     // Catch: java.lang.Throwable -> L44
            goto Lc
        L44:
            r8 = move-exception
            goto L97
        L46:
            boolean r8 = r2.contains(r3)     // Catch: java.lang.Throwable -> L44
            if (r8 == 0) goto L51
            java.lang.String r8 = d(r2)     // Catch: java.lang.Throwable -> L44
            goto Lc
        L51:
            r0 = r2
            goto L94
        L53:
            boolean r4 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Throwable -> L44
            if (r4 != 0) goto L94
            android.net.Uri r4 = android.net.Uri.parse(r8)     // Catch: java.lang.Throwable -> L44
            java.lang.String r4 = r4.getPath()     // Catch: java.lang.Throwable -> L44
            java.lang.String r5 = "/"
            java.lang.String[] r4 = r4.split(r5)     // Catch: java.lang.Throwable -> L44
            int r5 = r4.length     // Catch: java.lang.Throwable -> L44
            r6 = 1
            if (r5 <= r6) goto L6f
            int r2 = r4.length     // Catch: java.lang.Throwable -> L44
            int r2 = r2 - r6
            r2 = r4[r2]     // Catch: java.lang.Throwable -> L44
        L6f:
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L44
            if (r4 != 0) goto L7f
            java.lang.String r2 = r2.toLowerCase()     // Catch: java.lang.Throwable -> L44
            boolean r2 = r2.endsWith(r3)     // Catch: java.lang.Throwable -> L44
            if (r2 != 0) goto L94
        L7f:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L44
            r2.<init>()     // Catch: java.lang.Throwable -> L44
            java.lang.String r8 = com.czhj.sdk.common.utils.Md5Util.md5(r8)     // Catch: java.lang.Throwable -> L44
            r2.append(r8)     // Catch: java.lang.Throwable -> L44
            r2.append(r3)     // Catch: java.lang.Throwable -> L44
            java.lang.String r8 = r2.toString()     // Catch: java.lang.Throwable -> L44
            goto Lc
        L94:
            if (r1 == 0) goto La1
            goto L9e
        L97:
            java.lang.String r2 = "getDownloadUrlFilename"
            com.czhj.sdk.logger.SigmobLog.e(r2, r8)     // Catch: java.lang.Throwable -> La2
            if (r1 == 0) goto La1
        L9e:
            r1.disconnect()
        La1:
            return r0
        La2:
            r8 = move-exception
            if (r1 == 0) goto La8
            r1.disconnect()
        La8:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.common.q.a(java.lang.String):java.lang.String");
    }

    public static void a(String str, a aVar) {
        try {
            String b10 = b(str);
            if (TextUtils.isEmpty(b10)) {
                new q(aVar).executeOnExecutor(ThreadPoolFactory.BackgroundThreadPool.getInstance().getExecutorService(), str);
            } else {
                aVar.a(b10, str);
            }
        } catch (Throwable th2) {
            aVar.a("Failed to resolve url", th2);
        }
    }

    public static String a(String str, HttpURLConnection httpURLConnection) throws IOException, URISyntaxException {
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode < 200 || responseCode >= 400) {
            return null;
        }
        try {
            return URLUtil.guessFileName(str, httpURLConnection.getHeaderField("Content-Disposition"), null);
        } catch (IllegalArgumentException unused) {
            SigmobLog.e("Invalid URL redirection. baseUrl=" + str);
            throw new URISyntaxException(str, "Unable to parse invalid URL");
        } catch (NullPointerException e10) {
            SigmobLog.e("Invalid URL redirection. baseUrl=" + str);
            throw e10;
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(HashMap<String, String> hashMap) {
        String str;
        String str2;
        if (hashMap != null) {
            str = hashMap.get(TTDownloadField.TT_FILE_NAME);
            str2 = hashMap.get("url");
        } else {
            str = null;
            str2 = null;
        }
        this.f18018a.a(str, str2);
    }
}
