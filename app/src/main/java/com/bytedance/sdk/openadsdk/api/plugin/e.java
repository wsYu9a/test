package com.bytedance.sdk.openadsdk.api.plugin;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginInstallListener;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.download.PluginDownloadBean;
import com.bytedance.pangle.log.IZeusLogger;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class e {

    /* renamed from: d */
    private static volatile BaseDexClassLoader f8066d;

    /* renamed from: l */
    private static volatile TTPluginListener f8068l;

    /* renamed from: i */
    private final Context f8072i;

    /* renamed from: a */
    private static final String f8063a = id.c.f26970g + File.separator;

    /* renamed from: b */
    private static final HashMap<String, TTPluginListener> f8064b = new HashMap<>();

    /* renamed from: c */
    private static final HashMap<String, Handler> f8065c = new HashMap<>();

    /* renamed from: e */
    private static volatile e f8067e = null;

    /* renamed from: f */
    private final CountDownLatch f8069f = new CountDownLatch(1);

    /* renamed from: g */
    private volatile boolean f8070g = false;

    /* renamed from: h */
    private volatile String f8071h = "none";

    /* renamed from: j */
    private JSONObject f8073j = new JSONObject();

    /* renamed from: k */
    private EventListener f8074k = null;

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.e$1 */
    public class AnonymousClass1 implements IZeusReporter {
        public AnonymousClass1() {
        }

        @Override // com.bytedance.pangle.log.IZeusReporter
        public void report(String str, JSONObject jSONObject) {
            if ("load_finish".equals(str) && jSONObject != null && "com.byted.pangle".endsWith(jSONObject.optString("plugin_package_name"))) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("duration", jSONObject.opt("duration"));
                    jSONObject2.put(b7.d.f1362o, jSONObject.opt(b7.d.f1362o));
                    e.this.f8073j.put("zeus", jSONObject2);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
            if (TTAdSdk.isInitSuccess()) {
                com.bytedance.sdk.openadsdk.api.plugin.c.a(str, jSONObject);
            } else {
                com.bytedance.sdk.openadsdk.api.plugin.c.b(str, jSONObject);
            }
        }

        @Override // com.bytedance.pangle.log.IZeusReporter
        public void saveRecord(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.plugin.b.a(str, str2);
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.e$2 */
    public class AnonymousClass2 extends ZeusPluginStateListener {
        public AnonymousClass2() {
        }

        @Override // com.bytedance.pangle.ZeusPluginStateListener
        public void onPluginStateChange(String str, int i10, Object... objArr) {
            com.bytedance.sdk.openadsdk.api.c.b("TTPluginManager", str + " state changed, " + i10);
            if (i10 != 9 || TextUtils.equals(str, "com.byted.pangle")) {
                return;
            }
            e.this.c(str);
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.e$3 */
    public class AnonymousClass3 implements ZeusPluginInstallListener {
        public AnonymousClass3() {
        }

        @Override // com.bytedance.pangle.ZeusPluginInstallListener
        public void onPluginInstall(String str, int i10, String str2) {
            if (i10 == 7) {
                e.this.b(str, i10);
                return;
            }
            if (i10 == 6) {
                e.this.b(str, i10);
                if (e.this.f8074k == null || !"com.byted.pangle".equals(str)) {
                    com.bytedance.sdk.openadsdk.api.c.b("TTPluginManager", "no main pl");
                } else {
                    e.this.f8074k.onEvent(0, com.bykv.a.a.a.a.a.a().a(true).b());
                }
            }
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.e$4 */
    public class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ TTPluginListener f8078a;

        public AnonymousClass4(TTPluginListener tTPluginListener) {
            tTPluginListener = tTPluginListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.api.c.b("TTPluginManager", "Load plugin failed, caused by timeout.");
            tTPluginListener.onPluginListener(1001, null, null, null);
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.e$5 */
    public class AnonymousClass5 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ TTPluginListener f8080a;

        public AnonymousClass5(TTPluginListener tTPluginListener) {
            tTPluginListener = tTPluginListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            String packageName = tTPluginListener.packageName();
            Plugin plugin = (Zeus.isPluginInstalled(packageName) && (Zeus.isPluginLoaded(packageName) || Zeus.loadPlugin(packageName))) ? Zeus.getPlugin(packageName) : null;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Find plugin:");
            sb2.append(plugin != null);
            com.bytedance.sdk.openadsdk.api.c.b("TTPluginManager", sb2.toString());
            if (plugin == null) {
                TTPluginListener unused = e.f8068l = tTPluginListener;
            } else {
                e.b(plugin);
                tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
            }
        }
    }

    public static final class a extends PluginDownloadBean {

        /* renamed from: a */
        public String f8082a = "";

        /* renamed from: b */
        public File f8083b = null;

        public a() {
            this.mBackupUrlList = null;
        }
    }

    public static final class b implements IZeusLogger {
        private b() {
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void e(String str, String str2, Throwable th2) {
            com.bytedance.sdk.openadsdk.api.c.c(str, str2, th2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void i(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.c.c(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void v(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.c.a(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void w(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.c.d(str, str2);
        }

        public /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void w(String str, String str2, Throwable th2) {
            com.bytedance.sdk.openadsdk.api.c.b(str, str2, th2);
        }
    }

    public static final class c implements EventListener, Serializable {
        private void a(a aVar) {
            try {
                if (TextUtils.isEmpty(aVar.mPackageName) || !aVar.mPackageName.equals("com.byted.pangle")) {
                    return;
                }
                e.a(TTAppContextHolder.getContext()).b();
            } catch (Exception unused) {
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.EventListener
        public ValueSet onEvent(int i10, Result result) {
            com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a();
            if (i10 == 1) {
                com.bytedance.sdk.openadsdk.api.plugin.b.a("plugin_download", "plugin update start");
                ValueSet values = result.values();
                if (values == null) {
                    com.bytedance.sdk.openadsdk.api.plugin.b.a("plugin_download", "valueSet empty");
                    return null;
                }
                String stringValue = values.stringValue(3);
                int code = result.code();
                if (!result.isSuccess()) {
                    com.bytedance.sdk.openadsdk.api.plugin.b.a("plugin_download", "plugin update received failed");
                    com.bytedance.sdk.openadsdk.api.c.d("TTPluginManager", "plugin update received failed");
                    e.c(stringValue, code);
                    return null;
                }
                a d10 = e.d(values.stringValue(2));
                if (d10 == null || TextUtils.isEmpty(d10.mPackageName)) {
                    com.bytedance.sdk.openadsdk.api.plugin.b.a("plugin_download", "plugin update received with invalid config");
                    com.bytedance.sdk.openadsdk.api.c.d("TTPluginManager", "plugin update received with invalid config");
                    return null;
                }
                com.bytedance.sdk.openadsdk.api.plugin.b.a("plugin_download", "plugin update received: " + d10.mPackageName);
                com.bytedance.sdk.openadsdk.api.c.d("TTPluginManager", "plugin update received: " + d10.mPackageName);
                if (d10.isRevert()) {
                    com.bytedance.sdk.openadsdk.api.plugin.b.a("plugin_download", "plugin revert " + d10.mPackageName);
                    Zeus.unInstallPlugin(d10.mPackageName);
                } else {
                    a(d10);
                    com.bytedance.sdk.openadsdk.api.plugin.b.a("plugin_download", "plugin install");
                    if (e.b(d10)) {
                        a10.a(4, true);
                    }
                }
            }
            return a10.b();
        }
    }

    private e(Context context) {
        this.f8072i = context.getApplicationContext();
        try {
            GlobalParam.getInstance().closeHookHuaweiOnInit(true);
        } catch (Throwable th2) {
            com.bytedance.sdk.openadsdk.api.c.b("TTPluginManager", "Unexpected error for closeHookHuaweiOnInit.", th2);
        }
        b(context.getApplicationContext());
    }

    public static a d(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return a(new JSONObject(str));
        } catch (JSONException unused) {
            com.bytedance.sdk.openadsdk.api.c.e("TTPluginManager", "Invalid plugin info:" + str);
            return null;
        }
    }

    public void c(String str) {
        Plugin plugin = Zeus.getPlugin(str, false);
        try {
            if (plugin.mClassLoader != null) {
                TTAdSdk.getAdManager().register(com.bykv.a.a.a.a.b.a(3).a(0, 1).a(1, str).a(2, plugin.mClassLoader).b());
            }
        } catch (Throwable th2) {
            com.bytedance.sdk.openadsdk.api.c.a("TTPluginManager", "initPluginService failed in " + str, th2);
        }
    }

    private void b(Context context) {
        try {
            AnonymousClass1 anonymousClass1 = new IZeusReporter() { // from class: com.bytedance.sdk.openadsdk.api.plugin.e.1
                public AnonymousClass1() {
                }

                @Override // com.bytedance.pangle.log.IZeusReporter
                public void report(String str, JSONObject jSONObject) {
                    if ("load_finish".equals(str) && jSONObject != null && "com.byted.pangle".endsWith(jSONObject.optString("plugin_package_name"))) {
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("duration", jSONObject.opt("duration"));
                            jSONObject2.put(b7.d.f1362o, jSONObject.opt(b7.d.f1362o));
                            e.this.f8073j.put("zeus", jSONObject2);
                        } catch (Exception e10) {
                            e10.printStackTrace();
                        }
                    }
                    if (TTAdSdk.isInitSuccess()) {
                        com.bytedance.sdk.openadsdk.api.plugin.c.a(str, jSONObject);
                    } else {
                        com.bytedance.sdk.openadsdk.api.plugin.c.b(str, jSONObject);
                    }
                }

                @Override // com.bytedance.pangle.log.IZeusReporter
                public void saveRecord(String str, String str2) {
                    com.bytedance.sdk.openadsdk.api.plugin.b.a(str, str2);
                }
            };
            GlobalParam globalParam = GlobalParam.getInstance();
            globalParam.setReporter(anonymousClass1);
            globalParam.setCheckPermission(false);
            globalParam.setDownloadDir(c(context));
            globalParam.setLogger(new b());
            globalParam.setSignature("com.byted.pangle", "MIIDfTCCAmWgAwIBAgIEfRwYPjANBgkqhkiG9w0BAQsFADBvMQswCQYDVQQGEwJDTjEQMA4GA1UECBMHQmVpamluZzEQMA4GA1UEBxMHQmVpamluZzESMBAGA1UEChMJQnl0ZURhbmNlMQ8wDQYDVQQLEwZQYW5nbGUxFzAVBgNVBAMTDkNodWFuIFNoYW4gSmlhMB4XDTIxMTEwODA2MjQzOVoXDTQ2MTEwMjA2MjQzOVowbzELMAkGA1UEBhMCQ04xEDAOBgNVBAgTB0JlaWppbmcxEDAOBgNVBAcTB0JlaWppbmcxEjAQBgNVBAoTCUJ5dGVEYW5jZTEPMA0GA1UECxMGUGFuZ2xlMRcwFQYDVQQDEw5DaHVhbiBTaGFuIEppYTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAIBKeRL+4mfCn1SLYv6OemfwwItkjlLPyqOEugkV6lanFTcZgLwEl5LIkL0y28UncPtMX1Mii6DzCdJ/plw7S9+RT/hYDneu339IKWojaU2qai/5FokHlQ0MMnYl5yry00ghVPsl1u+03cQA2ZnjIMiFhrBJpQzHt7IYvq2aEEMBcY8uT7iFoBI848e1mL1joVS2z02C3NliP7ZNARkXH+rTQAlCJulT5IZk+V/PTaKqzgNrkhsKh0/tBmU7m8u79x/xpgGsE19H18AgS4P/9/MDCRe2Z35boZeccaUy2MXCwv3djzUcDk3rRzQPYzdpyyRnrFMuhiKesc5VHgUMs9kCAwEAAaMhMB8wHQYDVR0OBBYEFENENrNWGzc2WhxdvhoMDs57U70zMA0GCSqGSIb3DQEBCwUAA4IBAQAHqDCrmvyBBmIGXwuL1rwS/Qv9ZJIZykBIaNMm+H1IfitCl4yXd9N2n+PjE0UZtxZ21UZOt9wAr+RFiSl5YRXqpt7WLARTy4YW3RiQ+wiL7bshzeSYBoSiC427Bfeq0WjwY0/jHlr8uouppyJOz++6U9hrYX2EW/6UjH5XlWiKQJ6b2ZzPcP8Xpg/TJn4tWvXJP6jw9kRRP2GmMttY78leWQst2QEZILmWJubXRLPj9O+qx2uP9oGTD4sc1vb9hzkOHBIHzGaalqLFbbGaeFpLFHoGTsnOfPTwUVKDZYmxbkcmR1bp7eYOW+nSQNMLn0FjDewZl5l37Sa/gz0WVHon");
            globalParam.setSignature("com.byted.csj.ext", "MIIDezCCAmOgAwIBAgIENkE1KDANBgkqhkiG9w0BAQsFADBtMQswCQYDVQQGEwI4NjEQMA4GA1UECBMHYmVpamluZzEQMA4GA1UEBxMHYmVpamluZzESMBAGA1UEChMJYnl0ZWRhbmNlMRIwEAYDVQQLEwlieXRlZGFuY2UxEjAQBgNVBAMTCWJ5dGVkYW5jZTAgFw0yMjExMDIwODI3MzlaGA8yMDUwMDMyMDA4MjczOVowbTELMAkGA1UEBhMCODYxEDAOBgNVBAgTB2JlaWppbmcxEDAOBgNVBAcTB2JlaWppbmcxEjAQBgNVBAoTCWJ5dGVkYW5jZTESMBAGA1UECxMJYnl0ZWRhbmNlMRIwEAYDVQQDEwlieXRlZGFuY2UwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCc9Z2F3xxOMX1qTXMy2aPmS9OSkqrp8C8bHwS1hkNVR4umKREuqOn73INNo+R706jaCVnlPwxDwWjtX6H74DE4CveivyM9f2wNC3yIyDW+5j7lW/keTQcOlGLDEJQv4O/6FbB/jNU6epjyNaNIZhgZcvTpgaSixbdyHzRTFmvMh+WovdVK/J9LnHOQ+pmPZj7NB6MQRGMUrPEotLHQca3cmnLrnPAaZQaVoaFE9lOt9syyqEuf361SprNIGDtbkJuX3EqV/QOKWFwZX94IS7ZGSvfyCojcD4kaUSbaSoZC7zEuBb7l69g+ZMrJ/v6wkm01wxsNNssUwF7k6Sp0zubbAgMBAAGjITAfMB0GA1UdDgQWBBSxk+gVdDco1dP65hP67qoKNlMEYDANBgkqhkiG9w0BAQsFAAOCAQEAfosExl/AYEbS2xqHBTHa28cvnp/SElUQuzW6aWLqkfk9cxmFSI/euUV3/eB8RN+U2X47Y05u6+XUxTv0tSSEtyXNawm0qWH8jkR4gZY38YqBChKjhea668oT5X3Uocrw7SYXO/BfI8SKPa0uI/U8Cyl3uctbmmq/pPUkd3mKAy+HgyJoThD6K0oyiADlygngUMVTv6Uvid4qPj/bBnxI+LvVeX4l1dxGqWkiafQW9sz+RbFdge3X2XsSH4eo01BsCwOYEv1lHO2FrbAtFNpnIsSqrERdFaAJZ3tlJmg9bA03png8A2AajEjkhaOhduJB8zkSlvHNpoQMIAS9WtkG/w==");
            globalParam.setSignature("com.byted.live.lite", "MIIDSTCCAjGgAwIBAgIEaLy5tzANBgkqhkiG9w0BAQsFADBVMQswCQYDVQQGEwIxMTEMMAoGA1UECBMDMTExMQ4wDAYDVQQHEwUxMTExMTEMMAoGA1UEChMDMTExMQwwCgYDVQQLEwMxMTExDDAKBgNVBAMTAzExMTAeFw0yMDEyMDMxMjQyMTJaFw00NTExMjcxMjQyMTJaMFUxCzAJBgNVBAYTAjExMQwwCgYDVQQIEwMxMTExDjAMBgNVBAcTBTExMTExMQwwCgYDVQQKEwMxMTExDDAKBgNVBAsTAzExMTEMMAoGA1UEAxMDMTExMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA45E52YdkJm4gPCXZq7KDoM1h6pgSswllC/CwDOmh8pDGvX4ROaYP1vr2biRlXMHg7G0iXpxWVdlTtx+4QFd3dC+cGJQk0f6apGo2n2RpMA0zIsSf0VO1a3GjWLei5INo+4RDdciqJ4jfsoqBIjZETRkky+UU4eO/oyrAwOu4KdMln3Bg3u7eHWU4kMFrXxrRruT3Q/9gzlO90yQa0CZPWVDrk6cGJtJwJGhWm+62S3U8D26HE++eGP7ve83QBDGtKqx7HpCAFWUiYBgXGq12H0amQDkKcPcr/EFCaBlombSgkN0t6zBX80m+wcUPC75IBTmMV/DT2dXcgjZ2I1JSCQIDAQABoyEwHzAdBgNVHQ4EFgQUPDyIeKI0KhZFPHyn36gMMIYrpukwDQYJKoZIhvcNAQELBQADggEBAHkl0DoCRwn+XKsDJE+wGMpBBqUDzL6DSOnJx4SNqb7YZZU0ThcDK7jY4If3QRkvMio6ODrVZc2U/m/Tc3VeMk5h2W2UZRUWHNH3k9Xe0720uL20ZeH2Y6IG4L5HG8kIbTbFtX3gJpPG/xAcez+CzyCFLWQAZt1N+csG0syWkXJ0Nryq8VrgSCyCXD1KzFxrOe+65wtu50Vi68Vlbk7BZe/G8Qm0RhKmxq5BPMBJ4uY3be+03Ba5qC//o1XQHOEAjrJKXcN5wqHdFZTkmuxVyIPogZOzx4JlNl0zOrYGDJxp7aZfKF9FkXQyF7x0Ns3mZEtjx/+flXRzAAU9MDhPr/0=");
            Zeus.registerPluginStateListener(new ZeusPluginStateListener() { // from class: com.bytedance.sdk.openadsdk.api.plugin.e.2
                public AnonymousClass2() {
                }

                @Override // com.bytedance.pangle.ZeusPluginStateListener
                public void onPluginStateChange(String str, int i10, Object... objArr) {
                    com.bytedance.sdk.openadsdk.api.c.b("TTPluginManager", str + " state changed, " + i10);
                    if (i10 != 9 || TextUtils.equals(str, "com.byted.pangle")) {
                        return;
                    }
                    e.this.c(str);
                }
            });
            globalParam.closeBgDex2oat(true);
            Zeus.init((Application) context, true);
            Zeus.registerPluginInstallListener(new ZeusPluginInstallListener() { // from class: com.bytedance.sdk.openadsdk.api.plugin.e.3
                public AnonymousClass3() {
                }

                @Override // com.bytedance.pangle.ZeusPluginInstallListener
                public void onPluginInstall(String str, int i10, String str2) {
                    if (i10 == 7) {
                        e.this.b(str, i10);
                        return;
                    }
                    if (i10 == 6) {
                        e.this.b(str, i10);
                        if (e.this.f8074k == null || !"com.byted.pangle".equals(str)) {
                            com.bytedance.sdk.openadsdk.api.c.b("TTPluginManager", "no main pl");
                        } else {
                            e.this.f8074k.onEvent(0, com.bykv.a.a.a.a.a.a().a(true).b());
                        }
                    }
                }
            });
            this.f8070g = true;
        } catch (Throwable th2) {
            com.bytedance.sdk.openadsdk.api.c.b("TTPluginManager", "Unexpected error for init zeus.", th2);
            this.f8071h = th2.getMessage();
        }
    }

    public static e a(Context context) {
        if (f8067e == null) {
            synchronized (e.class) {
                try {
                    if (f8067e == null) {
                        f8067e = new e(context);
                    }
                } finally {
                }
            }
        }
        return f8067e;
    }

    private static File c(Context context) {
        return new File(new File(context.getDir("tt_pangle_bykv_file", 0), "pangle_com.byted.pangle"), f8063a);
    }

    public static void c(String str, int i10) {
        com.bytedance.sdk.openadsdk.api.c.d("TTPluginManager", "plugin update failed");
        Bundle bundle = new Bundle();
        bundle.putInt("code", i10);
        TTPluginListener tTPluginListener = f8064b.get(str);
        if (tTPluginListener != null) {
            tTPluginListener.onPluginListener(1001, null, null, bundle);
        }
    }

    public JSONObject a() {
        return this.f8073j;
    }

    public BaseDexClassLoader a(d dVar) throws Exception {
        return a(dVar, 60000);
    }

    public BaseDexClassLoader a(d dVar, int i10) throws Exception {
        boolean z10;
        if (this.f8070g) {
            if (!Zeus.isPluginInstalled("com.byted.pangle")) {
                try {
                    com.bytedance.sdk.openadsdk.api.c.b("TTPluginManager", "wait start");
                    this.f8069f.await(i10, TimeUnit.MILLISECONDS);
                    com.bytedance.sdk.openadsdk.api.c.b("TTPluginManager", "wait done");
                    dVar.b("wait_install_cost");
                } catch (Exception unused) {
                    com.bytedance.sdk.openadsdk.api.c.b("TTPluginManager", "Install wait time out");
                    throw new com.bytedance.sdk.openadsdk.api.plugin.a(8, "install wait timeout");
                }
            }
            if (Zeus.isPluginLoaded("com.byted.pangle") || Zeus.loadPlugin("com.byted.pangle")) {
                f8066d = Zeus.getPlugin("com.byted.pangle").mClassLoader;
                z10 = true;
            } else {
                z10 = false;
            }
            dVar.b("get_classloader_cost");
            Zeus.installFromDownloadDir();
            if (f8066d == null) {
                if (this.f8069f.getCount() != 0) {
                    com.bytedance.sdk.openadsdk.api.c.d("TTPluginManager", "Install wait time out");
                    throw new com.bytedance.sdk.openadsdk.api.plugin.a(8, "install wait timeout");
                }
                if (z10) {
                    com.bytedance.sdk.openadsdk.api.c.d("TTPluginManager", "Get null after load");
                    throw new com.bytedance.sdk.openadsdk.api.plugin.a(9, "Get null after load");
                }
            }
            dVar.b("get_classloader_done");
            return f8066d;
        }
        com.bytedance.sdk.openadsdk.api.c.d("TTPluginManager", "Zeus init failed.");
        throw new com.bytedance.sdk.openadsdk.api.plugin.a(4, this.f8071h);
    }

    public void b(String str, int i10) {
        if ("com.byted.pangle".equals(str) && i10 == 6) {
            com.bytedance.sdk.openadsdk.api.c.d("TTPluginManager", "notify to end wait");
            this.f8069f.countDown();
        }
        a(i10 == 6, str);
    }

    public void b(TTPluginListener tTPluginListener) {
        com.bytedance.sdk.openadsdk.e.a.a().b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.e.5

            /* renamed from: a */
            final /* synthetic */ TTPluginListener f8080a;

            public AnonymousClass5(TTPluginListener tTPluginListener2) {
                tTPluginListener = tTPluginListener2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String packageName = tTPluginListener.packageName();
                Plugin plugin = (Zeus.isPluginInstalled(packageName) && (Zeus.isPluginLoaded(packageName) || Zeus.loadPlugin(packageName))) ? Zeus.getPlugin(packageName) : null;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Find plugin:");
                sb2.append(plugin != null);
                com.bytedance.sdk.openadsdk.api.c.b("TTPluginManager", sb2.toString());
                if (plugin == null) {
                    TTPluginListener unused = e.f8068l = tTPluginListener;
                } else {
                    e.b(plugin);
                    tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                }
            }
        });
    }

    public static void b(Plugin plugin) {
        if (plugin == null) {
            com.bytedance.sdk.openadsdk.api.c.d("TTPluginManager", "plugin is null.");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("action", 0);
        bundle.putString("plugin_pkg_name", plugin.mPkgName);
        bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, a(plugin.getVersion()));
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager != null) {
            adManager.getExtra(Bundle.class, bundle);
        }
    }

    public static boolean b(a aVar) {
        File file;
        if (aVar != null && (file = aVar.f8083b) != null) {
            boolean syncInstallPlugin = Zeus.syncInstallPlugin(aVar.mPackageName, file.getAbsolutePath());
            a(syncInstallPlugin, aVar.mPackageName);
            return syncInstallPlugin;
        }
        com.bytedance.sdk.openadsdk.api.c.d("TTPluginManager", "plugin config is null");
        return false;
    }

    public void b() {
        EventListener eventListener = this.f8074k;
        if (eventListener != null) {
            eventListener.onEvent(1, com.bykv.a.a.a.a.a.a().a(true).b());
        }
    }

    public Bundle a(String str, Bundle bundle) {
        String a10 = a(str);
        if (!TextUtils.isEmpty(a10)) {
            bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, a10);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putBundle(str, bundle);
        Bundle bundle3 = new Bundle();
        bundle3.putBundle(PluginConstants.KEY_PL_CONFIG_INFO, bundle2);
        return bundle3;
    }

    public static String a(String str) {
        Plugin plugin;
        try {
            if (!Zeus.isPluginInstalled(str) || (plugin = Zeus.getPlugin(str)) == null) {
                return null;
            }
            return a(plugin.getVersion());
        } catch (Throwable unused) {
            com.bytedance.sdk.openadsdk.api.c.d("TTPluginManager", "Get local version failed");
            return null;
        }
    }

    public void a(TTPluginListener tTPluginListener) {
        if (!this.f8070g) {
            com.bytedance.sdk.openadsdk.api.c.d("TTPluginManager", "Zeus init failed.");
            if (tTPluginListener != null) {
                tTPluginListener.onPluginListener(1002, null, null, null);
                return;
            }
            return;
        }
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.e.4

            /* renamed from: a */
            final /* synthetic */ TTPluginListener f8078a;

            public AnonymousClass4(TTPluginListener tTPluginListener2) {
                tTPluginListener = tTPluginListener2;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.api.c.b("TTPluginManager", "Load plugin failed, caused by timeout.");
                tTPluginListener.onPluginListener(1001, null, null, null);
            }
        }, 180000L);
        String packageName = tTPluginListener2.packageName();
        Plugin plugin = (Zeus.isPluginInstalled(packageName) && (Zeus.isPluginLoaded(packageName) || Zeus.loadPlugin(packageName))) ? Zeus.getPlugin(packageName) : null;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Find plugin:");
        sb2.append(plugin != null);
        com.bytedance.sdk.openadsdk.api.c.b("TTPluginManager", sb2.toString());
        if (plugin != null) {
            b(plugin);
            handler.removeCallbacksAndMessages(null);
            tTPluginListener2.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
        } else {
            f8064b.put(packageName, tTPluginListener2);
            f8065c.put(packageName, handler);
        }
    }

    private static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.mPackageName = jSONObject.optString("package_name");
        aVar.mVersionCode = jSONObject.optInt("version_code");
        aVar.mUrl = jSONObject.optString("download_url");
        aVar.mMd5 = jSONObject.optString("md5");
        aVar.mApiVersionMin = jSONObject.optInt("min_version");
        aVar.mApiVersionMax = jSONObject.optInt("max_version");
        aVar.f8082a = jSONObject.optString("sign");
        aVar.mFlag = jSONObject.optBoolean("is_revert") ? 3 : 2;
        aVar.f8083b = new File(jSONObject.optString("plugin_file"));
        return aVar;
    }

    public static String a(int i10) {
        char[] charArray = String.valueOf(i10).toCharArray();
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < charArray.length; i11++) {
            sb2.append(charArray[i11]);
            if (i11 < charArray.length - 1) {
                sb2.append(p1.b.f29697h);
            }
        }
        return sb2.toString();
    }

    private static boolean a(TTPluginListener tTPluginListener, String str) {
        if (tTPluginListener == null || tTPluginListener.packageName() == null) {
            return false;
        }
        return tTPluginListener.packageName().equals(str);
    }

    private static void a(boolean z10, String str) {
        HashMap<String, TTPluginListener> hashMap = f8064b;
        TTPluginListener tTPluginListener = hashMap.get(str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Install dl plugin ");
        sb2.append(str);
        sb2.append(z10 ? " success" : " failed");
        sb2.append(", need notify: ");
        sb2.append(tTPluginListener != null);
        com.bytedance.sdk.openadsdk.api.c.b("TTPluginManager", sb2.toString());
        HashMap<String, Handler> hashMap2 = f8065c;
        Handler handler = hashMap2.get(str);
        if (z10) {
            TTPluginListener tTPluginListener2 = f8068l;
            if (!a(tTPluginListener2, str) && (tTPluginListener == null || handler == null)) {
                return;
            }
            if (Zeus.loadPlugin(str)) {
                Plugin plugin = Zeus.getPlugin(str);
                b(plugin);
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                if (tTPluginListener != null) {
                    tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                }
                if (a(tTPluginListener2, str)) {
                    tTPluginListener2.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                    f8068l = null;
                }
            } else {
                com.bytedance.sdk.openadsdk.api.c.b("TTPluginManager", "handle installed, load failed");
                c(str, 1002);
            }
        } else {
            com.bytedance.sdk.openadsdk.api.c.b("TTPluginManager", "handle installed failed");
            c(str, 1003);
        }
        hashMap.remove(str);
        hashMap2.remove(str);
    }

    public static void a(Throwable th2) {
        if (th2 instanceof AbstractMethodError) {
            Zeus.unInstallPlugin("com.byted.pangle");
            com.bytedance.sdk.openadsdk.api.c.d("TTPluginManager", "AbstractMethodError, rollback to builtin version.");
        }
    }
}
