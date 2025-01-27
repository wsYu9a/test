package com.sntech.ads;

import android.app.Application;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.Printer;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import bh.a0;
import bh.b;
import bh.h;
import com.at.api.service.CService;
import com.at.api.service.DService;
import com.sn.catpie.service.CCService;
import com.sn.catpie.service.DeviceStatService;
import com.snassdk.sdk.wrapper.Wrapper;
import com.sntech.ads.SNAdConfig;
import com.sntech.ads.SNAdSdk;
import com.sntech.ads.SNInitializer;
import com.sntech.ads.api.callback.InitAdCallback;
import com.sntech.ads.api.constant.BaseConstants;
import com.sntech.ads.impl.entity.InitConfig;
import com.sntech.ads.impl.utils.reflection.Reflection;
import com.sntech.net.DomainConfig;
import com.sntech.net.DomainManager;
import com.sntech.net.NetClient;
import int0.Cfor;
import java.net.ssl.SSLSocketLogger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import mj.j;
import new0.Cif;
import nk.l;
import p002continue.f;
import p012volatile.Ccase;
import yk.a;
import yk.c;
import yk.d;
import yk.e;
import yk.f;
import yk.i;
import yk.k;

@Keep
/* loaded from: classes4.dex */
public final class SNAdSdk {
    private static final String TAG = "SNAdSdk";
    private static final SNInitializer sInitializer = new i();
    private static boolean sAttachBaseContextCalled = false;

    /* renamed from: com.sntech.ads.SNAdSdk$do */
    public class Cdo implements SNInitializer.InitCallback {

        /* renamed from: do */
        public final /* synthetic */ Application f15do;

        public Cdo(Application application) {
            this.f15do = application;
        }

        @Override // com.sntech.ads.SNInitializer.InitCallback
        public final void fail(Exception exc) {
            b.a.f1608a.d(SNAdSdk.TAG, "init failed: " + exc);
            SNAdSdk.onInitFinished(this.f15do, false);
        }

        @Override // com.sntech.ads.SNInitializer.InitCallback
        public final void success() {
            SNAdSdk.onInitFinished(this.f15do, true);
        }
    }

    private SNAdSdk() {
    }

    @Keep
    public static void addInitCallback(SNInitializer.InitCallback initCallback) {
        sInitializer.addCallback(initCallback);
    }

    @Keep
    public static SNAdManager getAdManager() {
        return k.a.f33582a;
    }

    @Keep
    public static SNCodeManager getCodeManager() {
        Ccase.Cdo cdo = Ccase.Cdo.f31554a;
        return (SNCodeManager) Ccase.Cdo.f31555b.getValue();
    }

    @Keep
    public static SNEventManager getEventManager() {
        return d.a.f33570a;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.HashSet, java.util.Set<java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.Map<java.lang.String, bh.h>, java.util.concurrent.ConcurrentHashMap] */
    @Keep
    public static <T> T getExtService(Class<T> cls) {
        f fVar = f.b.f25213a;
        Iterator it = fVar.f25207b.values().iterator();
        while (true) {
            T t10 = null;
            if (!it.hasNext()) {
                Iterator it2 = fVar.f25208c.iterator();
                while (it2.hasNext()) {
                    T t11 = (T) it2.next();
                    if (cls.isInstance(t11)) {
                        return t11;
                    }
                }
                return null;
            }
            try {
                t10 = (T) ((h) it.next()).getService(cls);
            } catch (Throwable unused) {
            }
            if (t10 != null && cls.isInstance(t10)) {
                return t10;
            }
        }
    }

    @Keep
    public static void initAdPlatforms(@NonNull Context context, @NonNull InitAdCallback initAdCallback) {
        b.a.f1608a.f(TAG, "initAdPlatforms");
        initAdCallback.onInitAdPlatforms(Wrapper.wrap(context));
    }

    public static /* synthetic */ void lambda$onApplicationAttachBaseContext$0(String str) {
    }

