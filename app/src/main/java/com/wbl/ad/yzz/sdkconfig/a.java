package com.wbl.ad.yzz.sdkconfig;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.wbl.ad.yzz.config.AdInitConfig;
import com.wbl.ad.yzz.config.AdInitialize;
import com.wbl.ad.yzz.network.f.f;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: com.wbl.ad.yzz.sdkconfig.a$a */
    public class C0776a implements TTAdSdk.InitCallback {
        public C0776a(a aVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void fail(int i2, String str) {
            f.c("TTAdManagerHolder", "初始化失败 code = " + i2 + " errmsg = " + str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void success() {
        }
    }

    public static class b {

        /* renamed from: a */
        public static final a f33775a = new a(null);
    }

    public /* synthetic */ a(C0776a c0776a) {
        this();
    }

    public static a b() {
        return b.f33775a;
    }

    public TTAdManager a() {
        if (TTAdSdk.isInitSuccess()) {
            return TTAdSdk.getAdManager();
        }
        f.c("TTAdManagerHolder", "get() 没有初始化");
        return null;
    }

    public void c(Context context, String str, AdInitConfig adInitConfig) {
        b(context, str, adInitConfig);
    }

    public a() {
    }

    public final void b(Context context, String str, AdInitConfig adInitConfig) {
        try {
            if (TTAdSdk.isInitSuccess()) {
                return;
            }
            TTAdSdk.init(context, a(context, str, adInitConfig), new C0776a(this));
        } catch (Exception e2) {
            f.b("TTAdManagerHolder", e2.getMessage() + "");
        }
    }

    public final TTAdConfig a(Context context, String str, AdInitConfig adInitConfig) {
        TTAdConfig.Builder supportMultiProcess = new TTAdConfig.Builder().appId(str).useTextureView(true).appName(com.wbl.ad.yzz.util.d0.a.a(context)).titleBarTheme(1).allowShowNotify(true).allowShowPageWhenScreenLock(true).debug(false).directDownloadNetworkType(new int[0]).supportMultiProcess(false);
        if (adInitConfig != null) {
            if (AdInitialize.getInstance().isEnableLog()) {
                AdInitialize.getInstance().debugLog("ttInit config: " + adInitConfig);
            }
            if (adInitConfig.getTtCustomController() != null) {
                supportMultiProcess.customController(adInitConfig.getTtCustomController());
            }
        }
        return supportMultiProcess.build();
    }
}
