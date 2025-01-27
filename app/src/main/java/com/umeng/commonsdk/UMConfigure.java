package com.umeng.commonsdk;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.sigmob.sdk.base.mta.PointCategory;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bf;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.n;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.ccg.ActionInfo;
import com.umeng.ccg.CcgAgent;
import com.umeng.ccg.b;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMLogCommon;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.listener.OnGetOaidListener;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.TagHelper;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.a;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.c;
import com.umeng.commonsdk.utils.d;
import hf.e;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class UMConfigure {
    public static final int DEVICE_TYPE_BOX = 2;
    public static final int DEVICE_TYPE_PHONE = 1;
    private static final String KEY_FILE_NAME_APPKEY = "APPKEY";
    private static final String KEY_FILE_NAME_LOG = "LOG";
    private static final String KEY_METHOD_NAME_PUSH_SETCHANNEL = "setMessageChannel";
    private static final String KEY_METHOD_NAME_PUSH_SET_SECRET = "setSecret";
    private static final String KEY_METHOD_NAME_SETAPPKEY = "setAppkey";
    private static final String KEY_METHOD_NAME_SETCHANNEL = "setChannel";
    private static final String KEY_METHOD_NAME_SETDEBUGMODE = "setDebugMode";
    private static final String TAG = "UMConfigure";
    private static final String WRAPER_TYPE_COCOS2DX_X = "Cocos2d-x";
    private static final String WRAPER_TYPE_COCOS2DX_XLUA = "Cocos2d-x_lua";
    private static final String WRAPER_TYPE_FLUTTER = "flutter";
    private static final String WRAPER_TYPE_HYBRID = "hybrid";
    private static final String WRAPER_TYPE_NATIVE = "native";
    private static final String WRAPER_TYPE_PHONEGAP = "phonegap";
    private static final String WRAPER_TYPE_REACTNATIVE = "react-native";
    private static final String WRAPER_TYPE_UNITY = "Unity";
    private static final String WRAPER_TYPE_WEEX = "weex";
    private static boolean debugLog = false;
    private static OnGetOaidListener mOnGetOaidListener;
    public static UMLog umDebugLog = new UMLog();
    private static boolean preInitComplete = false;
    private static Object PreInitLock = new Object();
    public static String sAppkey = "";
    public static String sChannel = "";
    public static boolean isInit = false;
    private static Object lock = new Object();
    private static int preInitInvokedFlag = 0;
    private static int policyGrantInvokedFlag = 0;
    private static int policyGrantResult = 0;
    private static boolean shouldCheckShareSdk = true;
    private static volatile boolean shouldCollectAid = true;
    private static volatile boolean shouldCollectOaid = true;
    private static volatile boolean shouldCollectImei = true;
    private static volatile boolean shouldCollectImsi = true;
    private static volatile boolean shouldCollectIccid = true;
    private static volatile boolean shouldCollectWiFiMac = true;
    private static volatile boolean shouldCollectApl = true;
    private static volatile boolean shouldOutputRT = false;
    public static MobclickAgent.PageMode AUTO_ACTIVITY_PAGE_COLLECTION = MobclickAgent.PageMode.AUTO;
    private static volatile long initCompleteTs = 0;
    private static final String[] BUSINESS_TYPE = {"apm", "push", "share", "ulink", "uverify", "usms", "urec", "abtest", "game", bt.al};
    private static boolean isFinish = false;
    private static Object lockObject = new Object();

    /* renamed from: com.umeng.commonsdk.UMConfigure$1 */
    public static class AnonymousClass1 extends Thread {

        /* renamed from: a */
        final /* synthetic */ Context f24317a;

        public AnonymousClass1(Context context) {
            applicationContext = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                Looper.prepare();
                Toast.makeText(applicationContext, "SDK 初始化失败，请检查是否集成umeng-asms-1.2.X.aar库。", 1).show();
                Looper.loop();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.umeng.commonsdk.UMConfigure$2 */
    public static class AnonymousClass2 extends Thread {

        /* renamed from: a */
        final /* synthetic */ Context f24318a;

        public AnonymousClass2(Context context) {
            applicationContext = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                Looper.prepare();
                Toast.makeText(applicationContext, UMLogCommon.SC_10015, 1).show();
                Looper.loop();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.umeng.commonsdk.UMConfigure$3 */
    public static class AnonymousClass3 extends Thread {

        /* renamed from: a */
        final /* synthetic */ Context f24319a;

        public AnonymousClass3(Context context) {
            applicationContext = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                Looper.prepare();
                Toast.makeText(applicationContext, UMLogCommon.SC_10015, 1).show();
                Looper.loop();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.umeng.commonsdk.UMConfigure$4 */
    public static class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f24320a;

        public AnonymousClass4(Context context) {
            applicationContext = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            String b10 = bf.b(applicationContext);
            if (UMConfigure.mOnGetOaidListener != null) {
                UMConfigure.mOnGetOaidListener.onGetOaid(b10);
            }
        }
    }

    public enum BS_TYPE {
        APM,
        PUSH,
        SHARE,
        ULINK,
        UVERIFY,
        USMS,
        UREC,
        ABTEST,
        GAME,
        ZID
    }

    private static boolean checkShareSdk(Class<?> cls) {
        try {
            return cls.getDeclaredField("isZyb") != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static void deleteModuleTag(BS_TYPE bs_type, String str) {
        if (bs_type == null) {
            Log.e("UMLog", UMLogCommon.SC_10025);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.e("UMLog", UMLogCommon.SC_10020);
            return;
        }
        try {
            if (str.trim().getBytes().length > 64) {
                Log.e("UMLog", UMLogCommon.SC_10021);
                return;
            }
            int ordinal = bs_type.ordinal();
            String[] strArr = BUSINESS_TYPE;
            String str2 = ordinal < strArr.length ? strArr[ordinal] : "";
            if (TextUtils.isEmpty(str2)) {
                Log.e("UMLog", UMLogCommon.SC_10022);
                return;
            }
            TagHelper.deleteModuleTag(str2 + e.f26694a + str);
        } catch (Throwable unused) {
        }
    }

    private static void disableAidCollect() {
        try {
            Class<?> cls = getClass("com.umeng.socialize.UMShareAPI");
            Class<?> cls2 = getClass("com.uyumao.nns.zmd.ZmdManager");
            if (cls == null && cls2 == null) {
                return;
            }
            shouldCollectAid = false;
        } catch (Throwable unused) {
        }
    }

    private static void disableOaidCollect() {
        try {
            if (getClass("com.uyumao.nns.zmd.ZmdManager") != null) {
                shouldCollectOaid = false;
            }
        } catch (Throwable unused) {
        }
    }

    public static void enableAplCollection(boolean z10) {
        shouldCollectApl = z10;
    }

    public static void enableAzxSwitch(boolean z10) {
        b.a(z10);
    }

    public static void enableIccidCollection(boolean z10) {
        shouldCollectIccid = z10;
    }

    public static void enableImeiCollection(boolean z10) {
        shouldCollectImei = z10;
    }

    public static void enableImsiCollection(boolean z10) {
        shouldCollectImsi = z10;
    }

    public static void enableUmcCfgSwitch(boolean z10) {
        b.b(z10);
    }

    public static void enableWiFiMacCollection(boolean z10) {
        shouldCollectWiFiMac = z10;
    }

    private static Class<?> getClass(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private static String getCurrentActivityName() {
        return PageNameMonitor.getInstance().getCurrentActivityName();
    }

    private static Object getDecInstanceObject(Class<?> cls) {
        Constructor<?> constructor;
        if (cls == null) {
            return null;
        }
        try {
            constructor = cls.getDeclaredConstructor(null);
        } catch (NoSuchMethodException unused) {
            constructor = null;
        }
        if (constructor == null) {
            return null;
        }
        constructor.setAccessible(true);
        try {
            return constructor.newInstance(null);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException unused2) {
            return null;
        }
    }

    private static Method getDecMethod(Class<?> cls, String str, Class<?>[] clsArr) {
        Method method = null;
        if (cls != null) {
            try {
                method = cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
            }
            if (method != null) {
                method.setAccessible(true);
            }
        }
        return method;
    }

    public static long getInitCompleteTs() {
        return initCompleteTs;
    }

    public static boolean getInitStatus() {
        boolean z10;
        synchronized (lockObject) {
            z10 = isFinish;
        }
        return z10;
    }

    private static Map<String, String> getModuleTags() {
        try {
            return TagHelper.getModuleTags();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void getOaid(Context context, OnGetOaidListener onGetOaidListener) {
        if (context == null) {
            if (debugLog) {
                Log.e(TAG, "context is null !!!");
                return;
            }
            return;
        }
        Context applicationContext = context.getApplicationContext();
        mOnGetOaidListener = onGetOaidListener;
        if (shouldCollectOaid) {
            new Thread(new Runnable() { // from class: com.umeng.commonsdk.UMConfigure.4

                /* renamed from: a */
                final /* synthetic */ Context f24320a;

                public AnonymousClass4(Context applicationContext2) {
                    applicationContext = applicationContext2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    String b10 = bf.b(applicationContext);
                    if (UMConfigure.mOnGetOaidListener != null) {
                        UMConfigure.mOnGetOaidListener.onGetOaid(b10);
                    }
                }
            }).start();
            return;
        }
        OnGetOaidListener onGetOaidListener2 = mOnGetOaidListener;
        if (onGetOaidListener2 != null) {
            onGetOaidListener2.onGetOaid(null);
        }
    }

    public static String[] getTestDeviceInfo(Context context) {
        String[] strArr = new String[2];
        if (context != null) {
            try {
                strArr[0] = DeviceConfig.getDeviceIdForGeneral(context);
                strArr[1] = DeviceConfig.getMac(context);
            } catch (Exception unused) {
            }
        }
        return strArr;
    }

    public static String getUMIDString(Context context) {
        if (context != null) {
            return UMUtils.getUMId(context.getApplicationContext());
        }
        return null;
    }

    public static String getUmengZID(Context context) {
        if (context != null) {
            return UMUtils.getZid(context.getApplicationContext());
        }
        return null;
    }

    private static void ignoreSdkCheck(Context context) {
        shouldCheckShareSdk = false;
    }

    public static void init(Context context, int i10, String str) {
        init(context, null, null, i10, str);
    }

    private static void invoke(Method method, Object obj, Object[] objArr) {
        if (method == null || obj == null) {
            return;
        }
        try {
            method.invoke(obj, objArr);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
        }
    }

    public static boolean isDebugLog() {
        return debugLog;
    }

    private static Boolean isInForeground() {
        return Boolean.valueOf(com.umeng.analytics.vshelper.b.d());
    }

    private static boolean isPreInit() {
        boolean z10;
        synchronized (PreInitLock) {
            z10 = preInitComplete;
        }
        return z10;
    }

    private static boolean isSilentMode() {
        boolean a10 = c.a();
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> isSilentMode() return: " + a10);
        return a10;
    }

    private static boolean needCheckPolicyResult(Context context) {
        File filesDir = context.getFilesDir();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(filesDir.getAbsolutePath());
        sb2.append(File.separator);
        sb2.append(bx.f23695m);
        return !new File(sb2.toString()).exists();
    }

    public static boolean needSendZcfgEnv(Context context) {
        File filesDir = context.getFilesDir();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(filesDir.getAbsolutePath());
        sb2.append(File.separator);
        sb2.append(bx.f23694l);
        return !new File(sb2.toString()).exists();
    }

    public static void onActEvent(String str, String str2, Bundle bundle) {
        CcgAgent.onActUpEvent(str, str2, bundle);
    }

    public static void preInit(Context context, String str, String str2) {
        synchronized (lock) {
            preInitInvokedFlag = 1;
        }
        preInitInternal(context, str, str2);
    }

    private static void preInitInternal(Context context, String str, String str2) {
        if (context == null) {
            if (debugLog) {
                Log.e(TAG, "preInit: context is null, pls check!");
                return;
            }
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if ("1".equals(UMUtils.getSystemProperty("debug.umeng.rtlog", "0"))) {
            shouldOutputRT = true;
        }
        if (TextUtils.isEmpty(str)) {
            str = UMUtils.getAppkeyByXML(applicationContext);
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = UMUtils.getChannelByXML(applicationContext);
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "Unknown";
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        sAppkey = str;
        sChannel = str2;
        UMGlobalContext.getInstance(applicationContext);
        n.a(applicationContext);
        if (!needSendZcfgEnv(applicationContext)) {
            FieldManager.a().a(applicationContext);
        }
        synchronized (PreInitLock) {
            preInitComplete = true;
        }
        boolean a10 = c.a();
        if (debugLog && a10) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 当前处于静默模式!");
        }
    }

    public static void registerActionInfo(ActionInfo actionInfo) {
        CcgAgent.registerActionInfo(actionInfo);
    }

    public static void resetStorePath() {
        resetStorePrefix("um_");
    }

    public static void resetStorePrefix(String str) {
        bd.b().a(str);
    }

    private static void setCheckDevice(boolean z10) {
        AnalyticsConstants.CHECK_DEVICE = z10;
    }

    public static void setDomain(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e("UMLog", "setDomain: Parameter domain is null or empty string, do nothing.");
        } else {
            UMServerURL.DEFAULT_URL = str;
            UMServerURL.SECONDARY_URL = str;
        }
    }

    public static void setEncryptEnabled(boolean z10) {
        com.umeng.commonsdk.statistics.b.a(z10);
    }

    private static void setFile(Class<?> cls, String str, String str2) {
        if (cls != null) {
            try {
                cls.getField(str).set(str, str2);
            } catch (Exception unused) {
            }
        }
    }

    private static void setLatencyWindow(long j10) {
        a.f24590c = ((int) j10) * 1000;
    }

    public static void setLogEnabled(boolean z10) {
        try {
            debugLog = z10;
            MLog.DEBUG = z10;
            Class<?> cls = getClass("com.umeng.message.PushAgent");
            Object decInstanceObject = getDecInstanceObject(cls);
            Class cls2 = Boolean.TYPE;
            invoke(getDecMethod(cls, KEY_METHOD_NAME_SETDEBUGMODE, new Class[]{cls2}), decInstanceObject, new Object[]{Boolean.valueOf(z10)});
            setFile(getClass("com.umeng.socialize.Config"), "DEBUG", z10);
            invoke(getDecMethod(getClass("com.umeng.umcrash.UMCrash"), "setDebug", new Class[]{cls2}), new Object[]{Boolean.valueOf(z10)});
        } catch (Exception e10) {
            if (debugLog) {
                Log.e(TAG, "set log enabled e is " + e10);
            }
        } catch (Throwable th2) {
            if (debugLog) {
                Log.e(TAG, "set log enabled e is " + th2);
            }
        }
    }

    private static void setModuleTag(BS_TYPE bs_type, String str, String str2) {
        try {
            if (bs_type == null) {
                Log.e("UMLog", UMLogCommon.SC_10024);
                return;
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (str.trim().getBytes().length > 64) {
                    Log.e("UMLog", UMLogCommon.SC_10017);
                    return;
                }
                if (str2.trim().getBytes().length > 128) {
                    Log.e("UMLog", UMLogCommon.SC_10018);
                    return;
                }
                int ordinal = bs_type.ordinal();
                String[] strArr = BUSINESS_TYPE;
                String str3 = ordinal < strArr.length ? strArr[ordinal] : "";
                if (TextUtils.isEmpty(str3)) {
                    Log.e("UMLog", UMLogCommon.SC_10019);
                    return;
                }
                TagHelper.setModuleTag(str3 + e.f26694a + str, str2);
                return;
            }
            Log.e("UMLog", UMLogCommon.SC_10016);
        } catch (Throwable unused) {
        }
    }

    public static void setProcessEvent(boolean z10) {
        AnalyticsConstants.SUB_PROCESS_EVENT = z10;
    }

    private static void setWraperType(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (str.equals("native")) {
                com.umeng.commonsdk.stateless.a.f24559a = "native";
                a.f24588a = "native";
            } else if (str.equals(WRAPER_TYPE_COCOS2DX_X)) {
                com.umeng.commonsdk.stateless.a.f24559a = WRAPER_TYPE_COCOS2DX_X;
                a.f24588a = WRAPER_TYPE_COCOS2DX_X;
            } else if (str.equals(WRAPER_TYPE_COCOS2DX_XLUA)) {
                com.umeng.commonsdk.stateless.a.f24559a = WRAPER_TYPE_COCOS2DX_XLUA;
                a.f24588a = WRAPER_TYPE_COCOS2DX_XLUA;
            } else if (str.equals(WRAPER_TYPE_UNITY)) {
                com.umeng.commonsdk.stateless.a.f24559a = WRAPER_TYPE_UNITY;
                a.f24588a = WRAPER_TYPE_UNITY;
            } else if (str.equals(WRAPER_TYPE_REACTNATIVE)) {
                com.umeng.commonsdk.stateless.a.f24559a = WRAPER_TYPE_REACTNATIVE;
                a.f24588a = WRAPER_TYPE_REACTNATIVE;
            } else if (str.equals(WRAPER_TYPE_PHONEGAP)) {
                com.umeng.commonsdk.stateless.a.f24559a = WRAPER_TYPE_PHONEGAP;
                a.f24588a = WRAPER_TYPE_PHONEGAP;
            } else if (str.equals(WRAPER_TYPE_WEEX)) {
                com.umeng.commonsdk.stateless.a.f24559a = WRAPER_TYPE_WEEX;
                a.f24588a = WRAPER_TYPE_WEEX;
            } else if (str.equals("hybrid")) {
                com.umeng.commonsdk.stateless.a.f24559a = "hybrid";
                a.f24588a = "hybrid";
            } else if (str.equals(WRAPER_TYPE_FLUTTER)) {
                com.umeng.commonsdk.stateless.a.f24559a = WRAPER_TYPE_FLUTTER;
                a.f24588a = WRAPER_TYPE_FLUTTER;
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        com.umeng.commonsdk.stateless.a.f24560b = str2;
        a.f24589b = str2;
    }

    public static boolean shouldCollectAid() {
        return shouldCollectAid;
    }

    public static boolean shouldCollectApl() {
        return shouldCollectApl;
    }

    public static boolean shouldCollectIccid() {
        return shouldCollectIccid;
    }

    public static boolean shouldCollectImei() {
        return shouldCollectImei;
    }

    public static boolean shouldCollectImsi() {
        return shouldCollectImsi;
    }

    public static boolean shouldCollectOaid() {
        return shouldCollectOaid;
    }

    public static boolean shouldCollectWifiMac() {
        return shouldCollectWiFiMac;
    }

    public static boolean shouldOutput() {
        return shouldOutputRT;
    }

    public static void submitPolicyGrantResult(Context context, boolean z10) {
        UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.B, com.umeng.commonsdk.internal.b.a(context).a(), null);
        synchronized (lock) {
            try {
                policyGrantInvokedFlag = 1;
                if (z10) {
                    policyGrantResult = 1;
                } else {
                    policyGrantResult = 2;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.f24490z, com.umeng.commonsdk.internal.b.a(context).a(), Integer.valueOf(policyGrantResult));
    }

    public static void init(Context context, String str, String str2, int i10, String str3) {
        Object invoke;
        Method declaredMethod;
        Class<?> cls;
        Method declaredMethod2;
        Method declaredMethod3;
        Object invoke2;
        Method declaredMethod4;
        try {
            try {
                if (debugLog) {
                    Log.i(TAG, "common version is 9.7.9");
                    Log.i(TAG, "common type is " + SdkVersion.SDK_TYPE);
                }
            } catch (Throwable th2) {
                if (debugLog) {
                    Log.e(TAG, "init e is " + th2);
                }
            }
        } catch (Exception e10) {
            if (debugLog) {
                Log.e(TAG, "init e is " + e10);
            }
        }
        if (context == null) {
            if (debugLog) {
                Log.e(TAG, "context is null !!!");
                return;
            }
            return;
        }
        if (isInit) {
            if (debugLog) {
                Log.e(TAG, "has inited !!!");
                return;
            }
            return;
        }
        Context applicationContext = context.getApplicationContext();
        UMGlobalContext.getInstance(applicationContext);
        if (c.a()) {
            if (!isPreInit()) {
                preInitInternal(applicationContext, str, str2);
                if (!isPreInit()) {
                    return;
                }
            }
            UMWorkDispatch.sendEvent(applicationContext, com.umeng.commonsdk.internal.a.D, com.umeng.commonsdk.internal.b.a(applicationContext).a(), null);
            return;
        }
        try {
            if (getClass("com.umeng.umzid.ZIDManager") == null) {
                Log.e(TAG, "--->>> SDK 初始化失败，请检查是否集成umeng-asms-1.2.x.aar库。<<<--- ");
                new Thread() { // from class: com.umeng.commonsdk.UMConfigure.1

                    /* renamed from: a */
                    final /* synthetic */ Context f24317a;

                    public AnonymousClass1(Context applicationContext2) {
                        applicationContext = applicationContext2;
                    }

                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            Looper.prepare();
                            Toast.makeText(applicationContext, "SDK 初始化失败，请检查是否集成umeng-asms-1.2.X.aar库。", 1).show();
                            Looper.loop();
                        } catch (Throwable unused) {
                        }
                    }
                }.start();
                return;
            }
        } catch (Throwable unused) {
        }
        try {
            Class<?> cls2 = getClass("com.umeng.message.PushAgent");
            if (cls2 != null && !checkShareSdk(cls2)) {
                Log.e("UMLog", UMLogCommon.SC_10015);
                if (shouldCheckShareSdk) {
                    new Thread() { // from class: com.umeng.commonsdk.UMConfigure.2

                        /* renamed from: a */
                        final /* synthetic */ Context f24318a;

                        public AnonymousClass2(Context applicationContext2) {
                            applicationContext = applicationContext2;
                        }

                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            try {
                                Looper.prepare();
                                Toast.makeText(applicationContext, UMLogCommon.SC_10015, 1).show();
                                Looper.loop();
                            } catch (Throwable unused2) {
                            }
                        }
                    }.start();
                }
            }
        } catch (Throwable unused2) {
        }
        try {
            Class<?> cls3 = getClass("com.umeng.socialize.UMShareAPI");
            if (cls3 != null && !checkShareSdk(cls3)) {
                Log.e("UMLog", UMLogCommon.SC_10015);
                if (shouldCheckShareSdk) {
                    new Thread() { // from class: com.umeng.commonsdk.UMConfigure.3

                        /* renamed from: a */
                        final /* synthetic */ Context f24319a;

                        public AnonymousClass3(Context applicationContext2) {
                            applicationContext = applicationContext2;
                        }

                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            try {
                                Looper.prepare();
                                Toast.makeText(applicationContext, UMLogCommon.SC_10015, 1).show();
                                Looper.loop();
                            } catch (Throwable unused3) {
                            }
                        }
                    }.start();
                }
            }
        } catch (Throwable unused3) {
        }
        if (!isPreInit()) {
            preInitInternal(applicationContext2, str, str2);
            if (!isPreInit()) {
                return;
            }
        }
        UMEnvelopeBuild.registerNetReceiver(applicationContext2);
        UMUtils.setAppkey(applicationContext2, sAppkey);
        String lastAppkey = UMUtils.getLastAppkey(applicationContext2);
        if (!TextUtils.isEmpty(sAppkey) && !sAppkey.equals(lastAppkey)) {
            if (!TextUtils.isEmpty(lastAppkey) && debugLog) {
                UMLog.mutlInfo(UMLogCommon.SC_10008, 2, "");
            }
            UMUtils.setLastAppkey(applicationContext2, sAppkey);
        }
        if (debugLog) {
            Log.i(TAG, "current appkey is " + sAppkey + ", last appkey is " + lastAppkey);
        }
        if (debugLog) {
            String appkeyByXML = UMUtils.getAppkeyByXML(applicationContext2);
            if (!TextUtils.isEmpty(sAppkey) && !TextUtils.isEmpty(appkeyByXML) && !sAppkey.equals(appkeyByXML)) {
                UMLog.mutlInfo(UMLogCommon.SC_10011, 3, "", new String[]{"@", "#"}, new String[]{sAppkey, appkeyByXML});
            }
        }
        UMUtils.setChannel(applicationContext2, sChannel);
        if (debugLog) {
            Log.i(TAG, "channel is " + sChannel);
        }
        try {
            Method declaredMethod5 = MobclickAgent.class.getDeclaredMethod(PointCategory.INIT, Context.class);
            if (declaredMethod5 != null) {
                declaredMethod5.setAccessible(true);
                declaredMethod5.invoke(MobclickAgent.class, applicationContext2);
                if (FieldManager.allow(d.F)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> FirstResumeTrigger enabled.");
                    n.a(applicationContext2).b(applicationContext2);
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> FirstResumeTrigger disabled.");
                }
                if (debugLog) {
                    UMLog.mutlInfo(UMLogCommon.SC_10003, 2, "");
                }
            }
            Class.forName("com.umeng.analytics.game.UMGameAgent");
            Method declaredMethod6 = MobclickAgent.class.getDeclaredMethod("setGameScenarioType", Context.class);
            if (declaredMethod6 != null) {
                declaredMethod6.setAccessible(true);
                declaredMethod6.invoke(MobclickAgent.class, applicationContext2);
            }
            if (com.umeng.commonsdk.statistics.b.f24591a.indexOf(com.kwad.sdk.m.e.TAG) >= 0 && (declaredMethod4 = MobclickAgent.class.getDeclaredMethod("disableExceptionCatch", null)) != null) {
                declaredMethod4.setAccessible(true);
                declaredMethod4.invoke(MobclickAgent.class, null);
            }
        } catch (Throwable unused4) {
        }
        try {
            Class<?> cls4 = Class.forName("com.umeng.message.PushAgent");
            Method declaredMethod7 = cls4.getDeclaredMethod(PointCategory.INIT, Context.class);
            if (declaredMethod7 != null) {
                declaredMethod7.setAccessible(true);
                declaredMethod7.invoke(cls4, applicationContext2);
            }
        } catch (Throwable unused5) {
        }
        try {
            Class<?> cls5 = Class.forName("com.umeng.message.MessageSharedPrefs");
            Method declaredMethod8 = cls5.getDeclaredMethod("getInstance", Context.class);
            if (declaredMethod8 != null && (invoke2 = declaredMethod8.invoke(cls5, applicationContext2)) != null) {
                Method declaredMethod9 = cls5.getDeclaredMethod("setMessageAppKey", String.class);
                if (declaredMethod9 != null) {
                    declaredMethod9.setAccessible(true);
                    declaredMethod9.invoke(invoke2, sAppkey);
                    if (debugLog) {
                        UMLog.mutlInfo(UMLogCommon.SC_10004, 2, "");
                    }
                }
                Method declaredMethod10 = cls5.getDeclaredMethod(KEY_METHOD_NAME_PUSH_SETCHANNEL, String.class);
                if (declaredMethod10 != null) {
                    declaredMethod10.setAccessible(true);
                    declaredMethod10.invoke(invoke2, sChannel);
                    if (debugLog) {
                        UMLog.mutlInfo(UMLogCommon.SC_10005, 2, "");
                    }
                }
                if (!TextUtils.isEmpty(str3)) {
                    if (debugLog) {
                        Log.i(TAG, "push secret is " + str3);
                    }
                    Method declaredMethod11 = cls5.getDeclaredMethod("setMessageAppSecret", String.class);
                    if (declaredMethod11 != null) {
                        declaredMethod11.setAccessible(true);
                        declaredMethod11.invoke(invoke2, str3);
                        if (debugLog) {
                            UMLog.mutlInfo(UMLogCommon.SC_10009, 2, "");
                        }
                    }
                }
            }
        } catch (Exception unused6) {
        }
        try {
            Class<?> cls6 = getClass("com.umeng.socialize.UMShareAPI");
            setFile(cls6, KEY_FILE_NAME_APPKEY, sAppkey);
            if (cls6 != null && (declaredMethod3 = cls6.getDeclaredMethod(PointCategory.INIT, Context.class, String.class)) != null) {
                declaredMethod3.setAccessible(true);
                declaredMethod3.invoke(cls6, applicationContext2, sAppkey);
                if (debugLog) {
                    UMLog.mutlInfo(UMLogCommon.SC_10006, 2, "");
                }
            }
        } catch (Throwable unused7) {
        }
        AnalyticsConstants.setDeviceType(i10);
        try {
            Class<?> cls7 = Class.forName("com.umeng.error.UMError");
            Method declaredMethod12 = cls7.getDeclaredMethod(PointCategory.INIT, Context.class);
            if (declaredMethod12 != null) {
                declaredMethod12.setAccessible(true);
                declaredMethod12.invoke(cls7, applicationContext2);
                if (debugLog) {
                    UMLog.mutlInfo(UMLogCommon.SC_10010, 2, "");
                }
            }
        } catch (Throwable unused8) {
        }
        try {
            if (getClass("com.umeng.umefs.UMEfs") == null && (cls = getClass("com.umeng.umcrash.UMCrash")) != null) {
                if (SdkVersion.SDK_TYPE == 1 && (declaredMethod2 = cls.getDeclaredMethod("useIntlServices", Boolean.TYPE)) != null) {
                    declaredMethod2.setAccessible(true);
                    declaredMethod2.invoke(cls, Boolean.TRUE);
                }
                Method declaredMethod13 = cls.getDeclaredMethod(PointCategory.INIT, Context.class, String.class, String.class);
                if (declaredMethod13 != null) {
                    declaredMethod13.setAccessible(true);
                    declaredMethod13.invoke(cls, applicationContext2, sAppkey, sChannel);
                    if (debugLog) {
                        UMLog.mutlInfo(UMLogCommon.SC_10014, 2, "");
                    }
                }
            }
        } catch (Throwable unused9) {
        }
        try {
            Method declaredMethod14 = Class.forName("com.umeng.vt.facade.EventFacade").getDeclaredMethod(PointCategory.INIT, Application.class, String.class, String.class, Integer.TYPE, String.class);
            if (declaredMethod14 != null) {
                declaredMethod14.invoke(null, applicationContext2, sAppkey, sChannel, Integer.valueOf(i10), str3);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>初始化 EventFacade 成功.");
            }
        } catch (Throwable unused10) {
        }
        try {
            Method declaredMethod15 = Class.forName("com.umeng.vt.common.VTTracker").getDeclaredMethod(PointCategory.INIT, Application.class, String.class);
            if (declaredMethod15 != null) {
                declaredMethod15.invoke(null, applicationContext2, sAppkey);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>初始化 VTTracker 成功.");
            }
        } catch (Throwable unused11) {
        }
        synchronized (lockObject) {
            isFinish = true;
        }
        if (needCheckPolicyResult(applicationContext2)) {
            synchronized (lock) {
                try {
                    if (preInitInvokedFlag == 0) {
                        Log.e(TAG, UMLogCommon.SC_10026);
                    }
                    if (policyGrantResult == 0) {
                        Log.e(TAG, UMLogCommon.SC_10028);
                    }
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(com.umeng.commonsdk.internal.a.J, preInitInvokedFlag);
                        jSONObject.put(com.umeng.commonsdk.internal.a.K, policyGrantInvokedFlag);
                        jSONObject.put("policyGrantResult", policyGrantResult);
                        UMWorkDispatch.sendEvent(applicationContext2, com.umeng.commonsdk.internal.a.A, com.umeng.commonsdk.internal.b.a(applicationContext2).a(), jSONObject);
                    } catch (Throwable unused12) {
                    }
                } finally {
                }
            }
        }
        if (needSendZcfgEnv(applicationContext2)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 走零号报文发送逻辑");
            UMWorkDispatch.sendEvent(applicationContext2, com.umeng.commonsdk.internal.a.f24480p, com.umeng.commonsdk.internal.b.a(applicationContext2).a(), null);
        } else if (UMUtils.isMainProgress(applicationContext2)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 走正常逻辑.");
            if (FieldManager.b()) {
                UMWorkDispatch.sendEvent(applicationContext2, com.umeng.commonsdk.internal.a.f24489y, com.umeng.commonsdk.internal.b.a(applicationContext2).a(), null);
            }
            if (FieldManager.allow(d.G)) {
                com.umeng.commonsdk.internal.c.a(applicationContext2, false);
            }
        }
        if (isDebugLog()) {
            UMConfigureInternation.doSelfCheck(applicationContext2);
        }
        try {
            Context applicationContext2 = context.getApplicationContext();
            Class<?> cls8 = Class.forName("com.umeng.cconfig.UMRemoteConfig");
            Method declaredMethod16 = cls8.getDeclaredMethod("getInstance", null);
            if (declaredMethod16 != null && (invoke = declaredMethod16.invoke(cls8, null)) != null && (declaredMethod = cls8.getDeclaredMethod(PointCategory.INIT, Context.class)) != null) {
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(invoke, applicationContext2);
            }
        } catch (Exception unused13) {
        }
        UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.F, com.umeng.commonsdk.internal.b.a(context).a(), null);
        if (!isInit) {
            isInit = true;
        }
        initCompleteTs = System.currentTimeMillis();
        if (debugLog) {
            UMLog.mutlInfo(UMLogCommon.SC_10029, 2, "");
        }
    }

    private static void invoke(Method method, Object[] objArr) {
        if (method != null) {
            try {
                method.invoke(null, objArr);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }

    private static void setFile(Class<?> cls, String str, boolean z10) {
        if (cls != null) {
            try {
                cls.getField(str).set(str, Boolean.valueOf(z10));
            } catch (Exception unused) {
            }
        }
    }
}
