package com.opos.cmn.func.dl.base.a;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.opos.cmn.func.dl.base.DownloadRequest;
import com.opos.cmn.func.dl.base.a.a;
import com.opos.cmn.func.dl.base.a.a.e;
import com.opos.cmn.func.dl.base.a.a.f;
import com.opos.cmn.func.dl.base.exception.DlException;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes4.dex */
public class c implements d, Comparable<c> {

    /* renamed from: d */
    private static final String f17264d = c.class.getSimpleName();

    /* renamed from: a */
    public b f17265a;

    /* renamed from: b */
    public com.opos.cmn.func.dl.base.g.a f17266b;

    /* renamed from: c */
    public f f17267c;

    /* renamed from: e */
    private Context f17268e;

    /* renamed from: f */
    private com.opos.cmn.func.dl.base.e.b f17269f;

    /* renamed from: g */
    private com.opos.cmn.func.dl.base.d f17270g;

    /* renamed from: h */
    private com.opos.cmn.func.dl.base.f.a f17271h;

    /* renamed from: i */
    private com.opos.cmn.func.dl.base.b.c f17272i;

    /* renamed from: j */
    private com.opos.cmn.func.dl.base.a.b.a f17273j;
    private List<com.opos.cmn.func.dl.base.e.c> k;
    private com.opos.cmn.func.dl.base.a.a l;
    private CountDownLatch m;
    private Lock n = new ReentrantLock();
    private AtomicLong o = new AtomicLong(0);
    private List<com.opos.cmn.func.dl.base.a.a.c> p = new ArrayList();
    private long q;

    public final class a implements f {
        public a() {
        }

        @Override // com.opos.cmn.func.dl.base.a.a.f
        public final void a() {
            File a2 = c.this.f17265a.a();
            if (!com.opos.cmn.an.d.b.a.a(c.this.f17265a.f17260j, a2)) {
                com.opos.cmn.an.f.a.c(c.f17264d, "Rename failed");
                throw new DlException(1004);
            }
            if (!com.opos.cmn.func.dl.base.h.a.a(c.this.f17265a.k, a2)) {
                long length = a2.length();
                long j2 = c.this.f17265a.k;
                com.opos.cmn.an.f.a.c(c.f17264d, "Length check Failed!Server=" + j2 + ",local=" + length);
                throw new DlException(1010, String.valueOf(j2), String.valueOf(length));
            }
            if (com.opos.cmn.func.dl.base.h.a.a(c.this.f17265a.f17254d, a2)) {
                c.this.f17266b.h();
                c.this.d();
                return;
            }
            String a3 = com.opos.cmn.an.a.c.a(a2);
            String str = c.this.f17265a.f17254d;
            com.opos.cmn.an.f.a.c(c.f17264d, "MD5 check Failed!Server=" + str + ",local=" + a3);
            throw new DlException(1005, String.valueOf(str), String.valueOf(a3));
        }

        @Override // com.opos.cmn.func.dl.base.a.a.f
        public final void a(com.opos.cmn.func.dl.base.a.a.a aVar) {
            com.opos.cmn.func.dl.base.a.a.d a2 = c.this.f17271h.a();
            for (e eVar : a2.f17244b) {
                if (eVar.f17248c.containsKey(Integer.valueOf(aVar.f17226b))) {
                    eVar.a(aVar);
                    return;
                }
            }
            e eVar2 = null;
            for (e eVar3 : a2.f17244b) {
                if (eVar2 == null || eVar2.a() > eVar3.a()) {
                    eVar2 = eVar3;
                }
            }
            if (eVar2 != null) {
                eVar2.a(aVar);
            }
        }

        @Override // com.opos.cmn.func.dl.base.a.a.f
        public final void a(com.opos.cmn.func.dl.base.e.c cVar) {
            com.opos.cmn.an.f.a.b(c.f17264d, "url: " + c.this.f17265a.f17255e + " finish a read thread! ThreadInfo=" + cVar.toString() + ",use time:" + (System.currentTimeMillis() - c.this.q));
        }

