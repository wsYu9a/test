package com.bytedance.sdk.openadsdk.api.plugin;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.a;
import com.baidu.mobads.sdk.internal.bw;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.log.IZeusLogger;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.sdk.openadsdk.TTAdEvent;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.heytap.mcssdk.n.d;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class gv {

    /* renamed from: g */
    private static volatile BaseDexClassLoader f6378g;
    private static volatile boolean gv;
    private static volatile TTPluginListener nt;
    private final Context pa;

    /* renamed from: j */
    private static final String f6380j = "next" + File.separator;
    private static final HashMap<String, TTPluginListener> zx = new HashMap<>();

    /* renamed from: i */
    private static final HashMap<String, Handler> f6379i = new HashMap<>();
    private static volatile gv q = null;
    private final CountDownLatch lg = new CountDownLatch(1);
    private volatile boolean y = false;
    private volatile String k = a.f5472a;
    private JSONObject t = new JSONObject();

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.gv$1 */
    class AnonymousClass1 implements IZeusReporter {
        AnonymousClass1() {
        }

        @Override // com.bytedance.pangle.log.IZeusReporter
        public void report(String str, JSONObject jSONObject) {
            if (str == "load_finish" && jSONObject != null && "com.byted.pangle".endsWith(jSONObject.optString("plugin_package_name"))) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("duration", jSONObject.opt("duration"));
                    jSONObject2.put(d.l, jSONObject.opt(d.l));
                    gv.this.t.put("zeus", jSONObject2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (gv.gv) {
                g.j(str, jSONObject);
            } else {
                g.i(str, jSONObject);
            }
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.gv$2 */
    class AnonymousClass2 extends ZeusPluginStateListener {

        /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.gv$2$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: j */
            final /* synthetic */ String f6384j;
            final /* synthetic */ int zx;

            AnonymousClass1(String str, int i2) {
                str = str;
                i2 = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                gv.this.zx(str, i2);
            }
        }

        AnonymousClass2() {
        }

        @Override // com.bytedance.pangle.ZeusPluginStateListener
        public void onPluginStateChange(String str, int i2, Object... objArr) {
            com.bytedance.sdk.openadsdk.api.j.zx("TTPluginManager", str + " state changed, " + i2);
            if (i2 == 7) {
                gv.this.zx(str, i2);
            } else if (i2 == 6) {
                com.bytedance.sdk.openadsdk.zx.j.j().j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.gv.2.1

                    /* renamed from: j */
                    final /* synthetic */ String f6384j;
                    final /* synthetic */ int zx;

                    AnonymousClass1(String str2, int i22) {
                        str = str2;
                        i2 = i22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        gv.this.zx(str, i2);
                    }
                });
            }
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.gv$3 */
    class AnonymousClass3 implements Runnable {

        /* renamed from: j */
        final /* synthetic */ TTPluginListener f6385j;

        AnonymousClass3(TTPluginListener tTPluginListener) {
            tTPluginListener = tTPluginListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.api.j.zx("TTPluginManager", "Load plugin failed, caused by timeout.");
            tTPluginListener.onPluginListener(1001, null, null, null);
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.gv$4 */
    class AnonymousClass4 implements Runnable {

        /* renamed from: j */
        final /* synthetic */ TTPluginListener f6386j;

        AnonymousClass4(TTPluginListener tTPluginListener) {
            tTPluginListener = tTPluginListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            String packageName = tTPluginListener.packageName();
            Plugin plugin = (Zeus.isPluginInstalled(packageName) && (Zeus.isPluginLoaded(packageName) || Zeus.loadPlugin(packageName))) ? Zeus.getPlugin(packageName) : null;
            StringBuilder sb = new StringBuilder();
            sb.append("Find plugin:");
            sb.append(plugin != null);
            com.bytedance.sdk.openadsdk.api.j.zx("TTPluginManager", sb.toString());
            if (plugin == null) {
                TTPluginListener unused = gv.nt = tTPluginListener;
            } else {
                gv.zx(plugin);
                tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
            }
        }
    }

    static final class i implements EventListener, Serializable {
        i() {
        }

        @Override // com.bykv.vk.openvk.api.proto.EventListener
        public ValueSet onEvent(int i2, Result result) {
            com.bytedance.sdk.openadsdk.api.i j2 = com.bytedance.sdk.openadsdk.api.i.j();
            if (i2 == 1) {
                ValueSet values = result.values();
                if (values == null) {
                    return null;
                }
                String stringValue = values.stringValue(3);
                int code = result.code();
                if (!result.isSuccess()) {
                    gv.i(stringValue, code);
                    return null;
                }
                com.bytedance.sdk.openadsdk.api.plugin.zx i3 = gv.i(values.stringValue(2));
                if (i3 == null || TextUtils.isEmpty(i3.mPackageName)) {
                    com.bytedance.sdk.openadsdk.api.j.g("TTPluginManager", "plugin update received with invalid config");
                    return null;
                }
                com.bytedance.sdk.openadsdk.api.j.g("TTPluginManager", "plugin update received: " + i3.mPackageName);
                if (i3.isRevert()) {
                    Zeus.unInstallPlugin(i3.mPackageName);
                } else if (gv.zx(i3)) {
                    j2.j(4, true);
                }
            }
            return j2.zx();
        }
    }

    private static final class j implements IZeusLogger {
        private j() {
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void e(String str, String str2, Throwable th) {
            com.bytedance.sdk.openadsdk.api.j.zx(str, str2, th);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void i(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.j.i(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void v(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.j.j(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void w(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.j.j(str, str2);
        }

        /* synthetic */ j(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void w(String str, String str2, Throwable th) {
            com.bytedance.sdk.openadsdk.api.j.j(str, str2, th);
        }
    }

    static final class zx implements TTAdEvent {
        zx() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdEvent
        public void onEvent(int i2, Bundle bundle) {
            if (i2 == 1) {
                String string = bundle.getString("config");
                String string2 = bundle.getString("plugin_pkg_name");
                int i3 = bundle.getInt("code");
                if (i3 != 0) {
                    gv.i(string2, i3);
                    return;
                }
                com.bytedance.sdk.openadsdk.api.plugin.zx i4 = gv.i(string);
                if (i4 == null || TextUtils.isEmpty(i4.mPackageName)) {
                    com.bytedance.sdk.openadsdk.api.j.g("TTPluginManager", "plugin update received with invalid config");
                    return;
                }
                if (!bundle.getBoolean(bw.o)) {
                    gv.i(i4.mPackageName, 1004);
                    return;
                }
                com.bytedance.sdk.openadsdk.api.j.g("TTPluginManager", "plugin update received: " + i4.mPackageName);
                if (i4.isRevert()) {
                    Zeus.unInstallPlugin(i4.mPackageName);
                } else if (gv.zx(i4)) {
                    bundle.putBoolean("installed", true);
                }
            }
        }
    }

    private gv(Context context) {
        this.pa = context.getApplicationContext();
        g.j(context);
        zx(context.getApplicationContext());
    }

    public JSONObject zx() {
        return this.t;
    }

    private static File i(Context context) {
        return new File(new File(context.getDir("tt_pangle_bykv_file", 0), "pangle_com.byted.pangle"), f6380j);
    }

    private void zx(Context context) {
        try {
            AnonymousClass1 anonymousClass1 = new IZeusReporter() { // from class: com.bytedance.sdk.openadsdk.api.plugin.gv.1
                AnonymousClass1() {
                }

                @Override // com.bytedance.pangle.log.IZeusReporter
                public void report(String str, JSONObject jSONObject) {
                    if (str == "load_finish" && jSONObject != null && "com.byted.pangle".endsWith(jSONObject.optString("plugin_package_name"))) {
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("duration", jSONObject.opt("duration"));
                            jSONObject2.put(d.l, jSONObject.opt(d.l));
                            gv.this.t.put("zeus", jSONObject2);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (gv.gv) {
                        g.j(str, jSONObject);
                    } else {
                        g.i(str, jSONObject);
                    }
                }
            };
            GlobalParam globalParam = GlobalParam.getInstance();
            globalParam.setReporter(anonymousClass1);
            globalParam.setCheckPermission(false);
            globalParam.setDownloadDir(i(context));
            globalParam.setLogger(new j());
            globalParam.setSignature("com.byted.pangle", "MIIDfTCCAmWgAwIBAgIEfRwYPjANBgkqhkiG9w0BAQsFADBvMQswCQYDVQQGEwJDTjEQMA4GA1UECBMHQmVpamluZzEQMA4GA1UEBxMHQmVpamluZzESMBAGA1UEChMJQnl0ZURhbmNlMQ8wDQYDVQQLEwZQYW5nbGUxFzAVBgNVBAMTDkNodWFuIFNoYW4gSmlhMB4XDTIxMTEwODA2MjQzOVoXDTQ2MTEwMjA2MjQzOVowbzELMAkGA1UEBhMCQ04xEDAOBgNVBAgTB0JlaWppbmcxEDAOBgNVBAcTB0JlaWppbmcxEjAQBgNVBAoTCUJ5dGVEYW5jZTEPMA0GA1UECxMGUGFuZ2xlMRcwFQYDVQQDEw5DaHVhbiBTaGFuIEppYTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAIBKeRL+4mfCn1SLYv6OemfwwItkjlLPyqOEugkV6lanFTcZgLwEl5LIkL0y28UncPtMX1Mii6DzCdJ/plw7S9+RT/hYDneu339IKWojaU2qai/5FokHlQ0MMnYl5yry00ghVPsl1u+03cQA2ZnjIMiFhrBJpQzHt7IYvq2aEEMBcY8uT7iFoBI848e1mL1joVS2z02C3NliP7ZNARkXH+rTQAlCJulT5IZk+V/PTaKqzgNrkhsKh0/tBmU7m8u79x/xpgGsE19H18AgS4P/9/MDCRe2Z35boZeccaUy2MXCwv3djzUcDk3rRzQPYzdpyyRnrFMuhiKesc5VHgUMs9kCAwEAAaMhMB8wHQYDVR0OBBYEFENENrNWGzc2WhxdvhoMDs57U70zMA0GCSqGSIb3DQEBCwUAA4IBAQAHqDCrmvyBBmIGXwuL1rwS/Qv9ZJIZykBIaNMm+H1IfitCl4yXd9N2n+PjE0UZtxZ21UZOt9wAr+RFiSl5YRXqpt7WLARTy4YW3RiQ+wiL7bshzeSYBoSiC427Bfeq0WjwY0/jHlr8uouppyJOz++6U9hrYX2EW/6UjH5XlWiKQJ6b2ZzPcP8Xpg/TJn4tWvXJP6jw9kRRP2GmMttY78leWQst2QEZILmWJubXRLPj9O+qx2uP9oGTD4sc1vb9hzkOHBIHzGaalqLFbbGaeFpLFHoGTsnOfPTwUVKDZYmxbkcmR1bp7eYOW+nSQNMLn0FjDewZl5l37Sa/gz0WVHon");
            globalParam.setSignature("com.byted.csj.ext", "MIIDezCCAmOgAwIBAgIENkE1KDANBgkqhkiG9w0BAQsFADBtMQswCQYDVQQGEwI4NjEQMA4GA1UECBMHYmVpamluZzEQMA4GA1UEBxMHYmVpamluZzESMBAGA1UEChMJYnl0ZWRhbmNlMRIwEAYDVQQLEwlieXRlZGFuY2UxEjAQBgNVBAMTCWJ5dGVkYW5jZTAgFw0yMjExMDIwODI3MzlaGA8yMDUwMDMyMDA4MjczOVowbTELMAkGA1UEBhMCODYxEDAOBgNVBAgTB2JlaWppbmcxEDAOBgNVBAcTB2JlaWppbmcxEjAQBgNVBAoTCWJ5dGVkYW5jZTESMBAGA1UECxMJYnl0ZWRhbmNlMRIwEAYDVQQDEwlieXRlZGFuY2UwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCc9Z2F3xxOMX1qTXMy2aPmS9OSkqrp8C8bHwS1hkNVR4umKREuqOn73INNo+R706jaCVnlPwxDwWjtX6H74DE4CveivyM9f2wNC3yIyDW+5j7lW/keTQcOlGLDEJQv4O/6FbB/jNU6epjyNaNIZhgZcvTpgaSixbdyHzRTFmvMh+WovdVK/J9LnHOQ+pmPZj7NB6MQRGMUrPEotLHQca3cmnLrnPAaZQaVoaFE9lOt9syyqEuf361SprNIGDtbkJuX3EqV/QOKWFwZX94IS7ZGSvfyCojcD4kaUSbaSoZC7zEuBb7l69g+ZMrJ/v6wkm01wxsNNssUwF7k6Sp0zubbAgMBAAGjITAfMB0GA1UdDgQWBBSxk+gVdDco1dP65hP67qoKNlMEYDANBgkqhkiG9w0BAQsFAAOCAQEAfosExl/AYEbS2xqHBTHa28cvnp/SElUQuzW6aWLqkfk9cxmFSI/euUV3/eB8RN+U2X47Y05u6+XUxTv0tSSEtyXNawm0qWH8jkR4gZY38YqBChKjhea668oT5X3Uocrw7SYXO/BfI8SKPa0uI/U8Cyl3uctbmmq/pPUkd3mKAy+HgyJoThD6K0oyiADlygngUMVTv6Uvid4qPj/bBnxI+LvVeX4l1dxGqWkiafQW9sz+RbFdge3X2XsSH4eo01BsCwOYEv1lHO2FrbAtFNpnIsSqrERdFaAJZ3tlJmg9bA03png8A2AajEjkhaOhduJB8zkSlvHNpoQMIAS9WtkG/w==");
            globalParam.setSignature("com.byted.live.lite", "MIIDSTCCAjGgAwIBAgIEaLy5tzANBgkqhkiG9w0BAQsFADBVMQswCQYDVQQGEwIxMTEMMAoGA1UECBMDMTExMQ4wDAYDVQQHEwUxMTExMTEMMAoGA1UEChMDMTExMQwwCgYDVQQLEwMxMTExDDAKBgNVBAMTAzExMTAeFw0yMDEyMDMxMjQyMTJaFw00NTExMjcxMjQyMTJaMFUxCzAJBgNVBAYTAjExMQwwCgYDVQQIEwMxMTExDjAMBgNVBAcTBTExMTExMQwwCgYDVQQKEwMxMTExDDAKBgNVBAsTAzExMTEMMAoGA1UEAxMDMTExMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA45E52YdkJm4gPCXZq7KDoM1h6pgSswllC/CwDOmh8pDGvX4ROaYP1vr2biRlXMHg7G0iXpxWVdlTtx+4QFd3dC+cGJQk0f6apGo2n2RpMA0zIsSf0VO1a3GjWLei5INo+4RDdciqJ4jfsoqBIjZETRkky+UU4eO/oyrAwOu4KdMln3Bg3u7eHWU4kMFrXxrRruT3Q/9gzlO90yQa0CZPWVDrk6cGJtJwJGhWm+62S3U8D26HE++eGP7ve83QBDGtKqx7HpCAFWUiYBgXGq12H0amQDkKcPcr/EFCaBlombSgkN0t6zBX80m+wcUPC75IBTmMV/DT2dXcgjZ2I1JSCQIDAQABoyEwHzAdBgNVHQ4EFgQUPDyIeKI0KhZFPHyn36gMMIYrpukwDQYJKoZIhvcNAQELBQADggEBAHkl0DoCRwn+XKsDJE+wGMpBBqUDzL6DSOnJx4SNqb7YZZU0ThcDK7jY4If3QRkvMio6ODrVZc2U/m/Tc3VeMk5h2W2UZRUWHNH3k9Xe0720uL20ZeH2Y6IG4L5HG8kIbTbFtX3gJpPG/xAcez+CzyCFLWQAZt1N+csG0syWkXJ0Nryq8VrgSCyCXD1KzFxrOe+65wtu50Vi68Vlbk7BZe/G8Qm0RhKmxq5BPMBJ4uY3be+03Ba5qC//o1XQHOEAjrJKXcN5wqHdFZTkmuxVyIPogZOzx4JlNl0zOrYGDJxp7aZfKF9FkXQyF7x0Ns3mZEtjx/+flXRzAAU9MDhPr/0=");
            Zeus.registerPluginStateListener(new ZeusPluginStateListener() { // from class: com.bytedance.sdk.openadsdk.api.plugin.gv.2

                /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.gv$2$1 */
                class AnonymousClass1 implements Runnable {

                    /* renamed from: j */
                    final /* synthetic */ String f6384j;
                    final /* synthetic */ int zx;

                    AnonymousClass1(String str2, int i22) {
                        str = str2;
                        i2 = i22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        gv.this.zx(str, i2);
                    }
                }

                AnonymousClass2() {
                }

                @Override // com.bytedance.pangle.ZeusPluginStateListener
                public void onPluginStateChange(String str2, int i22, Object... objArr) {
                    com.bytedance.sdk.openadsdk.api.j.zx("TTPluginManager", str2 + " state changed, " + i22);
                    if (i22 == 7) {
                        gv.this.zx(str2, i22);
                    } else if (i22 == 6) {
                        com.bytedance.sdk.openadsdk.zx.j.j().j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.gv.2.1

                            /* renamed from: j */
                            final /* synthetic */ String f6384j;
                            final /* synthetic */ int zx;

                            AnonymousClass1(String str22, int i222) {
                                str = str22;
                                i2 = i222;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                gv.this.zx(str, i2);
                            }
                        });
                    }
                }
            });
            Zeus.init((Application) context, true);
            this.y = true;
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.j.j("TTPluginManager", "Unexpected error for init zeus.", th);
            this.k = th.getMessage();
        }
    }

    public static com.bytedance.sdk.openadsdk.api.plugin.zx i(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return j(new JSONObject(str));
        } catch (JSONException unused) {
            com.bytedance.sdk.openadsdk.api.j.q("TTPluginManager", "Invalid plugin info:" + str);
            return null;
        }
    }

    public static gv j(Context context) {
        if (q == null) {
            synchronized (gv.class) {
                if (q == null) {
                    q = new gv(context);
                }
            }
        }
        return q;
    }

    public static void i(String str, int i2) {
        com.bytedance.sdk.openadsdk.api.j.g("TTPluginManager", "plugin update failed");
        Bundle bundle = new Bundle();
        bundle.putInt("code", i2);
        TTPluginListener tTPluginListener = zx.get(str);
        if (tTPluginListener != null) {
            tTPluginListener.onPluginListener(1001, null, null, bundle);
        }
    }

    public void j() {
        gv = true;
        g.j(new ArrayList());
    }

    public BaseDexClassLoader j(q qVar) throws Exception {
        if (this.y) {
            if (!Zeus.isPluginInstalled("com.byted.pangle")) {
                try {
                    this.lg.await(60000L, TimeUnit.MILLISECONDS);
                    qVar.zx("wait_install_cost");
                } catch (Exception unused) {
                    com.bytedance.sdk.openadsdk.api.j.g("TTPluginManager", "Install wait time out");
                    throw new com.bytedance.sdk.openadsdk.api.plugin.i(8, "install wait timeout");
                }
            }
            boolean z = false;
            if (Zeus.isPluginLoaded("com.byted.pangle") || Zeus.loadPlugin("com.byted.pangle")) {
                f6378g = Zeus.getPlugin("com.byted.pangle").mClassLoader;
                z = true;
            }
            qVar.zx("get_classloader_cost");
            Zeus.installFromDownloadDir();
            if (f6378g == null) {
                if (this.lg.getCount() != 0) {
                    com.bytedance.sdk.openadsdk.api.j.g("TTPluginManager", "Install wait time out");
                    throw new com.bytedance.sdk.openadsdk.api.plugin.i(8, "install wait timeout");
                }
                if (z) {
                    com.bytedance.sdk.openadsdk.api.j.g("TTPluginManager", "Get null after load");
                    throw new com.bytedance.sdk.openadsdk.api.plugin.i(9, "Get null after load");
                }
            }
            qVar.zx("get_classloader_done");
            return f6378g;
        }
        com.bytedance.sdk.openadsdk.api.j.g("TTPluginManager", "Zeus init failed.");
        throw new com.bytedance.sdk.openadsdk.api.plugin.i(4, this.k);
    }

    public void zx(String str, int i2) {
        if ("com.byted.pangle".equals(str) && i2 == 6) {
            this.lg.countDown();
        }
        j(i2 == 6, str);
    }

    public void zx(TTPluginListener tTPluginListener) {
        com.bytedance.sdk.openadsdk.zx.j.j().j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.gv.4

            /* renamed from: j */
            final /* synthetic */ TTPluginListener f6386j;

            AnonymousClass4(TTPluginListener tTPluginListener2) {
                tTPluginListener = tTPluginListener2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String packageName = tTPluginListener.packageName();
                Plugin plugin = (Zeus.isPluginInstalled(packageName) && (Zeus.isPluginLoaded(packageName) || Zeus.loadPlugin(packageName))) ? Zeus.getPlugin(packageName) : null;
                StringBuilder sb = new StringBuilder();
                sb.append("Find plugin:");
                sb.append(plugin != null);
                com.bytedance.sdk.openadsdk.api.j.zx("TTPluginManager", sb.toString());
                if (plugin == null) {
                    TTPluginListener unused = gv.nt = tTPluginListener;
                } else {
                    gv.zx(plugin);
                    tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                }
            }
        });
    }

    public static void zx(Plugin plugin) {
        if (plugin == null) {
            com.bytedance.sdk.openadsdk.api.j.g("TTPluginManager", "plugin is null.");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("action", 0);
        bundle.putString("plugin_pkg_name", plugin.mPkgName);
        bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, j(plugin.getVersion()));
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager != null) {
            adManager.getExtra(Bundle.class, bundle);
        }
    }

    public static boolean zx(com.bytedance.sdk.openadsdk.api.plugin.zx zxVar) {
        File file;
        if (zxVar != null && (file = zxVar.zx) != null) {
            boolean syncInstallPlugin = Zeus.syncInstallPlugin(zxVar.mPackageName, file.getAbsolutePath());
            j(syncInstallPlugin, zxVar.mPackageName);
            return syncInstallPlugin;
        }
        com.bytedance.sdk.openadsdk.api.j.g("TTPluginManager", "plugin config is null");
        return false;
    }

    public Bundle j(String str, Bundle bundle) {
        String j2 = j(str);
        if (!TextUtils.isEmpty(j2)) {
            bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, j2);
        }
        lg.j(str, bundle);
        Bundle bundle2 = new Bundle();
        bundle2.putBundle(str, bundle);
        Bundle bundle3 = new Bundle();
        bundle3.putBundle(PluginConstants.KEY_PL_CONFIG_INFO, bundle2);
        return bundle3;
    }

    public static String j(String str) {
        Plugin plugin;
        try {
            if (!Zeus.isPluginInstalled(str) || (plugin = Zeus.getPlugin(str)) == null) {
                return null;
            }
            return j(plugin.getVersion());
        } catch (Throwable unused) {
            com.bytedance.sdk.openadsdk.api.j.g("TTPluginManager", "Get local version failed");
            return null;
        }
    }

    public void j(TTPluginListener tTPluginListener) {
        if (!this.y) {
            com.bytedance.sdk.openadsdk.api.j.g("TTPluginManager", "Zeus init failed.");
            if (tTPluginListener != null) {
                tTPluginListener.onPluginListener(1002, null, null, null);
                return;
            }
            return;
        }
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.gv.3

            /* renamed from: j */
            final /* synthetic */ TTPluginListener f6385j;

            AnonymousClass3(TTPluginListener tTPluginListener2) {
                tTPluginListener = tTPluginListener2;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.api.j.zx("TTPluginManager", "Load plugin failed, caused by timeout.");
                tTPluginListener.onPluginListener(1001, null, null, null);
            }
        }, 180000L);
        String packageName = tTPluginListener2.packageName();
        Plugin plugin = (Zeus.isPluginInstalled(packageName) && (Zeus.isPluginLoaded(packageName) || Zeus.loadPlugin(packageName))) ? Zeus.getPlugin(packageName) : null;
        StringBuilder sb = new StringBuilder();
        sb.append("Find plugin:");
        sb.append(plugin != null);
        com.bytedance.sdk.openadsdk.api.j.zx("TTPluginManager", sb.toString());
        if (plugin != null) {
            zx(plugin);
            handler.removeCallbacksAndMessages(null);
            tTPluginListener2.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
        } else {
            zx.put(packageName, tTPluginListener2);
            f6379i.put(packageName, handler);
        }
    }

    private static com.bytedance.sdk.openadsdk.api.plugin.zx j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.api.plugin.zx zxVar = new com.bytedance.sdk.openadsdk.api.plugin.zx();
        zxVar.mPackageName = jSONObject.optString("package_name");
        zxVar.mVersionCode = jSONObject.optInt("version_code");
        zxVar.mUrl = jSONObject.optString("download_url");
        zxVar.mMd5 = jSONObject.optString("md5");
        zxVar.mApiVersionMin = jSONObject.optInt("min_version");
        zxVar.mApiVersionMax = jSONObject.optInt("max_version");
        zxVar.f6445j = jSONObject.optString("sign");
        zxVar.mFlag = jSONObject.optBoolean("is_revert") ? 3 : 2;
        zxVar.zx = new File(jSONObject.optString("plugin_file"));
        return zxVar;
    }

    public static String j(int i2) {
        char[] charArray = String.valueOf(i2).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < charArray.length; i3++) {
            sb.append(charArray[i3]);
            if (i3 < charArray.length - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    private static boolean j(TTPluginListener tTPluginListener, String str) {
        if (tTPluginListener == null || tTPluginListener.packageName() == null) {
            return false;
        }
        return tTPluginListener.packageName().equals(str);
    }

    private static void j(boolean z, String str) {
        HashMap<String, TTPluginListener> hashMap = zx;
        TTPluginListener tTPluginListener = hashMap.get(str);
        StringBuilder sb = new StringBuilder();
        sb.append("Install dl plugin ");
        sb.append(str);
        sb.append(z ? " success" : " failed");
        sb.append(", need notify: ");
        sb.append(tTPluginListener != null);
        com.bytedance.sdk.openadsdk.api.j.zx("TTPluginManager", sb.toString());
        HashMap<String, Handler> hashMap2 = f6379i;
        Handler handler = hashMap2.get(str);
        if (z) {
            TTPluginListener tTPluginListener2 = nt;
            if (!j(tTPluginListener2, str) && (tTPluginListener == null || handler == null)) {
                return;
            }
            if (Zeus.loadPlugin(str)) {
                Plugin plugin = Zeus.getPlugin(str);
                zx(plugin);
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                if (tTPluginListener != null) {
                    tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                }
                if (j(tTPluginListener2, str)) {
                    tTPluginListener2.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                    nt = null;
                }
            } else {
                i(str, 1002);
            }
        } else {
            i(str, 1003);
        }
        hashMap.remove(str);
        hashMap2.remove(str);
    }

    public static void j(Throwable th) {
        if (th instanceof AbstractMethodError) {
            Zeus.unInstallPlugin("com.byted.pangle");
            com.bytedance.sdk.openadsdk.api.j.g("TTPluginManager", "AbstractMethodError, rollback to builtin version.");
        }
    }
}
