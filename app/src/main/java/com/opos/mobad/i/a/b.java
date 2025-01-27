package com.opos.mobad.i.a;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/* loaded from: classes4.dex */
public class b extends Thread {

    /* renamed from: a */
    private File f20995a;

    /* renamed from: b */
    private int f20996b;

    /* renamed from: c */
    private c[] f20997c;

    /* renamed from: d */
    private volatile boolean f20998d = false;

    public b(File file, int i2, c[] cVarArr) {
        setName("download_monitor_" + file.getName());
        setPriority(5);
        this.f20995a = file;
        this.f20996b = i2;
        this.f20997c = cVarArr;
    }

    private void a(File file, int i2, c[] cVarArr) {
        com.opos.cmn.an.f.a.b("DownloadMonitorThread", "writePosInfoToFile start");
        if (file != null && cVarArr != null && cVarArr.length > 0) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
                    try {
                        dataOutputStream.writeInt(i2);
                        for (int i3 = 0; i3 < cVarArr.length; i3++) {
                            dataOutputStream.writeLong(cVarArr[i3].a());
                            dataOutputStream.writeLong(cVarArr[i3].b());
                        }
                        dataOutputStream.close();
                        fileOutputStream.close();
                    } finally {
                    }
                } finally {
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("DownloadMonitorThread", "writePosInfoToFile", (Throwable) e2);
            }
        }
        com.opos.cmn.an.f.a.b("DownloadMonitorThread", "writePosInfoToFile end");
    }

    public void a() {
        this.f20998d = true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        StringBuilder sb;
        com.opos.cmn.an.f.a.b("DownloadMonitorThread", "DownloadMonitorThread start running.");
        e eVar = new e(this.f20995a);
        try {
            try {
                if (eVar.a()) {
                    while (!this.f20998d) {
                        a(this.f20995a, this.f20996b, this.f20997c);
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
                com.opos.cmn.an.f.a.b("DownloadMonitorThread", "posInfoFile releaseFileLock success." + this.f20995a);
                throw th;
            }
        } catch (Exception e3) {
            com.opos.cmn.an.f.a.a("DownloadMonitorThread", "DownloadMonitorThread run", (Throwable) e3);
            com.opos.cmn.an.f.a.b("DownloadMonitorThread", "DownloadMonitorThread end running.");
            eVar.b();
            sb = new StringBuilder();
        }
        sb.append("posInfoFile releaseFileLock success.");
        sb.append(this.f20995a);
        com.opos.cmn.an.f.a.b("DownloadMonitorThread", sb.toString());
    }
}
