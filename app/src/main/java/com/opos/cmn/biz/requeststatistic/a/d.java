package com.opos.cmn.biz.requeststatistic.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.mobads.sdk.internal.bj;
import com.opos.cmn.biz.requeststatistic.a;
import com.opos.cmn.biz.requeststatistic.a.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    public static final String f16787a = "d";

    /* renamed from: g */
    private static d f16788g;

    /* renamed from: b */
    public Context f16789b;

    /* renamed from: c */
    public b f16790c;

    /* renamed from: e */
    public a f16792e;

    /* renamed from: f */
    public a f16793f;

    /* renamed from: h */
    private ReadWriteLock f16794h = new ReentrantReadWriteLock();

    /* renamed from: d */
    public LinkedBlockingQueue<c> f16791d = new LinkedBlockingQueue<>();

    /* renamed from: com.opos.cmn.biz.requeststatistic.a.d$1 */
    public final class AnonymousClass1 implements a.b {
        public AnonymousClass1() {
        }

        @Override // com.opos.cmn.biz.requeststatistic.a.a.b
        public final void a(a.InterfaceC0381a interfaceC0381a) {
            d.a(d.this, interfaceC0381a);
        }
    }

    /* renamed from: com.opos.cmn.biz.requeststatistic.a.d$2 */
    public final class AnonymousClass2 implements a.b {
        public AnonymousClass2() {
        }

        @Override // com.opos.cmn.biz.requeststatistic.a.a.b
        public final void a(a.InterfaceC0381a interfaceC0381a) {
            d.b(d.this, interfaceC0381a);
        }
    }

    /* renamed from: com.opos.cmn.biz.requeststatistic.a.d$3 */
    final class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ a.InterfaceC0381a f16797a;

        AnonymousClass3(a.InterfaceC0381a interfaceC0381a) {
            interfaceC0381a = interfaceC0381a;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.this.f16794h.writeLock().lock();
            try {
                try {
                    LinkedList linkedList = new LinkedList();
                    Object poll = d.this.f16791d.poll();
                    while (true) {
                        c cVar = (c) poll;
                        if (cVar == null) {
                            break;
                        }
                        linkedList.add(cVar);
                        poll = d.this.f16791d.poll();
                    }
                    d.this.f16790c.a(linkedList);
                    com.opos.cmn.an.f.a.b(d.f16787a, "write cache size:" + linkedList.size());
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.b(d.f16787a, "write fail", e2);
                    a.InterfaceC0381a interfaceC0381a = interfaceC0381a;
                    if (interfaceC0381a != null) {
                        interfaceC0381a.b();
                        d.this.f16794h.writeLock().unlock();
                        return;
                    }
                }
                d.this.f16794h.writeLock().unlock();
                a.InterfaceC0381a interfaceC0381a2 = interfaceC0381a;
                if (interfaceC0381a2 != null) {
                    interfaceC0381a2.a();
                }
            } catch (Throwable th) {
                d.this.f16794h.writeLock().unlock();
                throw th;
            }
        }
    }

    /* renamed from: com.opos.cmn.biz.requeststatistic.a.d$4 */
    public final class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ c f16799a;

        public AnonymousClass4(c cVar22) {
            r2 = cVar22;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.this.f16794h.writeLock().lock();
            try {
                try {
                    b bVar = d.this.f16790c;
                    c cVar3 = r2;
                    long j2 = cVar3.f16784a;
                    if (j2 < 0) {
                        com.opos.cmn.an.f.a.c(b.f16783a, "delete data by id had not init");
                        bVar.getWritableDatabase().delete("request_statistic", "data=?", new String[]{cVar3.f16785b});
                    } else {
                        bVar.getWritableDatabase().delete("request_statistic", "id=?", new String[]{String.valueOf(j2)});
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.b(d.f16787a, "delete fail", e2);
                }
            } finally {
                d.this.f16794h.writeLock().unlock();
            }
        }
    }

    /* renamed from: com.opos.cmn.biz.requeststatistic.a.d$5 */
    final class AnonymousClass5 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ a.InterfaceC0381a f16801a;

        /* renamed from: com.opos.cmn.biz.requeststatistic.a.d$5$1 */
        final class AnonymousClass1 implements a.InterfaceC0381a {
            AnonymousClass1() {
            }

            @Override // com.opos.cmn.biz.requeststatistic.a.a.InterfaceC0381a
            public final void a() {
                d.d(d.this);
                a.InterfaceC0381a interfaceC0381a = interfaceC0381a;
                if (interfaceC0381a != null) {
                    interfaceC0381a.a();
                }
            }

            @Override // com.opos.cmn.biz.requeststatistic.a.a.InterfaceC0381a
            public final void b() {
                d.d(d.this);
                a.InterfaceC0381a interfaceC0381a = interfaceC0381a;
                if (interfaceC0381a != null) {
                    interfaceC0381a.b();
                }
            }
        }

        AnonymousClass5(a.InterfaceC0381a interfaceC0381a) {
            interfaceC0381a = interfaceC0381a;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.c(d.this, new a.InterfaceC0381a() { // from class: com.opos.cmn.biz.requeststatistic.a.d.5.1
                AnonymousClass1() {
                }

                @Override // com.opos.cmn.biz.requeststatistic.a.a.InterfaceC0381a
                public final void a() {
                    d.d(d.this);
                    a.InterfaceC0381a interfaceC0381a = interfaceC0381a;
                    if (interfaceC0381a != null) {
                        interfaceC0381a.a();
                    }
                }

                @Override // com.opos.cmn.biz.requeststatistic.a.a.InterfaceC0381a
                public final void b() {
                    d.d(d.this);
                    a.InterfaceC0381a interfaceC0381a = interfaceC0381a;
                    if (interfaceC0381a != null) {
                        interfaceC0381a.b();
                    }
                }
            });
        }
    }

    /* renamed from: com.opos.cmn.biz.requeststatistic.a.d$6 */
    final class AnonymousClass6 implements a.InterfaceC0380a {

        /* renamed from: a */
        final /* synthetic */ List f16804a;

        /* renamed from: b */
        final /* synthetic */ a.InterfaceC0381a f16805b;

        AnonymousClass6(List list, a.InterfaceC0381a interfaceC0381a) {
            r2 = list;
            r3 = interfaceC0381a;
        }

        @Override // com.opos.cmn.biz.requeststatistic.a.InterfaceC0380a
        public final void onFail() {
            com.opos.cmn.an.f.a.b(d.f16787a, "report cache fail");
            a.InterfaceC0381a interfaceC0381a = r3;
            if (interfaceC0381a != null) {
                interfaceC0381a.b();
            }
        }

        @Override // com.opos.cmn.biz.requeststatistic.a.InterfaceC0380a
        public final void onSuccess() {
            a.InterfaceC0381a interfaceC0381a;
            com.opos.cmn.an.f.a.b(d.f16787a, "report cache success");
            if (!d.this.a((List<c>) r2) && (interfaceC0381a = r3) != null) {
                interfaceC0381a.b();
            } else if (d.e(d.this)) {
                d.c(d.this, r3);
            } else {
                r3.a();
            }
        }
    }

    private d() {
    }

    public static d a() {
        d dVar = f16788g;
        if (dVar == null) {
            synchronized (d.class) {
                if (f16788g == null) {
                    f16788g = new d();
                }
                dVar = f16788g;
            }
        }
        return dVar;
    }

    static /* synthetic */ void a(d dVar, a.InterfaceC0381a interfaceC0381a) {
        com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.opos.cmn.biz.requeststatistic.a.d.3

            /* renamed from: a */
            final /* synthetic */ a.InterfaceC0381a f16797a;

            AnonymousClass3(a.InterfaceC0381a interfaceC0381a2) {
                interfaceC0381a = interfaceC0381a2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                d.this.f16794h.writeLock().lock();
                try {
                    try {
                        LinkedList linkedList = new LinkedList();
                        Object poll = d.this.f16791d.poll();
                        while (true) {
                            c cVar = (c) poll;
                            if (cVar == null) {
                                break;
                            }
                            linkedList.add(cVar);
                            poll = d.this.f16791d.poll();
                        }
                        d.this.f16790c.a(linkedList);
                        com.opos.cmn.an.f.a.b(d.f16787a, "write cache size:" + linkedList.size());
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.b(d.f16787a, "write fail", e2);
                        a.InterfaceC0381a interfaceC0381a2 = interfaceC0381a;
                        if (interfaceC0381a2 != null) {
                            interfaceC0381a2.b();
                            d.this.f16794h.writeLock().unlock();
                            return;
                        }
                    }
                    d.this.f16794h.writeLock().unlock();
                    a.InterfaceC0381a interfaceC0381a22 = interfaceC0381a;
                    if (interfaceC0381a22 != null) {
                        interfaceC0381a22.a();
                    }
                } catch (Throwable th) {
                    d.this.f16794h.writeLock().unlock();
                    throw th;
                }
            }
        });
    }

    public boolean a(List<c> list) {
        this.f16794h.writeLock().lock();
        try {
            try {
                b bVar = this.f16790c;
                if (list != null && list.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("(");
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        sb.append("'");
                        sb.append(list.get(i2).f16784a);
                        sb.append("'");
                        if (i2 < list.size() - 1) {
                            sb.append(",");
                        }
                    }
                    sb.append(")");
                    bVar.getWritableDatabase().execSQL("delete\tfrom\trequest_statistic\twhere\tid\tin\t" + sb.toString());
                }
                this.f16794h.writeLock().unlock();
                return true;
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b(f16787a, "delete data", e2);
                this.f16794h.writeLock().unlock();
                return false;
            }
        } catch (Throwable th) {
            this.f16794h.writeLock().unlock();
            throw th;
        }
    }

    static /* synthetic */ void b(d dVar, a.InterfaceC0381a interfaceC0381a) {
        com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.opos.cmn.biz.requeststatistic.a.d.5

            /* renamed from: a */
            final /* synthetic */ a.InterfaceC0381a f16801a;

            /* renamed from: com.opos.cmn.biz.requeststatistic.a.d$5$1 */
            final class AnonymousClass1 implements a.InterfaceC0381a {
                AnonymousClass1() {
                }

                @Override // com.opos.cmn.biz.requeststatistic.a.a.InterfaceC0381a
                public final void a() {
                    d.d(d.this);
                    a.InterfaceC0381a interfaceC0381a = interfaceC0381a;
                    if (interfaceC0381a != null) {
                        interfaceC0381a.a();
                    }
                }

                @Override // com.opos.cmn.biz.requeststatistic.a.a.InterfaceC0381a
                public final void b() {
                    d.d(d.this);
                    a.InterfaceC0381a interfaceC0381a = interfaceC0381a;
                    if (interfaceC0381a != null) {
                        interfaceC0381a.b();
                    }
                }
            }

            AnonymousClass5(a.InterfaceC0381a interfaceC0381a2) {
                interfaceC0381a = interfaceC0381a2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                d.c(d.this, new a.InterfaceC0381a() { // from class: com.opos.cmn.biz.requeststatistic.a.d.5.1
                    AnonymousClass1() {
                    }

                    @Override // com.opos.cmn.biz.requeststatistic.a.a.InterfaceC0381a
                    public final void a() {
                        d.d(d.this);
                        a.InterfaceC0381a interfaceC0381a2 = interfaceC0381a;
                        if (interfaceC0381a2 != null) {
                            interfaceC0381a2.a();
                        }
                    }

                    @Override // com.opos.cmn.biz.requeststatistic.a.a.InterfaceC0381a
                    public final void b() {
                        d.d(d.this);
                        a.InterfaceC0381a interfaceC0381a2 = interfaceC0381a;
                        if (interfaceC0381a2 != null) {
                            interfaceC0381a2.b();
                        }
                    }
                });
            }
        });
    }

    static /* synthetic */ void c(d dVar, a.InterfaceC0381a interfaceC0381a) {
        dVar.f16794h.readLock().lock();
        long currentTimeMillis = System.currentTimeMillis() - bj.f5599d;
        long currentTimeMillis2 = System.currentTimeMillis() - 60000;
        String str = f16787a;
        com.opos.cmn.an.f.a.b(str, "do report cache with start Time:" + currentTimeMillis + ", endTime:" + currentTimeMillis2);
        try {
            try {
                List<c> a2 = dVar.f16790c.a(currentTimeMillis, currentTimeMillis2);
                dVar.f16794h.readLock().unlock();
                com.opos.cmn.an.f.a.b(str, "report cache size:" + a2.size());
                if (a2.size() > 0) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<c> it = a2.iterator();
                    while (it.hasNext()) {
                        try {
                            jSONArray.put(new JSONObject(it.next().f16785b));
                        } catch (JSONException e2) {
                            com.opos.cmn.an.f.a.b(f16787a, "parse data fail", e2);
                        }
                    }
                    if (jSONArray.length() > 0) {
                        com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.opos.cmn.biz.requeststatistic.a.1

                            /* renamed from: a */
                            final /* synthetic */ Context f16772a;

                            /* renamed from: b */
                            final /* synthetic */ String f16773b;

                            /* renamed from: c */
                            final /* synthetic */ InterfaceC0380a f16774c;

                            public AnonymousClass1(Context context, String str2, InterfaceC0380a interfaceC0380a) {
                                r1 = context;
                                r2 = str2;
                                r3 = interfaceC0380a;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                a.a(r1, r2, r3);
                            }
                        });
                        return;
                    }
                    if (!dVar.a(a2)) {
                        if (interfaceC0381a != null) {
                            interfaceC0381a.b();
                            return;
                        }
                        return;
                    } else if (interfaceC0381a == null) {
                        return;
                    }
                } else if (interfaceC0381a == null) {
                    return;
                }
                interfaceC0381a.a();
            } catch (Throwable th) {
                dVar.f16794h.readLock().unlock();
                throw th;
            }
        } catch (Exception e3) {
            com.opos.cmn.an.f.a.b(f16787a, "get cache fail", e3);
            if (interfaceC0381a != null) {
                interfaceC0381a.b();
            }
            dVar.f16794h.readLock().unlock();
        }
    }

    static /* synthetic */ void d(d dVar) {
        dVar.f16794h.writeLock().lock();
        int i2 = 0;
        try {
            try {
                i2 = dVar.f16790c.getWritableDatabase().delete("request_statistic", "createTime<= ?", new String[]{String.valueOf(System.currentTimeMillis() - bj.f5599d)});
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b(f16787a, "delete cache expired fail", e2);
            }
            dVar.f16794h.writeLock().unlock();
            com.opos.cmn.an.f.a.b(f16787a, "delete cache expired size:".concat(String.valueOf(i2)));
        } catch (Throwable th) {
            dVar.f16794h.writeLock().unlock();
            throw th;
        }
    }

    static /* synthetic */ boolean e(d dVar) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) dVar.f16789b.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1;
    }

    public final void b() {
        a aVar = this.f16793f;
        if (aVar != null) {
            aVar.a();
        }
    }
}
