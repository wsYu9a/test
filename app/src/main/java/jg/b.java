package jg;

import android.content.Context;
import com.tanx.exposer.achieve.AdMonitorType;
import com.tanx.exposer.achieve.retry.AdMonitorRetryType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import lg.a;
import lg.b;
import og.a;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    public Context f27560a;

    /* renamed from: b */
    public hg.c f27561b;

    /* renamed from: c */
    public jg.a f27562c;

    /* renamed from: d */
    public d f27563d;

    /* renamed from: e */
    public AtomicInteger f27564e;

    /* renamed from: f */
    public boolean f27565f;

    /* renamed from: g */
    public final a.c f27566g;

    /* renamed from: h */
    public int f27567h;

    /* renamed from: i */
    public ConcurrentLinkedQueue<ig.b> f27568i;

    public class a implements a.c {
        public a() {
        }

        @Override // og.a.c
        public void a(int i10) {
            b bVar = b.this;
            boolean z10 = i10 != -1;
            bVar.f27565f = z10;
            if (z10 && bVar.f27561b.i() != null && b.this.f27561b.i().d()) {
                b.this.a();
            }
        }
    }

    /* renamed from: jg.b$b */
    public class RunnableC0717b implements Runnable {
        public RunnableC0717b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.d.f29194a.a(b.this.f27566g);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.h();
            String a10 = sg.b.a(System.currentTimeMillis(), "yyyy-MM-dd");
            sg.a.a("AdRetryExposeManager", "currentDate=" + a10);
            b bVar = b.this;
            bVar.f27562c.d(a10, bVar.f27567h);
            b.this.m();
        }
    }

    public static class d {

        /* renamed from: a */
        public int f27572a = 500;

        /* renamed from: b */
        public int f27573b = 5;
    }

    public static class e {

        /* renamed from: a */
        public static final b f27574a = new b((byte) 0);
    }

    public /* synthetic */ b(byte b10) {
        this();
    }

    public synchronized void a() {
        try {
            int i10 = this.f27563d.f27573b - this.f27564e.get();
            sg.a.a("AdRetryExposeManager", "availableRetryCount=" + i10);
            if (i10 <= 0) {
                return;
            }
            if (this.f27568i.size() <= 0) {
                return;
            }
            sg.a.a("AdRetryExposeManager", "failedRequestQueue.size=" + this.f27568i.size());
            ArrayList arrayList = new ArrayList();
            while (true) {
                int i11 = i10 - 1;
                if (i10 <= 0) {
                    break;
                }
                ig.b poll = this.f27568i.poll();
                if (poll != null) {
                    arrayList.add(poll);
                    h();
                    this.f27562c.b(poll.d());
                }
                i10 = i11;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                j((ig.b) it.next(), true);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void b(Context context, hg.c cVar) {
        this.f27560a = context;
        this.f27561b = cVar;
        if (cVar.i() != null) {
            this.f27567h = cVar.i().f();
        }
        l();
        g();
    }

    public void c(ig.b bVar) {
        if (bVar != null && this.f27568i.contains(bVar) && this.f27568i.remove(bVar)) {
            j(bVar, false);
        }
    }

    public void d(ig.b bVar, int i10, String str, boolean z10) {
        if (bVar == null) {
            return;
        }
        if (z10) {
            this.f27564e.decrementAndGet();
        } else {
            bVar.f(AdMonitorRetryType.NONE);
            mg.b.c().b("TanxExposer", "EXPOSER_SUCCESS_POINT", String.valueOf(i10), str, bVar.j() == null ? "" : bVar.j().toString());
        }
        rg.b.f(bVar, i10, str, z10, bVar.m().name());
        h();
        if (!k(bVar)) {
            i(bVar, i10, str, false);
        } else {
            if (this.f27568i.contains(bVar)) {
                return;
            }
            n();
            this.f27568i.add(bVar);
            this.f27562c.c(bVar);
            i(bVar, i10, str, true);
        }
    }

    public void e(ig.b bVar, boolean z10) {
        if (z10) {
            this.f27564e.decrementAndGet();
        }
        if (bVar == null) {
            return;
        }
        if (!z10) {
            bVar.f(AdMonitorRetryType.NONE);
            mg.b.c().a("TanxExposer", "EXPOSER_SUCCESS_POINT", bVar.j() == null ? "" : bVar.j().toString());
        }
        rg.b.g(bVar, z10, bVar.m().name());
        kg.b h10 = hg.c.c().h();
        if (h10 != null && bVar.m() != AdMonitorRetryType.DB) {
            h10.tanxc_do(bVar.i(), bVar.l(), bVar.j());
        }
        a();
    }

    public final void g() {
        qg.b.a(new RunnableC0717b(), 10000L);
    }

    public synchronized void h() {
        if (this.f27562c == null) {
            this.f27562c = new jg.a(this.f27560a);
        }
    }

    public final void i(ig.b bVar, int i10, String str, boolean z10) {
        kg.b h10 = hg.c.c().h();
        if (h10 == null || bVar.m() == AdMonitorRetryType.DB) {
            return;
        }
        if (z10) {
            h10.tanxc_if(i10, str, bVar.i(), bVar.l(), bVar.j());
        } else {
            h10.tanxc_do(i10, str, bVar.i(), bVar.l(), bVar.j());
        }
    }

    public final void j(ig.b bVar, boolean z10) {
        if (bVar == null) {
            return;
        }
        if (z10) {
            bVar.h().incrementAndGet();
            this.f27564e.incrementAndGet();
        }
        new ng.b(this.f27561b.i().h()).a(bVar.k(), bVar.l() == AdMonitorType.EXPOSE ? new b.C0737b(bVar, z10) : new a.b(bVar, z10));
    }

    public boolean k(ig.b bVar) {
        hg.b i10 = this.f27561b.i();
        return i10 != null && i10.g() && i10.a().contains(bVar.l()) && bVar.c() > 0 && bVar.h().get() < bVar.c();
    }

    public final void l() {
        qg.b.a(new c(), 0L);
    }

    public final void m() {
        h();
        List<ig.b> a10 = this.f27562c.a(sg.b.a(System.currentTimeMillis(), "yyyy-MM-dd"));
        if (a10.isEmpty()) {
            if (sg.a.f30663a) {
                sg.a.a("AdRetryExposeManager", "sendRetryMonitor return because no retry monitor info.");
                return;
            }
            return;
        }
        int size = a10.size();
        if (sg.a.f30663a) {
            sg.a.a("AdRetryExposeManager", "sendRetryMonitor: count = " + size);
        }
        for (int i10 = 0; i10 < size; i10++) {
            ig.b bVar = a10.get(i10);
            bVar.f(AdMonitorRetryType.DB);
            if (!k(bVar)) {
                this.f27562c.b(bVar.d());
            } else if (this.f27568i.contains(bVar)) {
                this.f27562c.b(bVar.d());
            } else {
                n();
                this.f27568i.add(bVar);
            }
        }
        if (a.d.f29194a.b()) {
            a();
        } else if (sg.a.f30663a) {
            sg.a.a("AdRetryExposeManager", "sendRetryMonitor return because no net.");
        }
    }

    public final void n() {
        if (this.f27568i.size() < this.f27563d.f27572a) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.f27568i.size() - this.f27563d.f27572a);
        while (this.f27568i.size() >= this.f27563d.f27572a) {
            ig.b poll = this.f27568i.poll();
            if (poll != null) {
                arrayList.add(poll);
                h();
                this.f27562c.b(poll.d());
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            i((ig.b) it.next(), -2, "retry fail,exceed max retry count", false);
        }
    }

    public b() {
        this.f27563d = new d();
        this.f27564e = new AtomicInteger(0);
        this.f27565f = true;
        this.f27566g = new a();
        this.f27567h = 3;
        this.f27568i = new ConcurrentLinkedQueue<>();
    }
}
