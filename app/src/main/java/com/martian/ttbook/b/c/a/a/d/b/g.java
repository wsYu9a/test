package com.martian.ttbook.b.c.a.a.d.b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.mobads.sdk.internal.am;
import com.martian.rpauth.MartianRPUserManager;
import com.martian.ttbook.b.c.a.a.c.f;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.e.a;
import com.martian.ttbook.b.c.a.a.e.c;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpStatus;

/* loaded from: classes4.dex */
public final class g {

    /* renamed from: a */
    static Map<Integer, com.martian.ttbook.b.c.a.a.d.b.b> f15721a = new ConcurrentHashMap();

    /* renamed from: b */
    static com.martian.ttbook.b.c.a.a.d.b.h f15722b = com.martian.ttbook.b.c.a.a.d.b.h.f15760a;

    /* renamed from: c */
    private boolean f15723c = false;

    class a implements c.InterfaceC0361c {

        /* renamed from: a */
        final /* synthetic */ Handler.Callback f15724a;

        /* renamed from: b */
        final /* synthetic */ com.martian.ttbook.b.c.a.a.d.b.h f15725b;

        /* renamed from: com.martian.ttbook.b.c.a.a.d.b.g$a$a */
        class RunnableC0357a implements Runnable {
            RunnableC0357a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Message obtain = Message.obtain();
                obtain.what = 0;
                obtain.obj = Boolean.TRUE;
                a.this.f15724a.handleMessage(obtain);
            }
        }

        a(g gVar, Handler.Callback callback, com.martian.ttbook.b.c.a.a.d.b.h hVar) {
            this.f15724a = callback;
            this.f15725b = hVar;
        }

        @Override // com.martian.ttbook.b.c.a.a.e.c.InterfaceC0361c
        public void a(int i2, byte[] bArr, com.martian.ttbook.b.c.a.a.d.b.i iVar) {
            Log.e("xxx", "exit ");
            if (iVar != null || bArr == null) {
                return;
            }
            try {
                com.martian.ttbook.b.c.a.a.e.e eVar = new com.martian.ttbook.b.c.a.a.e.e(com.martian.ttbook.b.c.a.a.b.s(new String(bArr, "UTF-8")));
                if (eVar.f(j.f15758a, false)) {
                    com.martian.ttbook.b.c.a.a.d.b.j.r = Boolean.TRUE;
                    com.martian.ttbook.b.c.a.a.b.q();
                } else {
                    com.martian.ttbook.b.c.a.a.d.b.j.r = Boolean.FALSE;
                }
                String str = null;
                eVar.d(j.f15759b, null);
                if (this.f15724a != null) {
                    com.martian.ttbook.b.c.a.a.e.j.c(new RunnableC0357a());
                }
                com.martian.ttbook.b.c.a.a.e.f.c().k("debugLog", com.martian.ttbook.b.c.a.a.d.b.j.r.booleanValue());
                com.martian.ttbook.b.c.a.a.d.b.h hVar = this.f15725b;
                if (hVar != null) {
                    str = hVar.c();
                }
                Log.e("xxx", "init set oaid " + str);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ com.martian.ttbook.b.c.a.a.d.b.d f15727a;

        b(g gVar, com.martian.ttbook.b.c.a.a.d.b.d dVar) {
            this.f15727a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.martian.ttbook.b.c.a.a.d.b.i iVar = new com.martian.ttbook.b.c.a.a.d.b.i(3000106, "广告无填充");
            com.martian.ttbook.b.c.a.a.c.e eVar = this.f15727a.f15673g;
            if (eVar != null) {
                eVar.a(iVar);
            }
        }
    }

    class c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ com.martian.ttbook.b.c.a.a.d.b.d f15728a;

        c(g gVar, com.martian.ttbook.b.c.a.a.d.b.d dVar) {
            this.f15728a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.martian.ttbook.b.c.a.a.d.b.i iVar = new com.martian.ttbook.b.c.a.a.d.b.i(3000107, "广告无填充");
            com.martian.ttbook.b.c.a.a.c.e eVar = this.f15728a.f15673g;
            if (eVar != null) {
                eVar.a(iVar);
            }
        }
    }

    class d implements i {

        /* renamed from: a */
        final /* synthetic */ com.martian.ttbook.b.c.a.a.d.b.d f15729a;

