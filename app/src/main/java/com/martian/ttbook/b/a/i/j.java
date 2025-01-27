package com.martian.ttbook.b.a.i;

import android.os.Build;
import android.text.TextUtils;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.HttpHeaders;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.json.JSONObject;

/* loaded from: classes4.dex */
class j {

    /* renamed from: a */
    private static int f14993a = 65536;

    /* renamed from: b */
    private static long f14994b = 2000;

    public static final class a implements X509TrustManager {

        /* renamed from: a */
        private X509TrustManager f14995a;

        public a(KeyStore keyStore) {
            try {
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
                trustManagerFactory.init(keyStore);
                TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                if (trustManagers == null || trustManagers.length == 0) {
                    throw new NoSuchAlgorithmException("no trust manager found.");
                }
                this.f14995a = (X509TrustManager) trustManagers[0];
            } catch (Exception e2) {
                b.d.e.c.a.d.d("DownloadNetworkImpl", "failed to initialize the standard trust manager: " + e2.getMessage());
                this.f14995a = null;
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            if (x509CertificateArr == null) {
                throw new IllegalArgumentException("there were no certificates.");
            }
            if (x509CertificateArr.length == 1) {
                x509CertificateArr[0].checkValidity();
                return;
            }
            X509TrustManager x509TrustManager = this.f14995a;
            if (x509TrustManager == null) {
                throw new CertificateException("there were one more certificates but no trust manager found.");
            }
            x509TrustManager.checkServerTrusted(x509CertificateArr, str);
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    j() {
    }

    private int a(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        try {
            Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(str);
            if (!matcher.find()) {
                return -1;
            }
            return (Integer.parseInt(matcher.group(2)) - Integer.parseInt(matcher.group(1))) + 1;
        } catch (Exception e2) {
            throw new h(-1016, "getContentLengthWithContentRange exception contentRange = " + str, e2);
        }
    }

    private String c(Map map, String str) {
        List list;
        int lastIndexOf;
        StringBuilder sb;
        String substring;
        String a2 = g.a(str);
        if (map == null || (list = (List) map.get("Content-Type")) == null || list.size() <= 0) {
            return a2;
        }
        String str2 = (String) list.get(0);
        String trim = str2 == null ? "" : str2.trim();
        b.d.e.c.a.d.k("DownloadNetworkImpl", "Content-Type = " + trim);
        if (trim.startsWith("image/")) {
            substring = trim.substring(6);
            sb = new StringBuilder();
            sb.append(a2);
            sb.append(".");
            if ("jpeg".equals(substring)) {
                substring = "jpg";
            }
        } else {
            if (trim.startsWith(AdBaseConstants.MIME_APK)) {
                return a2 + ".apk";
            }
            int lastIndexOf2 = str.lastIndexOf(47);
            String substring2 = lastIndexOf2 > 0 ? str.substring(lastIndexOf2 + 1) : null;
            b.d.e.c.a.d.k("DownloadNetworkImpl", "lastPart = " + substring2);
            if (substring2 == null || substring2.length() <= 0 || (lastIndexOf = substring2.lastIndexOf(46)) <= 0 || substring2.length() - lastIndexOf >= 10) {
                return a2;
            }
            sb = new StringBuilder();
            sb.append(a2);
            substring = substring2.substring(lastIndexOf);
        }
        sb.append(substring);
        return sb.toString();
    }

    private HttpURLConnection d(String str, int i2, int i3) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("GET");
            if (Build.VERSION.SDK_INT < 8) {
                System.setProperty("http.keepAlive", "false");
            }
            if (httpURLConnection instanceof HttpsURLConnection) {
                X509HostnameVerifier x509HostnameVerifier = SSLSocketFactory.STRICT_HOSTNAME_VERIFIER;
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, new TrustManager[]{new a(null)}, new SecureRandom());
                httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
                httpsURLConnection.setHostnameVerifier(x509HostnameVerifier);
            }
            if (i2 > 0) {
                httpURLConnection.setConnectTimeout(i2);
            }
            if (i3 > 0) {
                httpURLConnection.setReadTimeout(i3);
            }
            return httpURLConnection;
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
            throw new h(-1003, e2);
        } catch (IOException e3) {
            e3.printStackTrace();
            throw new h(-1004, e3);
        } catch (KeyManagementException e4) {
            e4.printStackTrace();
            throw new h(-1006, e4);
        } catch (NoSuchAlgorithmException e5) {
            e5.printStackTrace();
            throw new h(-1005, e5);
        } catch (Exception e6) {
            e6.printStackTrace();
            throw new h(-1000, "getDownloadConnection exception(" + str + ")", e6);
        }
    }

