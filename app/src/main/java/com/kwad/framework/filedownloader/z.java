package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class z extends e implements v {
    private final ArrayList<a.InterfaceC0462a> aip = new ArrayList<>();

    @Override // com.kwad.framework.filedownloader.v
    public final boolean d(a.InterfaceC0462a interfaceC0462a) {
        return !this.aip.isEmpty() && this.aip.contains(interfaceC0462a);
    }

    @Override // com.kwad.framework.filedownloader.v
    public final void e(a.InterfaceC0462a interfaceC0462a) {
        if (this.aip.isEmpty()) {
            return;
        }
        synchronized (this.aip) {
            this.aip.remove(interfaceC0462a);
        }
    }

    @Override // com.kwad.framework.filedownloader.v
    public final boolean f(a.InterfaceC0462a interfaceC0462a) {
        r.wc();
        if (!r.we()) {
            synchronized (this.aip) {
                try {
                    r.wc();
                    if (!r.we()) {
                        if (com.kwad.framework.filedownloader.f.d.alt) {
                            com.kwad.framework.filedownloader.f.d.c(this, "Waiting for connecting with the downloader service... %d", Integer.valueOf(interfaceC0462a.vl().getId()));
                        }
                        n.vU().az(com.kwad.framework.filedownloader.f.c.xT());
                        if (!this.aip.contains(interfaceC0462a)) {
                            interfaceC0462a.free();
                            this.aip.add(interfaceC0462a);
                        }
                        return true;
                    }
                } finally {
                }
            }
        }
        e(interfaceC0462a);
        return false;
    }

    @Override // com.kwad.framework.filedownloader.e
    public final void vE() {
        w wf2 = r.wc().wf();
        if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.c(this, "The downloader service is connected.", new Object[0]);
        }
        synchronized (this.aip) {
            try {
                List<a.InterfaceC0462a> list = (List) this.aip.clone();
                this.aip.clear();
                ArrayList arrayList = new ArrayList(wf2.wj());
                for (a.InterfaceC0462a interfaceC0462a : list) {
                    int vn = interfaceC0462a.vn();
                    if (wf2.bi(vn)) {
                        interfaceC0462a.vl().uU().vt();
                        if (!arrayList.contains(Integer.valueOf(vn))) {
                            arrayList.add(Integer.valueOf(vn));
                        }
                    } else {
                        interfaceC0462a.vr();
                    }
                }
                wf2.p(arrayList);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.e
    public final void vF() {
        if (vG() != DownloadServiceConnectChangedEvent.ConnectStatus.lost) {
            if (h.vJ().size() > 0) {
                com.kwad.framework.filedownloader.f.d.d(this, "file download service has be unbound but the size of active tasks are not empty %d ", Integer.valueOf(h.vJ().size()));
                return;
            }
            return;
        }
        w wf2 = r.wc().wf();
        if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.c(this, "lost the connection to the file download service, and current active task size is %d", Integer.valueOf(h.vJ().size()));
        }
        if (h.vJ().size() > 0) {
            synchronized (this.aip) {
                try {
                    h.vJ().o(this.aip);
                    Iterator<a.InterfaceC0462a> it = this.aip.iterator();
                    while (it.hasNext()) {
                        it.next().free();
                    }
                    wf2.wi();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            r.wc().wd();
        }
    }
}
