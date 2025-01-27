package com.kwad.framework.filedownloader.services;

import com.kwad.framework.filedownloader.a.c;
import com.kwad.framework.filedownloader.e.b;
import com.kwad.framework.filedownloader.f.c;

/* loaded from: classes3.dex */
public final class c {
    private final b akX;

    public interface a {
        c.b wC();
    }

    public static class b {
        c.InterfaceC0468c akY;
        Integer akZ;
        c.e ala;
        c.b alb;
        a alc;
        c.a ald;
        c.d ale;

        public final b a(c.b bVar) {
            this.alb = bVar;
            return this;
        }

        public final b bI(int i10) {
            this.akZ = Integer.MAX_VALUE;
            return this;
        }

        public final String toString() {
            return com.kwad.framework.filedownloader.f.f.b("component: database[%s], maxNetworkCount[%s], outputStream[%s], connection[%s], connectionCountAdapter[%s]", this.akY, this.akZ, this.ala, this.alb, this.ald);
        }

        public final b a(a aVar) {
            this.alc = aVar;
            return this;
        }
    }

    public c() {
        this.akX = null;
    }

    private static c.d xE() {
        return new com.kwad.framework.filedownloader.services.b();
    }

    private static int xF() {
        return com.kwad.framework.filedownloader.f.e.xV().aly;
    }

    private static c.e xG() {
        return new b.a();
    }

    private static c.b xH() {
        return new c.b();
    }

    private static c.a xI() {
        return new com.kwad.framework.filedownloader.a.a();
    }

    public final int wz() {
        b bVar = this.akX;
        if (bVar == null) {
            return xF();
        }
        Integer num = bVar.akZ;
        if (num == null) {
            return xF();
        }
        if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize maxNetworkThreadCount: %d", num);
        }
        return com.kwad.framework.filedownloader.f.e.bM(num.intValue());
    }

    public final c.e xA() {
        b bVar = this.akX;
        if (bVar == null) {
            return xG();
        }
        c.e eVar = bVar.ala;
        if (eVar == null) {
            return xG();
        }
        if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize output stream: %s", eVar);
        }
        return eVar;
    }

    public final c.b xB() {
        c.b wC;
        b bVar = this.akX;
        if (bVar == null) {
            return xH();
        }
        a aVar = bVar.alc;
        return (aVar == null || (wC = aVar.wC()) == null) ? xH() : wC;
    }

    public final c.a xC() {
        b bVar = this.akX;
        if (bVar == null) {
            return xI();
        }
        c.a aVar = bVar.ald;
        if (aVar == null) {
            return xI();
        }
        if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize connection count adapter: %s", aVar);
        }
        return aVar;
    }

    public final c.d xD() {
        b bVar = this.akX;
        if (bVar == null) {
            return xE();
        }
        c.d dVar = bVar.ale;
        if (dVar == null) {
            return xE();
        }
        if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize id generator: %s", dVar);
        }
        return dVar;
    }

    public final com.kwad.framework.filedownloader.b.a xz() {
        c.InterfaceC0468c interfaceC0468c;
        b bVar = this.akX;
        if (bVar == null || (interfaceC0468c = bVar.akY) == null) {
            return new com.kwad.framework.filedownloader.b.c();
        }
        com.kwad.framework.filedownloader.b.a xU = interfaceC0468c.xU();
        return xU != null ? xU : new com.kwad.framework.filedownloader.b.c();
    }

    public c(b bVar) {
        this.akX = bVar;
    }
}