    private void e(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    private void f(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                b.d.e.c.a.d.k("DownloadNetworkImpl", "flush and sync to disk");
                fileOutputStream.flush();
                fileOutputStream.getFD().sync();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    private void g(Map<String, List<String>> map) {
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            StringBuilder sb = new StringBuilder();
            if (value != null && value.size() > 0) {
                for (int i2 = 0; i2 < value.size(); i2++) {
                    sb.append(value.get(i2));
                    sb.append(",");
                }
            }
            b.d.e.c.a.d.k("DownloadNetworkImpl", "header key = " + key + " , value = " + sb.toString());
        }
    }

    private boolean h(int i2) {
        return i2 == 301 || i2 == 302 || i2 == 303 || i2 == 300 || i2 == 307 || i2 == 308;
    }

    private String i(Map<String, List<String>> map) {
        String str = "";
        if (map == null) {
            return "";
        }
        List<String> list = map.get("Content-Disposition");
        if (list != null && list.size() > 0) {
            String str2 = list.get(0);
            b.d.e.c.a.d.k("DownloadNetworkImpl", "Content-Disposition header value = " + str2);
            for (String str3 : str2.split(";")) {
                if (str3.trim().startsWith("filename")) {
                    str = str3.split("=")[1];
                    if (str.startsWith("\"") && str.endsWith("\"")) {
                        str = str.substring(1, str.length() - 1);
                    }
                }
            }
        }
        return str;
    }

    public String b(n nVar) {
        int i2;
        long j2;
        b.d.e.c.a.d.k("DownloadNetworkImpl", "download enter , " + nVar.toString());
        i p = nVar.p();
        if (p == i.f14992a) {
            throw new h("DownloadListener EMPTY");
        }
        p.e();
        String m = nVar.m();
        String t = nVar.t();
        boolean x = nVar.x();
        if (x) {
            File file = new File(m, g.a(t));
            if (x && file.exists()) {
                p.a();
                p.f();
                p.b(100, file.length(), file.length());
                p.d(file);
                return file.getAbsolutePath();
            }
        }
        HttpURLConnection d2 = d(t, nVar.a(), nVar.v());
        try {
            Map<String, String> s = nVar.s();
            int i3 = 1;
            if (TextUtils.isEmpty(s.get("User-Agent"))) {
                String format = String.format(Locale.ENGLISH, "downloader/%s", 12078564);
                b.d.e.c.a.d.k("DownloadNetworkImpl", "setRequestProperty headerName = User-Agent, headerValue = " + format);
                d2.setRequestProperty("User-Agent", format);
            }
            if (TextUtils.isEmpty(s.get(HttpHeaders.RANGE))) {
                String format2 = String.format(Locale.ENGLISH, "bytes=%d-", 0);
                b.d.e.c.a.d.k("DownloadNetworkImpl", "setRequestProperty headerName = Range, headerValue = " + format2);
                d2.addRequestProperty(HttpHeaders.RANGE, format2);
            }
            for (String str : s.keySet()) {
                b.d.e.c.a.d.k("DownloadNetworkImpl", "setRequestProperty headerName = " + str + ", headerValue = " + s.get(str));
                d2.setRequestProperty(str, s.get(str));
            }
            try {
                d2.connect();
                int responseCode = d2.getResponseCode();
                int u = nVar.u();
                String headerField = d2.getHeaderField(HttpHeaders.LOCATION);
                b.d.e.c.a.d.k("DownloadNetworkImpl", "http responseCode = " + responseCode + ", location = " + headerField);
                HttpURLConnection httpURLConnection = d2;
                int i4 = 0;
                while (h(responseCode) && !TextUtils.isEmpty(headerField)) {
                    try {
                        httpURLConnection.getInputStream().close();
                        HttpURLConnection d3 = d(headerField, nVar.a(), nVar.v());
                        d3.connect();
                        responseCode = d3.getResponseCode();
                        headerField = d3.getHeaderField(HttpHeaders.LOCATION);
                        i4 += i3;
                        b.d.e.c.a.d.k("DownloadNetworkImpl", "redirect responseCode = " + responseCode + ", location = " + headerField + " , currentRedirectTimes = " + i4);
                        if (i4 >= u) {
                            throw new h(-1012, "redirect too many times(" + u + ")");
                        }
                        httpURLConnection = d3;
                        i3 = 1;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        if (e2 instanceof SocketTimeoutException) {
                            String str2 = "redirect SocketTimeoutException(" + t + ")";
                            b.d.e.c.a.d.p("DownloadNetworkImpl", str2);
                            throw new h(-1009, str2, e2);
                        }
                        if (e2 instanceof UnknownHostException) {
                            String str3 = "redirect UnknownHostException(" + t + ")";
                            b.d.e.c.a.d.p("DownloadNetworkImpl", str3);
                            throw new h(-1010, str3, e2);
                        }
                        if (!(e2 instanceof ConnectException)) {
                            throw new h(-1011, "redirect(" + e2.getMessage() + ")", e2);
                        }
                        String str4 = "redirect ConnectException(" + t + ")";
                        b.d.e.c.a.d.p("DownloadNetworkImpl", str4);
                        throw new h(-1001, str4, e2);
                    }
                }
                b.d.e.c.a.d.k("DownloadNetworkImpl", "final responseCode = " + responseCode);
                if (responseCode < 200 || responseCode >= 300) {
                    try {
                        try {
                            StringBuilder sb = new StringBuilder();
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream(), Charset.forName("utf-8")));
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    e(bufferedReader);
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("error", sb.toString());
                                    jSONObject.put("status", Integer.valueOf(responseCode));
                                    throw new h(-1014, jSONObject.toString());
                                }
                                if (sb.length() > 0) {
                                    sb.append('\n');
                                }
                                sb.append(readLine);
                            }
                        } catch (Exception e3) {
                            throw new h(-1015, e3.getMessage());
                        }
                    } finally {
                    }
                } else {
                    p.a();
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    g(headerFields);
                    b.d.e.c.a.d.k("DownloadNetworkImpl", "eTag = " + httpURLConnection.getHeaderField(HttpHeaders.ETAG));
                    String r = nVar.r();
                    b.d.e.c.a.d.k("DownloadNetworkImpl", "download request file name = " + r);
                    if (TextUtils.isEmpty(r)) {
                        r = i(headerFields);
                        b.d.e.c.a.d.k("DownloadNetworkImpl", "getFileNameWithContentDisposition= " + r);
                        if (TextUtils.isEmpty(r)) {
                            r = c(headerFields, t);
                            b.d.e.c.a.d.k("DownloadNetworkImpl", "getFileNameWithContentType = " + r);
                        }
                    }
                    b.d.e.c.a.d.k("DownloadNetworkImpl", "final file name = " + r);
                    File file2 = new File(m, r);
                    File file3 = new File(m, r.replace("tmp", "apk"));
                    if (x && file3.exists()) {
                        httpURLConnection.disconnect();
                        p.f();
                        p.b(100, file3.length(), file3.length());
                        p.d(file3);
                        return file3.getAbsolutePath();
                    }
                    if (!file2.getParentFile().exists()) {
                        file2.getParentFile().mkdirs();
                    }
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (file3.exists()) {
                        file3.delete();
                    }
                    try {
                        if (nVar.w()) {
                            if (file2.exists()) {
                                file2.delete();
                            }
                            httpURLConnection.disconnect();
                            return "";
                        }
                        InputStream inputStream = httpURLConnection.getInputStream();
                        int contentLength = httpURLConnection.getContentLength();
                        b.d.e.c.a.d.k("DownloadNetworkImpl", "contentLength = " + contentLength);
                        if (contentLength < 0) {
                            String headerField2 = httpURLConnection.getHeaderField("Transfer-Encoding");
                            String headerField3 = httpURLConnection.getHeaderField("Content-Range");
                            int a2 = a(headerField3);
                            b.d.e.c.a.d.k("DownloadNetworkImpl", "transferEncoding = " + headerField2 + " , contentRange = " + a2 + " , contentRangeValue = " + headerField3);
                            if (a2 < 0) {
                                throw new h(-1002, "contentLength < 0 , transferEncoding = " + headerField2 + " , contentRange = " + headerField3);
                            }
                            i2 = a2;
                        } else {
                            i2 = contentLength;
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(file2);
                        byte[] bArr = new byte[4096];
                        int read = inputStream.read(bArr);
                        if (read > 0) {
                            p.f();
                        }
                        long j3 = 0;
                        long j4 = 0;
                        long j5 = 0;
                        while (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                            byte[] bArr2 = bArr;
                            long j6 = read + j3;
                            long currentTimeMillis = System.currentTimeMillis();
                            long j7 = currentTimeMillis - j5;
                            long j8 = currentTimeMillis;
                            if (j6 - j4 <= f14993a || j7 <= f14994b) {
                                j8 = j5;
                                j2 = j4;
                            } else {
                                f(fileOutputStream);
                                j2 = j6;
                            }
                            float f2 = 100.0f;
                            if (i2 > 0) {
                                f2 = 100.0f * j6;
                            }
                            p.b((int) (f2 / i2), j6, i2);
                            if (nVar.w()) {
                                break;
                            }
                            bArr = bArr2;
                            read = inputStream.read(bArr2);
                            j4 = j2;
                            j3 = j6;
                            j5 = j8;
                        }
                        f(fileOutputStream);
                        e(inputStream);
                        e(fileOutputStream);
                        if (nVar.w()) {
                            if (file2.exists()) {
                                file2.delete();
                            }
                            httpURLConnection.disconnect();
                            return null;
                        }
                        p.b(100, file2.length(), file2.length());
                        File file4 = new File(file2.getAbsolutePath().replace("tmp", "apk"));
                        file2.renameTo(file4);
                        try {
                            p.d(file4);
                            httpURLConnection.disconnect();
                            return file4.getAbsolutePath();
                        } catch (Throwable th) {
                            th = th;
                            file2 = file4;
                            try {
                                if (file2.exists()) {
                                    file2.delete();
                                }
                                throw new h(-1013, th.getMessage(), th);
                            } finally {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (IOException e4) {
                e4.printStackTrace();
                if (e4 instanceof SocketTimeoutException) {
                    String str5 = "SocketTimeoutException(" + t + ")";
                    b.d.e.c.a.d.p("DownloadNetworkImpl", str5);
                    throw new h(-1009, str5, e4);
                }
                if (e4 instanceof UnknownHostException) {
                    String str6 = "UnknownHostException(" + t + ")";
                    b.d.e.c.a.d.p("DownloadNetworkImpl", str6);
                    throw new h(-1010, str6, e4);
                }
                if (!(e4 instanceof ConnectException)) {
                    throw new h(-1011, e4.getMessage(), e4);
                }
                String str7 = "ConnectException(" + t + ")";
                b.d.e.c.a.d.p("DownloadNetworkImpl", str7);
                throw new h(-1001, str7, e4);
            }
        } catch (IllegalStateException e5) {
            e5.printStackTrace();
            throw new h(-1007, e5);
        } catch (Exception e6) {
            throw new h(-1008, e6);
        }
    }
}
