package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class h {
    private final ArrayList<a.InterfaceC0462a> ahJ;

    public static final class a {
        private static final h ahK = new h((byte) 0);
    }

    public /* synthetic */ h(byte b10) {
        this();
    }

    public static h vJ() {
        return a.ahK;
    }

    public final boolean a(a.InterfaceC0462a interfaceC0462a) {
        return this.ahJ.isEmpty() || !this.ahJ.contains(interfaceC0462a);
    }

    public final void b(a.InterfaceC0462a interfaceC0462a) {
        if (!interfaceC0462a.vl().uW()) {
            interfaceC0462a.vo();
        }
        if (interfaceC0462a.vm().vB().vO()) {
            c(interfaceC0462a);
        }
    }

    public final int ba(int i10) {
        int i11;
        synchronized (this.ahJ) {
            try {
                Iterator<a.InterfaceC0462a> it = this.ahJ.iterator();
                i11 = 0;
                while (it.hasNext()) {
                    if (it.next().aZ(i10)) {
                        i11++;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return i11;
    }

    public final List<a.InterfaceC0462a> bb(int i10) {
        byte vd2;
        ArrayList arrayList = new ArrayList();
        synchronized (this.ahJ) {
            try {
                Iterator<a.InterfaceC0462a> it = this.ahJ.iterator();
                while (it.hasNext()) {
                    a.InterfaceC0462a next = it.next();
                    if (next.aZ(i10) && !next.isOver() && (vd2 = next.vl().vd()) != 0 && vd2 != 10) {
                        arrayList.add(next);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return arrayList;
    }

    public final List<a.InterfaceC0462a> bc(int i10) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.ahJ) {
            try {
                Iterator<a.InterfaceC0462a> it = this.ahJ.iterator();
                while (it.hasNext()) {
                    a.InterfaceC0462a next = it.next();
                    if (next.aZ(i10) && !next.isOver()) {
                        arrayList.add(next);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return arrayList;
    }

    public final void c(a.InterfaceC0462a interfaceC0462a) {
        if (interfaceC0462a.vp()) {
            return;
        }
        synchronized (this.ahJ) {
            try {
                if (this.ahJ.contains(interfaceC0462a)) {
                    com.kwad.framework.filedownloader.f.d.d(this, "already has %s", interfaceC0462a);
                } else {
                    interfaceC0462a.vq();
                    this.ahJ.add(interfaceC0462a);
                    if (com.kwad.framework.filedownloader.f.d.alt) {
                        com.kwad.framework.filedownloader.f.d.e(this, "add list in all %s %d %d", interfaceC0462a, Byte.valueOf(interfaceC0462a.vl().vd()), Integer.valueOf(this.ahJ.size()));
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void o(List<a.InterfaceC0462a> list) {
        synchronized (this.ahJ) {
            try {
                Iterator<a.InterfaceC0462a> it = this.ahJ.iterator();
                while (it.hasNext()) {
                    a.InterfaceC0462a next = it.next();
                    if (!list.contains(next)) {
                        list.add(next);
                    }
                }
                this.ahJ.clear();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final int size() {
        return this.ahJ.size();
    }

    private h() {
        this.ahJ = new ArrayList<>();
    }

    public final boolean a(a.InterfaceC0462a interfaceC0462a, MessageSnapshot messageSnapshot) {
        boolean remove;
        byte vd2 = messageSnapshot.vd();
        synchronized (this.ahJ) {
            remove = this.ahJ.remove(interfaceC0462a);
        }
        if (com.kwad.framework.filedownloader.f.d.alt && this.ahJ.size() == 0) {
            com.kwad.framework.filedownloader.f.d.e(this, "remove %s left %d %d", interfaceC0462a, Byte.valueOf(vd2), Integer.valueOf(this.ahJ.size()));
        }
        if (remove) {
            t vB = interfaceC0462a.vm().vB();
            if (vd2 == -4) {
                vB.l(messageSnapshot);
            } else if (vd2 == -3) {
                vB.j(com.kwad.framework.filedownloader.message.f.t(messageSnapshot));
            } else if (vd2 == -2) {
                vB.n(messageSnapshot);
            } else if (vd2 == -1) {
                vB.m(messageSnapshot);
            }
        } else {
            com.kwad.framework.filedownloader.f.d.a(this, "remove error, not exist: %s %d", interfaceC0462a, Byte.valueOf(vd2));
        }
        return remove;
    }
}
