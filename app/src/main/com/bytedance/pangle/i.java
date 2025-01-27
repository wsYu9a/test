package com.bytedance.pangle;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.pangle.apm.ApmUtils;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.servermanager.MainServerManager;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class i {

    /* renamed from: d */
    private static volatile i f7668d;

    /* renamed from: a */
    boolean f7669a;

    /* renamed from: b */
    public final List<ZeusPluginStateListener> f7670b = new CopyOnWriteArrayList();

    /* renamed from: c */
    final List<ZeusPluginEventCallback> f7671c = new ArrayList();

    /* renamed from: e */
    private final Handler f7672e = new Handler(Looper.getMainLooper());

    /* renamed from: com.bytedance.pangle.i$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            j.b();
        }
    }

    /* renamed from: com.bytedance.pangle.i$2 */
    public class AnonymousClass2 implements com.bytedance.pangle.c.a {
        public AnonymousClass2() {
        }

        @Override // com.bytedance.pangle.c.a
        public final void a(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
            String str2;
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            if (jSONObject3 == null) {
                jSONObject3 = new JSONObject();
            }
            if (Zeus.getAppApplication() != null) {
                Zeus.getAppApplication();
                str2 = com.bytedance.pangle.d.d.a(com.bytedance.pangle.d.d.a());
            } else {
                str2 = null;
            }
            String packageName = Zeus.getAppApplication() != null ? Zeus.getAppApplication().getPackageName() : "";
            if (str2 == null) {
                str2 = "unknown";
            }
            try {
                jSONObject.putOpt(ContentProviderManager.PLUGIN_PROCESS_NAME, com.bytedance.pangle.log.b.a(str2));
                jSONObject.putOpt("host_package_name", packageName);
                Plugin plugin = Zeus.getPlugin(jSONObject.optString("plugin_package_name", ""), false);
                jSONObject.putOpt("plugin_api_version", com.bytedance.pangle.log.b.a(Integer.valueOf(plugin != null ? plugin.getApiVersionCode() : -1)));
                jSONObject.putOpt("zeus_sdk_version", com.bytedance.pangle.log.b.a("0.0.1-beta.4200.115-bugfix.24-pangle"));
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
            } catch (JSONException e10) {
                ZeusLogger.w(ZeusLogger.TAG_REPORTER, e10.getMessage(), e10);
            }
        }
    }

    /* renamed from: com.bytedance.pangle.i$3 */
    public class AnonymousClass3 implements Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_COMMON, "invoke SystemConfig");
                MethodUtils.invokeStaticMethod(Class.forName("com.android.server.SystemConfig"), "getInstance", new Object[0]);
            } catch (Throwable th2) {
                GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_ERROR, "invoke SystemConfig error : ".concat(String.valueOf(th2)));
            }
        }
    }

    /* renamed from: com.bytedance.pangle.i$4 */
    public class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Object f7676a;

        /* renamed from: b */
        final /* synthetic */ int f7677b;

        /* renamed from: c */
        final /* synthetic */ int f7678c;

        /* renamed from: d */
        final /* synthetic */ String f7679d;

        /* renamed from: e */
        final /* synthetic */ int f7680e;

        /* renamed from: f */
        final /* synthetic */ Throwable f7681f;

        public AnonymousClass4(Object obj, int i10, int i11, String str, int i12, Throwable th2) {
            obj = obj;
            i10 = i10;
            i11 = i11;
            str = str;
            i12 = i12;
            th2 = th2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                ((ZeusPluginEventCallback) obj).onPluginEvent(i10, i11, str, i12, th2);
            } catch (Throwable unused) {
            }
        }
    }

    public static i a() {
        if (f7668d == null) {
            synchronized (i.class) {
                try {
                    if (f7668d == null) {
                        f7668d = new i();
                    }
                } finally {
                }
            }
        }
        return f7668d;
    }

    private static void b() {
        ProviderInfo[] providerInfoArr;
        String str;
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_SERVER_MANAGER, "start");
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
                GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_SERVER_MANAGER, "finish");
                return;
            }
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "initServerManager failed. packageInfo:".concat(String.valueOf(packageInfo)));
        } catch (Exception e10) {
            GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_SERVER_MANAGER, "error:".concat(String.valueOf(e10)));
            throw new RuntimeException(e10);
        }
    }

    private Object[] c() {
        Object[] array;
        synchronized (this.f7671c) {
            try {
                array = !this.f7671c.isEmpty() ? this.f7671c.toArray() : null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return array == null ? new Object[0] : array;
    }

    public final synchronized void a(Application application, boolean z10) {
        if (this.f7669a) {
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
            com.bytedance.pangle.d.e.a(new Runnable() { // from class: com.bytedance.pangle.i.1
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    j.b();
                }
            });
            if (GlobalParam.getInstance().isPostBgDexOptByInit()) {
                com.bytedance.pangle.e.f.a();
            }
            if (z10) {
                Zeus.onPrivacyAgreed();
            }
            com.bytedance.pangle.c.b a10 = com.bytedance.pangle.c.b.a();
            AnonymousClass2 anonymousClass2 = new com.bytedance.pangle.c.a() { // from class: com.bytedance.pangle.i.2
                public AnonymousClass2() {
                }

                @Override // com.bytedance.pangle.c.a
                public final void a(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
                    String str2;
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    if (jSONObject2 == null) {
                        jSONObject2 = new JSONObject();
                    }
                    if (jSONObject3 == null) {
                        jSONObject3 = new JSONObject();
                    }
                    if (Zeus.getAppApplication() != null) {
                        Zeus.getAppApplication();
                        str2 = com.bytedance.pangle.d.d.a(com.bytedance.pangle.d.d.a());
                    } else {
                        str2 = null;
                    }
                    String packageName = Zeus.getAppApplication() != null ? Zeus.getAppApplication().getPackageName() : "";
                    if (str2 == null) {
                        str2 = "unknown";
                    }
                    try {
                        jSONObject.putOpt(ContentProviderManager.PLUGIN_PROCESS_NAME, com.bytedance.pangle.log.b.a(str2));
                        jSONObject.putOpt("host_package_name", packageName);
                        Plugin plugin = Zeus.getPlugin(jSONObject.optString("plugin_package_name", ""), false);
                        jSONObject.putOpt("plugin_api_version", com.bytedance.pangle.log.b.a(Integer.valueOf(plugin != null ? plugin.getApiVersionCode() : -1)));
                        jSONObject.putOpt("zeus_sdk_version", com.bytedance.pangle.log.b.a("0.0.1-beta.4200.115-bugfix.24-pangle"));
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
                    } catch (JSONException e10) {
                        ZeusLogger.w(ZeusLogger.TAG_REPORTER, e10.getMessage(), e10);
                    }
                }
            };
            synchronized (a10.f7494a) {
                a10.f7494a.add(anonymousClass2);
            }
            if (!globalParam.isCloseFlipped()) {
                b.a();
            }
            if (Build.VERSION.SDK_INT == 29) {
                com.bytedance.pangle.d.e.a(new Runnable() { // from class: com.bytedance.pangle.i.3
                    public AnonymousClass3() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_COMMON, "invoke SystemConfig");
                            MethodUtils.invokeStaticMethod(Class.forName("com.android.server.SystemConfig"), "getInstance", new Object[0]);
                        } catch (Throwable th2) {
                            GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_ERROR, "invoke SystemConfig error : ".concat(String.valueOf(th2)));
                        }
                    }
                });
            }
            if (com.bytedance.pangle.util.i.j()) {
                try {
                    GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_COMMON, "invoke disableApiWarning");
                    FieldUtils.writeField(com.bytedance.pangle.d.a.a(), "mHiddenApiWarningShown", Boolean.TRUE);
                    ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager disableApiWarningShownForAndroidP, true");
                } catch (Exception e10) {
                    ZeusLogger.errReport(ZeusLogger.TAG_INIT, "disableApiWarningShownForAndroidP failed", e10);
                }
            }
            b();
            ContentProviderManager.getInstance().initSystemContentProviderInfo();
            if (!globalParam.closeHookHuaweiOnInit()) {
                Zeus.hookHuaWeiVerifier(application);
            }
            this.f7669a = true;
            a(ZeusPluginEventCallback.EVENT_FINISH_INITIALIZATION, 0, null, -1, null);
            return;
        }
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_ERROR, "context is null");
        throw new IllegalArgumentException("context must be not null !!!");
    }

    public final void a(int i10, int i11, @Nullable String str, int i12, @Nullable Throwable th2) {
        for (Object obj : c()) {
            this.f7672e.post(new Runnable() { // from class: com.bytedance.pangle.i.4

                /* renamed from: a */
                final /* synthetic */ Object f7676a;

                /* renamed from: b */
                final /* synthetic */ int f7677b;

                /* renamed from: c */
                final /* synthetic */ int f7678c;

                /* renamed from: d */
                final /* synthetic */ String f7679d;

                /* renamed from: e */
                final /* synthetic */ int f7680e;

                /* renamed from: f */
                final /* synthetic */ Throwable f7681f;

                public AnonymousClass4(Object obj2, int i102, int i112, String str2, int i122, Throwable th22) {
                    obj = obj2;
                    i10 = i102;
                    i11 = i112;
                    str = str2;
                    i12 = i122;
                    th2 = th22;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        ((ZeusPluginEventCallback) obj).onPluginEvent(i10, i11, str, i12, th2);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }
}
