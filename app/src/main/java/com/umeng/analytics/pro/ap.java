package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.SecureRandom;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

/* loaded from: classes4.dex */
public class ap {

    /* renamed from: a */
    private static HostnameVerifier f23438a;

    /* renamed from: com.umeng.analytics.pro.ap$1 */
    public static class AnonymousClass1 implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return "pre-ucc.umeng.com".equalsIgnoreCase(str) || "ucc.umeng.com".equalsIgnoreCase(str) || "aspect-upush.umeng.com".equalsIgnoreCase(str) || "pre-msg.umengcloud.com".equalsIgnoreCase(str) || "ulogs.umeng.com".equalsIgnoreCase(str) || "preulogs.umeng.com".equalsIgnoreCase(str) || "cnlogs.umeng.com".equalsIgnoreCase(str);
        }
    }

    private static HostnameVerifier a() {
        if (f23438a == null) {
            f23438a = new HostnameVerifier() { // from class: com.umeng.analytics.pro.ap.1
                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    if (TextUtils.isEmpty(str)) {
                        return false;
                    }
                    return "pre-ucc.umeng.com".equalsIgnoreCase(str) || "ucc.umeng.com".equalsIgnoreCase(str) || "aspect-upush.umeng.com".equalsIgnoreCase(str) || "pre-msg.umengcloud.com".equalsIgnoreCase(str) || "ulogs.umeng.com".equalsIgnoreCase(str) || "preulogs.umeng.com".equalsIgnoreCase(str) || "cnlogs.umeng.com".equalsIgnoreCase(str);
                }
            };
        }
        return f23438a;
    }

    public static byte[] a(String str, String str2) {
        return a(str, str2.getBytes());
    }

    public static byte[] a(String str, byte[] bArr) {
        byte[] bArr2 = null;
        try {
            HttpsURLConnection a10 = a(str, "ak", ax.a(bArr, UMConfigure.sAppkey.getBytes()));
            if (a10 != null && a10.getResponseCode() == 200) {
                InputStream inputStream = a10.getInputStream();
                try {
                    byte[] readStreamToByteArray = HelperUtils.readStreamToByteArray(inputStream);
                    try {
                        String headerField = a10.getHeaderField("ak");
                        if (!TextUtils.isEmpty(headerField)) {
                            bArr2 = ax.a(readStreamToByteArray, headerField.getBytes());
                        } else {
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "ccg 应答不包含ak!");
                        }
                        HelperUtils.safeClose(inputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        HelperUtils.safeClose(inputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        } catch (Throwable unused) {
        }
        return bArr2;
    }

    public static void a(String str, byte[] bArr, String str2) {
        byte[] bArr2;
        int responseCode;
        HttpsURLConnection httpsURLConnection = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                ax.a(bArr, byteArrayOutputStream);
                bArr2 = ax.a(byteArrayOutputStream.toByteArray(), UMConfigure.sAppkey.getBytes());
            } catch (Throwable unused) {
                bArr2 = null;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "appkey";
            }
            httpsURLConnection = a(str, str2, bArr2);
            if (httpsURLConnection != null && (responseCode = httpsURLConnection.getResponseCode()) != 200) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "SC/ActUp/EkvError event report error, http error code: " + responseCode);
            }
            if (httpsURLConnection == null) {
                return;
            }
        } catch (Throwable th2) {
            try {
                th2.printStackTrace();
                if (httpsURLConnection == null) {
                    return;
                }
            } catch (Throwable th3) {
                if (httpsURLConnection != null) {
                    try {
                        httpsURLConnection.disconnect();
                    } catch (Throwable unused2) {
                    }
                }
                throw th3;
            }
        }
        try {
            httpsURLConnection.disconnect();
        } catch (Throwable unused3) {
        }
    }

    private static HttpsURLConnection a(String str, String str2, byte[] bArr) {
        HttpsURLConnection httpsURLConnection = null;
        try {
            HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) new URL(str).openConnection();
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, null, new SecureRandom());
                httpsURLConnection2.setSSLSocketFactory(sSLContext.getSocketFactory());
                httpsURLConnection2.setHostnameVerifier(a());
                httpsURLConnection2.setRequestMethod("POST");
                httpsURLConnection2.setConnectTimeout(by.f23697b);
                httpsURLConnection2.setDoOutput(true);
                httpsURLConnection2.setDoInput(true);
                httpsURLConnection2.setReadTimeout(by.f23697b);
                httpsURLConnection2.addRequestProperty("Content-Type", "application/octet-stream");
                httpsURLConnection2.addRequestProperty(str2, UMConfigure.sAppkey);
                httpsURLConnection2.setRequestProperty("User-Agent", DeviceConfig.getCustomAgt());
                httpsURLConnection2.connect();
                OutputStream outputStream = httpsURLConnection2.getOutputStream();
                outputStream.write(bArr);
                outputStream.flush();
                outputStream.close();
                return httpsURLConnection2;
            } catch (Exception e10) {
                e = e10;
                httpsURLConnection = httpsURLConnection2;
                e.printStackTrace();
                return httpsURLConnection;
            }
        } catch (Exception e11) {
            e = e11;
        }
    }
}
