package com.alimm.tanx.core;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.alimm.tanx.core.ad.ITanxCoreManager;
import com.alimm.tanx.core.config.TanxConfig;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.view.player.cache.ProxyCacheManager;
import com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer;

/* loaded from: classes.dex */
public class TanxCoreSdk implements NotConfused {
    private static Application application = null;
    private static boolean mDebugMode = false;
    private static tanxc_do mInitializer = null;
    private static volatile boolean mIsInit = false;
    private static HttpProxyCacheServer proxyCacheServer;

    public static boolean checkSdkInit() {
        if (mInitializer != null) {
            return true;
        }
        if (mDebugMode) {
            throw new RuntimeException("TanxSdk Not initialized");
        }
        Log.e("checkSdkInit", "TanxSdk Not initialized SdkDebug : false");
        return false;
    }

    public static Application getApplication() {
        return application;
    }

    public static TanxConfig getConfig() {
        if (checkSdkInit()) {
            return mInitializer.tanxc_do();
        }
        return null;
    }

    public static HttpProxyCacheServer getProxy(Context context) {
        if (proxyCacheServer == null) {
            proxyCacheServer = ProxyCacheManager.getProxy(context);
        }
        return proxyCacheServer;
    }

    public static ITanxCoreManager getSDKManager() {
        if (checkSdkInit()) {
            return mInitializer.tanxc_if();
        }
        return null;
    }

    public static void init(Application application2, TanxConfig tanxConfig, TanxCoreInstanceConfig tanxCoreInstanceConfig, TanxInitListener tanxInitListener) {
        Log.d("TanxSdkBuildTime", "2024-09-23 16:23:21");
        if (mIsInit) {
            return;
        }
        if (tanxConfig != null) {
            mDebugMode = tanxConfig.isDebugMode();
        }
        application = application2;
        if (mInitializer == null) {
            mInitializer = new tanxc_do();
        }
        mInitializer.tanxc_do(application2, tanxConfig, tanxCoreInstanceConfig, tanxInitListener);
        mIsInit = true;
    }

    public static boolean ismDebugMode() {
        return mDebugMode;
    }

    public static boolean logCheckSdkInit() {
        return mIsInit;
    }

    public static void init(Application application2, TanxConfig tanxConfig, TanxInitListener tanxInitListener) {
        Log.d("TanxSdkBuildTime", "2024-09-23 16:23:21");
        init(application2, tanxConfig, new TanxCoreInstanceConfig(), tanxInitListener);
    }
}
