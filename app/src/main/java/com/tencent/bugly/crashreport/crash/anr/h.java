package com.tencent.bugly.crashreport.crash.anr;

import android.app.ActivityManager;
import android.content.Context;
import android.os.FileObserver;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.anr.TraceFileHelper;
import com.tencent.bugly.proguard.J;
import com.tencent.bugly.proguard.W;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ba;
import com.tencent.bugly.proguard.ca;
import com.tencent.bugly.proguard.da;
import com.tencent.bugly.proguard.ea;
import com.tencent.bugly.proguard.fa;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class h implements fa {

    /* renamed from: a */
    private static h f22420a;

    /* renamed from: d */
    private final Context f22423d;

    /* renamed from: e */
    private final com.tencent.bugly.crashreport.common.info.a f22424e;

    /* renamed from: f */
    private final W f22425f;

    /* renamed from: g */
    private final com.tencent.bugly.crashreport.common.strategy.c f22426g;

    /* renamed from: h */
    private String f22427h;

    /* renamed from: i */
    private final com.tencent.bugly.crashreport.crash.e f22428i;

    /* renamed from: j */
    private FileObserver f22429j;

    /* renamed from: l */
    private ea f22431l;

    /* renamed from: m */
    private int f22432m;

    /* renamed from: b */
    private AtomicInteger f22421b = new AtomicInteger(0);

    /* renamed from: c */
    private long f22422c = -1;

    /* renamed from: k */
    private boolean f22430k = true;

    /* renamed from: n */
    private ActivityManager.ProcessErrorStateInfo f22433n = new ActivityManager.ProcessErrorStateInfo();

    private h(Context context, com.tencent.bugly.crashreport.common.strategy.c cVar, com.tencent.bugly.crashreport.common.info.a aVar, W w10, J j10, com.tencent.bugly.crashreport.crash.e eVar, BuglyStrategy.a aVar2) {
        this.f22423d = ca.a(context);
        this.f22427h = context.getDir("bugly", 0).getAbsolutePath();
        this.f22424e = aVar;
        this.f22425f = w10;
        this.f22426g = cVar;
        this.f22428i = eVar;
    }

    private boolean h() {
        ea eaVar = this.f22431l;
        if (eaVar != null && eaVar.isAlive()) {
            return false;
        }
        ea eaVar2 = new ea();
        this.f22431l = eaVar2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Bugly-ThreadMonitor");
        int i10 = this.f22432m;
        this.f22432m = i10 + 1;
        sb2.append(i10);
        eaVar2.setName(sb2.toString());
        this.f22431l.a();
        this.f22431l.a(this);
        boolean c10 = this.f22431l.c();
        this.f22425f.a(new e(this));
        return c10;
    }

    private synchronized void i() {
        if (a()) {
            X.e("start when started!", new Object[0]);
            return;
        }
        if (TextUtils.isEmpty(this.f22427h)) {
            return;
        }
        h();
        f fVar = new f(this, this.f22427h, 256);
        this.f22429j = fVar;
        try {
            fVar.startWatching();
            X.c("startWatchingPrivateAnrDir! dumFilePath is %s", this.f22427h);
            this.f22425f.a(new g(this));
        } catch (Throwable th2) {
            this.f22429j = null;
            X.e("startWatchingPrivateAnrDir failed!", new Object[0]);
            if (!X.b(th2)) {
                th2.printStackTrace();
            }
        }
    }

    private boolean j() {
        ea eaVar = this.f22431l;
        if (eaVar == null) {
            return false;
        }
        boolean d10 = eaVar.d();
        this.f22431l.b();
        this.f22431l.b(this);
        this.f22431l = null;
        return d10;
    }

    private synchronized void k() {
        if (!a()) {
            X.e("close when closed!", new Object[0]);
            return;
        }
        j();
        X.c("stopWatchingPrivateAnrDir", new Object[0]);
        try {
            this.f22429j.stopWatching();
            this.f22429j = null;
            X.e("close anr monitor!", new Object[0]);
        } catch (Throwable th2) {
            X.e("stop anr monitor failed!", new Object[0]);
            if (!X.b(th2)) {
                th2.printStackTrace();
            }
        }
    }

    private File l() {
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(this.f22427h);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    return null;
                }
                for (File file2 : listFiles) {
                    String name = file2.getName();
                    if (name.startsWith("jni_mannual_bugly_trace_")) {
                        try {
                            int indexOf = name.indexOf(rb.b.f30387c);
                            if (indexOf > 0) {
                                long parseLong = Long.parseLong(name.substring(24, indexOf));
                                long j10 = (currentTimeMillis - parseLong) / 1000;
                                X.a("current time %d trace time is %d s", Long.valueOf(currentTimeMillis), Long.valueOf(parseLong));
                                X.a("current time minus trace time is %d s", Long.valueOf(j10));
                                if (j10 < 30) {
                                    return file2;
                                }
                            } else {
                                continue;
                            }
                        } catch (Throwable unused) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Trace file that has invalid format: ");
                            sb2.append(name);
                            X.a(sb2.toString(), new Object[0]);
                        }
                    }
                }
            } catch (Throwable th2) {
                X.b(th2);
                return null;
            }
        }
        return null;
    }

    public synchronized boolean c() {
        return this.f22430k;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0095 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d() {
        /*
            r15 = this;
            java.lang.String r0 = "bugly_trace_"
            long r1 = com.tencent.bugly.proguard.ca.b()
            long r3 = com.tencent.bugly.crashreport.crash.h.f22468g
            long r1 = r1 - r3
            java.io.File r3 = new java.io.File
            java.lang.String r4 = r15.f22427h
            r3.<init>(r4)
            boolean r4 = r3.exists()
            if (r4 == 0) goto Lb4
            boolean r4 = r3.isDirectory()
            if (r4 == 0) goto Lb4
            java.io.File[] r3 = r3.listFiles()     // Catch: java.lang.Throwable -> L93
            if (r3 == 0) goto Lb0
            int r4 = r3.length     // Catch: java.lang.Throwable -> L93
            if (r4 != 0) goto L27
            goto Lb0
        L27:
            java.lang.String r4 = ".txt"
            int r5 = r3.length     // Catch: java.lang.Throwable -> L93
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
        L2e:
            if (r7 >= r5) goto L99
            r10 = r3[r7]     // Catch: java.lang.Throwable -> L93
            java.lang.String r11 = r10.getName()     // Catch: java.lang.Throwable -> L93
            boolean r12 = r11.startsWith(r0)     // Catch: java.lang.Throwable -> L93
            if (r12 == 0) goto L3d
            goto L43
        L3d:
            boolean r12 = r11.startsWith(r0)     // Catch: java.lang.Throwable -> L93
            if (r12 == 0) goto L47
        L43:
            r9 = 1
            r12 = 12
            goto L49
        L47:
            r12 = r9
            r9 = 0
        L49:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L93
            r13.<init>()     // Catch: java.lang.Throwable -> L93
            java.lang.String r14 = "Number Trace file : "
            r13.append(r14)     // Catch: java.lang.Throwable -> L93
            r13.append(r11)     // Catch: java.lang.Throwable -> L93
            java.lang.String r13 = r13.toString()     // Catch: java.lang.Throwable -> L93
            java.lang.Object[] r14 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> L93
            com.tencent.bugly.proguard.X.a(r13, r14)     // Catch: java.lang.Throwable -> L93
            if (r9 == 0) goto L95
            int r9 = r11.indexOf(r4)     // Catch: java.lang.Throwable -> L74
            if (r9 <= 0) goto L8a
            java.lang.String r9 = r11.substring(r12, r9)     // Catch: java.lang.Throwable -> L74
            long r13 = java.lang.Long.parseLong(r9)     // Catch: java.lang.Throwable -> L74
            int r9 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r9 < 0) goto L8a
            goto L95
        L74:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L93
            r9.<init>()     // Catch: java.lang.Throwable -> L93
            java.lang.String r13 = "Trace file that has invalid format: "
            r9.append(r13)     // Catch: java.lang.Throwable -> L93
            r9.append(r11)     // Catch: java.lang.Throwable -> L93
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> L93
            java.lang.Object[] r11 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> L93
            com.tencent.bugly.proguard.X.a(r9, r11)     // Catch: java.lang.Throwable -> L93
        L8a:
            boolean r9 = r10.delete()     // Catch: java.lang.Throwable -> L93
            if (r9 == 0) goto L95
            int r8 = r8 + 1
            goto L95
        L93:
            r0 = move-exception
            goto Lb1
        L95:
            int r7 = r7 + 1
            r9 = r12
            goto L2e
        L99:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L93
            r0.<init>()     // Catch: java.lang.Throwable -> L93
            java.lang.String r1 = "Number of overdue trace files that has deleted: "
            r0.append(r1)     // Catch: java.lang.Throwable -> L93
            r0.append(r8)     // Catch: java.lang.Throwable -> L93
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L93
            java.lang.Object[] r1 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> L93
            com.tencent.bugly.proguard.X.a(r0, r1)     // Catch: java.lang.Throwable -> L93
            goto Lb4
        Lb0:
            return
        Lb1:
            com.tencent.bugly.proguard.X.b(r0)
        Lb4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.anr.h.d():void");
    }

    public synchronized void e() {
        if (a()) {
            X.e("start when started!", new Object[0]);
            return;
        }
        c cVar = new c(this, "/data/anr/", 8);
        this.f22429j = cVar;
        try {
            cVar.startWatching();
            X.c("start anr monitor!", new Object[0]);
            this.f22425f.a(new d(this));
        } catch (Throwable th2) {
            this.f22429j = null;
            X.e("start anr monitor failed!", new Object[0]);
            if (!X.b(th2)) {
                th2.printStackTrace();
            }
        }
    }

    public synchronized void f() {
        if (!a()) {
            X.e("close when closed!", new Object[0]);
            return;
        }
        try {
            this.f22429j.stopWatching();
            this.f22429j = null;
            X.e("close anr monitor!", new Object[0]);
        } catch (Throwable th2) {
            X.e("stop anr monitor failed!", new Object[0]);
            if (!X.b(th2)) {
                th2.printStackTrace();
            }
        }
    }

    public void g() {
        int i10 = 0;
        while (true) {
            int i11 = i10 + 1;
            if (i10 >= 30) {
                return;
            }
            try {
                X.c("try main sleep for make a test anr! try:%d/30 , kill it if you don't want to wait!", Integer.valueOf(i11));
                ca.c(5000L);
                i10 = i11;
            } catch (Throwable th2) {
                if (X.b(th2)) {
                    return;
                }
                th2.printStackTrace();
                return;
            }
        }
    }

    private synchronized void c(boolean z10) {
        if (this.f22430k != z10) {
            X.c("user change anr %b", Boolean.valueOf(z10));
            this.f22430k = z10;
        }
    }

    public boolean b() {
        return this.f22421b.get() != 0;
    }

    public static h a(Context context, com.tencent.bugly.crashreport.common.strategy.c cVar, com.tencent.bugly.crashreport.common.info.a aVar, W w10, J j10, com.tencent.bugly.crashreport.crash.e eVar, BuglyStrategy.a aVar2) {
        if (f22420a == null) {
            f22420a = new h(context, cVar, aVar, w10, j10, eVar, aVar2);
        }
        return f22420a;
    }

    public void b(boolean z10) {
        c(z10);
        boolean c10 = c();
        com.tencent.bugly.crashreport.common.strategy.c b10 = com.tencent.bugly.crashreport.common.strategy.c.b();
        if (b10 != null) {
            c10 = c10 && b10.c().f22342f;
        }
        if (c10 != a()) {
            X.c("anr changed to %b", Boolean.valueOf(c10));
            a(c10);
        }
    }

    public ActivityManager.ProcessErrorStateInfo a(Context context, long j10) {
        if (j10 < 0) {
            j10 = 0;
        }
        try {
            X.a("to find!", new Object[0]);
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            long j11 = j10 / 500;
            int i10 = 0;
            while (true) {
                X.a("waiting!", new Object[0]);
                List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
                if (processesInErrorState != null) {
                    for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                        if (processErrorStateInfo.condition == 2) {
                            X.a("found!", new Object[0]);
                            return processErrorStateInfo;
                        }
                    }
                }
                ca.c(500L);
                int i11 = i10 + 1;
                if (i10 >= j11) {
                    X.a("end!", new Object[0]);
                    return null;
                }
                i10 = i11;
            }
        } catch (Exception e10) {
            X.a(e10);
            return null;
        } catch (OutOfMemoryError e11) {
            this.f22433n.pid = Process.myPid();
            this.f22433n.shortMsg = "bugly sdk waitForAnrProcessStateChanged encount error:" + e11.getMessage();
            return this.f22433n;
        }
    }

    public boolean b(String str) {
        return str.startsWith("bugly_trace_");
    }

    public a a(Context context, ActivityManager.ProcessErrorStateInfo processErrorStateInfo, long j10, Map<String, String> map) {
        a aVar = new a();
        aVar.f22408c = j10;
        aVar.f22406a = processErrorStateInfo != null ? processErrorStateInfo.processName : AppInfo.a(context, Process.myPid());
        aVar.f22411f = processErrorStateInfo != null ? processErrorStateInfo.shortMsg : "";
        aVar.f22410e = processErrorStateInfo != null ? processErrorStateInfo.longMsg : "";
        aVar.f22407b = map;
        Thread thread = Looper.getMainLooper().getThread();
        if (map != null) {
            Iterator<String> it = map.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (next.startsWith(thread.getName())) {
                    aVar.f22412g = map.get(next);
                    break;
                }
            }
        }
        if (TextUtils.isEmpty(aVar.f22412g)) {
            aVar.f22412g = "main stack is null , some error may be encountered.";
        }
        Long valueOf = Long.valueOf(aVar.f22408c);
        String str = aVar.f22409d;
        String str2 = aVar.f22406a;
        String str3 = aVar.f22412g;
        String str4 = aVar.f22411f;
        String str5 = aVar.f22410e;
        Map<String, String> map2 = aVar.f22407b;
        X.a("anr tm:%d\ntr:%s\nproc:%s\nmain stack:%s\nsMsg:%s\n lMsg:%s\n threads:%d", valueOf, str, str2, str3, str4, str5, Integer.valueOf(map2 == null ? 0 : map2.size()));
        return aVar;
    }

    public CrashDetailBean a(a aVar) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        try {
            crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.h();
            crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.j();
            crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.g();
            crashDetailBean.F = this.f22424e.v();
            crashDetailBean.G = this.f22424e.w();
            crashDetailBean.H = this.f22424e.x();
            if (!com.tencent.bugly.crashreport.common.info.b.i(this.f22423d)) {
                crashDetailBean.f22396w = ca.a(this.f22423d, com.tencent.bugly.crashreport.crash.h.f22466e, com.tencent.bugly.crashreport.crash.h.f22469h);
            }
            crashDetailBean.f22375b = 3;
            crashDetailBean.f22378e = this.f22424e.l();
            com.tencent.bugly.crashreport.common.info.a aVar2 = this.f22424e;
            crashDetailBean.f22379f = aVar2.E;
            crashDetailBean.f22380g = aVar2.i();
            crashDetailBean.f22386m = this.f22424e.y();
            crashDetailBean.f22387n = "ANR_EXCEPTION";
            crashDetailBean.f22388o = aVar.f22411f;
            crashDetailBean.f22390q = aVar.f22412g;
            HashMap hashMap = new HashMap();
            crashDetailBean.Q = hashMap;
            hashMap.put("BUGLY_CR_01", aVar.f22410e);
            String str = crashDetailBean.f22390q;
            int indexOf = str != null ? str.indexOf("\n") : -1;
            crashDetailBean.f22389p = indexOf > 0 ? crashDetailBean.f22390q.substring(0, indexOf) : "GET_FAIL";
            crashDetailBean.f22391r = aVar.f22408c;
            String str2 = crashDetailBean.f22390q;
            if (str2 != null) {
                crashDetailBean.f22394u = ca.c(str2.getBytes());
            }
            crashDetailBean.f22399z = aVar.f22407b;
            crashDetailBean.A = aVar.f22406a;
            crashDetailBean.B = "main(1)";
            crashDetailBean.I = this.f22424e.r();
            crashDetailBean.f22381h = this.f22424e.p();
            crashDetailBean.f22382i = this.f22424e.o();
            crashDetailBean.f22395v = aVar.f22409d;
            com.tencent.bugly.crashreport.common.info.a aVar3 = this.f22424e;
            crashDetailBean.M = aVar3.M;
            crashDetailBean.N = aVar3.f22288d;
            crashDetailBean.O = aVar3.C();
            if (!com.tencent.bugly.crashreport.common.info.b.i(this.f22423d)) {
                this.f22428i.d(crashDetailBean);
            }
            crashDetailBean.R = this.f22424e.A();
            crashDetailBean.S = this.f22424e.t();
            crashDetailBean.T = this.f22424e.h();
            crashDetailBean.U = this.f22424e.g();
            crashDetailBean.f22398y = ba.b();
        } catch (Throwable th2) {
            if (!X.b(th2)) {
                th2.printStackTrace();
            }
        }
        return crashDetailBean;
    }

    public boolean a(String str, String str2, String str3) {
        Map<String, String[]> map;
        TraceFileHelper.a readTargetDumpInfo = TraceFileHelper.readTargetDumpInfo(str3, str, true);
        if (readTargetDumpInfo != null && (map = readTargetDumpInfo.f22405d) != null && map.size() > 0) {
            File file = new File(str2);
            try {
                if (!file.exists()) {
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                }
                if (file.exists() && file.canWrite()) {
                    BufferedWriter bufferedWriter = null;
                    try {
                        try {
                            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file, false));
                            try {
                                String[] strArr = readTargetDumpInfo.f22405d.get("main");
                                int i10 = 3;
                                if (strArr != null && strArr.length >= 3) {
                                    String str4 = strArr[0];
                                    String str5 = strArr[1];
                                    String str6 = strArr[2];
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("\"main\" tid=");
                                    sb2.append(str6);
                                    sb2.append(" :\n");
                                    sb2.append(str4);
                                    sb2.append("\n");
                                    sb2.append(str5);
                                    sb2.append("\n\n");
                                    bufferedWriter2.write(sb2.toString());
                                    bufferedWriter2.flush();
                                }
                                for (Map.Entry<String, String[]> entry : readTargetDumpInfo.f22405d.entrySet()) {
                                    if (!entry.getKey().equals("main") && entry.getValue() != null && entry.getValue().length >= i10) {
                                        String str7 = entry.getValue()[0];
                                        String str8 = entry.getValue()[1];
                                        String str9 = entry.getValue()[2];
                                        StringBuilder sb3 = new StringBuilder();
                                        sb3.append("\"");
                                        sb3.append(entry.getKey());
                                        sb3.append("\" tid=");
                                        sb3.append(str9);
                                        sb3.append(" :\n");
                                        sb3.append(str7);
                                        sb3.append("\n");
                                        sb3.append(str8);
                                        sb3.append("\n\n");
                                        bufferedWriter2.write(sb3.toString());
                                        bufferedWriter2.flush();
                                        i10 = 3;
                                    }
                                }
                                try {
                                    bufferedWriter2.close();
                                } catch (IOException e10) {
                                    if (!X.b(e10)) {
                                        e10.printStackTrace();
                                    }
                                }
                                return true;
                            } catch (IOException e11) {
                                e = e11;
                                bufferedWriter = bufferedWriter2;
                                if (!X.b(e)) {
                                    e.printStackTrace();
                                }
                                X.b("dump trace fail %s", e.getClass().getName() + ":" + e.getMessage());
                                if (bufferedWriter != null) {
                                    try {
                                        bufferedWriter.close();
                                    } catch (IOException e12) {
                                        if (!X.b(e12)) {
                                            e12.printStackTrace();
                                        }
                                    }
                                }
                                return false;
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedWriter = bufferedWriter2;
                                BufferedWriter bufferedWriter3 = bufferedWriter;
                                Throwable th3 = th;
                                if (bufferedWriter3 != null) {
                                    try {
                                        bufferedWriter3.close();
                                        throw th3;
                                    } catch (IOException e13) {
                                        if (!X.b(e13)) {
                                            e13.printStackTrace();
                                            throw th3;
                                        }
                                        throw th3;
                                    }
                                }
                                throw th3;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } catch (IOException e14) {
                        e = e14;
                    }
                } else {
                    X.b("backup file create fail %s", str2);
                    return false;
                }
            } catch (Exception e15) {
                if (!X.b(e15)) {
                    e15.printStackTrace();
                }
                X.b("backup file create error! %s  %s", e15.getClass().getName() + ":" + e15.getMessage(), str2);
                return false;
            }
        } else {
            X.b("not found trace dump for %s", str3);
            return false;
        }
    }

    public boolean a(Context context, String str, ActivityManager.ProcessErrorStateInfo processErrorStateInfo, long j10, Map<String, String> map) {
        a a10 = a(context, processErrorStateInfo, j10, map);
        X.c("found visiable anr , start to upload!", new Object[0]);
        CrashDetailBean a11 = a(a10);
        if (a11 == null) {
            X.b("pack anr fail!", new Object[0]);
            return false;
        }
        com.tencent.bugly.crashreport.crash.h.g().a(a11);
        if (a11.f22374a >= 0) {
            X.c("backup anr record success!", new Object[0]);
        } else {
            X.e("backup anr record fail!", new Object[0]);
        }
        if (str != null && new File(str).exists()) {
            a10.f22409d = new File(this.f22427h, "bugly_trace_" + j10 + rb.b.f30387c).getAbsolutePath();
            this.f22421b.set(3);
            if (a(str, a10.f22409d, a10.f22406a)) {
                X.c("backup trace success", new Object[0]);
            }
        } else {
            File l10 = l();
            X.c("traceFile is %s", l10);
            if (l10 != null) {
                a11.f22395v = l10.getAbsolutePath();
            }
        }
        com.tencent.bugly.crashreport.crash.e.a("ANR", ca.a(), a10.f22406a, "main", a10.f22412g, a11);
        if (!this.f22428i.c(a11)) {
            this.f22428i.a(a11, 3000L, true);
        }
        this.f22428i.e(a11);
        return true;
    }

    public final void a(String str) {
        long j10;
        synchronized (this) {
            try {
                if (this.f22421b.get() != 0) {
                    X.a("trace started return ", new Object[0]);
                    return;
                }
                this.f22421b.set(1);
                try {
                    X.a("read trace first dump for create time!", new Object[0]);
                    TraceFileHelper.a readFirstDumpInfo = TraceFileHelper.readFirstDumpInfo(str, false);
                    long j11 = readFirstDumpInfo != null ? readFirstDumpInfo.f22404c : -1L;
                    if (j11 == -1) {
                        X.e("trace dump fail could not get time!", new Object[0]);
                        j11 = System.currentTimeMillis();
                    }
                    j10 = j11;
                } finally {
                    try {
                    } finally {
                    }
                }
                if (Math.abs(j10 - this.f22422c) < 10000) {
                    X.e("should not process ANR too Fre in %d", 10000);
                    return;
                }
                this.f22422c = j10;
                this.f22421b.set(1);
                try {
                    Map<String, String> a10 = ca.a(com.tencent.bugly.crashreport.crash.h.f22467f, false);
                    if (a10 != null && a10.size() > 0) {
                        ActivityManager.ProcessErrorStateInfo a11 = a(this.f22423d, 20000L);
                        this.f22433n = a11;
                        if (a11 == null) {
                            X.a("proc state is unvisiable!", new Object[0]);
                            return;
                        } else if (a11.pid != Process.myPid()) {
                            X.a("not mind proc!", this.f22433n.processName);
                            return;
                        } else {
                            X.c("found visiable anr , start to process!", new Object[0]);
                            a(this.f22423d, str, this.f22433n, j10, a10);
                            return;
                        }
                    }
                    X.e("can't get all thread skip this anr", new Object[0]);
                } catch (Throwable th2) {
                    X.b(th2);
                    X.b("get all thread stack fail!", new Object[0]);
                }
            } finally {
            }
        }
    }

    public synchronized boolean a() {
        return this.f22429j != null;
    }

    public synchronized void a(boolean z10) {
        try {
            if (z10) {
                i();
            } else {
                k();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void a(StrategyBean strategyBean) {
        X.e("customer decides whether to open or close.", new Object[0]);
    }

    @Override // com.tencent.bugly.proguard.fa
    public boolean a(da daVar) {
        Map<String, String> hashMap = new HashMap<>();
        if (daVar.b().equals(Looper.getMainLooper())) {
            try {
                hashMap = ca.a(200000, false);
            } catch (Throwable th2) {
                X.a(th2);
                hashMap.put("main", th2.getMessage());
            }
            Map<String, String> map = hashMap;
            X.a("onThreadBlock found visiable anr , start to process!", new Object[0]);
            String d10 = com.tencent.bugly.crashreport.common.info.b.d(this.f22423d);
            if (!TextUtils.isEmpty(d10) && (d10.contains("XiaoMi") || d10.contains("samsung"))) {
                this.f22433n = a(this.f22423d, 20000L);
            }
            a(this.f22423d, "", this.f22433n, System.currentTimeMillis(), map);
        } else {
            X.a("anr handler onThreadBlock only care main thread ,current thread is: %s", daVar.c());
        }
        return true;
    }
}