        class a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ com.martian.ttbook.b.c.a.a.d.b.i f15730a;

            /* renamed from: b */
            final /* synthetic */ com.martian.ttbook.b.c.a.a.d.b.e f15731b;

            a(com.martian.ttbook.b.c.a.a.d.b.i iVar, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
                this.f15730a = iVar;
                this.f15731b = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f15729a.e(this.f15730a, this.f15731b);
            }
        }

        class b implements Runnable {

            /* renamed from: a */
            final /* synthetic */ com.martian.ttbook.b.c.a.a.d.b.e f15733a;

            b(com.martian.ttbook.b.c.a.a.d.b.e eVar) {
                this.f15733a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f15729a.e(new com.martian.ttbook.b.c.a.a.d.b.i(3000102, "广告无填充"), this.f15733a);
            }
        }

        class c implements Runnable {

            /* renamed from: a */
            final /* synthetic */ com.martian.ttbook.b.c.a.a.d.b.e f15735a;

            c(com.martian.ttbook.b.c.a.a.d.b.e eVar) {
                this.f15735a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f15729a.e(new com.martian.ttbook.b.c.a.a.d.b.i(3000101, "广告无填充"), this.f15735a);
            }
        }

        /* renamed from: com.martian.ttbook.b.c.a.a.d.b.g$d$d */
        class RunnableC0358d implements Runnable {

            /* renamed from: a */
            final /* synthetic */ com.martian.ttbook.b.c.a.a.d.b.e f15737a;

            RunnableC0358d(com.martian.ttbook.b.c.a.a.d.b.e eVar) {
                this.f15737a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f15729a.e(new com.martian.ttbook.b.c.a.a.d.b.i(3000104, "广告无填充"), this.f15737a);
            }
        }

        class e implements Runnable {

            /* renamed from: a */
            final /* synthetic */ com.martian.ttbook.b.c.a.a.d.b.e f15739a;

            e(com.martian.ttbook.b.c.a.a.d.b.e eVar) {
                this.f15739a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f15729a.e(new com.martian.ttbook.b.c.a.a.d.b.i(3000103, "广告无填充"), this.f15739a);
            }
        }

        class f implements Runnable {

            /* renamed from: a */
            final /* synthetic */ com.martian.ttbook.b.c.a.a.d.b.e f15741a;

            f(com.martian.ttbook.b.c.a.a.d.b.e eVar) {
                this.f15741a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f15729a.e(new com.martian.ttbook.b.c.a.a.d.b.i(3000105, "广告无填充"), this.f15741a);
            }
        }

        d(g gVar, com.martian.ttbook.b.c.a.a.d.b.d dVar) {
            this.f15729a = dVar;
        }

