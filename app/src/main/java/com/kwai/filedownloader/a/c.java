package com.kwai.filedownloader.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.kwai.filedownloader.a.a;
import com.kwai.filedownloader.e.f;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/* loaded from: classes2.dex */
public final class c implements a {
    private volatile Thread aGB;
    private Handler handler;
    private volatile List<Integer> aGz = new CopyOnWriteArrayList();
    private AtomicInteger aGA = new AtomicInteger();
    private final b aGw = new b();
    private final d aGx = new d();
    private final long aGy = com.kwai.filedownloader.e.e.Jb().aJs;

    /* renamed from: com.kwai.filedownloader.a.c$1 */
    final class AnonymousClass1 implements Handler.Callback {
        AnonymousClass1() {
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                if (c.this.aGB != null) {
                    LockSupport.unpark(c.this.aGB);
                    c.a(c.this, (Thread) null);
                }
                return false;
            }
            try {
                c.this.aGA.set(i2);
                c.this.cN(i2);
                c.this.aGz.add(Integer.valueOf(i2));
                return false;
            } finally {
                c.this.aGA.set(0);
                if (c.this.aGB != null) {
                    LockSupport.unpark(c.this.aGB);
                    c.a(c.this, (Thread) null);
                }
            }
        }
    }

    public c() {
        HandlerThread handlerThread = new HandlerThread(f.fE("RemitHandoverToDB"), 10);
        handlerThread.start();
        this.handler = new Handler(handlerThread.getLooper(), new Handler.Callback() { // from class: com.kwai.filedownloader.a.c.1
            AnonymousClass1() {
            }

            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                int i2 = message.what;
                if (i2 == 0) {
                    if (c.this.aGB != null) {
                        LockSupport.unpark(c.this.aGB);
                        c.a(c.this, (Thread) null);
                    }
                    return false;
                }
                try {
                    c.this.aGA.set(i2);
                    c.this.cN(i2);
                    c.this.aGz.add(Integer.valueOf(i2));
                    return false;
                } finally {
                    c.this.aGA.set(0);
                    if (c.this.aGB != null) {
                        LockSupport.unpark(c.this.aGB);
                        c.a(c.this, (Thread) null);
                    }
                }
            }
        });
    }

    static /* synthetic */ Thread a(c cVar, Thread thread) {
        cVar.aGB = null;
        return null;
    }

    public void cN(int i2) {
        this.aGx.b(this.aGw.cI(i2));
        List<com.kwai.filedownloader.c.a> cJ = this.aGw.cJ(i2);
        this.aGx.cK(i2);
        Iterator<com.kwai.filedownloader.c.a> it = cJ.iterator();
        while (it.hasNext()) {
            this.aGx.a(it.next());
        }
    }

    private boolean cO(int i2) {
        return !this.aGz.contains(Integer.valueOf(i2));
    }

    private void cP(int i2) {
        this.handler.removeMessages(i2);
        if (this.aGA.get() != i2) {
            cN(i2);
            return;
        }
        this.aGB = Thread.currentThread();
        this.handler.sendEmptyMessage(0);
        LockSupport.park();
    }

    @Override // com.kwai.filedownloader.a.a
    public final void A(int i2, int i3) {
        this.aGw.A(i2, i3);
        if (cO(i2)) {
            return;
        }
        this.aGx.A(i2, i3);
    }

    @Override // com.kwai.filedownloader.a.a
    public final a.InterfaceC0237a Hx() {
        d dVar = this.aGx;
        b bVar = this.aGw;
        return dVar.a(bVar.aGt, bVar.aGu);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i2, int i3, long j2) {
        this.aGw.a(i2, i3, j2);
        if (cO(i2)) {
            return;
        }
        this.aGx.a(i2, i3, j2);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i2, long j2, String str, String str2) {
        this.aGw.a(i2, j2, str, str2);
        if (cO(i2)) {
            return;
        }
        this.aGx.a(i2, j2, str, str2);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i2, String str, long j2, long j3, int i3) {
        this.aGw.a(i2, str, j2, j3, i3);
        if (cO(i2)) {
            return;
        }
        this.aGx.a(i2, str, j2, j3, i3);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i2, Throwable th) {
        this.aGw.a(i2, th);
        if (cO(i2)) {
            return;
        }
        this.aGx.a(i2, th);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i2, Throwable th, long j2) {
        this.aGw.a(i2, th, j2);
        if (cO(i2)) {
            cP(i2);
        }
        this.aGx.a(i2, th, j2);
        this.aGz.remove(Integer.valueOf(i2));
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(com.kwai.filedownloader.c.a aVar) {
        this.aGw.a(aVar);
        if (cO(aVar.getId())) {
            return;
        }
        this.aGx.a(aVar);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void b(com.kwai.filedownloader.c.c cVar) {
        this.aGw.b(cVar);
        if (cO(cVar.getId())) {
            return;
        }
        this.aGx.b(cVar);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void cH(int i2) {
        this.handler.sendEmptyMessageDelayed(i2, this.aGy);
    }

    @Override // com.kwai.filedownloader.a.a
    public final com.kwai.filedownloader.c.c cI(int i2) {
        return this.aGw.cI(i2);
    }

    @Override // com.kwai.filedownloader.a.a
    public final List<com.kwai.filedownloader.c.a> cJ(int i2) {
        return this.aGw.cJ(i2);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void cK(int i2) {
        this.aGw.cK(i2);
        if (cO(i2)) {
            return;
        }
        this.aGx.cK(i2);
    }

    @Override // com.kwai.filedownloader.a.a
    public final boolean cL(int i2) {
        this.aGx.cL(i2);
        return this.aGw.cL(i2);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void cM(int i2) {
        this.aGw.cM(i2);
        if (cO(i2)) {
            return;
        }
        this.aGx.cM(i2);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void clear() {
        this.aGw.clear();
        this.aGx.clear();
    }

    @Override // com.kwai.filedownloader.a.a
    public final void e(int i2, long j2) {
        this.aGw.e(i2, j2);
        if (cO(i2)) {
            return;
        }
        this.aGx.e(i2, j2);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void f(int i2, long j2) {
        this.aGw.f(i2, j2);
        if (cO(i2)) {
            this.handler.removeMessages(i2);
            if (this.aGA.get() == i2) {
                this.aGB = Thread.currentThread();
                this.handler.sendEmptyMessage(0);
                LockSupport.park();
            }
            this.aGz.remove(Integer.valueOf(i2));
        }
        this.aGx.f(i2, j2);
        this.aGz.remove(Integer.valueOf(i2));
    }

    @Override // com.kwai.filedownloader.a.a
    public final void g(int i2, long j2) {
        this.aGw.g(i2, j2);
        if (cO(i2)) {
            cP(i2);
        }
        this.aGx.g(i2, j2);
        this.aGz.remove(Integer.valueOf(i2));
    }
}
