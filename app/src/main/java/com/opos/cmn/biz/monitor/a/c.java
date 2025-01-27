package com.opos.cmn.biz.monitor.a;

import android.content.Context;
import com.baidu.mobads.sdk.internal.bj;
import com.opos.cmn.biz.monitor.a.a;
import com.opos.cmn.biz.monitor.b.e;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private static final String f16687a = "c";

    /* renamed from: b */
    private static c f16688b;

    /* renamed from: d */
    private Context f16690d;

    /* renamed from: e */
    private b f16691e;

    /* renamed from: c */
    private LinkedBlockingQueue<d> f16689c = new LinkedBlockingQueue<>();

    /* renamed from: f */
    private Object f16692f = new Object();

    /* renamed from: g */
    private a f16693g = new a(new a.b() { // from class: com.opos.cmn.biz.monitor.a.c.1

        /* renamed from: com.opos.cmn.biz.monitor.a.c$1$1 */
        class RunnableC03761 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ a.InterfaceC0375a f16696a;

            RunnableC03761(a.InterfaceC0375a interfaceC0375a) {
                interfaceC0375a = interfaceC0375a;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.b(interfaceC0375a);
            }
        }

        AnonymousClass1() {
        }

        @Override // com.opos.cmn.biz.monitor.a.a.b
        public void a(a.InterfaceC0375a interfaceC0375a) {
            com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.opos.cmn.biz.monitor.a.c.1.1

                /* renamed from: a */
                final /* synthetic */ a.InterfaceC0375a f16696a;

                RunnableC03761(a.InterfaceC0375a interfaceC0375a2) {
                    interfaceC0375a = interfaceC0375a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    c.this.b(interfaceC0375a);
                }
            });
        }
    }, Integer.MAX_VALUE, BaseConstants.Time.MINUTE);

    /* renamed from: h */
    private a f16694h = new a(new a.b() { // from class: com.opos.cmn.biz.monitor.a.c.2

        /* renamed from: com.opos.cmn.biz.monitor.a.c$2$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ a.InterfaceC0375a f16699a;

            AnonymousClass1(a.InterfaceC0375a interfaceC0375a) {
                interfaceC0375a = interfaceC0375a;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.a(interfaceC0375a);
            }
        }

        AnonymousClass2() {
        }

        @Override // com.opos.cmn.biz.monitor.a.a.b
        public void a(a.InterfaceC0375a interfaceC0375a) {
            com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.opos.cmn.biz.monitor.a.c.2.1

                /* renamed from: a */
                final /* synthetic */ a.InterfaceC0375a f16699a;

                AnonymousClass1(a.InterfaceC0375a interfaceC0375a2) {
                    interfaceC0375a = interfaceC0375a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    c.this.a(interfaceC0375a);
                }
            });
        }
    }, Integer.MAX_VALUE, 0);

    /* renamed from: com.opos.cmn.biz.monitor.a.c$1 */
    class AnonymousClass1 implements a.b {

        /* renamed from: com.opos.cmn.biz.monitor.a.c$1$1 */
        class RunnableC03761 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ a.InterfaceC0375a f16696a;

            RunnableC03761(a.InterfaceC0375a interfaceC0375a2) {
                interfaceC0375a = interfaceC0375a2;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.b(interfaceC0375a);
            }
        }

        AnonymousClass1() {
        }

        @Override // com.opos.cmn.biz.monitor.a.a.b
        public void a(a.InterfaceC0375a interfaceC0375a2) {
            com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.opos.cmn.biz.monitor.a.c.1.1

                /* renamed from: a */
                final /* synthetic */ a.InterfaceC0375a f16696a;

                RunnableC03761(a.InterfaceC0375a interfaceC0375a22) {
                    interfaceC0375a = interfaceC0375a22;
                }

                @Override // java.lang.Runnable
                public void run() {
                    c.this.b(interfaceC0375a);
                }
            });
        }
    }

    /* renamed from: com.opos.cmn.biz.monitor.a.c$2 */
    class AnonymousClass2 implements a.b {

        /* renamed from: com.opos.cmn.biz.monitor.a.c$2$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ a.InterfaceC0375a f16699a;

            AnonymousClass1(a.InterfaceC0375a interfaceC0375a2) {
                interfaceC0375a = interfaceC0375a2;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.a(interfaceC0375a);
            }
        }

        AnonymousClass2() {
        }

        @Override // com.opos.cmn.biz.monitor.a.a.b
        public void a(a.InterfaceC0375a interfaceC0375a2) {
            com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.opos.cmn.biz.monitor.a.c.2.1

                /* renamed from: a */
                final /* synthetic */ a.InterfaceC0375a f16699a;

                AnonymousClass1(a.InterfaceC0375a interfaceC0375a22) {
                    interfaceC0375a = interfaceC0375a22;
                }

                @Override // java.lang.Runnable
                public void run() {
                    c.this.a(interfaceC0375a);
                }
            });
        }
    }

    /* renamed from: com.opos.cmn.biz.monitor.a.c$3 */
    class AnonymousClass3 implements a.InterfaceC0375a {

        /* renamed from: a */
        final /* synthetic */ a.InterfaceC0375a f16701a;

        AnonymousClass3(a.InterfaceC0375a interfaceC0375a) {
            interfaceC0375a = interfaceC0375a;
        }

        @Override // com.opos.cmn.biz.monitor.a.a.InterfaceC0375a
        public void a() {
            a.InterfaceC0375a interfaceC0375a = interfaceC0375a;
            if (interfaceC0375a != null) {
                interfaceC0375a.a();
            }
            if (c.this.f16689c.isEmpty()) {
                return;
            }
            c.this.f16694h.a();
        }

        @Override // com.opos.cmn.biz.monitor.a.a.InterfaceC0375a
        public void b() {
            a.InterfaceC0375a interfaceC0375a = interfaceC0375a;
            if (interfaceC0375a != null) {
                interfaceC0375a.b();
            }
        }
    }

    /* renamed from: com.opos.cmn.biz.monitor.a.c$4 */
    class AnonymousClass4 implements a.InterfaceC0375a {

        /* renamed from: a */
        final /* synthetic */ a.InterfaceC0375a f16703a;

        AnonymousClass4(a.InterfaceC0375a interfaceC0375a) {
            interfaceC0375a = interfaceC0375a;
        }

        @Override // com.opos.cmn.biz.monitor.a.a.InterfaceC0375a
        public void a() {
            c.this.c();
            a.InterfaceC0375a interfaceC0375a = interfaceC0375a;
            if (interfaceC0375a != null) {
                interfaceC0375a.a();
            }
        }

        @Override // com.opos.cmn.biz.monitor.a.a.InterfaceC0375a
        public void b() {
            c.this.c();
            a.InterfaceC0375a interfaceC0375a = interfaceC0375a;
            if (interfaceC0375a != null) {
                interfaceC0375a.b();
            }
        }
    }

    /* renamed from: com.opos.cmn.biz.monitor.a.c$5 */
    class AnonymousClass5 implements e.a {

        /* renamed from: a */
        final /* synthetic */ d f16705a;

        /* renamed from: b */
        final /* synthetic */ AtomicInteger f16706b;

        /* renamed from: c */
        final /* synthetic */ CountDownLatch f16707c;

        AnonymousClass5(d dVar, AtomicInteger atomicInteger, CountDownLatch countDownLatch) {
            dVar = dVar;
            atomicInteger = atomicInteger;
            countDownLatch = countDownLatch;
        }

        @Override // com.opos.cmn.biz.monitor.b.e.a
        public void a() {
            countDownLatch.countDown();
        }

        @Override // com.opos.cmn.biz.monitor.b.e.a
        public void a(byte[] bArr) {
            if (!com.opos.cmn.biz.monitor.e.a(dVar.f16713c) || e.a(bArr)) {
                atomicInteger.incrementAndGet();
                c.this.c(dVar);
            }
            countDownLatch.countDown();
        }
    }

    /* renamed from: com.opos.cmn.biz.monitor.a.c$6 */
    class AnonymousClass6 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ d f16709a;

        AnonymousClass6(d dVar) {
            dVar = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.c(dVar);
        }
    }

    private int a(List<d> list) {
        CountDownLatch countDownLatch = new CountDownLatch(list.size());
        AtomicInteger atomicInteger = new AtomicInteger();
        for (int i2 = 0; i2 < list.size(); i2++) {
            d dVar = list.get(i2);
            new e(this.f16690d, dVar.f16713c, 3, com.opos.cmn.biz.monitor.a.a().b(), new e.a() { // from class: com.opos.cmn.biz.monitor.a.c.5

                /* renamed from: a */
                final /* synthetic */ d f16705a;

                /* renamed from: b */
                final /* synthetic */ AtomicInteger f16706b;

                /* renamed from: c */
                final /* synthetic */ CountDownLatch f16707c;

                AnonymousClass5(d dVar2, AtomicInteger atomicInteger2, CountDownLatch countDownLatch2) {
                    dVar = dVar2;
                    atomicInteger = atomicInteger2;
                    countDownLatch = countDownLatch2;
                }

                @Override // com.opos.cmn.biz.monitor.b.e.a
                public void a() {
                    countDownLatch.countDown();
                }

                @Override // com.opos.cmn.biz.monitor.b.e.a
                public void a(byte[] bArr) {
                    if (!com.opos.cmn.biz.monitor.e.a(dVar.f16713c) || e.a(bArr)) {
                        atomicInteger.incrementAndGet();
                        c.this.c(dVar);
                    }
                    countDownLatch.countDown();
                }
            }).a();
        }
        try {
            if (countDownLatch2.await(60000L, TimeUnit.MILLISECONDS)) {
                return atomicInteger2.get();
            }
            return 0;
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b(f16687a, "send cache request error:" + e2);
            return 0;
        }
    }

    public static c a() {
        c cVar = f16688b;
        if (cVar == null) {
            synchronized (c.class) {
                if (f16688b == null) {
                    f16688b = new c();
                }
                cVar = f16688b;
            }
        }
        return cVar;
    }

    public void a(a.InterfaceC0375a interfaceC0375a) {
        c(new a.InterfaceC0375a() { // from class: com.opos.cmn.biz.monitor.a.c.3

            /* renamed from: a */
            final /* synthetic */ a.InterfaceC0375a f16701a;

            AnonymousClass3(a.InterfaceC0375a interfaceC0375a2) {
                interfaceC0375a = interfaceC0375a2;
            }

            @Override // com.opos.cmn.biz.monitor.a.a.InterfaceC0375a
            public void a() {
                a.InterfaceC0375a interfaceC0375a2 = interfaceC0375a;
                if (interfaceC0375a2 != null) {
                    interfaceC0375a2.a();
                }
                if (c.this.f16689c.isEmpty()) {
                    return;
                }
                c.this.f16694h.a();
            }

            @Override // com.opos.cmn.biz.monitor.a.a.InterfaceC0375a
            public void b() {
                a.InterfaceC0375a interfaceC0375a2 = interfaceC0375a;
                if (interfaceC0375a2 != null) {
                    interfaceC0375a2.b();
                }
            }
        });
    }

    public void b(a.InterfaceC0375a interfaceC0375a) {
        d(new a.InterfaceC0375a() { // from class: com.opos.cmn.biz.monitor.a.c.4

            /* renamed from: a */
            final /* synthetic */ a.InterfaceC0375a f16703a;

            AnonymousClass4(a.InterfaceC0375a interfaceC0375a2) {
                interfaceC0375a = interfaceC0375a2;
            }

            @Override // com.opos.cmn.biz.monitor.a.a.InterfaceC0375a
            public void a() {
                c.this.c();
                a.InterfaceC0375a interfaceC0375a2 = interfaceC0375a;
                if (interfaceC0375a2 != null) {
                    interfaceC0375a2.a();
                }
            }

            @Override // com.opos.cmn.biz.monitor.a.a.InterfaceC0375a
            public void b() {
                c.this.c();
                a.InterfaceC0375a interfaceC0375a2 = interfaceC0375a;
                if (interfaceC0375a2 != null) {
                    interfaceC0375a2.b();
                }
            }
        });
    }

    public void c() {
        int a2;
        try {
            synchronized (this.f16692f) {
                a2 = this.f16691e.a(System.currentTimeMillis() - bj.f5599d);
            }
            com.opos.cmn.an.f.a.b(f16687a, "remove expired data size:" + a2);
        } catch (Exception unused) {
            com.opos.cmn.an.f.a.b(f16687a, "remove expired data fail");
        }
    }

    private void c(a.InterfaceC0375a interfaceC0375a) {
        LinkedList linkedList = new LinkedList();
        while (true) {
            d poll = this.f16689c.poll();
            if (poll == null) {
                break;
            } else {
                linkedList.add(poll);
            }
        }
        if (linkedList.size() > 0) {
            synchronized (this.f16692f) {
                this.f16691e.a(linkedList);
            }
        }
        if (interfaceC0375a != null) {
            interfaceC0375a.a();
        }
    }

    public void c(d dVar) {
        synchronized (this.f16692f) {
            int a2 = this.f16691e.a(dVar);
            com.opos.cmn.an.f.a.b(f16687a, "delete num:" + a2);
        }
    }

    private void d(a.InterfaceC0375a interfaceC0375a) {
        List<d> a2;
        int a3;
        com.opos.cmn.an.f.a.b(f16687a, "pickResendMonitorAndSend");
        do {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = currentTimeMillis - bj.f5599d;
            long j3 = currentTimeMillis - 60000;
            String str = f16687a;
            com.opos.cmn.an.f.a.b(str, "pick monitor from:" + j2 + ",to:" + j3);
            synchronized (this.f16692f) {
                a2 = this.f16691e.a(j2, j3, 5);
            }
            if (a2 == null || a2.size() <= 0) {
                com.opos.cmn.an.f.a.b(str, "cacheList empty");
                a(false);
                if (interfaceC0375a != null) {
                    interfaceC0375a.a();
                    return;
                }
                return;
            }
            a(true);
            com.opos.cmn.an.f.a.b(str, "send cacheNum:" + a2.size());
            a3 = a(a2);
            com.opos.cmn.an.f.a.b(str, "send cache success num:" + a3);
        } while (a3 > 0);
        if (interfaceC0375a != null) {
            interfaceC0375a.b();
        }
    }

    public void a(Context context) {
        this.f16690d = context.getApplicationContext();
        this.f16691e = new b(context);
    }

    public void a(d dVar) {
        this.f16689c.offer(dVar);
        this.f16694h.a();
    }

    public void a(boolean z) {
        com.opos.cmn.an.f.a.b(f16687a, "setCacheEnable value:" + z);
        Context context = this.f16690d;
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ads_monitor_cache", 4).edit().putBoolean("has_monitor_cache", z).commit();
    }

    public void b() {
        this.f16693g.a();
    }

    public void b(d dVar) {
        if (this.f16689c.remove(dVar)) {
            return;
        }
        com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.opos.cmn.biz.monitor.a.c.6

            /* renamed from: a */
            final /* synthetic */ d f16709a;

            AnonymousClass6(d dVar2) {
                dVar = dVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.c(dVar);
            }
        });
    }
}
