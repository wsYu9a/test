package com.bytedance.pangle;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.os.EnvironmentCompat;
import com.bytedance.pangle.apm.ApmUtils;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.servermanager.MainServerManager;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.i;
import com.bytedance.pangle.util.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class h {

    /* renamed from: d */
    private static volatile h f6161d;

    /* renamed from: a */
    boolean f6162a;

    /* renamed from: b */
    final List<ZeusPluginStateListener> f6163b = new CopyOnWriteArrayList();

    /* renamed from: c */
    final List<ZeusPluginEventCallback> f6164c = new ArrayList();

    /* renamed from: e */
    private final Handler f6165e = new Handler(Looper.getMainLooper());

    /* renamed from: com.bytedance.pangle.h$1 */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            j.b();
        }
    }

    /* renamed from: com.bytedance.pangle.h$2 */
    final class AnonymousClass2 implements com.bytedance.pangle.c.a {
        AnonymousClass2() {
        }

        @Override // com.bytedance.pangle.c.a
        public final void a(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            if (jSONObject3 == null) {
                jSONObject3 = new JSONObject();
            }
            String str2 = null;
            if (Zeus.getAppApplication() != null) {
                Zeus.getAppApplication();
                str2 = com.bytedance.pangle.d.d.a(com.bytedance.pangle.d.d.a());
            }
            String packageName = Zeus.getAppApplication() != null ? Zeus.getAppApplication().getPackageName() : "";
            if (str2 == null) {
                str2 = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            try {
                jSONObject.putOpt(ContentProviderManager.PLUGIN_PROCESS_NAME, com.bytedance.pangle.log.b.a(str2));
                jSONObject.putOpt("host_package_name", packageName);
                Plugin plugin = Zeus.getPlugin(jSONObject.optString("plugin_package_name", ""), false);
                jSONObject.putOpt("plugin_api_version", com.bytedance.pangle.log.b.a(Integer.valueOf(plugin != null ? plugin.getApiVersionCode() : -1)));
                jSONObject.putOpt("zeus_sdk_version", com.bytedance.pangle.log.b.a("0.0.1-beta.4200.112-pangle"));
                ZeusLogger.v(ZeusLogger.TAG_REPORTER, "eventName: " + str + "\ncategoryData:" + jSONObject.toString(1) + "\nmetricData:" + jSONObject2.toString(1) + "\nlogExtrData:" + jSONObject3.toString(1));
                IZeusReporter reporter = GlobalParam.getInstance().getReporter();
                if (reporter != null) {
                    JSONObject jSONObject4 = new JSONObject();
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject4.putOpt(next, jSONObject.opt(next));
                    }
                    Iterator<String> keys2 = jSONObject2.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        jSONObject4.putOpt(next2, jSONObject2.opt(next2));
                    }
                    Iterator<String> keys3 = jSONObject3.keys();
                    while (keys3.hasNext()) {
                        String next3 = keys3.next();
                        jSONObject4.putOpt(next3, jSONObject3.opt(next3));
                    }
                    reporter.report(str, jSONObject4);
                }
                ApmUtils.getApmInstance().monitorEvent(str, jSONObject, jSONObject2, jSONObject3);
            } catch (JSONException e2) {
                ZeusLogger.w(ZeusLogger.TAG_REPORTER, e2.getMessage(), e2);
            }
        }
    }

    /* renamed from: com.bytedance.pangle.h$3 */
    final class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                MethodUtils.invokeStaticMethod(Class.forName("com.android.server.SystemConfig"), "getInstance", new Object[0]);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.bytedance.pangle.h$4 */
    final class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Object f6169a;

        /* renamed from: b */
        final /* synthetic */ int f6170b;

        /* renamed from: c */
        final /* synthetic */ int f6171c;

        /* renamed from: d */
        final /* synthetic */ String f6172d;

        /* renamed from: e */
        final /* synthetic */ int f6173e;

        /* renamed from: f */
        final /* synthetic */ Throwable f6174f;

        AnonymousClass4(Object obj, int i2, int i3, String str, int i4, Throwable th) {
            obj = obj;
            i2 = i2;
            i3 = i3;
            str = str;
            i4 = i4;
            th = th;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                ((ZeusPluginEventCallback) obj).onPluginEvent(i2, i3, str, i4, th);
            } catch (Throwable unused) {
            }
        }
    }

    public static h a() {
        if (f6161d == null) {
            synchronized (h.class) {
                if (f6161d == null) {
                    f6161d = new h();
                }
            }
        }
        return f6161d;
    }

    private static void b() {
        ProviderInfo[] providerInfoArr;
        String str;
        try {
            PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 8);
            if (packageInfo != null && (providerInfoArr = packageInfo.providers) != null) {
                for (ProviderInfo providerInfo : providerInfoArr) {
                    if (!TextUtils.isEmpty(providerInfo.authority)) {
                        if (providerInfo.authority.contains(Zeus.getAppApplication().getPackageName() + ".pangle.servermanager.")) {
                            if (!TextUtils.isEmpty(providerInfo.processName) && providerInfo.processName.contains(":")) {
                                str = providerInfo.processName.split(":")[1];
                                if (Zeus.getServerManagerHashMap().get(str) != null || !TextUtils.equals(str, "main") || !TextUtils.equals(providerInfo.name, MainServerManager.class.getName())) {
                                    Zeus.getServerManagerHashMap().put(str, providerInfo);
                                }
                            }
                            str = "main";
                            if (Zeus.getServerManagerHashMap().get(str) != null) {
                            }
                            Zeus.getServerManagerHashMap().put(str, providerInfo);
                        }
                    }
                }
                return;
            }
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "initServerManager failed. packageInfo:".concat(String.valueOf(packageInfo)));
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    private Object[] c() {
        Object[] array;
        synchronized (this.f6164c) {
            array = !this.f6164c.isEmpty() ? this.f6164c.toArray() : null;
        }
        return array == null ? new Object[0] : array;
    }

    final synchronized void a(Application application, boolean z) {
        if (this.f6162a) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager zeus has been inited!");
            return;
        }
        a(3000, 0, null, -1, null);
        Zeus.setAppContext(application);
        GlobalParam globalParam = GlobalParam.getInstance();
        globalParam.init();
        if (application != null) {
            ZeusLogger.setDebug(globalParam.isDebug());
            ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusManager init, context = " + application + ", hParam = " + globalParam);
            com.bytedance.pangle.d.e.a(new Runnable() { // from class: com.bytedance.pangle.h.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    j.b();
                }
            });
            if (GlobalParam.getInstance().isPostBgDexOptByInit()) {
                com.bytedance.pangle.e.f.a();
            }
            if (z) {
                Zeus.onPrivacyAgreed();
            }
            com.bytedance.pangle.c.b a2 = com.bytedance.pangle.c.b.a();
            AnonymousClass2 anonymousClass2 = new com.bytedance.pangle.c.a() { // from class: com.bytedance.pangle.h.2
                AnonymousClass2() {
                }

                @Override // com.bytedance.pangle.c.a
                public final void a(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    if (jSONObject2 == null) {
                        jSONObject2 = new JSONObject();
                    }
                    if (jSONObject3 == null) {
                        jSONObject3 = new JSONObject();
                    }
                    String str2 = null;
                    if (Zeus.getAppApplication() != null) {
                        Zeus.getAppApplication();
                        str2 = com.bytedance.pangle.d.d.a(com.bytedance.pangle.d.d.a());
                    }
                    String packageName = Zeus.getAppApplication() != null ? Zeus.getAppApplication().getPackageName() : "";
                    if (str2 == null) {
                        str2 = EnvironmentCompat.MEDIA_UNKNOWN;
                    }
                    try {
                        jSONObject.putOpt(ContentProviderManager.PLUGIN_PROCESS_NAME, com.bytedance.pangle.log.b.a(str2));
                        jSONObject.putOpt("host_package_name", packageName);
                        Plugin plugin = Zeus.getPlugin(jSONObject.optString("plugin_package_name", ""), false);
                        jSONObject.putOpt("plugin_api_version", com.bytedance.pangle.log.b.a(Integer.valueOf(plugin != null ? plugin.getApiVersionCode() : -1)));
                        jSONObject.putOpt("zeus_sdk_version", com.bytedance.pangle.log.b.a("0.0.1-beta.4200.112-pangle"));
                        ZeusLogger.v(ZeusLogger.TAG_REPORTER, "eventName: " + str + "\ncategoryData:" + jSONObject.toString(1) + "\nmetricData:" + jSONObject2.toString(1) + "\nlogExtrData:" + jSONObject3.toString(1));
                        IZeusReporter reporter = GlobalParam.getInstance().getReporter();
                        if (reporter != null) {
                            JSONObject jSONObject4 = new JSONObject();
                            Iterator<String> keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                jSONObject4.putOpt(next, jSONObject.opt(next));
                            }
                            Iterator<String> keys2 = jSONObject2.keys();
                            while (keys2.hasNext()) {
                                String next2 = keys2.next();
                                jSONObject4.putOpt(next2, jSONObject2.opt(next2));
                            }
                            Iterator<String> keys3 = jSONObject3.keys();
                            while (keys3.hasNext()) {
                                String next3 = keys3.next();
                                jSONObject4.putOpt(next3, jSONObject3.opt(next3));
                            }
                            reporter.report(str, jSONObject4);
                        }
                        ApmUtils.getApmInstance().monitorEvent(str, jSONObject, jSONObject2, jSONObject3);
                    } catch (JSONException e2) {
                        ZeusLogger.w(ZeusLogger.TAG_REPORTER, e2.getMessage(), e2);
                    }
                }
            };
            synchronized (a2.f6015a) {
                a2.f6015a.add(anonymousClass2);
            }
            if (!globalParam.isCloseFlipped()) {
                b.a();
            }
            if (Build.VERSION.SDK_INT == 29) {
                com.bytedance.pangle.d.e.a(new Runnable() { // from class: com.bytedance.pangle.h.3
                    AnonymousClass3() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            MethodUtils.invokeStaticMethod(Class.forName("com.android.server.SystemConfig"), "getInstance", new Object[0]);
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
            if (i.j()) {
                try {
                    FieldUtils.writeField(com.bytedance.pangle.d.a.a(), "mHiddenApiWarningShown", Boolean.TRUE);
                    ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager disableApiWarningShownForAndroidP, true");
                } catch (Exception e2) {
                    ZeusLogger.errReport(ZeusLogger.TAG_INIT, "disableApiWarningShownForAndroidP failed", e2);
                }
            }
            b();
            ContentProviderManager.getInstance().initSystemContentProviderInfo();
            com.bytedance.pangle.receiver.b.a(application);
            this.f6162a = true;
            a(ZeusPluginEventCallback.EVENT_FINISH_INITIALIZATION, 0, null, -1, null);
            return;
        }
        throw new IllegalArgumentException("context must be not null !!!");
    }

    public final void a(int i2, int i3, @Nullable String str, int i4, @Nullable Throwable th) {
        for (Object obj : c()) {
            this.f6165e.post(new Runnable() { // from class: com.bytedance.pangle.h.4

                /* renamed from: a */
                final /* synthetic */ Object f6169a;

                /* renamed from: b */
                final /* synthetic */ int f6170b;

                /* renamed from: c */
                final /* synthetic */ int f6171c;

                /* renamed from: d */
                final /* synthetic */ String f6172d;

                /* renamed from: e */
                final /* synthetic */ int f6173e;

                /* renamed from: f */
                final /* synthetic */ Throwable f6174f;

                AnonymousClass4(Object obj2, int i22, int i32, String str2, int i42, Throwable th2) {
                    obj = obj2;
                    i2 = i22;
                    i3 = i32;
                    str = str2;
                    i4 = i42;
                    th = th2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        ((ZeusPluginEventCallback) obj).onPluginEvent(i2, i3, str, i4, th);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }
}
