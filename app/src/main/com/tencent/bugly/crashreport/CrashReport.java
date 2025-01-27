package com.tencent.bugly.crashreport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.CrashModule;
import com.tencent.bugly.crashreport.biz.f;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.common.strategy.c;
import com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver;
import com.tencent.bugly.crashreport.crash.h;
import com.tencent.bugly.crashreport.crash.h5.H5JavaScriptInterface;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.crashreport.crash.k;
import com.tencent.bugly.proguard.K;
import com.tencent.bugly.proguard.W;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.Y;
import com.tencent.bugly.proguard.ca;
import java.net.InetAddress;
import java.net.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public class CrashReport {

    /* renamed from: a */
    private static Context f22226a;

    public static class CrashHandleCallback extends BuglyStrategy.a {
    }

    public static class UserStrategy extends BuglyStrategy {

        /* renamed from: u */
        CrashHandleCallback f22227u;

        public UserStrategy(Context context) {
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized int getCallBackType() {
            return this.f22055r;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized boolean getCloseErrorCallback() {
            return this.f22056s;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized void setCallBackType(int i10) {
            this.f22055r = i10;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized void setCloseErrorCallback(boolean z10) {
            this.f22056s = z10;
        }

        public synchronized void setCrashHandleCallback(CrashHandleCallback crashHandleCallback) {
            this.f22227u = crashHandleCallback;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized CrashHandleCallback getCrashHandleCallback() {
            return this.f22227u;
        }
    }

    public interface WebViewInterface {
        void addJavascriptInterface(H5JavaScriptInterface h5JavaScriptInterface, String str);

        CharSequence getContentDescription();

        String getUrl();

        void loadUrl(String str);

        void setJavaScriptEnabled(boolean z10);
    }

    public static void closeBugly() {
        if (!com.tencent.bugly.b.f22064a) {
            Log.w(X.f22679b, "Can not close bugly because bugly is disable.");
            return;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            Log.w(X.f22679b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return;
        }
        if (f22226a == null) {
            return;
        }
        BuglyBroadcastReceiver buglyBroadcastReceiver = BuglyBroadcastReceiver.getInstance();
        if (buglyBroadcastReceiver != null) {
            buglyBroadcastReceiver.unregister(f22226a);
        }
        closeCrashReport();
        f.a(f22226a);
        W c10 = W.c();
        if (c10 != null) {
            c10.b();
        }
    }

    public static void closeCrashReport() {
        if (!com.tencent.bugly.b.f22064a) {
            Log.w(X.f22679b, "Can not close crash report because bugly is disable.");
        } else if (CrashModule.getInstance().hasInitialized()) {
            h.g().b();
        } else {
            Log.w(X.f22679b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        }
    }

    public static void closeNativeReport() {
        if (!com.tencent.bugly.b.f22064a) {
            Log.w(X.f22679b, "Can not close native report because bugly is disable.");
        } else if (CrashModule.getInstance().hasInitialized()) {
            h.g().e();
        } else {
            Log.e(X.f22679b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        }
    }

    public static void enableBugly(boolean z10) {
        com.tencent.bugly.b.f22064a = z10;
    }

    public static void enableObtainId(Context context, boolean z10) {
        if (!com.tencent.bugly.b.f22064a) {
            Log.w(X.f22679b, "Can not set DB name because bugly is disable.");
            return;
        }
        if (context == null) {
            Log.w(X.f22679b, "enableObtainId args context should not be null");
            return;
        }
        Log.i(X.f22679b, "Enable identification obtaining? " + z10);
        com.tencent.bugly.crashreport.common.info.a.a(context).b(z10);
    }

    public static Set<String> getAllUserDataKeys(Context context) {
        if (!com.tencent.bugly.b.f22064a) {
            Log.w(X.f22679b, "Can not get all keys of user data because bugly is disable.");
            return new HashSet();
        }
        if (context != null) {
            return com.tencent.bugly.crashreport.common.info.a.a(context).b();
        }
        Log.e(X.f22679b, "getAllUserDataKeys args context should not be null");
        return new HashSet();
    }

    public static String getAppChannel() {
        if (!com.tencent.bugly.b.f22064a) {
            Log.w(X.f22679b, "Can not get App channel because bugly is disable.");
            return "unknown";
        }
        if (CrashModule.getInstance().hasInitialized()) {
            return com.tencent.bugly.crashreport.common.info.a.a(f22226a).I;
        }
        Log.e(X.f22679b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        return "unknown";
    }

    public static String getAppID() {
        if (!com.tencent.bugly.b.f22064a) {
            Log.w(X.f22679b, "Can not get App ID because bugly is disable.");
            return "unknown";
        }
        if (CrashModule.getInstance().hasInitialized()) {
            return com.tencent.bugly.crashreport.common.info.a.a(f22226a).e();
        }
        Log.e(X.f22679b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        return "unknown";
    }

    public static String getAppVer() {
        if (!com.tencent.bugly.b.f22064a) {
            Log.w(X.f22679b, "Can not get app version because bugly is disable.");
            return "unknown";
        }
        if (CrashModule.getInstance().hasInitialized()) {
            return com.tencent.bugly.crashreport.common.info.a.a(f22226a).E;
        }
        Log.e(X.f22679b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        return "unknown";
    }

    public static String getBuglyVersion(Context context) {
        if (context != null) {
            return com.tencent.bugly.crashreport.common.info.a.a(context).s();
        }
        X.e("Please call with context.", new Object[0]);
        return "unknown";
    }

    public static String getDeviceID(Context context) {
        return com.tencent.bugly.crashreport.common.info.a.a(context).l();
    }

    public static Proxy getHttpProxy() {
        return Y.a();
    }

    public static Map<String, String> getSdkExtraData() {
        if (!com.tencent.bugly.b.f22064a) {
            Log.w(X.f22679b, "Can not get SDK extra data because bugly is disable.");
            return new HashMap();
        }
        if (CrashModule.getInstance().hasInitialized()) {
            return com.tencent.bugly.crashreport.common.info.a.a(f22226a).f22303ka;
        }
        Log.e(X.f22679b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        return null;
    }

    public static String getUserData(Context context, String str) {
        if (!com.tencent.bugly.b.f22064a) {
            Log.w(X.f22679b, "Can not get user data because bugly is disable.");
            return "unknown";
        }
        if (context == null) {
            Log.e(X.f22679b, "getUserDataValue args context should not be null");
            return "unknown";
        }
        if (ca.b(str)) {
            return null;
        }
        return com.tencent.bugly.crashreport.common.info.a.a(context).a(str);
    }

    public static int getUserDatasSize(Context context) {
        if (!com.tencent.bugly.b.f22064a) {
            Log.w(X.f22679b, "Can not get size of user data because bugly is disable.");
            return -1;
        }
        if (context != null) {
            return com.tencent.bugly.crashreport.common.info.a.a(context).z();
        }
        Log.e(X.f22679b, "getUserDatasSize args context should not be null");
        return -1;
    }

    public static String getUserId() {
        if (!com.tencent.bugly.b.f22064a) {
            Log.w(X.f22679b, "Can not get user ID because bugly is disable.");
            return "unknown";
        }
        if (CrashModule.getInstance().hasInitialized()) {
            return com.tencent.bugly.crashreport.common.info.a.a(f22226a).y();
        }
        Log.e(X.f22679b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        return "unknown";
    }

    public static int getUserSceneTagId(Context context) {
        if (!com.tencent.bugly.b.f22064a) {
            Log.w(X.f22679b, "Can not get user scene tag because bugly is disable.");
            return -1;
        }
        if (context != null) {
            return com.tencent.bugly.crashreport.common.info.a.a(context).A();
        }
        Log.e(X.f22679b, "getUserSceneTagId args context should not be null");
        return -1;
    }

    public static void initCrashReport(Context context) {
        if (context == null) {
            return;
        }
        f22226a = context;
        com.tencent.bugly.b.a(CrashModule.getInstance());
        com.tencent.bugly.b.a(context);
    }

    public static boolean isLastSessionCrash() {
        if (!com.tencent.bugly.b.f22064a) {
            Log.w(X.f22679b, "The info 'isLastSessionCrash' is not accurate because bugly is disable.");
            return false;
        }
        if (CrashModule.getInstance().hasInitialized()) {
            return h.g().h();
        }
        Log.e(X.f22679b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        return false;
    }

    public static void postCatchedException(Throwable th2) {
        postCatchedException(th2, Thread.currentThread());
    }

    public static void postException(Thread thread, int i10, String str, String str2, String str3, Map<String, String> map) {
        if (!com.tencent.bugly.b.f22064a) {
            Log.w(X.f22679b, "Can not post crash caught because bugly is disable.");
        } else if (CrashModule.getInstance().hasInitialized()) {
            k.a(thread, i10, str, str2, str3, map);
        } else {
            Log.e(X.f22679b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        }
    }

    private static void putSdkData(Context context, String str, String str2) {
        if (context == null || ca.b(str) || ca.b(str2)) {
            return;
        }
        String replace = str.replace("[a-zA-Z[0-9]]+", "");
        if (replace.length() > 100) {
            Log.w(X.f22679b, String.format("putSdkData key length over limit %d, will be cutted.", 50));
            replace = replace.substring(0, 50);
        }
        if (str2.length() > 500) {
            Log.w(X.f22679b, String.format("putSdkData value length over limit %d, will be cutted!", 200));
            str2 = str2.substring(0, 200);
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).a(replace, str2);
        X.d(String.format("[param] putSdkData data: %s - %s", replace, str2), new Object[0]);
    }

    public static void putUserData(Context context, String str, String str2) {
        if (!com.tencent.bugly.b.f22064a) {
            Log.w(X.f22679b, "Can not put user data because bugly is disable.");
            return;
        }
        if (context == null) {
            Log.w(X.f22679b, "putUserData args context should not be null");
            return;
        }
        if (str == null) {
            X.e("putUserData args key should not be null or empty", new Object[0]);
            return;
        }
        if (str2 == null) {
            X.e("putUserData args value should not be null", new Object[0]);
            return;
        }
        if (str2.length() > 200) {
            X.e("user data value length over limit %d, it will be cutted!", 200);
            str2 = str2.substring(0, 200);
        }
        com.tencent.bugly.crashreport.common.info.a a10 = com.tencent.bugly.crashreport.common.info.a.a(context);
        if (a10.b().contains(str)) {
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.putKeyValueToNative(str, str2);
            }
            com.tencent.bugly.crashreport.common.info.a.a(context).b(str, str2);
            X.a("replace KV %s %s", str, str2);
            return;
        }
        if (a10.z() >= 50) {
            X.e("user data size is over limit %d, it will be cutted!", 50);
            return;
        }
        if (str.length() > 50) {
            X.e("user data key length over limit %d , will drop this new key %s", 50, str);
            str = str.substring(0, 50);
        }
        NativeCrashHandler nativeCrashHandler2 = NativeCrashHandler.getInstance();
        if (nativeCrashHandler2 != null) {
            nativeCrashHandler2.putKeyValueToNative(str, str2);
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).b(str, str2);
        X.d("[param] set user data: %s - %s", str, str2);
    }

    public static String removeUserData(Context context, String str) {
        if (!com.tencent.bugly.b.f22064a) {
            Log.w(X.f22679b, "Can not remove user data because bugly is disable.");
            return "unknown";
        }
        if (context == null) {
            Log.e(X.f22679b, "removeUserData args context should not be null");
            return "unknown";
        }
        if (ca.b(str)) {
            return null;
        }
        X.d("[param] remove user data: %s", str);
        return com.tencent.bugly.crashreport.common.info.a.a(context).b(str);
    }

    public static void setAppChannel(Context context, String str) {
        if (!com.tencent.bugly.b.f22064a) {
            Log.w(X.f22679b, "Can not set App channel because Bugly is disable.");
            return;
        }
        if (context == null) {
            Log.w(X.f22679b, "setAppChannel args context should not be null");
            return;
        }
        if (str == null) {
            Log.w(X.f22679b, "App channel is null, will not set");
            return;
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).I = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppChannel(str);
        }
    }

    public static void setAppPackage(Context context, String str) {
        if (!com.tencent.bugly.b.f22064a) {
            Log.w(X.f22679b, "Can not set App package because bugly is disable.");
            return;
        }
        if (context == null) {
            Log.w(X.f22679b, "setAppPackage args context should not be null");
            return;
        }
        if (str == null) {
            Log.w(X.f22679b, "App package is null, will not set");
            return;
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).f22294g = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppPackage(str);
        }
    }

    public static void setAppVersion(Context context, String str) {
        if (!com.tencent.bugly.b.f22064a) {
            Log.w(X.f22679b, "Can not set App version because bugly is disable.");
            return;
        }
        if (context == null) {
            Log.w(X.f22679b, "setAppVersion args context should not be null");
            return;
        }
        if (str == null) {
            Log.w(X.f22679b, "App version is null, will not set");
            return;
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).E = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppVersion(str);
        }
    }

    public static void setBuglyDbName(String str) {
        if (!com.tencent.bugly.b.f22064a) {
            Log.w(X.f22679b, "Can not set DB name because bugly is disable.");
            return;
        }
        Log.i(X.f22679b, "Set Bugly DB name: " + str);
        K.f22624a = str;
    }

    public static void setContext(Context context) {
        f22226a = context;
    }

    public static void setCrashFilter(String str) {
        if (!com.tencent.bugly.b.f22064a) {
            Log.w(X.f22679b, "Can not set App package because bugly is disable.");
            return;
        }
        Log.i(X.f22679b, "Set crash stack filter: " + str);
        h.f22475n = str;
    }

    public static void setCrashRegularFilter(String str) {
        if (!com.tencent.bugly.b.f22064a) {
            Log.w(X.f22679b, "Can not set App package because bugly is disable.");
            return;
        }
        Log.i(X.f22679b, "Set crash stack filter: " + str);
        h.f22476o = str;
    }

    public static void setDeviceId(Context context, String str) {
        if (str != null) {
            com.tencent.bugly.crashreport.common.info.a.a(context).d(str);
        }
    }

    public static void setHandleNativeCrashInJava(boolean z10) {
        if (!com.tencent.bugly.b.f22064a) {
            Log.w(X.f22679b, "Can not set App package because bugly is disable.");
            return;
        }
        Log.i(X.f22679b, "Should handle native crash in Java profile after handled in native profile: " + z10);
        NativeCrashHandler.setShouldHandleInJava(z10);
    }

    public static void setHttpProxy(String str, int i10) {
        Y.a(str, i10);
    }

    public static void setIsAppForeground(Context context, boolean z10) {
        if (!com.tencent.bugly.b.f22064a) {
            Log.w(X.f22679b, "Can not set 'isAppForeground' because bugly is disable.");
            return;
        }
        if (context == null) {
            X.e("Context should not be null.", new Object[0]);
            return;
        }
        if (z10) {
            X.a("App is in foreground.", new Object[0]);
        } else {
            X.a("App is in background.", new Object[0]);
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).a(z10);
    }

    public static void setIsDevelopmentDevice(Context context, boolean z10) {
        if (!com.tencent.bugly.b.f22064a) {
            Log.w(X.f22679b, "Can not set 'isDevelopmentDevice' because bugly is disable.");
            return;
        }
        if (context == null) {
            X.e("Context should not be null.", new Object[0]);
            return;
        }
        if (z10) {
            X.a("This is a development device.", new Object[0]);
        } else {
            X.a("This is not a development device.", new Object[0]);
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).f22295ga = z10;
    }

    public static boolean setJavascriptMonitor(WebView webView, boolean z10) {
        return setJavascriptMonitor(webView, z10, false);
    }

    public static void setSdkExtraData(Context context, String str, String str2) {
        if (!com.tencent.bugly.b.f22064a) {
            Log.w(X.f22679b, "Can not put SDK extra data because bugly is disable.");
        } else {
            if (context == null || ca.b(str) || ca.b(str2)) {
                return;
            }
            com.tencent.bugly.crashreport.common.info.a.a(context).c(str, str2);
        }
    }

    public static void setServerUrl(String str) {
        if (ca.b(str) || !ca.c(str)) {
            Log.i(X.f22679b, "URL is invalid.");
            return;
        }
        c.a(str);
        StrategyBean.f22337a = str;
        StrategyBean.f22338b = str;
    }

    public static void setSessionIntervalMills(long j10) {
        if (com.tencent.bugly.b.f22064a) {
            f.c(j10);
        } else {
            Log.w(X.f22679b, "Can not set 'SessionIntervalMills' because bugly is disable.");
        }
    }

    public static void setUserId(String str) {
        if (!com.tencent.bugly.b.f22064a) {
            Log.w(X.f22679b, "Can not set user ID because bugly is disable.");
        } else if (CrashModule.getInstance().hasInitialized()) {
            setUserId(f22226a, str);
        } else {
            Log.e(X.f22679b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        }
    }

    public static void setUserSceneTag(Context context, int i10) {
        if (!com.tencent.bugly.b.f22064a) {
            Log.w(X.f22679b, "Can not set tag caught because bugly is disable.");
            return;
        }
        if (context == null) {
            Log.e(X.f22679b, "setTag args context should not be null");
            return;
        }
        if (i10 <= 0) {
            X.e("setTag args tagId should > 0", new Object[0]);
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).b(i10);
        X.d("[param] set user scene tag: %d", Integer.valueOf(i10));
    }

    public static void startCrashReport() {
        if (!com.tencent.bugly.b.f22064a) {
            Log.w(X.f22679b, "Can not start crash report because bugly is disable.");
        } else if (CrashModule.getInstance().hasInitialized()) {
            h.g().o();
        } else {
            Log.w(X.f22679b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        }
    }

    public static void testANRCrash() {
        if (!com.tencent.bugly.b.f22064a) {
            Log.w(X.f22679b, "Can not test ANR crash because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(X.f22679b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            X.c("start to create a anr crash for test!", new Object[0]);
            h.g().t();
        }
    }

    public static void testJavaCrash() {
        if (!com.tencent.bugly.b.f22064a) {
            Log.w(X.f22679b, "Can not test Java crash because bugly is disable.");
        } else {
            if (!CrashModule.getInstance().hasInitialized()) {
                Log.e(X.f22679b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
                return;
            }
            com.tencent.bugly.crashreport.common.info.a m10 = com.tencent.bugly.crashreport.common.info.a.m();
            if (m10 != null) {
                m10.a(24096);
            }
            throw new RuntimeException("This Crash create for Test! You can go to Bugly see more detail!");
        }
    }

    public static void testNativeCrash() {
        testNativeCrash(false, false, false);
    }

    public static void postCatchedException(Throwable th2, Thread thread) {
        postCatchedException(th2, thread, false);
    }

    public static void setHttpProxy(InetAddress inetAddress, int i10) {
        Y.a(inetAddress, i10);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static boolean setJavascriptMonitor(WebView webView, boolean z10, boolean z11) {
        if (webView == null) {
            Log.w(X.f22679b, "WebView is null.");
            return false;
        }
        webView.getSettings().setSavePassword(false);
        webView.getSettings().setAllowFileAccess(false);
        return setJavascriptMonitor(new a(webView), z10, z11);
    }

    public static void testNativeCrash(boolean z10, boolean z11, boolean z12) {
        if (!com.tencent.bugly.b.f22064a) {
            Log.w(X.f22679b, "Can not test native crash because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(X.f22679b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            X.c("start to create a native crash for test!", new Object[0]);
            h.g().a(z10, z11, z12);
        }
    }

    public static void postCatchedException(Throwable th2, Thread thread, boolean z10) {
        if (!com.tencent.bugly.b.f22064a) {
            Log.w(X.f22679b, "Can not post crash caught because bugly is disable.");
            return;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(X.f22679b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return;
        }
        if (th2 == null) {
            X.e("throwable is null, just return", new Object[0]);
            return;
        }
        if (thread == null) {
            thread = Thread.currentThread();
        }
        h.g().a(thread, th2, false, (String) null, (byte[]) null, z10);
    }

    public static void initCrashReport(Context context, UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        f22226a = context;
        com.tencent.bugly.b.a(CrashModule.getInstance());
        com.tencent.bugly.b.a(context, userStrategy);
    }

    public static void postException(int i10, String str, String str2, String str3, Map<String, String> map) {
        postException(Thread.currentThread(), i10, str, str2, str3, map);
    }

    public static void setUserId(Context context, String str) {
        if (!com.tencent.bugly.b.f22064a) {
            Log.w(X.f22679b, "Can not set user ID because bugly is disable.");
            return;
        }
        if (context == null) {
            Log.e(X.f22679b, "Context should not be null when bugly has not been initialed!");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            X.e("userId should not be null", new Object[0]);
            return;
        }
        if (str.length() > 100) {
            String substring = str.substring(0, 100);
            X.e("userId %s length is over limit %d substring to %s", str, 100, substring);
            str = substring;
        }
        if (str.equals(com.tencent.bugly.crashreport.common.info.a.a(context).y())) {
            return;
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).g(str);
        X.d("[user] set userId : %s", str);
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeUserId(str);
        }
        if (CrashModule.getInstance().hasInitialized()) {
            f.l();
        }
    }

    public static Map<String, String> getSdkExtraData(Context context) {
        if (!com.tencent.bugly.b.f22064a) {
            Log.w(X.f22679b, "Can not get SDK extra data because bugly is disable.");
            return new HashMap();
        }
        if (context == null) {
            X.e("Context should not be null.", new Object[0]);
            return null;
        }
        return com.tencent.bugly.crashreport.common.info.a.a(context).f22303ka;
    }

    public static void initCrashReport(Context context, String str, boolean z10) {
        initCrashReport(context, str, z10, null);
    }

    public static boolean setJavascriptMonitor(WebViewInterface webViewInterface, boolean z10) {
        return setJavascriptMonitor(webViewInterface, z10, false);
    }

    public static void initCrashReport(Context context, String str, boolean z10, UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        f22226a = context;
        com.tencent.bugly.b.a(CrashModule.getInstance());
        com.tencent.bugly.b.a(context, str, z10, userStrategy);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static boolean setJavascriptMonitor(WebViewInterface webViewInterface, boolean z10, boolean z11) {
        if (webViewInterface == null) {
            Log.w(X.f22679b, "WebViewInterface is null.");
            return false;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            X.b("CrashReport has not been initialed! please to call method 'initCrashReport' first!", new Object[0]);
            return false;
        }
        X.c("Set Javascript exception monitor of webview.", new Object[0]);
        if (!com.tencent.bugly.b.f22064a) {
            Log.w(X.f22679b, "Can not set JavaScript monitor because bugly is disable.");
            return false;
        }
        X.a("URL of webview is %s", webViewInterface.getUrl());
        X.c("Enable the javascript needed by webview monitor.", new Object[0]);
        webViewInterface.setJavaScriptEnabled(true);
        H5JavaScriptInterface h5JavaScriptInterface = H5JavaScriptInterface.getInstance(webViewInterface);
        if (h5JavaScriptInterface != null) {
            X.c("Add a secure javascript interface to the webview.", new Object[0]);
            webViewInterface.addJavascriptInterface(h5JavaScriptInterface, "exceptionUploader");
        }
        if (z10) {
            X.c("Inject bugly.js(v%s) to the webview.", com.tencent.bugly.crashreport.crash.h5.b.b());
            String a10 = com.tencent.bugly.crashreport.crash.h5.b.a();
            if (a10 == null) {
                X.b("Failed to inject Bugly.js.", com.tencent.bugly.crashreport.crash.h5.b.b());
                return false;
            }
            webViewInterface.loadUrl("javascript:" + a10);
        }
        return true;
    }
}
