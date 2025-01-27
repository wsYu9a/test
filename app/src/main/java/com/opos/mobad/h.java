package com.opos.mobad;

/* loaded from: classes4.dex */
public class h {
    public static boolean a(com.opos.mobad.c.a.b bVar, int i2, int i3) {
        boolean z = true;
        if (bVar != null) {
            int i4 = 0;
            while (true) {
                if (i4 >= i2) {
                    z = false;
                    break;
                }
                if (bVar.a()) {
                    break;
                }
                com.opos.cmn.an.f.a.a("RetryFileLockTool", "acquireFileLock but thread has acquire " + i4);
                try {
                    Thread.sleep(i3);
                } catch (InterruptedException e2) {
                    com.opos.cmn.an.f.a.a("RetryFileLockTool", "", (Throwable) e2);
                }
                i4++;
            }
            com.opos.cmn.an.f.a.b("RetryFileLockTool", "acquireFileLock retry time=" + i2 + ",interval =" + i3 + ",result =" + z);
        }
        return z;
    }
}
