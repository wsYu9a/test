package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.h;
import com.tencent.bugly.proguard.X;

/* loaded from: classes4.dex */
public class CrashModule extends a {
    public static final int MODULE_ID = 1004;

    /* renamed from: a */
    private static int f24581a;

    /* renamed from: b */
    private static CrashModule f24582b = new CrashModule();

    /* renamed from: c */
    private long f24583c;

    /* renamed from: d */
    private BuglyStrategy.a f24584d;

    /* renamed from: e */
    private boolean f24585e = false;

    private synchronized void a(Context context, BuglyStrategy buglyStrategy) {
        if (buglyStrategy == null) {
            return;
        }
        String libBuglySOFilePath = buglyStrategy.getLibBuglySOFilePath();
        if (!TextUtils.isEmpty(libBuglySOFilePath)) {
            com.tencent.bugly.crashreport.common.info.a.a(context).L = libBuglySOFilePath;
            X.c("setted libBugly.so file path :%s", libBuglySOFilePath);
        }
        if (buglyStrategy.getCrashHandleCallback() != null) {
            this.f24584d = buglyStrategy.getCrashHandleCallback();
            X.c("setted CrashHanldeCallback", new Object[0]);
        }
        if (buglyStrategy.getAppReportDelay() > 0) {
            long appReportDelay = buglyStrategy.getAppReportDelay();
            this.f24583c = appReportDelay;
            X.c("setted delay: %d", Long.valueOf(appReportDelay));
        }
    }

    public static CrashModule getInstance() {
        CrashModule crashModule = f24582b;
        crashModule.id = 1004;
        return crashModule;
    }

    @Override // com.tencent.bugly.a
    public String[] getTables() {
        return new String[]{"t_cr"};
    }

