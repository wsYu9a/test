package com.kwai.filedownloader;

import com.kwai.filedownloader.a;
import com.kwai.filedownloader.event.DownloadServiceConnectChangedEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class z extends e implements v {
    private final ArrayList<a.InterfaceC0236a> aGm = new ArrayList<>();

    @Override // com.kwai.filedownloader.e
    public final void GR() {
        w Hs = r.Hp().Hs();
        if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(this, "The downloader service is connected.", new Object[0]);
        }
        synchronized (this.aGm) {
            List<a.InterfaceC0236a> list = (List) this.aGm.clone();
            this.aGm.clear();
            ArrayList arrayList = new ArrayList(Hs.Hw());
            for (a.InterfaceC0236a interfaceC0236a : list) {
                int GA = interfaceC0236a.GA();
                if (Hs.cF(GA)) {
                    interfaceC0236a.Gy().Gh().GG();
                    if (!arrayList.contains(Integer.valueOf(GA))) {
                        arrayList.add(Integer.valueOf(GA));
                    }
                } else {
                    interfaceC0236a.GE();
                }
            }
            Hs.F(arrayList);
        }
    }

    @Override // com.kwai.filedownloader.e
    public final void GS() {
        if (GT() != DownloadServiceConnectChangedEvent.ConnectStatus.lost) {
            if (h.GW().size() > 0) {
                com.kwai.filedownloader.e.d.h(this, "file download service has be unbound but the size of active tasks are not empty %d ", Integer.valueOf(h.GW().size()));
                return;
            }
            return;
        }
        w Hs = r.Hp().Hs();
        if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(this, "lost the connection to the file download service, and current active task size is %d", Integer.valueOf(h.GW().size()));
        }
        if (h.GW().size() > 0) {
            synchronized (this.aGm) {
                h.GW().E(this.aGm);
                Iterator<a.InterfaceC0236a> it = this.aGm.iterator();
                while (it.hasNext()) {
                    it.next().free();
                }
                Hs.Hv();
            }
            r.Hp().Hq();
        }
    }

    @Override // com.kwai.filedownloader.v
    public final boolean d(a.InterfaceC0236a interfaceC0236a) {
        return !this.aGm.isEmpty() && this.aGm.contains(interfaceC0236a);
    }

    @Override // com.kwai.filedownloader.v
    public final void e(a.InterfaceC0236a interfaceC0236a) {
        if (this.aGm.isEmpty()) {
            return;
        }
        synchronized (this.aGm) {
            this.aGm.remove(interfaceC0236a);
        }
    }

    @Override // com.kwai.filedownloader.v
    public final boolean f(a.InterfaceC0236a interfaceC0236a) {
        r.Hp();
        if (!r.Hr()) {
            synchronized (this.aGm) {
                r.Hp();
                if (!r.Hr()) {
                    if (com.kwai.filedownloader.e.d.aJq) {
                        com.kwai.filedownloader.e.d.g(this, "Waiting for connecting with the downloader service... %d", Integer.valueOf(interfaceC0236a.Gy().getId()));
                    }
                    n.Hh().dr(com.kwai.filedownloader.e.c.IZ());
                    if (!this.aGm.contains(interfaceC0236a)) {
                        interfaceC0236a.free();
                        this.aGm.add(interfaceC0236a);
                    }
                    return true;
                }
            }
        }
        e(interfaceC0236a);
        return false;
    }
}
