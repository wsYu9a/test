package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTCodeGroupRit;
import com.bytedance.sdk.openadsdk.api.j;
import com.bytedance.sdk.openadsdk.api.plugin.lg;
import com.bytedance.sdk.openadsdk.live.zx;
import java.util.Map;

/* loaded from: classes.dex */
public final class TTAdSdk {
    public static final String INITIALIZER_CLASS_NAME = "com.bytedance.sdk.openadsdk.core.AdSdkInitializerHolder";

    /* renamed from: j */
    private static final TTInitializer f6363j = new lg();

    /* renamed from: com.bytedance.sdk.openadsdk.TTAdSdk$1 */
    static class AnonymousClass1 implements CodeGroupRitObject {

        /* renamed from: j */
        final /* synthetic */ long f6364j;
        final /* synthetic */ TTCodeGroupRit.TTCodeGroupRitListener zx;

        AnonymousClass1(long j2, TTCodeGroupRit.TTCodeGroupRitListener tTCodeGroupRitListener) {
            j2 = j2;
            tTCodeGroupRitListener = tTCodeGroupRitListener;
        }

        @Override // com.bytedance.sdk.openadsdk.CodeGroupRitObject
        public long getCodeGroupId() {
            return j2;
        }

        @Override // com.bytedance.sdk.openadsdk.CodeGroupRitObject
        public TTCodeGroupRit.TTCodeGroupRitListener getListener() {
            return tTCodeGroupRitListener;
        }
    }

    public interface InitCallback {
        void fail(int i2, String str);

        void success();
    }

    public static TTAdManager getAdManager() {
        TTInitializer tTInitializer = f6363j;
        if (tTInitializer != null) {
            return tTInitializer.getAdManager();
        }
        return null;
    }

    public static void getCodeGroupRit(long j2, TTCodeGroupRit.TTCodeGroupRitListener tTCodeGroupRitListener) {
        TTInitializer tTInitializer = f6363j;
        if (tTInitializer != null) {
            tTInitializer.getAdManager().register(new CodeGroupRitObject() { // from class: com.bytedance.sdk.openadsdk.TTAdSdk.1

                /* renamed from: j */
                final /* synthetic */ long f6364j;
                final /* synthetic */ TTCodeGroupRit.TTCodeGroupRitListener zx;

                AnonymousClass1(long j22, TTCodeGroupRit.TTCodeGroupRitListener tTCodeGroupRitListener2) {
                    j2 = j22;
                    tTCodeGroupRitListener = tTCodeGroupRitListener2;
                }

                @Override // com.bytedance.sdk.openadsdk.CodeGroupRitObject
                public long getCodeGroupId() {
                    return j2;
                }

                @Override // com.bytedance.sdk.openadsdk.CodeGroupRitObject
                public TTCodeGroupRit.TTCodeGroupRitListener getListener() {
                    return tTCodeGroupRitListener;
                }
            });
        } else if (tTCodeGroupRitListener2 != null) {
            tTCodeGroupRitListener2.onFail(4100, "please init sdk first!");
        }
    }

    public static void init(Context context, TTAdConfig tTAdConfig, InitCallback initCallback) {
        j(context, tTAdConfig);
        Context applicationContext = context.getApplicationContext();
        TTInitializer tTInitializer = f6363j;
        if (tTInitializer == null) {
            initCallback.fail(4100, "Load initializer failed");
        } else {
            tTInitializer.init(applicationContext, tTAdConfig, initCallback);
        }
    }

    public static boolean isInitSuccess() {
        TTInitializer tTInitializer = f6363j;
        if (tTInitializer != null) {
            return tTInitializer.isInitSuccess();
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
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        if (mediaExtraInfo == null || !mediaExtraInfo.containsKey("_tt_ad_type_onepointfive")) {
            return false;
        }
        return ((Boolean) mediaExtraInfo.get("_tt_ad_type_onepointfive")).booleanValue();
    }

    private static void j(Context context, TTAdConfig tTAdConfig) {
        if (tTAdConfig != null && tTAdConfig.isDebug()) {
            j.j();
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            j.j("Wrong Thread ! Please exec TTAdSdk.init in main thread.");
        }
        j(context, "Context is null, please check.");
        j(tTAdConfig, "TTAdConfig is null, please check.");
        TTAppContextHolder.setContext(context);
        updateConfigAuth(tTAdConfig);
        tTAdConfig.setExtra(TTAdConstant.PANGLE_INIT_START_TIME, Long.valueOf(SystemClock.elapsedRealtime()));
        tTAdConfig.setExtra(TTAdConstant.KEY_S_C, "main");
        tTAdConfig.setExtra(TTAdConstant.KEY_L_S, Boolean.TRUE);
        tTAdConfig.setExtra(TTAdConstant.KEY_EXT_API_CODE, 999);
    }

    public static void updateAdConfig(TTAdConfig tTAdConfig) {
        TTAdManager adManager;
        if (tTAdConfig == null || (adManager = f6363j.getAdManager()) == null) {
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
        adManager.getExtra(AdConfig.class, bundle);
    }

    public static void updateConfigAuth(TTAdConfig tTAdConfig) {
        zx j2;
        if (tTAdConfig == null || (j2 = zx.j()) == null) {
            return;
        }
        j2.j(tTAdConfig.getInjectionAuth());
    }

    public static void updatePaid(boolean z) {
        TTAdManager adManager = f6363j.getAdManager();
        if (adManager == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_paid", z);
        if (bundle.keySet().isEmpty()) {
            return;
        }
        adManager.getExtra(AdConfig.class, bundle);
    }

    private static void j(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }
}
