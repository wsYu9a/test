package com.kwad.framework.filedownloader.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.kwad.framework.filedownloader.b.a;
import com.kwad.framework.filedownloader.f.f;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/* loaded from: classes3.dex */
public final class c implements a {
    private volatile Thread aiE;
    private Handler handler;
    private volatile List<Integer> aiC = new CopyOnWriteArrayList();
    private AtomicInteger aiD = new AtomicInteger();
    private final b aiz = new b();
    private final d aiA = new d();
    private final long aiB = com.kwad.framework.filedownloader.f.e.xV().alv;

    /* renamed from: com.kwad.framework.filedownloader.b.c$1 */
    public class AnonymousClass1 implements Handler.Callback {
        public AnonymousClass1() {
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 0) {
                if (c.this.aiE != null) {
                    LockSupport.unpark(c.this.aiE);
                    c.a(c.this, (Thread) null);
                }
                return false;
            }
            try {
                c.this.aiD.set(i10);
                c.this.bq(i10);
                c.this.aiC.add(Integer.valueOf(i10));
                return false;
            } finally {
                c.this.aiD.set(0);
                if (c.this.aiE != null) {
                    LockSupport.unpark(c.this.aiE);
                    c.a(c.this, (Thread) null);
                }
            }
        }
    }

    public c() {
        HandlerThread handlerThread = new HandlerThread(f.bB("RemitHandoverToDB"), 10);
        handlerThread.start();
        this.handler = new Handler(handlerThread.getLooper(), new Handler.Callback() { // from class: com.kwad.framework.filedownloader.b.c.1
            public AnonymousClass1() {
            }

            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                int i10 = message.what;
                if (i10 == 0) {
                    if (c.this.aiE != null) {
                        LockSupport.unpark(c.this.aiE);
                        c.a(c.this, (Thread) null);
                    }
                    return false;
                }
                try {
                    c.this.aiD.set(i10);
                    c.this.bq(i10);
                    c.this.aiC.add(Integer.valueOf(i10));
                    return false;
                } finally {
                    c.this.aiD.set(0);
                    if (c.this.aiE != null) {
                        LockSupport.unpark(c.this.aiE);
                        c.a(c.this, (Thread) null);
                    }
                }
            }
        });
    }

    public void bq(int i10) {
        this.aiA.b(this.aiz.bl(i10));
        List<com.kwad.framework.filedownloader.d.a> bm = this.aiz.bm(i10);
        this.aiA.bn(i10);
        Iterator<com.kwad.framework.filedownloader.d.a> it = bm.iterator();
        while (it.hasNext()) {
            this.aiA.a(it.next());
        }
    }

    private boolean br(int i10) {
        return !this.aiC.contains(Integer.valueOf(i10));
    }

    private void bs(int i10) {
        this.handler.removeMessages(i10);
        if (this.aiD.get() != i10) {
            bq(i10);
            return;
        }
        this.aiE = Thread.currentThread();
        this.handler.sendEmptyMessage(0);
        LockSupport.park();
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bk(int i10) {
        this.handler.sendEmptyMessageDelayed(i10, this.aiB);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final com.kwad.framework.filedownloader.d.c bl(int i10) {
        return this.aiz.bl(i10);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final List<com.kwad.framework.filedownloader.d.a> bm(int i10) {
        return this.aiz.bm(i10);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bn(int i10) {
        this.aiz.bn(i10);
        if (br(i10)) {
            return;
        }
        this.aiA.bn(i10);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final boolean bo(int i10) {
        this.aiA.bo(i10);
        return this.aiz.bo(i10);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bp(int i10) {
        this.aiz.bp(i10);
        if (br(i10)) {
            return;
        }
        this.aiA.bp(i10);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void clear() {
        this.aiz.clear();
        this.aiA.clear();
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void d(int i10, long j10) {
        this.aiz.d(i10, j10);
        if (br(i10)) {
            bs(i10);
        }
        this.aiA.d(i10, j10);
        this.aiC.remove(Integer.valueOf(i10));
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void s(int i10, int i11) {
        this.aiz.s(i10, i11);
        if (br(i10)) {
            return;
        }
        this.aiA.s(i10, i11);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final a.InterfaceC0463a wn() {
        d dVar = this.aiA;
        b bVar = this.aiz;
        return dVar.a(bVar.aiw, bVar.aix);
    }

    public static /* synthetic */ Thread a(c cVar, Thread thread) {
        cVar.aiE = null;
        return null;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(int i10, long j10) {
        this.aiz.b(i10, j10);
        if (br(i10)) {
            return;
        }
        this.aiA.b(i10, j10);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void c(int i10, long j10) {
        this.aiz.c(i10, j10);
        if (br(i10)) {
            this.handler.removeMessages(i10);
            if (this.aiD.get() == i10) {
                this.aiE = Thread.currentThread();
                this.handler.sendEmptyMessage(0);
                LockSupport.park();
            }
            this.aiC.remove(Integer.valueOf(i10));
        }
        this.aiA.c(i10, j10);
        this.aiC.remove(Integer.valueOf(i10));
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(com.kwad.framework.filedownloader.d.a aVar) {
        this.aiz.a(aVar);
        if (br(aVar.getId())) {
            return;
        }
        this.aiA.a(aVar);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(com.kwad.framework.filedownloader.d.c cVar) {
        this.aiz.b(cVar);
        if (br(cVar.getId())) {
            return;
        }
        this.aiA.b(cVar);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i10, int i11, long j10) {
        this.aiz.a(i10, i11, j10);
        if (br(i10)) {
            return;
        }
        this.aiA.a(i10, i11, j10);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i10, String str, long j10, long j11, int i11) {
        this.aiz.a(i10, str, j10, j11, i11);
        if (br(i10)) {
            return;
        }
        this.aiA.a(i10, str, j10, j11, i11);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i10, long j10, String str, String str2) {
        this.aiz.a(i10, j10, str, str2);
        if (br(i10)) {
            return;
        }
        this.aiA.a(i10, j10, str, str2);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i10, Throwable th2) {
        this.aiz.a(i10, th2);
        if (br(i10)) {
            return;
        }
        this.aiA.a(i10, th2);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i10, Throwable th2, long j10) {
        this.aiz.a(i10, th2, j10);
        if (br(i10)) {
            bs(i10);
        }
        this.aiA.a(i10, th2, j10);
        this.aiC.remove(Integer.valueOf(i10));
    }
}
