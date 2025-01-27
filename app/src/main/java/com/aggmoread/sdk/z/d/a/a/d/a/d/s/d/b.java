package com.aggmoread.sdk.z.d.a.a.d.a.d.s.d;

import android.content.Context;
import android.location.Location;
import androidx.annotation.Nullable;
import com.aggmoread.sdk.client.AMConst;
import com.aggmoread.sdk.z.d.a.a.c.j;
import com.aggmoread.sdk.z.d.a.a.d.b.g;
import com.aggmoread.sdk.z.d.a.a.e.c;
import com.aggmoread.sdk.z.d.a.a.e.e;
import com.bytedance.sdk.openadsdk.LocationProvider;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfig;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager;
import java.util.Map;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    private static volatile boolean f5585a = false;

    /* renamed from: b */
    private static volatile boolean f5586b = false;

    public static class a implements TTAdSdk.Callback {
        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void fail(int i10, String str) {
            e.a("media init fail , " + i10 + ", msg " + str);
            boolean unused = b.f5586b = false;
            boolean unused2 = b.f5585a = false;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void success() {
            e.a("media init success");
            boolean unused = b.f5586b = true;
        }
    }

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.b$b */
    public static class C0143b extends TTCustomController {

        /* renamed from: a */
        final /* synthetic */ j f5587a;

        /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.b$b$a */
        public class a implements LocationProvider {

            /* renamed from: a */
            final /* synthetic */ Location f5588a;

            public a(C0143b c0143b, Location location) {
                this.f5588a = location;
            }

            @Override // com.bytedance.sdk.openadsdk.LocationProvider
            public double getLatitude() {
                return this.f5588a.getLatitude();
            }

            @Override // com.bytedance.sdk.openadsdk.LocationProvider
            public double getLongitude() {
                return this.f5588a.getLongitude();
            }
        }

        public C0143b(j jVar) {
            this.f5587a = jVar;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean alist() {
            return super.alist();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        @Nullable
        public String getAndroidId() {
            return this.f5587a.h();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        @Nullable
        public String getDevImei() {
            return this.f5587a.j();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        @Nullable
        public String getDevOaid() {
            return this.f5587a.o();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        @Nullable
        public String getMacAddress() {
            return this.f5587a.n();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        @Nullable
        public LocationProvider getTTLocation() {
            Location m10 = this.f5587a.m();
            return m10 != null ? new a(this, m10) : super.getTTLocation();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseAndroidId() {
            return this.f5587a.e();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseLocation() {
            return this.f5587a.b();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUsePermissionRecordAudio() {
            return super.isCanUsePermissionRecordAudio();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUsePhoneState() {
            return this.f5587a.f();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseWifiState() {
            return this.f5587a.d();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseWriteExternal() {
            return this.f5587a.g();
        }
    }

    private static TTAdConfig a(Context context, String str, String str2) {
        TTAdConfig.Builder mediationConfig = new TTAdConfig.Builder().appId(str).appName(str2).useMediation(true).titleBarTheme(1).allowShowNotify(true).debug(com.aggmoread.sdk.z.d.a.a.d.b.j.f6028r.booleanValue()).supportMultiProcess(false).setMediationConfig(new MediationConfig.Builder().setPublisherDid(c.d()).build());
        TTCustomController a10 = a();
        if (a10 != null) {
            mediationConfig.customController(a10);
        }
        return mediationConfig.build();
    }

    public static String b() {
        try {
            return (String) com.aggmoread.sdk.z.d.a.a.e.j.a(TTAdSdk.class, "SDK_VERSION_NAME");
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean c(Context context, String str, String str2) {
        b(context, str, str2);
        return f5586b;
    }

    private static TTCustomController a() {
        j b10 = g.a().b();
        if (b10 != null) {
            return new C0143b(b10);
        }
        return null;
    }

    private static void b(Context context, String str, String str2) {
        if (f5585a) {
            return;
        }
        try {
            TTAdSdk.init(context, a(context, str, str2));
            TTAdSdk.start(new a());
            f5585a = true;
        } catch (Exception unused) {
            f5585a = false;
        }
    }

    public static Object a(Object obj, String str, Class<?>[] clsArr, Object... objArr) {
        try {
            return obj.getClass().getMethod(str, clsArr).invoke(obj, objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void a(Map<String, Object> map, Object obj) {
        String str;
        String str2;
        MediationAdEcpmInfo showEcpm;
        try {
            Object a10 = a(obj, "getMediationManager", null, new Object[0]);
            if (!(a10 instanceof MediationBaseManager) || (showEcpm = ((MediationBaseManager) a10).getShowEcpm()) == null) {
                str = "-1";
                str2 = "";
            } else {
                str = showEcpm.getEcpm();
                str2 = showEcpm.getSlotId();
            }
            e.a("rit = " + str2 + ", epm = " + str);
            map.put(AMConst.ExtrasKey.AD_PRICE, str);
            map.put("EXTRA_network_csj_placementId", str2);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
