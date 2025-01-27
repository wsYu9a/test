package com.aggmoread.sdk.z.b.j;

import android.text.TextUtils;
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
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.json.JSONObject;

/* loaded from: classes.dex */
class j {

    /* renamed from: a */
    private static int f4594a = 65536;

    /* renamed from: b */
    private static long f4595b = 2000;

    public static final class a implements X509TrustManager {

        /* renamed from: a */
        private X509TrustManager f4596a;

        public a(KeyStore keyStore) {
            try {
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
                trustManagerFactory.init(keyStore);
                TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                if (trustManagers == null || trustManagers.length == 0) {
                    throw new NoSuchAlgorithmException("no trust manager found.");
                }
                this.f4596a = (X509TrustManager) trustManagers[0];
            } catch (Exception e10) {
                com.aggmoread.sdk.z.b.d.a("DownloadNetworkImpl", "failed to initialize the standard trust manager: " + e10.getMessage());
                this.f4596a = null;
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
            X509TrustManager x509TrustManager = this.f4596a;
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
        } catch (Exception e10) {
            throw new h(-1016, "getContentLengthWithContentRange exception contentRange = " + str, e10);
        }
    }

    private String b(Map<String, List<String>> map) {
        String str = "";
        if (map == null) {
            return "";
        }
        List<String> list = map.get("Content-Disposition");
        if (list != null && list.size() > 0) {
            String str2 = list.get(0);
            com.aggmoread.sdk.z.b.d.c("DownloadNetworkImpl", "Content-Disposition header value = " + str2);
            for (String str3 : str2.split(";")) {
                if (str3.trim().startsWith(com.sigmob.sdk.downloader.core.breakpoint.f.f19043e)) {
                    str = str3.split("=")[1];
                    if (str.startsWith("\"") && str.endsWith("\"")) {
                        str = str.substring(1, str.length() - 1);
                    }
                }
            }
        }
        return str;
    }