    public static /* synthetic */ void lambda$onApplicationAttachBaseContext$1(Boolean bool) {
        if (bool.booleanValue()) {
            sInitializer.loaderInitSuccess();
        }
    }

    public static void lambda$onApplicationAttachBaseContext$2(Application application, SNAdConfig sNAdConfig) {
        b.a.f1608a.f(TAG, "process onApplicationAttachBaseContext");
        DomainManager.get().init(application.getBaseContext(), new DomainConfig(new DomainConfig.Cdo().m46do(DomainConfig.TEMPLATE_X1, BaseConstants.DOMAIN_X1).m46do(DomainConfig.TEMPLATE_DEVICE, BaseConstants.DOMAIN_DEVICE).m46do(DomainConfig.TEMPLATE_DEVICE_ACTIVE, BaseConstants.DOMAIN_DEVICE_ACTIVE)));
        f fVar = f.b.f25213a;
        fVar.k(application, sNAdConfig, new bh.i() { // from class: dg.b
            @Override // bh.i
            public final void a(Object obj) {
                SNAdSdk.lambda$onApplicationAttachBaseContext$1((Boolean) obj);
            }
        });
        fVar.y(application);
        sInitializer.init(application.getBaseContext());
    }

    public static void lambda$onApplicationAttachBaseContext$3(Application application, SNAdConfig sNAdConfig) {
        NetClient.init(application.getBaseContext(), "5.3.0.0", sNAdConfig.getAppId());
        application.getBaseContext();
        b.a.f1608a.f(c.f33566b, "CrashHandler init");
        if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof c)) {
            Thread.setDefaultUncaughtExceptionHandler(new c(Thread.getDefaultUncaughtExceptionHandler()));
        }
        if (mj.f.c()) {
            c.f33567c.postDelayed(new e(), 3000L);
        }
        addInitCallback(new a());
        kk.c.b(application, sNAdConfig);
        kk.c.a(application, sNAdConfig);
        yk.f.a().b(new f.a() { // from class: dg.k

            /* renamed from: a */
            public final /* synthetic */ Application f25560a;

            /* renamed from: b */
            public final /* synthetic */ SNAdConfig f25561b;

            public /* synthetic */ k(Application application2, SNAdConfig sNAdConfig2) {
                application = application2;
                sNAdConfig = sNAdConfig2;
            }

            @Override // yk.f.a
            public final void j() {
                SNAdSdk.lambda$onApplicationAttachBaseContext$2(application, sNAdConfig);
            }
        });
    }

    public static void lambda$onApplicationCreate$4(Application application) {
        b.a.f1608a.f(TAG, "process onApplicationCreate");
        f.b.f25213a.A(application);
    }

    public static /* synthetic */ void lambda$onApplicationCreate$5(Application application) {
        yk.f.a().b(new f.a() { // from class: dg.h

            /* renamed from: a */
            public final /* synthetic */ Application f25557a;

            public /* synthetic */ h(Application application2) {
                application = application2;
            }

            @Override // yk.f.a
            public final void j() {
                SNAdSdk.lambda$onApplicationCreate$4(application);
            }
        });
        sInitializer.addCallback(new Cdo(application2));
    }

    public static void lambda$onApplicationLowMemory$6(Application application) {
        b.a.f1608a.f(TAG, "process onApplicationLowMemory");
        f.b.f25213a.h(application);
        l.c().u("APPLICATION_LOW_MEMORY", null);
    }

    public static /* synthetic */ void lambda$onApplicationLowMemory$7(Application application) {
        yk.f.a().b(new f.a() { // from class: dg.c

            /* renamed from: a */
            public final /* synthetic */ Application f25551a;

            public /* synthetic */ c(Application application2) {
                application = application2;
            }

            @Override // yk.f.a
            public final void j() {
                SNAdSdk.lambda$onApplicationLowMemory$6(application);
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [java.util.HashSet, java.util.Set<java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.util.HashSet, java.util.Set<java.lang.Object>] */
    public static void lambda$onInitFinished$9(Application application) {
        InitConfig initConfig;
        Cif cif;
        p002continue.f fVar = f.b.f25213a;
        SNAdConfig sNAdConfig = fVar.f25209d;
        DService dService = (DService) getExtService(DService.class);
        if (getExtService(DeviceStatService.class) == null && dService != null && fVar.f25208c.contains(dService)) {
            b.a.f1608a.f("Fallback", "SNC.onApplicationCreate(Fallback)");
            if (rh.d.f30429c == null) {
                throw new IllegalStateException("SNC init error: should call init first!");
            }
            if (rh.d.d()) {
                Log.d("SNC_LOG", "onApplicationCreate");
            }
            rh.d.c(rh.d.f30429c, false);
            Context context = rh.d.f30429c;
            synchronized (Cif.class) {
                try {
                    if (Cif.f28856e == null) {
                        Cif.f28856e = new Cif(context);
                    }
                    cif = Cif.f28856e;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            synchronized (cif.f28860b) {
                if (!cif.f28860b.get()) {
                    cif.f28860b.set(true);
                    cif.f28861c.d(cif.f28859a);
                    cif.f28862d.b(cif.f28859a);
                    if (sk.e.b(cif.f28859a)) {
                        try {
                            ((WifiManager) cif.f28859a.getApplicationContext().getSystemService("wifi")).startScan();
                        } catch (Exception e10) {
                            if (rh.d.d()) {
                                e10.printStackTrace();
                            }
                        }
                    }
                }
            }
            new Thread(new Cfor(context), "s_n_a_task").start();
        }
        CService cService = (CService) getExtService(CService.class);
        if (getExtService(CCService.class) == null) {
            p002continue.f fVar2 = f.b.f25213a;
            fVar2.getClass();
            if (cService != null && fVar2.f25208c.contains(cService) && (initConfig = yk.b.f33565c) != null && initConfig.checkRisk == 1) {
                if (ph.d.f29891f == null) {
                    synchronized (ph.d.class) {
                        try {
                            if (ph.d.f29891f == null) {
                                ph.d.f29891f = new ph.d();
                            }
                        } finally {
                        }
                    }
                }
                ph.d.f29891f.c();
            }
        }
        String userId = f.b.f25213a.f25209d.getUserId();
        if (TextUtils.isEmpty(userId)) {
            return;
        }
        getAdManager().setUserId(userId);
    }

    public static void lambda$updatePrivacyAgreed$8(Context context, boolean z10) {
        yk.b.f33564b = context;
        yk.f a10 = yk.f.a();
        synchronized (a10.f33572a) {
            try {
                boolean z11 = j.a().getBoolean("privacy_agreed", false);
                j.e("privacy_agreed", z10);
                if (!z11 && z10) {
                    for (int i10 = 0; i10 < a10.f33572a.size(); i10++) {
                        a10.f33572a.get(i10).j();
                    }
                    a10.f33572a.clear();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Keep
    public static void onApplicationAttachBaseContext(@NonNull Application application, @NonNull SNAdConfig sNAdConfig) {
        long currentTimeMillis = System.currentTimeMillis();
        sAttachBaseContextCalled = true;
        Context baseContext = application.getBaseContext();
        if (!yk.b.f33563a) {
            yk.b.f33563a = true;
            yk.b.f33564b = baseContext;
            j.c(j.a().getInt("START_UP_TIMES", 0) + 1);
        }
        if (TextUtils.isEmpty(sNAdConfig.getAppId())) {
            throw new RuntimeException("App Id Can not be null");
        }
        bh.j jVar = b.a.f1608a;
        String str = TAG;
        StringBuilder a10 = nh.b.a("Gradle build success = ");
        a10.append(Wrapper.isContextWrapped(application));
        jVar.f(str, a10.toString());
        if (Build.VERSION.SDK_INT >= 28 && !qk.a.a()) {
            Reflection.m42do(application);
        }
        String str2 = null;
        SSLSocketLogger.setup(application, new Printer() { // from class: dg.i
            @Override // android.util.Printer
            public final void println(String str3) {
                SNAdSdk.lambda$onApplicationAttachBaseContext$0(str3);
            }
        }, null);
        byte[] bytes = sNAdConfig.getAppId().getBytes(StandardCharsets.UTF_8);
        if (bytes != null) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bytes);
                for (byte b10 : messageDigest.digest()) {
                    int i10 = b10 & 255;
                    stringBuffer.append(i10 < 16 ? "0" + Integer.toHexString(i10) : Integer.toHexString(i10));
                }
                str2 = stringBuffer.toString();
            } catch (NoSuchAlgorithmException unused) {
                str2 = "No";
            }
        }
        p002continue.f fVar = f.b.f25213a;
        String substring = str2.substring(0, 16);
        fVar.getClass();
        a0.f1607a = substring;
        fVar.p().post(new Runnable() { // from class: dg.j

            /* renamed from: b */
            public final /* synthetic */ Application f25558b;

            /* renamed from: c */
            public final /* synthetic */ SNAdConfig f25559c;

            public /* synthetic */ j(Application application2, SNAdConfig sNAdConfig2) {
                application = application2;
                sNAdConfig = sNAdConfig2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                SNAdSdk.lambda$onApplicationAttachBaseContext$3(application, sNAdConfig);
            }
        });
        long currentTimeMillis2 = System.currentTimeMillis();
        bh.j jVar2 = b.a.f1608a;
        String str3 = TAG;
        StringBuilder a11 = nh.b.a("onApplicationAttachBaseContext cost ");
        a11.append(currentTimeMillis2 - currentTimeMillis);
        a11.append("ms");
        jVar2.k(str3, a11.toString());
    }

    @Keep
    public static void onApplicationCreate(@NonNull Application application) {
        if (!sAttachBaseContextCalled) {
            b.a.f1608a.d(TAG, "Call onApplicationAttachBaseContext first!");
        }
        long currentTimeMillis = System.currentTimeMillis();
        f.b.f25213a.p().post(new Runnable() { // from class: dg.d

            /* renamed from: b */
            public final /* synthetic */ Application f25552b;

            public /* synthetic */ d(Application application2) {
                application = application2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                SNAdSdk.lambda$onApplicationCreate$5(application);
            }
        });
        long currentTimeMillis2 = System.currentTimeMillis();
        bh.j jVar = b.a.f1608a;
        String str = TAG;
        StringBuilder a10 = nh.b.a("onApplicationCreate cost ");
        a10.append(currentTimeMillis2 - currentTimeMillis);
        a10.append("ms");
        jVar.k(str, a10.toString());
    }

    @Keep
    public static void onApplicationLowMemory(Application application) {
        f.b.f25213a.p().post(new Runnable() { // from class: dg.e

            /* renamed from: b */
            public final /* synthetic */ Application f25553b;

            public /* synthetic */ e(Application application2) {
                application = application2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                SNAdSdk.lambda$onApplicationLowMemory$7(application);
            }
        });
    }

    public static void onInitFinished(Application application, boolean z10) {
        f.b.f25213a.p().post(new Runnable() { // from class: dg.g

            /* renamed from: b */
            public final /* synthetic */ Application f25556b;

            public /* synthetic */ g(Application application2) {
                application = application2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                SNAdSdk.lambda$onInitFinished$9(application);
            }
        });
    }

    @Keep
    public static void updatePrivacyAgreed(Context context, boolean z10) {
        b.a.f1608a.f(TAG, "updatePrivacyAgreed " + z10);
        f.b.f25213a.p().post(new Runnable() { // from class: dg.f

            /* renamed from: b */
            public final /* synthetic */ Context f25554b;

            /* renamed from: c */
            public final /* synthetic */ boolean f25555c;

            public /* synthetic */ f(Context context2, boolean z102) {
                context = context2;
                z10 = z102;
            }

            @Override // java.lang.Runnable
            public final void run() {
                SNAdSdk.lambda$updatePrivacyAgreed$8(context, z10);
            }
        });
    }
}