    public synchronized boolean hasInitialized() {
        return this.f24585e;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x008b A[Catch: all -> 0x00bd, TryCatch #0 {, blocks: (B:7:0x0003, B:10:0x0009, B:12:0x0039, B:14:0x004f, B:16:0x0055, B:17:0x0058, B:19:0x005d, B:22:0x0064, B:24:0x0074, B:27:0x007b, B:29:0x008b, B:31:0x0093, B:32:0x009a, B:37:0x0086, B:38:0x006f), top: B:6:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0093 A[Catch: all -> 0x00bd, TryCatch #0 {, blocks: (B:7:0x0003, B:10:0x0009, B:12:0x0039, B:14:0x004f, B:16:0x0055, B:17:0x0058, B:19:0x005d, B:22:0x0064, B:24:0x0074, B:27:0x007b, B:29:0x008b, B:31:0x0093, B:32:0x009a, B:37:0x0086, B:38:0x006f), top: B:6:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0098  */
    @Override // com.tencent.bugly.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void init(android.content.Context r12, boolean r13, com.tencent.bugly.BuglyStrategy r14) {
        /*
            r11 = this;
            monitor-enter(r11)
            if (r12 == 0) goto Lc0
            boolean r0 = r11.f24585e     // Catch: java.lang.Throwable -> Lbd
            if (r0 == 0) goto L9
            goto Lc0
        L9:
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r2 = "Initializing crash module."
            com.tencent.bugly.proguard.X.c(r2, r1)     // Catch: java.lang.Throwable -> Lbd
            com.tencent.bugly.proguard.H r1 = com.tencent.bugly.proguard.H.a()     // Catch: java.lang.Throwable -> Lbd
            int r2 = com.tencent.bugly.CrashModule.f24581a     // Catch: java.lang.Throwable -> Lbd
            r3 = 1
            int r2 = r2 + r3
            com.tencent.bugly.CrashModule.f24581a = r2     // Catch: java.lang.Throwable -> Lbd
            r4 = 1004(0x3ec, float:1.407E-42)
            r1.a(r4, r2)     // Catch: java.lang.Throwable -> Lbd
            r11.f24585e = r3     // Catch: java.lang.Throwable -> Lbd
            com.tencent.bugly.crashreport.CrashReport.setContext(r12)     // Catch: java.lang.Throwable -> Lbd
            r11.a(r12, r14)     // Catch: java.lang.Throwable -> Lbd
            com.tencent.bugly.BuglyStrategy$a r8 = r11.f24584d     // Catch: java.lang.Throwable -> Lbd
            r5 = 1004(0x3ec, float:1.407E-42)
            r9 = 0
            r10 = 0
            r6 = r12
            r7 = r13
            com.tencent.bugly.crashreport.crash.h r13 = com.tencent.bugly.crashreport.crash.h.a(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> Lbd
            r13.r()     // Catch: java.lang.Throwable -> Lbd
            if (r14 == 0) goto L4d
            int r1 = r14.getCallBackType()     // Catch: java.lang.Throwable -> Lbd
            r13.a(r1)     // Catch: java.lang.Throwable -> Lbd
            boolean r1 = r14.getCloseErrorCallback()     // Catch: java.lang.Throwable -> Lbd
            r13.a(r1)     // Catch: java.lang.Throwable -> Lbd
            boolean r1 = r14.isUploadSpotCrash()     // Catch: java.lang.Throwable -> Lbd
            com.tencent.bugly.crashreport.crash.h.l = r1     // Catch: java.lang.Throwable -> Lbd
        L4d:
            if (r14 == 0) goto L58
            boolean r1 = r14.isEnableCatchAnrTrace()     // Catch: java.lang.Throwable -> Lbd
            if (r1 == 0) goto L58
            r13.q()     // Catch: java.lang.Throwable -> Lbd
        L58:
            r13.a()     // Catch: java.lang.Throwable -> Lbd
            if (r14 == 0) goto L6f
            boolean r1 = r14.isEnableNativeCrashMonitor()     // Catch: java.lang.Throwable -> Lbd
            if (r1 == 0) goto L64
            goto L6f
        L64:
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r2 = "[crash] Closed native crash monitor!"
            com.tencent.bugly.proguard.X.c(r2, r1)     // Catch: java.lang.Throwable -> Lbd
            r13.e()     // Catch: java.lang.Throwable -> Lbd
            goto L72
        L6f:
            r13.s()     // Catch: java.lang.Throwable -> Lbd
        L72:
            if (r14 == 0) goto L86
            boolean r1 = r14.isEnableANRCrashMonitor()     // Catch: java.lang.Throwable -> Lbd
            if (r1 == 0) goto L7b
            goto L86
        L7b:
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r1 = "[crash] Closed ANR monitor!"
            com.tencent.bugly.proguard.X.c(r1, r0)     // Catch: java.lang.Throwable -> Lbd
            r13.c()     // Catch: java.lang.Throwable -> Lbd
            goto L89
        L86:
            r13.p()     // Catch: java.lang.Throwable -> Lbd
        L89:
            if (r14 == 0) goto L91
            boolean r0 = r14.isMerged()     // Catch: java.lang.Throwable -> Lbd
            com.tencent.bugly.crashreport.crash.h.f24858d = r0     // Catch: java.lang.Throwable -> Lbd
        L91:
            if (r14 == 0) goto L98
            long r0 = r14.getAppReportDelay()     // Catch: java.lang.Throwable -> Lbd
            goto L9a
        L98:
            r0 = 0
        L9a:
            r13.a(r0)     // Catch: java.lang.Throwable -> Lbd
            r13.u()     // Catch: java.lang.Throwable -> Lbd
            com.tencent.bugly.crashreport.crash.k.a(r12)     // Catch: java.lang.Throwable -> Lbd
            com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver r13 = com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver.getInstance()     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r14 = "android.net.conn.CONNECTIVITY_CHANGE"
            r13.addFilter(r14)     // Catch: java.lang.Throwable -> Lbd
            r13.register(r12)     // Catch: java.lang.Throwable -> Lbd
            com.tencent.bugly.proguard.H r12 = com.tencent.bugly.proguard.H.a()     // Catch: java.lang.Throwable -> Lbd
            int r13 = com.tencent.bugly.CrashModule.f24581a     // Catch: java.lang.Throwable -> Lbd
            int r13 = r13 - r3
            com.tencent.bugly.CrashModule.f24581a = r13     // Catch: java.lang.Throwable -> Lbd
            r12.a(r4, r13)     // Catch: java.lang.Throwable -> Lbd
            monitor-exit(r11)
            return
        Lbd:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        Lc0:
            monitor-exit(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.CrashModule.init(android.content.Context, boolean, com.tencent.bugly.BuglyStrategy):void");
    }

    @Override // com.tencent.bugly.a
    public void onServerStrategyChanged(StrategyBean strategyBean) {
        h g2;
        if (strategyBean == null || (g2 = h.g()) == null) {
            return;
        }
        g2.a(strategyBean);
    }
}
