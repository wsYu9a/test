package com.kwad.sdk.api;

import android.content.Context;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.loader.t;
import com.kwad.sdk.api.loader.u;
import com.kwad.sdk.api.proxy.app.AdSdkFileProvider;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.atomic.AtomicBoolean;

@KsAdSdkApi
@Keep
/* loaded from: classes.dex */
public class KsAdSDK {
    private static Context mOriginalAppContext;
    private static String sAppTag;
    public static final AtomicBoolean sHasInit = new AtomicBoolean(false);
    private static final AtomicBoolean sHasRest = new AtomicBoolean(false);

    @Keep
    private static IKsAdSDK sSdk;

    /* renamed from: com.kwad.sdk.api.KsAdSDK$1 */
    /* loaded from: classes2.dex */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ Context Zh;
        final /* synthetic */ SdkConfig Zi;

        AnonymousClass1(Context context, SdkConfig sdkConfig) {
            am = context;
            sdkConfig = sdkConfig;
        }

        @Override // java.lang.Runnable
        public final void run() {
            t.c(am, "sdkconfig", sdkConfig.toJson());
        }
    }

    @Keep
    @Retention(RetentionPolicy.SOURCE)
    public @interface KsThemeModeType {
        public static final int NIGHT = 1;
        public static final int NORMAL = 0;
    }

    @Keep
    @Retention(RetentionPolicy.SOURCE)
    public @interface SdkType {
        public static final int AD = 1;
        public static final int CAR = 5;
        public static final int CT = 2;
        public static final int CT_PURE = 4;
        public static final int EC = 3;
    }

    @KsAdSdkApi
    @Keep
    public static void deleteCache() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.deleteCache();
        }
    }

    @KsAdSdkApi
    @Keep
    public static String getAppId() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            return iKsAdSDK.getAppId();
        }
        return null;
    }

    @KsAdSdkApi
    @Keep
    public static String getAppName() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            return iKsAdSDK.getAppName();
        }
        return null;
    }

    @Nullable
    @KsAdSdkApi
    @Keep
    public static Context getContext() {
        return mOriginalAppContext;
    }

    @KsAdSdkApi
    @Keep
    public static String getDid() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            return iKsAdSDK.getDid();
        }
        return null;
    }

    @Nullable
    @KsAdSdkApi
    @Keep
    public static synchronized KsLoadManager getLoadManager() {
        synchronized (KsAdSDK.class) {
            if (sSdk != null && sHasInit.get()) {
                return sSdk.getAdManager();
            }
            Log.e("KsAdSDK", "please init sdk before getLoadManager");
            return new b();
        }
    }

    @KsAdSdkApi
    @Keep
    public static int getSDKType() {
        return 1;
    }

    @KsAdSdkApi
    @Keep
    public static String getSDKVersion() {
        return "3.3.40";
    }

    @KsAdSdkApi
    @Keep
    public static String getSDKVersion(int i2) {
        return i2 != 1 ? "" : "3.3.40";
    }

    @KsAdSdkApi
    @Keep
    public static synchronized boolean init(Context context, SdkConfig sdkConfig) {
        KsInitCallback ksInitCallback;
        synchronized (KsAdSDK.class) {
            if (context == null || sdkConfig == null) {
                if (sdkConfig != null && (ksInitCallback = sdkConfig.ksInitCallback) != null) {
                    ksInitCallback.onFail(0, "context or config is null");
                }
                return false;
            }
            mOriginalAppContext = context;
            try {
                Context am = com.kwad.sdk.api.loader.c.am(context);
                if (am == null) {
                    revertDynamic(new RuntimeException("wrappApp Exception"), context, sdkConfig);
                    return false;
                }
                try {
                    IKsAdSDK init = Loader.get().init(am, KsAdSDK.class.getClassLoader());
                    sSdk = init;
                    init.setApiVersion("3.3.40");
                    sSdk.setApiVersionCode(3034000);
                    sSdk.setLaunchTime(AdSdkFileProvider.sLaunchTime);
                    try {
                        Context wrapContextIfNeed = Wrapper.wrapContextIfNeed(am);
                        if (wrapContextIfNeed == null) {
                            revertDynamic(new RuntimeException("wrapContextIfNeed Exception"), am, sdkConfig);
                            return false;
                        }
                        sSdk.init(wrapContextIfNeed, sdkConfig);
                        sSdk.setAppTag(sAppTag);
                        u.a(am, sSdk);
                        sHasInit.set(true);
                        com.kwad.sdk.api.kwai.a.submit(new Runnable() { // from class: com.kwad.sdk.api.KsAdSDK.1
                            final /* synthetic */ Context Zh;
                            final /* synthetic */ SdkConfig Zi;

                            AnonymousClass1(Context am2, SdkConfig sdkConfig2) {
                                am = am2;
                                sdkConfig = sdkConfig2;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                t.c(am, "sdkconfig", sdkConfig.toJson());
                            }
                        });
                        return sHasInit.get();
                    } catch (Throwable th) {
                        revertDynamic(th, am2, sdkConfig2);
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    context = am2;
                    revertDynamic(th, context, sdkConfig2);
                    return false;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    @KsAdSdkApi
    @Keep
    public static boolean isDebugLogEnable() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            return iKsAdSDK.isDebugLogEnable();
        }
        return false;
    }

    @KsAdSdkApi
    @Keep
    public static void pauseCurrentPlayer() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.pauseCurrentPlayer();
        }
    }

    public static void re(Object obj) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.re(obj);
        }
    }

    @KsAdSdkApi
    @Keep
    public static void resumeCurrentPlayer() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.resumeCurrentPlayer();
        }
    }

    private static void revertDynamic(Throwable th, Context context, SdkConfig sdkConfig) {
        AtomicBoolean atomicBoolean = sHasRest;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        u.au(context);
        Loader.get().rest();
        Log.d("KSAdSDK", "init appId after reset:" + sdkConfig.appId);
        init(context, sdkConfig);
        if (sSdk == null || !sHasInit.get()) {
            return;
        }
        sSdk.re(th);
    }

    @KsAdSdkApi
    @Keep
    public static void setAdxEnable(boolean z) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setAdxEnable(z);
        }
    }

    @KsAdSdkApi
    @Keep
    public static void setAppTag(String str) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setAppTag(str);
        } else {
            sAppTag = str;
        }
    }

    public static void setLoadingLottieAnimation(boolean z, @RawRes int i2) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setLoadingLottieAnimation(z, i2);
        }
    }

    public static void setLoadingLottieAnimationColor(boolean z, @ColorInt int i2) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setLoadingLottieAnimationColor(z, i2);
        }
    }

    @KsAdSdkApi
    @Keep
    public static void setPersonalRecommend(boolean z) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setPersonalRecommend(z);
        }
    }

    @KsAdSdkApi
    @Keep
    public static void setProgrammaticRecommend(boolean z) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setProgrammaticRecommend(z);
        }
    }

    public static void setThemeMode(int i2) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setThemeMode(i2);
        }
    }

    @KsAdSdkApi
    @Keep
    public static void unInit() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.unInit();
        }
        sSdk = null;
    }
}
