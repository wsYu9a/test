package com.oplus.log.core;

import android.os.StatFs;
import android.util.Log;
import b.h.a.d;
import com.oplus.log.core.k;
import java.io.File;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes4.dex */
public final class h extends Thread {

    /* renamed from: a */
    i f16151a;

    /* renamed from: f */
    private boolean f16156f;

    /* renamed from: g */
    private File f16157g;

    /* renamed from: h */
    private boolean f16158h;

    /* renamed from: i */
    private long f16159i;

    /* renamed from: j */
    private f f16160j;
    private ConcurrentLinkedQueue<e> k;
    private String l;
    private String m;
    private String n;
    private long o;
    private long p;
    private long q;
    private String r;
    private String s;
    private int t;
    private ExecutorService v;

    /* renamed from: b */
    private final Object f16152b = new Object();

    /* renamed from: c */
    private final Object f16153c = new Object();

    /* renamed from: e */
    private volatile boolean f16155e = true;
    private ConcurrentLinkedQueue<e> u = new ConcurrentLinkedQueue<>();

    /* renamed from: d */
    private final com.oplus.log.core.a f16154d = new com.oplus.log.core.a();
    private final d.C0055d w = new d.C0055d();

    final class a implements i {
        a() {
        }

        @Override // com.oplus.log.core.i
        public final void a(String str, int i2) {
            if (h.this.f16151a != null) {
                h.this.f16151a.a(str, i2);
            }
        }
    }

    final class b implements k.a {
        b() {
        }
    }

