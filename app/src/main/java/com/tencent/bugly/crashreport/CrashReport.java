package com.tencent.bugly.crashreport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import androidx.core.os.EnvironmentCompat;
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

/* loaded from: classes.dex */
public class CrashReport {

    /* renamed from: a */
    private static Context f24705a;

    /* loaded from: classes4.dex */
    public static class CrashHandleCallback extends BuglyStrategy.a {
    }

    /* loaded from: classes4.dex */
    public static class UserStrategy extends BuglyStrategy {
        CrashHandleCallback u;

        public UserStrategy(Context context) {
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized int getCallBackType() {
            return this.r;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized boolean getCloseErrorCallback() {
            return this.s;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized void setCallBackType(int i2) {
            this.r = i2;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized void setCloseErrorCallback(boolean z) {
            this.s = z;
        }

        public synchronized void setCrashHandleCallback(CrashHandleCallback crashHandleCallback) {
            this.u = crashHandleCallback;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized CrashHandleCallback getCrashHandleCallback() {
            return this.u;
        }
    }

    /* loaded from: classes4.dex */
    public interface WebViewInterface {
        void addJavascriptInterface(H5JavaScriptInterface h5JavaScriptInterface, String str);

        CharSequence getContentDescription();

        String getUrl();

        void loadUrl(String str);

        void setJavaScriptEnabled(boolean z);
    }

    public static void closeBugly() {
        if (!com.tencent.bugly.b.f24586a) {
            Log.w(X.f25019b, "Can not close bugly because bugly is disable.");
            return;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            Log.w(X.f25019b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return;
        }
        if (f24705a == null) {
            return;
        }
        BuglyBroadcastReceiver buglyBroadcastReceiver = BuglyBroadcastReceiver.getInstance();
        if (buglyBroadcastReceiver != null) {
            buglyBroadcastReceiver.unregister(f24705a);
        }
        closeCrashReport();
        f.a(f24705a);
        W c2 = W.c();
        if (c2 != null) {
            c2.b();
        }
    }

    public static void closeCrashReport() {
        if (!com.tencent.bugly.b.f24586a) {
            Log.w(X.f25019b, "Can not close crash report because bugly is disable.");
        } else if (CrashModule.getInstance().hasInitialized()) {
            h.g().b();
        } else {
            Log.w(X.f25019b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        }
    }

    public static void closeNativeReport() {
        if (!com.tencent.bugly.b.f24586a) {
            Log.w(X.f25019b, "Can not close native report because bugly is disable.");
        } else if (CrashModule.getInstance().hasInitialized()) {
            h.g().e();
        } else {
            Log.e(X.f25019b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        }
    }

    public static void enableBugly(boolean z) {
        com.tencent.bugly.b.f24586a = z;
    }

    public static void enableObtainId(Context context, boolean z) {
        if (!com.tencent.bugly.b.f24586a) {
            Log.w(X.f25019b, "Can not set DB name because bugly is disable.");
            return;
        }
        if (context == null) {
            Log.w(X.f25019b, "enableObtainId args context should not be null");
            return;
        }
        Log.i(X.f25019b, "Enable identification obtaining? " + z);
        com.tencent.bugly.crashreport.common.info.a.a(context).b(z);
    }

    public static Set<String> getAllUserDataKeys(Context context) {
        if (!com.tencent.bugly.b.f24586a) {
            Log.w(X.f25019b, "Can not get all keys of user data because bugly is disable.");
            return new HashSet();
        }
        if (context != null) {
            return com.tencent.bugly.crashreport.common.info.a.a(context).b();
        }
        Log.e(X.f25019b, "getAllUserDataKeys args context should not be null");
        return new HashSet();
    }

    public static String getAppChannel() {
        if (!com.tencent.bugly.b.f24586a) {
            Log.w(X.f25019b, "Can not get App channel because bugly is disable.");
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
        if (CrashModule.getInstance().hasInitialized()) {
            return com.tencent.bugly.crashreport.common.info.a.a(f24705a).I;
        }
        Log.e(X.f25019b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }

    public static String getAppID() {
        if (!com.tencent.bugly.b.f24586a) {
            Log.w(X.f25019b, "Can not get App ID because bugly is disable.");
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
        if (CrashModule.getInstance().hasInitialized()) {
            return com.tencent.bugly.crashreport.common.info.a.a(f24705a).e();
        }
        Log.e(X.f25019b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }

    public static String getAppVer() {
        if (!com.tencent.bugly.b.f24586a) {
            Log.w(X.f25019b, "Can not get app version because bugly is disable.");
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
        if (CrashModule.getInstance().hasInitialized()) {
            return com.tencent.bugly.crashreport.common.info.a.a(f24705a).E;
        }
        Log.e(X.f25019b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }

    public static String getBuglyVersion(Context context) {
        if (context != null) {
            return com.tencent.bugly.crashreport.common.info.a.a(context).s();
        }
        X.e("Please call with context.", new Object[0]);
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }

    public static String getDeviceID(Context context) {
        return com.tencent.bugly.crashreport.common.info.a.a(context).l();
    }

    public static Proxy getHttpProxy() {
        return Y.a();
    }

    public static Map<String, String> getSdkExtraData() {
        if (!com.tencent.bugly.b.f24586a) {
            Log.w(X.f25019b, "Can not get SDK extra data because bugly is disable.");
            return new HashMap();
        }
        if (CrashModule.getInstance().hasInitialized()) {
            return com.tencent.bugly.crashreport.common.info.a.a(f24705a).ka;
        }
        Log.e(X.f25019b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        return null;
    }

    public static String getUserData(Context context, String str) {
        if (!com.tencent.bugly.b.f24586a) {
            Log.w(X.f25019b, "Can not get user data because bugly is disable.");
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
        if (context == null) {
            Log.e(X.f25019b, "getUserDataValue args context should not be null");
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
        if (ca.b(str)) {
            return null;
        }
        return com.tencent.bugly.crashreport.common.info.a.a(context).a(str);
    }

    public static int getUserDatasSize(Context context) {
        if (!com.tencent.bugly.b.f24586a) {
            Log.w(X.f25019b, "Can not get size of user data because bugly is disable.");
            return -1;
        }
        if (context != null) {
            return com.tencent.bugly.crashreport.common.info.a.a(context).z();
        }
        Log.e(X.f25019b, "getUserDatasSize args context should not be null");
        return -1;
    }

    public static String getUserId() {
        if (!com.tencent.bugly.b.f24586a) {
            Log.w(X.f25019b, "Can not get user ID because bugly is disable.");
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
        if (CrashModule.getInstance().hasInitialized()) {
            return com.tencent.bugly.crashreport.common.info.a.a(f24705a).y();
        }
        Log.e(X.f25019b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }

    public static int getUserSceneTagId(Context context) {
        if (!com.tencent.bugly.b.f24586a) {
            Log.w(X.f25019b, "Can not get user scene tag because bugly is disable.");
            return -1;
        }
        if (context != null) {
            return com.tencent.bugly.crashreport.common.info.a.a(context).A();
        }
        Log.e(X.f25019b, "getUserSceneTagId args context should not be null");
        return -1;
    }

    public static void initCrashReport(Context context) {
        if (context == null) {
            return;
        }
        f24705a = context;
        com.tencent.bugly.b.a(CrashModule.getInstance());
        com.tencent.bugly.b.a(context);
    }

    public static boolean isLastSessionCrash() {
        if (!com.tencent.bugly.b.f24586a) {
            Log.w(X.f25019b, "The info 'isLastSessionCrash' is not accurate because bugly is disable.");
            return false;
        }
        if (CrashModule.getInstance().hasInitialized()) {
            return h.g().h();
        }
        Log.e(X.f25019b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        return false;
    }

    public static void postCatchedException(Throwable th) {
        postCatchedException(th, Thread.currentThread());
    }

    public static void postException(Thread thread, int i2, String str, String str2, String str3, Map<String, String> map) {
        if (!com.tencent.bugly.b.f24586a) {
            Log.w(X.f25019b, "Can not post crash caught because bugly is disable.");
        } else if (CrashModule.getInstance().hasInitialized()) {
            k.a(thread, i2, str, str2, str3, map);
        } else {
            Log.e(X.f25019b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        }
    }

    private static void putSdkData(Context context, String str, String str2) {
        if (context == null || ca.b(str) || ca.b(str2)) {
            return;
        }
        String replace = str.replace("[a-zA-Z[0-9]]+", "");
        if (replace.length() > 100) {
            Log.w(X.f25019b, String.format("putSdkData key length over limit %d, will be cutted.", 50));
            replace = replace.substring(0, 50);
        }
        if (str2.length() > 500) {
            Log.w(X.f25019b, String.format("putSdkData value length over limit %d, will be cutted!", 200));
            str2 = str2.substring(0, 200);
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).a(replace, str2);
        X.d(String.format("[param] putSdkData data: %s - %s", replace, str2), new Object[0]);
    }

    public static void putUserData(Context context, String str, String str2) {
        if (!com.tencent.bugly.b.f24586a) {
            Log.w(X.f25019b, "Can not put user data because bugly is disable.");
            return;
        }
        if (context == null) {
            Log.w(X.f25019b, "putUserData args context should not be null");
            return;
        }
        if (str == null) {
            String str3 = "" + str;
            X.e("putUserData args key should not be null or empty", new Object[0]);
            return;
        }
        if (str2 == null) {
            String str4 = "" + str2;
            X.e("putUserData args value should not be null", new Object[0]);
            return;
        }
        if (str2.length() > 200) {
            X.e("user data value length over limit %d, it will be cutted!", 200);
            str2 = str2.substring(0, 200);
        }
        com.tencent.bugly.crashreport.common.info.a a2 = com.tencent.bugly.crashreport.common.info.a.a(context);
        if (a2.b().contains(str)) {
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.putKeyValueToNative(str, str2);
            }
            com.tencent.bugly.crashreport.common.info.a.a(context).b(str, str2);
            X.a("replace KV %s %s", str, str2);
            return;
        }
        if (a2.z() >= 50) {
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
        if (!com.tencent.bugly.b.f24586a) {
            Log.w(X.f25019b, "Can not remove user data because bugly is disable.");
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
        if (context == null) {
            Log.e(X.f25019b, "removeUserData args context should not be null");
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
        if (ca.b(str)) {
            return null;
        }
        X.d("[param] remove user data: %s", str);
        return com.tencent.bugly.crashreport.common.info.a.a(context).b(str);
    }

    public static void setAppChannel(Context context, String str) {
        if (!com.tencent.bugly.b.f24586a) {
            Log.w(X.f25019b, "Can not set App channel because Bugly is disable.");
            return;
        }
        if (context == null) {
            Log.w(X.f25019b, "setAppChannel args context should not be null");
            return;
        }
        if (str == null) {
            Log.w(X.f25019b, "App channel is null, will not set");
            return;
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).I = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppChannel(str);
        }
    }

    public static void setAppPackage(Context context, String str) {
        if (!com.tencent.bugly.b.f24586a) {
            Log.w(X.f25019b, "Can not set App package because bugly is disable.");
            return;
        }
        if (context == null) {
            Log.w(X.f25019b, "setAppPackage args context should not be null");
            return;
        }
        if (str == null) {
            Log.w(X.f25019b, "App package is null, will not set");
            return;
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).f24754g = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppPackage(str);
        }
    }

    public static void setAppVersion(Context context, String str) {
        if (!com.tencent.bugly.b.f24586a) {
            Log.w(X.f25019b, "Can not set App version because bugly is disable.");
            return;
        }
        if (context == null) {
            Log.w(X.f25019b, "setAppVersion args context should not be null");
            return;
        }
        if (str == null) {
            Log.w(X.f25019b, "App version is null, will not set");
            return;
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).E = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppVersion(str);
        }
    }

    public static void setBuglyDbName(String str) {
        if (!com.tencent.bugly.b.f24586a) {
            Log.w(X.f25019b, "Can not set DB name because bugly is disable.");
            return;
        }
        Log.i(X.f25019b, "Set Bugly DB name: " + str);
        K.f24975a = str;
    }

    public static void setContext(Context context) {
        f24705a = context;
    }

    public static void setCrashFilter(String str) {
        if (!com.tencent.bugly.b.f24586a) {
            Log.w(X.f25019b, "Can not set App package because bugly is disable.");
            return;
        }
        Log.i(X.f25019b, "Set crash stack filter: " + str);
        h.n = str;
    }

    public static void setCrashRegularFilter(String str) {
        if (!com.tencent.bugly.b.f24586a) {
            Log.w(X.f25019b, "Can not set App package because bugly is disable.");
            return;
        }
        Log.i(X.f25019b, "Set crash stack filter: " + str);
        h.o = str;
    }

    public static void setDeviceId(Context context, String str) {
        if (str != null) {
            com.tencent.bugly.crashreport.common.info.a.a(context).d(str);
        }
    }

    public static void setHandleNativeCrashInJava(boolean z) {
        if (!com.tencent.bugly.b.f24586a) {
            Log.w(X.f25019b, "Can not set App package because bugly is disable.");
            return;
        }
        Log.i(X.f25019b, "Should handle native crash in Java profile after handled in native profile: " + z);
        NativeCrashHandler.setShouldHandleInJava(z);
    }

    public static void setHttpProxy(String str, int i2) {
        Y.a(str, i2);
    }

    public static void setIsAppForeground(Context context, boolean z) {
        if (!com.tencent.bugly.b.f24586a) {
            Log.w(X.f25019b, "Can not set 'isAppForeground' because bugly is disable.");
            return;
        }
        if (context == null) {
            X.e("Context should not be null.", new Object[0]);
            return;
        }
        if (z) {
            X.a("App is in foreground.", new Object[0]);
        } else {
            X.a("App is in background.", new Object[0]);
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).a(z);
    }

    public static void setIsDevelopmentDevice(Context context, boolean z) {
        if (!com.tencent.bugly.b.f24586a) {
            Log.w(X.f25019b, "Can not set 'isDevelopmentDevice' because bugly is disable.");
            return;
        }
        if (context == null) {
            X.e("Context should not be null.", new Object[0]);
            return;
        }
        if (z) {
            X.a("This is a development device.", new Object[0]);
        } else {
            X.a("This is not a development device.", new Object[0]);
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).ga = z;
    }

    public static boolean setJavascriptMonitor(WebView webView, boolean z) {
        return setJavascriptMonitor(webView, z, false);
    }

    public static void setSdkExtraData(Context context, String str, String str2) {
        if (!com.tencent.bugly.b.f24586a) {
            Log.w(X.f25019b, "Can not put SDK extra data because bugly is disable.");
        } else {
            if (context == null || ca.b(str) || ca.b(str2)) {
                return;
            }
            com.tencent.bugly.crashreport.common.info.a.a(context).c(str, str2);
        }
    }

    public static void setServerUrl(String str) {
        if (ca.b(str) || !ca.c(str)) {
            Log.i(X.f25019b, "URL is invalid.");
            return;
        }
        c.a(str);
        StrategyBean.f24763a = str;
        StrategyBean.f24764b = str;
    }

    public static void setSessionIntervalMills(long j2) {
        if (com.tencent.bugly.b.f24586a) {
            f.c(j2);
        } else {
            Log.w(X.f25019b, "Can not set 'SessionIntervalMills' because bugly is disable.");
        }
    }

    public static void setUserId(String str) {
        if (!com.tencent.bugly.b.f24586a) {
            Log.w(X.f25019b, "Can not set user ID because bugly is disable.");
        } else if (CrashModule.getInstance().hasInitialized()) {
            setUserId(f24705a, str);
        } else {
            Log.e(X.f25019b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        }
    }

    public static void setUserSceneTag(Context context, int i2) {
        if (!com.tencent.bugly.b.f24586a) {
            Log.w(X.f25019b, "Can not set tag caught because bugly is disable.");
            return;
        }
        if (context == null) {
            Log.e(X.f25019b, "setTag args context should not be null");
            return;
        }
        if (i2 <= 0) {
            X.e("setTag args tagId should > 0", new Object[0]);
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).b(i2);
        X.d("[param] set user scene tag: %d", Integer.valueOf(i2));
    }

    public static void startCrashReport() {
        if (!com.tencent.bugly.b.f24586a) {
            Log.w(X.f25019b, "Can not start crash report because bugly is disable.");
        } else if (CrashModule.getInstance().hasInitialized()) {
            h.g().o();
        } else {
            Log.w(X.f25019b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        }
    }

    public static void testANRCrash() {
        if (!com.tencent.bugly.b.f24586a) {
            Log.w(X.f25019b, "Can not test ANR crash because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(X.f25019b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            X.c("start to create a anr crash for test!", new Object[0]);
            h.g().t();
        }
    }

    public static void testJavaCrash() {
        if (!com.tencent.bugly.b.f24586a) {
            Log.w(X.f25019b, "Can not test Java crash because bugly is disable.");
        } else {
            if (!CrashModule.getInstance().hasInitialized()) {
                Log.e(X.f25019b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
                return;
            }
            com.tencent.bugly.crashreport.common.info.a m = com.tencent.bugly.crashreport.common.info.a.m();
            if (m != null) {
                m.a(24096);
            }
            throw new RuntimeException("This Crash create for Test! You can go to Bugly see more detail!");
        }
    }

    public static void testNativeCrash() {
        testNativeCrash(false, false, false);
    }

    public static void postCatchedException(Throwable th, Thread thread) {
        postCatchedException(th, thread, false);
    }

    public static void setHttpProxy(InetAddress inetAddress, int i2) {
        Y.a(inetAddress, i2);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static boolean setJavascriptMonitor(WebView webView, boolean z, boolean z2) {
        if (webView == null) {
            Log.w(X.f25019b, "WebView is null.");
            return false;
        }
        webView.getSettings().setSavePassword(false);
        webView.getSettings().setAllowFileAccess(false);
        return setJavascriptMonitor(new a(webView), z, z2);
    }

    public static void testNativeCrash(boolean z, boolean z2, boolean z3) {
        if (!com.tencent.bugly.b.f24586a) {
            Log.w(X.f25019b, "Can not test native crash because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(X.f25019b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            X.c("start to create a native crash for test!", new Object[0]);
            h.g().a(z, z2, z3);
        }
    }

    public static void postCatchedException(Throwable th, Thread thread, boolean z) {
        if (!com.tencent.bugly.b.f24586a) {
            Log.w(X.f25019b, "Can not post crash caught because bugly is disable.");
            return;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(X.f25019b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return;
        }
        if (th == null) {
            X.e("throwable is null, just return", new Object[0]);
            return;
        }
        if (thread == null) {
            thread = Thread.currentThread();
        }
        h.g().a(thread, th, false, (String) null, (byte[]) null, z);
    }

    public static void initCrashReport(Context context, UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        f24705a = context;
        com.tencent.bugly.b.a(CrashModule.getInstance());
        com.tencent.bugly.b.a(context, userStrategy);
    }

    public static void postException(int i2, String str, String str2, String str3, Map<String, String> map) {
        postException(Thread.currentThread(), i2, str, str2, str3, map);
    }

    public static void setUserId(Context context, String str) {
        if (!com.tencent.bugly.b.f24586a) {
            Log.w(X.f25019b, "Can not set user ID because bugly is disable.");
            return;
        }
        if (context == null) {
            Log.e(X.f25019b, "Context should not be null when bugly has not been initialed!");
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
        if (!com.tencent.bugly.b.f24586a) {
            Log.w(X.f25019b, "Can not get SDK extra data because bugly is disable.");
            return new HashMap();
        }
        if (context == null) {
            X.e("Context should not be null.", new Object[0]);
            return null;
        }
        return com.tencent.bugly.crashreport.common.info.a.a(context).ka;
    }

    public static void initCrashReport(Context context, String str, boolean z) {
        initCrashReport(context, str, z, null);
    }

    public static boolean setJavascriptMonitor(WebViewInterface webViewInterface, boolean z) {
        return setJavascriptMonitor(webViewInterface, z, false);
    }

    public static void initCrashReport(Context context, String str, boolean z, UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        f24705a = context;
        com.tencent.bugly.b.a(CrashModule.getInstance());
        com.tencent.bugly.b.a(context, str, z, userStrategy);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static boolean setJavascriptMonitor(WebViewInterface webViewInterface, boolean z, boolean z2) {
        if (webViewInterface == null) {
            Log.w(X.f25019b, "WebViewInterface is null.");
            return false;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            X.b("CrashReport has not been initialed! please to call method 'initCrashReport' first!", new Object[0]);
            return false;
        }
        X.c("Set Javascript exception monitor of webview.", new Object[0]);
        if (!com.tencent.bugly.b.f24586a) {
            Log.w(X.f25019b, "Can not set JavaScript monitor because bugly is disable.");
            return false;
        }
        X.a("URL of webview is %s", webViewInterface.getUrl());
        if (!z2 && Build.VERSION.SDK_INT < 19) {
            X.b("This interface is only available for Android 4.4 or later.", new Object[0]);
            return false;
        }
        X.c("Enable the javascript needed by webview monitor.", new Object[0]);
        webViewInterface.setJavaScriptEnabled(true);
        H5JavaScriptInterface h5JavaScriptInterface = H5JavaScriptInterface.getInstance(webViewInterface);
        if (h5JavaScriptInterface != null) {
            X.c("Add a secure javascript interface to the webview.", new Object[0]);
            webViewInterface.addJavascriptInterface(h5JavaScriptInterface, "exceptionUploader");
        }
        if (z) {
            X.c("Inject bugly.js(v%s) to the webview.", com.tencent.bugly.crashreport.crash.h5.b.b());
            String a2 = com.tencent.bugly.crashreport.crash.h5.b.a();
            if (a2 == null) {
                X.b("Failed to inject Bugly.js.", com.tencent.bugly.crashreport.crash.h5.b.b());
                return false;
            }
            webViewInterface.loadUrl("javascript:" + a2);
        }
        return true;
    }
}
