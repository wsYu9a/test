package com.vivo.mobilead.util;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.TTLocation;
import com.vivo.ic.dm.Downloads;
import com.vivo.mobilead.model.VLocation;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class s0 {

    /* renamed from: a */
    private static volatile boolean f30774a;

    static class a extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ Context f30775a;

        /* renamed from: b */
        final /* synthetic */ String f30776b;

        /* renamed from: com.vivo.mobilead.util.s0$a$a */
        class C0670a implements TTAdSdk.InitCallback {
            C0670a(a aVar) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
            public void fail(int i2, String str) {
                boolean unused = s0.f30774a = false;
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
            public void success() {
                boolean unused = s0.f30774a = true;
            }
        }

        a(Context context, String str) {
            this.f30775a = context;
            this.f30776b = str;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            try {
                Context context = this.f30775a;
                TTAdSdk.init(context, s0.b(context, this.f30776b), new C0670a(this));
            } catch (Exception unused) {
                boolean unused2 = s0.f30774a = false;
            }
        }
    }

    static class b extends TTCustomController {
        b() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean alist() {
            return h0.K().D();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public String getDevImei() {
            return h0.K().g();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public String getDevOaid() {
            return h0.K().h();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseLocation() {
            return h0.K().E();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUsePhoneState() {
            return h0.K().F();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseWifiState() {
            return h0.K().G();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseWriteExternal() {
            return h0.K().H();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public TTLocation getTTLocation() {
            VLocation i2 = h0.K().i();
            return i2 != null ? new TTLocation(i2.getLat(), i2.getLng()) : new TTLocation(0.0d, 0.0d);
        }
    }

    public static boolean b() {
        return f30774a;
    }

    private static void c(Context context, String str) {
        if (f30774a) {
            return;
        }
        a1.d(new a(context, str));
    }

    public static void d(Context context, String str) {
        c(context, str);
    }

    public static TTAdConfig b(Context context, String str) {
        return new TTAdConfig.Builder().appId(str).useTextureView(true).appName("APP媒体").titleBarTheme(1).allowShowNotify(true).allowShowPageWhenScreenLock(false).debug(false).directDownloadNetworkType(4).asyncInit(true).supportMultiProcess(false).data(a(String.valueOf(h0.K().f()))).customController(new b()).build();
    }

    public static TTAdManager a() {
        if (f30774a) {
            return TTAdSdk.getAdManager();
        }
        throw new RuntimeException("TTAdSdk is not init, please check.");
    }

    private static String a(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", "personal_ads_type");
            jSONObject.put(Downloads.RequestHeaders.COLUMN_VALUE, str);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            return jSONArray.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
