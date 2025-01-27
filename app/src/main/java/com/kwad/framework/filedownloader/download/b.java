package com.kwad.framework.filedownloader.download;

import com.kwad.framework.filedownloader.a.c;
import com.kwad.framework.filedownloader.f.c;
import com.kwad.framework.filedownloader.services.c;
import java.io.File;

/* loaded from: classes3.dex */
public final class b {
    private com.kwad.framework.filedownloader.services.c aja;
    private c.a ajb;
    private c.b ajc;
    private c.e ajd;
    private volatile com.kwad.framework.filedownloader.b.a aje;
    private c.d ajf;

    public static final class a {
        private static final b ajg = new b();
    }

    private c.a wB() {
        c.a aVar = this.ajb;
        if (aVar != null) {
            return aVar;
        }
        synchronized (this) {
            try {
                if (this.ajb == null) {
                    this.ajb = wE().xC();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return this.ajb;
    }

    private c.b wC() {
        c.b bVar = this.ajc;
        if (bVar != null) {
            return bVar;
        }
        synchronized (this) {
            try {
                if (this.ajc == null) {
                    this.ajc = wE().xB();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return this.ajc;
    }

    private c.e wD() {
        c.e eVar = this.ajd;
        if (eVar != null) {
            return eVar;
        }
        synchronized (this) {
            try {
                if (this.ajd == null) {
                    this.ajd = wE().xA();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return this.ajd;
    }

    private com.kwad.framework.filedownloader.services.c wE() {
        com.kwad.framework.filedownloader.services.c cVar = this.aja;
        if (cVar != null) {
            return cVar;
        }
        synchronized (this) {
            try {
                if (this.aja == null) {
                    this.aja = new com.kwad.framework.filedownloader.services.c();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return this.aja;
    }

    public static b ww() {
        return a.ajg;
    }

    public final void a(c.b bVar) {
        synchronized (this) {
            this.aja = new com.kwad.framework.filedownloader.services.c(bVar);
            this.ajc = null;
            this.ajd = null;
            this.aje = null;
            this.ajf = null;
        }
    }

    public final void b(c.b bVar) {
        synchronized (this) {
            this.aja = new com.kwad.framework.filedownloader.services.c(bVar);
        }
    }

    public final com.kwad.framework.filedownloader.a.b bl(String str) {
        try {
            return wC().bi(str);
        } catch (Throwable unused) {
            c.b bVar = new c.b();
            this.ajc = bVar;
            return bVar.bi(str);
        }
    }

    public final boolean wA() {
        wD();
        return true;
    }

    public final c.d wx() {
        c.d dVar = this.ajf;
        if (dVar != null) {
            return dVar;
        }
        synchronized (this) {
            try {
                if (this.ajf == null) {
                    this.ajf = wE().xD();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return this.ajf;
    }

    public final synchronized com.kwad.framework.filedownloader.b.a wy() {
        if (this.aje != null) {
            return this.aje;
        }
        this.aje = wE().xz();
        a(this.aje.wn());
        return this.aje;
    }

    public final int wz() {
        return wE().wz();
    }

    public final com.kwad.framework.filedownloader.e.a b(File file) {
        return wD().c(file);
    }

    public final int a(int i10, String str, String str2, long j10) {
        return wB().P(j10);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0064 A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:3:0x001f, B:5:0x0025, B:7:0x0034, B:9:0x003a, B:11:0x0041, B:13:0x0047, B:16:0x0058, B:19:0x00dd, B:22:0x0064, B:24:0x006f, B:26:0x007e, B:28:0x008d, B:30:0x0093, B:32:0x009b, B:33:0x00b8, B:35:0x00bf, B:38:0x00cc, B:41:0x00d7, B:43:0x00e6, B:45:0x00fc, B:47:0x0100, B:48:0x011b, B:49:0x0126, B:55:0x0055), top: B:2:0x001f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.kwad.framework.filedownloader.b.a.InterfaceC0463a r27) {
        /*
            Method dump skipped, instructions count: 411
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.download.b.a(com.kwad.framework.filedownloader.b.a$a):void");
    }
}
