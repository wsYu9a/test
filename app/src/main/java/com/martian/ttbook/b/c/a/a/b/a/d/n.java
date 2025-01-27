package com.martian.ttbook.b.c.a.a.b.a.d;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.location.Location;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.api.BDAdConfig;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.huawei.hms.ads.HwAds;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsCustomController;
import com.kwad.sdk.api.SdkConfig;
import com.qumeng.advlib.api.AiClkAdManager;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.union.UMUnionSdk;
import com.vivo.mobilead.manager.VInitCallback;
import com.vivo.mobilead.manager.VivoAdManager;
import com.vivo.mobilead.model.VAdConfig;
import com.vivo.mobilead.model.VCustomController;
import com.vivo.mobilead.model.VLocation;
import com.vivo.mobilead.unified.base.VivoAdError;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class n {

    /* renamed from: a */
    static AtomicBoolean f15415a = new AtomicBoolean();

    /* renamed from: b */
    static AtomicBoolean f15416b = new AtomicBoolean();

    /* renamed from: c */
    static AtomicBoolean f15417c = new AtomicBoolean();

    /* renamed from: d */
    static AtomicBoolean f15418d = new AtomicBoolean();

    /* renamed from: e */
    static AtomicBoolean f15419e = new AtomicBoolean();

    /* renamed from: f */
    static AtomicBoolean f15420f = new AtomicBoolean();

    /* renamed from: g */
    static AtomicBoolean f15421g = new AtomicBoolean();

    static class a extends KsCustomController {

        /* renamed from: a */
        final /* synthetic */ com.martian.ttbook.b.c.a.a.c.i f15422a;

        a(com.martian.ttbook.b.c.a.a.c.i iVar) {
            this.f15422a = iVar;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canReadInstalledPackages() {
            return this.f15422a.a();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canReadLocation() {
            return this.f15422a.b();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUseMacAddress() {
            return this.f15422a.c();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUseNetworkState() {
            return this.f15422a.d();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUseOaid() {
            return this.f15422a.e();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUsePhoneState() {
            return this.f15422a.f();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUseStoragePermission() {
            return this.f15422a.g();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String getAndroidId() {
            return this.f15422a.h();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String getImei() {
            return this.f15422a.i();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String[] getImeis() {
            return this.f15422a.j();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public List<String> getInstalledPackages() {
            ArrayList arrayList = new ArrayList();
            List<PackageInfo> k = this.f15422a.k();
            if (k != null) {
                Iterator<PackageInfo> it = k.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().packageName);
                }
            }
            return arrayList;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public Location getLocation() {
            return this.f15422a.l();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String getMacAddress() {
            return this.f15422a.m();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String getOaid() {
            return this.f15422a.n();
        }
    }

    static class b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f15423a;

        /* renamed from: b */
        final /* synthetic */ String f15424b;

        /* renamed from: c */
        final /* synthetic */ String f15425c;

        b(Context context, String str, String str2) {
            this.f15423a = context;
            this.f15424b = str;
            this.f15425c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.h(this.f15423a, this.f15424b, this.f15425c, null);
        }
    }

    static class c extends VCustomController {

        /* renamed from: a */
        final /* synthetic */ com.martian.ttbook.b.c.a.a.c.i f15426a;

        c(com.martian.ttbook.b.c.a.a.c.i iVar) {
            this.f15426a = iVar;
        }

        @Override // com.vivo.mobilead.model.VCustomController
        public String getImei() {
            return !TextUtils.isEmpty(this.f15426a.i()) ? this.f15426a.i() : super.getImei();
        }

        @Override // com.vivo.mobilead.model.VCustomController
        public VLocation getLocation() {
            Location l = this.f15426a.l();
            return l != null ? new VLocation(l.getLongitude(), l.getLatitude()) : super.getLocation();
        }

        @Override // com.vivo.mobilead.model.VCustomController
        public boolean isCanPersonalRecommend() {
            return super.isCanPersonalRecommend();
        }

        @Override // com.vivo.mobilead.model.VCustomController
        public boolean isCanUseApplist() {
            return this.f15426a.a();
        }

        @Override // com.vivo.mobilead.model.VCustomController
        public boolean isCanUseImsi() {
            return this.f15426a.f();
        }

        @Override // com.vivo.mobilead.model.VCustomController
        public boolean isCanUseLocation() {
            return this.f15426a.b();
        }

        @Override // com.vivo.mobilead.model.VCustomController
        public boolean isCanUsePhoneState() {
            return this.f15426a.f();
        }

        @Override // com.vivo.mobilead.model.VCustomController
        public boolean isCanUseWifiState() {
            return this.f15426a.d();
        }

        @Override // com.vivo.mobilead.model.VCustomController
        public boolean isCanUseWriteExternal() {
            return this.f15426a.g();
        }
    }

    static class d implements VInitCallback {

        /* renamed from: a */
        final /* synthetic */ o f15427a;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f15427a.a();
                n.f15421g.set(true);
            }
        }

        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f15427a.b();
            }
        }

        d(o oVar) {
            this.f15427a = oVar;
        }

        @Override // com.vivo.mobilead.manager.VInitCallback
        public void failed(@NonNull VivoAdError vivoAdError) {
            com.martian.ttbook.b.c.a.a.e.j.c(new b());
        }

        @Override // com.vivo.mobilead.manager.VInitCallback
        public void suceess() {
            com.martian.ttbook.b.c.a.a.e.j.c(new a());
        }
    }

    static class e implements Runnable {

        /* renamed from: a */
        final /* synthetic */ o f15430a;

        e(o oVar) {
            this.f15430a = oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f15430a.a();
        }
    }

    public static void a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            com.martian.ttbook.b.c.a.a.e.d.g("KSAdSDK", "初始化失败，context或appid为空");
            return;
        }
        try {
            if (f15417c.compareAndSet(false, true)) {
                new BDAdConfig.Builder().setAppName("union_sdk").setAppsid(str).build(context).init();
                MobadsPermissionSettings.setPermissionLocation(false);
            }
        } catch (Exception unused) {
            f15417c.set(false);
        }
    }

    public static void b(Context context, String str, o oVar) {
        if (oVar == null || !(context instanceof Application)) {
            return;
        }
        if (f15421g.get()) {
            com.martian.ttbook.b.c.a.a.e.j.c(new e(oVar));
            return;
        }
        com.martian.ttbook.b.c.a.a.c.i g2 = com.martian.ttbook.b.c.a.a.d.b.g.b().g();
        VAdConfig.Builder debug = new VAdConfig.Builder().setMediaId(str).setDebug(true);
        if (g2 != null) {
            debug.setCustomController(new c(g2));
        }
        VivoAdManager.getInstance().init((Application) context, debug.build(), new d(oVar));
    }

    public static void c(Context context, String str, String str2) {
        if (f15415a.compareAndSet(false, true)) {
            com.martian.ttbook.b.c.a.a.b.a.d.y.c.e(context, str, str2);
        }
    }

    public static void e(boolean z) {
        try {
            Class<?> cls = Class.forName("com.qq.e.comm.managers.setting.GlobalSetting");
            cls.getDeclaredMethod("setAgreePrivacyStrategy", Boolean.TYPE).invoke(cls, Boolean.valueOf(z));
            Log.e("xxx", "set  " + z);
        } catch (Exception e2) {
            Log.e("xxx", "e " + e2.getMessage());
        }
    }

    public static void f(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            com.martian.ttbook.b.c.a.a.e.d.g("gdt_ad", "初始化失败，context或appid为空");
            return;
        }
        if (com.martian.ttbook.b.c.a.a.e.i.i("4.380") && f15416b.compareAndSet(false, true)) {
            try {
                Class<?> cls = Class.forName("com.qq.e.comm.managers.GDTAdSdk");
                Method declaredMethod = cls.getDeclaredMethod("init", Context.class, String.class);
                if (declaredMethod != null) {
                    declaredMethod.invoke(cls, context, str);
                }
            } catch (Exception e2) {
                try {
                    com.martian.ttbook.b.c.a.a.e.d.g("gdt_ad", "e " + e2.getLocalizedMessage());
                    Class<?> cls2 = Class.forName("com.qq.e.comm.managers.GDTADManager");
                    cls2.getMethod("initWith", Context.class, String.class).invoke(cls2.getDeclaredMethod("getInstance", new Class[0]).invoke(cls2, new Object[0]), context, str);
                } catch (Exception e3) {
                    com.martian.ttbook.b.c.a.a.e.d.g("gdt_ad", "err " + e3.getLocalizedMessage());
                    f15416b.set(false);
                }
            }
        }
    }

    public static void g(Context context, String str, String str2) {
        if (f15419e.compareAndSet(false, true)) {
            com.martian.ttbook.b.c.a.a.e.d.g("UM_TAG", "init");
            UMConfigure.preInit(context, str, str2);
            UMUnionSdk.init(context);
            if (TextUtils.isEmpty(str)) {
                f15419e.set(false);
                com.martian.ttbook.b.c.a.a.e.d.g("UM_TAG", "init no appKey! ");
            } else if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                com.martian.ttbook.b.a.k.n.b(new b(context, str, str2));
            } else {
                h(context, str, str2, null);
            }
        }
    }

    public static void h(Context context, String str, String str2, String str3) {
        UMConfigure.submitPolicyGrantResult(context, true);
        UMConfigure.init(context, str, str2, 1, str3);
    }

    public static void i(Context context, String str) {
        if (f15418d.compareAndSet(false, true)) {
            com.martian.ttbook.b.c.a.a.e.d.g("HW_TAG", "init");
            HwAds.init(context);
        }
    }

    public static boolean j(Context context, String str) {
        String appId = KsAdSDK.getAppId();
        if (!TextUtils.isEmpty(appId) && appId.equals(str)) {
            return true;
        }
        if (context == null || TextUtils.isEmpty(str)) {
            com.martian.ttbook.b.c.a.a.e.d.g("KSAdSDK", "初始化失败，context或appid为空");
            return false;
        }
        com.martian.ttbook.b.c.a.a.e.d.g("KSAdSDK", "ks init appId " + str);
        SdkConfig.Builder debug = new SdkConfig.Builder().appId(str).showNotification(true).debug(com.martian.ttbook.b.c.a.a.d.b.j.r.booleanValue());
        com.martian.ttbook.b.c.a.a.c.i g2 = com.martian.ttbook.b.c.a.a.d.b.g.b().g();
        if (g2 != null) {
            debug.customController(new a(g2));
        }
        boolean init = KsAdSDK.init(context.getApplicationContext(), debug.build());
        String appId2 = KsAdSDK.getAppId();
        boolean z = init && !TextUtils.isEmpty(appId2) && appId2.equals(str);
        com.martian.ttbook.b.c.a.a.e.d.g("KSAdSDK", "ks init result  " + z);
        return z;
    }

    public static void k(Context context, String str) {
        if (f15420f.compareAndSet(false, true)) {
            com.martian.ttbook.b.c.a.a.e.d.g("QM_TAG", "init");
            AiClkAdManager.getInstance().init(context, str);
            com.martian.ttbook.b.c.a.a.c.i g2 = com.martian.ttbook.b.c.a.a.d.b.g.b().g();
            if (g2 != null) {
                AiClkAdManager.getInstance().appListFromClientNotice();
                AiClkAdManager.getInstance().setAppList(g2.k());
            }
        }
    }
}
