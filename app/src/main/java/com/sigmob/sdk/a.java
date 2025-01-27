package com.sigmob.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.location.Location;
import android.media.AudioManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.mta.DeviceContext;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.utils.AdLifecycleManager;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.AdActivity;
import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.common.h;
import com.sigmob.sdk.base.common.u;
import com.sigmob.sdk.base.k;
import com.sigmob.sdk.base.l;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntityActive;
import com.sigmob.sdk.base.network.f;
import com.sigmob.sdk.base.utils.d;
import com.sigmob.windad.WindAdOptions;
import com.sigmob.windad.WindAds;
import com.sigmob.windad.WindCustomController;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    public static WeakReference<Activity> f17487a = null;

    /* renamed from: b */
    public static Context f17488b = null;

    /* renamed from: c */
    public static b f17489c = null;

    /* renamed from: d */
    public static String f17490d = null;

    /* renamed from: e */
    public static WeakReference<Activity> f17491e = null;

    /* renamed from: f */
    public static boolean f17492f = false;

    /* renamed from: g */
    public static boolean f17493g = false;

    /* renamed from: h */
    public static boolean f17494h = false;

    /* renamed from: i */
    public static DeviceContext f17495i;

    /* renamed from: com.sigmob.sdk.a$a */
    public class C0560a extends DeviceContext {
        @Override // com.czhj.sdk.common.mta.DeviceContext
        public String getAndroidId() {
            WindCustomController customController = WindAds.sharedAds().getOptions().getCustomController();
            if ((customController == null || customController.isCanUseAndroidId()) && a.f17492f && WindAds.sharedAds().isPersonalizedAdvertisingOn()) {
                return ClientMetadata.getInstance().getAndroidId();
            }
            if (customController == null || customController.isCanUseAndroidId()) {
                return null;
            }
            return customController.getAndroidId();
        }

        @Override // com.czhj.sdk.common.mta.DeviceContext
        public String getCarrier() {
            WindCustomController customController = WindAds.sharedAds().getOptions().getCustomController();
            if (customController == null || customController.isCanUsePhoneState()) {
                return ClientMetadata.getInstance().getNetworkOperatorForUrl();
            }
            return null;
        }

        @Override // com.czhj.sdk.common.mta.DeviceContext
        public String getCarrierName() {
            WindCustomController customController = WindAds.sharedAds().getOptions().getCustomController();
            if (customController == null || customController.isCanUsePhoneState()) {
                return ClientMetadata.getInstance().getNetworkOperatorName();
            }
            return null;
        }

        @Override // com.czhj.sdk.common.mta.DeviceContext
        public String getImei() {
            WindCustomController customController = WindAds.sharedAds().getOptions().getCustomController();
            if ((customController == null || customController.isCanUsePhoneState()) && a.f17492f && WindAds.sharedAds().isPersonalizedAdvertisingOn()) {
                return ClientMetadata.getInstance().getDeviceId();
            }
            if (customController == null || customController.isCanUsePhoneState()) {
                return null;
            }
            return customController.getDevImei();
        }

        @Override // com.czhj.sdk.common.mta.DeviceContext
        public String getImei1() {
            WindCustomController customController = WindAds.sharedAds().getOptions().getCustomController();
            if ((customController == null || customController.isCanUsePhoneState()) && a.f17492f && WindAds.sharedAds().isPersonalizedAdvertisingOn()) {
                return ClientMetadata.getInstance().getDeviceId(0);
            }
            if (customController == null || customController.isCanUsePhoneState()) {
                return null;
            }
            return customController.getDevImei();
        }

        @Override // com.czhj.sdk.common.mta.DeviceContext
        public String getImei2() {
            WindCustomController customController = WindAds.sharedAds().getOptions().getCustomController();
            if ((customController == null || customController.isCanUsePhoneState()) && a.f17492f && WindAds.sharedAds().isPersonalizedAdvertisingOn()) {
                return ClientMetadata.getInstance().getDeviceId(1);
            }
            if (customController == null || customController.isCanUsePhoneState()) {
                return null;
            }
            return customController.getDevImei();
        }

        @Override // com.czhj.sdk.common.mta.DeviceContext
        public Location getLocation() {
            WindCustomController customController = WindAds.sharedAds().getOptions().getCustomController();
            if (customController == null || customController.isCanUseLocation()) {
                return ClientMetadata.getInstance().getLocation();
            }
            if (customController.isCanUseLocation()) {
                return null;
            }
            return customController.getLocation();
        }

        @Override // com.czhj.sdk.common.mta.DeviceContext
        public String getOaid() {
            WindCustomController customController = WindAds.sharedAds().getOptions().getCustomController();
            return (customController == null || TextUtils.isEmpty(customController.getDevOaid())) ? ClientMetadata.getInstance().getOAID() : customController.getDevOaid();
        }

        @Override // com.czhj.sdk.common.mta.DeviceContext
        public boolean isCustomAndroidId() {
            WindCustomController customController = WindAds.sharedAds().getOptions().getCustomController();
            return customController == null || customController.isCanUseAndroidId();
        }

        @Override // com.czhj.sdk.common.mta.DeviceContext
        public boolean isCustomOaId() {
            WindCustomController customController = WindAds.sharedAds().getOptions().getCustomController();
            return (customController == null || TextUtils.isEmpty(customController.getDevOaid())) ? false : true;
        }

        @Override // com.czhj.sdk.common.mta.DeviceContext
        public boolean isCustomPhoneState() {
            WindCustomController customController = WindAds.sharedAds().getOptions().getCustomController();
            return customController == null || customController.isCanUsePhoneState();
        }
    }

    public static class b implements AdLifecycleManager.LifecycleListener {

        /* renamed from: a */
        public String f17496a;

        /* renamed from: b */
        public long f17497b;

        /* renamed from: d */
        public String f17499d;

        /* renamed from: e */
        public int f17500e;

        /* renamed from: i */
        public boolean f17504i;

        /* renamed from: c */
        public Map<String, String> f17498c = new HashMap();

        /* renamed from: f */
        public boolean f17501f = true;

        /* renamed from: g */
        public boolean f17502g = false;

        /* renamed from: h */
        public boolean f17503h = false;

        /* renamed from: j */
        public BroadcastReceiver f17505j = new C0561a();

        /* renamed from: com.sigmob.sdk.a$b$a */
        public class C0561a extends BroadcastReceiver {
            public C0561a() {
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
            
                if (r4.equals(com.sigmob.sdk.base.k.L) == false) goto L52;
             */
            @Override // android.content.BroadcastReceiver
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onReceive(android.content.Context r4, android.content.Intent r5) {
                /*
                    r3 = this;
                    java.lang.String r4 = r5.getAction()
                    byte[] r4 = r4.getBytes()
                    r5 = 2
                    java.lang.String r4 = android.util.Base64.encodeToString(r4, r5)
                    r4.hashCode()
                    r0 = 0
                    r1 = -1
                    int r2 = r4.hashCode()
                    switch(r2) {
                        case -252353173: goto L2f;
                        case 1349729289: goto L24;
                        case 1349784159: goto L1b;
                        default: goto L19;
                    }
                L19:
                    r5 = -1
                    goto L39
                L1b:
                    java.lang.String r2 = "YW5kcm9pZC5pbnRlbnQuYWN0aW9uLlNDUkVFTl9PTg=="
                    boolean r4 = r4.equals(r2)
                    if (r4 != 0) goto L39
                    goto L19
                L24:
                    java.lang.String r5 = "YW5kcm9pZC5pbnRlbnQuYWN0aW9uLlNDUkVFTl9PRkY="
                    boolean r4 = r4.equals(r5)
                    if (r4 != 0) goto L2d
                    goto L19
                L2d:
                    r5 = 1
                    goto L39
                L2f:
                    java.lang.String r5 = "YW5kcm9pZC5pbnRlbnQuYWN0aW9uLlVTRVJfUFJFU0VOVA=="
                    boolean r4 = r4.equals(r5)
                    if (r4 != 0) goto L38
                    goto L19
                L38:
                    r5 = 0
                L39:
                    switch(r5) {
                        case 0: goto L50;
                        case 1: goto L48;
                        case 2: goto L3d;
                        default: goto L3c;
                    }
                L3c:
                    goto L58
                L3d:
                    java.lang.String r4 = "screen on"
                    com.czhj.sdk.logger.SigmobLog.d(r4)
                    java.lang.String r4 = "screen_on"
                L44:
                    com.sigmob.sdk.base.common.b0.b(r4, r0, r0)
                    goto L58
                L48:
                    java.lang.String r4 = "screen off"
                    com.czhj.sdk.logger.SigmobLog.d(r4)
                    java.lang.String r4 = "locked"
                    goto L44
                L50:
                    java.lang.String r4 = "screen user present"
                    com.czhj.sdk.logger.SigmobLog.d(r4)
                    java.lang.String r4 = "unlock"
                    goto L44
                L58:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.a.b.C0561a.onReceive(android.content.Context, android.content.Intent):void");
            }
        }

        public b() {
            AdLifecycleManager.getInstance().initialize(a.c());
            this.f17497b = System.currentTimeMillis();
            this.f17496a = UUID.randomUUID().toString();
            SigmobLog.i("session_start: " + this.f17497b + ":" + this.f17496a);
            PointEntityActive.ActiveTracking(PointCategory.SESSION_START, this.f17496a, "0", String.valueOf(this.f17497b));
            AdLifecycleManager.getInstance().addLifecycleListener(this);
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(new String(Base64.decode(k.L, 2)));
                intentFilter.addAction(new String(Base64.decode(k.M, 2)));
                intentFilter.addAction(new String(Base64.decode(k.N, 2)));
                u.a(a.f17488b, this.f17505j, intentFilter);
            } catch (Throwable th2) {
                SigmobLog.e("register screen status receiver error" + th2.getMessage());
            }
        }

        public void a(Activity activity) {
        }

        public void b(Activity activity) {
        }

        @Override // com.czhj.sdk.common.utils.AdLifecycleManager.LifecycleListener
        public void onCreate(Activity activity) {
            String simpleName = activity.getClass().getSimpleName();
            this.f17499d = simpleName;
            this.f17498c.put(simpleName, simpleName);
            this.f17501f = true;
            this.f17502g = false;
        }

        @Override // com.czhj.sdk.common.utils.AdLifecycleManager.LifecycleListener
        public void onDestroy(Activity activity) {
            if (activity instanceof AdActivity) {
                this.f17504i = false;
            }
            this.f17498c.remove(activity.getClass().getSimpleName());
            if (this.f17498c.size() == 0 && this.f17501f) {
                long currentTimeMillis = System.currentTimeMillis();
                long j10 = (currentTimeMillis - this.f17497b) / 1000;
                SigmobLog.i("onActivityDestroyed session_end: " + currentTimeMillis + ":" + this.f17496a + ":" + j10);
                PointEntityActive.ActiveTracking(PointCategory.SESSION_END, this.f17496a, String.valueOf(j10), String.valueOf(currentTimeMillis));
                this.f17497b = System.currentTimeMillis();
                this.f17501f = false;
            }
            if (this.f17498c.size() == 0) {
                this.f17503h = true;
            }
        }

        @Override // com.czhj.sdk.common.utils.AdLifecycleManager.LifecycleListener
        public void onPause(Activity activity) {
        }

        @Override // com.czhj.sdk.common.utils.AdLifecycleManager.LifecycleListener
        public void onResume(Activity activity) {
            if (activity instanceof AdActivity) {
                this.f17504i = true;
            } else if (!this.f17504i) {
                WeakReference unused = a.f17491e = new WeakReference(activity);
            }
            this.f17502g = !activity.getClass().getSimpleName().equals(this.f17499d);
            this.f17499d = activity.getClass().getSimpleName();
            if (this.f17502g) {
                WeakReference unused2 = a.f17487a = new WeakReference(activity);
            }
            if (!this.f17501f || this.f17503h) {
                this.f17503h = false;
                this.f17496a = UUID.randomUUID().toString();
                this.f17497b = System.currentTimeMillis();
                this.f17501f = true;
                SigmobLog.i("onActivityResumed session_start: " + this.f17497b + ":" + this.f17496a);
                PointEntityActive.ActiveTracking(PointCategory.SESSION_START, this.f17496a, "0", String.valueOf(this.f17497b));
            }
        }

        @Override // com.czhj.sdk.common.utils.AdLifecycleManager.LifecycleListener
        public void onStart(Activity activity) {
            this.f17500e++;
        }

        @Override // com.czhj.sdk.common.utils.AdLifecycleManager.LifecycleListener
        public void onStop(Activity activity) {
            this.f17500e--;
            if (activity.getClass().getSimpleName().equals(this.f17499d)) {
                b();
                if (!this.f17502g || this.f17498c.size() == 1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j10 = (currentTimeMillis - this.f17497b) / 1000;
                    SigmobLog.i("onActivityStopped session_end: " + currentTimeMillis + ":" + this.f17496a + ":" + j10);
                    PointEntityActive.ActiveTracking(PointCategory.SESSION_END, this.f17496a, String.valueOf(j10), String.valueOf(currentTimeMillis));
                    this.f17497b = System.currentTimeMillis();
                    this.f17501f = false;
                }
            }
        }

        public void a(Activity activity, int i10, int i11, Intent intent) {
        }

        public final void b() {
            BaseAdUnit m10 = h.m();
            if (m10 != null) {
                f.a(m10, "open_pkg");
                b0.a("open_pkg", "1", m10);
            }
            h.f((BaseAdUnit) null);
        }

        public int a() {
            return this.f17500e;
        }
    }

    public static Application c() {
        Context context = f17488b;
        if (context instanceof Application) {
            return (Application) context;
        }
        return null;
    }

    public static Context d() {
        return f17488b;
    }

    public static DeviceContext e() {
        DeviceContext deviceContext = f17495i;
        if (deviceContext != null || f17488b == null) {
            return deviceContext;
        }
        C0560a c0560a = new C0560a();
        f17495i = c0560a;
        return c0560a;
    }

    public static String f() {
        return f17490d;
    }

    public static Activity g() {
        WeakReference<Activity> weakReference = f17491e;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static Activity h() {
        WeakReference<Activity> weakReference = f17487a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static boolean i() {
        AudioManager audioManager;
        return (f17488b == null || (audioManager = (AudioManager) d().getSystemService("audio")) == null || audioManager.getStreamVolume(3) != 0) ? false : true;
    }

    public static void j() {
        if (f17489c == null) {
            f17489c = new b();
        }
    }

    public static void k() {
        WindCustomController customController;
        List<PackageInfo> installPackageInfoList;
        WindAdOptions options = WindAds.sharedAds().getOptions();
        if (options == null || options.getCustomController() == null || (customController = options.getCustomController()) == null || customController.isCanUseAppList() || (installPackageInfoList = customController.getInstallPackageInfoList()) == null) {
            return;
        }
        Iterator<PackageInfo> it = installPackageInfoList.iterator();
        while (it.hasNext()) {
            b0.a(it.next(), 2);
        }
    }

    public static void c(Context context) {
        Networking.AddSigmobServerURL(l.r());
        Networking.AddSigmobServerURL(l.w().j());
        Networking.AddSigmobServerURL(l.w().v());
        Networking.AddSigmobServerURL(l.w().z());
        Networking.initializeV2(context);
        Networking.initializeSigRequestQueue(context);
    }

    public static synchronized void a(Context context) {
        synchronized (a.class) {
            if (f17488b == null) {
                Context applicationContext = context.getApplicationContext();
                f17488b = applicationContext;
                b(applicationContext);
                d.a(f17488b, k.f18183o);
                l.w().f0();
                c(f17488b);
                com.sigmob.sdk.base.db.a.a(f17488b);
                ClientMetadata.getInstance().initialize(f17488b);
                k();
            }
        }
    }

    public static void b(Context context) {
        try {
            if (TextUtils.isEmpty(f17490d)) {
                List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("hap://app/")), 0);
                if (queryIntentActivities.isEmpty()) {
                    return;
                }
                f17490d = queryIntentActivities.get(0).activityInfo.packageName;
            }
        } catch (NullPointerException unused) {
        }
    }

    public static void a(boolean z10) {
        f17492f = z10;
    }

    public static void a(Activity activity) {
        if (activity != null) {
            f17487a = new WeakReference<>(activity);
        }
    }
}
