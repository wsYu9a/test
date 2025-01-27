package com.opos.mobad.f.a.a;

import android.os.SystemClock;
import com.opos.mobad.f.a.a.n;
import com.opos.mobad.service.a.e;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class c<T extends n> extends com.opos.mobad.l.j implements m, n, o {

    /* renamed from: a */
    private String f20565a;

    /* renamed from: b */
    private T f20566b;

    /* renamed from: c */
    private volatile T f20567c;

    /* renamed from: d */
    private volatile boolean f20568d;

    /* renamed from: g */
    private volatile boolean f20569g;

    /* renamed from: h */
    private a<T> f20570h;

    /* renamed from: i */
    private int f20571i;

    /* renamed from: com.opos.mobad.f.a.a.c$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f20572a;

        /* renamed from: b */
        final /* synthetic */ int f20573b;

        /* renamed from: com.opos.mobad.f.a.a.c$1$1 */
        class CallableC04431 implements Callable<e.b> {
            CallableC04431() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public e.b call() throws Exception {
                return c.this.a(r0.f20571i);
            }
        }

        /* renamed from: com.opos.mobad.f.a.a.c$1$2 */
        class AnonymousClass2 implements Runnable {
            AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                c.this.d(str, i2);
            }
        }

        AnonymousClass1(String str, int i2) {
            str = str;
            i2 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.b b2;
            com.opos.cmn.an.f.a.b("dispatcherW", "init and load ad");
            if (!c.this.f20568d) {
                FutureTask futureTask = new FutureTask(new Callable<e.b>() { // from class: com.opos.mobad.f.a.a.c.1.1
                    CallableC04431() {
                    }

                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public e.b call() throws Exception {
                        return c.this.a(r0.f20571i);
                    }
                });
                com.opos.cmn.an.j.b.c(futureTask);
                try {
                    b2 = (e.b) futureTask.get(c.this.f20571i, TimeUnit.MILLISECONDS);
                } catch (Exception unused) {
                    com.opos.cmn.an.f.a.b("dispatcherW", "init timeout");
                    b2 = c.this.b(com.opos.mobad.service.f.b().a(c.this.f20565a, true));
                }
                if (b2 != null) {
                    c.this.c(b2);
                }
            }
            ((com.opos.mobad.l.j) c.this).f21202e.post(new Runnable() { // from class: com.opos.mobad.f.a.a.c.1.2
                AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    c.this.d(str, i2);
                }
            });
        }
    }

    /* renamed from: com.opos.mobad.f.a.a.c$2 */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.p();
        }
    }

    public interface a<T extends n> {
        int a(int i2);

        T a(List<e.a> list, e.a aVar, long j2);

        T a(List<e.a> list, e.a aVar, long j2, int i2);
    }

    public c(String str, int i2, a<T> aVar) {
        super(null);
        this.f20568d = false;
        this.f20569g = false;
        this.f20565a = str;
        this.f20571i = i2;
        this.f20570h = aVar;
        this.f20566b = q();
        p();
    }

    private static e.a a(String str, List<e.a> list, e.a aVar, long j2) {
        boolean z;
        boolean z2 = false;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        loop0: while (true) {
            z = false;
            for (e.a aVar2 : list) {
                i3 = aVar2.f23523d;
                i4 = aVar2.f23524e;
                int i5 = aVar2.f23525f;
                i2 += i5;
                z2 = z2 || 1 == aVar2.f23520a;
                if (z || (aVar != null && aVar.f23520a == aVar2.f23520a && i5 > 0)) {
                    z = true;
                }
            }
            break loop0;
        }
        if (!z2 && i2 < 100) {
            list.add(new e.a(1, str, 100 - i2, j2, i3, i4));
            z2 = true;
        }
        if (!z && aVar != null) {
            return aVar;
        }
        if (z2) {
            return null;
        }
        return new e.a(1, str, 100, j2, i3, i4);
    }

    private static e.a a(List<e.a> list, String str, long j2) {
        if (list == null) {
            list = new ArrayList<>();
        }
        e.a aVar = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (e.a aVar2 : list) {
            if (1 == aVar2.f23520a) {
                aVar = aVar2;
            }
            i3 = aVar2.f23523d;
            i4 = aVar2.f23524e;
            i2 += aVar2.f23525f;
        }
        if (aVar != null) {
            return aVar;
        }
        e.a aVar3 = new e.a(1, str, Math.max(0, 100 - i2), j2, i3, i4);
        list.add(aVar3);
        return aVar3;
    }

    private boolean a(e.b bVar) {
        for (e.a aVar : bVar.f23527a) {
            if (aVar != null) {
                int a2 = this.f20570h.a(aVar.f23520a);
                if (a2 != 0 && 2 != a2 && 3 != a2) {
                    com.opos.cmn.an.f.a.b("dispatcherW", "has channel not init " + aVar.f23520a);
                    return false;
                }
                com.opos.cmn.an.f.a.b("dispatcherW", "has channel init " + aVar.f23520a);
            }
        }
        return true;
    }

    public e.b b(e.b bVar) {
        if (bVar == null) {
            return null;
        }
        List<e.a> list = bVar.f23527a;
        if (list == null || list.size() <= 0) {
            return bVar;
        }
        ArrayList arrayList = new ArrayList();
        for (e.a aVar : bVar.f23527a) {
            if (aVar != null && this.f20570h.a(aVar.f23520a) == 0) {
                arrayList.add(aVar);
            }
        }
        return new e.b(arrayList, bVar.f23531e, bVar.f23528b, bVar.f23529c, bVar.f23530d);
    }

    private static e.a c(String str) {
        return new e.a(1, str, 100, 30000L, 0, 0);
    }

    public void c(e.b bVar) {
        T a2;
        synchronized (this) {
            com.opos.cmn.an.f.a.b("dispatcherW", "initDispatcher:" + this.f20569g + "," + this.f20568d, bVar);
            if (!this.f20569g && !this.f20568d) {
                List<e.a> list = bVar.f23527a;
                if (list != null && list.size() > 0) {
                    if (1 != bVar.f23531e) {
                        e.a a3 = a(bVar.f23527a, this.f20565a, bVar.f23529c);
                        com.opos.cmn.an.f.a.b("dispatcherW", "create ssp:", this.f20565a, bVar.f23527a, a3);
                        a2 = this.f20570h.a(bVar.f23527a, a3, bVar.f23530d, bVar.f23531e);
                    } else {
                        e.a a4 = a(this.f20565a, bVar.f23527a, bVar.f23528b, bVar.f23529c);
                        com.opos.cmn.an.f.a.b("dispatcherW", "create serial:", this.f20565a, bVar.f23527a, a4);
                        a2 = this.f20570h.a(bVar.f23527a, a4, bVar.f23530d);
                    }
                    this.f20568d = true;
                    com.opos.cmn.an.f.a.b("dispatcherW", "dispatcher succ");
                    this.f20567c = a2;
                    if (this.f20569g) {
                        a2.b();
                    }
                }
                com.opos.cmn.an.f.a.b("dispatcherW", "strategy size 0 ");
                this.f20568d = true;
            }
        }
    }

    private void c(String str, int i2) {
        if (this.f20567c != null) {
            com.opos.cmn.an.f.a.b("dispatcherW", "reset to target");
            T t = this.f20566b;
            this.f20566b = this.f20567c;
            t.b();
            this.f20567c = null;
        }
        this.f20566b.a(str, i2);
    }

    public void d(String str, int i2) {
        try {
            c(str, i2);
        } finally {
            o();
        }
    }

    private void m() {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.f.a.a.c.2
            AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.p();
            }
        });
    }

    public void p() {
        e.b a2 = a(0L);
        if (a2 != null) {
            c(a2);
        }
    }

    private T q() {
        return this.f20570h.a(new ArrayList(), c(this.f20565a), 0L);
    }

    public e.b a(long j2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        e.b a2 = com.opos.mobad.service.f.b().a(this.f20565a, true);
        com.opos.cmn.an.f.a.b("dispatcherW", "channelStrategy = " + a2);
        if (a2 != null && a(a2)) {
            return a2;
        }
        if (j2 > 0) {
            for (int i2 = 0; i2 < 10; i2++) {
                a2 = com.opos.mobad.service.f.b().a(this.f20565a, true);
                if (a2 != null && a(a2)) {
                    return a2;
                }
                int elapsedRealtime2 = ((int) (j2 - (SystemClock.elapsedRealtime() - elapsedRealtime))) / (10 - i2);
                if (elapsedRealtime2 > 0) {
                    try {
                        Thread.sleep(elapsedRealtime2);
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.b("dispatcherW", "sleep timeout", e2);
                    }
                }
            }
            return b(a2);
        }
        return null;
    }

    @Override // com.opos.mobad.f.a.a.m
    public void a(int i2, int i3) {
        T t = this.f20566b;
        if (t instanceof m) {
            ((m) t).a(i2, i3);
        }
    }

    @Override // com.opos.mobad.f.a.a.n
    public void a(int i2, int i3, String str) {
        this.f20566b.a(i2, i3, str);
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void b() {
        com.opos.cmn.an.f.a.b("dispatcherW", "destroy");
        this.f20569g = true;
        super.b();
        T t = this.f20566b;
        if (t != null) {
            t.b();
        }
        if (this.f20567c != null) {
            this.f20567c.b();
        }
    }

    @Override // com.opos.mobad.l.j
    protected boolean b(String str) {
        return false;
    }

    @Override // com.opos.mobad.l.j
    protected boolean b(String str, int i2) {
        if (!this.f20568d) {
            if (this.f20571i > 0) {
                com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.f.a.a.c.1

                    /* renamed from: a */
                    final /* synthetic */ String f20572a;

                    /* renamed from: b */
                    final /* synthetic */ int f20573b;

                    /* renamed from: com.opos.mobad.f.a.a.c$1$1 */
                    class CallableC04431 implements Callable<e.b> {
                        CallableC04431() {
                        }

                        @Override // java.util.concurrent.Callable
                        /* renamed from: a */
                        public e.b call() throws Exception {
                            return c.this.a(r0.f20571i);
                        }
                    }

                    /* renamed from: com.opos.mobad.f.a.a.c$1$2 */
                    class AnonymousClass2 implements Runnable {
                        AnonymousClass2() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            c.this.d(str, i2);
                        }
                    }

                    AnonymousClass1(String str2, int i22) {
                        str = str2;
                        i2 = i22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        e.b b2;
                        com.opos.cmn.an.f.a.b("dispatcherW", "init and load ad");
                        if (!c.this.f20568d) {
                            FutureTask futureTask = new FutureTask(new Callable<e.b>() { // from class: com.opos.mobad.f.a.a.c.1.1
                                CallableC04431() {
                                }

                                @Override // java.util.concurrent.Callable
                                /* renamed from: a */
                                public e.b call() throws Exception {
                                    return c.this.a(r0.f20571i);
                                }
                            });
                            com.opos.cmn.an.j.b.c(futureTask);
                            try {
                                b2 = (e.b) futureTask.get(c.this.f20571i, TimeUnit.MILLISECONDS);
                            } catch (Exception unused) {
                                com.opos.cmn.an.f.a.b("dispatcherW", "init timeout");
                                b2 = c.this.b(com.opos.mobad.service.f.b().a(c.this.f20565a, true));
                            }
                            if (b2 != null) {
                                c.this.c(b2);
                            }
                        }
                        ((com.opos.mobad.l.j) c.this).f21202e.post(new Runnable() { // from class: com.opos.mobad.f.a.a.c.1.2
                            AnonymousClass2() {
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                c.this.d(str, i2);
                            }
                        });
                    }
                });
                return true;
            }
            m();
        }
        d(str2, i22);
        return true;
    }

    @Override // com.opos.mobad.ad.b
    public int c() {
        return this.f20566b.c();
    }

    @Override // com.opos.mobad.f.a.a.n
    public void d(int i2) {
        this.f20566b.d(i2);
    }

    @Override // com.opos.mobad.f.a.a.n
    public void e(int i2) {
        this.f20566b.e(i2);
    }

    @Override // com.opos.mobad.f.a.a.o
    public List h() {
        T t = this.f20566b;
        if (!(t instanceof o)) {
            return null;
        }
        ((o) t).h();
        return null;
    }

    @Override // com.opos.mobad.f.a.a.n
    public com.opos.mobad.ad.b i() {
        return this.f20566b.i();
    }

    @Override // com.opos.mobad.f.a.a.n
    public int j() {
        return this.f20566b.j();
    }

    @Override // com.opos.mobad.f.a.a.n
    public e.a k() {
        return this.f20566b.k();
    }
}
