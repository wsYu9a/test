package com.kwad.sdk.api;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.loader.e;
import com.kwad.sdk.api.loader.v;
import com.kwad.sdk.api.proxy.app.AdSdkFileProvider;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.atomic.AtomicBoolean;

@KsAdSdkApi
@Keep
/* loaded from: classes3.dex */
public class KsAdSDK {
    private static Context mOriginalAppContext;
    private static String sAppTag;
    public static final AtomicBoolean sHasInit = new AtomicBoolean(false);
    private static final AtomicBoolean sHasRest = new AtomicBoolean(false);

    @Keep
    private static IKsAdSDK sSdk;

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
        return BuildConfig.VERSION_NAME;
    }

    public static boolean haseInit() {
        return sHasInit.get();
    }

    @KsAdSdkApi
    @Keep
    public static synchronized boolean init(Context context, SdkConfig sdkConfig) {
        long elapsedRealtime;
        Context context2;
        Throwable th2;
        synchronized (KsAdSDK.class) {
            try {
                elapsedRealtime = SystemClock.elapsedRealtime();
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
            if (context == null || sdkConfig == null) {
                throw new RuntimeException("init context or config is null");
            }
            mOriginalAppContext = context;
            try {
                context2 = e.aO(context);
                if (context2 == null) {
                    throw new RuntimeException("init wrapperApp Exception");
                }
                try {
                    IKsAdSDK init = Loader.get().init(context2, KsAdSDK.class.getClassLoader());
                    sSdk = init;
                    init.setApiVersion(BuildConfig.VERSION_NAME);
                    sSdk.setApiVersionCode(BuildConfig.VERSION_CODE);
                    sSdk.setLaunchTime(AdSdkFileProvider.sLaunchTime);
                    Context wrapContextIfNeed = Wrapper.wrapContextIfNeed(context2);
                    if (wrapContextIfNeed == null) {
                        throw new RuntimeException("init wrapContextIfNeed Exception");
                    }
                    try {
                        sSdk.setInitStartTime(elapsedRealtime);
                    } catch (Throwable th4) {
                        c.m(th4);
                    }
                    sSdk.init(wrapContextIfNeed, sdkConfig);
                    sSdk.setAppTag(sAppTag);
                    v.a(context2, sSdk);
                    com.kwad.sdk.api.loader.b.a(context2, sdkConfig);
                    c.nF();
                    sHasInit.set(sSdk != null);
                    return sHasInit.get();
                } catch (Throwable th5) {
                    th2 = th5;
                    revertDynamic(th2, context2, sdkConfig);
                    return false;
                }
            } catch (Throwable th6) {
                context2 = context;
                th2 = th6;
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

    @KsAdSdkApi
    @Keep
    public static void resumeCurrentPlayer() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.resumeCurrentPlayer();
        }
    }

    private static void revertDynamic(Throwable th2, Context context, SdkConfig sdkConfig) {
        AtomicBoolean atomicBoolean = sHasRest;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        v.aW(context);
        Loader.get().rest();
        Log.d("KSAdSDK", "init appId after reset:" + sdkConfig.appId);
        init(context, sdkConfig);
        c.m(th2);
    }

    @KsAdSdkApi
    @Keep
    public static void setAdxEnable(boolean z10) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setAdxEnable(z10);
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

    public static void setLoadingLottieAnimation(boolean z10, @RawRes int i10) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setLoadingLottieAnimation(z10, i10);
        }
    }

    public static void setLoadingLottieAnimationColor(boolean z10, @ColorInt int i10) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setLoadingLottieAnimationColor(z10, i10);
        }
    }

    @KsAdSdkApi
    @Keep
    public static void setPersonalRecommend(boolean z10) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setPersonalRecommend(z10);
        }
    }

    @KsAdSdkApi
    @Keep
    public static void setProgrammaticRecommend(boolean z10) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setProgrammaticRecommend(z10);
        }
    }

    public static void setThemeMode(int i10) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setThemeMode(i10);
        }
    }

    @KsAdSdkApi
    @Keep
    public static synchronized void start() {
        synchronized (KsAdSDK.class) {
            try {
                sSdk.start();
            } catch (Throwable th2) {
                c.m(th2);
            }
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

    @KsAdSdkApi
    @Keep
    public static String getSDKVersion(int i10) {
        return i10 != 1 ? "" : BuildConfig.VERSION_NAME;
    }
}
