package com.shu.priory.download.b;

import com.shu.priory.download.b.a.b;
import com.shu.priory.download.b.b.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class c implements com.shu.priory.download.b.a.a, b.a, a.InterfaceC0552a {

    /* renamed from: a */
    private ExecutorService f16949a;

    /* renamed from: b */
    private com.shu.priory.download.b.a f16950b;

    /* renamed from: c */
    private com.shu.priory.download.d.a f16951c;

    /* renamed from: e */
    private a f16953e;

    /* renamed from: g */
    private long f16955g;

    /* renamed from: f */
    private long f16954f = System.currentTimeMillis();

    /* renamed from: h */
    private volatile AtomicBoolean f16956h = new AtomicBoolean(false);

    /* renamed from: d */
    private List<com.shu.priory.download.b.b.a> f16952d = new ArrayList();

    public interface a {
        void f(com.shu.priory.download.d.a aVar);

        void g(com.shu.priory.download.d.a aVar);
    }

    public c(ExecutorService executorService, com.shu.priory.download.b.a aVar, com.shu.priory.download.d.a aVar2, a aVar3) {
        this.f16949a = executorService;
        this.f16950b = aVar;
        this.f16951c = aVar2;
        this.f16953e = aVar3;
    }

    private void f() {
        this.f16955g = 0L;
        Iterator<com.shu.priory.download.d.b> it = this.f16951c.j().iterator();
        while (it.hasNext()) {
            this.f16955g += it.next().d();
        }
        this.f16951c.b(this.f16955g);
    }

    @Override // com.shu.priory.download.b.a.a
    public void a() {
        if (this.f16951c.d() <= 0) {
            this.f16949a.submit(new com.shu.priory.download.b.a.b(this.f16950b, this.f16951c, this));
            return;
        }
        Iterator<com.shu.priory.download.d.b> it = this.f16951c.j().iterator();
        while (it.hasNext()) {
            com.shu.priory.download.b.b.a aVar = new com.shu.priory.download.b.b.a(it.next(), this.f16950b, this.f16951c, this);
            this.f16949a.submit(aVar);
            this.f16952d.add(aVar);
        }
        this.f16951c.a(2);
        this.f16950b.a(this.f16951c);
    }

    @Override // com.shu.priory.download.b.a.b.a
    public void b() {
        this.f16953e.g(this.f16951c);
    }

    @Override // com.shu.priory.download.b.b.a.InterfaceC0552a
    public void c() {
        if (this.f16956h.get()) {
            return;
        }
        synchronized (this) {
            try {
                if (!this.f16956h.get()) {
                    this.f16956h.set(true);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.f16954f > 1000) {
                        f();
                        this.f16950b.a(this.f16951c);
                        this.f16954f = currentTimeMillis;
                    }
                    this.f16956h.set(false);
                }
            } finally {
            }
        }
    }

    @Override // com.shu.priory.download.b.b.a.InterfaceC0552a
    public void d() {
        f();
        if (this.f16951c.e() == this.f16951c.d()) {
            this.f16951c.a(4);
            this.f16950b.a(this.f16951c);
            a aVar = this.f16953e;
            if (aVar != null) {
                aVar.f(this.f16951c);
            }
        }
    }

    @Override // com.shu.priory.download.b.b.a.InterfaceC0552a
    public void e() {
        this.f16953e.g(this.f16951c);
    }

    @Override // com.shu.priory.download.b.a.b.a
    public void a(long j10, boolean z10) {
        this.f16951c.a(z10);
        this.f16951c.a(j10);
        ArrayList arrayList = new ArrayList();
        if (z10) {
            long d10 = this.f16951c.d();
            long j11 = d10 / 2;
            int i10 = 0;
            while (i10 < 2) {
                long j12 = j11 * i10;
                com.shu.priory.download.d.b bVar = new com.shu.priory.download.d.b(this.f16951c.b(), j12, i10 == 1 ? d10 : (j12 + j11) - 1);
                arrayList.add(bVar);
                com.shu.priory.download.b.b.a aVar = new com.shu.priory.download.b.b.a(bVar, this.f16950b, this.f16951c, this);
                this.f16949a.submit(aVar);
                this.f16952d.add(aVar);
                i10++;
            }
        } else {
            com.shu.priory.download.d.b bVar2 = new com.shu.priory.download.d.b(this.f16951c.b(), 0L, this.f16951c.d());
            arrayList.add(bVar2);
            com.shu.priory.download.b.b.a aVar2 = new com.shu.priory.download.b.b.a(bVar2, this.f16950b, this.f16951c, this);
            this.f16949a.submit(aVar2);
            this.f16952d.add(aVar2);
        }
        this.f16951c.a(arrayList);
        this.f16951c.a(2);
        this.f16950b.a(this.f16951c);
    }
}