    final class c implements ThreadFactory {
        c() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(Thread.currentThread().getThreadGroup(), runnable, "logan-thread-send-log", 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    h(ConcurrentLinkedQueue<e> concurrentLinkedQueue, String str, String str2, long j2, long j3, long j4, String str3, String str4, String str5) {
        this.k = concurrentLinkedQueue;
        this.l = str;
        this.m = str2;
        this.n = str5;
        this.o = j2;
        this.p = j3;
        this.q = j4;
        this.r = str3;
        this.s = str4;
    }

    private void d(long j2) {
        File[] listFiles;
        File file = new File(this.m);
        if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2 != null) {
                try {
                    if (file2.lastModified() <= j2) {
                        file2.delete();
                    }
                } catch (Exception e2) {
                    if (b.h.a.c.j()) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0040, code lost:
    
        if (b.h.a.c.j() == false) goto L199;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0042, code lost:
    
        r5.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b0, code lost:
    
        if (b.h.a.c.j() == false) goto L199;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0086, code lost:
    
        if (b.h.a.c.j() == false) goto L199;
     */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean e(java.lang.String r5, java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 221
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.log.core.h.e(java.lang.String, java.lang.String):boolean");
    }

    private boolean g() {
        StatFs statFs;
        try {
            statFs = new StatFs(this.m);
        } catch (IllegalArgumentException e2) {
            if (b.h.a.c.j()) {
                e2.printStackTrace();
            }
        }
        return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks()) > this.q;
    }

    public final void c() {
        if (this.f16156f) {
            return;
        }
        synchronized (this.f16152b) {
            this.f16152b.notify();
        }
    }

    public final void f() {
        if (com.oplus.log.core.b.f16111a) {
            Log.d("LoganThread", "Logan flush start");
        }
        f fVar = this.f16160j;
        if (fVar != null) {
            fVar.logan_flush();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x025f A[Catch: all -> 0x0290, TryCatch #0 {, blocks: (B:76:0x019b, B:78:0x01a1, B:79:0x028e, B:81:0x01a8, B:83:0x01ae, B:84:0x01b5, B:87:0x01bf, B:89:0x01c5, B:91:0x01c9, B:92:0x01d0, B:96:0x0206, B:98:0x022e, B:100:0x0252, B:102:0x025f, B:104:0x0263, B:105:0x026b, B:107:0x027c, B:108:0x0287, B:110:0x0255, B:111:0x0258, B:112:0x01dc, B:114:0x01fd), top: B:75:0x019b }] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x026b A[Catch: all -> 0x0290, TryCatch #0 {, blocks: (B:76:0x019b, B:78:0x01a1, B:79:0x028e, B:81:0x01a8, B:83:0x01ae, B:84:0x01b5, B:87:0x01bf, B:89:0x01c5, B:91:0x01c9, B:92:0x01d0, B:96:0x0206, B:98:0x022e, B:100:0x0252, B:102:0x025f, B:104:0x0263, B:105:0x026b, B:107:0x027c, B:108:0x0287, B:110:0x0255, B:111:0x0258, B:112:0x01dc, B:114:0x01fd), top: B:75:0x019b }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0258 A[Catch: all -> 0x0290, TryCatch #0 {, blocks: (B:76:0x019b, B:78:0x01a1, B:79:0x028e, B:81:0x01a8, B:83:0x01ae, B:84:0x01b5, B:87:0x01bf, B:89:0x01c5, B:91:0x01c9, B:92:0x01d0, B:96:0x0206, B:98:0x022e, B:100:0x0252, B:102:0x025f, B:104:0x0263, B:105:0x026b, B:107:0x027c, B:108:0x0287, B:110:0x0255, B:111:0x0258, B:112:0x01dc, B:114:0x01fd), top: B:75:0x019b }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0055 A[Catch: InterruptedException -> 0x02a2, all -> 0x02b1, TryCatch #2 {InterruptedException -> 0x02a2, blocks: (B:11:0x000e, B:13:0x0018, B:16:0x0023, B:18:0x0027, B:20:0x002b, B:22:0x002f, B:26:0x0055, B:28:0x0059, B:29:0x007f, B:31:0x0085, B:33:0x008b, B:34:0x0092, B:36:0x0096, B:37:0x009f, B:39:0x00b0, B:41:0x00bc, B:43:0x00c9, B:49:0x00e2, B:51:0x00fe, B:53:0x0109, B:54:0x010e, B:56:0x011c, B:57:0x0134, B:58:0x014e, B:60:0x015c, B:61:0x0168, B:63:0x016c, B:65:0x0170, B:66:0x017c, B:68:0x00de, B:69:0x018e, B:71:0x0192, B:73:0x0198, B:74:0x019a, B:120:0x0292, B:124:0x0293, B:126:0x0297, B:128:0x029e, B:129:0x0037, B:131:0x003d, B:133:0x0041, B:136:0x004b), top: B:10:0x000e, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e2 A[Catch: InterruptedException -> 0x02a2, all -> 0x02b1, TryCatch #2 {InterruptedException -> 0x02a2, blocks: (B:11:0x000e, B:13:0x0018, B:16:0x0023, B:18:0x0027, B:20:0x002b, B:22:0x002f, B:26:0x0055, B:28:0x0059, B:29:0x007f, B:31:0x0085, B:33:0x008b, B:34:0x0092, B:36:0x0096, B:37:0x009f, B:39:0x00b0, B:41:0x00bc, B:43:0x00c9, B:49:0x00e2, B:51:0x00fe, B:53:0x0109, B:54:0x010e, B:56:0x011c, B:57:0x0134, B:58:0x014e, B:60:0x015c, B:61:0x0168, B:63:0x016c, B:65:0x0170, B:66:0x017c, B:68:0x00de, B:69:0x018e, B:71:0x0192, B:73:0x0198, B:74:0x019a, B:120:0x0292, B:124:0x0293, B:126:0x0297, B:128:0x029e, B:129:0x0037, B:131:0x003d, B:133:0x0041, B:136:0x004b), top: B:10:0x000e, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x015c A[Catch: InterruptedException -> 0x02a2, all -> 0x02b1, TryCatch #2 {InterruptedException -> 0x02a2, blocks: (B:11:0x000e, B:13:0x0018, B:16:0x0023, B:18:0x0027, B:20:0x002b, B:22:0x002f, B:26:0x0055, B:28:0x0059, B:29:0x007f, B:31:0x0085, B:33:0x008b, B:34:0x0092, B:36:0x0096, B:37:0x009f, B:39:0x00b0, B:41:0x00bc, B:43:0x00c9, B:49:0x00e2, B:51:0x00fe, B:53:0x0109, B:54:0x010e, B:56:0x011c, B:57:0x0134, B:58:0x014e, B:60:0x015c, B:61:0x0168, B:63:0x016c, B:65:0x0170, B:66:0x017c, B:68:0x00de, B:69:0x018e, B:71:0x0192, B:73:0x0198, B:74:0x019a, B:120:0x0292, B:124:0x0293, B:126:0x0297, B:128:0x029e, B:129:0x0037, B:131:0x003d, B:133:0x0041, B:136:0x004b), top: B:10:0x000e, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x016c A[Catch: InterruptedException -> 0x02a2, all -> 0x02b1, TryCatch #2 {InterruptedException -> 0x02a2, blocks: (B:11:0x000e, B:13:0x0018, B:16:0x0023, B:18:0x0027, B:20:0x002b, B:22:0x002f, B:26:0x0055, B:28:0x0059, B:29:0x007f, B:31:0x0085, B:33:0x008b, B:34:0x0092, B:36:0x0096, B:37:0x009f, B:39:0x00b0, B:41:0x00bc, B:43:0x00c9, B:49:0x00e2, B:51:0x00fe, B:53:0x0109, B:54:0x010e, B:56:0x011c, B:57:0x0134, B:58:0x014e, B:60:0x015c, B:61:0x0168, B:63:0x016c, B:65:0x0170, B:66:0x017c, B:68:0x00de, B:69:0x018e, B:71:0x0192, B:73:0x0198, B:74:0x019a, B:120:0x0292, B:124:0x0293, B:126:0x0297, B:128:0x029e, B:129:0x0037, B:131:0x003d, B:133:0x0041, B:136:0x004b), top: B:10:0x000e, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0206 A[Catch: all -> 0x0290, TryCatch #0 {, blocks: (B:76:0x019b, B:78:0x01a1, B:79:0x028e, B:81:0x01a8, B:83:0x01ae, B:84:0x01b5, B:87:0x01bf, B:89:0x01c5, B:91:0x01c9, B:92:0x01d0, B:96:0x0206, B:98:0x022e, B:100:0x0252, B:102:0x025f, B:104:0x0263, B:105:0x026b, B:107:0x027c, B:108:0x0287, B:110:0x0255, B:111:0x0258, B:112:0x01dc, B:114:0x01fd), top: B:75:0x019b }] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 693
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.log.core.h.run():void");
    }
}