        @Override // com.martian.ttbook.b.c.a.a.d.b.g.i
        public void a(com.martian.ttbook.b.c.a.a.d.b.e eVar, byte[] bArr, com.martian.ttbook.b.c.a.a.d.b.i iVar) {
            if (iVar != null) {
                com.martian.ttbook.b.c.a.a.e.j.c(new a(iVar, eVar));
                return;
            }
            int c2 = eVar.f15702d.c(e.c.k, 0);
            if (c2 > 0 && c2 <= this.f15729a.x.i()) {
                com.martian.ttbook.b.c.a.a.e.j.c(new b(eVar));
                return;
            }
            int c3 = eVar.f15702d.c(e.c.f15720j, 0);
            if (c3 > 0 && c3 <= this.f15729a.w.i()) {
                com.martian.ttbook.b.c.a.a.e.j.c(new c(eVar));
                return;
            }
            int c4 = eVar.f15702d.c(e.c.f15719i, 0);
            if (c4 > 0 && c4 <= this.f15729a.z.i()) {
                com.martian.ttbook.b.c.a.a.e.j.c(new RunnableC0358d(eVar));
                return;
            }
            int c5 = eVar.f15702d.c(e.c.f15718h, 0);
            if (c5 > 0 && c5 <= this.f15729a.y.i()) {
                com.martian.ttbook.b.c.a.a.e.j.c(new e(eVar));
                return;
            }
            int c6 = eVar.f15702d.c(e.c.t, 0);
            String format = String.format("RLC_%s", this.f15729a.f15675i);
            if (c6 > 0 && c6 * 1000 >= System.currentTimeMillis() - com.martian.ttbook.b.c.a.a.e.f.c().b(format, 0L)) {
                com.martian.ttbook.b.c.a.a.e.j.c(new f(eVar));
                return;
            }
            this.f15729a.d(eVar);
            com.martian.ttbook.b.c.a.a.e.f.c().i(format, System.currentTimeMillis());
            g.e(this.f15729a, eVar);
        }
    }

    static class e implements Runnable {

        /* renamed from: a */
        final /* synthetic */ com.martian.ttbook.b.c.a.a.d.b.d f15743a;

        /* renamed from: b */
        final /* synthetic */ int f15744b;

        /* renamed from: c */
        final /* synthetic */ com.martian.ttbook.b.c.a.a.d.b.e f15745c;

        e(com.martian.ttbook.b.c.a.a.d.b.d dVar, int i2, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
            this.f15743a = dVar;
            this.f15744b = i2;
            this.f15745c = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f15743a.e(new com.martian.ttbook.b.c.a.a.d.b.i(-10000, "不支持的广告源. adSource=" + this.f15744b), this.f15745c);
        }
    }

    static class f implements Runnable {

        /* renamed from: a */
        final /* synthetic */ com.martian.ttbook.b.c.a.a.d.b.b f15746a;

        /* renamed from: b */
        final /* synthetic */ com.martian.ttbook.b.c.a.a.d.b.d f15747b;

        /* renamed from: c */
        final /* synthetic */ com.martian.ttbook.b.c.a.a.d.b.e f15748c;

        f(com.martian.ttbook.b.c.a.a.d.b.b bVar, com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
            this.f15746a = bVar;
            this.f15747b = dVar;
            this.f15748c = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f15746a.a(this.f15747b, this.f15748c).z();
            } catch (Exception e2) {
                com.martian.ttbook.b.c.a.a.e.d.a(e2.getMessage());
            } catch (OutOfMemoryError e3) {
                e3.printStackTrace();
                com.martian.ttbook.b.c.a.a.e.d.g("AdSdkThread", "oom err");
                this.f15747b.e(new com.martian.ttbook.b.c.a.a.d.b.i(10006, "内存空间不足，广告请求失败！"), this.f15748c);
            }
        }
    }

    /* renamed from: com.martian.ttbook.b.c.a.a.d.b.g$g */
    class C0359g implements c.InterfaceC0361c {

        /* renamed from: a */
        final /* synthetic */ i f15749a;

        /* renamed from: b */
        final /* synthetic */ com.martian.ttbook.b.c.a.a.d.b.d f15750b;

        C0359g(g gVar, i iVar, com.martian.ttbook.b.c.a.a.d.b.d dVar) {
            this.f15749a = iVar;
            this.f15750b = dVar;
        }

        @Override // com.martian.ttbook.b.c.a.a.e.c.InterfaceC0361c
        public void a(int i2, byte[] bArr, com.martian.ttbook.b.c.a.a.d.b.i iVar) {
            if (iVar != null) {
                this.f15749a.a(null, bArr, iVar);
                return;
            }
            if (i2 != 200) {
                this.f15749a.a(null, bArr, new com.martian.ttbook.b.c.a.a.d.b.i(10001, "HTTP error，statusCode=" + i2));
                return;
            }
            if (bArr == null) {
                this.f15749a.a(null, bArr, new com.martian.ttbook.b.c.a.a.d.b.i(10000, "HTTP error，response parse error."));
                return;
            }
            try {
                Map<Object, Object> l = com.martian.ttbook.b.c.a.a.b.l(new String(bArr, "UTF-8"));
                if (l == null) {
                    this.f15749a.a(null, bArr, new com.martian.ttbook.b.c.a.a.d.b.i(MartianRPUserManager.f14920g, "HTTP error, response parse error, parse json."));
                    return;
                }
                com.martian.ttbook.b.c.a.a.d.b.e eVar = new com.martian.ttbook.b.c.a.a.d.b.e(this.f15750b, l);
                com.martian.ttbook.b.c.a.a.d.b.i c2 = eVar.c();
                if (c2 != null) {
                    this.f15749a.a(null, bArr, c2);
                } else {
                    this.f15749a.a(eVar, bArr, null);
                }
            } catch (UnsupportedEncodingException unused) {
                this.f15749a.a(null, bArr, new com.martian.ttbook.b.c.a.a.d.b.i(10000, "HTTP error，response parse error, encodeing error."));
            }
        }
    }

    class h implements a.c {

        /* renamed from: a */
        final /* synthetic */ com.martian.ttbook.b.c.a.a.d.b.d f15751a;

        /* renamed from: b */
        final /* synthetic */ i f15752b;

        class a implements i {

            /* renamed from: a */
            final /* synthetic */ com.martian.ttbook.b.c.a.a.e.a f15754a;

            a(h hVar, com.martian.ttbook.b.c.a.a.e.a aVar) {
                this.f15754a = aVar;
            }

            @Override // com.martian.ttbook.b.c.a.a.d.b.g.i
            public void a(com.martian.ttbook.b.c.a.a.d.b.e eVar, byte[] bArr, com.martian.ttbook.b.c.a.a.d.b.i iVar) {
                if (bArr != null) {
                    this.f15754a.f(bArr);
                }
            }
        }

        class b implements i {

            /* renamed from: a */
            final /* synthetic */ com.martian.ttbook.b.c.a.a.e.a f15755a;

            class a implements i {
                a() {
                }

                @Override // com.martian.ttbook.b.c.a.a.d.b.g.i
                public void a(com.martian.ttbook.b.c.a.a.d.b.e eVar, byte[] bArr, com.martian.ttbook.b.c.a.a.d.b.i iVar) {
                    if (bArr != null) {
                        b.this.f15755a.f(bArr);
                    }
                }
            }

            b(com.martian.ttbook.b.c.a.a.e.a aVar) {
                this.f15755a = aVar;
            }

            @Override // com.martian.ttbook.b.c.a.a.d.b.g.i
            public void a(com.martian.ttbook.b.c.a.a.d.b.e eVar, byte[] bArr, com.martian.ttbook.b.c.a.a.d.b.i iVar) {
                h.this.f15752b.a(eVar, bArr, iVar);
                h hVar = h.this;
                g.this.i(hVar.f15751a, new a());
            }
        }

        h(com.martian.ttbook.b.c.a.a.d.b.d dVar, i iVar) {
            this.f15751a = dVar;
            this.f15752b = iVar;
        }

        @Override // com.martian.ttbook.b.c.a.a.e.a.c
        public void a(com.martian.ttbook.b.c.a.a.e.a aVar) {
            Map<Object, Object> l;
            com.martian.ttbook.b.c.a.a.d.b.e eVar;
            g gVar;
            com.martian.ttbook.b.c.a.a.d.b.d dVar;
            i bVar;
            byte[] h2 = aVar != null ? aVar.h() : null;
            if (h2 != null) {
                try {
                    String str = new String(h2, "UTF-8");
                    com.martian.ttbook.b.c.a.a.e.d.g("ADGLOBALTAG", "cached ad data = " + str);
                    l = com.martian.ttbook.b.c.a.a.b.l(str);
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
                if (l != null) {
                    eVar = new com.martian.ttbook.b.c.a.a.d.b.e(this.f15751a, l);
                    if (eVar == null && eVar.c() == null) {
                        this.f15752b.a(eVar, h2, null);
                        long g2 = eVar.f15702d.g(e.c.B) * 1000;
                        long currentTimeMillis = System.currentTimeMillis() - aVar.i();
                        com.martian.ttbook.b.c.a.a.e.d.a("ct " + currentTimeMillis + ", pct " + g2 + ", db " + aVar.i());
                        if (currentTimeMillis < g2) {
                            return;
                        }
                        aVar.f(null);
                        gVar = g.this;
                        dVar = this.f15751a;
                        bVar = new a(this, aVar);
                    } else {
                        gVar = g.this;
                        dVar = this.f15751a;
                        bVar = new b(aVar);
                    }
                    gVar.i(dVar, bVar);
                }
            }
            eVar = null;
            if (eVar == null) {
            }
            gVar = g.this;
            dVar = this.f15751a;
            bVar = new b(aVar);
            gVar.i(dVar, bVar);
        }
    }

    private interface i {
        void a(com.martian.ttbook.b.c.a.a.d.b.e eVar, byte[] bArr, com.martian.ttbook.b.c.a.a.d.b.i iVar);
    }

    public static class j {

        /* renamed from: a */
        public static final Object f15758a = new Object();

        /* renamed from: b */
        public static final Object f15759b = new Object();
    }

    public g(Context context) {
        com.martian.ttbook.b.c.a.a.d.b.j.q = context;
        f15721a.put(100, new com.martian.ttbook.b.c.a.a.d.a.d.x.b());
        f15721a.put(10086, new com.martian.ttbook.b.c.a.a.b.a.d.w.a());
        f15721a.put(105, new com.martian.ttbook.b.c.a.a.b.a.d.z.a());
        f15721a.put(101, new com.martian.ttbook.b.c.a.a.b.a.d.y.b());
        f15721a.put(107, new com.martian.ttbook.b.c.a.a.b.a.d.b0.a());
        f15721a.put(1, new com.martian.ttbook.b.c.a.a.b.a.d.x.b());
        f15721a.put(500, new com.martian.ttbook.b.c.a.a.b.a.d.a0.a());
        f15721a.put(Integer.valueOf(HttpStatus.SC_NOT_IMPLEMENTED), new com.martian.ttbook.b.c.a.a.b.a.d.b.a());
        f15721a.put(Integer.valueOf(HttpStatus.SC_BAD_GATEWAY), new com.martian.ttbook.b.c.a.a.b.a.d.a.a());
        f15721a.put(503, new com.martian.ttbook.b.c.a.a.b.a.d.c.a());
    }

    public static com.martian.ttbook.b.c.a.a.d.b.h b() {
        return f15722b;
    }

    public static void e(com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
        int f2 = eVar.f();
        if (f2 == 0) {
            f2 = 10086;
        }
        com.martian.ttbook.b.c.a.a.d.b.b bVar = f15721a.get(Integer.valueOf(f2));
        if (bVar == null) {
            com.martian.ttbook.b.c.a.a.e.j.c(new e(dVar, f2, eVar));
        } else {
            com.martian.ttbook.b.c.a.a.e.j.c(new f(bVar, dVar, eVar));
        }
    }

    public f.a a(Context context) {
        return new com.martian.ttbook.b.c.a.a.d.b.c(context);
    }

    public Object c(Handler.Callback callback, com.martian.ttbook.b.c.a.a.d.b.h hVar) {
        if (com.martian.ttbook.b.c.a.a.e.i.f(19)) {
            return null;
        }
        if (hVar != null) {
            f15722b = hVar;
        }
        h();
        com.martian.ttbook.b.c.a.a.e.c.d(com.martian.ttbook.b.c.a.a.d.b.j.q);
        com.martian.ttbook.b.c.a.a.e.j.d();
        com.martian.ttbook.b.c.a.a.e.f.c().d("debugFile", null);
        com.martian.ttbook.b.c.a.a.d.b.j.r = Boolean.valueOf(com.martian.ttbook.b.c.a.a.e.f.c().g("debugLog", false));
        com.martian.ttbook.b.c.a.a.e.b.z();
        try {
            String d2 = com.martian.ttbook.b.c.a.a.b.d(com.martian.ttbook.b.c.a.a.e.c.g(null));
            com.martian.ttbook.b.c.a.a.b.h(com.martian.ttbook.b.c.a.a.d.b.j.q, com.martian.ttbook.b.c.a.a.d.b.j.r.booleanValue());
            byte[] bytes = d2.getBytes("UTF-8");
            HashMap hashMap = new HashMap();
            hashMap.put("Content-type", am.f5520d);
            com.martian.ttbook.b.c.a.a.e.c.f(com.martian.ttbook.b.c.a.a.d.b.j.e(), bytes, hashMap, new a(this, callback, hVar));
            this.f15723c = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    public void d(com.martian.ttbook.b.c.a.a.c.f fVar) {
        com.martian.ttbook.b.c.a.a.d.b.d dVar = (com.martian.ttbook.b.c.a.a.d.b.d) fVar;
        dVar.b();
        if (com.martian.ttbook.b.c.a.a.e.i.f(19)) {
            com.martian.ttbook.b.c.a.a.e.j.c(new b(this, dVar));
            return;
        }
        Log.e("ADGLOBALTAG", "init " + this.f15723c);
        if (this.f15723c) {
            f(dVar, new d(this, dVar));
        } else {
            com.martian.ttbook.b.c.a.a.e.j.c(new c(this, dVar));
        }
    }

    public void f(com.martian.ttbook.b.c.a.a.d.b.d dVar, i iVar) {
        com.martian.ttbook.b.c.a.a.e.a b2 = com.martian.ttbook.b.c.a.a.e.a.b("sc_" + dVar.f15675i);
        h hVar = new h(dVar, iVar);
        if (b2 != null) {
            b2.e(hVar);
        } else {
            hVar.a(null);
        }
    }

    public void g(String str) {
        com.martian.ttbook.b.c.a.a.e.d.g("xxx", "set oaid " + str);
        com.martian.ttbook.b.c.a.a.d.b.h hVar = f15722b;
        if (hVar != null) {
            hVar.e(str);
        }
    }

    public void h() {
        com.martian.ttbook.b.c.a.a.b.e();
        com.martian.ttbook.b.c.a.a.d.b.d.o();
        com.martian.ttbook.b.c.a.a.d.b.e.g();
        k.e();
        com.martian.ttbook.b.c.a.a.b.v(new Object[]{j.f15758a, j.f15759b});
        com.martian.ttbook.b.c.a.a.b.u(com.martian.ttbook.b.c.a.a.d.b.j.f15772a);
        com.martian.ttbook.b.c.a.a.b.w(com.martian.ttbook.b.c.a.a.d.b.j.l);
        com.martian.ttbook.b.c.a.a.b.E(com.martian.ttbook.b.c.a.a.d.b.j.f15774c);
        com.martian.ttbook.b.c.a.a.b.F(com.martian.ttbook.b.c.a.a.d.b.j.f15776e);
        com.martian.ttbook.b.c.a.a.d.b.j.g();
        com.martian.ttbook.b.c.a.a.b.G(com.martian.ttbook.b.c.a.a.d.b.j.f15773b);
        com.martian.ttbook.b.c.a.a.b.H(com.martian.ttbook.b.c.a.a.d.b.j.n);
        com.martian.ttbook.b.c.a.a.b.I(com.martian.ttbook.b.c.a.a.d.b.j.f15781j);
        com.martian.ttbook.b.c.a.a.b.J(com.martian.ttbook.b.c.a.a.d.b.j.f15777f);
        com.martian.ttbook.b.c.a.a.b.K(com.martian.ttbook.b.c.a.a.d.b.j.o);
        com.martian.ttbook.b.c.a.a.b.L(com.martian.ttbook.b.c.a.a.d.b.j.f15779h);
        com.martian.ttbook.b.c.a.a.b.y(com.martian.ttbook.b.c.a.a.d.b.j.f15780i);
        com.martian.ttbook.b.c.a.a.b.z(com.martian.ttbook.b.c.a.a.d.b.j.f15778g);
        com.martian.ttbook.b.c.a.a.b.A(com.martian.ttbook.b.c.a.a.d.b.j.m);
        com.martian.ttbook.b.c.a.a.b.B(com.martian.ttbook.b.c.a.a.d.b.j.k);
        com.martian.ttbook.b.c.a.a.b.C(com.martian.ttbook.b.c.a.a.d.b.j.f15775d);
        com.martian.ttbook.b.c.a.a.b.D(com.martian.ttbook.b.c.a.a.d.b.j.p);
    }

    public void i(com.martian.ttbook.b.c.a.a.d.b.d dVar, i iVar) {
        String d2 = com.martian.ttbook.b.c.a.a.b.d(dVar.j());
        com.martian.ttbook.b.c.a.a.e.d.g("ADGLOBALTAG", "params is " + d2);
        HashMap hashMap = new HashMap();
        hashMap.put("Content-type", am.f5520d);
        try {
            com.martian.ttbook.b.c.a.a.e.c.f(com.martian.ttbook.b.c.a.a.d.b.j.a(), d2.getBytes("UTF-8"), hashMap, new C0359g(this, iVar, dVar));
        } catch (UnsupportedEncodingException unused) {
            iVar.a(null, null, new com.martian.ttbook.b.c.a.a.d.b.i(10002, "HTTP error, request error"));
        }
    }
}