        @Override // com.opos.cmn.func.dl.base.a.a.f
        public final void a(DlException dlException) {
            c.this.a(dlException);
        }

        @Override // com.opos.cmn.func.dl.base.a.a.f
        public final void b(com.opos.cmn.func.dl.base.a.a.a aVar) {
            int i2 = aVar.f17225a;
            if (c.this.k != null && i2 < c.this.k.size()) {
                ((com.opos.cmn.func.dl.base.e.c) c.this.k.get(i2)).f17326d += aVar.f17227c;
                com.opos.cmn.func.dl.base.e.b bVar = c.this.f17269f;
                bVar.f17322f.a(bVar.f17321e);
            }
            long a2 = c.this.f17273j.a(c.this.f17265a.k, c.this.f17265a.l, c.this.q, c.this.f17265a.s.get(), c.this.f17270g.c(), c.this.f17270g.d(), c.this.f17270g.e());
            if (a2 > 0) {
                c.this.f17266b.a(a2);
            }
        }
    }

    public c(DownloadRequest downloadRequest, com.opos.cmn.func.dl.base.f.a aVar) {
        this.f17271h = aVar;
        com.opos.cmn.func.dl.base.d dVar = aVar.f17335c;
        this.f17270g = dVar;
        this.f17268e = dVar.f();
        this.f17272i = this.f17270g.g();
        this.f17273j = new com.opos.cmn.func.dl.base.a.b.b();
        this.f17267c = new a();
        this.f17265a = new b(downloadRequest, this.f17270g);
        this.f17266b = new com.opos.cmn.func.dl.base.g.a(this.f17265a, this.f17271h.f17336d);
        this.l = new com.opos.cmn.func.dl.base.a.a(this.f17265a);
    }

    public void a(DlException dlException) {
        this.f17266b.a(dlException);
        d();
    }

    public void d() {
        CountDownLatch countDownLatch = this.m;
        if (countDownLatch != null) {
            countDownLatch.countDown();
            this.m = null;
        }
    }

    private void e() {
        Iterator<com.opos.cmn.func.dl.base.a.a.c> it = this.p.iterator();
        while (it.hasNext()) {
            it.next().f17235a = true;
        }
        this.p.clear();
    }

    private void f() {
        this.f17272i.b().remove(this);
    }

    public final void a() {
        this.f17266b.f();
        d();
        e();
        f();
    }

    public final void a(boolean z) {
        if (this.f17266b.c()) {
            try {
                com.opos.cmn.func.dl.base.a.a aVar = this.l;
                String str = aVar.f17217b.f17255e;
                if (TextUtils.isEmpty(str) || !str.matches("(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]")) {
                    throw new DlException(1007);
                }
                if (!com.opos.cmn.an.h.c.a.d(aVar.f17218c)) {
                    throw new DlException(1003);
                }
                aVar.a(z);
                if (!com.opos.cmn.func.dl.base.h.a.a(aVar.f17218c)) {
                    com.opos.cmn.an.f.a.c(com.opos.cmn.func.dl.base.a.a.f17216a, "has no storage permission");
                }
                if (this.f17266b.d()) {
                    this.f17272i.b().execute(this);
                }
            } catch (DlException e2) {
                a(e2);
            }
        }
    }