    /* JADX WARN: Finally extract failed */
    public String a(n nVar) {
        String str;
        long j10;
        int i10 = 1;
        com.aggmoread.sdk.z.b.d.c("DownloadNetworkImpl", "download enter , " + nVar.toString());
        i e10 = nVar.e();
        if (e10 == i.f4593a) {
            throw new h("DownloadListener EMPTY");
        }
        e10.b();
        String d10 = nVar.d();
        String h10 = nVar.h();
        boolean l10 = nVar.l();
        if (l10) {
            File file = new File(d10, g.a(h10));
            if (l10 && file.exists()) {
                e10.a();
                e10.c();
                e10.a(100, file.length(), file.length());
                e10.a(file);
                return file.getAbsolutePath();
            }
        }
        HttpURLConnection a10 = a(h10, nVar.b(), nVar.j());
        try {
            Map<String, String> g10 = nVar.g();
            if (TextUtils.isEmpty(g10.get("User-Agent"))) {
                str = " , contentRange = ";
                String format = String.format(Locale.ENGLISH, "downloader/%s", 12078564);
                com.aggmoread.sdk.z.b.d.c("DownloadNetworkImpl", "setRequestProperty headerName = User-Agent, headerValue = " + format);
                a10.setRequestProperty("User-Agent", format);
            } else {
                str = " , contentRange = ";
            }
            if (TextUtils.isEmpty(g10.get("Range"))) {
                String format2 = String.format(Locale.ENGLISH, "bytes=%d-", 0);
                com.aggmoread.sdk.z.b.d.c("DownloadNetworkImpl", "setRequestProperty headerName = Range, headerValue = " + format2);
                a10.addRequestProperty("Range", format2);
            }
            for (String str2 : g10.keySet()) {
                com.aggmoread.sdk.z.b.d.c("DownloadNetworkImpl", "setRequestProperty headerName = " + str2 + ", headerValue = " + g10.get(str2));
                a10.setRequestProperty(str2, g10.get(str2));
            }
            try {
                a10.connect();
                int responseCode = a10.getResponseCode();
                int i11 = nVar.i();
                String headerField = a10.getHeaderField(m5.c.f28347t0);
                com.aggmoread.sdk.z.b.d.c("DownloadNetworkImpl", "http responseCode = " + responseCode + ", location = " + headerField);
                HttpURLConnection httpURLConnection = a10;
                int i12 = 0;
                while (a(responseCode) && !TextUtils.isEmpty(headerField)) {
                    try {
                        httpURLConnection.getInputStream().close();
                        httpURLConnection = a(headerField, nVar.b(), nVar.j());
                        httpURLConnection.connect();
                        responseCode = httpURLConnection.getResponseCode();
                        headerField = httpURLConnection.getHeaderField(m5.c.f28347t0);
                        i12 += i10;
                        com.aggmoread.sdk.z.b.d.c("DownloadNetworkImpl", "redirect responseCode = " + responseCode + ", location = " + headerField + " , currentRedirectTimes = " + i12);
                        if (i12 >= i11) {
                            throw new h(-1012, "redirect too many times(" + i11 + ")");
                        }
                        i10 = 1;
                    } catch (IOException e11) {
                        e11.printStackTrace();
                        if (e11 instanceof SocketTimeoutException) {
                            String str3 = "redirect SocketTimeoutException(" + h10 + ")";
                            com.aggmoread.sdk.z.b.d.e("DownloadNetworkImpl", str3);
                            throw new h(-1009, str3, e11);
                        }
                        if (e11 instanceof UnknownHostException) {
                            String str4 = "redirect UnknownHostException(" + h10 + ")";
                            com.aggmoread.sdk.z.b.d.e("DownloadNetworkImpl", str4);
                            throw new h(-1010, str4, e11);
                        }
                        if (!(e11 instanceof ConnectException)) {
                            throw new h(-1011, "redirect(" + e11.getMessage() + ")", e11);
                        }
                        String str5 = "redirect ConnectException(" + h10 + ")";
                        com.aggmoread.sdk.z.b.d.e("DownloadNetworkImpl", str5);
                        throw new h(-1001, str5, e11);
                    }
                }
                com.aggmoread.sdk.z.b.d.c("DownloadNetworkImpl", "final responseCode = " + responseCode);
                if (responseCode < 200 || responseCode >= 300) {
                    try {
                        try {
                            StringBuilder sb2 = new StringBuilder();
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream(), Charset.forName("utf-8")));
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    a(bufferedReader);
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("error", sb2.toString());
                                    jSONObject.put("status", Integer.valueOf(responseCode));
                                    throw new h(-1014, jSONObject.toString());
                                }
                                if (sb2.length() > 0) {
                                    sb2.append('\n');
                                }
                                sb2.append(readLine);
                            }
                        } catch (Exception e12) {
                            throw new h(-1015, e12.getMessage());
                        }
                    } catch (Throwable th2) {
                        httpURLConnection.disconnect();
                        throw th2;
                    }
                } else {
                    e10.a();
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    a(headerFields);
                    com.aggmoread.sdk.z.b.d.c("DownloadNetworkImpl", "eTag = " + httpURLConnection.getHeaderField(m5.c.f28335p0));
                    String f10 = nVar.f();
                    com.aggmoread.sdk.z.b.d.c("DownloadNetworkImpl", "download request file name = " + f10);
                    if (TextUtils.isEmpty(f10)) {
                        f10 = b(headerFields);
                        com.aggmoread.sdk.z.b.d.c("DownloadNetworkImpl", "getFileNameWithContentDisposition= " + f10);
                        if (TextUtils.isEmpty(f10)) {
                            f10 = a(headerFields, h10);
                            com.aggmoread.sdk.z.b.d.c("DownloadNetworkImpl", "getFileNameWithContentType = " + f10);
                        }
                    }
                    com.aggmoread.sdk.z.b.d.c("DownloadNetworkImpl", "final file name = " + f10);
                    File file2 = new File(d10, f10);
                    File file3 = new File(d10, f10.replace("tmp", "apk"));
                    if (l10 && file3.exists()) {
                        httpURLConnection.disconnect();
                        e10.c();
                        e10.a(100, file3.length(), file3.length());
                        e10.a(file3);
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
                        if (nVar.k()) {
                            if (file2.exists()) {
                                file2.delete();
                            }
                            httpURLConnection.disconnect();
                            return "";
                        }
                        InputStream inputStream = httpURLConnection.getInputStream();
                        int contentLength = httpURLConnection.getContentLength();
                        com.aggmoread.sdk.z.b.d.c("DownloadNetworkImpl", "contentLength = " + contentLength);
                        if (contentLength < 0) {
                            String headerField2 = httpURLConnection.getHeaderField("Transfer-Encoding");
                            String headerField3 = httpURLConnection.getHeaderField("Content-Range");
                            int a11 = a(headerField3);
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("transferEncoding = ");
                            sb3.append(headerField2);
                            String str6 = str;
                            sb3.append(str6);
                            sb3.append(a11);
                            sb3.append(" , contentRangeValue = ");
                            sb3.append(headerField3);
                            com.aggmoread.sdk.z.b.d.c("DownloadNetworkImpl", sb3.toString());
                            if (a11 < 0) {
                                throw new h(-1002, "contentLength < 0 , transferEncoding = " + headerField2 + str6 + headerField3);
                            }
                            contentLength = a11;
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(file2);
                        byte[] bArr = new byte[4096];
                        int read = inputStream.read(bArr);
                        if (read > 0) {
                            e10.c();
                        }
                        long j11 = 0;
                        long j12 = 0;
                        long j13 = 0;
                        while (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                            byte[] bArr2 = bArr;
                            long j14 = read + j11;
                            long currentTimeMillis = System.currentTimeMillis();
                            long j15 = currentTimeMillis - j13;
                            long j16 = currentTimeMillis;
                            if (j14 - j12 <= f4594a || j15 <= f4595b) {
                                j16 = j13;
                                j10 = j12;
                            } else {
                                a(fileOutputStream);
                                j10 = j14;
                            }
                            float f11 = 100.0f;
                            if (contentLength > 0) {
                                f11 = 100.0f * j14;
                            }
                            e10.a((int) (f11 / contentLength), j14, contentLength);
                            if (nVar.k()) {
                                break;
                            }
                            bArr = bArr2;
                            read = inputStream.read(bArr2);
                            j12 = j10;
                            j11 = j14;
                            j13 = j16;
                        }
                        a(fileOutputStream);
                        a(inputStream);
                        a((Closeable) fileOutputStream);
                        if (nVar.k()) {
                            if (file2.exists()) {
                                file2.delete();
                            }
                            httpURLConnection.disconnect();
                            return null;
                        }
                        e10.a(100, file2.length(), file2.length());
                        File file4 = new File(file2.getAbsolutePath().replace("tmp", "apk"));
                        file2.renameTo(file4);
                        try {
                            e10.a(file4);
                            httpURLConnection.disconnect();
                            return file4.getAbsolutePath();
                        } catch (Throwable th3) {
                            th = th3;
                            file2 = file4;
                            try {
                                if (file2.exists()) {
                                    file2.delete();
                                }
                                throw new h(-1013, th.getMessage(), th);
                            } catch (Throwable th4) {
                                httpURLConnection.disconnect();
                                throw th4;
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                }
            } catch (IOException e13) {
                e13.printStackTrace();
                if (e13 instanceof SocketTimeoutException) {
                    String str7 = "SocketTimeoutException(" + h10 + ")";
                    com.aggmoread.sdk.z.b.d.e("DownloadNetworkImpl", str7);
                    throw new h(-1009, str7, e13);
                }
                if (e13 instanceof UnknownHostException) {
                    String str8 = "UnknownHostException(" + h10 + ")";
                    com.aggmoread.sdk.z.b.d.e("DownloadNetworkImpl", str8);
                    throw new h(-1010, str8, e13);
                }
                if (!(e13 instanceof ConnectException)) {
                    throw new h(-1011, e13.getMessage(), e13);
                }
                String str9 = "ConnectException(" + h10 + ")";
                com.aggmoread.sdk.z.b.d.e("DownloadNetworkImpl", str9);
                throw new h(-1001, str9, e13);
            }
        } catch (IllegalStateException e14) {
            e14.printStackTrace();
            throw new h(-1007, e14);
        } catch (Exception e15) {
            throw new h(-1008, e15);
        }
    }

    private String a(Map map, String str) {
        List list;
        int lastIndexOf;
        String a10 = g.a(str);
        if (map == null || (list = (List) map.get("Content-Type")) == null || list.size() <= 0) {
            return a10;
        }
        String str2 = (String) list.get(0);
        String trim = str2 == null ? "" : str2.trim();
        com.aggmoread.sdk.z.b.d.c("DownloadNetworkImpl", "Content-Type = " + trim);
        if (trim.startsWith("image/")) {
            String substring = trim.substring(6);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(a10);
            sb2.append(p1.b.f29697h);
            if ("jpeg".equals(substring)) {
                substring = "jpg";
            }
            sb2.append(substring);
            return sb2.toString();
        }
        if (trim.startsWith("application/vnd.android.package-archive")) {
            return a10 + p1.b.f29697h + "apk";
        }
        int lastIndexOf2 = str.lastIndexOf(47);
        String substring2 = lastIndexOf2 > 0 ? str.substring(lastIndexOf2 + 1) : null;
        com.aggmoread.sdk.z.b.d.c("DownloadNetworkImpl", "lastPart = " + substring2);
        if (substring2 == null || substring2.length() <= 0 || (lastIndexOf = substring2.lastIndexOf(46)) <= 0 || substring2.length() - lastIndexOf >= 10) {
            return a10;
        }
        return a10 + substring2.substring(lastIndexOf);
    }

    private HttpURLConnection a(String str, int i10, int i11) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("GET");
            if (httpURLConnection instanceof HttpsURLConnection) {
                X509HostnameVerifier x509HostnameVerifier = SSLSocketFactory.STRICT_HOSTNAME_VERIFIER;
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, new TrustManager[]{new a(null)}, new SecureRandom());
                httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
                httpsURLConnection.setHostnameVerifier(x509HostnameVerifier);
            }
            if (i10 > 0) {
                httpURLConnection.setConnectTimeout(i10);
            }
            if (i11 > 0) {
                httpURLConnection.setReadTimeout(i11);
            }
            return httpURLConnection;
        } catch (MalformedURLException e10) {
            e10.printStackTrace();
            throw new h(-1003, e10);
        } catch (IOException e11) {
            e11.printStackTrace();
            throw new h(-1004, e11);
        } catch (KeyManagementException e12) {
            e12.printStackTrace();
            throw new h(-1006, e12);
        } catch (NoSuchAlgorithmException e13) {
            e13.printStackTrace();
            throw new h(-1005, e13);
        } catch (Exception e14) {
            e14.printStackTrace();
            throw new h(-1000, "getDownloadConnection exception(" + str + ")", e14);
        }
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
        }
    }

    private void a(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                com.aggmoread.sdk.z.b.d.c("DownloadNetworkImpl", "flush and sync to disk");
                fileOutputStream.flush();
                fileOutputStream.getFD().sync();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
        }
    }

    private void a(Map<String, List<String>> map) {
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            StringBuilder sb2 = new StringBuilder();
            if (value != null && value.size() > 0) {
                for (int i10 = 0; i10 < value.size(); i10++) {
                    sb2.append(value.get(i10));
                    sb2.append(",");
                }
            }
            com.aggmoread.sdk.z.b.d.c("DownloadNetworkImpl", "header key = " + key + " , value = " + sb2.toString());
        }
    }

    private boolean a(int i10) {
        return i10 == 301 || i10 == 302 || i10 == 303 || i10 == 300 || i10 == 307 || i10 == 308;
    }
}
