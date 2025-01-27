package com.tencent.bugly;

import java.util.Map;

/* loaded from: classes4.dex */
public class BuglyStrategy {

    /* renamed from: a */
    private String f22038a;

    /* renamed from: b */
    private String f22039b;

    /* renamed from: c */
    private String f22040c;

    /* renamed from: d */
    private long f22041d;

    /* renamed from: e */
    private String f22042e;

    /* renamed from: f */
    private String f22043f;

    /* renamed from: q */
    private a f22054q;

    /* renamed from: g */
    private boolean f22044g = true;

    /* renamed from: h */
    private boolean f22045h = true;

    /* renamed from: i */
    private boolean f22046i = false;

    /* renamed from: j */
    private boolean f22047j = true;

    /* renamed from: k */
    private Class<?> f22048k = null;

    /* renamed from: l */
    private boolean f22049l = true;

    /* renamed from: m */
    private boolean f22050m = true;

    /* renamed from: n */
    private boolean f22051n = true;

    /* renamed from: o */
    private boolean f22052o = true;

    /* renamed from: p */
    private boolean f22053p = false;

    /* renamed from: r */
    protected int f22055r = 31;

    /* renamed from: s */
    protected boolean f22056s = false;

    /* renamed from: t */
    private boolean f22057t = true;

    public static class a {
        public static final int CRASHTYPE_ANR = 4;
        public static final int CRASHTYPE_BLOCK = 7;
        public static final int CRASHTYPE_COCOS2DX_JS = 5;
        public static final int CRASHTYPE_COCOS2DX_LUA = 6;
        public static final int CRASHTYPE_JAVA_CATCH = 1;
        public static final int CRASHTYPE_JAVA_CRASH = 0;
        public static final int CRASHTYPE_NATIVE = 2;
        public static final int CRASHTYPE_U3D = 3;
        public static final int MAX_USERDATA_KEY_LENGTH = 100;
        public static final int MAX_USERDATA_VALUE_LENGTH = 100000;

        public synchronized Map<String, String> onCrashHandleStart(int i10, String str, String str2, String str3) {
            return null;
        }

        public synchronized byte[] onCrashHandleStart2GetExtraDatas(int i10, String str, String str2, String str3) {
            return null;
        }
    }

    public synchronized String getAppChannel() {
        String str;
        str = this.f22039b;
        if (str == null) {
            str = com.tencent.bugly.crashreport.common.info.a.m().I;
        }
        return str;
    }

    public synchronized String getAppPackageName() {
        String str;
        str = this.f22040c;
        if (str == null) {
            str = com.tencent.bugly.crashreport.common.info.a.m().f22294g;
        }
        return str;
    }

    public synchronized long getAppReportDelay() {
        return this.f22041d;
    }

    public synchronized String getAppVersion() {
        String str;
        str = this.f22038a;
        if (str == null) {
            str = com.tencent.bugly.crashreport.common.info.a.m().E;
        }
        return str;
    }

    public synchronized int getCallBackType() {
        return this.f22055r;
    }

    public synchronized boolean getCloseErrorCallback() {
        return this.f22056s;
    }

    public synchronized a getCrashHandleCallback() {
        return this.f22054q;
    }

    public synchronized String getDeviceID() {
        return this.f22043f;
    }

    public synchronized String getLibBuglySOFilePath() {
        return this.f22042e;
    }

    public synchronized Class<?> getUserInfoActivity() {
        return this.f22048k;
    }

    public synchronized boolean isBuglyLogUpload() {
        return this.f22049l;
    }

    public synchronized boolean isEnableANRCrashMonitor() {
        return this.f22045h;
    }

    public synchronized boolean isEnableCatchAnrTrace() {
        return this.f22046i;
    }

    public synchronized boolean isEnableNativeCrashMonitor() {
        return this.f22044g;
    }

    public synchronized boolean isEnableUserInfo() {
        return this.f22047j;
    }

    public boolean isMerged() {
        return this.f22057t;
    }

    public boolean isReplaceOldChannel() {
        return this.f22050m;
    }

    public synchronized boolean isUploadProcess() {
        return this.f22051n;
    }

    public synchronized boolean isUploadSpotCrash() {
        return this.f22052o;
    }

    public synchronized boolean recordUserInfoOnceADay() {
        return this.f22053p;
    }

    public synchronized BuglyStrategy setAppChannel(String str) {
        this.f22039b = str;
        return this;
    }

    public synchronized BuglyStrategy setAppPackageName(String str) {
        this.f22040c = str;
        return this;
    }

    public synchronized BuglyStrategy setAppReportDelay(long j10) {
        this.f22041d = j10;
        return this;
    }

    public synchronized BuglyStrategy setAppVersion(String str) {
        this.f22038a = str;
        return this;
    }

    public synchronized BuglyStrategy setBuglyLogUpload(boolean z10) {
        this.f22049l = z10;
        return this;
    }

    public synchronized void setCallBackType(int i10) {
        this.f22055r = i10;
    }

    public synchronized void setCloseErrorCallback(boolean z10) {
        this.f22056s = z10;
    }

    public synchronized BuglyStrategy setCrashHandleCallback(a aVar) {
        this.f22054q = aVar;
        return this;
    }

    public synchronized BuglyStrategy setDeviceID(String str) {
        this.f22043f = str;
        return this;
    }

    public synchronized BuglyStrategy setEnableANRCrashMonitor(boolean z10) {
        this.f22045h = z10;
        return this;
    }

    public void setEnableCatchAnrTrace(boolean z10) {
        this.f22046i = z10;
    }

    public synchronized BuglyStrategy setEnableNativeCrashMonitor(boolean z10) {
        this.f22044g = z10;
        return this;
    }

    public synchronized BuglyStrategy setEnableUserInfo(boolean z10) {
        this.f22047j = z10;
        return this;
    }

    public synchronized BuglyStrategy setLibBuglySOFilePath(String str) {
        this.f22042e = str;
        return this;
    }

    public void setMerged(boolean z10) {
        this.f22057t = z10;
    }

    public synchronized BuglyStrategy setRecordUserInfoOnceADay(boolean z10) {
        this.f22053p = z10;
        return this;
    }

    public void setReplaceOldChannel(boolean z10) {
        this.f22050m = z10;
    }

    public synchronized BuglyStrategy setUploadProcess(boolean z10) {
        this.f22051n = z10;
        return this;
    }

    public synchronized void setUploadSpotCrash(boolean z10) {
        this.f22052o = z10;
    }

    public synchronized BuglyStrategy setUserInfoActivity(Class<?> cls) {
        this.f22048k = cls;
        return this;
    }
}