    public final void b() {
        this.f17266b.g();
        d();
        e();
        f();
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(c cVar) {
        return cVar.f17265a.f17252b - this.f17265a.f17252b >= 0 ? 1 : -1;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.opos.cmn.an.f.a.b(f17264d, "Download task begin run");
        try {
            try {
                long incrementAndGet = this.o.incrementAndGet();
                this.n.lock();
                this.q = SystemClock.uptimeMillis();
                if (this.f17266b.b() && incrementAndGet == this.o.get()) {
                    this.l.a(false);
                    if (this.f17266b.e()) {
                        a.C0390a a2 = this.l.a();
                        if (this.f17266b.b() && incrementAndGet == this.o.get()) {
                            this.l.a(false);
                            if (a2.f17224f) {
                                this.f17266b.h();
                            } else {
                                if (this.f17269f == null) {
                                    this.f17269f = new com.opos.cmn.func.dl.base.e.b(this.f17265a);
                                }
                                com.opos.cmn.func.dl.base.e.b bVar = this.f17269f;
                                String str = com.opos.cmn.func.dl.base.e.b.f17317a;
                                com.opos.cmn.an.f.a.b(str, "get thread infos!");
                                List<com.opos.cmn.func.dl.base.e.c> a3 = bVar.f17322f.a();
                                bVar.f17321e = a3;
                                if (a3 == null || a3.isEmpty()) {
                                    if (com.opos.cmn.an.d.b.a.a(bVar.f17318b)) {
                                        com.opos.cmn.an.d.b.a.e(bVar.f17318b);
                                    }
                                    if (com.opos.cmn.an.d.b.a.a(bVar.f17319c)) {
                                        com.opos.cmn.an.d.b.a.e(bVar.f17319c);
                                    }
                                    com.opos.cmn.func.dl.base.h.a.a(bVar.f17318b);
                                    com.opos.cmn.func.dl.base.h.a.a(bVar.f17319c);
                                    b bVar2 = bVar.f17320d;
                                    long j2 = bVar2.k;
                                    boolean a4 = com.opos.cmn.func.dl.base.e.b.a(j2, Boolean.valueOf(bVar2.m));
                                    int a5 = com.opos.cmn.func.dl.base.e.b.a(j2, a4);
                                    com.opos.cmn.an.f.a.b(str, "block num=".concat(String.valueOf(a5)));
                                    ArrayList arrayList = new ArrayList(a5);
                                    bVar.f17321e = arrayList;
                                    if (a4) {
                                        long j3 = j2 / a5;
                                        com.opos.cmn.an.f.a.a(str, "average:".concat(String.valueOf(j3)));
                                        int i2 = 0;
                                        while (i2 < a5) {
                                            long j4 = i2 * j3;
                                            com.opos.cmn.func.dl.base.e.c cVar = new com.opos.cmn.func.dl.base.e.c(i2, j4, 0L, i2 == a5 + (-1) ? j2 - j4 : j3);
                                            bVar.f17321e.add(cVar);
                                            com.opos.cmn.an.f.a.b(com.opos.cmn.func.dl.base.e.b.f17317a, "thread info:" + cVar.toString());
                                            i2++;
                                        }
                                    } else {
                                        arrayList.add(new com.opos.cmn.func.dl.base.e.c(0, 0L, 0L, j2));
                                    }
                                }
                                Iterator<com.opos.cmn.func.dl.base.e.c> it = bVar.f17321e.iterator();
                                int i3 = 0;
                                while (it.hasNext()) {
                                    i3 = (int) (it.next().f17326d + i3);
                                }
                                b bVar3 = bVar.f17320d;
                                long j5 = i3;
                                bVar3.l = j5;
                                bVar3.a(j5);
                                this.k = bVar.f17321e;
                                if (this.f17266b.b() && incrementAndGet == this.o.get()) {
                                    this.l.a(false);
                                    for (com.opos.cmn.func.dl.base.e.c cVar2 : this.k) {
                                        long j6 = cVar2.f17326d;
                                        long j7 = cVar2.f17325c;
                                        if (j6 < j7 || j7 == -1) {
                                            com.opos.cmn.func.dl.base.a.a.c cVar3 = new com.opos.cmn.func.dl.base.a.a.c(this.f17268e, this.f17271h.f17337e, this, cVar2);
                                            this.f17272i.c().execute(cVar3);
                                            this.p.add(cVar3);
                                        }
                                    }
                                    if (this.f17266b.a() == 3) {
                                        CountDownLatch countDownLatch = new CountDownLatch(1);
                                        this.m = countDownLatch;
                                        countDownLatch.await();
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (DlException e2) {
                a(e2);
            } catch (Exception e3) {
                a(new DlException(1000, e3));
            }
        } finally {
            this.n.unlock();
        }
    }
}
