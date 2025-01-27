package com.kwai.filedownloader;

import com.kwai.filedownloader.a;
import com.kwai.filedownloader.message.MessageSnapshot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class h {
    private final ArrayList<a.InterfaceC0236a> aFG;

    static final class a {
        private static final h aFH = new h((byte) 0);
    }

    private h() {
        this.aFG = new ArrayList<>();
    }

    /* synthetic */ h(byte b2) {
        this();
    }

    public static h GW() {
        return a.aFH;
    }

    final void E(List<a.InterfaceC0236a> list) {
        synchronized (this.aFG) {
            Iterator<a.InterfaceC0236a> it = this.aFG.iterator();
            while (it.hasNext()) {
                a.InterfaceC0236a next = it.next();
                if (!list.contains(next)) {
                    list.add(next);
                }
            }
            this.aFG.clear();
        }
    }

    final boolean a(a.InterfaceC0236a interfaceC0236a) {
        return this.aFG.isEmpty() || !this.aFG.contains(interfaceC0236a);
    }

    public final boolean a(a.InterfaceC0236a interfaceC0236a, MessageSnapshot messageSnapshot) {
        boolean remove;
        byte Gq = messageSnapshot.Gq();
        synchronized (this.aFG) {
            remove = this.aFG.remove(interfaceC0236a);
        }
        if (com.kwai.filedownloader.e.d.aJq && this.aFG.size() == 0) {
            com.kwai.filedownloader.e.d.i(this, "remove %s left %d %d", interfaceC0236a, Byte.valueOf(Gq), Integer.valueOf(this.aFG.size()));
        }
        if (remove) {
            t GO = interfaceC0236a.Gz().GO();
            if (Gq == -4) {
                GO.l(messageSnapshot);
            } else if (Gq == -3) {
                GO.j(com.kwai.filedownloader.message.f.t(messageSnapshot));
            } else if (Gq == -2) {
                GO.n(messageSnapshot);
            } else if (Gq == -1) {
                GO.m(messageSnapshot);
            }
        } else {
            com.kwai.filedownloader.e.d.e(this, "remove error, not exist: %s %d", interfaceC0236a, Byte.valueOf(Gq));
        }
        return remove;
    }

    final void b(a.InterfaceC0236a interfaceC0236a) {
        if (!interfaceC0236a.Gy().Gj()) {
            interfaceC0236a.GB();
        }
        if (interfaceC0236a.Gz().GO().Hb()) {
            c(interfaceC0236a);
        }
    }

    final void c(a.InterfaceC0236a interfaceC0236a) {
        if (interfaceC0236a.GC()) {
            return;
        }
        synchronized (this.aFG) {
            if (this.aFG.contains(interfaceC0236a)) {
                com.kwai.filedownloader.e.d.h(this, "already has %s", interfaceC0236a);
            } else {
                interfaceC0236a.GD();
                this.aFG.add(interfaceC0236a);
                if (com.kwai.filedownloader.e.d.aJq) {
                    com.kwai.filedownloader.e.d.i(this, "add list in all %s %d %d", interfaceC0236a, Byte.valueOf(interfaceC0236a.Gy().Gq()), Integer.valueOf(this.aFG.size()));
                }
            }
        }
    }

    final int cx(int i2) {
        int i3;
        synchronized (this.aFG) {
            Iterator<a.InterfaceC0236a> it = this.aFG.iterator();
            i3 = 0;
            while (it.hasNext()) {
                if (it.next().cw(i2)) {
                    i3++;
                }
            }
        }
        return i3;
    }

    final List<a.InterfaceC0236a> cy(int i2) {
        byte Gq;
        ArrayList arrayList = new ArrayList();
        synchronized (this.aFG) {
            Iterator<a.InterfaceC0236a> it = this.aFG.iterator();
            while (it.hasNext()) {
                a.InterfaceC0236a next = it.next();
                if (next.cw(i2) && !next.isOver() && (Gq = next.Gy().Gq()) != 0 && Gq != 10) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    final List<a.InterfaceC0236a> cz(int i2) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.aFG) {
            Iterator<a.InterfaceC0236a> it = this.aFG.iterator();
            while (it.hasNext()) {
                a.InterfaceC0236a next = it.next();
                if (next.cw(i2) && !next.isOver()) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    final int size() {
        return this.aFG.size();
    }
}
