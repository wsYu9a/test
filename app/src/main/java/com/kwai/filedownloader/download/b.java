package com.kwai.filedownloader.download;

import com.kwai.filedownloader.e.c;
import com.kwai.filedownloader.kwai.c;
import com.kwai.filedownloader.services.c;
import java.io.File;

/* loaded from: classes2.dex */
public final class b {
    private com.kwai.filedownloader.services.c aGW;
    private c.a aGX;
    private c.b aGY;
    private c.e aGZ;
    private volatile com.kwai.filedownloader.a.a aHa;
    private c.d aHb;

    static final class a {
        private static final b aHc = new b();
    }

    public static b HF() {
        return a.aHc;
    }

    private c.a HK() {
        c.a aVar = this.aGX;
        if (aVar != null) {
            return aVar;
        }
        synchronized (this) {
            if (this.aGX == null) {
                this.aGX = HM().IJ();
            }
        }
        return this.aGX;
    }

    private c.e HL() {
        c.e eVar = this.aGZ;
        if (eVar != null) {
            return eVar;
        }
        synchronized (this) {
            if (this.aGZ == null) {
                this.aGZ = HM().IH();
            }
        }
        return this.aGZ;
    }

    private com.kwai.filedownloader.services.c HM() {
        com.kwai.filedownloader.services.c cVar = this.aGW;
        if (cVar != null) {
            return cVar;
        }
        synchronized (this) {
            if (this.aGW == null) {
                this.aGW = new com.kwai.filedownloader.services.c();
            }
        }
        return this.aGW;
    }

    private c.b T() {
        c.b bVar = this.aGY;
        if (bVar != null) {
            return bVar;
        }
        synchronized (this) {
            if (this.aGY == null) {
                this.aGY = HM().II();
            }
        }
        return this.aGY;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00d4, code lost:
    
        if (r8.IB() > 0) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0051, code lost:
    
        if (r8.IB() <= 0) goto L114;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00fd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065 A[Catch: all -> 0x0143, TryCatch #1 {all -> 0x0143, blocks: (B:73:0x0034, B:75:0x003b, B:77:0x0042, B:79:0x0049, B:10:0x0056, B:37:0x0065, B:39:0x0070, B:9:0x0053), top: B:72:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00cc A[Catch: all -> 0x0141, TryCatch #0 {all -> 0x0141, blocks: (B:16:0x00f1, B:28:0x00fd, B:30:0x0113, B:32:0x0117, B:33:0x012f, B:34:0x0136, B:52:0x00a3, B:53:0x00c5, B:55:0x00cc, B:58:0x00da, B:61:0x00e5), top: B:15:0x00f1 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.kwai.filedownloader.a.a.InterfaceC0237a r26) {
        /*
            Method dump skipped, instructions count: 456
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.filedownloader.download.b.a(com.kwai.filedownloader.a.a$a):void");
    }

    public final c.d HG() {
        c.d dVar = this.aHb;
        if (dVar != null) {
            return dVar;
        }
        synchronized (this) {
            if (this.aHb == null) {
                this.aHb = HM().IK();
            }
        }
        return this.aHb;
    }

    public final synchronized com.kwai.filedownloader.a.a HH() {
        if (this.aHa != null) {
            return this.aHa;
        }
        this.aHa = HM().IG();
        a(this.aHa.Hx());
        return this.aHa;
    }

    public final int HI() {
        return HM().HI();
    }

    public final boolean HJ() {
        HL();
        return true;
    }

    public final int a(int i2, String str, String str2, long j2) {
        return HK().ak(j2);
    }

    public final void a(c.b bVar) {
        synchronized (this) {
            this.aGW = new com.kwai.filedownloader.services.c(bVar);
            this.aGY = null;
            this.aGZ = null;
            this.aHa = null;
            this.aHb = null;
        }
    }

    public final com.kwai.filedownloader.d.a ab(File file) {
        return HL().ac(file);
    }

    public final void b(c.b bVar) {
        synchronized (this) {
            this.aGW = new com.kwai.filedownloader.services.c(bVar);
        }
    }

    public final com.kwai.filedownloader.kwai.b fp(String str) {
        try {
            return T().q(str);
        } catch (Throwable unused) {
            c.b bVar = new c.b();
            this.aGY = bVar;
            return bVar.q(str);
        }
    }
}
