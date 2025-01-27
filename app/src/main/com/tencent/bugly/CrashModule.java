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
    private static int f22058a;

    /* renamed from: b */
    private static CrashModule f22059b = new CrashModule();

    /* renamed from: c */
    private long f22060c;

    /* renamed from: d */
    private BuglyStrategy.a f22061d;

    /* renamed from: e */
    private boolean f22062e = false;

    private synchronized void a(Context context, BuglyStrategy buglyStrategy) {
        if (buglyStrategy == null) {
            return;
        }
        try {
            String libBuglySOFilePath = buglyStrategy.getLibBuglySOFilePath();
            if (!TextUtils.isEmpty(libBuglySOFilePath)) {
                com.tencent.bugly.crashreport.common.info.a.a(context).L = libBuglySOFilePath;
                X.c("setted libBugly.so file path :%s", libBuglySOFilePath);
            }
            if (buglyStrategy.getCrashHandleCallback() != null) {
                this.f22061d = buglyStrategy.getCrashHandleCallback();
                X.c("setted CrashHanldeCallback", new Object[0]);
            }
            if (buglyStrategy.getAppReportDelay() > 0) {
                long appReportDelay = buglyStrategy.getAppReportDelay();
                this.f22060c = appReportDelay;
                X.c("setted delay: %d", Long.valueOf(appReportDelay));
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static CrashModule getInstance() {
        CrashModule crashModule = f22059b;
        crashModule.f22063id = 1004;
        return crashModule;
    }

    @Override // com.tencent.bugly.a
    public String[] getTables() {
        return new String[]{"t_cr"};
    }

    public synchronized boolean hasInitialized() {
        return this.f22062e;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x008f A[Catch: all -> 0x004e, TryCatch #0 {all -> 0x004e, blocks: (B:7:0x0003, B:10:0x0009, B:12:0x0039, B:14:0x0053, B:16:0x0059, B:17:0x005c, B:19:0x0061, B:22:0x0068, B:24:0x0078, B:27:0x007f, B:29:0x008f, B:31:0x0097, B:32:0x009e, B:37:0x008a, B:38:0x0073), top: B:6:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0097 A[Catch: all -> 0x004e, TryCatch #0 {all -> 0x004e, blocks: (B:7:0x0003, B:10:0x0009, B:12:0x0039, B:14:0x0053, B:16:0x0059, B:17:0x005c, B:19:0x0061, B:22:0x0068, B:24:0x0078, B:27:0x007f, B:29:0x008f, B:31:0x0097, B:32:0x009e, B:37:0x008a, B:38:0x0073), top: B:6:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009c  */
    @Override // com.tencent.bugly.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void init(android.content.Context r12, boolean r13, com.tencent.bugly.BuglyStrategy r14) {
        /*
            r11 = this;
            monitor-enter(r11)
            if (r12 == 0) goto Lc3
            boolean r0 = r11.f22062e     // Catch: java.lang.Throwable -> L4e
            if (r0 == 0) goto L9
            goto Lc3
        L9:
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L4e
            java.lang.String r2 = "Initializing crash module."
            com.tencent.bugly.proguard.X.c(r2, r1)     // Catch: java.lang.Throwable -> L4e
            com.tencent.bugly.proguard.H r1 = com.tencent.bugly.proguard.H.a()     // Catch: java.lang.Throwable -> L4e
            int r2 = com.tencent.bugly.CrashModule.f22058a     // Catch: java.lang.Throwable -> L4e
            r3 = 1
            int r2 = r2 + r3
            com.tencent.bugly.CrashModule.f22058a = r2     // Catch: java.lang.Throwable -> L4e
            r4 = 1004(0x3ec, float:1.407E-42)
            r1.a(r4, r2)     // Catch: java.lang.Throwable -> L4e
            r11.f22062e = r3     // Catch: java.lang.Throwable -> L4e
            com.tencent.bugly.crashreport.CrashReport.setContext(r12)     // Catch: java.lang.Throwable -> L4e
            r11.a(r12, r14)     // Catch: java.lang.Throwable -> L4e
            com.tencent.bugly.BuglyStrategy$a r8 = r11.f22061d     // Catch: java.lang.Throwable -> L4e
            r9 = 0
            r10 = 0
            r5 = 1004(0x3ec, float:1.407E-42)
            r6 = r12
            r7 = r13
            com.tencent.bugly.crashreport.crash.h r13 = com.tencent.bugly.crashreport.crash.h.a(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L4e
            r13.r()     // Catch: java.lang.Throwable -> L4e
            if (r14 == 0) goto L51
            int r1 = r14.getCallBackType()     // Catch: java.lang.Throwable -> L4e
            r13.a(r1)     // Catch: java.lang.Throwable -> L4e
            boolean r1 = r14.getCloseErrorCallback()     // Catch: java.lang.Throwable -> L4e
            r13.a(r1)     // Catch: java.lang.Throwable -> L4e
            boolean r1 = r14.isUploadSpotCrash()     // Catch: java.lang.Throwable -> L4e
            com.tencent.bugly.crashreport.crash.h.f22473l = r1     // Catch: java.lang.Throwable -> L4e
            goto L51
        L4e:
            r12 = move-exception
            goto Lc1
        L51:
            if (r14 == 0) goto L5c
            boolean r1 = r14.isEnableCatchAnrTrace()     // Catch: java.lang.Throwable -> L4e
            if (r1 == 0) goto L5c
            r13.q()     // Catch: java.lang.Throwable -> L4e
        L5c:
            r13.a()     // Catch: java.lang.Throwable -> L4e
            if (r14 == 0) goto L73
            boolean r1 = r14.isEnableNativeCrashMonitor()     // Catch: java.lang.Throwable -> L4e
            if (r1 == 0) goto L68
            goto L73
        L68:
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L4e
            java.lang.String r2 = "[crash] Closed native crash monitor!"
            com.tencent.bugly.proguard.X.c(r2, r1)     // Catch: java.lang.Throwable -> L4e
            r13.e()     // Catch: java.lang.Throwable -> L4e
            goto L76
        L73:
            r13.s()     // Catch: java.lang.Throwable -> L4e
        L76:
            if (r14 == 0) goto L8a
            boolean r1 = r14.isEnableANRCrashMonitor()     // Catch: java.lang.Throwable -> L4e
            if (r1 == 0) goto L7f
            goto L8a
        L7f:
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L4e
            java.lang.String r1 = "[crash] Closed ANR monitor!"
            com.tencent.bugly.proguard.X.c(r1, r0)     // Catch: java.lang.Throwable -> L4e
            r13.c()     // Catch: java.lang.Throwable -> L4e
            goto L8d
        L8a:
            r13.p()     // Catch: java.lang.Throwable -> L4e
        L8d:
            if (r14 == 0) goto L95
            boolean r0 = r14.isMerged()     // Catch: java.lang.Throwable -> L4e
            com.tencent.bugly.crashreport.crash.h.f22465d = r0     // Catch: java.lang.Throwable -> L4e
        L95:
            if (r14 == 0) goto L9c
            long r0 = r14.getAppReportDelay()     // Catch: java.lang.Throwable -> L4e
            goto L9e
        L9c:
            r0 = 0
        L9e:
            r13.a(r0)     // Catch: java.lang.Throwable -> L4e
            r13.u()     // Catch: java.lang.Throwable -> L4e
            com.tencent.bugly.crashreport.crash.k.a(r12)     // Catch: java.lang.Throwable -> L4e
            com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver r13 = com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver.getInstance()     // Catch: java.lang.Throwable -> L4e
            java.lang.String r14 = "android.net.conn.CONNECTIVITY_CHANGE"
            r13.addFilter(r14)     // Catch: java.lang.Throwable -> L4e
            r13.register(r12)     // Catch: java.lang.Throwable -> L4e
            com.tencent.bugly.proguard.H r12 = com.tencent.bugly.proguard.H.a()     // Catch: java.lang.Throwable -> L4e
            int r13 = com.tencent.bugly.CrashModule.f22058a     // Catch: java.lang.Throwable -> L4e
            int r13 = r13 - r3
            com.tencent.bugly.CrashModule.f22058a = r13     // Catch: java.lang.Throwable -> L4e
            r12.a(r4, r13)     // Catch: java.lang.Throwable -> L4e
            monitor-exit(r11)
            return
        Lc1:
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L4e
            throw r12
        Lc3:
            monitor-exit(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.CrashModule.init(android.content.Context, boolean, com.tencent.bugly.BuglyStrategy):void");
    }

    @Override // com.tencent.bugly.a
    public void onServerStrategyChanged(StrategyBean strategyBean) {
        h g10;
        if (strategyBean == null || (g10 = h.g()) == null) {
            return;
        }
        g10.a(strategyBean);
    }
}
