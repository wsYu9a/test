package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.x;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes3.dex */
final class k implements t {
    private a.InterfaceC0462a ahU;
    private a.c ahV;
    private Queue<MessageSnapshot> ahW;
    private boolean ahX = false;

    public k(a.InterfaceC0462a interfaceC0462a, a.c cVar) {
        a(interfaceC0462a, cVar);
    }

    private void a(a.InterfaceC0462a interfaceC0462a, a.c cVar) {
        this.ahU = interfaceC0462a;
        this.ahV = cVar;
        this.ahW = new LinkedBlockingQueue();
    }

    private void bd(int i10) {
        if (com.kwad.framework.filedownloader.d.d.bG(i10)) {
            if (!this.ahW.isEmpty()) {
                MessageSnapshot peek = this.ahW.peek();
                com.kwad.framework.filedownloader.f.d.d(this, "the messenger[%s](with id[%d]) has already accomplished all his job, but there still are some messages in parcel queue[%d] queue-top-status[%d]", this, Integer.valueOf(peek.getId()), Integer.valueOf(this.ahW.size()), Byte.valueOf(peek.vd()));
            }
            this.ahU = null;
        }
    }

    private void o(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify completed %s", this.ahU);
        }
        this.ahV.vu();
        p(messageSnapshot);
    }

    private void p(MessageSnapshot messageSnapshot) {
        a.InterfaceC0462a interfaceC0462a = this.ahU;
        if (interfaceC0462a == null) {
            if (com.kwad.framework.filedownloader.f.d.alt) {
                com.kwad.framework.filedownloader.f.d.c(this, "occur this case, it would be the host task of this messenger has been over(paused/warn/completed/error) on the other thread before receiving the snapshot(id[%d], status[%d])", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.vd()));
            }
        } else {
            if (!this.ahX && interfaceC0462a.vl().va() != null) {
                this.ahW.offer(messageSnapshot);
                j.vL().a(this);
                return;
            }
            if ((l.isValid() || this.ahU.vs()) && messageSnapshot.vd() == 4) {
                this.ahV.vu();
            }
            bd(messageSnapshot.vd());
        }
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void b(a.InterfaceC0462a interfaceC0462a, a.c cVar) {
        if (this.ahU != null) {
            throw new IllegalStateException(com.kwad.framework.filedownloader.f.f.b("the messenger is working, can't re-appointment for %s", interfaceC0462a));
        }
        a(interfaceC0462a, cVar);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void f(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify pending %s", this.ahU);
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void g(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify started %s", this.ahU);
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void h(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify connected %s", this.ahU);
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void i(MessageSnapshot messageSnapshot) {
        a vl = this.ahU.vl();
        if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify progress %s %d %d", vl, Long.valueOf(vl.vb()), Long.valueOf(vl.vc()));
        }
        if (vl.uX() > 0) {
            p(messageSnapshot);
        } else if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify progress but client not request notify %s", this.ahU);
        }
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void j(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify block completed %s %s", this.ahU, Thread.currentThread().getName());
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void k(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.alt) {
            a vl = this.ahU.vl();
            com.kwad.framework.filedownloader.f.d.c(this, "notify retry %s %d %d %s", this.ahU, Integer.valueOf(vl.vg()), Integer.valueOf(vl.vh()), vl.vf());
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void l(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify warn %s", this.ahU);
        }
        this.ahV.vu();
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void m(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.alt) {
            a.InterfaceC0462a interfaceC0462a = this.ahU;
            com.kwad.framework.filedownloader.f.d.c(this, "notify error %s %s", interfaceC0462a, interfaceC0462a.vl().vf());
        }
        this.ahV.vu();
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void n(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify paused %s", this.ahU);
        }
        this.ahV.vu();
        p(messageSnapshot);
    }

    public final String toString() {
        a.InterfaceC0462a interfaceC0462a = this.ahU;
        return com.kwad.framework.filedownloader.f.f.b("%d:%s", Integer.valueOf(interfaceC0462a == null ? -1 : interfaceC0462a.vl().getId()), super.toString());
    }

    @Override // com.kwad.framework.filedownloader.t
    public final boolean vO() {
        if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify begin %s", this.ahU);
        }
        if (this.ahU == null) {
            com.kwad.framework.filedownloader.f.d.d(this, "can't begin the task, the holder fo the messenger is nil, %d", Integer.valueOf(this.ahW.size()));
            return false;
        }
        this.ahV.onBegin();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.framework.filedownloader.t
    public final void vP() {
        if (this.ahX) {
            return;
        }
        MessageSnapshot poll = this.ahW.poll();
        byte vd2 = poll.vd();
        a.InterfaceC0462a interfaceC0462a = this.ahU;
        if (interfaceC0462a == null) {
            return;
        }
        a vl = interfaceC0462a.vl();
        i va2 = vl.va();
        x.a vm = interfaceC0462a.vm();
        bd(vd2);
        if (va2 == null) {
            return;
        }
        if (vd2 == 4) {
            try {
                va2.b(vl);
                o(((com.kwad.framework.filedownloader.message.a) poll).xf());
                return;
            } catch (Throwable th2) {
                m(vm.g(th2));
                return;
            }
        }
        g gVar = va2 instanceof g ? (g) va2 : null;
        if (vd2 == -4) {
            va2.d(vl);
            return;
        }
        if (vd2 == -3) {
            va2.c(vl);
            return;
        }
        if (vd2 == -2) {
            if (gVar == null) {
                va2.c(vl, poll.xg(), poll.xh());
                return;
            } else {
                poll.xk();
                poll.xi();
                return;
            }
        }
        if (vd2 == -1) {
            va2.a(vl, poll.xl());
            return;
        }
        if (vd2 == 1) {
            if (gVar == null) {
                va2.a(vl, poll.xg(), poll.xh());
                return;
            } else {
                poll.xk();
                poll.xi();
                return;
            }
        }
        if (vd2 == 2) {
            if (gVar == null) {
                va2.a(vl, poll.getEtag(), poll.wY(), vl.getSmallFileSoFarBytes(), poll.xh());
                return;
            }
            poll.getEtag();
            poll.wY();
            poll.xi();
            return;
        }
        if (vd2 == 3) {
            if (gVar != null) {
                poll.xk();
                return;
            } else {
                va2.b(vl, poll.xg(), vl.getSmallFileTotalBytes());
                return;
            }
        }
        if (vd2 != 5) {
            if (vd2 != 6) {
                return;
            }
            va2.a(vl);
        } else if (gVar != null) {
            poll.xl();
            poll.vh();
            poll.xk();
        } else {
            poll.xl();
            poll.vh();
            poll.xg();
        }
    }

    @Override // com.kwad.framework.filedownloader.t
    public final boolean vQ() {
        return this.ahU.vl().vi();
    }

    @Override // com.kwad.framework.filedownloader.t
    public final boolean vR() {
        return this.ahW.peek().vd() == 4;
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void vS() {
        this.ahX = true;
    }
}
