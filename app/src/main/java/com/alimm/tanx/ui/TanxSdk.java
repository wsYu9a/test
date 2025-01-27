package com.alimm.tanx.ui;

import android.app.Application;
import android.util.Log;
import com.alimm.tanx.core.SdkConstant;
import com.alimm.tanx.core.TanxCoreInstanceConfig;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.TanxInitListener;
import com.alimm.tanx.core.config.TanxConfig;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.utils.StringUtil;
import com.alimm.tanx.ui.ad.ITanxSdkManager;
import java.util.concurrent.atomic.AtomicInteger;
import ok.a;

/* loaded from: classes.dex */
public class TanxSdk implements NotConfused {
    private static final String TAG = "TanxSdk";
    public static final int TANX_SDK_INIT_ERROR = -1;
    public static final int TANX_SDK_INIT_ING = 1;
    public static final int TANX_SDK_INIT_SUCC = 2;
    public static final int TANX_SDK_INIT_WAIT = 0;
    private static Application application;
    private static tanxu_if mInitializer;
    public static volatile AtomicInteger mIsInit = new AtomicInteger(0);

    public static Application getApplication() {
        return application;
    }

    public static TanxConfig getConfig() {
        if (TanxCoreSdk.checkSdkInit()) {
            return mInitializer.tanxu_do();
        }
        return null;
    }

    public static ITanxSdkManager getSDKManager() {
        if (TanxCoreSdk.checkSdkInit()) {
            return mInitializer.tanxu_if();
        }
        return null;
    }

    public static void init(Application application2, TanxConfig tanxConfig, TanxInitListener tanxInitListener) {
        StringBuilder a10 = a.a("--->init()-->mIsInit->");
        a10.append(mIsInit);
        a10.append(" version:");
        a10.append(SdkConstant.getSdkVersion());
        Log.d(TAG, a10.toString());
        init(application2, tanxConfig, new TanxThirdInstanceDefault().build(), tanxInitListener);
    }

    public static void init(Application application2, TanxConfig tanxConfig, TanxCoreInstanceConfig tanxCoreInstanceConfig, TanxInitListener tanxInitListener) {
        StringBuilder a10 = a.a("--->init()-->mIsInit->");
        a10.append(mIsInit);
        a10.append(" version:");
        a10.append(SdkConstant.getSdkVersion());
        Log.d(TAG, a10.toString());
        synchronized (TanxSdk.class) {
            try {
                if (mIsInit.get() != 0 && mIsInit.get() != -1) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("--->init()终止，已经在初始化，或者已经初始化完成。-->mIsInit->");
                    sb2.append(mIsInit);
                    sb2.append(" version:");
                    sb2.append(SdkConstant.getSdkVersion());
                    Log.d(TAG, sb2.toString());
                } else {
                    mIsInit.set(1);
                    application = application2;
                    if (tanxConfig != null) {
                        if (StringUtil.isNull(tanxConfig.getAppKey())) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("AppKey Is Null :");
                            sb3.append(mIsInit);
                            sb3.append(" version:");
                            sb3.append(SdkConstant.getSdkVersion());
                            Log.d(TAG, sb3.toString());
                            UtErrorCode utErrorCode = UtErrorCode.APP_KEY_NULL;
                            tanxInitListener.error(utErrorCode.getIntCode(), utErrorCode.getMsg());
                            return;
                        }
                        if (mInitializer == null) {
                            mInitializer = new tanxu_if();
                        }
                        TanxCoreSdk.init(application2, tanxConfig, tanxCoreInstanceConfig, new tanxu_do(application2, tanxConfig, tanxInitListener));
                    } else {
                        throw new RuntimeException("TanxConfig Not Null");
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
