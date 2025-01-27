package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.api.a;
import com.bytedance.sdk.openadsdk.api.c;
import com.bytedance.sdk.openadsdk.api.plugin.f;
import java.util.Map;

/* loaded from: classes2.dex */
public final class TTAdSdk {
    public static final String BRANCH = "v6400";
    public static final String BUILT_IN_PLUGIN_NAME = "com.byted.pangle";
    public static final String C_H = "b769000";
    public static final int EXT_API_VERSION_CODE = 999;
    public static final boolean INCLUDE_LIVE = true;
    public static final String INITIALIZER_CLASS_NAME = "com.bytedance.sdk.openadsdk.core.AdSdkInitializerHolder";
    public static final boolean IS_BOOST = false;
    public static final boolean IS_P = true;
    public static final String LIVE_PLUGIN_PACKAGE_NAME = "com.byted.live.lite";
    public static final boolean ONLY_API = false;
    public static final int SDK_VERSION_CODE = 6411;
    public static final String SDK_VERSION_NAME = "6.4.1.1";
    public static final String S_C = "main";

    /* renamed from: a */
    private static final a f7957a = new f();

    /* renamed from: b */
    private static volatile TTAdConfig f7958b;

    public interface Callback extends InitCallback {
    }

    @Deprecated
    public interface InitCallback {
        void fail(int i10, String str);

        void success();
    }

    private static void a(Context context, TTAdConfig tTAdConfig) {
        if (tTAdConfig != null && tTAdConfig.isDebug()) {
            c.a();
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            c.a("Wrong Thread ! Please exec TTAdSdk.init in main thread.");
        }
        a(context, "Context is null, please check.");
        a(tTAdConfig, "TTAdConfig is null, please check.");
        TTAppContextHolder.setContext(context);
        updateConfigAuth(tTAdConfig);
    }

    public static TTAdManager getAdManager() {
        a aVar = f7957a;
        if (aVar != null) {
            return aVar.b();
        }
        return null;
    }

    public static boolean init(Context context, TTAdConfig tTAdConfig) {
        f7958b = tTAdConfig;
        a(context, f7958b);
        return true;
    }

    @Deprecated
    public static boolean isInitSuccess() {
        a aVar = f7957a;
        if (aVar != null) {
            return aVar.a();
        }
        return false;
    }

    public static boolean isOnePointFiveAdType(TTNativeExpressAd tTNativeExpressAd) {
        Map<String, Object> mediaExtraInfo;
        if (tTNativeExpressAd == null) {
            mediaExtraInfo = null;
        } else {
            try {
                mediaExtraInfo = tTNativeExpressAd.getMediaExtraInfo();
            } catch (Throwable th2) {
                th2.printStackTrace();
                return false;
            }
        }
        if (mediaExtraInfo == null || !mediaExtraInfo.containsKey("_tt_ad_type_onepointfive")) {
            return false;
        }
        return ((Boolean) mediaExtraInfo.get("_tt_ad_type_onepointfive")).booleanValue();
    }

    public static boolean isSdkReady() {
        a aVar = f7957a;
        if (aVar != null) {
            return aVar.a();
        }
        return false;
    }

    public static void start(Callback callback) {
        a(f7958b, "TTAdConfig is null, please exec TTAdSdk.init before TTAdSdk.start.");
        a aVar = f7957a;
        if (aVar == null) {
            callback.fail(4100, "Load initializer failed");
        } else {
            aVar.a(TTAppContextHolder.getContext(), f7958b, callback);
        }
    }

    public static void updateAdConfig(TTAdConfig tTAdConfig) {
        a.c b10;
        if (tTAdConfig == null || (b10 = f7957a.b()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(tTAdConfig.getData())) {
            bundle.putString("extra_data", tTAdConfig.getData());
        }
        if (!TextUtils.isEmpty(tTAdConfig.getKeywords())) {
            bundle.putString("keywords", tTAdConfig.getKeywords());
        }
        if (bundle.keySet().isEmpty()) {
            return;
        }
        b10.getExtra(ValueSet.class, bundle);
    }

    public static void updateConfigAuth(TTAdConfig tTAdConfig) {
        Object obj;
        if (tTAdConfig == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.live.c.a().a(tTAdConfig.getInjectionAuth());
        Map<String, Object> initExtra = tTAdConfig.getInitExtra();
        if (initExtra == null || (obj = initExtra.get(TTAdConstant.KEY_INIT_FOR_LIVE)) == null || !(obj instanceof Map)) {
            return;
        }
        com.bytedance.sdk.openadsdk.live.c.a().a((Map<String, String>) obj);
    }

    public static void updatePaid(boolean z10) {
        a.c b10 = f7957a.b();
        if (b10 == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_paid", z10);
        if (bundle.keySet().isEmpty()) {
            return;
        }
        b10.getExtra(ValueSet.class, bundle);
    }

    private static void a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }
}
