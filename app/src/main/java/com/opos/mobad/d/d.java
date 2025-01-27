package com.opos.mobad.d;

import android.content.Context;
import com.opos.mobad.c.a;
import com.opos.mobad.c.a.a;
import com.opos.mobad.h;
import java.io.Closeable;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSource;

/* loaded from: classes4.dex */
public class d implements com.opos.mobad.c.a, com.opos.mobad.c.a.a {

    /* renamed from: a */
    private static volatile d f20469a;

    /* renamed from: b */
    private Context f20470b;

    /* renamed from: c */
    private c f20471c;

    /* renamed from: com.opos.mobad.d.d$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ a.b f20472a;

        /* renamed from: b */
        final /* synthetic */ Set f20473b;

        /* renamed from: c */
        final /* synthetic */ a.InterfaceC0427a f20474c;

        /* renamed from: d */
        final /* synthetic */ CountDownLatch f20475d;

        /* renamed from: e */
        final /* synthetic */ boolean f20476e;

        /* renamed from: f */
        final /* synthetic */ com.opos.mobad.c.a.b f20477f;

        AnonymousClass1(a.b bVar, Set set, a.InterfaceC0427a interfaceC0427a, CountDownLatch countDownLatch, boolean z, com.opos.mobad.c.a.b bVar2) {
            t = bVar;
            synchronizedSet = set;
            interfaceC0427a = interfaceC0427a;
            countDownLatch = countDownLatch;
            z = z;
            bVar = bVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.b bVar = t;
            if (bVar != null) {
                if (synchronizedSet.contains(bVar.f20031a)) {
                    com.opos.cmn.an.f.a.b("fLoader", "url repeat:" + t.f20031a);
                } else {
                    synchronizedSet.add(t.f20031a);
                    a.InterfaceC0427a interfaceC0427a = interfaceC0427a;
                    if (interfaceC0427a != null) {
                        interfaceC0427a.a(t.f20031a);
                    }
                    c cVar = d.this.f20471c;
                    a.b bVar2 = t;
                    if (cVar.a(bVar2.f20031a, bVar2.f20032b, bVar2.f20033c)) {
                        a.InterfaceC0427a interfaceC0427a2 = interfaceC0427a;
                        if (interfaceC0427a2 != null) {
                            interfaceC0427a2.a(t.f20031a, 1);
                        }
                    } else {
                        d dVar = d.this;
                        a.b bVar3 = t;
                        dVar.a(bVar3.f20031a, bVar3.f20032b, bVar3.f20033c, interfaceC0427a);
                    }
                }
            }
            countDownLatch.countDown();
            if (z) {
                com.opos.cmn.an.f.a.b("fLoader", "wait for complete");
                try {
                    try {
                        countDownLatch.await(5000L, TimeUnit.MILLISECONDS);
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.b("fLoader", "wait time out ", e2);
                    }
                    a.InterfaceC0427a interfaceC0427a3 = interfaceC0427a;
                    if (interfaceC0427a3 != null) {
                        interfaceC0427a3.a();
                    }
                } finally {
                    com.opos.mobad.c.a.b bVar4 = bVar;
                    if (bVar4 != null) {
                        bVar4.b();
                    }
                }
            }
        }
    }

    private d() {
    }

    public static d a() {
        d dVar = f20469a;
        if (dVar == null) {
            synchronized (d.class) {
                dVar = f20469a;
                if (dVar == null) {
                    dVar = new d();
                    f20469a = dVar;
                }
            }
        }
        return dVar;
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b("fLoader", "close", e2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0198  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r18, java.lang.String r19, java.lang.String r20, com.opos.mobad.c.a.a.InterfaceC0427a r21) {
        /*
            Method dump skipped, instructions count: 414
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.d.d.a(java.lang.String, java.lang.String, java.lang.String, com.opos.mobad.c.a.a$a):void");
    }

    private void a(String str, String str2, String str3, BufferedSource bufferedSource, Buffer buffer, a.InterfaceC0427a interfaceC0427a) {
        int i2;
        int a2 = buffer == null ? this.f20471c.a(str, bufferedSource, str2, str3) : this.f20471c.a(str, bufferedSource, buffer, str2, str3);
        if (a2 == 0) {
            if (interfaceC0427a == null) {
                return;
            } else {
                i2 = 0;
            }
        } else if (a2 == 1) {
            if (interfaceC0427a == null) {
                return;
            } else {
                i2 = 2;
            }
        } else if (interfaceC0427a == null) {
            return;
        } else {
            i2 = 3;
        }
        interfaceC0427a.a(str, i2);
    }

    private <T extends a.b> void b(List<T> list, a.InterfaceC0427a interfaceC0427a, com.opos.mobad.c.a.b bVar) {
        CountDownLatch countDownLatch = new CountDownLatch(list.size());
        Set synchronizedSet = Collections.synchronizedSet(new HashSet());
        if (bVar == null || h.a(bVar, 6, 70)) {
            int i2 = 0;
            while (i2 < list.size()) {
                com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.d.d.1

                    /* renamed from: a */
                    final /* synthetic */ a.b f20472a;

                    /* renamed from: b */
                    final /* synthetic */ Set f20473b;

                    /* renamed from: c */
                    final /* synthetic */ a.InterfaceC0427a f20474c;

                    /* renamed from: d */
                    final /* synthetic */ CountDownLatch f20475d;

                    /* renamed from: e */
                    final /* synthetic */ boolean f20476e;

                    /* renamed from: f */
                    final /* synthetic */ com.opos.mobad.c.a.b f20477f;

                    AnonymousClass1(a.b bVar2, Set synchronizedSet2, a.InterfaceC0427a interfaceC0427a2, CountDownLatch countDownLatch2, boolean z, com.opos.mobad.c.a.b bVar3) {
                        t = bVar2;
                        synchronizedSet = synchronizedSet2;
                        interfaceC0427a = interfaceC0427a2;
                        countDownLatch = countDownLatch2;
                        z = z;
                        bVar = bVar3;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        a.b bVar2 = t;
                        if (bVar2 != null) {
                            if (synchronizedSet.contains(bVar2.f20031a)) {
                                com.opos.cmn.an.f.a.b("fLoader", "url repeat:" + t.f20031a);
                            } else {
                                synchronizedSet.add(t.f20031a);
                                a.InterfaceC0427a interfaceC0427a2 = interfaceC0427a;
                                if (interfaceC0427a2 != null) {
                                    interfaceC0427a2.a(t.f20031a);
                                }
                                c cVar = d.this.f20471c;
                                a.b bVar22 = t;
                                if (cVar.a(bVar22.f20031a, bVar22.f20032b, bVar22.f20033c)) {
                                    a.InterfaceC0427a interfaceC0427a22 = interfaceC0427a;
                                    if (interfaceC0427a22 != null) {
                                        interfaceC0427a22.a(t.f20031a, 1);
                                    }
                                } else {
                                    d dVar = d.this;
                                    a.b bVar3 = t;
                                    dVar.a(bVar3.f20031a, bVar3.f20032b, bVar3.f20033c, interfaceC0427a);
                                }
                            }
                        }
                        countDownLatch.countDown();
                        if (z) {
                            com.opos.cmn.an.f.a.b("fLoader", "wait for complete");
                            try {
                                try {
                                    countDownLatch.await(5000L, TimeUnit.MILLISECONDS);
                                } catch (Exception e2) {
                                    com.opos.cmn.an.f.a.b("fLoader", "wait time out ", e2);
                                }
                                a.InterfaceC0427a interfaceC0427a3 = interfaceC0427a;
                                if (interfaceC0427a3 != null) {
                                    interfaceC0427a3.a();
                                }
                            } finally {
                                com.opos.mobad.c.a.b bVar4 = bVar;
                                if (bVar4 != null) {
                                    bVar4.b();
                                }
                            }
                        }
                    }
                });
                i2++;
            }
            return;
        }
        bVar3.b();
        if (interfaceC0427a2 != null) {
            interfaceC0427a2.a();
        }
    }

    public void a(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f20470b = applicationContext;
        this.f20471c = new c(applicationContext);
    }

    @Override // com.opos.mobad.c.a
    public void a(String str, String str2, int i2, int i3, a.InterfaceC0426a interfaceC0426a) {
        if (this.f20470b != null) {
            this.f20471c.a(str, str2, i2, i3, interfaceC0426a);
        } else if (interfaceC0426a != null) {
            interfaceC0426a.a(2, null);
        }
    }

    public <T extends a.b> void a(List<T> list, a.InterfaceC0427a interfaceC0427a) {
        a(list, interfaceC0427a, null);
    }

    public <T extends a.b> void a(List<T> list, a.InterfaceC0427a interfaceC0427a, com.opos.mobad.c.a.b bVar) {
        if (this.f20470b != null && list != null && list.size() > 0) {
            b(list, interfaceC0427a, bVar);
        } else if (interfaceC0427a != null) {
            interfaceC0427a.a();
        }
    }
}
