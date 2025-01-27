package com.tencent.bugly;

import java.util.Map;

/* loaded from: classes.dex */
public class BuglyStrategy {

    /* renamed from: a */
    private String f24571a;

    /* renamed from: b */
    private String f24572b;

    /* renamed from: c */
    private String f24573c;

    /* renamed from: d */
    private long f24574d;

    /* renamed from: e */
    private String f24575e;

    /* renamed from: f */
    private String f24576f;
    private a q;

    /* renamed from: g */
    private boolean f24577g = true;

    /* renamed from: h */
    private boolean f24578h = true;

    /* renamed from: i */
    private boolean f24579i = false;

    /* renamed from: j */
    private boolean f24580j = true;
    private Class<?> k = null;
    private boolean l = true;
    private boolean m = true;
    private boolean n = true;
    private boolean o = true;
    private boolean p = false;
    protected int r = 31;
    protected boolean s = false;
    private boolean t = true;

    /* loaded from: classes4.dex */
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

        public synchronized Map<String, String> onCrashHandleStart(int i2, String str, String str2, String str3) {
            return null;
        }

        public synchronized byte[] onCrashHandleStart2GetExtraDatas(int i2, String str, String str2, String str3) {
            return null;
        }
    }

    public synchronized String getAppChannel() {
        String str;
        str = this.f24572b;
        if (str == null) {
            str = com.tencent.bugly.crashreport.common.info.a.m().I;
        }
        return str;
    }

    public synchronized String getAppPackageName() {
        String str;
        str = this.f24573c;
        if (str == null) {
            str = com.tencent.bugly.crashreport.common.info.a.m().f24754g;
        }
        return str;
    }

    public synchronized long getAppReportDelay() {
        return this.f24574d;
    }

    public synchronized String getAppVersion() {
        String str;
        str = this.f24571a;
        if (str == null) {
            str = com.tencent.bugly.crashreport.common.info.a.m().E;
        }
        return str;
    }

    public synchronized int getCallBackType() {
        return this.r;
    }

    public synchronized boolean getCloseErrorCallback() {
        return this.s;
    }

    public synchronized a getCrashHandleCallback() {
        return this.q;
    }

    public synchronized String getDeviceID() {
        return this.f24576f;
    }

    public synchronized String getLibBuglySOFilePath() {
        return this.f24575e;
    }

    public synchronized Class<?> getUserInfoActivity() {
        return this.k;
    }

    public synchronized boolean isBuglyLogUpload() {
        return this.l;
    }

    public synchronized boolean isEnableANRCrashMonitor() {
        return this.f24578h;
    }

    public synchronized boolean isEnableCatchAnrTrace() {
        return this.f24579i;
    }

    public synchronized boolean isEnableNativeCrashMonitor() {
        return this.f24577g;
    }

    public synchronized boolean isEnableUserInfo() {
        return this.f24580j;
    }

    public boolean isMerged() {
        return this.t;
    }

    public boolean isReplaceOldChannel() {
        return this.m;
    }

    public synchronized boolean isUploadProcess() {
        return this.n;
    }

    public synchronized boolean isUploadSpotCrash() {
        return this.o;
    }

    public synchronized boolean recordUserInfoOnceADay() {
        return this.p;
    }

    public synchronized BuglyStrategy setAppChannel(String str) {
        this.f24572b = str;
        return this;
    }

    public synchronized BuglyStrategy setAppPackageName(String str) {
        this.f24573c = str;
        return this;
    }

    public synchronized BuglyStrategy setAppReportDelay(long j2) {
        this.f24574d = j2;
        return this;
    }

    public synchronized BuglyStrategy setAppVersion(String str) {
        this.f24571a = str;
        return this;
    }

    public synchronized BuglyStrategy setBuglyLogUpload(boolean z) {
        this.l = z;
        return this;
    }

    public synchronized void setCallBackType(int i2) {
        this.r = i2;
    }

    public synchronized void setCloseErrorCallback(boolean z) {
        this.s = z;
    }

    public synchronized BuglyStrategy setCrashHandleCallback(a aVar) {
        this.q = aVar;
        return this;
    }

    public synchronized BuglyStrategy setDeviceID(String str) {
        this.f24576f = str;
        return this;
    }

    public synchronized BuglyStrategy setEnableANRCrashMonitor(boolean z) {
        this.f24578h = z;
        return this;
    }

    public void setEnableCatchAnrTrace(boolean z) {
        this.f24579i = z;
    }

    public synchronized BuglyStrategy setEnableNativeCrashMonitor(boolean z) {
        this.f24577g = z;
        return this;
    }

    public synchronized BuglyStrategy setEnableUserInfo(boolean z) {
        this.f24580j = z;
        return this;
    }

    public synchronized BuglyStrategy setLibBuglySOFilePath(String str) {
        this.f24575e = str;
        return this;
    }

    public void setMerged(boolean z) {
        this.t = z;
    }

    public synchronized BuglyStrategy setRecordUserInfoOnceADay(boolean z) {
        this.p = z;
        return this;
    }

    public void setReplaceOldChannel(boolean z) {
        this.m = z;
    }

    public synchronized BuglyStrategy setUploadProcess(boolean z) {
        this.n = z;
        return this;
    }

    public synchronized void setUploadSpotCrash(boolean z) {
        this.o = z;
    }

    public synchronized BuglyStrategy setUserInfoActivity(Class<?> cls) {
        this.k = cls;
        return this;
    }
}
