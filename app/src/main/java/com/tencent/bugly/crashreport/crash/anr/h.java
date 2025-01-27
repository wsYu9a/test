package com.tencent.bugly.crashreport.crash.anr;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
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
    private static h f24817a;

    /* renamed from: d */
    private final Context f24820d;

    /* renamed from: e */
    private final com.tencent.bugly.crashreport.common.info.a f24821e;

    /* renamed from: f */
    private final W f24822f;

    /* renamed from: g */
    private final com.tencent.bugly.crashreport.common.strategy.c f24823g;

    /* renamed from: h */
    private String f24824h;

    /* renamed from: i */
    private final com.tencent.bugly.crashreport.crash.e f24825i;

    /* renamed from: j */
    private FileObserver f24826j;
    private ea l;
    private int m;

    /* renamed from: b */
    private AtomicInteger f24818b = new AtomicInteger(0);

    /* renamed from: c */
    private long f24819c = -1;
    private boolean k = true;
    private ActivityManager.ProcessErrorStateInfo n = new ActivityManager.ProcessErrorStateInfo();

    private h(Context context, com.tencent.bugly.crashreport.common.strategy.c cVar, com.tencent.bugly.crashreport.common.info.a aVar, W w, J j2, com.tencent.bugly.crashreport.crash.e eVar, BuglyStrategy.a aVar2) {
        this.f24820d = ca.a(context);
        this.f24824h = context.getDir("bugly", 0).getAbsolutePath();
        this.f24821e = aVar;
        this.f24822f = w;
        this.f24823g = cVar;
        this.f24825i = eVar;
    }

    private boolean h() {
        ea eaVar = this.l;
        if (eaVar != null && eaVar.isAlive()) {
            return false;
        }
        ea eaVar2 = new ea();
        this.l = eaVar2;
        StringBuilder sb = new StringBuilder();
        sb.append("Bugly-ThreadMonitor");
        int i2 = this.m;
        this.m = i2 + 1;
        sb.append(i2);
        eaVar2.setName(sb.toString());
        this.l.a();
        this.l.a(this);
        boolean c2 = this.l.c();
        this.f24822f.a(new e(this));
        return c2;
    }

    private synchronized void i() {
        if (a()) {
            X.e("start when started!", new Object[0]);
            return;
        }
        if (TextUtils.isEmpty(this.f24824h)) {
            return;
        }
        h();
        f fVar = new f(this, this.f24824h, 256);
        this.f24826j = fVar;
        try {
            fVar.startWatching();
            X.c("startWatchingPrivateAnrDir! dumFilePath is %s", this.f24824h);
            this.f24822f.a(new g(this));
        } catch (Throwable th) {
            this.f24826j = null;
            X.e("startWatchingPrivateAnrDir failed!", new Object[0]);
            if (!X.b(th)) {
                th.printStackTrace();
            }
        }
    }

    private boolean j() {
        ea eaVar = this.l;
        if (eaVar == null) {
            return false;
        }
        boolean d2 = eaVar.d();
        this.l.b();
        this.l.b(this);
        this.l = null;
        return d2;
    }

    private synchronized void k() {
        if (!a()) {
            X.e("close when closed!", new Object[0]);
            return;
        }
        j();
        X.c("stopWatchingPrivateAnrDir", new Object[0]);
        try {
            this.f24826j.stopWatching();
            this.f24826j = null;
            X.e("close anr monitor!", new Object[0]);
        } catch (Throwable th) {
            X.e("stop anr monitor failed!", new Object[0]);
            if (!X.b(th)) {
                th.printStackTrace();
            }
        }
    }

    private File l() {
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(this.f24824h);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    return null;
                }
                int i2 = 24;
                int length = listFiles.length;
                int i3 = 0;
                while (i3 < length) {
                    File file2 = listFiles[i3];
                    String name = file2.getName();
                    if (name.startsWith("jni_mannual_bugly_trace_")) {
                        try {
                            int indexOf = name.indexOf(com.martian.mibook.lib.local.c.b.b.f13935b);
                            if (indexOf > 0) {
                                long parseLong = Long.parseLong(name.substring(i2, indexOf));
                                long j2 = (currentTimeMillis - parseLong) / 1000;
                                X.a("current time %d trace time is %d s", Long.valueOf(currentTimeMillis), Long.valueOf(parseLong));
                                X.a("current time minus trace time is %d s", Long.valueOf(j2));
                                if (j2 < 30) {
                                    return file2;
                                }
                            } else {
                                continue;
                            }
                        } catch (Throwable unused) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Trace file that has invalid format: ");
                            sb.append(name);
                            X.a(sb.toString(), new Object[0]);
                        }
                    }
                    i3++;
                    i2 = 24;
                }
            } catch (Throwable th) {
                X.b(th);
                return null;
            }
        }
        return null;
    }

    public synchronized boolean c() {
        return this.k;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0091 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void d() {
        /*
            r15 = this;
            java.lang.String r0 = "bugly_trace_"
            long r1 = com.tencent.bugly.proguard.ca.b()
            long r3 = com.tencent.bugly.crashreport.crash.h.f24861g
            long r1 = r1 - r3
            java.io.File r3 = new java.io.File
            java.lang.String r4 = r15.f24824h
            r3.<init>(r4)
            boolean r4 = r3.exists()
            if (r4 == 0) goto Lb0
            boolean r4 = r3.isDirectory()
            if (r4 == 0) goto Lb0
            java.io.File[] r3 = r3.listFiles()     // Catch: java.lang.Throwable -> Lac
            if (r3 == 0) goto Lab
            int r4 = r3.length     // Catch: java.lang.Throwable -> Lac
            if (r4 != 0) goto L27
            goto Lab
        L27:
            java.lang.String r4 = ".txt"
            int r5 = r3.length     // Catch: java.lang.Throwable -> Lac
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
        L2e:
            if (r7 >= r5) goto L94
            r10 = r3[r7]     // Catch: java.lang.Throwable -> Lac
            java.lang.String r11 = r10.getName()     // Catch: java.lang.Throwable -> Lac
            boolean r12 = r11.startsWith(r0)     // Catch: java.lang.Throwable -> Lac
            if (r12 == 0) goto L3d
            goto L43
        L3d:
            boolean r12 = r11.startsWith(r0)     // Catch: java.lang.Throwable -> Lac
            if (r12 == 0) goto L47
        L43:
            r9 = 12
            r12 = 1
            goto L48
        L47:
            r12 = 0
        L48:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lac
            r13.<init>()     // Catch: java.lang.Throwable -> Lac
            java.lang.String r14 = "Number Trace file : "
            r13.append(r14)     // Catch: java.lang.Throwable -> Lac
            r13.append(r11)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r13 = r13.toString()     // Catch: java.lang.Throwable -> Lac
            java.lang.Object[] r14 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> Lac
            com.tencent.bugly.proguard.X.a(r13, r14)     // Catch: java.lang.Throwable -> Lac
            if (r12 == 0) goto L91
            int r12 = r11.indexOf(r4)     // Catch: java.lang.Throwable -> L73
            if (r12 <= 0) goto L89
            java.lang.String r12 = r11.substring(r9, r12)     // Catch: java.lang.Throwable -> L73
            long r11 = java.lang.Long.parseLong(r12)     // Catch: java.lang.Throwable -> L73
            int r13 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r13 < 0) goto L89
            goto L91
        L73:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lac
            r12.<init>()     // Catch: java.lang.Throwable -> Lac
            java.lang.String r13 = "Trace file that has invalid format: "
            r12.append(r13)     // Catch: java.lang.Throwable -> Lac
            r12.append(r11)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r11 = r12.toString()     // Catch: java.lang.Throwable -> Lac
            java.lang.Object[] r12 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> Lac
            com.tencent.bugly.proguard.X.a(r11, r12)     // Catch: java.lang.Throwable -> Lac
        L89:
            boolean r10 = r10.delete()     // Catch: java.lang.Throwable -> Lac
            if (r10 == 0) goto L91
            int r8 = r8 + 1
        L91:
            int r7 = r7 + 1
            goto L2e
        L94:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lac
            r0.<init>()     // Catch: java.lang.Throwable -> Lac
            java.lang.String r1 = "Number of overdue trace files that has deleted: "
            r0.append(r1)     // Catch: java.lang.Throwable -> Lac
            r0.append(r8)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Lac
            java.lang.Object[] r1 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> Lac
            com.tencent.bugly.proguard.X.a(r0, r1)     // Catch: java.lang.Throwable -> Lac
            goto Lb0
        Lab:
            return
        Lac:
            r0 = move-exception
            com.tencent.bugly.proguard.X.b(r0)
        Lb0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.anr.h.d():void");
    }

    protected synchronized void e() {
        if (a()) {
            X.e("start when started!", new Object[0]);
            return;
        }
        c cVar = new c(this, "/data/anr/", 8);
        this.f24826j = cVar;
        try {
            cVar.startWatching();
            X.c("start anr monitor!", new Object[0]);
            this.f24822f.a(new d(this));
        } catch (Throwable th) {
            this.f24826j = null;
            X.e("start anr monitor failed!", new Object[0]);
            if (!X.b(th)) {
                th.printStackTrace();
            }
        }
    }

    protected synchronized void f() {
        if (!a()) {
            X.e("close when closed!", new Object[0]);
            return;
        }
        try {
            this.f24826j.stopWatching();
            this.f24826j = null;
            X.e("close anr monitor!", new Object[0]);
        } catch (Throwable th) {
            X.e("stop anr monitor failed!", new Object[0]);
            if (!X.b(th)) {
                th.printStackTrace();
            }
        }
    }

    public void g() {
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i2 >= 30) {
                return;
            }
            try {
                X.c("try main sleep for make a test anr! try:%d/30 , kill it if you don't want to wait!", Integer.valueOf(i3));
                ca.c(5000L);
                i2 = i3;
            } catch (Throwable th) {
                if (X.b(th)) {
                    return;
                }
                th.printStackTrace();
                return;
            }
        }
    }

    private synchronized void c(boolean z) {
        if (this.k != z) {
            X.c("user change anr %b", Boolean.valueOf(z));
            this.k = z;
        }
    }

    public boolean b() {
        return this.f24818b.get() != 0;
    }

    public static h a(Context context, com.tencent.bugly.crashreport.common.strategy.c cVar, com.tencent.bugly.crashreport.common.info.a aVar, W w, J j2, com.tencent.bugly.crashreport.crash.e eVar, BuglyStrategy.a aVar2) {
        if (f24817a == null) {
            f24817a = new h(context, cVar, aVar, w, j2, eVar, aVar2);
        }
        return f24817a;
    }

    public void b(boolean z) {
        c(z);
        boolean c2 = c();
        com.tencent.bugly.crashreport.common.strategy.c b2 = com.tencent.bugly.crashreport.common.strategy.c.b();
        if (b2 != null) {
            c2 = c2 && b2.c().f24768f;
        }
        if (c2 != a()) {
            X.c("anr changed to %b", Boolean.valueOf(c2));
            a(c2);
        }
    }

    protected ActivityManager.ProcessErrorStateInfo a(Context context, long j2) {
        if (j2 < 0) {
            j2 = 0;
        }
        try {
            X.a("to find!", new Object[0]);
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            long j3 = j2 / 500;
            int i2 = 0;
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
                int i3 = i2 + 1;
                if (i2 >= j3) {
                    X.a("end!", new Object[0]);
                    return null;
                }
                i2 = i3;
            }
        } catch (Exception e2) {
            X.a(e2);
            return null;
        } catch (OutOfMemoryError e3) {
            this.n.pid = Process.myPid();
            this.n.shortMsg = "bugly sdk waitForAnrProcessStateChanged encount error:" + e3.getMessage();
            return this.n;
        }
    }

    public boolean b(String str) {
        return str.startsWith("bugly_trace_");
    }

    protected a a(Context context, ActivityManager.ProcessErrorStateInfo processErrorStateInfo, long j2, Map<String, String> map) {
        a aVar = new a();
        aVar.f24805c = j2;
        aVar.f24803a = processErrorStateInfo != null ? processErrorStateInfo.processName : AppInfo.a(context, Process.myPid());
        aVar.f24808f = processErrorStateInfo != null ? processErrorStateInfo.shortMsg : "";
        aVar.f24807e = processErrorStateInfo != null ? processErrorStateInfo.longMsg : "";
        aVar.f24804b = map;
        Thread thread = Looper.getMainLooper().getThread();
        if (map != null) {
            Iterator<String> it = map.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (next.startsWith(thread.getName())) {
                    aVar.f24809g = map.get(next);
                    break;
                }
            }
        }
        if (TextUtils.isEmpty(aVar.f24809g)) {
            aVar.f24809g = "main stack is null , some error may be encountered.";
        }
        Object[] objArr = new Object[7];
        objArr[0] = Long.valueOf(aVar.f24805c);
        objArr[1] = aVar.f24806d;
        objArr[2] = aVar.f24803a;
        objArr[3] = aVar.f24809g;
        objArr[4] = aVar.f24808f;
        objArr[5] = aVar.f24807e;
        Map<String, String> map2 = aVar.f24804b;
        objArr[6] = Integer.valueOf(map2 != null ? map2.size() : 0);
        X.a("anr tm:%d\ntr:%s\nproc:%s\nmain stack:%s\nsMsg:%s\n lMsg:%s\n threads:%d", objArr);
        return aVar;
    }

    protected CrashDetailBean a(a aVar) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        try {
            crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.h();
            crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.j();
            crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.g();
            crashDetailBean.F = this.f24821e.v();
            crashDetailBean.G = this.f24821e.w();
            crashDetailBean.H = this.f24821e.x();
            if (!com.tencent.bugly.crashreport.common.info.b.i(this.f24820d)) {
                crashDetailBean.w = ca.a(this.f24820d, com.tencent.bugly.crashreport.crash.h.f24859e, com.tencent.bugly.crashreport.crash.h.f24862h);
            }
            crashDetailBean.f24788b = 3;
            crashDetailBean.f24791e = this.f24821e.l();
            com.tencent.bugly.crashreport.common.info.a aVar2 = this.f24821e;
            crashDetailBean.f24792f = aVar2.E;
            crashDetailBean.f24793g = aVar2.i();
            crashDetailBean.m = this.f24821e.y();
            crashDetailBean.n = "ANR_EXCEPTION";
            crashDetailBean.o = aVar.f24808f;
            crashDetailBean.q = aVar.f24809g;
            HashMap hashMap = new HashMap();
            crashDetailBean.Q = hashMap;
            hashMap.put("BUGLY_CR_01", aVar.f24807e);
            String str = crashDetailBean.q;
            int indexOf = str != null ? str.indexOf("\n") : -1;
            crashDetailBean.p = indexOf > 0 ? crashDetailBean.q.substring(0, indexOf) : "GET_FAIL";
            crashDetailBean.r = aVar.f24805c;
            String str2 = crashDetailBean.q;
            if (str2 != null) {
                crashDetailBean.u = ca.c(str2.getBytes());
            }
            crashDetailBean.z = aVar.f24804b;
            crashDetailBean.A = aVar.f24803a;
            crashDetailBean.B = "main(1)";
            crashDetailBean.I = this.f24821e.r();
            crashDetailBean.f24794h = this.f24821e.p();
            crashDetailBean.f24795i = this.f24821e.o();
            crashDetailBean.v = aVar.f24806d;
            com.tencent.bugly.crashreport.common.info.a aVar3 = this.f24821e;
            crashDetailBean.M = aVar3.M;
            crashDetailBean.N = aVar3.f24751d;
            crashDetailBean.O = aVar3.C();
            if (!com.tencent.bugly.crashreport.common.info.b.i(this.f24820d)) {
                this.f24825i.d(crashDetailBean);
            }
            crashDetailBean.R = this.f24821e.A();
            crashDetailBean.S = this.f24821e.t();
            crashDetailBean.T = this.f24821e.h();
            crashDetailBean.U = this.f24821e.g();
            crashDetailBean.y = ba.b();
        } catch (Throwable th) {
            if (!X.b(th)) {
                th.printStackTrace();
            }
        }
        return crashDetailBean;
    }

    protected boolean a(String str, String str2, String str3) {
        Map<String, String[]> map;
        TraceFileHelper.a readTargetDumpInfo = TraceFileHelper.readTargetDumpInfo(str3, str, true);
        if (readTargetDumpInfo != null && (map = readTargetDumpInfo.f24802d) != null && map.size() > 0) {
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
                                String[] strArr = readTargetDumpInfo.f24802d.get("main");
                                int i2 = 3;
                                if (strArr != null && strArr.length >= 3) {
                                    String str4 = strArr[0];
                                    String str5 = strArr[1];
                                    String str6 = strArr[2];
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("\"main\" tid=");
                                    sb.append(str6);
                                    sb.append(" :\n");
                                    sb.append(str4);
                                    sb.append("\n");
                                    sb.append(str5);
                                    sb.append("\n\n");
                                    bufferedWriter2.write(sb.toString());
                                    bufferedWriter2.flush();
                                }
                                for (Map.Entry<String, String[]> entry : readTargetDumpInfo.f24802d.entrySet()) {
                                    if (!entry.getKey().equals("main") && entry.getValue() != null && entry.getValue().length >= i2) {
                                        String str7 = entry.getValue()[0];
                                        String str8 = entry.getValue()[1];
                                        String str9 = entry.getValue()[2];
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append("\"");
                                        sb2.append(entry.getKey());
                                        sb2.append("\" tid=");
                                        sb2.append(str9);
                                        sb2.append(" :\n");
                                        sb2.append(str7);
                                        sb2.append("\n");
                                        sb2.append(str8);
                                        sb2.append("\n\n");
                                        bufferedWriter2.write(sb2.toString());
                                        bufferedWriter2.flush();
                                        i2 = 3;
                                    }
                                }
                                try {
                                    bufferedWriter2.close();
                                } catch (IOException e2) {
                                    if (!X.b(e2)) {
                                        e2.printStackTrace();
                                    }
                                }
                                return true;
                            } catch (IOException e3) {
                                e = e3;
                                bufferedWriter = bufferedWriter2;
                                if (!X.b(e)) {
                                    e.printStackTrace();
                                }
                                X.b("dump trace fail %s", e.getClass().getName() + ":" + e.getMessage());
                                if (bufferedWriter != null) {
                                    try {
                                        bufferedWriter.close();
                                    } catch (IOException e4) {
                                        if (!X.b(e4)) {
                                            e4.printStackTrace();
                                        }
                                    }
                                }
                                return false;
                            } catch (Throwable th) {
                                th = th;
                                bufferedWriter = bufferedWriter2;
                                BufferedWriter bufferedWriter3 = bufferedWriter;
                                Throwable th2 = th;
                                if (bufferedWriter3 != null) {
                                    try {
                                        bufferedWriter3.close();
                                        throw th2;
                                    } catch (IOException e5) {
                                        if (!X.b(e5)) {
                                            e5.printStackTrace();
                                            throw th2;
                                        }
                                        throw th2;
                                    }
                                }
                                throw th2;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (IOException e6) {
                        e = e6;
                    }
                } else {
                    X.b("backup file create fail %s", str2);
                    return false;
                }
            } catch (Exception e7) {
                if (!X.b(e7)) {
                    e7.printStackTrace();
                }
                X.b("backup file create error! %s  %s", e7.getClass().getName() + ":" + e7.getMessage(), str2);
                return false;
            }
        } else {
            X.b("not found trace dump for %s", str3);
            return false;
        }
    }

    public boolean a(Context context, String str, ActivityManager.ProcessErrorStateInfo processErrorStateInfo, long j2, Map<String, String> map) {
        a a2 = a(context, processErrorStateInfo, j2, map);
        X.c("found visiable anr , start to upload!", new Object[0]);
        CrashDetailBean a3 = a(a2);
        if (a3 == null) {
            X.b("pack anr fail!", new Object[0]);
            return false;
        }
        com.tencent.bugly.crashreport.crash.h.g().a(a3);
        if (a3.f24787a >= 0) {
            X.c("backup anr record success!", new Object[0]);
        } else {
            X.e("backup anr record fail!", new Object[0]);
        }
        if (str != null && new File(str).exists()) {
            a2.f24806d = new File(this.f24824h, "bugly_trace_" + j2 + com.martian.mibook.lib.local.c.b.b.f13935b).getAbsolutePath();
            this.f24818b.set(3);
            if (a(str, a2.f24806d, a2.f24803a)) {
                X.c("backup trace success", new Object[0]);
            }
        } else {
            File l = l();
            X.c("traceFile is %s", l);
            if (l != null) {
                a3.v = l.getAbsolutePath();
            }
        }
        com.tencent.bugly.crashreport.crash.e.a("ANR", ca.a(), a2.f24803a, "main", a2.f24809g, a3);
        if (!this.f24825i.c(a3)) {
            this.f24825i.a(a3, 3000L, true);
        }
        this.f24825i.e(a3);
        return true;
    }

    public final void a(String str) {
        long j2;
        synchronized (this) {
            if (this.f24818b.get() != 0) {
                X.a("trace started return ", new Object[0]);
                return;
            }
            this.f24818b.set(1);
            try {
                X.a("read trace first dump for create time!", new Object[0]);
                TraceFileHelper.a readFirstDumpInfo = TraceFileHelper.readFirstDumpInfo(str, false);
                long j3 = readFirstDumpInfo != null ? readFirstDumpInfo.f24801c : -1L;
                if (j3 == -1) {
                    X.e("trace dump fail could not get time!", new Object[0]);
                    j3 = System.currentTimeMillis();
                }
                j2 = j3;
            } finally {
                try {
                } finally {
                }
            }
            if (Math.abs(j2 - this.f24819c) < 10000) {
                X.e("should not process ANR too Fre in %d", 10000);
                return;
            }
            this.f24819c = j2;
            this.f24818b.set(1);
            try {
                Map<String, String> a2 = ca.a(com.tencent.bugly.crashreport.crash.h.f24860f, false);
                if (a2 != null && a2.size() > 0) {
                    ActivityManager.ProcessErrorStateInfo a3 = a(this.f24820d, 20000L);
                    this.n = a3;
                    if (a3 == null) {
                        X.a("proc state is unvisiable!", new Object[0]);
                        return;
                    } else if (a3.pid != Process.myPid()) {
                        X.a("not mind proc!", this.n.processName);
                        return;
                    } else {
                        X.c("found visiable anr , start to process!", new Object[0]);
                        a(this.f24820d, str, this.n, j2, a2);
                        return;
                    }
                }
                X.e("can't get all thread skip this anr", new Object[0]);
            } catch (Throwable th) {
                X.b(th);
                X.b("get all thread stack fail!", new Object[0]);
            }
        }
    }

    protected synchronized boolean a() {
        return this.f24826j != null;
    }

    protected synchronized void a(boolean z) {
        if (Build.VERSION.SDK_INT <= 19) {
            if (z) {
                e();
            } else {
                f();
            }
        } else if (z) {
            i();
        } else {
            k();
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
            } catch (Throwable th) {
                X.a(th);
                hashMap.put("main", th.getMessage());
            }
            Map<String, String> map = hashMap;
            X.a("onThreadBlock found visiable anr , start to process!", new Object[0]);
            String d2 = com.tencent.bugly.crashreport.common.info.b.d(this.f24820d);
            if (!TextUtils.isEmpty(d2) && (d2.contains("XiaoMi") || d2.contains("samsung"))) {
                this.n = a(this.f24820d, 20000L);
            }
            a(this.f24820d, "", this.n, System.currentTimeMillis(), map);
        } else {
            X.a("anr handler onThreadBlock only care main thread ,current thread is: %s", daVar.c());
        }
        return true;
    }
}
