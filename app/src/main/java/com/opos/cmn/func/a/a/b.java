package com.opos.cmn.func.a.a;

import java.io.File;

/* loaded from: classes4.dex */
public class b extends Thread {

    /* renamed from: a */
    private File f17028a;

    /* renamed from: b */
    private int f17029b;

    /* renamed from: c */
    private c[] f17030c;

    /* renamed from: d */
    private volatile boolean f17031d = false;

    public b(File file, int i2, c[] cVarArr) {
        setName("download_monitor_" + file.getName());
        setPriority(5);
        this.f17028a = file;
        this.f17029b = i2;
        this.f17030c = cVarArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0075 A[Catch: IOException -> 0x0071, TRY_LEAVE, TryCatch #5 {IOException -> 0x0071, blocks: (B:42:0x006d, B:34:0x0075), top: B:41:0x006d }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.io.File r7, int r8, com.opos.cmn.func.a.a.c[] r9) {
        /*
            r6 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "DownloadMonitorThread"
            java.lang.String r2 = "writePosInfoToFile start"
            com.opos.cmn.an.f.a.b(r1, r2)
            if (r7 == 0) goto L7d
            if (r9 == 0) goto L7d
            int r2 = r9.length
            if (r2 <= 0) goto L7d
            r2 = 0
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            r3.<init>(r7)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            java.io.DataOutputStream r7 = new java.io.DataOutputStream     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            r7.<init>(r3)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            r7.writeInt(r8)     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L40
            r8 = 0
        L1f:
            int r2 = r9.length     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L40
            if (r8 >= r2) goto L37
            r2 = r9[r8]     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L40
            long r4 = r2.a()     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L40
            r7.writeLong(r4)     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L40
            r2 = r9[r8]     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L40
            long r4 = r2.b()     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L40
            r7.writeLong(r4)     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L40
            int r8 = r8 + 1
            goto L1f
        L37:
            r7.close()     // Catch: java.io.IOException -> L59
            r3.close()     // Catch: java.io.IOException -> L59
            goto L7d
        L3e:
            r8 = move-exception
            goto L67
        L40:
            r8 = move-exception
            r2 = r7
            goto L4e
        L43:
            r7 = move-exception
            goto L6b
        L45:
            r7 = move-exception
            r8 = r7
            goto L4e
        L48:
            r7 = move-exception
            r3 = r2
            goto L6b
        L4b:
            r7 = move-exception
            r8 = r7
            r3 = r2
        L4e:
            java.lang.String r7 = "writePosInfoToFile"
            com.opos.cmn.an.f.a.c(r1, r7, r8)     // Catch: java.lang.Throwable -> L65
            if (r2 == 0) goto L5b
            r2.close()     // Catch: java.io.IOException -> L59
            goto L5b
        L59:
            r7 = move-exception
            goto L61
        L5b:
            if (r3 == 0) goto L7d
            r3.close()     // Catch: java.io.IOException -> L59
            goto L7d
        L61:
            com.opos.cmn.an.f.a.c(r1, r0, r7)
            goto L7d
        L65:
            r8 = move-exception
            r7 = r2
        L67:
            r2 = r3
            r3 = r2
            r2 = r7
            r7 = r8
        L6b:
            if (r2 == 0) goto L73
            r2.close()     // Catch: java.io.IOException -> L71
            goto L73
        L71:
            r8 = move-exception
            goto L79
        L73:
            if (r3 == 0) goto L7c
            r3.close()     // Catch: java.io.IOException -> L71
            goto L7c
        L79:
            com.opos.cmn.an.f.a.c(r1, r0, r8)
        L7c:
            throw r7
        L7d:
            java.lang.String r7 = "writePosInfoToFile end"
            com.opos.cmn.an.f.a.b(r1, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.func.a.a.b.a(java.io.File, int, com.opos.cmn.func.a.a.c[]):void");
    }

    public void a() {
        this.f17031d = true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        StringBuilder sb;
        com.opos.cmn.an.f.a.b("DownloadMonitorThread", "DownloadMonitorThread start running.");
        e eVar = new e(this.f17028a);
        try {
            try {
                if (eVar.a()) {
                    while (!this.f17031d) {
                        a(this.f17028a, this.f17029b, this.f17030c);
                        try {
                            Thread.sleep(500L);
                        } catch (InterruptedException e2) {
                            com.opos.cmn.an.f.a.b("DownloadMonitorThread", "", e2);
                        }
                    }
                }
                com.opos.cmn.an.f.a.b("DownloadMonitorThread", "DownloadMonitorThread end running.");
                eVar.b();
                sb = new StringBuilder();
            } catch (Throwable th) {
                com.opos.cmn.an.f.a.b("DownloadMonitorThread", "DownloadMonitorThread end running.");
                eVar.b();
                com.opos.cmn.an.f.a.b("DownloadMonitorThread", "posInfoFile releaseFileLock success." + this.f17028a);
                throw th;
            }
        } catch (Exception e3) {
            com.opos.cmn.an.f.a.c("DownloadMonitorThread", "DownloadMonitorThread run", e3);
            com.opos.cmn.an.f.a.b("DownloadMonitorThread", "DownloadMonitorThread end running.");
            eVar.b();
            sb = new StringBuilder();
        }
        sb.append("posInfoFile releaseFileLock success.");
        sb.append(this.f17028a);
        com.opos.cmn.an.f.a.b("DownloadMonitorThread", sb.toString());
    }
}
