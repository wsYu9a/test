package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.by;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.n;
import com.umeng.analytics.pro.q;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: e */
    private static boolean f24693e = false;

    /* renamed from: f */
    private static boolean f24694f = false;

    /* renamed from: g */
    private static boolean f24695g = false;

    /* renamed from: a */
    private String f24696a = "10.0.0.172";

    /* renamed from: b */
    private int f24697b = 80;

    /* renamed from: c */
    private Context f24698c;

    /* renamed from: d */
    private b f24699d;

    /* renamed from: com.umeng.commonsdk.statistics.internal.c$1 */
    public class AnonymousClass1 implements UMImprintChangeCallback {
        public AnonymousClass1() {
        }

        @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
        public void onImprintValueChanged(String str, String str2) {
            if (FieldManager.b()) {
                FieldManager.a().a(c.this.f24698c, str2);
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> apply imprint change and exit: key=" + str + "; value= " + str2);
                UMWorkDispatch.sendEvent(c.this.f24698c, com.umeng.commonsdk.internal.a.f24487w, com.umeng.commonsdk.internal.b.a(c.this.f24698c).a(), null);
            }
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.internal.c$2 */
    public class AnonymousClass2 implements UMImprintPreProcessCallback {
        public AnonymousClass2() {
        }

        @Override // com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback
        public boolean onPreProcessImprintKey(String str, String str2) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> onImprintValueChanged: key=" + str + "; value= " + str2);
            FieldManager.a().a(c.this.f24698c);
            UMWorkDispatch.sendEvent(c.this.f24698c, com.umeng.commonsdk.internal.a.f24483s, com.umeng.commonsdk.internal.b.a(c.this.f24698c).a(), null);
            ImprintHandler.getImprintService(c.this.f24698c).a(AnalyticsConstants.ZERO_RESPONSE_FLAG);
            return true;
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.internal.c$3 */
    public class AnonymousClass3 implements UMImprintChangeCallback {
        public AnonymousClass3() {
        }

        @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
        public void onImprintValueChanged(String str, String str2) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> first onImprintValueChanged: key=" + str + "; value= " + str2);
            FieldManager.a().a(c.this.f24698c, str2);
            UMWorkDispatch.sendEvent(c.this.f24698c, com.umeng.commonsdk.internal.a.f24483s, com.umeng.commonsdk.internal.b.a(c.this.f24698c).a(), null);
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> recv zcfg response: foregound count timer enabled.");
                if (!UMWorkDispatch.eventHasExist()) {
                    UMWorkDispatch.sendEventEx(c.this.f24698c, q.a.E, CoreProtocol.getInstance(c.this.f24698c), null, 0L);
                }
            }
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> recv zcfg response: FirstResumeTrigger enabled.");
                n.a(c.this.f24698c).b(c.this.f24698c);
            }
            ImprintHandler.getImprintService(c.this.f24698c).unregistImprintCallback(AnalyticsConstants.CFG_FIELD_KEY, this);
        }
    }

    public c(Context context) {
        this.f24698c = context;
    }

    private void b() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f24698c, "domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f24698c, "domain_s", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            UMServerURL.DEFAULT_URL = DataHelper.assembleURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            UMServerURL.SECONDARY_URL = DataHelper.assembleURL(imprintProperty2);
        }
        String imprintProperty3 = UMEnvelopeBuild.imprintProperty(this.f24698c, "oversea_domain_p", "");
        String imprintProperty4 = UMEnvelopeBuild.imprintProperty(this.f24698c, "oversea_domain_s", "");
        if (!TextUtils.isEmpty(imprintProperty3)) {
            UMServerURL.OVERSEA_DEFAULT_URL = DataHelper.assembleURL(imprintProperty3);
        }
        if (!TextUtils.isEmpty(imprintProperty4)) {
            UMServerURL.OVERSEA_SECONDARY_URL = DataHelper.assembleURL(imprintProperty4);
        }
        AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.OVERSEA_DEFAULT_URL, UMServerURL.OVERSEA_SECONDARY_URL};
        if (TextUtils.isEmpty(com.umeng.commonsdk.statistics.b.f24592b)) {
            return;
        }
        if (com.umeng.commonsdk.statistics.b.f24592b.startsWith("460") || com.umeng.commonsdk.statistics.b.f24592b.startsWith("461")) {
            AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.DEFAULT_URL, UMServerURL.SECONDARY_URL};
        }
    }

    private void c() {
        if (f24695g) {
            return;
        }
        ImprintHandler.getImprintService(this.f24698c).registImprintCallback(AnalyticsConstants.CFG_FIELD_KEY, new UMImprintChangeCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.1
            public AnonymousClass1() {
            }

            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                if (FieldManager.b()) {
                    FieldManager.a().a(c.this.f24698c, str2);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> apply imprint change and exit: key=" + str + "; value= " + str2);
                    UMWorkDispatch.sendEvent(c.this.f24698c, com.umeng.commonsdk.internal.a.f24487w, com.umeng.commonsdk.internal.b.a(c.this.f24698c).a(), null);
                }
            }
        });
        f24695g = true;
    }

    private void d() {
        if (f24694f) {
            return;
        }
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 注册零号报文 imprint 应答处理回调。");
        ImprintHandler.getImprintService(this.f24698c).registPreProcessCallback(AnalyticsConstants.ZERO_RESPONSE_FLAG, new UMImprintPreProcessCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.2
            public AnonymousClass2() {
            }

            @Override // com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback
            public boolean onPreProcessImprintKey(String str, String str2) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> onImprintValueChanged: key=" + str + "; value= " + str2);
                FieldManager.a().a(c.this.f24698c);
                UMWorkDispatch.sendEvent(c.this.f24698c, com.umeng.commonsdk.internal.a.f24483s, com.umeng.commonsdk.internal.b.a(c.this.f24698c).a(), null);
                ImprintHandler.getImprintService(c.this.f24698c).a(AnalyticsConstants.ZERO_RESPONSE_FLAG);
                return true;
            }
        });
        ImprintHandler.getImprintService(this.f24698c).registImprintCallback(AnalyticsConstants.CFG_FIELD_KEY, new UMImprintChangeCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.3
            public AnonymousClass3() {
            }

            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> first onImprintValueChanged: key=" + str + "; value= " + str2);
                FieldManager.a().a(c.this.f24698c, str2);
                UMWorkDispatch.sendEvent(c.this.f24698c, com.umeng.commonsdk.internal.a.f24483s, com.umeng.commonsdk.internal.b.a(c.this.f24698c).a(), null);
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> recv zcfg response: foregound count timer enabled.");
                    if (!UMWorkDispatch.eventHasExist()) {
                        UMWorkDispatch.sendEventEx(c.this.f24698c, q.a.E, CoreProtocol.getInstance(c.this.f24698c), null, 0L);
                    }
                }
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> recv zcfg response: FirstResumeTrigger enabled.");
                    n.a(c.this.f24698c).b(c.this.f24698c);
                }
                ImprintHandler.getImprintService(c.this.f24698c).unregistImprintCallback(AnalyticsConstants.CFG_FIELD_KEY, this);
            }
        });
        f24694f = true;
    }

    public void a(b bVar) {
        this.f24699d = bVar;
    }

    private void a() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f24698c, "domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f24698c, "domain_s", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            UMServerURL.DEFAULT_URL = DataHelper.assembleURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            UMServerURL.SECONDARY_URL = DataHelper.assembleURL(imprintProperty2);
        }
        AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.DEFAULT_URL, UMServerURL.SECONDARY_URL};
    }

    private byte[] c(byte[] bArr, String str) {
        if (by.a().b()) {
            return a(bArr, str.replace("ulogs", "cnlogs"));
        }
        return a(bArr, str);
    }

    public byte[] a(byte[] bArr, boolean z10, boolean z11, String str) {
        if (SdkVersion.SDK_TYPE == 0) {
            a();
        } else {
            UMServerURL.DEFAULT_URL = UMServerURL.OVERSEA_DEFAULT_URL;
            UMServerURL.SECONDARY_URL = UMServerURL.OVERSEA_SECONDARY_URL;
            b();
        }
        byte[] bArr2 = null;
        int i10 = 0;
        while (true) {
            String[] strArr = AnalyticsConstants.APPLOG_URL_LIST;
            if (i10 >= strArr.length) {
                break;
            }
            String str2 = strArr[i10];
            if (z11) {
                d();
            } else {
                c();
            }
            String str3 = str2 + File.separator + str;
            if (SdkVersion.SDK_TYPE != 0) {
                bArr2 = a(bArr, str3);
            } else if (i10 == 0) {
                bArr2 = b(bArr, str3);
            } else {
                bArr2 = c(bArr, str3);
            }
            if (bArr2 != null) {
                b bVar = this.f24699d;
                if (bVar != null) {
                    bVar.onRequestSucceed(z10);
                }
            } else {
                b bVar2 = this.f24699d;
                if (bVar2 != null) {
                    bVar2.onRequestFailed();
                }
                i10++;
            }
        }
        return bArr2;
    }

    private byte[] b(byte[] bArr, String str) {
        if (by.a().b()) {
            if (!str.contains("preulogs")) {
                str = str.replace("ulogs", "cnlogs");
            }
            String b10 = by.b(str);
            String c10 = cc.b().c();
            if (!TextUtils.isEmpty(c10)) {
                str = by.a(c10, b10);
            }
            byte[] a10 = a(bArr, str);
            if (a10 != null) {
                return a10;
            }
            String a11 = by.a().a(b10);
            return (TextUtils.isEmpty(a11) || str.equalsIgnoreCase(a11)) ? a10 : a(bArr, a11);
        }
        return a(bArr, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x018e: IF  (r6 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:107:0x019a, block:B:106:0x018e */
    public byte[] a(byte[] bArr, String str) {
        HttpsURLConnection httpsURLConnection;
        OutputStream outputStream;
        OutputStream outputStream2;
        boolean z10;
        UMRTLog.i(UMRTLog.RTLOG_TAG, "[有状态] 上报url: " + str);
        try {
            try {
                b bVar = this.f24699d;
                if (bVar != null) {
                    bVar.onRequestStart();
                }
                httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
                try {
                    z10 = true;
                    if (!f24693e) {
                        httpsURLConnection.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                        SSLContext sSLContext = SSLContext.getInstance("TLS");
                        sSLContext.init(null, null, new SecureRandom());
                        httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
                        f24693e = true;
                    }
                    httpsURLConnection.setRequestProperty("X-Umeng-UTC", String.valueOf(System.currentTimeMillis()));
                    httpsURLConnection.setRequestProperty("X-Umeng-Sdk", a.a(this.f24698c).b());
                    httpsURLConnection.setRequestProperty("Content-Type", a.a(this.f24698c).a());
                    httpsURLConnection.setRequestProperty("Msg-Type", "envelope/json");
                    httpsURLConnection.setRequestProperty("X-Umeng-Pro-Ver", "1.0.0");
                    httpsURLConnection.setRequestProperty("SM-IMP", "1");
                    httpsURLConnection.setRequestProperty("User-Agent", DeviceConfig.getCustomAgt());
                    httpsURLConnection.setConnectTimeout(30000);
                    httpsURLConnection.setReadTimeout(30000);
                    httpsURLConnection.setRequestMethod("POST");
                    httpsURLConnection.setDoOutput(true);
                    httpsURLConnection.setDoInput(true);
                    httpsURLConnection.setUseCaches(false);
                    outputStream = httpsURLConnection.getOutputStream();
                } catch (UnknownHostException unused) {
                    outputStream = null;
                } catch (SSLHandshakeException unused2) {
                    outputStream = null;
                } catch (Throwable unused3) {
                    outputStream = null;
                }
                try {
                    outputStream.write(bArr);
                    outputStream.flush();
                    httpsURLConnection.connect();
                    b bVar2 = this.f24699d;
                    if (bVar2 != null) {
                        bVar2.onRequestEnd();
                    }
                    int responseCode = httpsURLConnection.getResponseCode();
                    String headerField = httpsURLConnection.getHeaderField("Content-Type");
                    if (TextUtils.isEmpty(headerField) || !headerField.equalsIgnoreCase("application/thrift")) {
                        z10 = false;
                    }
                    boolean z11 = AnalyticsConstants.UM_DEBUG;
                    if (responseCode == 200 && z10) {
                        InputStream inputStream = httpsURLConnection.getInputStream();
                        try {
                            byte[] readStreamToByteArray = HelperUtils.readStreamToByteArray(inputStream);
                            try {
                                outputStream.close();
                            } catch (Exception e10) {
                                UMCrashManager.reportCrash(this.f24698c, e10);
                            }
                            try {
                                httpsURLConnection.getInputStream().close();
                            } catch (IOException unused4) {
                            }
                            httpsURLConnection.disconnect();
                            return readStreamToByteArray;
                        } finally {
                            HelperUtils.safeClose(inputStream);
                        }
                    }
                    try {
                        outputStream.close();
                    } catch (Exception e11) {
                        UMCrashManager.reportCrash(this.f24698c, e11);
                    }
                    try {
                        httpsURLConnection.getInputStream().close();
                    } catch (IOException unused5) {
                    }
                    httpsURLConnection.disconnect();
                    return null;
                } catch (UnknownHostException unused6) {
                    UMLog.aq("A_10200", 2, "\\|");
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e12) {
                            UMCrashManager.reportCrash(this.f24698c, e12);
                        }
                    }
                    if (httpsURLConnection != null) {
                        try {
                            httpsURLConnection.getInputStream().close();
                        } catch (IOException unused7) {
                        }
                        httpsURLConnection.disconnect();
                    }
                    return null;
                } catch (SSLHandshakeException unused8) {
                    UMLog.aq("A_10201", 2, "\\|");
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e13) {
                            UMCrashManager.reportCrash(this.f24698c, e13);
                        }
                    }
                    if (httpsURLConnection != null) {
                        try {
                            httpsURLConnection.getInputStream().close();
                        } catch (IOException unused9) {
                        }
                        httpsURLConnection.disconnect();
                    }
                    return null;
                } catch (Throwable unused10) {
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e14) {
                            UMCrashManager.reportCrash(this.f24698c, e14);
                        }
                    }
                    if (httpsURLConnection != null) {
                        try {
                            httpsURLConnection.getInputStream().close();
                        } catch (IOException unused11) {
                        }
                        httpsURLConnection.disconnect();
                    }
                    return null;
                }
            } catch (UnknownHostException unused12) {
                httpsURLConnection = null;
                outputStream = null;
            } catch (SSLHandshakeException unused13) {
                httpsURLConnection = null;
                outputStream = null;
            } catch (Throwable unused14) {
                httpsURLConnection = null;
                outputStream = null;
            }
        } catch (Throwable th2) {
            if (outputStream2 != null) {
                try {
                    outputStream2.close();
                } catch (Exception e15) {
                    UMCrashManager.reportCrash(this.f24698c, e15);
                }
            }
            if (str != 0) {
                try {
                    str.getInputStream().close();
                } catch (IOException unused15) {
                }
                str.disconnect();
                throw th2;
            }
            throw th2;
        }
    }
}
